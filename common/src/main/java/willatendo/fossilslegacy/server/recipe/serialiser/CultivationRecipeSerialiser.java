package willatendo.fossilslegacy.server.recipe.serialiser;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import willatendo.fossilslegacy.server.recipe.ArchaeologyRecipe;
import willatendo.fossilslegacy.server.recipe.CultivationRecipe;

public class CultivationRecipeSerialiser implements RecipeSerializer<CultivationRecipe> {
    private static final MapCodec<CultivationRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(archaeologyRecipe -> {
            return archaeologyRecipe.ingredient;
        }), ItemStack.STRICT_SINGLE_ITEM_CODEC.fieldOf("result").forGetter(archaeologyRecipe -> {
            return archaeologyRecipe.result;
        }), Codec.INT.fieldOf("time").orElse(6000).forGetter(archaeologyRecipe -> {
            return archaeologyRecipe.time;
        })).apply(instance, CultivationRecipe::new);
    });
    private static final StreamCodec<RegistryFriendlyByteBuf, CultivationRecipe> STREAM_CODEC = StreamCodec.of(CultivationRecipeSerialiser::toNetwork, CultivationRecipeSerialiser::fromNetwork);

    private static CultivationRecipe fromNetwork(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(registryFriendlyByteBuf);
        ItemStack result = ItemStack.STREAM_CODEC.decode(registryFriendlyByteBuf);
        int time = registryFriendlyByteBuf.readVarInt();
        return new CultivationRecipe(ingredient, result, time);
    }

    private static void toNetwork(RegistryFriendlyByteBuf registryFriendlyByteBuf, CultivationRecipe cultivationRecipe) {
        Ingredient.CONTENTS_STREAM_CODEC.encode(registryFriendlyByteBuf, cultivationRecipe.ingredient);
        ItemStack.STREAM_CODEC.encode(registryFriendlyByteBuf, cultivationRecipe.result);
        registryFriendlyByteBuf.writeVarInt(cultivationRecipe.time);
    }

    @Override
    public MapCodec<CultivationRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, CultivationRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}
