package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.DilophosaurusModel;
import willatendo.fossilslegacy.server.entity.Dilophosaurus;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class DilophosaurusRenderer extends MobRenderer<Dinosaur, DilophosaurusModel> {
    public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entity/dilophosaurus/dilophosaurus.png");
    public static final ResourceLocation AGGRESSIVE_TEXTURE = FossilsLegacyUtils.resource("textures/entity/dilophosaurus/aggressive_dilophosaurus.png");

    public DilophosaurusRenderer(Context context) {
        super(context, new DilophosaurusModel(context.bakeLayer(FossilsLegacyModelLayers.DILOPHOSAURUS)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(Dinosaur dinosaur) {
        return ((Dilophosaurus) dinosaur).isAttacking() ? AGGRESSIVE_TEXTURE : TEXTURE;
    }
}
