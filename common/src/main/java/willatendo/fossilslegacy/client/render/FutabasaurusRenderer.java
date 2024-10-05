package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import willatendo.fossilslegacy.server.entity.dinosaur.cretaceous.Futabasaurus;

public class FutabasaurusRenderer extends CoatTypeMobRenderer<Futabasaurus> {
    public FutabasaurusRenderer(Context context) {
        super(context, 0.3F);
    }
}
