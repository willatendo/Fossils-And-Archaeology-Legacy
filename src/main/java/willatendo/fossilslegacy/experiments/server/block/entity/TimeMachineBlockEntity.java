package willatendo.fossilslegacy.experiments.server.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.experiments.server.menu.TimeMachineMenu;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class TimeMachineBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, StackedContentsCompatible, ExtendedScreenHandlerFactory {
	private static final int[] SLOTS_FOR_UP = new int[] { 0, 1, 2, 3, 4, 5, 6 };
	private static final int[] SLOTS_FOR_DOWN = SLOTS_FOR_UP;
	private static final int[] SLOTS_FOR_SIDES = SLOTS_FOR_UP;
	public static final int MAX_RESTORE_TICK = 10;
	public static final int MAX_CHARGE = 1000;
	public static final int MEMORY_WIDTH = 10;
	public static final int MEMORY_HEIGHT = 10;
	protected NonNullList<ItemStack> itemStacks = NonNullList.withSize(7, ItemStack.EMPTY);

	public int time;
	public float rot;
	public float oRot;
	public float tRot;
	private int chargeLevel = 0;
	private BlockState[][][] memoryArray = null;
	public boolean isRestoring = false;
	private int restoringLayer = 0;
	private int restoreTick = 0;

	public final ContainerData containerData = new ContainerData() {
		@Override
		public int get(int data) {
			switch (data) {
			case 0:
				return TimeMachineBlockEntity.this.chargeLevel;
			case 1:
				return TimeMachineBlockEntity.this.isRestoring ? 1 : 0;
			default:
				return 0;
			}
		}

		@Override
		public void set(int data, int set) {
			switch (data) {
			case 0:
				TimeMachineBlockEntity.this.chargeLevel = set;
				break;
			case 1:
				if (set == 1) {
					TimeMachineBlockEntity.this.isRestoring = true;
				} else {
					TimeMachineBlockEntity.this.isRestoring = false;
				}
				break;
			}

		}

		@Override
		public int getCount() {
			return 1;
		}
	};

	public TimeMachineBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(FossilsExperimentsBlockEntities.TIME_MACHINE.get(), blockPos, blockState);
	}

	public float getCircleSize() {
		return (float) (Math.PI * 2.0F);
	}

	@Override
	public void load(CompoundTag compoundTag) {
		super.load(compoundTag);
		this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compoundTag, this.itemStacks);
		this.chargeLevel = compoundTag.getInt("ChargeLevel");
	}

	@Override
	protected void saveAdditional(CompoundTag compoundTag) {
		super.saveAdditional(compoundTag);
		ContainerHelper.saveAllItems(compoundTag, this.itemStacks);
		compoundTag.putInt("ChargeLevel", this.chargeLevel);
	}

	public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, TimeMachineBlockEntity timeMachineBlockEntity) {
		if (!timeMachineBlockEntity.isRestoring) {
			timeMachineBlockEntity.charge();
			if (timeMachineBlockEntity.memoryArray == null) {
				timeMachineBlockEntity.startMemory();
			}
		} else {
			++timeMachineBlockEntity.restoreTick;
			if (timeMachineBlockEntity.restoreTick == MAX_RESTORE_TICK) {
				timeMachineBlockEntity.restoreProgress();
				timeMachineBlockEntity.restoreTick = 0;
			}
		}
	}

	public static void clockTick(Level level, BlockPos blockPos, BlockState blockState, TimeMachineBlockEntity timeMachineBlockEntity) {
		float facing;
		timeMachineBlockEntity.oRot = timeMachineBlockEntity.rot;
		Player player = level.getNearestPlayer((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.5, (double) blockPos.getZ() + 0.5, 3.0, false);
		if (player != null) {
			double x = player.getX() - ((double) blockPos.getX() + 0.5);
			double z = player.getZ() - ((double) blockPos.getZ() + 0.5);
			timeMachineBlockEntity.tRot = (float) Mth.atan2(z, x) + timeMachineBlockEntity.getCircleSize() / 4.0F;
		} else {
			timeMachineBlockEntity.tRot += 0.02f;
		}
		while (timeMachineBlockEntity.rot >= (float) Math.PI) {
			timeMachineBlockEntity.rot -= (float) Math.PI * 2;
		}
		while (timeMachineBlockEntity.rot < (float) (-Math.PI)) {
			timeMachineBlockEntity.rot += (float) Math.PI * 2;
		}
		while (timeMachineBlockEntity.tRot >= (float) Math.PI) {
			timeMachineBlockEntity.tRot -= (float) Math.PI * 2;
		}
		while (timeMachineBlockEntity.tRot < (float) (-Math.PI)) {
			timeMachineBlockEntity.tRot += (float) Math.PI * 2;
		}
		for (facing = timeMachineBlockEntity.tRot - timeMachineBlockEntity.rot; facing >= (float) Math.PI; facing -= (float) Math.PI * 2) {
		}
		while (facing < (float) (-Math.PI)) {
			facing += (float) Math.PI * 2;
		}
		timeMachineBlockEntity.rot += facing * 0.4f;
		timeMachineBlockEntity.time++;
	}

	private void restoreProgress() {
		BlockState blockState = Blocks.AIR.defaultBlockState();
		for (int posX = 0; posX < MEMORY_WIDTH; posX++) {
			for (int posZ = 0; posZ < MEMORY_WIDTH; posZ++) {
				BlockState testState = this.level.getBlockState(this.getBlockPos().offset(posX - (this.MEMORY_WIDTH / 2), this.restoringLayer, posZ - (this.MEMORY_WIDTH / 2)));
				if (this.isNonPerserveBlock(testState)) {
					continue;
				}
				blockState = this.memoryArray[posX][this.restoringLayer][posZ];
				this.level.setBlock(this.getBlockPos().offset(posX - (this.MEMORY_WIDTH / 2), this.restoringLayer, posZ - (this.MEMORY_WIDTH / 2)), blockState, 3);
				if (!blockState.isAir()) {
					RandomSource randomSource = this.level.getRandom();
					this.level.addParticle(ParticleTypes.PORTAL, posX - (this.MEMORY_WIDTH / 2) + (randomSource.nextDouble() - 0.5D), this.restoringLayer + randomSource.nextDouble(), posZ - (this.MEMORY_WIDTH / 2) + (randomSource.nextDouble() - 0.5D), (randomSource.nextDouble() - 0.5D) * 2.0D, -randomSource.nextDouble(), (randomSource.nextDouble() - 0.5D) * 2.0D);
				}
			}
			this.level.playLocalSound(this.getBlockPos(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.BLOCKS, 1.0F, 1.0F, true);
			this.chargeLevel = MAX_CHARGE - (int) ((float) this.restoringLayer / (float) this.MEMORY_HEIGHT * MAX_CHARGE);
			++this.restoringLayer;
			if (this.restoringLayer >= this.MEMORY_HEIGHT) {
				this.isRestoring = false;
				this.restoringLayer = 0;
				this.chargeLevel = 0;
			}
		}
	}

	private void charge() {
		if (!this.isFullyCharged()) {
			this.chargeLevel++;
		}
	}

	public void startMemory() {
		this.memoryArray = new BlockState[MEMORY_WIDTH][MEMORY_HEIGHT][MEMORY_WIDTH];
		for (int x = 0; x < MEMORY_WIDTH; x++) {
			for (int y = 0; y < MEMORY_HEIGHT; y++) {
				for (int z = 0; z < MEMORY_WIDTH; z++) {
					BlockState blockState = this.level.getBlockState(this.getBlockPos().offset(x - MEMORY_WIDTH / 2, y, z - MEMORY_WIDTH / 2));
					if (this.isNonPerserveBlock(blockState)) {
						blockState = Blocks.AIR.defaultBlockState();
					}

					this.memoryArray[x][y][z] = blockState;
				}
			}
		}
	}

	private boolean isNonPerserveBlock(BlockState blockState) {
		if (blockState.isAir()) {
			return false;
		}
		if (blockState.hasBlockEntity()) {
			return true;
		}
		if (blockState.is(Blocks.DIAMOND_BLOCK) || blockState.is(Blocks.DIAMOND_ORE)) {
			{
				return true;
			}
		}
		return false;
	}

	public int getChargeLevel() {
		return this.chargeLevel;
	}

	public boolean isFullyCharged() {
		return this.chargeLevel == MAX_CHARGE;
	}

	public void startRestoring() {
		if (this.memoryArray == null) {
			return;
		}
		if (!this.isFullyCharged()) {
			return;
		}
		this.isRestoring = true;
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
	public int[] getSlotsForFace(Direction direction) {
		if (direction == Direction.DOWN) {
			return SLOTS_FOR_DOWN;
		} else {
			return direction == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
		}
	}

	@Override
	public boolean canPlaceItemThroughFace(int slot, ItemStack itemStack, Direction direction) {
		return this.canPlaceItem(slot, itemStack);
	}

	@Override
	public boolean canTakeItemThroughFace(int slot, ItemStack itemStack, Direction direction) {
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
		this.itemStacks.set(slot, itemStack);
		if (itemStack.getCount() > this.getMaxStackSize()) {
			itemStack.setCount(this.getMaxStackSize());
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
	public void fillStackedContents(StackedContents stackedContents) {
		for (ItemStack itemStack : this.itemStacks) {
			stackedContents.accountStack(itemStack);
		}
	}

	@Override
	protected Component getDefaultName() {
		return FossilsLegacyUtils.translation("menu", "time_machine");
	}

	@Override
	protected AbstractContainerMenu createMenu(int windowId, Inventory inventory) {
		return new TimeMachineMenu(windowId, inventory, this);
	}

	@Override
	public void writeScreenOpeningData(ServerPlayer serverPlayer, FriendlyByteBuf friendlyByteBuf) {
		friendlyByteBuf.writeBlockPos(this.getBlockPos());
	}
}
