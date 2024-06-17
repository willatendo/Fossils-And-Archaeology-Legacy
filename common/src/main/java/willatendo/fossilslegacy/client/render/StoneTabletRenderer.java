package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.PoseStack.Pose;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import willatendo.fossilslegacy.server.entity.StoneTablet;
import willatendo.fossilslegacy.server.entity.variants.StoneTabletVariant;

public class StoneTabletRenderer extends EntityRenderer<StoneTablet> {
    public StoneTabletRenderer(Context context) {
        super(context);
    }

    @Override
    public void render(StoneTablet stoneTablet, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - packedLight));
        StoneTabletVariant stoneHieroglyphTypes = stoneTablet.getVariant().value();
        poseStack.scale(0.0625F, 0.0625F, 0.0625F);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityTranslucent(this.getTextureLocation(stoneTablet)));
        this.renderStoneHieroglyph(poseStack, vertexConsumer, stoneTablet, stoneHieroglyphTypes.width(), stoneHieroglyphTypes.height());
        poseStack.popPose();
        super.render(stoneTablet, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
    }

    private void renderStoneHieroglyph(PoseStack poseStack, VertexConsumer vertexConsumer, StoneTablet stoneTablet, int width, int height) {
        Pose pose = poseStack.last();
        Matrix4f matrix4f = pose.pose();
        Matrix3f matrix3f = pose.normal();
        float f = (float) (-width) / 2.0F;
        float f1 = (float) (-height) / 2.0F;
        int i = width / 16;
        int j = height / 16;
        float d0 = 16.0F / i;
        float d1 = 16.0F / j;

        for (int k = 0; k < i; ++k) {
            for (int l = 0; l < j; ++l) {
                float uStart = f + (float) (k * 16);
                float uEnd = f + (float) ((k + 1) * 16);
                float vStart = f1 + (float) (l * 16);
                float vEnd = f1 + (float) ((l + 1) * 16);
                int x = stoneTablet.getBlockX();
                int y = Mth.floor(stoneTablet.getY() + (double) ((vStart + vEnd) / 2.0F / 16.0F));
                int z = stoneTablet.getBlockZ();
                Direction direction = stoneTablet.getDirection();
                if (direction == Direction.NORTH) {
                    x = Mth.floor(stoneTablet.getX() + (double) ((uStart + uEnd) / 2.0F / 16.0F));
                }

                if (direction == Direction.WEST) {
                    z = Mth.floor(stoneTablet.getZ() - (double) ((uStart + uEnd) / 2.0F / 16.0F));
                }

                if (direction == Direction.SOUTH) {
                    x = Mth.floor(stoneTablet.getX() - (double) ((uStart + uEnd) / 2.0F / 16.0F));
                }

                if (direction == Direction.EAST) {
                    z = Mth.floor(stoneTablet.getZ() + (double) ((uStart + uEnd) / 2.0F / 16.0F));
                }

                int lightColour = LevelRenderer.getLightColor(stoneTablet.level(), new BlockPos(x, y, z));
                float spriteMinU = (float) (d0 * (i - k)) / 16f;
                float spriteMaxU = (float) (d0 * (i - (k + 1))) / 16f;
                float spriteMinV = (float) (d1 * (j - l)) / 16f;
                float spriteMaxV = (float) (d1 * (j - (l + 1))) / 16f;
                this.vertex(pose, vertexConsumer, uEnd, vStart, spriteMaxU, spriteMinV, -0.5F, 0, 0, -1, lightColour);
                this.vertex(pose, vertexConsumer, uStart, vStart, spriteMinU, spriteMinV, -0.5F, 0, 0, -1, lightColour);
                this.vertex(pose, vertexConsumer, uStart, vEnd, spriteMinU, spriteMaxV, -0.5F, 0, 0, -1, lightColour);
                this.vertex(pose, vertexConsumer, uEnd, vEnd, spriteMaxU, spriteMaxV, -0.5F, 0, 0, -1, lightColour);
            }
        }
    }

    private void vertex(PoseStack.Pose pose, VertexConsumer vertexConsumer, float x, float y, float u, float v, float z, int x2, int y2, int y3, int lightColour) {
        vertexConsumer.addVertex(pose, x, y, z).setColor(255, 255, 255, 255).setUv(u, v).setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightColour).setNormal(pose, (float) x2, (float) y2, (float) y3);
    }

    @Override
    public ResourceLocation getTextureLocation(StoneTablet stoneTablet) {
        return stoneTablet.getVariant().value().getTexture();
    }
}
