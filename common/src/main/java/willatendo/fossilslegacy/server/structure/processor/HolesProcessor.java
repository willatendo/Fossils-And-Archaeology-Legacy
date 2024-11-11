package willatendo.fossilslegacy.server.structure.processor;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

import java.util.List;

public class HolesProcessor extends StructureProcessor {
    public static final MapCodec<HolesProcessor> CODEC = ProcessorRule.CODEC.listOf().fieldOf("rules").xmap(HolesProcessor::new, holesProcessor -> holesProcessor.rules);
    private final ImmutableList<ProcessorRule> rules;

    public HolesProcessor(List<? extends ProcessorRule> rules) {
        this.rules = ImmutableList.copyOf(rules);
    }

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader, BlockPos offsetBlockPos, BlockPos blockPos, StructureTemplate.StructureBlockInfo structureBlockInfo, StructureTemplate.StructureBlockInfo relativeStructureBlockInfo, StructurePlaceSettings structurePlaceSettings) {
        RandomSource randomsource = RandomSource.create(Mth.getSeed(relativeStructureBlockInfo.pos()));
        BlockState blockstate = levelReader.getBlockState(relativeStructureBlockInfo.pos());
        UnmodifiableIterator<ProcessorRule> iterator = this.rules.iterator();

        ProcessorRule processorRule;
        do {
            if (!iterator.hasNext()) {
                return relativeStructureBlockInfo;
            }

            processorRule = iterator.next();
        } while (!processorRule.test(relativeStructureBlockInfo.state(), blockstate, structureBlockInfo.pos(), relativeStructureBlockInfo.pos(), blockPos, randomsource));

        return new StructureTemplate.StructureBlockInfo(relativeStructureBlockInfo.pos(), Blocks.AIR.defaultBlockState(), processorRule.getOutputTag(randomsource, relativeStructureBlockInfo.nbt()));
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return FossilsLegacyStructureProcessorType.HOLES_PROCESSOR.get();
    }
}
