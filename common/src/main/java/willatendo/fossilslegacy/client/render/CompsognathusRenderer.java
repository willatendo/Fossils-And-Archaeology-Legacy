package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.server.entity.dinosaur.jurassic.Compsognathus;

public class CompsognathusRenderer extends CoatTypeMobRenderer<Compsognathus> {
    public CompsognathusRenderer(EntityRendererProvider.Context context) {
        super(context, 0.15F);
    }
}
