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
        BlockState head = cycadConfiguration.head().getState(randomSource, blockPos.above(height - 1));
        BlockState log = cycadConfiguration.log().getState(randomSource, blockPos.above(height - 1));
        if (head.getBlock() instanceof TallPlantBlock tallPlantBlock) {
            BlockState[] blockState = new BlockState[height];
            for (int i = 0; i < height; i++) {
                if (i == height - 1) {
                    blockState[i] = head;
                } else {
                    blockState[i] = log.setValue(tallPlantBlock.sizeProperty(), height - 1);
                }
            }
            return tallPlantBlock.featurePlace(worldGenLevel, blockPos, height, blockState, blockPosIn -> this.validTreePos(worldGenLevel, blockPosIn));
        }
        return false;
    }
}
