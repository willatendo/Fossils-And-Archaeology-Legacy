package willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;
import willatendo.fossilslegacy.server.dinopedia_type.FADinopediaTypes;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.entity.goals.*;
import willatendo.fossilslegacy.server.entity.util.Diet;
import willatendo.fossilslegacy.server.entity.util.DinosaurUtils;
import willatendo.fossilslegacy.server.entity.util.interfaces.AnimatedSittingEntity;
import willatendo.fossilslegacy.server.entity.util.interfaces.CommandingType;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.util.interfaces.ShakingEntity;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.sound.FASoundEvents;
import willatendo.fossilslegacy.server.tags.FAModelTypeTags;

import java.util.Optional;

public class Smilodon extends Dinosaur implements DinopediaInformation, ShakingEntity, AnimatedSittingEntity {
    private static final EntityDataAccessor<Boolean> DATA_INTERESTED_ID = SynchedEntityData.defineId(Smilodon.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState sitAnimationState = new AnimationState();
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
        return Animal.createAnimalAttributes().add(Attributes.MAX_HEALTH, 5.0F).add(Attributes.MOVEMENT_SPEED, 0.23D).add(Attributes.ATTACK_DAMAGE, 5.0D).build();
    }

    @Override
    public AnimationState getSitAnimationState() {
        return this.sitAnimationState;
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
    public TagKey<ModelGene> getModelTypes() {
        return FAModelTypeTags.SMILODON;
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        Smilodon smilodon = FAEntityTypes.SMILODON.get().create(serverLevel, EntitySpawnReason.BREEDING);
        smilodon.setModelType(this.getModelType());
        return smilodon;
    }

    @Override
    public int getMaxGrowthStage() {
        return 8;
    }

    @Override
    public Diet getDiet() {
        return Diet.carnivore(this.level());
    }

    @Override
    public float[] healthPerGrowthStage() {
        return DinosaurUtils.getHealths(this.getMaxGrowthStage(), 5.0F, 20.0F);
    }

    @Override
    protected ItemStack getHead() {
        return new ItemStack(FAItems.SMILODON_HEAD.get());
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
        if (this.level().isClientSide()) {
            this.sitAnimationState.animateWhen(this.isOrderedToSit(), this.tickCount);
        }

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
                    this.level().addParticle(ParticleTypes.SPLASH, this.getX() + (double) g, f + 0.8f, this.getZ() + (double) h, vec3.x, vec3.y, vec3.z);
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

    @Override
    public boolean isWet() {
        return this.isWet;
    }

    public boolean isShaking() {
        return this.isShaking;
    }

    public float getWetShade(float partialTicks) {
        return Math.min(0.5F + Mth.lerp(partialTicks, this.shakeAnimO, this.shakeAnim) / 2.0F * 0.5F, 1.0F);
    }

    public float getInterestedAngle() {
        return this.interestedAngle;
    }

    public float getInterestedAngleO() {
        return this.interestedAngleO;
    }

    public float shakeAnim() {
        return this.shakeAnim;
    }

    public float shakeAnim0() {
        return this.shakeAnimO;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.getOverridenSoundEvent(FASoundEvents.SMILODON_AMBIENT.get(), ModelGene.OverrideInfo.OverridenSoundType.AMBIENT);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return this.getOverridenSoundEvent(FASoundEvents.SMILODON_HURT.get(), ModelGene.OverrideInfo.OverridenSoundType.HURT);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return this.getOverridenSoundEvent(FASoundEvents.SMILODON_DEATH.get(), ModelGene.OverrideInfo.OverridenSoundType.DEATH);
    }

    public void setIsInterested(boolean interested) {
        this.entityData.set(DATA_INTERESTED_ID, interested);
    }

    public boolean isInterested() {
        return this.entityData.get(DATA_INTERESTED_ID);
    }

    @Override
    public Optional<ResourceKey<DinopediaType>> getDinopediaType() {
        return Optional.of(FADinopediaTypes.SMILODON);
    }

    @Override
    public CommandingType commandItems() {
        return CommandingType.hand();
    }
}
