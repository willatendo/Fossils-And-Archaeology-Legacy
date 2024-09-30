package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.server.entity.Moa;

public class MoaRenderer extends CoatTypeMobRenderer<Moa> {
    public MoaRenderer(EntityRendererProvider.Context context) {
        super(context, 0.5F);
    }
}
