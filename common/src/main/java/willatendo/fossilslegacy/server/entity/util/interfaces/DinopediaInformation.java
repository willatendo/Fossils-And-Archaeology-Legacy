package willatendo.fossilslegacy.server.entity.util.interfaces;

import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;

import java.util.Optional;

public interface DinopediaInformation {
    default Optional<ResourceKey<DinopediaType>> getDinopediaType() {
        return Optional.empty();
    }
}
