package willatendo.fossilslegacy.server.block.entity.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedItemContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeCraftingHolder;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.block.blocks.DNAHybridizerBlock;
import willatendo.fossilslegacy.server.block.entity.FABlockEntityTypes;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.item.items.StorageDiscItem;
import willatendo.fossilslegacy.server.menu.menus.DNAHybridizerMenu;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;
import java.util.UUID;

public class DNAHybridizerBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, RecipeCraftingHolder, StackedContentsCompatible {
    private static final int[] SLOTS_FOR_UP = new int[]{0};
    private static final int[] SLOTS_FOR_DOWN = new int[]{2};
    private static final int[] SLOTS_FOR_SIDES = new int[]{1};
    protected NonNullList<ItemStack> itemStacks = NonNullList.withSize(3, ItemStack.EMPTY);
    public int onTime;
    public int codingProgress;
    public int codingTotalTime;
    public final ContainerData containerData = new ContainerData() {
        @Override
        public int get(int slot) {
            switch (slot) {
                case 0:
                    return DNAHybridizerBlockEntity.this.onTime;
                case 1:
                    return DNAHybridizerBlockEntity.this.codingProgress;
                case 2:
                    return DNAHybridizerBlockEntity.this.codingTotalTime;
                default:
                    return 0;
            }
        }

        @Override
        public void set(int slot, int set) {
            switch (slot) {
                case 0 -> DNAHybridizerBlockEntity.this.onTime = set;
                case 1 -> DNAHybridizerBlockEntity.this.codingProgress = set;
                case 2 -> DNAHybridizerBlockEntity.this.codingTotalTime = set;
            }

        }

        @Override
        public int getCount() {
            return 3;
        }
    };

    public DNAHybridizerBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FABlockEntityTypes.DNA_HYBRIDIZER.get(), blockPos, blockState);
    }

    private boolean isOn() {
        return this.onTime > 0;
    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(compoundTag, this.itemStacks, provider);
        this.onTime = compoundTag.getInt("on_time");
        this.codingProgress = compoundTag.getInt("coding_time");
        this.codingTotalTime = compoundTag.getInt("coding_time_total");
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        compoundTag.putInt("on_time", this.onTime);
        compoundTag.putInt("coding_time", this.codingProgress);
        compoundTag.putInt("coding_time_total", this.codingTotalTime);
        ContainerHelper.saveAllItems(compoundTag, this.itemStacks, provider);
    }

    public static void serverTick(ServerLevel serverLevel, BlockPos blockPos, BlockState blockState, DNAHybridizerBlockEntity dnaHybridizerBlockEntity) {
        boolean isOn = dnaHybridizerBlockEntity.isOn();
        boolean changed = false;
        if (dnaHybridizerBlockEntity.isOn()) {
            --dnaHybridizerBlockEntity.onTime;
        }

        boolean hasDNA1 = !dnaHybridizerBlockEntity.itemStacks.get(0).isEmpty();
        boolean hasDNA2 = !dnaHybridizerBlockEntity.itemStacks.get(1).isEmpty();
        if (dnaHybridizerBlockEntity.isOn() || hasDNA2 && hasDNA1) {
            int maxStackSize = dnaHybridizerBlockEntity.getMaxStackSize();
            if (!dnaHybridizerBlockEntity.isOn() && dnaHybridizerBlockEntity.canHybridize(dnaHybridizerBlockEntity.itemStacks, maxStackSize)) {
                dnaHybridizerBlockEntity.onTime = 100;
                if (dnaHybridizerBlockEntity.isOn()) {
                    changed = true;
                }
            }

            if (dnaHybridizerBlockEntity.isOn() && dnaHybridizerBlockEntity.canHybridize(dnaHybridizerBlockEntity.itemStacks, maxStackSize)) {
                ++dnaHybridizerBlockEntity.codingProgress;
                if (dnaHybridizerBlockEntity.codingProgress == dnaHybridizerBlockEntity.codingTotalTime) {
                    dnaHybridizerBlockEntity.codingProgress = 0;
                    dnaHybridizerBlockEntity.codingTotalTime = 100;
                    dnaHybridizerBlockEntity.hybridize(dnaHybridizerBlockEntity.itemStacks, maxStackSize);
                    changed = true;
                }
            } else {
                dnaHybridizerBlockEntity.codingProgress = 0;
            }
        } else if (!dnaHybridizerBlockEntity.isOn() && dnaHybridizerBlockEntity.codingProgress > 0) {
            dnaHybridizerBlockEntity.codingProgress = Mth.clamp(dnaHybridizerBlockEntity.codingProgress - 2, 0, dnaHybridizerBlockEntity.codingTotalTime);
        }

        if (isOn != dnaHybridizerBlockEntity.isOn()) {
            changed = true;
            blockState = blockState.setValue(DNAHybridizerBlock.ACTIVE, Boolean.valueOf(dnaHybridizerBlockEntity.isOn()));
            serverLevel.setBlock(blockPos, blockState, 3);
        }

        if (changed) {
            setChanged(serverLevel, blockPos, blockState);
        }
    }

    private boolean canHybridize(NonNullList<ItemStack> itemStacks, int maxStackSize) {
        ItemStack dna1 = itemStacks.get(0);
        ItemStack dna2 = itemStacks.get(1);
        if (!dna1.isEmpty() && !dna2.isEmpty() && dna1.getItem() == dna2.getItem() && !dna1.has(FADataComponents.MODEL_TYPE.get()) && !dna1.has(FADataComponents.PATTERN_HOLDER.get()) && !dna2.has(FADataComponents.MODEL_TYPE.get()) && !dna2.has(FADataComponents.PATTERN_HOLDER.get()) && dna1.has(FADataComponents.PURITY.get()) && dna2.has(FADataComponents.PURITY.get()) && dna1.get(FADataComponents.PURITY.get()) != 100 && dna2.get(FADataComponents.PURITY.get()) != 100) {
            ItemStack output = new ItemStack(dna1.getItem());
            if (dna1.has(FADataComponents.GENETIC_CODE.get()) && dna2.has(FADataComponents.GENETIC_CODE.get())) {
                UUID geneticCode1 = dna1.get(FADataComponents.GENETIC_CODE.get());
                UUID geneticCode2 = dna1.get(FADataComponents.GENETIC_CODE.get());
                if (geneticCode1 == geneticCode2) {
                    return false;
                }
                output.set(FADataComponents.GENETIC_CODE.get(), dna1.get(FADataComponents.GENETIC_CODE.get()));
            }
            int dna1Purity = dna1.get(FADataComponents.PURITY.get());
            int dna2Purity = dna2.get(FADataComponents.PURITY.get());
            int newPurity = dna1Purity + dna2Purity;
            output.set(FADataComponents.PURITY.get(), Math.min(newPurity, 100));
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

    private void hybridize(NonNullList<ItemStack> itemStacks, int maxStackSize) {
        if (this.canHybridize(itemStacks, maxStackSize)) {
            ItemStack dna1 = itemStacks.get(0);
            ItemStack dna2 = itemStacks.get(1);
            ItemStack output = new ItemStack(dna1.getItem());
            int dna1Purity = dna1.get(FADataComponents.PURITY.get());
            int dna2Purity = dna2.get(FADataComponents.PURITY.get());
            int newPurity = dna1Purity + dna2Purity;
            output.set(FADataComponents.PURITY.get(), Math.min(newPurity, 100));
            ItemStack outputSlot = itemStacks.get(2);
            if (outputSlot.isEmpty()) {
                itemStacks.set(2, output.copy());
            } else if (outputSlot.is(output.getItem())) {
                outputSlot.grow(output.getCount());
            }

            dna1.shrink(1);
            dna2.shrink(1);
        }
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

        if ((slot == 0 || slot == 1) && !flag) {
            this.codingTotalTime = 100;
            this.codingProgress = 0;
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
        if (slot == 0 || slot == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void awardUsedRecipes(Player player, List<ItemStack> itemStacks) {
    }

    @Override
    public void clearContent() {
        this.itemStacks.clear();
    }

    @Override
    public void setRecipeUsed(RecipeHolder<?> recipeHolder) {
    }

    @Override
    public RecipeHolder<?> getRecipeUsed() {
        return null;
    }

    @Override
    public void fillStackedContents(StackedItemContents stackedItemContents) {
        for (ItemStack itemStack : this.itemStacks) {
            stackedItemContents.accountStack(itemStack);
        }
    }

    @Override
    protected Component getDefaultName() {
        return FAUtils.translation("container", "dna_hybridizer");
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
        return new DNAHybridizerMenu(windowId, inventory, this);
    }
}
