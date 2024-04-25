package willatendo.fossilslegacy.experiments.server.item;

import net.minecraft.world.flag.FeatureFlagSet;
import willatendo.fossilslegacy.server.ConfigHelper;
import willatendo.fossilslegacy.server.entity.EggVariant;
import willatendo.fossilslegacy.server.item.EggItem;

import java.util.function.Supplier;

public class ExperimentalEggItem extends EggItem {
    public ExperimentalEggItem(Supplier<EggVariant> eggVariant, Properties properties) {
        super(eggVariant, properties);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet featureFlagSet) {
        return ConfigHelper.shouldEnableExperiments();
    }
}
