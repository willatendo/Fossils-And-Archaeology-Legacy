package willatendo.fossilslegacy.server.recipe.serialiser;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import willatendo.fossilslegacy.server.recipe.ArchaeologyRecipe;

public class ArchaeologyRecipeSerialiser implements RecipeSerializer<ArchaeologyRecipe> {
	public static final Codec<ArchaeologyRecipe> CODEC = RecordCodecBuilder.create(instance -> instance.group(Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(archaeologyRecipe -> archaeologyRecipe.ingredient), BuiltInRegistries.ITEM.byNameCodec().xmap(ItemStack::new, ItemStack::getItem).fieldOf("result").forGetter(archaeologyRecipe -> archaeologyRecipe.result), Codec.INT.fieldOf("time").orElse(100).forGetter(archaeologyRecipe -> archaeologyRecipe.time)).apply(instance, ArchaeologyRecipe::new));

	@Override
	public ArchaeologyRecipe fromNetwork(FriendlyByteBuf friendlyByteBuf) {
		Ingredient ingredient = Ingredient.fromNetwork(friendlyByteBuf);
		ItemStack result = friendlyByteBuf.readItem();
		int time = friendlyByteBuf.readVarInt();
		return new ArchaeologyRecipe(ingredient, result, time);
	}

	@Override
	public void toNetwork(FriendlyByteBuf friendlyByteBuf, ArchaeologyRecipe archaeologyRecipe) {
		archaeologyRecipe.ingredient.toNetwork(friendlyByteBuf);
		friendlyByteBuf.writeItem(archaeologyRecipe.result);
		friendlyByteBuf.writeVarInt(archaeologyRecipe.time);
	}

	@Override
	public Codec<ArchaeologyRecipe> codec() {
		return CODEC;
	}
}
