package fossilslegacy.server.recipe;

import fossilslegacy.server.block.FossilsLegacyBlocks;
import fossilslegacy.server.recipe.serialiser.FossilsLegacyRecipeSerialisers;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class CultivationRecipe implements Recipe<Container> {
	public final ResourceLocation id;
	public final Ingredient ingredient;
	public final ItemStack result;
	public final int time;

	public CultivationRecipe(ResourceLocation id, Ingredient ingredient, ItemStack result, int time) {
		this.id = id;
		this.ingredient = ingredient;
		this.result = result;
		this.time = time;
	}

	@Override
	public boolean matches(Container container, Level level) {
		return this.ingredient.test(container.getItem(0));
	}

	@Override
	public ItemStack assemble(Container container, RegistryAccess registryAccess) {
		return this.result.copy();
	}

	@Override
	public boolean canCraftInDimensions(int x, int y) {
		return true;
	}

	@Override
	public ItemStack getResultItem(RegistryAccess registryAccess) {
		return this.result;
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public ItemStack getToastSymbol() {
		return FossilsLegacyBlocks.CULTIVATOR.get().asItem().getDefaultInstance();
	}

	public int getTime() {
		return this.time;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return FossilsLegacyRecipeSerialisers.CULTIVATION.get();
	}

	@Override
	public RecipeType<?> getType() {
		return FossilsLegacyRecipeTypes.CULTIVATION.get();
	}
}
