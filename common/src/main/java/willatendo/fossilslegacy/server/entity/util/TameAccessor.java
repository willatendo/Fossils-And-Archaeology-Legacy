package willatendo.fossilslegacy.server.entity.util;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.server.entity.Dinosaur;

import java.util.UUID;

public interface TameAccessor extends SimpleLevelAccessor {
	void setOwnerUUID(UUID uuid);

	UUID getOwnerUUID();

	LivingEntity getOwner();

	default boolean isTame() {
		return this.getOwnerUUID() != null;
	}

	default void setOwnerUUID(UUID uuid, boolean treat) {
		if (treat) {
			if (this instanceof SpeakingEntity speakingEntity) {
				speakingEntity.sendMessageToPlayer(DinoSituation.TAME_WITH_TREAT, this.getLevel().getPlayerByUUID(uuid));
			} else {
				Player player = this.getLevel().getPlayerByUUID(uuid);
				player.sendSystemMessage(DinoSituation.TAME_WITH_TREAT.getMessage(player, (Dinosaur) (Object) this));
			}
		}
		this.setOwnerUUID(uuid);
	}
}
