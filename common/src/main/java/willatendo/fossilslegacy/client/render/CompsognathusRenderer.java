package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.CompsognathusModel;
import willatendo.fossilslegacy.server.entity.Compsognathus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class CompsognathusRenderer extends MobRenderer<Compsognathus, CompsognathusModel> {
    public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entity/compsognathus/compsognathus.png");

    public CompsognathusRenderer(EntityRendererProvider.Context context) {
        super(context, new CompsognathusModel(context.bakeLayer(FossilsLegacyModelLayers.COMPSOGNATHUS)), 0.15F);
    }

    @Override
    public ResourceLocation getTextureLocation(Compsognathus compsognathus) {
        return TEXTURE;
    }
}
