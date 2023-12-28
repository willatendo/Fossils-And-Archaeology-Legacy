package willatendo.fossilslegacy;

import willatendo.simplelibrary.server.config.SimpleConfig;

public class FossilsLegacyConfig {
	private static final boolean animalsStarve;
	private static final boolean animalsBreakBlocks;
	private static final boolean animalsGrow;
	private static final boolean academiesGenerate;
	private static final boolean weaponShopsGenerate;
	private static final boolean shipwrecksGenerate;
	private static final boolean anuSpawns;
	public static final SimpleConfig SIMPLE_CONFIG = new SimpleConfig("fossils_legacy");

	public static void init() {
	}

	static {
		SIMPLE_CONFIG.saveBooleanValue("animals_starve", true);
		SIMPLE_CONFIG.saveBooleanValue("animals_break_blocks", true);
		SIMPLE_CONFIG.saveBooleanValue("animals_grow", true);
		SIMPLE_CONFIG.saveBooleanValue("academies_generate", true);
		SIMPLE_CONFIG.saveBooleanValue("weapon_shops_generate", true);
		SIMPLE_CONFIG.saveBooleanValue("shipwrecks_generate", true);
		SIMPLE_CONFIG.saveBooleanValue("anu_spawns", true);

		animalsStarve = SIMPLE_CONFIG.getBooleanValue("animals_starve");
		animalsBreakBlocks = SIMPLE_CONFIG.getBooleanValue("animals_break_blocks");
		animalsGrow = SIMPLE_CONFIG.getBooleanValue("animals_grow");
		academiesGenerate = SIMPLE_CONFIG.getBooleanValue("academies_generate");
		weaponShopsGenerate = SIMPLE_CONFIG.getBooleanValue("weapon_shops_generate");
		shipwrecksGenerate = SIMPLE_CONFIG.getBooleanValue("shipwrecks_generate");
		anuSpawns = SIMPLE_CONFIG.getBooleanValue("anu_spawns");
	}

	public static boolean willAnimalsStarve() {
		return animalsStarve;
	}

	public static boolean willAnimalsBreakBlocks() {
		return animalsBreakBlocks;
	}

	public static boolean willAnimalsGrow() {
		return animalsGrow;
	}

	public static boolean shouldAcademiesGenerate() {
		return academiesGenerate;
	}

	public static boolean shouldWeaponShopsGenerate() {
		return weaponShopsGenerate;
	}

	public static boolean shouldShipwrecksGenerate() {
		return shipwrecksGenerate;
	}

	public static boolean shouldAnuSpawn() {
		return anuSpawns;
	}
}
