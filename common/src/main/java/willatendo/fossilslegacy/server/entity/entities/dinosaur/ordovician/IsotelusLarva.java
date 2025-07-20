package willatendo.fossilslegacy.server.entity.entities.dinosaur.ordovician;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.ConversionParams;
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
import org.jetbrains.annotations.Nullable;
import willatendo.fossilslegacy.server.entity.FAEntityDataSerializers;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.util.interfaces.DataDrivenCosmetics;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pattern.FAPatterns;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAModelTypeTags;
import willatendo.fossilslegacy.server.tags.FAPatternTags;

public class IsotelusLarva extends WaterAnimal implements DinopediaInformation, DataDrivenCosmetics {
    private static final EntityDataAccessor<Holder<ModelType>> MODEL_TYPE = SynchedEntityData.defineId(IsotelusLarva.class, FAEntityDataSerializers.MODEL_TYPES.get());
    private static final EntityDataAccessor<Holder<Pattern>> SKIN = SynchedEntityData.defineId(IsotelusLarva.class, FAEntityDataSerializers.PATTERN.get());
    private static final EntityDataAccessor<Holder<Pattern>> PATTERN = SynchedEntityData.defineId(IsotelusLarva.class, FAEntityDataSerializers.PATTERN.get());
    public static int ticksToBeTrilobite = Math.abs(-24000);
    private int age;

    public IsotelusLarva(EntityType<? extends IsotelusLarva> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier isotelusLarvaAttributes() {
        return Animal.createAnimalAttributes().add(Attributes.MAX_HEALTH, 1.0F).add(Attributes.MOVEMENT_SPEED, 0.01D).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1.0D));
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (!this.level().isClientSide) {
            this.setAge(this.age + 1);
        }
    }

    private int getAge() {
        return this.age;
    }

    private void ageUp(int offset) {
        this.setAge(this.age + offset * 20);
    }

    private void setAge(int age) {
        this.age = age;
        if (this.age >= IsotelusLarva.ticksToBeTrilobite) {
            this.ageUp();
        }
    }

    private void ageUp() {
        if (this.level() instanceof ServerLevel serverlevel) {
            this.convertTo(FAEntityTypes.ISOTELUS.get(), ConversionParams.single(this, false, false), isotelus -> {
                isotelus.finalizeSpawn(serverlevel, this.level().getCurrentDifficultyAt(isotelus.blockPosition()), EntitySpawnReason.CONVERSION, null);
                isotelus.setPersistenceRequired();
                isotelus.fudgePositionAfterSizeChange(this.getDimensions(this.getPose()));
                this.playSound(SoundEvents.TADPOLE_GROW_UP, 0.15F, 1.0F);
            });
        }
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, EntitySpawnReason entitySpawnReason, SpawnGroupData spawnGroupData) {
        HolderLookup<ModelType> modelTypes = serverLevelAccessor.holderLookup(FARegistries.MODEL_TYPES);
        Holder<ModelType> modelType = modelTypes.getOrThrow(FAModelTypeTags.ISOTELUS_LARVA).getRandomElement(this.getRandom()).get();
        this.setModelType(modelType);
        HolderLookup<Pattern> patterns = serverLevelAccessor.holderLookup(FARegistries.PATTERN);
        Holder<Pattern> skin = patterns.getOrThrow(modelType.value().skins()).getRandomElement(this.getRandom()).get();
        this.setSkin(skin);
        if (skin.is(FAPatternTags.HAS_PATTERNS) && serverLevelAccessor.getRandom().nextInt(4) == 1) {
            Holder<Pattern> pattern = patterns.getOrThrow(modelType.value().patterns()).getRandomElement(this.getRandom()).get();
            this.setPattern(pattern);
        } else {
            this.setPattern(patterns.getOrThrow(FAPatterns.BLANK));
        }
        return super.finalizeSpawn(serverLevelAccessor, difficultyInstance, entitySpawnReason, spawnGroupData);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(MODEL_TYPE, this.registryAccess().lookupOrThrow(FARegistries.MODEL_TYPES).getAny().orElseThrow());
        builder.define(SKIN, this.registryAccess().lookupOrThrow(FARegistries.PATTERN).getAny().orElseThrow());
        builder.define(PATTERN, this.registryAccess().lookupOrThrow(FARegistries.PATTERN).getAny().orElse(this.level().holderLookup(FARegistries.PATTERN).getOrThrow(FAPatterns.BLANK)));
    }

    @Override
    public Holder<ModelType> getModelType() {
        return this.entityData.get(MODEL_TYPE);
    }

    @Override
    public void setModelType(Holder<ModelType> modelType) {
        this.entityData.set(MODEL_TYPE, modelType);
    }

    @Override
    public Holder<Pattern> getSkin() {
        return this.entityData.get(SKIN);
    }

    @Override
    public void setSkin(Holder<Pattern> pattern) {
        this.entityData.set(SKIN, pattern);
    }

    @Override
    public Holder<Pattern> getPattern() {
        return this.entityData.get(PATTERN);
    }

    @Override
    public void setPattern(Holder<Pattern> pattern) {
        this.entityData.set(PATTERN, pattern);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        this.addCosmeticsData(compoundTag, this.registryAccess());
        compoundTag.putInt("age", this.age);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.readCosmeticsData(compoundTag, this.registryAccess());
        this.setAge(compoundTag.getInt("age"));
    }

    @Override
    public CompoundTag saveWithoutId(CompoundTag compoundTag) {
        this.addCosmeticsData(compoundTag, this.registryAccess());
        compoundTag.putInt("age", this.age);
        return super.saveWithoutId(compoundTag);
    }

    @Override
    public boolean save(CompoundTag compoundTag) {
        this.addCosmeticsData(compoundTag, this.registryAccess());
        compoundTag.putInt("age", this.age);
        return super.save(compoundTag);
    }
}
