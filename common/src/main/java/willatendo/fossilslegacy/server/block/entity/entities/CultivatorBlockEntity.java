package willatendo.fossilslegacy.server.block.entity.entities;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedItemContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeCraftingHolder;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeManager.CachedCheck;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import willatendo.fossilslegacy.server.block.blocks.CultivatorBlock;
import willatendo.fossilslegacy.server.block.entity.FABlockEntityTypes;
import willatendo.fossilslegacy.server.fuel.FuelEntry;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.menu.menus.CultivatorMenu;
import willatendo.fossilslegacy.server.recipe.FARecipeTypes;
import willatendo.fossilslegacy.server.recipe.recipes.CultivationRecipe;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAFuelEntryTags;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public class CultivatorBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, RecipeCraftingHolder, StackedContentsCompatible {
    private static final int[] SLOTS_FOR_UP = new int[]{0};
    private static final int[] SLOTS_FOR_DOWN = new int[]{2};
    private static final int[] SLOTS_FOR_SIDES = new int[]{1};
    protected NonNullList<ItemStack> itemStacks = NonNullList.withSize(3, ItemStack.EMPTY);
    public int onTime;
    public int onDuration;
    public int cultivationProgress;
    public int cultivationTotalTime;
    public int time;
    public float rot;
    public float oRot;
    public float tRot;
    public final ContainerData containerData = new ContainerData() {
        @Override
        public int get(int slot) {
            switch (slot) {
                case 0:
                    if (CultivatorBlockEntity.this.onDuration > 32767) {
                        return Mth.floor((double) CultivatorBlockEntity.this.onTime / (double) CultivatorBlockEntity.this.onDuration * 32767.0);
                    }

                    return CultivatorBlockEntity.this.onTime;
                case 1:
                    return Math.min(CultivatorBlockEntity.this.onDuration, 32767);
                case 2:
                    return CultivatorBlockEntity.this.cultivationProgress;
                case 3:
                    return CultivatorBlockEntity.this.cultivationTotalTime;
                default:
                    return 0;
            }
        }

        @Override
        public void set(int slot, int set) {
            switch (slot) {
                case 0:
                    CultivatorBlockEntity.this.onTime = set;
                    break;
                case 1:
                    CultivatorBlockEntity.this.onDuration = set;
                    break;
                case 2:
                    CultivatorBlockEntity.this.cultivationProgress = set;
                    break;
                case 3:
                    CultivatorBlockEntity.this.cultivationTotalTime = set;
            }

        }

        @Override
        public int getCount() {
            return 4;
        }
    };

    private final Object2IntOpenHashMap<ResourceKey<Recipe<?>>> recipesUsed = new Object2IntOpenHashMap<>();
    public final CachedCheck<SingleRecipeInput, CultivationRecipe> recipeCheck = RecipeManager.createCheck(FARecipeTypes.CULTIVATION.get());

    public final DyeColor dyeColor;

    public CultivatorBlockEntity(BlockPos blockPos, BlockState blockState) {
        this(DyeColor.RED, blockPos, blockState);
    }

    public CultivatorBlockEntity(DyeColor dyeColor, BlockPos blockPos, BlockState blockState) {
        super(FABlockEntityTypes.CULTIVATOR.get(), blockPos, blockState);
        this.dyeColor = dyeColor;
    }

    private boolean isOn() {
        return this.onTime > 0;
    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(compoundTag, this.itemStacks, provider);
        this.onTime = compoundTag.getInt("OnTime");
        this.cultivationProgress = compoundTag.getInt("CultivationTime");
        this.cultivationTotalTime = compoundTag.getInt("CultivationTimeTotal");
        this.onDuration = this.getOnDuration(provider, this.itemStacks.get(1));
        CompoundTag usedRecipes = compoundTag.getCompound("RecipesUsed");
        for (String recipes : usedRecipes.getAllKeys()) {
            this.recipesUsed.put(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse(recipes)), usedRecipes.getInt(recipes));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        compoundTag.putInt("OnTime", this.onTime);
        compoundTag.putInt("CultivationTime", this.cultivationProgress);
        compoundTag.putInt("CultivationTimeTotal", this.cultivationTotalTime);
        ContainerHelper.saveAllItems(compoundTag, this.itemStacks, provider);
        CompoundTag usedRecipes = new CompoundTag();
        this.recipesUsed.forEach((recipeId, recipe) -> usedRecipes.putInt(recipeId.location().toString(), recipe));
        compoundTag.put("RecipesUsed", usedRecipes);
    }

    public static void clientTick(Level level, BlockPos blockPos, BlockState blockState, CultivatorBlockEntity cultivatorBlockEntity) {
        cultivatorBlockEntity.oRot = cultivatorBlockEntity.rot;
        cultivatorBlockEntity.tRot += 0.02F;

        while (cultivatorBlockEntity.rot >= 3.1415927F) {
            cultivatorBlockEntity.rot -= 6.2831855F;
        }

        while (cultivatorBlockEntity.rot < -3.1415927F) {
            cultivatorBlockEntity.rot += 6.2831855F;
        }

        while (cultivatorBlockEntity.tRot >= 3.1415927F) {
            cultivatorBlockEntity.tRot -= 6.2831855F;
        }

        while (cultivatorBlockEntity.tRot < -3.1415927F) {
            cultivatorBlockEntity.tRot += 6.2831855F;
        }

        float f2;
        for (f2 = cultivatorBlockEntity.tRot - cultivatorBlockEntity.rot; f2 >= 3.1415927F; f2 -= 6.2831855F) {
        }

        while (f2 < -3.1415927F) {
            f2 += 6.2831855F;
        }

        cultivatorBlockEntity.rot += f2 * 0.4F;
        ++cultivatorBlockEntity.time;
    }

    public static void serverTick(ServerLevel serverLevel, BlockPos blockPos, BlockState blockState, CultivatorBlockEntity cultivatorBlockEntity) {
        boolean isOn = cultivatorBlockEntity.isOn();
        boolean changed = false;
        if (cultivatorBlockEntity.isOn()) {
            --cultivatorBlockEntity.onTime;
        }

        ItemStack fuel = cultivatorBlockEntity.itemStacks.get(1);
        boolean hasInput = !cultivatorBlockEntity.itemStacks.get(0).isEmpty();
        boolean hasFuel = !fuel.isEmpty();
        if (cultivatorBlockEntity.isOn() || hasFuel && hasInput) {
            RecipeHolder<CultivationRecipe> recipe;
            if (hasInput) {
                recipe = cultivatorBlockEntity.recipeCheck.getRecipeFor(new SingleRecipeInput(cultivatorBlockEntity.itemStacks.get(0)), serverLevel).orElse(null);
            } else {
                recipe = null;
            }

            int maxStackSize = cultivatorBlockEntity.getMaxStackSize();
            if (!cultivatorBlockEntity.isOn() && cultivatorBlockEntity.canCultivate(serverLevel.registryAccess(), recipe, cultivatorBlockEntity.itemStacks, maxStackSize)) {
                cultivatorBlockEntity.onTime = cultivatorBlockEntity.getOnDuration(serverLevel.registryAccess(), fuel);
                cultivatorBlockEntity.onDuration = cultivatorBlockEntity.onTime;
                if (cultivatorBlockEntity.isOn()) {
                    changed = true;
                    ItemStack craftingRemainder = fuel.getItem().getCraftingRemainder();
                    if (!craftingRemainder.isEmpty()) {
                        cultivatorBlockEntity.itemStacks.set(1, craftingRemainder);
                    } else if (hasFuel) {
                        Item item = fuel.getItem();
                        fuel.shrink(1);
                        if (fuel.isEmpty()) {
                            cultivatorBlockEntity.itemStacks.set(1, item.getCraftingRemainder());
                        }
                    }
                }
            }

            if (cultivatorBlockEntity.isOn() && cultivatorBlockEntity.canCultivate(serverLevel.registryAccess(), recipe, cultivatorBlockEntity.itemStacks, maxStackSize)) {
                ++cultivatorBlockEntity.cultivationProgress;
                if (cultivatorBlockEntity.cultivationProgress == cultivatorBlockEntity.cultivationTotalTime) {
                    cultivatorBlockEntity.cultivationProgress = 0;
                    cultivatorBlockEntity.cultivationTotalTime = getTotalCultivationTime(serverLevel, cultivatorBlockEntity);
                    if (cultivatorBlockEntity.cultivate(serverLevel.registryAccess(), recipe, cultivatorBlockEntity.itemStacks, maxStackSize)) {
                        cultivatorBlockEntity.setRecipeUsed(recipe);
                    }

                    changed = true;
                }
            } else {
                cultivatorBlockEntity.cultivationProgress = 0;
            }
        } else if (!cultivatorBlockEntity.isOn() && cultivatorBlockEntity.cultivationProgress > 0) {
            cultivatorBlockEntity.cultivationProgress = Mth.clamp(cultivatorBlockEntity.cultivationProgress - 2, 0, cultivatorBlockEntity.cultivationTotalTime);
        }

        if (cultivatorBlockEntity.onTime == (cultivatorBlockEntity.getTotalCultivationTime(serverLevel, cultivatorBlockEntity) / 2) + 1) {
            if (!hasInput) {
                if (cultivatorBlockEntity.level.getRandom().nextInt(100) <= 30) {
                    CultivatorBlock.shatter(serverLevel, blockPos, cultivatorBlockEntity);
                }
            } else {
                ItemStack input = cultivatorBlockEntity.itemStacks.get(0);
                int chance = input.has(FADataComponents.PURITY.get()) ? input.get(FADataComponents.PURITY.get()) : 30;
                if (cultivatorBlockEntity.level.getRandom().nextInt(100) <= chance) {
                    CultivatorBlock.shatter(serverLevel, blockPos, cultivatorBlockEntity);
                }
            }
        }

        if (isOn != cultivatorBlockEntity.isOn()) {
            changed = true;
            blockState = blockState.setValue(CultivatorBlock.ACTIVE, Boolean.valueOf(cultivatorBlockEntity.isOn()));
            serverLevel.setBlock(blockPos, blockState, 3);
        }

        if (changed) {
            setChanged(serverLevel, blockPos, blockState);
        }
    }

    private boolean canCultivate(RegistryAccess registryAccess, RecipeHolder<?> recipeHolder, NonNullList<ItemStack> itemStacks, int maxStackSize) {
        ItemStack input = itemStacks.get(0);
        if (input.has(FADataComponents.PURITY.get()) && input.get(FADataComponents.PURITY.get()) < 50) {
            return false;
        } else if (!input.isEmpty() && recipeHolder != null) {
            ItemStack output = ((CultivationRecipe) recipeHolder.value()).assemble(new SingleRecipeInput(input), registryAccess);
            if (output.isEmpty()) {
                return false;
            } else {
                ItemStack outputSlot = itemStacks.get(2);
                if (outputSlot.isEmpty()) {
                    return true;
                } else if (!ItemStack.isSameItem(outputSlot, output)) {
                    return false;
                } else if (outputSlot.getCount() + output.getCount() <= maxStackSize && outputSlot.getCount() + output.getCount() <= outputSlot.getMaxStackSize()) {
                    return true;
                } else {
                    return outputSlot.getCount() + output.getCount() <= output.getMaxStackSize();
                }
            }
        } else {
            return false;
        }
    }

    private boolean cultivate(RegistryAccess registryAccess, RecipeHolder<?> recipeHolder, NonNullList<ItemStack> itemStacks, int maxStackSize) {
        if (recipeHolder != null && this.canCultivate(registryAccess, recipeHolder, itemStacks, maxStackSize)) {
            ItemStack input = itemStacks.get(0);
            ItemStack output = ((CultivationRecipe) recipeHolder.value()).assemble(new SingleRecipeInput(itemStacks.get(0)), registryAccess);
            if (input.has(FADataComponents.MODEL_TYPE.get())) {
                output.set(FADataComponents.MODEL_TYPE.get(), input.get(FADataComponents.MODEL_TYPE.get()));
            }
            if (input.has(FADataComponents.COSMETIC_GENE_HOLDER.get())) {
                output.set(FADataComponents.COSMETIC_GENE_HOLDER.get(), input.get(FADataComponents.COSMETIC_GENE_HOLDER.get()));
            }
            if (input.has(FADataComponents.GENE_HOLDER.get())) {
                output.set(FADataComponents.GENE_HOLDER.get(), input.get(FADataComponents.GENE_HOLDER.get()));
            }
            ItemStack outputSlot = itemStacks.get(2);
            if (outputSlot.isEmpty()) {
                itemStacks.set(2, output.copy());
            } else if (outputSlot.is(output.getItem())) {
                outputSlot.grow(output.getCount());
            }

            input.shrink(1);
            return true;
        } else {
            return false;
        }
    }

    public int getOnDuration(HolderLookup.Provider provider, ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return 0;
        } else {
            return FuelEntry.getFuel(provider.lookupOrThrow(FARegistries.FUEL_ENTRY), FAFuelEntryTags.CULTIVATOR).getOrDefault(itemStack.getItem(), 0);
        }
    }

    private static int getTotalCultivationTime(ServerLevel serverLevel, CultivatorBlockEntity cultivatorBlockEntity) {
        return cultivatorBlockEntity.recipeCheck.getRecipeFor(new SingleRecipeInput(cultivatorBlockEntity.getItem(0)), serverLevel).map(recipeHolder -> recipeHolder.value().getTime()).orElse(6000);
    }

    @Override
    public int[] getSlotsForFace(Direction direction) {
        if (direction == Direction.DOWN) {
            return SLOTS_FOR_DOWN;
        } else {
            return direction == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
        }
    }

    @Override
    public boolean canPlaceItemThroughFace(int slot, ItemStack itemStack, Direction direction) {
        return this.canPlaceItem(slot, itemStack);
    }

    @Override
    public boolean canTakeItemThroughFace(int slot, ItemStack itemStack, Direction direction) {
        if (direction == Direction.DOWN && slot == 1) {
            return itemStack.is(Items.BUCKET);
        }
        return true;
    }

    @Override
    public int getContainerSize() {
        return this.itemStacks.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemStack : this.itemStacks) {
            if (!itemStack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack getItem(int slot) {
        return this.itemStacks.get(slot);
    }

    @Override
    public ItemStack removeItem(int slot, int amount) {
        return ContainerHelper.removeItem(this.itemStacks, slot, amount);
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        return ContainerHelper.takeItem(this.itemStacks, slot);
    }

    @Override
    public void setItem(int slot, ItemStack itemStack) {
        ItemStack itemStackInSlot = this.itemStacks.get(slot);
        boolean flag = !itemStack.isEmpty() && ItemStack.isSameItemSameComponents(itemStackInSlot, itemStack);
        this.itemStacks.set(slot, itemStack);
        if (itemStack.getCount() > this.getMaxStackSize()) {
            itemStack.setCount(this.getMaxStackSize());
        }

        if (slot == 0 && !flag) {
            if (this.level instanceof ServerLevel serverLevel) {
                this.cultivationTotalTime = getTotalCultivationTime(serverLevel, this);
                this.cultivationProgress = 0;
                this.setChanged();
            }
        }
    }

    @Override
    public boolean stillValid(Player player) {
        if (this.level.getBlockEntity(this.worldPosition) != this) {
            return false;
        } else {
            return player.distanceToSqr((double) this.worldPosition.getX() + 0.5D, (double) this.worldPosition.getY() + 0.5D, (double) this.worldPosition.getZ() + 0.5D) <= 64.0D;
        }
    }

    @Override
    public boolean canPlaceItem(int slot, ItemStack itemStack) {
        if (slot == 2) {
            return false;
        } else if (slot != 1) {
            return true;
        } else {
            return this.getOnDuration(this.level.registryAccess(), itemStack) > 0;
        }
    }

    @Override
    public void clearContent() {
        this.itemStacks.clear();
    }

    @Override
    public void setRecipeUsed(RecipeHolder<?> recipeHolder) {
        if (recipeHolder != null) {
            ResourceKey<Recipe<?>> recipeId = recipeHolder.id();
            this.recipesUsed.addTo(recipeId, 1);
        }
    }

    @Override
    public RecipeHolder<?> getRecipeUsed() {
        return null;
    }

    public void awardUsedRecipes(Player player, List<ItemStack> itemStacks) {
    }

    @Override
    public void fillStackedContents(StackedItemContents stackedItemContents) {
        for (ItemStack itemStack : this.itemStacks) {
            stackedItemContents.accountStack(itemStack);
        }
    }

    @Override
    protected Component getDefaultName() {
        return FAUtils.translation("container", "cultivator");
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.itemStacks;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemStacks) {
        this.itemStacks = itemStacks;
    }

    @Override
    protected AbstractContainerMenu createMenu(int windowId, Inventory inventory) {
        return new CultivatorMenu(windowId, inventory, this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putInt("CultivationTime", this.cultivationProgress);
        ContainerHelper.saveAllItems(compoundTag, this.itemStacks, true, provider);
        return compoundTag;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
