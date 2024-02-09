package willatendo.fossilslegacy.server.entity;

import java.util.UUID;

import net.minecraft.world.entity.LivingEntity;

public interface TameAccessor {
	void setOwnerUUID(UUID uuid);

	UUID getOwnerUUID();

	LivingEntity getOwner();

	default boolean isTame() {
		return this.getOwnerUUID() != null;
	}
}
