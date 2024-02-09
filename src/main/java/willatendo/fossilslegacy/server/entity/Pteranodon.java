package willatendo.fossilslegacy.server.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.utils.Lists;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.block.entity.FeederBlockEntity;
import willatendo.fossilslegacy.server.entity.Egg.EggType;
import willatendo.fossilslegacy.server.entity.goal.DinoBabyFollowParentGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoFollowOwnerGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoOwnerHurtByTargetGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoOwnerHurtTargetGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoWaterAvoidingRandomStrollGoal;
import willatendo.fossilslegacy.server.item.FossilsLegacyItemTags;
import willatendo.fossilslegacy.server.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class Pteranodon extends Dinosaur implements DinopediaInformation, RideableDinosaur {
	public float airSpeed = 0.0F;
	public float airAngle = 0.0F;
	public float airPitch = 0.0F;
	public float lastAirPitch = 0.0F;
	public boolean landing = false;
	public boolean isFlying = false;

	public Pteranodon(EntityType<? extends Pteranodon> entityType, Level level) {
		super(entityType, level);
	}

	public static AttributeSupplier pteranodonAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0F).add(Attributes.MOVEMENT_SPEED, 0.2D).build();
	}

	@Override
	public float maxUpStep() {
		return DinosaurTypes.PTEROSAURUS.getStepHeights()[this.getGrowthStage()];
	}

	@Override
	public int getMinRideableAge() {
		return 5;
	}

	@Override
	public void aiStep() {
		this.handleFlying();
		super.aiStep();
	}

	@Override
	public void tick() {
		super.tick();

		if (this.isAlive()) {
			if (!this.isFlying) {
				if (this.canFly() && this.tickCount % 10 == 0) {
					this.isFlying = true;
				}
			} else if (this.isFlying && !this.canFly()) {
				this.isFlying = false;
			}
		}
	}

	public boolean canFly() {
		return !this.onGround() && !this.isInWaterOrBubble() && this.isVehicle();
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, DinoConstants.PISCIVORE_FOOD, false));
		this.goalSelector.addGoal(4, new DinoBabyFollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(6, new DinoWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new DinoFollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new DinoOwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new DinoOwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
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
	public boolean isNoGravity() {
		return this.isFlying;
	}

	@Override
	public boolean isNoAi() {
		return this.isFlying;
	}

	@Override
	public void travel(Vec3 vec3) {
		if (this.isAlive()) {
			LivingEntity livingEntity = this.getControllingPassenger();
			if (this.isVehicle() && livingEntity != null) {
				if (!this.isFlying) {
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
	}

	private void handleFlying() {
		if (!this.hasControllingPassenger() || !(this.getControllingPassenger() instanceof LocalPlayer)) {
			return;
		}
		LocalPlayer localPlayer = (LocalPlayer) this.getControllingPassenger();
		this.handleLanding();
		if (this.isFlying) {
			this.airAngle -= localPlayer.xxa;
			if (this.airAngle > 30F) {
				this.airAngle = 30F;
			}
			if (this.airAngle < -30F) {
				this.airAngle = -30F;
			}
			if (Math.abs(this.airAngle) > 10) {
				this.yRotO += (this.airAngle > 0 ? 1 : -1);
			}
			for (; this.yRotO < -180F; this.yRotO += 360F) {
			}
			for (; this.yRotO >= 180F; this.yRotO -= 360F) {
			}
			if (this.landing) {
				this.airPitch = 0;
				if (!this.verticalCollision) {
					this.yya = -0.2F;
				} else {
					this.yya = 0;
				}
				this.setDeltaMovement(new Vec3(0.0F, this.airSpeed, 0.0F));
			} else {
				if ((this.horizontalCollision || this.verticalCollision) && this.airSpeed != 0) {
					this.airSpeed = 0.0F;
					this.setDeltaMovement(new Vec3(0.0F, 0.0F, 0.0F));
					return;
				}
				if (this.airSpeed == 0 && this.yya != 0) {
					this.airSpeed = this.yya * this.yya;
				}
				this.airAngle -= localPlayer.xxa;
				if (this.airAngle > 30F) {
					this.airAngle = 30F;
				}
				if (this.airAngle < -30F) {
					this.airAngle = -30F;
				}

				this.airPitch -= localPlayer.zza * 2;
				if (this.airPitch > 90) {
					this.airPitch = 90;
				}
				if (this.airPitch < -60) {
					this.airPitch = -60;
				}
				float pitch = (float) (this.airPitch * (Math.PI / 180));
				if (this.lastAirPitch >= this.airPitch) {
					double SpeedOffset = Math.cos(pitch);
					if (pitch < 0) {
						SpeedOffset += 1;
					}
					this.setZza(this.airSpeed * (float) SpeedOffset);
					if (this.airPitch < 60 && this.zza > 0.1F) {
						this.yya = (float) (Math.sin(pitch) * 0.4F);
					}
				}
				this.lastAirPitch = this.airPitch;
			}
		}
	}

	public void handleLanding() {
		if (this.hasControllingPassenger() && !this.verticalCollision && !this.onGround()) {
			if (!this.landing) {
				if (this.airPitch > 60) {
					this.landing = true;
				}
			}
		} else {
			this.landing = false;
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return FossilsLegacySoundEvents.PTERANODON_AMBIENT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return FossilsLegacySoundEvents.PTERANODON_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return FossilsLegacySoundEvents.PTERANODON_DEATH.get();
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compoundTag) {
		super.addAdditionalSaveData(compoundTag);

		compoundTag.putFloat("AirSpeed", this.airSpeed);
		compoundTag.putFloat("AirAngle", this.airAngle);
		compoundTag.putFloat("AirPitch", this.airPitch);
		compoundTag.putBoolean("IsFlying", this.isFlying);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compoundTag) {
		super.readAdditionalSaveData(compoundTag);

		this.airSpeed = compoundTag.getFloat("AirSpeed");
		this.airAngle = compoundTag.getFloat("AirAngle");
		this.airPitch = compoundTag.getFloat("AirPitch");
		this.isFlying = compoundTag.getBoolean("IsFlying");
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
				information.add(FossilsLegacyUtils.translation("dinopedia", "able_to_fly"));
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
		return CommandType.tag(FossilsLegacyItemTags.PTERANODON_COMMANDABLES);
	}

	@Override
	public int getMaxGrowthStage() {
		return 8;
	}

	@Override
	public double getMinHealth() {
		return 4.0D;
	}

	@Override
	public int getMaxHunger() {
		return 100;
	}

	@Override
	public EggType eggType() {
		return EggType.PTERANODON;
	}

	@Override
	public float boundingBoxGrowth() {
		return 0.15F;
	}

	@Override
	public int foodLevelForItemStack(ItemStack itemStack) {
		return FeederBlockEntity.getMeatFoodLevel(itemStack);
	}
}
