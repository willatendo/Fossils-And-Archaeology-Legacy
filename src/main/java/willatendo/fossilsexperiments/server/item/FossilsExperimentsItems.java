package willatendo.fossilsexperiments.server.item;

import java.util.function.Supplier;

import com.google.common.base.Function;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import willatendo.fossilsexperiments.flags.FossilsLegacyFeatureFlags;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.simplelibrary.server.flag.FlagItemProperties;
import willatendo.simplelibrary.server.registry.SimpleHolder;

public class FossilsExperimentsItems {
	public static final SimpleHolder<CoinItem> OVERWORLD_COIN = register("overworld_coin", properties -> () -> new CoinItem(Level.OVERWORLD, properties));

	public static <T extends Item> SimpleHolder<T> register(String id, Function<Properties, Supplier<T>> item) {
		Properties properties = new FlagItemProperties().requiredFeatures(FossilsLegacyFeatureFlags.REGISTRY, FossilsLegacyFeatureFlags.FOSSIL_EXPERIMENTS);
		return FossilsLegacyItems.ITEMS.register(id, item.apply(properties));
	}

	public static void init() {
	}
}
