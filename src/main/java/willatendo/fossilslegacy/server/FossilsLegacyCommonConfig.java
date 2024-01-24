package willatendo.fossilslegacy.server;

import willatendo.simplelibrary.config.ModConfigSpec;
import willatendo.simplelibrary.config.ModConfigSpec.BooleanValue;

public class FossilsLegacyCommonConfig {
	private final BooleanValue animalsStarve;
	private final BooleanValue animalsBreakBlocks;
	private final BooleanValue animalsGrow;
	private final BooleanValue anuSpawns;

	public FossilsLegacyCommonConfig(ModConfigSpec.Builder builder) {
		this.animalsStarve = builder.comment("If true, animals will starve").define("animalsStarve", true);
		this.animalsBreakBlocks = builder.comment("If true, some animals will be able to break blocks").define("animalsBreakBlocks", true);
		this.animalsGrow = builder.comment("If true, animals will grow").define("animalsGrow", true);
		this.anuSpawns = builder.comment("If true, anu will spawn once in the nether").define("anuSpawns", true);
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
