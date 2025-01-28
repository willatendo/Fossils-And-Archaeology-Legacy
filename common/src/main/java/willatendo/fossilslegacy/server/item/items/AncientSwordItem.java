package willatendo.fossilslegacy.server.item.items;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.criteria.FLCriteriaTriggers;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.AncientLightningBolt;
import willatendo.fossilslegacy.server.tags.FAItemTags;

public class AncientSwordItem extends SwordItem {
    public AncientSwordItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity victim, LivingEntity user) {
        if (user instanceof Player player) {
            if (user instanceof ServerPlayer serverPlayer && victim instanceof Pig pig) {
                FLCriteriaTriggers.CREATE_ZOMBIFIED_PIGMAN.get().trigger(serverPlayer, pig);
            }
            Level level = victim.level();
            LightningBolt lightningBolt;
            if (user.getItemBySlot(EquipmentSlot.HEAD).is(FAItemTags.PIGLIN_TAMING_ARMOR) && user.getItemBySlot(EquipmentSlot.CHEST).is(FAItemTags.PIGLIN_TAMING_ARMOR) && user.getItemBySlot(EquipmentSlot.LEGS).is(FAItemTags.PIGLIN_TAMING_ARMOR) && user.getItemBySlot(EquipmentSlot.FEET).is(FAItemTags.PIGLIN_TAMING_ARMOR)) {
                lightningBolt = FAEntityTypes.ANCIENT_LIGHTNING_BOLT.get().create(level);
                ((AncientLightningBolt) lightningBolt).tame(player);
            } else {
                lightningBolt = EntityType.LIGHTNING_BOLT.create(level);
            }
            lightningBolt.moveTo(Vec3.atBottomCenterOf(victim.blockPosition()));
            level.addFreshEntity(lightningBolt);
            if (level.isClientSide()) {
                level.playSound(user, victim.blockPosition(), SoundEvents.LIGHTNING_BOLT_THUNDER, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
        }
        return super.hurtEnemy(itemStack, victim, user);
    }
}
