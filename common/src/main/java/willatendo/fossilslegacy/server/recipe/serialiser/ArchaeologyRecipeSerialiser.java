package willatendo.fossilslegacy.server.recipe.serialiser;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import willatendo.fossilslegacy.server.recipe.ArchaeologyRecipe;

public class ArchaeologyRecipeSerialiser implements RecipeSerializer<ArchaeologyRecipe> {
    private static final MapCodec<ArchaeologyRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(archaeologyRecipe -> {
            return archaeologyRecipe.ingredient;
        }), ItemStack.STRICT_SINGLE_ITEM_CODEC.fieldOf("result").forGetter(archaeologyRecipe -> {
            return archaeologyRecipe.result;
        }), Codec.INT.fieldOf("time").orElse(100).forGetter(archaeologyRecipe -> {
            return archaeologyRecipe.time;
        })).apply(instance, ArchaeologyRecipe::new);
    });
    private static final StreamCodec<RegistryFriendlyByteBuf, ArchaeologyRecipe> STREAM_CODEC = StreamCodec.of(ArchaeologyRecipeSerialiser::toNetwork, ArchaeologyRecipeSerialiser::fromNetwork);

    private static ArchaeologyRecipe fromNetwork(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(registryFriendlyByteBuf);
        ItemStack result = ItemStack.STREAM_CODEC.decode(registryFriendlyByteBuf);
        int time = registryFriendlyByteBuf.readVarInt();
        return new ArchaeologyRecipe(ingredient, result, time);
    }

    private static void toNetwork(RegistryFriendlyByteBuf registryFriendlyByteBuf, ArchaeologyRecipe archaeologyRecipe) {
        Ingredient.CONTENTS_STREAM_CODEC.encode(registryFriendlyByteBuf, archaeologyRecipe.ingredient);
        ItemStack.STREAM_CODEC.encode(registryFriendlyByteBuf, archaeologyRecipe.result);
        registryFriendlyByteBuf.writeVarInt(archaeologyRecipe.time);
    }

    @Override
    public MapCodec<ArchaeologyRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, ArchaeologyRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}
