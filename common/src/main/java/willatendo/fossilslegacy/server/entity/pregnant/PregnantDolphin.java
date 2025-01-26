package willatendo.fossilslegacy.server.entity.pregnant;

import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityDataSerializers;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.util.interfaces.PregnantAnimal;
import willatendo.fossilslegacy.server.entity.variants.PregnancyType;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.item.dinopedia.DinopediaType;
import willatendo.fossilslegacy.server.item.dinopedia.FossilsLegacyDinopediaTypes;

import java.util.Optional;

public class PregnantDolphin extends Dolphin implements DinopediaInformation, PregnantAnimal<Dolphin> {
    private static final EntityDataAccessor<Holder<CoatType>> OFFSPRING_COAT_TYPE = SynchedEntityData.defineId(PregnantDolphin.class, FossilsLegacyEntityDataSerializers.COAT_TYPES.get());
    private static final EntityDataAccessor<Integer> PREGNANCY_TIME = SynchedEntityData.defineId(PregnantDolphin.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Holder<PregnancyType>> PREGNANCY = SynchedEntityData.defineId(PregnantDolphin.class, FossilsLegacyEntityDataSerializers.PREGNANCY_TYPES.get());

    public PregnantDolphin(EntityType<? extends Dolphin> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public ItemStack getPickResult() {
        return Items.DOLPHIN_SPAWN_EGG.getDefaultInstance();
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
        return Optional.of(FossilsLegacyDinopediaTypes.PREGNANT_ANIMAL);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        this.addRemainingPregnancyTime(compoundTag);
        this.addPregnancyData(compoundTag);
        this.addCoatTypeData(compoundTag);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.readRemainingPregnancyTime(compoundTag);
        this.readPregnancyData(compoundTag);
        this.readCoatTypeData(compoundTag);
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
    public Holder<CoatType> getOffspringCoatType() {
        return this.entityData.get(OFFSPRING_COAT_TYPE);
    }

    @Override
    public void setOffspringCoatType(Holder<CoatType> coatTypeHolder) {
        this.entityData.set(OFFSPRING_COAT_TYPE, coatTypeHolder);
    }

    @Override
    public Entity getOffspring(Level level) {
        return this.getPregnancyType().value().entityType().get().create(level);
    }

    @Override
    public Dolphin getBaseEntity(Level level) {
        return EntityType.DOLPHIN.create(level);
    }
}
