package willatendo.fossilslegacy.server.item.items;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.item.FAItems;

public class FrozenMeatItem extends Item {
    public FrozenMeatItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(toolMaterial.applySwordProperties(properties, attackDamage, attackSpeed));
    }

    @Override
    public boolean canAttackBlock(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        return !player.isCreative();
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity victem, LivingEntity attacker) {
        if (attacker instanceof Player player && !player.isCreative()) {
            if (itemStack.getCount() > 1) {
                ItemStack brokenItemStack = new ItemStack(FAItems.BROKEN_FROZEN_MEAT.get());
                if (player instanceof ServerPlayer) {
                    brokenItemStack.setDamageValue(1);
                }
                player.addItem(brokenItemStack);
                itemStack.shrink(1);
            } else {
                ItemStack brokenItemStack = new ItemStack(FAItems.BROKEN_FROZEN_MEAT.get());
                if (player instanceof ServerPlayer) {
                    brokenItemStack.setDamageValue(1);
                }
                player.setItemInHand(player.getUsedItemHand(), brokenItemStack);
            }
            return true;
        }
        return true;
    }
}
