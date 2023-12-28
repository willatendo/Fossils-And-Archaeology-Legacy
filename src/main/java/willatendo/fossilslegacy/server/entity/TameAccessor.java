package willatendo.fossilslegacy.server.entity;

import java.util.UUID;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public interface TameAccessor {
	void setOwnerUUID(UUID uuid);

	UUID getOwnerUUID();

	LivingEntity getOwner();

	default boolean isTame() {
		return this.getOwnerUUID() != null;
	}

	default boolean TESTING_autotame(Player player) {
		if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
			if (!this.isTame()) {
				this.setOwnerUUID(player.getUUID());
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
