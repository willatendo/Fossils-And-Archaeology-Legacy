package willatendo.fossilslegacy.server.entity.entities.pregnant;

import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;
import willatendo.fossilslegacy.server.dinopedia_type.FADinopediaTypes;
import willatendo.fossilslegacy.server.entity.FAEntityDataSerializers;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.util.interfaces.PregnantAnimal;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pregnancy_types.PregnancyType;

import java.util.Optional;

public class PregnantPolarBear extends PolarBear implements DinopediaInformation, PregnantAnimal<PolarBear> {
    private static final EntityDataAccessor<Holder<ModelType>> OFFSPRING_COAT_TYPE = SynchedEntityData.defineId(PregnantPolarBear.class, FAEntityDataSerializers.MODEL_TYPES.get());
    private static final EntityDataAccessor<Integer> PREGNANCY_TIME = SynchedEntityData.defineId(PregnantPolarBear.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Holder<PregnancyType>> PREGNANCY = SynchedEntityData.defineId(PregnantPolarBear.class, FAEntityDataSerializers.PREGNANCY_TYPES.get());

    public PregnantPolarBear(EntityType<? extends PolarBear> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public ItemStack getPickResult() {
        return Items.POLAR_BEAR_SPAWN_EGG.getDefaultInstance();
    }

    @Override
    public boolean canBreed() {
        return false;
    }

    @Override
    public Level getLevel() {
        return this.level();
    }

    @Override
    public Component getPregnantDisplayName() {
        return this.getDisplayName();
    }

    @Override
    public float getPregnantHealth() {
        return this.getHealth();
    }

    @Override
    public float getPregnantMaxHealth() {
        return this.getMaxHealth();
    }

    @Override
    public Optional<ResourceKey<DinopediaType>> getDinopediaType() {
        return Optional.of(FADinopediaTypes.PREGNANT_ANIMAL);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        this.addRemainingPregnancyTime(compoundTag);
        this.addPregnancyData(compoundTag);
        this.addPregnancyData(compoundTag);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.readRemainingPregnancyTime(compoundTag);
        this.readPregnancyData(compoundTag);
        this.readPregnancyData(compoundTag);
    }

    @Override
    public boolean save(CompoundTag compoundTag) {
        this.addRemainingPregnancyTime(compoundTag);
        this.addPregnancyData(compoundTag);
        this.addPregnancyData(compoundTag);
        return super.save(compoundTag);
    }

    @Override
    public CompoundTag saveWithoutId(CompoundTag compoundTag) {
        this.addRemainingPregnancyTime(compoundTag);
        this.addPregnancyData(compoundTag);
        this.addPregnancyData(compoundTag);
        return super.saveWithoutId(compoundTag);
    }

    @Override
    public void tick() {
        super.tick();
        this.birthTick(this, this.level());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        this.defineCoatTypeData(OFFSPRING_COAT_TYPE, builder);
        this.definePregnancyData(PREGNANCY, builder);
        builder.define(PREGNANCY_TIME, 0);
    }

    @Override
    public int getRemainingPregnancyTime() {
        return this.entityData.get(PREGNANCY_TIME);
    }

    @Override
    public void setRemainingPregnancyTime(int remainingPregnancyTime) {
        this.entityData.set(PREGNANCY_TIME, remainingPregnancyTime);
    }

    @Override
    public Holder<PregnancyType> getPregnancyType() {
        return this.entityData.get(PREGNANCY);
    }

    @Override
    public void setPregnancyType(Holder<PregnancyType> pregnancyType) {
        this.entityData.set(PREGNANCY, pregnancyType);
    }

    @Override
    public Holder<ModelType> getOffspringModelType() {
        return this.entityData.get(OFFSPRING_COAT_TYPE);
    }

    @Override
    public void setOffspringModelType(Holder<ModelType> coatTypeHolder) {
        this.entityData.set(OFFSPRING_COAT_TYPE, coatTypeHolder);
    }

    @Override
    public Entity getOffspring(Level level) {
        return this.getPregnancyType().value().entityType().get().create(level, EntitySpawnReason.BREEDING);
    }

    @Override
    public PolarBear getBaseEntity(Level level) {
        return EntityType.POLAR_BEAR.create(level, EntitySpawnReason.BREEDING);
    }
}
