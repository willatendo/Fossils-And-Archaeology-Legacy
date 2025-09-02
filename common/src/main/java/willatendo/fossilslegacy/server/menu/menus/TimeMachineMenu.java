package willatendo.fossilslegacy.server.menu.menus;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.block.blocks.TimeMachineBlock;
import willatendo.fossilslegacy.server.block.entity.entities.TimeMachineBlockEntity;
import willatendo.fossilslegacy.server.menu.FAMenuTypes;
import willatendo.fossilslegacy.server.menu.slot.CoinSlot;

public class TimeMachineMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess containerLevelAccess;
    public final TimeMachineBlockEntity timeMachineBlockEntity;

    public TimeMachineMenu(int windowId, Inventory inventory, TimeMachineBlockEntity timeMachineBlockEntity) {
        super(FAMenuTypes.TIME_MACHINE.get(), windowId);
        this.containerLevelAccess = ContainerLevelAccess.create(timeMachineBlockEntity.getLevel(), timeMachineBlockEntity.getBlockPos());
        this.timeMachineBlockEntity = timeMachineBlockEntity;

        this.addSlot(new CoinSlot(timeMachineBlockEntity, 0, 80, 37));

        this.addStandardInventorySlots(inventory, 8, 84);

        this.addDataSlots(timeMachineBlockEntity.containerData);
    }

    public TimeMachineMenu(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(windowId, inventory, friendlyByteBuf.readBlockPos());
    }

    public TimeMachineMenu(int windowId, Inventory inventory, BlockPos blockPos) {
        this(windowId, inventory, (TimeMachineBlockEntity) inventory.player.level().getBlockEntity(blockPos));
    }

    @Override
    public boolean stillValid(Player player) {
        return this.containerLevelAccess.evaluate((level, blockPos) -> level.getBlockState(blockPos).getBlock() instanceof TimeMachineBlock && player.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotIndex);
        if (slot != null && slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            itemstack = slotStack.copy();
            if (slotIndex < 1) {
                if (!this.moveItemStackTo(slotStack, 1, 37, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(slotStack, 0, 1, false)) {
                return ItemStack.EMPTY;
            }

            if (slotStack.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (slotStack.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, slotStack);
        }

        return itemstack;
    }

    public int getChargeLevel() {
        return this.getContainerData().get(0);
    }

    public boolean isCharged() {
        return this.getContainerData().get(0) == TimeMachineBlockEntity.MAX_CHARGE;
    }

    protected ContainerData getContainerData() {
        return this.timeMachineBlockEntity.containerData;
    }
}
