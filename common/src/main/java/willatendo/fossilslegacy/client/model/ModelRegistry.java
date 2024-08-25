package willatendo.fossilslegacy.client.model;

import com.google.common.collect.Maps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import willatendo.fossilslegacy.client.model.dinosaur.BrachiosaurusModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.LegacyBrachiosaurusModel;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.Map;

public class ModelRegistry {
    private static final Map<ResourceLocation, ModelProvider<? extends Entity>> ENTITY_MODELS = Maps.newHashMap();

    public static <T extends Entity> ModelProvider<T> getModel(ResourceLocation id) {
        return (ModelProvider<T>) ENTITY_MODELS.get(id);
    }

    public static <T extends Entity> void register(ResourceLocation id, ModelProvider<T> modelProvider) {
        ENTITY_MODELS.put(id, modelProvider);
    }

    private static <T extends Entity> void register(String id, ModelProvider<T> modelProvider) {
        ModelRegistry.register(FossilsLegacyUtils.resource(id), modelProvider);
    }

    public static void init() {
        ModelRegistry.register("brachiosaurus", BrachiosaurusModel::new);
        ModelRegistry.register("brachiosaurus_legacy", LegacyBrachiosaurusModel::new);
    }
}
