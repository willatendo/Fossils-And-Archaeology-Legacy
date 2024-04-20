package willatendo.fossilslegacy.server.entity;

import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public interface DinopediaInformation {
	List<Component> info(Player player);
}
