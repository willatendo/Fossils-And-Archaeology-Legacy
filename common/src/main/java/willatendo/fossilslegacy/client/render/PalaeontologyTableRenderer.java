package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.model.json.JsonModelLoader;
import willatendo.fossilslegacy.server.block.entity.PalaeontologyTableBlockEntity;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class PalaeontologyTableRenderer implements BlockEntityRenderer<PalaeontologyTableBlockEntity> {
    public PalaeontologyTableRenderer(BlockEntityRendererProvider.Context context) {
    }

    private Model getModel(ResourceLocation id) {
        if (JsonModelLoader.isJsonModel(id)) {
            return JsonModelLoader.getModel(id);
        } else {
            return null;
        }
    }

    @Override
    public void render(PalaeontologyTableBlockEntity palaeontologyTableBlockEntity, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        FossilsLegacyUtils.LOGGER.info("HERE!");
        if (palaeontologyTableBlockEntity.getDisplay() != null) {
            FossilVariant fossilVariant = palaeontologyTableBlockEntity.getDisplay().value();
            Model model = this.getModel(fossilVariant.model());
            if (model != null) {
                poseStack.pushPose();
                poseStack.scale(-0.5F, -0.5F, 0.5F);
                poseStack.translate(-1.0F, -3.501F, 1.0F);
                model.renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(fossilVariant.texture())), packedLight, packedOverlay);
                poseStack.popPose();
            }
        }
    }
}
