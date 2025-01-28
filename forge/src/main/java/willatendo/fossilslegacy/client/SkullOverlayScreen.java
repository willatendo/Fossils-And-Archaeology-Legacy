package willatendo.fossilslegacy.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class SkullOverlayScreen implements LayeredDraw.Layer {
    @Override
    public void render(GuiGraphics guiGraphics, DeltaTracker deltaTracker) {
        Minecraft minecraft = Minecraft.getInstance();
        ItemStack itemstack = minecraft.player.getInventory().getArmor(3);
        if (itemstack.is(FABlocks.SKULL_BLOCK.get().asItem())) {
            if (minecraft.options.getCameraType().isFirstPerson() && !itemstack.isEmpty() && !minecraft.player.isScoping()) {
                RenderSystem.disableDepthTest();
                RenderSystem.depthMask(false);
                RenderSystem.enableBlend();
                guiGraphics.setColor(1.0F, 1.0F, 1.0F, 1.0F);
                guiGraphics.blit(FossilsLegacyUtils.resource("textures/misc/skullblur.png"), 0, 0, -90, 0.0F, 0.0F, guiGraphics.guiWidth(), guiGraphics.guiHeight(), guiGraphics.guiWidth(), guiGraphics.guiHeight());
                RenderSystem.disableBlend();
                RenderSystem.depthMask(true);
                RenderSystem.enableDepthTest();
                guiGraphics.setColor(1.0F, 1.0F, 1.0F, 1.0F);
            }
        }
    }
}
