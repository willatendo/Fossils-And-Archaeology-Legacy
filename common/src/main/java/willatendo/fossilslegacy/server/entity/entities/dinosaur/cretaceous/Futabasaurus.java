package willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;
import willatendo.fossilslegacy.server.dinopedia_type.FADinopediaTypes;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.entity.entities.Egg;
import willatendo.fossilslegacy.server.entity.goals.*;
import willatendo.fossilslegacy.server.entity.util.DinosaurUtils;
import willatendo.fossilslegacy.server.entity.util.interfaces.CommandingType;
import willatendo.fossilslegacy.server.entity.util.interfaces.Diet;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.util.interfaces.RideableDinosaur;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.sound.FASoundEvents;
import willatendo.fossilslegacy.server.tags.FAModelTypeTags;

import java.util.Optional;

public class Futabasaurus extends Dinosaur implements DinopediaInformation, RideableDinosaur {
    private static final EntityDataAccessor<Boolean> SHOULD_SINK = SynchedEntityData.defineId(Futabasaurus.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DIVE_POSE = SynchedEntityData.defineId(Futabasaurus.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Float> TARGET_Y = SynchedEntityData.defineId(Futabasaurus.class, EntityDataSerializers.FLOAT);

    public Futabasaurus(EntityType<? extends Dinosaur> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier futabasaurusAttributes() {
        return Animal.createAnimalAttributes().add(Attributes.MAX_HEALTH, 16.0F).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 3.0D).build();
    }

    public static boolean checkFutabasaurusSpawnRules(EntityType<Futabasaurus> entityType, ServerLevelAccessor serverLevelAccessor, EntitySpawnReason entitySpawnReason, BlockPos blockPos, RandomSource randomSource) {
        return blockPos.getY() >= (serverLevelAccessor.getSeaLevel() - 13) && blockPos.getY() <= serverLevelAccessor.getSeaLevel() && serverLevelAccessor.getFluidState(blockPos.below()).is(FluidTags.WATER) && serverLevelAccessor.getBlockState(blockPos.above()).is(Blocks.WATER);
    }

    @Override
    public EntityType<Egg> getEggEntityType() {
        return FAEntityTypes.FUTABASAURUS_EGG.get();
    }

    @Override
    public float maxUpStep() {
        return DinosaurUtils.getStepHeights(12, 0.5F, 1.0F)[this.getGrowthStage()];
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
    public TagKey<ModelType> getModelTypes() {
        return FAModelTypeTags.FUTABASAURUS;
    }

    @Override
    public int getMaxGrowthStage() {
        return 12;
    }

    @Override
    public double getMinHealth() {
        return 4.0D;
    }

    @Override
    public Diet getDiet() {
        return Diet.piscivore(this.level());
    }

    @Override
    protected void registerGoals() {
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
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(SHOULD_SINK, false);
        builder.define(DIVE_POSE, false);
        builder.define(TARGET_Y, 0.0F);
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
            } else {
                super.travel(vec3);
            }
        } else {
            super.travel(vec3);
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.getOverridenSoundEvent(FASoundEvents.FUTABASAURUS_AMBIENT.get(), ModelType.OverrideInfo.OverridenSoundType.AMBIENT);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return this.getOverridenSoundEvent(FASoundEvents.FUTABASAURUS_HURT.get(), ModelType.OverrideInfo.OverridenSoundType.HURT);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return this.getOverridenSoundEvent(FASoundEvents.FUTABASAURUS_DEATH.get(), ModelType.OverrideInfo.OverridenSoundType.DEATH);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("ShouldSink", this.shouldSink());
        compoundTag.putBoolean("DivePose", this.shouldSink());
        compoundTag.putFloat("TargetY", this.targetY());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.setShouldSink(compoundTag.getBoolean("ShouldSink"));
        this.setTargetY(compoundTag.getFloat("TargetY"));
    }

    public boolean shouldSink() {
        return this.entityData.get(SHOULD_SINK);
    }

    public void setShouldSink(boolean shouldSink) {
        this.entityData.set(SHOULD_SINK, shouldSink);
    }

    public boolean divePose() {
        return this.entityData.get(DIVE_POSE);
    }

    public void setDivePose(boolean divePose) {
        this.entityData.set(DIVE_POSE, divePose);
    }

    public float targetY() {
        return this.entityData.get(TARGET_Y);
    }

    public void setTargetY(float shouldSink) {
        this.entityData.set(TARGET_Y, shouldSink);
    }

    @Override
    public Optional<ResourceKey<DinopediaType>> getDinopediaType() {
        return Optional.of(FADinopediaTypes.FUTABASAURUS);
    }

    @Override
    public CommandingType commandItems() {
        return CommandingType.none();
    }

    public boolean isOnSurface() {
        return (this.level().getBlockState(new BlockPos((int) Math.floor(this.getX()), (int) Math.floor(this.getY() + this.getEyeHeight() / 2), (int) Math.floor(this.getZ()))).is(Blocks.AIR));
    }

    public boolean shouldDivePose() {
        return (this.level().getBlockState(new BlockPos((int) Math.floor(this.getX()), (int) Math.floor(this.getY() + this.getEyeHeight() / 2 + 1), (int) Math.floor(this.getZ()))).is(Blocks.AIR));
    }

    @Override
    public void aiStep() {
        super.aiStep();

        this.creatureFloat();

        if (!this.shouldDivePose()) {
            this.setDivePose(true);
        } else {
            this.setDivePose(false);
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.isInWaterOrBubble()) {
            if (((!this.isOnSurface() && this.targetY() > this.getY()) || this.targetY() < this.getY()) && !this.verticalCollision) {
                if (this.targetY() > this.getY()) {
                    this.setYya(2.0F);
                } else {
                    this.setYya(-1.0F);
                }
            }
            if ((Math.abs(this.getY() - this.targetY()) <= 0.125D) || this.isOnSurface()) {
                this.setYya(0.0F);
            }
        }
    }

    private void creatureFloat() {
        if (this.hasControllingPassenger()) {
            if (this.getControllingPassenger() instanceof LocalPlayer localPlayer) {
                if (this.shouldSink()) {
                    this.setTargetY((float) this.getY() - 0.5F);
                } else {
                    if (this.isOnSurface()) {
                        this.setTargetY((float) this.getY());
                    } else if (localPlayer.xxa == 0.0F) {
                        this.setTargetY((float) this.getY() + 0.2F);
                    } else {
                        this.setTargetY((float) this.getY());
                    }
                }
            }
        } else {
            if (this.isOnSurface()) {
                this.setTargetY((float) this.getY());
            } else {
                this.setTargetY((float) this.getY() + 0.2F);
            }
        }
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    protected float getWaterSlowDown() {
        return this.hasControllingPassenger() ? 1.0F : super.getWaterSlowDown();
    }
}
