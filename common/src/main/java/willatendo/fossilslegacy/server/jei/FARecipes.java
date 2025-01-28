package willatendo.fossilslegacy.server.jei;

import com.google.common.collect.Lists;
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
import willatendo.fossilslegacy.server.ancient_axe_bonus.AncientAxeBonus;
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.command_type.FACommandTypes;
import willatendo.fossilslegacy.server.feeder_food.FeederFood;
import willatendo.fossilslegacy.server.fuel.FuelEntry;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.item.FATiers;
import willatendo.fossilslegacy.server.item.items.AnimalDNAItem;
import willatendo.fossilslegacy.server.item.items.DNAItem;
import willatendo.fossilslegacy.server.jei.recipe.ArticulatedFossilRecipe;
import willatendo.fossilslegacy.server.jei.recipe.FuelRecipe;
import willatendo.fossilslegacy.server.jei.recipe.FeederRecipe;
import willatendo.fossilslegacy.server.jei.recipe.GeneModificationRecipe;
import willatendo.fossilslegacy.server.jewel_recovery.JewelRecovery;
import willatendo.fossilslegacy.server.recipe.FARecipeTypes;
import willatendo.fossilslegacy.server.recipe.recipes.AnalyzationRecipe;
import willatendo.fossilslegacy.server.recipe.recipes.ArchaeologyRecipe;
import willatendo.fossilslegacy.server.recipe.recipes.CultivationRecipe;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FACoatTypeTags;
import willatendo.fossilslegacy.server.tags.FAFuelEntryTags;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class FARecipes {
    private final RecipeManager recipeManager;
    private final RegistryAccess registryAccess;

    public FARecipes() {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        this.recipeManager = clientLevel.getRecipeManager();
        this.registryAccess = clientLevel.registryAccess();
    }

    public List<RecipeHolder<AnalyzationRecipe>> getAnalyzationRecipes() {
        return recipeManager.getAllRecipesFor(FARecipeTypes.ANALYZATION.get());
    }

    public List<AncientAxeBonus> getAncientAxeBonusRecipes() {
        List<AncientAxeBonus> ancientAxeBonuses = new ArrayList<>();
        this.registryAccess.registryOrThrow(FARegistries.ANCIENT_AXE_BONUS).forEach(ancientAxeBonuses::add);
        return ancientAxeBonuses;
    }

    public List<RecipeHolder<ArchaeologyRecipe>> getArchaeologyRecipes() {
        return recipeManager.getAllRecipesFor(FARecipeTypes.ARCHAEOLOGY.get());
    }

    public List<ArticulatedFossilRecipe> getArticulatedFossilRecipes() {
        List<ArticulatedFossilRecipe> articulatedFossilRecipes = new ArrayList<>();
        this.registryAccess.registryOrThrow(FARegistries.FOSSIL_VARIANTS).holders().forEach(fossilVariant -> articulatedFossilRecipes.add(new ArticulatedFossilRecipe(fossilVariant.value().fossilCount(), fossilVariant)));
        return articulatedFossilRecipes;
    }

    public List<FuelRecipe> getBiomatterRecipes() {
        List<FuelRecipe> fuelRecipes = new ArrayList<>();
        FuelEntry.getFuel(this.registryAccess, FAFuelEntryTags.CULTIVATOR).forEach((item, time) -> fuelRecipes.add(new FuelRecipe(new ItemStack(item), time)));
        return fuelRecipes;
    }

    public List<RecipeHolder<CultivationRecipe>> getCultivationRecipes() {
        return recipeManager.getAllRecipesFor(FARecipeTypes.CULTIVATION.get());
    }

    public List<FeederFood> getFeederRecipes() {
        List<FeederFood> feederRecipes = new ArrayList<>();
        this.registryAccess.registryOrThrow(FARegistries.FEEDER_FOOD).forEach(feederRecipes::add);
        return feederRecipes;
    }

    public List<GeneModificationRecipe> getGeneModificationRecipes() {
        List<GeneModificationRecipe> geneModificationRecipes = Lists.newArrayList();
        Registry<CoatType> registry = this.registryAccess.registryOrThrow(FARegistries.COAT_TYPES);

        for (DNAItem dnaItem : DNAItem.DNA) {
            if (dnaItem instanceof AnimalDNAItem animalDNAItem) {
                if (animalDNAItem.getApplicableCoatTypes() != null) {
                    List<Holder<CoatType>> coatTypes = registry.getTag(animalDNAItem.getApplicableCoatTypes()).get().stream().toList();
                    boolean hasLegacy = false;
                    for (Holder<CoatType> coatTypeHolder : coatTypes) {
                        if (coatTypeHolder.is(FACoatTypeTags.LEGACY)) {
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

    public List<FuelRecipe> getInformationRecipes() {
        List<FuelRecipe> fuelRecipes = new ArrayList<>();
        FuelEntry.getFuel(this.registryAccess, FAFuelEntryTags.ARCHAEOLOGY_WORKBENCH).forEach((item, time) -> fuelRecipes.add(new FuelRecipe(new ItemStack(item), time)));
        return fuelRecipes;
    }

    public List<JewelRecovery> getJewelRecoveryRecipes() {
        List<JewelRecovery> jewelRecoveries = new ArrayList<>();
        this.registryAccess.registryOrThrow(FARegistries.JEWEL_RECOVERY).forEach(jewelRecoveries::add);
        return jewelRecoveries;
    }

    public List<RecipeHolder<CraftingRecipe>> createMagicConchRecipes() {
        List<RecipeHolder<CraftingRecipe>> recipes = new ArrayList<>();
        ItemStack magicConchFollow = new ItemStack(FAItems.MAGIC_CONCH.get());
        magicConchFollow.set(FADataComponents.COMMAND_TYPE.get(), FACommandTypes.FOLLOW);
        ItemStack magicConchStay = new ItemStack(FAItems.MAGIC_CONCH.get());
        magicConchStay.set(FADataComponents.COMMAND_TYPE.get(), FACommandTypes.STAY);
        ItemStack magicConchFreeMove = new ItemStack(FAItems.MAGIC_CONCH.get());
        magicConchFreeMove.set(FADataComponents.COMMAND_TYPE.get(), FACommandTypes.FREE_MOVE);

        recipes.add(new RecipeHolder<>(FossilsLegacyUtils.resource("magic_conch_stay"), new ShapelessRecipe("magic_conch", CraftingBookCategory.MISC, magicConchStay, NonNullList.of(Ingredient.EMPTY, Ingredient.of(magicConchFollow)))));
        recipes.add(new RecipeHolder<>(FossilsLegacyUtils.resource("magic_conch_free_move"), new ShapelessRecipe("magic_conch", CraftingBookCategory.MISC, magicConchFreeMove, NonNullList.of(Ingredient.EMPTY, Ingredient.of(magicConchStay)))));
        recipes.add(new RecipeHolder<>(FossilsLegacyUtils.resource("magic_conch_follow"), new ShapelessRecipe("magic_conch", CraftingBookCategory.MISC, magicConchFollow, NonNullList.of(Ingredient.EMPTY, Ingredient.of(magicConchFreeMove)))));

        return recipes;
    }

    public List<IJeiAnvilRecipe> createRepairRecipes(IVanillaRecipeFactory iVanillaRecipeFactory) {
        return getRepairData().flatMap(repairData -> this.getRepairRecipes(repairData, iVanillaRecipeFactory)).toList();
    }

    private Stream<RepairData> getRepairData() {
        return Stream.of(new RepairData(FATiers.SCARAB_GEM.getRepairIngredient(), new ItemStack(FAItems.SCARAB_GEM_SWORD.get()), new ItemStack(FAItems.SCARAB_GEM_PICKAXE.get()), new ItemStack(FAItems.SCARAB_GEM_AXE.get()), new ItemStack(FAItems.SCARAB_GEM_SHOVEL.get()), new ItemStack(FAItems.SCARAB_GEM_HOE.get())));
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
