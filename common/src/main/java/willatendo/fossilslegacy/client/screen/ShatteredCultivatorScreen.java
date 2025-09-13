package willatendo.fossilslegacy.client.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import willatendo.fossilslegacy.server.menu.menus.ShatteredCultivatorMenu;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class ShatteredCultivatorScreen extends AbstractContainerScreen<ShatteredCultivatorMenu> {
    private static final ResourceLocation TEXTURE = FAUtils.resource("textures/gui/container/shattered_cultivator.png");

    public ShatteredCultivatorScreen(ShatteredCultivatorMenu shatteredCultivatorMenu, Inventory inventory, Component title) {
        super(shatteredCultivatorMenu, inventory, title);
        this.imageHeight = 133;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
        int leftPos = this.leftPos;
        int topPos = this.topPos;
        guiGraphics.blit(RenderType::guiTextured, TEXTURE, leftPos, topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);
    }
}
