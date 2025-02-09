package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Carnotaurus;

public class CarnotaurusRenderer extends CoatTypeMobRenderer<Carnotaurus, DinosaurRenderState> {
    public CarnotaurusRenderer(EntityRendererProvider.Context context) {
        super(new DinosaurRenderState(), context, 0.15F);
    }
}
