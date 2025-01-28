package willatendo.fossilslegacy.client;

import net.minecraft.client.RecipeBookCategories;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.item.FAItems;

public final class FARecipeBookCategories {
    public static final RecipeBookCategories ANALYZATION_SEARCH = FossilsModloaderHelper.INSTANCE.createRecipeBookCategory("analyzation_search", new ItemStack(Items.COMPASS));
    public static final RecipeBookCategories ANALYZATION_MISC = FossilsModloaderHelper.INSTANCE.createRecipeBookCategory("analyzation_misc", new ItemStack(FAItems.VELOCIRAPTOR_DNA.get()));
    public static final RecipeBookCategories ARCHAEOLOGY_WORKBENCH_SEARCH = FossilsModloaderHelper.INSTANCE.createRecipeBookCategory("archaeology_search", new ItemStack(Items.COMPASS));
    public static final RecipeBookCategories ARCHAEOLOGY_WORKBENCH_RESTORE = FossilsModloaderHelper.INSTANCE.createRecipeBookCategory("archaeology_restore", new ItemStack(FAItems.ANCIENT_SHOVEL_ARTIFACT.get()));
    public static final RecipeBookCategories ARCHAEOLOGY_WORKBENCH_REPAIR = FossilsModloaderHelper.INSTANCE.createRecipeBookCategory("archaeology_repair", new ItemStack(FAItems.GOLDEN_JAVELIN.get()));
    public static final RecipeBookCategories ARCHAEOLOGY_WORKBENCH_MISC = FossilsModloaderHelper.INSTANCE.createRecipeBookCategory("archaeology_misc", new ItemStack(FAItems.RELIC_SCRAP.get()));
    public static final RecipeBookCategories CULTIVATION_SEARCH = FossilsModloaderHelper.INSTANCE.createRecipeBookCategory("cultivation_search", new ItemStack(Items.COMPASS));
    public static final RecipeBookCategories CULTIVATION_EGGS = FossilsModloaderHelper.INSTANCE.createRecipeBookCategory("cultivation_eggs", new ItemStack(FAItems.TYRANNOSAURUS_EGG.get()));
    public static final RecipeBookCategories CULTIVATION_PLANTS = FossilsModloaderHelper.INSTANCE.createRecipeBookCategory("cultivation_plants", new ItemStack(BuiltInRegistries.ITEM.get(FAItems.LEPIDODENDRON_SAPLING)));
    public static final RecipeBookCategories CULTIVATION_MISC = FossilsModloaderHelper.INSTANCE.createRecipeBookCategory("cultivation_misc", new ItemStack(FAItems.TRICERATOPS_DNA.get()));
}
