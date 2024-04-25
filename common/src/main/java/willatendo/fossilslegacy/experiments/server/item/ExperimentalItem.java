package willatendo.fossilslegacy.experiments.server.item;

import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import willatendo.fossilslegacy.server.ConfigHelper;

public class ExperimentalItem extends Item {
    public ExperimentalItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet featureFlagSet) {
        return ConfigHelper.shouldEnableExperiments();
    }
}
