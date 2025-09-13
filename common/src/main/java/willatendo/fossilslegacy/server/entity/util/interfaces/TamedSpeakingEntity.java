package willatendo.fossilslegacy.server.entity.util.interfaces;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.server.level.FAGameRules;

public interface TamedSpeakingEntity extends SpeakingEntity, TameAccessor, SimpleLevelAccessor {
    default void sendMessageToOwnerOrElseAll(SpeakerType speakerType) {
        if (this.isTame() && this.getOwner() instanceof ServerPlayer serverPlayer) {
            this.sendMessageToPlayer(speakerType, serverPlayer);
        } else {
            if (this.getLevel() instanceof ServerLevel serverLevel && serverLevel.getGameRules().getBoolean(FAGameRules.RULE_DO_UNTAME_ANIMAL_MESSAGES)) {
                for (Player player : this.getLevel().players()) {
                    if (player instanceof ServerPlayer serverPlayer) {
                        this.sendMessageToPlayer(speakerType, serverPlayer);
                    }
                }
            }
        }
    }
}
