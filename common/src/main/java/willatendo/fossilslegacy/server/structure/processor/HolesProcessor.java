package willatendo.fossilslegacy.server.structure.processor;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
import willatendo.fossilslegacy.server.structure.processor.hole.RelicHoleList;

import java.util.List;

public class HolesProcessor extends StructureProcessor {
    public static final MapCodec<HolesProcessor> CODEC = ProcessorRule.CODEC.listOf().fieldOf("rules").xmap(HolesProcessor::new, holesProcessor -> holesProcessor.rules);
    private final ImmutableList<ProcessorRule> rules;

    public HolesProcessor(List<? extends ProcessorRule> rules) {
        this.rules = ImmutableList.copyOf(rules);
    }

    @Override
    public List<StructureTemplate.StructureBlockInfo> finalizeProcessing(ServerLevelAccessor serverLevelAccessor, BlockPos offsetBlockPos, BlockPos blockPos, List<StructureTemplate.StructureBlockInfo> structureBlockInfos, List<StructureTemplate.StructureBlockInfo> processedStructureBlockInfos, StructurePlaceSettings structurePlaceSettings) {
        if (!structureBlockInfos.isEmpty()) {
            List<BlockPos> blockPoses = structureBlockInfos.stream().map(StructureTemplate.StructureBlockInfo::pos).toList();
            RelicHoleList relicHoleList = new RelicHoleList(serverLevelAccessor.getRandom(), blockPoses, 5, 3);
            for (int i = 0; i < processedStructureBlockInfos.size(); i++) {
                StructureTemplate.StructureBlockInfo structureBlockInfo = processedStructureBlockInfos.get(i);
                if (relicHoleList.isHole(structureBlockInfo.pos())) {
                    processedStructureBlockInfos.set(i, new StructureTemplate.StructureBlockInfo(structureBlockInfo.pos(), Blocks.AIR.defaultBlockState(), structureBlockInfo.nbt()));
                }
            }
        }
        return processedStructureBlockInfos;
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return FossilsLegacyStructureProcessorType.HOLES_PROCESSOR.get();
    }
}
