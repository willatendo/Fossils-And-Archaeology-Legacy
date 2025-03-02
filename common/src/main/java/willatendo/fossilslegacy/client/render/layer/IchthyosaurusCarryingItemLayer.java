package willatendo.fossilslegacy.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.state.IchthyosaurusRenderState;

public class IchthyosaurusCarryingItemLayer extends RenderLayer<IchthyosaurusRenderState, EntityModel<IchthyosaurusRenderState>> {
    public IchthyosaurusCarryingItemLayer(RenderLayerParent<IchthyosaurusRenderState, EntityModel<IchthyosaurusRenderState>> renderLayerParent) {
        super(renderLayerParent);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks, IchthyosaurusRenderState ichthyosaurusRenderState, float packedLight, float packedOverlay) {
        ItemStackRenderState itemStackRenderState = ichthyosaurusRenderState.heldItem;
        if (!itemStackRenderState.isEmpty()) {
            poseStack.pushPose();
            float xRot = Mth.abs(ichthyosaurusRenderState.xRot) / 60.0F;
            if (ichthyosaurusRenderState.xRot < 0.0F) {
                poseStack.translate(0.0F, 1.0F - xRot * 0.5F, -1.0F + xRot * 0.5F);
            } else {
                poseStack.translate(0.0F, 1.0F + xRot * 0.8F, -1.0F + xRot * 0.2F);
            }

            itemStackRenderState.render(poseStack, multiBufferSource, partialTicks, OverlayTexture.NO_OVERLAY);
            poseStack.popPose();
        }
    }
}