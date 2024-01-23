package willatendo.fossilslegacy.server.entity;

import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public interface CommandType {
	boolean canCommand(Player player, InteractionHand interactionHand);

	boolean canCommandWithItem(ItemStack itemStack);

	public static CommandType none() {
		return new CommandType() {
			@Override
			public boolean canCommand(Player player, InteractionHand interactionHand) {
				return false;
			}

			@Override
			public boolean canCommandWithItem(ItemStack itemStack) {
				return false;
			}
		};
	}

	public static CommandType hand() {
		return new CommandType() {
			@Override
			public boolean canCommand(Player player, InteractionHand interactionHand) {
				return player.getItemInHand(interactionHand).isEmpty();
			}

			@Override
			public boolean canCommandWithItem(ItemStack itemStack) {
				return false;
			}
		};
	}

	public static CommandType tag(TagKey<Item> tag) {
		return new CommandType() {
			@Override
			public boolean canCommand(Player player, InteractionHand interactionHand) {
				return player.getItemInHand(interactionHand).is(tag);
			}

			@Override
			public boolean canCommandWithItem(ItemStack itemStack) {
				return itemStack.is(tag);
			}
		};
	}
}
