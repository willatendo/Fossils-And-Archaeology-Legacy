package willatendo.fossilslegacy.server.menu.menus;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.recipebook.ServerPlaceRecipe;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedItemContents;
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

public class AnalyzerMenu extends RecipeBookMenu {
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

        this.addStandardInventorySlots(inventory, 8, 84);

        this.addDataSlots(analyzerBlockEntity.containerData);
    }

    public AnalyzerMenu(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(windowId, inventory, friendlyByteBuf.readBlockPos());
    }

    public AnalyzerMenu(int windowId, Inventory inventory, BlockPos blockPos) {
        this(windowId, inventory, (AnalyzerBlockEntity) inventory.player.level().getBlockEntity(blockPos));
    }

    @Override
    public void fillCraftSlotsStackedContents(StackedItemContents stackedItemContents) {
        if (this.analyzerBlockEntity instanceof StackedContentsCompatible stackedContentsCompatible) {
            stackedContentsCompatible.fillStackedContents(stackedItemContents);
        }
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
    public RecipeBookMenu.PostPlaceAction handlePlacement(boolean useMaxItems, boolean isCreative, RecipeHolder<?> recipeHolder, ServerLevel serverLevel, Inventory inventory) {
        List<Slot> list = List.of(this.getSlot(0), this.getSlot(9));
        RecipeHolder<AnalyzationRecipe> recipe = (RecipeHolder<AnalyzationRecipe>) recipeHolder;
        return ServerPlaceRecipe.placeRecipe(new ServerPlaceRecipe.CraftingMenuAccess<>() {
            @Override
            public void fillCraftSlotsStackedContents(StackedItemContents stackedItemContents) {
                AnalyzerMenu.this.fillCraftSlotsStackedContents(stackedItemContents);
            }

            @Override
            public void clearCraftingContent() {
                list.forEach(slot -> slot.set(ItemStack.EMPTY));
            }

            @Override
            public boolean recipeMatches(RecipeHolder<AnalyzationRecipe> recipe) {
                return recipe.value().matches(new AnalyzerRecipeInput(AnalyzerMenu.this.analyzerBlockEntity.getItem(0), AnalyzerMenu.this.getItems()), serverLevel);
            }
        }, 1, 1, List.of(this.getSlot(0)), list, inventory, recipe, useMaxItems, isCreative);
    }

    @Override
    public RecipeBookType getRecipeBookType() {
        return FARecipeBookTypes.ANALYZER;
    }
}