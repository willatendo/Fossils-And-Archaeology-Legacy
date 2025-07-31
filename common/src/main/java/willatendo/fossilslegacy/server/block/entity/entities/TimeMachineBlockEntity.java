package willatendo.fossilslegacy.server.block.entity.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedItemContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Portal;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.entity.FABlockEntityTypes;
import willatendo.fossilslegacy.server.item.items.CoinItem;
import willatendo.fossilslegacy.server.menu.menus.TimeMachineMenu;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public class TimeMachineBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, StackedContentsCompatible {
    private static final int[] SLOTS_FOR_UP = new int[]{0};
    private static final int[] SLOTS_FOR_DOWN = SLOTS_FOR_UP;
    private static final int[] SLOTS_FOR_SIDES = SLOTS_FOR_UP;
    public static final int MAX_CHARGE = 1000;
    protected NonNullList<ItemStack> itemStacks = NonNullList.withSize(1, ItemStack.EMPTY);

    public int time;
    public float rot;
    public float oRot;
    public float tRot;
    private int chargeLevel = 0;

    public final ContainerData containerData = new ContainerData() {
        @Override
        public int get(int data) {
            switch (data) {
                case 0:
                    return TimeMachineBlockEntity.this.chargeLevel;
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
            }

        }

        @Override
        public int getCount() {
            return 1;
        }
    };

    public TimeMachineBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FABlockEntityTypes.TIME_MACHINE.get(), blockPos, blockState);
    }

    public float getCircleSize() {
        return (float) (Math.PI * 2.0F);
    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(compoundTag, this.itemStacks, provider);
        this.chargeLevel = compoundTag.getInt("ChargeLevel");
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        ContainerHelper.saveAllItems(compoundTag, this.itemStacks, provider);
        compoundTag.putInt("ChargeLevel", this.chargeLevel);
    }

    public void timeTravel(BlockPos blockPos) {
        this.setChargeLevel(0);
        List<Player> players = this.level.getEntitiesOfClass(Player.class, new AABB(this.getBlockPos()).inflate(7.0D));
        players.forEach(player -> {
            if (this.level instanceof ServerLevel serverLevel) {
                MinecraftServer minecraftServer = serverLevel.getServer();
                ResourceKey<Level> destinedLevel = ((CoinItem) this.itemStacks.get(0).getItem()).getDestinedLevel();
                ResourceKey<Level> blockEntityLevel = this.level.dimension();
                if (destinedLevel != blockEntityLevel) {
                    double x = player.position().x();
                    double z = player.position().z();
                    double y = serverLevel.getHeight(Heightmap.Types.WORLD_SURFACE, (int) x, (int) z);
                    double finalY = y > -64.0D ? y : 70;
                    this.level.playSound(player, this.getBlockPos(), SoundEvents.PORTAL_TRAVEL, SoundSource.BLOCKS, 1.0F, 1.0F);
                    player.setAsInsidePortal((serverLevelIn, entity, blockPosIn) -> {
                        Level level = entity.level();
                        if (!level.getBlockState(TimeMachineBlockEntity.this.getBlockPos()).is(FABlocks.TIME_MACHINE.get())) {
                            level.setBlock(TimeMachineBlockEntity.this.getBlockPos(), FABlocks.TIME_MACHINE.get().defaultBlockState(), 3);
                        }
                        BlockEntity blockEntity = level.getBlockEntity(TimeMachineBlockEntity.this.getBlockPos());
                        if (blockEntity instanceof TimeMachineBlockEntity timeMachineBlockEntity) {
                            if (timeMachineBlockEntity.getItem(0).isEmpty()) {
                                timeMachineBlockEntity.setItem(0, CoinItem.getCoin(blockEntityLevel, destinedLevel));
                            }
                        }
                        return new TeleportTransition(serverLevelIn, new Vec3(x, finalY, z), Vec3.ZERO, 0.0F, 0.0F, TeleportTransition.PLAY_PORTAL_SOUND.then(TeleportTransition.PLACE_PORTAL_TICKET));
                    }, blockPos);
                }
            }
        });
    }

    public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, TimeMachineBlockEntity timeMachineBlockEntity) {
        timeMachineBlockEntity.charge();
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

    private void charge() {
        if (!this.isFullyCharged()) {
            this.chargeLevel++;
        }
    }

    public int getChargeLevel() {
        return this.chargeLevel;
    }

    public void setChargeLevel(int chargeLevel) {
        this.chargeLevel = chargeLevel;
    }

    public boolean isFullyCharged() {
        return this.chargeLevel == MAX_CHARGE;
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
    public void fillStackedContents(StackedItemContents stackedItemContents) {
        for (ItemStack itemStack : this.itemStacks) {
            stackedItemContents.accountStack(itemStack);
        }
    }

    @Override
    protected Component getDefaultName() {
        return FAUtils.translation("container", "time_machine");
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
        return new TimeMachineMenu(windowId, inventory, this);
    }
}
