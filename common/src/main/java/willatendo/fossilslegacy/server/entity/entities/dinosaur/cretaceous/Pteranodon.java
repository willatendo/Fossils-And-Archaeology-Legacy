package willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;
import willatendo.fossilslegacy.server.dinopedia_type.FADinopediaTypes;
import willatendo.fossilslegacy.server.egg_variant.EggVariant;
import willatendo.fossilslegacy.server.egg_variant.FAEggVariants;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.entity.goals.*;
import willatendo.fossilslegacy.server.entity.util.DinosaurUtils;
import willatendo.fossilslegacy.server.entity.util.interfaces.*;
import willatendo.fossilslegacy.server.sound.FASoundEvents;
import willatendo.fossilslegacy.server.tags.FACoatTypeTags;
import willatendo.fossilslegacy.server.tags.FAItemTags;

import java.util.Optional;

public class Pteranodon extends Dinosaur implements DinopediaInformation, RideableDinosaur, FlyingDinosaur {
    public final AnimationState flyAnimationState = new AnimationState();
    public final AnimationState landAnimationState = new AnimationState();
    public float airSpeed = 0.0F;
    public float airAngle = 0.0F;
    public float airPitch = 0.0F;
    public float lastAirPitch = 0.0F;
    public boolean landing = false;

    public Pteranodon(EntityType<? extends Pteranodon> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier pteranodonAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0F).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 3.0D).build();
    }

    @Override
    protected EntityDimensions getDefaultDimensions(Pose pose) {
        CoatType coatType = this.getCoatType().value();
        CoatType.BoundingBoxInfo boundingBoxInfo = coatType.boundingBoxInfo();
        EntityDimensions newDimensions = this.dimensions = EntityDimensions.scalable(boundingBoxInfo.boundingBoxWidth() + (boundingBoxInfo.boundingBoxGrowth() * this.getGrowthStage()), boundingBoxInfo.boundingBoxHeight() + (boundingBoxInfo.boundingBoxGrowth() * this.getGrowthStage()));
        if (this.shouldFly() && !this.landing) {
            return newDimensions.scale(1.0F, 0.5F);
        }
        return newDimensions;
    }

    @Override
    protected Component getTypeName() {
        return this.getOverridenName(super.getTypeName());
    }

    @Override
    public float getAirPitch() {
        return this.airPitch;
    }

    @Override
    public float getAirAngle() {
        return this.airAngle;
    }

    @Override
    public boolean shouldFly() {
        return !this.onGround() && !this.isInWaterOrBubble() && ((this.level().getBlockState(this.blockPosition().below()).isAir() && this.position().y - this.blockPosition().getY() < 0.5F) || (this.level().getBlockState(this.blockPosition()).isAir() && this.position().y - this.blockPosition().getY() > 0.5F));
    }

    @Override
    public boolean shouldLand() {
        return this.landing;
    }

    @Override
    public AnimationState getFlyingAnimationState() {
        return this.flyAnimationState;
    }

    @Override
    public AnimationState getLandingAnimationState() {
        return this.landAnimationState;
    }

    @Override
    public float maxUpStep() {
        return DinosaurUtils.getStepHeights(8, 0.5F, 1.0F)[this.getGrowthStage()];
    }

    @Override
    public int getMinRideableAge() {
        return 5;
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
    public TagKey<CoatType> getCoatTypes() {
        return FACoatTypeTags.PTERANODON;
    }

    @Override
    public Holder<EggVariant> getEggVariant() {
        return FAEggVariants.PTERANODON;
    }

    @Override
    public Diet getDiet() {
        return Diet.piscivore(this.level());
    }

    @Override
    public void tick() {
        this.handleRiding();
        if (this.level().isClientSide()) {
            this.flyAnimationState.animateWhen(this.shouldFly() && !this.landing, this.tickCount);
            this.landAnimationState.animateWhen(this.landing, this.tickCount);
        }

        super.tick();
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
        return this.hasControllingPassenger() && this.shouldFly();
    }

    @Override
    public boolean isNoAi() {
        return (this.hasControllingPassenger() && this.shouldFly()) || super.isNoAi();
    }

    @Override
    public void travel(Vec3 vec3) {
        if (this.isAlive()) {
            LivingEntity livingEntity = this.getControllingPassenger();
            if (this.isVehicle() && livingEntity != null) {
                if (!this.shouldFly()) {
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
                } else {
                    super.travel(vec3);
                }
            } else {
                super.travel(vec3);
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.getOverridenSoundEvent(FASoundEvents.PTERANODON_AMBIENT.get(), CoatType.OverrideInfo.OverridenSoundType.AMBIENT);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return this.getOverridenSoundEvent(FASoundEvents.PTERANODON_HURT.get(), CoatType.OverrideInfo.OverridenSoundType.HURT);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return this.getOverridenSoundEvent(FASoundEvents.PTERANODON_DEATH.get(), CoatType.OverrideInfo.OverridenSoundType.DEATH);
    }

    @Override
    public Optional<ResourceKey<DinopediaType>> getDinopediaType() {
        return Optional.of(FADinopediaTypes.PTERANODON);
    }

    @Override
    public CommandingType commandItems() {
        return CommandingType.tag(FAItemTags.PTERANODON_COMMANDABLES);
    }

    private void handleRiding() {
        if (this.isInWaterOrBubble()) {
            if (this.landing) {
                this.landing = false;
            }
            return;
        }
        if (this.hasControllingPassenger() && this.getControllingPassenger() instanceof LocalPlayer localPlayer) {
            this.handleLanding();
            if (!this.shouldFly()) {
                if (this.airSpeed != 0.0F) {
                    this.airSpeed = 0.0F;
                }
                if (this.airAngle != 0.0F) {
                    this.airAngle = 0.0F;
                }
                if (this.airPitch != 0.0F) {
                    this.airPitch = 0.0F;
                }
                this.addYRot(-(localPlayer.xxa * 5.0F));
            } else {
                if (this.zza == 0.0F) {
                    this.zza = 0.2F;
                }
                this.airAngle -= localPlayer.xxa;
                if (this.airAngle > 30.0F) {
                    this.airAngle = 30.0F;
                }
                if (this.airAngle < -30.0F) {
                    this.airAngle = -30.0F;
                }
                if (Math.abs(this.airAngle) > 10.0F) {
                    this.addYRot(this.airAngle > 0.0F ? 1.0F : -1.0F);
                }
                if (this.landing) {
                    this.airPitch = 0.0F;
                    if (!this.verticalCollision) {
                        this.yya = -0.2F;
                    } else {
                        this.yya = 0.0F;
                    }
                    Vec3 moveDirection = new Vec3(this.xxa, this.yya, this.zza);
                    this.moveRelative(this.airSpeed, moveDirection);
                } else {
                    if ((this.horizontalCollision || this.verticalCollision) && this.airSpeed != 0.0F) {
                        this.airSpeed = 0.0F;
                        Vec3 noDirection = new Vec3(0.0F, 0.0F, 0.0F);
                        this.moveRelative(this.airSpeed, noDirection);
                        return;
                    }
                    if (this.airSpeed == 0) {
                        this.airSpeed = 0.15F;
                    }
                    this.airAngle -= localPlayer.xxa;
                    if (this.airAngle > 30.0F) {
                        this.airAngle = 30.0F;
                    }
                    if (this.airAngle < -30.0F) {
                        this.airAngle = -30.0F;
                    }

                    this.airPitch -= localPlayer.zza * 2;
                    if (this.airPitch > 90.0F) {
                        this.airPitch = 90.0F;
                    }
                    if (this.airPitch < -60.0F) {
                        this.airPitch = -60.0F;
                    }
                    float yPitch = (float) (this.airPitch * (Math.PI / 180));
                    if (this.lastAirPitch >= this.airPitch) {
                        double speedOffset = Math.cos(yPitch);
                        if (yPitch < 0) {
                            speedOffset += 1;
                        }
                        Vec3 moveDirection = new Vec3(this.xxa, this.yya, this.zza);
                        this.moveRelative(this.airSpeed * (float) speedOffset, moveDirection);
                        if (this.airPitch < 60 && this.zza > 0.1F) {
                            this.yya = (float) (Math.sin(yPitch) * 0.4F);
                        }
                    }
                    this.lastAirPitch = this.airPitch;
                }
            }
        }
    }

    public void handleLanding() {
        if (this.hasControllingPassenger() && !this.verticalCollision && !this.onGround() && !this.isInWaterOrBubble()) {
            if (!this.landing) {
                if (this.airPitch > 60) {
                    this.landing = true;
                }
            }
        } else {
            this.landing = false;
        }
    }

    public void addYRot(float add) {
        this.setYRot(this.getYRot() + add);
    }
}
