package willatendo.fossilslegacy.server.feature.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import willatendo.fossilslegacy.server.block.blocks.TallHorsetailBlock;

public class FASimpleBlockFeature extends Feature<SimpleBlockConfiguration> {
    public FASimpleBlockFeature(Codec<SimpleBlockConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> featurePlaceContext) {
        SimpleBlockConfiguration simpleBlockConfiguration = featurePlaceContext.config();
        WorldGenLevel worldGenLevel = featurePlaceContext.level();
        BlockPos blockPos = featurePlaceContext.origin();
        BlockState blockState = simpleBlockConfiguration.toPlace().getState(featurePlaceContext.random(), blockPos);
        if (blockState.canSurvive(worldGenLevel, blockPos)) {
            if (blockState.getBlock() instanceof TallHorsetailBlock) {
                if (!worldGenLevel.isEmptyBlock(blockPos.above())) {
                    return false;
                }

                TallHorsetailBlock.placeAt(worldGenLevel, blockState, blockPos, 2);
            }
            if (simpleBlockConfiguration.scheduleTick()) {
                worldGenLevel.scheduleTick(blockPos, worldGenLevel.getBlockState(blockPos).getBlock(), 1);
            }

            return true;
        } else {
            return false;
        }
    }
}
