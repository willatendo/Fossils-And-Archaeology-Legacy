package willatendo.fossilslegacy.server.entity.util.interfaces;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;

public interface SpeakingEntity {
    Component getDisplayName();

    default void sendMessageToPlayer(SpeakerType speakerType, ServerPlayer serverPlayer) {
        serverPlayer.sendSystemMessage(Component.translatable("%s", speakerType.getMessage(serverPlayer, (LivingEntity) this).getString()));
    }
}
