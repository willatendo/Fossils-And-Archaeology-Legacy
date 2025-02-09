package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import willatendo.fossilslegacy.client.render.layer.MosasaurusEyesLayer;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Mosasaurus;

public class MosasaurusRenderer extends CoatTypeMobRenderer<Mosasaurus, DinosaurRenderState> {
    public MosasaurusRenderer(Context context) {
        super(new DinosaurRenderState(), context, 0.3F);
        this.addLayer(new MosasaurusEyesLayer(this));
    }
}
