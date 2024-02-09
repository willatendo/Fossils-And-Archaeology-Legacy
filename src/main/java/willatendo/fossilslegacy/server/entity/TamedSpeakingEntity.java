package willatendo.fossilslegacy.server.entity;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public interface TamedSpeakingEntity extends SpeakingEntity, TameAccessor {
	Level level();

	default void sendMessageToOwnerOrElseAll(Speaker speaker) {
		if (this.isTame() && this.getOwner() instanceof Player player) {
			this.sendMessageToPlayer(speaker, player);
		} else {
			for (Player player : this.level().players()) {
				this.sendMessageToPlayer(speaker, player);
			}
		}
	}
}
