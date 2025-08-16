package willatendo.fossilslegacy.server.feature.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import willatendo.fossilslegacy.server.block.blocks.TallPlantBlock;
import willatendo.fossilslegacy.server.feature.configurations.TallPlantConfiguration;

public class TallPlantFeature extends Feature<TallPlantConfiguration> {
    public TallPlantFeature(Codec<TallPlantConfiguration> codec) {
        super(codec);
    }

    private boolean validTreePos(WorldGenLevel worldGenLevel, BlockPos blockPos) {
        return worldGenLevel.isStateAtPosition(blockPos, blockState -> blockState.isAir() || blockState.is(BlockTags.REPLACEABLE_BY_TREES));
    }

    @Override
    public boolean place(FeaturePlaceContext<TallPlantConfiguration> featurePlaceContext) {
        RandomSource randomSource = featurePlaceContext.random();
        BlockPos blockPos = featurePlaceContext.origin();
        WorldGenLevel worldGenLevel = featurePlaceContext.level();
        TallPlantConfiguration tallPlantConfiguration = featurePlaceContext.config();
        int height = tallPlantConfiguration.height().sample(randomSource);
        BlockState head = tallPlantConfiguration.head().getState(randomSource, blockPos.above(height - 1));
        BlockState log = tallPlantConfiguration.log().getState(randomSource, blockPos.above(height - 1));
        if (head.getBlock() instanceof TallPlantBlock tallPlantBlock) {
            BlockState[] blockState = new BlockState[height];
            for (int i = 0; i < height; i++) {
                if (i == height - 1) {
                    blockState[i] = head;
                } else {
                    blockState[i] = log.setValue(tallPlantBlock.sizeProperty(), tallPlantBlock.sizesPerHeight()[height - 1][i]);
                }
            }
            return tallPlantBlock.featurePlace(worldGenLevel, randomSource, blockPos, height, blockState, blockPosIn -> this.validTreePos(worldGenLevel, blockPosIn));
        }
        return false;
    }
}
