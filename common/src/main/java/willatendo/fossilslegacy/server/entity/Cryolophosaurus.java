package willatendo.fossilslegacy.server.entity;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
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
import willatendo.fossilslegacy.server.entity.goal.*;
import willatendo.fossilslegacy.server.entity.util.CommandType;
import willatendo.fossilslegacy.server.entity.util.Diet;
import willatendo.fossilslegacy.server.entity.util.DinoUtils;
import willatendo.fossilslegacy.server.entity.util.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.variants.EggVariant;
import willatendo.fossilslegacy.server.item.FossilsLegacyItemTags;
import willatendo.fossilslegacy.server.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.List;

public class Cryolophosaurus extends Dinosaur implements DinopediaInformation {
    public Cryolophosaurus(EntityType<? extends Cryolophosaurus> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier cryolophosaurusAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0F).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 6.0D).build();
    }

    @Override
    public float maxUpStep() {
        return DinoUtils.getStepHeights(8, 1.0F, 2.0F)[this.getGrowthStage()];
    }

    @Override
    public int getMaxHunger() {
        return 500;
    }

    @Override
    public Holder<EggVariant> getEggVariant() {
        return FossilsLegacyEggVariants.CRYOLOPHOSAURUS;
    }

    @Override
    public int getMaxGrowthStage() {
        return 8;
    }

    @Override
    public float getBoundingBoxGrowth() {
        return 0.35F;
    }

    @Override
    public double getMinHealth() {
        return 10.0F;
    }

    @Override
    public Diet getDiet() {
        return Diet.carnivore();
    }

    @Override
    public float renderScaleWidth() {
        return 0.25F + (0.2F * (float) this.getGrowthStage());
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
        this.targetSelector.addGoal(4, new DinoNearestAttackableTargetGoal<>(this, LivingEntity.class, true));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return FossilsLegacySoundEvents.CRYOLOPHOSAURUS_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return FossilsLegacySoundEvents.CRYOLOPHOSAURUS_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return FossilsLegacySoundEvents.CRYOLOPHOSAURUS_DEATH.get();
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
    public CommandType commandItems() {
        return CommandType.tag(FossilsLegacyItemTags.CRYOLOPHOSAURUS_COMMANDABLES);
    }
}
