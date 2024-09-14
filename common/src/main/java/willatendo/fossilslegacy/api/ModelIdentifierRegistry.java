package willatendo.fossilslegacy.api;

import com.google.common.collect.Maps;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

import java.util.Map;
import java.util.function.Function;

public class ModelIdentifierRegistry {
    private static final Map<ResourceLocation, ModelProvider<? extends Entity>> ENTITY_MODELS = Maps.newHashMap();
    private static final Map<ResourceLocation, ModelLayerLocation> MODEL_LAYERS = Maps.newHashMap();

    public static Map<ResourceLocation, EntityModel<? extends Entity>> registerAllModels(Function<ModelLayerLocation, ModelPart> root) {
        Map<ResourceLocation, EntityModel<? extends Entity>> maps = Maps.newHashMap();
        ENTITY_MODELS.forEach(((resourceLocation, modelProvider) -> {
            EntityModel<? extends Entity> entityModel = modelProvider.create(root.apply(MODEL_LAYERS.get(resourceLocation)));
            maps.put(resourceLocation, entityModel);
        }));
        return maps;
    }

    public static <T extends Entity> ModelProvider<T> getModel(ResourceLocation id) {
        return (ModelProvider<T>) ENTITY_MODELS.get(id);
    }

    public static <T extends Entity> void register(ResourceLocation id, ModelProvider<T> modelProvider, ModelLayerLocation modelLayerLocation) {
        ENTITY_MODELS.put(id, modelProvider);
        MODEL_LAYERS.put(id, modelLayerLocation);
    }

    @FunctionalInterface
    public interface ModelProvider<T extends Entity> {
        EntityModel<T> create(ModelPart root);
    }
}
