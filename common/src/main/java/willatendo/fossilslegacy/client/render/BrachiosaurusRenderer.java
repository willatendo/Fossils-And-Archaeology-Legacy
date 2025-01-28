package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.Brachiosaurus;

public class BrachiosaurusRenderer extends CoatTypeMobRenderer<Brachiosaurus> {
    public BrachiosaurusRenderer(Context context) {
        super(context, 0.3F);
    }
}
