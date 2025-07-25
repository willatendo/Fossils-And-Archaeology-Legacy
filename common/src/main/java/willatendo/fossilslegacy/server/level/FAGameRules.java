package willatendo.fossilslegacy.server.level;

import net.minecraft.world.level.GameRules;
import willatendo.fossilslegacy.platform.FAModloaderHelper;

public final class FAGameRules {
    public static final GameRules.Key<GameRules.BooleanValue> RULE_DOANIMALBLOCKBREAKING = FAModloaderHelper.INSTANCE.createBooleanGameRule("doAnimalBlockBreaking", GameRules.Category.MOBS, true);
    public static final GameRules.Key<GameRules.BooleanValue> RULE_DOANIMALHUNGER = FAModloaderHelper.INSTANCE.createBooleanGameRule("doAnimalHunger", GameRules.Category.MOBS, true);
    public static final GameRules.Key<GameRules.BooleanValue> RULE_DOANIMALGROWTH = FAModloaderHelper.INSTANCE.createBooleanGameRule("doAnimalGrowth", GameRules.Category.MOBS, true);
    public static final GameRules.Key<GameRules.BooleanValue> RULE_TAR_SOURCE_CONVERSION = FAModloaderHelper.INSTANCE.createBooleanGameRule("tarSourceConversion", GameRules.Category.UPDATES, false);

    public static void init() {
    }
}
