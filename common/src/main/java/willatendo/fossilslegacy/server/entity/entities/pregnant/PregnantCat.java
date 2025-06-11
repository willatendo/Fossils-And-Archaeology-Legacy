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
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;
import willatendo.fossilslegacy.server.dinopedia_type.FADinopediaTypes;
import willatendo.fossilslegacy.server.entity.FAEntityDataSerializers;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.util.interfaces.PregnantAnimal;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;
import willatendo.fossilslegacy.server.pregnancy_types.PregnancyType;

import java.util.Optional;

public class PregnantCat extends Cat implements DinopediaInformation, PregnantAnimal<Cat> {
    private static final EntityDataAccessor<Integer> PREGNANCY_TIME = SynchedEntityData.defineId(PregnantCat.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Holder<PregnancyType>> PREGNANCY_TYPE = SynchedEntityData.defineId(PregnantCat.class, FAEntityDataSerializers.PREGNANCY_TYPES.get());
    private static final EntityDataAccessor<Holder<ModelType>> OFFSPRING_MODEL_TYPE = SynchedEntityData.defineId(PregnantCat.class, FAEntityDataSerializers.MODEL_TYPES.get());
    private static final EntityDataAccessor<Holder<Pattern>> OFFSPRING_SKIN = SynchedEntityData.defineId(PregnantCat.class, FAEntityDataSerializers.PATTERN.get());
    private static final EntityDataAccessor<Holder<Pattern>> OFFSPRING_PATTERN = SynchedEntityData.defineId(PregnantCat.class, FAEntityDataSerializers.PATTERN.get());

    public PregnantCat(EntityType<? extends Cat> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public ItemStack getPickResult() {
        return Items.CAT_SPAWN_EGG.getDefaultInstance();
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
        this.addPregnancyData(compoundTag, this.registryAccess());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.readPregnancyData(compoundTag, this.registryAccess());
    }

    @Override
    public boolean save(CompoundTag compoundTag) {
        this.addPregnancyData(compoundTag, this.registryAccess());
        return super.save(compoundTag);
    }

    @Override
    public CompoundTag saveWithoutId(CompoundTag compoundTag) {
        this.addPregnancyData(compoundTag, this.registryAccess());
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
        this.definePregnancyData(builder, this.registryAccess(), PREGNANCY_TIME, PREGNANCY_TYPE, OFFSPRING_MODEL_TYPE, OFFSPRING_SKIN, OFFSPRING_PATTERN);
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
        return this.entityData.get(PREGNANCY_TYPE);
    }

    @Override
    public void setPregnancyType(Holder<PregnancyType> pregnancyType) {
        this.entityData.set(PREGNANCY_TYPE, pregnancyType);
    }

    @Override
    public Holder<ModelType> getOffspringModelType() {
        return this.entityData.get(OFFSPRING_MODEL_TYPE);
    }

    @Override
    public void setOffspringModelType(Holder<ModelType> coatTypeHolder) {
        this.entityData.set(OFFSPRING_MODEL_TYPE, coatTypeHolder);
    }

    @Override
    public void setOffspringSkin(Holder<Pattern> pattern) {
        this.entityData.set(OFFSPRING_SKIN, pattern);
    }

    @Override
    public Holder<Pattern> getOffspringSkin() {
        return this.entityData.get(OFFSPRING_SKIN);
    }

    @Override
    public void setOffspringPattern(Holder<Pattern> pattern) {
        this.entityData.set(OFFSPRING_PATTERN, pattern);
    }

    @Override
    public Holder<Pattern> getOffspringPattern() {
        return this.entityData.get(OFFSPRING_PATTERN);
    }

    @Override
    public Entity getOffspring(Level level) {
        return this.getPregnancyType().value().entityType().get().create(level, EntitySpawnReason.BREEDING);
    }

    @Override
    public Cat getBaseEntity(Level level) {
        return EntityType.CAT.create(level, EntitySpawnReason.BREEDING);
    }
}
