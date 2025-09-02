package willatendo.fossilslegacy.server.menu.menus;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.block.blocks.HologramProjectorBlock;
import willatendo.fossilslegacy.server.block.entity.entities.HologramProjectorBlockEntity;
import willatendo.fossilslegacy.server.menu.FAMenuTypes;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class HologramProjectorMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess containerLevelAccess;

    public HologramProjectorMenu(int windowId, Inventory inventory, HologramProjectorBlockEntity hologramProjectorBlockEntity) {
        super(FAMenuTypes.HOLOGRAM_PROJECTOR.get(), windowId);
        this.containerLevelAccess = ContainerLevelAccess.create(hologramProjectorBlockEntity.getLevel(), hologramProjectorBlockEntity.getBlockPos());

        this.addStandardInventorySlots(inventory, 8, 84);
    }

    public HologramProjectorMenu(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(windowId, inventory, friendlyByteBuf.readBlockPos());
    }

    public HologramProjectorMenu(int windowId, Inventory inventory, BlockPos blockPos) {
        this(windowId, inventory, (HologramProjectorBlockEntity) inventory.player.level().getBlockEntity(blockPos));
    }

    @Override
    public boolean stillValid(Player player) {
        return this.containerLevelAccess.evaluate((level, blockPos) -> level.getBlockState(blockPos).getBlock() instanceof HologramProjectorBlock && player.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        return SimpleUtils.quickMoveItemStack(this, player, slotIndex, 0);
    }
}
