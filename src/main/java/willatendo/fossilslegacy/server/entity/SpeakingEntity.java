package willatendo.fossilslegacy.server.entity;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public interface SpeakingEntity {
	Component getDisplayName();

	default void sendMessageToPlayer(SpeakerType speaker, Player player) {
		player.sendSystemMessage(Component.translatable("%s: %s", this.getDisplayName().getString(), speaker.getMessage(player).getString()));
	}
}
