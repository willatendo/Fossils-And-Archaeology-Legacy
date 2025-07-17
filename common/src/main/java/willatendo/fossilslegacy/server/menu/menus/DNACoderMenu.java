package willatendo.fossilslegacy.server.menu.menus;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.client.screen.DNACoderScreen;
import willatendo.fossilslegacy.client.screen.DNARecombinatorScreen;
import willatendo.fossilslegacy.server.block.blocks.DNACoderBlock;
import willatendo.fossilslegacy.server.block.entity.entities.DNACoderBlockEntity;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.item.items.DNAItem;
import willatendo.fossilslegacy.server.menu.FAMenuTypes;
import willatendo.fossilslegacy.server.menu.slot.ResultSlot;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class DNACoderMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess containerLevelAccess;
    private final ContainerData data;

    public DNACoderMenu(int windowId, Inventory inventory, DNACoderBlockEntity dnaCoderBlockEntity) {
        super(FAMenuTypes.DNA_CODER.get(), windowId);
        this.containerLevelAccess = ContainerLevelAccess.create(dnaCoderBlockEntity.getLevel(), dnaCoderBlockEntity.getBlockPos());
        this.data = dnaCoderBlockEntity.containerData;

        this.addSlot(new Slot(dnaCoderBlockEntity, 0, 56, 17) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.getItem() instanceof DNAItem;
            }

            @Override
            public ResourceLocation getNoItemIcon() {
                return DNARecombinatorScreen.EMPTY_SLOT_DNA;
            }
        });
        this.addSlot(new Slot(dnaCoderBlockEntity, 1, 56, 53) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.is(FAItems.STORAGE_DISC.get());
            }

            @Override
            public ResourceLocation getNoItemIcon() {
                return DNACoderScreen.EMPTY_SLOT_DISC;
            }
        });
        this.addSlot(new ResultSlot(inventory.player, dnaCoderBlockEntity, 2, 116, 35));

        this.addStandardInventorySlots(inventory, 8, 84);

        this.addDataSlots(dnaCoderBlockEntity.containerData);
    }

    public DNACoderMenu(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(windowId, inventory, friendlyByteBuf.readBlockPos());
    }

    public DNACoderMenu(int windowId, Inventory inventory, BlockPos blockPos) {
        this(windowId, inventory, (DNACoderBlockEntity) inventory.player.level().getBlockEntity(blockPos));
    }

    @Override
    public boolean stillValid(Player player) {
        return this.containerLevelAccess.evaluate((level, blockPos) -> level.getBlockState(blockPos).getBlock() instanceof DNACoderBlock && player.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
    }

    public float getCodeProgress() {
        int progress = this.data.get(1);
        int total = this.data.get(2);
        return total != 0 && progress != 0 ? Mth.clamp((float) progress / (float) total, 0.0F, 1.0F) : 0.0F;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        return SimpleUtils.quickMoveItemStack(this, player, slotIndex, 3);
    }
}
