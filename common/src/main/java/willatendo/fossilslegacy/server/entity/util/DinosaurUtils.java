package willatendo.fossilslegacy.server.entity.util;

import net.minecraft.world.item.crafting.Ingredient;
import willatendo.fossilslegacy.server.tags.FAItemTags;

public class DinosaurUtils {
    public static final Ingredient HERBIVORE_FOOD = Ingredient.of(FAItemTags.HERBIVORE_FOODS);
    public static final Ingredient CARNIVORE_FOOD = Ingredient.of(FAItemTags.CARNIVORE_FOODS);
    public static final Ingredient PISCIVORE_FOOD = Ingredient.of(FAItemTags.PISCIVORE_FOODS);
    public static final Ingredient OMNIVORE_FOOD = Ingredient.of(FAItemTags.OMNIVORE_FOODS);

    public static float[] getStepHeights(int growthStages, float minStepHeight, float maxStepHeight) {
        float[] stepHeights = new float[growthStages + 1];
        float diff = maxStepHeight - minStepHeight;
        float change = diff / growthStages;
        for (int i = 0; i < (growthStages + 1); i++) {
            stepHeights[i] = minStepHeight + (change * ((float) i));
        }
        return stepHeights;
    }
}
