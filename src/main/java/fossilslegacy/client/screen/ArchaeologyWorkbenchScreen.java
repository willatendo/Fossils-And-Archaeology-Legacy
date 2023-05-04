package fossilslegacy.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import fossilslegacy.server.menu.ArchaeologyWorkbenchMenu;
import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ArchaeologyWorkbenchScreen extends AbstractContainerScreen<ArchaeologyWorkbenchMenu> {
	private static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/gui/archaeology_workbench.png");

	public ArchaeologyWorkbenchScreen(ArchaeologyWorkbenchMenu archaeologyWorkbenchMenu, Inventory inventory, Component title) {
		super(archaeologyWorkbenchMenu, inventory, title);
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
		blit(poseStack, leftPos, topPos, 0, 0, this.imageWidth, this.imageHeight);
		if (this.menu.isOn()) {
			int onProgess = this.menu.getOnProgress();
			blit(poseStack, leftPos + 81, topPos + 36 + 13 - onProgess, 176, 13 - onProgess, 14, onProgess + 1);
		}

		int archaeologyProgess = this.menu.getArchaeologyProgress();
		blit(poseStack, leftPos + 76, topPos + 21, 176, 14, archaeologyProgess + 1, 16);
	}
}
