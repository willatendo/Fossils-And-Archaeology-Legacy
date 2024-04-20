package willatendo.fossilslegacy.server.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.utils.Lists;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.client.FossilsLegacyKeys;
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
	public float targetY = 0.0F;

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
		if (this.isAlive()) {
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

	public boolean isOnSurface() {
		return (this.level().getBlockState(new BlockPos((int) Math.floor(this.getX()), (int) Math.floor(this.getY() + this.getEyeHeight() / 2), (int) Math.floor(this.getZ()))).is(Blocks.AIR));
	}

	@Override
	public void aiStep() {
		super.aiStep();

		this.handleRiding();
	}

	@Override
	public void tick() {
		FossilsLegacyUtils.LOGGER.info(this.targetY + "");

		super.tick();

		if (this.isInWaterOrBubble()) {
			if (((!this.isOnSurface() && this.targetY > this.getY()) || this.targetY < this.getY()) && !this.verticalCollision) {
				if (this.targetY > this.getY()) {
					this.setYya(2.0F);
				} else {
					this.setYya(-1.0F);
				}
			}
			if ((Math.abs(this.getY() - this.targetY) <= 0.125D) || this.isOnSurface()) {
				this.setYya(0.0F);
			}
		}
	}

	private void handleRiding() {
		if (this.hasControllingPassenger()) {
			if (this.getControllingPassenger() instanceof LocalPlayer localPlayer) {
				if (FossilsLegacyKeys.SINK.isDown()) {
					this.targetY = (float) this.getY() - 0.5F;
				} else {
					if (this.isOnSurface()) {
						this.targetY = (float) this.getY();
					} else if (localPlayer.xxa == 0.0F) {
						this.targetY = (float) this.getY() + 0.2F;
					} else {
						this.targetY = (float) this.getY();
					}
				}
			}
		}
	}

	public void addYRot(float add) {
		this.setYRot(this.getYRot() + add);
	}

	@Override
	public boolean isPushedByFluid() {
		return false;
	}

	@Override
	protected float getWaterSlowDown() {
		return this.hasControllingPassenger() ? 0.75F : super.getWaterSlowDown();
	}
}
