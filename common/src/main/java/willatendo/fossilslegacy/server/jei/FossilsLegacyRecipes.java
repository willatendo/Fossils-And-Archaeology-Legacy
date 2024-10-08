package willatendo.fossilslegacy.server.jei;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.vanilla.IJeiAnvilRecipe;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.Holder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.server.block.entity.CultivatorBlockEntity;
import willatendo.fossilslegacy.server.block.entity.FeederBlockEntity;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.commands.CommandType;
import willatendo.fossilslegacy.server.entity.commands.FossilsLegacyCommandTypes;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.item.DNAItem;
import willatendo.fossilslegacy.server.item.FossilsLegacyDataComponents;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.item.FossilsLegacyTiers;
import willatendo.fossilslegacy.server.jei.recipe.BiomatterRecipe;
import willatendo.fossilslegacy.server.jei.recipe.FeederRecipe;
import willatendo.fossilslegacy.server.jei.recipe.GeneModificationRecipe;
import willatendo.fossilslegacy.server.recipe.AnalyzationRecipe;
import willatendo.fossilslegacy.server.recipe.ArchaeologyRecipe;
import willatendo.fossilslegacy.server.recipe.CultivationRecipe;
import willatendo.fossilslegacy.server.recipe.FossilsLegacyRecipeTypes;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class FossilsLegacyRecipes {
    private final RecipeManager recipeManager;
    private final RegistryAccess registryAccess;

    public FossilsLegacyRecipes() {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        this.recipeManager = clientLevel.getRecipeManager();
        this.registryAccess = clientLevel.registryAccess();
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

    public List<BiomatterRecipe> getBiomatterRecipes() {
        List<BiomatterRecipe> biomatterRecipes = new ArrayList<>();
        for (int i = 0; i < CultivatorBlockEntity.getOnTimeMap().size(); i++) {
            biomatterRecipes.add(new BiomatterRecipe(new ItemStack(CultivatorBlockEntity.getOnTimeMap().keySet().stream().toList().get(i)), CultivatorBlockEntity.getOnTimeMap().values().stream().toList().get(i)));
        }
        return biomatterRecipes;
    }

    public List<FeederRecipe> getFeederRecipes() {
        List<FeederRecipe> feederRecipes = new ArrayList<>();
        for (int i = 0; i < FeederBlockEntity.getMeatFoodLevel().size(); i++) {
            feederRecipes.add(new FeederRecipe(new ItemStack(FeederBlockEntity.getMeatFoodLevel().keySet().stream().toList().get(i)), FeederBlockEntity.getMeatFoodLevel().values().stream().toList().get(i), true));
        }
        for (int i = 0; i < FeederBlockEntity.getPlantsFoodLevel().size(); i++) {
            feederRecipes.add(new FeederRecipe(new ItemStack(FeederBlockEntity.getPlantsFoodLevel().keySet().stream().toList().get(i)), FeederBlockEntity.getPlantsFoodLevel().values().stream().toList().get(i), false));
        }
        return feederRecipes;
    }

    public List<GeneModificationRecipe> getGeneModificationRecipes() {
        List<GeneModificationRecipe> geneModificationRecipes = Lists.newArrayList();
        Registry<CoatType> registry = this.registryAccess.registryOrThrow(FossilsLegacyRegistries.COAT_TYPES);

        for (DNAItem dnaItem : DNAItem.DNA) {
            if (dnaItem.getApplicableCoatTypes() != null) {
                List<CoatType> coatTypes = registry.getTag(dnaItem.getApplicableCoatTypes()).get().stream().map(Holder::value).toList();
                geneModificationRecipes.add(new GeneModificationRecipe(FossilsLegacyUtils.translation("jei", "gene_modification.coat_type"), coatTypes, Ingredient.of(dnaItem)));
            }
        }

        return geneModificationRecipes;
    }

    public List<RecipeHolder<CraftingRecipe>> createMagicConchRecipes() {
        List<RecipeHolder<CraftingRecipe>> recipes = new ArrayList<>();
        ItemStack magicConchFollow = new ItemStack(FossilsLegacyItems.MAGIC_CONCH.get());
        magicConchFollow.set(FossilsLegacyDataComponents.COMMAND_TYPE.get(), FossilsLegacyCommandTypes.FOLLOW);
        ItemStack magicConchStay = new ItemStack(FossilsLegacyItems.MAGIC_CONCH.get());
        magicConchStay.set(FossilsLegacyDataComponents.COMMAND_TYPE.get(), FossilsLegacyCommandTypes.STAY);
        ItemStack magicConchFreeMove = new ItemStack(FossilsLegacyItems.MAGIC_CONCH.get());
        magicConchFreeMove.set(FossilsLegacyDataComponents.COMMAND_TYPE.get(), FossilsLegacyCommandTypes.FREE_MOVE);

        recipes.add(new RecipeHolder<>(FossilsLegacyUtils.resource("magic_conch_stay"), new ShapelessRecipe("magic_conch", CraftingBookCategory.MISC, magicConchStay, NonNullList.of(Ingredient.EMPTY, Ingredient.of(magicConchFollow)))));
        recipes.add(new RecipeHolder<>(FossilsLegacyUtils.resource("magic_conch_free_move"), new ShapelessRecipe("magic_conch", CraftingBookCategory.MISC, magicConchFreeMove, NonNullList.of(Ingredient.EMPTY, Ingredient.of(magicConchStay)))));
        recipes.add(new RecipeHolder<>(FossilsLegacyUtils.resource("magic_conch_follow"), new ShapelessRecipe("magic_conch", CraftingBookCategory.MISC, magicConchFollow, NonNullList.of(Ingredient.EMPTY, Ingredient.of(magicConchFreeMove)))));

        return recipes;
    }

    public List<IJeiAnvilRecipe> createRepairRecipes(IVanillaRecipeFactory iVanillaRecipeFactory) {
        return getRepairData().flatMap(repairData -> getRepairRecipes(repairData, iVanillaRecipeFactory)).toList();
    }

    private Stream<RepairData> getRepairData() {
        return Stream.of(new RepairData(FossilsLegacyTiers.SCARAB_GEM.getRepairIngredient(), new ItemStack(FossilsLegacyItems.SCARAB_GEM_SWORD.get()), new ItemStack(FossilsLegacyItems.SCARAB_GEM_PICKAXE.get()), new ItemStack(FossilsLegacyItems.SCARAB_GEM_AXE.get()), new ItemStack(FossilsLegacyItems.SCARAB_GEM_SHOVEL.get()), new ItemStack(FossilsLegacyItems.SCARAB_GEM_HOE.get())));
    }

    private Stream<IJeiAnvilRecipe> getRepairRecipes(RepairData repairData, IVanillaRecipeFactory iVanillaRecipeFactory) {
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
