package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.PoseStack.Pose;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.resources.StoneTabletTextureManager;
import willatendo.fossilslegacy.server.entity.StoneTablet;
import willatendo.fossilslegacy.server.entity.variants.StoneTabletVariant;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class StoneTabletRenderer extends EntityRenderer<StoneTablet> {
    public StoneTabletRenderer(Context context) {
        super(context);
    }

    @Override
    public void render(StoneTablet stoneTablet, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - packedLight));
        StoneTabletVariant stoneHieroglyphTypes = stoneTablet.getVariant().value();
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutout(this.getTextureLocation(stoneTablet)));
        this.renderStoneHieroglyph(poseStack, vertexConsumer, stoneTablet, stoneHieroglyphTypes.width(), stoneHieroglyphTypes.height(), StoneTabletTextureManager.INSTANCE.get(stoneHieroglyphTypes));
        poseStack.popPose();
        super.render(stoneTablet, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
    }

    private void renderStoneHieroglyph(PoseStack poseStack, VertexConsumer vertexConsumer, StoneTablet stoneTablet, int width, int height, TextureAtlasSprite stoneTabletAtlas) {
        Pose pose = poseStack.last();
        float f = (float) (-width) / 2.0F;
        float f1 = (float) (-height) / 2.0F;
        double normalizedWidth = 1.0D / width;
        double normalizedHeight = 1.0D / height;

        for (int w = 0; w < width; ++w) {
            for (int h = 0; h < height; ++h) {
                float uStart = f + (float) (w + 1);
                float uEnd = f + (float) w;
                float vStart = f1 + (float) (h + 1);
                float vEnd = f1 + (float) h;
                int blockX = stoneTablet.getBlockX();
                int blockY = Mth.floor(stoneTablet.getY() + (double) ((vStart + vEnd) / 2.0F));
                int blockZ = stoneTablet.getBlockZ();
                Direction direction = stoneTablet.getDirection();
                if (direction == Direction.NORTH) {
                    blockX = Mth.floor(stoneTablet.getX() + (double) ((uStart + uEnd) / 2.0F));
                }

                if (direction == Direction.WEST) {
                    blockZ = Mth.floor(stoneTablet.getZ() - (double) ((uStart + uEnd) / 2.0F));
                }

                if (direction == Direction.SOUTH) {
                    blockX = Mth.floor(stoneTablet.getX() - (double) ((uStart + uEnd) / 2.0F));
                }

                if (direction == Direction.EAST) {
                    blockZ = Mth.floor(stoneTablet.getZ() + (double) ((uStart + uEnd) / 2.0F));
                }

                int lightColour = LevelRenderer.getLightColor(stoneTablet.level(), new BlockPos(blockX, blockY, blockZ));
                float spriteMinU = stoneTabletAtlas.getU((float) (normalizedWidth * (double) (width - w)));
                float spriteMaxU = stoneTabletAtlas.getU((float) (normalizedWidth * (double) (width - (w + 1))));
                float spriteMinV = stoneTabletAtlas.getV((float) (normalizedHeight * (double) (height - h)));
                float spriteMaxV = stoneTabletAtlas.getV((float) (normalizedHeight * (double) (height - (h + 1))));
                this.vertex(pose, vertexConsumer, uStart, vEnd, spriteMaxU, spriteMinV, -0.03125F, 0, 0, -1, lightColour);
                this.vertex(pose, vertexConsumer, uEnd, vEnd, spriteMinU, spriteMinV, -0.03125F, 0, 0, -1, lightColour);
                this.vertex(pose, vertexConsumer, uEnd, vStart, spriteMinU, spriteMaxV, -0.03125F, 0, 0, -1, lightColour);
                this.vertex(pose, vertexConsumer, uStart, vStart, spriteMaxU, spriteMaxV, -0.03125F, 0, 0, -1, lightColour);
            }
        }
    }

    private void vertex(PoseStack.Pose pose, VertexConsumer vertexConsumer, float x, float y, float u, float v, float z, int x2, int y2, int y3, int lightColour) {
        vertexConsumer.addVertex(pose, x, y, z).setColor(-1).setUv(u, v).setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightColour).setNormal(pose, (float) x2, (float) y2, (float) y3);
    }

    @Override
    public ResourceLocation getTextureLocation(StoneTablet stoneTablet) {
        return StoneTabletTextureManager.INSTANCE.get(stoneTablet.getVariant().value()).atlasLocation();
    }
}
