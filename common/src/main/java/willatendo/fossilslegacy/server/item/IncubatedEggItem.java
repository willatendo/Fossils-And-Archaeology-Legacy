package willatendo.fossilslegacy.server.item;

import net.minecraft.Util;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.entity.ThrownIncubatedEgg;

public class IncubatedEggItem extends Item implements ProjectileItem {
    private final int eggType;

    public IncubatedEggItem(int eggType, Properties properties) {
        super(properties);
        this.eggType = eggType;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        level.playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.EGG_THROW, SoundSource.PLAYERS, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!level.isClientSide) {
            ThrownIncubatedEgg thrownegg = new ThrownIncubatedEgg(level, player);
            thrownegg.setEggType(this.eggType);
            thrownegg.setItem(itemStack);
            thrownegg.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(thrownegg);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.getAbilities().instabuild) {
            itemStack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }

    @Override
    public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
        return Util.make(new ThrownIncubatedEgg(level, position.x(), position.y(), position.z()), thrownIncubatedEgg -> {
            thrownIncubatedEgg.setItem(itemStack);
            thrownIncubatedEgg.setEggType(1);
        });
    }
}
