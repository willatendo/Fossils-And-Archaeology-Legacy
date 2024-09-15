package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import willatendo.fossilslegacy.server.entity.Triceratops;

public class TriceratopsRenderer extends CoatTypeMobRenderer<Triceratops> {
    public TriceratopsRenderer(Context context) {
        super(context, 0.3F);
    }
}
