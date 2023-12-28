package willatendo.fossilslegacy.server.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FossilsLegacyFoods {
	public static final FoodProperties RAW_DINOSAUR_MEAT = new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).meat().build();
	public static final FoodProperties COOKED_DINOSAUR_MEAT = new FoodProperties.Builder().nutrition(8).saturationMod(0.8F).meat().build();
	public static final FoodProperties SIO_CHIU_LE = new FoodProperties.Builder().nutrition(8).saturationMod(2.0F).build();
	public static final FoodProperties RAW_CHICKEN_SOUP = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).build();
	public static final FoodProperties COOKED_CHICKEN_SOUP = new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).build();
	public static final FoodProperties CHICKEN_ESSENCE = new FoodProperties.Builder().nutrition(10).saturationMod(0.0F).build();
}
