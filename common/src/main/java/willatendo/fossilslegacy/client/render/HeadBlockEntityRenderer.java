package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import willatendo.fossilslegacy.client.FAModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.head.AnkylosaursHeadModel;
import willatendo.fossilslegacy.client.model.dinosaur.head.BaryonyxHeadModel;
import willatendo.fossilslegacy.client.model.dinosaur.head.HeadModel;
import willatendo.fossilslegacy.server.block.blocks.AbstractHeadBlock;
import willatendo.fossilslegacy.server.block.blocks.WallHeadBlock;
import willatendo.fossilslegacy.server.block.entity.entities.HeadBlockEntity;
import willatendo.fossilslegacy.server.item.FAHeadTypes;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Map;
import java.util.function.Function;

public class HeadBlockEntityRenderer implements BlockEntityRenderer<HeadBlockEntity> {
    private static final Map<FAHeadTypes, ResourceLocation> TEXTURE_BY_HEAD = Map.of(
            FAHeadTypes.ANKYLOSAURUS, FAUtils.resource("textures/entity/ankylosaurus/ankylosaurus.png"),
            FAHeadTypes.BARYONYX, FAUtils.resource("textures/entity/baryonyx/baryonyx.png")
    );
    private final Function<FAHeadTypes, HeadModel> modelByHead;

    public static HeadModel createModel(EntityModelSet modelSet, FAHeadTypes faHeadTypes) {
        HeadModel headModel;
        switch (faHeadTypes) {
            case ANKYLOSAURUS ->
                    headModel = new AnkylosaursHeadModel(modelSet.bakeLayer(FAModelLayers.ANKYLOSAURUS_HEAD));
            case BARYONYX ->
                    headModel = new BaryonyxHeadModel(modelSet.bakeLayer(FAModelLayers.BARYONYX_HEAD));
            default -> throw new MatchException(null, null);
        }
        return headModel;
    }

    public HeadBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.modelByHead = Util.memoize(faHeadTypes -> HeadBlockEntityRenderer.createModel(context.getModelSet(), faHeadTypes));
    }

    @Override
    public void render(HeadBlockEntity headBlockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        BlockState blockState = headBlockEntity.getBlockState();
        boolean flag = blockState.getBlock() instanceof WallHeadBlock;
        Direction direction = flag ? blockState.getValue(WallHeadBlock.FACING) : null;
        int rotation = flag ? RotationSegment.convertToSegment(direction.getOpposite()) : blockState.getValue(SkullBlock.ROTATION);
        FAHeadTypes faHeadTypes = ((AbstractHeadBlock) blockState.getBlock()).getType();
        RenderType rendertype = HeadBlockEntityRenderer.getRenderType(faHeadTypes);
        HeadBlockEntityRenderer.renderSkull(direction, RotationSegment.convertToDegrees(rotation), 0, poseStack, multiBufferSource, packedLight, this.modelByHead.apply(faHeadTypes), rendertype);
    }

    public static void renderSkull(Direction direction, float yRot, float mouthAnimation, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, HeadModel headModel, RenderType renderType) {
        poseStack.pushPose();
        if (direction == null) {
            poseStack.translate(0.5F, 0.0F, 0.5F);
        } else {
            poseStack.translate(0.5F - (float) direction.getStepX() * 0.25F, 0.25F, 0.5F - (float) direction.getStepZ() * 0.25F);
        }

        poseStack.scale(-1.0F, -1.0F, 1.0F);
        headModel.setupAnim(mouthAnimation, yRot, 0.0F);
        headModel.renderToBuffer(poseStack, multiBufferSource.getBuffer(renderType), packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
    }

    public static RenderType getRenderType(FAHeadTypes faHeadTypes) {
        return HeadBlockEntityRenderer.getRenderType(faHeadTypes, null);
    }

    public static RenderType getRenderType(FAHeadTypes faHeadTypes, ResourceLocation textureOverride) {
        return RenderType.entityCutoutNoCullZOffset(textureOverride != null ? textureOverride : HeadBlockEntityRenderer.TEXTURE_BY_HEAD.get(faHeadTypes));
    }
}
