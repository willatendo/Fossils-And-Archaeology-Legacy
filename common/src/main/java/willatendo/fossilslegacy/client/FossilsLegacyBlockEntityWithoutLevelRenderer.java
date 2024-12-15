package willatendo.fossilslegacy.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.client.model.json.JsonModelLoader;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.item.FossilsLegacyDataComponents;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

public final class FossilsLegacyBlockEntityWithoutLevelRenderer extends BlockEntityWithoutLevelRenderer {
    public static final FossilsLegacyBlockEntityWithoutLevelRenderer INSTANCE = new FossilsLegacyBlockEntityWithoutLevelRenderer();

    private FossilsLegacyBlockEntityWithoutLevelRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    @Override
    public void renderByItem(ItemStack itemStack, ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        if (itemStack.is(FossilsLegacyItems.ARTICULATED_FOSSIL.get())) {
            Holder<FossilVariant> fossilVariantHolder = itemStack.get(FossilsLegacyDataComponents.FOSSIL_VARIANT.get());
            if (fossilVariantHolder != null) {
                FossilVariant fossilVariant = fossilVariantHolder.value();
                ResourceLocation model = fossilVariant.model();

                if (JsonModelLoader.isJsonModel(model)) {
                    poseStack.pushPose();
                    poseStack.scale(-0.5F, -0.5F, 0.5F);
                    poseStack.translate(-1.0F, -1.501F, 1.0F);
                    JsonModelLoader.getModel(model).renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(fossilVariant.texture())), packedLight, packedOverlay);
                    poseStack.popPose();
                }

                if (JsonModelLoader.isBuiltInModel(model)) {
                    poseStack.pushPose();
                    poseStack.scale(-0.5F, -0.5F, 0.5F);
                    poseStack.translate(-1.0F, -1.501F, 1.0F);
                    JsonModelLoader.getBuiltInModel(model, true).renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(fossilVariant.texture())), packedLight, packedOverlay);
                    poseStack.popPose();
                }
            }
        }
    }
}
