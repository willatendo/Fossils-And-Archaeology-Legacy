package willatendo.fossilslegacy.client.user_manual.recipe.special;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.client.user_manual.draw.SlotPlacer;
import willatendo.fossilslegacy.client.user_manual.draw.SpriteDrawer;

public interface DrawSpecialRecipe {
    void draw(ItemStack input, Level level, SlotPlacer slotPlacer, SpriteDrawer spriteDrawer);
}
