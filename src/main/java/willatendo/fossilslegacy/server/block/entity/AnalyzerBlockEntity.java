package willatendo.fossilslegacy.server.block.entity;

import java.util.List;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeManager.CachedCheck;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import willatendo.fossilslegacy.server.block.AnalyzerBlock;
import willatendo.fossilslegacy.server.menu.AnalyzerMenu;
import willatendo.fossilslegacy.server.recipe.AnalyzationRecipe;
import willatendo.fossilslegacy.server.recipe.FossilsLegacyRecipeTypes;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class AnalyzerBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, RecipeHolder, StackedContentsCompatible {
	private static final int[] SLOTS_FOR_UP = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
	private static final int[] SLOTS_FOR_DOWN = new int[] { 9, 10, 11, 12 };
	private static final int[] SLOTS_FOR_SIDES = SLOTS_FOR_UP;
	protected NonNullList<ItemStack> itemStacks = NonNullList.withSize(13, ItemStack.EMPTY);
	private LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);
	public int onTime;
	public int analyzationProgress;
	public int analyzationTotalTime;
	public final ContainerData containerData = new ContainerData() {
		@Override
		public int get(int slot) {
			switch (slot) {
			case 0:
				return AnalyzerBlockEntity.this.onTime;
			case 1:
				return AnalyzerBlockEntity.this.analyzationProgress;
			case 2:
				return AnalyzerBlockEntity.this.analyzationTotalTime;
			default:
				return 0;
			}
		}

		@Override
		public void set(int slot, int set) {
			switch (slot) {
			case 0:
				AnalyzerBlockEntity.this.onTime = set;
				break;
			case 1:
				AnalyzerBlockEntity.this.analyzationProgress = set;
				break;
			case 2:
				AnalyzerBlockEntity.this.analyzationTotalTime = set;
			}

		}

		@Override
		public int getCount() {
			return 3;
		}
	};
	private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
	private final CachedCheck<Container, AnalyzationRecipe> recipeCheck = RecipeManager.createCheck(FossilsLegacyRecipeTypes.ANALYZATION.get());

	public AnalyzerBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(FossilsLegacyBlockEntities.ANALYZER.get(), blockPos, blockState);
	}

	private boolean isOn() {
		return this.onTime > 0;
	}

	@Override
	public void load(CompoundTag compoundTag) {
		super.load(compoundTag);
		this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compoundTag, this.itemStacks);
		this.onTime = compoundTag.getInt("OnTime");
		this.analyzationProgress = compoundTag.getInt("AnalyzationTime");
		this.analyzationTotalTime = compoundTag.getInt("AnalyzationTimeTotal");
		CompoundTag usedRecipes = compoundTag.getCompound("RecipesUsed");
		for (String recipes : usedRecipes.getAllKeys()) {
			this.recipesUsed.put(new ResourceLocation(recipes), usedRecipes.getInt(recipes));
		}
	}

	@Override
	protected void saveAdditional(CompoundTag compoundTag) {
		super.saveAdditional(compoundTag);
		compoundTag.putInt("OnTime", this.onTime);
		compoundTag.putInt("AnalyzationTime", this.analyzationProgress);
		compoundTag.putInt("AnalyzationTimeTotal", this.analyzationTotalTime);
		ContainerHelper.saveAllItems(compoundTag, this.itemStacks);
		CompoundTag usedRecipes = new CompoundTag();
		this.recipesUsed.forEach((recipeId, recipe) -> {
			usedRecipes.putInt(recipeId.toString(), recipe);
		});
		compoundTag.put("RecipesUsed", usedRecipes);
	}

	public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, AnalyzerBlockEntity analyzerBlockEntity) {
		boolean isOn = analyzerBlockEntity.isOn();
		boolean changed = false;
		if (analyzerBlockEntity.isOn()) {
			--analyzerBlockEntity.onTime;
		}

		for (int inputSlots = 8; inputSlots > -1; inputSlots--) {
			boolean hasInput = !analyzerBlockEntity.itemStacks.get(inputSlots).isEmpty();
			if (analyzerBlockEntity.isOn() || hasInput) {
				Recipe<Container> recipe;
				if (hasInput) {
					recipe = analyzerBlockEntity.recipeCheck.getRecipeFor(analyzerBlockEntity, level).orElse(null);
				} else {
					recipe = null;
				}

				if (recipe != null) {
					int maxStackSize = analyzerBlockEntity.getMaxStackSize();
					ItemStack output = recipe.assemble(analyzerBlockEntity, level.registryAccess());
					for (int outputSlots = 9; outputSlots < 13; outputSlots++) {
						if (!analyzerBlockEntity.isOn() && analyzerBlockEntity.canAnalyze(outputSlots, inputSlots, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
							analyzerBlockEntity.onTime = 100;
							if (analyzerBlockEntity.isOn()) {
								changed = true;
							}
						}

						if (analyzerBlockEntity.isOn() && analyzerBlockEntity.canAnalyze(outputSlots, inputSlots, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
							++analyzerBlockEntity.analyzationProgress;
							if (analyzerBlockEntity.analyzationProgress == analyzerBlockEntity.analyzationTotalTime) {
								analyzerBlockEntity.analyzationProgress = 0;
								analyzerBlockEntity.analyzationTotalTime = getTotalCultivationTime(level, analyzerBlockEntity);
								if (analyzerBlockEntity.canAnalyze(outputSlots, inputSlots, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
									ItemStack input = analyzerBlockEntity.itemStacks.get(inputSlots);
									ItemStack outputSlot = analyzerBlockEntity.itemStacks.get(outputSlots);
									if (outputSlot.isEmpty()) {
										analyzerBlockEntity.itemStacks.set(outputSlots, output.copy());
									} else if (outputSlot.is(output.getItem())) {
										outputSlot.grow(output.getCount());
									}

									input.shrink(1);
								}

								changed = true;
							}
						} else {
							analyzerBlockEntity.analyzationProgress = 0;
						}
					}
				}
			} else if (!analyzerBlockEntity.isOn() && analyzerBlockEntity.analyzationProgress > 0) {
				analyzerBlockEntity.analyzationProgress = Mth.clamp(analyzerBlockEntity.analyzationProgress - 2, 0, analyzerBlockEntity.analyzationTotalTime);
			}
		}

		if (isOn != analyzerBlockEntity.isOn()) {
			changed = true;
			blockState = blockState.setValue(AnalyzerBlock.ACTIVE, Boolean.valueOf(analyzerBlockEntity.isOn()));
			level.setBlock(blockPos, blockState, 3);
		}

		if (changed) {
			setChanged(level, blockPos, blockState);
		}
	}

	private boolean canAnalyze(int slot, int inputSlot, ItemStack output, NonNullList<ItemStack> itemStacks, int maxStackSize) {
		if (!itemStacks.get(inputSlot).isEmpty() && output != null) {
			if (output.isEmpty()) {
				return false;
			} else {
				ItemStack outputSlot = itemStacks.get(slot);
				if (outputSlot.isEmpty()) {
					return true;
				} else if (!ItemStack.isSameItem(outputSlot, output)) {
					return false;
				} else if (outputSlot.getCount() + output.getCount() <= maxStackSize && outputSlot.getCount() + output.getCount() <= outputSlot.getMaxStackSize()) {
					return true;
				} else {
					return outputSlot.getCount() + output.getCount() <= output.getMaxStackSize();
				}
			}
		} else {
			return false;
		}
	}

	private static int getTotalCultivationTime(Level level, AnalyzerBlockEntity analyzerBlockEntity) {
		return analyzerBlockEntity.recipeCheck.getRecipeFor(analyzerBlockEntity, level).map(AnalyzationRecipe::getTime).orElse(100);
	}

	@Override
	public int[] getSlotsForFace(Direction direction) {
		if (direction == Direction.DOWN) {
			return SLOTS_FOR_DOWN;
		} else {
			return direction == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
		}
	}

	@Override
	public boolean canPlaceItemThroughFace(int slot, ItemStack itemStack, Direction direction) {
		return this.canPlaceItem(slot, itemStack);
	}

	@Override
	public boolean canTakeItemThroughFace(int slot, ItemStack itemStack, Direction direction) {
		return true;
	}

	@Override
	public int getContainerSize() {
		return this.itemStacks.size();
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack itemStack : this.itemStacks) {
			if (!itemStack.isEmpty()) {
				return false;
			}
		}

		return true;
	}

	@Override
	public ItemStack getItem(int slot) {
		return this.itemStacks.get(slot);
	}

	@Override
	public ItemStack removeItem(int slot, int amount) {
		return ContainerHelper.removeItem(this.itemStacks, slot, amount);
	}

	@Override
	public ItemStack removeItemNoUpdate(int slot) {
		return ContainerHelper.takeItem(this.itemStacks, slot);
	}

	@Override
	public void setItem(int slot, ItemStack itemStack) {
		ItemStack itemStackInSlot = this.itemStacks.get(slot);
		boolean flag = !itemStack.isEmpty() && ItemStack.isSameItemSameTags(itemStackInSlot, itemStack);
		this.itemStacks.set(slot, itemStack);
		if (itemStack.getCount() > this.getMaxStackSize()) {
			itemStack.setCount(this.getMaxStackSize());
		}

		if (slot == 0 && !flag) {
			this.analyzationTotalTime = 100;
			this.analyzationProgress = 0;
			this.setChanged();
		}

	}

	@Override
	public boolean stillValid(Player player) {
		if (this.level.getBlockEntity(this.worldPosition) != this) {
			return false;
		} else {
			return player.distanceToSqr((double) this.worldPosition.getX() + 0.5D, (double) this.worldPosition.getY() + 0.5D, (double) this.worldPosition.getZ() + 0.5D) <= 64.0D;
		}
	}

	@Override
	public boolean canPlaceItem(int slot, ItemStack itemStack) {
		if (slot == 0 || slot == 1 || slot == 2 || slot == 3 || slot == 4 || slot == 5 || slot == 6 || slot == 7 || slot == 8) {
			return true;
		} else {
			return false;
		}
	}

	public void awardUsedRecipes(Player player, List<ItemStack> itemStacks) {
	}

	@Override
	public void clearContent() {
		this.itemStacks.clear();
	}

	@Override
	public void setRecipeUsed(Recipe<?> recipe) {
		if (recipe != null) {
			ResourceLocation recipeId = recipe.getId();
			this.recipesUsed.addTo(recipeId, 1);
		}
	}

	@Override
	public Recipe<?> getRecipeUsed() {
		return null;
	}

	@Override
	public void fillStackedContents(StackedContents stackedContents) {
		for (ItemStack itemStack : this.itemStacks) {
			stackedContents.accountStack(itemStack);
		}

	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction direction) {
		if (!this.remove && direction != null && capability == ForgeCapabilities.ITEM_HANDLER) {
			if (direction == Direction.UP) {
				return handlers[0].cast();
			} else if (direction == Direction.DOWN) {
				return handlers[1].cast();
			} else {
				return handlers[2].cast();
			}
		}
		return super.getCapability(capability, direction);
	}

	@Override
	public void invalidateCaps() {
		super.invalidateCaps();
		for (int x = 0; x < handlers.length; x++)
			handlers[x].invalidate();
	}

	@Override
	public void reviveCaps() {
		super.reviveCaps();
		this.handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);
	}

	@Override
	protected Component getDefaultName() {
		return FossilsLegacyUtils.translation("menu", "analyzer");
	}

	@Override
	protected AbstractContainerMenu createMenu(int windowId, Inventory inventory) {
		return new AnalyzerMenu(windowId, inventory, this);
	}
}
