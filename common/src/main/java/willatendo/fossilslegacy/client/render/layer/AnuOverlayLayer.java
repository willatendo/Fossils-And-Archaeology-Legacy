package willatendo.fossilslegacy.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import willatendo.fossilslegacy.client.model.AnuModel;
import willatendo.fossilslegacy.server.entity.Anu;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class AnuOverlayLayer extends RenderLayer<Anu, AnuModel> {
    public AnuOverlayLayer(RenderLayerParent<Anu, AnuModel> renderLayerParent) {
        super(renderLayerParent);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks, Anu anu, float position, float speed, float packedOverlay, float bob, float headPitch, float headYaw) {
        RenderType renderType = RenderType.eyes(FossilsLegacyUtils.resource("textures/entity/anu/anu_overlay.png"));
        if (anu.isCharging()) {
            renderType = RenderType.eyes(FossilsLegacyUtils.resource("textures/entity/anu/anu_overlay_charging.png"));
        }
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(renderType);
        ((Model) this.getParentModel()).renderToBuffer(poseStack, vertexConsumer, 0xF00000, OverlayTexture.NO_OVERLAY);
    }
}
