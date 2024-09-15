package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import willatendo.fossilslegacy.client.render.layer.MosasaurusEyesLayer;
import willatendo.fossilslegacy.server.entity.Mosasaurus;

public class MosasaurusRenderer extends CoatTypeMobRenderer<Mosasaurus> {
    public MosasaurusRenderer(Context context) {
        super(context, 0.3F);
        this.addLayer(new MosasaurusEyesLayer(this));
    }
}
