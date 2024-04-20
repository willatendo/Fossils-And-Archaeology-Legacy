package willatendo.fossilslegacy.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import willatendo.fossilslegacy.server.menu.AnalyzerMenu;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class AnalyzerScreen extends AbstractContainerScreen<AnalyzerMenu> {
	private static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/gui/analyzer.png");

	public AnalyzerScreen(AnalyzerMenu analyzerMenu, Inventory inventory, Component title) {
		super(analyzerMenu, inventory, title);
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

		int analyzerProgess = this.menu.getAnalyzerProgress();
		guiGraphics.blit(TEXTURE, leftPos + 68, topPos + 39, 176, 0, analyzerProgess + 1, 22);
	}
}
