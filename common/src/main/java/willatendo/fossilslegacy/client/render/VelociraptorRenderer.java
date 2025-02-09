package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Velociraptor;

public class VelociraptorRenderer extends CoatTypeMobRenderer<Velociraptor, DinosaurRenderState> {
    public VelociraptorRenderer(Context context) {
        super(new DinosaurRenderState(), context, 0.3F);
    }
}
