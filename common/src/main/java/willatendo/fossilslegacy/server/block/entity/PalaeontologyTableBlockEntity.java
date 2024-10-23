package willatendo.fossilslegacy.server.block.entity;

import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.menu.PalaeontologyTableMenu;
import willatendo.fossilslegacy.server.tags.FossilsLegacyItemTags;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

public class PalaeontologyTableBlockEntity extends BaseContainerBlockEntity implements StackedContentsCompatible {
    protected NonNullList<ItemStack> itemStacks = NonNullList.withSize(10, ItemStack.EMPTY);
    public final List<FossilVariant> fossilVariants = Lists.newArrayList();
    public FossilVariant selected = null;
    private int lastFossilCount = 0;

    public PalaeontologyTableBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FossilsLegacyBlockEntityTypes.PALEONTOLOGY_TABLE.get(), blockPos, blockState);
    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(compoundTag, this.itemStacks, provider);
        this.lastFossilCount = compoundTag.getInt("LastFossilCount");
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        ContainerHelper.saveAllItems(compoundTag, this.itemStacks, provider);
        compoundTag.putInt("LastFossilCount", this.lastFossilCount);
    }

    public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, PalaeontologyTableBlockEntity palaeontologyTableBlockEntity) {
        RegistryAccess registryAccess = level.registryAccess();
        Registry<FossilVariant> fossilVariantRegistry = registryAccess.registryOrThrow(FossilsLegacyRegistries.FOSSIL_VARIANTS);
        int fossilCount = 0;
        for (int i = 0; i < palaeontologyTableBlockEntity.getContainerSize(); i++) {
            if (palaeontologyTableBlockEntity.isFossil(i)) {
                fossilCount++;
            }
        }
        if (fossilCount != palaeontologyTableBlockEntity.lastFossilCount) {
            palaeontologyTableBlockEntity.fossilVariants.clear();
            for (FossilVariant fossilVariant : fossilVariantRegistry.stream().toList()) {
                if (fossilVariant.fossilCount() == fossilCount) {
                    if (!palaeontologyTableBlockEntity.fossilVariants.contains(fossilVariant)) {
                        palaeontologyTableBlockEntity.fossilVariants.add(fossilVariant);
                    }
                }
            }
        }
        if (!palaeontologyTableBlockEntity.fossilVariants.isEmpty()) {
            palaeontologyTableBlockEntity.selected = palaeontologyTableBlockEntity.fossilVariants.getFirst();
        }
    }

    private boolean isFossil(int slot) {
        return this.getItem(slot).is(FossilsLegacyItemTags.MESOZOIC_FOSSIL);
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
        boolean flag = !itemStack.isEmpty() && ItemStack.isSameItemSameComponents(itemStackInSlot, itemStack);
        this.itemStacks.set(slot, itemStack);
        if (itemStack.getCount() > this.getMaxStackSize()) {
            itemStack.setCount(this.getMaxStackSize());
        }

        if (slot < 9 && !flag) {
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
        if (slot < 9) {
            return false;
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
    protected Component getDefaultName() {
        return FossilsLegacyUtils.translation("container", "palaeontology_table");
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.itemStacks;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemStacks) {
        this.itemStacks = itemStacks;
    }

    @Override
    protected AbstractContainerMenu createMenu(int windowId, Inventory inventory) {
        return new PalaeontologyTableMenu(windowId, inventory, this);
    }
}
