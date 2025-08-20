package willatendo.fossilslegacy.server.entity.util.interfaces;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
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
import willatendo.fossilslegacy.client.render.CageRenderer;
import willatendo.fossilslegacy.server.gene.Chromosome;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.FAPatternGenes;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;
import willatendo.fossilslegacy.server.pregnancy_types.FAPregnancyTypes;
import willatendo.fossilslegacy.server.pregnancy_types.PregnancyType;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.Optional;

public interface PregnantAnimal<T extends Entity> extends TicksToBirth {
    Registry<ModelGene> getModelGeneRegistry();

    Registry<SkinGene> getSkinGeneRegistry();

    Registry<PatternGene> getPatternGeneRegistry();

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

    Chromosome getOffspringChromosome1();

    void setOffspringChromosome1(Chromosome chromosome);

    Chromosome getOffspringChromosome2();

    void setOffspringChromosome2(Chromosome chromosome);

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

    default void definePregnancyData(SynchedEntityData.Builder builder, RegistryAccess registryAccess, EntityDataAccessor<Integer> pregnancyTime, EntityDataAccessor<Holder<PregnancyType>> pregnancyType, EntityDataAccessor<Chromosome> chromosome1, EntityDataAccessor<Chromosome> chromosome2) {
        builder.define(pregnancyTime, 0);
        builder.define(pregnancyType, FABuiltInRegistries.PREGNANCY_TYPES.getOrThrow(FAPregnancyTypes.CAT.getKey()));
        builder.define(chromosome1, Chromosome.BLANK);
        builder.define(chromosome2, Chromosome.BLANK);
    }

    default void addPregnancyData(CompoundTag compoundTag, HolderLookup.Provider provider) {
        compoundTag.putInt("pregnancy_time", this.getRemainingTime());
        this.getPregnancyType().unwrapKey().ifPresent(pregnancyType -> compoundTag.putString("pregnancy_type", pregnancyType.location().toString()));
        CompoundTag chromosome1 = new CompoundTag();
        this.getOffspringChromosome1().saveAdditional(chromosome1);
        compoundTag.put("offspring_chromosome_1", chromosome1);
        CompoundTag chromosome2 = new CompoundTag();
        this.getOffspringChromosome2().saveAdditional(chromosome2);
        compoundTag.put("offspring_chromosome_2", chromosome2);
    }

    default void readPregnancyData(CompoundTag compoundTag, HolderLookup.Provider provider) {
        this.setRemainingPregnancyTime(compoundTag.getInt("pregnancy_time"));
        Optional.ofNullable(ResourceLocation.tryParse(compoundTag.getString("pregnancy_type"))).map(id -> ResourceKey.create(FARegistries.PREGNANCY_TYPE, id)).flatMap(resourceKey -> provider.lookupOrThrow(FARegistries.PREGNANCY_TYPE).get(resourceKey)).ifPresent(this::setPregnancyType);
        this.setOffspringChromosome1(Chromosome.loadAdditional(compoundTag.getCompound("offspring_chromosome_1")));
        this.setOffspringChromosome2(Chromosome.loadAdditional(compoundTag.getCompound("offspring_chromosome_2")));
    }
}
