package fossilslegacy.server.item;

import fossilslegacy.server.entity.GrowingEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ChickenEssanceBottleItem extends Item {
	public ChickenEssanceBottleItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
		if (livingEntity instanceof GrowingEntity growingEntity) {
			if (growingEntity.getGrowthStage() < growingEntity.getGrowthStages().length) {
				growingEntity.setGrowthStage(growingEntity.getGrowthStage() + 1);
				itemStack.shrink(1);
				return InteractionResult.sidedSuccess(player.level.isClientSide());
			}
		}

		return super.interactLivingEntity(itemStack, player, livingEntity, interactionHand);
	}
}
