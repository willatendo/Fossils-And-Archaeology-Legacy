package willatendo.fossilslegacy.server.structure.pool;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyPools {
    public static ResourceKey<StructureTemplatePool> createKey(String id) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, FossilsLegacyUtils.resource(id));
    }

    public static void register(BootstrapContext<StructureTemplatePool> bootstrapContext, String id, StructureTemplatePool structureTemplatePool) {
        bootstrapContext.register(FossilsLegacyPools.createKey(id), structureTemplatePool);
    }

    public static void bootstrap(BootstrapContext<StructureTemplatePool> bootstrapContext) {

    }
}
