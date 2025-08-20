package willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary;

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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;
import willatendo.fossilslegacy.server.dinopedia_type.FADinopediaTypes;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.entity.goals.DinoEatFromFeederGoal;
import willatendo.fossilslegacy.server.entity.goals.DinoOwnerHurtByTargetGoal;
import willatendo.fossilslegacy.server.entity.goals.DinoOwnerHurtTargetGoal;
import willatendo.fossilslegacy.server.entity.goals.DinoTemptGoal;
import willatendo.fossilslegacy.server.entity.util.Diet;
import willatendo.fossilslegacy.server.entity.util.DinosaurUtils;
import willatendo.fossilslegacy.server.entity.util.interfaces.CommandingType;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.sound.FASoundEvents;
import willatendo.fossilslegacy.server.tags.FAModelGeneTags;

import java.util.Optional;

public class Elasmotherium extends Dinosaur implements DinopediaInformation {
    public Elasmotherium(EntityType<? extends Elasmotherium> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier elasmotheriumAttributes() {
        return Animal.createAnimalAttributes().add(Attributes.MAX_HEALTH, 5.0F).add(Attributes.MOVEMENT_SPEED, 0.23D).add(Attributes.ATTACK_DAMAGE, 3.0D).build();
    }

    @Override
    public float maxUpStep() {
        return DinosaurUtils.getStepHeights(this.getMaxGrowthStage(), 0.5F, 1.5F)[this.getGrowthStage()];
    }

    @Override
    public int getMaxHunger() {
        return 100;
    }

    @Override
    public TagKey<ModelGene> getModelTypes() {
        return FAModelGeneTags.ELASMOTHERIUM;
    }

    @Override
    public CommandingType commandItems() {
        return CommandingType.hand();
    }

    @Override
    public int getMaxGrowthStage() {
        return 8;
    }

    @Override
    public Diet getDiet() {
        return Diet.herbivore(this.level());
    }

    @Override
    public float[] healthPerGrowthStage() {
        return DinosaurUtils.getHealths(this.getMaxGrowthStage(), 5.0F, 25.0F);
    }

    @Override
    protected ItemStack getHead() {
        return new ItemStack(FAItems.ELASMOTHERIUM_HEAD.get());
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new DinoTemptGoal(this, 1.1D, false));
        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(4, new EatBlockGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new DinoEatFromFeederGoal(this, 1.0D, 24, false));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new DinoOwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new DinoOwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.getOverridenSoundEvent(FASoundEvents.ELASMOTHERIUM_AMBIENT.get(), ModelGene.OverrideInfo.OverridenSoundType.AMBIENT, this.registryAccess());
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return this.getOverridenSoundEvent(FASoundEvents.ELASMOTHERIUM_HURT.get(), ModelGene.OverrideInfo.OverridenSoundType.HURT, this.registryAccess());
    }

    @Override
    protected SoundEvent getDeathSound() {
        return this.getOverridenSoundEvent(FASoundEvents.ELASMOTHERIUM_DEATH.get(), ModelGene.OverrideInfo.OverridenSoundType.DEATH, this.registryAccess());
    }

    @Override
    public Optional<ResourceKey<DinopediaType>> getDinopediaType() {
        return Optional.of(FADinopediaTypes.ELASMOTHERIUM);
    }
}
