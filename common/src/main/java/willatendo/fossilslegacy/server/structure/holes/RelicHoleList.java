package willatendo.fossilslegacy.server.structure.holes;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class RelicHoleList {
    private RelicHole[] relicHoles;
    private int DEFAULT_HOLE_COUNT = 9;
    private int DEFAULT_HOLE_SIZE = 7;

    public RelicHoleList(List<BlockState> blockStates, Rotation rotation, BlockPos blockPos, RandomSource randomSource, int xWidth, int layers, int zWidth, int holeCount, int holeSize) {
        if (holeCount < 0) {
            holeCount = DEFAULT_HOLE_COUNT;
        }
        if (holeSize < 0) {
            holeSize = DEFAULT_HOLE_SIZE;
        }
        this.relicHoles = new RelicHole[holeCount + 1];
        for (int i = 0; i < this.relicHoles.length; i++) {
            this.relicHoles[i] = new RelicHole(blockStates, rotation, blockPos, randomSource, xWidth, layers, zWidth, holeSize);
        }
    }

    public boolean isHole(BlockPos blockPos) {
        for (int i = 0; i < this.relicHoles.length; i++) {
            if (this.relicHoles[i].isHole(blockPos)) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }
}
