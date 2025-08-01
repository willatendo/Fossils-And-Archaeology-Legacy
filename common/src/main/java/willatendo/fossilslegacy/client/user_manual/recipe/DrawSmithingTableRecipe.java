package willatendo.fossilslegacy.client.user_manual.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.SmithingRecipeInput;
import net.minecraft.world.item.crafting.SmithingTransformRecipe;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.client.user_manual.draw.SlotPlacer;
import willatendo.fossilslegacy.client.user_manual.draw.SpriteDrawer;

import java.util.Optional;

public class DrawSmithingTableRecipe implements DrawRecipe {
    @Override
    public void draw(Level level, Recipe<?> recipe, SlotPlacer slotPlacer, SpriteDrawer spriteDrawer) {
        if (recipe instanceof SmithingTransformRecipe smithingTransformRecipe) {
            Optional<Ingredient> template = smithingTransformRecipe.templateIngredient();
            Optional<Ingredient> base = smithingTransformRecipe.baseIngredient();
            Optional<Ingredient> addition = smithingTransformRecipe.additionIngredient();
            ItemStack output = smithingTransformRecipe.assemble(new SmithingRecipeInput(new ItemStack(template.get().items().toList().getFirst()), new ItemStack(base.get().items().toList().getFirst()), new ItemStack(addition.get().items().toList().getFirst())), level.registryAccess());

            template.ifPresent(ingredient -> slotPlacer.place(33, 35, ingredient));
            base.ifPresent(ingredient -> slotPlacer.place(51, 35, ingredient));
            addition.ifPresent(ingredient -> slotPlacer.place(69, 35, ingredient));
            slotPlacer.place(123, 35, output);
        }
    }
}
