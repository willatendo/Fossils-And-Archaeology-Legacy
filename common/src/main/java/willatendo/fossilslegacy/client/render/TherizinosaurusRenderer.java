package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.server.entity.dinosaur.cretaceous.Therizinosaurus;

public class TherizinosaurusRenderer extends CoatTypeMobRenderer<Therizinosaurus> {
    public TherizinosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, 0.15F);
    }
}
