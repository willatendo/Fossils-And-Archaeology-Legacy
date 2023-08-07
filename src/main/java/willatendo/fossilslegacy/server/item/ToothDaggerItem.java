package willatendo.fossilslegacy.server.item;

import java.util.List;
import java.util.Random;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IForgeShearable;

public class ToothDaggerItem extends SwordItem {
	public ToothDaggerItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
		super(tier, attackDamage, attackSpeed, properties);
	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
		if (livingEntity instanceof IForgeShearable iForgeShearable) {
			if (livingEntity.level().isClientSide) {
				return InteractionResult.SUCCESS;
			}
			BlockPos blockPos = new BlockPos((int) livingEntity.getX(), (int) livingEntity.getY(), (int) livingEntity.getZ());
			if (iForgeShearable.isShearable(itemStack, livingEntity.level(), blockPos)) {
				List<ItemStack> drops = iForgeShearable.onSheared(player, itemStack, livingEntity.level(), blockPos, EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, itemStack));
				Random random = new Random();
				drops.forEach(d -> {
					ItemEntity itementity = livingEntity.spawnAtLocation(d, 1.0F);
					itementity.setDeltaMovement(itementity.getDeltaMovement().add((double) ((random.nextFloat() - random.nextFloat()) * 0.1F), (double) (random.nextFloat() * 0.05F), (double) ((random.nextFloat() - random.nextFloat()) * 0.1F)));
				});
				itemStack.hurtAndBreak(1, player, user -> user.broadcastBreakEvent(interactionHand));
			}
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}

	@Override
	public InteractionResult useOn(UseOnContext useOnContext) {
		Level level = useOnContext.getLevel();
		BlockPos blockPos = useOnContext.getClickedPos();
		BlockState blockState = level.getBlockState(blockPos);
		Block block = blockState.getBlock();
		if (block instanceof GrowingPlantHeadBlock growingPlanetHead) {
			if (!growingPlanetHead.isMaxAge(blockState)) {
				Player player = useOnContext.getPlayer();
				ItemStack itemStack = useOnContext.getItemInHand();
				if (player instanceof ServerPlayer) {
					CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, blockPos, itemStack);
				}

				level.playSound(player, blockPos, SoundEvents.GROWING_PLANT_CROP, SoundSource.BLOCKS, 1.0F, 1.0F);
				level.setBlockAndUpdate(blockPos, growingPlanetHead.getMaxAgeState(blockState));
				if (player != null) {
					itemStack.hurtAndBreak(1, player, (user) -> {
						user.broadcastBreakEvent(useOnContext.getHand());
					});
				}

				return InteractionResult.sidedSuccess(level.isClientSide);
			}
		}

		return super.useOn(useOnContext);
	}
}
