package fossilslegacy.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import fossilslegacy.server.menu.AnalyzerMenu;
import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class AnalyzerScreen extends AbstractContainerScreen<AnalyzerMenu> {
	private static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/gui/analyzer.png");

	public AnalyzerScreen(AnalyzerMenu analyzerMenu, Inventory inventory, Component title) {
		super(analyzerMenu, inventory, title);
	}

	@Override
	public void render(PoseStack poseStack, int x, int y, float partialTicks) {
		this.renderBackground(poseStack);
		super.render(poseStack, x, y, partialTicks);
		this.renderTooltip(poseStack, x, y);
	}

	@Override
	protected void renderBg(PoseStack poseStack, float partialTicks, int x, int y) {
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, TEXTURE);
		int leftPos = this.leftPos;
		int topPos = this.topPos;
		this.blit(poseStack, leftPos, topPos, 0, 0, this.imageWidth, this.imageHeight);

		int analyzerProgess = this.menu.getAnalyzerProgress();
		this.blit(poseStack, leftPos + 68, topPos + 39, 176, 0, analyzerProgess + 1, 22);
	}
}
