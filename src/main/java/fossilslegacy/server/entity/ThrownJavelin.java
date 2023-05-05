package fossilslegacy.server.entity;

import fossilslegacy.server.item.FossilsLegacyItems;
import fossilslegacy.server.item.FossilsLegacyTiers;
import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class ThrownJavelin extends AbstractArrow {
	private static final EntityDataAccessor<Integer> DATA_VARIANT_ID = SynchedEntityData.defineId(ThrownJavelin.class, EntityDataSerializers.INT);
	private ItemStack itemStack = FossilsLegacyItems.WOODEN_JAVELIN.get().getDefaultInstance();
	private float damage = 1.0F;

	public ThrownJavelin(EntityType<? extends ThrownJavelin> entityType, Level level) {
		super(entityType, level);
	}

	public ThrownJavelin(Level level, LivingEntity livingEntity, ItemStack itemStack) {
		super(FossilsLegacyEntities.THROWN_JAVELIN.get(), livingEntity, level);
		this.itemStack = itemStack.copy();
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_VARIANT_ID, 0);
	}

	@Override
	public boolean save(CompoundTag compoundTag) {
		compoundTag.putFloat("Damage", this.damage);
		compoundTag.putInt("Variant", this.getVariant());
		return super.save(compoundTag);
	}

	@Override
	public void load(CompoundTag compoundTag) {
		super.load(compoundTag);
		this.damage = compoundTag.getFloat("Damage");
		this.setVariant(compoundTag.getInt("Variant"));
	}

	public void setVariant(int variant) {
		this.entityData.set(DATA_VARIANT_ID, variant);
	}

	public void setVariant(Tier tier) {
		if (tier == Tiers.WOOD) {
			this.setVariant(0);
		}
		if (tier == Tiers.STONE) {
			this.setVariant(1);
		}
		if (tier == Tiers.IRON) {
			this.setVariant(2);
		}
		if (tier == Tiers.GOLD) {
			this.setVariant(3);
		}
		if (tier == Tiers.DIAMOND) {
			this.setVariant(4);
		}
		if (tier == Tiers.NETHERITE) {
			this.setVariant(5);
		}
		if (tier == FossilsLegacyTiers.GEM) {
			this.setVariant(6);
		}
		this.damage = 4 + tier.getAttackDamageBonus();
	}

	public int getVariant() {
		return this.entityData.get(DATA_VARIANT_ID);
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	protected void onHitEntity(EntityHitResult entityHitResult) {
		Entity entity = entityHitResult.getEntity();
		Entity owner = this.getOwner();
		DamageSource damageSource = new DamageSource(this.level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, FossilsLegacyUtils.resource("javelin"))));
		SoundEvent soundevent = SoundEvents.ARROW_HIT;
		if (entity.hurt(damageSource, this.damage)) {
			if (entity.getType() == EntityType.ENDERMAN) {
				return;
			}

			if (entity instanceof LivingEntity livingEntity) {
				this.doPostHurtEffects(livingEntity);
			}
		}

		this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));
		float soundLevel = 1.0F;
		if (this.level instanceof ServerLevel && this.getVariant() == 6) {
			BlockPos blockpos = entity.blockPosition();
			if (this.level.canSeeSky(blockpos)) {
				LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(this.level);
				if (lightningbolt != null) {
					lightningbolt.moveTo(Vec3.atBottomCenterOf(blockpos));
					lightningbolt.setCause(owner instanceof ServerPlayer ? (ServerPlayer) owner : null);
					this.level.addFreshEntity(lightningbolt);
					soundevent = SoundEvents.LIGHTNING_BOLT_THUNDER;
					soundLevel = 5.0F;
				}
			}
		}
		this.playSound(soundevent, soundLevel, 1.0F);
	}

	@Override
	protected ItemStack getPickupItem() {
		return this.itemStack;
	}
}
