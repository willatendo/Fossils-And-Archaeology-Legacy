package willatendo.fossilslegacy.server.entity.util.interfaces;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.FAPatterns;
import willatendo.fossilslegacy.server.pregnancy_types.FAPregnancyTypes;
import willatendo.fossilslegacy.server.pregnancy_types.PregnancyType;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.Optional;

public interface PregnantAnimal<T extends Entity> extends TicksToBirth, SimpleLevelAccessor {
    int getRemainingPregnancyTime();

    void setRemainingPregnancyTime(int remainingPregnancyTime);

    @Override
    default int getRemainingTime() {
        return this.getRemainingPregnancyTime();
    }

    @Override
    default void setRemainingTime(int remainingPregnancyTime) {
        this.setRemainingPregnancyTime(remainingPregnancyTime);
    }

    Holder<PregnancyType> getPregnancyType();

    void setPregnancyType(Holder<PregnancyType> pregnancyType);

    Holder<ModelGene> getOffspringModelType();

    void setOffspringModelType(Holder<ModelGene> coatTypeHolder);

    void setOffspringSkin(Holder<PatternGene> pattern);

    Holder<PatternGene> getOffspringSkin();

    void setOffspringPattern(Holder<PatternGene> pattern);

    Holder<PatternGene> getOffspringPattern();

    T getBaseEntity(Level level);

    Component getPregnantDisplayName();

    float getPregnantHealth();

    float getPregnantMaxHealth();

    @Override
    default int maxTime() {
        return 6000;
    }

    default void onRemove(Mob original, Entity replaced) {
    }

    @Override
    default void onEntityTicksComplete(Mob mob, Entity offspring, Level level) {
        if (level instanceof ServerLevel serverLevel && offspring instanceof Mob mobOffspring) {
            mobOffspring.finalizeSpawn(serverLevel, level.getCurrentDifficultyAt(mob.blockPosition()), EntitySpawnReason.BREEDING, null);
        }
        Entity baseEntity = this.getBaseEntity(level);
        CompoundTag compoundTag = new CompoundTag();
        mob.save(compoundTag);
        baseEntity.load(compoundTag);
        mob.remove(Entity.RemovalReason.DISCARDED);
        level.addFreshEntity(baseEntity);
        this.onRemove(mob, baseEntity);
    }

    default void definePregnancyData(SynchedEntityData.Builder builder, RegistryAccess registryAccess, EntityDataAccessor<Integer> pregnancyTime, EntityDataAccessor<Holder<PregnancyType>> pregnancyType, EntityDataAccessor<Holder<ModelGene>> modelType, EntityDataAccessor<Holder<PatternGene>> skin, EntityDataAccessor<Holder<PatternGene>> pattern) {
        builder.define(pregnancyTime, 0);
        builder.define(pregnancyType, FABuiltInRegistries.PREGNANCY_TYPES.getOrThrow(FAPregnancyTypes.CAT.getKey()));
        builder.define(modelType, registryAccess.lookupOrThrow(FARegistries.MODEL_GENE).getAny().orElseThrow());
        builder.define(skin, registryAccess.lookupOrThrow(FARegistries.PATTERN_GENE).getAny().orElseThrow());
        builder.define(pattern, registryAccess.lookupOrThrow(FARegistries.PATTERN_GENE).getAny().orElse(this.getLevel().holderLookup(FARegistries.PATTERN_GENE).getOrThrow(FAPatterns.BLANK)));
    }

    default void addPregnancyData(CompoundTag compoundTag, HolderLookup.Provider provider) {
        compoundTag.putInt("pregnancy_time", this.getRemainingTime());
        this.getPregnancyType().unwrapKey().ifPresent(pregnancyType -> compoundTag.putString("pregnancy_type", pregnancyType.location().toString()));
        this.getOffspringModelType().unwrapKey().ifPresent(modelType -> compoundTag.putString("offspring_model_type", modelType.location().toString()));
        this.getOffspringSkin().unwrapKey().ifPresent(skin -> compoundTag.putString("offspring_skin", skin.location().toString()));
        if (this.getOffspringPattern() != null) {
            this.getOffspringPattern().unwrapKey().ifPresent(pattern -> compoundTag.putString("offspring_pattern", pattern.location().toString()));
        }
    }

    default void readPregnancyData(CompoundTag compoundTag, HolderLookup.Provider provider) {
        this.setRemainingPregnancyTime(compoundTag.getInt("pregnancy_time"));
        Optional.ofNullable(ResourceLocation.tryParse(compoundTag.getString("pregnancy_type"))).map(id -> ResourceKey.create(FARegistries.PREGNANCY_TYPE, id)).flatMap(resourceKey -> provider.lookupOrThrow(FARegistries.PREGNANCY_TYPE).get(resourceKey)).ifPresent(this::setPregnancyType);
        Optional.ofNullable(ResourceLocation.tryParse(compoundTag.getString("offspring_model_type"))).map(id -> ResourceKey.create(FARegistries.MODEL_GENE, id)).flatMap(resourceKey -> provider.lookupOrThrow(FARegistries.MODEL_GENE).get(resourceKey)).ifPresent(this::setOffspringModelType);
        Optional.ofNullable(ResourceLocation.tryParse(compoundTag.getString("offspring_skin"))).map(id -> ResourceKey.create(FARegistries.PATTERN_GENE, id)).flatMap(resourceKey -> provider.lookupOrThrow(FARegistries.PATTERN_GENE).get(resourceKey)).ifPresent(this::setOffspringSkin);
        if (compoundTag.contains("offspring_pattern")) {
            Optional.ofNullable(ResourceLocation.tryParse(compoundTag.getString("offspring_pattern"))).map(id -> ResourceKey.create(FARegistries.PATTERN_GENE, id)).flatMap(resourceKey -> provider.lookupOrThrow(FARegistries.PATTERN_GENE).get(resourceKey)).ifPresent(this::setOffspringPattern);
        }
    }
}
