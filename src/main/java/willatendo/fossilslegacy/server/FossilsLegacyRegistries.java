package willatendo.fossilslegacy.server;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.entity.StoneTabletVariant;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyRegistries {
	public static final ResourceKey<Registry<StoneTabletVariant>> STONE_TABLET_VARIANTS = createRegistryKey("stone_tablet_types");

	private static <T> ResourceKey<Registry<T>> createRegistryKey(String id) {
		return ResourceKey.createRegistryKey(FossilsLegacyUtils.resource(id));
	}
}
