package willatendo.fossilslegacy.server.feature.trunkplacer;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import willatendo.fossilslegacy.server.feature.FATrunkPlacerTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class StraightBranchingTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<StraightBranchingTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> trunkPlacerParts(instance).apply(instance, StraightBranchingTrunkPlacer::new));

    public StraightBranchingTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return FATrunkPlacerTypes.STRAIGHT_BRANCHING_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource randomSource, int height, BlockPos blockPos, TreeConfiguration treeConfiguration) {
        setDirtAt(levelSimulatedReader, biConsumer, randomSource, blockPos.below(), treeConfiguration);

        List<FoliagePlacer.FoliageAttachment> foliageAttachments = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            if (i != height - 1) {
                this.placeLog(levelSimulatedReader, biConsumer, randomSource, blockPos.above(i), treeConfiguration);
                if (i != 0) {
                    if ((i + 1) % 3 == 0) {
                        foliageAttachments.add(new FoliagePlacer.FoliageAttachment(blockPos.above(i), 0, false));
                    }
                }
            } else {
                biConsumer.accept(blockPos.above(i), treeConfiguration.foliageProvider.getState(randomSource, blockPos.above(i)));
            }
        }

        return foliageAttachments;
    }
}
