package willatendo.fossilslegacy.server.jei;

//@JeiPlugin
//public class FossilsLegacyJEI implements IModPlugin {
//	public static final RecipeType<ArchaeologyRecipe> ARCHAEOLOGY = RecipeType.create(FossilsLegacyUtils.ID, "archaeology_category", ArchaeologyRecipe.class);
//	public static final RecipeType<CultivationRecipe> CULTIVATION = RecipeType.create(FossilsLegacyUtils.ID, "cultivation_category", CultivationRecipe.class);
//	public static final RecipeType<AnalyzationRecipe> ANALYZATION = RecipeType.create(FossilsLegacyUtils.ID, "analyzation_category", AnalyzationRecipe.class);
//	public static final RecipeType<BiomatterRecipe> BIOMATTER = RecipeType.create(FossilsLegacyUtils.ID, "biomatter_category", BiomatterRecipe.class);
//	public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/gui/fossils_legacy_jei.png");
//
//	// JEI Constants
//	public static final String JEI_ID = "jei";
//	public static final ResourceLocation LOCATION_JEI_GUI_TEXTURE_ATLAS = new ResourceLocation(FossilsLegacyJEI.JEI_ID, "textures/atlas/gui.png");
//
//	private static FossilsLegacyJEITextures textures;
//
//	private ArchaeologyCategory archaeologyCategory;
//	private CultivationCategory cultivationCategory;
//	private AnalyzationCategory analyzationCategory;
//
//	@Override
//	public ResourceLocation getPluginUid() {
//		return FossilsLegacyUtils.resource("fossils_legacy_jei");
//	}
//
//	public static FossilsLegacyJEITextures getTextures(IGuiHelper iGuiHelper) {
//		if (textures == null) {
//			textures = new FossilsLegacyJEITextures(iGuiHelper);
//		}
//		return textures;
//	}
//
//	@Override
//	public void registerCategories(IRecipeCategoryRegistration iRecipeCategoryRegistration) {
//		IGuiHelper iGuiHelper = iRecipeCategoryRegistration.getJeiHelpers().getGuiHelper();
//		FossilsLegacyJEITextures fossilsLegacyJEITextures = this.getTextures(iGuiHelper);
//		iRecipeCategoryRegistration.addRecipeCategories(this.archaeologyCategory = new ArchaeologyCategory(iGuiHelper, fossilsLegacyJEITextures), this.cultivationCategory = new CultivationCategory(iGuiHelper, fossilsLegacyJEITextures), this.analyzationCategory = new AnalyzationCategory(iGuiHelper, fossilsLegacyJEITextures), new BiomatterCategory(iGuiHelper, fossilsLegacyJEITextures));
//	}
//
//	@Override
//	public void registerRecipes(IRecipeRegistration iRecipeRegistration) {
//		IIngredientManager iIngredientManager = iRecipeRegistration.getIngredientManager();
//
//		FossilsLegacyRecipes fossilsLegacyRecipes = new FossilsLegacyRecipes(iIngredientManager);
//
//		iRecipeRegistration.addRecipes(FossilsLegacyJEI.ARCHAEOLOGY, fossilsLegacyRecipes.getArchaeologyRecipes(this.archaeologyCategory));
//		iRecipeRegistration.addRecipes(FossilsLegacyJEI.CULTIVATION, fossilsLegacyRecipes.getCultivationRecipes(this.cultivationCategory));
//		List<BiomatterRecipe> biomatterRecipes = new ArrayList<>();
//		for (int i = 0; i < CultivatorBlockEntity.getOnTimeMap().size(); i++) {
//			biomatterRecipes.add(new BiomatterRecipe(CultivatorBlockEntity.getOnTimeMap().keySet().stream().toList().get(i), CultivatorBlockEntity.getOnTimeMap().values().stream().toList().get(i)));
//		}
//		iRecipeRegistration.addRecipes(FossilsLegacyJEI.BIOMATTER, biomatterRecipes);
//		iRecipeRegistration.addRecipes(FossilsLegacyJEI.ANALYZATION, fossilsLegacyRecipes.getAnalyzationRecipes(this.analyzationCategory));
//	}
//
//	@Override
//	public void registerRecipeCatalysts(IRecipeCatalystRegistration iRecipeCatalystRegistration) {
//		iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get()), FossilsLegacyJEI.ARCHAEOLOGY);
//		iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.CULTIVATOR.get()), FossilsLegacyJEI.CULTIVATION);
//		iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.CULTIVATOR.get()), FossilsLegacyJEI.BIOMATTER);
//		iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.ANALYZER.get()), FossilsLegacyJEI.ANALYZATION);
//	}
//
//	@Override
//	public void registerGuiHandlers(IGuiHandlerRegistration iGuiHandlerRegistration) {
//		iGuiHandlerRegistration.addRecipeClickArea(ArchaeologyWorkbenchScreen.class, 76, 21, 24, 14, FossilsLegacyJEI.ARCHAEOLOGY);
//		iGuiHandlerRegistration.addRecipeClickArea(CultivatorScreen.class, 76, 21, 24, 14, FossilsLegacyJEI.CULTIVATION);
//		iGuiHandlerRegistration.addRecipeClickArea(CultivatorScreen.class, 76, 21, 24, 14, FossilsLegacyJEI.BIOMATTER);
//		iGuiHandlerRegistration.addRecipeClickArea(AnalyzerScreen.class, 68, 39, 21, 9, FossilsLegacyJEI.ANALYZATION);
//	}
//
//	@Override
//	public void registerRecipeTransferHandlers(IRecipeTransferRegistration iRecipeTransferRegistration) {
//		iRecipeTransferRegistration.addRecipeTransferHandler(ArchaeologyWorkbenchMenu.class, FossilsLegacyMenus.ARCHAEOLOGY_WORKBENCH.get(), FossilsLegacyJEI.ARCHAEOLOGY, 0, 1, 3, 36);
//		iRecipeTransferRegistration.addRecipeTransferHandler(CultivatorMenu.class, FossilsLegacyMenus.CULTIVATOR.get(), FossilsLegacyJEI.CULTIVATION, 0, 1, 3, 36);
//		iRecipeTransferRegistration.addRecipeTransferHandler(AnalyzerMenu.class, FossilsLegacyMenus.ANALYZER.get(), FossilsLegacyJEI.ANALYZATION, 0, 9, 10, 36);
//	}
//}
