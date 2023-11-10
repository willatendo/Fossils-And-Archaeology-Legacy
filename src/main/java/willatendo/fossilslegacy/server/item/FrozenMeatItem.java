package willatendo.fossilslegacy.server.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class FrozenMeatItem extends Item {
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;

	public FrozenMeatItem(Properties properties) {
		super(properties);
		ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 9.0D, AttributeModifier.Operation.ADDITION));
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -2.4D, AttributeModifier.Operation.ADDITION));
		this.defaultModifiers = builder.build();
	}

	@Override
	public boolean canAttackBlock(BlockState blockState, Level level, BlockPos blockPos, Player player) {
		return !player.isCreative();
	}

	@Override
	public boolean hurtEnemy(ItemStack itemStack, LivingEntity victem, LivingEntity attacker) {
		if (attacker instanceof Player player && !player.isCreative()) {
			if (itemStack.getCount() > 1) {
				ItemStack brokenItemStack = new ItemStack(FossilsLegacyItems.BROKEN_FROZEN_MEAT.get());
				if (player instanceof ServerPlayer serverPlayer) {
					brokenItemStack.hurt(1, RandomSource.create(), serverPlayer);
				}
				player.addItem(brokenItemStack);
				itemStack.shrink(1);
			} else {
				ItemStack brokenItemStack = new ItemStack(FossilsLegacyItems.BROKEN_FROZEN_MEAT.get());
				if (player instanceof ServerPlayer serverPlayer) {
					brokenItemStack.hurt(1, RandomSource.create(), serverPlayer);
				}
				player.setItemInHand(player.getUsedItemHand(), brokenItemStack);
			}
			return true;
		}
		return true;
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
		return equipmentSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(equipmentSlot);
	}

	@Override
	public boolean canPerformAction(ItemStack itemStack, ToolAction toolAction) {
		return ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
	}
}
