package willatendo.fossilslegacy.server.structure.pool;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.LegacySinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.function.Function;

public class FossilsLegacyPools {
    public static ResourceKey<StructureTemplatePool> createKey(String id) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, FossilsLegacyUtils.resource(id));
    }

    public static Function<StructureTemplatePool.Projection, LegacySinglePoolElement> legacy(String id) {
        return StructurePoolElement.legacy(FossilsLegacyUtils.ID + ":" + id);
    }

    public static Function<StructureTemplatePool.Projection, LegacySinglePoolElement> legacy(String id, Holder<StructureProcessorList> structureProcessorListHolder) {
        return StructurePoolElement.legacy(FossilsLegacyUtils.ID + ":" + id, structureProcessorListHolder);
    }

    public static void register(BootstrapContext<StructureTemplatePool> bootstrapContext, String id, StructureTemplatePool structureTemplatePool) {
        bootstrapContext.register(FossilsLegacyPools.createKey(id), structureTemplatePool);
    }

    public static void bootstrap(BootstrapContext<StructureTemplatePool> bootstrapContext) {
        AcademyPools.bootstrap(bootstrapContext);
    }
}
