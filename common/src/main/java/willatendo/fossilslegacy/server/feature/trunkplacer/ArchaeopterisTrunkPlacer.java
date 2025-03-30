package willatendo.fossilslegacy.server.feature.trunkplacer;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import willatendo.fossilslegacy.server.block.blocks.BranchBlock;
import willatendo.fossilslegacy.server.feature.FATrunkPlacerTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class ArchaeopterisTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<ArchaeopterisTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> trunkPlacerParts(instance).apply(instance, ArchaeopterisTrunkPlacer::new));

    public ArchaeopterisTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return FATrunkPlacerTypes.ARCHAEOPTERIS_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource randomSource, int height, BlockPos blockPos, TreeConfiguration treeConfiguration) {
        ArchaeopterisTrunkPlacer.setDirtAt(levelSimulatedReader, biConsumer, randomSource, blockPos.below(), treeConfiguration);

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            ArchaeopterisTrunkPlacer.setDirtAt(levelSimulatedReader, biConsumer, randomSource, blockPos.below().relative(direction), treeConfiguration);
            this.placeLog(levelSimulatedReader, biConsumer, randomSource, blockPos.relative(direction), treeConfiguration);
        }

        for (int i = 0; i < height; i++) {
            this.placeLog(levelSimulatedReader, biConsumer, randomSource, blockPos.above(i), treeConfiguration);
        }

        List<FoliagePlacer.FoliageAttachment> foliageAttachments = new ArrayList<>();
        for (int i = 4; i < height; i++) {
            if (i != height - 1) {
                if ((i - 1) % 3 == 0) {
                    for (Direction direction : Direction.Plane.HORIZONTAL) {
                        int max;
                        for (int x = 1; x < (max = ((height / 2) - (i / 4)) - 2 + randomSource.nextInt(2)); x++) {
                            this.placeLog(levelSimulatedReader, biConsumer, randomSource, blockPos.above(i).relative(direction, x), treeConfiguration, blockState -> blockState.setValue(RotatedPillarBlock.AXIS, direction.getAxis()));
                            if (x > 1) {
                                this.placeLeaves(levelSimulatedReader, biConsumer, randomSource, blockPos.above(i).relative(direction, x).relative(direction.getClockWise()), treeConfiguration, blockState -> blockState.setValue(BranchBlock.HORIZONTAL_FACING, direction.getClockWise()));
                                this.placeLeaves(levelSimulatedReader, biConsumer, randomSource, blockPos.above(i).relative(direction, x).relative(direction.getCounterClockWise()), treeConfiguration, blockState -> blockState.setValue(BranchBlock.HORIZONTAL_FACING, direction.getCounterClockWise()));
                            }
                            if (x == max - 1) {
                                this.placeLeaves(levelSimulatedReader, biConsumer, randomSource, blockPos.above(i).relative(direction, x + 1), treeConfiguration, blockState -> blockState.setValue(BranchBlock.HORIZONTAL_FACING, direction));
                            }
                        }
                    }
                }
            }
            if (i == height - 1) {
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    this.placeLeaves(levelSimulatedReader, biConsumer, randomSource, blockPos.above(i).relative(direction), treeConfiguration, blockState -> blockState.setValue(BranchBlock.HORIZONTAL_FACING, direction));
                }
            }
        }

        return foliageAttachments;
    }

    protected boolean placeLeaves(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource randomSource, BlockPos blockPos, TreeConfiguration treeConfiguration, Function<BlockState, BlockState> propertySetter) {
        if (this.validTreePos(levelSimulatedReader, blockPos)) {
            blockSetter.accept(blockPos, propertySetter.apply(treeConfiguration.foliageProvider.getState(randomSource, blockPos)));
            return true;
        } else {
            return false;
        }
    }
}
