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
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Mosasaurus;

import java.util.Optional;

public class MosasaurusEyesLayer extends RenderLayer<Mosasaurus, EntityModel<Mosasaurus>> {

    public MosasaurusEyesLayer(RenderLayerParent<Mosasaurus, EntityModel<Mosasaurus>> renderLayerParent) {
        super(renderLayerParent);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, Mosasaurus mosasaurus, float v, float v1, float v2, float v3, float v4, float v5) {
        Optional<ResourceLocation> optionalEyeLayerTexture = mosasaurus.getCoatType().value().patterns().getFirst().textures().eyeLayerTexture();
        if (optionalEyeLayerTexture.isPresent()) {
            VertexConsumer vertexconsumer = multiBufferSource.getBuffer(RenderType.eyes(optionalEyeLayerTexture.get()));
            this.getParentModel().renderToBuffer(poseStack, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY);
        }
    }
}
