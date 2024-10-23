package willatendo.fossilslegacy.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import willatendo.fossilslegacy.server.menu.PalaeontologyTableMenu;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class PalaeontologyTableScreen extends AbstractContainerScreen<PalaeontologyTableMenu> {
    private static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/gui/container/palaeontology_table.png");

    public PalaeontologyTableScreen(PalaeontologyTableMenu palaeontologyTableMenu, Inventory inventory, Component title) {
        super(palaeontologyTableMenu, inventory, title);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
        super.render(guiGraphics, x, y, partialTicks);
        this.renderTooltip(guiGraphics, x, y);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        guiGraphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }
}
