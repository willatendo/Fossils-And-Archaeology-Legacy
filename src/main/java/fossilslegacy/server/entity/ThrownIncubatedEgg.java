package fossilslegacy.server.entity;

import fossilslegacy.server.item.FossilsLegacyItems;
import net.minecraft.Util;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
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

public class ThrownIncubatedEgg extends ThrowableItemProjectile {
	private static final EntityDataAccessor<Integer> EGG_TYPE = SynchedEntityData.defineId(ThrownIncubatedEgg.class, EntityDataSerializers.INT);

	public ThrownIncubatedEgg(EntityType<? extends ThrownIncubatedEgg> entityType, Level level) {
		super(entityType, level);
	}

	public ThrownIncubatedEgg(Level level, LivingEntity livingEntity) {
		super(FossilsLegacyEntities.THROWN_INCUBATED_EGG.get(), livingEntity, level);
	}

	public ThrownIncubatedEgg(Level level, double x, double y, double z) {
		super(FossilsLegacyEntities.THROWN_INCUBATED_EGG.get(), x, y, z, level);
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
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(EGG_TYPE, 0);
	}

	public int getEggType() {
		return this.entityData.get(EGG_TYPE);
	}

	public void setEggType(int eggType) {
		this.entityData.set(EGG_TYPE, eggType);
	}

	@Override
	protected void onHit(HitResult hitResult) {
		super.onHit(hitResult);
		if (!this.level().isClientSide()) {
			int i = 1;
			if (this.random.nextInt(32) == 0) {
				i = 4;
			}

			for (int animals = 0; animals < i; ++animals) {
				Animal animalToSpawn = this.getEggType() == 0 ? EntityType.CHICKEN.create(this.level()) : EntityType.PARROT.create(this.level());
				if (animalToSpawn instanceof Chicken) {
					animalToSpawn.setAge(-24000);
					animalToSpawn.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
				}
				if (animalToSpawn instanceof Parrot parrot) {
					animalToSpawn.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
					parrot.setVariant(Util.getRandom(Parrot.Variant.values(), this.level().getRandom()));
				}
				this.level().addFreshEntity(animalToSpawn);
			}

			this.level().broadcastEntityEvent(this, (byte) 3);
			this.discard();
		}
	}

	@Override
	protected Item getDefaultItem() {
		return getEggType() == 0 ? FossilsLegacyItems.INCUBATED_CHICKEN_EGG.get() : FossilsLegacyItems.INCUBATED_PARROT_EGG.get();
	}
}
