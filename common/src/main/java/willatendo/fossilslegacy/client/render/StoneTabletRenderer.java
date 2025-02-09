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
import net.minecraft.client.renderer.entity.state.PaintingRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.PaintingTextureManager;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.client.resources.StoneTabletTextureManager;
import willatendo.fossilslegacy.client.state.StoneTabletRenderState;
import willatendo.fossilslegacy.server.entity.entities.StoneTablet;
import willatendo.fossilslegacy.server.stone_tablet_variant.StoneTabletVariant;

public class StoneTabletRenderer extends EntityRenderer<StoneTablet, StoneTabletRenderState> {
    public StoneTabletRenderer(Context context) {
        super(context);
    }

    @Override
    public void render(StoneTabletRenderState stoneTabletRenderState, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        StoneTabletVariant stoneTabletVariant = stoneTabletRenderState.variant;
        if (stoneTabletVariant != null) {
            poseStack.pushPose();
            poseStack.mulPose(Axis.YP.rotationDegrees((float) (180 - stoneTabletRenderState.direction.get2DDataValue() * 90)));
            TextureAtlasSprite textureAtlasSprite = StoneTabletTextureManager.INSTANCE.get(stoneTabletVariant);
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entitySolidZOffsetForward(textureAtlasSprite.atlasLocation()));
            this.renderStoneTablet(poseStack, vertexConsumer, stoneTabletRenderState.lightCoords, stoneTabletVariant.width(), stoneTabletVariant.height(), StoneTabletTextureManager.INSTANCE.get(stoneTabletVariant));
            poseStack.popPose();
            super.render(stoneTabletRenderState, poseStack, multiBufferSource, partialTicks);
        }
    }

    @Override
    public StoneTabletRenderState createRenderState() {
        return new StoneTabletRenderState();
    }

    @Override
    public void extractRenderState(StoneTablet stoneTablet, StoneTabletRenderState stoneTabletRenderState, float partialTick) {
        super.extractRenderState(stoneTablet, stoneTabletRenderState, partialTick);
        Direction direction = stoneTablet.getDirection();
        StoneTabletVariant stoneTabletVariant = stoneTablet.getVariant().value();
        stoneTabletRenderState.direction = direction;
        stoneTabletRenderState.variant = stoneTabletVariant;
        int width = stoneTabletVariant.width();
        int height = stoneTabletVariant.height();
        if (stoneTabletRenderState.lightCoords.length != width * height) {
            stoneTabletRenderState.lightCoords = new int[width * height];
        }

        float f = (float) (-width) / 2.0F;
        float f1 = (float) (-height) / 2.0F;
        Level level = stoneTablet.level();

        for (int h = 0; h < height; ++h) {
            for (int w = 0; w < width; ++w) {
                float f2 = (float) w + f + 0.5F;
                float f3 = (float) h + f1 + 0.5F;
                int x = stoneTablet.getBlockX();
                int y = Mth.floor(stoneTablet.getY() + (double) f3);
                int z = stoneTablet.getBlockZ();
                switch (direction) {
                    case NORTH -> x = Mth.floor(stoneTablet.getX() + (double) f2);
                    case WEST -> z = Mth.floor(stoneTablet.getZ() - (double) f2);
                    case SOUTH -> x = Mth.floor(stoneTablet.getX() - (double) f2);
                    case EAST -> z = Mth.floor(stoneTablet.getZ() + (double) f2);
                }

                stoneTabletRenderState.lightCoords[w + h * width] = LevelRenderer.getLightColor(level, new BlockPos(x, y, z));
            }
        }

    }

    private void renderStoneTablet(PoseStack poseStack, VertexConsumer vertexConsumer, int[] lightCoords, int width, int height, TextureAtlasSprite stoneTabletAtlas) {
        PoseStack.Pose pose = poseStack.last();
        float f = (float) (-width) / 2.0F;
        float f1 = (float) (-height) / 2.0F;
        double d0 = 1.0 / (double) width;
        double d1 = 1.0 / (double) height;

        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                float f15 = f + (float) (i + 1);
                float f16 = f + (float) i;
                float f17 = f1 + (float) (j + 1);
                float f18 = f1 + (float) j;
                int k = lightCoords[i + j * width];
                float f19 = stoneTabletAtlas.getU((float) (d0 * (double) (width - i)));
                float f20 = stoneTabletAtlas.getU((float) (d0 * (double) (width - (i + 1))));
                float f21 = stoneTabletAtlas.getV((float) (d1 * (double) (height - j)));
                float f22 = stoneTabletAtlas.getV((float) (d1 * (double) (height - (j + 1))));
                this.vertex(pose, vertexConsumer, f15, f18, f20, f21, -0.03125F, 0, 0, -1, k);
                this.vertex(pose, vertexConsumer, f16, f18, f19, f21, -0.03125F, 0, 0, -1, k);
                this.vertex(pose, vertexConsumer, f16, f17, f19, f22, -0.03125F, 0, 0, -1, k);
                this.vertex(pose, vertexConsumer, f15, f17, f20, f22, -0.03125F, 0, 0, -1, k);
            }
        }
    }

    private void vertex(PoseStack.Pose pose, VertexConsumer vertexConsumer, float x, float y, float u, float v, float z, int x2, int y2, int y3, int lightColour) {
        vertexConsumer.addVertex(pose, x, y, z).setColor(-1).setUv(u, v).setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightColour).setNormal(pose, (float) x2, (float) y2, (float) y3);
    }
}
