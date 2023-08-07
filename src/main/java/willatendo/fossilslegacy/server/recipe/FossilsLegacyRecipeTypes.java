package willatendo.fossilslegacy.server.recipe;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.recipe.SimpleRecipeType;

public class FossilsLegacyRecipeTypes {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, FossilsLegacyUtils.ID);

	public static final RegistryObject<SimpleRecipeType<AnalyzationRecipe>> ANALYZATION = RECIPE_TYPES.register("analyzation", () -> new SimpleRecipeType<AnalyzationRecipe>());
	public static final RegistryObject<SimpleRecipeType<ArchaeologyRecipe>> ARCHAEOLOGY = RECIPE_TYPES.register("archaeology", () -> new SimpleRecipeType<ArchaeologyRecipe>());
	public static final RegistryObject<SimpleRecipeType<CultivationRecipe>> CULTIVATION = RECIPE_TYPES.register("cultivation", () -> new SimpleRecipeType<CultivationRecipe>());
}
