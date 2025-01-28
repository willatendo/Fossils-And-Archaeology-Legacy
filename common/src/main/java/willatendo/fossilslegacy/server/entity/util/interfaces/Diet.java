package willatendo.fossilslegacy.server.entity.util.interfaces;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.LevelAccessor;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Nautilus;
import willatendo.fossilslegacy.server.entity.util.DinosaurUtils;
import willatendo.fossilslegacy.server.feeder_food.FeederFood;

public interface Diet {
    boolean getsFoodFromKill();

    int getItemStackFoodValue(ItemStack itemStack);

    int getEntityFoodValue(Entity entity);

    Ingredient getTemptFoods();

    static Diet piscivore(LevelAccessor levelAccessor) {
        return new Diet() {
            @Override
            public boolean getsFoodFromKill() {
                return true;
            }

            @Override
            public int getItemStackFoodValue(ItemStack itemStack) {
                FeederFood feederFood = FeederFood.getFeederFood(levelAccessor, itemStack);
                if (feederFood != null && feederFood.sameFillType(FeederFood.FillType.MEAT)) {
                    return feederFood.getAmount();
                }
                return 0;
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
                return DinosaurUtils.PISCIVORE_FOOD;
            }
        };
    }

    static Diet carnivore(LevelAccessor levelAccessor) {
        return new Diet() {
            @Override
            public boolean getsFoodFromKill() {
                return true;
            }

            @Override
            public int getItemStackFoodValue(ItemStack itemStack) {
                FeederFood feederFood = FeederFood.getFeederFood(levelAccessor, itemStack);
                if (feederFood != null && feederFood.sameFillType(FeederFood.FillType.MEAT)) {
                    return feederFood.getAmount();
                }
                return 0;
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
                return DinosaurUtils.CARNIVORE_FOOD;
            }
        };
    }

    static Diet herbivore(LevelAccessor levelAccessor) {
        return new Diet() {
            @Override
            public boolean getsFoodFromKill() {
                return false;
            }

            @Override
            public int getItemStackFoodValue(ItemStack itemStack) {
                FeederFood feederFood = FeederFood.getFeederFood(levelAccessor, itemStack);
                if (feederFood != null && feederFood.sameFillType(FeederFood.FillType.PLANT)) {
                    return feederFood.getAmount();
                }
                return 0;
            }

            @Override
            public int getEntityFoodValue(Entity entity) {
                return 0;
            }

            @Override
            public Ingredient getTemptFoods() {
                return DinosaurUtils.HERBIVORE_FOOD;
            }
        };
    }

    static Diet omnivore(LevelAccessor levelAccessor) {
        return new Diet() {
            @Override
            public boolean getsFoodFromKill() {
                return true;
            }

            @Override
            public int getItemStackFoodValue(ItemStack itemStack) {
                FeederFood feederFood = FeederFood.getFeederFood(levelAccessor, itemStack);
                if (feederFood != null) {
                    return feederFood.getAmount();
                }
                return 0;
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
                return DinosaurUtils.OMNIVORE_FOOD;
            }
        };
    }
}
