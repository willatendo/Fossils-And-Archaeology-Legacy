package willatendo.fossilslegacy.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class SkullOverlayScreen implements IGuiOverlay {
    @Override
    public void render(ForgeGui forgeGui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        Minecraft minecraft = forgeGui.getMinecraft();
        ItemStack itemstack = minecraft.player.getInventory().getArmor(3);
        if (itemstack.is(FossilsLegacyBlocks.SKULL_BLOCK.get().asItem())) {
            if (minecraft.options.getCameraType().isFirstPerson() && !itemstack.isEmpty() && !minecraft.player.isScoping()) {
                forgeGui.renderTextureOverlay(guiGraphics, FossilsLegacyUtils.resource("textures/gui/skullblur.png"), 1.0F);
            }
        }
    }
}
