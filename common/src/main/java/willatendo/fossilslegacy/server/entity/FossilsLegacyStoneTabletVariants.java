package willatendo.fossilslegacy.server.entity;

import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.variants.StoneTabletVariant;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyStoneTabletVariants {
    public static final SimpleRegistry<StoneTabletVariant> STONE_TABLET_VARIANTS = SimpleRegistry.create(FossilsLegacyRegistries.STONE_TABLET_VARIANTS, FossilsLegacyUtils.ID);

    public static final SimpleHolder<StoneTabletVariant> LIGHTING = register("lighting", 2, 1);
    public static final SimpleHolder<StoneTabletVariant> SOCIAL = register("social", 1, 1);
    public static final SimpleHolder<StoneTabletVariant> GREAT_WAR = register("great_war", 2, 2);
    public static final SimpleHolder<StoneTabletVariant> ANU_DEATH = register("anu_death", 2, 1);
    public static final SimpleHolder<StoneTabletVariant> PORTAL = register("portal", 2, 2);
    public static final SimpleHolder<StoneTabletVariant> HEROBRINE = register("herobrine", 2, 2);
    public static final SimpleHolder<StoneTabletVariant> SKELETON_AND_CREEPER = register("skeleton_and_creeper", 1, 1);
    public static final SimpleHolder<StoneTabletVariant> ZOMBIE_AND_SPIDER = register("zombie_and_spider", 1, 1);
    public static final SimpleHolder<StoneTabletVariant> TYRANNOSAURUS_IN_ICEBERG = register("tyrannosaurus_in_iceberg", 2, 2);
    public static final SimpleHolder<StoneTabletVariant> TYRANNOSAURUS_TRANSPORT = register("tyrannosaurus_transport", 2, 1);
    public static final SimpleHolder<StoneTabletVariant> TYRANNOSAURUS_MELT = register("tyrannosaurus_melt", 2, 1);
    public static final SimpleHolder<StoneTabletVariant> TYRANNOSAURUS_ATTACK = register("tyrannosaurus_attack", 2, 2);
    public static final SimpleHolder<StoneTabletVariant> TYRANNOSAURUS_DEATH = register("tyrannosaurus_death", 2, 2);
    public static final SimpleHolder<StoneTabletVariant> TYRANNOSAURUS_CORPSE = register("tyrannosaurus_corpse", 4, 2);
    public static final SimpleHolder<StoneTabletVariant> PRINCESS = register("princess", 2, 2);
    public static final SimpleHolder<StoneTabletVariant> MOSASAURUS = register("mosasaurus", 2, 1);
    public static final SimpleHolder<StoneTabletVariant> HOLY_MOSASAURUS = register("holy_mosasaurus", 4, 2);
    public static final SimpleHolder<StoneTabletVariant> PAST = register("past", 2, 2);
    public static final SimpleHolder<StoneTabletVariant> TIME_MACHINE = register("time_machine", 1, 2);
    public static final SimpleHolder<StoneTabletVariant> FUTURE = register("future", 2, 2);
    public static final SimpleHolder<StoneTabletVariant> ANU_TOTEM = register("anu_totem", 1, 2);

    public static SimpleHolder<StoneTabletVariant> register(String id, int width, int height) {
        return STONE_TABLET_VARIANTS.register(id, () -> new StoneTabletVariant(id, width, height));
    }
}
