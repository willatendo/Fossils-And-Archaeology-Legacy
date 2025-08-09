package willatendo.fossilslegacy.server.feature.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.blocks.JurassicFernBlock;
import willatendo.fossilslegacy.server.tags.FABlockTags;

public class JurassicFernFeature extends Feature<NoneFeatureConfiguration> {
    public JurassicFernFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
        BlockPos blockPos = featurePlaceContext.origin();
        WorldGenLevel worldGenLevel = featurePlaceContext.level();
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

        if (featurePlaceContext.random().nextInt(5) == 1) {
            for (int xRange = 0; xRange < 16; xRange++) {
                for (int zRange = 0; zRange < 16; zRange++) {
                    int x = blockPos.getX() + xRange;
                    int z = blockPos.getZ() + zRange;

                    mutableBlockPos.set(x, worldGenLevel.getHeight(Heightmap.Types.MOTION_BLOCKING, x, z) - 1, z);

                    if (worldGenLevel.getBlockState(mutableBlockPos).is(BlockTags.LEAVES)) {
                        mutableBlockPos.set(x, worldGenLevel.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z), z);
                        BlockState blockState = FABlocks.JURASSIC_FERN.get().defaultBlockState();
                        if (worldGenLevel.getBlockState(mutableBlockPos.below()).is(FABlockTags.JURASSIC_FERN_PLANTABLE_ON) && worldGenLevel.getBlockState(mutableBlockPos.above()).isAir()) {
                            JurassicFernBlock.placeAt(worldGenLevel, blockState, mutableBlockPos, 2);
                        }
                    }
                }
            }

            return true;
        }
        return false;
    }
}
