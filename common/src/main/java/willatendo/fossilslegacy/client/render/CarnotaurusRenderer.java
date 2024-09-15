package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.CarnotaurusModel;
import willatendo.fossilslegacy.server.entity.Carnotaurus;
import willatendo.fossilslegacy.server.entity.Dinosaur;

public class CarnotaurusRenderer extends CoatTypeMobRenderer<Carnotaurus> {
    public CarnotaurusRenderer(EntityRendererProvider.Context context) {
        super(context,  0.15F);
    }
}
