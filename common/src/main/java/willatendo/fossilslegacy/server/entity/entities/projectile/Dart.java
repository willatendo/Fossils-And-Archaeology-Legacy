package willatendo.fossilslegacy.server.entity.entities.projectile;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.shapes.VoxelShape;
import willatendo.fossilslegacy.server.entity.FADamageTypes;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.util.interfaces.TranquilizableEntity;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Dart extends Projectile {
    private static final EntityDataAccessor<Byte> ID_FLAGS = SynchedEntityData.defineId(Dart.class, EntityDataSerializers.BYTE);
    private BlockState lastState;
    protected int inGroundTime;
    public AbstractArrow.Pickup pickup;
    public int shakeTime;
    private int life;
    private double baseDamage;
    private SoundEvent soundEvent;
    private ItemStack firedFromWeapon;
    private int potency;
    private Dart.Color color;

    public Dart(EntityType<? extends Dart> entityType, Level level) {
        super(entityType, level);
        this.soundEvent = this.getDefaultHitGroundSoundEvent();
        this.baseDamage = 1.0D;
        this.potency = 0;
        this.color = Color.RED;
    }

    public Dart(Level level, LivingEntity owner, ItemStack pickupItemStack, ItemStack firedFromWeapon, Dart.Color color, int potency) {
        this(level, owner.getX(), owner.getEyeY() - 0.10000000149011612, owner.getZ(), pickupItemStack, firedFromWeapon, color, potency);
        this.setOwner(owner);
    }

    public Dart(Level level, double x, double y, double z, ItemStack pickupItemStack, ItemStack firedFromWeapon, Dart.Color color, int potency) {
        this(FAEntityTypes.DART.get(), level);
        this.setCustomName(pickupItemStack.get(DataComponents.CUSTOM_NAME));
        this.setPos(x, y, z);
        this.potency = potency;
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double distance) {
        double boxSize = this.getBoundingBox().getSize() * 10.0;
        if (Double.isNaN(boxSize)) {
            boxSize = 1.0;
        }

        boxSize *= 64.0 * Entity.getViewScale();
        return distance < boxSize * boxSize;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(ID_FLAGS, (byte) 0);
    }

    @Override
    public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
        super.shoot(x, y, z, velocity, inaccuracy);
        this.life = 0;
    }

    @Override
    public void lerpTo(double x, double y, double z, float zRot, float xRot, int steps) {
        this.setPos(x, y, z);
        this.setRot(zRot, xRot);
    }

    @Override
    public void lerpMotion(double x, double y, double z) {
        super.lerpMotion(x, y, z);
        this.life = 0;
    }

    @Override
    public void tick() {
        boolean flag = !this.isNoPhysics();
        Vec3 deltaMovement = this.getDeltaMovement();
        BlockPos blockPos = this.blockPosition();
        BlockState blockState = this.level().getBlockState(blockPos);
        if (!blockState.isAir() && flag) {
            VoxelShape voxelShape = blockState.getCollisionShape(this.level(), blockPos);
            if (!voxelShape.isEmpty()) {
                Vec3 position = this.position();
                Iterator<AABB> aabbs = voxelShape.toAabbs().iterator();

                while (aabbs.hasNext()) {
                    AABB aabb = aabbs.next();
                    if (aabb.move(blockPos).contains(position)) {
                        break;
                    }
                }
            }
        }

        if (this.shakeTime > 0) {
            --this.shakeTime;
        }

        if (this.isInWaterOrRain() || blockState.is(Blocks.POWDER_SNOW)) {
            this.clearFire();
        }

        this.inGroundTime = 0;
        Vec3 position = this.position();
        if (this.isInWater()) {
            this.applyInertia(this.getWaterInertia());
            this.addBubbleParticles(position);
        }

        if (this.isCritArrow()) {
            for (int i = 0; i < 4; ++i) {
                this.level().addParticle(ParticleTypes.CRIT, position.x + deltaMovement.x * (double) i / 4.0, position.y + deltaMovement.y * (double) i / 4.0, position.z + deltaMovement.z * (double) i / 4.0, -deltaMovement.x, -deltaMovement.y + 0.2, -deltaMovement.z);
            }
        }

        float yRot;
        if (!flag) {
            yRot = (float) (Mth.atan2(-deltaMovement.x, -deltaMovement.z) * 180.0 / 3.1415927410125732);
        } else {
            yRot = (float) (Mth.atan2(deltaMovement.x, deltaMovement.z) * 180.0 / 3.1415927410125732);
        }

        float xRot = (float) (Mth.atan2(deltaMovement.y, deltaMovement.horizontalDistance()) * 180.0 / 3.1415927410125732);
        this.setXRot(lerpRotation(this.getXRot(), xRot));
        this.setYRot(lerpRotation(this.getYRot(), yRot));
        if (flag) {
            BlockHitResult blockHitResult = this.level().clipIncludingBorder(new ClipContext(position, position.add(deltaMovement), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
            this.stepMoveAndHit(blockHitResult);
        } else {
            this.setPos(position.add(deltaMovement));
            this.applyEffectsFromBlocks();
        }

        if (!this.isInWater()) {
            this.applyInertia(0.99F);
        }

        if (flag) {
            this.applyGravity();
        }

        super.tick();
    }

    private void stepMoveAndHit(BlockHitResult hitResult) {
        while (true) {
            if (this.isAlive()) {
                Vec3 position = this.position();
                EntityHitResult entityHitResult = this.findHitEntity(position, hitResult.getLocation());
                Vec3 location = Objects.requireNonNullElse(entityHitResult, hitResult).getLocation();
                this.setPos(location);
                this.applyEffectsFromBlocks(position, location);
                if (this.portalProcess != null && this.portalProcess.isInsidePortalThisTick()) {
                    this.handlePortal();
                }

                if (entityHitResult == null) {
                    if (this.isAlive() && hitResult.getType() != HitResult.Type.MISS) {
                        this.hitTargetOrDeflectSelf(hitResult);
                        this.hasImpulse = true;
                    }
                } else {
                    if (!this.isAlive() || this.noPhysics) {
                        continue;
                    }

                    ProjectileDeflection projectiledeflection = this.hitTargetOrDeflectSelf(entityHitResult);
                    this.hasImpulse = true;
                    if (projectiledeflection == ProjectileDeflection.NONE) {
                        continue;
                    }
                }
            }

            return;
        }
    }

    private void applyInertia(float inertia) {
        Vec3 deltaMovement = this.getDeltaMovement();
        this.setDeltaMovement(deltaMovement.scale(inertia));
    }

    private void addBubbleParticles(Vec3 pos) {
        Vec3 deltaMovement = this.getDeltaMovement();

        for (int i = 0; i < 4; ++i) {
            this.level().addParticle(ParticleTypes.BUBBLE, pos.x - deltaMovement.x * 0.25, pos.y - deltaMovement.y * 0.25, pos.z - deltaMovement.z * 0.25, deltaMovement.x, deltaMovement.y, deltaMovement.z);
        }
    }

    @Override
    protected double getDefaultGravity() {
        return 0.05;
    }

    private boolean shouldFall() {
        return this.level().noCollision((new AABB(this.position(), this.position())).inflate(0.06));
    }

    private void startFalling() {
        Vec3 deltaMovement = this.getDeltaMovement();
        this.setDeltaMovement(deltaMovement.multiply(this.random.nextFloat() * 0.2F, this.random.nextFloat() * 0.2F, this.random.nextFloat() * 0.2F));
        this.life = 0;
    }

    @Override
    public void move(MoverType moverType, Vec3 position) {
        super.move(moverType, position);
        if (moverType != MoverType.SELF && this.shouldFall()) {
            this.startFalling();
        }
    }

    @Override
    protected void onItemBreak(Item item) {
        this.firedFromWeapon = null;
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        float length = (float) this.getDeltaMovement().length();
        double baseDamage = this.baseDamage;
        Entity owner = this.getOwner();
        DamageSource damageSource = new DamageSource(this.level().registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(FADamageTypes.DART), this, owner != null ? owner : this);
        if (this.getWeaponItem() != null) {
            Level level = this.level();
            if (level instanceof ServerLevel serverLevel) {
                baseDamage = EnchantmentHelper.modifyDamage(serverLevel, this.getWeaponItem(), entity, damageSource, (float) baseDamage);
            }
        }

        int j = Mth.ceil(Mth.clamp((double) length * baseDamage, 0.0, 2.147483647E9));

        if (this.isCritArrow()) {
            long k = this.random.nextInt(j / 2 + 2);
            j = (int) Math.min(k + (long) j, 2147483647L);
        }

        if (owner instanceof LivingEntity livingentity1) {
            livingentity1.setLastHurtMob(entity);
        }

        boolean flag = entity.getType() == EntityType.ENDERMAN;
        int i = entity.getRemainingFireTicks();
        if (this.isOnFire() && !flag) {
            entity.igniteForSeconds(5.0F);
        }

        if (entity.hurtOrSimulate(damageSource, (float) j)) {
            if (flag) {
                return;
            }

            if (entity instanceof LivingEntity livingEntity) {
                if (!this.level().isClientSide) {
                    livingEntity.setArrowCount(livingEntity.getArrowCount() + 1);
                }

                this.doKnockback(livingEntity, damageSource);
                Level level = this.level();
                if (level instanceof ServerLevel serverLevel) {
                    EnchantmentHelper.doPostAttackEffectsWithItemSource(serverLevel, livingEntity, damageSource, this.getWeaponItem());
                }

                this.doPostHurtEffects(livingEntity);
                if (livingEntity != owner && livingEntity instanceof Player && owner instanceof ServerPlayer serverPlayer && !this.isSilent()) {
                    serverPlayer.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.ARROW_HIT_PLAYER, 0.0F));
                }

                if (!this.level().isClientSide && owner instanceof ServerPlayer serverPlayer) {
                    if (!entity.isAlive()) {
                        CriteriaTriggers.KILLED_BY_ARROW.trigger(serverPlayer, List.of(entity), this.firedFromWeapon);
                    }
                }
            }

            this.playSound(this.soundEvent, 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
            this.discard();
        } else {
            entity.setRemainingFireTicks(i);
            this.deflect(ProjectileDeflection.REVERSE, entity, this.getOwner(), false);
            this.setDeltaMovement(this.getDeltaMovement().scale(0.2));
            Level level = this.level();
            if (level instanceof ServerLevel) {
                if (this.getDeltaMovement().lengthSqr() < 1.0E-7) {
                    this.discard();
                }
            }
        }

    }

    protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
        float knockback;
        label18:
        {
            if (this.firedFromWeapon != null) {
                Level level = this.level();
                if (level instanceof ServerLevel serverLevel) {
                    knockback = EnchantmentHelper.modifyKnockback(serverLevel, this.firedFromWeapon, livingEntity, damageSource, 0.0F);
                    break label18;
                }
            }

            knockback = 0.0F;
        }

        if (knockback > 0.0) {
            double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
            Vec3 deltaMovement = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
            if (deltaMovement.lengthSqr() > 0.0) {
                livingEntity.push(deltaMovement.x, 0.1, deltaMovement.z);
            }
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        this.remove(RemovalReason.KILLED);
    }

    @Override
    public ItemStack getWeaponItem() {
        return this.firedFromWeapon;
    }

    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.ARROW_HIT;
    }

    protected void doPostHurtEffects(LivingEntity livingEntity) {
        if (livingEntity instanceof TranquilizableEntity tranquilizableEntity) {
            tranquilizableEntity.setTranquilizeTime(this.potency);
        }
    }

    protected EntityHitResult findHitEntity(Vec3 startVec, Vec3 endVec) {
        return ProjectileUtil.getEntityHitResult(this.level(), this, startVec, endVec, this.getBoundingBox().expandTowards(this.getDeltaMovement()).inflate(1.0), this::canHitEntity);
    }

    @Override
    protected boolean canHitEntity(Entity entity) {
        boolean canHit;
        if (entity instanceof Player targetPlayer) {
            Entity owner = this.getOwner();
            if (owner instanceof Player ownerPlayer) {
                if (!ownerPlayer.canHarmPlayer(targetPlayer)) {
                    canHit = false;
                    return canHit;
                }
            }
        }

        canHit = super.canHitEntity(entity);
        return canHit;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putShort("life", (short) this.life);
        if (this.lastState != null) {
            compoundTag.put("inBlockState", NbtUtils.writeBlockState(this.lastState));
        }

        compoundTag.putByte("shake", (byte) this.shakeTime);
        compoundTag.putByte("pickup", (byte) this.pickup.ordinal());
        compoundTag.putDouble("damage", this.baseDamage);
        compoundTag.putBoolean("crit", this.isCritArrow());
        compoundTag.putString("SoundEvent", BuiltInRegistries.SOUND_EVENT.getKey(this.soundEvent).toString());
        if (this.firedFromWeapon != null) {
            compoundTag.put("weapon", this.firedFromWeapon.save(this.registryAccess(), new CompoundTag()));
        }
        compoundTag.putInt("potency", this.potency);
        compoundTag.putInt("color", this.color.ordinal());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.life = compoundTag.getShort("life");
        if (compoundTag.contains("inBlockState", 10)) {
            this.lastState = NbtUtils.readBlockState(this.level().holderLookup(Registries.BLOCK), compoundTag.getCompound("inBlockState"));
        }

        this.shakeTime = compoundTag.getByte("shake") & 255;
        if (compoundTag.contains("damage", 99)) {
            this.baseDamage = compoundTag.getDouble("damage");
        }

        this.pickup = AbstractArrow.Pickup.byOrdinal(compoundTag.getByte("pickup"));
        this.setCritArrow(compoundTag.getBoolean("crit"));
        if (compoundTag.contains("SoundEvent", 8)) {
            this.soundEvent = BuiltInRegistries.SOUND_EVENT.getOptional(ResourceLocation.parse(compoundTag.getString("SoundEvent"))).orElse(this.getDefaultHitGroundSoundEvent());
        }

        if (compoundTag.contains("weapon", 10)) {
            this.firedFromWeapon = ItemStack.parse(this.registryAccess(), compoundTag.getCompound("weapon")).orElse(null);
        } else {
            this.firedFromWeapon = null;
        }
        this.potency = compoundTag.getInt("potency");
        this.color = Dart.Color.values()[compoundTag.getInt("color")];
    }

    @Override
    protected Entity.MovementEmission getMovementEmission() {
        return MovementEmission.NONE;
    }

    public void setBaseDamage(double baseDamage) {
        this.baseDamage = baseDamage;
    }

    public double getBaseDamage() {
        return this.baseDamage;
    }

    public boolean isAttackable() {
        return this.getType().is(EntityTypeTags.REDIRECTABLE_PROJECTILE);
    }

    public void setCritArrow(boolean critArrow) {
        this.setFlag(1, critArrow);
    }

    private void setFlag(int id, boolean value) {
        byte flags = this.entityData.get(ID_FLAGS);
        if (value) {
            this.entityData.set(ID_FLAGS, (byte) (flags | id));
        } else {
            this.entityData.set(ID_FLAGS, (byte) (flags & ~id));
        }
    }

    public boolean isCritArrow() {
        return (this.entityData.get(ID_FLAGS) & 1) != 0;
    }

    protected float getWaterInertia() {
        return 0.6F;
    }

    public void setNoPhysics(boolean noPhysics) {
        this.noPhysics = noPhysics;
        this.setFlag(2, noPhysics);
    }

    public boolean isNoPhysics() {
        return !this.level().isClientSide ? this.noPhysics : (this.entityData.get(ID_FLAGS) & 2) != 0;
    }

    @Override
    protected boolean shouldBounceOnWorldBorder() {
        return true;
    }

    public enum Color {
        GREEN(FAUtils.resource("textures/entity/darts/green_dart.png")),
        RED(FAUtils.resource("textures/entity/darts/red_dart.png")),
        BLUE(FAUtils.resource("textures/entity/darts/blue_dart.png"));

        private final ResourceLocation texture;

        Color(ResourceLocation texture) {
            this.texture = texture;
        }

        public ResourceLocation getTexture() {
            return this.texture;
        }
    }
}
