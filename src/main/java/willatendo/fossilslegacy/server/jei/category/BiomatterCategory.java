package willatendo.fossilslegacy.server.jei.category;

//public class BiomatterCategory implements IRecipeCategory<BiomatterRecipe> {
//	private final IDrawable background;
//	private final IDrawableStatic icon;
//	private final LoadingCache<Integer, IDrawableAnimated> cachedBiomatter;
//	private final ImmutableRect2i textArea;
//
//	public BiomatterCategory(IGuiHelper guiHelper, FossilsLegacyJEITextures fossilsLegacyJEITextures) {
//		Minecraft minecraft = Minecraft.getInstance();
//		Font fontRenderer = minecraft.font;
//		Component maxSmeltCountText = createSmeltCountText(10000000 * 200);
//		int maxStringWidth = fontRenderer.width(maxSmeltCountText.getString());
//		this.background = guiHelper.drawableBuilder(FossilsLegacyJEI.TEXTURE, 35, 77, 18, 35).addPadding(0, 0, 0, 12 + maxStringWidth).build();
//		this.icon = guiHelper.createDrawable(FossilsLegacyJEI.TEXTURE, 0, 166, 14, 14);
//		this.cachedBiomatter = fossilsLegacyJEITextures.createProgressBar(25, 88, 56, 14, 14, IDrawableAnimated.StartDirection.TOP, true);
//		this.textArea = new ImmutableRect2i(20, 0, 20 + maxStringWidth, 34);
//	}
//
//	@Override
//	public RecipeType<BiomatterRecipe> getRecipeType() {
//		return FossilsLegacyJEI.BIOMATTER;
//	}
//
//	@Override
//	public Component getTitle() {
//		return FossilsLegacyUtils.translation("jei", "biomatter");
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
//	public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, BiomatterRecipe analyzationRecipe, IFocusGroup iFocusGroup) {
//		iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 1, 18).addItemStacks(analyzationRecipe.getItemStack());
//	}
//
//	@Override
//	public void draw(BiomatterRecipe analyzationRecipe, IRecipeSlotsView iRecipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
//		int biomatterUseTime = analyzationRecipe.getBiomatterUseTime();
//		IDrawableAnimated biomatter = this.cachedBiomatter.getUnchecked(biomatterUseTime);
//		biomatter.draw(guiGraphics, 2, 0);
//		Minecraft minecraft = Minecraft.getInstance();
//		Font font = minecraft.font;
//		Component smeltCountText = createSmeltCountText(biomatterUseTime);
//		ImmutableRect2i centerArea = MathUtil.centerTextArea(this.textArea, font, smeltCountText);
//		guiGraphics.drawString(font, smeltCountText, centerArea.getX(), centerArea.getY(), 0xFF808080, false);
//	}
//
//	private static Component createSmeltCountText(int burnTime) {
//		if (burnTime == 6000) {
//			return Component.translatable("jei.fossilslegacy.biomatter.biomatterCount.single");
//		} else {
//			NumberFormat numberInstance = NumberFormat.getNumberInstance();
//			numberInstance.setMaximumFractionDigits(2);
//			String smeltCount = numberInstance.format(burnTime / 6000.0F);
//			return Component.translatable("jei.fossilslegacy.biomatter.biomatterCount", smeltCount);
//		}
//	}
//}
