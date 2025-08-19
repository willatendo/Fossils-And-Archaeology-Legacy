package willatendo.fossilslegacy.server.entity.entities.dinosaur.ordovician;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import willatendo.fossilslegacy.server.entity.FAEntityDataSerializers;
import willatendo.fossilslegacy.server.entity.util.interfaces.DataDrivenCosmetics;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.FAPatterns;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAModelTypeTags;
import willatendo.fossilslegacy.server.tags.FAPatternTags;

public class Isotelus extends WaterAnimal implements DinopediaInformation, DataDrivenCosmetics {
    private static final EntityDataAccessor<Holder<ModelGene>> MODEL_TYPE = SynchedEntityData.defineId(Isotelus.class, FAEntityDataSerializers.MODEL_TYPES.get());
    private static final EntityDataAccessor<Holder<PatternGene>> SKIN = SynchedEntityData.defineId(Isotelus.class, FAEntityDataSerializers.PATTERN.get());
    private static final EntityDataAccessor<Holder<PatternGene>> PATTERN = SynchedEntityData.defineId(Isotelus.class, FAEntityDataSerializers.PATTERN.get());

    public Isotelus(EntityType<? extends Isotelus> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier isotelusAttributes() {
        return Animal.createAnimalAttributes().add(Attributes.MAX_HEALTH, 5.0F).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ARMOR, 2.0D).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1.0D));
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, EntitySpawnReason entitySpawnReason, SpawnGroupData spawnGroupData) {
        HolderLookup<ModelGene> modelTypes = serverLevelAccessor.holderLookup(FARegistries.MODEL_GENE);
        Holder<ModelGene> modelType = modelTypes.getOrThrow(FAModelTypeTags.ISOTELUS).getRandomElement(this.getRandom()).get();
        this.setModelType(modelType);
        HolderLookup<PatternGene> patterns = serverLevelAccessor.holderLookup(FARegistries.PATTERN_GENE);
        Holder<PatternGene> skin = patterns.getOrThrow(modelType.value().skinGenes()).getRandomElement(this.getRandom()).get();
        this.setSkin(skin);
        if (skin.is(FAPatternTags.HAS_PATTERNS) && serverLevelAccessor.getRandom().nextInt(4) == 1) {
            Holder<PatternGene> pattern = patterns.getOrThrow(modelType.value().patternGenes()).getRandomElement(this.getRandom()).get();
            this.setPattern(pattern);
        } else {
            this.setPattern(patterns.getOrThrow(FAPatterns.BLANK));
        }
        return super.finalizeSpawn(serverLevelAccessor, difficultyInstance, entitySpawnReason, spawnGroupData);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(MODEL_TYPE, this.registryAccess().lookupOrThrow(FARegistries.MODEL_GENE).getAny().orElseThrow());
        builder.define(SKIN, this.registryAccess().lookupOrThrow(FARegistries.PATTERN_GENE).getAny().orElseThrow());
        builder.define(PATTERN, this.registryAccess().lookupOrThrow(FARegistries.PATTERN_GENE).getAny().orElse(this.level().holderLookup(FARegistries.PATTERN_GENE).getOrThrow(FAPatterns.BLANK)));
    }

    @Override
    public Holder<ModelGene> getModelType() {
        return this.entityData.get(MODEL_TYPE);
    }

    @Override
    public void setModelType(Holder<ModelGene> modelType) {
        this.entityData.set(MODEL_TYPE, modelType);
    }

    @Override
    public Holder<PatternGene> getSkin() {
        return this.entityData.get(SKIN);
    }

    @Override
    public void setSkin(Holder<PatternGene> pattern) {
        this.entityData.set(SKIN, pattern);
    }

    @Override
    public Holder<PatternGene> getPattern() {
        return this.entityData.get(PATTERN);
    }

    @Override
    public void setPattern(Holder<PatternGene> pattern) {
        this.entityData.set(PATTERN, pattern);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        this.addCosmeticsData(compoundTag, this.registryAccess());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.readCosmeticsData(compoundTag, this.registryAccess());
    }

    @Override
    public CompoundTag saveWithoutId(CompoundTag compoundTag) {
        this.addCosmeticsData(compoundTag, this.registryAccess());
        return super.saveWithoutId(compoundTag);
    }

    @Override
    public boolean save(CompoundTag compoundTag) {
        this.addCosmeticsData(compoundTag, this.registryAccess());
        return super.save(compoundTag);
    }
}
