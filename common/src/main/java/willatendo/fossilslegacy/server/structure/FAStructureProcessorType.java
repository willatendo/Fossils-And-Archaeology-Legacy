package willatendo.fossilslegacy.server.structure;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import willatendo.fossilslegacy.server.structure.processor.HolesProcessor;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FAStructureProcessorType {
    public static final SimpleRegistry<StructureProcessorType<?>> STRUCTURE_PROCESSOR_TYPES = SimpleRegistry.create(Registries.STRUCTURE_PROCESSOR, FossilsLegacyUtils.ID);

    public static final SimpleHolder<StructureProcessorType<HolesProcessor>> HOLES_PROCESSOR = STRUCTURE_PROCESSOR_TYPES.register("holes_processor", () -> () -> HolesProcessor.CODEC);
}
