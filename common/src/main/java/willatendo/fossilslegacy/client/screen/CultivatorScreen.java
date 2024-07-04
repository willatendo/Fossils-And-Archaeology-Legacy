package willatendo.fossilslegacy.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeUpdateListener;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import willatendo.fossilslegacy.client.screen.recipebook.CultivatorRecipeBookComponent;
import willatendo.fossilslegacy.server.menu.CultivatorMenu;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class CultivatorScreen extends AbstractContainerScreen<CultivatorMenu> implements RecipeUpdateListener {
    private static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/gui/container/cultivator.png");
    private static final ResourceLocation CULTIVATION_PROGRESS_SPRITE = FossilsLegacyUtils.resource("container/cultivator/cultivation_progress");
    private static final ResourceLocation BIOMASS_PROGRESS_SPRITE = FossilsLegacyUtils.resource("container/cultivator/biomass_progress");
    public final CultivatorRecipeBookComponent cultivatorRecipeBookComponent = new CultivatorRecipeBookComponent();
    private boolean widthTooNarrow;

    public CultivatorScreen(CultivatorMenu archaeologyWorkbenchMenu, Inventory inventory, Component title) {
        super(archaeologyWorkbenchMenu, inventory, title);
    }

    @Override
    public void init() {
        super.init();
        this.widthTooNarrow = this.width < 379;
        this.cultivatorRecipeBookComponent.init(this.width, this.height, this.minecraft, this.widthTooNarrow, this.menu);
        this.leftPos = this.cultivatorRecipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
        this.addRenderableWidget(new ImageButton(this.leftPos + 20, this.height / 2 - 49, 20, 18, RecipeBookComponent.RECIPE_BUTTON_SPRITES, button -> {
            this.cultivatorRecipeBookComponent.toggleVisibility();
            this.leftPos = this.cultivatorRecipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
            button.setPosition(this.leftPos + 20, this.height / 2 - 49);
        }));
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    @Override
    public void containerTick() {
        super.containerTick();
        this.cultivatorRecipeBookComponent.tick();
    }

    @Override
    public void render(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
        if (this.cultivatorRecipeBookComponent.isVisible() && this.widthTooNarrow) {
            this.renderBackground(guiGraphics, x, y, partialTicks);
            this.cultivatorRecipeBookComponent.render(guiGraphics, x, y, partialTicks);
        } else {
            super.render(guiGraphics, x, y, partialTicks);
            this.cultivatorRecipeBookComponent.render(guiGraphics, x, y, partialTicks);
            this.cultivatorRecipeBookComponent.renderGhostRecipe(guiGraphics, this.leftPos, this.topPos, true, partialTicks);
        }

        this.renderTooltip(guiGraphics, x, y);
        this.cultivatorRecipeBookComponent.renderTooltip(guiGraphics, this.leftPos, this.topPos, x, y);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int x, int y) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int leftPos = this.leftPos;
        int topPos = this.topPos;
        guiGraphics.blit(TEXTURE, leftPos, topPos, 0, 0, this.imageWidth, this.imageHeight);
        if (this.menu.isOn()) {
            int onProgess = Mth.ceil(this.menu.getOnProgress() * 13.0F) + 1;
            guiGraphics.blitSprite(BIOMASS_PROGRESS_SPRITE, 14, 14, 0, 14 - onProgess, leftPos + 81, topPos + 36 + 14 - onProgess, 14, onProgess);
        }

        int cultivationProgess = this.menu.getCultivationProgress();
        guiGraphics.blitSprite(CULTIVATION_PROGRESS_SPRITE, 22, 9, 0, 0, leftPos + 77, topPos + 23, cultivationProgess + 1, 9);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        if (this.cultivatorRecipeBookComponent.mouseClicked(mouseX, mouseY, mouseButton)) {
            return true;
        } else {
            return this.widthTooNarrow && this.cultivatorRecipeBookComponent.isVisible() ? true : super.mouseClicked(mouseX, mouseY, mouseButton);
        }
    }

    @Override
    protected void slotClicked(Slot slot, int slotId, int mouseButton, ClickType clickType) {
        super.slotClicked(slot, slotId, mouseButton, clickType);
        this.cultivatorRecipeBookComponent.slotClicked(slot);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        return this.cultivatorRecipeBookComponent.keyPressed(keyCode, scanCode, modifiers) ? true : super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    protected boolean hasClickedOutside(double mouseX, double mouseY, int leftPos, int topPos, int mouseButton) {
        boolean $$5 = mouseX < (double) leftPos || mouseY < (double) topPos || mouseX >= (double) (leftPos + this.imageWidth) || mouseY >= (double) (topPos + this.imageHeight);
        return this.cultivatorRecipeBookComponent.hasClickedOutside(mouseX, mouseY, this.leftPos, this.topPos, this.imageWidth, this.imageHeight, mouseButton) && $$5;
    }

    @Override
    public boolean charTyped(char keyCode, int modifiers) {
        return this.cultivatorRecipeBookComponent.charTyped(keyCode, modifiers) ? true : super.charTyped(keyCode, modifiers);
    }

    @Override
    public void recipesUpdated() {
        this.cultivatorRecipeBookComponent.recipesUpdated();
    }

    @Override
    public RecipeBookComponent getRecipeBookComponent() {
        return this.cultivatorRecipeBookComponent;
    }
}
