package willatendo.fossilslegacy.server.menu.menus;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.block.blocks.ShatteredCultivatorBlock;
import willatendo.fossilslegacy.server.block.entity.entities.ShatteredCultivatorBlockEntity;
import willatendo.fossilslegacy.server.menu.FAMenuTypes;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class ShatteredCultivatorMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess containerLevelAccess;

    public ShatteredCultivatorMenu(int windowId, Inventory inventory, ShatteredCultivatorBlockEntity shatteredCultivatorBlockEntity) {
        super(FAMenuTypes.SHATTERED_CULTIVATOR.get(), windowId);
        this.containerLevelAccess = ContainerLevelAccess.create(shatteredCultivatorBlockEntity.getLevel(), shatteredCultivatorBlockEntity.getBlockPos());

        this.addSlot(new Slot(shatteredCultivatorBlockEntity, 0, 62, 20) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return false;
            }
        });
        this.addSlot(new Slot(shatteredCultivatorBlockEntity, 1, 80, 20) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return false;
            }
        });
        this.addSlot(new Slot(shatteredCultivatorBlockEntity, 2, 98, 20) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return false;
            }
        });

        this.addStandardInventorySlots(inventory, 8, 51);
    }

    public ShatteredCultivatorMenu(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(windowId, inventory, friendlyByteBuf.readBlockPos());
    }

    public ShatteredCultivatorMenu(int windowId, Inventory inventory, BlockPos blockPos) {
        this(windowId, inventory, (ShatteredCultivatorBlockEntity) inventory.player.level().getBlockEntity(blockPos));
    }

    @Override
    public boolean stillValid(Player player) {
        return this.containerLevelAccess.evaluate((level, blockPos) -> level.getBlockState(blockPos).getBlock() instanceof ShatteredCultivatorBlock && player.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        return SimpleUtils.quickMoveItemStack(this, player, slotIndex, 3);
    }
}
