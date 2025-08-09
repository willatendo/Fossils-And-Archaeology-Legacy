package willatendo.fossilslegacy.server.feature.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import willatendo.fossilslegacy.server.block.blocks.CycadLogBlock;
import willatendo.fossilslegacy.server.feature.configurations.CycadConfiguration;

public class CycadFeature extends Feature<CycadConfiguration> {
    public CycadFeature(Codec<CycadConfiguration> codec) {
        super(codec);
    }

    private boolean validTreePos(WorldGenLevel worldGenLevel, BlockPos blockPos) {
        return worldGenLevel.isStateAtPosition(blockPos, blockState -> blockState.isAir() || blockState.is(BlockTags.REPLACEABLE_BY_TREES));
    }

    @Override
    public boolean place(FeaturePlaceContext<CycadConfiguration> featurePlaceContext) {
        RandomSource randomSource = featurePlaceContext.random();
        BlockPos blockPos = featurePlaceContext.origin();
        WorldGenLevel worldGenLevel = featurePlaceContext.level();
        CycadConfiguration cycadConfiguration = featurePlaceContext.config();
        int height = cycadConfiguration.height().sample(randomSource);
        for (int i = 0; i < height - 1; i++) {
            BlockPos aboveBlockPos = blockPos.above(i);
            BlockState logBlockState = cycadConfiguration.log().getState(randomSource, aboveBlockPos);
            if (height == 2) {
                logBlockState = logBlockState.setValue(CycadLogBlock.SIZE, 2);
            }
            if (height == 3) {
                if (i == 0) {
                    logBlockState = logBlockState.setValue(CycadLogBlock.SIZE, 3);
                } else if (i == 1) {
                    logBlockState = logBlockState.setValue(CycadLogBlock.SIZE, 2);
                }
            }
            if (height == 4) {
                if (i == 0) {
                    logBlockState = logBlockState.setValue(CycadLogBlock.SIZE, 3);
                } else if (i == 1) {
                    logBlockState = logBlockState.setValue(CycadLogBlock.SIZE, 2);
                } else if (i == 2) {
                    logBlockState = logBlockState.setValue(CycadLogBlock.SIZE, 1);
                }
            }
            if (this.validTreePos(worldGenLevel, aboveBlockPos) && logBlockState.canSurvive(worldGenLevel, aboveBlockPos)) {
                worldGenLevel.setBlock(aboveBlockPos, logBlockState, 2);
            }
        }
        BlockPos aboveBlockPos = blockPos.above(height - 1);
        BlockState headBlockState = cycadConfiguration.head().getState(randomSource, aboveBlockPos);
        boolean placed = false;
        if (this.validTreePos(worldGenLevel, aboveBlockPos) && headBlockState.canSurvive(worldGenLevel, aboveBlockPos)) {
            worldGenLevel.setBlock(aboveBlockPos, headBlockState, 2);
            placed = true;
        }
        return placed;
    }
}
