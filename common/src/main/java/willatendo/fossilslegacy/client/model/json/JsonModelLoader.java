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
    private static final Map<ResourceLocation, AnimationHolder> ANIMATIONS = Maps.newHashMap();
    private static final Map<ModelLayerLocation, LayerDefinition> MODELS = Maps.newHashMap();
    private static final Map<ResourceLocation, List<String>> HEADS = Maps.newHashMap();

    public static boolean isJsonModel(ResourceLocation id) {
        return MODELS.keySet().stream().map(ModelLayerLocation::getModel).toList().contains(id);
    }

    public static Optional<AnimationHolder> getAnimations(ResourceLocation id) {
        AnimationHolder animationHolder = ANIMATIONS.get(id);
        return animationHolder == null ? Optional.empty() : Optional.of(animationHolder);
    }

    public static List<ModelPart> getHead(ResourceLocation id, ModelPart root) {
        List<String> headPieces = HEADS.getOrDefault(id, List.of());
        List<ModelPart> modelParts = Lists.newArrayList();
        headPieces.forEach(string -> {
            if (!root.children.containsKey(string)) {
                for (ModelPart part1 : root.children.values()) {
                    if (part1.children.containsKey(string)) {
                        modelParts.add(part1.getChild(string));
                    } else {
                        for (ModelPart part2 : root.children.values()) {
                            if (part2.children.containsKey(string)) {
                                modelParts.add(part2.getChild(string));
                            } else {
                                for (ModelPart part3 : root.children.values()) {
                                    if (part3.children.containsKey(string)) {
                                        modelParts.add(part3.getChild(string));
                                    } else {
                                        for (ModelPart part4 : root.children.values()) {
                                            if (part4.children.containsKey(string)) {
                                                modelParts.add(part4.getChild(string));
                                            } else {
                                                for (ModelPart part5 : root.children.values()) {
                                                    if (part5.children.containsKey(string)) {
                                                        modelParts.add(part5.getChild(string));
                                                    } else {
                                                        for (ModelPart part6 : root.children.values()) {
                                                            if (part6.children.containsKey(string)) {
                                                                modelParts.add(part6.getChild(string));
                                                            } else {
                                                                for (ModelPart part7 : root.children.values()) {
                                                                    if (part7.children.containsKey(string)) {
                                                                        modelParts.add(part7.getChild(string));
                                                                    } else {
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                modelParts.add(root.getChild(string));
            }
        });
        return modelParts;
    }

    public static EntityModel getModel(ResourceLocation id) {
        return new JsonModel(id, JsonLayerDefinitionResourceManager.INSTANCE.bakeLayer(new ModelLayerLocation(id, "main")));
    }

    private JsonModelLoader() {
        super(new Gson(), "fossilslegacy/models");
    }

    public static Map<ModelLayerLocation, LayerDefinition> getModels() {
        return MODELS;
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> jsons, ResourceManager resourceManager, ProfilerFiller profilerFiller) {
        MODELS.clear();
        for (Map.Entry<ResourceLocation, JsonElement> entry : jsons.entrySet()) {
            try {
                this.load(entry.getValue().getAsJsonObject());
            } catch (Exception e) {
                FossilsLegacyUtils.LOGGER.error("Failed to load json models! {}", e);
            }
        }

        FossilsLegacyUtils.LOGGER.info("Registered {} json models!", MODELS.size());
    }

    private void load(JsonObject jsonObject) {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition root = meshDefinition.getRoot();
        ResourceLocation resourceLocation = this.parse(jsonObject, "model_layer_location");
        ModelLayerLocation modelLayerLocation = new ModelLayerLocation(resourceLocation, "main");
        String headPiecesName = "head_pieces";
        Optional<List<String>> savedHeadPieces = Optional.empty();
        if (jsonObject.has(headPiecesName)) {
            JsonArray headPieces = jsonObject.getAsJsonArray(headPiecesName);
            List<String> pieces = Lists.newArrayList();
            headPieces.asList().forEach(jsonElement -> {
                pieces.add(jsonElement.getAsString());
            });
            savedHeadPieces = Optional.of(pieces);
        }

        savedHeadPieces.ifPresent(strings -> HEADS.put(resourceLocation, strings));

        if (jsonObject.has("animations")) {
            JsonObject animations = GsonHelper.getAsJsonObject(jsonObject, "animations");
            String walk = "walk";
            String swim = "swim";
            String fly = "fly";
            String floatDown = "float_down";
            String head = "head";
            Optional<ResourceLocation> walkAnimation = Optional.empty();
            if (animations.has(walk)) {
                walkAnimation = Optional.of(this.parse(animations, walk));
            }
            Optional<ResourceLocation> swimAnimation = Optional.empty();
            if (animations.has(swim)) {
                swimAnimation = Optional.of(this.parse(animations, swim));
            }
            Optional<ResourceLocation> flyAnimation = Optional.empty();
            if (animations.has(fly)) {
                flyAnimation = Optional.of(this.parse(animations, fly));
            }
            Optional<ResourceLocation> floatDownAnimation = Optional.empty();
            if (animations.has(floatDown)) {
                floatDownAnimation = Optional.of(this.parse(animations, floatDown));
            }
            Optional<ResourceLocation> headAnimation = Optional.empty();
            if (animations.has(head)) {
                headAnimation = Optional.of(this.parse(animations, head));
            }

            ANIMATIONS.put(resourceLocation, new AnimationHolder(walkAnimation, swimAnimation, flyAnimation, floatDownAnimation, headAnimation));
        }

        int textureHeight = GsonHelper.getAsInt(jsonObject, "texture_height");
        int textureWidth = GsonHelper.getAsInt(jsonObject, "texture_width");
        JsonArray elements = GsonHelper.getAsJsonArray(jsonObject, "elements");
        for (JsonElement jsonElement : elements.asList()) {
            JsonObject element = jsonElement.getAsJsonObject();
            String id = GsonHelper.getAsString(element, "id");
            String parentName = "parent";
            String parent = null;
            if (element.has(parentName)) {
                parent = GsonHelper.getAsString(element, parentName);
            }
            List<Box> boxList = Lists.newArrayList();
            JsonArray boxes = GsonHelper.getAsJsonArray(element, "boxes");
            for (JsonElement boxElement : boxes.asList()) {
                JsonObject box = boxElement.getAsJsonObject();
                int xOffset = GsonHelper.getAsInt(box, "texture_x_offset");
                int yOffset = GsonHelper.getAsInt(box, "texture_y_offset");
                float xOrigin = GsonHelper.getAsFloat(box, "x_origin");
                float yOrigin = GsonHelper.getAsFloat(box, "y_origin");
                float zOrigin = GsonHelper.getAsFloat(box, "z_origin");
                float xDimension = GsonHelper.getAsFloat(box, "x_dimension");
                float yDimension = GsonHelper.getAsFloat(box, "y_dimension");
                float zDimension = GsonHelper.getAsFloat(box, "z_dimension");
                Optional<Boolean> mirror = Optional.empty();
                if (box.has("mirror")) {
                    mirror = Optional.of(GsonHelper.getAsBoolean(box, "mirror"));
                }
                boxList.add(new Box(xOffset, yOffset, xOrigin, yOrigin, zOrigin, xDimension, yDimension, zDimension, mirror));
            }
            JsonObject poses = element.getAsJsonObject("poses");
            float x = GsonHelper.getAsFloat(poses, "x");
            float y = GsonHelper.getAsFloat(poses, "y");
            float z = GsonHelper.getAsFloat(poses, "z");
            boolean hasXRot = poses.has("x_rot");
            boolean hasYRot = poses.has("y_rot");
            boolean hasZRot = poses.has("z_rot");
            boolean hasRot = hasXRot || hasYRot || hasZRot;
            float xRot = 0.0F;
            float yRot = 0.0F;
            float zRot = 0.0F;
            if (hasXRot) {
                xRot = GsonHelper.getAsFloat(poses, "x_rot");
            }
            if (hasYRot) {
                yRot = GsonHelper.getAsFloat(poses, "y_rot");
            }
            if (hasZRot) {
                zRot = GsonHelper.getAsFloat(poses, "z_rot");
            }
            CubeListBuilder cubeListBuilder = CubeListBuilder.create();
            boxList.forEach(box -> {
                cubeListBuilder.texOffs(box.xOffset(), box.yOffset()).addBox(box.xOrigin(), box.yOrigin(), box.zOrigin(), box.xDimension(), box.yDimension(), box.zDimension());
                if (box.mirror().isPresent()) {
                    cubeListBuilder.mirror(box.mirror().get());
                }
            });
            this.getPartToAddTo(root, parent).addOrReplaceChild(id, cubeListBuilder, hasRot ? PartPose.offsetAndRotation(x, y, z, xRot, yRot, zRot) : PartPose.offset(x, y, z));
        }

        MODELS.put(modelLayerLocation, LayerDefinition.create(meshDefinition, textureWidth, textureHeight));
    }

    private PartDefinition getPartToAddTo(PartDefinition root, String parent) {
        return parent != null ? this.getFromParent(root, parent) : root;
    }

    private PartDefinition getFromParent(PartDefinition root, String parent) {
        if (root.children.containsKey(parent)) {
            return root.getChild(parent);
        } else {
            for (PartDefinition child1 : root.children.values()) {
                if (child1.children.containsKey(parent)) {
                    return child1.getChild(parent);
                } else {
                    for (PartDefinition child2 : child1.children.values()) {
                        if (child2.children.containsKey(parent)) {
                            return child2.getChild(parent);
                        } else {
                            for (PartDefinition child3 : child2.children.values()) {
                                if (child3.children.containsKey(parent)) {
                                    return child3.getChild(parent);
                                } else {
                                    for (PartDefinition child4 : child3.children.values()) {
                                        if (child4.children.containsKey(parent)) {
                                            return child4.getChild(parent);
                                        } else {
                                            for (PartDefinition child5 : child4.children.values()) {
                                                if (child5.children.containsKey(parent)) {
                                                    return child5.getChild(parent);
                                                } else {
                                                    for (PartDefinition child6 : child5.children.values()) {
                                                        if (child6.children.containsKey(parent)) {
                                                            return child6.getChild(parent);
                                                        } else {
                                                            for (PartDefinition child7 : child6.children.values()) {
                                                                if (child7.children.containsKey(parent)) {
                                                                    return child7.getChild(parent);
                                                                } else {
                                                                    for (PartDefinition child8 : child7.children.values()) {
                                                                        if (child8.children.containsKey(parent)) {
                                                                            return child8.getChild(parent);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            FossilsLegacyUtils.LOGGER.error("Has a child that is more that 8 children deep!");
            return null;
        }
    }

    private ResourceLocation parse(JsonObject jsonObject, String memberName) {
        return ResourceLocation.parse(GsonHelper.getAsString(jsonObject, memberName));
    }

    private record Box(int xOffset, int yOffset, float xOrigin, float yOrigin, float zOrigin, float xDimension, float yDimension, float zDimension, Optional<Boolean> mirror) {
    }

    private record Element(String parent, CubeListBuilder cubeListBuilder, PartPose partPose) {
    }

    public record AnimationHolder(Optional<ResourceLocation> walkAnimation, Optional<ResourceLocation> swimAnimation, Optional<ResourceLocation> flyAnimation, Optional<ResourceLocation> floatAnimation, Optional<ResourceLocation> headAnimation) {
    }
}
