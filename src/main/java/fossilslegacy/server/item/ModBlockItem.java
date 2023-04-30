package fossilslegacy.server.item;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class ModBlockItem extends BlockItem {
	private final Supplier<Block> block;

	public ModBlockItem(Supplier<Block> block, Properties properties) {
		super(null, properties);
		this.block = block;
	}

	@Override
	public Block getBlock() {
		return this.block.get();
	}
}
