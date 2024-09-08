package willatendo.fossilslegacy.client;

import net.minecraft.client.RecipeBookCategories;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

public class FossilsLegacyRecipeBookCategories {
    public static final RecipeBookCategories ANALYZATION_SEARCH = FossilsModloaderHelper.INSTANCE.createRecipeBookCategory("analyzation_search", new ItemStack(Items.COMPASS));
    public static final RecipeBookCategories ANALYZATION_MISC = FossilsModloaderHelper.INSTANCE.createRecipeBookCategory("analyzation_misc", new ItemStack(FossilsLegacyItems.VELOCIRAPTOR_DNA.get()));
    public static final RecipeBookCategories ARCHAEOLOGY_WORKBENCH_SEARCH = FossilsModloaderHelper.INSTANCE.createRecipeBookCategory("archaeology_search", new ItemStack(Items.COMPASS));
    public static final RecipeBookCategories ARCHAEOLOGY_WORKBENCH_RESTORE = FossilsModloaderHelper.INSTANCE.createRecipeBookCategory("archaeology_restore", new ItemStack(FossilsLegacyItems.ANCIENT_SHOVEL_ARTIFACT.get()));
    public static final RecipeBookCategories ARCHAEOLOGY_WORKBENCH_REPAIR = FossilsModloaderHelper.INSTANCE.createRecipeBookCategory("archaeology_repair", new ItemStack(FossilsLegacyItems.GOLDEN_JAVELIN.get()));
    public static final RecipeBookCategories ARCHAEOLOGY_WORKBENCH_MISC = FossilsModloaderHelper.INSTANCE.createRecipeBookCategory("archaeology_misc", new ItemStack(FossilsLegacyItems.RELIC_SCRAP.get()));
    public static final RecipeBookCategories CULTIVATION_SEARCH = FossilsModloaderHelper.INSTANCE.createRecipeBookCategory("cultivation_search", new ItemStack(Items.COMPASS));
    public static final RecipeBookCategories CULTIVATION_EGGS = FossilsModloaderHelper.INSTANCE.createRecipeBookCategory("cultivation_eggs", new ItemStack(FossilsLegacyItems.TYRANNOSAURUS_EGG.get()));
    public static final RecipeBookCategories CULTIVATION_PLANTS = FossilsModloaderHelper.INSTANCE.createRecipeBookCategory("cultivation_plants", new ItemStack(BuiltInRegistries.ITEM.get(FossilsLegacyItems.LEPIDODENDRON_SAPLING)));
    public static final RecipeBookCategories CULTIVATION_MISC = FossilsModloaderHelper.INSTANCE.createRecipeBookCategory("cultivation_misc", new ItemStack(FossilsLegacyItems.TRICERATOPS_DNA.get()));
}
