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

public class MachuPicchuPools {
    public static final ResourceKey<StructureTemplatePool> START = FAPools.createKey("machu_picchu/starts");

    public static void bootstrap(BootstrapContext<StructureTemplatePool> bootstrapContext) {
        HolderGetter<StructureTemplatePool> structureTemplatePoolHolderGetter = bootstrapContext.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> structureProcessorListHolderGetter = bootstrapContext.lookup(Registries.PROCESSOR_LIST);
        Holder<StructureTemplatePool> empty = structureTemplatePoolHolderGetter.getOrThrow(Pools.EMPTY);
        Holder<StructureProcessorList> machuPicchuHouseDegradation = structureProcessorListHolderGetter.getOrThrow(FAProcessorLists.MACHU_PICCHU_HOUSE_DEGRADATION);
        Holder<StructureProcessorList> machuPicchuRoadDegradation = structureProcessorListHolderGetter.getOrThrow(FAProcessorLists.MACHU_PICCHU_ROAD);
        bootstrapContext.register(START, new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FAPools.legacy("machu_picchu/start", machuPicchuHouseDegradation), 1)), StructureTemplatePool.Projection.RIGID));
        FAPools.register(bootstrapContext, "machu_picchu/decoration", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FAPools.legacy("machu_picchu/house/basic_house", machuPicchuHouseDegradation), 1), Pair.of(FAPools.legacy("machu_picchu/house/thatch_house", machuPicchuHouseDegradation), 1), Pair.of(FAPools.legacy("machu_picchu/wall", machuPicchuHouseDegradation), 1)), StructureTemplatePool.Projection.RIGID));
        FAPools.register(bootstrapContext, "machu_picchu/wall", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FAPools.legacy("machu_picchu/wall", machuPicchuHouseDegradation), 1)), StructureTemplatePool.Projection.TERRAIN_MATCHING));
        FAPools.register(bootstrapContext, "machu_picchu/house", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FAPools.legacy("machu_picchu/house/basic_house", machuPicchuHouseDegradation), 1), Pair.of(FAPools.legacy("machu_picchu/house/thatch_house", machuPicchuHouseDegradation), 1)), StructureTemplatePool.Projection.RIGID));
        FAPools.register(bootstrapContext, "machu_picchu/path", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FAPools.legacy("machu_picchu/road/road", machuPicchuRoadDegradation), 10), Pair.of(FAPools.legacy("machu_picchu/road/road_end", machuPicchuRoadDegradation), 5), Pair.of(FAPools.legacy("machu_picchu/road/cross", machuPicchuRoadDegradation), 1), Pair.of(FAPools.legacy("machu_picchu/road/split_road", machuPicchuRoadDegradation), 3), Pair.of(FAPools.legacy("machu_picchu/road/road_turn", machuPicchuRoadDegradation), 3)), StructureTemplatePool.Projection.TERRAIN_MATCHING));
    }
}
