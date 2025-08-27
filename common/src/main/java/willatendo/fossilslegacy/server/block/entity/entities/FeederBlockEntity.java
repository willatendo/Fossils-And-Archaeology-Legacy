package willatendo.fossilslegacy.server.block.entity.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.block.blocks.FeederBlock;
import willatendo.fossilslegacy.server.block.entity.FABlockEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.feeder_food.FeederFood;
import willatendo.fossilslegacy.server.level.FAGameRules;
import willatendo.fossilslegacy.server.menu.menus.FeederMenu;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class FeederBlockEntity extends BaseContainerBlockEntity {
    private NonNullList<ItemStack> itemStacks = NonNullList.withSize(2, ItemStack.EMPTY);
    public int meatLevel = 0;
    public int plantsLevel = 0;
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
    private List<UUID> notifiedPlayers = new ArrayList<>();

    public FeederBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FABlockEntityTypes.FEEDER.get(), blockPos, blockState);
    }

    public void addNotifiedPlayer(UUID uuid) {
        if (!this.notifiedPlayers.contains(uuid)) {
            this.notifiedPlayers.add(uuid);
        }
    }

    public void removeNotifiedPlayer(UUID uuid) {
        this.notifiedPlayers.remove(uuid);
    }

    public List<UUID> getNotifiedPlayers() {
        return this.notifiedPlayers;
    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        this.meatLevel = compoundTag.getInt("MeatLevel");
        this.plantsLevel = compoundTag.getInt("PlantsLevel");
        this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(compoundTag, this.itemStacks, provider);
        this.notifiedPlayers = new ArrayList<>();
        CompoundTag notifiedPlayers = compoundTag.getCompound("notified_players");
        for (int i = 0; i < compoundTag.getInt("notified_players_size"); i++) {
            this.notifiedPlayers.add(notifiedPlayers.getUUID("player" + i));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        compoundTag.putInt("MeatLevel", this.meatLevel);
        compoundTag.putInt("PlantsLevel", this.plantsLevel);
        ContainerHelper.saveAllItems(compoundTag, this.itemStacks, provider);
        compoundTag.putInt("notified_players_size", this.notifiedPlayers.size());
        CompoundTag notifiedPlayers = new CompoundTag();
        for (int i = 0; i < this.notifiedPlayers.size(); i++) {
            notifiedPlayers.putUUID("player" + i, this.notifiedPlayers.get(i));
        }
        compoundTag.put("notified_players", notifiedPlayers);
    }

    public static void serverTick(ServerLevel serverLevel, BlockPos blockPos, BlockState blockState, FeederBlockEntity feederBlockEntity) {
        boolean hasFood = (feederBlockEntity.meatLevel > 0 || feederBlockEntity.plantsLevel > 0);
        boolean changed = false;
        ItemStack meat = feederBlockEntity.itemStacks.get(0);
        ItemStack plants = feederBlockEntity.itemStacks.get(1);
        Map<Item, FeederFood.FeederInfo> map = FeederFood.getFeederFood(serverLevel.registryAccess());

        if (!meat.isEmpty()) {
            FeederFood.FeederInfo feederInfo = map.getOrDefault(meat.getItem(), null);
            if (feederInfo != null) {
                int amount = feederInfo.fillAmount();
                if (!(amount + feederBlockEntity.meatLevel > 10000)) {
                    feederBlockEntity.meatLevel += amount;
                    meat.shrink(1);
                    changed = true;
                }
            }
        }
        if (!plants.isEmpty()) {
            FeederFood.FeederInfo feederInfo = map.getOrDefault(plants.getItem(), null);
            if (feederInfo != null) {
                int amount = feederInfo.fillAmount();
                if (!(amount + feederBlockEntity.plantsLevel > 10000)) {
                    feederBlockEntity.plantsLevel += amount;
                    plants.shrink(1);
                    changed = true;
                }
            }
        }

        if (hasFood) {
            serverLevel.setBlock(blockPos, blockState.setValue(FeederBlock.HAS_FOOD, true), 3);
        } else {
            serverLevel.setBlock(blockPos, blockState.setValue(FeederBlock.HAS_FOOD, false), 3);
        }

        if (changed) {
            setChanged(serverLevel, blockPos, blockState);
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

        if (this.level instanceof ServerLevel serverLevel) {
            int lowQuorum = serverLevel.getGameRules().getInt(FAGameRules.RULE_LOWFEEDERMESSAGEQUORUM);
            boolean low = meat ? this.meatLevel <= lowQuorum : this.plantsLevel <= lowQuorum;
            if (low) {
                this.notifiedPlayers.forEach(uuid -> this.level.getPlayerByUUID(uuid).displayClientMessage(FAUtils.translation("block", "feeder.low." + (low ? "meat" : "plant"), this.getDisplayName()), false));
            }
        }
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
        boolean flag = !itemStack.isEmpty() && ItemStack.isSameItem(itemStackInSlot, itemStack) && ItemStack.isSameItemSameComponents(itemStack, itemStackInSlot);
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
        return FAUtils.translation("container", "feeder");
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
        return new FeederMenu(windowId, inventory, this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putInt("MeatLevel", this.meatLevel);
        compoundTag.putInt("PlantsLevel", this.plantsLevel);
        ContainerHelper.saveAllItems(compoundTag, this.itemStacks, registries);
        compoundTag.putInt("notified_players_size", this.notifiedPlayers.size());
        CompoundTag notifiedPlayers = new CompoundTag();
        for (int i = 0; i < this.notifiedPlayers.size(); i++) {
            notifiedPlayers.putUUID("player" + i, this.notifiedPlayers.get(i));
        }
        compoundTag.put("notified_players", notifiedPlayers);
        return compoundTag;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
