package willatendo.fossilslegacy.server.entity.util;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public interface SpeakingEntity {
	Component getDisplayName();

	default void sendMessageToPlayer(SpeakerType speakerType, Player player) {
		player.sendSystemMessage(Component.translatable("%s", speakerType.getMessage(player, (LivingEntity) (Object) this).getString()));
	}
}
