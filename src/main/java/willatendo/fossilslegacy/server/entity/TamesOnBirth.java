package willatendo.fossilslegacy.server.entity;

import java.util.UUID;

public interface TamesOnBirth {
	default boolean tamesOnBirth() {
		return true;
	}

	void setOwnerUUID(UUID uuid);
}
