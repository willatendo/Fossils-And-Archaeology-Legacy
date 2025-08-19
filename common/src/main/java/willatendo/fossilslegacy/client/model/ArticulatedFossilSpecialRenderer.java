package willatendo.fossilslegacy.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.special.NoDataSpecialModelRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.client.model.json.JsonModelLoader;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;
import willatendo.fossilslegacy.server.item.FADataComponents;

public class ArticulatedFossilSpecialRenderer implements NoDataSpecialModelRenderer {
    private Holder<FossilVariant> fossilVariantHolder;

    @Override
    public Void extractArgument(ItemStack itemStack) {
        this.fossilVariantHolder = itemStack.get(FADataComponents.FOSSIL_VARIANT.get());
        return NoDataSpecialModelRenderer.super.extractArgument(itemStack);
    }

    @Override
    public void render(ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay, boolean hasFoilType) {
        if (this.fossilVariantHolder != null) {
            FossilVariant fossilVariant = this.fossilVariantHolder.value();
            ResourceLocation model = fossilVariant.model();

            if (JsonModelLoader.isJsonModel(model)) {
                poseStack.pushPose();
                poseStack.scale(-0.5F, -0.5F, 0.5F);
                poseStack.translate(-1.0F, -1.501F, 1.0F);
                JsonModelLoader.getModel(model).renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(fossilVariant.texture())), packedLight, packedOverlay);
                poseStack.popPose();
            }
        }
    }

    public record Unbaked() implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<ArticulatedFossilSpecialRenderer.Unbaked> MAP_CODEC = MapCodec.unit(new ArticulatedFossilSpecialRenderer.Unbaked());

        @Override
        public MapCodec<ArticulatedFossilSpecialRenderer.Unbaked> type() {
            return MAP_CODEC;
        }

        @Override
        public SpecialModelRenderer<?> bake(EntityModelSet modelSet) {
            return new ArticulatedFossilSpecialRenderer();
        }
    }
}
