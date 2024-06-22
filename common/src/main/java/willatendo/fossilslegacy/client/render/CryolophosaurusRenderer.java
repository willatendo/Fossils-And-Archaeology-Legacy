package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.legacy.CryolophosaurusModel;
import willatendo.fossilslegacy.server.entity.Cryolophosaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class CryolophosaurusRenderer extends MobRenderer<Cryolophosaurus, CryolophosaurusModel> {
    public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entities/animals/cryolophosaurus/cryolophosaurus.png");

    public CryolophosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, new CryolophosaurusModel(context.bakeLayer(FossilsLegacyModels.CRYOLOPHOSAURUS)), 0.15F);
    }

    @Override
    public ResourceLocation getTextureLocation(Cryolophosaurus cryolophosaurus) {
        return TEXTURE;
    }
}
