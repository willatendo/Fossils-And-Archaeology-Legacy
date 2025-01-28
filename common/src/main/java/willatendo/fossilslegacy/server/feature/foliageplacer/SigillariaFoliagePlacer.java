package willatendo.fossilslegacy.server.feature.foliageplacer;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import willatendo.fossilslegacy.server.feature.FAFoliagePlacerTypes;

public class SigillariaFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<SigillariaFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> foliagePlacerParts(instance).apply(instance, SigillariaFoliagePlacer::new));

    public SigillariaFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return FAFoliagePlacerTypes.SIGILLARIA_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader levelSimulatedReader, FoliageSetter foliageSetter, RandomSource randomSource, TreeConfiguration treeConfiguration, int maxHeight, FoliageAttachment foliageAttachment, int foliageHeight, int foliageRadius, int offset) {
        BlockPos blockPos = foliageAttachment.pos().above(offset);
        foliageSetter.set(blockPos, treeConfiguration.trunkProvider.getState(randomSource, blockPos));
        foliageSetter.set(blockPos.above(), treeConfiguration.trunkProvider.getState(randomSource, blockPos.above()));
        foliageSetter.set(blockPos.above(2), treeConfiguration.trunkProvider.getState(randomSource, blockPos.above(2)));
        foliageSetter.set(blockPos.above(3), treeConfiguration.foliageProvider.getState(randomSource, blockPos.above(3)));
        foliageSetter.set(blockPos.above(4), treeConfiguration.foliageProvider.getState(randomSource, blockPos.above(4)));
        foliageSetter.set(blockPos.above(5), treeConfiguration.foliageProvider.getState(randomSource, blockPos.above(5)));
        foliageSetter.set(blockPos.above(6), treeConfiguration.foliageProvider.getState(randomSource, blockPos.above(6)));
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            for (int height = 1; height <= 4; height++) {
                BlockPos columnBlockPos = blockPos.relative(direction).above(height);
                foliageSetter.set(columnBlockPos, treeConfiguration.foliageProvider.getState(randomSource, columnBlockPos));
                if (height > 1 && height < 4) {
                    foliageSetter.set(columnBlockPos.relative(direction.getClockWise()), treeConfiguration.foliageProvider.getState(randomSource, columnBlockPos.relative(direction.getClockWise())));
                }
            }
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
