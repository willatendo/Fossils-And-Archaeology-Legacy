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
import willatendo.fossilslegacy.server.block.blocks.DNACoderBlock;
import willatendo.fossilslegacy.server.block.entity.FABlockEntityTypes;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.item.items.StorageDiscItem;
import willatendo.fossilslegacy.server.menu.menus.DNACoderMenu;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public class DNACoderBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, RecipeCraftingHolder, StackedContentsCompatible {
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
                    return DNACoderBlockEntity.this.onTime;
                case 1:
                    return DNACoderBlockEntity.this.codingProgress;
                case 2:
                    return DNACoderBlockEntity.this.codingTotalTime;
                default:
                    return 0;
            }
        }

        @Override
        public void set(int slot, int set) {
            switch (slot) {
                case 0 -> DNACoderBlockEntity.this.onTime = set;
                case 1 -> DNACoderBlockEntity.this.codingProgress = set;
                case 2 -> DNACoderBlockEntity.this.codingTotalTime = set;
            }

        }

        @Override
        public int getCount() {
            return 3;
        }
    };

    public DNACoderBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FABlockEntityTypes.DNA_CODER.get(), blockPos, blockState);
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

    public static void serverTick(ServerLevel serverLevel, BlockPos blockPos, BlockState blockState, DNACoderBlockEntity dnaCoderBlockEntity) {
        boolean isOn = dnaCoderBlockEntity.isOn();
        boolean changed = false;
        if (dnaCoderBlockEntity.isOn()) {
            --dnaCoderBlockEntity.onTime;
        }

        boolean hasDNA = !dnaCoderBlockEntity.itemStacks.get(0).isEmpty();
        boolean hasDisc = !dnaCoderBlockEntity.itemStacks.get(1).isEmpty();
        if (dnaCoderBlockEntity.isOn() || hasDisc && hasDNA) {
            int maxStackSize = dnaCoderBlockEntity.getMaxStackSize();
            if (!dnaCoderBlockEntity.isOn() && dnaCoderBlockEntity.canEncode(dnaCoderBlockEntity.itemStacks, maxStackSize)) {
                dnaCoderBlockEntity.onTime = 100;
                if (dnaCoderBlockEntity.isOn()) {
                    changed = true;
                }
            }

            if (dnaCoderBlockEntity.isOn() && dnaCoderBlockEntity.canEncode(dnaCoderBlockEntity.itemStacks, maxStackSize)) {
                ++dnaCoderBlockEntity.codingProgress;
                if (dnaCoderBlockEntity.codingProgress == dnaCoderBlockEntity.codingTotalTime) {
                    dnaCoderBlockEntity.codingProgress = 0;
                    dnaCoderBlockEntity.codingTotalTime = 100;
                    dnaCoderBlockEntity.encode(dnaCoderBlockEntity.itemStacks, maxStackSize);
                    changed = true;
                }
            } else {
                dnaCoderBlockEntity.codingProgress = 0;
            }
        } else if (!dnaCoderBlockEntity.isOn() && dnaCoderBlockEntity.codingProgress > 0) {
            dnaCoderBlockEntity.codingProgress = Mth.clamp(dnaCoderBlockEntity.codingProgress - 2, 0, dnaCoderBlockEntity.codingTotalTime);
        }

        if (isOn != dnaCoderBlockEntity.isOn()) {
            changed = true;
            blockState = blockState.setValue(DNACoderBlock.ACTIVE, Boolean.valueOf(dnaCoderBlockEntity.isOn()));
            serverLevel.setBlock(blockPos, blockState, 3);
        }

        if (changed) {
            setChanged(serverLevel, blockPos, blockState);
        }
    }

    private boolean canEncode(NonNullList<ItemStack> itemStacks, int maxStackSize) {
        ItemStack dna = itemStacks.get(0);
        ItemStack disc = itemStacks.get(1);
        if (!dna.isEmpty() && !disc.isEmpty() && !disc.has(DataComponents.CUSTOM_DATA)) {
            ItemStack output = new ItemStack(FAItems.STORAGE_DISC.get());
            StorageDiscItem.copyDNA(output, dna);
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

    private void encode(NonNullList<ItemStack> itemStacks, int maxStackSize) {
        if (this.canEncode(itemStacks, maxStackSize)) {
            ItemStack dna = itemStacks.get(0);
            ItemStack disc = itemStacks.get(1);
            ItemStack output = new ItemStack(FAItems.STORAGE_DISC.get());
            StorageDiscItem.copyDNA(output, dna);
            ItemStack outputSlot = itemStacks.get(2);
            if (outputSlot.isEmpty()) {
                itemStacks.set(2, output.copy());
            } else if (outputSlot.is(output.getItem())) {
                outputSlot.grow(output.getCount());
            }

            dna.shrink(1);
            disc.shrink(1);
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

        if ((slot == 0 || slot == 1 || slot == 2 || slot == 3 || slot == 4 || slot == 5 || slot == 6 || slot == 7 || slot == 8) && !flag) {
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
        return FAUtils.translation("container", "dna_coder");
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
        return new DNACoderMenu(windowId, inventory, this);
    }

    public NonNullList<ItemStack> getItemStacks() {
        return this.itemStacks;
    }
}
