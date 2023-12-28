package willatendo.fossilslegacy.server.jei.category;

//public class CultivationCategory implements IRecipeCategory<CultivationRecipe> {
//	private final IDrawable background;
//	private final IDrawable icon;
//	private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;
//	protected final IDrawableAnimated animatedVat;
//
//	public CultivationCategory(IGuiHelper guiHelper, FossilsLegacyJEITextures fossilsLegacyJEITextures) {
//		this.background = fossilsLegacyJEITextures.getBackground(0, 56, 88, 56);
//		this.icon = fossilsLegacyJEITextures.getIconFromItemLike(FossilsLegacyBlocks.CULTIVATOR.get());
//		this.cachedArrows = fossilsLegacyJEITextures.createProgressBar(25, 88, 70, 24, 14, IDrawableAnimated.StartDirection.LEFT);
//		this.animatedVat = fossilsLegacyJEITextures.createBiomatterBar();
//	}
//
//	protected IDrawableAnimated getArrow(CultivationRecipe cultivationRecipe) {
//		int cookTime = cultivationRecipe.getTime();
//		if (cookTime <= 0) {
//			cookTime = 3000;
//		}
//		return this.cachedArrows.getUnchecked(cookTime);
//	}
//
//	@Override
//	public RecipeType<CultivationRecipe> getRecipeType() {
//		return FossilsLegacyJEI.CULTIVATION;
//	}
//
//	@Override
//	public Component getTitle() {
//		return FossilsLegacyUtils.translation("jei", "cultivation");
//	}
//
//	@Override
//	public IDrawable getBackground() {
//		return this.background;
//	}
//
//	@Override
//	public IDrawable getIcon() {
//		return this.icon;
//	}
//
//	@Override
//	public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, CultivationRecipe cultivationRecipe, IFocusGroup iFocusGroup) {
//		iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 5, 5).addIngredients(cultivationRecipe.getIngredients().get(0));
//		iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 67, 5).addItemStack(RecipeUtil.getResultItem(cultivationRecipe));
//	}
//	
//	@Override
//	public void draw(CultivationRecipe cultivationRecipe, IRecipeSlotsView iRecipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
//		this.animatedVat.draw(guiGraphics, 37, 21);
//
//		IDrawableAnimated arrow = this.getArrow(cultivationRecipe);
//		arrow.draw(guiGraphics, 33, 8);
//	}
//}
