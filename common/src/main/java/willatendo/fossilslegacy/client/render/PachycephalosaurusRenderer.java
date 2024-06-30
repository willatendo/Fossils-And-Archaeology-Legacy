package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.PachycephalosaurusModel;
import willatendo.fossilslegacy.server.entity.Pachycephalosaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class PachycephalosaurusRenderer extends MobRenderer<Pachycephalosaurus, PachycephalosaurusModel> {
    public static final ResourceLocation BABY_TEXTURE = FossilsLegacyUtils.resource("textures/entity/pachycephalosaurus/pachycephalosaurus_baby.png");
    public static final ResourceLocation ADULT_TEXTURE = FossilsLegacyUtils.resource("textures/entity/pachycephalosaurus/pachycephalosaurus_adult.png");

    public PachycephalosaurusRenderer(Context context) {
        super(context, new PachycephalosaurusModel(context.bakeLayer(FossilsLegacyModelLayers.PACHYCEPHALOSAURUS)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(Pachycephalosaurus pachycephalosaurus) {
        return pachycephalosaurus.isBaby() ? BABY_TEXTURE : ADULT_TEXTURE;
    }
}
