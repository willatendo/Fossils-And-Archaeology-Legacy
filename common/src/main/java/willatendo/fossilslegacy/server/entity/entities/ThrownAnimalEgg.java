package willatendo.fossilslegacy.server.entity.entities;

import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.util.interfaces.ChromosomedEntity;
import willatendo.fossilslegacy.server.entity.util.interfaces.TamesOnBirth;
import willatendo.fossilslegacy.server.gene.Chromosome;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;
import willatendo.fossilslegacy.server.item.FAItems;

public class ThrownAnimalEgg extends ThrowableItemProjectile implements ChromosomedEntity {
    private EntityType<? extends Animal> animal;
    private Chromosome chromosome1;
    private Chromosome chromosome2;
    private boolean incubated;

    public ThrownAnimalEgg(EntityType<? extends ThrownAnimalEgg> entityType, Level level) {
        super(entityType, level);
        this.animal = EntityType.CHICKEN;
        this.incubated = false;
    }

    public ThrownAnimalEgg(Level level, LivingEntity livingEntity, EntityType<? extends Animal> animal, boolean incubated, ItemStack itemStack) {
        super(FAEntityTypes.THROWN_INCUBATED_EGG.get(), livingEntity, level, itemStack);
        this.animal = animal;
        this.incubated = incubated;
    }

    public ThrownAnimalEgg(Level level, double x, double y, double z, EntityType<? extends Animal> animal, boolean incubated, ItemStack itemStack) {
        super(FAEntityTypes.THROWN_INCUBATED_EGG.get(), x, y, z, level, itemStack);
        this.animal = animal;
        this.incubated = incubated;
    }

    @Override
    public void handleEntityEvent(byte event) {
        if (event == 3) {
            for (int i = 0; i < 8; ++i) {
                this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double) this.random.nextFloat() - 0.5D) * 0.08D, ((double) this.random.nextFloat() - 0.5D) * 0.08D, ((double) this.random.nextFloat() - 0.5D) * 0.08D);
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        entityHitResult.getEntity().hurt(this.damageSources().thrown(this, this.getOwner()), 0.0F);
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);

        if (!this.level().isClientSide()) {
            if (this.incubated || this.random.nextInt(8) == 0) {
                int i = 1;
                if (this.random.nextInt(32) == 0) {
                    i = 4;
                }

                for (int animals = 0; animals < i; ++animals) {
                    Animal animalToSpawn = this.animal.create(this.level(), EntitySpawnReason.TRIGGERED);
                    animalToSpawn.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    if (animalToSpawn instanceof ChromosomedEntity chromosomedEntity && this.chromosome1 != null && this.chromosome2 != null) {
                        chromosomedEntity.setChromosome1(this.chromosome1);
                        chromosomedEntity.setChromosome2(this.chromosome2);
                    }
                    if (animalToSpawn instanceof Dinosaur dinosaur) {
                        dinosaur.setGrowthStage(0, true);
                    }
                    if (animalToSpawn instanceof TamesOnBirth tamesOnBirth) {
                        if (tamesOnBirth.tamesOnBirth()) {
                            Player player = this.level().getNearestPlayer(animalToSpawn, 25.0D);
                            if (player != null) {
                                tamesOnBirth.setOwnerUUID(player.getUUID());
                            }
                        }
                    }
                    if (animalToSpawn instanceof Chicken) {
                        animalToSpawn.setBaby(true);
                    }
                    if (animalToSpawn instanceof Parrot parrot) {
                        parrot.setVariant(Util.getRandom(Parrot.Variant.values(), this.level().getRandom()));
                    }
                    this.level().addFreshEntity(animalToSpawn);
                }
            }

            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putString("EntityType", BuiltInRegistries.ENTITY_TYPE.getKey(this.animal).toString());
        compoundTag.putBoolean("Incubated", this.incubated);
        if (this.chromosome1 != null && this.chromosome2 != null) {
            this.saveChromosomes(compoundTag);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.animal = (EntityType<? extends Animal>) BuiltInRegistries.ENTITY_TYPE.getValue(ResourceLocation.parse(compoundTag.getString("EntityType")));
        this.incubated = compoundTag.getBoolean("Incubated");
        if (compoundTag.contains("chromosome_1") && compoundTag.contains("chromosome_2")) {
            this.loadChromosomes(compoundTag);
        }
    }

    @Override
    protected Item getDefaultItem() {
        return FAItems.INCUBATED_CHICKEN_EGG.get();
    }

    @Override
    public Registry<ModelGene> getModelGeneRegistry() {
        return null;
    }

    @Override
    public Registry<SkinGene> getSkinGeneRegistry() {
        return null;
    }

    @Override
    public Registry<PatternGene> getPatternGeneRegistry() {
        return null;
    }

    @Override
    public Chromosome getChromosome1() {
        return this.chromosome1;
    }

    @Override
    public void setChromosome1(Chromosome chromosome) {
        this.chromosome1 = chromosome;
    }

    @Override
    public Chromosome getChromosome2() {
        return this.chromosome2;
    }

    @Override
    public void setChromosome2(Chromosome chromosome) {
        this.chromosome2 = chromosome;
    }
}
