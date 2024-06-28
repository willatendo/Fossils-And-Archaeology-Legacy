package willatendo.fossilslegacy.server.feature.foliageplacer;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class LepidodendronFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<LepidodendronFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> foliagePlacerParts(instance).apply(instance, LepidodendronFoliagePlacer::new));

    public LepidodendronFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return FossilsLegacyFoliagePlacerTypes.LEPIDODENDRON_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader levelSimulatedReader, FoliageSetter foliageSetter, RandomSource randomSource, TreeConfiguration treeConfiguration, int maxHeight, FoliageAttachment foliageAttachment, int foliageHeight, int foliageRadius, int offset) {
        boolean doubleTrunk = foliageAttachment.doubleTrunk();
        BlockPos blockPos = foliageAttachment.pos().above(offset);
        this.placeLeavesRow(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, blockPos, foliageRadius + foliageAttachment.radiusOffset(), -1 - foliageHeight, doubleTrunk);
        this.placeLeavesRow(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, blockPos, foliageRadius - 1, -foliageHeight, doubleTrunk);
        this.placeLeavesRow(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, blockPos, foliageRadius + foliageAttachment.radiusOffset() - 1, 0, doubleTrunk);
        this.placeLeavesRow(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, blockPos, foliageRadius - 1, -2 - foliageHeight, doubleTrunk);
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
