package willatendo.fossilslegacy.server.entity;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public interface SpeakerType {
	Component getMessage(Player player);
}
