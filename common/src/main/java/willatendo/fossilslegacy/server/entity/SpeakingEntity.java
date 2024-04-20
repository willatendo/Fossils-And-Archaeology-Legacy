package willatendo.fossilslegacy.server.entity;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public interface SpeakingEntity {
	Component getDisplayName();

	default void sendMessageToPlayer(SpeakerType speaker, Player player) {
		player.sendSystemMessage(Component.translatable("%s", speaker.getMessage(player, (LivingEntity) (Object) this).getString()));
	}
}
