package willatendo.fossilslegacy.server.jei;

import com.google.common.collect.Lists;
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
import willatendo.fossilslegacy.server.block.entity.CultivatorBlockEntity;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.commands.FossilsLegacyCommandTypes;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.item.*;
import willatendo.fossilslegacy.server.item.feederfood.FeederFood;
import willatendo.fossilslegacy.server.item.feederfood.FillType;
import willatendo.fossilslegacy.server.jei.recipe.ArticulatedFossilRecipe;
import willatendo.fossilslegacy.server.jei.recipe.BiomatterRecipe;
import willatendo.fossilslegacy.server.jei.recipe.FeederRecipe;
import willatendo.fossilslegacy.server.jei.recipe.GeneModificationRecipe;
import willatendo.fossilslegacy.server.recipe.AnalyzationRecipe;
import willatendo.fossilslegacy.server.recipe.ArchaeologyRecipe;
import willatendo.fossilslegacy.server.recipe.CultivationRecipe;
import willatendo.fossilslegacy.server.recipe.FossilsLegacyRecipeTypes;
import willatendo.fossilslegacy.server.tags.FossilsLegacyCoatTypeTags;
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
        Registry<FeederFood> feederFoodRegistry = this.registryAccess.registryOrThrow(FossilsLegacyRegistries.FEEDER_FOOD);
        for (FeederFood feederFood : feederFoodRegistry.stream().toList()) {
            feederRecipes.add(new FeederRecipe(feederFood.getItemStack(), feederFood.getAmount(), feederFood.getFillType() == FillType.MEAT));
        }
        return feederRecipes;
    }

    public List<GeneModificationRecipe> getGeneModificationRecipes() {
        List<GeneModificationRecipe> geneModificationRecipes = Lists.newArrayList();
        Registry<CoatType> registry = this.registryAccess.registryOrThrow(FossilsLegacyRegistries.COAT_TYPES);

        for (DNAItem dnaItem : DNAItem.DNA) {
            if (dnaItem instanceof AnimalDNAItem animalDNAItem) {
                if (animalDNAItem.getApplicableCoatTypes() != null) {
                    List<Holder<CoatType>> coatTypes = registry.getTag(animalDNAItem.getApplicableCoatTypes()).get().stream().toList();
                    boolean hasLegacy = false;
                    for (Holder<CoatType> coatTypeHolder : coatTypes) {
                        if (coatTypeHolder.is(FossilsLegacyCoatTypeTags.LEGACY)) {
                            hasLegacy = true;
                            break;
                        }
                    }
                    geneModificationRecipes.add(new GeneModificationRecipe(FossilsLegacyUtils.translation("jei", "gene_modification.coat_type"), coatTypes.stream().map(Holder::value).toList(), Ingredient.of(dnaItem), hasLegacy));
                }
            }
        }

        return geneModificationRecipes;
    }

    public List<ArticulatedFossilRecipe> getArticulatedFossilRecipes() {
        List<ArticulatedFossilRecipe> articulatedFossilRecipes = new ArrayList<>();
        Registry<FossilVariant> fossilVariantRegistry = this.registryAccess.registryOrThrow(FossilsLegacyRegistries.FOSSIL_VARIANTS);
        for (Holder<FossilVariant> fossilVariant : fossilVariantRegistry.holders().toList()) {
            articulatedFossilRecipes.add(new ArticulatedFossilRecipe(fossilVariant.value().fossilCount(), fossilVariant));
        }
        return articulatedFossilRecipes;
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
