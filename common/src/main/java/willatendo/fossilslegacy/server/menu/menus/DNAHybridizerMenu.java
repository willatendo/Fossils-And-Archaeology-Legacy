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
import willatendo.fossilslegacy.client.screen.DNARecombinatorScreen;
import willatendo.fossilslegacy.server.block.blocks.DNAHybridizerBlock;
import willatendo.fossilslegacy.server.block.entity.entities.DNAHybridizerBlockEntity;
import willatendo.fossilslegacy.server.item.items.DNAItem;
import willatendo.fossilslegacy.server.menu.FAMenuTypes;
import willatendo.fossilslegacy.server.menu.slot.ResultSlot;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class DNAHybridizerMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess containerLevelAccess;
    private final ContainerData data;

    public DNAHybridizerMenu(int windowId, Inventory inventory, DNAHybridizerBlockEntity dnaHybridizerBlockEntity) {
        super(FAMenuTypes.DNA_HYBRIDIZER.get(), windowId);
        this.containerLevelAccess = ContainerLevelAccess.create(dnaHybridizerBlockEntity.getLevel(), dnaHybridizerBlockEntity.getBlockPos());
        this.data = dnaHybridizerBlockEntity.containerData;

        this.addSlot(new Slot(dnaHybridizerBlockEntity, 0, 56, 17) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.getItem() instanceof DNAItem;
            }

            @Override
            public ResourceLocation getNoItemIcon() {
                return DNARecombinatorScreen.EMPTY_SLOT_DNA;
            }
        });
        this.addSlot(new Slot(dnaHybridizerBlockEntity, 1, 56, 53) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.getItem() instanceof DNAItem;
            }

            @Override
            public ResourceLocation getNoItemIcon() {
                return DNARecombinatorScreen.EMPTY_SLOT_DNA;
            }
        });
        this.addSlot(new ResultSlot(inventory.player, dnaHybridizerBlockEntity, 2, 115, 34));

        this.addStandardInventorySlots(inventory, 8, 84);

        this.addDataSlots(dnaHybridizerBlockEntity.containerData);
    }

    public DNAHybridizerMenu(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(windowId, inventory, friendlyByteBuf.readBlockPos());
    }

    public DNAHybridizerMenu(int windowId, Inventory inventory, BlockPos blockPos) {
        this(windowId, inventory, (DNAHybridizerBlockEntity) inventory.player.level().getBlockEntity(blockPos));
    }

    @Override
    public boolean stillValid(Player player) {
        return this.containerLevelAccess.evaluate((level, blockPos) -> level.getBlockState(blockPos).getBlock() instanceof DNAHybridizerBlock && player.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
    }

    public float getHybridizationProgress() {
        int progress = this.data.get(1);
        int total = this.data.get(2);
        return total != 0 && progress != 0 ? Mth.clamp((float) progress / (float) total, 0.0F, 1.0F) : 0.0F;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        return SimpleUtils.quickMoveItemStack(this, player, slotIndex, 3);
    }
}
