package willatendo.fossilslegacy.server.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.registration.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.client.screen.AnalyzerScreen;
import willatendo.fossilslegacy.client.screen.ArchaeologyWorkbenchScreen;
import willatendo.fossilslegacy.client.screen.CultivatorScreen;
import willatendo.fossilslegacy.client.screen.GeneModificationTableScreen;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.jei.category.*;
import willatendo.fossilslegacy.server.jei.ingredient.CoatTypeHelper;
import willatendo.fossilslegacy.server.jei.ingredient.CoatTypeRenderer;
import willatendo.fossilslegacy.server.jei.ingredient.FossilsLegacyIngredientTypes;
import willatendo.fossilslegacy.server.jei.interpreter.ArticulatedFossilSubtypeInterpreter;
import willatendo.fossilslegacy.server.jei.interpreter.MagicConchSubtypeInterpreter;
import willatendo.fossilslegacy.server.jei.interpreter.StoneTabletSubtypeInterpreter;
import willatendo.fossilslegacy.server.menu.AnalyzerMenu;
import willatendo.fossilslegacy.server.menu.ArchaeologyWorkbenchMenu;
import willatendo.fossilslegacy.server.menu.CultivatorMenu;
import willatendo.fossilslegacy.server.menu.FossilsLegacyMenuTypes;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

@JeiPlugin
public final class FossilsLegacyJEI implements IModPlugin {
    // JEI Constants
    private ArchaeologyCategory archaeologyCategory;
    private CultivationCategory cultivationCategory;
    private AnalyzationCategory analyzationCategory;

    @Override
    public ResourceLocation getPluginUid() {
        return FossilsLegacyUtils.resource("fossils_legacy_jei");
    }

    @Override
    public void registerIngredients(IModIngredientRegistration iModIngredientRegistration) {
        List<CoatType> coatTypes = Lists.newArrayList();

        iModIngredientRegistration.register(FossilsLegacyIngredientTypes.COAT_TYPE, coatTypes, new CoatTypeHelper(), new CoatTypeRenderer("small_gene", 16, 16), CoatType.DIRECT_CODEC);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration iRecipeCategoryRegistration) {
        IGuiHelper iGuiHelper = iRecipeCategoryRegistration.getJeiHelpers().getGuiHelper();
        FossilsLegacyJEITextures fossilsLegacyJEITextures = new FossilsLegacyJEITextures(iGuiHelper);
        iRecipeCategoryRegistration.addRecipeCategories(this.archaeologyCategory = new ArchaeologyCategory(iGuiHelper, fossilsLegacyJEITextures), this.cultivationCategory = new CultivationCategory(iGuiHelper, fossilsLegacyJEITextures), this.analyzationCategory = new AnalyzationCategory(iGuiHelper, fossilsLegacyJEITextures), new GeneModificationCategory(fossilsLegacyJEITextures), new BiomatterCategory(fossilsLegacyJEITextures), new FeederCategory(fossilsLegacyJEITextures), new ArticulatedFossilCategory(fossilsLegacyJEITextures));
    }

    @Override
    public void registerRecipes(IRecipeRegistration iRecipeRegistration) {
        IVanillaRecipeFactory iVanillaRecipeFactory = iRecipeRegistration.getVanillaRecipeFactory();
        FossilsLegacyRecipes fossilsLegacyRecipes = new FossilsLegacyRecipes();

        iRecipeRegistration.addRecipes(FossilsLegacyJEIRecipeTypes.ARCHAEOLOGY, fossilsLegacyRecipes.getArchaeologyRecipes(this.archaeologyCategory));
        iRecipeRegistration.addRecipes(FossilsLegacyJEIRecipeTypes.CULTIVATION, fossilsLegacyRecipes.getCultivationRecipes(this.cultivationCategory));
        iRecipeRegistration.addRecipes(FossilsLegacyJEIRecipeTypes.ANALYZATION, fossilsLegacyRecipes.getAnalyzationRecipes(this.analyzationCategory));
        iRecipeRegistration.addRecipes(FossilsLegacyJEIRecipeTypes.BIOMATTER, fossilsLegacyRecipes.getBiomatterRecipes());
        iRecipeRegistration.addRecipes(FossilsLegacyJEIRecipeTypes.GENE_MODIFICATION, fossilsLegacyRecipes.getGeneModificationRecipes());
        iRecipeRegistration.addRecipes(FossilsLegacyJEIRecipeTypes.FEEDER, fossilsLegacyRecipes.getFeederRecipes());
        iRecipeRegistration.addRecipes(FossilsLegacyJEIRecipeTypes.ARTICULATED_FOSSIL, fossilsLegacyRecipes.getArticulatedFossilRecipes());

        iRecipeRegistration.addRecipes(RecipeTypes.CRAFTING, fossilsLegacyRecipes.createMagicConchRecipes());
        iRecipeRegistration.addRecipes(RecipeTypes.ANVIL, fossilsLegacyRecipes.createRepairRecipes(iVanillaRecipeFactory));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration iRecipeCatalystRegistration) {
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get()), FossilsLegacyJEIRecipeTypes.ARCHAEOLOGY);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.WHITE_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.WHITE_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.ORANGE_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.ORANGE_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.MAGENTA_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.MAGENTA_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.LIGHT_BLUE_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.LIGHT_BLUE_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.YELLOW_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.YELLOW_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.LIME_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.LIME_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.PINK_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.PINK_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.GRAY_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.GRAY_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.LIGHT_GRAY_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.LIGHT_GRAY_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.CYAN_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.CYAN_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.PURPLE_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.PURPLE_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.BLUE_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.BLUE_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.BROWN_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.BROWN_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.GREEN_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.GREEN_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.RED_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.RED_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.BLACK_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.BLACK_CULTIVATOR.get()), FossilsLegacyJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.ANALYZER.get()), FossilsLegacyJEIRecipeTypes.ANALYZATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.GENE_MODIFICATION_TABLE.get()), FossilsLegacyJEIRecipeTypes.GENE_MODIFICATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.FEEDER.get()), FossilsLegacyJEIRecipeTypes.FEEDER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.PALAEONTOLOGY_TABLE.get()), FossilsLegacyJEIRecipeTypes.ARTICULATED_FOSSIL);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration iGuiHandlerRegistration) {
        iGuiHandlerRegistration.addRecipeClickArea(ArchaeologyWorkbenchScreen.class, 76, 21, 24, 14, FossilsLegacyJEIRecipeTypes.ARCHAEOLOGY);
        iGuiHandlerRegistration.addRecipeClickArea(CultivatorScreen.class, 76, 21, 24, 14, FossilsLegacyJEIRecipeTypes.CULTIVATION);
        iGuiHandlerRegistration.addRecipeClickArea(CultivatorScreen.class, 76, 21, 24, 14, FossilsLegacyJEIRecipeTypes.BIOMATTER);
        iGuiHandlerRegistration.addRecipeClickArea(AnalyzerScreen.class, 68, 39, 21, 9, FossilsLegacyJEIRecipeTypes.ANALYZATION);
        iGuiHandlerRegistration.addRecipeClickArea(GeneModificationTableScreen.class, 60, 74, 54, 8, FossilsLegacyJEIRecipeTypes.GENE_MODIFICATION);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration iRecipeTransferRegistration) {
        iRecipeTransferRegistration.addRecipeTransferHandler(ArchaeologyWorkbenchMenu.class, FossilsLegacyMenuTypes.ARCHAEOLOGY_WORKBENCH.get(), FossilsLegacyJEIRecipeTypes.ARCHAEOLOGY, 0, 1, 3, 36);
        iRecipeTransferRegistration.addRecipeTransferHandler(CultivatorMenu.class, FossilsLegacyMenuTypes.CULTIVATOR.get(), FossilsLegacyJEIRecipeTypes.CULTIVATION, 0, 1, 3, 36);
        iRecipeTransferRegistration.addRecipeTransferHandler(AnalyzerMenu.class, FossilsLegacyMenuTypes.ANALYZER.get(), FossilsLegacyJEIRecipeTypes.ANALYZATION, 0, 9, 10, 36);
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration iSubtypeRegistration) {
        iSubtypeRegistration.registerSubtypeInterpreter(FossilsLegacyItems.ARTICULATED_FOSSIL.get(), ArticulatedFossilSubtypeInterpreter.INSTANCE);
        iSubtypeRegistration.registerSubtypeInterpreter(FossilsLegacyItems.MAGIC_CONCH.get(), MagicConchSubtypeInterpreter.INSTANCE);
        iSubtypeRegistration.registerSubtypeInterpreter(FossilsLegacyItems.STONE_TABLET.get(), StoneTabletSubtypeInterpreter.INSTANCE);
    }
}
