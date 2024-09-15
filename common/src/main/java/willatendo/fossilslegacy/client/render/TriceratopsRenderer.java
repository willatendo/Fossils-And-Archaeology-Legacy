package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.TriceratopsModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.LegacyTriceratopsModel;
import willatendo.fossilslegacy.server.entity.Triceratops;

public class TriceratopsRenderer extends CoatTypeMobRenderer<Triceratops> {
    public TriceratopsRenderer(Context context) {
        super(context, 0.3F);
    }
}
