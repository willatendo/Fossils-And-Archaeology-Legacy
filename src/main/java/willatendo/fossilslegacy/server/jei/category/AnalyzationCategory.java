package willatendo.fossilslegacy.server.jei.category;

//public class AnalyzationCategory implements IRecipeCategory<AnalyzationRecipe> {
//	private final IDrawable background;
//	private final IDrawable icon;
//	private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;
//
//	public AnalyzationCategory(IGuiHelper guiHelper, FossilsLegacyJEITextures fossilsLegacyJEITextures) {
//		this.background = fossilsLegacyJEITextures.getBackground(0, 112, 144, 54);
//		this.icon = fossilsLegacyJEITextures.getIconFromItemLike(FossilsLegacyBlocks.ANALYZER.get());
//		this.cachedArrows = fossilsLegacyJEITextures.createProgressBar(25, 144, 122, 21, 10, IDrawableAnimated.StartDirection.LEFT);
//	}
//
//	protected IDrawableAnimated getArrow(AnalyzationRecipe analyzationRecipe) {
//		int cookTime = analyzationRecipe.getTime();
//		if (cookTime <= 0) {
//			cookTime = 100;
//		}
//		return this.cachedArrows.getUnchecked(cookTime);
//	}
//
//	@Override
//	public RecipeType<AnalyzationRecipe> getRecipeType() {
//		return FossilsLegacyJEI.ANALYZATION;
//	}
//
//	@Override
//	public Component getTitle() {
//		return FossilsLegacyUtils.translation("jei", "analyzation");
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
//	public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, AnalyzationRecipe analyzationRecipe, IFocusGroup iFocusGroup) {
//		iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 1, 1).addIngredients(analyzationRecipe.getIngredients().get(0));
//		iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 95, 5).addItemStacks(analyzationRecipe.getResults()).addTooltipCallback((iRecipeSlotView, tooltip) -> {
//			tooltip.add(Component.literal(analyzationRecipe.getWeight(iRecipeSlotView.getDisplayedItemStack().get()) + "%").withStyle(ChatFormatting.GRAY));
//		});
//	}
//
//	@Override
//	public void draw(AnalyzationRecipe analyzationRecipe, IRecipeSlotsView iRecipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
//		IDrawableAnimated arrow = this.getArrow(analyzationRecipe);
//		arrow.draw(guiGraphics, 61, 21);
//	}
//}
