package willatendo.fossilslegacy.server.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.block.ArchaeologyWorkbenchBlock;
import willatendo.fossilslegacy.server.block.entity.ArchaeologyWorkbenchBlockEntity;
import willatendo.fossilslegacy.server.menu.slot.FuelSlot;
import willatendo.fossilslegacy.server.menu.slot.ResultSlot;

import java.util.List;

public class ArchaeologyWorkbenchMenu extends AbstractContainerMenu {
	private final ContainerLevelAccess containerLevelAccess;
	public final ArchaeologyWorkbenchBlockEntity archaeologyWorkbenchBlockEntity;

	public ArchaeologyWorkbenchMenu(int windowId, Inventory inventory, ArchaeologyWorkbenchBlockEntity archaeologyWorkbenchBlockEntity) {
		super(FossilsLegacyMenus.ARCHAEOLOGY_WORKBENCH.get(), windowId);
		this.containerLevelAccess = ContainerLevelAccess.create(archaeologyWorkbenchBlockEntity.getLevel(), archaeologyWorkbenchBlockEntity.getBlockPos());
		this.archaeologyWorkbenchBlockEntity = archaeologyWorkbenchBlockEntity;

		this.addSlot(new Slot(archaeologyWorkbenchBlockEntity, 0, 49, 20));
		this.addSlot(new FuelSlot(archaeologyWorkbenchBlockEntity, 1, 80, 54, itemStack -> archaeologyWorkbenchBlockEntity.getOnDuration(itemStack) > 0));
		this.addSlot(new ResultSlot(inventory.player, archaeologyWorkbenchBlockEntity, 2, 111, 20));

		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 9; column++) {
				this.addSlot(new Slot(inventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
			}
		}

		for (int column = 0; column < 9; column++) {
			this.addSlot(new Slot(inventory, column, 8 + column * 18, 142));
		}

		this.addDataSlots(archaeologyWorkbenchBlockEntity.containerData);
	}

	public ArchaeologyWorkbenchMenu(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
		this(windowId, inventory, (ArchaeologyWorkbenchBlockEntity) inventory.player.level().getBlockEntity(friendlyByteBuf.readBlockPos()));
	}

	@Override
	public boolean stillValid(Player player) {
		return this.containerLevelAccess.evaluate((level, blockPos) -> level.getBlockState(blockPos).getBlock() instanceof ArchaeologyWorkbenchBlock && player.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
	}

	@Override
	public ItemStack quickMoveStack(Player player, int slotIndex) {
		ItemStack itemStack = ItemStack.EMPTY;
		List<Slot> inventorySlots = this.slots;
		Slot slot = inventorySlots.get(slotIndex);

		if (slot != null && slot.hasItem()) {
			ItemStack itemStackInSlot = slot.getItem();
			itemStack = itemStackInSlot.copy();

			int playerInventoryStartIndex = 3;

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

	public int getOnProgress() {
		int onDuration = this.archaeologyWorkbenchBlockEntity.containerData.get(1);
		if (onDuration == 0) {
			onDuration = 100;
		}

		return this.archaeologyWorkbenchBlockEntity.containerData.get(0) * 14 / onDuration;
	}

	public int getArchaeologyProgress() {
		int archaeologyProgress = this.archaeologyWorkbenchBlockEntity.containerData.get(2);
		int archaeologyTotalTime = this.archaeologyWorkbenchBlockEntity.containerData.get(3);
		return archaeologyTotalTime != 0 && archaeologyProgress != 0 ? archaeologyProgress * 24 / archaeologyTotalTime : 0;
	}

	public boolean isOn() {
		return this.archaeologyWorkbenchBlockEntity.containerData.get(0) > 0;
	}

}