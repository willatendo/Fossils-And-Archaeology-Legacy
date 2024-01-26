package willatendo.fossilslegacy.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import willatendo.fossilslegacy.server.menu.FeederMenu;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FeederScreen extends AbstractContainerScreen<FeederMenu> {
	private static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/gui/feeder.png");

	public FeederScreen(FeederMenu feederMenu, Inventory inventory, Component title) {
		super(feederMenu, inventory, title);
	}

	@Override
	public void render(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
		super.render(guiGraphics, x, y, partialTicks);
		this.renderTooltip(guiGraphics, x, y);
		guiGraphics.drawString(this.font, this.menu.feederBlockEntity.containerData.get(0) + "", this.leftPos + 25, this.topPos + 32, 0xFF0000);
		guiGraphics.drawString(this.font, this.menu.feederBlockEntity.containerData.get(1) + "", this.leftPos + 121, this.topPos + 32, 0x3B703);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int x, int y) {
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, TEXTURE);
		int leftPos = this.leftPos;
		int topPos = this.topPos;
		guiGraphics.blit(TEXTURE, leftPos, topPos, 0, 0, this.imageWidth, this.imageHeight);
		int meat = this.menu.getMeatScaled(46);
		guiGraphics.blit(TEXTURE, leftPos + 67, topPos + 55 - meat, 176, 46 - meat, 3, meat);
		int plants = this.menu.getPlantsScaled(46);
		guiGraphics.blit(TEXTURE, leftPos + 111, topPos + 55 - plants, 176, 46 - plants, 3, plants);
	}
}
