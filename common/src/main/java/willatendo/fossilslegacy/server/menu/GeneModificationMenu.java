package willatendo.fossilslegacy.server.menu;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.block.GeneModificationBlock;
import willatendo.fossilslegacy.server.block.entity.GeneModificationTableBlockEntity;
import willatendo.fossilslegacy.server.item.DNAItem;
import willatendo.fossilslegacy.server.menu.slot.ResultSlot;

import java.util.List;

public class GeneModificationMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess containerLevelAccess;
    public final GeneModificationTableBlockEntity geneModificationTableBlockEntity;
    public final Player player;

    public GeneModificationMenu(int windowId, Inventory inventory, GeneModificationTableBlockEntity geneModificationTableBlockEntity) {
        super(FossilsLegacyMenuTypes.GENE_MODIFICATION.get(), windowId);
        this.containerLevelAccess = ContainerLevelAccess.create(geneModificationTableBlockEntity.getLevel(), geneModificationTableBlockEntity.getBlockPos());
        this.geneModificationTableBlockEntity = geneModificationTableBlockEntity;
        this.player = inventory.player;

        this.addSlot(new Slot(geneModificationTableBlockEntity, 0, 30, 26) {
            @Override
            public int getMaxStackSize() {
                return 1;
            }

            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.getItem() instanceof DNAItem;
            }
        });

        this.addSlot(new ResultSlot(this.player, geneModificationTableBlockEntity, 1, 58, 26));

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                this.addSlot(new Slot(inventory, column + row * 9 + 9, 8 + column * 18, 105 + row * 18));
            }
        }

        for (int column = 0; column < 9; column++) {
            this.addSlot(new Slot(inventory, column, 8 + column * 18, 163));
        }
    }

    public GeneModificationMenu(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(windowId, inventory, friendlyByteBuf.readBlockPos());
    }

    public GeneModificationMenu(int windowId, Inventory inventory, BlockPos blockPos) {
        this(windowId, inventory, (GeneModificationTableBlockEntity) inventory.player.level().getBlockEntity(blockPos));
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        ItemStack itemStack = ItemStack.EMPTY;
        List<Slot> inventorySlots = this.slots;
        Slot slot = inventorySlots.get(slotIndex);

        if (slot != null && slot.hasItem()) {
            ItemStack itemStackInSlot = slot.getItem();
            itemStack = itemStackInSlot.copy();

            int playerInventoryStartIndex = 1;

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

    @Override
    public boolean stillValid(Player player) {
        return this.containerLevelAccess.evaluate((level, blockPos) -> level.getBlockState(blockPos).getBlock() instanceof GeneModificationBlock && player.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
    }
}
