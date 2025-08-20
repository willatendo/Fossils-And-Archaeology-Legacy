package willatendo.fossilslegacy.server.entity.entities.pregnant;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;
import willatendo.fossilslegacy.server.dinopedia_type.FADinopediaTypes;
import willatendo.fossilslegacy.server.entity.FAEntityDataSerializers;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.util.interfaces.PregnantAnimal;
import willatendo.fossilslegacy.server.gene.Chromosome;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;
import willatendo.fossilslegacy.server.pregnancy_types.PregnancyType;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.Optional;

public class PregnantPig extends Pig implements DinopediaInformation, PregnantAnimal<Pig> {
    private static final EntityDataAccessor<Integer> PREGNANCY_TIME = SynchedEntityData.defineId(PregnantPig.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Holder<PregnancyType>> PREGNANCY_TYPE = SynchedEntityData.defineId(PregnantPig.class, FAEntityDataSerializers.PREGNANCY_TYPES.get());
    private static final EntityDataAccessor<Chromosome> CHROMOSOME_1 = SynchedEntityData.defineId(PregnantPig.class, FAEntityDataSerializers.CHROMOSOME.get());
    private static final EntityDataAccessor<Chromosome> CHROMOSOME_2 = SynchedEntityData.defineId(PregnantPig.class, FAEntityDataSerializers.CHROMOSOME.get());
    public final Registry<ModelGene> modelGeneRegistry;
    public final Registry<PatternGene> patternGeneRegistry;
    public final Registry<SkinGene> skinGeneRegistry;

    public PregnantPig(EntityType<? extends Pig> entityType, Level level) {
        super(entityType, level);
        this.modelGeneRegistry = level.registryAccess().lookupOrThrow(FARegistries.MODEL_GENE);
        this.patternGeneRegistry = level.registryAccess().lookupOrThrow(FARegistries.PATTERN_GENE);
        this.skinGeneRegistry = level.registryAccess().lookupOrThrow(FARegistries.SKIN_GENE);
    }

    @Override
    public Registry<ModelGene> getModelGeneRegistry() {
        return this.modelGeneRegistry;
    }

    @Override
    public Registry<SkinGene> getSkinGeneRegistry() {
        return this.skinGeneRegistry;
    }

    @Override
    public Registry<PatternGene> getPatternGeneRegistry() {
        return this.patternGeneRegistry;
    }

    @Override
    public ItemStack getPickResult() {
        return Items.PIG_SPAWN_EGG.getDefaultInstance();
    }

    @Override
    public boolean canBreed() {
        return false;
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
        this.definePregnancyData(builder, this.registryAccess(), PREGNANCY_TIME, PREGNANCY_TYPE, CHROMOSOME_1, CHROMOSOME_2);
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
    public Chromosome getOffspringChromosome1() {
        return this.entityData.get(CHROMOSOME_1);
    }

    @Override
    public void setOffspringChromosome1(Chromosome chromosome) {
        this.entityData.set(CHROMOSOME_1, chromosome);
    }

    @Override
    public Chromosome getOffspringChromosome2() {
        return this.entityData.get(CHROMOSOME_2);
    }

    @Override
    public void setOffspringChromosome2(Chromosome chromosome) {
        this.entityData.set(CHROMOSOME_2, chromosome);
    }

    @Override
    public Entity getOffspring(Level level) {
        return this.getPregnancyType().value().entityType().get().create(level, EntitySpawnReason.BREEDING);
    }

    @Override
    public Pig getBaseEntity(Level level) {
        return EntityType.PIG.create(level, EntitySpawnReason.BREEDING);
    }
}
