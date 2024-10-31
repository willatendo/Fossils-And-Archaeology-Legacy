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

import javax.annotation.Nullable;
import java.util.List;

public class HolesProcessor extends StructureProcessor {
    public static final MapCodec<HolesProcessor> CODEC = ProcessorRule.CODEC.listOf().fieldOf("rules").xmap(HolesProcessor::new, holesProcessor -> holesProcessor.rules);
    private final ImmutableList<ProcessorRule> rules;

    public HolesProcessor(List<? extends ProcessorRule> rules) {
        this.rules = ImmutableList.copyOf(rules);
    }

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader, BlockPos offsetBlockPos, BlockPos blockPos, StructureTemplate.StructureBlockInfo structureBlockInfo, StructureTemplate.StructureBlockInfo relativeStructureBlockInfo, StructurePlaceSettings structurePlaceSettings) {
        RandomSource randomSource = RandomSource.create(Mth.getSeed(relativeStructureBlockInfo.pos()));
        BlockState blockState = levelReader.getBlockState(relativeStructureBlockInfo.pos());
        UnmodifiableIterator<ProcessorRule> processorRules = this.rules.iterator();

        ProcessorRule processorRule;
        do {
            if (!processorRules.hasNext()) {
                return relativeStructureBlockInfo;
            }

            processorRule = processorRules.next();
        } while (!processorRule.test(relativeStructureBlockInfo.state(), blockState, structureBlockInfo.pos(), relativeStructureBlockInfo.pos(), blockPos, randomSource));

        return new StructureTemplate.StructureBlockInfo(relativeStructureBlockInfo.pos(), Blocks.AIR.defaultBlockState(), relativeStructureBlockInfo.nbt());
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return FossilsLegacyStructureProcessorType.HOLES_PROCESSOR.get();
    }
}
