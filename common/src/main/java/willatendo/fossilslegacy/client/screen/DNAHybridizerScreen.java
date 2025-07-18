package willatendo.fossilslegacy.client.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import willatendo.fossilslegacy.server.menu.menus.DNAHybridizerMenu;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class DNAHybridizerScreen extends AbstractContainerScreen<DNAHybridizerMenu> {
    private static final ResourceLocation ENCODER_TEXTURE = FAUtils.resource("textures/gui/container/dna_hybridizer.png");
    private static final ResourceLocation HYBRIDIZATION_PROGRESS_SPRITE = FAUtils.resource("container/dna_hybridizer/hybridization_progress");

    public DNAHybridizerScreen(DNAHybridizerMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
        super.render(guiGraphics, x, y, partialTicks);
        this.renderTooltip(guiGraphics, x, y);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int x, int y) {
        guiGraphics.blit(RenderType::guiTextured, ENCODER_TEXTURE, this.leftPos, this.topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);
        guiGraphics.blitSprite(RenderType::guiTextured, HYBRIDIZATION_PROGRESS_SPRITE, 39, 17, 0, 0, this.leftPos + 63, this.topPos + 35, Mth.ceil(this.menu.getHybridizationProgress() * 39.0F), 17);
    }
}
