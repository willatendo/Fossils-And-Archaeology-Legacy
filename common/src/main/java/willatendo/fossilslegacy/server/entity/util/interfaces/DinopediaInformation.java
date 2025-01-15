package willatendo.fossilslegacy.server.entity.util.interfaces;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.server.item.dinopedia.DinopediaType;

import java.util.List;
import java.util.Optional;

public interface DinopediaInformation {
    default List<Component> info(Player player) {
        return List.of();
    }

    default Optional<ResourceKey<DinopediaType>> getDinopediaType() {
        return Optional.empty();
    }
}
