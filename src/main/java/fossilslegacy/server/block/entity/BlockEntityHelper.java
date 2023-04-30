package fossilslegacy.server.block.entity;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class BlockEntityHelper {
	public static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> blockEntityAtPos, BlockEntityType<E> blockEntity, BlockEntityTicker<? super E> blockEntityTicker) {
		return blockEntity == blockEntityAtPos ? (BlockEntityTicker<A>) blockEntityTicker : null;
	}
}
