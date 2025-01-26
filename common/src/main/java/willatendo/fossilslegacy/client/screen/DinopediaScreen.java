package willatendo.fossilslegacy.client.screen;

import net.minecraft.client.GameNarrator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.PageButton;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.item.dinopedia.DinopediaEntry;
import willatendo.fossilslegacy.server.item.dinopedia.line.BuiltInDinopediaLines;

import java.util.ArrayList;
import java.util.List;

public class DinopediaScreen extends Screen {
    public static final ResourceLocation BOOK_LOCATION = ResourceLocation.withDefaultNamespace("textures/gui/book.png");
    private final List<DinopediaEntry> dinopediaEntries;
    private final Player player;
    private final LivingEntity livingEntity;
    private final DinopediaInformation dinopediaInformation;
    private int index = 0;
    private PageButton forwardButton;
    private PageButton backButton;

    public DinopediaScreen(Player player, LivingEntity livingEntity, DinopediaInformation dinopediaInformation) {
        super(GameNarrator.NO_TITLE);
        RegistryAccess registryAccess = Minecraft.getInstance().level.registryAccess();
        if (dinopediaInformation.getDinopediaType().isPresent()) {
            this.dinopediaEntries = registryAccess.registryOrThrow(FossilsLegacyRegistries.DINOPEDIA_TYPE).get(dinopediaInformation.getDinopediaType().get()).dinopediaEntries().stream().map(dinopediaEntry -> registryAccess.registryOrThrow(FossilsLegacyRegistries.DINOPEDIA_ENTRY).get(dinopediaEntry)).toList();
        } else {
            this.dinopediaEntries = List.of();
        }

        this.player = player;
        this.livingEntity = livingEntity;
        this.dinopediaInformation = dinopediaInformation;
    }

    @Override
    protected void init() {
        int leftPos = (this.width - 192) / 2;
        int topPos = (this.height / 2) - (182 / 2);
        this.forwardButton = this.addRenderableWidget(new PageButton(leftPos + 116, topPos + 157, true, button -> {
            if (this.index + 1 < this.dinopediaEntries.size()) {
                this.index++;

                this.updateButtonVisibility();
            }
        }, true));
        this.backButton = this.addRenderableWidget(new PageButton(leftPos + 45, topPos + 157, false, button -> {
            if (this.index - 1 >= 0) {
                this.index--;

                this.updateButtonVisibility();
            }
        }, true));
        this.updateButtonVisibility();
    }

    private void updateButtonVisibility() {
        this.forwardButton.visible = this.index < this.dinopediaEntries.size() - 1;
        this.backButton.visible = this.index > 0;
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (super.keyPressed(keyCode, scanCode, modifiers)) {
            return true;
        } else {
            switch (keyCode) {
                case 266:
                    this.backButton.onPress();
                    return true;
                case 267:
                    this.forwardButton.onPress();
                    return true;
                default:
                    return false;
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.livingEntity.isAlive() || !this.player.isAlive()) {
            this.onClose();
        }
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);

        DinopediaEntry dinopediaEntry = this.dinopediaEntries.get(this.index);
        int leftPos = (this.width - 192) / 2;
        int topPos = (this.height / 2) - (182 / 2);

        int textStart = 20;

        if (dinopediaEntry.drawEntity()) {
            textStart = 90;
            this.livingEntity.tickCount = this.player.tickCount;
            GeneModificationTableScreen.renderEntityInInventoryFollowsMouse(guiGraphics, leftPos + 20, topPos + 15, leftPos + 172, topPos + 80, 16, 1.0F, 0.25F, mouseX, mouseY, this.livingEntity);
        }

        List<Component> components = new ArrayList<>();
        if (this.dinopediaInformation.getDinopediaType().isPresent()) {
            if (this.dinopediaInformation instanceof Entity entity) {
                components = dinopediaEntry.getText(entity, this.player);
            }
        } else {
            components = this.dinopediaInformation.info(this.player);
        }

        if (!components.isEmpty()) {
            boolean displayName = dinopediaEntry.line().contains(BuiltInDinopediaLines.DISPLAY_NAME);
            if (displayName) {
                this.drawCenteredStringMinusShadow(guiGraphics, this.font, components.getFirst(), leftPos, topPos + textStart, 0, dinopediaEntry.centerText());
            }

            for (int i = displayName ? 1 : 0; i < components.size(); i++) {
                this.drawCenteredStringMinusShadow(guiGraphics, this.font, components.get(i), leftPos, topPos + textStart + (displayName ? 10 : 0) + (i * 10), 0, dinopediaEntry.centerText());
            }
        }
    }

    private void drawCenteredStringMinusShadow(GuiGraphics guiGraphics, Font font, Component text, int x, int y, int color, boolean centered) {
        int drawX = x + 36;
        if (centered) {
            drawX = x - (font.width(text) / 2) + (192 / 2);
        }
        guiGraphics.drawString(font, text, drawX, y, color, false);
    }

    @Override
    public void renderBackground(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderTransparentBackground(guiGraphics);
        guiGraphics.blit(BOOK_LOCATION, (this.width - 192) / 2, (this.height / 2) - (182 / 2), 0, 0, 192, 192);
    }
}
