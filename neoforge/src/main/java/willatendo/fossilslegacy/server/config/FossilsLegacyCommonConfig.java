package willatendo.fossilslegacy.server.config;

import net.neoforged.neoforge.common.ModConfigSpec;

import static willatendo.fossilslegacy.server.config.FossilsLegacyBaseConfigSettings.*;

public class FossilsLegacyCommonConfig {
    private final ModConfigSpec.BooleanValue animalsStarve;
    private final ModConfigSpec.BooleanValue animalsBreakBlocks;
    private final ModConfigSpec.BooleanValue animalsGrow;
    private final ModConfigSpec.BooleanValue anuSpawns;

    public FossilsLegacyCommonConfig(ModConfigSpec.Builder builder) {
        this.animalsStarve = builder.comment("If true, animals will starve").define("animalsStarve", WILL_ANIMALS_STARVE);
        this.animalsBreakBlocks = builder.comment("If true, some animals will be able to break blocks").define("animalsBreakBlocks", WILL_ANIMALS_BREAK_BLOCKS);
        this.animalsGrow = builder.comment("If true, animals will grow").define("animalsGrow", WILL_ANIMALS_GROW);
        this.anuSpawns = builder.comment("If true, anu will spawn once in the nether").define("anuSpawns", SHOULD_ANU_SPAWN);
    }

    public boolean willAnimalsStarve() {
        return this.animalsStarve.get();
    }

    public boolean willAnimalsBreakBlocks() {
        return this.animalsBreakBlocks.get();
    }

    public boolean willAnimalsGrow() {
        return this.animalsGrow.get();
    }

    public boolean shouldAnuSpawn() {
        return this.anuSpawns.get();
    }
}
