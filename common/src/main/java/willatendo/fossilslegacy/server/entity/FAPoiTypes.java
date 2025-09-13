package willatendo.fossilslegacy.server.entity;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.platform.FAModloaderHelper;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.Set;

public final class FAPoiTypes {
    public static final SimpleRegistry<PoiType> POI_TYPES = SimpleRegistry.create(Registries.POINT_OF_INTEREST_TYPE, FAUtils.ID);

    public static final ResourceKey<PoiType> ARCHAEOLOGIST = FAPoiTypes.create("archaeologist");
    public static final ResourceKey<PoiType> PALAEONTOLOGIST = FAPoiTypes.create("palaeontologist");
    public static final ResourceKey<PoiType> GENETICIST = FAPoiTypes.create("geneticist");

    private static ResourceKey<PoiType> create(String id) {
        return ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, FAUtils.resource(id));
    }

    private static Set<BlockState> getBlockStates(Block block) {
        return ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates());
    }

    static {
        FAModloaderHelper.INSTANCE.registerPOI(POI_TYPES, "archaeologist", () -> new PoiType(FAPoiTypes.getBlockStates(FABlocks.ARCHAEOLOGY_WORKBENCH.get()), 1, 1));
        FAModloaderHelper.INSTANCE.registerPOI(POI_TYPES, "palaeontologist", () -> new PoiType(FAPoiTypes.getBlockStates(FABlocks.PALAEONTOLOGY_TABLE.get()), 1, 1));
        FAModloaderHelper.INSTANCE.registerPOI(POI_TYPES, "geneticist", () -> new PoiType(FAPoiTypes.getBlockStates(FABlocks.DNA_RECOMBINATOR.get()), 1, 1));
    }
}
