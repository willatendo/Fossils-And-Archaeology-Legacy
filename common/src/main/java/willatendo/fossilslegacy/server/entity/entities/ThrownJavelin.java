package willatendo.fossilslegacy.server.entity.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.entity.FADamageTypes;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.item.FAToolMaterials;

public class ThrownJavelin extends AbstractArrow {
    private static final EntityDataAccessor<Integer> DATA_VARIANT_ID = SynchedEntityData.defineId(ThrownJavelin.class, EntityDataSerializers.INT);
    private ItemStack itemStack = FAItems.BROKEN_WOODEN_JAVELIN.get().getDefaultInstance();
    private float damage = 1.0F;

    public ThrownJavelin(EntityType<? extends ThrownJavelin> entityType, Level level) {
        super(entityType, level);
    }

    protected ThrownJavelin(EntityType<? extends ThrownJavelin> entityType, double x, double y, double z, Level level) {
        this(entityType, level);
        this.setPos(x, y, z);
    }

    public ThrownJavelin(Level level, double x, double y, double z) {
        this(FAEntityTypes.THROWN_JAVELIN.get(), x, y, z, level);
    }

    public ThrownJavelin(Level level, LivingEntity livingEntity, ItemStack itemStack) {
        super(FAEntityTypes.THROWN_JAVELIN.get(), livingEntity, level, itemStack, null);
        this.itemStack = itemStack.copy();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_VARIANT_ID, 0);
    }

    @Override
    public boolean save(CompoundTag compoundTag) {
        compoundTag.putFloat("Damage", this.damage);
        compoundTag.putInt("Variant", this.getVariant());
        compoundTag.put("javelin", this.itemStack.save(this.registryAccess()));
        return super.save(compoundTag);
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.damage = compoundTag.getFloat("Damage");
        this.setVariant(compoundTag.getInt("Variant"));
        this.itemStack = ItemStack.parseOptional(this.registryAccess(), compoundTag.getCompound("javelin"));
    }

    public void setVariant(int variant) {
        this.entityData.set(DATA_VARIANT_ID, variant);
    }

    public void setVariant(ToolMaterial tier) {
        if (tier == ToolMaterial.WOOD) {
            this.setVariant(0);
        }
        if (tier == ToolMaterial.STONE) {
            this.setVariant(1);
        }
        if (tier == ToolMaterial.IRON) {
            this.setVariant(2);
        }
        if (tier == ToolMaterial.GOLD) {
            this.setVariant(3);
        }
        if (tier == ToolMaterial.DIAMOND) {
            this.setVariant(4);
        }
        if (tier == ToolMaterial.NETHERITE) {
            this.setVariant(5);
        }
        if (tier == FAToolMaterials.SCARAB_GEM) {
            this.setVariant(6);
        }
        this.damage = 6.0F + tier.attackDamageBonus();
    }

    public int getVariant() {
        return this.entityData.get(DATA_VARIANT_ID);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        Entity owner = this.getOwner();
        DamageSource damageSource = new DamageSource(this.level().registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(FADamageTypes.JAVELIN));
        SoundEvent soundevent = SoundEvents.ARROW_HIT;
        if (entity.hurtOrSimulate(damageSource, this.damage)) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }

            if (entity instanceof LivingEntity livingEntity) {
                this.doPostHurtEffects(livingEntity);
            }
        }

        this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));
        float soundLevel = 1.0F;
        if (this.level() instanceof ServerLevel && this.getVariant() == 6) {
            BlockPos blockpos = entity.blockPosition();
            if (this.level().canSeeSky(blockpos)) {
                LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(this.level(), EntitySpawnReason.EVENT);
                if (lightningbolt != null) {
                    lightningbolt.moveTo(Vec3.atBottomCenterOf(blockpos));
                    lightningbolt.setCause(owner instanceof ServerPlayer ? (ServerPlayer) owner : null);
                    this.level().addFreshEntity(lightningbolt);
                    soundevent = SoundEvents.LIGHTNING_BOLT_THUNDER;
                    soundLevel = 5.0F;
                }
            }
        }
        this.playSound(soundevent, soundLevel, 1.0F);
    }

    @Override
    protected ItemStack getPickupItem() {
        return this.itemStack;
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(FAItems.WOODEN_JAVELIN.get());
    }
}
