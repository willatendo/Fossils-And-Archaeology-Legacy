package willatendo.fossilslegacy.client.model.json;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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
        JsonModelElement jsonModelElement = JSON_MODELS.get(id);
        return new JsonModel<>(id, jsonModelElement.colored(), jsonModelElement.overrideReset(), JsonLayerDefinitionResourceManager.INSTANCE.bakeLayer(new ModelLayerLocation(id, "main")));
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

            animationHolder = Optional.of(new AnimationHolder(this.parseAnimation(animationsObject, "walk"), this.parseAnimation(animationsObject, "swim"), this.parseAnimation(animationsObject, "fly"), this.parseAnimation(animationsObject, "float_down"), this.parseAnimation(animationsObject, "head"), this.parseAnimation(animationsObject, "shake"), this.parseAnimation(animationsObject, "sit"), this.parseAnimation(animationsObject, "tail"), this.parseAnimation(animationsObject, "land")));
        }

        int textureHeight = GsonHelper.getAsInt(jsonObject, "texture_height");
        int textureWidth = GsonHelper.getAsInt(jsonObject, "texture_width");
        JsonArray elementsArray = GsonHelper.getAsJsonArray(jsonObject, "elements");
        elementsArray.asList().forEach(jsonElement -> {
            this.loadElement(jsonElement.getAsJsonObject(), root, loadParts);
        });
        boolean colored = false;
        if (jsonObject.has("colored")) {
            colored = GsonHelper.getAsBoolean(jsonObject, "colored");
        }
        boolean overrideReset = false;
        if (jsonObject.has("override_reset")) {
            overrideReset = GsonHelper.getAsBoolean(jsonObject, "override_reset");
        }
        JSON_MODELS.put(resourceLocation, new JsonModelElement(LayerDefinition.create(meshDefinition, textureWidth, textureHeight), animationHolder, loadParts, headPieces, colored, overrideReset));
    }

    private void loadElement(JsonObject elementObject, PartDefinition root, List<String> loadParts) {
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
        loadParts.add(elementId);
        PartDefinition newRoot = root.addOrReplaceChild(elementId, cubeListBuilder, hasRot ? PartPose.offsetAndRotation(x, y, z, xRot, yRot, zRot) : PartPose.offset(x, y, z));

        String varElements = "elements";
        if (elementObject.has(varElements)) {
            JsonArray elementsArray = GsonHelper.getAsJsonArray(elementObject, varElements);
            elementsArray.asList().forEach(elementsArray1 -> {
                this.loadElement(elementsArray1.getAsJsonObject(), newRoot, loadParts);
            });
        }
    }

    private ResourceLocation[] parseAnimation(JsonObject animationsObject, String varIn) {
        List<ResourceLocation> animations = Lists.newArrayList();
        if (animationsObject.has(varIn)) {
            if (GsonHelper.isArrayNode(animationsObject, varIn)) {
                JsonArray animationsArray = GsonHelper.getAsJsonArray(animationsObject, varIn);
                animationsArray.forEach(jsonElement -> animations.add(ResourceLocation.parse(jsonElement.getAsString())));
            } else {
                animations.add(this.parse(animationsObject, varIn));
            }
        }
        return animations.isEmpty() ? new ResourceLocation[]{} : animations.toArray(ResourceLocation[]::new);
    }

    private ResourceLocation parse(JsonObject jsonObject, String memberName) {
        return ResourceLocation.parse(GsonHelper.getAsString(jsonObject, memberName));
    }

    private record JsonModelElement(LayerDefinition layerDefinition, Optional<AnimationHolder> animationHolder, List<String> loadParts, Optional<List<String>> headPieces, boolean colored, boolean overrideReset) {
    }

    private record Box(int xOffset, int yOffset, float xOrigin, float yOrigin, float zOrigin, float xDimension, float yDimension, float zDimension, Optional<Boolean> mirror) {
    }

    public record AnimationHolder(ResourceLocation[] walkAnimation, ResourceLocation[] swimAnimation, ResourceLocation[] flyAnimation, ResourceLocation[] floatAnimation, ResourceLocation[] headAnimation, ResourceLocation[] shakeAnimation, ResourceLocation[] sitAnimation, ResourceLocation[] tailAnimation, ResourceLocation[] landAnimation) {
        public boolean hasWalkAnimations() {
            return this.walkAnimation().length > 0;
        }

        public boolean hasSwimAnimations() {
            return this.swimAnimation().length > 0;
        }

        public boolean hasFlyAnimations() {
            return this.flyAnimation().length > 0;
        }

        public boolean hasFloatAnimations() {
            return this.floatAnimation().length > 0;
        }

        public boolean hasHeadAnimations() {
            return this.headAnimation().length > 0;
        }

        public boolean hasShakeAnimations() {
            return this.shakeAnimation().length > 0;
        }

        public boolean hasSitAnimations() {
            return this.sitAnimation().length > 0;
        }

        public boolean hasTailAnimations() {
            return this.tailAnimation().length > 0;
        }

        public boolean hasLandAnimations() {
            return this.landAnimation().length > 0;
        }
    }
}
