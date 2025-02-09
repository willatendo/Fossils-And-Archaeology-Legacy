package willatendo.fossilslegacy.server.menu.menus;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.recipebook.ServerPlaceRecipe;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedItemContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.block.blocks.ArchaeologyWorkbenchBlock;
import willatendo.fossilslegacy.server.block.entity.entities.ArchaeologyWorkbenchBlockEntity;
import willatendo.fossilslegacy.server.fuel.FuelEntry;
import willatendo.fossilslegacy.server.menu.FAMenuTypes;
import willatendo.fossilslegacy.server.menu.FARecipeBookTypes;
import willatendo.fossilslegacy.server.menu.slot.FuelSlot;
import willatendo.fossilslegacy.server.menu.slot.ResultSlot;
import willatendo.fossilslegacy.server.recipe.recipes.ArchaeologyRecipe;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAFuelEntryTags;

import java.util.List;

public class ArchaeologyWorkbenchMenu extends RecipeBookMenu {
    private final ContainerLevelAccess containerLevelAccess;
    private final Level level;
    public final ArchaeologyWorkbenchBlockEntity archaeologyWorkbenchBlockEntity;

    public ArchaeologyWorkbenchMenu(int windowId, Inventory inventory, ArchaeologyWorkbenchBlockEntity archaeologyWorkbenchBlockEntity) {
        super(FAMenuTypes.ARCHAEOLOGY_WORKBENCH.get(), windowId);
        this.containerLevelAccess = ContainerLevelAccess.create(archaeologyWorkbenchBlockEntity.getLevel(), archaeologyWorkbenchBlockEntity.getBlockPos());
        this.level = inventory.player.level();
        this.archaeologyWorkbenchBlockEntity = archaeologyWorkbenchBlockEntity;

        this.addSlot(new Slot(archaeologyWorkbenchBlockEntity, 0, 49, 20));
        this.addSlot(new FuelSlot(archaeologyWorkbenchBlockEntity, 1, 80, 54, itemStack -> archaeologyWorkbenchBlockEntity.getOnDuration(itemStack) > 0));
        this.addSlot(new ResultSlot(inventory.player, archaeologyWorkbenchBlockEntity, 2, 111, 20));

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                this.addSlot(new Slot(inventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
            }
        }

        for (int column = 0; column < 9; column++) {
            this.addSlot(new Slot(inventory, column, 8 + column * 18, 142));
        }

        this.addDataSlots(archaeologyWorkbenchBlockEntity.containerData);
    }

    public ArchaeologyWorkbenchMenu(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(windowId, inventory, friendlyByteBuf.readBlockPos());
    }

    public ArchaeologyWorkbenchMenu(int windowId, Inventory inventory, BlockPos blockPos) {
        this(windowId, inventory, (ArchaeologyWorkbenchBlockEntity) inventory.player.level().getBlockEntity(blockPos));
    }

    @Override
    public void fillCraftSlotsStackedContents(StackedItemContents stackedItemContents) {
        if (this.archaeologyWorkbenchBlockEntity instanceof StackedContentsCompatible stackedContentsCompatible) {
            stackedContentsCompatible.fillStackedContents(stackedItemContents);
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return this.containerLevelAccess.evaluate((level, blockPos) -> level.getBlockState(blockPos).getBlock() instanceof ArchaeologyWorkbenchBlock && player.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        ItemStack itemStack = ItemStack.EMPTY;
        List<Slot> inventorySlots = this.slots;
        Slot slot = inventorySlots.get(slotIndex);

        if (slot != null && slot.hasItem()) {
            ItemStack itemStackInSlot = slot.getItem();
            itemStack = itemStackInSlot.copy();

            int playerInventoryStartIndex = 3;

            if (slotIndex < playerInventoryStartIndex) {
                if (!this.moveItemStackTo(itemStackInSlot, playerInventoryStartIndex, inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (FuelEntry.getFuel(this.level.holderLookup(FARegistries.FUEL_ENTRY), FAFuelEntryTags.ARCHAEOLOGY_WORKBENCH).getOrDefault(itemStackInSlot.getItem(), 0) > 0) {
                    this.moveItemStackTo(itemStackInSlot, 1, playerInventoryStartIndex, false);
                    return ItemStack.EMPTY;
                } else if (!this.moveItemStackTo(itemStackInSlot, 0, playerInventoryStartIndex, false)) {
                    return ItemStack.EMPTY;
                }
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

    public float getOnProgress() {
        int onDuration = this.archaeologyWorkbenchBlockEntity.containerData.get(1);
        if (onDuration == 0) {
            onDuration = 100;
        }

        return Mth.clamp(this.archaeologyWorkbenchBlockEntity.containerData.get(0) / (float) onDuration, 0.0F, 1.0F);
    }

    public int getArchaeologyProgress() {
        int archaeologyProgress = this.archaeologyWorkbenchBlockEntity.containerData.get(2);
        int archaeologyTotalTime = this.archaeologyWorkbenchBlockEntity.containerData.get(3);
        return archaeologyTotalTime != 0 && archaeologyProgress != 0 ? archaeologyProgress * 24 / archaeologyTotalTime : 0;
    }

    public boolean isOn() {
        return this.archaeologyWorkbenchBlockEntity.containerData.get(0) > 0;
    }

    @Override
    public RecipeBookMenu.PostPlaceAction handlePlacement(boolean useMaxItems, boolean isCreative, RecipeHolder<?> recipeHolder, ServerLevel serverLevel, Inventory inventory) {
        List<Slot> list = List.of(this.getSlot(0), this.getSlot(2));
        RecipeHolder<ArchaeologyRecipe> recipe = (RecipeHolder<ArchaeologyRecipe>) recipeHolder;
        return ServerPlaceRecipe.placeRecipe(new ServerPlaceRecipe.CraftingMenuAccess<>() {
            @Override
            public void fillCraftSlotsStackedContents(StackedItemContents stackedItemContents) {
                ArchaeologyWorkbenchMenu.this.fillCraftSlotsStackedContents(stackedItemContents);
            }

            @Override
            public void clearCraftingContent() {
                list.forEach(slot -> slot.set(ItemStack.EMPTY));
            }

            @Override
            public boolean recipeMatches(RecipeHolder<ArchaeologyRecipe> recipe) {
                return recipe.value().matches(new SingleRecipeInput(ArchaeologyWorkbenchMenu.this.archaeologyWorkbenchBlockEntity.getItem(0)), serverLevel);
            }
        }, 1, 1, List.of(this.getSlot(0)), list, inventory, recipe, useMaxItems, isCreative);
    }

    @Override
    public RecipeBookType getRecipeBookType() {
        return FARecipeBookTypes.ARCHAEOLOGY_WORKBENCH;
    }
}