package willatendo.fossilslegacy.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.gui.overlay.ExtendedGui;
import net.neoforged.neoforge.client.gui.overlay.IGuiOverlay;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class SkullOverlayScreen implements IGuiOverlay {
    @Override
    public void render(ExtendedGui extendedGui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        Minecraft minecraft = extendedGui.getMinecraft();
        ItemStack itemstack = minecraft.player.getInventory().getArmor(3);
        if (itemstack.is(FossilsLegacyBlocks.SKULL_BLOCK.get().asItem())) {
            if (minecraft.options.getCameraType().isFirstPerson() && !itemstack.isEmpty() && !minecraft.player.isScoping()) {
                extendedGui.renderTextureOverlay(guiGraphics, FossilsLegacyUtils.resource("textures/gui/skullblur.png"), 1.0F);
            }
        }
    }
}
