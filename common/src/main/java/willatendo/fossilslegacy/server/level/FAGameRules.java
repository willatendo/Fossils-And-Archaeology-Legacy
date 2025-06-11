package willatendo.fossilslegacy.server.level;

import net.minecraft.world.level.GameRules;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;

public final class FAGameRules {
    public static final GameRules.Key<GameRules.BooleanValue> RULE_DOANIMALBLOCKBREAKING = FossilsModloaderHelper.INSTANCE.createBooleanGameRule("doAnimalBlockBreaking", GameRules.Category.MOBS, true);
    public static final GameRules.Key<GameRules.BooleanValue> RULE_DOANIMALHUNGER = FossilsModloaderHelper.INSTANCE.createBooleanGameRule("doAnimalHunger", GameRules.Category.MOBS, true);
    public static final GameRules.Key<GameRules.BooleanValue> RULE_DOANIMALGROWTH = FossilsModloaderHelper.INSTANCE.createBooleanGameRule("doAnimalGrowth", GameRules.Category.MOBS, true);
    public static final GameRules.Key<GameRules.BooleanValue> RULE_TAR_SOURCE_CONVERSION = FossilsModloaderHelper.INSTANCE.createBooleanGameRule("tarSourceConversion", GameRules.Category.UPDATES, false);

    public static void init() {
    }
}
