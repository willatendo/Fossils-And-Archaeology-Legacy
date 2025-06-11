package willatendo.fossilslegacy.server.entity.entities.vehicle;

import com.google.common.collect.Lists;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractBoat;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class Jeep extends VehicleEntity {
    private float deltaRotation;
    private int lerpSteps;
    private double lerpX;
    private double lerpY;
    private double lerpZ;
    private double lerpYRot;
    private double lerpXRot;
    private final Supplier<Item> dropItem;

    public Jeep(EntityType<? extends Jeep> entityType, Level level, Supplier<Item> dropItem) {
        super(entityType, level);
        this.dropItem = dropItem;
        this.blocksBuilding = true;
    }

    @Override
    protected Entity.MovementEmission getMovementEmission() {
        return Entity.MovementEmission.EVENTS;
    }

    @Override
    public boolean canCollideWith(Entity entity) {
        return AbstractBoat.canVehicleCollide(this, entity);
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    public Vec3 getRelativePortalPosition(Direction.Axis axis, BlockUtil.FoundRectangle foundRectangle) {
        return LivingEntity.resetForwardDirectionOfRelativePortalPosition(super.getRelativePortalPosition(axis, foundRectangle));
    }

    @Override
    protected Vec3 getPassengerAttachmentPoint(Entity entity, EntityDimensions entityDimensions, float p_376713_) {
        return new Vec3(0.0F, entityDimensions.height() / 4.0F, 0.0F).yRot(-this.getYRot() * 0.017453292F);
    }

    @Override
    public void push(Entity entity) {
        if (entity instanceof Jeep) {
            if (entity.getBoundingBox().minY < this.getBoundingBox().maxY) {
                super.push(entity);
            }
        } else if (entity.getBoundingBox().minY <= this.getBoundingBox().minY) {
            super.push(entity);
        }
    }

    @Override
    public boolean isPickable() {
        return !this.isRemoved();
    }

    @Override
    public void cancelLerp() {
        this.lerpSteps = 0;
    }

    @Override
    public void lerpTo(double p_376789_, double p_376649_, double p_376850_, float p_376105_, float p_376936_, int p_376914_) {
        this.lerpX = p_376789_;
        this.lerpY = p_376649_;
        this.lerpZ = p_376850_;
        this.lerpYRot = (double) p_376105_;
        this.lerpXRot = (double) p_376936_;
        this.lerpSteps = p_376914_;
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

    @Override
    public void tick() {
        if (this.level() instanceof ServerLevel) {
            this.applyGravity();
        }

        super.tick();
        this.tickLerp();
    }

    private void tickLerp() {
        if (this.lerpSteps > 0) {
            this.lerpPositionAndRotationStep(this.lerpSteps, this.lerpX, this.lerpY, this.lerpZ, this.lerpYRot, this.lerpXRot);
            --this.lerpSteps;
        }
    }

    @Override
    protected double getDefaultGravity() {
        return 0.04;
    }

    @Nullable
    @Override
    public LivingEntity getControllingPassenger() {
        Entity entity = this.getFirstPassenger();
        if (entity instanceof Player player) {
            return player;
        }
        return super.getControllingPassenger();
    }

    @Override
    protected void positionRider(Entity entity, Entity.MoveFunction moveFunction) {
        super.positionRider(entity, moveFunction);
        if (!entity.getType().is(EntityTypeTags.CAN_TURN_IN_BOATS)) {
            entity.setYRot(entity.getYRot() + this.deltaRotation);
            entity.setYHeadRot(entity.getYHeadRot() + this.deltaRotation);
            this.clampRotation(entity);
            if (entity instanceof Animal animal && this.getPassengers().size() == 1) {
                int i = entity.getId() % 2 == 0 ? 90 : 270;
                entity.setYBodyRot(animal.yBodyRot + (float) i);
                entity.setYHeadRot(entity.getYHeadRot() + (float) i);
            }
        }
    }

    @Override
    public Vec3 getDismountLocationForPassenger(LivingEntity livingEntity) {
        Vec3 vec3 = getCollisionHorizontalEscapeVector(this.getBbWidth() * Mth.SQRT_OF_TWO, livingEntity.getBbWidth(), livingEntity.getYRot());
        double x = this.getX() + vec3.x;
        double z = this.getZ() + vec3.z;
        BlockPos blockPosInArea = BlockPos.containing(x, this.getBoundingBox().maxY, z);
        BlockPos blockPosBelowArea = blockPosInArea.below();
        if (!this.level().isWaterAt(blockPosBelowArea)) {
            List<Vec3> validLocations = Lists.newArrayList();
            double floorHeight = this.level().getBlockFloorHeight(blockPosInArea);
            if (DismountHelper.isBlockFloorValid(floorHeight)) {
                validLocations.add(new Vec3(x, (double) blockPosInArea.getY() + floorHeight, z));
            }

            double floorHeightBelow = this.level().getBlockFloorHeight(blockPosBelowArea);
            if (DismountHelper.isBlockFloorValid(floorHeightBelow)) {
                validLocations.add(new Vec3(x, (double) blockPosBelowArea.getY() + floorHeightBelow, z));
            }

            for (Pose pose : livingEntity.getDismountPoses()) {
                for (Vec3 validLocation : validLocations) {
                    if (DismountHelper.canDismountTo(this.level(), validLocation, livingEntity, pose)) {
                        livingEntity.setPose(pose);
                        return validLocation;
                    }
                }
            }
        }

        return super.getDismountLocationForPassenger(livingEntity);
    }

    protected void clampRotation(Entity entity) {
        entity.setYBodyRot(this.getYRot());
        float yRot = Mth.wrapDegrees(entity.getYRot() - this.getYRot());
        float clamp = Mth.clamp(yRot, -105.0F, 105.0F);
        entity.yRotO += clamp - yRot;
        entity.setYRot(entity.getYRot() + clamp - yRot);
        entity.setYHeadRot(entity.getYRot());
    }

    @Override
    public void onPassengerTurned(Entity entity) {
        this.clampRotation(entity);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand interactionHand) {
        InteractionResult interactionResult = super.interact(player, interactionHand);
        if (interactionResult != InteractionResult.PASS) {
            return interactionResult;
        } else {
            return player.isSecondaryUseActive() || !this.level().isClientSide && !player.startRiding(this) ? InteractionResult.PASS : InteractionResult.SUCCESS;
        }
    }

    @Override
    protected Item getDropItem() {
        return this.dropItem.get();
    }

    @Nullable
    @Override
    public ItemStack getPickResult() {
        return new ItemStack(this.dropItem.get());
    }
}
