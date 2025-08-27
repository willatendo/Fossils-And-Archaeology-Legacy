package willatendo.fossilslegacy.client.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.entity.BlockEntity;
import willatendo.fossilslegacy.network.NetworkUtils;
import willatendo.fossilslegacy.network.serverbound.ServerboundAddNotifiedPlayerPacket;
import willatendo.fossilslegacy.network.serverbound.ServerboundRemoveNotifiedPlayerPacket;
import willatendo.fossilslegacy.server.block.entity.entities.FeederBlockEntity;
import willatendo.fossilslegacy.server.menu.menus.FeederMenu;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.UUID;

public class FeederScreen extends AbstractContainerScreen<FeederMenu> {
    private static final ResourceLocation TEXTURE = FAUtils.resource("textures/gui/container/feeder.png");
    private static final ResourceLocation FEEDER_CAPACITY_SPRITE = FAUtils.resource("container/feeder/feeder_capacity");
    private Button notifyMeButton;
    private Button dontNotifyMeButton;

    public FeederScreen(FeederMenu feederMenu, Inventory inventory, Component title) {
        super(feederMenu, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        BlockPos blockPos = this.menu.feederBlockEntity.getBlockPos();
        FeederBlockEntity feederBlockEntity = (FeederBlockEntity) this.minecraft.level.getBlockEntity(blockPos);
        UUID playerUuid = this.minecraft.player.getUUID();
        FAUtils.LOGGER.info("{}", feederBlockEntity.getNotifiedPlayers());
        boolean active = !feederBlockEntity.getNotifiedPlayers().contains(playerUuid);

        this.notifyMeButton = this.addRenderableWidget(Button.builder(FAUtils.translation("container", "feeder.notify_me"), button -> {
            NetworkUtils.sendToServer(new ServerboundAddNotifiedPlayerPacket(blockPos, playerUuid));
            FAUtils.LOGGER.info("Notify Me");
            this.notifyMeButton.active = false;
            this.dontNotifyMeButton.active = true;
        }).bounds(this.leftPos + this.imageWidth, this.topPos, 50, 20).build());
        this.notifyMeButton.active = active;
        this.dontNotifyMeButton = this.addRenderableWidget(Button.builder(FAUtils.translation("container", "feeder.dont_notify_me"), button -> {
            NetworkUtils.sendToServer(new ServerboundRemoveNotifiedPlayerPacket(blockPos, playerUuid));
            FAUtils.LOGGER.info("Don't Notify Me");
            this.notifyMeButton.active = true;
            this.dontNotifyMeButton.active = false;
        }).bounds(this.leftPos + this.imageWidth, this.topPos + 20, 50, 20).build());
        this.dontNotifyMeButton.active = !active;
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
        int leftPos = this.leftPos;
        int topPos = this.topPos;
        guiGraphics.blit(RenderType::guiTextured, TEXTURE, leftPos, topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);
        int meat = this.menu.getMeatScaled(46);
        guiGraphics.blitSprite(RenderType::guiTextured, FEEDER_CAPACITY_SPRITE, 3, 46, 0, 46 - meat, leftPos + 67, topPos + 55 - meat, 3, meat);
        int plants = this.menu.getPlantsScaled(46);
        guiGraphics.blitSprite(RenderType::guiTextured, FEEDER_CAPACITY_SPRITE, 3, 46, 0, 46 - plants, leftPos + 111, topPos + 55 - plants, 3, plants);
    }
}
