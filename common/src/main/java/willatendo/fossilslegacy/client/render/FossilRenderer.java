package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ARGB;
import willatendo.fossilslegacy.client.model.json.JsonModelLoader;
import willatendo.fossilslegacy.client.state.FossilRenderState;
import willatendo.fossilslegacy.server.entity.entities.Fossil;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;

public class FossilRenderer extends EntityRenderer<Fossil, FossilRenderState> {
    private EntityModel<FossilRenderState> model;

    public FossilRenderer(Context context) {
        super(context);
    }

    @Override
    public void extractRenderState(Fossil fossil, FossilRenderState fossilRenderState, float partialTick) {
        super.extractRenderState(fossil, fossilRenderState, partialTick);
        fossilRenderState.variant = fossil.getFossilVariant();
        fossilRenderState.size = fossil.getSize();
        fossilRenderState.renderScaleWidth = fossil.renderScaleWidth();
        fossilRenderState.renderScaleHeight = fossil.renderScaleHeight();
        Minecraft minecraft = Minecraft.getInstance();
        fossilRenderState.isInvisibleToPlayer = fossil.isInvisible() && fossil.isInvisibleTo(minecraft.player);
        fossilRenderState.appearsGlowing = minecraft.shouldEntityAppearGlowing(fossil);
    }

    @Override
    public FossilRenderState createRenderState() {
        return new FossilRenderState();
    }

    private void setModel(EntityModel<FossilRenderState> entityModel) {
        if (this.model != entityModel) {
            this.model = entityModel;
        }
    }

    private EntityModel<FossilRenderState> getModel(ResourceLocation id) {
        if (JsonModelLoader.isJsonModel(id)) {
            return JsonModelLoader.getModel(id);
        } else {
            return null;
        }
    }

    @Override
    public void render(FossilRenderState fossilRenderState, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
        FossilVariant fossilVariant = fossilRenderState.variant.value();
        this.setModel(this.getModel(fossilVariant.model()));
        this.shadowRadius = fossilVariant.shadowSize() + (fossilVariant.shadowGrowth() * fossilRenderState.size);

        poseStack.pushPose();

        poseStack.scale(1.0F, 1.0F, 1.0F);
        poseStack.scale(-1.0F, -1.0F, 1.0F);
        poseStack.scale(fossilRenderState.renderScaleWidth, fossilRenderState.renderScaleHeight, fossilRenderState.renderScaleWidth);
        poseStack.translate(0.0F, -1.501F, 0.0F);
        this.model.setupAnim(fossilRenderState);
        boolean isInvisible = !fossilRenderState.isInvisible;
        boolean visible = !isInvisible && !fossilRenderState.isInvisibleToPlayer;
        RenderType renderType = this.getRenderType(fossilRenderState, isInvisible, visible, fossilRenderState.appearsGlowing);
        if (renderType != null) {
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(renderType);
            int packedOverlay = OverlayTexture.pack(OverlayTexture.u(0.0F), OverlayTexture.v(false));
            int color = ARGB.multiply(visible ? 654311423 : -1, -1);
            this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        }

        poseStack.popPose();
        super.render(fossilRenderState, poseStack, multiBufferSource, packedLight);
    }

    protected RenderType getRenderType(FossilRenderState fossilRenderState, boolean isBodyVisible, boolean isVisible, boolean isGlowing) {
        ResourceLocation textureLocation = this.getTextureLocation(fossilRenderState);
        if (isVisible) {
            return RenderType.itemEntityTranslucentCull(textureLocation);
        } else if (isBodyVisible) {
            return this.model.renderType(textureLocation);
        } else {
            return isGlowing ? RenderType.outline(textureLocation) : null;
        }
    }

    @Override
    protected float getShadowRadius(FossilRenderState fossilRenderState) {
        return super.getShadowRadius(fossilRenderState) * fossilRenderState.size;
    }

    public ResourceLocation getTextureLocation(FossilRenderState fossilRenderState) {
        FossilVariant fossilVariant = fossilRenderState.variant.value();
        return fossilVariant.texture();
    }
}
