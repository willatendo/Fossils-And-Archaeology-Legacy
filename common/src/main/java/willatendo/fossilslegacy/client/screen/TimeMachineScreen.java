package willatendo.fossilslegacy.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.block.entity.TimeMachineBlockEntity;
import willatendo.fossilslegacy.server.menu.TimeMachineMenu;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class TimeMachineScreen extends AbstractContainerScreen<TimeMachineMenu> {
    private static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/gui/container/time_machine.png");
    private static final ResourceLocation CLOCK_SPRITE = FossilsLegacyUtils.resource("container/time_machine/clock");

    public TimeMachineScreen(TimeMachineMenu timeMachineMenu, Inventory inventory, Component component) {
        super(timeMachineMenu, inventory, component);
    }

    @Override
    protected void init() {
        super.init();
        this.addRenderableWidget(TimeMachineButton.create(FossilsLegacyUtils.translation("menu", "time_machine.start"), button -> {
            if (this.menu.getSlot(0).hasItem() && this.menu.isCharged()) {
                FossilsModloaderHelper.INSTANCE.sendTimeMachinePacket(this.menu.timeMachineBlockEntity.getBlockPos());
            }
        }).bounds(this.leftPos + 131, this.topPos + 18, 34, 14).build());
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
        float charge = ((float) (TimeMachineBlockEntity.MAX_CHARGE - this.menu.getChargeLevel())) / (float) TimeMachineBlockEntity.MAX_CHARGE;
        int height = (int) (charge * (float) 75.0F);
        guiGraphics.blitSprite(CLOCK_SPRITE, 76, 76, 0, 0, leftPos + 50, topPos + 6, 75, height);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int x, int y) {
        super.renderLabels(guiGraphics, x, y);
        String precentage = this.menu.getChargeLevel() / 10 + "%";
        int secondWordPosX = (34 - this.font.width(precentage)) / 2;
        guiGraphics.drawString(this.font, Component.literal(precentage), 131 + secondWordPosX, 60, 0xff0000);
    }
}
