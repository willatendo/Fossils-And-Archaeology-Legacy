package willatendo.fossilslegacy.server.recipe.serialiser;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import willatendo.fossilslegacy.server.menu.categories.CultivationBookCategory;
import willatendo.fossilslegacy.server.recipe.recipes.CultivationRecipe;

public class CultivationRecipeSerialiser implements RecipeSerializer<CultivationRecipe> {
    private static final MapCodec<CultivationRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(CultivationBookCategory.CODEC.fieldOf("category").orElse(CultivationBookCategory.MISC).forGetter(cultivationRecipe -> cultivationRecipe.cultivationBookCategory), Codec.STRING.optionalFieldOf("group", "").forGetter(cultivationRecipe -> cultivationRecipe.group), Ingredient.CODEC.fieldOf("ingredient").forGetter(archaeologyRecipe -> archaeologyRecipe.ingredient), ItemStack.STRICT_SINGLE_ITEM_CODEC.fieldOf("result").forGetter(archaeologyRecipe -> archaeologyRecipe.result), Codec.INT.fieldOf("time").orElse(6000).forGetter(archaeologyRecipe -> archaeologyRecipe.time)).apply(instance, CultivationRecipe::new));
    private static final StreamCodec<RegistryFriendlyByteBuf, CultivationRecipe> STREAM_CODEC = StreamCodec.of(CultivationRecipeSerialiser::toNetwork, CultivationRecipeSerialiser::fromNetwork);

    private static CultivationRecipe fromNetwork(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        CultivationBookCategory cultivationBookCategory = registryFriendlyByteBuf.readEnum(CultivationBookCategory.class);
        String group = registryFriendlyByteBuf.readUtf();
        Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(registryFriendlyByteBuf);
        ItemStack result = ItemStack.STREAM_CODEC.decode(registryFriendlyByteBuf);
        int time = registryFriendlyByteBuf.readVarInt();
        return new CultivationRecipe(cultivationBookCategory, group, ingredient, result, time);
    }

    private static void toNetwork(RegistryFriendlyByteBuf registryFriendlyByteBuf, CultivationRecipe cultivationRecipe) {
        registryFriendlyByteBuf.writeEnum(cultivationRecipe.cultivationBookCategory);
        registryFriendlyByteBuf.writeUtf(cultivationRecipe.group);
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
