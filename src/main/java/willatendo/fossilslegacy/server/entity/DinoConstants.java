package willatendo.fossilslegacy.server.entity;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import willatendo.fossilslegacy.server.block.entity.FeederBlockEntity;

public class DinoConstants {
	public static final Ingredient HERBIVORE_FOOD = Ingredient.of(FeederBlockEntity.getPlantsFoodLevel().keySet().stream().toArray(ItemLike[]::new));
	public static final Ingredient CARNIVORE_FOOD = Ingredient.of(FeederBlockEntity.getMeatFoodLevel().keySet().stream().toArray(ItemLike[]::new));
}
