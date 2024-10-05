package willatendo.fossilslegacy.server.entity.util;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.server.block.entity.FeederBlockEntity;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

import java.util.List;

public class DinoUtils {
    public static final Ingredient HERBIVORE_FOOD = Ingredient.of(FeederBlockEntity.getPlantsFoodLevel().keySet().stream().toArray(ItemLike[]::new));
    public static final Ingredient CARNIVORE_FOOD = Ingredient.of(FeederBlockEntity.getMeatFoodLevel().keySet().stream().toArray(ItemLike[]::new));
    public static final Ingredient PISCIVORE_FOOD = Ingredient.of(Items.COD, Items.COOKED_COD, Items.SALMON, Items.COOKED_SALMON, Items.TROPICAL_FISH, FossilsLegacyItems.SIO_CHIU_LE.get(), FossilsLegacyItems.NAUTILUS.get());
    public static final Ingredient OMNIVORE_FOOD = DinoUtils.onivoreFood();

    private static Ingredient onivoreFood() {
        List<ItemLike> food = Lists.newArrayList();
        food.addAll(FeederBlockEntity.getPlantsFoodLevel().keySet());
        food.addAll(FeederBlockEntity.getMeatFoodLevel().keySet());
        return Ingredient.of(food.stream().toArray(ItemLike[]::new));
    }

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
