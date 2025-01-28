package willatendo.fossilslegacy.server.item.items;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.item.FAItems;

public class FrozenMeatItem extends Item {
    public FrozenMeatItem(Properties properties) {
        super(properties);
    }

    public static ItemAttributeModifiers createAttributes(Tier tier, int attackDamage, float attackSpeed) {
        return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, ((float) attackDamage + tier.getAttackDamageBonus()), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, (double) attackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
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
                if (player instanceof ServerPlayer serverPlayer) {
                    brokenItemStack.setDamageValue(1);
                }
                player.addItem(brokenItemStack);
                itemStack.shrink(1);
            } else {
                ItemStack brokenItemStack = new ItemStack(FAItems.BROKEN_FROZEN_MEAT.get());
                if (player instanceof ServerPlayer serverPlayer) {
                    brokenItemStack.setDamageValue(1);
                }
                player.setItemInHand(player.getUsedItemHand(), brokenItemStack);
            }
            return true;
        }
        return true;
    }
}
