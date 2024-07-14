package willatendo.fossilslegacy.server.recipe.serialiser;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import willatendo.fossilslegacy.server.inventory.AnalyzationBookCategory;
import willatendo.fossilslegacy.server.recipe.AnalyzationRecipe;
import willatendo.fossilslegacy.server.recipe.AnalyzationRecipe.AnalyzationOutputs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnalyzationRecipeSerialiser implements RecipeSerializer<AnalyzationRecipe> {
    private static final Codec<AnalyzationOutputs> RESULTS_CODEC = RecordCodecBuilder.create(instance -> instance.group(ItemStack.STRICT_SINGLE_ITEM_CODEC.fieldOf("result").forGetter(analyzationOutputs -> analyzationOutputs.result), Codec.INT.fieldOf("weight").orElse(100).forGetter(analyzationOutputs -> analyzationOutputs.weight)).apply(instance, AnalyzationOutputs::new));
    private static final MapCodec<AnalyzationRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(AnalyzationBookCategory.CODEC.fieldOf("category").forGetter(analyzationRecipe -> analyzationRecipe.analyzationBookCategory), Codec.STRING.optionalFieldOf("group", "").forGetter(analyzationRecipe -> analyzationRecipe.group), Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(analyzationRecipe -> analyzationRecipe.ingredient), Codec.list(RESULTS_CODEC).fieldOf("results").forGetter(analyzationRecipe -> analyzationRecipe.results), Codec.INT.fieldOf("time").orElse(100).forGetter(analyzationRecipe -> analyzationRecipe.time)).apply(instance, AnalyzationRecipe::new));
    private static final StreamCodec<RegistryFriendlyByteBuf, AnalyzationRecipe> STREAM_CODEC = StreamCodec.of(AnalyzationRecipeSerialiser::toNetwork, AnalyzationRecipeSerialiser::fromNetwork);

    private static AnalyzationRecipe fromNetwork(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        AnalyzationBookCategory analyzationBookCategory = registryFriendlyByteBuf.readEnum(AnalyzationBookCategory.class);
        String group = registryFriendlyByteBuf.readUtf();
        Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(registryFriendlyByteBuf);
        List<AnalyzationOutputs> analyzationOutputs = new ArrayList<>();
        Map<ItemStack, Integer> map = registryFriendlyByteBuf.readMap(friendlyByteBuf -> ItemStack.STREAM_CODEC.decode((RegistryFriendlyByteBuf) friendlyByteBuf), friendlyByteBuf -> friendlyByteBuf.readVarInt());
        map.forEach((itemStack, weight) -> analyzationOutputs.add(new AnalyzationOutputs(itemStack, weight)));
        int time = registryFriendlyByteBuf.readVarInt();
        return new AnalyzationRecipe(analyzationBookCategory, group, ingredient, analyzationOutputs, time);
    }

    private static void toNetwork(RegistryFriendlyByteBuf registryFriendlyByteBuf, AnalyzationRecipe archaeologyRecipe) {
        registryFriendlyByteBuf.writeEnum(archaeologyRecipe.analyzationBookCategory);
        registryFriendlyByteBuf.writeUtf(archaeologyRecipe.group);
        Ingredient.CONTENTS_STREAM_CODEC.encode(registryFriendlyByteBuf, archaeologyRecipe.ingredient);
        registryFriendlyByteBuf.writeMap(archaeologyRecipe.getResultsAndWeight(), (friendlyByteBuf, itemStack) -> {
            ItemStack.STREAM_CODEC.encode((RegistryFriendlyByteBuf) friendlyByteBuf, itemStack);
        }, (friendlyByteBuf, weight) -> {
            friendlyByteBuf.writeVarInt(weight);
        });
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
