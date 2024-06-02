package willatendo.fossilslegacy.server.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.registration.*;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.client.screen.AnalyzerScreen;
import willatendo.fossilslegacy.client.screen.ArchaeologyWorkbenchScreen;
import willatendo.fossilslegacy.client.screen.CultivatorScreen;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.block.entity.CultivatorBlockEntity;
import willatendo.fossilslegacy.server.block.entity.FeederBlockEntity;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.jei.category.*;
import willatendo.fossilslegacy.server.jei.recipe.BiomatterRecipe;
import willatendo.fossilslegacy.server.jei.recipe.FeederRecipe;
import willatendo.fossilslegacy.server.menu.AnalyzerMenu;
import willatendo.fossilslegacy.server.menu.ArchaeologyWorkbenchMenu;
import willatendo.fossilslegacy.server.menu.CultivatorMenu;
import willatendo.fossilslegacy.server.menu.FossilsLegacyMenus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class FossilsLegacyJEI implements IModPlugin {
    public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/gui/fossils_legacy_jei.png");

    // JEI Constants
    public static final String JEI_ID = "jei";
    public static final ResourceLocation LOCATION_JEI_GUI_TEXTURE_ATLAS = new ResourceLocation(FossilsLegacyJEI.JEI_ID, "textures/atlas/gui.png");

    private static FossilsLegacyJEITextures textures;

    private ArchaeologyCategory archaeologyCategory;
    private CultivationCategory cultivationCategory;
    private AnalyzationCategory analyzationCategory;

    @Override
    public ResourceLocation getPluginUid() {
        return FossilsLegacyUtils.resource("fossils_legacy_jei");
    }

    public static FossilsLegacyJEITextures getTextures(IGuiHelper iGuiHelper) {
        if (textures == null) {
            textures = new FossilsLegacyJEITextures(iGuiHelper);
        }
        return textures;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration iRecipeCategoryRegistration) {
        IGuiHelper iGuiHelper = iRecipeCategoryRegistration.getJeiHelpers().getGuiHelper();
        FossilsLegacyJEITextures fossilsLegacyJEITextures = this.getTextures(iGuiHelper);
        iRecipeCategoryRegistration.addRecipeCategories(this.archaeologyCategory = new ArchaeologyCategory(iGuiHelper, fossilsLegacyJEITextures), this.cultivationCategory = new CultivationCategory(iGuiHelper, fossilsLegacyJEITextures), this.analyzationCategory = new AnalyzationCategory(iGuiHelper, fossilsLegacyJEITextures), new BiomatterCategory(iGuiHelper, fossilsLegacyJEITextures), new FeederCategory(iGuiHelper, fossilsLegacyJEITextures));
    }

    @Override
    public void registerRecipes(IRecipeRegistration iRecipeRegistration) {
        IIngredientManager iIngredientManager = iRecipeRegistration.getIngredientManager();
        IVanillaRecipeFactory iVanillaRecipeFactory = iRecipeRegistration.getVanillaRecipeFactory();

        FossilsLegacyRecipes fossilsLegacyRecipes = new FossilsLegacyRecipes(iIngredientManager);

        iRecipeRegistration.addRecipes(FossilsLegacyJEIRecipeTypes.ARCHAEOLOGY, fossilsLegacyRecipes.getArchaeologyRecipes(this.archaeologyCategory));
        iRecipeRegistration.addRecipes(FossilsLegacyJEIRecipeTypes.CULTIVATION, fossilsLegacyRecipes.getCultivationRecipes(this.cultivationCategory));
        List<BiomatterRecipe> biomatterRecipes = new ArrayList<>();
        for (int i = 0; i < CultivatorBlockEntity.getOnTimeMap().size(); i++) {
            biomatterRecipes.add(new BiomatterRecipe(new ItemStack(CultivatorBlockEntity.getOnTimeMap().keySet().stream().toList().get(i)), CultivatorBlockEntity.getOnTimeMap().values().stream().toList().get(i)));
        }
        iRecipeRegistration.addRecipes(FossilsLegacyJEIRecipeTypes.BIOMATTER, biomatterRecipes);
        List<FeederRecipe> feederRecipes = new ArrayList<>();
        for (int i = 0; i < FeederBlockEntity.getMeatFoodLevel().size(); i++) {
            feederRecipes.add(new FeederRecipe(new ItemStack(FeederBlockEntity.getMeatFoodLevel().keySet().stream().toList().get(i)), FeederBlockEntity.getMeatFoodLevel().values().stream().toList().get(i), true));
        }
        for (int i = 0; i < FeederBlockEntity.getPlantsFoodLevel().size(); i++) {
            feederRecipes.add(new FeederRecipe(new ItemStack(FeederBlockEntity.getPlantsFoodLevel().keySet().stream().toList().get(i)), FeederBlockEntity.getPlantsFoodLevel().values().stream().toList().get(i), false));
        }
        iRecipeRegistration.addRecipes(FossilsLegacyJEIRecipeTypes.FEEDER, feederRecipes);
        iRecipeRegistration.addRecipes(FossilsLegacyJEIRecipeTypes.ANALYZATION, fossilsLegacyRecipes.getAnalyzationRecipes(this.analyzationCategory));

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
        iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.FEEDER.get()), FossilsLegacyJEIRecipeTypes.FEEDER);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration iGuiHandlerRegistration) {
        iGuiHandlerRegistration.addRecipeClickArea(ArchaeologyWorkbenchScreen.class, 76, 21, 24, 14, FossilsLegacyJEIRecipeTypes.ARCHAEOLOGY);
        iGuiHandlerRegistration.addRecipeClickArea(CultivatorScreen.class, 76, 21, 24, 14, FossilsLegacyJEIRecipeTypes.CULTIVATION);
        iGuiHandlerRegistration.addRecipeClickArea(CultivatorScreen.class, 76, 21, 24, 14, FossilsLegacyJEIRecipeTypes.BIOMATTER);
        iGuiHandlerRegistration.addRecipeClickArea(AnalyzerScreen.class, 68, 39, 21, 9, FossilsLegacyJEIRecipeTypes.ANALYZATION);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration iRecipeTransferRegistration) {
        iRecipeTransferRegistration.addRecipeTransferHandler(ArchaeologyWorkbenchMenu.class, FossilsLegacyMenus.ARCHAEOLOGY_WORKBENCH.get(), FossilsLegacyJEIRecipeTypes.ARCHAEOLOGY, 0, 1, 3, 36);
        iRecipeTransferRegistration.addRecipeTransferHandler(CultivatorMenu.class, FossilsLegacyMenus.CULTIVATOR.get(), FossilsLegacyJEIRecipeTypes.CULTIVATION, 0, 1, 3, 36);
        iRecipeTransferRegistration.addRecipeTransferHandler(AnalyzerMenu.class, FossilsLegacyMenus.ANALYZER.get(), FossilsLegacyJEIRecipeTypes.ANALYZATION, 0, 9, 10, 36);
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration iSubtypeRegistration) {
        iSubtypeRegistration.useNbtForSubtypes(FossilsLegacyItems.MAGIC_CONCH.get());
    }
}
