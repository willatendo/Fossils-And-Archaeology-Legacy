package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import willatendo.fossilslegacy.client.render.layer.VelociraptorHoldItemInMouthLayer;
import willatendo.fossilslegacy.server.entity.Velociraptor;

public class VelociraptorRenderer extends CoatTypeMobRenderer<Velociraptor> {
    public VelociraptorRenderer(Context context) {
        super(context, 0.3F);
        this.addLayer(new VelociraptorHoldItemInMouthLayer(this, context.getItemInHandRenderer()));
    }
}
