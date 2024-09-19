package willatendo.fossilslegacy.server.entity.util.interfaces;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.server.entity.util.CommandType;

public interface PlayerCommandableAccess {
    CommandType getCommand();

    void setCommand(CommandType dinosaurOrder);

    CommandingType commandItems();

    default boolean isOrderedToSit() {
        return this.getCommand() == CommandType.STAY;
    }

    default boolean willListenToDrum(Player player, InteractionHand interactionHand) {
        return this.commandItems().canCommandWithItem(player.getItemInHand(interactionHand));
    }
}
