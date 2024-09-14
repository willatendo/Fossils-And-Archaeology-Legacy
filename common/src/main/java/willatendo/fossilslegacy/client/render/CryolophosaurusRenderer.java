package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.CryolophosaurusModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class CryolophosaurusRenderer extends MobRenderer<Dinosaur, CryolophosaurusModel> {
    public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entity/cryolophosaurus/cryolophosaurus.png");

    public CryolophosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, new CryolophosaurusModel(context.bakeLayer(FossilsLegacyModelLayers.CRYOLOPHOSAURUS)), 0.15F);
    }

    @Override
    public ResourceLocation getTextureLocation(Dinosaur dinosaur) {
        return TEXTURE;
    }
}
