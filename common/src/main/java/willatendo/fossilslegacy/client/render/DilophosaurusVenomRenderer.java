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
import willatendo.fossilslegacy.client.state.DilophosaurusVenomRenderState;
import willatendo.fossilslegacy.server.entity.entities.DilophosaurusVenom;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class DilophosaurusVenomRenderer extends EntityRenderer<DilophosaurusVenom, DilophosaurusVenomRenderState> {
    public static final ResourceLocation TEXTURE = FAUtils.resource("textures/entity/dilophosaurus/venom.png");
    private final LlamaSpitModel model;

    public DilophosaurusVenomRenderer(Context context) {
        super(context);
        this.model = new LlamaSpitModel(context.bakeLayer(ModelLayers.LLAMA_SPIT));
    }

    @Override
    public void render(DilophosaurusVenomRenderState dilophosaurusVenomRenderState, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        poseStack.pushPose();
        poseStack.translate(0.0F, 0.15F, 0.0F);
        poseStack.mulPose(Axis.YP.rotationDegrees(dilophosaurusVenomRenderState.yRot - 90.0F));
        poseStack.mulPose(Axis.ZP.rotationDegrees(dilophosaurusVenomRenderState.xRot));
        this.model.setupAnim(dilophosaurusVenomRenderState);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(this.model.renderType(TEXTURE));
        this.model.renderToBuffer(poseStack, vertexConsumer, partialTicks, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(dilophosaurusVenomRenderState, poseStack, multiBufferSource, partialTicks);
    }

    @Override
    public DilophosaurusVenomRenderState createRenderState() {
        return new DilophosaurusVenomRenderState();
    }

    @Override
    public void extractRenderState(DilophosaurusVenom dilophosaurusVenom, DilophosaurusVenomRenderState dilophosaurusVenomRenderState, float partialTicks) {
        super.extractRenderState(dilophosaurusVenom, dilophosaurusVenomRenderState, partialTicks);
        dilophosaurusVenomRenderState.xRot = dilophosaurusVenom.getXRot(partialTicks);
        dilophosaurusVenomRenderState.yRot = dilophosaurusVenom.getYRot(partialTicks);
    }
}