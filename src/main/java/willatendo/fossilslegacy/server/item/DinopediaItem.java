package willatendo.fossilslegacy.server.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.entity.DinopediaInformation;

public class DinopediaItem extends Item {
	private int useTime = 0;

	public DinopediaItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
		if (this.useTime == 0) {
			this.useTime = 3;
			if (livingEntity instanceof DinopediaInformation dinosaurEncyclopediaInfo) {
				for (Component component : dinosaurEncyclopediaInfo.info(player)) {
					player.sendSystemMessage(component);
				}
				return InteractionResult.sidedSuccess(player.level().isClientSide());
			}
		}

		return super.interactLivingEntity(itemStack, player, livingEntity, interactionHand);
	}

	@Override
	public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int slot, boolean isSlot) {
		super.inventoryTick(itemStack, level, entity, slot, isSlot);
		if (this.useTime > 0) {
			this.useTime = 0;
		}
	}
}
