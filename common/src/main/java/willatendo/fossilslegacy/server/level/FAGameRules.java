package willatendo.fossilslegacy.server.level;

import net.minecraft.world.level.GameRules;
import willatendo.fossilslegacy.platform.FAModloaderHelper;

public final class FAGameRules {
    public static final GameRules.Key<GameRules.BooleanValue> RULE_DO_ANIMAL_BLOCK_BREAKING = FAModloaderHelper.INSTANCE.createBooleanGameRule("doAnimalBlockBreaking", GameRules.Category.MOBS, true);
    public static final GameRules.Key<GameRules.BooleanValue> RULE_DO_ANIMAL_HUNGER = FAModloaderHelper.INSTANCE.createBooleanGameRule("doAnimalHunger", GameRules.Category.MOBS, true);
    public static final GameRules.Key<GameRules.BooleanValue> RULE_DO_ANIMAL_GROWTH = FAModloaderHelper.INSTANCE.createBooleanGameRule("doAnimalGrowth", GameRules.Category.MOBS, true);
    public static final GameRules.Key<GameRules.BooleanValue> RULE_DO_LOW_FEEDER_MESSAGE = FAModloaderHelper.INSTANCE.createBooleanGameRule("doLowFeederMessage", GameRules.Category.PLAYER, true);
    public static final GameRules.Key<GameRules.IntegerValue> RULE_LOW_FEEDER_MESSAGE_QUORUM = FAModloaderHelper.INSTANCE.createIntegerGameRule("lowFeederMessageQuorum", GameRules.Category.PLAYER, 100);
    public static final GameRules.Key<GameRules.BooleanValue> RULE_DO_UNTAME_ANIMAL_MESSAGES = FAModloaderHelper.INSTANCE.createBooleanGameRule("doUntameAnimalMessages", GameRules.Category.PLAYER, true);
    public static final GameRules.Key<GameRules.BooleanValue> RULE_DO_LIMIT_NOTIFICATION_DISTANCE = FAModloaderHelper.INSTANCE.createBooleanGameRule("doLimitNotificationDistance", GameRules.Category.PLAYER, false);
    public static final GameRules.Key<GameRules.IntegerValue> RULE_NOTIFICATION_DISTANCE = FAModloaderHelper.INSTANCE.createIntegerGameRule("notificationDistance", GameRules.Category.PLAYER, 30);
    public static final GameRules.Key<GameRules.BooleanValue> RULE_TAR_SOURCE_CONVERSION = FAModloaderHelper.INSTANCE.createBooleanGameRule("tarSourceConversion", GameRules.Category.UPDATES, false);

    public static void init() {
    }
}
