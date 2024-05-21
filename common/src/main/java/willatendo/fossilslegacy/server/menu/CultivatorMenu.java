package willatendo.fossilslegacy.server.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.block.CultivatorBlock;
import willatendo.fossilslegacy.server.block.entity.CultivatorBlockEntity;
import willatendo.fossilslegacy.server.menu.slot.FuelSlot;
import willatendo.fossilslegacy.server.menu.slot.ResultSlot;

import java.util.List;

public class CultivatorMenu extends AbstractContainerMenu {
	private final ContainerLevelAccess containerLevelAccess;
	public final CultivatorBlockEntity cultivatorBlockEntity;

	public CultivatorMenu(int windowId, Inventory inventory, CultivatorBlockEntity cultivatorBlockEntity) {
		super(FossilsLegacyMenus.CULTIVATOR.get(), windowId);
		this.containerLevelAccess = ContainerLevelAccess.create(cultivatorBlockEntity.getLevel(), cultivatorBlockEntity.getBlockPos());
		this.cultivatorBlockEntity = cultivatorBlockEntity;

		this.addSlot(new Slot(cultivatorBlockEntity, 0, 49, 20));
		this.addSlot(new FuelSlot(cultivatorBlockEntity, 1, 80, 54, itemStack -> cultivatorBlockEntity.getOnDuration(itemStack) > 0));
		this.addSlot(new ResultSlot(inventory.player, cultivatorBlockEntity, 2, 111, 20));

		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 9; column++) {
				this.addSlot(new Slot(inventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
			}
		}

		for (int column = 0; column < 9; column++) {
			this.addSlot(new Slot(inventory, column, 8 + column * 18, 142));
		}

		this.addDataSlots(cultivatorBlockEntity.containerData);
	}

	public CultivatorMenu(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
		this(windowId, inventory, (CultivatorBlockEntity) inventory.player.level().getBlockEntity(friendlyByteBuf.readBlockPos()));
	}

	@Override
	public boolean stillValid(Player player) {
		return this.containerLevelAccess.evaluate((level, blockPos) -> level.getBlockState(blockPos).getBlock() instanceof CultivatorBlock && player.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
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
			} else {
				if (CultivatorBlockEntity.getOnTimeMap().getOrDefault(itemStackInSlot.getItem(), 0) > 0) {
					this.moveItemStackTo(itemStackInSlot, 1, playerInventoryStartIndex, false);
					return ItemStack.EMPTY;
				} else if (!this.moveItemStackTo(itemStackInSlot, 0, playerInventoryStartIndex, false)) {
					return ItemStack.EMPTY;
				}
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
		int onDuration = this.cultivatorBlockEntity.containerData.get(1);
		if (onDuration == 0) {
			onDuration = 100;
		}

		return this.cultivatorBlockEntity.containerData.get(0) * 14 / onDuration;
	}

	public int getCultivationProgress() {
		int cultivationProgress = this.cultivatorBlockEntity.containerData.get(2);
		int cultivationTotalTime = this.cultivatorBlockEntity.containerData.get(3);
		return cultivationTotalTime != 0 && cultivationProgress != 0 ? cultivationProgress * 22 / cultivationTotalTime : 0;
	}

	public boolean isOn() {
		return this.cultivatorBlockEntity.containerData.get(0) > 0;
	}

}