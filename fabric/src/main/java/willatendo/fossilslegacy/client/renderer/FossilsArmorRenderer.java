package willatendo.fossilslegacy.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.client.FAModelLayers;
import willatendo.fossilslegacy.client.FossilsLegacyClient;
import willatendo.fossilslegacy.client.model.CaptainsHatModel;
import willatendo.fossilslegacy.server.item.FAItems;

public class FossilsArmorRenderer implements ArmorRenderer {
    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, ItemStack itemStack, HumanoidRenderState humanoidRenderState, EquipmentSlot equipmentSlot, int packedLight, HumanoidModel<HumanoidRenderState> humanoidModel) {
        if (itemStack.is(FAItems.CAPTAINS_HAT.get())) {
            CaptainsHatModel captainsHatModel = new CaptainsHatModel(Minecraft.getInstance().getEntityModels().bakeLayer(FAModelLayers.CAPTAINS_HAT));
            captainsHatModel.copyPropertiesTo(humanoidModel);

            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.armorCutoutNoCull(FossilsLegacyClient.CAPTAINS_HAT));
            captainsHatModel.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, -1);

            if (itemStack.hasFoil()) {
                captainsHatModel.renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.armorEntityGlint()), packedLight, OverlayTexture.NO_OVERLAY, -1);
            }
        }
    }
}
