package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Pachycephalosaurus;

public class PachycephalosaurusRenderer extends CoatTypeMobRenderer<Pachycephalosaurus, DinosaurRenderState> {
    public PachycephalosaurusRenderer(Context context) {
        super(new DinosaurRenderState(), context, 0.3F);
    }
}
