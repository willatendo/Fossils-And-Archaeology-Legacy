package willatendo.fossilslegacy.client.user_manual.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.client.user_manual.draw.SlotPlacer;
import willatendo.fossilslegacy.client.user_manual.draw.SpriteDrawer;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;
import java.util.Optional;

public class DrawCraftingTableRecipe implements DrawRecipe {
    private static final ResourceLocation SHAPELESS = FAUtils.resource("container/user_manual/shapeless");

    @Override
    public void draw(Level level, Recipe<?> recipe, SlotPlacer slotPlacer, SpriteDrawer spriteDrawer) {
        HolderLookup.Provider registries = level.registryAccess();
        ItemStack output;
        if (recipe instanceof ShapedRecipe shapedRecipe) {
            List<Optional<Ingredient>> ingredients = shapedRecipe.getIngredients();
            output = recipe.assemble(null, registries);
            for (int x = 0; x < shapedRecipe.getWidth(); x++) {
                for (int y = 0; y < shapedRecipe.getHeight(); y++) {
                    int index = x + (y * shapedRecipe.getWidth());
                    if (index < ingredients.size()) {
                        Optional<Ingredient> ingredient = ingredients.get(index);
                        if (ingredient.isPresent()) {
                            slotPlacer.place(30 + x * 18, 17 + y * 18, ingredient.get());
                        }
                    }
                }
            }

            slotPlacer.place(124, 35, output);
        }
        List<Ingredient> ingredients = recipe.placementInfo().ingredients();
        if (recipe instanceof ShapelessRecipe) {
            output = recipe.assemble(null, registries);
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    int index = x + (y * 3);
                    if (index < ingredients.size()) {
                        slotPlacer.place(30 + x * 18, 17 + y * 18, ingredients.get(index));
                    }
                }
            }

            slotPlacer.place(124, 35, output);

            spriteDrawer.draw(93, 16, 16, 16, 16, 16, SHAPELESS);
        }
    }
}
