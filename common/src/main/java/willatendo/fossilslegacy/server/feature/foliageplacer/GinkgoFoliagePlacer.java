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
import willatendo.fossilslegacy.server.utils.FAUtils;

public class GinkgoFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<GinkgoFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(IntProvider.codec(0, 16).fieldOf("radius").forGetter(ginkgoFoliagePlacer -> ginkgoFoliagePlacer.radius), IntProvider.codec(0, 16).fieldOf("offset").forGetter(ginkgoFoliagePlacer -> ginkgoFoliagePlacer.offset), IntProvider.codec(0, 16).fieldOf("height").forGetter(ginkgoFoliagePlacer -> ginkgoFoliagePlacer.height)).apply(instance, GinkgoFoliagePlacer::new));
    private final IntProvider height;

    public GinkgoFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return FAFoliagePlacerTypes.GINKGO_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader levelSimulatedReader, FoliageSetter foliageSetter, RandomSource randomSource, TreeConfiguration treeConfiguration, int maxHeight, FoliageAttachment foliageAttachment, int foliageHeight, int foliageRadius, int offset) {
        BlockPos blockPos = foliageAttachment.pos();
        foliageSetter.set(blockPos, treeConfiguration.foliageProvider.getState(randomSource, blockPos));
        int leavesHeight = this.height.sample(randomSource);
        int treeHeight = foliageAttachment.radiusOffset();
        for (int i = 0; i < leavesHeight; i++) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                int branchLength = (i == 0 ? 2 : (i == 1 || i == 2) ? 4 : 5);
                boolean crumples = i > 3 && i % 2 == 0;
                boolean thickPart = i > Math.ceil((double) treeHeight / 2);
                if (crumples) {
                    branchLength -= 1;
                }
                for (int x = (thickPart ? 2 : 1); x < branchLength; x++) {
                    blockPos = foliageAttachment.pos().below(i).relative(direction, x);
                    foliageSetter.set(blockPos, treeConfiguration.foliageProvider.getState(randomSource, blockPos));
                    if (thickPart && x == 2) {
                        foliageSetter.set(blockPos.relative(direction.getOpposite()).relative(direction.getClockWise()), treeConfiguration.foliageProvider.getState(randomSource, blockPos.relative(direction.getOpposite()).relative(direction.getClockWise())));
                    }
                    if (i != 0) {
                        foliageSetter.set(blockPos.relative(direction.getClockWise()), treeConfiguration.foliageProvider.getState(randomSource, blockPos.relative(direction.getClockWise())));
                        if (x == 2) {
                            foliageSetter.set(blockPos.relative(direction.getClockWise(), 2), treeConfiguration.foliageProvider.getState(randomSource, blockPos.relative(direction.getClockWise(), 2)));
                        }
                        if (i >= 3 && !(i % 2 == 0)) {
                            if (x == 2) {
                                foliageSetter.set(blockPos.relative(direction.getClockWise(), 3), treeConfiguration.foliageProvider.getState(randomSource, blockPos.relative(direction.getClockWise(), 3)));
                            } else if (x == 3) {
                                foliageSetter.set(blockPos.relative(direction.getClockWise(), 2), treeConfiguration.foliageProvider.getState(randomSource, blockPos.relative(direction.getClockWise(), 2)));
                            }
                        }
                        if (x > 1) {
                            foliageSetter.set(blockPos.relative(direction.getCounterClockWise()), treeConfiguration.foliageProvider.getState(randomSource, blockPos.relative(direction.getCounterClockWise())));
                        }
                    }
                    if (branchLength == 2) {
                        foliageSetter.set(blockPos.relative(direction, 2), treeConfiguration.foliageProvider.getState(randomSource, blockPos.relative(direction, 2)));
                    }
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
