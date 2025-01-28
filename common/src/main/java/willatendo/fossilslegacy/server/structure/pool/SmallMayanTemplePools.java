package willatendo.fossilslegacy.server.structure.pool;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import willatendo.fossilslegacy.server.structure.FAPools;
import willatendo.fossilslegacy.server.structure.FAProcessorLists;

public class SmallMayanTemplePools {
    public static final ResourceKey<StructureTemplatePool> START = FAPools.createKey("small_mayan_temple/starts");

    public static void bootstrap(BootstrapContext<StructureTemplatePool> bootstrapContext) {
        HolderGetter<StructureTemplatePool> structureTemplatePoolHolderGetter = bootstrapContext.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> structureProcessorListHolderGetter = bootstrapContext.lookup(Registries.PROCESSOR_LIST);
        Holder<StructureTemplatePool> empty = structureTemplatePoolHolderGetter.getOrThrow(Pools.EMPTY);
        Holder<StructureProcessorList> mayanTempleDegradation = structureProcessorListHolderGetter.getOrThrow(FAProcessorLists.MAYAN_TEMPLE_DEGRADATION);
        bootstrapContext.register(START, new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FAPools.legacy("small_mayan_temple/small_mayan_temple", mayanTempleDegradation), 1)), StructureTemplatePool.Projection.RIGID));
        FAPools.register(bootstrapContext, "small_mayan_temple/loot", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(StructurePoolElement.empty(), 10), Pair.of(FAPools.legacy("small_mayan_temple/loot/small_mayan_loot_vase_blank"), 7), Pair.of(FAPools.legacy("small_mayan_temple/loot/small_mayan_loot_vase_jade"), 7), Pair.of(FAPools.legacy("small_mayan_temple/loot/small_mayan_loot_vase_ocelot"), 7), Pair.of(FAPools.legacy("small_mayan_temple/loot/small_mayan_loot_vase_villager"), 7)), StructureTemplatePool.Projection.RIGID));
    }
}
