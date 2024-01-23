package willatendo.fossilslegacy.server.entity;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import willatendo.fossilslegacy.server.block.entity.FeederBlockEntity;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

public class DinoConstants {
	public static final Ingredient HERBIVORE_FOOD = Ingredient.of(FeederBlockEntity.getPlantsFoodLevel().keySet().stream().toArray(ItemLike[]::new));
	public static final Ingredient CARNIVORE_FOOD = Ingredient.of(FeederBlockEntity.getMeatFoodLevel().keySet().stream().toArray(ItemLike[]::new));
	public static final Ingredient PISCIVORE_FOOD = Ingredient.of(Items.COD, Items.COOKED_COD, Items.SALMON, Items.COOKED_SALMON, Items.TROPICAL_FISH, FossilsLegacyItems.SIO_CHIU_LE.get(), FossilsLegacyItems.NAUTILUS.get());
}
