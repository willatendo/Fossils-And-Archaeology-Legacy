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
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class SigillariaTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<SigillariaTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> trunkPlacerParts(instance).apply(instance, SigillariaTrunkPlacer::new));

    public SigillariaTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return FossilsLegacyTrunkPlacerTypes.SIGILLARIA_TRUNK_PLACER.get();
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

        for (int i = 0; i < height - 6; i++) {
            this.placeLog(levelSimulatedReader, biConsumer, randomSource, blockPos.above(i), treeConfiguration);
        }

        int branches = randomSource.nextInt(100) + 1;
        List<FoliagePlacer.FoliageAttachment> foliageAttachments = new ArrayList<>();
        if (branches < 30) {
            foliageAttachments.add(new FoliagePlacer.FoliageAttachment(blockPos.above(height - 6), 0, false));
        }
        if (branches >= 30 && branches < 95) {
            Direction[] branchDirections = randomSource.nextInt(2) == 0 ? new Direction[]{Direction.NORTH, Direction.SOUTH} : new Direction[]{Direction.EAST, Direction.WEST};
            for (int i = 1; i > -1; i--) {
                for (Direction direction : branchDirections) {
                    BlockPos topPos = blockPos.above(height - 6 + i).relative(direction, i + 1);
                    this.placeLog(levelSimulatedReader, biConsumer, randomSource, topPos, treeConfiguration);
                    if (i == 1) {
                        foliageAttachments.add(new FoliagePlacer.FoliageAttachment(topPos.above(), 0, false));
                    }
                }
            }
        }
        if (branches >= 95) {
            Direction facing = Direction.Plane.HORIZONTAL.getRandomDirection(randomSource);
            for (int i = 1; i > -1; i--) {
                this.placeLog(levelSimulatedReader, biConsumer, randomSource, blockPos.above(height - 6 + i).relative(facing, i + 1), treeConfiguration);
                if (i == 1) {
                    foliageAttachments.add(new FoliagePlacer.FoliageAttachment(blockPos.above(height - 6 + i).relative(facing, i + 1), 0, false));
                }
                Direction[] branchDirections = facing == Direction.NORTH ? new Direction[]{Direction.EAST, Direction.WEST} : facing == Direction.EAST ? new Direction[]{Direction.NORTH, Direction.SOUTH} : facing == Direction.SOUTH ? new Direction[]{Direction.EAST, Direction.WEST} : new Direction[]{Direction.SOUTH, Direction.NORTH};
                for (Direction direction : branchDirections) {
                    BlockPos topPos = blockPos.above(height - 6 + i).relative(direction, i + 1).relative(facing.getOpposite(), i + 1);
                    this.placeLog(levelSimulatedReader, biConsumer, randomSource, topPos, treeConfiguration);
                    if (i == 1) {
                        foliageAttachments.add(new FoliagePlacer.FoliageAttachment(topPos.above(), 0, false));
                    }
                }
            }
        }

        return foliageAttachments;
    }
}