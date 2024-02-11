package willatendo.fossilslegacy.server;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.core.Registry;
import willatendo.fossilslegacy.server.entity.StoneTabletVariant;

public class FossilsLegacyBuiltInRegistries {
	public static final Registry<StoneTabletVariant> STONE_TABLET_VARIANTS = FabricRegistryBuilder.createSimple(FossilsLegacyRegistries.STONE_TABLET_VARIANTS).buildAndRegister();

	public static void init() {
	}
}
