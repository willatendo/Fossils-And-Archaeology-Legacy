package willatendo.fossilslegacy.server.feature.trunkplacer;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class ForkedThickTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<ForkedThickTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> trunkPlacerParts(instance).apply(instance, ForkedThickTrunkPlacer::new));

    public ForkedThickTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return FossilsLegacyTrunkPlacerTypes.FORKED_THICK_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource randomSource, int height, BlockPos blockPos, TreeConfiguration treeConfiguration) {
        setDirtAt(levelSimulatedReader, biConsumer, randomSource, blockPos.below(), treeConfiguration);

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            setDirtAt(levelSimulatedReader, biConsumer, randomSource, blockPos.below().relative(direction), treeConfiguration);
            for (int i = 0; i < height / 5; i++) {
                this.placeLog(levelSimulatedReader, biConsumer, randomSource, blockPos.above(i).relative(direction), treeConfiguration);
            }
        }

        for (int i = 0; i < height - 2; i++) {
            this.placeLog(levelSimulatedReader, biConsumer, randomSource, blockPos.above(i), treeConfiguration);
        }

        Direction[] branchDirections = randomSource.nextInt(2) == 0 ? new Direction[]{Direction.NORTH, Direction.SOUTH} : new Direction[]{Direction.EAST, Direction.WEST};
        List<FoliagePlacer.FoliageAttachment> foliageAttachments = new ArrayList<>();
        for (int i = 1; i > -1; i--) {
            for (Direction direction : branchDirections) {
                BlockPos topPos = blockPos.above(height - 2 + i).relative(direction, i + 1);
                this.placeLog(levelSimulatedReader, biConsumer, randomSource, topPos, treeConfiguration);
                if (i == 1) {
                    foliageAttachments.add(new FoliagePlacer.FoliageAttachment(topPos.above(), 0, false));
                }
            }
        }

        return foliageAttachments;
    }
}
