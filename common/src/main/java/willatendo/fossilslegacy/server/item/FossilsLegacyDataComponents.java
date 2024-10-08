package willatendo.fossilslegacy.server.item;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import willatendo.fossilslegacy.server.entity.commands.CommandType;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyDataComponents {
    public static final SimpleRegistry<DataComponentType<?>> DATA_COMPONENT_TYPES = SimpleRegistry.create(Registries.DATA_COMPONENT_TYPE, FossilsLegacyUtils.ID);

    public static final SimpleHolder<DataComponentType<Holder<CoatType>>> COAT_TYPE = DATA_COMPONENT_TYPES.register("coat_type", () -> DataComponentType.<Holder<CoatType>>builder().persistent(CoatType.CODEC).networkSynchronized(CoatType.STREAM_CODEC).cacheEncoding().build());
    public static final SimpleHolder<DataComponentType<Holder<CommandType>>> COMMAND_TYPE = DATA_COMPONENT_TYPES.register("command_type", () -> DataComponentType.<Holder<CommandType>>builder().persistent(CommandType.CODEC).networkSynchronized(CommandType.STREAM_CODEC).cacheEncoding().build());
}
