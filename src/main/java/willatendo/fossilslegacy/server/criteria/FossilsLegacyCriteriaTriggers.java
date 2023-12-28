package willatendo.fossilslegacy.server.criteria;

import net.minecraft.advancements.CriteriaTriggers;

public class FossilsLegacyCriteriaTriggers {
	public static final TameZombifiedPigmanTrigger TAME_ZOMBIFIED_PIGMAN_TRIGGER = CriteriaTriggers.register("tame_zombified_pigman_trigger", new TameZombifiedPigmanTrigger());

	public static void init() {
	}
}
