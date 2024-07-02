package willatendo.fossilslegacy.server.entity;

import net.minecraft.Util;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

public class ThrownAnimalEgg extends ThrowableItemProjectile {
    private EntityType<? extends Animal> animal;
    private boolean incubated;

    public ThrownAnimalEgg(EntityType<? extends ThrownAnimalEgg> entityType, Level level) {
        super(entityType, level);
        this.animal = EntityType.CHICKEN;
        this.incubated = false;
    }

    public ThrownAnimalEgg(Level level, LivingEntity livingEntity, EntityType<? extends Animal> animal, boolean incubated) {
        super(FossilsLegacyEntityTypes.THROWN_INCUBATED_EGG.get(), livingEntity, level);
        this.animal = animal;
        this.incubated = incubated;
    }

    public ThrownAnimalEgg(Level level, double x, double y, double z, EntityType<? extends Animal> animal, boolean incubated) {
        super(FossilsLegacyEntityTypes.THROWN_INCUBATED_EGG.get(), x, y, z, level);
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
        boolean shouldHatch = this.incubated ? true : this.random.nextInt(8) == 0;

        if (shouldHatch) {
            if (!this.level().isClientSide()) {
                int i = 1;
                if (this.random.nextInt(32) == 0) {
                    i = 4;
                }

                for (int animals = 0; animals < i; ++animals) {
                    Animal animalToSpawn = this.animal.create(this.level());
                    if (animalToSpawn instanceof Chicken || animalToSpawn instanceof Dodo) {
                        animalToSpawn.setBaby(true);
                    }
                    if (animalToSpawn instanceof Parrot parrot) {
                        parrot.setVariant(Util.getRandom(Parrot.Variant.values(), this.level().getRandom()));
                    }
                    animalToSpawn.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    this.level().addFreshEntity(animalToSpawn);
                }

                this.level().broadcastEntityEvent(this, (byte) 3);
                this.discard();
            }
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putString("EntityType", BuiltInRegistries.ENTITY_TYPE.getKey(this.animal).toString());
        compoundTag.putBoolean("Incubated", this.incubated);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.animal = (EntityType<? extends Animal>) BuiltInRegistries.ENTITY_TYPE.get(ResourceLocation.parse(compoundTag.getString("EntityType")));
        this.incubated = compoundTag.getBoolean("Incubated");
    }

    @Override
    protected Item getDefaultItem() {
        return FossilsLegacyItems.INCUBATED_CHICKEN_EGG.get();
    }
}
