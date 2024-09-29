package willatendo.fossilslegacy.client.model.json;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.profiling.ProfilerFiller;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JsonModelLoader extends SimpleJsonResourceReloadListener {
    public static final JsonModelLoader INSTANCE = new JsonModelLoader();
    private static final Map<ResourceLocation, JsonModelElement> JSON_MODELS = Maps.newHashMap();

    public static boolean isJsonModel(ResourceLocation id) {
        return JSON_MODELS.containsKey(id);
    }

    protected static Map<ModelLayerLocation, LayerDefinition> getModels() {
        Map<ModelLayerLocation, LayerDefinition> models = Maps.newHashMap();
        JSON_MODELS.forEach((resourceLocation, jsonModelElement) -> models.put(new ModelLayerLocation(resourceLocation, "main"), jsonModelElement.layerDefinition()));
        return models;
    }

    protected static Optional<AnimationHolder> getAnimations(ResourceLocation id) {
        return JSON_MODELS.get(id).animationHolder();
    }

    protected static List<String> getLoadParts(ResourceLocation id) {
        return JSON_MODELS.get(id).loadParts();
    }

    protected static List<ModelPart> getHeadPieces(ResourceLocation id, ModelPart root) {
        Optional<List<String>> optionalHeadPieces = JSON_MODELS.get(id).headPieces();
        if (optionalHeadPieces.isPresent()) {
            List<String> headPieces = optionalHeadPieces.get();
            List<ModelPart> modelParts = Lists.newArrayList();
            for (String headPiece : headPieces) {
                for (ModelPart modelPart : root.getAllParts().toList()) {
                    if (modelPart.hasChild(headPiece)) {
                        modelParts.add(modelPart.getChild(headPiece));
                        break;
                    }
                }
            }
            return modelParts;
        } else {
            return List.of();
        }
    }

    public static EntityModel getModel(ResourceLocation id) {
        return new JsonModel(id, JSON_MODELS.get(id).colored(), JsonLayerDefinitionResourceManager.INSTANCE.bakeLayer(new ModelLayerLocation(id, "main")));
    }

    private JsonModelLoader() {
        super(new Gson(), "fossilslegacy/models");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> jsons, ResourceManager resourceManager, ProfilerFiller profilerFiller) {
        JSON_MODELS.clear();

        for (Map.Entry<ResourceLocation, JsonElement> entry : jsons.entrySet()) {
            try {
                this.load(entry.getValue().getAsJsonObject());
            } catch (Exception e) {
                FossilsLegacyUtils.LOGGER.error("Failed to load json models! {}", entry.getKey(), e);
            }
        }
    }

    private void load(JsonObject jsonObject) {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition root = meshDefinition.getRoot();

        ResourceLocation resourceLocation = this.parse(jsonObject, "model_id");
        List<String> loadParts = Lists.newArrayList();

        String varHeadPieces = "head_pieces";
        Optional<List<String>> headPieces = Optional.empty();
        if (jsonObject.has(varHeadPieces)) {
            JsonArray headPiecesArray = jsonObject.getAsJsonArray(varHeadPieces);
            List<String> pieces = Lists.newArrayList();
            headPiecesArray.asList().forEach(jsonElement -> pieces.add(jsonElement.getAsString()));
            headPieces = Optional.of(pieces);
        }

        String varAnimations = "animations";
        Optional<AnimationHolder> animationHolder = Optional.empty();
        if (jsonObject.has(varAnimations)) {
            JsonObject animationsObject = GsonHelper.getAsJsonObject(jsonObject, varAnimations);

            Pair<Optional<ResourceLocation>, List<String>> walkAnimation = this.parseAnimation(animationsObject, "walk");
            Pair<Optional<ResourceLocation>, List<String>> swimAnimation = this.parseAnimation(animationsObject, "swim");
            Pair<Optional<ResourceLocation>, List<String>> flyAnimation = this.parseAnimation(animationsObject, "fly");
            Pair<Optional<ResourceLocation>, List<String>> floatDownAnimation = this.parseAnimation(animationsObject, "float_down");
            Pair<Optional<ResourceLocation>, List<String>> headAnimation = this.parseAnimation(animationsObject, "head");
            Pair<Optional<ResourceLocation>, List<String>> shakeAnimation = this.parseAnimation(animationsObject, "shake");
            Pair<Optional<ResourceLocation>, List<String>> sitAnimation = this.parseAnimation(animationsObject, "sit");
            Pair<Optional<ResourceLocation>, List<String>> tailAnimation = this.parseAnimation(animationsObject, "tail");

            this.loadPartsFrom(walkAnimation, loadParts);
            this.loadPartsFrom(swimAnimation, loadParts);
            this.loadPartsFrom(flyAnimation, loadParts);
            this.loadPartsFrom(floatDownAnimation, loadParts);
            this.loadPartsFrom(headAnimation, loadParts);
            this.loadPartsFrom(shakeAnimation, loadParts);
            this.loadPartsFrom(sitAnimation, loadParts);
            this.loadPartsFrom(tailAnimation, loadParts);

            animationHolder = Optional.of(new AnimationHolder(walkAnimation.getFirst(), swimAnimation.getFirst(), flyAnimation.getFirst(), floatDownAnimation.getFirst(), headAnimation.getFirst(), shakeAnimation.getFirst(), sitAnimation.getFirst(), tailAnimation.getFirst()));
        }

        int textureHeight = GsonHelper.getAsInt(jsonObject, "texture_height");
        int textureWidth = GsonHelper.getAsInt(jsonObject, "texture_width");
        JsonArray elementsArray = GsonHelper.getAsJsonArray(jsonObject, "elements");
        elementsArray.asList().forEach(jsonElement -> {
            this.loadElement(jsonElement.getAsJsonObject(), root);
        });
        boolean colored = false;
        if (jsonObject.has("colored")) {
            colored = GsonHelper.getAsBoolean(jsonObject, "colored");
        }
        JSON_MODELS.put(resourceLocation, new JsonModelElement(LayerDefinition.create(meshDefinition, textureWidth, textureHeight), animationHolder, loadParts, headPieces, colored));
    }

    private void loadElement(JsonObject elementObject, PartDefinition root) {
        String elementId = GsonHelper.getAsString(elementObject, "id");
        List<Box> boxList = Lists.newArrayList();
        JsonArray boxesArray = GsonHelper.getAsJsonArray(elementObject, "boxes");
        for (JsonElement boxElement : boxesArray.asList()) {
            JsonObject boxObject = boxElement.getAsJsonObject();
            int textureXOffset = GsonHelper.getAsInt(boxObject, "texture_x_offset");
            int textureYOffset = GsonHelper.getAsInt(boxObject, "texture_y_offset");
            float xOrigin = GsonHelper.getAsFloat(boxObject, "x_origin");
            float yOrigin = GsonHelper.getAsFloat(boxObject, "y_origin");
            float zOrigin = GsonHelper.getAsFloat(boxObject, "z_origin");
            float xDimension = GsonHelper.getAsFloat(boxObject, "x_dimension");
            float yDimension = GsonHelper.getAsFloat(boxObject, "y_dimension");
            float zDimension = GsonHelper.getAsFloat(boxObject, "z_dimension");

            String varMirror = "mirror";
            Optional<Boolean> mirror = Optional.empty();
            if (boxObject.has(varMirror)) {
                mirror = Optional.of(GsonHelper.getAsBoolean(boxObject, varMirror));
            }

            boxList.add(new Box(textureXOffset, textureYOffset, xOrigin, yOrigin, zOrigin, xDimension, yDimension, zDimension, mirror));
        }

        JsonObject posesObject = elementObject.getAsJsonObject("poses");
        float x = GsonHelper.getAsFloat(posesObject, "x");
        float y = GsonHelper.getAsFloat(posesObject, "y");
        float z = GsonHelper.getAsFloat(posesObject, "z");

        String varXRot = "x_rot";
        String varYRot = "y_rot";
        String varZRot = "z_rot";
        boolean hasXRot = posesObject.has(varXRot);
        boolean hasYRot = posesObject.has(varYRot);
        boolean hasZRot = posesObject.has(varZRot);
        boolean hasRot = hasXRot || hasYRot || hasZRot;
        float xRot = 0.0F;
        float yRot = 0.0F;
        float zRot = 0.0F;
        if (hasXRot) {
            xRot = GsonHelper.getAsFloat(posesObject, varXRot);
        }
        if (hasYRot) {
            yRot = GsonHelper.getAsFloat(posesObject, varYRot);
        }
        if (hasZRot) {
            zRot = GsonHelper.getAsFloat(posesObject, varZRot);
        }

        CubeListBuilder cubeListBuilder = CubeListBuilder.create();
        boxList.forEach(box -> {
            cubeListBuilder.texOffs(box.xOffset(), box.yOffset()).addBox(box.xOrigin(), box.yOrigin(), box.zOrigin(), box.xDimension(), box.yDimension(), box.zDimension());
            if (box.mirror().isPresent()) {
                cubeListBuilder.mirror(box.mirror().get());
            }
        });
        PartDefinition newRoot = root.addOrReplaceChild(elementId, cubeListBuilder, hasRot ? PartPose.offsetAndRotation(x, y, z, xRot, yRot, zRot) : PartPose.offset(x, y, z));

        String varElements = "elements";
        if (elementObject.has(varElements)) {
            JsonArray elementsArray = GsonHelper.getAsJsonArray(elementObject, varElements);
            elementsArray.asList().forEach(elementsArray1 -> {
                this.loadElement(elementsArray1.getAsJsonObject(), newRoot);
            });
        }
    }

    private Pair<Optional<ResourceLocation>, List<String>> parseAnimation(JsonObject animationsObject, String varIn) {
        Optional<ResourceLocation> id = Optional.empty();
        List<String> loadParts = Lists.newArrayList();
        if (animationsObject.has(varIn)) {
            if (GsonHelper.isObjectNode(animationsObject, varIn)) {
                JsonObject animationObject = GsonHelper.getAsJsonObject(animationsObject, varIn);
                id = Optional.of(this.parse(animationObject, "id"));
                JsonArray loadPartsArray = GsonHelper.getAsJsonArray(animationObject, "load_parts");
                loadPartsArray.forEach(jsonElement -> loadParts.add(jsonElement.getAsString()));
            } else {
                id = Optional.of(this.parse(animationsObject, varIn));
            }
        }
        return Pair.of(id, loadParts);
    }

    private void loadPartsFrom(Pair<Optional<ResourceLocation>, List<String>> animations, List<String> loadParts) {
        animations.getSecond().forEach(loadPart -> {
            if (!loadParts.contains(loadPart)) {
                loadParts.add(loadPart);
            }
        });
    }

    private ResourceLocation parse(JsonObject jsonObject, String memberName) {
        return ResourceLocation.parse(GsonHelper.getAsString(jsonObject, memberName));
    }

    private record JsonModelElement(LayerDefinition layerDefinition, Optional<AnimationHolder> animationHolder, List<String> loadParts, Optional<List<String>> headPieces, boolean colored) {
    }

    private record Box(int xOffset, int yOffset, float xOrigin, float yOrigin, float zOrigin, float xDimension, float yDimension, float zDimension, Optional<Boolean> mirror) {
    }

    public record AnimationHolder(Optional<ResourceLocation> walkAnimation, Optional<ResourceLocation> swimAnimation, Optional<ResourceLocation> flyAnimation, Optional<ResourceLocation> floatAnimation, Optional<ResourceLocation> headAnimation, Optional<ResourceLocation> shakeAnimation, Optional<ResourceLocation> sitAnimation, Optional<ResourceLocation> tailAnimation) {
    }
}
