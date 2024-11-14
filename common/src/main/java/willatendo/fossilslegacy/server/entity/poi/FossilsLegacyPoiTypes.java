package willatendo.fossilslegacy.server.entity.poi;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.Set;

public class FossilsLegacyPoiTypes {
    public static final SimpleRegistry<PoiType> POI_TYPES = SimpleRegistry.create(Registries.POINT_OF_INTEREST_TYPE, FossilsLegacyUtils.ID);

    public static final ResourceKey<PoiType> ARCHAEOLOGIST = FossilsLegacyPoiTypes.create("archaeologist");
    public static final ResourceKey<PoiType> PALAEONTOLOGIST = FossilsLegacyPoiTypes.create("palaeontologist");

    private static ResourceKey<PoiType> create(String id) {
        return ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, FossilsLegacyUtils.resource(id));
    }

    private static Set<BlockState> getBlockStates(Block block) {
        return ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates());
    }

    static {
        FossilsModloaderHelper.INSTANCE.registerPOI(POI_TYPES, "archaeologist", () -> new PoiType(FossilsLegacyPoiTypes.getBlockStates(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get()), 1, 1));
        FossilsModloaderHelper.INSTANCE.registerPOI(POI_TYPES, "palaeontologist", () -> new PoiType(FossilsLegacyPoiTypes.getBlockStates(FossilsLegacyBlocks.PALAEONTOLOGY_TABLE.get()), 1, 1));
    }
}