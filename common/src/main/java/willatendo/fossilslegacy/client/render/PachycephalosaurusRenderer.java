package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.PachycephalosaurusModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.Pachycephalosaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class PachycephalosaurusRenderer extends CoatTypeMobRenderer<Pachycephalosaurus> {
    public PachycephalosaurusRenderer(Context context) {
        super(context, 0.3F);
    }
}
