package willatendo.fossilslegacy.server.recipe.serialiser;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import willatendo.fossilslegacy.server.recipe.MagicConchRecipe;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.RegistryHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyRecipeSerialisers {
	public static final SimpleRegistry<RecipeSerializer<?>> RECIPE_SERIALIZERS = SimpleRegistry.create(BuiltInRegistries.RECIPE_SERIALIZER, FossilsLegacyUtils.ID);

	public static final RegistryHolder<AnalyzationRecipeSerialiser> ANALYZATION = RECIPE_SERIALIZERS.register("analyzation", () -> new AnalyzationRecipeSerialiser());
	public static final RegistryHolder<ArchaeologyRecipeSerialiser> ARCHAEOLOGY = RECIPE_SERIALIZERS.register("archaeology", () -> new ArchaeologyRecipeSerialiser());
	public static final RegistryHolder<CultivationRecipeSerialiser> CULTIVATION = RECIPE_SERIALIZERS.register("cultivation", () -> new CultivationRecipeSerialiser());
	public static final RegistryHolder<RecipeSerializer<MagicConchRecipe>> MAGIC_CONCH = RECIPE_SERIALIZERS.register("magic_conch", () -> new SimpleCraftingRecipeSerializer<>(MagicConchRecipe::new));

	public static void init() {
	}
}
