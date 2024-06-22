package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.legacy.DilophosaurusModel;
import willatendo.fossilslegacy.server.entity.Dilophosaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class DilophosaurusRenderer extends MobRenderer<Dilophosaurus, DilophosaurusModel> {
    public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entities/animals/dilophosaurus/dilophosaurus.png");
    public static final ResourceLocation AGGRESSIVE_TEXTURE = FossilsLegacyUtils.resource("textures/entities/animals/dilophosaurus/aggressive_dilophosaurus.png");

    public DilophosaurusRenderer(Context context) {
        super(context, new DilophosaurusModel(context.bakeLayer(FossilsLegacyModels.DILOPHOSAURUS)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(Dilophosaurus dilophosaurus) {
        return dilophosaurus.isAttacking() ? AGGRESSIVE_TEXTURE : TEXTURE;
    }
}
