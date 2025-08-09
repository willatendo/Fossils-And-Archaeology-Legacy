package willatendo.fossilslegacy.server.feature;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import willatendo.fossilslegacy.server.feature.configurations.CycadConfiguration;
import willatendo.fossilslegacy.server.feature.features.CycadFeature;
import willatendo.fossilslegacy.server.feature.features.FASimpleBlockFeature;
import willatendo.fossilslegacy.server.feature.features.JurassicFernFeature;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FAFeatures {
    public static final SimpleRegistry<Feature<?>> FEATURES = SimpleRegistry.create(Registries.FEATURE, FAUtils.ID);

    public static final SimpleHolder<CycadFeature> CYCAD = FEATURES.register("cycad", () -> new CycadFeature(CycadConfiguration.CODEC));
    public static final SimpleHolder<FASimpleBlockFeature> FA_SIMPLE_BLOCK = FEATURES.register("simple_block", () -> new FASimpleBlockFeature(SimpleBlockConfiguration.CODEC));
    public static final SimpleHolder<JurassicFernFeature> JURASSIC_FERN = FEATURES.register("jurassic_fern", () -> new JurassicFernFeature(NoneFeatureConfiguration.CODEC));
}
