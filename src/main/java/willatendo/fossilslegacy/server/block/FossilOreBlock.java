package willatendo.fossilslegacy.server.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

public class FossilOreBlock extends Block {
	public FossilOreBlock(Properties properties) {
		super(properties);
	}

	@Override
	public void spawnAfterBreak(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, ItemStack itemStack, boolean flag) {
		int chance = serverLevel.getRandom().nextInt(20000);
		if (chance >= 20 && chance <= 30) {
			popResource(serverLevel, blockPos, FossilsLegacyItems.GEM_ARTIFACT.get().getDefaultInstance());
		}
		if (chance <= 4500) {
			popResource(serverLevel, blockPos, FossilsLegacyItems.FOSSIL.get().getDefaultInstance());
		}
		if (chance > 4500 && chance <= 9800) {
			popResource(serverLevel, blockPos, FossilsLegacyItems.RELIC_SCRAP.get().getDefaultInstance());
		}
		if (chance > 9800 && chance <= 17800) {
			popResource(serverLevel, blockPos, Items.BONE.getDefaultInstance());
		}
		if (chance > 17800 && chance <= 19800) {
			popResource(serverLevel, blockPos, FossilsLegacyBlocks.SKULL_BLOCK.get().asItem().getDefaultInstance());
		}
		if (chance > 19800 && chance <= 19900) {
			popResource(serverLevel, blockPos, FossilsLegacyItems.SWORD_ARTIFACT.get().getDefaultInstance());
		}
		if (chance > 19900 && chance <= 20100) {
			popResource(serverLevel, blockPos, FossilsLegacyItems.HELMET_ARTIFACT.get().getDefaultInstance());
		}
		super.spawnAfterBreak(blockState, serverLevel, blockPos, itemStack, flag);
	}
}
