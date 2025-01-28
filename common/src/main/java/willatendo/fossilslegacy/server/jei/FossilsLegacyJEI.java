package willatendo.fossilslegacy.server.jei;

import com.google.common.collect.Lists;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.registration.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.client.screen.AnalyzerScreen;
import willatendo.fossilslegacy.client.screen.ArchaeologyWorkbenchScreen;
import willatendo.fossilslegacy.client.screen.CultivatorScreen;
import willatendo.fossilslegacy.client.screen.GeneModificationTableScreen;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.jei.category.*;
import willatendo.fossilslegacy.server.jei.ingredient.CoatTypeHelper;
import willatendo.fossilslegacy.server.jei.ingredient.CoatTypeRenderer;
import willatendo.fossilslegacy.server.jei.ingredient.FAIngredientTypes;
import willatendo.fossilslegacy.server.jei.interpreter.ArticulatedFossilSubtypeInterpreter;
import willatendo.fossilslegacy.server.jei.interpreter.MagicConchSubtypeInterpreter;
import willatendo.fossilslegacy.server.jei.interpreter.StoneTabletSubtypeInterpreter;
import willatendo.fossilslegacy.server.menu.FAMenuTypes;
import willatendo.fossilslegacy.server.menu.menus.AnalyzerMenu;
import willatendo.fossilslegacy.server.menu.menus.ArchaeologyWorkbenchMenu;
import willatendo.fossilslegacy.server.menu.menus.CultivatorMenu;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

@JeiPlugin
public final class FossilsLegacyJEI implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return FossilsLegacyUtils.resource("fossils_legacy_jei");
    }

    @Override
    public void registerIngredients(IModIngredientRegistration iModIngredientRegistration) {
        List<CoatType> coatTypes = Lists.newArrayList();

        iModIngredientRegistration.register(FAIngredientTypes.COAT_TYPE, coatTypes, new CoatTypeHelper(), new CoatTypeRenderer("small_gene", 16, 16), CoatType.DIRECT_CODEC);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration iRecipeCategoryRegistration) {
        IGuiHelper iGuiHelper = iRecipeCategoryRegistration.getJeiHelpers().getGuiHelper();
        FAJEITextures FAJEITextures = new FAJEITextures(iGuiHelper);
        iRecipeCategoryRegistration.addRecipeCategories(
                new AnalyzationCategory(iGuiHelper, FAJEITextures),
                new AncientAxeBonusCategory(iGuiHelper),
                new ArchaeologyCategory(iGuiHelper, FAJEITextures),
                new ArticulatedFossilCategory(FAJEITextures),
                new BiomatterCategory(FAJEITextures),
                new CultivationCategory(iGuiHelper, FAJEITextures),
                new FeederCategory(FAJEITextures),
                new GeneModificationCategory(FAJEITextures),
                new InformationCategory(FAJEITextures),
                new JewelRecoveryCategory(iGuiHelper));
    }

    @Override
    public void registerRecipes(IRecipeRegistration iRecipeRegistration) {
        IVanillaRecipeFactory iVanillaRecipeFactory = iRecipeRegistration.getVanillaRecipeFactory();
        FARecipes FARecipes = new FARecipes();

        iRecipeRegistration.addRecipes(FAJEIRecipeTypes.ANALYZATION, FARecipes.getAnalyzationRecipes());
        iRecipeRegistration.addRecipes(FAJEIRecipeTypes.ANCIENT_AXE_BONUS, FARecipes.getAncientAxeBonusRecipes());
        iRecipeRegistration.addRecipes(FAJEIRecipeTypes.ARCHAEOLOGY, FARecipes.getArchaeologyRecipes());
        iRecipeRegistration.addRecipes(FAJEIRecipeTypes.ARTICULATED_FOSSIL, FARecipes.getArticulatedFossilRecipes());
        iRecipeRegistration.addRecipes(FAJEIRecipeTypes.BIOMATTER, FARecipes.getBiomatterRecipes());
        iRecipeRegistration.addRecipes(FAJEIRecipeTypes.CULTIVATION, FARecipes.getCultivationRecipes());
        iRecipeRegistration.addRecipes(FAJEIRecipeTypes.FEEDER, FARecipes.getFeederRecipes());
        iRecipeRegistration.addRecipes(FAJEIRecipeTypes.GENE_MODIFICATION, FARecipes.getGeneModificationRecipes());
        iRecipeRegistration.addRecipes(FAJEIRecipeTypes.INFORMATION, FARecipes.getInformationRecipes());
        iRecipeRegistration.addRecipes(FAJEIRecipeTypes.JEWEL_RECOVERY, FARecipes.getJewelRecoveryRecipes());

        iRecipeRegistration.addRecipes(RecipeTypes.CRAFTING, FARecipes.createMagicConchRecipes());
        iRecipeRegistration.addRecipes(RecipeTypes.ANVIL, FARecipes.createRepairRecipes(iVanillaRecipeFactory));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration iRecipeCatalystRegistration) {
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.ARCHAEOLOGY_WORKBENCH.get()), FAJEIRecipeTypes.ARCHAEOLOGY);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.ARCHAEOLOGY_WORKBENCH.get()), FAJEIRecipeTypes.INFORMATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.WHITE_CULTIVATOR.get()), FAJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.WHITE_CULTIVATOR.get()), FAJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.ORANGE_CULTIVATOR.get()), FAJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.ORANGE_CULTIVATOR.get()), FAJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.MAGENTA_CULTIVATOR.get()), FAJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.MAGENTA_CULTIVATOR.get()), FAJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.LIGHT_BLUE_CULTIVATOR.get()), FAJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.LIGHT_BLUE_CULTIVATOR.get()), FAJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.YELLOW_CULTIVATOR.get()), FAJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.YELLOW_CULTIVATOR.get()), FAJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.LIME_CULTIVATOR.get()), FAJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.LIME_CULTIVATOR.get()), FAJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.PINK_CULTIVATOR.get()), FAJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.PINK_CULTIVATOR.get()), FAJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.GRAY_CULTIVATOR.get()), FAJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.GRAY_CULTIVATOR.get()), FAJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.LIGHT_GRAY_CULTIVATOR.get()), FAJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.LIGHT_GRAY_CULTIVATOR.get()), FAJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.CYAN_CULTIVATOR.get()), FAJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.CYAN_CULTIVATOR.get()), FAJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.PURPLE_CULTIVATOR.get()), FAJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.PURPLE_CULTIVATOR.get()), FAJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.BLUE_CULTIVATOR.get()), FAJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.BLUE_CULTIVATOR.get()), FAJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.BROWN_CULTIVATOR.get()), FAJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.BROWN_CULTIVATOR.get()), FAJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.GREEN_CULTIVATOR.get()), FAJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.GREEN_CULTIVATOR.get()), FAJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.RED_CULTIVATOR.get()), FAJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.RED_CULTIVATOR.get()), FAJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.BLACK_CULTIVATOR.get()), FAJEIRecipeTypes.CULTIVATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.BLACK_CULTIVATOR.get()), FAJEIRecipeTypes.BIOMATTER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.ANALYZER.get()), FAJEIRecipeTypes.ANALYZATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.GENE_MODIFICATION_TABLE.get()), FAJEIRecipeTypes.GENE_MODIFICATION);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.FEEDER.get()), FAJEIRecipeTypes.FEEDER);
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FABlocks.PALAEONTOLOGY_TABLE.get()), FAJEIRecipeTypes.ARTICULATED_FOSSIL);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration iGuiHandlerRegistration) {
        iGuiHandlerRegistration.addRecipeClickArea(ArchaeologyWorkbenchScreen.class, 76, 21, 24, 14, FAJEIRecipeTypes.ARCHAEOLOGY);
        iGuiHandlerRegistration.addRecipeClickArea(CultivatorScreen.class, 76, 21, 24, 14, FAJEIRecipeTypes.CULTIVATION);
        iGuiHandlerRegistration.addRecipeClickArea(AnalyzerScreen.class, 68, 39, 21, 9, FAJEIRecipeTypes.ANALYZATION);
        iGuiHandlerRegistration.addRecipeClickArea(GeneModificationTableScreen.class, 60, 74, 54, 8, FAJEIRecipeTypes.GENE_MODIFICATION);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration iRecipeTransferRegistration) {
        iRecipeTransferRegistration.addRecipeTransferHandler(ArchaeologyWorkbenchMenu.class, FAMenuTypes.ARCHAEOLOGY_WORKBENCH.get(), FAJEIRecipeTypes.ARCHAEOLOGY, 0, 1, 3, 36);
        iRecipeTransferRegistration.addRecipeTransferHandler(CultivatorMenu.class, FAMenuTypes.CULTIVATOR.get(), FAJEIRecipeTypes.CULTIVATION, 0, 1, 3, 36);
        iRecipeTransferRegistration.addRecipeTransferHandler(AnalyzerMenu.class, FAMenuTypes.ANALYZER.get(), FAJEIRecipeTypes.ANALYZATION, 0, 9, 10, 36);
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration iSubtypeRegistration) {
        iSubtypeRegistration.registerSubtypeInterpreter(FAItems.ARTICULATED_FOSSIL.get(), ArticulatedFossilSubtypeInterpreter.INSTANCE);
        iSubtypeRegistration.registerSubtypeInterpreter(FAItems.MAGIC_CONCH.get(), MagicConchSubtypeInterpreter.INSTANCE);
        iSubtypeRegistration.registerSubtypeInterpreter(FAItems.STONE_TABLET.get(), StoneTabletSubtypeInterpreter.INSTANCE);
    }
}
