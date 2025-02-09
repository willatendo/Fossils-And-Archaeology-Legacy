package willatendo.fossilslegacy.mixin.client;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.utils.FAUtils;

@Mixin(Gui.class)
public abstract class GuiMixin {
    @Shadow
    @Final
    private Minecraft minecraft;

    @Inject(method = "renderCameraOverlays", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Inventory;getArmor(I)Lnet/minecraft/world/item/ItemStack;"), cancellable = true)
    private void fossil_renderSkullOverlay(GuiGraphics guiGraphics, DeltaTracker deltaTracker, CallbackInfo callbackInfo) {
        ItemStack itemStack = this.minecraft.player.getInventory().getArmor(3);

        RenderTextureOverlayAccessor renderTextureOverlayAccessor = (RenderTextureOverlayAccessor) this;
        if (itemStack.is(FABlocks.SKULL_BLOCK.get().asItem())) {
            renderTextureOverlayAccessor.fossil_renderTextureOverlay(guiGraphics, FAUtils.resource("textures/misc/skullblur.png"), 1.0F);
        }
    }
}