package willatendo.fossilslegacy.server.recipe.serialiser;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import willatendo.fossilslegacy.server.analyzer_result.AnalyzerResult;
import willatendo.fossilslegacy.server.menu.categories.AnalyzationBookCategory;
import willatendo.fossilslegacy.server.recipe.recipes.AnalyzationRecipe;
import willatendo.fossilslegacy.server.registry.FARegistries;

public class AnalyzationRecipeSerialiser implements RecipeSerializer<AnalyzationRecipe> {
    private static final MapCodec<AnalyzationRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(AnalyzationBookCategory.CODEC.fieldOf("category").forGetter(analyzationRecipe -> analyzationRecipe.analyzationBookCategory), Codec.STRING.optionalFieldOf("group", "").forGetter(analyzationRecipe -> analyzationRecipe.group), Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(analyzationRecipe -> analyzationRecipe.ingredient), TagKey.codec(FARegistries.ANALYZER_RESULT).fieldOf("results").forGetter(analyzationRecipe -> analyzationRecipe.results), Codec.INT.fieldOf("time").orElse(100).forGetter(analyzationRecipe -> analyzationRecipe.time)).apply(instance, AnalyzationRecipe::new));
    private static final StreamCodec<RegistryFriendlyByteBuf, AnalyzationRecipe> STREAM_CODEC = StreamCodec.of(AnalyzationRecipeSerialiser::toNetwork, AnalyzationRecipeSerialiser::fromNetwork);

    private static AnalyzationRecipe fromNetwork(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        AnalyzationBookCategory analyzationBookCategory = registryFriendlyByteBuf.readEnum(AnalyzationBookCategory.class);
        String group = registryFriendlyByteBuf.readUtf();
        Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(registryFriendlyByteBuf);
        TagKey<AnalyzerResult> analyzerResults = TagKey.create(FARegistries.ANALYZER_RESULT, registryFriendlyByteBuf.readResourceLocation());
        int time = registryFriendlyByteBuf.readVarInt();
        return new AnalyzationRecipe(analyzationBookCategory, group, ingredient, analyzerResults, time);
    }

    private static void toNetwork(RegistryFriendlyByteBuf registryFriendlyByteBuf, AnalyzationRecipe archaeologyRecipe) {
        registryFriendlyByteBuf.writeEnum(archaeologyRecipe.analyzationBookCategory);
        registryFriendlyByteBuf.writeUtf(archaeologyRecipe.group);
        Ingredient.CONTENTS_STREAM_CODEC.encode(registryFriendlyByteBuf, archaeologyRecipe.ingredient);
        registryFriendlyByteBuf.writeResourceLocation(archaeologyRecipe.results.location());
        registryFriendlyByteBuf.writeVarInt(archaeologyRecipe.time);
    }

    @Override
    public MapCodec<AnalyzationRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, AnalyzationRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}
