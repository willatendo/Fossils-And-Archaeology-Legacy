package willatendo.fossilslegacy.server.entity;

import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.entity.genetics.cosmetics.FossilsLegacyCoatTypeTags;
import willatendo.fossilslegacy.server.entity.goal.*;
import willatendo.fossilslegacy.server.entity.util.interfaces.*;
import willatendo.fossilslegacy.server.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.List;

public class Smilodon extends Dinosaur implements DinopediaInformation, CoatTypeEntity, ShakingEntity {
    private static final EntityDataAccessor<Holder<CoatType>> COAT_TYPE = SynchedEntityData.defineId(Smilodon.class, FossilsLegacyEntityDataSerializers.COAT_TYPES.get());
    private static final EntityDataAccessor<Boolean> DATA_INTERESTED_ID = SynchedEntityData.defineId(Smilodon.class, EntityDataSerializers.BOOLEAN);
    private boolean isWet;
    private boolean isShaking;
    private float interestedAngle;
    private float interestedAngleO;
    private float shakeAnim;
    private float shakeAnimO;

    public Smilodon(EntityType<? extends Smilodon> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier smilodonAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0F).add(Attributes.MOVEMENT_SPEED, 0.23D).add(Attributes.ATTACK_DAMAGE, 5.0D).build();
    }

    @Override
    public float maxUpStep() {
        return 1.0F;
    }

    @Override
    public int getMaxHunger() {
        return 100;
    }

    @Override
    public TagKey<CoatType> getCoatTypes() {
        return FossilsLegacyCoatTypeTags.SMILODON;
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return FossilsLegacyEntityTypes.SMILODON.get().create(serverLevel);
    }

    @Override
    public int getMaxGrowthStage() {
        return 1;
    }

    @Override
    public double getMinHealth() {
        return 8.0D;
    }

    @Override
    public float getBoundingBoxGrowth() {
        return 0.0F;
    }

    @Override
    public Diet getDiet() {
        return Diet.carnivore();
    }

    @Override
    public float renderScaleWidth() {
        CoatType coatType = this.getCoatType().value();
        return coatType.ageScaleInfo().baseScaleWidth() + (coatType.ageScaleInfo().ageScale() * (float) this.getGrowthStage());
    }

    @Override
    public float renderScaleHeight() {
        CoatType coatType = this.getCoatType().value();
        return coatType.ageScaleInfo().baseScaleHeight() + (coatType.ageScaleInfo().ageScale() * (float) this.getGrowthStage());
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new DinoTemptGoal(this, 1.1D, false));
        this.goalSelector.addGoal(3, new DinoBabyFollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new DinoWaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new SmilodonBegGoal(this, 8.0f));
        this.goalSelector.addGoal(7, new DinoFollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
        this.goalSelector.addGoal(8, new DinoEatFromFeederGoal(this, 1.0D, 24, true));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new DinoOwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new DinoOwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(COAT_TYPE, this.registryAccess().registryOrThrow(FossilsLegacyRegistries.COAT_TYPES).getAny().orElseThrow());
        builder.define(DATA_INTERESTED_ID, false);
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (!this.level().isClientSide && this.isWet && !this.isShaking && !this.isPathFinding() && this.onGround()) {
            this.isShaking = true;
            this.shakeAnim = 0.0F;
            this.shakeAnimO = 0.0F;
            this.level().broadcastEntityEvent(this, (byte) 8);
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.isAlive()) {
            return;
        }
        this.interestedAngleO = this.interestedAngle;
        this.interestedAngle = this.isInterested() ? (this.interestedAngle += (1.0f - this.interestedAngle) * 0.4f) : (this.interestedAngle += (0.0f - this.interestedAngle) * 0.4f);
        if (this.isInWaterRainOrBubble()) {
            this.isWet = true;
            if (this.isShaking && !((Level) this.level()).isClientSide) {
                this.level().broadcastEntityEvent(this, (byte) 56);
                this.cancelShake();
            }
        } else if ((this.isWet || this.isShaking) && this.isShaking) {
            if (this.shakeAnim == 0.0f) {
                this.playSound(SoundEvents.WOLF_SHAKE, this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.0f);
                this.gameEvent(GameEvent.ENTITY_ACTION);
            }
            this.shakeAnimO = this.shakeAnim;
            this.shakeAnim += 0.05f;
            if (this.shakeAnimO >= 2.0f) {
                this.isWet = false;
                this.isShaking = false;
                this.shakeAnimO = 0.0f;
                this.shakeAnim = 0.0f;
            }
            if (this.shakeAnim > 0.4f) {
                float f = (float) this.getY();
                int i = (int) (Mth.sin((this.shakeAnim - 0.4f) * (float) Math.PI) * 7.0f);
                Vec3 vec3 = this.getDeltaMovement();
                for (int j = 0; j < i; ++j) {
                    float g = (this.random.nextFloat() * 2.0f - 1.0f) * this.getBbWidth() * 0.5f;
                    float h = (this.random.nextFloat() * 2.0f - 1.0f) * this.getBbWidth() * 0.5f;
                    ((Level) this.level()).addParticle(ParticleTypes.SPLASH, this.getX() + (double) g, f + 0.8f, this.getZ() + (double) h, vec3.x, vec3.y, vec3.z);
                }
            }
        }
    }

    @Override
    public void handleEntityEvent(byte event) {
        if (event == 8) {
            this.isShaking = true;
            this.shakeAnim = 0.0F;
            this.shakeAnimO = 0.0F;
        } else if (event == 56) {
            this.cancelShake();
        } else {
            super.handleEntityEvent(event);
        }
    }

    public float getTailAngle() {
        return this.isTame() ? (0.55F - (this.getMaxHealth() - this.getHealth()) * 0.02F) * (float) Math.PI : ((float) Math.PI / 5F);
    }

    private void cancelShake() {
        this.isShaking = false;
        this.shakeAnim = 0.0F;
        this.shakeAnimO = 0.0F;
    }

    public boolean isWet() {
        return this.isWet;
    }

    public boolean isShaking() {
        return this.isShaking;
    }

    public float getWetShade(float time) {
        return Math.min(0.5F + Mth.lerp(time, this.shakeAnimO, this.shakeAnim) / 2.0F * 0.5F, 1.0F);
    }

    @Override
    public float getHeadRollAngle(float f) {
        return Mth.lerp(f, this.interestedAngleO, this.interestedAngle) * 0.15f * (float) Math.PI;
    }

    @Override
    public float getBodyRollAngle(float ageInTicks, float max) {
        float f = (Mth.lerp(ageInTicks, this.shakeAnimO, this.shakeAnim) + max) / 1.8F;
        if (f < 0.0F) {
            f = 0.0F;
        } else if (f > 1.0F) {
            f = 1.0F;
        }

        return Mth.sin(f * (float) Math.PI) * Mth.sin(f * (float) Math.PI * 11.0F) * 0.15F * (float) Math.PI;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return FossilsLegacySoundEvents.SMILODON_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return FossilsLegacySoundEvents.SMILODON_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return FossilsLegacySoundEvents.SMILODON_DEATH.get();
    }

    public void setIsInterested(boolean interested) {
        this.entityData.set(DATA_INTERESTED_ID, interested);
    }

    public boolean isInterested() {
        return this.entityData.get(DATA_INTERESTED_ID);
    }

    @Override
    public Holder<CoatType> getCoatType() {
        return this.entityData.get(COAT_TYPE);
    }

    @Override
    public void setCoatType(Holder<CoatType> coatTypeHolder) {
        this.entityData.set(COAT_TYPE, coatTypeHolder);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        this.addCoatType(compoundTag);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.readCoatType(compoundTag);
    }

    @Override
    public List<Component> info(Player player) {
        ArrayList<Component> information = Lists.newArrayList();
        if (this.isTame() && this.isOwnedBy(player)) {
            information.add(this.getDisplayName());
            information.add(FossilsLegacyUtils.translation("dinopedia", "owner", this.getOwner() != null ? this.getOwner().getDisplayName().getString() : FossilsLegacyUtils.translation("encyclopedia", "wild").getString()));
            information.add(FossilsLegacyUtils.translation("dinopedia", "age", this.getDaysAlive()));
            information.add(FossilsLegacyUtils.translation("dinopedia", "health", (int) this.getHealth(), (int) this.getMaxHealth()));
            information.add(FossilsLegacyUtils.translation("dinopedia", "hunger", this.getHunger(), this.getMaxHunger()));
        } else {
            information.add(this.getDisplayName());
            if (this.isTame()) {
                information.add(FossilsLegacyUtils.translation("dinopedia", "not_owner"));
            } else {
                information.add(FossilsLegacyUtils.translation("dinopedia", "wild"));
            }
        }
        return information;
    }

    @Override
    public CommandingType commandItems() {
        return CommandingType.hand();
    }

    @Override
    public boolean isBaby() {
        return this.getGrowthStage() == 0;
    }
}
