package willatendo.fossilslegacy.server.config;

import net.minecraftforge.common.ForgeConfigSpec;

import static willatendo.fossilslegacy.server.config.FossilsLegacyBaseConfigSettings.FEATHERED_DINOSAURUS;
import static willatendo.fossilslegacy.server.config.FossilsLegacyBaseConfigSettings.LEGACY_MODELS;

public class FossilsLegacyClientConfig {
    private final ForgeConfigSpec.BooleanValue featheredDinosaurs;
    private final ForgeConfigSpec.BooleanValue legacyModels;

    public FossilsLegacyClientConfig(ForgeConfigSpec.Builder builder) {
        this.featheredDinosaurs = builder.comment("If true, some dinosaurs will have feathers").define("featheredDinosaurs", FEATHERED_DINOSAURUS);
        this.legacyModels = builder.comment("If true, where applicable, legacy models will be used").define("legacyModels", LEGACY_MODELS);
    }

    public boolean featheredDinosaurs() {
        return this.featheredDinosaurs.get();
    }

    public boolean legacyModels() {
        return this.legacyModels.get();
    }
}
