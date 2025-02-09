package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import willatendo.fossilslegacy.client.state.SmilodonRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Smilodon;

public class SmilodonRenderer extends CoatTypeMobRenderer<Smilodon, SmilodonRenderState> {
    public SmilodonRenderer(Context context) {
        super(new SmilodonRenderState(), context, 0.3F);
    }
}
