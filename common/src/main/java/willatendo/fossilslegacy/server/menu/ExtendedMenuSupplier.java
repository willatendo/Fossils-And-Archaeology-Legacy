package willatendo.fossilslegacy.server.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;

public interface ExtendedMenuSupplier<T extends AbstractContainerMenu> {
    T create(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf);
}
