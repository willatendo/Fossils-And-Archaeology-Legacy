package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.block.entity.entities.VaseBlockEntity;

public class VaseRenderer implements BlockEntityRenderer<VaseBlockEntity> {
    private final ItemRenderer itemRenderer;

    public VaseRenderer(BlockEntityRendererProvider.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(VaseBlockEntity vaseBlockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        ItemStack itemStack = vaseBlockEntity.getTheItem();
        int blockPosSeed = (int) vaseBlockEntity.getBlockPos().asLong();
        int count = vaseBlockEntity.getCount();
        if (itemStack != ItemStack.EMPTY) {
            if (count > 13) {
                count = 13;
            }
            for (int i = 0; i < count; i++) {
                poseStack.pushPose();
                poseStack.translate(0.5F, 0.15F + (0.05F * i), 0.5F);
                poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
                poseStack.mulPose(Axis.ZP.rotationDegrees(0.0F + (22.5F * i)));
                poseStack.scale(0.375F, 0.375F, 0.375F);
                this.itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, packedLight, packedOverlay, poseStack, multiBufferSource, vaseBlockEntity.getLevel(), blockPosSeed);
                poseStack.popPose();
            }
        }
    }
}
