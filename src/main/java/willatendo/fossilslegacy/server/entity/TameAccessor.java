package willatendo.fossilslegacy.server.entity;

import java.util.UUID;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.loading.FMLLoader;

public interface TameAccessor {
	void setOwnerUUID(UUID uuid);

	UUID getOwnerUUID();

	LivingEntity getOwner();

	default boolean isTame() {
		return this.getOwnerUUID() != null;
	}

	default boolean TESTING_autotame(Player player) {
		if (!FMLLoader.isProduction()) {
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
