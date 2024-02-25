package willatendo.fossilsexperiments.server.item;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.ConfigHelper;

public class CoinItem extends Item {
	public CoinItem(ResourceKey<Level> level, Properties properties) {
		super(properties);
	}

	@Override
	public boolean isEnabled(FeatureFlagSet featureFlagSet) {
		return ConfigHelper.shouldEnableExperiments();
	}
}
