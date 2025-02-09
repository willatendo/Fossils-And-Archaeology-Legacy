package willatendo.fossilslegacy.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;

import java.util.Optional;

public class MosasaurusEyesLayer extends RenderLayer<DinosaurRenderState, EntityModel<DinosaurRenderState>> {
    public MosasaurusEyesLayer(RenderLayerParent<DinosaurRenderState, EntityModel<DinosaurRenderState>> renderLayerParent) {
        super(renderLayerParent);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks, DinosaurRenderState dinosaurRenderState, float packedLight, float packedOverlay) {
        Optional<ResourceLocation> optionalEyeLayerTexture = dinosaurRenderState.coatType.value().patterns().getFirst().textures().eyeLayerTexture();
        if (optionalEyeLayerTexture.isPresent()) {
            VertexConsumer vertexconsumer = multiBufferSource.getBuffer(RenderType.eyes(optionalEyeLayerTexture.get()));
            this.getParentModel().renderToBuffer(poseStack, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY);
        }
    }
}
