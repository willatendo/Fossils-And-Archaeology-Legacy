package willatendo.fossilslegacy.client.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import willatendo.fossilslegacy.server.menu.menus.DNACoderMenu;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class DNACoderScreen extends AbstractContainerScreen<DNACoderMenu> {
    private static final ResourceLocation ENCODER_TEXTURE = FAUtils.resource("textures/gui/container/dna_encoder.png");
    public static final ResourceLocation EMPTY_SLOT_DISC = FAUtils.resource("container/slot/disc");
    private static final ResourceLocation CODE_PROGRESS_SPRITE = FAUtils.resource("container/dna_coder/code_progress");

    public DNACoderScreen(DNACoderMenu menu, Inventory playerInventory, Component title) {
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
        guiGraphics.blitSprite(RenderType::guiTextured, CODE_PROGRESS_SPRITE, 24, 16, 0, 0, this.leftPos + 79, this.topPos + 34, Mth.ceil(this.menu.getCodeProgress() * 24.0F), 16);
    }
}
