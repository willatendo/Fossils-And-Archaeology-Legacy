package willatendo.fossilslegacy.server.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import willatendo.fossilslegacy.server.block.entity.FeederBlockEntity;

public interface Diet {
	boolean getsFoodFromKill();

	int getItemStackFoodValue(ItemStack itemStack);

	int getEntityFoodValue(Entity entity);

	Ingredient getTemptFoods();

	public static Diet piscivore() {
		return new Diet() {
			@Override
			public boolean getsFoodFromKill() {
				return true;
			}

			@Override
			public int getItemStackFoodValue(ItemStack itemStack) {
				return FeederBlockEntity.getMeatFoodLevel(itemStack);
			}

			@Override
			public int getEntityFoodValue(Entity entity) {
				if (entity instanceof Nautilus) {
					return 100;
				}
				return 5;
			}

			@Override
			public Ingredient getTemptFoods() {
				return DinoUtils.PISCIVORE_FOOD;
			}
		};
	}

	public static Diet carnivore() {
		return new Diet() {
			@Override
			public boolean getsFoodFromKill() {
				return true;
			}

			@Override
			public int getItemStackFoodValue(ItemStack itemStack) {
				return FeederBlockEntity.getMeatFoodLevel(itemStack);
			}

			@Override
			public int getEntityFoodValue(Entity entity) {
				if (entity instanceof Pig) {
					return 30;
				}
				if (entity instanceof Sheep) {
					return 35;
				}
				if (entity instanceof Goat) {
					return 35;
				}
				if (entity instanceof Cow) {
					return 50;
				}
				if (entity instanceof Chicken) {
					return 20;
				}
				return 20;
			}

			@Override
			public Ingredient getTemptFoods() {
				return DinoUtils.CARNIVORE_FOOD;
			}
		};
	}

	public static Diet herbivore() {
		return new Diet() {
			@Override
			public boolean getsFoodFromKill() {
				return false;
			}

			@Override
			public int getItemStackFoodValue(ItemStack itemStack) {
				return FeederBlockEntity.getPlantsFoodLevel(itemStack);
			}

			@Override
			public int getEntityFoodValue(Entity entity) {
				return 0;
			}

			@Override
			public Ingredient getTemptFoods() {
				return DinoUtils.HERBIVORE_FOOD;
			}
		};
	}
}
