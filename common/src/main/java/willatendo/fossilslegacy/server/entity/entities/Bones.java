package willatendo.fossilslegacy.server.entity.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.EnumSet;

public class Bones extends Monster implements RangedAttackMob {
    boolean searchingForLand;
    protected final WaterBoundPathNavigation waterNavigation;
    protected final GroundPathNavigation groundNavigation;

    private final RangedBowAttackGoal<Bones> bowGoal = new RangedBowAttackGoal<>(this, 1.0, 20, 15.0F);
    private final MeleeAttackGoal meleeGoal = new MeleeAttackGoal(this, 1.2, false) {
        @Override
        public void stop() {
            super.stop();
            Bones.this.setAggressive(false);
        }

        @Override
        public void start() {
            super.start();
            Bones.this.setAggressive(true);
        }
    };

    public Bones(EntityType<? extends Bones> entityType, Level level) {
        super(entityType, level);
        this.reassessWeaponGoal();
        this.moveControl = new Bones.DrownedPirateMoveControl(this);
        this.setPathfindingMalus(PathType.WATER, 0.0F);
        this.waterNavigation = new WaterBoundPathNavigation(this, level);
        this.groundNavigation = new GroundPathNavigation(this, level);
    }

    public static AttributeSupplier createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.25).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new Bones.DrownedPirateGoToWaterGoal(this, 1.0));
        this.goalSelector.addGoal(2, new RestrictSunGoal(this));
        this.goalSelector.addGoal(2, new Bones.DrownedPirateAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(3, new FleeSunGoal(this, 1.0));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Wolf.class, 6.0F, 1.0, 1.2));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new Bones.DrownedPirateSwimUpGoal(this, 1.0, this.level().getSeaLevel()));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
    }

    public boolean okTarget(LivingEntity target) {
        return target != null ? !this.level().isDay() || target.isInWater() : false;
    }

    public boolean isPushedByFluid() {
        return !this.isSwimming();
    }

    boolean wantsToSwim() {
        if (this.searchingForLand) {
            return true;
        } else {
            LivingEntity livingentity = this.getTarget();
            return livingentity != null && livingentity.isInWater();
        }
    }

    @Override
    public void travel(Vec3 travelVector) {
        if (this.isControlledByLocalInstance() && this.isUnderWater() && this.wantsToSwim()) {
            this.moveRelative(0.01F, travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9));
        } else {
            super.travel(travelVector);
        }
    }

    @Override
    public void updateSwimming() {
        if (!this.level().isClientSide) {
            if (this.isEffectiveAi() && this.isUnderWater() && this.wantsToSwim()) {
                this.navigation = this.waterNavigation;
                this.setSwimming(true);
            } else {
                this.navigation = this.groundNavigation;
                this.setSwimming(false);
            }
        }
    }

    @Override
    public boolean isVisuallySwimming() {
        return this.isSwimming();
    }

    protected boolean closeToNextPos() {
        Path path = this.getNavigation().getPath();
        if (path != null) {
            BlockPos blockPos = path.getTarget();
            if (blockPos != null) {
                double d0 = this.distanceToSqr(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                if (d0 < 4.0) {
                    return true;
                }
            }
        }

        return false;
    }

    public void setSearchingForLand(boolean searchingForLand) {
        this.searchingForLand = searchingForLand;
    }

    @Override
    protected void playStepSound(BlockPos blockPos, BlockState blockState) {
        this.playSound(SoundEvents.SKELETON_STEP, 0.15F, 1.0F);
    }

    @Override
    public void aiStep() {
        boolean flag = this.isSunBurnTick();
        if (flag) {
            ItemStack headItemStack = this.getItemBySlot(EquipmentSlot.HEAD);
            if (!headItemStack.isEmpty()) {
                if (headItemStack.isDamageableItem()) {
                    Item item = headItemStack.getItem();
                    headItemStack.setDamageValue(headItemStack.getDamageValue() + this.random.nextInt(2));
                    if (headItemStack.getDamageValue() >= headItemStack.getMaxDamage()) {
                        this.onEquippedItemBroken(item, EquipmentSlot.HEAD);
                        this.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
                    }
                }

                flag = false;
            }

            if (flag) {
                this.igniteForSeconds(8.0F);
            }
        }

        super.aiStep();
    }

    @Override
    public void rideTick() {
        super.rideTick();
        Entity entity = this.getControlledVehicle();
        if (entity instanceof PathfinderMob pathfinderMob) {
            this.yBodyRot = pathfinderMob.yBodyRot;
        }
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource randomSource, DifficultyInstance difficultyInstance) {
        super.populateDefaultEquipmentSlots(randomSource, difficultyInstance);
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, EntitySpawnReason entitySpawnReason, SpawnGroupData spawnGroupData) {
        spawnGroupData = super.finalizeSpawn(serverLevelAccessor, difficultyInstance, entitySpawnReason, spawnGroupData);
        RandomSource randomSource = serverLevelAccessor.getRandom();
        this.populateDefaultEquipmentSlots(randomSource, difficultyInstance);
        this.populateDefaultEquipmentEnchantments(serverLevelAccessor, randomSource, difficultyInstance);
        this.reassessWeaponGoal();
        this.setCanPickUpLoot(randomSource.nextFloat() < 0.55F * difficultyInstance.getSpecialMultiplier());
        if (this.getItemBySlot(EquipmentSlot.HEAD).isEmpty()) {
            LocalDate localDate = LocalDate.now();
            int day = localDate.get(ChronoField.DAY_OF_MONTH);
            int month = localDate.get(ChronoField.MONTH_OF_YEAR);
            if (month == 10 && day == 31 && randomSource.nextFloat() < 0.25F) {
                this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(randomSource.nextFloat() < 0.1F ? Blocks.JACK_O_LANTERN : Blocks.CARVED_PUMPKIN));
                this.armorDropChances[EquipmentSlot.HEAD.getIndex()] = 0.0F;
            }
        }

        return spawnGroupData;
    }

    public void reassessWeaponGoal() {
        if (this.level() != null && !this.level().isClientSide) {
            this.goalSelector.removeGoal(this.meleeGoal);
            this.goalSelector.removeGoal(this.bowGoal);
            ItemStack itemStack = this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, Items.BOW));
            if (itemStack.getItem() instanceof BowItem) {
                int hardAttack = this.getHardAttackInterval();
                if (this.level().getDifficulty() != Difficulty.HARD) {
                    hardAttack = this.getAttackInterval();
                }

                this.bowGoal.setMinAttackInterval(hardAttack);
                this.goalSelector.addGoal(4, this.bowGoal);
            } else {
                this.goalSelector.addGoal(4, this.meleeGoal);
            }
        }
    }

    protected int getHardAttackInterval() {
        return 20;
    }

    protected int getAttackInterval() {
        return 40;
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        ItemStack weaponItemStack = this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, Items.BOW));
        ItemStack projectileItemStack = this.getProjectile(weaponItemStack);
        AbstractArrow abstractArrow = this.getArrow(projectileItemStack, distanceFactor, weaponItemStack);
        double x = target.getX() - this.getX();
        double y = target.getY(0.3333333333333333) - abstractArrow.getY();
        double z = target.getZ() - this.getZ();
        double d3 = Math.sqrt(x * x + z * z);
        Level level = this.level();
        if (level instanceof ServerLevel serverLevel) {
            Projectile.spawnProjectileUsingShoot(abstractArrow, serverLevel, projectileItemStack, x, y + d3 * 0.20000000298023224, z, 1.6F, (float) (14 - serverLevel.getDifficulty().getId() * 4));
        }

        this.playSound(SoundEvents.SKELETON_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
    }

    protected AbstractArrow getArrow(ItemStack arrowItemStack, float velocity, ItemStack weaponItemStack) {
        return ProjectileUtil.getMobArrow(this, arrowItemStack, velocity, weaponItemStack);
    }

    public TagKey<Item> getPreferredWeaponType() {
        return ItemTags.SKELETON_PREFERRED_WEAPONS;
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.reassessWeaponGoal();
    }

    @Override
    public void setItemSlot(EquipmentSlot equipmentSlot, ItemStack itemStack) {
        super.setItemSlot(equipmentSlot, itemStack);
        if (!this.level().isClientSide) {
            this.reassessWeaponGoal();
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SKELETON_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.SKELETON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SKELETON_DEATH;
    }


    static class DrownedPirateMoveControl extends MoveControl {
        private final Bones bones;

        public DrownedPirateMoveControl(Bones bones) {
            super(bones);
            this.bones = bones;
        }

        @Override
        public void tick() {
            LivingEntity target = this.bones.getTarget();
            if (this.bones.wantsToSwim() && this.bones.isInWater()) {
                if (target != null && target.getY() > this.bones.getY() || this.bones.searchingForLand) {
                    this.bones.setDeltaMovement(this.bones.getDeltaMovement().add(0.0, 0.002, 0.0));
                }

                if (this.operation != Operation.MOVE_TO || this.bones.getNavigation().isDone()) {
                    this.bones.setSpeed(0.0F);
                    return;
                }

                double x = this.wantedX - this.bones.getX();
                double y = this.wantedY - this.bones.getY();
                double z = this.wantedZ - this.bones.getZ();
                double distance = Math.sqrt(x * x + y * y + z * z);
                y /= distance;
                float f = (float) (Mth.atan2(z, x) * 180.0 / 3.1415927410125732) - 90.0F;
                this.bones.setYRot(this.rotlerp(this.bones.getYRot(), f, 90.0F));
                this.bones.yBodyRot = this.bones.getYRot();
                float movementSpeed = (float) (this.speedModifier * this.bones.getAttributeValue(Attributes.MOVEMENT_SPEED));
                float speed = Mth.lerp(0.125F, this.bones.getSpeed(), movementSpeed);
                this.bones.setSpeed(speed);
                this.bones.setDeltaMovement(this.bones.getDeltaMovement().add((double) speed * x * 0.005, (double) speed * y * 0.1, (double) speed * z * 0.005));
            } else {
                if (!this.bones.onGround()) {
                    this.bones.setDeltaMovement(this.bones.getDeltaMovement().add(0.0, -0.008, 0.0));
                }

                super.tick();
            }
        }
    }

    static class DrownedPirateGoToWaterGoal extends Goal {
        private final PathfinderMob mob;
        private double wantedX;
        private double wantedY;
        private double wantedZ;
        private final double speedModifier;
        private final Level level;

        public DrownedPirateGoToWaterGoal(PathfinderMob mob, double speedModifier) {
            this.mob = mob;
            this.speedModifier = speedModifier;
            this.level = mob.level();
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            if (!this.level.isDay()) {
                return false;
            } else if (this.mob.isInWater()) {
                return false;
            } else {
                Vec3 waterPos = this.getWaterPos();
                if (waterPos == null) {
                    return false;
                } else {
                    this.wantedX = waterPos.x;
                    this.wantedY = waterPos.y;
                    this.wantedZ = waterPos.z;
                    return true;
                }
            }
        }

        @Override
        public boolean canContinueToUse() {
            return !this.mob.getNavigation().isDone();
        }

        @Override
        public void start() {
            this.mob.getNavigation().moveTo(this.wantedX, this.wantedY, this.wantedZ, this.speedModifier);
        }

        private Vec3 getWaterPos() {
            RandomSource randomSource = this.mob.getRandom();
            BlockPos blockPos = this.mob.blockPosition();

            for (int i = 0; i < 10; ++i) {
                BlockPos destination = blockPos.offset(randomSource.nextInt(20) - 10, 2 - randomSource.nextInt(8), randomSource.nextInt(20) - 10);
                if (this.level.getBlockState(destination).is(Blocks.WATER)) {
                    return Vec3.atBottomCenterOf(destination);
                }
            }

            return null;
        }
    }

    static class DrownedPirateAttackGoal extends MeleeAttackGoal {
        private final Bones bones;

        public DrownedPirateAttackGoal(Bones bones, double speedModifier, boolean followingTargetEvenIfNotSeen) {
            super(bones, speedModifier, followingTargetEvenIfNotSeen);
            this.bones = bones;
        }

        @Override
        public boolean canUse() {
            return super.canUse() && this.bones.okTarget(this.bones.getTarget());
        }

        @Override
        public boolean canContinueToUse() {
            return super.canContinueToUse() && this.bones.okTarget(this.bones.getTarget());
        }
    }

    static class DrownedPirateSwimUpGoal extends Goal {
        private final Bones bones;
        private final double speedModifier;
        private final int seaLevel;
        private boolean stuck;

        public DrownedPirateSwimUpGoal(Bones bones, double speedModifier, int seaLevel) {
            this.bones = bones;
            this.speedModifier = speedModifier;
            this.seaLevel = seaLevel;
        }

        @Override
        public boolean canUse() {
            return !this.bones.level().isDay() && this.bones.isInWater() && this.bones.getY() < (double) (this.seaLevel - 2);
        }

        @Override
        public boolean canContinueToUse() {
            return this.canUse() && !this.stuck;
        }

        @Override
        public void tick() {
            if (this.bones.getY() < (double) (this.seaLevel - 1) && (this.bones.getNavigation().isDone() || this.bones.closeToNextPos())) {
                Vec3 vec3 = DefaultRandomPos.getPosTowards(this.bones, 4, 8, new Vec3(this.bones.getX(), (double) (this.seaLevel - 1), this.bones.getZ()), 1.5707963705062866);
                if (vec3 == null) {
                    this.stuck = true;
                    return;
                }

                this.bones.getNavigation().moveTo(vec3.x, vec3.y, vec3.z, this.speedModifier);
            }
        }

        @Override
        public void start() {
            this.bones.setSearchingForLand(true);
            this.stuck = false;
        }

        @Override
        public void stop() {
            this.bones.setSearchingForLand(false);
        }
    }
}
