package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import willatendo.fossilslegacy.server.entity.dinosaur.cretaceous.Pachycephalosaurus;

public class PachycephalosaurusRenderer extends CoatTypeMobRenderer<Pachycephalosaurus> {
    public PachycephalosaurusRenderer(Context context) {
        super(context, 0.3F);
    }
}
