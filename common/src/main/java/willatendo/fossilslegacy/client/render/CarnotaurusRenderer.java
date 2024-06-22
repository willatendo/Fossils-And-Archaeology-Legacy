package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.legacy.CarnotaurusModel;
import willatendo.fossilslegacy.server.entity.Carnotaurus;

public class CarnotaurusRenderer extends MobRenderer<Carnotaurus, CarnotaurusModel> {
    public CarnotaurusRenderer(EntityRendererProvider.Context context) {
        super(context, new CarnotaurusModel(context.bakeLayer(FossilsLegacyModels.CARNOTAURUS)), 0.15F);
    }

    @Override
    public ResourceLocation getTextureLocation(Carnotaurus carnotaurus) {
        return carnotaurus.textures()[carnotaurus.getSubSpecies()][0];
    }
}
