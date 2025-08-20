package willatendo.fossilslegacy.server.entity.entities.dinosaur.ordovician;

import net.minecraft.core.Registry;
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
import willatendo.fossilslegacy.server.entity.FAEntityDataSerializers;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.util.interfaces.ChromosomedEntity;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.gene.Chromosome;
import willatendo.fossilslegacy.server.gene.ChromosomeUtils;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAModelGeneTags;

public class IsotelusLarva extends WaterAnimal implements DinopediaInformation, ChromosomedEntity {
    private static final EntityDataAccessor<Chromosome> CHROMOSOME_1 = SynchedEntityData.defineId(IsotelusLarva.class, FAEntityDataSerializers.CHROMOSOME.get());
    private static final EntityDataAccessor<Chromosome> CHROMOSOME_2 = SynchedEntityData.defineId(IsotelusLarva.class, FAEntityDataSerializers.CHROMOSOME.get());
    public final Registry<ModelGene> modelGeneRegistry;
    public final Registry<PatternGene> patternGeneRegistry;
    public final Registry<SkinGene> skinGeneRegistry;
    public static int ticksToBeTrilobite = Math.abs(-24000);
    private int age;

    public IsotelusLarva(EntityType<? extends IsotelusLarva> entityType, Level level) {
        super(entityType, level);
        this.modelGeneRegistry = level.registryAccess().lookupOrThrow(FARegistries.MODEL_GENE);
        this.patternGeneRegistry = level.registryAccess().lookupOrThrow(FARegistries.PATTERN_GENE);
        this.skinGeneRegistry = level.registryAccess().lookupOrThrow(FARegistries.SKIN_GENE);
    }

    public static AttributeSupplier isotelusLarvaAttributes() {
        return Animal.createAnimalAttributes().add(Attributes.MAX_HEALTH, 1.0F).add(Attributes.MOVEMENT_SPEED, 0.01D).build();
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

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, EntitySpawnReason entitySpawnReason, SpawnGroupData spawnGroupData) {
        ChromosomeUtils.createRandomChromosomes(this, this.getRandom(), FAModelGeneTags.ISOTELUS_LARVA);
        return super.finalizeSpawn(serverLevelAccessor, difficultyInstance, entitySpawnReason, spawnGroupData);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(CHROMOSOME_1, Chromosome.BLANK);
        builder.define(CHROMOSOME_2, Chromosome.BLANK);
    }

    @Override
    public void setChromosome1(Chromosome chromosome) {
        this.entityData.set(CHROMOSOME_1, chromosome);
    }

    @Override
    public Chromosome getChromosome1() {
        return this.entityData.get(CHROMOSOME_1);
    }

    @Override
    public void setChromosome2(Chromosome chromosome) {
        this.entityData.set(CHROMOSOME_2, chromosome);
    }

    @Override
    public Chromosome getChromosome2() {
        return this.entityData.get(CHROMOSOME_2);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        this.saveChromosomes(compoundTag);
        compoundTag.putInt("age", this.age);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.loadChromosomes(compoundTag);
        this.setAge(compoundTag.getInt("age"));
    }

    @Override
    public CompoundTag saveWithoutId(CompoundTag compoundTag) {
        this.saveChromosomes(compoundTag);
        compoundTag.putInt("age", this.age);
        return super.saveWithoutId(compoundTag);
    }

    @Override
    public boolean save(CompoundTag compoundTag) {
        this.saveChromosomes(compoundTag);
        compoundTag.putInt("age", this.age);
        return super.save(compoundTag);
    }
}
