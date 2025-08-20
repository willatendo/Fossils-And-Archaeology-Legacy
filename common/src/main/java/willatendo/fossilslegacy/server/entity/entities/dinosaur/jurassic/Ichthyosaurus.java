package willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;
import willatendo.fossilslegacy.server.dinopedia_type.FADinopediaTypes;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.entity.entities.Egg;
import willatendo.fossilslegacy.server.entity.goals.DinoEatFromFeederGoal;
import willatendo.fossilslegacy.server.entity.goals.DinoOwnerHurtByTargetGoal;
import willatendo.fossilslegacy.server.entity.goals.DinoOwnerHurtTargetGoal;
import willatendo.fossilslegacy.server.entity.goals.IchthyosaurusJumpGoal;
import willatendo.fossilslegacy.server.entity.util.Diet;
import willatendo.fossilslegacy.server.entity.util.DinosaurUtils;
import willatendo.fossilslegacy.server.entity.util.interfaces.CommandingType;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.tags.FAModelGeneTags;
import willatendo.fossilslegacy.server.tags.FAStructureTags;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Ichthyosaurus extends Dinosaur implements DinopediaInformation {
    private static final EntityDataAccessor<BlockPos> TREASURE_POS = SynchedEntityData.defineId(Ichthyosaurus.class, EntityDataSerializers.BLOCK_POS);
    private static final EntityDataAccessor<Boolean> FED = SynchedEntityData.defineId(Ichthyosaurus.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> MOISTNESS_LEVEL = SynchedEntityData.defineId(Ichthyosaurus.class, EntityDataSerializers.INT);
    public static final Predicate<ItemEntity> ALLOWED_ITEMS = itemEntity -> !itemEntity.hasPickUpDelay() && itemEntity.isAlive() && itemEntity.isInWater();
    static final TargetingConditions SWIM_WITH_PLAYER_TARGETING = TargetingConditions.forNonCombat().range(10.0).ignoreLineOfSight();

    public Ichthyosaurus(EntityType<? extends Ichthyosaurus> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.02F, 0.1F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
        this.setCanPickUpLoot(true);
    }

    public static AttributeSupplier ichthyosaurusAttributes() {
        return Animal.createAnimalAttributes().add(Attributes.MAX_HEALTH, 5.0F).add(Attributes.MOVEMENT_SPEED, 1.2000000476837158).add(Attributes.ATTACK_DAMAGE, 4.0D).build();
    }

    public static boolean checkIchthyosaurusSpawnRules(EntityType<Ichthyosaurus> entityType, ServerLevelAccessor serverLevelAccessor, EntitySpawnReason entitySpawnReason, BlockPos blockPos, RandomSource randomSource) {
        int seaLevel = serverLevelAccessor.getSeaLevel();
        int underSeaLevel = seaLevel - 13;
        return blockPos.getY() >= underSeaLevel && blockPos.getY() <= seaLevel && serverLevelAccessor.getFluidState(blockPos.below()).is(FluidTags.WATER) && serverLevelAccessor.getBlockState(blockPos.above()).is(Blocks.WATER);
    }

    @Override
    public boolean checkSpawnObstruction(LevelReader levelReader) {
        return levelReader.isUnobstructed(this);
    }

    @Override
    public EntityType<Egg> getEggEntityType() {
        return FAEntityTypes.ICHTHYOSAURUS_EGG.get();
    }

    @Override
    public int getMaxHunger() {
        return 100;
    }

    @Override
    public TagKey<ModelGene> getModelTypes() {
        return FAModelGeneTags.ICHTHYOSAURUS;
    }

    @Override
    public int getMaxGrowthStage() {
        return 8;
    }

    @Override
    public Diet getDiet() {
        return Diet.piscivore(this.level());
    }

    @Override
    public float[] healthPerGrowthStage() {
        return DinosaurUtils.getHealths(this.getMaxGrowthStage(), 5.0F, 25.0F);
    }

    @Override
    protected ItemStack getHead() {
        return new ItemStack(FAItems.ICHTHYOSAURUS_HEAD.get());
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new BreathAirGoal(this));
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(1, new Ichthyosaurus.IchthyosaurusSwimToTreasureGoal(this));
        this.goalSelector.addGoal(2, new Ichthyosaurus.IchthyosaurusSwimWithPlayerGoal(this, 4.0));
        this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1.0, 10));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new DinoEatFromFeederGoal(this, 1.0D, 24, (int) this.getEyeHeight(), false));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(5, new IchthyosaurusJumpGoal(this, 10));
        this.goalSelector.addGoal(6, new MeleeAttackGoal(this, 1.2000000476837158, true));
        this.goalSelector.addGoal(8, new Ichthyosaurus.PlayWithItemsGoal());
        this.goalSelector.addGoal(8, new FollowBoatGoal(this));
        this.targetSelector.addGoal(1, new DinoOwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new DinoOwnerHurtTargetGoal(this));
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(TREASURE_POS, BlockPos.ZERO);
        builder.define(FED, false);
        builder.define(MOISTNESS_LEVEL, 2400);
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        return new WaterBoundPathNavigation(this, level);
    }

    @Override
    public void playAttackSound() {
        this.playSound(SoundEvents.DOLPHIN_ATTACK, 1.0F, 1.0F);
    }

    @Override
    public boolean canAttack(LivingEntity livingEntity) {
        return !this.isBaby() && super.canAttack(livingEntity);
    }

    @Override
    public int getMaxAirSupply() {
        return 4800;
    }

    @Override
    protected int increaseAirSupply(int currentAir) {
        return this.getMaxAirSupply();
    }

    @Override
    public int getMaxHeadXRot() {
        return 1;
    }

    @Override
    public int getMaxHeadYRot() {
        return 1;
    }

    @Override
    protected boolean canRide(Entity entity) {
        return true;
    }

    @Override
    protected boolean canDispenserEquipIntoSlot(EquipmentSlot equipmentSlot) {
        return equipmentSlot == EquipmentSlot.MAINHAND && this.canPickUpLoot();
    }

    @Override
    protected void pickUpItem(ServerLevel serverLevel, ItemEntity itemEntity) {
        if (this.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty()) {
            ItemStack itemStack = itemEntity.getItem();
            if (this.canHoldItem(itemStack)) {
                this.onItemPickup(itemEntity);
                this.setItemSlot(EquipmentSlot.MAINHAND, itemStack);
                this.setGuaranteedDrop(EquipmentSlot.MAINHAND);
                this.take(itemEntity, itemStack.getCount());
                itemEntity.discard();
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.isNoAi()) {
            this.setAirSupply(this.getMaxAirSupply());
        } else {
            if (this.isInWaterRainOrBubble()) {
                this.setMoisntessLevel(2400);
            } else {
                this.setMoisntessLevel(this.getMoistnessLevel() - 1);
                if (this.getMoistnessLevel() <= 0) {
                    this.hurt(this.damageSources().dryOut(), 1.0F);
                }

                if (this.onGround()) {
                    this.setDeltaMovement(this.getDeltaMovement().add((double) ((this.random.nextFloat() * 2.0F - 1.0F) * 0.2F), 0.5, (double) ((this.random.nextFloat() * 2.0F - 1.0F) * 0.2F)));
                    this.setYRot(this.random.nextFloat() * 360.0F);
                    this.setOnGround(false);
                    this.hasImpulse = true;
                }
            }

            if (this.level().isClientSide && this.isInWater() && this.getDeltaMovement().lengthSqr() > 0.03) {
                Vec3 vec3 = this.getViewVector(0.0F);
                float f = Mth.cos(this.getYRot() * 0.017453292F) * 0.3F;
                float f1 = Mth.sin(this.getYRot() * 0.017453292F) * 0.3F;
                float f2 = 1.2F - this.random.nextFloat() * 0.7F;

                for (int i = 0; i < 2; ++i) {
                    this.level().addParticle(ParticleTypes.DOLPHIN, this.getX() - vec3.x * (double) f2 + (double) f, this.getY() - vec3.y, this.getZ() - vec3.z * (double) f2 + (double) f1, 0.0, 0.0, 0.0);
                    this.level().addParticle(ParticleTypes.DOLPHIN, this.getX() - vec3.x * (double) f2 - (double) f, this.getY() - vec3.y, this.getZ() - vec3.z * (double) f2 - (double) f1, 0.0, 0.0, 0.0);
                }
            }
        }
    }

    @Override
    public void handleEntityEvent(byte event) {
        if (event == 38) {
            this.addParticlesAroundSelf(ParticleTypes.HAPPY_VILLAGER);
        } else {
            super.handleEntityEvent(event);
        }
    }

    private void addParticlesAroundSelf(ParticleOptions particleOption) {
        for (int i = 0; i < 7; ++i) {
            double xSpeed = this.random.nextGaussian() * 0.01;
            double ySpeed = this.random.nextGaussian() * 0.01;
            double zSpeed = this.random.nextGaussian() * 0.01;
            this.level().addParticle(particleOption, this.getRandomX(1.0), this.getRandomY() + 0.2, this.getRandomZ(1.0), xSpeed, ySpeed, zSpeed);
        }
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (!itemStack.isEmpty() && this.getDiet().getItemStackFoodValue(itemStack) > 0) {
            if (!this.level().isClientSide()) {
                this.playSound(SoundEvents.DOLPHIN_EAT, 1.0F, 1.0F);
            }

            if (this.isBaby()) {
                itemStack.consume(1, player);
                this.ageUp(getSpeedUpSecondsWhenFeeding(-this.age), true);
            } else {
                this.setFed(true);
                itemStack.consume(1, player);
            }

            return InteractionResult.SUCCESS;
        } else {
            return super.mobInteract(player, interactionHand);
        }
    }

    protected boolean closeToNextPos() {
        BlockPos blockpos = this.getNavigation().getTargetPos();
        return blockpos != null ? blockpos.closerToCenterThan(this.position(), 12.0) : false;
    }

    @Override
    public void travel(Vec3 vec3) {
        if (this.isControlledByLocalInstance() && this.isInWater()) {
            this.moveRelative(this.getSpeed(), vec3);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0, -0.005, 0.0));
            }
        } else {
            super.travel(vec3);
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, EntitySpawnReason entitySpawnReason, SpawnGroupData spawnGroupData) {
        this.setAirSupply(this.getMaxAirSupply());
        this.setXRot(0.0F);
        return super.finalizeSpawn(serverLevelAccessor, difficultyInstance, entitySpawnReason, spawnGroupData);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.getOverridenSoundEvent(SoundEvents.DOLPHIN_AMBIENT, ModelGene.OverrideInfo.OverridenSoundType.AMBIENT, this.registryAccess());
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return this.getOverridenSoundEvent(SoundEvents.DOLPHIN_HURT, ModelGene.OverrideInfo.OverridenSoundType.HURT, this.registryAccess());
    }

    @Override
    protected SoundEvent getDeathSound() {
        return this.getOverridenSoundEvent(SoundEvents.DOLPHIN_DEATH, ModelGene.OverrideInfo.OverridenSoundType.DEATH, this.registryAccess());
    }

    public void setTreasurePos(BlockPos blockPos) {
        this.entityData.set(TREASURE_POS, blockPos);
    }

    public BlockPos getTreasurePos() {
        return this.entityData.get(TREASURE_POS);
    }

    public boolean isFed() {
        return this.entityData.get(FED);
    }

    public void setFed(boolean gotFish) {
        this.entityData.set(FED, gotFish);
    }

    public int getMoistnessLevel() {
        return this.entityData.get(MOISTNESS_LEVEL);
    }

    public void setMoisntessLevel(int moistnessLevel) {
        this.entityData.set(MOISTNESS_LEVEL, moistnessLevel);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("TreasurePosX", this.getTreasurePos().getX());
        compoundTag.putInt("TreasurePosY", this.getTreasurePos().getY());
        compoundTag.putInt("TreasurePosZ", this.getTreasurePos().getZ());
        compoundTag.putBoolean("IsFed", this.isFed());
        compoundTag.putInt("Moistness", this.getMoistnessLevel());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        int x = compoundTag.getInt("TreasurePosX");
        int y = compoundTag.getInt("TreasurePosY");
        int z = compoundTag.getInt("TreasurePosZ");
        this.setTreasurePos(new BlockPos(x, y, z));
        this.setFed(compoundTag.getBoolean("IsFed"));
        this.setMoisntessLevel(compoundTag.getInt("Moistness"));
    }

    @Override
    public Optional<ResourceKey<DinopediaType>> getDinopediaType() {
        return Optional.of(FADinopediaTypes.ICHTHYOSAURUS);
    }

    @Override
    public CommandingType commandItems() {
        return CommandingType.none();
    }

    static class IchthyosaurusSwimToTreasureGoal extends Goal {
        private final Ichthyosaurus ichthyosaurus;
        private boolean stuck;

        IchthyosaurusSwimToTreasureGoal(Ichthyosaurus ichthyosaurus) {
            this.ichthyosaurus = ichthyosaurus;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        @Override
        public boolean isInterruptable() {
            return false;
        }

        @Override
        public boolean canUse() {
            return this.ichthyosaurus.isFed() && this.ichthyosaurus.getAirSupply() >= 100;
        }

        @Override
        public boolean canContinueToUse() {
            BlockPos blockpos = this.ichthyosaurus.getTreasurePos();
            return !BlockPos.containing(blockpos.getX(), this.ichthyosaurus.getY(), blockpos.getZ()).closerToCenterThan(this.ichthyosaurus.position(), 4.0) && !this.stuck && this.ichthyosaurus.getAirSupply() >= 100;
        }

        @Override
        public void start() {
            if (this.ichthyosaurus.level() instanceof ServerLevel serverLevel) {
                this.stuck = false;
                this.ichthyosaurus.getNavigation().stop();
                BlockPos ichthyosaurusBlockPos = this.ichthyosaurus.blockPosition();
                BlockPos nearestMapStructure = serverLevel.findNearestMapStructure(FAStructureTags.ICHTHYOSAURUS_LOCATED, ichthyosaurusBlockPos, 50, false);
                if (nearestMapStructure != null) {
                    this.ichthyosaurus.setTreasurePos(nearestMapStructure);
                    serverLevel.broadcastEntityEvent(this.ichthyosaurus, (byte) 38);
                } else {
                    this.stuck = true;
                }
            }

        }

        @Override
        public void stop() {
            BlockPos treasurePos = this.ichthyosaurus.getTreasurePos();
            if (BlockPos.containing(treasurePos.getX(), this.ichthyosaurus.getY(), treasurePos.getZ()).closerToCenterThan(this.ichthyosaurus.position(), 4.0) || this.stuck) {
                this.ichthyosaurus.setFed(false);
            }
        }

        @Override
        public void tick() {
            Level level = this.ichthyosaurus.level();
            if (this.ichthyosaurus.closeToNextPos() || this.ichthyosaurus.getNavigation().isDone()) {
                Vec3 treasurePosCenter = Vec3.atCenterOf(this.ichthyosaurus.getTreasurePos());
                Vec3 posTowards = DefaultRandomPos.getPosTowards(this.ichthyosaurus, 16, 1, treasurePosCenter, 0.39269909262657166);
                if (posTowards == null) {
                    posTowards = DefaultRandomPos.getPosTowards(this.ichthyosaurus, 8, 4, treasurePosCenter, 1.5707963705062866);
                }

                if (posTowards != null) {
                    BlockPos blockpos = BlockPos.containing(posTowards);
                    if (!level.getFluidState(blockpos).is(FluidTags.WATER) || !level.getBlockState(blockpos).isPathfindable(PathComputationType.WATER)) {
                        posTowards = DefaultRandomPos.getPosTowards(this.ichthyosaurus, 8, 5, treasurePosCenter, 1.5707963705062866);
                    }
                }

                if (posTowards == null) {
                    this.stuck = true;
                    return;
                }

                this.ichthyosaurus.getLookControl().setLookAt(posTowards.x, posTowards.y, posTowards.z, (float) (this.ichthyosaurus.getMaxHeadYRot() + 20), (float) this.ichthyosaurus.getMaxHeadXRot());
                this.ichthyosaurus.getNavigation().moveTo(posTowards.x, posTowards.y, posTowards.z, 1.3);
                if (level.random.nextInt(this.adjustedTickDelay(80)) == 0) {
                    level.broadcastEntityEvent(this.ichthyosaurus, (byte) 38);
                }
            }
        }
    }

    static class IchthyosaurusSwimWithPlayerGoal extends Goal {
        private final Ichthyosaurus ichthyosaurus;
        private final double speedModifier;
        private Player player;

        IchthyosaurusSwimWithPlayerGoal(Ichthyosaurus ichthyosaurus, double speedModifier) {
            this.ichthyosaurus = ichthyosaurus;
            this.speedModifier = speedModifier;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            this.player = getServerLevel(this.ichthyosaurus).getNearestPlayer(Ichthyosaurus.SWIM_WITH_PLAYER_TARGETING, this.ichthyosaurus);
            return this.player != null && this.player.isSwimming() && this.ichthyosaurus.getTarget() != this.player;
        }

        @Override
        public boolean canContinueToUse() {
            return this.player != null && this.player.isSwimming() && this.ichthyosaurus.distanceToSqr(this.player) < 256.0;
        }

        @Override
        public void start() {
            this.player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 100), this.ichthyosaurus);
        }

        @Override
        public void stop() {
            this.player = null;
            this.ichthyosaurus.getNavigation().stop();
        }

        @Override
        public void tick() {
            this.ichthyosaurus.getLookControl().setLookAt(this.player, (float) (this.ichthyosaurus.getMaxHeadYRot() + 20), (float) this.ichthyosaurus.getMaxHeadXRot());
            if (this.ichthyosaurus.distanceToSqr(this.player) < 6.25) {
                this.ichthyosaurus.getNavigation().stop();
            } else {
                this.ichthyosaurus.getNavigation().moveTo(this.player, this.speedModifier);
            }

            if (this.player.isSwimming() && this.player.level().random.nextInt(6) == 0) {
                this.player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 100), this.ichthyosaurus);
            }
        }
    }

    class PlayWithItemsGoal extends Goal {
        private int cooldown;

        PlayWithItemsGoal() {
        }

        @Override
        public boolean canUse() {
            if (this.cooldown > Ichthyosaurus.this.tickCount) {
                return false;
            } else {
                List<ItemEntity> itemEntities = Ichthyosaurus.this.level().getEntitiesOfClass(ItemEntity.class, Ichthyosaurus.this.getBoundingBox().inflate(8.0, 8.0, 8.0), Ichthyosaurus.ALLOWED_ITEMS);
                return !itemEntities.isEmpty() || !Ichthyosaurus.this.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty();
            }
        }

        @Override
        public void start() {
            List<ItemEntity> itemEntities = Ichthyosaurus.this.level().getEntitiesOfClass(ItemEntity.class, Ichthyosaurus.this.getBoundingBox().inflate(8.0, 8.0, 8.0), Ichthyosaurus.ALLOWED_ITEMS);
            if (!itemEntities.isEmpty()) {
                Ichthyosaurus.this.getNavigation().moveTo(itemEntities.get(0), 1.2000000476837158);
                Ichthyosaurus.this.playSound(SoundEvents.DOLPHIN_PLAY, 1.0F, 1.0F);
            }

            this.cooldown = 0;
        }

        @Override
        public void stop() {
            ItemStack itemstack = Ichthyosaurus.this.getItemBySlot(EquipmentSlot.MAINHAND);
            if (!itemstack.isEmpty()) {
                this.drop(itemstack);
                Ichthyosaurus.this.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                this.cooldown = Ichthyosaurus.this.tickCount + Ichthyosaurus.this.random.nextInt(100);
            }
        }

        @Override
        public void tick() {
            List<ItemEntity> list = Ichthyosaurus.this.level().getEntitiesOfClass(ItemEntity.class, Ichthyosaurus.this.getBoundingBox().inflate(8.0, 8.0, 8.0), Ichthyosaurus.ALLOWED_ITEMS);
            ItemStack itemstack = Ichthyosaurus.this.getItemBySlot(EquipmentSlot.MAINHAND);
            if (!itemstack.isEmpty()) {
                this.drop(itemstack);
                Ichthyosaurus.this.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
            } else if (!list.isEmpty()) {
                Ichthyosaurus.this.getNavigation().moveTo(list.getFirst(), 1.2000000476837158);
            }
        }

        private void drop(ItemStack itemStack) {
            if (!itemStack.isEmpty()) {
                double eyeY = Ichthyosaurus.this.getEyeY() - 0.30000001192092896;
                ItemEntity itemEntity = new ItemEntity(Ichthyosaurus.this.level(), Ichthyosaurus.this.getX(), eyeY, Ichthyosaurus.this.getZ(), itemStack);
                itemEntity.setPickUpDelay(40);
                itemEntity.setThrower(Ichthyosaurus.this);
                float r1 = Ichthyosaurus.this.random.nextFloat() * 6.2831855F;
                float r2 = 0.02F * Ichthyosaurus.this.random.nextFloat();
                itemEntity.setDeltaMovement(0.3F * -Mth.sin(Ichthyosaurus.this.getYRot() * 0.017453292F) * Mth.cos(Ichthyosaurus.this.getXRot() * 0.017453292F) + Mth.cos(r1) * r2, 0.3F * Mth.sin(Ichthyosaurus.this.getXRot() * 0.017453292F) * 1.5F, 0.3F * Mth.cos(Ichthyosaurus.this.getYRot() * 0.017453292F) * Mth.cos(Ichthyosaurus.this.getXRot() * 0.017453292F) + Mth.sin(r1) * r2);
                Ichthyosaurus.this.level().addFreshEntity(itemEntity);
            }
        }
    }
}
