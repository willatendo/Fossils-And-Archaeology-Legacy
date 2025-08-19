package willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;
import willatendo.fossilslegacy.server.dinopedia_type.FADinopediaTypes;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.entity.entities.Egg;
import willatendo.fossilslegacy.server.entity.goals.*;
import willatendo.fossilslegacy.server.entity.util.Diet;
import willatendo.fossilslegacy.server.entity.util.DinosaurUtils;
import willatendo.fossilslegacy.server.entity.util.interfaces.CommandingType;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.util.interfaces.RideableDinosaur;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.sound.FASoundEvents;
import willatendo.fossilslegacy.server.tags.FAItemTags;
import willatendo.fossilslegacy.server.tags.FAModelTypeTags;

import java.util.Optional;

public class Triceratops extends Dinosaur implements DinopediaInformation, RideableDinosaur {
    public Triceratops(EntityType<? extends Triceratops> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier triceratopsAttributes() {
        return Animal.createAnimalAttributes().add(Attributes.MAX_HEALTH, 5.0F).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 4.0D).build();
    }

    @Override
    public EntityType<Egg> getEggEntityType() {
        return FAEntityTypes.TRICERATOPS_EGG.get();
    }

    @Override
    public float maxUpStep() {
        return DinosaurUtils.getStepHeights(this.getMaxGrowthStage(), 1.0F, 1.5F)[this.getGrowthStage()];
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
    public TagKey<ModelGene> getModelTypes() {
        return FAModelTypeTags.TRICERATOPS;
    }

    @Override
    public int getMaxGrowthStage() {
        return 12;
    }

    @Override
    public Diet getDiet() {
        return Diet.herbivore(this.level());
    }

    @Override
    public float[] healthPerGrowthStage() {
        return DinosaurUtils.getHealths(this.getMaxGrowthStage(), 5.0F, 40.0F);
    }

    @Override
    protected ItemStack getHead() {
        return new ItemStack(FAItems.TRICERATOPS_HEAD.get());
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new DinoFloatGoal(this));
        this.goalSelector.addGoal(1, new DinoPanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new DinoBreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new DinoTemptGoal(this, 1.1D, false));
        this.goalSelector.addGoal(4, new DinoBabyFollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new DinoMeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(6, new DinoWaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new DinoFollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
        this.goalSelector.addGoal(6, new DinoEatFromFeederGoal(this, 1.0D, 24, false));
        this.goalSelector.addGoal(6, new DinoEatFernsGoal(this));
        this.goalSelector.addGoal(7, new DinoLookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new DinoRandomLookAroundGoal(this));
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
            } else {
                super.travel(vec3);
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.getOverridenSoundEvent(FASoundEvents.TRICERATOPS_AMBIENT.get(), ModelGene.OverrideInfo.OverridenSoundType.AMBIENT);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return this.getOverridenSoundEvent(FASoundEvents.TRICERATOPS_HURT.get(), ModelGene.OverrideInfo.OverridenSoundType.HURT);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return this.getOverridenSoundEvent(FASoundEvents.TRICERATOPS_DEATH.get(), ModelGene.OverrideInfo.OverridenSoundType.DEATH);
    }

    @Override
    public Optional<ResourceKey<DinopediaType>> getDinopediaType() {
        return Optional.of(FADinopediaTypes.TRICERATOPS);
    }

    @Override
    public CommandingType commandItems() {
        return CommandingType.tag(FAItemTags.TRICERATOPS_COMMANDABLES);
    }
}
