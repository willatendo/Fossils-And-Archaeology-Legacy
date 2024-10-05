package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.server.entity.dinosaur.cretaceous.Spinosaurus;

public class SpinosaurusRenderer extends CoatTypeMobRenderer<Spinosaurus> {
    public SpinosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, 0.3F);
    }
}
