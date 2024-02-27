package willatendo.fossilsexperiments.server.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilsexperiments.server.block.TimeMachineBlock;
import willatendo.fossilsexperiments.server.block.entity.TimeMachineBlockEntity;

public class TimeMachineMenu extends AbstractContainerMenu {
	private final ContainerLevelAccess containerLevelAccess;
	public final TimeMachineBlockEntity timeMachineBlockEntity;

	public TimeMachineMenu(int windowId, Inventory inventory, TimeMachineBlockEntity timeMachineBlockEntity) {
		super(FossilsExperimentsMenus.TIME_MACHINE.get(), windowId);
		this.containerLevelAccess = ContainerLevelAccess.create(timeMachineBlockEntity.getLevel(), timeMachineBlockEntity.getBlockPos());
		this.timeMachineBlockEntity = timeMachineBlockEntity;

		for (int column = 0; column < 2; column++) {
			for (int row = 0; row < 3; row++) {
				this.addSlot(new Slot(timeMachineBlockEntity, row + column * 3, 8 + 18 * column, 18 + 18 * row));
			}
		}
		this.addSlot(new Slot(timeMachineBlockEntity, 6, 80, 37));

		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 9; column++) {
				this.addSlot(new Slot(inventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
			}
		}

		for (int column = 0; column < 9; column++) {
			this.addSlot(new Slot(inventory, column, 8 + column * 18, 142));
		}

		this.addDataSlots(timeMachineBlockEntity.containerData);
	}

	public TimeMachineMenu(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
		this(windowId, inventory, (TimeMachineBlockEntity) inventory.player.level().getBlockEntity(friendlyByteBuf.readBlockPos()));
	}

	@Override
	public boolean stillValid(Player player) {
		return this.containerLevelAccess.evaluate((level, blockPos) -> level.getBlockState(blockPos).getBlock() instanceof TimeMachineBlock && player.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
	}

	@Override
	public ItemStack quickMoveStack(Player player, int slotIndex) {
		return null;
	}

	public int getChargeLevel() {
		return this.getContainerData().get(0);
	}

	public boolean isCharged() {
		return this.getContainerData().get(0) == TimeMachineBlockEntity.MAX_CHARGE;
	}

	public boolean isRestoring() {
		return this.getContainerData().get(1) == 1;
	}

	protected ContainerData getContainerData() {
		return this.timeMachineBlockEntity.containerData;
	}
}
