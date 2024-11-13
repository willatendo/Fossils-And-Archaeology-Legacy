package willatendo.fossilslegacy.server.structure.processor;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.levelgen.structure.templatesystem.ProcessorRule;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

import java.util.List;

public class HolesProcessor extends StructureProcessor {
    public static final MapCodec<HolesProcessor> CODEC = ProcessorRule.CODEC.listOf().fieldOf("rules").xmap(HolesProcessor::new, holesProcessor -> holesProcessor.rules);
    private final ImmutableList<ProcessorRule> rules;

    public HolesProcessor(List<? extends ProcessorRule> rules) {
        this.rules = ImmutableList.copyOf(rules);
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return FossilsLegacyStructureProcessorType.HOLES_PROCESSOR.get();
    }
}
