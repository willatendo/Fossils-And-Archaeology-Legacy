package willatendo.fossilslegacy.server.entity.util.interfaces;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public interface SpeakerType<T extends LivingEntity> {
	Component getMessage(Player player, T livingEntity);

	String getTranslationKey();
}
