package willatendo.fossilslegacy.server.jei.category;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.crafting.Ingredient;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEIRecipeTypes;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEITextures;
import willatendo.fossilslegacy.server.jei.ingredient.CoatTypeRenderer;
import willatendo.fossilslegacy.server.jei.ingredient.FossilsLegacyIngredientTypes;
import willatendo.fossilslegacy.server.jei.recipe.GeneModificationRecipe;
import willatendo.fossilslegacy.server.tags.FossilsLegacyCoatTypeTags;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public final class GeneModificationCategory extends AbstractRecipeCategory<GeneModificationRecipe> {
    private final IDrawableStatic geneModification;

    public GeneModificationCategory(FossilsLegacyJEITextures fossilsLegacyJEITextures) {
        super(FossilsLegacyJEIRecipeTypes.GENE_MODIFICATION, FossilsLegacyUtils.translation("jei", "gene_modification"), fossilsLegacyJEITextures.getIconFromItemLike(FossilsLegacyBlocks.GENE_MODIFICATION_TABLE.get()), 101, 42);
        this.geneModification = fossilsLegacyJEITextures.getGeneModification();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, GeneModificationRecipe geneModificationRecipe, IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 80, 1).setStandardSlotBackground().addIngredients(geneModificationRecipe.ingredient());
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 12, 16).addIngredients(FossilsLegacyIngredientTypes.COAT_TYPE, geneModificationRecipe.coatTypes()).setCustomRenderer(FossilsLegacyIngredientTypes.COAT_TYPE, new CoatTypeRenderer("gene", 22, 8));
        if (geneModificationRecipe.hasLegacy()) {
            iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.CATALYST, 80, 23).setStandardSlotBackground().addIngredients(Ingredient.of(FossilsLegacyItems.LEGACY_GENETIC_CODE.get())).addRichTooltipCallback((recipeSlotView, tooltip) -> tooltip.add(FossilsLegacyUtils.translation("jei", "gene_modification.use_genetic_code", Component.translatable(FossilsLegacyUtils.getTagTranslationKey(FossilsLegacyCoatTypeTags.LEGACY)))));
        }
    }

    @Override
    public void draw(GeneModificationRecipe geneModificationRecipe, IRecipeSlotsView iRecipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        guiGraphics.drawString(font, geneModificationRecipe.type(), 1, 1, 0xFFFFFF);

        this.geneModification.draw(guiGraphics, 1, 12);
    }
}
