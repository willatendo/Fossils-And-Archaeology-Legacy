package willatendo.fossilslegacy.server.recipe.serialiser;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import willatendo.fossilslegacy.server.recipe.AnalyzationRecipe;
import willatendo.fossilslegacy.server.recipe.AnalyzationRecipe.AnalyzationOutputs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnalyzationRecipeSerialiser implements RecipeSerializer<AnalyzationRecipe> {
    private static final Codec<AnalyzationOutputs> RESULTS_CODEC = RecordCodecBuilder.create(instance -> instance.group(BuiltInRegistries.ITEM.byNameCodec().xmap(ItemStack::new, ItemStack::getItem).fieldOf("result").forGetter(analyzationRecipe -> analyzationRecipe.result), Codec.INT.fieldOf("weight").orElse(100).forGetter(analyzationRecipe -> analyzationRecipe.weight)).apply(instance, AnalyzationOutputs::new));

    public static final Codec<AnalyzationRecipe> CODEC = RecordCodecBuilder.create(instance -> instance.group(Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(analyzationRecipe -> analyzationRecipe.ingredient), Codec.list(RESULTS_CODEC).fieldOf("results").forGetter(analyzationRecipe -> analyzationRecipe.results), Codec.INT.fieldOf("time").orElse(100).forGetter(analyzationRecipe -> analyzationRecipe.time)).apply(instance, AnalyzationRecipe::new));

    @Override
    public AnalyzationRecipe fromNetwork(FriendlyByteBuf friendlyByteBuf) {
        Ingredient ingredient = Ingredient.fromNetwork(friendlyByteBuf);
        List<AnalyzationOutputs> analyzationOutputs = new ArrayList<>();
        Map<ItemStack, Integer> map = friendlyByteBuf.readMap(fbb -> fbb.readItem(), fbb -> fbb.readVarInt());
        map.forEach((itemStack, weight) -> analyzationOutputs.add(new AnalyzationOutputs(itemStack, weight)));
        int time = friendlyByteBuf.readVarInt();
        return new AnalyzationRecipe(ingredient, analyzationOutputs, time);
    }

    @Override
    public void toNetwork(FriendlyByteBuf friendlyByteBuf, AnalyzationRecipe archaeologyRecipe) {
        archaeologyRecipe.ingredient.toNetwork(friendlyByteBuf);
        friendlyByteBuf.writeMap(archaeologyRecipe.getResultsAndWeight(), (fbb, itemStack) -> {
            fbb.writeItem(itemStack);
        }, (fbb, weight) -> {
            fbb.writeVarInt(weight);
        });
        friendlyByteBuf.writeVarInt(archaeologyRecipe.time);
    }

    @Override
    public Codec<AnalyzationRecipe> codec() {
        return CODEC;
    }
}
