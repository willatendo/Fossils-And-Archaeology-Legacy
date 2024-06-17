package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.LlamaSpitModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.server.entity.DilophosaurusVenom;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class DilophosaurusVenomRenderer extends EntityRenderer<DilophosaurusVenom> {
    public static final ResourceLocation TEXTURE = FossilsLegacyUtils.mc("textures/entity/llama/spit.png");
    private final LlamaSpitModel<DilophosaurusVenom> model;

    public DilophosaurusVenomRenderer(Context context) {
        super(context);
        this.model = new LlamaSpitModel<>(context.bakeLayer(ModelLayers.LLAMA_SPIT));
    }

    @Override
    public void render(DilophosaurusVenom dilophosaurusVenom, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        poseStack.pushPose();
        poseStack.translate(0.0F, 0.15F, 0.0F);
        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(packedOverlay, dilophosaurusVenom.yRotO, dilophosaurusVenom.getYRot()) - 90.0F));
        poseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(packedOverlay, dilophosaurusVenom.xRotO, dilophosaurusVenom.getXRot())));
        this.model.setupAnim(dilophosaurusVenom, packedOverlay, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(this.model.renderType(TEXTURE));
        this.model.renderToBuffer(poseStack, vertexConsumer, partialTicks, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(dilophosaurusVenom, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
    }

    @Override
    public ResourceLocation getTextureLocation(DilophosaurusVenom p_115371_) {
        return TEXTURE;
    }
}