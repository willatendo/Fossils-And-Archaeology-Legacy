package willatendo.fossilslegacy.server.entity.util.interfaces;

import java.util.UUID;

public interface TamesOnBirth {
	default boolean tamesOnBirth() {
		return true;
	}

	void setOwnerUUID(UUID uuid);
}
