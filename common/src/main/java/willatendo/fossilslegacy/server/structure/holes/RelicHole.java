package willatendo.fossilslegacy.server.structure.holes;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class RelicHole {
    public final BlockPos blockPos;
    public final int range;

    public RelicHole(RandomSource randomSource, BlockPos blockPos, int holeSize) {
        this.blockPos = blockPos;
        this.range = randomSource.nextInt(holeSize) + 1;
    }

    public boolean isHole(BlockPos blockPos) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        int atX = this.blockPos.getX();
        int atY = this.blockPos.getY();
        int atZ = this.blockPos.getZ();
        int distance = (int) Math.sqrt(Math.pow((atX - x), 2) + Math.pow((atY - y), 2) + Math.pow((atZ - z), 2));
        return (distance <= this.range);
    }
}
