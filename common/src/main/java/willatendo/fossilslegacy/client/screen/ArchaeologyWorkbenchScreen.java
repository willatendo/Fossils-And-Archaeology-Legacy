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
import willatendo.fossilslegacy.client.screen.recipebook.ArchaeologyWorkbenchRecipeBookComponent;
import willatendo.fossilslegacy.client.screen.recipebook.RecipeBookUtils;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.menu.menus.ArchaeologyWorkbenchMenu;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public class ArchaeologyWorkbenchScreen extends AbstractRecipeBookScreen<ArchaeologyWorkbenchMenu> {
    private static final ResourceLocation TEXTURE = FAUtils.resource("textures/gui/container/archaeology_workbench.png");
    private static final ResourceLocation ARCHAEOLOGY_PROGRESS_SPRITE = FAUtils.resource("container/archaeology_workbench/archaeology_progress");
    private static final ResourceLocation INFORMATION_PROGRESS_SPRITE = FAUtils.resource("container/archaeology_workbench/information_progress");
    private static final Component FILTER_NAME = Component.translatable("gui.recipebook.toggleRecipes.archaeology");
    private static final List<RecipeBookComponent.TabInfo> TABS = List.of(RecipeBookUtils.createSearch(FASearchRecipeBookCategory.ARCHAEOLOGY_WORKBENCH), new RecipeBookComponent.TabInfo(FAItems.ANCIENT_SHOVEL_ARTIFACT.get(), FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_RESTORE.get()), new RecipeBookComponent.TabInfo(FAItems.GOLDEN_JAVELIN.get(), FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_REPAIR.get()), new RecipeBookComponent.TabInfo(FAItems.RELIC_SCRAP.get(), FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_MISC.get()));

    public ArchaeologyWorkbenchScreen(ArchaeologyWorkbenchMenu archaeologyWorkbenchMenu, Inventory inventory, Component title) {
        super(archaeologyWorkbenchMenu, new ArchaeologyWorkbenchRecipeBookComponent(archaeologyWorkbenchMenu, FILTER_NAME, TABS), inventory, title);
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
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int leftPos = this.leftPos;
        int topPos = this.topPos;
        guiGraphics.blit(RenderType::guiTextured, TEXTURE, leftPos, topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);
        if (this.menu.isOn()) {
            int onProgess = Mth.ceil(this.menu.getOnProgress() * 13.0F) + 1;
            guiGraphics.blitSprite(RenderType::guiTextured, INFORMATION_PROGRESS_SPRITE, 14, 14, 0, 14 - onProgess, leftPos + 81, topPos + 36 + 14 - onProgess, 14, onProgess);
        }

        int archaeologyProgess = this.menu.getArchaeologyProgress();
        guiGraphics.blitSprite(RenderType::guiTextured, ARCHAEOLOGY_PROGRESS_SPRITE, 24, 14, 0, 0, leftPos + 76, topPos + 21, archaeologyProgess + 1, 14);
    }
}
