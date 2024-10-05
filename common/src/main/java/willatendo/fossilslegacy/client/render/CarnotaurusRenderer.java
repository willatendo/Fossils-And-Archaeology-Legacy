package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.server.entity.dinosaur.cretaceous.Carnotaurus;

public class CarnotaurusRenderer extends CoatTypeMobRenderer<Carnotaurus> {
    public CarnotaurusRenderer(EntityRendererProvider.Context context) {
        super(context, 0.15F);
    }
}
