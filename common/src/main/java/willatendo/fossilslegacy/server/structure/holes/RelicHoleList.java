package willatendo.fossilslegacy.server.structure.holes;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;

import java.util.List;

public class RelicHoleList {
    private final RelicHole[] relicHoles;

    public RelicHoleList(RandomSource randomSource, List<BlockPos> structureBlockPoses, int holeCount, int holeSize) {
        this.relicHoles = new RelicHole[holeCount + 1];
        for (int i = 0; i < this.relicHoles.length; i++) {
            BlockPos blockPos = structureBlockPoses.get(randomSource.nextInt(structureBlockPoses.size()));
            this.relicHoles[i] = new RelicHole(randomSource, blockPos, holeSize);
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
