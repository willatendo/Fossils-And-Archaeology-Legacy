package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.VelociraptorModel;
import willatendo.fossilslegacy.client.render.layer.VelociraptorHoldItemInMouthLayer;
import willatendo.fossilslegacy.server.entity.Velociraptor;

public class VelociraptorRenderer extends DinosaurRenderer<Velociraptor, VelociraptorModel> {
    public VelociraptorRenderer(Context context) {
        super(context, new VelociraptorModel(context.bakeLayer(FossilsLegacyModels.VELOCIRAPTOR)), 0.3F);
        this.addLayer(new VelociraptorHoldItemInMouthLayer(this, context.getItemInHandRenderer()));
    }

    @Override
    public ResourceLocation getTextureLocation(Velociraptor velociraptor) {
        return velociraptor.textures()[velociraptor.getSubSpecies()][velociraptor.isBaby() ? 1 : 0];
    }
}
