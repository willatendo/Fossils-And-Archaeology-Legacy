package willatendo.fossilslegacy.server.entity;

import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.entity.variants.BoatType;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.List;

public class FossilsLegacyBoatTypes {
    public static final SimpleRegistry<BoatType> BOAT_TYPES = SimpleRegistry.create(FossilsLegacyRegistries.BOAT_TYPES, FossilsLegacyUtils.ID);

    public static final SimpleHolder<BoatType> LEPIDODENDRON = BOAT_TYPES.register("lepidodendron", () -> new BoatType("lepidodendron", FossilsLegacyItems.LEPIDODENDRON_BOAT, FossilsLegacyItems.LEPIDODENDRON_CHEST_BOAT, FossilsLegacyBlocks.LEPIDODENDRON_PLANKS));

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(BOAT_TYPES);
    }
}
