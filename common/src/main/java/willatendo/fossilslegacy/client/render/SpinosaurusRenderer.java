package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Spinosaurus;

public class SpinosaurusRenderer extends CoatTypeMobRenderer<Spinosaurus, DinosaurRenderState> {
    public SpinosaurusRenderer(EntityRendererProvider.Context context) {
        super(new DinosaurRenderState(),context, 0.3F);
    }
}
