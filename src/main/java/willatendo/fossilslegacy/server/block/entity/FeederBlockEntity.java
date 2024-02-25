package willatendo.fossilslegacy.server.block.entity;

import java.util.Map;

import com.google.common.collect.Maps;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.block.FeederBlock;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.item.FeederMeatLevel;
import willatendo.fossilslegacy.server.item.FeederPlantsLevel;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.menu.FeederMenu;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FeederBlockEntity extends BaseContainerBlockEntity implements ExtendedScreenHandlerFactory {
	private NonNullList<ItemStack> itemStacks = NonNullList.withSize(2, ItemStack.EMPTY);
	public int meatLevel = 0;
	public final int maxMeatLevel = 10000;
	public int plantsLevel = 0;
	public final int maxPlantsLevel = 10000;
	public final ContainerData containerData = new ContainerData() {
		@Override
		public int get(int data) {
			switch (data) {
			case 0:
				return FeederBlockEntity.this.meatLevel;
			case 1:
				return FeederBlockEntity.this.plantsLevel;
			default:
				return 0;
			}
		}

		@Override
		public void set(int data, int set) {
			switch (data) {
			case 0:
				FeederBlockEntity.this.meatLevel = set;
				break;
			case 1:
				FeederBlockEntity.this.plantsLevel = set;
				break;
			}

		}

		@Override
		public int getCount() {
			return 2;
		}
	};

	public FeederBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(FossilsLegacyBlockEntities.FEEDER.get(), blockPos, blockState);
	}

	public static Map<Item, Integer> getMeatFoodLevel() {
		Map<Item, Integer> map = Maps.newLinkedHashMap();
		map.put(Items.BEEF, 40);
		map.put(Items.COOKED_BEEF, 20);
		map.put(Items.CHICKEN, 30);
		map.put(Items.COOKED_CHICKEN, 10);
		map.put(Items.MUTTON, 30);
		map.put(Items.COOKED_MUTTON, 10);
		map.put(Items.RABBIT, 30);
		map.put(Items.COOKED_RABBIT, 10);
		map.put(Items.PORKCHOP, 20);
		map.put(Items.COOKED_PORKCHOP, 30);
		map.put(Items.COD, 40);
		map.put(Items.COOKED_COD, 60);
		map.put(Items.SALMON, 40);
		map.put(Items.COOKED_SALMON, 60);
		map.put(Items.TROPICAL_FISH, 40);
		map.put(FossilsLegacyItems.COOKED_BRACHIOSAURUS_MEAT.get(), 100);
		map.put(FossilsLegacyItems.COOKED_DILOPHOSAURUS_MEAT.get(), 100);
		map.put(FossilsLegacyItems.COOKED_FUTABASAURUS_MEAT.get(), 100);
		map.put(FossilsLegacyItems.COOKED_PTERANODON_MEAT.get(), 100);
		map.put(FossilsLegacyItems.COOKED_SMILODON_MEAT.get(), 100);
		map.put(FossilsLegacyItems.COOKED_STEGOSAURUS_MEAT.get(), 100);
		map.put(FossilsLegacyItems.COOKED_TRICERATOPS_MEAT.get(), 100);
		map.put(FossilsLegacyItems.COOKED_TYRANNOSAURUS_MEAT.get(), 100);
		map.put(FossilsLegacyItems.COOKED_VELOCIRAPTOR_MEAT.get(), 100);
		map.put(FossilsLegacyItems.SIO_CHIU_LE.get(), 100);
		map.put(FossilsLegacyItems.RAW_BRACHIOSAURUS_MEAT.get(), 100);
		map.put(FossilsLegacyItems.RAW_DILOPHOSAURUS_MEAT.get(), 100);
		map.put(FossilsLegacyItems.RAW_FUTABASAURUS_MEAT.get(), 100);
		map.put(FossilsLegacyItems.RAW_PTERANODON_MEAT.get(), 100);
		map.put(FossilsLegacyItems.RAW_SMILODON_MEAT.get(), 100);
		map.put(FossilsLegacyItems.RAW_STEGOSAURUS_MEAT.get(), 100);
		map.put(FossilsLegacyItems.RAW_TRICERATOPS_MEAT.get(), 100);
		map.put(FossilsLegacyItems.RAW_TYRANNOSAURUS_MEAT.get(), 100);
		map.put(FossilsLegacyItems.RAW_VELOCIRAPTOR_MEAT.get(), 100);
		map.put(FossilsLegacyItems.NAUTILUS.get(), 100);
		return map;
	}

	public static Map<Item, Integer> getPlantsFoodLevel() {
		Map<Item, Integer> map = Maps.newLinkedHashMap();
		map.put(Items.APPLE, 100);
		map.put(Items.WHEAT, 40);
		map.put(Items.BREAD, 120);
		map.put(Items.SUGAR_CANE, 20);
		map.put(Items.WHEAT_SEEDS, 20);
		map.put(Items.BEETROOT_SEEDS, 20);
		map.put(Items.MELON_SEEDS, 20);
		map.put(Items.PUMPKIN_SEEDS, 20);
		map.put(Items.MELON_SLICE, 25);
		map.put(Items.SWEET_BERRIES, 15);
		map.put(Items.GLOW_BERRIES, 15);
		map.put(Items.CARROT, 100);
		map.put(Items.POTATO, 100);
		map.put(Items.BAKED_POTATO, 75);
		map.put(Items.BEETROOT, 25);
		map.put(Items.KELP, 15);
		map.put(FossilsLegacyItems.JURASSIC_FERN_SPORES.get(), 50);
		return map;
	}

	@Override
	protected void saveAdditional(CompoundTag compoundTag) {
		super.saveAdditional(compoundTag);
		compoundTag.putInt("MeatLevel", this.meatLevel);
		compoundTag.putInt("PlantsLevel", this.plantsLevel);
		ContainerHelper.saveAllItems(compoundTag, this.itemStacks);
	}

	@Override
	public void load(CompoundTag compoundTag) {
		super.load(compoundTag);
		this.meatLevel = compoundTag.getInt("MeatLevel");
		this.plantsLevel = compoundTag.getInt("PlantsLevel");
		this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compoundTag, this.itemStacks);
	}

	public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, FeederBlockEntity feederBlockEntity) {
		boolean hasFood = (feederBlockEntity.meatLevel > 0 || feederBlockEntity.plantsLevel > 0);
		boolean changed = false;
		ItemStack meat = feederBlockEntity.itemStacks.get(0);
		ItemStack plants = feederBlockEntity.itemStacks.get(1);

		if (!meat.isEmpty()) {
			int meatLevel = feederBlockEntity.getMeatFoodLevel(meat);
			if (meatLevel > 0) {
				if (!(meatLevel + feederBlockEntity.meatLevel > feederBlockEntity.maxMeatLevel)) {
					feederBlockEntity.meatLevel += feederBlockEntity.getMeatFoodLevel(meat);
					meat.shrink(1);
					changed = true;
				}
			}
		}
		if (!plants.isEmpty()) {
			int plantsLevel = feederBlockEntity.getPlantsFoodLevel(plants);
			if (plantsLevel > 0) {
				if (!(plantsLevel + feederBlockEntity.plantsLevel > feederBlockEntity.maxPlantsLevel)) {
					feederBlockEntity.plantsLevel += plantsLevel;
					plants.shrink(1);
					changed = true;
				}
			}
		}

		if (hasFood) {
			level.setBlock(blockPos, blockState.setValue(FeederBlock.HAS_FOOD, true), 3);
			changed = true;
		} else {
			level.setBlock(blockPos, blockState.setValue(FeederBlock.HAS_FOOD, false), 3);
			changed = true;
		}

		if (changed) {
			setChanged(level, blockPos, blockState);
		}
	}

	public boolean hasFood(boolean meat) {
		return meat ? this.meatLevel > 0 : this.plantsLevel > 0;
	}

	public void feed(Dinosaur dinosaur, boolean meat) {
		while (dinosaur.feed() && this.hasFood(meat)) {
			if (meat) {
				this.meatLevel--;
			} else {
				this.plantsLevel--;
			}
		}
	}

	public static int getMeatFoodLevel(ItemStack itemStack) {
		if (itemStack.getItem() instanceof FeederMeatLevel feederMeatLevel) {
			return feederMeatLevel.feederMeatLevel();
		}
		return getMeatFoodLevel().getOrDefault(itemStack.getItem(), 0);
	}

	public static int getPlantsFoodLevel(ItemStack itemStack) {
		if (itemStack.getItem() instanceof FeederPlantsLevel feederPlantsLevel) {
			return feederPlantsLevel.feederPlantsLevel();
		}
		return getPlantsFoodLevel().getOrDefault(itemStack.getItem(), 0);
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
		ItemStack itemStackInSlot = this.itemStacks.get(slot);
		boolean flag = !itemStack.isEmpty() && ItemStack.isSameItem(itemStackInSlot, itemStack) && ItemStack.isSameItemSameTags(itemStack, itemStackInSlot);
		this.itemStacks.set(slot, itemStack);
		if (itemStack.getCount() > this.getMaxStackSize()) {
			itemStack.setCount(this.getMaxStackSize());
		}

		if ((slot == 0 || slot == 1) && !flag) {
			this.setChanged();
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
	protected Component getDefaultName() {
		return FossilsLegacyUtils.translation("menu", "feeder");
	}

	@Override
	protected AbstractContainerMenu createMenu(int windowId, Inventory inventory) {
		return new FeederMenu(windowId, inventory, this);
	}

	@Override
	public void writeScreenOpeningData(ServerPlayer serverPlayer, FriendlyByteBuf friendlyByteBuf) {
		friendlyByteBuf.writeBlockPos(this.getBlockPos());
	}
}
