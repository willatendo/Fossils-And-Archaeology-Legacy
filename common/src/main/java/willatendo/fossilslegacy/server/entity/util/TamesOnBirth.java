package willatendo.fossilslegacy.server.entity.util;

import java.util.UUID;

public interface TamesOnBirth {
	default boolean tamesOnBirth() {
		return true;
	}

	void setOwnerUUID(UUID uuid);
}
