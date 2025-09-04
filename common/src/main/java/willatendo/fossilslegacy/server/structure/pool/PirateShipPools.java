package willatendo.fossilslegacy.server.structure.pool;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import willatendo.fossilslegacy.server.structure.FAPools;

public class PirateShipPools {
    public static final ResourceKey<StructureTemplatePool> START = FAPools.createKey("pirate_ship/starts");

    public static void bootstrap(BootstrapContext<StructureTemplatePool> bootstrapContext) {
        HolderGetter<StructureTemplatePool> structureTemplatePoolHolderGetter = bootstrapContext.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> empty = structureTemplatePoolHolderGetter.getOrThrow(Pools.EMPTY);
        bootstrapContext.register(START, new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FAPools.legacy("pirate_ship/pirate_ship_middle"), 1)), StructureTemplatePool.Projection.RIGID));
        FAPools.register(bootstrapContext, "pirate_ship/front", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FAPools.legacy("pirate_ship/pirate_ship_front"), 1)), StructureTemplatePool.Projection.RIGID));
        FAPools.register(bootstrapContext, "pirate_ship/back", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FAPools.legacy("pirate_ship/pirate_ship_back"), 1)), StructureTemplatePool.Projection.RIGID));
        FAPools.register(bootstrapContext, "pirate_ship/mobs/drowned_pirate", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FAPools.legacy("pirate_ship/pirate_ship_drowned_pirate"), 1)), StructureTemplatePool.Projection.RIGID));
        FAPools.register(bootstrapContext, "pirate_ship/mobs/drowned_pirate_captain", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FAPools.legacy("pirate_ship/pirate_ship_drowned_pirate_captain"), 1)), StructureTemplatePool.Projection.RIGID));
    }
}

