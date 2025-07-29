package willatendo.fossilslegacy.client.user_manual.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.client.user_manual.draw.SlotPlacer;
import willatendo.fossilslegacy.client.user_manual.draw.SpriteDrawer;

import java.util.List;

public class DrawFurnaceRecipe implements DrawRecipe {
    @Override
    public void draw(Level level, Recipe<?> recipe, SlotPlacer slotPlacer, SpriteDrawer spriteDrawer) {
        if (recipe instanceof SmeltingRecipe smeltingRecipe) {
            List<Ingredient> ingredients = recipe.placementInfo().ingredients();
            ItemStack output = smeltingRecipe.assemble(null, level.registryAccess());

            slotPlacer.place(1, 1, ingredients.getFirst());
            slotPlacer.place(1, 37, level.fuelValues().fuelItems().stream().map(ItemStack::new).toList());
            slotPlacer.place(61, 19, output);
        }
    }
}
