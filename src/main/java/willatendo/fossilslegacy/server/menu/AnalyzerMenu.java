package willatendo.fossilslegacy.server.menu;

import java.util.List;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.block.AnalyzerBlock;
import willatendo.fossilslegacy.server.block.entity.AnalyzerBlockEntity;
import willatendo.fossilslegacy.server.menu.slot.ResultSlot;

public class AnalyzerMenu extends AbstractContainerMenu {
	private final ContainerLevelAccess containerLevelAccess;
	public final AnalyzerBlockEntity analyzerBlockEntity;

	public AnalyzerMenu(int windowId, Inventory inventory, AnalyzerBlockEntity analyzerBlockEntity) {
		super(FossilsLegacyMenus.ANALYZER.get(), windowId);
		this.containerLevelAccess = ContainerLevelAccess.create(analyzerBlockEntity.getLevel(), analyzerBlockEntity.getBlockPos());
		this.analyzerBlockEntity = analyzerBlockEntity;

		for (int row = 0; row < 3; ++row) {
			for (int column = 0; column < 3; ++column) {
				this.addSlot(new Slot(analyzerBlockEntity, column + row * 3, 8 + column * 18, 18 + row * 18));
			}
		}
		
		this.addSlot(new ResultSlot(inventory.player, analyzerBlockEntity, 9, 102, 22));
		for (int column = 0; column < 3; ++column) {
			this.addSlot(new ResultSlot(inventory.player, analyzerBlockEntity, column + 10, 98 + column * 18, 54));
		}

		for (int row = 0; row < 3; ++row) {
			for (int column = 0; column < 9; ++column) {
				this.addSlot(new Slot(inventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
			}
		}

		for (int column = 0; column < 9; ++column) {
			this.addSlot(new Slot(inventory, column, 8 + column * 18, 142));
		}

		this.addDataSlots(analyzerBlockEntity.containerData);
	}

	public AnalyzerMenu(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
		this(windowId, inventory, (AnalyzerBlockEntity) inventory.player.level().getBlockEntity(friendlyByteBuf.readBlockPos()));
	}

	@Override
	public boolean stillValid(Player player) {
		return this.containerLevelAccess.evaluate((level, blockPos) -> level.getBlockState(blockPos).getBlock() instanceof AnalyzerBlock && player.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
	}

	@Override
	public ItemStack quickMoveStack(Player player, int slotIndex) {
		ItemStack itemStack = ItemStack.EMPTY;
		List<Slot> inventorySlots = this.slots;
		Slot slot = inventorySlots.get(slotIndex);

		if (slot != null && slot.hasItem()) {
			ItemStack itemStackInSlot = slot.getItem();
			itemStack = itemStackInSlot.copy();

			int playerInventoryStartIndex = 13;

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

	public int getAnalyzerProgress() {
		int analyzerProgress = this.analyzerBlockEntity.containerData.get(1);
		int analyzerTotalTime = this.analyzerBlockEntity.containerData.get(2);
		return analyzerTotalTime != 0 && analyzerProgress != 0 ? analyzerProgress * 22 / analyzerTotalTime : 0;
	}

	public boolean isOn() {
		return this.analyzerBlockEntity.containerData.get(0) > 0;
	}

}