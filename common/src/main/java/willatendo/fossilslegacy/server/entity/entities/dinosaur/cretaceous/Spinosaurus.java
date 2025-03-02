package willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous;

import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
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
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;
import willatendo.fossilslegacy.server.dinopedia_type.FADinopediaTypes;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.entity.entities.Egg;
import willatendo.fossilslegacy.server.entity.goals.*;
import willatendo.fossilslegacy.server.entity.util.BlockBreakRule;
import willatendo.fossilslegacy.server.entity.util.DinosaurUtils;
import willatendo.fossilslegacy.server.entity.util.interfaces.CommandingType;
import willatendo.fossilslegacy.server.entity.util.interfaces.Diet;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.sound.FASoundEvents;
import willatendo.fossilslegacy.server.tags.*;

import java.util.Optional;

public class Spinosaurus extends Dinosaur implements DinopediaInformation {
    private final BlockBreakRule blockBreakRule = new BlockBreakRule(this, 3, FABlockTags.SPINOSAURUS_UNBREAKABLES);

    public Spinosaurus(EntityType<? extends Spinosaurus> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier spinosaurusAttributes() {
        return Animal.createAnimalAttributes().add(Attributes.MAX_HEALTH, 200.0F).add(Attributes.MOVEMENT_SPEED, 0.4D).add(Attributes.ATTACK_DAMAGE, 7.0D).build();
    }

    @Override
    public EntityType<Egg> getEggEntityType() {
        return FAEntityTypes.SPINOSAURUS_EGG.get();
    }

    @Override
    public float maxUpStep() {
        return DinosaurUtils.getStepHeights(8, 1.0F, 2.0F)[this.getGrowthStage()];
    }

    @Override
    public boolean tamesOnBirth() {
        return false;
    }

    @Override
    public int getMaxHunger() {
        return 100;
    }

    @Override
    public TagKey<ModelType> getCoatTypes() {
        return FAModelTypeTags.SPINOSAURUS;
    }

    @Override
    public int getMaxGrowthStage() {
        return 8;
    }

    @Override
    public double getMinHealth() {
        return 15.0F;
    }

    @Override
    public Diet getDiet() {
        return Diet.piscivore(this.level());
    }

    @Override
    public boolean hurtServer(ServerLevel serverLevel, DamageSource damageSource, float hearts) {
        if (damageSource.is(FADamageTypeTags.SPINOSAURUS_IMMUNE)) {
            return false;
        }
        return super.hurtServer(serverLevel, damageSource, hearts);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.blockBreakRule.canUse()) {
            this.blockBreakRule.tick();
        }
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
        this.goalSelector.addGoal(6, new DinoEatFromFeederGoal(this, 1.0D, 24, true));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new DinoOwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new DinoOwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(4, new DinoNearestAttackableTargetGoal<>(this, FAEntityTypeTags.SPINOSAURUS_VICTIMS, true));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.getOverridenSoundEvent(FASoundEvents.SPINOSAURUS_AMBIENT.get(), ModelType.OverrideInfo.OverridenSoundType.AMBIENT);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return this.getOverridenSoundEvent(FASoundEvents.SPINOSAURUS_HURT.get(), ModelType.OverrideInfo.OverridenSoundType.HURT);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return this.getOverridenSoundEvent(FASoundEvents.SPINOSAURUS_DEATH.get(), ModelType.OverrideInfo.OverridenSoundType.DEATH);
    }

    @Override
    public Optional<ResourceKey<DinopediaType>> getDinopediaType() {
        return Optional.of(FADinopediaTypes.SPINOSAURUS);
    }

    @Override
    public CommandingType commandItems() {
        return CommandingType.tag(FAItemTags.SPINOSAURUS_COMMANDABLES);
    }
}
