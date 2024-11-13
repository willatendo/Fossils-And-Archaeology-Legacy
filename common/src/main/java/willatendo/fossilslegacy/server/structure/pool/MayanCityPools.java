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
import willatendo.fossilslegacy.server.structure.processor.FossilsLegacyProcessorLists;

public class MayanCityPools {
    public static final ResourceKey<StructureTemplatePool> START = FossilsLegacyPools.createKey("mayan_city/starts");

    public static void bootstrap(BootstrapContext<StructureTemplatePool> bootstrapContext) {
        HolderGetter<StructureTemplatePool> structureTemplatePoolHolderGetter = bootstrapContext.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> structureProcessorListHolderGetter = bootstrapContext.lookup(Registries.PROCESSOR_LIST);
        Holder<StructureTemplatePool> empty = structureTemplatePoolHolderGetter.getOrThrow(Pools.EMPTY);
        Holder<StructureProcessorList> mayanTempleDegradation = structureProcessorListHolderGetter.getOrThrow(FossilsLegacyProcessorLists.MAYAN_TEMPLE_DEGRADATION);
        bootstrapContext.register(START, new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FossilsLegacyPools.legacy("mayan_city/city_center/city_center_layer_1", mayanTempleDegradation), 1)), StructureTemplatePool.Projection.RIGID));
        FossilsLegacyPools.register(bootstrapContext, "mayan_city/layer_2", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FossilsLegacyPools.legacy("mayan_city/city_center/city_center_layer_2", mayanTempleDegradation), 1)), StructureTemplatePool.Projection.RIGID));
        FossilsLegacyPools.register(bootstrapContext, "mayan_city/layer_3", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FossilsLegacyPools.legacy("mayan_city/city_center/city_center_layer_3", mayanTempleDegradation), 1)), StructureTemplatePool.Projection.RIGID));
        FossilsLegacyPools.register(bootstrapContext, "mayan_city/layer_4", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FossilsLegacyPools.legacy("mayan_city/city_center/city_center_layer_4", mayanTempleDegradation), 1)), StructureTemplatePool.Projection.RIGID));
        FossilsLegacyPools.register(bootstrapContext, "mayan_city/staircase_base", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FossilsLegacyPools.legacy("mayan_city/city_center/staircase/city_center_staircase_1", mayanTempleDegradation), 1)), StructureTemplatePool.Projection.RIGID));
        FossilsLegacyPools.register(bootstrapContext, "mayan_city/staircase_2", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FossilsLegacyPools.legacy("mayan_city/city_center/staircase/city_center_staircase_2", mayanTempleDegradation), 1)), StructureTemplatePool.Projection.RIGID));
        FossilsLegacyPools.register(bootstrapContext, "mayan_city/staircase_3", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FossilsLegacyPools.legacy("mayan_city/city_center/staircase/city_center_staircase_3", mayanTempleDegradation), 1)), StructureTemplatePool.Projection.RIGID));
        FossilsLegacyPools.register(bootstrapContext, "mayan_city/roads", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(FossilsLegacyPools.legacy("mayan_city/road/road_end", mayanTempleDegradation), 5), Pair.of(FossilsLegacyPools.legacy("mayan_city/road/road", mayanTempleDegradation), 5), Pair.of(FossilsLegacyPools.legacy("mayan_city/road/cross", mayanTempleDegradation), 1), Pair.of(FossilsLegacyPools.legacy("mayan_city/road/split_road", mayanTempleDegradation), 2), Pair.of(FossilsLegacyPools.legacy("mayan_city/road/long_road", mayanTempleDegradation), 5)), StructureTemplatePool.Projection.TERRAIN_MATCHING));
        FossilsLegacyPools.register(bootstrapContext, "mayan_city/houses", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(StructurePoolElement.empty(), 10), Pair.of(FossilsLegacyPools.legacy("mayan_city/house/large_house", mayanTempleDegradation), 2), Pair.of(FossilsLegacyPools.legacy("mayan_city/house/medium_house", mayanTempleDegradation), 5), Pair.of(FossilsLegacyPools.legacy("mayan_city/house/small_house", mayanTempleDegradation), 3)), StructureTemplatePool.Projection.RIGID));
        FossilsLegacyPools.register(bootstrapContext, "mayan_city/buildings", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(StructurePoolElement.empty(), 10), Pair.of(FossilsLegacyPools.legacy("mayan_city/building/pillars", mayanTempleDegradation), 5), Pair.of(FossilsLegacyPools.legacy("mayan_city/building/sport_arena", mayanTempleDegradation), 1)), StructureTemplatePool.Projection.RIGID));
        FossilsLegacyPools.register(bootstrapContext, "mayan_city/treasure", new StructureTemplatePool(empty, ImmutableList.of(Pair.of(StructurePoolElement.empty(), 4), Pair.of(FossilsLegacyPools.legacy("mayan_city/mayan_city_treasure_pot"), 50)), StructureTemplatePool.Projection.RIGID));
    }
}
