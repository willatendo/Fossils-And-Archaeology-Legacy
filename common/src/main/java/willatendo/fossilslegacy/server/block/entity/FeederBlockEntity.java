package willatendo.fossilslegacy.server.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.block.FeederBlock;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.item.feederfood.FeederFood;
import willatendo.fossilslegacy.server.menu.FeederMenu;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FeederBlockEntity extends BaseContainerBlockEntity {
    private NonNullList<ItemStack> itemStacks = NonNullList.withSize(2, ItemStack.EMPTY);
    public int meatLevel = 0;
    public final int maxMeatLevel = 10000;
    public int plantsLevel = 0;
    public final int maxPlantsLevel = 10000;
    public final ContainerData containerData = new ContainerData() {
        @Override
        public int get(int data) {
            switch (data) {
                case 0:
                    return FeederBlockEntity.this.meatLevel;
                case 1:
                    return FeederBlockEntity.this.plantsLevel;
                default:
                    return 0;
            }
        }

        @Override
        public void set(int data, int set) {
            switch (data) {
                case 0:
                    FeederBlockEntity.this.meatLevel = set;
                    break;
                case 1:
                    FeederBlockEntity.this.plantsLevel = set;
                    break;
            }

        }

        @Override
        public int getCount() {
            return 2;
        }
    };

    public FeederBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FossilsLegacyBlockEntityTypes.FEEDER.get(), blockPos, blockState);
    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        this.meatLevel = compoundTag.getInt("MeatLevel");
        this.plantsLevel = compoundTag.getInt("PlantsLevel");
        this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(compoundTag, this.itemStacks, provider);
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        compoundTag.putInt("MeatLevel", this.meatLevel);
        compoundTag.putInt("PlantsLevel", this.plantsLevel);
        ContainerHelper.saveAllItems(compoundTag, this.itemStacks, provider);
    }

    public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, FeederBlockEntity feederBlockEntity) {
        boolean hasFood = (feederBlockEntity.meatLevel > 0 || feederBlockEntity.plantsLevel > 0);
        boolean changed = false;
        ItemStack meat = feederBlockEntity.itemStacks.get(0);
        ItemStack plants = feederBlockEntity.itemStacks.get(1);

        if (!meat.isEmpty()) {
            FeederFood feederFood = FeederFood.getFeederFood(level, meat);
            if (feederFood != null) {
                int amount = feederFood.getAmount();
                if (!(amount + feederBlockEntity.meatLevel > feederBlockEntity.maxMeatLevel)) {
                    feederBlockEntity.meatLevel += amount;
                    meat.shrink(1);
                    changed = true;
                }
            }
        }
        if (!plants.isEmpty()) {
            FeederFood feederFood = FeederFood.getFeederFood(level, plants);
            if (feederFood != null) {
                int amount = feederFood.getAmount();
                if (!(amount + feederBlockEntity.plantsLevel > feederBlockEntity.maxPlantsLevel)) {
                    feederBlockEntity.plantsLevel += amount;
                    plants.shrink(1);
                    changed = true;
                }
            }
        }

        if (hasFood) {
            level.setBlock(blockPos, blockState.setValue(FeederBlock.HAS_FOOD, true), 3);
            changed = true;
        } else {
            level.setBlock(blockPos, blockState.setValue(FeederBlock.HAS_FOOD, false), 3);
            changed = true;
        }

        if (changed) {
            setChanged(level, blockPos, blockState);
        }
    }

    public boolean hasFood(boolean meat) {
        return meat ? this.meatLevel > 0 : this.plantsLevel > 0;
    }

    public void feed(Dinosaur dinosaur, boolean meat) {
        while (dinosaur.feed() && this.hasFood(meat)) {
            if (meat) {
                this.meatLevel--;
            } else {
                this.plantsLevel--;
            }
        }
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
        boolean flag = !itemStack.isEmpty() && ItemStack.isSameItem(itemStackInSlot, itemStack) && ItemStack.isSameItemSameComponents(itemStack, itemStackInSlot);
        this.itemStacks.set(slot, itemStack);
        if (itemStack.getCount() > this.getMaxStackSize()) {
            itemStack.setCount(this.getMaxStackSize());
        }

        if ((slot == 0 || slot == 1) && !flag) {
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
    public void clearContent() {
        this.itemStacks.clear();
    }

    @Override
    protected Component getDefaultName() {
        return FossilsLegacyUtils.translation("container", "feeder");
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
        return new FeederMenu(windowId, inventory, this);
    }
}
