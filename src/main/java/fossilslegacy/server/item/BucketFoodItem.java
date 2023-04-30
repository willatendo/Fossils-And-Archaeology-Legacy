package fossilslegacy.server.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class BucketFoodItem extends Item {
	public BucketFoodItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
		ItemStack superItemStack = super.finishUsingItem(itemStack, level, livingEntity);
		return livingEntity instanceof Player && ((Player) livingEntity).getAbilities().instabuild ? superItemStack : new ItemStack(Items.BUCKET);
	}
}
