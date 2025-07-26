package willatendo.fossilslegacy.client.user_manual.recipe.type;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.client.user_manual.recipe.DrawRecipe;

public record RecipeTypeDrawInformationHolder(ResourceLocation texture, int width, int height, int xOffset, int yOffset, DrawRecipe drawRecipe, Block... containers) {
    public static final RecipeTypeDrawInformationHolder EMPTY = new RecipeTypeDrawInformationHolder(null, 0, 0, 0, 0, (level, recipe, slotPlacer, spriteDrawer) -> {
    });
}
