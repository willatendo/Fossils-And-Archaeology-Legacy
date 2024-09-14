package willatendo.fossilslegacy.server.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.server.entity.genetics.CoatType;
import willatendo.fossilslegacy.server.entity.genetics.FossilsLegacyCoatTypeTags;
import willatendo.fossilslegacy.server.entity.goal.*;
import willatendo.fossilslegacy.server.entity.util.*;
import willatendo.fossilslegacy.server.entity.variants.EggVariant;
import willatendo.fossilslegacy.server.item.FossilsLegacyItemTags;
import willatendo.fossilslegacy.server.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.List;

public class Triceratops extends Dinosaur implements DinopediaInformation, RideableDinosaur, SubSpecies {
    private static final EntityDataAccessor<Integer> SUB_SPECIES = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.INT);

    public Triceratops(EntityType<? extends Triceratops> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier triceratopsAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0F).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 4.0D).build();
    }

    @Override
    public float maxUpStep() {
        return DinoUtils.getStepHeights(12, 1.0F, 1.5F)[this.getGrowthStage()];
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
    public TagKey<CoatType> getCoatTypes() {
        return FossilsLegacyCoatTypeTags.TRICERATOPS;
    }

    @Override
    public Holder<EggVariant> getEggVariant() {
        return FossilsLegacyEggVariants.TRICERATOPS;
    }

    @Override
    public int getMaxGrowthStage() {
        return 12;
    }

    @Override
    public float getBoundingBoxGrowth() {
        return 0.35F;
    }

    @Override
    public double getMinHealth() {
        return 10.0F;
    }

    @Override
    public Diet getDiet() {
        return Diet.herbivore();
    }

    @Override
    public float renderScaleWidth() {
        return 1.5F + (0.3F * (float) this.getGrowthStage());
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
        this.goalSelector.addGoal(6, new DinoEatFromFeederGoal(this, 1.0D, 24, false));
        this.goalSelector.addGoal(6, new DinoEatFernsGoal(this));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new DinoOwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new DinoOwnerHurtTargetGoal(this));
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(SUB_SPECIES, 0);
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
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return FossilsLegacySoundEvents.TRICERATOPS_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return FossilsLegacySoundEvents.TRICERATOPS_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return FossilsLegacySoundEvents.TRICERATOPS_DEATH.get();
    }

    @Override
    public int getSubSpecies() {
        return this.entityData.get(SUB_SPECIES);
    }

    @Override
    public void setSubSpecies(int subSpecies) {
        if (subSpecies > 2) {
            subSpecies = 2;
        }
        this.entityData.set(SUB_SPECIES, subSpecies);
    }

    @Override
    public ResourceLocation[][] textures() {
        return new ResourceLocation[][]{{FossilsLegacyUtils.resource("textures/entity/triceratops/green_triceratops.png"), FossilsLegacyUtils.resource("textures/entity/triceratops/green_baby_triceratops.png")}, {FossilsLegacyUtils.resource("textures/entity/triceratops/brown_triceratops.png"), FossilsLegacyUtils.resource("textures/entity/triceratops/brown_baby_triceratops.png")}, {FossilsLegacyUtils.resource("textures/entity/triceratops/alternate_triceratops.png"), FossilsLegacyUtils.resource("textures/entity/triceratops/alternate_baby_triceratops.png")}};
    }

    @Override
    public ResourceLocation[][] legacyTextures() {
        return new ResourceLocation[][]{{FossilsLegacyUtils.resource("textures/entity/triceratops/legacy/green_triceratops.png"), FossilsLegacyUtils.resource("textures/entity/triceratops/legacy/green_baby_triceratops.png")}, {FossilsLegacyUtils.resource("textures/entity/triceratops/legacy/brown_triceratops.png"), FossilsLegacyUtils.resource("textures/entity/triceratops/legacy/brown_baby_triceratops.png")}, {FossilsLegacyUtils.resource("textures/entity/triceratops/legacy/alternate_triceratops.png"), FossilsLegacyUtils.resource("textures/entity/triceratops/legacy/alternate_baby_triceratops.png")}};
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("SubSpecies", this.getSubSpecies());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.setSubSpecies(compoundTag.getInt("SubSpecies"));
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, SpawnGroupData spawnGroupData) {
        this.setSubSpecies(this.random.nextInt(this.textures().length));
        return super.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData);
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
        return CommandType.tag(FossilsLegacyItemTags.TRICERATOPS_COMMANDABLES);
    }
}
