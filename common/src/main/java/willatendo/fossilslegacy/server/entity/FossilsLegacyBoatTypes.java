package willatendo.fossilslegacy.server.entity;

import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.SimpleRegistries;
import willatendo.simplelibrary.server.entity.variant.BoatType;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyBoatTypes {
    public static final SimpleRegistry<BoatType> BOAT_TYPES = SimpleRegistry.create(SimpleRegistries.BOAT_TYPES, FossilsLegacyUtils.ID);

    public static final SimpleHolder<BoatType> CALAMITES = BOAT_TYPES.register("calamites", () -> new BoatType("calamites", FossilsLegacyItems.CALAMITES_BOAT, FossilsLegacyItems.CALAMITES_CHEST_BOAT, FossilsLegacyBlocks.CALAMITES_PLANKS));
    public static final SimpleHolder<BoatType> LEPIDODENDRON = BOAT_TYPES.register("lepidodendron", () -> new BoatType("lepidodendron", FossilsLegacyItems.LEPIDODENDRON_BOAT, FossilsLegacyItems.LEPIDODENDRON_CHEST_BOAT, FossilsLegacyBlocks.LEPIDODENDRON_PLANKS));
    public static final SimpleHolder<BoatType> SIGILLARIA = BOAT_TYPES.register("sigillaria", () -> new BoatType("sigillaria", FossilsLegacyItems.SIGILLARIA_BOAT, FossilsLegacyItems.SIGILLARIA_CHEST_BOAT, FossilsLegacyBlocks.SIGILLARIA_PLANKS));
}
