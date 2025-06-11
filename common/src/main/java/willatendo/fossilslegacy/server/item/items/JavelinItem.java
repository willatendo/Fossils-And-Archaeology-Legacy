package willatendo.fossilslegacy.server.item.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.entity.entities.projectile.ThrownJavelin;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.item.FAToolMaterials;

public class JavelinItem extends Item {
    private final ToolMaterial toolMaterial;

    public JavelinItem(ToolMaterial toolMaterial, Properties properties) {
        super(properties);
        this.toolMaterial = toolMaterial;
    }

    public ToolMaterial getTier() {
        return this.toolMaterial;
    }


    @Override
    public ItemUseAnimation getUseAnimation(ItemStack itemStack) {
        return ItemUseAnimation.BOW;
    }

    @Override
    public int getUseDuration(ItemStack itemStack, LivingEntity livingEntity) {
        return 72000;
    }

    @Override
    public boolean releaseUsing(ItemStack itemStack, Level level, LivingEntity livingEntity, int time) {
        if (livingEntity instanceof Player player) {
            int i = this.getUseDuration(itemStack, livingEntity) - time;
            if (i >= 0) {
                if (!level.isClientSide()) {
                    ItemStack damaged = itemStack;
                    if (!(itemStack.getItem() instanceof BrokenJavelinItem)) {
                        damaged = JavelinItem.getDamaged(this.toolMaterial);
                    }
                    damaged.hurtAndBreak(1, player, LivingEntity.getSlotForHand(livingEntity.getUsedItemHand()));
                    ThrownJavelin thrownJavelin = new ThrownJavelin(level, player, damaged);
                    thrownJavelin.setVariant(this.toolMaterial);
                    thrownJavelin.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1.0F);

                    if (player.getAbilities().instabuild) {
                        thrownJavelin.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                    }

                    level.addFreshEntity(thrownJavelin);
                    level.playSound(null, thrownJavelin, SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F);

                    if (!player.getAbilities().instabuild) {
                        itemStack.shrink(1);
                    }
                }

                player.awardStat(Stats.ITEM_USED.get(this));
                return true;
            }
        }
        return false;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (itemStack.getMaxDamage() > 0) {
            if (itemStack.getDamageValue() >= itemStack.getMaxDamage() - 1) {
                return InteractionResult.FAIL;
            } else {
                player.startUsingItem(interactionHand);
                return InteractionResult.CONSUME;
            }
        } else {
            player.startUsingItem(interactionHand);
            return InteractionResult.CONSUME;
        }
    }

    public static ItemStack getDamaged(ToolMaterial toolMaterial) {
        return toolMaterial == ToolMaterial.WOOD ? FAItems.BROKEN_WOODEN_JAVELIN.get().getDefaultInstance() : toolMaterial == ToolMaterial.STONE ? FAItems.BROKEN_STONE_JAVELIN.get().getDefaultInstance() : toolMaterial == ToolMaterial.IRON ? FAItems.BROKEN_IRON_JAVELIN.get().getDefaultInstance() : toolMaterial == ToolMaterial.GOLD ? FAItems.BROKEN_GOLDEN_JAVELIN.get().getDefaultInstance() : toolMaterial == ToolMaterial.DIAMOND ? FAItems.BROKEN_DIAMOND_JAVELIN.get().getDefaultInstance() : toolMaterial == ToolMaterial.NETHERITE ? FAItems.BROKEN_NETHERITE_JAVELIN.get().getDefaultInstance() : toolMaterial == FAToolMaterials.SCARAB_GEM ? FAItems.BROKEN_SCARAB_GEM_JAVELIN.get().getDefaultInstance() : null;
    }
}
