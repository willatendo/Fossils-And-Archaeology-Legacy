package willatendo.fossilslegacy.server.menu.menus;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import willatendo.fossilslegacy.client.screen.DNARecombinatorScreen;
import willatendo.fossilslegacy.server.block.blocks.DNARecombinatorBlock;
import willatendo.fossilslegacy.server.block.entity.entities.DNARecombinatorBlockEntity;
import willatendo.fossilslegacy.server.item.items.DNAItem;
import willatendo.fossilslegacy.server.menu.FAMenuTypes;
import willatendo.fossilslegacy.server.menu.slot.GeneticCodeSlot;
import willatendo.fossilslegacy.server.menu.slot.ResultSlot;

import java.util.List;

public class DNARecombinatorMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess containerLevelAccess;
    public final DNARecombinatorBlockEntity DNARecombinatorBlockEntity;
    public final Player player;
    public final Slot[] geneticSlots = new Slot[3];

    public DNARecombinatorMenu(int windowId, Inventory inventory, DNARecombinatorBlockEntity DNARecombinatorBlockEntity) {
        super(FAMenuTypes.GENE_MODIFICATION.get(), windowId);
        this.containerLevelAccess = ContainerLevelAccess.create(DNARecombinatorBlockEntity.getLevel(), DNARecombinatorBlockEntity.getBlockPos());
        this.DNARecombinatorBlockEntity = DNARecombinatorBlockEntity;
        this.player = inventory.player;
    }

    public DNARecombinatorMenu(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(windowId, inventory, friendlyByteBuf.readBlockPos());
    }

    public DNARecombinatorMenu(int windowId, Inventory inventory, BlockPos blockPos) {
        this(windowId, inventory, (DNARecombinatorBlockEntity) inventory.player.level().getBlockEntity(blockPos));
    }

    public boolean hasExtraGeneticCodeInSlot(int slot) {
        return this.geneticSlots[slot] != null && this.geneticSlots[slot].hasItem();
    }

    public Slot getGeneticCodeInSlot(int slot) {
        return this.geneticSlots[slot];
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        ItemStack itemStack = ItemStack.EMPTY;
        List<Slot> inventorySlots = this.slots;
        Slot slot = inventorySlots.get(slotIndex);

        if (slot != null && slot.hasItem()) {
            ItemStack itemStackInSlot = slot.getItem();
            itemStack = itemStackInSlot.copy();

            int playerInventoryStartIndex = 5;

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
        return this.containerLevelAccess.evaluate((level, blockPos) -> level.getBlockState(blockPos).getBlock() instanceof DNARecombinatorBlock && player.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
    }
}
