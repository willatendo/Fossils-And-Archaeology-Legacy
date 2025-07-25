package willatendo.fossilslegacy.server.entity.entities.dinosaur.guadalupian;

import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;
import willatendo.fossilslegacy.server.dinopedia_type.FADinopediaTypes;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.entity.entities.Egg;
import willatendo.fossilslegacy.server.entity.goals.*;
import willatendo.fossilslegacy.server.entity.util.Diet;
import willatendo.fossilslegacy.server.entity.util.DinosaurUtils;
import willatendo.fossilslegacy.server.entity.util.interfaces.CommandingType;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.sound.FASoundEvents;
import willatendo.fossilslegacy.server.tags.FAEntityTypeTags;
import willatendo.fossilslegacy.server.tags.FAItemTags;
import willatendo.fossilslegacy.server.tags.FAModelTypeTags;

import java.util.Optional;

public class Dimetrodon extends Dinosaur implements DinopediaInformation {
    public Dimetrodon(EntityType<? extends Dimetrodon> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier dimetrodonAttributes() {
        return Animal.createAnimalAttributes().add(Attributes.MAX_HEALTH, 10.0F).add(Attributes.MOVEMENT_SPEED, 0.35D).add(Attributes.ATTACK_DAMAGE, 4.0D).build();
    }

    @Override
    public EntityType<Egg> getEggEntityType() {
        return FAEntityTypes.DIMETRODON_EGG.get();
    }

    @Override
    public float maxUpStep() {
        return DinosaurUtils.getStepHeights(this.getMaxGrowthStage(), 0.5F, 1.0F)[this.getGrowthStage()];
    }

    @Override
    public int getMaxHunger() {
        return 500;
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
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new DinoTemptGoal(this, 1.1D, false));
        this.goalSelector.addGoal(4, new DinoBabyFollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(6, new DinoWaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new DinoFollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
        this.goalSelector.addGoal(6, new DinoEatFromFeederGoal(this, 1.0D, 24, false));
        this.goalSelector.addGoal(6, new DinoEatFernsGoal(this));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new DinoOwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new DinoOwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(4, new DinoNearestAttackableTargetGoal<>(this, FAEntityTypeTags.DIMETRODON_VICTIMS, true));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return FASoundEvents.DIMETRODON_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return FASoundEvents.DIMETRODON_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return FASoundEvents.DIMETRODON_DEATH.get();
    }

    @Override
    public TagKey<ModelType> getModelTypes() {
        return FAModelTypeTags.DIMETRODON;
    }

    @Override
    public int getMaxGrowthStage() {
        return 12;
    }

    @Override
    public CommandingType commandItems() {
        return CommandingType.tag(FAItemTags.DIMETRODON_COMMANDABLES);
    }

    @Override
    public Optional<ResourceKey<DinopediaType>> getDinopediaType() {
        return Optional.of(FADinopediaTypes.DIMETRODON);
    }
}
