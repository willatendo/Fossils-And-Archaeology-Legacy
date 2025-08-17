package willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;
import willatendo.fossilslegacy.server.dinopedia_type.FADinopediaTypes;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.DilophosaurusVenom;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.entity.entities.Egg;
import willatendo.fossilslegacy.server.entity.goals.*;
import willatendo.fossilslegacy.server.entity.util.Diet;
import willatendo.fossilslegacy.server.entity.util.DinosaurUtils;
import willatendo.fossilslegacy.server.entity.util.interfaces.CommandingType;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.sound.FASoundEvents;
import willatendo.fossilslegacy.server.tags.FAEntityTypeTags;
import willatendo.fossilslegacy.server.tags.FAItemTags;
import willatendo.fossilslegacy.server.tags.FAModelTypeTags;

import java.util.Optional;

public class Dilophosaurus extends Dinosaur implements DinopediaInformation, RangedAttackMob {
    private static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(Dilophosaurus.class, EntityDataSerializers.BOOLEAN);

    public Dilophosaurus(EntityType<? extends Dilophosaurus> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier dilophosaurusAttributes() {
        return Animal.createAnimalAttributes().add(Attributes.MAX_HEALTH, 5.0F).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 4.0D).build();
    }

    @Override
    public EntityType<Egg> getEggEntityType() {
        return FAEntityTypes.DILOPHOSAURUS_EGG.get();
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
    public TagKey<ModelType> getModelTypes() {
        return FAModelTypeTags.DILOPHOSAURUS;
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
        return DinosaurUtils.getHealths(this.getMaxGrowthStage(), 5.0F, 30.0F);
    }

    @Override
    protected ItemStack getHead() {
        return new ItemStack(FAItems.DILOPHOSAURUS_HEAD.get());
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new DinoTemptGoal(this, 1.1D, false));
        this.goalSelector.addGoal(3, new DinoBabyFollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(3, new Dilophosaurus.TexturedRangedAttackGoal(this, 1.25D, 20, 10.0F));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new DinoWaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new DinoFollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(6, new DinoEatFromFeederGoal(this, 1.0D, 24, true));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new DinoOwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new DinoOwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(4, new DinoNearestAttackableTargetGoal<>(this, FAEntityTypeTags.DILOPHOSAURUS_VICTIMS, true));
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(ATTACKING, false);
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float damage) {
        DilophosaurusVenom dilophosaurusVenom = new DilophosaurusVenom(this.level(), this);
        double headHeight = livingEntity.getEyeY() - (double) 1.1F;
        double x = livingEntity.getX() - this.getX();
        double y = headHeight - dilophosaurusVenom.getY();
        double z = livingEntity.getZ() - this.getZ();
        double p = Math.sqrt(x * x + z * z) * (double) 0.2F;
        dilophosaurusVenom.shoot(x, y + p, z, 1.6F, 12.0F);
        this.level().addFreshEntity(dilophosaurusVenom);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.random.nextInt(3) == 0 ? this.getOverridenSoundEvent(FASoundEvents.DILOPHOSAURUS_CALL.get(), ModelType.OverrideInfo.OverridenSoundType.AMBIENT) : this.getOverridenSoundEvent(FASoundEvents.DILOPHOSAURUS_AMBIENT.get(), ModelType.OverrideInfo.OverridenSoundType.AMBIENT);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return this.getOverridenSoundEvent(FASoundEvents.DILOPHOSAURUS_HURT.get(), ModelType.OverrideInfo.OverridenSoundType.HURT);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return this.getOverridenSoundEvent(FASoundEvents.DILOPHOSAURUS_DEATH.get(), ModelType.OverrideInfo.OverridenSoundType.DEATH);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("Attacking", this.isAttacking());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.setAttacking(compoundTag.getBoolean("Attacking"));
    }

    @Override
    public Optional<ResourceKey<DinopediaType>> getDinopediaType() {
        return Optional.of(FADinopediaTypes.DILOPHOSAURUS);
    }

    @Override
    public CommandingType commandItems() {
        return CommandingType.tag(FAItemTags.DILOPHOSAURUS_COMMANDABLES);
    }

    public static class TexturedRangedAttackGoal extends RangedAttackGoal {
        private final Dilophosaurus dilophosaurus;

        public TexturedRangedAttackGoal(Dilophosaurus dilophosaurus, double speedModifier, int attackIntervalMin, float attackIntervalMax) {
            super(dilophosaurus, speedModifier, attackIntervalMin, attackIntervalMax);
            this.dilophosaurus = dilophosaurus;
        }

        @Override
        public void start() {
            super.start();
            this.dilophosaurus.setAttacking(true);
        }

        @Override
        public void stop() {
            super.stop();
            this.dilophosaurus.setAttacking(false);
        }
    }
}
