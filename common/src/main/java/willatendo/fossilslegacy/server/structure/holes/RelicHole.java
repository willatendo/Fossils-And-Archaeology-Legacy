package willatendo.fossilslegacy.server.structure.holes;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class RelicHole {
    public BlockPos blockPos;
    public int range;
    public int mixedIndex;

    public RelicHole() {
        this.blockPos = BlockPos.ZERO;
    }

    public RelicHole(List<BlockState> blockStates, Rotation rotation, BlockPos blockPos, RandomSource randomSource, int xWidth, int layers, int zWidth, int holeSize) {
        do {
            int xOffset = randomSource.nextInt(xWidth);
            int zOffset = randomSource.nextInt(zWidth);
            this.blockPos = new BlockPos(blockPos.getX() + xOffset, blockPos.getY() + randomSource.nextInt(layers), blockPos.getZ() + zOffset);
            this.mixedIndex = xOffset * xWidth * zWidth + zOffset * xWidth + xOffset;
        } while (blockStates.get(this.mixedIndex).is(Blocks.AIR));
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
