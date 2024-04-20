package willatendo.fossilslegacy.server.config;

import net.minecraftforge.common.ForgeConfigSpec;

import static willatendo.fossilslegacy.server.config.FossilsLegacyBaseConfigSettings.*;

public class FossilsLegacyCommonConfig {
    private final ForgeConfigSpec.BooleanValue animalsStarve;
    private final ForgeConfigSpec.BooleanValue animalsBreakBlocks;
    private final ForgeConfigSpec.BooleanValue animalsGrow;
    private final ForgeConfigSpec.BooleanValue anuSpawns;

    public FossilsLegacyCommonConfig(ForgeConfigSpec.Builder builder) {
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
