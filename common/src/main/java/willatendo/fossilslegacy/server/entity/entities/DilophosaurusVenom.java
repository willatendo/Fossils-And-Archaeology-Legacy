package willatendo.fossilslegacy.server.entity.entities;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import willatendo.fossilslegacy.server.entity.FADamageTypes;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;

public class DilophosaurusVenom extends ThrowableProjectile {
    public DilophosaurusVenom(EntityType<? extends DilophosaurusVenom> entityType, Level level) {
        super(entityType, level);
    }

    public DilophosaurusVenom(Level level, LivingEntity livingEntity) {
        super(FAEntityTypes.DILOPHOSAURUS_VENOM.get(), livingEntity, level);
    }

    public DilophosaurusVenom(Level level, double x, double y, double z) {
        super(FAEntityTypes.DILOPHOSAURUS_VENOM.get(), x, y, z, level);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResulte) {
        super.onHitEntity(entityHitResulte);
        Entity entity = entityHitResulte.getEntity();
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 120));
        }
        entity.hurt(new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(FADamageTypes.DILOPHOSAURUS_ENVENOMATION)), 1.0F);
    }
}
