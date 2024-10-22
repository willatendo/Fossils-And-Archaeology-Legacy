package willatendo.fossilslegacy.server.entity.util;

import net.minecraft.world.item.crafting.Ingredient;
import willatendo.fossilslegacy.server.tags.FossilsLegacyItemTags;

public class DinoUtils {
    public static final Ingredient HERBIVORE_FOOD = Ingredient.of(FossilsLegacyItemTags.HERBIVORE_FOODS);
    public static final Ingredient CARNIVORE_FOOD = Ingredient.of(FossilsLegacyItemTags.CARNIVORE_FOODS);
    public static final Ingredient PISCIVORE_FOOD = Ingredient.of(FossilsLegacyItemTags.PISCIVORE_FOODS);
    public static final Ingredient OMNIVORE_FOOD = Ingredient.of(FossilsLegacyItemTags.OMNIVORE_FOODS);

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
