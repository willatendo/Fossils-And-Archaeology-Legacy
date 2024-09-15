package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import willatendo.fossilslegacy.server.entity.Stegosaurus;

public class StegosaurusRenderer extends CoatTypeMobRenderer<Stegosaurus> {
    public StegosaurusRenderer(Context context) {
        super(context, 0.15F);
    }
}
