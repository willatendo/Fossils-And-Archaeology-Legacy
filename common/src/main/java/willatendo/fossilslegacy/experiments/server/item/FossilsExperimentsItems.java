package willatendo.fossilslegacy.experiments.server.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.experiments.server.block.FossilsExperimentsBlocks;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.simplelibrary.server.registry.SimpleHolder;

public class FossilsExperimentsItems {
	public static final SimpleHolder<CoinItem> OVERWORLD_COIN = FossilsLegacyItems.ITEMS.register("overworld_coin", () -> new CoinItem(Level.OVERWORLD, new Item.Properties()));
	public static final SimpleHolder<CoinItem> NETHER_COIN = FossilsLegacyItems.ITEMS.register("nether_coin", () -> new CoinItem(Level.NETHER, new Item.Properties()));
	public static final SimpleHolder<CoinItem> PREHISTORIC_COIN = FossilsLegacyItems.ITEMS.register("prehistoric_coin", () -> new CoinItem(Level.OVERWORLD, new Item.Properties()));

	public static void init() {
		FossilsLegacyItems.ITEMS.register("time_machine", () -> new ExperimentalBlockItem(FossilsExperimentsBlocks.TIME_MACHINE.get(), new Item.Properties().fireResistant()));
	}
}
