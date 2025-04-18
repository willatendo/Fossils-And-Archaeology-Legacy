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
import willatendo.fossilslegacy.server.block.blocks.CultivatorBlock;
import willatendo.fossilslegacy.server.block.entity.entities.CultivatorBlockEntity;
import willatendo.fossilslegacy.server.fuel.FuelEntry;
import willatendo.fossilslegacy.server.menu.FAMenuTypes;
import willatendo.fossilslegacy.server.menu.FARecipeBookTypes;
import willatendo.fossilslegacy.server.menu.slot.FuelSlot;
import willatendo.fossilslegacy.server.menu.slot.ResultSlot;
import willatendo.fossilslegacy.server.recipe.recipes.CultivationRecipe;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAFuelEntryTags;

import java.util.List;

public class CultivatorMenu extends RecipeBookMenu {
    private final ContainerLevelAccess containerLevelAccess;
    private final Level level;
    public final CultivatorBlockEntity cultivatorBlockEntity;

    public CultivatorMenu(int windowId, Inventory inventory, CultivatorBlockEntity cultivatorBlockEntity) {
        super(FAMenuTypes.CULTIVATOR.get(), windowId);
        this.containerLevelAccess = ContainerLevelAccess.create(cultivatorBlockEntity.getLevel(), cultivatorBlockEntity.getBlockPos());
        this.level = inventory.player.level();
        this.cultivatorBlockEntity = cultivatorBlockEntity;

        this.addSlot(new Slot(cultivatorBlockEntity, 0, 49, 20));
        this.addSlot(new FuelSlot(cultivatorBlockEntity, 1, 80, 54, itemStack -> cultivatorBlockEntity.getOnDuration(inventory.player.registryAccess(), itemStack) > 0));
        this.addSlot(new ResultSlot(inventory.player, cultivatorBlockEntity, 2, 111, 20));

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                this.addSlot(new Slot(inventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
            }
        }

        for (int column = 0; column < 9; column++) {
            this.addSlot(new Slot(inventory, column, 8 + column * 18, 142));
        }

        this.addDataSlots(cultivatorBlockEntity.containerData);
    }

    public CultivatorMenu(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(windowId, inventory, friendlyByteBuf.readBlockPos());
    }

    public CultivatorMenu(int windowId, Inventory inventory, BlockPos blockPos) {
        this(windowId, inventory, (CultivatorBlockEntity) inventory.player.level().getBlockEntity(blockPos));
    }

    @Override
    public void fillCraftSlotsStackedContents(StackedItemContents stackedItemContents) {
        if (this.cultivatorBlockEntity instanceof StackedContentsCompatible stackedContentsCompatible) {
            stackedContentsCompatible.fillStackedContents(stackedItemContents);
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return this.containerLevelAccess.evaluate((level, blockPos) -> level.getBlockState(blockPos).getBlock() instanceof CultivatorBlock && player.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
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
                if (FuelEntry.getFuel(this.level.holderLookup(FARegistries.FUEL_ENTRY), FAFuelEntryTags.CULTIVATOR).getOrDefault(itemStackInSlot.getItem(), 0) > 0) {
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
        int onDuration = this.cultivatorBlockEntity.containerData.get(1);
        if (onDuration == 0) {
            onDuration = 100;
        }

        return Mth.clamp(this.cultivatorBlockEntity.containerData.get(0) / (float) onDuration, 0.0F, 1.0F);
    }

    public int getCultivationProgress() {
        int cultivationProgress = this.cultivatorBlockEntity.containerData.get(2);
        int cultivationTotalTime = this.cultivatorBlockEntity.containerData.get(3);
        return cultivationTotalTime != 0 && cultivationProgress != 0 ? cultivationProgress * 22 / cultivationTotalTime : 0;
    }

    public boolean isOn() {
        return this.cultivatorBlockEntity.containerData.get(0) > 0;
    }

    @Override
    public RecipeBookMenu.PostPlaceAction handlePlacement(boolean useMaxItems, boolean isCreative, RecipeHolder<?> recipeHolder, ServerLevel serverLevel, Inventory inventory) {
        List<Slot> list = List.of(this.getSlot(0), this.getSlot(2));
        RecipeHolder<CultivationRecipe> recipe = (RecipeHolder<CultivationRecipe>) recipeHolder;
        return ServerPlaceRecipe.placeRecipe(new ServerPlaceRecipe.CraftingMenuAccess<>() {
            @Override
            public void fillCraftSlotsStackedContents(StackedItemContents stackedItemContents) {
                CultivatorMenu.this.fillCraftSlotsStackedContents(stackedItemContents);
            }

            @Override
            public void clearCraftingContent() {
                list.forEach(slot -> slot.set(ItemStack.EMPTY));
            }

            @Override
            public boolean recipeMatches(RecipeHolder<CultivationRecipe> recipe) {
                return recipe.value().matches(new SingleRecipeInput(CultivatorMenu.this.cultivatorBlockEntity.getItem(0)), serverLevel);
            }
        }, 1, 1, List.of(this.getSlot(0)), list, inventory, recipe, useMaxItems, isCreative);
    }

    @Override
    public RecipeBookType getRecipeBookType() {
        return FARecipeBookTypes.CULTIVATOR;
    }
}