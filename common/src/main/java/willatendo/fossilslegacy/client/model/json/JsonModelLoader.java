package willatendo.fossilslegacy.client.model.json;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mojang.serialization.JsonOps;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JsonModelLoader extends SimpleJsonResourceReloadListener<JsonModel> {
    public static final JsonModelLoader INSTANCE = new JsonModelLoader();
    private static final FileToIdConverter ASSET_LISTER = FileToIdConverter.json("fossilslegacy/models");
    private static final Map<ResourceLocation, JsonModel> JSON_MODELS = Maps.newHashMap();

    public static boolean isJsonModel(ResourceLocation id) {
        return JSON_MODELS.containsKey(id);
    }

    protected static Map<ModelLayerLocation, LayerDefinition> getModels() {
        Map<ModelLayerLocation, LayerDefinition> models = Maps.newHashMap();
        JSON_MODELS.forEach((resourceLocation, jsonModel) -> models.put(new ModelLayerLocation(resourceLocation, "main"), jsonModel.createModel()));
        return models;
    }

    protected static AnimationHolder getAnimations(ResourceLocation id) {
        Optional<JsonModel.Animations> animations = JSON_MODELS.get(id).animations();
        return animations.map(JsonModel.Animations::toAnimationHolder).orElse(AnimationHolder.EMPTY);
    }

    protected static List<String> getLoadParts(ResourceLocation id) {
        return JSON_MODELS.get(id).getLoadParts();
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

    public static JsonTypeModel getModel(ResourceLocation id) {
        return new JsonTypeModel<>(id, JSON_MODELS.get(id).isOverrideReset(), JsonLayerDefinitionResourceManager.INSTANCE.bakeLayer(new ModelLayerLocation(id, "main")));
    }

    private JsonModelLoader() {
        super(JsonModel.CODEC, ASSET_LISTER);
    }

    @Override
    protected Map<ResourceLocation, JsonModel> prepare(ResourceManager resourceManager, ProfilerFiller profiler) {
        Map<ResourceLocation, JsonModel> map = new HashMap<>();
        scanDirectory(resourceManager, JsonModelLoader.ASSET_LISTER, JsonOps.INSTANCE, JsonModel.CODEC, map);
        return map;
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonModel> jsons, ResourceManager resourceManager, ProfilerFiller profilerFiller) {
        JSON_MODELS.clear();

        JSON_MODELS.putAll(jsons);
    }
}
