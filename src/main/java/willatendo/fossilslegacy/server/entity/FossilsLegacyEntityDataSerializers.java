package willatendo.fossilslegacy.server.entity;

import net.minecraft.core.Holder;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import willatendo.fossilslegacy.server.FossilsLegacyBuiltInRegistries;

public class FossilsLegacyEntityDataSerializers {
	public static final EntityDataSerializer<EggVariant> EGG_VARIANTS = EntityDataSerializer.simpleId(FossilsLegacyBuiltInRegistries.EGG_VARIANTS);
	public static final EntityDataSerializer<FossilVariant> FOSSIL_VARIANTS = EntityDataSerializer.simpleId(FossilsLegacyBuiltInRegistries.FOSSIL_VARIANTS);
	public static final EntityDataSerializer<Holder<StoneTabletVariant>> STONE_TABLET_VARIANTS = EntityDataSerializer.simpleId(FossilsLegacyBuiltInRegistries.STONE_TABLET_VARIANTS.asHolderIdMap());

	public static void init() {
		EntityDataSerializers.registerSerializer(EGG_VARIANTS);
		EntityDataSerializers.registerSerializer(FOSSIL_VARIANTS);
		EntityDataSerializers.registerSerializer(STONE_TABLET_VARIANTS);
	}
}
