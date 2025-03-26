package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Holder;
import willatendo.fossilslegacy.client.resources.DecorationPlaqueTextureManager;
import willatendo.fossilslegacy.server.block.blocks.DecorationPostBlock;
import willatendo.fossilslegacy.server.block.entity.entities.DecorationPostBlockEntity;
import willatendo.fossilslegacy.server.decoration_plaque_type.DecorationPlaqueType;

public class DecorationPostRenderer implements BlockEntityRenderer<DecorationPostBlockEntity> {
    public DecorationPostRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(DecorationPostBlockEntity decorationPostBlockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        Holder<DecorationPlaqueType> decorationPlaqueTypeHolder = decorationPostBlockEntity.getDecorationPlaqueType();
        if (decorationPlaqueTypeHolder != null) {
            poseStack.pushPose();
            poseStack.translate(0.5F, 0.5F, 0.5F);
            if (decorationPostBlockEntity.getBlockState() != null) {
                float rotation = 180.0F - ((float) decorationPostBlockEntity.getBlockState().getValue(DecorationPostBlock.ROTATION) * 45.0F);
                poseStack.mulPose(Axis.YP.rotationDegrees(rotation));
                if (rotation % 90 == 0) {
                    poseStack.translate(0.0F, 0.0F, -0.1F);
                } else {
                    poseStack.translate(0.0F, 0.0F, -0.15F);
                }
            }
            DecorationPlaqueType decorationPlaqueType = decorationPlaqueTypeHolder.value();
            int height = decorationPlaqueType.height();
            if (height > 1) {
                poseStack.translate(0.0F, 0.5F * (height - 1), 0.0F);
            }
            TextureAtlasSprite textureAtlasSprite = DecorationPlaqueTextureManager.INSTANCE.get(decorationPlaqueType);
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCullZOffset(textureAtlasSprite.atlasLocation()));
            DecorationPlaqueRenderer.renderDecorationPlaque(poseStack, vertexConsumer, packedLight, decorationPlaqueType.width(), height, textureAtlasSprite);
            poseStack.popPose();
        }
    }
}
