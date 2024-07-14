package willatendo.fossilslegacy.server.item;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import willatendo.fossilslegacy.server.utils.DinosaurCommand;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyDataComponents {
    public static final SimpleRegistry<DataComponentType<?>> DATA_COMPONENT_TYPES = SimpleRegistry.create(Registries.DATA_COMPONENT_TYPE, FossilsLegacyUtils.ID);

    public static final SimpleHolder<DataComponentType<DinosaurCommand>> DINOSAUR_COMMAND = DATA_COMPONENT_TYPES.register("dinosaur_command", () -> DataComponentType.<DinosaurCommand>builder().persistent(DinosaurCommand.CODEC).networkSynchronized(DinosaurCommand.STREAM_CODEC).cacheEncoding().build());
}
