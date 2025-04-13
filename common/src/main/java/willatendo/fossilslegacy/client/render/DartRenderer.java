package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.ArrowModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import willatendo.fossilslegacy.client.state.DartRenderState;
import willatendo.fossilslegacy.server.entity.entities.projectile.Dart;

public class DartRenderer extends EntityRenderer<Dart, DartRenderState> {
    private final ArrowModel model;

    public DartRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new ArrowModel(context.bakeLayer(ModelLayers.ARROW));
    }

    @Override
    public void render(DartRenderState dartRenderState, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(dartRenderState.yRot - 90.0F));
        poseStack.mulPose(Axis.ZP.rotationDegrees(dartRenderState.xRot));
        VertexConsumer vertexconsumer = multiBufferSource.getBuffer(RenderType.entityCutout(dartRenderState.color.getTexture()));
        this.model.setupAnim(dartRenderState);
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(dartRenderState, poseStack, multiBufferSource, packedLight);
    }

    @Override
    public void extractRenderState(Dart dart, DartRenderState dartRenderState, float partialTick) {
        super.extractRenderState(dart, dartRenderState, partialTick);
        dartRenderState.xRot = dart.getXRot(partialTick);
        dartRenderState.yRot = dart.getYRot(partialTick);
        dartRenderState.color = dart.getColor();
    }

    @Override
    public DartRenderState createRenderState() {
        return new DartRenderState();
    }
}
