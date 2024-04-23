package willatendo.fossilslegacy.server.config.forge;

import net.neoforged.neoforge.common.ModConfigSpec;

import static willatendo.fossilslegacy.server.config.FossilsLegacyBaseConfigSettings.FEATHERED_DINOSAURUS;

public class FossilsLegacyClientConfig {
    private final ModConfigSpec.BooleanValue featheredDinosaurs;

    public FossilsLegacyClientConfig(ModConfigSpec.Builder builder) {
        this.featheredDinosaurs = builder.comment("If true, some dinosaurs will have feathers").define("featheredDinosaurs", FEATHERED_DINOSAURUS);
    }

    public boolean featheredDinosaurs() {
        return this.featheredDinosaurs.get();
    }
}
