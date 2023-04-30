package fossilslegacy.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import fossilslegacy.server.menu.CultivatorMenu;
import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CultivatorScreen extends AbstractContainerScreen<CultivatorMenu> {
	private static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/gui/cultivator.png");

	public CultivatorScreen(CultivatorMenu archaeologyWorkbenchMenu, Inventory inventory, Component title) {
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
		this.blit(poseStack, leftPos, topPos, 0, 0, this.imageWidth, this.imageHeight);
		if (this.menu.isOn()) {
			int onProgess = this.menu.getOnProgress();
			this.blit(poseStack, leftPos + 81, topPos + 36 + 13 - onProgess, 176, 13 - onProgess, 14, onProgess + 1);
		}

		int cultivationProgess = this.menu.getCultivationProgress();
		this.blit(poseStack, leftPos + 77, topPos + 23, 176, 14, cultivationProgess + 1, 22);
	}
}
