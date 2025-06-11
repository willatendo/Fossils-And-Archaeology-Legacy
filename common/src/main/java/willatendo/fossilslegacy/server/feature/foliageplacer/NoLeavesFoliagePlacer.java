package willatendo.fossilslegacy.server.feature.foliageplacer;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import willatendo.fossilslegacy.server.feature.FAFoliagePlacerTypes;

public class NoLeavesFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<NoLeavesFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> NoLeavesFoliagePlacer.foliagePlacerParts(instance).apply(instance, NoLeavesFoliagePlacer::new));

    public NoLeavesFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return FAFoliagePlacerTypes.NO_LEAVES_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader levelSimulatedReader, FoliageSetter foliageSetter, RandomSource randomSource, TreeConfiguration treeConfiguration, int maxHeight, FoliageAttachment foliageAttachment, int foliageHeight, int foliageRadius, int offset) {
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
