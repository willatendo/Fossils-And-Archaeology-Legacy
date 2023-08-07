package willatendo.fossilslegacy.server.recipe.serialiser;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraftforge.registries.ForgeRegistries;
import willatendo.fossilslegacy.server.recipe.ArchaeologyRecipe;

public class ArchaeologyRecipeSerialiser implements RecipeSerializer<ArchaeologyRecipe> {
	@Override
	public ArchaeologyRecipe fromJson(ResourceLocation id, JsonObject jsonObject) {
		JsonElement jsonelement = (JsonElement) (GsonHelper.isArrayNode(jsonObject, "ingredient") ? GsonHelper.getAsJsonArray(jsonObject, "ingredient") : GsonHelper.getAsJsonObject(jsonObject, "ingredient"));
		Ingredient ingredient = Ingredient.fromJson(jsonelement);
		ItemStack result;
		if (jsonObject.get("result").isJsonObject()) {
			result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "result"));
		} else {
			String resultName = GsonHelper.getAsString(jsonObject, "result");
			ResourceLocation resultId = new ResourceLocation(resultName);
			result = new ItemStack(ForgeRegistries.ITEMS.getValue(resultId));
		}
		int time = GsonHelper.getAsInt(jsonObject, "time", 3000);
		return new ArchaeologyRecipe(id, ingredient, result, time);
	}

	@Override
	public ArchaeologyRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf friendlyByteBuf) {
		Ingredient ingredient = Ingredient.fromNetwork(friendlyByteBuf);
		ItemStack result = friendlyByteBuf.readItem();
		int time = friendlyByteBuf.readVarInt();
		return new ArchaeologyRecipe(id, ingredient, result, time);
	}

	@Override
	public void toNetwork(FriendlyByteBuf friendlyByteBuf, ArchaeologyRecipe archaeologyRecipe) {
		archaeologyRecipe.ingredient.toNetwork(friendlyByteBuf);
		friendlyByteBuf.writeItem(archaeologyRecipe.result);
		friendlyByteBuf.writeVarInt(archaeologyRecipe.time);
	}
}
