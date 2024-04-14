package willatendo.fossilslegacy.server.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.utils.Lists;
import org.jetbrains.annotations.Nullable;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import willatendo.fossilslegacy.server.entity.goal.DinoBabyFollowParentGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoEatFromFeederGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoFollowOwnerGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoOwnerHurtByTargetGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoOwnerHurtTargetGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoTemptGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoWaterAvoidingRandomStrollGoal;
import willatendo.fossilslegacy.server.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class Futabasaurus extends Dinosaur implements DinopediaInformation, RideableDinosaur {
	private float invFriction;
	private float deltaRotation;
	private int lerpSteps;
	private double lerpX;
	private double lerpY;
	private double lerpZ;
	private double lerpYRot;
	private double lerpXRot;
	private double waterLevel;
	private float landFriction;
	private Status status;
	private Status oldStatus;
	private double lastYd;

	public Futabasaurus(EntityType<? extends Dinosaur> entityType, Level level) {
		super(entityType, level);
	}

	public static AttributeSupplier plesiosaurusAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 16.0F).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 3.0D).build();
	}

	@Override
	public float maxUpStep() {
		return DinoUtils.getStepHeights(12, 0.5F, 1.0F)[this.getGrowthStage()];
	}

	@Override
	public int getMinRideableAge() {
		return 5;
	}

	@Override
	public int getMaxHunger() {
		return 500;
	}

	@Override
	public EggVariant getEggVariant() {
		return FossilsLegacyEggVariants.FUTABASAURUS.get();
	}

	@Override
	public int getMaxGrowthStage() {
		return 12;
	}

	@Override
	public float getBoundingBoxGrowth() {
		return 0.25F;
	}

	@Override
	public double getMinHealth() {
		return 4.0D;
	}

	@Override
	public Diet getDiet() {
		return Diet.piscivore();
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new DinoTemptGoal(this, 1.1D, false));
		this.goalSelector.addGoal(4, new DinoBabyFollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(6, new DinoWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new DinoFollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
		this.goalSelector.addGoal(6, new DinoEatFromFeederGoal(this, 1.0D, 24, true));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new DinoOwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new DinoOwnerHurtTargetGoal(this));
	}

	@Override
	public InteractionResult interactAt(Player player, Vec3 vec3, InteractionHand interactionHand) {
		ItemStack itemStack = player.getItemInHand(interactionHand);

		if (itemStack.isEmpty() && !this.commandItems().canCommandWithItem(itemStack)) {
			if (!this.hasPassenger(this) && this.getGrowthStage() >= this.getMinRideableAge() && this.isTame()) {
				if (!this.level().isClientSide) {
					player.startRiding(this);
				}
				return InteractionResult.SUCCESS;
			}
		}
		return super.interactAt(player, vec3, interactionHand);
	}

	@Override
	public LivingEntity getControllingPassenger() {
		Entity entity = this.getFirstPassenger();
		if (entity instanceof LivingEntity livingEntity) {
			return livingEntity;
		}

		return null;
	}

	@Override
	public Vec3 getDismountLocationForPassenger(LivingEntity livingEntity) {
		Direction direction = this.getMotionDirection();
		if (direction.getAxis() == Direction.Axis.Y) {
			return super.getDismountLocationForPassenger(livingEntity);
		} else {
			int[][] offsets = DismountHelper.offsetsForDirection(direction);
			BlockPos blockPos = this.blockPosition();
			BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

			for (Pose pose : livingEntity.getDismountPoses()) {
				AABB aabb = livingEntity.getLocalBoundsForPose(pose);

				for (int[] offset : offsets) {
					mutableBlockPos.set(blockPos.getX() + offset[0], blockPos.getY(), blockPos.getZ() + offset[1]);
					double floor = this.level().getBlockFloorHeight(mutableBlockPos);
					if (DismountHelper.isBlockFloorValid(floor)) {
						Vec3 vec3 = Vec3.upFromBottomCenterOf(mutableBlockPos, floor);
						if (DismountHelper.canDismountTo(this.level(), livingEntity, aabb.move(vec3))) {
							livingEntity.setPose(pose);
							return vec3;
						}
					}
				}
			}

			return super.getDismountLocationForPassenger(livingEntity);
		}
	}

	@Override
	public void travel(Vec3 vec3) {
		if (this.isAlive() && !this.isInWaterOrBubble()) {
			LivingEntity livingEntity = this.getControllingPassenger();
			if (this.isVehicle() && livingEntity != null) {
				this.setRot(livingEntity.getYRot(), livingEntity.getXRot() * 0.5F);
				this.yRotO = this.yBodyRot = this.yHeadRot = this.getYRot();
				float f = livingEntity.xxa * 0.5F;
				float f1 = livingEntity.zza;
				if (f1 <= 0.0F) {
					f1 *= 0.25F;
				}

				if (this.isControlledByLocalInstance()) {
					this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
					super.travel(new Vec3((double) f, vec3.y, (double) f1));
				} else if (livingEntity instanceof Player) {
					this.setDeltaMovement(this.getX() - this.xOld, this.getY() - this.yOld, this.getZ() - this.zOld);
				}

				this.calculateEntityAnimation(false);
				this.tryCheckInsideBlocks();
			} else {
				super.travel(vec3);
			}
		} else {
			super.travel(vec3);
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return FossilsLegacySoundEvents.FUTABASAURUS_AMBIENT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return FossilsLegacySoundEvents.FUTABASAURUS_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return FossilsLegacySoundEvents.FUTABASAURUS_DEATH.get();
	}

	@Override
	public List<Component> info(Player player) {
		ArrayList<Component> information = Lists.newArrayList();
		if (this.isTame() && this.isOwnedBy(player)) {
			information.add(this.getDisplayName());
			information.add(FossilsLegacyUtils.translation("dinopedia", "owner", this.getOwner() != null ? this.getOwner().getDisplayName().getString() : FossilsLegacyUtils.translation("encyclopedia", "wild").getString()));
			information.add(FossilsLegacyUtils.translation("dinopedia", "age", this.getDaysAlive()));
			information.add(FossilsLegacyUtils.translation("dinopedia", "health", (int) this.getHealth(), (int) this.getMaxHealth()));
			information.add(FossilsLegacyUtils.translation("dinopedia", "hunger", this.getHunger(), this.getMaxHunger()));
			if (this.getAge() >= this.getMinRideableAge()) {
				information.add(FossilsLegacyUtils.translation("dinopedia", "rideable"));
			}
		} else {
			information.add(this.getDisplayName());
			if (this.isTame()) {
				information.add(FossilsLegacyUtils.translation("dinopedia", "not_owner"));
			} else {
				information.add(FossilsLegacyUtils.translation("dinopedia", "wild"));
			}
		}
		return information;
	}

	@Override
	public CommandType commandItems() {
		return CommandType.none();
	}

	@Override
	public void lerpTo(double x, double y, double z, float yRot, float xRot, int steps) {
		this.lerpX = x;
		this.lerpY = y;
		this.lerpZ = z;
		this.lerpYRot = yRot;
		this.lerpXRot = xRot;
		this.lerpSteps = 10;
	}

	@Override
	public double lerpTargetX() {
		return this.lerpSteps > 0 ? this.lerpX : this.getX();
	}

	@Override
	public double lerpTargetY() {
		return this.lerpSteps > 0 ? this.lerpY : this.getY();
	}

	@Override
	public double lerpTargetZ() {
		return this.lerpSteps > 0 ? this.lerpZ : this.getZ();
	}

	@Override
	public float lerpTargetXRot() {
		return this.lerpSteps > 0 ? (float) this.lerpXRot : this.getXRot();
	}

	@Override
	public float lerpTargetYRot() {
		return this.lerpSteps > 0 ? (float) this.lerpYRot : this.getYRot();
	}

	@Nullable
	private Status isUnderwater() {
		AABB boundingBox = this.getBoundingBox();
		double maxYPlus = boundingBox.maxY + 0.001;
		int minX = Mth.floor(boundingBox.minX);
		int maxX = Mth.ceil(boundingBox.maxX);
		int minY = Mth.floor(boundingBox.maxY);
		int maxY = Mth.ceil(maxYPlus);
		int minZ = Mth.floor(boundingBox.minZ);
		int maxZ = Mth.ceil(boundingBox.maxZ);
		boolean underWater = false;
		BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
		for (int x = minX; x < maxX; ++x) {
			for (int y = minY; y < maxY; ++y) {
				for (int z = minZ; z < maxZ; ++z) {
					mutableBlockPos.set(x, y, z);
					FluidState fluidState = this.level().getFluidState(mutableBlockPos);
					if (!fluidState.is(FluidTags.WATER) || !(maxYPlus < (double) ((float) mutableBlockPos.getY() + fluidState.getHeight(this.level(), mutableBlockPos)))) {
						continue;
					}
					if (fluidState.isSource()) {
						underWater = true;
						continue;
					}
					return Status.UNDER_FLOWING_WATER;
				}
			}
		}
		return underWater ? Status.UNDER_WATER : null;
	}

	private Status getStatus() {
		Status status = this.isUnderwater();
		if (status != null) {
			this.waterLevel = this.getBoundingBox().maxY;
			return status;
		}
		if (this.checkInWater()) {
			return Status.IN_WATER;
		}
		float groundFriction = this.getGroundFriction();
		if (groundFriction > 0.0F) {
			this.landFriction = groundFriction;
			return Status.ON_LAND;
		}
		return Status.IN_AIR;
	}

	public float getWaterLevelAbove() {
		AABB boundingBox = this.getBoundingBox();
		int minX = Mth.floor(boundingBox.minX);
		int maxX = Mth.ceil(boundingBox.maxX);
		int minY = Mth.floor(boundingBox.maxY);
		int maxY = Mth.ceil(boundingBox.maxY - this.lastYd);
		int minZ = Mth.floor(boundingBox.minZ);
		int maxZ = Mth.ceil(boundingBox.maxZ);
		BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
		loop: for (int y = minY; y < maxY; ++y) {
			float height = 0.0F;
			for (int x = minX; x < maxX; ++x) {
				for (int z = minZ; z < maxZ; ++z) {
					mutableBlockPos.set(x, y, z);
					FluidState fluidState = this.level().getFluidState(mutableBlockPos);
					if (fluidState.is(FluidTags.WATER)) {
						height = Math.max(height, fluidState.getHeight(this.level(), mutableBlockPos));
					}
					if (height >= 1.0F) {
						continue loop;
					}
				}
			}
			if (!(height < 1.0F)) {
				continue;
			}
			return (float) mutableBlockPos.getY() + height;
		}
		return maxY + 1;
	}

	public float getGroundFriction() {
		AABB boundingBox = this.getBoundingBox();
		AABB adjusted = new AABB(boundingBox.minX, boundingBox.minY - 0.001, boundingBox.minZ, boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
		int minX = Mth.floor(adjusted.minX) - 1;
		int maxX = Mth.ceil(adjusted.maxX) + 1;
		int minY = Mth.floor(adjusted.minY) - 1;
		int maxY = Mth.ceil(adjusted.maxY) + 1;
		int minZ = Mth.floor(adjusted.minZ) - 1;
		int maxZ = Mth.ceil(adjusted.maxZ) + 1;
		VoxelShape voxelShape = Shapes.create(adjusted);
		float friction = 0.0F;
		int value = 0;
		BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
		for (int x = minX; x < maxX; ++x) {
			for (int z = minZ; z < maxZ; ++z) {
				int plus = (x == minX || x == maxX - 1 ? 1 : 0) + (z == minZ || z == maxZ - 1 ? 1 : 0);
				if (plus == 2) {
					continue;
				}
				for (int y = minY; y < maxY; ++y) {
					if (plus > 0 && (y == minY || y == maxY - 1)) {
						continue;
					}
					mutableBlockPos.set(x, y, z);
					BlockState blockState = this.level().getBlockState(mutableBlockPos);
					if (blockState.getBlock() instanceof WaterlilyBlock || !Shapes.joinIsNotEmpty(blockState.getCollisionShape(this.level(), mutableBlockPos).move(x, y, z), voxelShape, BooleanOp.AND)) {
						continue;
					}
					friction += blockState.getBlock().getFriction();
					++value;
				}
			}
		}
		return friction / (float) value;
	}

	private boolean checkInWater() {
		AABB boundingBox = this.getBoundingBox();
		int minX = Mth.floor(boundingBox.minX);
		int maxX = Mth.ceil(boundingBox.maxX);
		int minY = Mth.floor(boundingBox.minY);
		int maxY = Mth.ceil(boundingBox.minY + 0.001);
		int minZ = Mth.floor(boundingBox.minZ);
		int maxZ = Mth.ceil(boundingBox.maxZ);
		boolean inWater = false;
		this.waterLevel = -1.7976931348623157E308;
		BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
		for (int x = minX; x < maxX; ++x) {
			for (int y = minY; y < maxY; ++y) {
				for (int z = minZ; z < maxZ; ++z) {
					mutableBlockPos.set(x, y, z);
					FluidState fluidState = this.level().getFluidState(mutableBlockPos);
					if (!fluidState.is(FluidTags.WATER)) {
						continue;
					}
					float height = (float) y + fluidState.getHeight(this.level(), mutableBlockPos);
					this.waterLevel = Math.max((double) height, this.waterLevel);
					inWater |= boundingBox.minY < (double) height;
				}
			}
		}
		return inWater;
	}

	private void floatBoat() {
		double yFlowing = this.isNoGravity() ? 0.0 : (double) -0.04F;
		double yWater = 0.0;
		this.invFriction = 0.05F;
		if (this.oldStatus == Status.IN_AIR && this.status != Status.IN_AIR && this.status != Status.ON_LAND) {
			this.waterLevel = this.getY(1.0);
			this.setPos(this.getX(), (double) (this.getWaterLevelAbove() - this.getBbHeight()) + 0.101, this.getZ());
			this.setDeltaMovement(this.getDeltaMovement().multiply(1.0, 0.0, 1.0));
			this.lastYd = 0.0;
			this.status = Status.IN_WATER;
		} else {
			if (this.status == Status.IN_WATER) {
				yWater = (this.waterLevel - this.getY()) / (double) this.getBbHeight();
				this.invFriction = 0.9F;
			} else if (this.status == Status.UNDER_FLOWING_WATER) {
				yFlowing = -7.0E-4;
				this.invFriction = 0.9F;
			} else if (this.status == Status.UNDER_WATER) {
				yWater = 0.01F;
				this.invFriction = 0.45F;
			} else if (this.status == Status.IN_AIR) {
				this.invFriction = 0.9F;
			} else if (this.status == Status.ON_LAND) {
				this.invFriction = this.landFriction;
				if (this.getControllingPassenger() instanceof Player) {
					this.landFriction /= 2.0F;
				}
			}
			Vec3 deltaMovement = this.getDeltaMovement();
			this.setDeltaMovement(deltaMovement.x * (double) this.invFriction, deltaMovement.y + yFlowing, deltaMovement.z * (double) this.invFriction);
			this.deltaRotation *= this.invFriction;
			if (yWater > 0.0) {
				Vec3 vec3 = this.getDeltaMovement();
				this.setDeltaMovement(vec3.x, (vec3.y + yWater * 0.06153846016296973) * 0.75, vec3.z);
			}
		}
	}

	private void controlBoat() {
		if (!this.isVehicle()) {
			return;
		}
		float movement = 0.0F;
		if (this.getControllingPassenger() instanceof LocalPlayer localPlayer) {
			if (localPlayer.input.left) {
				this.deltaRotation -= 1.0F;
			}
			if (localPlayer.input.right) {
				this.deltaRotation += 1.0F;
			}
			if (localPlayer.input.right != localPlayer.input.left && !localPlayer.input.up && !localPlayer.input.down) {
				movement += 0.005F;
			}
			this.setYRot(this.getYRot() + this.deltaRotation);
			if (localPlayer.input.up) {
				movement += 0.04F;
			}
			if (localPlayer.input.down) {
				movement -= 0.005F;
			}
		}
		this.setDeltaMovement(this.getDeltaMovement().add(Mth.sin(-this.getYRot() * ((float) Math.PI / 180)) * movement, 0.0, Mth.cos(this.getYRot() * ((float) Math.PI / 180)) * movement));
	}

	private void tickLerp() {
		if (this.isControlledByLocalInstance()) {
			this.lerpSteps = 0;
			this.syncPacketPositionCodec(this.getX(), this.getY(), this.getZ());
		}
		if (this.lerpSteps <= 0) {
			return;
		}
		this.lerpPositionAndRotationStep(this.lerpSteps, this.lerpX, this.lerpY, this.lerpZ, this.lerpYRot, this.lerpXRot);
		--this.lerpSteps;
	}

	@Override
	public void tick() {
		this.oldStatus = this.status;
		this.status = this.getStatus();

		super.tick();
		this.tickLerp();

		if (this.isControlledByLocalInstance()) {
			this.floatBoat();
			if (this.level().isClientSide) {
				this.controlBoat();
			}
			this.move(MoverType.SELF, this.getDeltaMovement());
		} else {
			this.setDeltaMovement(Vec3.ZERO);
		}
		this.checkInsideBlocks();
	}

	@Override
	public boolean isPushedByFluid() {
		return false;
	}

	@Override
	public MobType getMobType() {
		return MobType.WATER;
	}

	@Override
	public boolean isUnderWater() {
		return this.status == Status.UNDER_WATER || this.status == Status.UNDER_FLOWING_WATER;
	}

	public static enum Status {
		IN_WATER,
		UNDER_WATER,
		UNDER_FLOWING_WATER,
		ON_LAND,
		IN_AIR;
	}
}
