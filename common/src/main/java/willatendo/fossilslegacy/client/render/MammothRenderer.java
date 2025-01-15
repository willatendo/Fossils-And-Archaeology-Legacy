package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import willatendo.fossilslegacy.client.render.layer.MammothFurLayer;
import willatendo.fossilslegacy.server.entity.dinosaur.quaternary.Mammoth;

public class MammothRenderer extends CoatTypeMobRenderer<Mammoth> {
    public MammothRenderer(Context context) {
        super(context, 0.3F);
        this.addLayer(new MammothFurLayer(this));
    }
}
