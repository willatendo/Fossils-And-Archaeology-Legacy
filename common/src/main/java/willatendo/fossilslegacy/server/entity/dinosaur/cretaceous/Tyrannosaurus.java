package willatendo.fossilslegacy.server.entity.dinosaur.cretaceous;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
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
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEggVariants;
import willatendo.fossilslegacy.server.entity.goal.*;
import willatendo.fossilslegacy.server.entity.util.BlockBreakRule;
import willatendo.fossilslegacy.server.entity.util.DinoSituation;
import willatendo.fossilslegacy.server.entity.util.DinoUtils;
import willatendo.fossilslegacy.server.entity.util.interfaces.*;
import willatendo.fossilslegacy.server.entity.variants.EggVariant;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.tags.*;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.List;

public class Tyrannosaurus extends Dinosaur implements DinopediaInformation, RideableDinosaur {
    private static final EntityDataAccessor<Boolean> KNOCKED_OUT = SynchedEntityData.defineId(Tyrannosaurus.class, EntityDataSerializers.BOOLEAN);
    private final BlockBreakRule blockBreakRule = new BlockBreakRule(this, 3, FossilsLegacyBlockTags.TYRANNOSAURUS_UNBREAKABLES);

    public Tyrannosaurus(EntityType<? extends Tyrannosaurus> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier tyrannosaurusAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 200.0F).add(Attributes.MOVEMENT_SPEED, 0.4D).add(Attributes.ATTACK_DAMAGE, 7.0D).build();
    }

    @Override
    public float maxUpStep() {
        return DinoUtils.getStepHeights(8, 1.0F, 2.0F)[this.getGrowthStage()];
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
    public TagKey<CoatType> getCoatTypes() {
        return FossilsLegacyCoatTypeTags.TYRANNOSAURUS;
    }

    @Override
    public Holder<EggVariant> getEggVariant() {
        return FossilsLegacyEggVariants.TYRANNOSAURUS;
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
    public boolean hurt(DamageSource damageSource, float hearts) {
        if (damageSource.is(FossilsLegacyDamgeTypeTags.TYRANNOSAURUS_IMMUNE)) {
            return false;
        }
        return super.hurt(damageSource, hearts);
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
        this.targetSelector.addGoal(4, new DinoNearestAttackableTargetGoal<>(this, FossilsLegacyEntityTypeTags.TYRANNOSAURUS_VICTIMS, true));
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(KNOCKED_OUT, false);
    }

    @Override
    public InteractionResult interactAt(Player player, Vec3 vec3, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);

        if (itemStack.is(FossilsLegacyItems.SCARAB_GEM.get())) {
            if (this.isKnockedOut() && !this.isTame() && this.getGrowthStage() > 3) {
                this.setKnockedOut(false);
                this.setHealth(this.getMaxHealth());
                this.setOwnerUUID(player.getUUID());
                return InteractionResult.SUCCESS;
            } else {
                if (this.getGrowthStage() <= 3) {
                    this.sendMessageToPlayer(DinoSituation.TAME_TYRANNOSAURUS_ERROR_TOO_YOUNG, player);
                } else if (!this.isKnockedOut()) {
                    this.sendMessageToPlayer(DinoSituation.TAME_TYRANNOSAURUS_ERROR_HEALTH, player);
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
                this.tryCheckInsideBlocks();
            } else {
                super.travel(vec3);
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return !this.isKnockedOut() ? this.getOverridenSoundEvent(FossilsLegacySoundEvents.TYRANNOSAURUS_AMBIENT.get(), CoatType.OverrideInfo.OverridenSoundType.AMBIENT) : super.getAmbientSound();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return !this.isKnockedOut() ? this.getOverridenSoundEvent(FossilsLegacySoundEvents.TYRANNOSAURUS_HURT.get(), CoatType.OverrideInfo.OverridenSoundType.HURT) : super.getHurtSound(damageSource);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return !this.isKnockedOut() ? this.getOverridenSoundEvent(FossilsLegacySoundEvents.TYRANNOSAURUS_DEATH.get(), CoatType.OverrideInfo.OverridenSoundType.DEATH) : super.getDeathSound();
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
    public List<Component> info(Player player) {
        ArrayList<Component> information = Lists.newArrayList();
        if (this.isTame() && this.isOwnedBy(player)) {
            information.add(this.getDisplayName());
            information.add(FossilsLegacyUtils.translation("dinopedia", "owner", this.getOwner() != null ? this.getOwner().getDisplayName().getString() : FossilsLegacyUtils.translation("encyclopedia", "wild").getString()));
            information.add(FossilsLegacyUtils.translation("dinopedia", "age", this.getDaysAlive()));
            information.add(FossilsLegacyUtils.translation("dinopedia", "health", (int) this.getHealth(), (int) this.getMaxHealth()));
            information.add(FossilsLegacyUtils.translation("dinopedia", "hunger", this.getHunger(), this.getMaxHunger()));
            information.add(FossilsLegacyUtils.translation("dinopedia", "rideable"));
        } else {
            information.add(this.getDisplayName());
            if (this.isTame()) {
                information.add(FossilsLegacyUtils.translation("dinopedia", "not_owner"));
            } else {
                information.add(FossilsLegacyUtils.translation("dinopedia", "wild"));
                if (this.getAge() > 3) {
                    information.add(FossilsLegacyUtils.translation("dinopedia", "dangerous"));
                }
            }
        }
        return information;
    }

    @Override
    public CommandingType commandItems() {
        return CommandingType.tag(FossilsLegacyItemTags.TYRANNOSAURUS_COMMANDABLES);
    }
}
