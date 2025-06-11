package willatendo.fossilslegacy.server.entity.entities;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.entity.FADamageTypes;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.Dilophosaurus;

public class DilophosaurusVenom extends ThrowableProjectile {
    public DilophosaurusVenom(EntityType<? extends DilophosaurusVenom> entityType, Level level) {
        super(entityType, level);
    }

    public DilophosaurusVenom(Level level, Dilophosaurus dilophosaurus) {
        this(FAEntityTypes.DILOPHOSAURUS_VENOM.get(), level);
        this.setOwner(dilophosaurus);
        this.setPos(dilophosaurus.getX() - (double) (dilophosaurus.getBbWidth() + 1.0F) * 0.5 * (double) Mth.sin(dilophosaurus.yBodyRot * 0.017453292F), dilophosaurus.getEyeY() - 0.10000000149011612, dilophosaurus.getZ() + (double) (dilophosaurus.getBbWidth() + 1.0F) * 0.5 * (double) Mth.cos(dilophosaurus.yBodyRot * 0.017453292F));
    }

    @Override
    protected double getDefaultGravity() {
        return 0.06;
    }

    @Override
    public void tick() {
        super.tick();
        Vec3 deltaMovement = this.getDeltaMovement();
        HitResult hitResult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
        this.hitTargetOrDeflectSelf(hitResult);
        double x = this.getX() + deltaMovement.x;
        double y = this.getY() + deltaMovement.y;
        double z = this.getZ() + deltaMovement.z;
        this.updateRotation();
        if (this.level().getBlockStates(this.getBoundingBox()).noneMatch(BlockBehaviour.BlockStateBase::isAir)) {
            this.discard();
        } else if (this.isInWaterOrBubble()) {
            this.discard();
        } else {
            this.setDeltaMovement(deltaMovement.scale(0.9900000095367432));
            this.applyGravity();
            this.setPos(x, y, z);
        }

    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResulte) {
        super.onHitEntity(entityHitResulte);
        Entity entity = entityHitResulte.getEntity();
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 120));
        }
        entity.hurt(new DamageSource(this.level().registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(FADamageTypes.DILOPHOSAURUS_ENVENOMATION)), 1.0F);
    }

    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        if (!this.level().isClientSide()) {
            this.discard();
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
    }

    @Override
    public void recreateFromPacket(ClientboundAddEntityPacket clientboundAddEntityPacket) {
        super.recreateFromPacket(clientboundAddEntityPacket);
        double xa = clientboundAddEntityPacket.getXa();
        double ya = clientboundAddEntityPacket.getYa();
        double za = clientboundAddEntityPacket.getZa();

        for (int i = 0; i < 7; ++i) {
            double d3 = 0.4 + 0.1 * (double) i;
            this.level().addParticle(ParticleTypes.SPIT, this.getX(), this.getY(), this.getZ(), xa * d3, ya, za * d3);
        }

        this.setDeltaMovement(xa, ya, za);
    }
}
