package fossilslegacy.server.entity;

import fossilslegacy.server.utils.DinosaurOrder;
import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public interface PlayerCommandable {
	DinosaurOrder getCommand();

	void setCommand(DinosaurOrder commands);

	TagKey<Item> commandItems();

	default boolean command(Player player, Vec3 vec3, InteractionHand interactionHand) {
		ItemStack itemStack = player.getItemInHand(interactionHand);
		if (itemStack.is(this.commandItems())) {
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
