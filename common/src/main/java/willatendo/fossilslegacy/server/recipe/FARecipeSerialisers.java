package willatendo.fossilslegacy.server.recipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import willatendo.fossilslegacy.server.recipe.recipes.KeyCloningRecipe;
import willatendo.fossilslegacy.server.recipe.recipes.MagicConchRecipe;
import willatendo.fossilslegacy.server.recipe.serialiser.AnalyzationRecipeSerialiser;
import willatendo.fossilslegacy.server.recipe.serialiser.ArchaeologyRecipeSerialiser;
import willatendo.fossilslegacy.server.recipe.serialiser.CultivationRecipeSerialiser;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FARecipeSerialisers {
    public static final SimpleRegistry<RecipeSerializer<?>> RECIPE_SERIALIZERS = SimpleRegistry.create(Registries.RECIPE_SERIALIZER, FAUtils.ID);

    public static final SimpleHolder<AnalyzationRecipeSerialiser> ANALYZATION = RECIPE_SERIALIZERS.register("analyzation", AnalyzationRecipeSerialiser::new);
    public static final SimpleHolder<ArchaeologyRecipeSerialiser> ARCHAEOLOGY = RECIPE_SERIALIZERS.register("archaeology", ArchaeologyRecipeSerialiser::new);
    public static final SimpleHolder<CultivationRecipeSerialiser> CULTIVATION = RECIPE_SERIALIZERS.register("cultivation", CultivationRecipeSerialiser::new);
    public static final SimpleHolder<RecipeSerializer<KeyCloningRecipe>> KEY_CLONING = RECIPE_SERIALIZERS.register("key_cloning", () -> new CustomRecipe.Serializer<>(KeyCloningRecipe::new));
    public static final SimpleHolder<RecipeSerializer<MagicConchRecipe>> MAGIC_CONCH = RECIPE_SERIALIZERS.register("magic_conch", () -> new CustomRecipe.Serializer<>(MagicConchRecipe::new));
}
