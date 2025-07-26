package willatendo.fossilslegacy.client.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import willatendo.fossilslegacy.network.NetworkUtils;
import willatendo.fossilslegacy.network.serverbound.ServerboundStartTimeMachinePacket;
import willatendo.fossilslegacy.server.block.entity.entities.TimeMachineBlockEntity;
import willatendo.fossilslegacy.server.menu.menus.TimeMachineMenu;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class TimeMachineScreen extends AbstractContainerScreen<TimeMachineMenu> {
    private static final ResourceLocation TEXTURE = FAUtils.resource("textures/gui/container/time_machine.png");
    private static final ResourceLocation CLOCK_SPRITE = FAUtils.resource("container/time_machine/clock");

    public TimeMachineScreen(TimeMachineMenu timeMachineMenu, Inventory inventory, Component component) {
        super(timeMachineMenu, inventory, component);
    }

    @Override
    protected void init() {
        super.init();
        this.addRenderableWidget(TimeMachineButton.create(FAUtils.translation("container", "time_machine.start"), button -> {
            if (this.menu.getSlot(0).hasItem() && this.menu.isCharged()) {
                NetworkUtils.sendToServer(new ServerboundStartTimeMachinePacket(this.menu.timeMachineBlockEntity.getBlockPos()));
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
        int leftPos = this.leftPos;
        int topPos = this.topPos;
        guiGraphics.blit(RenderType::guiTextured, TEXTURE, leftPos, topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);
        float charge = ((float) (TimeMachineBlockEntity.MAX_CHARGE - this.menu.getChargeLevel())) / (float) TimeMachineBlockEntity.MAX_CHARGE;
        int height = (int) (charge * (float) 75.0F);
        guiGraphics.blitSprite(RenderType::guiTextured, CLOCK_SPRITE, 76, 76, 0, 0, leftPos + 50, topPos + 6, 75, height);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int x, int y) {
        super.renderLabels(guiGraphics, x, y);
        String precentage = this.menu.getChargeLevel() / 10 + "%";
        int secondWordPosX = (34 - this.font.width(precentage)) / 2;
        guiGraphics.drawString(this.font, Component.literal(precentage), 131 + secondWordPosX, 60, 0xff0000);
    }
}
