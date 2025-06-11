package willatendo.fossilslegacy.server.entity.util.interfaces;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public interface TamedSpeakingEntity extends SpeakingEntity, TameAccessor, SimpleLevelAccessor {
    default void sendMessageToOwnerOrElseAll(SpeakerType speakerType) {
        if (this.isTame() && this.getOwner() instanceof ServerPlayer serverPlayer) {
            this.sendMessageToPlayer(speakerType, serverPlayer);
        } else {
            for (Player player : this.getLevel().players()) {
                if (player instanceof ServerPlayer serverPlayer) {
                    this.sendMessageToPlayer(speakerType, serverPlayer);
                }
            }
        }
    }
}
