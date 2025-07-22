package willatendo.fossilslegacy.server.entity.entities;

import net.minecraft.Util;
import net.minecraft.core.Holder;
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
import willatendo.fossilslegacy.server.entity.util.interfaces.DataDrivenCosmetics;
import willatendo.fossilslegacy.server.entity.util.interfaces.TamesOnBirth;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;

public class ThrownAnimalEgg extends ThrowableItemProjectile implements DataDrivenCosmetics {
    private EntityType<? extends Animal> animal;
    private Holder<ModelType> modelType;
    private Holder<Pattern> skin;
    private Holder<Pattern> pattern;
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
    public void setModelType(Holder<ModelType> coatType) {
        this.modelType = coatType;
    }

    @Override
    public Holder<ModelType> getModelType() {
        return this.modelType;
    }

    @Override
    public void setSkin(Holder<Pattern> pattern) {
        this.skin = pattern;
    }

    @Override
    public Holder<Pattern> getSkin() {
        return this.skin;
    }

    @Override
    public void setPattern(Holder<Pattern> pattern) {
        this.pattern = pattern;
    }

    @Override
    public Holder<Pattern> getPattern() {
        return this.pattern;
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
                    if (animalToSpawn instanceof DataDrivenCosmetics dataDrivenCosmetics && this.modelType != null && this.skin != null) {
                        dataDrivenCosmetics.setModelType(this.modelType);
                        dataDrivenCosmetics.setSkin(this.skin);
                        if (this.pattern != null) {
                            dataDrivenCosmetics.setPattern(this.pattern);
                        }
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
        if (this.modelType != null && this.skin != null) {
            this.addCosmeticsData(compoundTag, this.registryAccess());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.animal = (EntityType<? extends Animal>) BuiltInRegistries.ENTITY_TYPE.getValue(ResourceLocation.parse(compoundTag.getString("EntityType")));
        this.incubated = compoundTag.getBoolean("Incubated");
        if (compoundTag.contains("model_type") && compoundTag.contains("skin")) {
            this.readCosmeticsData(compoundTag, this.registryAccess());
        }
    }

    @Override
    protected Item getDefaultItem() {
        return FAItems.INCUBATED_CHICKEN_EGG.get();
    }
}
