package willatendo.fossilslegacy.server.menu.menus;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.block.blocks.AnalyzerBlock;
import willatendo.fossilslegacy.server.block.entity.crafting.AnalyzerRecipeInput;
import willatendo.fossilslegacy.server.block.entity.entities.AnalyzerBlockEntity;
import willatendo.fossilslegacy.server.menu.FAMenuTypes;
import willatendo.fossilslegacy.server.menu.FARecipeBookTypes;
import willatendo.fossilslegacy.server.menu.slot.ResultSlot;
import willatendo.fossilslegacy.server.recipe.recipes.AnalyzationRecipe;

import java.util.List;

public class AnalyzerMenu extends RecipeBookMenu<AnalyzerRecipeInput, AnalyzationRecipe> {
    private final ContainerLevelAccess containerLevelAccess;
    private final Level level;
    public final AnalyzerBlockEntity analyzerBlockEntity;

    public AnalyzerMenu(int windowId, Inventory inventory, AnalyzerBlockEntity analyzerBlockEntity) {
        super(FAMenuTypes.ANALYZER.get(), windowId);
        this.containerLevelAccess = ContainerLevelAccess.create(analyzerBlockEntity.getLevel(), analyzerBlockEntity.getBlockPos());
        this.level = inventory.player.level();
        this.analyzerBlockEntity = analyzerBlockEntity;

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                this.addSlot(new Slot(analyzerBlockEntity, column + row * 3, 8 + column * 18, 18 + row * 18));
            }
        }

        this.addSlot(new ResultSlot(inventory.player, analyzerBlockEntity, 9, 102, 22));
        for (int column = 0; column < 3; column++) {
            this.addSlot(new ResultSlot(inventory.player, analyzerBlockEntity, column + 10, 98 + column * 18, 54));
        }

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                this.addSlot(new Slot(inventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
            }
        }

        for (int column = 0; column < 9; column++) {
            this.addSlot(new Slot(inventory, column, 8 + column * 18, 142));
        }

        this.addDataSlots(analyzerBlockEntity.containerData);
    }

    public AnalyzerMenu(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(windowId, inventory, friendlyByteBuf.readBlockPos());
    }

    public AnalyzerMenu(int windowId, Inventory inventory, BlockPos blockPos) {
        this(windowId, inventory, (AnalyzerBlockEntity) inventory.player.level().getBlockEntity(blockPos));
    }

    @Override
    public void fillCraftSlotsStackedContents(StackedContents stackedContents) {
        if (this.analyzerBlockEntity instanceof StackedContentsCompatible stackedContentsCompatible) {
            stackedContentsCompatible.fillStackedContents(stackedContents);
        }
    }

    @Override
    public void clearCraftingContent() {
        this.getSlot(0).set(ItemStack.EMPTY);
        this.getSlot(2).set(ItemStack.EMPTY);
    }

    @Override
    public boolean recipeMatches(RecipeHolder<AnalyzationRecipe> recipeHolder) {
        return recipeHolder.value().matches(new AnalyzerRecipeInput(this.analyzerBlockEntity.getItem(0), this.analyzerBlockEntity.getItemStacks()), this.level);
    }

    @Override
    public int getResultSlotIndex() {
        return 2;
    }

    @Override
    public int getGridWidth() {
        return 1;
    }

    @Override
    public int getGridHeight() {
        return 1;
    }

    @Override
    public int getSize() {
        return 3;
    }


    @Override
    public boolean stillValid(Player player) {
        return this.containerLevelAccess.evaluate((level, blockPos) -> level.getBlockState(blockPos).getBlock() instanceof AnalyzerBlock && player.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        ItemStack itemStack = ItemStack.EMPTY;
        List<Slot> inventorySlots = this.slots;
        Slot slot = inventorySlots.get(slotIndex);

        if (slot != null && slot.hasItem()) {
            ItemStack itemStackInSlot = slot.getItem();
            itemStack = itemStackInSlot.copy();

            int playerInventoryStartIndex = 13;

            if (slotIndex < playerInventoryStartIndex) {
                if (!this.moveItemStackTo(itemStackInSlot, playerInventoryStartIndex, inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemStackInSlot, 0, playerInventoryStartIndex, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStackInSlot.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemStackInSlot.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemStackInSlot);
        }

        return itemStack;
    }

    public int getAnalyzerProgress() {
        int analyzerProgress = this.analyzerBlockEntity.containerData.get(1);
        int analyzerTotalTime = this.analyzerBlockEntity.containerData.get(2);
        return analyzerTotalTime != 0 && analyzerProgress != 0 ? analyzerProgress * 21 / analyzerTotalTime : 0;
    }

    public boolean isOn() {
        return this.analyzerBlockEntity.containerData.get(0) > 0;
    }

    @Override
    public RecipeBookType getRecipeBookType() {
        return FARecipeBookTypes.ANALYZER;
    }

    @Override
    public boolean shouldMoveToInventory(int slotIndex) {
        return slotIndex != 1;
    }
}