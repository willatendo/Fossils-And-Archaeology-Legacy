package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.server.entity.Cryolophosaurus;

public class CryolophosaurusRenderer extends CoatTypeMobRenderer<Cryolophosaurus> {
    public CryolophosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, 0.15F);
    }
}
