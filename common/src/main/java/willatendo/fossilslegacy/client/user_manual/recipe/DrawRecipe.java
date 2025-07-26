package willatendo.fossilslegacy.client.user_manual.recipe;

import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.client.user_manual.draw.SlotPlacer;
import willatendo.fossilslegacy.client.user_manual.draw.SpriteDrawer;

public interface DrawRecipe {
    void draw(Level level, Recipe<?> recipe, SlotPlacer slotPlacer, SpriteDrawer spriteDrawer);
}
