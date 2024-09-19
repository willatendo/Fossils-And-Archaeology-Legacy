package willatendo.fossilslegacy.server.item;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;

public class DinopediaItem extends Item {
	public DinopediaItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
		if (livingEntity instanceof DinopediaInformation dinosaurEncyclopediaInfo) {
			if (player.level() instanceof ServerLevel) {
				return InteractionResult.PASS;
			}

			player.getCooldowns().addCooldown(this, 10);
			for (Component component : dinosaurEncyclopediaInfo.info(player)) {
				player.sendSystemMessage(component);
			}
			player.awardStat(Stats.ITEM_USED.get(this));
			return InteractionResult.sidedSuccess(player.level().isClientSide());
		}

		return super.interactLivingEntity(itemStack, player, livingEntity, interactionHand);
	}
}
