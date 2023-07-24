package fossilslegacy.server.recipe.serialiser;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import fossilslegacy.server.recipe.AnalyzationRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraftforge.registries.ForgeRegistries;

public class AnalyzationRecipeSerialiser implements RecipeSerializer<AnalyzationRecipe> {
	@Override
	public AnalyzationRecipe fromJson(ResourceLocation id, JsonObject jsonObject) {
		JsonElement jsonelement = (JsonElement) (GsonHelper.isArrayNode(jsonObject, "ingredient") ? GsonHelper.getAsJsonArray(jsonObject, "ingredient") : GsonHelper.getAsJsonObject(jsonObject, "ingredient"));
		Ingredient ingredient = Ingredient.fromJson(jsonelement);
		List<ItemStack> results = new ArrayList<>();
		List<Integer> weights = new ArrayList<>();

		JsonArray resultsArray = jsonObject.get("results").getAsJsonArray();
		for (int i = 0; i < resultsArray.size(); i++) {
			JsonObject objects = resultsArray.get(i).getAsJsonObject();
			if (objects.get("result").isJsonObject()) {
				results.add(ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "result")));
			} else {
				String resultName = GsonHelper.getAsString(objects, "result");
				ResourceLocation resultId = new ResourceLocation(resultName);
				results.add(new ItemStack(ForgeRegistries.ITEMS.getValue(resultId)));
			}

			weights.add((int) objects.get("weight").getAsFloat());
		}

		int time = GsonHelper.getAsInt(jsonObject, "time", 100);
		return new AnalyzationRecipe(id, ingredient, results, weights, time);
	}

	@Override
	public AnalyzationRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf friendlyByteBuf) {
		Ingredient ingredient = Ingredient.fromNetwork(friendlyByteBuf);
		List<ItemStack> results = new ArrayList<>();
		List<Integer> weights = new ArrayList<>();
		for (int i = 0; i < friendlyByteBuf.readVarInt(); i++) {
			results.add(friendlyByteBuf.readItem());
			weights.add(friendlyByteBuf.readVarInt());
		}
		int time = friendlyByteBuf.readVarInt();
		return new AnalyzationRecipe(id, ingredient, results, weights, time);
	}

	@Override
	public void toNetwork(FriendlyByteBuf friendlyByteBuf, AnalyzationRecipe archaeologyRecipe) {
		archaeologyRecipe.ingredient.toNetwork(friendlyByteBuf);
		friendlyByteBuf.writeVarInt(archaeologyRecipe.results.size());
		for (ItemStack itemStack : archaeologyRecipe.results) {
			friendlyByteBuf.writeItem(itemStack);
		}
		for (int weight : archaeologyRecipe.weights) {
			friendlyByteBuf.writeVarInt(weight);
		}
		friendlyByteBuf.writeVarInt(archaeologyRecipe.time);
	}
}
