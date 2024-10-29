package willatendo.fossilslegacy.server.entity.dinosaur.cretaceous;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEggVariants;
import willatendo.fossilslegacy.server.entity.goal.*;
import willatendo.fossilslegacy.server.entity.util.BlockBreakRule;
import willatendo.fossilslegacy.server.entity.util.DinoUtils;
import willatendo.fossilslegacy.server.entity.util.interfaces.CoatTypeEntity;
import willatendo.fossilslegacy.server.entity.util.interfaces.CommandingType;
import willatendo.fossilslegacy.server.entity.util.interfaces.Diet;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.variants.EggVariant;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.tags.*;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.List;

public class Spinosaurus extends Dinosaur implements DinopediaInformation {
    private final BlockBreakRule blockBreakRule = new BlockBreakRule(this, 3, FossilsLegacyBlockTags.SPINOSAURUS_UNBREAKABLES);

    public Spinosaurus(EntityType<? extends Spinosaurus> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier spinosaurusAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 200.0F).add(Attributes.MOVEMENT_SPEED, 0.4D).add(Attributes.ATTACK_DAMAGE, 7.0D).build();
    }

    @Override
    public float maxUpStep() {
        return DinoUtils.getStepHeights(8, 1.0F, 2.0F)[this.getGrowthStage()];
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
    public TagKey<CoatType> getCoatTypes() {
        return FossilsLegacyCoatTypeTags.SPINOSAURUS;
    }

    @Override
    public Holder<EggVariant> getEggVariant() {
        return FossilsLegacyEggVariants.SPINOSAURUS;
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
    public boolean hurt(DamageSource damageSource, float hearts) {
        if (damageSource.is(FossilsLegacyDamgeTypeTags.SPINOSAURUS_IMMUNE)) {
            return false;
        }
        return super.hurt(damageSource, hearts);
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
        this.targetSelector.addGoal(4, new DinoNearestAttackableTargetGoal<>(this, FossilsLegacyEntityTypeTags.SPINOSAURUS_VICTIMS, true));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.getOverridenSoundEvent(FossilsLegacySoundEvents.SPINOSAURUS_AMBIENT.get(), CoatType.OverrideInfo.OverridenSoundType.AMBIENT);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return this.getOverridenSoundEvent(FossilsLegacySoundEvents.SPINOSAURUS_HURT.get(), CoatType.OverrideInfo.OverridenSoundType.HURT);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return this.getOverridenSoundEvent(FossilsLegacySoundEvents.SPINOSAURUS_DEATH.get(), CoatType.OverrideInfo.OverridenSoundType.DEATH);
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
            information.add(FossilsLegacyUtils.translation("dinopedia", "rideable"));
        } else {
            information.add(this.getDisplayName());
            if (this.isTame()) {
                information.add(FossilsLegacyUtils.translation("dinopedia", "not_owner"));
            } else {
                information.add(FossilsLegacyUtils.translation("dinopedia", "wild"));
                if (this.getAge() > 3) {
                    information.add(FossilsLegacyUtils.translation("dinopedia", "dangerous"));
                }
            }
        }
        return information;
    }

    @Override
    public CommandingType commandItems() {
        return CommandingType.tag(FossilsLegacyItemTags.SPINOSAURUS_COMMANDABLES);
    }
}
