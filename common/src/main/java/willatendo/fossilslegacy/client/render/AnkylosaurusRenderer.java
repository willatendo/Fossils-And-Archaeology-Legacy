package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.server.entity.dinosaur.cretaceous.Ankylosaurus;

public class AnkylosaurusRenderer extends CoatTypeMobRenderer<Ankylosaurus> {
    public AnkylosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, 0.5F);
    }
}
