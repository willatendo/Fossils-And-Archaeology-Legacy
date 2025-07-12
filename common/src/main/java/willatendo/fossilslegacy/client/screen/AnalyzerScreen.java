package willatendo.fossilslegacy.client.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.navigation.ScreenPosition;
import net.minecraft.client.gui.screens.inventory.AbstractRecipeBookScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import willatendo.fossilslegacy.client.FARecipeBookCategories;
import willatendo.fossilslegacy.client.FASearchRecipeBookCategory;
import willatendo.fossilslegacy.client.screen.recipebook.AnalyzerRecipeBookComponent;
import willatendo.fossilslegacy.client.screen.recipebook.RecipeBookUtils;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.menu.menus.AnalyzerMenu;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public class AnalyzerScreen extends AbstractRecipeBookScreen<AnalyzerMenu> {
    private static final ResourceLocation TEXTURE = FAUtils.resource("textures/gui/container/analyzer.png");
    private static final ResourceLocation ANALYZATION_PROGRESS_SPRITE = FAUtils.resource("container/analyzer/analyzation_progress");
    private static final Component FILTER_NAME = Component.translatable("gui.recipebook.toggleRecipes.analyzable");
    private static final List<RecipeBookComponent.TabInfo> TABS = List.of(RecipeBookUtils.createSearch(FASearchRecipeBookCategory.ANALYZATION), new RecipeBookComponent.TabInfo(FAItems.MESOZOIC_FOSSIL.get(), FARecipeBookCategories.ANALYZATION_PALAEONTOLOGY.get()), new RecipeBookComponent.TabInfo(FAItems.RELIC_SCRAP.get(), FARecipeBookCategories.ANALYZATION_ARCHAEOLOGY.get()), new RecipeBookComponent.TabInfo(FAItems.PLANT_FOSSIL.get(), FARecipeBookCategories.ANALYZATION_PALAEOBOTANY.get()), new RecipeBookComponent.TabInfo(FAItems.VELOCIRAPTOR_DNA.get(), FARecipeBookCategories.ANALYZATION_MISC.get()));

    public AnalyzerScreen(AnalyzerMenu analyzerMenu, Inventory inventory, Component title) {
        super(analyzerMenu, new AnalyzerRecipeBookComponent(analyzerMenu, FILTER_NAME, TABS), inventory, title);
    }

    @Override
    public void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    @Override
    protected ScreenPosition getRecipeBookButtonPosition() {
        return new ScreenPosition(this.leftPos + 129, this.topPos + 22);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int x, int y) {
        int leftPos = this.leftPos;
        int topPos = this.topPos;
        guiGraphics.blit(RenderType::guiTextured, TEXTURE, leftPos, topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);

        int analyzerProgess = this.menu.getAnalyzerProgress();
        guiGraphics.blitSprite(RenderType::guiTextured, ANALYZATION_PROGRESS_SPRITE, 21, 9, 0, 0, leftPos + 68, topPos + 39, analyzerProgess + 1, 9);
    }
}
