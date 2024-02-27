package willatendo.fossilsexperiments.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import willatendo.fossilsexperiments.server.block.entity.TimeMachineBlockEntity;
import willatendo.fossilsexperiments.server.menu.TimeMachineMenu;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class TimeMachineScreen extends AbstractContainerScreen<TimeMachineMenu> {
	private static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/gui/time_machine.png");

	public TimeMachineScreen(TimeMachineMenu timeMachineMenu, Inventory inventory, Component component) {
		super(timeMachineMenu, inventory, component);
	}

	@Override
	protected void init() {
		super.init();
		this.addWidget(Button.builder(FossilsLegacyUtils.translation("menu", "time_machine.start"), button -> {
		}).bounds(this.leftPos + 131, this.topPos + 18, 34, 14).build());
		this.addWidget(Button.builder(FossilsLegacyUtils.translation("menu", "time_machine.memory"), button -> {
		}).bounds(this.leftPos + 131, this.topPos + 56, 34, 14).build());
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
		float charge = ((float) (TimeMachineBlockEntity.MAX_CHARGE - this.menu.getContainerData().get(0))) / (float) TimeMachineBlockEntity.MAX_CHARGE;
		int height = (int) (charge * (float) 75.0F);
		guiGraphics.blit(TEXTURE, leftPos + 51, topPos + 6, 177, 1, 75, height);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int x, int y) {
		super.renderLabels(guiGraphics, x, y);
		String precentage = this.menu.getContainerData().get(0) / 10 + "%";
		int secondWordPosX = (34 - this.font.width(precentage)) / 2;
		guiGraphics.drawString(this.font, Component.literal(precentage), 131 + secondWordPosX, 40, 0xFF0000);
	}
}
