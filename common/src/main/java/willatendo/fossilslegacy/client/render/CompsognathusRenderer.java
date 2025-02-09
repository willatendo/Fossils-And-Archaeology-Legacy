package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.Compsognathus;

public class CompsognathusRenderer extends CoatTypeMobRenderer<Compsognathus, DinosaurRenderState> {
    public CompsognathusRenderer(EntityRendererProvider.Context context) {
        super(new DinosaurRenderState(), context, 0.15F);
    }
}
