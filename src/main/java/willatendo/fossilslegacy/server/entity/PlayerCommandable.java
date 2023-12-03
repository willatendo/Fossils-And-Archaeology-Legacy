package willatendo.fossilslegacy.server.entity;

import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.utils.DinosaurOrder;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public interface PlayerCommandable<T extends Entity> {
	DinosaurOrder getCommand();

	void setCommand(DinosaurOrder dinosaurOrder);

	TagKey<Item> commandItems();

	default boolean isSitting() {
		return this.getCommand() == DinosaurOrder.STAY;
	}

	default boolean isCommandItem(ItemStack itemStack) {
		if (this.commandItems() != null) {
			return itemStack.is(this.commandItems());
		} else {
			return this.commandItems() == null ? itemStack.isEmpty() : false;
		}
	}

	default boolean command(Player player, Vec3 vec3, InteractionHand interactionHand, T entity) {
		ItemStack itemStack = player.getItemInHand(interactionHand);
		if (entity instanceof TameAccessor tameAccessor) {
			if (tameAccessor.isTame() && tameAccessor.getOwnerUUID() == player.getUUID()) {
				if (this.isCommandItem(itemStack)) {
					if (DinosaurOrder.getNext(this.getCommand()) != null) {
						this.setCommand(DinosaurOrder.getNext(this.getCommand()));
						player.displayClientMessage(FossilsLegacyUtils.translation("order", "order.use", this.getCommand().getComponent().getString()), true);
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			if (this.isCommandItem(itemStack)) {
				if (DinosaurOrder.getNext(this.getCommand()) != null) {
					this.setCommand(DinosaurOrder.getNext(this.getCommand()));
					player.displayClientMessage(FossilsLegacyUtils.translation("order", "order.use", this.getCommand().getComponent().getString()), true);
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}
}
