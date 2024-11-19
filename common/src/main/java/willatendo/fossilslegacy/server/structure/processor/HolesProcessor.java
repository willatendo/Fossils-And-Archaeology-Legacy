package willatendo.fossilslegacy.server.structure.processor;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import javax.annotation.Nullable;
import java.util.List;

public class HolesProcessor extends StructureProcessor {
    public static final MapCodec<HolesProcessor> CODEC = ProcessorRule.CODEC.fieldOf("rule").xmap(HolesProcessor::new, holesProcessor -> holesProcessor.processorRule);
    private final ProcessorRule processorRule;

    public HolesProcessor(ProcessorRule processorRule) {
        this.processorRule = processorRule;
    }

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader, BlockPos offsetBlockPos, BlockPos blockPos, StructureTemplate.StructureBlockInfo structureBlockInfo, StructureTemplate.StructureBlockInfo relativeStructureBlockInfo, StructurePlaceSettings structurePlaceSettings) {
        RandomSource randomSource = RandomSource.create(Mth.getSeed(relativeStructureBlockInfo.pos()));
        BlockState blockState = levelReader.getBlockState(relativeStructureBlockInfo.pos());

        if (this.processorRule.test(relativeStructureBlockInfo.state(), blockState, structureBlockInfo.pos(), relativeStructureBlockInfo.pos(), blockPos, randomSource)) {
            return new StructureTemplate.StructureBlockInfo(relativeStructureBlockInfo.pos(), this.processorRule.getOutputState(), this.processorRule.getOutputTag(randomSource, relativeStructureBlockInfo.nbt()));
        }

        return relativeStructureBlockInfo;
    }

    @Override
    public List<StructureTemplate.StructureBlockInfo> finalizeProcessing(ServerLevelAccessor serverLevelAccessor, BlockPos offsetBlockPos, BlockPos blockPos, List<StructureTemplate.StructureBlockInfo> structureBlockInfo, List<StructureTemplate.StructureBlockInfo> processedStructureBlockInfo, StructurePlaceSettings structurePlaceSettings) {
        processedStructureBlockInfo.forEach(structureBlockInfo1 -> FossilsLegacyUtils.LOGGER.info("Hello"));
        List<StructureTemplate.StructureBlockInfo> structureBlockInfos = Lists.newArrayList();
        for (StructureTemplate.StructureBlockInfo processed : processedStructureBlockInfo) {
            if (serverLevelAccessor.getRandom().nextInt(400) == 1) {
                BlockPos blockPosAt = processed.pos();
                serverLevelAccessor.getBlockState(blockPosAt);
                for (int x = -3; x < 3; x++) {
                    for (int y = -3; y < 3; y++) {
                        for (int z = -3; z < 3; z++) {
                            structureBlockInfos.add(new StructureTemplate.StructureBlockInfo(blockPosAt.mutable().move(x, y, z), this.processorRule.getOutputState(), new CompoundTag()));
                        }
                    }
                }
            } else {
                structureBlockInfos.add(processed);
            }
        }
        return structureBlockInfos;
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return FossilsLegacyStructureProcessorType.HOLES_PROCESSOR.get();
    }
}
