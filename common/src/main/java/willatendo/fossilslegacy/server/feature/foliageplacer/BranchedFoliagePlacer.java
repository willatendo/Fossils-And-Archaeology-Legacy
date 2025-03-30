package willatendo.fossilslegacy.server.feature.foliageplacer;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import willatendo.fossilslegacy.server.feature.FAFoliagePlacerTypes;

public class BranchedFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<BranchedFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> BranchedFoliagePlacer.foliagePlacerParts(instance).apply(instance, BranchedFoliagePlacer::new));

    public BranchedFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return FAFoliagePlacerTypes.BRANCHED_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader levelSimulatedReader, FoliageSetter foliageSetter, RandomSource randomSource, TreeConfiguration treeConfiguration, int maxHeight, FoliageAttachment foliageAttachment, int foliageHeight, int foliageRadius, int offset) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockPos blockPos = foliageAttachment.pos().relative(direction);
            foliageSetter.set(blockPos, treeConfiguration.trunkProvider.getState(randomSource, blockPos).setValue(RotatedPillarBlock.AXIS, direction.getAxis()));
            foliageSetter.set(blockPos.relative(direction.getClockWise()), treeConfiguration.foliageProvider.getState(randomSource, blockPos.relative(direction.getClockWise())));
            foliageSetter.set(blockPos.relative(direction), treeConfiguration.foliageProvider.getState(randomSource, blockPos.relative(direction, 2)));
            foliageSetter.set(blockPos.relative(direction).above(), treeConfiguration.foliageProvider.getState(randomSource, blockPos.relative(direction, 2).above()));
        }
    }

    @Override
    public int foliageHeight(RandomSource randomSource, int height, TreeConfiguration treeConfiguration) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource randomSource, int localX, int localY, int localZ, int range, boolean large) {
        if (localY == 0) {
            return (localX > 1 || localZ > 1) && localX != 0 && localZ != 0;
        } else {
            return localX == range && localZ == range && range > 0;
        }
    }
}
