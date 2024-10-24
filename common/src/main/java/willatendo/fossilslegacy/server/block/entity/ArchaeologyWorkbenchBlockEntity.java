package willatendo.fossilslegacy.server.block.entity;

import com.google.common.collect.Maps;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeCraftingHolder;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeManager.CachedCheck;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.block.ArchaeologyWorkbenchBlock;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.menu.ArchaeologyWorkbenchMenu;
import willatendo.fossilslegacy.server.recipe.ArchaeologyRecipe;
import willatendo.fossilslegacy.server.recipe.FossilsLegacyRecipeTypes;
import willatendo.fossilslegacy.server.tags.FossilsLegacyItemTags;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;
import java.util.Map;

public class ArchaeologyWorkbenchBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, RecipeCraftingHolder, StackedContentsCompatible {
    private static final int[] SLOTS_FOR_UP = new int[]{0};
    private static final int[] SLOTS_FOR_DOWN = new int[]{2};
    private static final int[] SLOTS_FOR_SIDES = new int[]{1};
    protected NonNullList<ItemStack> itemStacks = NonNullList.withSize(3, ItemStack.EMPTY);
    public int onTime;
    public int onDuration;
    public int archaeologyProgress;
    public int archaeologyTotalTime;
    public final ContainerData containerData = new ContainerData() {
        @Override
        public int get(int slot) {
            switch (slot) {
                case 0:
                    if (ArchaeologyWorkbenchBlockEntity.this.onDuration > 32767) {
                        return Mth.floor((double) ArchaeologyWorkbenchBlockEntity.this.onTime / (double) ArchaeologyWorkbenchBlockEntity.this.onDuration * 32767.0);
                    }

                    return ArchaeologyWorkbenchBlockEntity.this.onTime;
                case 1:
                    return Math.min(ArchaeologyWorkbenchBlockEntity.this.onDuration, 32767);
                case 2:
                    return ArchaeologyWorkbenchBlockEntity.this.archaeologyProgress;
                case 3:
                    return ArchaeologyWorkbenchBlockEntity.this.archaeologyTotalTime;
                default:
                    return 0;
            }
        }

        @Override
        public void set(int slot, int set) {
            switch (slot) {
                case 0 -> ArchaeologyWorkbenchBlockEntity.this.onTime = set;
                case 1 -> ArchaeologyWorkbenchBlockEntity.this.onDuration = set;
                case 2 -> ArchaeologyWorkbenchBlockEntity.this.archaeologyProgress = set;
                case 3 -> ArchaeologyWorkbenchBlockEntity.this.archaeologyTotalTime = set;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    };
    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
    private final CachedCheck<SingleRecipeInput, ArchaeologyRecipe> recipeCheck = RecipeManager.createCheck(FossilsLegacyRecipeTypes.ARCHAEOLOGY.get());

    public static Map<Item, Integer> getOnTimeMap() {
        Map<Item, Integer> map = Maps.newLinkedHashMap();
        map.put(FossilsLegacyItems.RELIC_SCRAP.get(), 100);
        return map;
    }

    public ArchaeologyWorkbenchBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FossilsLegacyBlockEntityTypes.ARCHAEOLOGY_WORKBENCH.get(), blockPos, blockState);
    }

    private boolean isOn() {
        return this.onTime > 0;
    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(compoundTag, this.itemStacks, provider);
        this.onTime = compoundTag.getInt("OnTime");
        this.archaeologyProgress = compoundTag.getInt("ArchaeologyTime");
        this.archaeologyTotalTime = compoundTag.getInt("ArchaeologyTimeTotal");
        this.onDuration = this.getOnDuration(this.itemStacks.get(1));
        CompoundTag usedRecipes = compoundTag.getCompound("RecipesUsed");
        for (String recipes : usedRecipes.getAllKeys()) {
            this.recipesUsed.put(ResourceLocation.parse(recipes), usedRecipes.getInt(recipes));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        compoundTag.putInt("OnTime", this.onTime);
        compoundTag.putInt("ArchaeologyTime", this.archaeologyProgress);
        compoundTag.putInt("ArchaeologyTimeTotal", this.archaeologyTotalTime);
        ContainerHelper.saveAllItems(compoundTag, this.itemStacks, provider);
        CompoundTag usedRecipes = new CompoundTag();
        this.recipesUsed.forEach((recipeId, recipe) -> {
            usedRecipes.putInt(recipeId.toString(), recipe);
        });
        compoundTag.put("RecipesUsed", usedRecipes);
    }

    public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, ArchaeologyWorkbenchBlockEntity archaeologyWorkbenchBlockEntity) {
        boolean isOn = archaeologyWorkbenchBlockEntity.isOn();
        boolean changed = false;
        if (archaeologyWorkbenchBlockEntity.isOn()) {
            --archaeologyWorkbenchBlockEntity.onTime;
        }

        ItemStack fuel = archaeologyWorkbenchBlockEntity.itemStacks.get(1);
        boolean hasInput = !archaeologyWorkbenchBlockEntity.itemStacks.get(0).isEmpty();
        boolean hasFuel = !fuel.isEmpty();
        ItemStack input = archaeologyWorkbenchBlockEntity.itemStacks.get(0);
        if (input.is(FossilsLegacyItemTags.REPAIR_WHEN_BROKEN_IN_ARCHAEOLOGY_TABLE) && !(input.isDamaged())) {
            return;
        } else {
            if (archaeologyWorkbenchBlockEntity.isOn() || hasFuel && hasInput) {

                RecipeHolder<ArchaeologyRecipe> recipe;
                if (hasInput) {
                    recipe = archaeologyWorkbenchBlockEntity.recipeCheck.getRecipeFor(new SingleRecipeInput(archaeologyWorkbenchBlockEntity.itemStacks.get(0)), level).orElse(null);
                } else {
                    recipe = null;
                }

                int maxStackSize = archaeologyWorkbenchBlockEntity.getMaxStackSize();
                if (!archaeologyWorkbenchBlockEntity.isOn() && archaeologyWorkbenchBlockEntity.canFix(level.registryAccess(), recipe, archaeologyWorkbenchBlockEntity.itemStacks, maxStackSize)) {
                    archaeologyWorkbenchBlockEntity.onTime = archaeologyWorkbenchBlockEntity.getOnDuration(fuel);
                    archaeologyWorkbenchBlockEntity.onDuration = archaeologyWorkbenchBlockEntity.onTime;
                    if (archaeologyWorkbenchBlockEntity.isOn()) {
                        changed = true;
                        if (hasFuel) {
                            Item fuelItem = fuel.getItem();
                            fuel.shrink(1);
                            if (fuel.isEmpty()) {
                                Item craftingRemainder = fuelItem.getCraftingRemainingItem();
                                archaeologyWorkbenchBlockEntity.itemStacks.set(1, craftingRemainder == null ? ItemStack.EMPTY : new ItemStack(craftingRemainder));
                            }
                        }
                    }
                }

                if (archaeologyWorkbenchBlockEntity.isOn() && archaeologyWorkbenchBlockEntity.canFix(level.registryAccess(), recipe, archaeologyWorkbenchBlockEntity.itemStacks, maxStackSize)) {
                    ++archaeologyWorkbenchBlockEntity.archaeologyProgress;
                    if (archaeologyWorkbenchBlockEntity.archaeologyProgress == archaeologyWorkbenchBlockEntity.archaeologyTotalTime) {
                        archaeologyWorkbenchBlockEntity.archaeologyProgress = 0;
                        archaeologyWorkbenchBlockEntity.archaeologyTotalTime = getTotalArchaeologyTime(level, archaeologyWorkbenchBlockEntity);
                        if (archaeologyWorkbenchBlockEntity.fix(level.registryAccess(), recipe, archaeologyWorkbenchBlockEntity.itemStacks, maxStackSize)) {
                            archaeologyWorkbenchBlockEntity.setRecipeUsed(recipe);
                        }

                        changed = true;
                    }
                } else {
                    archaeologyWorkbenchBlockEntity.archaeologyProgress = 0;
                }
            } else if (!archaeologyWorkbenchBlockEntity.isOn() && archaeologyWorkbenchBlockEntity.archaeologyProgress > 0) {
                archaeologyWorkbenchBlockEntity.archaeologyProgress = Mth.clamp(archaeologyWorkbenchBlockEntity.archaeologyProgress - 2, 0, archaeologyWorkbenchBlockEntity.archaeologyTotalTime);
            }
        }

        if (isOn != archaeologyWorkbenchBlockEntity.isOn()) {
            changed = true;
            blockState = blockState.setValue(ArchaeologyWorkbenchBlock.ACTIVE, Boolean.valueOf(archaeologyWorkbenchBlockEntity.isOn()));
            level.setBlock(blockPos, blockState, 3);
        }

        if (changed) {
            setChanged(level, blockPos, blockState);
        }
    }

    private boolean canFix(RegistryAccess registryAccess, RecipeHolder<?> recipeHolder, NonNullList<ItemStack> itemStacks, int maxStackSize) {
        if (!itemStacks.get(0).isEmpty() && recipeHolder != null) {
            ItemStack output = ((ArchaeologyRecipe) recipeHolder.value()).assemble(new SingleRecipeInput(itemStacks.get(0)), registryAccess);
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

    private boolean fix(RegistryAccess registryAccess, RecipeHolder<?> recipeHolder, NonNullList<ItemStack> itemStacks, int maxStackSize) {
        if (recipeHolder != null && this.canFix(registryAccess, recipeHolder, itemStacks, maxStackSize)) {
            ItemStack input = itemStacks.get(0);
            ItemStack output = ((ArchaeologyRecipe) recipeHolder.value()).assemble(new SingleRecipeInput(itemStacks.get(0)), registryAccess);
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
            return this.getOnTimeMap().getOrDefault(itemStack.getItem(), 0);
        }
    }

    private static int getTotalArchaeologyTime(Level p_222693_, ArchaeologyWorkbenchBlockEntity archaeologyWorkbenchBlockEntity) {
        return archaeologyWorkbenchBlockEntity.recipeCheck.getRecipeFor(new SingleRecipeInput(archaeologyWorkbenchBlockEntity.getItem(0)), p_222693_).map(recipeHolder -> recipeHolder.value().getTime()).orElse(3000);
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
        boolean flag = !itemStack.isEmpty() && ItemStack.isSameItemSameComponents(itemStackInSlot, itemStack);
        this.itemStacks.set(slot, itemStack);
        if (itemStack.getCount() > this.getMaxStackSize()) {
            itemStack.setCount(this.getMaxStackSize());
        }

        if (slot == 0 && !flag) {
            this.archaeologyTotalTime = getTotalArchaeologyTime(this.level, this);
            this.archaeologyProgress = 0;
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
    public void setRecipeUsed(RecipeHolder<?> recipe) {
        if (recipe != null) {
            ResourceLocation recipeId = recipe.id();
            this.recipesUsed.addTo(recipeId, 1);
        }
    }

    @Override
    public RecipeHolder<?> getRecipeUsed() {
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
    protected Component getDefaultName() {
        return FossilsLegacyUtils.translation("container", "archaeology_workbench");
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.itemStacks;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemStacks) {
        this.itemStacks = itemStacks;
    }

    @Override
    protected AbstractContainerMenu createMenu(int windowId, Inventory inventory) {
        return new ArchaeologyWorkbenchMenu(windowId, inventory, this);
    }
}
