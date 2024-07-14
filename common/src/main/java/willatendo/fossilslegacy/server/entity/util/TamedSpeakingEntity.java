package willatendo.fossilslegacy.server.entity.util;

import net.minecraft.world.entity.player.Player;

public interface TamedSpeakingEntity extends SpeakingEntity, TameAccessor, SimpleLevelAccessor {
	default void sendMessageToOwnerOrElseAll(SpeakerType speaker) {
		if (this.isTame() && this.getOwner() instanceof Player player) {
			this.sendMessageToPlayer(speaker, player);
		} else {
			for (Player player : this.getLevel().players()) {
				this.sendMessageToPlayer(speaker, player);
			}
		}
	}
}
