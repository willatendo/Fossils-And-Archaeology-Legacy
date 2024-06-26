package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.MammothModel;
import willatendo.fossilslegacy.server.entity.Mammoth;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class MammothRenderer extends MobRenderer<Mammoth, MammothModel> {
    public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entity/mammoth/mammoth.png");
    public static final ResourceLocation SHEARED_TEXTURE = FossilsLegacyUtils.resource("textures/entity/mammoth/sheared_mammoth.png");
    public static final ResourceLocation BABY_TEXTURE = FossilsLegacyUtils.resource("textures/entity/mammoth/baby_mammoth.png");

    public MammothRenderer(Context context) {
        super(context, new MammothModel(context.bakeLayer(FossilsLegacyModelLayers.MAMMOTH)), 0.3F);
    }

    @Override
    protected void scale(Mammoth mammoth, PoseStack poseStack, float f) {
        if (!mammoth.isBaby()) {
            poseStack.scale(6.0F, 6.0F, 6.0F);
        }
        super.scale(mammoth, poseStack, f);
    }

    @Override
    public ResourceLocation getTextureLocation(Mammoth mammoth) {
        return mammoth.isBaby() ? BABY_TEXTURE : (mammoth.isSheared() ? SHEARED_TEXTURE : TEXTURE);
    }
}
