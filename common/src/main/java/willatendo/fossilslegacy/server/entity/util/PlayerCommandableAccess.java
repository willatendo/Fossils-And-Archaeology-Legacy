package willatendo.fossilslegacy.server.entity.util;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.server.utils.DinosaurCommand;

public interface PlayerCommandableAccess {
	DinosaurCommand getCommand();

	void setCommand(DinosaurCommand dinosaurOrder);

	CommandType commandItems();

	default boolean isOrderedToSit() {
		return this.getCommand() == DinosaurCommand.STAY;
	}

	default boolean willListenToDrum(Player player, InteractionHand interactionHand) {
		return this.commandItems().canCommandWithItem(player.getItemInHand(interactionHand));
	}
}
