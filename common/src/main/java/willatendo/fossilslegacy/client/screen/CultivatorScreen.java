package willatendo.fossilslegacy.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.navigation.ScreenPosition;
import net.minecraft.client.gui.screens.inventory.AbstractRecipeBookScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import willatendo.fossilslegacy.client.FARecipeBookCategories;
import willatendo.fossilslegacy.client.FASearchRecipeBookCategory;
import willatendo.fossilslegacy.client.screen.recipebook.CultivatorRecipeBookComponent;
import willatendo.fossilslegacy.client.screen.recipebook.RecipeBookUtils;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.menu.menus.CultivatorMenu;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public class CultivatorScreen extends AbstractRecipeBookScreen<CultivatorMenu> {
    private static final ResourceLocation TEXTURE = FAUtils.resource("textures/gui/container/cultivator.png");
    private static final ResourceLocation CULTIVATION_PROGRESS_SPRITE = FAUtils.resource("container/cultivator/cultivation_progress");
    private static final ResourceLocation BIOMASS_PROGRESS_SPRITE = FAUtils.resource("container/cultivator/biomass_progress");
    private static final Component FILTER_NAME = Component.translatable("gui.recipebook.toggleRecipes.cultivatable");
    private static final List<RecipeBookComponent.TabInfo> TABS = List.of(RecipeBookUtils.createSearch(FASearchRecipeBookCategory.CULTIVATION), new RecipeBookComponent.TabInfo(FAItems.TRICERATOPS_EGG.get(), FARecipeBookCategories.CULTIVATION_EGGS.get()), new RecipeBookComponent.TabInfo(FABlocks.LEPIDODENDRON_SAPLING.get().asItem(), FARecipeBookCategories.CULTIVATION_PLANTS.get()), new RecipeBookComponent.TabInfo(FAItems.TRICERATOPS_DNA.get(), FARecipeBookCategories.CULTIVATION_MISC.get()));

    public CultivatorScreen(CultivatorMenu cultivatorMenu, Inventory inventory, Component title) {
        super(cultivatorMenu, new CultivatorRecipeBookComponent(cultivatorMenu, FILTER_NAME, TABS), inventory, title);
    }

    @Override
    public void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    @Override
    protected ScreenPosition getRecipeBookButtonPosition() {
        return new ScreenPosition(this.leftPos + 20, this.height / 2 - 49);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int x, int y) {
        int leftPos = this.leftPos;
        int topPos = this.topPos;
        guiGraphics.blit(RenderType::guiTextured, TEXTURE, leftPos, topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);
        if (this.menu.isOn()) {
            int onProgess = Mth.ceil(this.menu.getOnProgress() * 13.0F) + 1;
            guiGraphics.blitSprite(RenderType::guiTextured, BIOMASS_PROGRESS_SPRITE, 14, 14, 0, 14 - onProgess, leftPos + 81, topPos + 36 + 14 - onProgess, 14, onProgess);
        }

        int cultivationProgess = this.menu.getCultivationProgress();
        guiGraphics.blitSprite(RenderType::guiTextured, CULTIVATION_PROGRESS_SPRITE, 22, 9, 0, 0, leftPos + 77, topPos + 23, cultivationProgess + 1, 9);
    }
}
