package willatendo.fossilslegacy.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import willatendo.fossilslegacy.client.model.AnuModel;
import willatendo.fossilslegacy.client.state.AnuRenderState;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class AnuOverlayLayer extends RenderLayer<AnuRenderState, AnuModel> {
    public AnuOverlayLayer(RenderLayerParent<AnuRenderState, AnuModel> renderLayerParent) {
        super(renderLayerParent);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks, AnuRenderState anuRenderState, float packedLight, float packedOverlay) {
        RenderType renderType = RenderType.eyes(FAUtils.resource("textures/entity/anu/anu_overlay.png"));
        if (anuRenderState.isCharging) {
            renderType = RenderType.eyes(FAUtils.resource("textures/entity/anu/anu_overlay_charging.png"));
        }
        this.getParentModel().renderToBuffer(poseStack, multiBufferSource.getBuffer(renderType), 0xF00000, OverlayTexture.NO_OVERLAY);
    }
}
