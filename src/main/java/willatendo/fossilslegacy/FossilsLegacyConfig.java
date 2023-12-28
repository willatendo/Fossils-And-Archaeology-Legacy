package willatendo.fossilslegacy;

public class FossilsLegacyConfig {
	private static boolean animalsStarve = true;
	private static boolean animalsBreakBlocks = true;
	private static boolean animalsGrow = true;
	private static boolean academiesGenerate = true;
	private static boolean weaponShopsGenerate = true;
	private static boolean shipwrecksGenerate = true;
	private static boolean anuSpawns = true;
//	public static final SimpleConfig SIMPLE_CONFIG = new SimpleConfig("fossils_legacy");

//	public static void init() {
//		SIMPLE_CONFIG.saveBooleanValue("animalsstarve", true);
//		SIMPLE_CONFIG.saveBooleanValue("animalsbreakblocks", true);
//		SIMPLE_CONFIG.saveBooleanValue("animalsgrow", true);
//		SIMPLE_CONFIG.saveBooleanValue("academiesgenerate", true);
//		SIMPLE_CONFIG.saveBooleanValue("weaponshopsgenerate", true);
//		SIMPLE_CONFIG.saveBooleanValue("shipwrecksgenerate", true);
//		SIMPLE_CONFIG.saveBooleanValue("anuspawns", true);
//
//		SIMPLE_CONFIG.loadConfig();
//	}
//
//	static {
//		animalsStarve = SIMPLE_CONFIG.getBooleanValue("animalsstarve");
//		animalsBreakBlocks = SIMPLE_CONFIG.getBooleanValue("animalsbreakblocks");
//		animalsGrow = SIMPLE_CONFIG.getBooleanValue("animalsgrow");
//		academiesGenerate = SIMPLE_CONFIG.getBooleanValue("academiesgenerate");
//		weaponShopsGenerate = SIMPLE_CONFIG.getBooleanValue("weaponshopsgenerate");
//		shipwrecksGenerate = SIMPLE_CONFIG.getBooleanValue("shipwrecksgenerate");
//		anuSpawns = SIMPLE_CONFIG.getBooleanValue("anuspawns");
//	}

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
