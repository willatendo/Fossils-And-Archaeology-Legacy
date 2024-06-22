package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.CompsognathusModel;
import willatendo.fossilslegacy.client.model.legacy.CryolophosaurusModel;
import willatendo.fossilslegacy.server.entity.Compsognathus;
import willatendo.fossilslegacy.server.entity.Cryolophosaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class CompsognathusRenderer extends MobRenderer<Compsognathus, CompsognathusModel> {
    public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entities/animals/compsognathus/texture.png");

    public CompsognathusRenderer(EntityRendererProvider.Context context) {
        super(context, new CompsognathusModel(context.bakeLayer(FossilsLegacyModels.COMPSOGNATHUS)), 0.15F);
    }

    @Override
    public ResourceLocation getTextureLocation(Compsognathus compsognathus) {
        return TEXTURE;
    }
}
