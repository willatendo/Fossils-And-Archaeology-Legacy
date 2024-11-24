package willatendo.fossilslegacy.server.structure.processor;

import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;
import java.util.Map;

public class HolesProcessor extends StructureProcessor {
    public static final MapCodec<HolesProcessor> CODEC = BlockState.CODEC.fieldOf("hole_fill").xmap(HolesProcessor::new, holesProcessor -> holesProcessor.holeFiller);
    private final BlockState holeFiller;

    public HolesProcessor(BlockState holeFiller) {
        this.holeFiller = holeFiller;
    }

    @Override
    public List<StructureTemplate.StructureBlockInfo> finalizeProcessing(ServerLevelAccessor serverLevelAccessor, BlockPos offsetBlockPos, BlockPos blockPos, List<StructureTemplate.StructureBlockInfo> structureBlockInfo, List<StructureTemplate.StructureBlockInfo> processedStructureBlockInfo, StructurePlaceSettings structurePlaceSettings) {
        Map<BlockPos, StructureTemplate.StructureBlockInfo> structureBlockInfos = Maps.newHashMap();
        for (StructureTemplate.StructureBlockInfo processed : processedStructureBlockInfo) {
            BlockPos blockPosAt = processed.pos();
            if (serverLevelAccessor.getRandom().nextInt(500) == 1) {
                serverLevelAccessor.getBlockState(blockPosAt);
                for (int x = -2; x < 3; x++) {
                    for (int y = -2; y < 3; y++) {
                        for (int z = -2; z < 3; z++) {
                            BlockPos mutableBlockPos = blockPosAt.mutable().move(x, y, z);
                            BlockState blockStateAt = serverLevelAccessor.getBlockState(mutableBlockPos);
                            if (serverLevelAccessor.getBlockState(mutableBlockPos).is(BlockTags.DOORS)) {
                                DoubleBlockHalf doubleBlockHalf = blockStateAt.getValue(DoorBlock.HALF);
                                FossilsLegacyUtils.LOGGER.info("Door {} {} @ {}", blockPosAt, blockStateAt, doubleBlockHalf);
                                switch (doubleBlockHalf) {
                                    case UPPER ->
                                            structureBlockInfos.put(mutableBlockPos.below(), new StructureTemplate.StructureBlockInfo(mutableBlockPos.below(), this.holeFiller, new CompoundTag()));
                                    case LOWER ->
                                            structureBlockInfos.put(mutableBlockPos.above(), new StructureTemplate.StructureBlockInfo(mutableBlockPos.above(), this.holeFiller, new CompoundTag()));
                                }
                            } else {
                                structureBlockInfos.put(mutableBlockPos, new StructureTemplate.StructureBlockInfo(mutableBlockPos, this.holeFiller, new CompoundTag()));
                            }
                        }
                    }
                }
            } else {
                if (!structureBlockInfos.containsKey(blockPosAt)) {
                    structureBlockInfos.put(blockPosAt, processed);
                }
            }
        }
        return structureBlockInfos.values().stream().toList();
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return FossilsLegacyStructureProcessorType.HOLES_PROCESSOR.get();
    }
}
