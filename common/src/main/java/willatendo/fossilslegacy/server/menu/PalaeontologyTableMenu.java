package willatendo.fossilslegacy.server.menu;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.block.PalaeontologyTableBlock;
import willatendo.fossilslegacy.server.block.entity.PalaeontologyTableBlockEntity;

public class PalaeontologyTableMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess containerLevelAccess;

    public PalaeontologyTableMenu(int windowId, Inventory inventory, PalaeontologyTableBlockEntity palaeontologyTableBlockEntity) {
        super(FossilsLegacyMenuTypes.PALAEONTOLOGY_TABLE.get(), windowId);
        this.containerLevelAccess = ContainerLevelAccess.create(palaeontologyTableBlockEntity.getLevel(), palaeontologyTableBlockEntity.getBlockPos());

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                this.addSlot(new Slot(inventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
            }
        }

        for (int column = 0; column < 9; column++) {
            this.addSlot(new Slot(inventory, column, 8 + column * 18, 142));
        }
    }

    public PalaeontologyTableMenu(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(windowId, inventory, friendlyByteBuf.readBlockPos());
    }

    public PalaeontologyTableMenu(int windowId, Inventory inventory, BlockPos blockPos) {
        this(windowId, inventory, (PalaeontologyTableBlockEntity) inventory.player.level().getBlockEntity(blockPos));
    }

    @Override
    public boolean stillValid(Player player) {
        return this.containerLevelAccess.evaluate((level, blockPos) -> level.getBlockState(blockPos).getBlock() instanceof PalaeontologyTableBlock && player.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return null;
    }
}
