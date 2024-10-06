package willatendo.fossilslegacy.server.entity.dinosaur.cretaceous;

import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEggVariants;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityDataSerializers;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.tags.FossilsLegacyCoatTypeTags;
import willatendo.fossilslegacy.server.entity.goal.*;
import willatendo.fossilslegacy.server.entity.util.DinoUtils;
import willatendo.fossilslegacy.server.entity.util.interfaces.CoatTypeEntity;
import willatendo.fossilslegacy.server.entity.util.interfaces.CommandingType;
import willatendo.fossilslegacy.server.entity.util.interfaces.Diet;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.variants.EggVariant;
import willatendo.fossilslegacy.server.tags.FossilsLegacyItemTags;
import willatendo.fossilslegacy.server.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.List;

public class Pachycephalosaurus extends Dinosaur implements DinopediaInformation, CoatTypeEntity {
    private static final EntityDataAccessor<Holder<CoatType>> COAT_TYPE = SynchedEntityData.defineId(Pachycephalosaurus.class, FossilsLegacyEntityDataSerializers.COAT_TYPES.get());

    public Pachycephalosaurus(EntityType<? extends Pachycephalosaurus> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier pachycephalosaurusAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0F).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 4.0D).build();
    }

    @Override
    protected EntityDimensions getDefaultDimensions(Pose pose) {
        CoatType coatType = this.getCoatType().value();
        CoatType.BoundingBoxInfo boundingBoxInfo = coatType.boundingBoxInfo();
        return this.dimensions = EntityDimensions.scalable(boundingBoxInfo.boundingBoxWidth() + (boundingBoxInfo.boundingBoxGrowth() * this.getGrowthStage()), boundingBoxInfo.boundingBoxHeight() + (boundingBoxInfo.boundingBoxGrowth() * this.getGrowthStage()));
    }

    @Override
    public void tick() {
        if (this.dimensions.width() != this.getEntityDimensions(this.getGrowthStage()).width() || this.dimensions.height() != this.getEntityDimensions(this.getGrowthStage()).height()) {
            this.refreshDimensions();
        }

        super.tick();
    }

    @Override
    protected Component getTypeName() {
        return this.getOverridenName(super.getTypeName());
    }

    @Override
    public float maxUpStep() {
        return DinoUtils.getStepHeights(8, 1.0F, 1.5F)[this.getGrowthStage()];
    }

    @Override
    public int getMaxHunger() {
        return 500;
    }

    @Override
    public TagKey<CoatType> getCoatTypes() {
        return FossilsLegacyCoatTypeTags.PACHYCEPHALOSAURUS;
    }

    @Override
    public Holder<EggVariant> getEggVariant() {
        return FossilsLegacyEggVariants.PACHYCEPHALOSAURUS;
    }

    @Override
    public int getMaxGrowthStage() {
        return 8;
    }

    @Override
    public float getBoundingBoxGrowth() {
        CoatType coatType = this.getCoatType().value();
        return coatType.boundingBoxInfo().boundingBoxGrowth();
    }

    @Override
    public double getMinHealth() {
        return 10.0F;
    }

    @Override
    public Diet getDiet() {
        return Diet.herbivore();
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
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(COAT_TYPE, this.registryAccess().registryOrThrow(FossilsLegacyRegistries.COAT_TYPES).getAny().orElseThrow());
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.getOverridenSoundEvent(FossilsLegacySoundEvents.PACHYCEPHALOSAURUS_AMBIENT.get(), CoatType.OverrideInfo.OverridenSoundType.AMBIENT);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return this.getOverridenSoundEvent(FossilsLegacySoundEvents.PACHYCEPHALOSAURUS_HURT.get(), CoatType.OverrideInfo.OverridenSoundType.HURT);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return this.getOverridenSoundEvent(FossilsLegacySoundEvents.PACHYCEPHALOSAURUS_DEATH.get(), CoatType.OverrideInfo.OverridenSoundType.DEATH);
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
        return CommandingType.tag(FossilsLegacyItemTags.PACHYCEPHALOSAURUS_COMMANDABLES);
    }
}