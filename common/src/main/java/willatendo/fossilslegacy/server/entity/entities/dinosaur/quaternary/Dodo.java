package willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;
import willatendo.fossilslegacy.server.dinopedia_type.FADinopediaTypes;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.entity.goals.*;
import willatendo.fossilslegacy.server.entity.util.interfaces.CommandingType;
import willatendo.fossilslegacy.server.entity.util.interfaces.Diet;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.util.interfaces.FloatDownEntity;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.sound.FASoundEvents;
import willatendo.fossilslegacy.server.tags.FACoatTypeTags;

import java.util.Optional;

public class Dodo extends Dinosaur implements DinopediaInformation, FloatDownEntity {
    public final AnimationState fallAnimationState = new AnimationState();
    public int eggTime = this.random.nextInt(6000) + 6000;

    public Dodo(EntityType<? extends Dodo> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier dodoAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0F).add(Attributes.MOVEMENT_SPEED, 0.25D).build();
    }

    @Override
    public AnimationState getFallAnimationState() {
        return this.fallAnimationState;
    }

    @Override
    public boolean tamesOnBirth() {
        return true;
    }

    @Override
    public int getMaxHunger() {
        return 100;
    }

    @Override
    public TagKey<CoatType> getCoatTypes() {
        return FACoatTypeTags.DODO;
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        Dodo dodo = FAEntityTypes.DODO.get().create(serverLevel, EntitySpawnReason.BREEDING);
        dodo.setCoatType(this.getCoatType());
        return dodo;
    }

    @Override
    public int getMaxGrowthStage() {
        return 8;
    }

    @Override
    public double getMinHealth() {
        return 4.0F;
    }

    @Override
    public Diet getDiet() {
        return Diet.herbivore(this.level());
    }

    @Override
    public void aiStep() {
        super.aiStep();
        Vec3 vec3 = this.getDeltaMovement();
        if (!this.onGround() && vec3.y < 0.0) {
            this.setDeltaMovement(vec3.multiply(1.0, 0.6, 1.0));
        }

        if (this.level() instanceof ServerLevel serverLevel && this.isAlive() && !this.isBaby() && --this.eggTime <= 0) {
            this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.spawnAtLocation(serverLevel, FAItems.DODO_EGG.get());
            this.gameEvent(GameEvent.ENTITY_PLACE);
            this.eggTime = this.random.nextInt(6000) + 6000;
        }
    }

    @Override
    public void tick() {
        if (this.level().isClientSide()) {
            this.fallAnimationState.animateWhen(!this.onGround(), this.tickCount);
        }

        super.tick();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new DinoTemptGoal(this, 1.1D, false));
        this.goalSelector.addGoal(4, new DinoBabyFollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new DinoWaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new DinoFollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
        this.goalSelector.addGoal(5, new DinoEatFromFeederGoal(this, 1.0D, 24, false));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.getOverridenSoundEvent(FASoundEvents.DODO_AMBIENT.get(), CoatType.OverrideInfo.OverridenSoundType.AMBIENT);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return this.getOverridenSoundEvent(FASoundEvents.DODO_HURT.get(), CoatType.OverrideInfo.OverridenSoundType.HURT);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return this.getOverridenSoundEvent(FASoundEvents.DODO_DEATH.get(), CoatType.OverrideInfo.OverridenSoundType.DEATH);
    }

    @Override
    protected void playStepSound(BlockPos blockPos, BlockState blockState) {
        this.playSound(FASoundEvents.DODO_STEP.get(), 0.15F, 1.0F);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("EggLayTime", this.eggTime);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.contains("EggLayTime")) {
            this.eggTime = compoundTag.getInt("EggLayTime");
        }
    }

    @Override
    public Optional<ResourceKey<DinopediaType>> getDinopediaType() {
        return Optional.of(FADinopediaTypes.DODO);
    }

    @Override
    public CommandingType commandItems() {
        return CommandingType.hand();
    }
}
