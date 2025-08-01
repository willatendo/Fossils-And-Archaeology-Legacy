package willatendo.fossilslegacy.client.user_manual.recipe;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.client.user_manual.draw.SlotPlacer;
import willatendo.fossilslegacy.client.user_manual.draw.SpriteDrawer;
import willatendo.fossilslegacy.server.fuel.FuelEntry;
import willatendo.fossilslegacy.server.recipe.recipes.ArchaeologyRecipe;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.List;

public class DrawArchaeologyRecipe implements DrawRecipe {
    @Override
    public void draw(Level level, Recipe<?> recipe, SlotPlacer slotPlacer, SpriteDrawer spriteDrawer) {
        if (recipe instanceof ArchaeologyRecipe archaeologyRecipe) {
            List<Ingredient> ingredients = recipe.placementInfo().ingredients();
            ItemStack output = archaeologyRecipe.assemble(null, level.registryAccess());
            List<FuelEntry> fuelEntries = level.registryAccess().lookupOrThrow(FARegistries.FUEL_ENTRY).get(archaeologyRecipe.requiredFuels).get().stream().map(fuelEntryHolder -> fuelEntryHolder.value()).toList();

            slotPlacer.place(49, 20, ingredients.getFirst());
            slotPlacer.place(80, 54, fuelEntries.stream().map(fuelEntry -> new ItemStack(BuiltInRegistries.ITEM.get(fuelEntry.fuel()).get().value())).toList());
            slotPlacer.place(111, 20, output);
        }
    }
}
