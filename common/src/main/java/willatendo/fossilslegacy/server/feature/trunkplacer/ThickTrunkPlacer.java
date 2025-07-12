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
import willatendo.fossilslegacy.server.feature.FATrunkPlacerTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class ThickTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<ThickTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> ThickTrunkPlacer.trunkPlacerParts(instance).apply(instance, ThickTrunkPlacer::new));

    public ThickTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return FATrunkPlacerTypes.THICK_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource randomSource, int height, BlockPos blockPos, TreeConfiguration treeConfiguration) {
        List<FoliagePlacer.FoliageAttachment> foliageAttachments = new ArrayList<>();
        ThickTrunkPlacer.setDirtAt(levelSimulatedReader, biConsumer, randomSource, blockPos.below(), treeConfiguration);

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            ThickTrunkPlacer.setDirtAt(levelSimulatedReader, biConsumer, randomSource, blockPos.below().relative(direction), treeConfiguration);
            for (int i = 0; i < height / 2; i++) {
                this.placeLog(levelSimulatedReader, biConsumer, randomSource, blockPos.above(i).relative(direction), treeConfiguration);
            }
        }

        for (int i = 0; i < height; i++) {
            this.placeLog(levelSimulatedReader, biConsumer, randomSource, blockPos.above(i), treeConfiguration);
            if (i == height - 1) {
                foliageAttachments.add(new FoliagePlacer.FoliageAttachment(blockPos.above(i + 1), height, false));
            }
        }

        return foliageAttachments;
    }
}
