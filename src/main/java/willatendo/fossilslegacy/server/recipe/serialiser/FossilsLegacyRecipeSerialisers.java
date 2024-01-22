package willatendo.fossilslegacy.server.recipe.serialiser;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import willatendo.fossilslegacy.server.recipe.MagicConchRecipe;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyRecipeSerialisers {
	public static final SimpleRegistry<RecipeSerializer<?>> RECIPE_SERIALIZERS = SimpleRegistry.create(Registries.RECIPE_SERIALIZER, FossilsLegacyUtils.ID);

	public static final SimpleHolder<AnalyzationRecipeSerialiser> ANALYZATION = RECIPE_SERIALIZERS.register("analyzation", () -> new AnalyzationRecipeSerialiser());
	public static final SimpleHolder<ArchaeologyRecipeSerialiser> ARCHAEOLOGY = RECIPE_SERIALIZERS.register("archaeology", () -> new ArchaeologyRecipeSerialiser());
	public static final SimpleHolder<CultivationRecipeSerialiser> CULTIVATION = RECIPE_SERIALIZERS.register("cultivation", () -> new CultivationRecipeSerialiser());
	public static final SimpleHolder<RecipeSerializer<MagicConchRecipe>> MAGIC_CONCH = RECIPE_SERIALIZERS.register("magic_conch", () -> new SimpleCraftingRecipeSerializer<>(MagicConchRecipe::new));

	public static void init() {
		RECIPE_SERIALIZERS.register();
	}
}
