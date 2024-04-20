package willatendo.fossilslegacy.server.entity;

import java.util.UUID;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

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
				speakingEntity.sendMessageToPlayer(DinoSituation.TAME_WITH_TREAT, this.level().getPlayerByUUID(uuid));
			} else {
				Player player = this.level().getPlayerByUUID(uuid);
				player.sendSystemMessage(DinoSituation.TAME_WITH_TREAT.getMessage(player, (Dinosaur) (Object) this));
			}
		}
		this.setOwnerUUID(uuid);
	}
}
