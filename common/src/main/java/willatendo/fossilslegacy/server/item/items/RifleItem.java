package willatendo.fossilslegacy.server.item.items;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.entity.entities.projectile.Dart;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.tags.FAItemTags;

import java.util.List;
import java.util.function.Predicate;

public class RifleItem extends ProjectileWeaponItem {
    public RifleItem(Properties properties) {
        super(properties);
    }

    @Override
    protected void shootProjectile(LivingEntity livingEntity, Projectile projectile, int index, float velocity, float inaccuracy, float angle, LivingEntity target) {
        projectile.shootFromRotation(livingEntity, livingEntity.getXRot(), livingEntity.getYRot() + angle, 0.0F, velocity, inaccuracy);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        boolean flag = !player.getProjectile(itemStack).isEmpty();
        if (!player.hasInfiniteMaterials() && !flag) {
            return InteractionResult.FAIL;
        } else {
            ItemStack projectileItemStack = player.getProjectile(itemStack);
            if (projectileItemStack.isEmpty()) {
                return InteractionResult.FAIL;
            } else {
                List<ItemStack> list = RifleItem.draw(itemStack, projectileItemStack, player);
                if (level instanceof ServerLevel serverLevel) {
                    if (!list.isEmpty()) {
                        this.shoot(serverLevel, player, player.getUsedItemHand(), itemStack, list, 3.0F, 1.0F, true, null);
                    }
                }

                level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                player.awardStat(Stats.ITEM_USED.get(this));
                player.getCooldowns().addCooldown(itemStack, 30);
                itemStack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);

                return InteractionResult.CONSUME;
            }
        }
    }

    @Override
    protected Projectile createProjectile(Level level, LivingEntity shooter, ItemStack weapon, ItemStack ammo, boolean isCritical) {
        Item ammoItem = ammo.getItem();
        DartItem dartItem;
        if (ammoItem instanceof DartItem ammoDartItem) {
            dartItem = ammoDartItem;
        } else {
            dartItem = FAItems.RED_TRANQUILIZER_DART.get();
        }

        Dart dart = dartItem.createDart(level, ammo, shooter, weapon);

        return dart;
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return itemStack -> itemStack.is(FAItemTags.DARTS);
    }

    @Override
    public int getDefaultProjectileRange() {
        return 100;
    }
}
