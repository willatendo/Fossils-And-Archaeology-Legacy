package willatendo.fossilslegacy.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeUpdateListener;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import willatendo.fossilslegacy.client.screen.recipebook.AnalyzerRecipeBookComponent;
import willatendo.fossilslegacy.server.menu.menus.AnalyzerMenu;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class AnalyzerScreen extends AbstractContainerScreen<AnalyzerMenu> implements RecipeUpdateListener {
    private static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/gui/container/analyzer.png");
    private static final ResourceLocation ANALYZATION_PROGRESS_SPRITE = FossilsLegacyUtils.resource("container/analyzer/analyzation_progress");
    public final AnalyzerRecipeBookComponent analyzerRecipeBookComponent = new AnalyzerRecipeBookComponent();
    private boolean widthTooNarrow;

    public AnalyzerScreen(AnalyzerMenu analyzerMenu, Inventory inventory, Component title) {
        super(analyzerMenu, inventory, title);
    }

    @Override
    public void init() {
        super.init();
        this.widthTooNarrow = this.width < 379;
        this.analyzerRecipeBookComponent.init(this.width, this.height, this.minecraft, this.widthTooNarrow, this.menu);
        this.leftPos = this.analyzerRecipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
        this.addRenderableWidget(new ImageButton(this.leftPos + 129, this.topPos + 22, 20, 18, RecipeBookComponent.RECIPE_BUTTON_SPRITES, button -> {
            this.analyzerRecipeBookComponent.toggleVisibility();
            this.leftPos = this.analyzerRecipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
            button.setPosition(this.leftPos + 129, this.topPos + 22);
        }));
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    @Override
    public void containerTick() {
        super.containerTick();
        this.analyzerRecipeBookComponent.tick();
    }

    @Override
    public void render(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
        if (this.analyzerRecipeBookComponent.isVisible() && this.widthTooNarrow) {
            this.renderBackground(guiGraphics, x, y, partialTicks);
            this.analyzerRecipeBookComponent.render(guiGraphics, x, y, partialTicks);
        } else {
            super.render(guiGraphics, x, y, partialTicks);
            this.analyzerRecipeBookComponent.render(guiGraphics, x, y, partialTicks);
            this.analyzerRecipeBookComponent.renderGhostRecipe(guiGraphics, this.leftPos, this.topPos, true, partialTicks);
        }

        this.renderTooltip(guiGraphics, x, y);
        this.analyzerRecipeBookComponent.renderTooltip(guiGraphics, this.leftPos, this.topPos, x, y);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int x, int y) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int leftPos = this.leftPos;
        int topPos = this.topPos;
        guiGraphics.blit(TEXTURE, leftPos, topPos, 0, 0, this.imageWidth, this.imageHeight);

        int analyzerProgess = this.menu.getAnalyzerProgress();
        guiGraphics.blitSprite(ANALYZATION_PROGRESS_SPRITE, 21, 9, 0, 0, leftPos + 68, topPos + 39, analyzerProgess + 1, 9);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        if (this.analyzerRecipeBookComponent.mouseClicked(mouseX, mouseY, mouseButton)) {
            return true;
        } else {
            return this.widthTooNarrow && this.analyzerRecipeBookComponent.isVisible() ? true : super.mouseClicked(mouseX, mouseY, mouseButton);
        }
    }

    @Override
    protected void slotClicked(Slot slot, int slotId, int mouseButton, ClickType clickType) {
        super.slotClicked(slot, slotId, mouseButton, clickType);
        this.analyzerRecipeBookComponent.slotClicked(slot);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        return this.analyzerRecipeBookComponent.keyPressed(keyCode, scanCode, modifiers) ? true : super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    protected boolean hasClickedOutside(double mouseX, double mouseY, int leftPos, int topPos, int mouseButton) {
        boolean $$5 = mouseX < (double) leftPos || mouseY < (double) topPos || mouseX >= (double) (leftPos + this.imageWidth) || mouseY >= (double) (topPos + this.imageHeight);
        return this.analyzerRecipeBookComponent.hasClickedOutside(mouseX, mouseY, this.leftPos, this.topPos, this.imageWidth, this.imageHeight, mouseButton) && $$5;
    }

    @Override
    public boolean charTyped(char keyCode, int modifiers) {
        return this.analyzerRecipeBookComponent.charTyped(keyCode, modifiers) ? true : super.charTyped(keyCode, modifiers);
    }

    @Override
    public void recipesUpdated() {
        this.analyzerRecipeBookComponent.recipesUpdated();
    }

    @Override
    public RecipeBookComponent getRecipeBookComponent() {
        return this.analyzerRecipeBookComponent;
    }
}
