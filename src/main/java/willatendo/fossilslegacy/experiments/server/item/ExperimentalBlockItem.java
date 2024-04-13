package willatendo.fossilslegacy.experiments.server.item;

import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.server.ConfigHelper;

public class ExperimentalBlockItem extends BlockItem {
	public ExperimentalBlockItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Override
	public boolean isEnabled(FeatureFlagSet featureFlagSet) {
		return ConfigHelper.shouldEnableExperiments();
	}
}
