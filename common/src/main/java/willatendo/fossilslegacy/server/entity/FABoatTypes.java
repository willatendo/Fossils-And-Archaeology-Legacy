package willatendo.fossilslegacy.server.entity;

import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.SimpleRegistries;
import willatendo.simplelibrary.server.entity.variant.BoatType;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FABoatTypes {
    public static final SimpleRegistry<BoatType> BOAT_TYPES = SimpleRegistry.create(SimpleRegistries.BOAT_TYPES, FossilsLegacyUtils.ID);

    public static final SimpleHolder<BoatType> CALAMITES = BOAT_TYPES.register("calamites", () -> new BoatType("calamites", FAItems.CALAMITES_BOAT, FAItems.CALAMITES_CHEST_BOAT, FABlocks.CALAMITES_PLANKS));
    public static final SimpleHolder<BoatType> LEPIDODENDRON = BOAT_TYPES.register("lepidodendron", () -> new BoatType("lepidodendron", FAItems.LEPIDODENDRON_BOAT, FAItems.LEPIDODENDRON_CHEST_BOAT, FABlocks.LEPIDODENDRON_PLANKS));
    public static final SimpleHolder<BoatType> SIGILLARIA = BOAT_TYPES.register("sigillaria", () -> new BoatType("sigillaria", FAItems.SIGILLARIA_BOAT, FAItems.SIGILLARIA_CHEST_BOAT, FABlocks.SIGILLARIA_PLANKS));
}
