package willatendo.fossilslegacy.server.stone_tablet_variant;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public final class FAStoneTabletVariants {
    public static final ResourceKey<StoneTabletVariant> LIGHTING = FAStoneTabletVariants.create("lighting");
    public static final ResourceKey<StoneTabletVariant> SOCIAL = FAStoneTabletVariants.create("social");
    public static final ResourceKey<StoneTabletVariant> GREAT_WAR = FAStoneTabletVariants.create("great_war");
    public static final ResourceKey<StoneTabletVariant> ANU_DEATH = FAStoneTabletVariants.create("anu_death");
    public static final ResourceKey<StoneTabletVariant> PORTAL = FAStoneTabletVariants.create("portal");
    public static final ResourceKey<StoneTabletVariant> HEROBRINE = FAStoneTabletVariants.create("herobrine");
    public static final ResourceKey<StoneTabletVariant> SKELETON_AND_CREEPER = FAStoneTabletVariants.create("skeleton_and_creeper");
    public static final ResourceKey<StoneTabletVariant> ZOMBIE_AND_SPIDER = FAStoneTabletVariants.create("zombie_and_spider");
    public static final ResourceKey<StoneTabletVariant> TYRANNOSAURUS_IN_ICEBERG = FAStoneTabletVariants.create("tyrannosaurus_in_iceberg");
    public static final ResourceKey<StoneTabletVariant> TYRANNOSAURUS_TRANSPORT = FAStoneTabletVariants.create("tyrannosaurus_transport");
    public static final ResourceKey<StoneTabletVariant> TYRANNOSAURUS_MELT = FAStoneTabletVariants.create("tyrannosaurus_melt");
    public static final ResourceKey<StoneTabletVariant> TYRANNOSAURUS_ATTACK = FAStoneTabletVariants.create("tyrannosaurus_attack");
    public static final ResourceKey<StoneTabletVariant> TYRANNOSAURUS_DEATH = FAStoneTabletVariants.create("tyrannosaurus_death");
    public static final ResourceKey<StoneTabletVariant> TYRANNOSAURUS_CORPSE = FAStoneTabletVariants.create("tyrannosaurus_corpse");
    public static final ResourceKey<StoneTabletVariant> PRINCESS = FAStoneTabletVariants.create("princess");
    public static final ResourceKey<StoneTabletVariant> MOSASAURUS = FAStoneTabletVariants.create("mosasaurus");
    public static final ResourceKey<StoneTabletVariant> HOLY_MOSASAURUS = FAStoneTabletVariants.create("holy_mosasaurus");
    public static final ResourceKey<StoneTabletVariant> PAST = FAStoneTabletVariants.create("past");
    public static final ResourceKey<StoneTabletVariant> TIME_MACHINE = FAStoneTabletVariants.create("time_machine");
    public static final ResourceKey<StoneTabletVariant> FUTURE = FAStoneTabletVariants.create("future");
    public static final ResourceKey<StoneTabletVariant> ANU_TOTEM = FAStoneTabletVariants.create("anu_totem");

    private static ResourceKey<StoneTabletVariant> create(String name) {
        return ResourceKey.create(FARegistries.STONE_TABLET_VARIANTS, FossilsLegacyUtils.resource(name));
    }

    private static void register(BootstrapContext<StoneTabletVariant> bootstrapContext, ResourceKey<StoneTabletVariant> resourceKey, int width, int height) {
        bootstrapContext.register(resourceKey, new StoneTabletVariant(width, height, resourceKey.location()));
    }

    public static void bootstrap(BootstrapContext<StoneTabletVariant> bootstrapContext) {
        FAStoneTabletVariants.register(bootstrapContext, LIGHTING, 2, 1);
        FAStoneTabletVariants.register(bootstrapContext, SOCIAL, 1, 1);
        FAStoneTabletVariants.register(bootstrapContext, GREAT_WAR, 2, 2);
        FAStoneTabletVariants.register(bootstrapContext, ANU_DEATH, 2, 1);
        FAStoneTabletVariants.register(bootstrapContext, PORTAL, 2, 2);
        FAStoneTabletVariants.register(bootstrapContext, HEROBRINE, 2, 2);
        FAStoneTabletVariants.register(bootstrapContext, SKELETON_AND_CREEPER, 1, 1);
        FAStoneTabletVariants.register(bootstrapContext, ZOMBIE_AND_SPIDER, 1, 1);
        FAStoneTabletVariants.register(bootstrapContext, TYRANNOSAURUS_IN_ICEBERG, 2, 2);
        FAStoneTabletVariants.register(bootstrapContext, TYRANNOSAURUS_TRANSPORT, 2, 1);
        FAStoneTabletVariants.register(bootstrapContext, TYRANNOSAURUS_MELT, 2, 1);
        FAStoneTabletVariants.register(bootstrapContext, TYRANNOSAURUS_ATTACK, 2, 2);
        FAStoneTabletVariants.register(bootstrapContext, TYRANNOSAURUS_DEATH, 2, 2);
        FAStoneTabletVariants.register(bootstrapContext, TYRANNOSAURUS_CORPSE, 4, 2);
        FAStoneTabletVariants.register(bootstrapContext, PRINCESS, 2, 2);
        FAStoneTabletVariants.register(bootstrapContext, MOSASAURUS, 2, 1);
        FAStoneTabletVariants.register(bootstrapContext, HOLY_MOSASAURUS, 4, 2);
        FAStoneTabletVariants.register(bootstrapContext, PAST, 2, 2);
        FAStoneTabletVariants.register(bootstrapContext, TIME_MACHINE, 1, 2);
        FAStoneTabletVariants.register(bootstrapContext, FUTURE, 2, 2);
        FAStoneTabletVariants.register(bootstrapContext, ANU_TOTEM, 1, 2);
    }
}
