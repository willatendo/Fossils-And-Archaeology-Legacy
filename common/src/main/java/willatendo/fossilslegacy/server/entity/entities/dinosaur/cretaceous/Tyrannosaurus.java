package willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
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
import willatendo.fossilslegacy.server.entity.util.BlockBreakRule;
import willatendo.fossilslegacy.server.entity.util.Diet;
import willatendo.fossilslegacy.server.entity.util.DinoSituation;
import willatendo.fossilslegacy.server.entity.util.DinosaurUtils;
import willatendo.fossilslegacy.server.entity.util.interfaces.CommandingType;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.util.interfaces.RideableDinosaur;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.sound.FASoundEvents;
import willatendo.fossilslegacy.server.tags.*;

import java.util.Optional;

public class Tyrannosaurus extends Dinosaur implements DinopediaInformation, RideableDinosaur {
    private static final EntityDataAccessor<Boolean> KNOCKED_OUT = SynchedEntityData.defineId(Tyrannosaurus.class, EntityDataSerializers.BOOLEAN);
    private final BlockBreakRule blockBreakRule = new BlockBreakRule(this, 3, FABlockTags.TYRANNOSAURUS_UNBREAKABLES);

    public Tyrannosaurus(EntityType<? extends Tyrannosaurus> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier tyrannosaurusAttributes() {
        return Animal.createAnimalAttributes().add(Attributes.MAX_HEALTH, 200.0F).add(Attributes.MOVEMENT_SPEED, 0.4D).add(Attributes.ATTACK_DAMAGE, 7.0D).build();
    }

    @Override
    public EntityType<Egg> getEggEntityType() {
        return FAEntityTypes.TYRANNOSAURUS_EGG.get();
    }

    @Override
    public float maxUpStep() {
        return DinosaurUtils.getStepHeights(8, 1.0F, 2.0F)[this.getGrowthStage()];
    }

    @Override
    public int getMinRideableAge() {
        return this.getMaxGrowthStage() / 2;
    }

    @Override
    public boolean tamesOnBirth() {
        return false;
    }

    @Override
    public int getMaxHunger() {
        return 100;
    }

    @Override
    public TagKey<ModelType> getModelTypes() {
        return FAModelTypeTags.TYRANNOSAURUS;
    }

    @Override
    public int getMaxGrowthStage() {
        return 8;
    }

    @Override
    public double getMinHealth() {
        return 15.0F;
    }

    @Override
    public Diet getDiet() {
        return Diet.carnivore(this.level());
    }

    @Override
    public boolean hurtServer(ServerLevel serverLevel, DamageSource damageSource, float damage) {
        if (damageSource.is(FADamageTypeTags.TYRANNOSAURUS_IMMUNE)) {
            return false;
        }
        return super.hurtServer(serverLevel, damageSource, damage);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.blockBreakRule.canUse()) {
            this.blockBreakRule.tick();
        }

        if (!this.isTame() && this.getGrowthStage() > 3) {
            if (this.getHunger() == 1 || this.getHealth() <= 20) {
                this.setKnockedOut(true);
            }
        }
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new DinoFollowFlareGoal(this));
        this.goalSelector.addGoal(0, new FloatGoal(this) {
            @Override
            public boolean canUse() {
                return !Tyrannosaurus.this.isKnockedOut() ? super.canUse() : false;
            }
        });
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D) {
            @Override
            public boolean canUse() {
                return !Tyrannosaurus.this.isKnockedOut() ? super.canUse() : false;
            }
        });
        this.goalSelector.addGoal(2, new DinoTemptGoal(this, 1.1D, false) {
            @Override
            public boolean canUse() {
                return !Tyrannosaurus.this.isKnockedOut() ? super.canUse() : false;
            }
        });
        this.goalSelector.addGoal(3, new DinoBabyFollowParentGoal(this, 1.1D) {
            @Override
            public boolean canUse() {
                return !Tyrannosaurus.this.isKnockedOut() ? super.canUse() : false;
            }
        });
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true) {
            @Override
            public boolean canUse() {
                return !Tyrannosaurus.this.isKnockedOut() ? super.canUse() : false;
            }
        });
        this.goalSelector.addGoal(5, new DinoWaterAvoidingRandomStrollGoal(this, 1.0D) {
            @Override
            public boolean canUse() {
                return !Tyrannosaurus.this.isKnockedOut() ? super.canUse() : false;
            }
        });
        this.goalSelector.addGoal(5, new DinoFollowOwnerGoal(this, 1.0D, 10.0F, 2.0F) {
            @Override
            public boolean canUse() {
                return !Tyrannosaurus.this.isKnockedOut() ? super.canUse() : false;
            }
        });
        this.goalSelector.addGoal(6, new DinoEatFromFeederGoal(this, 1.0D, 24, true) {
            @Override
            public boolean canUse() {
                return !Tyrannosaurus.this.isKnockedOut() ? super.canUse() : false;
            }
        });
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F) {
            @Override
            public boolean canUse() {
                return !Tyrannosaurus.this.isKnockedOut() ? super.canUse() : false;
            }
        });
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this) {
            @Override
            public boolean canUse() {
                return !Tyrannosaurus.this.isKnockedOut() ? super.canUse() : false;
            }
        });
        this.targetSelector.addGoal(1, new DinoOwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new DinoOwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(4, new DinoNearestAttackableTargetGoal<>(this, FAEntityTypeTags.TYRANNOSAURUS_VICTIMS, true));
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(KNOCKED_OUT, false);
    }

    @Override
    public InteractionResult interactAt(Player player, Vec3 vec3, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);

        if (itemStack.is(FAItems.SCARAB_GEM.get())) {
            if (this.isKnockedOut() && !this.isTame() && this.getGrowthStage() > 3) {
                this.setKnockedOut(false);
                this.setHealth(this.getMaxHealth());
                this.setOwnerUUID(player.getUUID());
                return InteractionResult.SUCCESS;
            } else {
                if (player instanceof ServerPlayer serverPlayer) {
                    if (this.getGrowthStage() <= 3) {
                        this.sendMessageToPlayer(DinoSituation.TAME_TYRANNOSAURUS_ERROR_TOO_YOUNG, serverPlayer);
                    } else if (!this.isKnockedOut()) {
                        this.sendMessageToPlayer(DinoSituation.TAME_TYRANNOSAURUS_ERROR_HEALTH, serverPlayer);
                    }
                }
            }
        }

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
        return !this.isKnockedOut() ? this.getOverridenSoundEvent(FASoundEvents.TYRANNOSAURUS_AMBIENT.get(), ModelType.OverrideInfo.OverridenSoundType.AMBIENT) : super.getAmbientSound();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return !this.isKnockedOut() ? this.getOverridenSoundEvent(FASoundEvents.TYRANNOSAURUS_HURT.get(), ModelType.OverrideInfo.OverridenSoundType.HURT) : super.getHurtSound(damageSource);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return !this.isKnockedOut() ? this.getOverridenSoundEvent(FASoundEvents.TYRANNOSAURUS_DEATH.get(), ModelType.OverrideInfo.OverridenSoundType.DEATH) : super.getDeathSound();
    }

    public boolean isKnockedOut() {
        return this.entityData.get(KNOCKED_OUT);
    }

    public void setKnockedOut(boolean knockedOut) {
        this.entityData.set(KNOCKED_OUT, knockedOut);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("KnockedOut", this.isKnockedOut());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.setKnockedOut(compoundTag.getBoolean("KnockedOut"));
    }

    @Override
    public Optional<ResourceKey<DinopediaType>> getDinopediaType() {
        return Optional.of(FADinopediaTypes.TYRANNOSAURUS);
    }

    @Override
    public CommandingType commandItems() {
        return CommandingType.tag(FAItemTags.TYRANNOSAURUS_COMMANDABLES);
    }
}
