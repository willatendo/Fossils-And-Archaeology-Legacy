package willatendo.fossilslegacy.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.entity.Velociraptor;
import willatendo.fossilslegacy.server.entity.genetics.FossilsLegacyCoatTypeTags;
import willatendo.fossilslegacy.server.entity.genetics.FossilsLegacyCoatTypes;

public class VelociraptorHoldItemInMouthLayer<T extends EntityModel<Velociraptor>> extends RenderLayer<Velociraptor, T> {
    private final ItemInHandRenderer itemInHandRenderer;

    public VelociraptorHoldItemInMouthLayer(RenderLayerParent<Velociraptor, T> renderLayerParent, ItemInHandRenderer itemInHandRenderer) {
        super(renderLayerParent);
        this.itemInHandRenderer = itemInHandRenderer;
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks, Velociraptor velociraptor, float position, float speed, float packedOverlay, float bob, float headPitch, float headYaw) {
        float ageOffset = ((velociraptor.getCoatType().is(FossilsLegacyCoatTypeTags.LEGACY_VELOCIRAPTOR) ? 1.0F : 0.5F) + 0.0F * ((float) velociraptor.getGrowthStage()));
        ItemStack heldItem = velociraptor.getHeldItem();
        poseStack.pushPose();
        poseStack.mulPose(Axis.ZP.rotation(60.0F));
        poseStack.mulPose(Axis.XP.rotation(-90.0F));
        poseStack.mulPose(Axis.ZP.rotation(20.0F));
        float scale = 0.625F;
        poseStack.scale(scale * ageOffset, scale * ageOffset, scale * ageOffset);
        this.itemInHandRenderer.renderItem(velociraptor, heldItem, ItemDisplayContext.GROUND, false, poseStack, multiBufferSource, partialTicks);
        poseStack.popPose();
    }
}
