package willatendo.fossilslegacy.client.screen;

import net.minecraft.client.GameNarrator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.PageButton;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.dinopedia_entry.DinopediaEntry;
import willatendo.fossilslegacy.server.dinopedia_entry.line.BuiltInDinopediaLines;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.ArrayList;
import java.util.List;

public class DinopediaScreen extends Screen {
    private static final ResourceLocation DINOPEDIA_TEXTURE = FAUtils.resource("textures/gui/container/dinopedia.png");
    private final int imageWidth = 280;
    private final int imageHeight = 180;
    private final List<DinopediaEntry> dinopediaEntries;
    private final Player player;
    private final LivingEntity livingEntity;
    private final DinopediaInformation dinopediaInformation;
    private final int pages;
    private int page = 0;
    private PageButton forwardButton;
    private PageButton backButton;

    public DinopediaScreen(Player player, LivingEntity livingEntity, DinopediaInformation dinopediaInformation) {
        super(GameNarrator.NO_TITLE);
        RegistryAccess registryAccess = Minecraft.getInstance().level.registryAccess();
        if (dinopediaInformation.getDinopediaType().isPresent()) {
            this.dinopediaEntries = registryAccess.lookupOrThrow(FARegistries.DINOPEDIA_TYPE).getValue(dinopediaInformation.getDinopediaType().get()).dinopediaEntries().stream().map(dinopediaEntry -> registryAccess.lookupOrThrow(FARegistries.DINOPEDIA_ENTRY).getValue(dinopediaEntry)).toList();
        } else {
            this.dinopediaEntries = List.of();
        }

        this.player = player;
        this.livingEntity = livingEntity;
        this.dinopediaInformation = dinopediaInformation;
        this.pages = (int) Math.ceil(this.dinopediaEntries.size() / 2.0D);
    }

    @Override
    protected void init() {
        int leftPos = (this.width - this.imageWidth) / 2;
        int topPos = (this.height / 2) - (this.imageHeight / 2);
        this.forwardButton = this.addRenderableWidget(new PageButton(leftPos + (this.imageWidth - 25 - 23), topPos + 157, true, button -> {
            if (this.page + 1 < this.pages) {
                this.page++;

                this.updateButtonVisibility();
            }
        }, true));
        this.backButton = this.addRenderableWidget(new PageButton(leftPos + 25, topPos + 157, false, button -> {
            if (this.page >= 0) {
                this.page--;

                this.updateButtonVisibility();
            }
        }, true));
        this.updateButtonVisibility();
    }

    private void updateButtonVisibility() {
        this.forwardButton.visible = this.page + 1 < this.pages;
        this.backButton.visible = this.page > 0;
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

        if (!this.dinopediaEntries.isEmpty()) {
            for (int i = 0; i < 2; i++) {
                int index = (this.page * 2) + i;
                if (index < this.dinopediaEntries.size()) {
                    boolean left = i % 2 == 0;
                    DinopediaEntry dinopediaEntry = this.dinopediaEntries.get(index);
                    int leftPos = (this.width - this.imageWidth) / 2;
                    int topPos = (this.height / 2) - (this.imageHeight / 2);

                    int textStart = 20;

                    if (dinopediaEntry.hasDisplayedItems()) {
                        int displayLeftPos = left ? (leftPos - (((this.imageWidth - 8) / 2) / 2)) : (leftPos + (((this.imageWidth - 8) / 2) / 2));
                        int line = 0;
                        int items = 0;
                        for (int item = 0; item < dinopediaEntry.displayedItems().get().size(); item++) {
                            DinopediaEntry.DisplayedItems displayedItems = dinopediaEntry.displayedItems().get().get(item);
                            this.drawCenteredStringMinusShadow(guiGraphics, this.font, displayedItems.description(), displayLeftPos, topPos + textStart + (line * 10) + (items * 18), 0, true);
                            line++;
                            HolderSet.Named<Item> displayedItemsList = this.player.level().registryAccess().lookupOrThrow(Registries.ITEM).getOrThrow(displayedItems.displayedItems());
                            int itemListSize = displayedItemsList.size();
                            int rows = (int) Math.ceil(itemListSize / 6.0D);
                            for (int y = 0; y < rows; y++) {
                                int preexistingCount = y * rows;
                                int rowCount = Math.min(itemListSize - preexistingCount, 6);
                                for (int x = 0; x < rowCount; x++) {
                                    int itemIndex = (y * rows) + x;
                                    int itemX = (((this.imageWidth - 8) / 2) / 2) + (x * 18) - ((rowCount / 2) * 16);
                                    if (!left) {
                                        itemX += (this.imageWidth - 16) / 2;
                                    }
                                    guiGraphics.renderItem(new ItemStack(displayedItemsList.get(itemIndex)), leftPos + itemX, topPos + textStart + (line * 10) + (items * 18));
                                }
                                items++;
                            }
                        }
                    } else {
                        if (dinopediaEntry.drawEntity() && this.livingEntity != null) {
                            int displayLeftPos = left ? leftPos + 25 : leftPos + 160;
                            int displayRightPos = left ? leftPos + 120 : leftPos + 255;
                            textStart = 90;
                            this.livingEntity.tickCount = this.player.tickCount;
                            DNARecombinatorScreen.renderEntityInInventoryFollowsMouse(guiGraphics, displayLeftPos, topPos + 15, displayRightPos, topPos + 80, 16, 1.0F, 0.25F, mouseX, mouseY, this.livingEntity);
                        }

                        List<Component> components = new ArrayList<>();
                        if (this.dinopediaInformation.getDinopediaType().isPresent()) {
                            if (this.dinopediaInformation instanceof Entity entity) {
                                components = dinopediaEntry.getText(entity, this.player);
                            }
                        }

                        if (!components.isEmpty()) {
                            boolean displayName = dinopediaEntry.line().contains(BuiltInDinopediaLines.DISPLAY_NAME);
                            int displayLeftPos = left ? (leftPos - (((this.imageWidth - 8) / 2) / 2)) : (leftPos + (((this.imageWidth - 8) / 2) / 2));

                            if (displayName) {
                                this.drawCenteredStringMinusShadow(guiGraphics, this.font, components.getFirst(), displayLeftPos, topPos + textStart, 0, dinopediaEntry.centerText());
                            }

                            for (int line = displayName ? 1 : 0; line < components.size(); line++) {
                                this.drawCenteredStringMinusShadow(guiGraphics, this.font, components.get(line), displayLeftPos, topPos + textStart + (displayName ? 10 : 0) + (line * 10), 0, dinopediaEntry.centerText());
                            }
                        }
                    }
                }
            }
        }
    }

    private void drawCenteredStringMinusShadow(GuiGraphics guiGraphics, Font font, Component text, int x, int y, int color, boolean centered) {
        int drawX = x + 36;
        if (centered) {
            drawX = x - (font.width(text) / 2) + (this.imageWidth / 2);
        }
        guiGraphics.drawString(font, text, drawX, y, color, false);
    }

    @Override
    public void renderBackground(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderTransparentBackground(guiGraphics);
        guiGraphics.blit(RenderType::guiTextured, DINOPEDIA_TEXTURE, (this.width - this.imageWidth) / 2, (this.height / 2) - (this.imageHeight / 2), 0.0F, 0.0F, 280, 180, 512, 512);
    }
}
