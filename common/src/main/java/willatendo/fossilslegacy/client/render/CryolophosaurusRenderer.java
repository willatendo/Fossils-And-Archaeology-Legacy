package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.Cryolophosaurus;

public class CryolophosaurusRenderer extends CoatTypeMobRenderer<Cryolophosaurus, DinosaurRenderState> {
    public CryolophosaurusRenderer(EntityRendererProvider.Context context) {
        super(new DinosaurRenderState(), context, 0.15F);
    }
}
