package willatendo.fossilslegacy.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import willatendo.fossilslegacy.server.menu.ArchaeologyWorkbenchMenu;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class ArchaeologyWorkbenchScreen extends AbstractContainerScreen<ArchaeologyWorkbenchMenu> {
    private static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/gui/container/archaeology_workbench.png");
    private static final ResourceLocation ARCHAEOLOGY_PROGRESS_SPRITE = FossilsLegacyUtils.resource("container/archaeology_workbench/archaeology_progress");
    private static final ResourceLocation INFORMATION_PROGRESS_SPRITE = FossilsLegacyUtils.resource("container/archaeology_workbench/information_progress");

    public ArchaeologyWorkbenchScreen(ArchaeologyWorkbenchMenu archaeologyWorkbenchMenu, Inventory inventory, Component title) {
        super(archaeologyWorkbenchMenu, inventory, title);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
        super.render(guiGraphics, x, y, partialTicks);
        this.renderTooltip(guiGraphics, x, y);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int x, int y) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int leftPos = this.leftPos;
        int topPos = this.topPos;
        guiGraphics.blit(TEXTURE, leftPos, topPos, 0, 0, this.imageWidth, this.imageHeight);
        if (this.menu.isOn()) {
            int onProgess = Mth.ceil(this.menu.getOnProgress() * 13.0F) + 1;
            guiGraphics.blitSprite(INFORMATION_PROGRESS_SPRITE, 14, 14, 0, 14 - onProgess, leftPos + 81, topPos + 36 + 14 - onProgess, 14, onProgess);
        }

        int archaeologyProgess = this.menu.getArchaeologyProgress();
        guiGraphics.blitSprite(ARCHAEOLOGY_PROGRESS_SPRITE, 24, 14, 0, 0, leftPos + 76, topPos + 21, archaeologyProgess + 1, 14);
    }
}
