package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Dodo;

public class DodoRenderer extends CoatTypeMobRenderer<Dodo> {
    public DodoRenderer(EntityRendererProvider.Context context) {
        super(context, 0.15F);
    }
}
