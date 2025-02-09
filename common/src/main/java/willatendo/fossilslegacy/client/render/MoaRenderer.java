package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Moa;

public class MoaRenderer extends CoatTypeMobRenderer<Moa, DinosaurRenderState> {
    public MoaRenderer(EntityRendererProvider.Context context) {
        super(new DinosaurRenderState(), context, 0.5F);
    }
}
