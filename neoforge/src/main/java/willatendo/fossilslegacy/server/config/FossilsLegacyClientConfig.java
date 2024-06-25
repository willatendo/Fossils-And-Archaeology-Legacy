package willatendo.fossilslegacy.server.config;

import net.neoforged.neoforge.common.ModConfigSpec;

import static willatendo.fossilslegacy.server.config.FossilsLegacyBaseConfigSettings.FEATHERED_DINOSAURUS;
import static willatendo.fossilslegacy.server.config.FossilsLegacyBaseConfigSettings.LEGACY_MODELS;

public class FossilsLegacyClientConfig {
    private final ModConfigSpec.BooleanValue featheredDinosaurs;
    private final ModConfigSpec.BooleanValue legacyModels;

    public FossilsLegacyClientConfig(ModConfigSpec.Builder builder) {
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
