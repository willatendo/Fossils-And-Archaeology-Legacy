package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Dodo;

public class DodoRenderer extends CoatTypeMobRenderer<Dodo, DinosaurRenderState> {
    public DodoRenderer(EntityRendererProvider.Context context) {
        super(new DinosaurRenderState(), context, 0.15F);
    }
}
