package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ARGB;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.client.model.json.JsonModelLoader;
import willatendo.fossilslegacy.server.block.blocks.HologramProjectorBlock;
import willatendo.fossilslegacy.server.block.entity.entities.HologramProjectorBlockEntity;
import willatendo.fossilslegacy.server.hologram.HologramType;

public class HologramProjectorBlockEntityRenderer implements BlockEntityRenderer<HologramProjectorBlockEntity> {
    public HologramProjectorBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(HologramProjectorBlockEntity hologramProjectorBlockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        Holder<HologramType> hologramType = hologramProjectorBlockEntity.getHologramType();
        if (hologramType != null) {
            poseStack.pushPose();
            poseStack.scale(1.0F, -1.0F, -1.0F);
            poseStack.translate(0.5F, -2.25F, -0.5F);
            BlockState blockState = hologramProjectorBlockEntity.getBlockState();
            if (blockState != null) {
                poseStack.mulPose(Axis.YP.rotationDegrees(blockState.getValue(HologramProjectorBlock.HORIZONTAL_FACING).toYRot()));
            }
            EntityModel<?> entityModel = this.getModel(hologramType.value().modelId());
            entityModel.renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.entityTranslucent(hologramType.value().texture())), packedLight, packedOverlay, ARGB.colorFromFloat(0.5F, 1.0F, 1.0F, 1.0F));
            poseStack.popPose();
        }
    }

    public EntityModel<?> getModel(ResourceLocation id) {
        if (JsonModelLoader.isJsonModel(id)) {
            return JsonModelLoader.getModel(id);
        } else {
            return null;
        }
    }
}
