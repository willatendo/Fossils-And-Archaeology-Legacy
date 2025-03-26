package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.client.resources.DecorationPlaqueTextureManager;
import willatendo.fossilslegacy.client.state.DecorationPlaqueRenderState;
import willatendo.fossilslegacy.server.decoration_plaque_type.DecorationPlaqueType;
import willatendo.fossilslegacy.server.entity.entities.DecorationPlaque;

public class DecorationPlaqueRenderer extends EntityRenderer<DecorationPlaque, DecorationPlaqueRenderState> {
    public DecorationPlaqueRenderer(Context context) {
        super(context);
    }

    @Override
    public void render(DecorationPlaqueRenderState decorationPlaqueRenderState, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        DecorationPlaqueType decorationPlaqueType = decorationPlaqueRenderState.type;
        if (decorationPlaqueType != null) {
            poseStack.pushPose();
            poseStack.mulPose(Axis.YP.rotationDegrees((float) (180 - decorationPlaqueRenderState.direction.get2DDataValue() * 90)));
            TextureAtlasSprite textureAtlasSprite = DecorationPlaqueTextureManager.INSTANCE.get(decorationPlaqueType);
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCullZOffset(textureAtlasSprite.atlasLocation()));
            DecorationPlaqueRenderer.renderDecorationPlaque(poseStack, vertexConsumer, decorationPlaqueRenderState.lightCoords, decorationPlaqueType.width(), decorationPlaqueType.height(), DecorationPlaqueTextureManager.INSTANCE.get(decorationPlaqueType));
            poseStack.popPose();
            super.render(decorationPlaqueRenderState, poseStack, multiBufferSource, partialTicks);
        }
    }

    @Override
    public DecorationPlaqueRenderState createRenderState() {
        return new DecorationPlaqueRenderState();
    }

    @Override
    public void extractRenderState(DecorationPlaque decorationPlaque, DecorationPlaqueRenderState decorationPlaqueRenderState, float partialTick) {
        super.extractRenderState(decorationPlaque, decorationPlaqueRenderState, partialTick);
        Direction direction = decorationPlaque.getDirection();
        DecorationPlaqueType decorationPlaqueType = decorationPlaque.getVariant().value();
        decorationPlaqueRenderState.direction = direction;
        decorationPlaqueRenderState.type = decorationPlaqueType;
        int width = decorationPlaqueType.width();
        int height = decorationPlaqueType.height();
        if (decorationPlaqueRenderState.lightCoords.length != width * height) {
            decorationPlaqueRenderState.lightCoords = new int[width * height];
        }

        float f = (float) (-width) / 2.0F;
        float f1 = (float) (-height) / 2.0F;
        Level level = decorationPlaque.level();

        for (int h = 0; h < height; ++h) {
            for (int w = 0; w < width; ++w) {
                float f2 = (float) w + f + 0.5F;
                float f3 = (float) h + f1 + 0.5F;
                int x = decorationPlaque.getBlockX();
                int y = Mth.floor(decorationPlaque.getY() + (double) f3);
                int z = decorationPlaque.getBlockZ();
                switch (direction) {
                    case NORTH -> x = Mth.floor(decorationPlaque.getX() + (double) f2);
                    case WEST -> z = Mth.floor(decorationPlaque.getZ() - (double) f2);
                    case SOUTH -> x = Mth.floor(decorationPlaque.getX() - (double) f2);
                    case EAST -> z = Mth.floor(decorationPlaque.getZ() + (double) f2);
                }

                decorationPlaqueRenderState.lightCoords[w + h * width] = LevelRenderer.getLightColor(level, new BlockPos(x, y, z));
            }
        }
    }

    static void renderDecorationPlaque(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int width, int height, TextureAtlasSprite stoneTabletAtlas) {
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
                float f19 = stoneTabletAtlas.getU((float) (d0 * (double) (width - i)));
                float f20 = stoneTabletAtlas.getU((float) (d0 * (double) (width - (i + 1))));
                float f21 = stoneTabletAtlas.getV((float) (d1 * (double) (height - j)));
                float f22 = stoneTabletAtlas.getV((float) (d1 * (double) (height - (j + 1))));
                DecorationPlaqueRenderer.vertex(pose, vertexConsumer, f15, f18, f20, f21, -0.03125F, 0, 0, -1, packedLight);
                DecorationPlaqueRenderer.vertex(pose, vertexConsumer, f16, f18, f19, f21, -0.03125F, 0, 0, -1, packedLight);
                DecorationPlaqueRenderer.vertex(pose, vertexConsumer, f16, f17, f19, f22, -0.03125F, 0, 0, -1, packedLight);
                DecorationPlaqueRenderer.vertex(pose, vertexConsumer, f15, f17, f20, f22, -0.03125F, 0, 0, -1, packedLight);
            }
        }
    }

    static void renderDecorationPlaque(PoseStack poseStack, VertexConsumer vertexConsumer, int[] lightCoords, int width, int height, TextureAtlasSprite stoneTabletAtlas) {
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
                DecorationPlaqueRenderer.vertex(pose, vertexConsumer, f15, f18, f20, f21, -0.03125F, 0, 0, -1, k);
                DecorationPlaqueRenderer.vertex(pose, vertexConsumer, f16, f18, f19, f21, -0.03125F, 0, 0, -1, k);
                DecorationPlaqueRenderer.vertex(pose, vertexConsumer, f16, f17, f19, f22, -0.03125F, 0, 0, -1, k);
                DecorationPlaqueRenderer.vertex(pose, vertexConsumer, f15, f17, f20, f22, -0.03125F, 0, 0, -1, k);
            }
        }
    }

    private static void vertex(PoseStack.Pose pose, VertexConsumer vertexConsumer, float x, float y, float u, float v, float z, int x2, int y2, int y3, int lightColour) {
        vertexConsumer.addVertex(pose, x, y, z).setColor(-1).setUv(u, v).setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightColour).setNormal(pose, (float) x2, (float) y2, (float) y3);
    }
}
