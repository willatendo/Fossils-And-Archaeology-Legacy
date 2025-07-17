package willatendo.fossilslegacy.server.item.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Unit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.sound.FASoundEvents;

public class FlareItem extends Item {
    public FlareItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (itemStack.has(FADataComponents.BURNING.get()) && entity instanceof ServerPlayer serverPlayer) {
            if (entity.tickCount % 20 == 1) {
                itemStack.hurtAndBreak(1, serverPlayer.serverLevel(), serverPlayer, item -> {
                    if (isSelected) {
                        serverPlayer.onEquippedItemBroken(item, EquipmentSlot.MAINHAND);
                    }
                    serverPlayer.addItem(new ItemStack(FAItems.FLARE_BODY.get()));
                });
            }
        }
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        if (livingEntity instanceof Player player) {
            ItemStack returningItemStack = itemStack.copy();
            ItemUtils.createFilledResult(itemStack, player, returningItemStack);
            returningItemStack.set(FADataComponents.BURNING.get(), Unit.INSTANCE);
            level.playLocalSound(livingEntity, FASoundEvents.FLARE_IGNITE.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
            return returningItemStack;
        }
        return super.finishUsingItem(itemStack, level, livingEntity);
    }

    @Override
    public int getUseDuration(ItemStack itemStack, LivingEntity livingEntityw) {
        return 32;
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack itemStack) {
        return ItemUseAnimation.EAT;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand interactionHand) {
        if (!player.getMainHandItem().has(FADataComponents.BURNING.get())) {
            player.startUsingItem(interactionHand);
            level.playLocalSound(player, FASoundEvents.FLARE_START.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
            return InteractionResult.CONSUME;
        } else {
            return super.use(level, player, interactionHand);
        }
    }
}
