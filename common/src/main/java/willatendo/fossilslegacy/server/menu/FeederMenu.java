package willatendo.fossilslegacy.server.menu;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.block.FeederBlock;
import willatendo.fossilslegacy.server.block.entity.FeederBlockEntity;
import willatendo.fossilslegacy.server.item.feederfood.FeederFood;
import willatendo.fossilslegacy.server.item.feederfood.FillType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

public class FeederMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess containerLevelAccess;
    public final FeederBlockEntity feederBlockEntity;

    public FeederMenu(int windowId, Inventory inventory, FeederBlockEntity feederBlockEntity) {
        super(FossilsLegacyMenuTypes.FEEDER.get(), windowId);
        Level level = feederBlockEntity.getLevel();
        this.containerLevelAccess = ContainerLevelAccess.create(level, feederBlockEntity.getBlockPos());
        this.feederBlockEntity = feederBlockEntity;

        this.addSlot(new Slot(feederBlockEntity, 0, 60, 62) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                FeederFood feederFood = FeederFood.getFeederFood(level, itemStack);
                return feederFood != null && feederFood.getFillType() == FillType.MEAT;
            }
        });
        this.addSlot(new Slot(feederBlockEntity, 1, 104, 62) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                FeederFood feederFood = FeederFood.getFeederFood(level, itemStack);
                return feederFood != null && feederFood.getFillType() == FillType.PLANT;
            }
        });

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                this.addSlot(new Slot(inventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
            }
        }

        for (int column = 0; column < 9; column++) {
            this.addSlot(new Slot(inventory, column, 8 + column * 18, 142));
        }

        this.addDataSlots(feederBlockEntity.containerData);
    }

    public FeederMenu(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(windowId, inventory, friendlyByteBuf.readBlockPos());
    }

    public FeederMenu(int windowId, Inventory inventory, BlockPos blockPos) {
        this(windowId, inventory, (FeederBlockEntity) inventory.player.level().getBlockEntity(blockPos));
    }

    @Override
    public boolean stillValid(Player player) {
        return this.containerLevelAccess.evaluate((level, blockPos) -> level.getBlockState(blockPos).getBlock() instanceof FeederBlock && player.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        ItemStack itemStack = ItemStack.EMPTY;
        List<Slot> inventorySlots = this.slots;
        Slot slot = inventorySlots.get(slotIndex);

        if (slot != null && slot.hasItem()) {
            ItemStack itemStackInSlot = slot.getItem();
            itemStack = itemStackInSlot.copy();

            int playerInventoryStartIndex = 2;

            if (slotIndex < playerInventoryStartIndex) {
                if (!this.moveItemStackTo(itemStackInSlot, playerInventoryStartIndex, inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemStackInSlot, 0, playerInventoryStartIndex, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStackInSlot.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemStackInSlot.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemStackInSlot);
        }

        return itemStack;
    }

    public int getMeatScaled(int scale) {
        if (this.feederBlockEntity.containerData.get(0) == 0) {
            return 0;
        }
        return this.feederBlockEntity.containerData.get(0) * scale / 10000;
    }

    public int getPlantsScaled(int scale) {
        if (this.feederBlockEntity.containerData.get(1) == 0) {
            return 0;
        }
        return this.feederBlockEntity.containerData.get(1) * scale / 10000;
    }
}
