package willatendo.fossilslegacy.server.item;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.command_type.CommandType;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FADataComponents {
    public static final SimpleRegistry<DataComponentType<?>> DATA_COMPONENT_TYPES = SimpleRegistry.create(Registries.DATA_COMPONENT_TYPE, FAUtils.ID);

    public static final SimpleHolder<DataComponentType<Holder<ModelType>>> MODEL_TYPE = DATA_COMPONENT_TYPES.register("model_type", () -> DataComponentType.<Holder<ModelType>>builder().persistent(ModelType.CODEC).networkSynchronized(ModelType.STREAM_CODEC).cacheEncoding().build());
    public static final SimpleHolder<DataComponentType<Holder<CommandType>>> COMMAND_TYPE = DATA_COMPONENT_TYPES.register("command_type", () -> DataComponentType.<Holder<CommandType>>builder().persistent(CommandType.CODEC).networkSynchronized(CommandType.STREAM_CODEC).cacheEncoding().build());
    public static final SimpleHolder<DataComponentType<Holder<FossilVariant>>> FOSSIL_VARIANT = DATA_COMPONENT_TYPES.register("fossil_variant", () -> DataComponentType.<Holder<FossilVariant>>builder().persistent(FossilVariant.CODEC).networkSynchronized(FossilVariant.STREAM_CODEC).cacheEncoding().build());
}
