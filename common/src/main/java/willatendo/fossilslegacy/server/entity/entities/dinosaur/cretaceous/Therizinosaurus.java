package willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous;

import net.minecraft.network.chat.Component;
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
import willatendo.fossilslegacy.server.tags.FAItemTags;
import willatendo.fossilslegacy.server.tags.FAModelTypeTags;

import java.util.Optional;

public class Therizinosaurus extends Dinosaur implements DinopediaInformation {
    public Therizinosaurus(EntityType<? extends Therizinosaurus> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier therizinosaurusAttributes() {
        return Animal.createAnimalAttributes().add(Attributes.MAX_HEALTH, 5.0F).add(Attributes.MOVEMENT_SPEED, 0.15D).add(Attributes.ATTACK_DAMAGE, 7.0D).build();
    }

    @Override
    public EntityType<Egg> getEggEntityType() {
        return FAEntityTypes.THERIZINOSAURUS_EGG.get();
    }

    @Override
    protected Component getTypeName() {
        return this.getOverridenName(super.getTypeName());
    }

    @Override
    public float maxUpStep() {
        return DinosaurUtils.getStepHeights(this.getMaxGrowthStage(), 1.0F, 2.0F)[this.getGrowthStage()];
    }

    @Override
    public int getMaxHunger() {
        return 500;
    }

    @Override
    public TagKey<ModelType> getModelTypes() {
        return FAModelTypeTags.THERIZINOSAURUS;
    }

    @Override
    public int getMaxGrowthStage() {
        return 10;
    }

    @Override
    public Diet getDiet() {
        return Diet.herbivore(this.level());
    }

    @Override
    public float[] healthPerGrowthStage() {
        return DinosaurUtils.getHealths(this.getMaxGrowthStage(), 5.0F, 40.0F);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new DinoTemptGoal(this, 1.1D, false));
        this.goalSelector.addGoal(3, new DinoBabyFollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new DinoWaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new DinoFollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
        this.goalSelector.addGoal(5, new DinoEatFromFeederGoal(this, 1.0D, 24, false));
        this.goalSelector.addGoal(5, new DinoEatFernsGoal(this));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new DinoOwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new DinoOwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.getOverridenSoundEvent(FASoundEvents.THERIZINOSAURUS_AMBIENT.get(), ModelType.OverrideInfo.OverridenSoundType.AMBIENT);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return this.getOverridenSoundEvent(FASoundEvents.THERIZINOSAURUS_HURT.get(), ModelType.OverrideInfo.OverridenSoundType.HURT);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return this.getOverridenSoundEvent(FASoundEvents.THERIZINOSAURUS_DEATH.get(), ModelType.OverrideInfo.OverridenSoundType.DEATH);
    }

    @Override
    public Optional<ResourceKey<DinopediaType>> getDinopediaType() {
        return Optional.of(FADinopediaTypes.THERIZINOSAURUS);
    }

    @Override
    public CommandingType commandItems() {
        return CommandingType.tag(FAItemTags.THERIZINOSAURUS_COMMANDABLES);
    }
}
