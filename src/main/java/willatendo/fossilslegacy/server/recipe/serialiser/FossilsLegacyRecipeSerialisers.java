package willatendo.fossilslegacy.server.recipe.serialiser;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import willatendo.fossilslegacy.server.recipe.MagicConchRecipe;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyRecipeSerialisers {
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, FossilsLegacyUtils.ID);

	public static final RegistryObject<AnalyzationRecipeSerialiser> ANALYZATION = RECIPE_SERIALIZERS.register("analyzation", () -> new AnalyzationRecipeSerialiser());
	public static final RegistryObject<ArchaeologyRecipeSerialiser> ARCHAEOLOGY = RECIPE_SERIALIZERS.register("archaeology", () -> new ArchaeologyRecipeSerialiser());
	public static final RegistryObject<CultivationRecipeSerialiser> CULTIVATION = RECIPE_SERIALIZERS.register("cultivation", () -> new CultivationRecipeSerialiser());
	public static final RegistryObject<RecipeSerializer<MagicConchRecipe>> MAGIC_CONCH = RECIPE_SERIALIZERS.register("magic_conch", () -> new SimpleCraftingRecipeSerializer<>(MagicConchRecipe::new));
}
