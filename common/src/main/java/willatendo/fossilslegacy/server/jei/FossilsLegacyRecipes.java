package willatendo.fossilslegacy.server.jei;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.vanilla.IJeiAnvilRecipe;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.item.FossilsLegacyTiers;
import willatendo.fossilslegacy.server.recipe.AnalyzationRecipe;
import willatendo.fossilslegacy.server.recipe.ArchaeologyRecipe;
import willatendo.fossilslegacy.server.recipe.CultivationRecipe;
import willatendo.fossilslegacy.server.recipe.FossilsLegacyRecipeTypes;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FossilsLegacyRecipes {
    private final RecipeManager recipeManager;

    public FossilsLegacyRecipes(IIngredientManager iIngredientManager) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        this.recipeManager = clientLevel.getRecipeManager();
    }

    public List<RecipeHolder<ArchaeologyRecipe>> getArchaeologyRecipes(IRecipeCategory<RecipeHolder<ArchaeologyRecipe>> archaeologyCategory) {
        return recipeManager.getAllRecipesFor(FossilsLegacyRecipeTypes.ARCHAEOLOGY.get());
    }

    public List<RecipeHolder<CultivationRecipe>> getCultivationRecipes(IRecipeCategory<RecipeHolder<CultivationRecipe>> cultivationCategory) {
        return recipeManager.getAllRecipesFor(FossilsLegacyRecipeTypes.CULTIVATION.get());
    }

    public List<RecipeHolder<AnalyzationRecipe>> getAnalyzationRecipes(IRecipeCategory<RecipeHolder<AnalyzationRecipe>> analyzationCategory) {
        return recipeManager.getAllRecipesFor(FossilsLegacyRecipeTypes.ANALYZATION.get());
    }

    public static List<RecipeHolder<CraftingRecipe>> createMagicConchRecipes() {
        List<RecipeHolder<CraftingRecipe>> recipes = new ArrayList<>();
        ItemStack magicConchFollow = new ItemStack(FossilsLegacyItems.MAGIC_CONCH.get());
        CompoundTag magicConchFollowTag = magicConchFollow.getOrCreateTag();
        magicConchFollowTag.putString("Command", "follow");
        magicConchFollow.setTag(magicConchFollowTag);
        ItemStack magicConchStay = new ItemStack(FossilsLegacyItems.MAGIC_CONCH.get());
        CompoundTag magicConchStayTag = magicConchStay.getOrCreateTag();
        magicConchStayTag.putString("Command", "stay");
        magicConchStay.setTag(magicConchStayTag);
        ItemStack magicConchFreeMove = new ItemStack(FossilsLegacyItems.MAGIC_CONCH.get());
        CompoundTag magicConchFreeMoveTag = magicConchFreeMove.getOrCreateTag();
        magicConchFreeMoveTag.putString("Command", "free_move");
        magicConchFreeMove.setTag(magicConchFreeMoveTag);

        recipes.add(new RecipeHolder<>(FossilsLegacyUtils.resource("magic_conch_stay"), new ShapelessRecipe("magic_conch", CraftingBookCategory.MISC, magicConchStay, NonNullList.of(Ingredient.EMPTY, Ingredient.of(magicConchFollow)))));
        recipes.add(new RecipeHolder<>(FossilsLegacyUtils.resource("magic_conch_free_move"), new ShapelessRecipe("magic_conch", CraftingBookCategory.MISC, magicConchFreeMove, NonNullList.of(Ingredient.EMPTY, Ingredient.of(magicConchStay)))));
        recipes.add(new RecipeHolder<>(FossilsLegacyUtils.resource("magic_conch_follow"), new ShapelessRecipe("magic_conch", CraftingBookCategory.MISC, magicConchFollow, NonNullList.of(Ingredient.EMPTY, Ingredient.of(magicConchFreeMove)))));

        return recipes;
    }

    public static List<IJeiAnvilRecipe> createRepairRecipes(IVanillaRecipeFactory iVanillaRecipeFactory) {
        return getRepairData().flatMap(repairData -> getRepairRecipes(repairData, iVanillaRecipeFactory)).toList();
    }

    private static Stream<RepairData> getRepairData() {
        return Stream.of(new RepairData(FossilsLegacyTiers.SCARAB_GEM.getRepairIngredient(), new ItemStack(FossilsLegacyItems.SCARAB_GEM_SWORD.get()), new ItemStack(FossilsLegacyItems.SCARAB_GEM_PICKAXE.get()), new ItemStack(FossilsLegacyItems.SCARAB_GEM_AXE.get()), new ItemStack(FossilsLegacyItems.SCARAB_GEM_SHOVEL.get()), new ItemStack(FossilsLegacyItems.SCARAB_GEM_HOE.get())));
    }

    private static Stream<IJeiAnvilRecipe> getRepairRecipes(RepairData repairData, IVanillaRecipeFactory iVanillaRecipeFactory) {
        Ingredient repairIngredient = repairData.getRepairIngredient();
        List<ItemStack> repairables = repairData.getRepairables();
        List<ItemStack> repairMaterials = List.of(repairIngredient.getItems());

        return repairables.stream().mapMulti((itemStack, consumer) -> {
            ItemStack damagedThreeQuarters = itemStack.copy();
            damagedThreeQuarters.setDamageValue(damagedThreeQuarters.getMaxDamage() * 3 / 4);
            ItemStack damagedHalf = itemStack.copy();
            damagedHalf.setDamageValue(damagedHalf.getMaxDamage() / 2);

            IJeiAnvilRecipe repairWithSame = iVanillaRecipeFactory.createAnvilRecipe(List.of(damagedThreeQuarters), List.of(damagedThreeQuarters), List.of(damagedHalf));
            consumer.accept(repairWithSame);

            if (!repairMaterials.isEmpty()) {
                ItemStack damagedFully = itemStack.copy();
                damagedFully.setDamageValue(damagedFully.getMaxDamage());
                IJeiAnvilRecipe repairWithMaterial = iVanillaRecipeFactory.createAnvilRecipe(List.of(damagedFully), repairMaterials, List.of(damagedThreeQuarters));
                consumer.accept(repairWithMaterial);
            }
        });
    }

    private static class RepairData {
        private final Ingredient repairIngredient;
        private final List<ItemStack> repairables;

        public RepairData(Ingredient repairIngredient, ItemStack... repairables) {
            this.repairIngredient = repairIngredient;
            this.repairables = List.of(repairables);
        }

        public Ingredient getRepairIngredient() {
            return repairIngredient;
        }

        public List<ItemStack> getRepairables() {
            return repairables;
        }
    }
}
