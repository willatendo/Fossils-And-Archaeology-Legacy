package willatendo.fossilslegacy.client.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;

@FunctionalInterface
public interface ModelProvider<T extends Entity> {
    EntityModel<T> create(ModelPart root);
}
