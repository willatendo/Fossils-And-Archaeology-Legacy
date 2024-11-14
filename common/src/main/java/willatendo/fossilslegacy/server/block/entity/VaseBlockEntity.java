package willatendo.fossilslegacy.server.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.RandomizableContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.ticks.ContainerSingleItem;
import org.jetbrains.annotations.Nullable;

public class VaseBlockEntity extends BlockEntity implements RandomizableContainer, ContainerSingleItem.BlockContainerSingleItem {
    private ItemStack item = ItemStack.EMPTY;
    private int count = 0;
    protected ResourceKey<LootTable> lootTable;
    protected long lootTableSeed;

    public VaseBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FossilsLegacyBlockEntityTypes.VASE.get(), blockPos, blockState);
    }

    public void setCount(int count) {
        this.count = count;
        this.markUpdated();
    }

    public int getCount() {
        return this.count;
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider registries) {
        super.saveAdditional(compoundTag, registries);
        if (!this.trySaveLootTable(compoundTag) && !this.item.isEmpty()) {
            compoundTag.put("item", this.item.save(registries));
        }
        compoundTag.putInt("count", this.count);
    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider registries) {
        super.loadAdditional(compoundTag, registries);
        if (!this.tryLoadLootTable(compoundTag)) {
            if (compoundTag.contains("item", 10)) {
                this.item = ItemStack.parse(registries, compoundTag.getCompound("item")).orElse(ItemStack.EMPTY);
            } else {
                this.item = ItemStack.EMPTY;
            }
        }
        this.count = compoundTag.getInt("count");
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag compoundTag = new CompoundTag();
        if (!this.item.isEmpty()) {
            compoundTag.put("item", this.item.save(registries));
        }
        compoundTag.putInt("count", this.count);
        return compoundTag;
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Nullable
    @Override
    public ResourceKey<LootTable> getLootTable() {
        return this.lootTable;
    }

    @Override
    public void setLootTable(ResourceKey<LootTable> resourceKey) {
        this.lootTable = resourceKey;
    }

    @Override
    public long getLootTableSeed() {
        return this.lootTableSeed;
    }

    @Override
    public void setLootTableSeed(long seed) {
        this.lootTableSeed = seed;
    }

    @Override
    public ItemStack getTheItem() {
        this.unpackLootTable(null);
        return this.item;
    }

    @Override
    public ItemStack splitTheItem(int amount) {
        this.unpackLootTable(null);
        ItemStack itemStack = this.item.split(amount);
        if (this.item.isEmpty()) {
            this.item = ItemStack.EMPTY;
        }

        return itemStack;
    }

    @Override
    public void setTheItem(ItemStack itemStack) {
        this.unpackLootTable(null);
        this.item = itemStack;
        this.markUpdated();
    }

    @Override
    public BlockEntity getContainerBlockEntity() {
        return this;
    }

    private void markUpdated() {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }
}
