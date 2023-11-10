package willatendo.fossilslegacy.server;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class FossilsLegacyCommonConfig {
	private final BooleanValue animalsStarve;
	private final BooleanValue animalsBreakBlocks;
	private final BooleanValue animalsGrow;
	private final BooleanValue academiesGenerate;
	private final BooleanValue weaponShopsGenerate;
	private final BooleanValue shipwrecksGenerate;
	private final BooleanValue anuSpawns;

	public FossilsLegacyCommonConfig(ForgeConfigSpec.Builder builder) {
		this.animalsStarve = builder.comment("If true, animals will starve").define("animalsStarve", true);
		this.animalsBreakBlocks = builder.comment("If true, some animals will be able to break blocks").define("animalsBreakBlocks", true);
		this.animalsGrow = builder.comment("If true, animals will grow").define("animalsGrow", true);
		this.academiesGenerate = builder.comment("If true, academies will generate in the world").define("academiesGenerate", true);
		this.weaponShopsGenerate = builder.comment("If true, weapon shops will generate in the world").define("weaponShopsGenerate", true);
		this.shipwrecksGenerate = builder.comment("If true, shipwrecks will generate in the world").define("shipwrecksGenerate", true);
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

	public boolean shouldAcademiesGenerate() {
		return this.academiesGenerate.get();
	}

	public boolean shouldWeaponShopsGenerate() {
		return this.weaponShopsGenerate.get();
	}

	public boolean shouldShipwrecksGenerate() {
		return this.shipwrecksGenerate.get();
	}

	public boolean shouldAnuSpawn() {
		return this.anuSpawns.get();
	}
}
