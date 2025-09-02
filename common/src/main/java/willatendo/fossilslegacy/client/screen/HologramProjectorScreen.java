package willatendo.fossilslegacy.client.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import willatendo.fossilslegacy.server.menu.menus.HologramProjectorMenu;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class HologramProjectorScreen extends AbstractContainerScreen<HologramProjectorMenu> {
    private static final ResourceLocation TEXTURE = FAUtils.resource("textures/gui/container/cultivator.png");

    public HologramProjectorScreen(HologramProjectorMenu hologramProjectorMenu, Inventory playerInventory, Component title) {
        super(hologramProjectorMenu, playerInventory, title);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
        super.render(guiGraphics, x, y, partialTicks);
        this.renderTooltip(guiGraphics, x, y);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int x, int y) {
        int leftPos = this.leftPos;
        int topPos = this.topPos;
        guiGraphics.blit(RenderType::guiTextured, TEXTURE, leftPos, topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);
    }
}
