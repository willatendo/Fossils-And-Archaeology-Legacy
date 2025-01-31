package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.mixin.client.ModelManagerAccessor;

import java.util.Map;

public class TridentLikeItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {
    private final ModelResourceLocation model3d;
    private final ModelResourceLocation model2d;

    public TridentLikeItemRenderer(ModelResourceLocation model2d, ModelResourceLocation model3d) {
        this.model2d = model2d;
        this.model3d = model3d;
    }

    @Override
    public void render(ItemStack itemStack, ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        if (!itemStack.isEmpty()) {
            ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

            poseStack.pushPose();
            boolean gui = itemDisplayContext == ItemDisplayContext.GUI || itemDisplayContext == ItemDisplayContext.GROUND || itemDisplayContext == ItemDisplayContext.FIXED;

            BakedModel model;
            ModelManager modelManager = itemRenderer.getItemModelShaper().getModelManager();
            Map<ModelResourceLocation, BakedModel> bakedRegistry = ((ModelManagerAccessor) modelManager).getBakedRegistry();
            if (gui) {
                model = bakedRegistry.getOrDefault(this.model2d, modelManager.getMissingModel());
            } else {
                model = bakedRegistry.getOrDefault(this.model3d, modelManager.getMissingModel());
            }
            RenderType renderType = ItemBlockRenderTypes.getRenderType(itemStack, true);
            VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(multiBufferSource, renderType, true, itemStack.hasFoil());
            itemRenderer.renderModelLists(model, itemStack, packedLight, packedOverlay, poseStack, vertexconsumer);
            poseStack.popPose();
        }
    }
}
