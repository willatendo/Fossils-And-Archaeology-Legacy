package willatendo.fossilslegacy.server.block.entity;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
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
import net.minecraft.world.item.Items;
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
import willatendo.fossilslegacy.server.block.CultivatorBlock;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.menu.CultivatorMenu;
import willatendo.fossilslegacy.server.recipe.CultivationRecipe;
import willatendo.fossilslegacy.server.recipe.FossilsLegacyRecipeTypes;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class CultivatorBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, RecipeHolder, StackedContentsCompatible {
	private static final int[] SLOTS_FOR_UP = new int[] { 0 };
	private static final int[] SLOTS_FOR_DOWN = new int[] { 2 };
	private static final int[] SLOTS_FOR_SIDES = new int[] { 1 };
	protected NonNullList<ItemStack> itemStacks = NonNullList.withSize(3, ItemStack.EMPTY);
	private LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);
	public int onTime;
	public int onDuration;
	public int cultivationProgress;
	public int cultivationTotalTime;
	public final ContainerData containerData = new ContainerData() {
		@Override
		public int get(int slot) {
			switch (slot) {
			case 0:
				return CultivatorBlockEntity.this.onTime;
			case 1:
				return CultivatorBlockEntity.this.onDuration;
			case 2:
				return CultivatorBlockEntity.this.cultivationProgress;
			case 3:
				return CultivatorBlockEntity.this.cultivationTotalTime;
			default:
				return 0;
			}
		}

		@Override
		public void set(int slot, int set) {
			switch (slot) {
			case 0:
				CultivatorBlockEntity.this.onTime = set;
				break;
			case 1:
				CultivatorBlockEntity.this.onDuration = set;
				break;
			case 2:
				CultivatorBlockEntity.this.cultivationProgress = set;
				break;
			case 3:
				CultivatorBlockEntity.this.cultivationTotalTime = set;
			}

		}

		@Override
		public int getCount() {
			return 4;
		}
	};
	private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
	private final CachedCheck<Container, CultivationRecipe> recipeCheck = RecipeManager.createCheck(FossilsLegacyRecipeTypes.CULTIVATION.get());

	public static Map<ItemStack, Integer> getOnTimeMap() {
		Map<ItemStack, Integer> map = Maps.newLinkedHashMap();
		map.put(new ItemStack(FossilsLegacyItems.FOSSIL.get()), 300);
		map.put(new ItemStack(FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get()), 1000);
		map.put(new ItemStack(FossilsLegacyItems.AXOLOTL_EGGS.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.BRACHIOSAURUS_EGG.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.DILOPHOSAURUS_EGG.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.FROG_EGGS.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.INCUBATED_CHICKEN_EGG.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.INCUBATED_PARROT_EGG.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.MOSASAURUS_EGG.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.NAUTILUS_EGGS.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.PLESIOSAURUS_EGG.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.PTEROSAURUS_EGG.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.STEGOSAURUS_EGG.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.TRICERATOPS_EGG.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.TYRANNOSAURUS_EGG.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.VELOCIRAPTOR_EGG.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.RAW_BRACHIOSAURUS_MEAT.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.RAW_DILOPHOSAURUS_MEAT.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.RAW_MAMMOTH_MEAT.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.RAW_MOSASAURUS_MEAT.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.RAW_PLESIOSAURUS_MEAT.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.RAW_PTEROSAURUS_MEAT.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.RAW_SMILODON_MEAT.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.RAW_STEGOSAURUS_MEAT.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.RAW_TRICERATOPS_MEAT.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.RAW_TYRANNOSAURUS_MEAT.get()), 12000);
		map.put(new ItemStack(FossilsLegacyItems.RAW_VELOCIRAPTOR_MEAT.get()), 12000);
		map.put(new ItemStack(Items.PORKCHOP), 3000);
		map.put(new ItemStack(Items.COD), 3000);
		map.put(new ItemStack(Items.SALMON), 3000);
		map.put(new ItemStack(Items.TROPICAL_FISH), 3000);
		map.put(new ItemStack(Items.BEEF), 4000);
		map.put(new ItemStack(Items.MUTTON), 3000);
		map.put(new ItemStack(Items.RABBIT), 3000);
		map.put(new ItemStack(Items.CHICKEN), 1500);
		map.put(new ItemStack(Items.EGG), 1000);
		map.put(new ItemStack(Items.SLIME_BALL), 800);
		map.put(new ItemStack(Items.MILK_BUCKET), 6000);
		return map;
	}

	public CultivatorBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(FossilsLegacyBlockEntities.CULTIVATOR.get(), blockPos, blockState);
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
		this.cultivationProgress = compoundTag.getInt("CultivationTime");
		this.cultivationTotalTime = compoundTag.getInt("CultivationTimeTotal");
		this.onDuration = this.getOnDuration(this.itemStacks.get(1));
		CompoundTag usedRecipes = compoundTag.getCompound("RecipesUsed");
		for (String recipes : usedRecipes.getAllKeys()) {
			this.recipesUsed.put(new ResourceLocation(recipes), usedRecipes.getInt(recipes));
		}
	}

	@Override
	protected void saveAdditional(CompoundTag compoundTag) {
		super.saveAdditional(compoundTag);
		compoundTag.putInt("OnTime", this.onTime);
		compoundTag.putInt("CultivationTime", this.cultivationProgress);
		compoundTag.putInt("CultivationTimeTotal", this.cultivationTotalTime);
		ContainerHelper.saveAllItems(compoundTag, this.itemStacks);
		CompoundTag usedRecipes = new CompoundTag();
		this.recipesUsed.forEach((recipeId, recipe) -> {
			usedRecipes.putInt(recipeId.toString(), recipe);
		});
		compoundTag.put("RecipesUsed", usedRecipes);
	}

	public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, CultivatorBlockEntity cultivatorBlockEntity) {
		boolean isOn = cultivatorBlockEntity.isOn();
		boolean changed = false;
		if (cultivatorBlockEntity.isOn()) {
			--cultivatorBlockEntity.onTime;
		}

		ItemStack fuel = cultivatorBlockEntity.itemStacks.get(1);
		boolean hasInput = !cultivatorBlockEntity.itemStacks.get(0).isEmpty();
		boolean hasFuel = !fuel.isEmpty();
		if (cultivatorBlockEntity.isOn() || hasFuel && hasInput) {
			Recipe<?> recipe;
			if (hasInput) {
				recipe = cultivatorBlockEntity.recipeCheck.getRecipeFor(cultivatorBlockEntity, level).orElse(null);
			} else {
				recipe = null;
			}

			int maxStackSize = cultivatorBlockEntity.getMaxStackSize();
			if (!cultivatorBlockEntity.isOn() && cultivatorBlockEntity.canCultivate(level.registryAccess(), recipe, cultivatorBlockEntity.itemStacks, maxStackSize)) {
				cultivatorBlockEntity.onTime = cultivatorBlockEntity.getOnDuration(fuel);
				cultivatorBlockEntity.onDuration = cultivatorBlockEntity.onTime;
				if (cultivatorBlockEntity.isOn()) {
					changed = true;
					if (fuel.hasCraftingRemainingItem())
						cultivatorBlockEntity.itemStacks.set(1, fuel.getCraftingRemainingItem());
					else if (hasFuel) {
						fuel.shrink(1);
						if (fuel.isEmpty()) {
							cultivatorBlockEntity.itemStacks.set(1, fuel.getCraftingRemainingItem());
						}
					}
				}
			}

			if (cultivatorBlockEntity.isOn() && cultivatorBlockEntity.canCultivate(level.registryAccess(), recipe, cultivatorBlockEntity.itemStacks, maxStackSize)) {
				++cultivatorBlockEntity.cultivationProgress;
				if (cultivatorBlockEntity.cultivationProgress == cultivatorBlockEntity.cultivationTotalTime) {
					cultivatorBlockEntity.cultivationProgress = 0;
					cultivatorBlockEntity.cultivationTotalTime = getTotalCultivationTime(level, cultivatorBlockEntity);
					if (cultivatorBlockEntity.cultivate(level.registryAccess(), recipe, cultivatorBlockEntity.itemStacks, maxStackSize)) {
						cultivatorBlockEntity.setRecipeUsed(recipe);
					}

					changed = true;
				}
			} else {
				cultivatorBlockEntity.cultivationProgress = 0;
			}
		} else if (!cultivatorBlockEntity.isOn() && cultivatorBlockEntity.cultivationProgress > 0) {
			cultivatorBlockEntity.cultivationProgress = Mth.clamp(cultivatorBlockEntity.cultivationProgress - 2, 0, cultivatorBlockEntity.cultivationTotalTime);
		}

		if (cultivatorBlockEntity.onTime == (cultivatorBlockEntity.getTotalCultivationTime(level, cultivatorBlockEntity) / 2) + 1) {
			if (cultivatorBlockEntity.level.getRandom().nextInt(100) <= 30) {
				((CultivatorBlock) FossilsLegacyBlocks.CULTIVATOR.get()).shatter(level, blockPos, cultivatorBlockEntity);
			}
		}

		if (isOn != cultivatorBlockEntity.isOn()) {
			changed = true;
			blockState = blockState.setValue(CultivatorBlock.ACTIVE, Boolean.valueOf(cultivatorBlockEntity.isOn()));
			level.setBlock(blockPos, blockState, 3);
		}

		if (changed) {
			setChanged(level, blockPos, blockState);
		}
	}

	private boolean canCultivate(RegistryAccess registryAccess, Recipe<?> recipe, NonNullList<ItemStack> itemStacks, int maxStackSize) {
		if (!itemStacks.get(0).isEmpty() && recipe != null) {
			ItemStack output = ((Recipe<WorldlyContainer>) recipe).assemble(this, registryAccess);
			if (output.isEmpty()) {
				return false;
			} else {
				ItemStack outputSlot = itemStacks.get(2);
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

	private boolean cultivate(RegistryAccess registryAccess, Recipe<?> recipe, NonNullList<ItemStack> itemStacks, int maxStackSize) {
		if (recipe != null && this.canCultivate(registryAccess, recipe, itemStacks, maxStackSize)) {
			ItemStack input = itemStacks.get(0);
			ItemStack output = ((Recipe<WorldlyContainer>) recipe).assemble(this, registryAccess);
			ItemStack outputSlot = itemStacks.get(2);
			if (outputSlot.isEmpty()) {
				itemStacks.set(2, output.copy());
			} else if (outputSlot.is(output.getItem())) {
				outputSlot.grow(output.getCount());
			}

			input.shrink(1);
			return true;
		} else {
			return false;
		}
	}

	public int getOnDuration(ItemStack itemStack) {
		if (itemStack.isEmpty()) {
			return 0;
		} else {
			return this.getOnTimeMap().getOrDefault(itemStack, 0);
		}
	}

	private static int getTotalCultivationTime(Level p_222693_, CultivatorBlockEntity cultivatorBlockEntity) {
		return cultivatorBlockEntity.recipeCheck.getRecipeFor(cultivatorBlockEntity, p_222693_).map(CultivationRecipe::getTime).orElse(6000);
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
		if (direction == Direction.DOWN && slot == 1) {
			return itemStack.is(Items.BUCKET);
		}
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
			this.cultivationTotalTime = getTotalCultivationTime(this.level, this);
			this.cultivationProgress = 0;
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
		if (slot == 2) {
			return false;
		} else if (slot != 1) {
			return true;
		} else {
			return this.getOnDuration(itemStack) > 0;
		}
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

	public void awardUsedRecipes(Player player, List<ItemStack> itemStacks) {
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
		return FossilsLegacyUtils.translation("menu", "cultivator");
	}

	@Override
	protected AbstractContainerMenu createMenu(int windowId, Inventory inventory) {
		return new CultivatorMenu(windowId, inventory, this);
	}
}
