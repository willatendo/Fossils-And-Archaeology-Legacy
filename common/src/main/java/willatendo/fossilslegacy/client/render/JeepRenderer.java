package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FAModelLayers;
import willatendo.fossilslegacy.client.model.vehicle.JeepModel;
import willatendo.fossilslegacy.client.state.JeepRenderState;
import willatendo.fossilslegacy.server.entity.entities.vehicle.Jeep;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class JeepRenderer extends EntityRenderer<Jeep, JeepRenderState> {
    private static final ResourceLocation JURASSIC_PARK_JEEP_TEXTURE = FAUtils.resource("textures/entity/jeep/jurassic_park_jeep.png");
    private final JeepModel model;

    public JeepRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 1.0F;
        this.model = new JeepModel(context.bakeLayer(FAModelLayers.JEEP));
    }

    @Override
    public JeepRenderState createRenderState() {
        return new JeepRenderState();
    }

    @Override
    public void extractRenderState(Jeep jeep, JeepRenderState jeepRenderState, float partialTick) {
        super.extractRenderState(jeep, jeepRenderState, partialTick);
        jeepRenderState.yRot = jeep.getYRot(partialTick);
    }

    @Override
    public void render(JeepRenderState jeepRenderState, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.translate(0.0F, 1.5F, 0.0F);
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - jeepRenderState.yRot));
        poseStack.scale(-1.0F, -1.0F, 1.0F);
        this.model.setupAnim(jeepRenderState);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(this.model.renderType(JURASSIC_PARK_JEEP_TEXTURE));
        this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(jeepRenderState, poseStack, multiBufferSource, packedLight);
    }
}
