package willatendo.fossilslegacy.server.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class DrinkingGlassBottleItem extends Item {
    public DrinkingGlassBottleItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        if (livingEntity instanceof Player player) {
            player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE));
        }
        return super.finishUsingItem(itemStack, level, livingEntity);
    }
}
