package fossilslegacy.server.block.entity;

import java.util.Map;
import java.util.Random;

import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;

import fossilslegacy.server.block.AnalyzerBlock;
import fossilslegacy.server.item.FossilsLegacyItemTags;
import fossilslegacy.server.item.FossilsLegacyItems;
import fossilslegacy.server.menu.AnalyzerMenu;
import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import net.minecraftforge.registries.ForgeRegistries;

public class AnalyzerBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, StackedContentsCompatible {
	private static final int[] SLOTS_FOR_UP = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
	private static final int[] SLOTS_FOR_DOWN = new int[] { 9, 10, 11, 12 };
	private static final int[] SLOTS_FOR_SIDES = SLOTS_FOR_UP;
	protected NonNullList<ItemStack> itemStacks = NonNullList.withSize(13, ItemStack.EMPTY);
	private LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);
	public int onTime;
	public int analyzationProgress;
	public int analyzationTotalTime;
	public final ContainerData containerData = new ContainerData() {
		@Override
		public int get(int slot) {
			switch (slot) {
			case 0:
				return AnalyzerBlockEntity.this.onTime;
			case 1:
				return AnalyzerBlockEntity.this.analyzationProgress;
			case 2:
				return AnalyzerBlockEntity.this.analyzationTotalTime;
			default:
				return 0;
			}
		}

		@Override
		public void set(int slot, int set) {
			switch (slot) {
			case 0:
				AnalyzerBlockEntity.this.onTime = set;
				break;
			case 1:
				AnalyzerBlockEntity.this.analyzationProgress = set;
				break;
			case 2:
				AnalyzerBlockEntity.this.analyzationTotalTime = set;
			}

		}

		@Override
		public int getCount() {
			return 3;
		}
	};

	public AnalyzerBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(FossilsLegacyBlockEntities.ANALYZER.get(), blockPos, blockState);
	}

	private boolean isOn() {
		return this.onTime > 0;
	}

	@Override
	public void load(CompoundTag compoundTag) {
		super.load(compoundTag);
		this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compoundTag, this.itemStacks);
		this.onTime = compoundTag.getInt("OnTime");
		this.analyzationProgress = compoundTag.getInt("AnalyzationTime");
		this.analyzationTotalTime = compoundTag.getInt("AnalyzationTimeTotal");
	}

	@Override
	protected void saveAdditional(CompoundTag compoundTag) {
		super.saveAdditional(compoundTag);
		compoundTag.putInt("OnTime", this.onTime);
		compoundTag.putInt("aAnalyzationTime", this.analyzationProgress);
		compoundTag.putInt("AnalyzationTimeTotal", this.analyzationTotalTime);
		ContainerHelper.saveAllItems(compoundTag, this.itemStacks);
	}

	public Pair<TagKey<Item>, TagKey<Item>> getForItem(ItemStack itemStack) {
		Map<Item, Pair<TagKey<Item>, TagKey<Item>>> map = Maps.newLinkedHashMap();
		map.put(FossilsLegacyItems.FOSSIL.get(), Pair.of(FossilsLegacyItemTags.LOW_CHANCE_FOSSIL_OUTPUTS, FossilsLegacyItemTags.HIGH_CHANCE_FOSSIL_OUTPUTS));
		map.put(FossilsLegacyItems.FROZEN_MEAT.get(), Pair.of(null, FossilsLegacyItemTags.FROZEN_MEAT_OUTPUTS));
		map.put(FossilsLegacyItems.RELIC_SCRAP.get(), Pair.of(null, FossilsLegacyItemTags.RELIC_SCRAP_OUTPUTS));
		map.put(Items.BEEF, Pair.of(null, FossilsLegacyItemTags.BEEF_OUTPUTS));
		map.put(Items.PORKCHOP, Pair.of(null, FossilsLegacyItemTags.PORKCHOP_OUTPUTS));
		map.put(Items.MUTTON, Pair.of(null, FossilsLegacyItemTags.MUTTON_OUTPUTS));
		map.put(Items.CHICKEN, Pair.of(null, FossilsLegacyItemTags.CHICKEN_OUTPUTS));
		map.put(Items.RABBIT, Pair.of(null, FossilsLegacyItemTags.RABBIT_OUTPUTS));
		map.put(FossilsLegacyItems.RAW_TRICERATOPS_MEAT.get(), Pair.of(null, FossilsLegacyItemTags.TRICERATOPS_MEAT_OUTPUTS));
		map.put(FossilsLegacyItems.RAW_UTAHRAPTOR_MEAT.get(), Pair.of(null, FossilsLegacyItemTags.UTAHRAPTOR_MEAT_OUTPUTS));
		map.put(FossilsLegacyItems.RAW_TYRANNOSAURUS_MEAT.get(), Pair.of(null, FossilsLegacyItemTags.TYRANNOSAURUS_MEAT_OUTPUTS));
		map.put(FossilsLegacyItems.RAW_PTEROSAURUS_MEAT.get(), Pair.of(null, FossilsLegacyItemTags.PTEROSAURUS_MEAT_OUTPUTS));
		map.put(FossilsLegacyItems.RAW_PLESIOSAURUS_MEAT.get(), Pair.of(null, FossilsLegacyItemTags.PLESIOSAURUS_MEAT_OUTPUTS));
		map.put(FossilsLegacyItems.RAW_MOSASAURUS_MEAT.get(), Pair.of(null, FossilsLegacyItemTags.MOSASAURUS_MEAT_OUTPUTS));
		map.put(FossilsLegacyItems.RAW_STEGOSAURUS_MEAT.get(), Pair.of(null, FossilsLegacyItemTags.STEGOSAURUS_MEAT_OUTPUTS));
		map.put(FossilsLegacyItems.RAW_DILOPHOSAURUS_MEAT.get(), Pair.of(null, FossilsLegacyItemTags.DILOPHOSAURUS_MEAT_OUTPUTS));
		map.put(FossilsLegacyItems.RAW_BRACHIOSAURUS_MEAT.get(), Pair.of(null, FossilsLegacyItemTags.BRACHIOSAURUS_MEAT_OUTPUTS));
		map.put(FossilsLegacyItems.RAW_SMILODON_MEAT.get(), Pair.of(null, FossilsLegacyItemTags.SMILODON_MEAT_OUTPUTS));
		map.put(FossilsLegacyItems.RAW_MAMMOTH_MEAT.get(), Pair.of(null, FossilsLegacyItemTags.MAMMOTH_MEAT_OUTPUTS));
		return map.getOrDefault(itemStack.getItem(), null);
	}

	public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, AnalyzerBlockEntity analyzerBlockEntity) {
		boolean isOn = analyzerBlockEntity.isOn();
		boolean changed = false;
		if (analyzerBlockEntity.isOn()) {
			--analyzerBlockEntity.onTime;
		}

		for (int i = 8; i > -1; i--) {
			boolean hasInput = !analyzerBlockEntity.itemStacks.get(i).isEmpty();
			if (analyzerBlockEntity.isOn() || hasInput) {
				TagKey<Item> outputs;
				if (hasInput) {
					Pair<TagKey<Item>, TagKey<Item>> maps = analyzerBlockEntity.getForItem(analyzerBlockEntity.itemStacks.get(i));
					if (maps.getFirst() != null) {
						int chance = new Random().nextInt(4);
						if (chance == 0) {
							outputs = maps.getFirst();
						} else {
							outputs = maps.getSecond();
						}
					} else {
						outputs = maps.getSecond();
					}
				} else {
					outputs = null;
				}

				if (outputs != null) {
					int maxStackSize = analyzerBlockEntity.getMaxStackSize();
					ItemStack output = ForgeRegistries.ITEMS.tags().getTag(outputs).stream().toList().get(new Random().nextInt(ForgeRegistries.ITEMS.tags().getTag(outputs).stream().toList().size())).getDefaultInstance();
					for (int os = 9; os < 12; os++) {
						if (analyzerBlockEntity.canAnalyze(os, i, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
							if (!analyzerBlockEntity.isOn() && analyzerBlockEntity.canAnalyze(os, i, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
								analyzerBlockEntity.onTime = 100;
								if (analyzerBlockEntity.isOn()) {
									changed = true;
								}
							}

							if (analyzerBlockEntity.isOn() && analyzerBlockEntity.canAnalyze(os, i, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
								++analyzerBlockEntity.analyzationProgress;
								if (analyzerBlockEntity.analyzationProgress == analyzerBlockEntity.analyzationTotalTime) {
									analyzerBlockEntity.analyzationProgress = 0;
									analyzerBlockEntity.analyzationTotalTime = 100;
									if (analyzerBlockEntity.canAnalyze(os, i, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
										ItemStack input = analyzerBlockEntity.itemStacks.get(i);
										ItemStack outputSlot = analyzerBlockEntity.itemStacks.get(os);
										if (outputSlot.isEmpty()) {
											analyzerBlockEntity.itemStacks.set(os, output.copy());
										} else if (outputSlot.is(output.getItem())) {
											outputSlot.grow(output.getCount());
										}

										input.shrink(1);
									}

									changed = true;
								}
							} else {
								analyzerBlockEntity.analyzationProgress = 0;
							}
						}
					}
//					if (analyzerBlockEntity.canAnalyze(9, i, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
//						if (!analyzerBlockEntity.isOn() && analyzerBlockEntity.canAnalyze(9, i, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
//							analyzerBlockEntity.onTime = 100;
//							if (analyzerBlockEntity.isOn()) {
//								changed = true;
//							}
//						}
//
//						if (analyzerBlockEntity.isOn() && analyzerBlockEntity.canAnalyze(9, i, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
//							++analyzerBlockEntity.analyzationProgress;
//							if (analyzerBlockEntity.analyzationProgress == analyzerBlockEntity.analyzationTotalTime) {
//								analyzerBlockEntity.analyzationProgress = 0;
//								analyzerBlockEntity.analyzationTotalTime = 100;
//								if (analyzerBlockEntity.canAnalyze(9, i, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
//									ItemStack input = analyzerBlockEntity.itemStacks.get(i);
//									ItemStack outputSlot = analyzerBlockEntity.itemStacks.get(9);
//									if (outputSlot.isEmpty()) {
//										analyzerBlockEntity.itemStacks.set(9, output.copy());
//									} else if (outputSlot.is(output.getItem())) {
//										outputSlot.grow(output.getCount());
//									}
//
//									input.shrink(1);
//								}
//
//								changed = true;
//							}
//						} else {
//							analyzerBlockEntity.analyzationProgress = 0;
//						}
//					} else if (analyzerBlockEntity.canAnalyze(10, i, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
//						if (!analyzerBlockEntity.isOn() && analyzerBlockEntity.canAnalyze(10, i, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
//							analyzerBlockEntity.onTime = 100;
//							if (analyzerBlockEntity.isOn()) {
//								changed = true;
//							}
//						}
//
//						if (analyzerBlockEntity.isOn() && analyzerBlockEntity.canAnalyze(10, i, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
//							++analyzerBlockEntity.analyzationProgress;
//							if (analyzerBlockEntity.analyzationProgress == analyzerBlockEntity.analyzationTotalTime) {
//								analyzerBlockEntity.analyzationProgress = 0;
//								analyzerBlockEntity.analyzationTotalTime = 100;
//								if (analyzerBlockEntity.canAnalyze(10, i, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
//									ItemStack input = analyzerBlockEntity.itemStacks.get(i);
//									ItemStack outputSlot = analyzerBlockEntity.itemStacks.get(10);
//									if (outputSlot.isEmpty()) {
//										analyzerBlockEntity.itemStacks.set(10, output.copy());
//									} else if (outputSlot.is(output.getItem())) {
//										outputSlot.grow(output.getCount());
//									}
//
//									input.shrink(1);
//								}
//
//								changed = true;
//							}
//						} else {
//							analyzerBlockEntity.analyzationProgress = 0;
//						}
//					} else if (analyzerBlockEntity.canAnalyze(11, i, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
//						if (!analyzerBlockEntity.isOn() && analyzerBlockEntity.canAnalyze(11, i, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
//							analyzerBlockEntity.onTime = 100;
//							if (analyzerBlockEntity.isOn()) {
//								changed = true;
//							}
//						}
//
//						if (analyzerBlockEntity.isOn() && analyzerBlockEntity.canAnalyze(11, i, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
//							++analyzerBlockEntity.analyzationProgress;
//							if (analyzerBlockEntity.analyzationProgress == analyzerBlockEntity.analyzationTotalTime) {
//								analyzerBlockEntity.analyzationProgress = 0;
//								analyzerBlockEntity.analyzationTotalTime = 100;
//								if (analyzerBlockEntity.canAnalyze(11, i, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
//									ItemStack input = analyzerBlockEntity.itemStacks.get(i);
//									ItemStack outputSlot = analyzerBlockEntity.itemStacks.get(11);
//									if (outputSlot.isEmpty()) {
//										analyzerBlockEntity.itemStacks.set(11, output.copy());
//									} else if (outputSlot.is(output.getItem())) {
//										outputSlot.grow(output.getCount());
//									}
//
//									input.shrink(1);
//								}
//
//								changed = true;
//							}
//						} else {
//							analyzerBlockEntity.analyzationProgress = 0;
//						}
//					} else if (analyzerBlockEntity.canAnalyze(12, i, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
//						if (!analyzerBlockEntity.isOn() && analyzerBlockEntity.canAnalyze(12, i, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
//							analyzerBlockEntity.onTime = 100;
//							if (analyzerBlockEntity.isOn()) {
//								changed = true;
//							}
//						}
//
//						if (analyzerBlockEntity.isOn() && analyzerBlockEntity.canAnalyze(12, i, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
//							++analyzerBlockEntity.analyzationProgress;
//							if (analyzerBlockEntity.analyzationProgress == analyzerBlockEntity.analyzationTotalTime) {
//								analyzerBlockEntity.analyzationProgress = 0;
//								analyzerBlockEntity.analyzationTotalTime = 100;
//								if (analyzerBlockEntity.canAnalyze(12, i, output, analyzerBlockEntity.itemStacks, maxStackSize)) {
//									ItemStack input = analyzerBlockEntity.itemStacks.get(i);
//									ItemStack outputSlot = analyzerBlockEntity.itemStacks.get(12);
//									if (outputSlot.isEmpty()) {
//										analyzerBlockEntity.itemStacks.set(12, output.copy());
//									} else if (outputSlot.is(output.getItem())) {
//										outputSlot.grow(output.getCount());
//									}
//
//									input.shrink(1);
//								}
//
//								changed = true;
//							}
//						} else {
//							analyzerBlockEntity.analyzationProgress = 0;
//						}
//					} else {
//						analyzerBlockEntity.analyzationProgress = 0;
//					}
				}
			} else if (!analyzerBlockEntity.isOn() && analyzerBlockEntity.analyzationProgress > 0) {
				analyzerBlockEntity.analyzationProgress = Mth.clamp(analyzerBlockEntity.analyzationProgress - 2, 0, analyzerBlockEntity.analyzationTotalTime);
			}
		}

		if (isOn != analyzerBlockEntity.isOn()) {
			changed = true;
			blockState = blockState.setValue(AnalyzerBlock.ACTIVE, Boolean.valueOf(analyzerBlockEntity.isOn()));
			level.setBlock(blockPos, blockState, 3);
		}

		if (changed) {
			setChanged(level, blockPos, blockState);
		}
	}

	private boolean canAnalyze(int slot, int inputSlot, ItemStack output, NonNullList<ItemStack> itemStacks, int maxStackSize) {
		if (!itemStacks.get(inputSlot).isEmpty() && output != null) {
			if (output.isEmpty()) {
				return false;
			} else {
				ItemStack outputSlot = itemStacks.get(slot);
				if (outputSlot.isEmpty()) {
					return true;
				} else if (!outputSlot.sameItem(output)) {
					return false;
				} else if (outputSlot.getCount() + output.getCount() <= maxStackSize && outputSlot.getCount() + output.getCount() <= outputSlot.getMaxStackSize()) {
					return true;
				} else {
					return outputSlot.getCount() + output.getCount() <= output.getMaxStackSize();
				}
			}
		} else {
			return false;
		}
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
		boolean flag = !itemStack.isEmpty() && itemStack.sameItem(itemStackInSlot) && ItemStack.tagMatches(itemStack, itemStackInSlot);
		this.itemStacks.set(slot, itemStack);
		if (itemStack.getCount() > this.getMaxStackSize()) {
			itemStack.setCount(this.getMaxStackSize());
		}

		if (slot == 0 && !flag) {
			this.analyzationTotalTime = 100;
			this.analyzationProgress = 0;
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
	public boolean canPlaceItem(int slot, ItemStack itemStack) {
		if (slot == 0 || slot == 1 || slot == 2 || slot == 3 || slot == 4 || slot == 5 || slot == 6 || slot == 7 || slot == 8) {
			return true;
		} else {
			return false;
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
	public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction direction) {
		if (!this.remove && direction != null && capability == ForgeCapabilities.ITEM_HANDLER) {
			if (direction == Direction.UP) {
				return handlers[0].cast();
			} else if (direction == Direction.DOWN) {
				return handlers[1].cast();
			} else {
				return handlers[2].cast();
			}
		}
		return super.getCapability(capability, direction);
	}

	@Override
	public void invalidateCaps() {
		super.invalidateCaps();
		for (int x = 0; x < handlers.length; x++)
			handlers[x].invalidate();
	}

	@Override
	public void reviveCaps() {
		super.reviveCaps();
		this.handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);
	}

	@Override
	protected Component getDefaultName() {
		return FossilsLegacyUtils.translation("menu", "analyzer");
	}

	@Override
	protected AbstractContainerMenu createMenu(int windowId, Inventory inventory) {
		return new AnalyzerMenu(windowId, inventory, this);
	}
}
