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

public class TotemPolePools {
    public static final ResourceKey<StructureTemplatePool> START = FossilsLegacyPools.createKey("totem_pole/starts");

    public static void bootstrap(BootstrapContext<StructureTemplatePool> bootstrapContext) {
        HolderGetter<StructureTemplatePool> structureTemplatePoolHolderGetter = bootstrapContext.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> empty = structureTemplatePoolHolderGetter.getOrThrow(Pools.EMPTY);
        bootstrapContext.register(START, new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FossilsLegacyPools.legacy("totem_pole/base/jungle_totem_pole_base"), 1), Pair.of(FossilsLegacyPools.legacy("totem_pole/base/oak_totem_pole_base"), 1), Pair.of(FossilsLegacyPools.legacy("totem_pole/base/spruce_totem_pole_base"), 1)), StructureTemplatePool.Projection.RIGID));
        FossilsLegacyPools.register(bootstrapContext, "totem_pole/layer", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FossilsLegacyPools.legacy("totem_pole/layer/dark_oak_totem_pole_layer"), 25), Pair.of(FossilsLegacyPools.legacy("totem_pole/layer/dark_oak_totem_pole_layer_cap"), 50), Pair.of(FossilsLegacyPools.legacy("totem_pole/layer/oak_totem_pole_layer"), 25), Pair.of(FossilsLegacyPools.legacy("totem_pole/layer/oak_totem_pole_layer_cap"), 50), Pair.of(FossilsLegacyPools.legacy("totem_pole/layer/spruce_totem_pole_layer"), 25), Pair.of(FossilsLegacyPools.legacy("totem_pole/layer/spruce_totem_pole_layer_cap"), 50)), StructureTemplatePool.Projection.RIGID));
        FossilsLegacyPools.register(bootstrapContext, "totem_pole/penultimate", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FossilsLegacyPools.legacy("totem_pole/penultimate/birch_totem_pole_centerpiece"), 50), Pair.of(FossilsLegacyPools.legacy("totem_pole/penultimate/oak_totem_pole_centerpiece"), 50), Pair.of(FossilsLegacyPools.legacy("totem_pole/penultimate/spruce_totem_pole_centerpiece"), 50)), StructureTemplatePool.Projection.RIGID));
        FossilsLegacyPools.register(bootstrapContext, "totem_pole/head/birch", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FossilsLegacyPools.legacy("totem_pole/head/birch_totem_pole_head"), 50)), StructureTemplatePool.Projection.RIGID));
        FossilsLegacyPools.register(bootstrapContext, "totem_pole/head/oak", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FossilsLegacyPools.legacy("totem_pole/head/oak_totem_pole_head"), 50)), StructureTemplatePool.Projection.RIGID));
        FossilsLegacyPools.register(bootstrapContext, "totem_pole/head/spruce", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FossilsLegacyPools.legacy("totem_pole/head/spruce_totem_pole_head"), 50)), StructureTemplatePool.Projection.RIGID));
    }
}
