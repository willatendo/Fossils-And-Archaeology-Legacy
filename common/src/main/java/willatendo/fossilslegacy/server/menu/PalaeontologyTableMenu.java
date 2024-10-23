package willatendo.fossilslegacy.server.menu;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.block.PalaeontologyTableBlock;
import willatendo.fossilslegacy.server.block.entity.PalaeontologyTableBlockEntity;
import willatendo.fossilslegacy.server.menu.slot.ResultSlot;
import willatendo.fossilslegacy.server.tags.FossilsLegacyItemTags;

public class PalaeontologyTableMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess containerLevelAccess;
    public final PalaeontologyTableBlockEntity palaeontologyTableBlockEntity;

    public PalaeontologyTableMenu(int windowId, Inventory inventory, PalaeontologyTableBlockEntity palaeontologyTableBlockEntity) {
        super(FossilsLegacyMenuTypes.PALAEONTOLOGY_TABLE.get(), windowId);
        this.containerLevelAccess = ContainerLevelAccess.create(palaeontologyTableBlockEntity.getLevel(), palaeontologyTableBlockEntity.getBlockPos());
        this.palaeontologyTableBlockEntity = palaeontologyTableBlockEntity;

        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 3; ++column) {
                this.addSlot(new Slot(palaeontologyTableBlockEntity, column + row * 3, 8 + column * 18, 17 + row * 18) {
                    @Override
                    public int getMaxStackSize(ItemStack itemStack) {
                        return 1;
                    }

                    @Override
                    public boolean mayPlace(ItemStack itemStack) {
                        return itemStack.is(FossilsLegacyItemTags.MESOZOIC_FOSSIL);
                    }
                });
            }
        }

        this.addSlot(new ResultSlot(inventory.player, palaeontologyTableBlockEntity, 9, 148, 35));

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                this.addSlot(new Slot(inventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
            }
        }

        for (int column = 0; column < 9; column++) {
            this.addSlot(new Slot(inventory, column, 8 + column * 18, 142));
        }
    }

    public PalaeontologyTableMenu(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(windowId, inventory, friendlyByteBuf.readBlockPos());
    }

    public PalaeontologyTableMenu(int windowId, Inventory inventory, BlockPos blockPos) {
        this(windowId, inventory, (PalaeontologyTableBlockEntity) inventory.player.level().getBlockEntity(blockPos));
    }

    @Override
    public boolean stillValid(Player player) {
        return this.containerLevelAccess.evaluate((level, blockPos) -> level.getBlockState(blockPos).getBlock() instanceof PalaeontologyTableBlock && player.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        ItemStack emptyItemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotIndex);
        if (slot != null && slot.hasItem()) {
            ItemStack slotItemStack = slot.getItem();
            emptyItemStack = slotItemStack.copy();
            if (slotIndex == 0) {
                if (!this.moveItemStackTo(slotItemStack, 10, 46, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(slotItemStack, emptyItemStack);
            } else if (slotIndex >= 10 && slotIndex < 46) {
                if (!this.moveItemStackTo(slotItemStack, 0, 9, false)) {
                    if (slotIndex < 37) {
                        if (!this.moveItemStackTo(slotItemStack, 36, 45, false)) {
                            return ItemStack.EMPTY;
                        }
                    } else if (!this.moveItemStackTo(slotItemStack, 9, 36, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.moveItemStackTo(slotItemStack, 9, 45, false)) {
                return ItemStack.EMPTY;
            }

            if (slotItemStack.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (slotItemStack.getCount() == emptyItemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, slotItemStack);
            if (slotIndex == 0) {
                player.drop(slotItemStack, false);
            }
        }

        return emptyItemStack;
    }
}
