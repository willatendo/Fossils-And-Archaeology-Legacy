package willatendo.fossilslegacy.server.structure.processor.hole;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;

import java.util.List;

public class RelicHoleList {
    private final RelicHole[] relicHoles;

    public RelicHoleList(RandomSource randomSource, List<BlockPos> structureBlockPoses, int holeCount, int holeSize) {
        this.relicHoles = new RelicHole[holeCount + 1];
        for (int i = 0; i < this.relicHoles.length; i++) {
            BlockPos blockPos = structureBlockPoses.get(Math.abs(randomSource.nextInt(structureBlockPoses.size())));
            this.relicHoles[i] = new RelicHole(randomSource, blockPos, holeSize);
        }
    }

    public boolean isHole(BlockPos blockPos) {
        for (RelicHole relicHole : this.relicHoles) {
            if (relicHole.isHole(blockPos)) {
                return true;
            }
        }
        return false;
    }
}
