package willatendo.fossilslegacy.server.entity.util.interfaces;

import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Nautilus;
import willatendo.fossilslegacy.server.feeder_food.FeederFood;
import willatendo.fossilslegacy.server.tags.FAItemTags;

public interface Diet {
    boolean getsFoodFromKill();

    int getItemStackFoodValue(ItemStack itemStack);

    int getEntityFoodValue(Entity entity);

    TagKey<Item> getTemptFoods();

    default FeederFood.FeederInfo getFeederInfo(LevelAccessor levelAccessor, ItemStack itemStack) {
        return FeederFood.getFeederFood(levelAccessor.registryAccess()).getOrDefault(itemStack.getItem(), null);
    }

    static Diet piscivore(LevelAccessor levelAccessor) {
        return new Diet() {
            @Override
            public boolean getsFoodFromKill() {
                return true;
            }

            @Override
            public int getItemStackFoodValue(ItemStack itemStack) {
                FeederFood.FeederInfo feederInfo = this.getFeederInfo(levelAccessor, itemStack);
                if (feederInfo != null && feederInfo.sameFillType(FeederFood.FillType.MEAT)) {
                    return feederInfo.fillAmount();
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
            public TagKey<Item> getTemptFoods() {
                return FAItemTags.PISCIVORE_FOODS;
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
                FeederFood.FeederInfo feederInfo = this.getFeederInfo(levelAccessor, itemStack);
                if (feederInfo != null && feederInfo.sameFillType(FeederFood.FillType.MEAT)) {
                    return feederInfo.fillAmount();
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
            public TagKey<Item> getTemptFoods() {
                return FAItemTags.CARNIVORE_FOODS;
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
                FeederFood.FeederInfo feederInfo = this.getFeederInfo(levelAccessor, itemStack);
                if (feederInfo != null && feederInfo.sameFillType(FeederFood.FillType.PLANT)) {
                    return feederInfo.fillAmount();
                }
                return 0;
            }

            @Override
            public int getEntityFoodValue(Entity entity) {
                return 0;
            }

            @Override
            public TagKey<Item> getTemptFoods() {
                return FAItemTags.HERBIVORE_FOODS;
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
                FeederFood.FeederInfo feederInfo = this.getFeederInfo(levelAccessor, itemStack);
                if (feederInfo != null) {
                    return feederInfo.fillAmount();
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
            public TagKey<Item> getTemptFoods() {
                return FAItemTags.OMNIVORE_FOODS;
            }
        };
    }
}
