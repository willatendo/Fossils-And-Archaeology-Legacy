package willatendo.fossilslegacy.server.config;

import net.minecraftforge.common.ForgeConfigSpec;

import static willatendo.fossilslegacy.server.config.FossilsLegacyBaseConfigSettings.FEATHERED_DINOSAURUS;

public class FossilsLegacyClientConfig {
    private final ForgeConfigSpec.BooleanValue featheredDinosaurs;

    public FossilsLegacyClientConfig(ForgeConfigSpec.Builder builder) {
        this.featheredDinosaurs = builder.comment("If true, some dinosaurs will have feathers").define("featheredDinosaurs", FEATHERED_DINOSAURUS);
    }

    public boolean featheredDinosaurs() {
        return this.featheredDinosaurs.get();
    }
}
