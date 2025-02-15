package willatendo.fossilslegacy.server.entity.entities.pregnant;

import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;
import willatendo.fossilslegacy.server.dinopedia_type.FADinopediaTypes;
import willatendo.fossilslegacy.server.entity.FAEntityDataSerializers;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.util.interfaces.PregnantAnimal;
import willatendo.fossilslegacy.server.item.FALootTables;
import willatendo.fossilslegacy.server.pregnancy_types.PregnancyType;

import java.util.Optional;

public class PregnantSheep extends Sheep implements DinopediaInformation, PregnantAnimal<Sheep> {
    private static final EntityDataAccessor<Holder<CoatType>> OFFSPRING_COAT_TYPE = SynchedEntityData.defineId(PregnantSheep.class, FAEntityDataSerializers.COAT_TYPES.get());
    private static final EntityDataAccessor<Integer> PREGNANCY_TIME = SynchedEntityData.defineId(PregnantSheep.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Holder<PregnancyType>> PREGNANCY = SynchedEntityData.defineId(PregnantSheep.class, FAEntityDataSerializers.PREGNANCY_TYPES.get());

    public PregnantSheep(EntityType<? extends Sheep> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public ItemStack getPickResult() {
        return Items.SHEEP_SPAWN_EGG.getDefaultInstance();
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
        return this.getPregnancyType().value().entityType().get().create(level, EntitySpawnReason.BREEDING);
    }

    @Override
    public Sheep getBaseEntity(Level level) {
        return EntityType.SHEEP.create(level, EntitySpawnReason.BREEDING);
    }


    @Override
    public void shear(ServerLevel serverLevel, SoundSource soundSource, ItemStack itemStack) {
        serverLevel.playSound(null, this, SoundEvents.SHEEP_SHEAR, soundSource, 1.0F, 1.0F);
        this.dropFromShearingLootTable(serverLevel, FALootTables.SHEAR_PREGNANT_SHEEP, itemStack, (serverLevelIn, itemStackIn) -> {
            for (int i = 0; i < itemStackIn.getCount(); ++i) {
                ItemEntity itemEntity = this.spawnAtLocation(serverLevelIn, itemStackIn.copyWithCount(1), 1.0F);
                if (itemEntity != null) {
                    itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().add((this.random.nextFloat() - this.random.nextFloat()) * 0.1F, this.random.nextFloat() * 0.05F, ((this.random.nextFloat() - this.random.nextFloat()) * 0.1F)));
                }
            }
        });
        this.setSheared(true);
    }
}
