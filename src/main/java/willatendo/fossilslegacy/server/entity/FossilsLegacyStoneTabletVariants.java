package willatendo.fossilslegacy.server.entity;

import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.FabricRegister;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyStoneTabletVariants {
	public static final SimpleRegistry<StoneTabletVariant> STONE_TABLET_TYPES = SimpleRegistry.create(FossilsLegacyRegistries.STONE_TABLET_VARIANTS, FossilsLegacyUtils.ID);

	public static final SimpleHolder<StoneTabletVariant> LIGHTING = register("lighting", 32, 16);
	public static final SimpleHolder<StoneTabletVariant> SOCIAL = register("social", 16, 16);
	public static final SimpleHolder<StoneTabletVariant> GREAT_WAR = register("great_war", 32, 32);
	public static final SimpleHolder<StoneTabletVariant> ANU_DEATH = register("anu_death", 32, 16);
	public static final SimpleHolder<StoneTabletVariant> PORTAL = register("portal", 32, 32);
	public static final SimpleHolder<StoneTabletVariant> HEROBRINE = register("herobrine", 32, 32);
	public static final SimpleHolder<StoneTabletVariant> SKELETON_AND_CREEPER = register("skeleton_and_creeper", 16, 16);
	public static final SimpleHolder<StoneTabletVariant> ZOMBIE_AND_SPIDER = register("zombie_and_spider", 16, 16);
	public static final SimpleHolder<StoneTabletVariant> TYRANNOSAURUS_IN_ICEBERG = register("tyrannosaurus_in_iceberg", 32, 32);
	public static final SimpleHolder<StoneTabletVariant> TYRANNOSAURUS_TRANSPORT = register("tyrannosaurus_transport", 32, 16);
	public static final SimpleHolder<StoneTabletVariant> TYRANNOSAURUS_MELT = register("tyrannosaurus_melt", 32, 16);
	public static final SimpleHolder<StoneTabletVariant> TYRANNOSAURUS_ATTACK = register("tyrannosaurus_attack", 32, 32);
	public static final SimpleHolder<StoneTabletVariant> TYRANNOSAURUS_DEATH = register("tyrannosaurus_death", 32, 32);
	public static final SimpleHolder<StoneTabletVariant> TYRANNOSAURUS_CORPSE = register("tyrannosaurus_corpse", 64, 32);
	public static final SimpleHolder<StoneTabletVariant> PRINCESS = register("princess", 32, 32);
	public static final SimpleHolder<StoneTabletVariant> MOSASAURUS = register("mosasaurus", 32, 16);
	public static final SimpleHolder<StoneTabletVariant> HOLY_MOSASAURUS = register("holy_mosasaurus", 64, 32);
	public static final SimpleHolder<StoneTabletVariant> PAST = register("past", 32, 32);
	public static final SimpleHolder<StoneTabletVariant> TIME_MACHINE = register("time_machine", 16, 32);
	public static final SimpleHolder<StoneTabletVariant> FUTURE = register("future", 32, 32);

	public static SimpleHolder<StoneTabletVariant> register(String id, int width, int height) {
		return STONE_TABLET_TYPES.register(id, () -> new StoneTabletVariant(id, width, height));
	}

	public static void init() {
		FabricRegister.register(STONE_TABLET_TYPES);
	}
}
