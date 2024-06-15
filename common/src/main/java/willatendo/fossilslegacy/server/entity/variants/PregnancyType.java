package willatendo.fossilslegacy.server.entity.variants;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import java.util.function.Supplier;

public record PregnancyType(Supplier<EntityType<? extends Entity>> entityType) {
    public Component getDescription() {
        return this.entityType.get().getDescription();
    }
}
