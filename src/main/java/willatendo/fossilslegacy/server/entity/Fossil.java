package willatendo.fossilslegacy.server.entity;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PowderSnowBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

public class Fossil extends Entity {
	private static final EntityDataAccessor<Integer> FOSSIL = SynchedEntityData.defineId(Fossil.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> SIZE = SynchedEntityData.defineId(Fossil.class, EntityDataSerializers.INT);

	public float yBodyRot;
	public float yBodyRotO;
	public float yHeadRot;
	public float yHeadRotO;
	public float xxa;
	public float yya;
	public float zza;
	public int hurtTime;
	public int hurtDuration;
	public int deathTime;
	protected boolean dead;
	private float speed;

	public Fossil(EntityType<?> entityType, Level level) {
		super(entityType, level);
	}

	public void travel(Vec3 vec3) {
		if (this.isControlledByLocalInstance()) {
			double movmentSpeed = 0.08D;
			boolean flag = this.getDeltaMovement().y <= 0.0D;

			FluidState fluidstate = this.level().getFluidState(this.blockPosition());
			if ((this.isInWater() || (this.isInFluidType(fluidstate) && fluidstate.getFluidType() != ForgeMod.LAVA_TYPE.get())) && this.isAffectedByFluids() && !this.canStandOnFluid(fluidstate)) {
				if (this.isInWater() || (this.isInFluidType(fluidstate))) {
					double y = this.getY();
					float modifier = this.isSprinting() ? 0.9F : this.getWaterSlowDown();
					float scale = 0.02F;

					this.moveRelative(scale, vec3);
					this.move(MoverType.SELF, this.getDeltaMovement());
					Vec3 deltaMovement = this.getDeltaMovement();
					if (this.horizontalCollision && this.onClimbable()) {
						deltaMovement = new Vec3(deltaMovement.x, 0.2D, deltaMovement.z);
					}

					this.setDeltaMovement(deltaMovement.multiply((double) modifier, (double) 0.8F, (double) modifier));
					Vec3 fluidFallingAdjustedMovement = this.getFluidFallingAdjustedMovement(movmentSpeed, flag, this.getDeltaMovement());
					this.setDeltaMovement(fluidFallingAdjustedMovement);
					if (this.horizontalCollision && this.isFree(fluidFallingAdjustedMovement.x, fluidFallingAdjustedMovement.y + (double) 0.6F - this.getY() + y, fluidFallingAdjustedMovement.z)) {
						this.setDeltaMovement(fluidFallingAdjustedMovement.x, (double) 0.3F, fluidFallingAdjustedMovement.z);
					}
				}
			} else if (this.isInLava() && this.isAffectedByFluids() && !this.canStandOnFluid(fluidstate)) {
				double y = this.getY();
				this.moveRelative(0.02F, vec3);
				this.move(MoverType.SELF, this.getDeltaMovement());
				if (this.getFluidHeight(FluidTags.LAVA) <= this.getFluidJumpThreshold()) {
					this.setDeltaMovement(this.getDeltaMovement().multiply(0.5D, (double) 0.8F, 0.5D));
					Vec3 fluidFallingAdjustedMovement = this.getFluidFallingAdjustedMovement(movmentSpeed, flag, this.getDeltaMovement());
					this.setDeltaMovement(fluidFallingAdjustedMovement);
				} else {
					this.setDeltaMovement(this.getDeltaMovement().scale(0.5D));
				}

				if (!this.isNoGravity()) {
					this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -movmentSpeed / 4.0D, 0.0D));
				}

				Vec3 deltaMovement = this.getDeltaMovement();
				if (this.horizontalCollision && this.isFree(deltaMovement.x, deltaMovement.y + (double) 0.6F - this.getY() + y, deltaMovement.z)) {
					this.setDeltaMovement(deltaMovement.x, (double) 0.3F, deltaMovement.z);
				}
			} else {
				BlockPos blockPos = this.getBlockPosBelowThatAffectsMyMovement();
				float friction = this.level().getBlockState(this.getBlockPosBelowThatAffectsMyMovement()).getFriction(level(), this.getBlockPosBelowThatAffectsMyMovement(), this);
				float onGround = this.onGround() ? friction * 0.91F : 0.91F;
				Vec3 calculate = this.handleRelativeFrictionAndCalculateMovement(vec3, friction);
				double y = calculate.y;
				if (this.level().isClientSide && !this.level().hasChunkAt(blockPos)) {
					if (this.getY() > (double) this.level().getMinBuildHeight()) {
						y = -0.1D;
					} else {
						y = 0.0D;
					}
				} else if (!this.isNoGravity()) {
					y -= movmentSpeed;
				}

				this.setDeltaMovement(calculate.x * (double) onGround, y * (double) 0.98F, calculate.z * (double) onGround);
			}
		}
	}

	public Vec3 getFluidFallingAdjustedMovement(double movmentSpeed, boolean flag, Vec3 vec3) {
		if (!this.isNoGravity() && !this.isSprinting()) {
			double y;
			if (flag && Math.abs(vec3.y - 0.005D) >= 0.003D && Math.abs(vec3.y - movmentSpeed / 16.0D) < 0.003D) {
				y = -0.003D;
			} else {
				y = vec3.y - movmentSpeed / 16.0D;
			}

			return new Vec3(vec3.x, y, vec3.z);
		} else {
			return vec3;
		}
	}

	public Vec3 handleRelativeFrictionAndCalculateMovement(Vec3 vec3, float friction) {
		this.moveRelative(this.getFrictionInfluencedSpeed(friction), vec3);
		this.setDeltaMovement(this.handleOnClimbable(this.getDeltaMovement()));
		this.move(MoverType.SELF, this.getDeltaMovement());
		Vec3 deltaMovement = this.getDeltaMovement();
		if ((this.horizontalCollision) && (this.onClimbable() || this.getFeetBlockState().is(Blocks.POWDER_SNOW) && PowderSnowBlock.canEntityWalkOnPowderSnow(this))) {
			deltaMovement = new Vec3(deltaMovement.x, 0.2D, deltaMovement.z);
		}

		return deltaMovement;
	}

	public boolean onClimbable() {
		return this.level().getBlockState(this.blockPosition()).is(BlockTags.CLIMBABLE);
	}

	private Vec3 handleOnClimbable(Vec3 vec3) {
		if (this.onClimbable()) {
			this.resetFallDistance();
			double d0 = Mth.clamp(vec3.x, (double) -0.15F, (double) 0.15F);
			double d1 = Mth.clamp(vec3.z, (double) -0.15F, (double) 0.15F);
			double d2 = Math.max(vec3.y, (double) -0.15F);

			vec3 = new Vec3(d0, d2, d1);
		}

		return vec3;
	}

	private float getFrictionInfluencedSpeed(float friction) {
		return this.onGround() ? this.getSpeed() * (0.21600002F / (friction * friction * friction)) : this.getFlyingSpeed();
	}

	protected float getFlyingSpeed() {
		return this.getControllingPassenger() instanceof Player ? this.getSpeed() * 0.1F : 0.02F;
	}

	protected float getWaterSlowDown() {
		return 0.8F;
	}

	protected boolean isAffectedByFluids() {
		return true;
	}

	public boolean canStandOnFluid(FluidState fluidState) {
		return false;
	}

	@Override
	public boolean hurt(DamageSource damageSource, float damage) {
		if (this.isInvulnerableTo(damageSource)) {
			return false;
		} else if (this.level().isClientSide) {
			return false;
		} else {
			this.die(damageSource);
			this.playHurtSound(damageSource);

			if (damage >= 0) {
				this.level().broadcastEntityEvent(this, (byte) 29);
			} else {
				this.level().broadcastDamageEvent(this, damageSource);
			}
			return true;
		}
	}

	public void die(DamageSource damageSource) {
		if (!this.isRemoved() && !this.dead) {
			Entity entity = damageSource.getEntity();

			this.dead = true;
			Level level = this.level();
			if (level instanceof ServerLevel serverLevel) {
				if (entity == null) {
					this.gameEvent(GameEvent.ENTITY_DIE);
					if (this.getSize() > 1) {
						for (int i = 0; i < (this.getSize() - 1); i++) {
							Block.popResource(level, this.blockPosition(), new ItemStack(Items.BONE));
						}
					}
					Block.popResource(level, this.blockPosition(), new ItemStack(FossilsLegacyItems.FOSSIL.get()));
				}

				this.level().broadcastEntityEvent(this, (byte) 3);
			}
		}
	}

	protected void playHurtSound(DamageSource damageSource) {
		SoundEvent soundEvent = this.getHurtSound(damageSource);
		if (soundEvent != null) {
			this.playSound(soundEvent, this.getSoundVolume(), this.getVoicePitch());
		}
	}

	@Nullable
	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return SoundEvents.SKELETON_HURT;
	}

	protected float getSoundVolume() {
		return 1.0F;
	}

	public float getVoicePitch() {
		return (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F;
	}

	@Override
	public void refreshDimensions() {
		double d0 = this.getX();
		double d1 = this.getY();
		double d2 = this.getZ();
		super.refreshDimensions();
		this.setPos(d0, d1, d2);
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> entityDataAccessor) {
		if (SIZE.equals(entityDataAccessor)) {
			this.refreshDimensions();
		}

		super.onSyncedDataUpdated(entityDataAccessor);
	}

	@Override
	public EntityDimensions getDimensions(Pose pose) {
		return super.getDimensions(pose).scale(0.75F * (float) this.getSize());
	}

	@Override
	public void baseTick() {
		super.baseTick();

		this.yBodyRotO = this.yBodyRot;
		this.yHeadRotO = this.yHeadRot;
	}

	@Override
	public float getVisualRotationYInDegrees() {
		return this.yBodyRot;
	}

	@Override
	public void tick() {
		if (this.dead) {
			this.remove(Entity.RemovalReason.KILLED);
		}

		this.xxa *= 0.98F;
		this.zza *= 0.98F;
		Vec3 vec3 = new Vec3((double) this.xxa, (double) this.yya, (double) this.zza);
		this.travel(vec3);

		super.tick();

		while (this.getYRot() - this.yRotO < -180.0F) {
			this.yRotO -= 360.0F;
		}

		while (this.getYRot() - this.yRotO >= 180.0F) {
			this.yRotO += 360.0F;
		}

		while (this.yBodyRot - this.yBodyRotO < -180.0F) {
			this.yBodyRotO -= 360.0F;
		}

		while (this.yBodyRot - this.yBodyRotO >= 180.0F) {
			this.yBodyRotO += 360.0F;
		}

		while (this.getXRot() - this.xRotO < -180.0F) {
			this.xRotO -= 360.0F;
		}

		while (this.getXRot() - this.xRotO >= 180.0F) {
			this.xRotO += 360.0F;
		}

		while (this.yHeadRot - this.yHeadRotO < -180.0F) {
			this.yHeadRotO -= 360.0F;
		}

		while (this.yHeadRot - this.yHeadRotO >= 180.0F) {
			this.yHeadRotO += 360.0F;
		}

		this.level().getProfiler().pop();
	}

	@Override
	public boolean isPickable() {
		return true;
	}

	@Override
	public ItemStack getPickedResult(HitResult hitResult) {
		return new ItemStack(FossilsLegacyItems.FOSSIL.get());
	}

	@Override
	protected void defineSynchedData() {
		this.entityData.define(FOSSIL, 0);
		this.entityData.define(SIZE, 1);
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag compoundTag) {
		this.setFossil(compoundTag.getInt("Fossil"));
		this.setSize(compoundTag.getInt("Size"));
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag compoundTag) {
		compoundTag.putInt("Fossil", this.getFossil());
		compoundTag.putInt("Size", this.getSize());
	}

	@Override
	public InteractionResult interactAt(Player player, Vec3 vec3, InteractionHand interactionHand) {
		ItemStack itemStack = player.getItemInHand(interactionHand);
		if (itemStack.is(Items.BONE)) {
			this.setSize(this.getSize() + 1);
			itemStack.shrink(1);
			return InteractionResult.SUCCESS;
		}
		if (itemStack.isEmpty()) {
			if (this.getSize() > 1) {
				this.setSize(this.getSize() - 1);
				player.addItem(new ItemStack(Items.BONE));
				return InteractionResult.SUCCESS;
			}
		}
		return super.interactAt(player, vec3, interactionHand);
	}

	public float getSpeed() {
		return this.speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public void setFossil(int fossils) {
		this.entityData.set(FOSSIL, fossils);
	}

	public int getFossil() {
		return this.entityData.get(FOSSIL);
	}

	public void setSize(int size) {
		this.entityData.set(SIZE, size);
	}

	public int getSize() {
		return this.entityData.get(SIZE);
	}
}
