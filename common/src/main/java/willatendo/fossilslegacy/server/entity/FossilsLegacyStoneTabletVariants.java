package willatendo.fossilslegacy.server.entity;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.variants.StoneTabletVariant;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyStoneTabletVariants {
    public static final ResourceKey<StoneTabletVariant> LIGHTING = FossilsLegacyStoneTabletVariants.create("lighting");
    public static final ResourceKey<StoneTabletVariant> SOCIAL = FossilsLegacyStoneTabletVariants.create("social");
    public static final ResourceKey<StoneTabletVariant> GREAT_WAR = FossilsLegacyStoneTabletVariants.create("great_war");
    public static final ResourceKey<StoneTabletVariant> ANU_DEATH = FossilsLegacyStoneTabletVariants.create("anu_death");
    public static final ResourceKey<StoneTabletVariant> PORTAL = FossilsLegacyStoneTabletVariants.create("portal");
    public static final ResourceKey<StoneTabletVariant> HEROBRINE = FossilsLegacyStoneTabletVariants.create("herobrine");
    public static final ResourceKey<StoneTabletVariant> SKELETON_AND_CREEPER = FossilsLegacyStoneTabletVariants.create("skeleton_and_creeper");
    public static final ResourceKey<StoneTabletVariant> ZOMBIE_AND_SPIDER = FossilsLegacyStoneTabletVariants.create("zombie_and_spider");
    public static final ResourceKey<StoneTabletVariant> TYRANNOSAURUS_IN_ICEBERG = FossilsLegacyStoneTabletVariants.create("tyrannosaurus_in_iceberg");
    public static final ResourceKey<StoneTabletVariant> TYRANNOSAURUS_TRANSPORT = FossilsLegacyStoneTabletVariants.create("tyrannosaurus_transport");
    public static final ResourceKey<StoneTabletVariant> TYRANNOSAURUS_MELT = FossilsLegacyStoneTabletVariants.create("tyrannosaurus_melt");
    public static final ResourceKey<StoneTabletVariant> TYRANNOSAURUS_ATTACK = FossilsLegacyStoneTabletVariants.create("tyrannosaurus_attack");
    public static final ResourceKey<StoneTabletVariant> TYRANNOSAURUS_DEATH = FossilsLegacyStoneTabletVariants.create("tyrannosaurus_death");
    public static final ResourceKey<StoneTabletVariant> TYRANNOSAURUS_CORPSE = FossilsLegacyStoneTabletVariants.create("tyrannosaurus_corpse");
    public static final ResourceKey<StoneTabletVariant> PRINCESS = FossilsLegacyStoneTabletVariants.create("princess");
    public static final ResourceKey<StoneTabletVariant> MOSASAURUS = FossilsLegacyStoneTabletVariants.create("mosasaurus");
    public static final ResourceKey<StoneTabletVariant> HOLY_MOSASAURUS = FossilsLegacyStoneTabletVariants.create("holy_mosasaurus");
    public static final ResourceKey<StoneTabletVariant> PAST = FossilsLegacyStoneTabletVariants.create("past");
    public static final ResourceKey<StoneTabletVariant> TIME_MACHINE = FossilsLegacyStoneTabletVariants.create("time_machine");
    public static final ResourceKey<StoneTabletVariant> FUTURE = FossilsLegacyStoneTabletVariants.create("future");
    public static final ResourceKey<StoneTabletVariant> ANU_TOTEM = FossilsLegacyStoneTabletVariants.create("anu_totem");

    private static ResourceKey<StoneTabletVariant> create(String name) {
        return ResourceKey.create(FossilsLegacyRegistries.STONE_TABLET_VARIANTS, FossilsLegacyUtils.resource(name));
    }

    private static void register(BootstrapContext<StoneTabletVariant> bootstrapContext, ResourceKey<StoneTabletVariant> resourceKey, int width, int height) {
        bootstrapContext.register(resourceKey, new StoneTabletVariant(width, height, resourceKey.location()));
    }

    public static void bootstrap(BootstrapContext<StoneTabletVariant> bootstrapContext) {
        FossilsLegacyStoneTabletVariants.register(bootstrapContext, LIGHTING, 2, 1);
        FossilsLegacyStoneTabletVariants.register(bootstrapContext, SOCIAL, 1, 1);
        FossilsLegacyStoneTabletVariants.register(bootstrapContext, GREAT_WAR, 2, 2);
        FossilsLegacyStoneTabletVariants.register(bootstrapContext, ANU_DEATH, 2, 1);
        FossilsLegacyStoneTabletVariants.register(bootstrapContext, PORTAL, 2, 2);
        FossilsLegacyStoneTabletVariants.register(bootstrapContext, HEROBRINE, 2, 2);
        FossilsLegacyStoneTabletVariants.register(bootstrapContext, SKELETON_AND_CREEPER, 1, 1);
        FossilsLegacyStoneTabletVariants.register(bootstrapContext, ZOMBIE_AND_SPIDER, 1, 1);
        FossilsLegacyStoneTabletVariants.register(bootstrapContext, TYRANNOSAURUS_IN_ICEBERG, 2, 2);
        FossilsLegacyStoneTabletVariants.register(bootstrapContext, TYRANNOSAURUS_TRANSPORT, 2, 1);
        FossilsLegacyStoneTabletVariants.register(bootstrapContext, TYRANNOSAURUS_MELT, 2, 1);
        FossilsLegacyStoneTabletVariants.register(bootstrapContext, TYRANNOSAURUS_ATTACK, 2, 2);
        FossilsLegacyStoneTabletVariants.register(bootstrapContext, TYRANNOSAURUS_DEATH, 2, 2);
        FossilsLegacyStoneTabletVariants.register(bootstrapContext, TYRANNOSAURUS_CORPSE, 4, 2);
        FossilsLegacyStoneTabletVariants.register(bootstrapContext, PRINCESS, 2, 2);
        FossilsLegacyStoneTabletVariants.register(bootstrapContext, MOSASAURUS, 2, 1);
        FossilsLegacyStoneTabletVariants.register(bootstrapContext, HOLY_MOSASAURUS, 4, 2);
        FossilsLegacyStoneTabletVariants.register(bootstrapContext, PAST, 2, 2);
        FossilsLegacyStoneTabletVariants.register(bootstrapContext, TIME_MACHINE, 1, 2);
        FossilsLegacyStoneTabletVariants.register(bootstrapContext, FUTURE, 2, 2);
        FossilsLegacyStoneTabletVariants.register(bootstrapContext, ANU_TOTEM, 1, 2);
    }
}
