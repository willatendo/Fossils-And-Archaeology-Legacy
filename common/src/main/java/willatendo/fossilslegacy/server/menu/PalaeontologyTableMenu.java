package willatendo.fossilslegacy.server.menu;

import com.google.common.collect.Lists;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.block.PalaeontologyTableBlock;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.item.FossilsLegacyDataComponents;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.menu.slot.ResultSlot;

import java.util.List;

public class PalaeontologyTableMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess containerLevelAccess;
    private final List<Holder<FossilVariant>> selectableFossilVariants = Lists.newArrayList();
    private final Registry<FossilVariant> fossilVariantGetter;
    private final DataSlot selectedFossilVariantIndex = DataSlot.standalone();
    private final Container inputContainer;
    private final Container outputContainer;
    private final Slot resultSlot;
    private Runnable slotUpdateListener;

    public PalaeontologyTableMenu(int windowId, Inventory inventory, ContainerLevelAccess containerLevelAccess) {
        super(FossilsLegacyMenuTypes.PALAEONTOLOGY_TABLE.get(), windowId);
        this.containerLevelAccess = containerLevelAccess;
        this.slotUpdateListener = () -> {
        };
        this.inputContainer = new SimpleContainer(9) {
            @Override
            public void setChanged() {
                super.setChanged();
                PalaeontologyTableMenu.this.slotsChanged(this);
                PalaeontologyTableMenu.this.slotUpdateListener.run();
            }
        };
        this.outputContainer = new SimpleContainer(1) {
            @Override
            public void setChanged() {
                super.setChanged();
                PalaeontologyTableMenu.this.slotUpdateListener.run();
            }
        };

        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 3; ++column) {
                this.addSlot(new Slot(this.inputContainer, column + row * 3, 8 + column * 18, 17 + row * 18) {
                    @Override
                    public int getMaxStackSize(ItemStack itemStack) {
                        return 1;
                    }
                });
            }
        }

        this.resultSlot = this.addSlot(new ResultSlot(inventory.player, this.outputContainer, 0, 148, 35) {
            @Override
            public void onTake(Player player, ItemStack itemStack) {
                PalaeontologyTableMenu.this.inputContainer.clearContent();
                super.onTake(player, itemStack);
            }
        });

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                this.addSlot(new Slot(inventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
            }
        }

        for (int column = 0; column < 9; column++) {
            this.addSlot(new Slot(inventory, column, 8 + column * 18, 142));
        }

        this.addDataSlot(this.selectedFossilVariantIndex);
        this.fossilVariantGetter = inventory.player.registryAccess().registryOrThrow(FossilsLegacyRegistries.FOSSIL_VARIANTS);
    }

    @Override
    public boolean stillValid(Player player) {
        return this.containerLevelAccess.evaluate((level, blockPos) -> level.getBlockState(blockPos).getBlock() instanceof PalaeontologyTableBlock && player.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
    }

    @Override
    public boolean clickMenuButton(Player player, int id) {
        if (id >= 0 && id < this.selectableFossilVariants.size()) {
            Holder<FossilVariant> fossilVariant = this.selectableFossilVariants.get(id);
            this.selectedFossilVariantIndex.set(id);
            this.setupResultSlot(fossilVariant);
            return true;
        } else {
            return false;
        }
    }

    public List<Holder<FossilVariant>> getSelectableFossilVariants() {
        return this.selectableFossilVariants;
    }

    public int getSelectedFossilVariantIndex() {
        return this.selectedFossilVariantIndex.get();
    }

    private void createSelectableFossilVariants() {
        for (Holder<FossilVariant> fossilVariant : this.fossilVariantGetter.holders().toList()) {
            int fossilCount = 0;
            for (int i = 0; i < this.inputContainer.getContainerSize(); i++) {
                if (this.inputContainer.getItem(i).is(fossilVariant.value().fossilIngredient())) {
                    fossilCount++;
                } else if (!this.inputContainer.getItem(i).isEmpty()) {
                    return;
                }
            }
            if (fossilVariant.value().fossilCount() == fossilCount) {
                if (!this.selectableFossilVariants.contains(fossilVariant)) {
                    this.selectableFossilVariants.add(fossilVariant);
                }
            }
        }
    }

    private boolean isValidPatternIndex(int index) {
        return index >= 0 && index < this.selectableFossilVariants.size();
    }

    public void slotsChanged(Container container) {
        this.selectableFossilVariants.clear();
        this.createSelectableFossilVariants();
        if (!this.selectableFossilVariants.isEmpty()) {
            int selectedFossilVariantIndex = this.selectedFossilVariantIndex.get();
            boolean isValidIndex = this.isValidPatternIndex(selectedFossilVariantIndex);
            Holder<FossilVariant> fossilVariantHolder;
            if (this.selectableFossilVariants.size() == 1) {
                this.selectedFossilVariantIndex.set(0);
                fossilVariantHolder = this.selectableFossilVariants.getFirst();
            } else if (!isValidIndex) {
                this.selectedFossilVariantIndex.set(-1);
                fossilVariantHolder = null;
            } else {
                Holder<FossilVariant> selectedFossilVariant = this.selectableFossilVariants.get(selectedFossilVariantIndex);
                int index = this.selectableFossilVariants.indexOf(selectedFossilVariant);
                if (index != -1) {
                    fossilVariantHolder = selectedFossilVariant;
                    this.selectedFossilVariantIndex.set(index);
                } else {
                    fossilVariantHolder = null;
                    this.selectedFossilVariantIndex.set(-1);
                }
            }

            if (fossilVariantHolder != null) {
                this.setupResultSlot(fossilVariantHolder);
            } else {
                this.resultSlot.set(ItemStack.EMPTY);
            }

            this.broadcastChanges();
        } else {
            this.resultSlot.set(ItemStack.EMPTY);
            this.selectableFossilVariants.clear();
            this.selectedFossilVariantIndex.set(-1);
        }
    }

    public void registerUpdateListener(Runnable listener) {
        this.slotUpdateListener = listener;
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

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.containerLevelAccess.execute((level, blockPos) -> {
            this.clearContainer(player, this.inputContainer);
        });
    }

    private void setupResultSlot(Holder<FossilVariant> fossilVariantHolder) {
        ItemStack resultItemStack = new ItemStack(FossilsLegacyItems.ARTICULATED_FOSSIL.get());

        resultItemStack.set(FossilsLegacyDataComponents.FOSSIL_VARIANT.get(), fossilVariantHolder);

        if (!ItemStack.matches(resultItemStack, this.resultSlot.getItem())) {
            this.resultSlot.set(resultItemStack);
        }
    }
}
