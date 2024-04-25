package willatendo.fossilslegacy.server.structure.holes;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class RelicHole {
    public BlockPos blockPos;
    public int range;
    public int mixedIndex;

    public RelicHole() {
        this.blockPos = BlockPos.ZERO;
    }

    public RelicHole(BlockPos blockPos, RandomSource randomSource, int xWidth, int layers, int zWidth, int holeSize) {
        this.blockPos = new BlockPos(blockPos.getX() + randomSource.nextInt(xWidth), blockPos.getY() + randomSource.nextInt(layers), blockPos.getZ() + randomSource.nextInt(zWidth));
        this.mixedIndex = this.blockPos.getX() * xWidth * zWidth + this.blockPos.getZ() * xWidth + this.blockPos.getX();
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
        FossilsLegacyUtils.LOGGER.info("bp " + this.blockPos + " in " + blockPos);
        return (distance <= this.range);
    }
}
