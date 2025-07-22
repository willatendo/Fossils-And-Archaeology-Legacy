package willatendo.fossilslegacy.server.menu.menus;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.menu.FAMenuTypes;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class UserManuelMenu extends AbstractContainerMenu {
    public final SimpleContainer itemSlot = new SimpleContainer(1);
    private final ContainerLevelAccess containerLevelAccess;

    public UserManuelMenu(int windowId, Inventory inventory, ContainerLevelAccess containerLevelAccess) {
        super(FAMenuTypes.USER_MANUEL.get(), windowId);
        this.containerLevelAccess = containerLevelAccess;

        this.addSlot(new Slot(this.itemSlot, 0, 150, 15));

        this.addStandardInventorySlots(inventory, 60, 197);
    }

    public UserManuelMenu(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(windowId, inventory, ContainerLevelAccess.NULL);
    }

    public UserManuelMenu(int windowId, Inventory inventory, BlockPos blockPos) {
        this(windowId, inventory, ContainerLevelAccess.NULL);
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.containerLevelAccess.execute((level, blockPos) -> this.clearContainer(player, this.itemSlot));
    }

    @Override
    public boolean stillValid(Player player) {
        return player.getMainHandItem().is(FAItems.USER_MANUEL.get());
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        return SimpleUtils.quickMoveItemStack(this, player, slotIndex, 1);
    }
}
