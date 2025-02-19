package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FAModelLayers;
import willatendo.fossilslegacy.client.model.JavelinModel;
import willatendo.fossilslegacy.client.state.ThrownJavelinRenderState;
import willatendo.fossilslegacy.server.entity.entities.ThrownJavelin;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Map;

public class ThrownJavelinRenderer extends EntityRenderer<ThrownJavelin, ThrownJavelinRenderState> {
    public static final Map<Integer, ResourceLocation> TEXTURES = Map.of(0, FAUtils.resource("textures/entity/javelin/wooden_javelin.png"), 1, FAUtils.resource("textures/entity/javelin/stone_javelin.png"), 2, FAUtils.resource("textures/entity/javelin/iron_javelin.png"), 3, FAUtils.resource("textures/entity/javelin/golden_javelin.png"), 4, FAUtils.resource("textures/entity/javelin/diamond_javelin.png"), 5, FAUtils.resource("textures/entity/javelin/netherite_javelin.png"), 6, FAUtils.resource("textures/entity/javelin/scarab_gem_javelin.png"));
    private final JavelinModel javelinModel;

    public ThrownJavelinRenderer(Context context) {
        super(context);
        this.javelinModel = new JavelinModel(context.bakeLayer(FAModelLayers.THROWN_JAVELIN));
    }

    @Override
    public ThrownJavelinRenderState createRenderState() {
        return new ThrownJavelinRenderState();
    }

    @Override
    public void extractRenderState(ThrownJavelin thrownJavelin, ThrownJavelinRenderState thrownJavelinRenderState, float partialTicks) {
        super.extractRenderState(thrownJavelin, thrownJavelinRenderState, partialTicks);
        thrownJavelinRenderState.variant = thrownJavelin.getVariant();
        thrownJavelinRenderState.xRot = thrownJavelin.getXRot(partialTicks);
        thrownJavelinRenderState.yRot = thrownJavelin.getYRot(partialTicks);
        thrownJavelinRenderState.shake = (float) thrownJavelin.shakeTime - partialTicks;
    }

    @Override
    public void render(ThrownJavelinRenderState thrownJavelinRenderState, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(thrownJavelinRenderState.yRot - 90.0F));
        poseStack.mulPose(Axis.ZP.rotationDegrees(thrownJavelinRenderState.xRot));
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutout(this.getTextureLocation(thrownJavelinRenderState)));
        this.javelinModel.setupAnim(thrownJavelinRenderState);
        this.javelinModel.renderToBuffer(poseStack, vertexConsumer, partialTicks, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(thrownJavelinRenderState, poseStack, multiBufferSource, partialTicks);
    }

    public ResourceLocation getTextureLocation(ThrownJavelinRenderState thrownJavelinRenderState) {
        return TEXTURES.get(thrownJavelinRenderState.variant);
    }
}
