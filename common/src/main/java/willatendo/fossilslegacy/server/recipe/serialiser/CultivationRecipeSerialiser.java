package willatendo.fossilslegacy.server.recipe.serialiser;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import willatendo.fossilslegacy.server.recipe.CultivationRecipe;

public class CultivationRecipeSerialiser implements RecipeSerializer<CultivationRecipe> {
	public static final Codec<CultivationRecipe> CODEC = RecordCodecBuilder.create(instance -> instance.group(Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(cultivationRecipe -> cultivationRecipe.ingredient), BuiltInRegistries.ITEM.byNameCodec().xmap(ItemStack::new, ItemStack::getItem).fieldOf("result").forGetter(cultivationRecipe -> cultivationRecipe.result), Codec.INT.fieldOf("time").orElse(100).forGetter(cultivationRecipe -> cultivationRecipe.time)).apply(instance, CultivationRecipe::new));

	@Override
	public CultivationRecipe fromNetwork(FriendlyByteBuf friendlyByteBuf) {
		Ingredient ingredient = Ingredient.fromNetwork(friendlyByteBuf);
		ItemStack result = friendlyByteBuf.readItem();
		int time = friendlyByteBuf.readVarInt();
		return new CultivationRecipe(ingredient, result, time);
	}

	@Override
	public void toNetwork(FriendlyByteBuf friendlyByteBuf, CultivationRecipe cultivationRecipe) {
		cultivationRecipe.ingredient.toNetwork(friendlyByteBuf);
		friendlyByteBuf.writeItem(cultivationRecipe.result);
		friendlyByteBuf.writeVarInt(cultivationRecipe.time);
	}

	@Override
	public Codec<CultivationRecipe> codec() {
		return CODEC;
	}
}
