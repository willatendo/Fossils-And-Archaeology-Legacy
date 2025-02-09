package willatendo.fossilslegacy.server.json_model;

import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class JsonModelTypes {
    public static final SimpleRegistry<JsonModelType<?>> JSON_MODEL_TYPES = SimpleRegistry.create(FARegistries.JSON_MODEL_TYPE, FAUtils.ID);

    public static final SimpleHolder<BuiltInJsonModelType> BUILT_IN = JSON_MODEL_TYPES.register("built_in", BuiltInJsonModelType::new);
}
