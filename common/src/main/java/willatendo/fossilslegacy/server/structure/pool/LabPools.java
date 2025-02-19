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

public class LabPools {
    public static final ResourceKey<StructureTemplatePool> START = FAPools.createKey("lab/starts");

    public static void bootstrap(BootstrapContext<StructureTemplatePool> bootstrapContext) {
        HolderGetter<StructureTemplatePool> structureTemplatePoolHolderGetter = bootstrapContext.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> empty = structureTemplatePoolHolderGetter.getOrThrow(Pools.EMPTY);
        bootstrapContext.register(START, new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FAPools.legacy("lab/lab"), 1)), StructureTemplatePool.Projection.RIGID));
        FAPools.register(bootstrapContext, "lab/decoration", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FAPools.legacy("lab/equipment/analyzer"), 25), Pair.of(FAPools.legacy("lab/equipment/cultivator"), 25), Pair.of(FAPools.legacy("lab/equipment/broken_cultivator"), 10), Pair.of(FAPools.legacy("lab/equipment/test_tube"), 25)), StructureTemplatePool.Projection.RIGID));
    }
}
