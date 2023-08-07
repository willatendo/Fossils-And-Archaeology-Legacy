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
import willatendo.fossilslegacy.server.recipe.CultivationRecipe;

public class CultivationRecipeSerialiser implements RecipeSerializer<CultivationRecipe> {
	@Override
	public CultivationRecipe fromJson(ResourceLocation id, JsonObject jsonObject) {
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
		int time = GsonHelper.getAsInt(jsonObject, "time", 6000);
		return new CultivationRecipe(id, ingredient, result, time);
	}

	@Override
	public CultivationRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf friendlyByteBuf) {
		Ingredient ingredient = Ingredient.fromNetwork(friendlyByteBuf);
		ItemStack result = friendlyByteBuf.readItem();
		int time = friendlyByteBuf.readVarInt();
		return new CultivationRecipe(id, ingredient, result, time);
	}

	@Override
	public void toNetwork(FriendlyByteBuf friendlyByteBuf, CultivationRecipe cultivationRecipe) {
		cultivationRecipe.ingredient.toNetwork(friendlyByteBuf);
		friendlyByteBuf.writeItem(cultivationRecipe.result);
		friendlyByteBuf.writeVarInt(cultivationRecipe.time);
	}
}
