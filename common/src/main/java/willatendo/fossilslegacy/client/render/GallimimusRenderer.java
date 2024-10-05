package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.server.entity.dinosaur.cretaceous.Gallimimus;

public class GallimimusRenderer extends CoatTypeMobRenderer<Gallimimus> {
    public GallimimusRenderer(EntityRendererProvider.Context context) {
        super(context, 0.5F);
    }
}
