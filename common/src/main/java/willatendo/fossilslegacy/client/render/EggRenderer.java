package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.EggModel;
import willatendo.fossilslegacy.server.entity.Egg;
import willatendo.fossilslegacy.server.entity.variants.EggVariant;

public class EggRenderer extends MobRenderer<Egg, EggModel> {
    private final EggModel regularEggModel;
    private final EggModel smallEggModel;

    public EggRenderer(Context context) {
        super(context, null, 0.3F);
        this.regularEggModel = new EggModel(context.bakeLayer(FossilsLegacyModelLayers.REGULAR_EGG));
        this.smallEggModel = new EggModel(context.bakeLayer(FossilsLegacyModelLayers.SMALL_EGG));
    }

    @Override
    public void render(Egg egg, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
        if (egg.getEggVariant().value().eggSize() == EggVariant.EggSize.SMALL) {
            this.model = this.smallEggModel;
        } else {
            this.model = this.regularEggModel;
        }
        super.render(egg, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(Egg egg) {
        return egg.getEggVariant().value().texture();
    }
}
