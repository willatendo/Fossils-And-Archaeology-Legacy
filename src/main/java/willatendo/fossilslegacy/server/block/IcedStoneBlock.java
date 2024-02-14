package willatendo.fossilslegacy.server.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.state.BlockState;

public class IcedStoneBlock extends HalfTransparentBlock {
	public IcedStoneBlock(Properties properties) {
		super(properties);
	}

	@Override
	public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
		if (serverLevel.getBrightness(LightLayer.BLOCK, blockPos) > 11 - blockState.getLightBlock(serverLevel, blockPos)) {
			this.melt(blockState, serverLevel, blockPos);
		}
	}

	protected void melt(BlockState blockState, Level level, BlockPos blockPos) {
		level.setBlockAndUpdate(blockPos, Blocks.STONE.defaultBlockState());
		level.neighborChanged(blockPos, Blocks.STONE, blockPos);
	}
}
