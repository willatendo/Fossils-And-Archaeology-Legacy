package willatendo.fossilslegacy.client.model.json;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
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
    private static final Map<ResourceLocation, Animations> ANIMATIONS = Maps.newHashMap();
    private static final Map<ModelLayerLocation, LayerDefinition> MODELS = Maps.newHashMap();

    public static boolean isJsonModel(ResourceLocation id) {
        return MODELS.keySet().stream().map(ModelLayerLocation::getModel).toList().contains(id);
    }

    public static Optional<Animations> getAnimations(ResourceLocation id) {
        Animations animations = ANIMATIONS.get(id);
        return animations == null ? Optional.empty() : Optional.of(animations);
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
        PartDefinition partDefinition = meshDefinition.getRoot();
        ResourceLocation resourceLocation = this.parse(jsonObject, "model_layer_location");
        ModelLayerLocation modelLayerLocation = new ModelLayerLocation(resourceLocation, "main");

        if (jsonObject.has("animations")) {
            JsonObject animations = GsonHelper.getAsJsonObject(jsonObject, "animations");
            String walk = "walk";
            String swim = "swim";
            Optional<ResourceLocation> walkAnimation = Optional.empty();
            if (animations.has(walk)) {
                walkAnimation = Optional.of(this.parse(animations, walk));
            }
            Optional<ResourceLocation> swimAnimation = Optional.empty();
            if (animations.has(swim)) {
                swimAnimation = Optional.of(this.parse(animations, swim));
            }

            ANIMATIONS.put(resourceLocation, new Animations(walkAnimation, swimAnimation));
        }

        int textureHeight = GsonHelper.getAsInt(jsonObject, "texture_height");
        int textureWidth = GsonHelper.getAsInt(jsonObject, "texture_width");
        JsonArray elements = GsonHelper.getAsJsonArray(jsonObject, "elements");
        for (JsonElement jsonElement : elements.asList()) {
            JsonObject element = jsonElement.getAsJsonObject();
            String id = GsonHelper.getAsString(element, "id");
            int xOffset = GsonHelper.getAsInt(element, "xOffset");
            int yOffset = GsonHelper.getAsInt(element, "yOffset");
            List<Box> boxList = Lists.newArrayList();
            JsonArray boxes = GsonHelper.getAsJsonArray(element, "boxes");
            for (JsonElement boxElement : boxes.asList()) {
                JsonObject box = boxElement.getAsJsonObject();
                float xOrigin = GsonHelper.getAsFloat(box, "xOrigin");
                float yOrigin = GsonHelper.getAsFloat(box, "yOrigin");
                float zOrigin = GsonHelper.getAsFloat(box, "zOrigin");
                float xDimension = GsonHelper.getAsFloat(box, "xDimension");
                float yDimension = GsonHelper.getAsFloat(box, "yDimension");
                float zDimension = GsonHelper.getAsFloat(box, "zDimension");
                boxList.add(new Box(xOrigin, yOrigin, zOrigin, xDimension, yDimension, zDimension));
            }
            JsonObject poses = element.getAsJsonObject("poses");
            float x = GsonHelper.getAsFloat(poses, "x");
            float y = GsonHelper.getAsFloat(poses, "y");
            float z = GsonHelper.getAsFloat(poses, "z");
            boolean hasXRot = poses.has("xRot");
            boolean hasYRot = poses.has("yRot");
            boolean hasZRot = poses.has("zRot");
            boolean hasRot = hasXRot || hasYRot || hasZRot;
            float xRot = 0.0F;
            float yRot = 0.0F;
            float zRot = 0.0F;
            if (hasXRot) {
                xRot = GsonHelper.getAsFloat(poses, "xRot");
            }
            if (hasYRot) {
                yRot = GsonHelper.getAsFloat(poses, "yRot");
            }
            if (hasZRot) {
                zRot = GsonHelper.getAsFloat(poses, "zRot");
            }
            CubeListBuilder cubeListBuilder = CubeListBuilder.create().texOffs(xOffset, yOffset);
            boxList.forEach(box -> cubeListBuilder.addBox(box.xOrigin(), box.yOrigin(), box.zOrigin(), box.xDimension(), box.yDimension(), box.zDimension()));
            partDefinition.addOrReplaceChild(id, cubeListBuilder, hasRot ? PartPose.offsetAndRotation(xRot, yRot, zRot, x, y, z) : PartPose.offset(x, y, z));
        }

        MODELS.put(modelLayerLocation, LayerDefinition.create(meshDefinition, textureWidth, textureHeight));
    }

    private ResourceLocation parse(JsonObject jsonObject, String memberName) {
        return ResourceLocation.parse(GsonHelper.getAsString(jsonObject, memberName));
    }

    private record Box(float xOrigin, float yOrigin, float zOrigin, float xDimension, float yDimension, float zDimension) {
    }

    public record Animations(Optional<ResourceLocation> walkAnimation, Optional<ResourceLocation> swimAnimation) {
    }
}
