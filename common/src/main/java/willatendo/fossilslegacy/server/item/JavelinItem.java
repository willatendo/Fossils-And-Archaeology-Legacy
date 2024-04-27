package willatendo.fossilslegacy.server.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.entity.ThrownJavelin;

public class JavelinItem extends Item {
    private final Tier tier;

    public JavelinItem(Tier tier, Properties properties) {
        super(properties);
        this.tier = tier;
    }

    public Tier getTier() {
        return this.tier;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack itemStack) {
        return 72000;
    }

    @Override
    public void releaseUsing(ItemStack itemStack, Level level, LivingEntity livingEntity, int time) {
        if (livingEntity instanceof Player player) {
            int i = this.getUseDuration(itemStack) - time;
            if (i >= 0) {
                if (!level.isClientSide()) {
                    ItemStack damaged = itemStack;
                    if (!(itemStack.getItem() instanceof BrokenJavelinItem)) {
                        damaged = JavelinItem.getDamaged(this.tier);
                    }
                    damaged.hurtAndBreak(1, player, (user) -> {
                        user.broadcastBreakEvent(livingEntity.getUsedItemHand());
                    });
                    ThrownJavelin thrownJavelin = new ThrownJavelin(level, player, damaged);
                    thrownJavelin.setVariant(this.tier);
                    thrownJavelin.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1.0F);

                    if (player.getAbilities().instabuild) {
                        thrownJavelin.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                    }

                    level.addFreshEntity(thrownJavelin);
                    level.playSound((Player) null, thrownJavelin, SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F);

                    if (!player.getAbilities().instabuild) {
                        itemStack.shrink(1);
                    }
                }

                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (itemStack.getMaxDamage() > 0) {
            if (itemStack.getDamageValue() >= itemStack.getMaxDamage() - 1) {
                return InteractionResultHolder.fail(itemStack);
            } else {
                player.startUsingItem(interactionHand);
                return InteractionResultHolder.consume(itemStack);
            }
        } else {
            player.startUsingItem(interactionHand);
            return InteractionResultHolder.consume(itemStack);
        }
    }

    public static ItemStack getDamaged(Tier tier) {
        return tier == Tiers.WOOD ? FossilsLegacyItems.BROKEN_WOODEN_JAVELIN.get().getDefaultInstance() : tier == Tiers.STONE ? FossilsLegacyItems.BROKEN_STONE_JAVELIN.get().getDefaultInstance() : tier == Tiers.IRON ? FossilsLegacyItems.BROKEN_IRON_JAVELIN.get().getDefaultInstance() : tier == Tiers.GOLD ? FossilsLegacyItems.BROKEN_GOLDEN_JAVELIN.get().getDefaultInstance() : tier == Tiers.DIAMOND ? FossilsLegacyItems.BROKEN_DIAMOND_JAVELIN.get().getDefaultInstance() : tier == Tiers.NETHERITE ? FossilsLegacyItems.BROKEN_NETHERITE_JAVELIN.get().getDefaultInstance() : tier == FossilsLegacyTiers.SCARAB_GEM ? FossilsLegacyItems.BROKEN_SCARAB_GEM_JAVELIN.get().getDefaultInstance() : null;
    }
}
