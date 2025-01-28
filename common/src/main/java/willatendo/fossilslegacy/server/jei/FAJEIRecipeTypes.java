package willatendo.fossilslegacy.server.jei;

import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.crafting.RecipeHolder;
import willatendo.fossilslegacy.server.ancient_axe_bonus.AncientAxeBonus;
import willatendo.fossilslegacy.server.jei.recipe.ArticulatedFossilRecipe;
import willatendo.fossilslegacy.server.jei.recipe.FuelRecipe;
import willatendo.fossilslegacy.server.jei.recipe.FeederRecipe;
import willatendo.fossilslegacy.server.jei.recipe.GeneModificationRecipe;
import willatendo.fossilslegacy.server.jewel_recovery.JewelRecovery;
import willatendo.fossilslegacy.server.recipe.FARecipeTypes;
import willatendo.fossilslegacy.server.recipe.recipes.AnalyzationRecipe;
import willatendo.fossilslegacy.server.recipe.recipes.ArchaeologyRecipe;
import willatendo.fossilslegacy.server.recipe.recipes.CultivationRecipe;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public final class FAJEIRecipeTypes {
    public static final RecipeType<RecipeHolder<AnalyzationRecipe>> ANALYZATION = RecipeType.createFromVanilla(FARecipeTypes.ANALYZATION.get());
    public static final RecipeType<AncientAxeBonus> ANCIENT_AXE_BONUS = RecipeType.create(FossilsLegacyUtils.ID, "ancient_axe_bonus", AncientAxeBonus.class);
    public static final RecipeType<RecipeHolder<ArchaeologyRecipe>> ARCHAEOLOGY = RecipeType.createFromVanilla(FARecipeTypes.ARCHAEOLOGY.get());
    public static final RecipeType<ArticulatedFossilRecipe> ARTICULATED_FOSSIL = RecipeType.create(FossilsLegacyUtils.ID, "articulated_fossil", ArticulatedFossilRecipe.class);
    public static final RecipeType<FuelRecipe> BIOMATTER = RecipeType.create(FossilsLegacyUtils.ID, "biomatter", FuelRecipe.class);
    public static final RecipeType<RecipeHolder<CultivationRecipe>> CULTIVATION = RecipeType.createFromVanilla(FARecipeTypes.CULTIVATION.get());
    public static final RecipeType<FeederRecipe> FEEDER = RecipeType.create(FossilsLegacyUtils.ID, "feeder", FeederRecipe.class);
    public static final RecipeType<GeneModificationRecipe> GENE_MODIFICATION = RecipeType.create(FossilsLegacyUtils.ID, "gene_modification", GeneModificationRecipe.class);
    public static final RecipeType<FuelRecipe> INFORMATION = RecipeType.create(FossilsLegacyUtils.ID, "information", FuelRecipe.class);
    public static final RecipeType<JewelRecovery> JEWEL_RECOVERY = RecipeType.create(FossilsLegacyUtils.ID, "jewel_recovery", JewelRecovery.class);
}
