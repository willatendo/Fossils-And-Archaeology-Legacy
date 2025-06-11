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
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import willatendo.fossilslegacy.server.structure.FAPools;
import willatendo.fossilslegacy.server.structure.FAProcessorLists;

public class MoaiPools {
    public static final ResourceKey<StructureTemplatePool> START = FAPools.createKey("moai/starts");

    public static void bootstrap(BootstrapContext<StructureTemplatePool> bootstrapContext) {
        HolderGetter<StructureTemplatePool> structureTemplatePoolHolderGetter = bootstrapContext.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> structureProcessorListHolderGetter = bootstrapContext.lookup(Registries.PROCESSOR_LIST);
        Holder<StructureTemplatePool> empty = structureTemplatePoolHolderGetter.getOrThrow(Pools.EMPTY);
        Holder<StructureProcessorList> moaiDegradation = structureProcessorListHolderGetter.getOrThrow(FAProcessorLists.MOAI_DEGRADATION);
        bootstrapContext.register(START, new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FAPools.legacy("moai/moai_body", moaiDegradation), 1), Pair.of(FAPools.legacy("moai/moai_head", moaiDegradation), 1)), StructureTemplatePool.Projection.RIGID));
        FAPools.register(bootstrapContext, "moai/head", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FAPools.legacy("moai/moai_head_on_body", moaiDegradation), 1)), StructureTemplatePool.Projection.RIGID));
    }
}
