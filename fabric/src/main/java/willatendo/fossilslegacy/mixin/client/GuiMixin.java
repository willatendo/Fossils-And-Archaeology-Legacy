package willatendo.fossilslegacy.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.Gui;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

@Mixin(Gui.class)
public abstract class GuiMixin {
    @Shadow
    protected abstract void renderTextureOverlay(ResourceLocation texture, float opacity);

    @Inject(at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/entity/player/Inventory;getArmor(I)Lnet/minecraft/world/item/ItemStack;"), method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;F)V", locals = LocalCapture.CAPTURE_FAILSOFT)
    private void render(PoseStack poseStack, float scopeScale, CallbackInfo callbackInfo, Font font, ItemStack itemStack) {
        if (itemStack.getItem() == FossilsLegacyBlocks.SKULL_BLOCK.get().asItem()) {
            this.renderTextureOverlay(FossilsLegacyUtils.resource("textures/gui/skullblur.png"), 1.0F);
        }
    }
}
