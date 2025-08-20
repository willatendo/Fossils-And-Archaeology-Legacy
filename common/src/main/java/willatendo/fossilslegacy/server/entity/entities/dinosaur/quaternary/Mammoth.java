package willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.ARGB;
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
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;
import willatendo.fossilslegacy.server.dinopedia_type.FADinopediaTypes;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.entity.goals.DinoEatFromFeederGoal;
import willatendo.fossilslegacy.server.entity.goals.DinoOwnerHurtByTargetGoal;
import willatendo.fossilslegacy.server.entity.goals.DinoOwnerHurtTargetGoal;
import willatendo.fossilslegacy.server.entity.goals.DinoTemptGoal;
import willatendo.fossilslegacy.server.entity.util.Diet;
import willatendo.fossilslegacy.server.entity.util.DinosaurUtils;
import willatendo.fossilslegacy.server.entity.util.interfaces.ChromosomedEntity;
import willatendo.fossilslegacy.server.entity.util.interfaces.CommandingType;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.util.interfaces.RideableDinosaur;
import willatendo.fossilslegacy.server.gene.ChromosomeUtils;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.item.FALootTables;
import willatendo.fossilslegacy.server.sound.FASoundEvents;
import willatendo.fossilslegacy.server.tags.FAModelGeneTags;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Mammoth extends Dinosaur implements DinopediaInformation, RideableDinosaur, Shearable {
    private static final EntityDataAccessor<Integer> WOOL_COLOR = SynchedEntityData.defineId(Mammoth.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> IS_SHEARED = SynchedEntityData.defineId(Mammoth.class, EntityDataSerializers.BOOLEAN);
    private static final Map<DyeColor, Integer> COLOR_BY_DYE = new HashMap<>(Arrays.stream(DyeColor.values()).collect(Collectors.toMap((dyeColor) -> dyeColor, Mammoth::createSheepColor)));
    private int eatAnimationTick;
    private int swingTick;
    private EatBlockGoal eatBlockGoal;

    private static int createSheepColor(DyeColor dyeColor) {
        if (dyeColor == DyeColor.WHITE) {
            return -1644826;
        } else {
            int i = dyeColor.getTextureDiffuseColor();
            float f = 0.75F;
            return ARGB.color(255, Mth.floor((float) ARGB.red(i) * 0.75F), Mth.floor((float) ARGB.green(i) * 0.75F), Mth.floor((float) ARGB.blue(i) * 0.75F));
        }
    }

    public static int getColor(DyeColor dyeColor) {
        return COLOR_BY_DYE.get(dyeColor);
    }

    public Mammoth(EntityType<? extends Mammoth> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier mammothAttributes() {
        return Animal.createAnimalAttributes().add(Attributes.MAX_HEALTH, 5.0F).add(Attributes.MOVEMENT_SPEED, 0.23D).add(Attributes.ATTACK_DAMAGE, 3.0D).build();
    }

    @Override
    public float maxUpStep() {
        return DinosaurUtils.getStepHeights(this.getMaxGrowthStage(), 0.5F, 1.5F)[this.getGrowthStage()];
    }

    @Override
    public int getMinRideableAge() {
        return 4;
    }

    @Override
    public int getMaxHunger() {
        return 100;
    }

    @Override
    public TagKey<ModelGene> getModelTypes() {
        return FAModelGeneTags.MAMMOTH;
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        Mammoth mammoth = FAEntityTypes.MAMMOTH.get().create(serverLevel, EntitySpawnReason.BREEDING);
        if (ageableMob instanceof ChromosomedEntity chromosomedEntity) {
            ChromosomeUtils.createChildChromosomes(mammoth, this, chromosomedEntity, this.getRandom());
        }
        mammoth.setColor(DyeColor.getMixedColor(serverLevel, this.getColor(), ((Mammoth) ageableMob).getColor()));
        return mammoth;
    }

    @Override
    public CommandingType commandItems() {
        return CommandingType.hand();
    }

    @Override
    public int getMaxGrowthStage() {
        return 8;
    }

    @Override
    public Diet getDiet() {
        return Diet.herbivore(this.level());
    }

    @Override
    public float[] healthPerGrowthStage() {
        return DinosaurUtils.getHealths(this.getMaxGrowthStage(), 5.0F, 30.0F);
    }

    @Override
    protected ItemStack getHead() {
        return new ItemStack(FAItems.MAMMOTH_HEAD.get());
    }

    public int getSwingTick() {
        return this.swingTick;
    }

    @Override
    protected void customServerAiStep(ServerLevel serverLevel) {
        this.eatAnimationTick = this.eatBlockGoal.getEatAnimationTick();
        super.customServerAiStep(serverLevel);
    }

    @Override
    public void aiStep() {
        if (this.level().isClientSide()) {
            this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
        }
        super.aiStep();
    }

    @Override
    public void tick() {
        super.tick();

        if (this.swingTick > 0) {
            --this.swingTick;
        }

        if (!this.hasEffect(MobEffects.WEAKNESS) && this.isInWeaknessBiome()) {
            this.addEffect(new MobEffectInstance(MobEffects.WEAKNESS));
        }
    }

    public boolean isInWeaknessBiome() {
        Holder<Biome> biome = this.level().getBiome(this.blockPosition());
        return this.isSheared() ? biome.value().getBaseTemperature() < 0.5F : biome.value().getBaseTemperature() > 1.0F;
    }

    @Override
    protected void registerGoals() {
        this.eatBlockGoal = new EatBlockGoal(this);
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new DinoTemptGoal(this, 1.1D, false));
        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(4, this.eatBlockGoal);
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new DinoEatFromFeederGoal(this, 1.0D, 24, false));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new DinoOwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new DinoOwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(WOOL_COLOR, 0);
        builder.define(IS_SHEARED, false);
    }

    @Override
    public InteractionResult interactAt(Player player, Vec3 vec3, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (itemStack.is(Items.SHEARS)) {
            if (this.level() instanceof ServerLevel serverLevel) {
                if (this.readyForShearing()) {
                    this.shear(serverLevel, SoundSource.PLAYERS, itemStack);
                    this.gameEvent(GameEvent.SHEAR, player);
                    itemStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
                    return InteractionResult.SUCCESS_SERVER;
                }
            }
            return InteractionResult.CONSUME;
        }
        if (itemStack.getItem() instanceof DyeItem dyeItem) {
            if (this.isAlive() && this.getColor() != dyeItem.getDyeColor()) {
                this.level().playSound(player, this, SoundEvents.DYE_USE, SoundSource.PLAYERS, 1.0F, 1.0F);
                if (!player.level().isClientSide()) {
                    this.setColor(dyeItem.getDyeColor());
                    if (!player.isCreative()) {
                        itemStack.shrink(1);
                    }
                }

                return InteractionResult.SUCCESS;
            }
        }
        if (itemStack.isEmpty() && !this.commandItems().canCommandWithItem(itemStack)) {
            if (!this.hasPassenger(this) && this.getGrowthStage() >= this.getMinRideableAge() && this.isTame()) {
                if (!this.level().isClientSide()) {
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
        return this.getOverridenSoundEvent(FASoundEvents.MAMMOTH_AMBIENT.get(), ModelGene.OverrideInfo.OverridenSoundType.AMBIENT, this.registryAccess());
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return this.getOverridenSoundEvent(FASoundEvents.MAMMOTH_HURT.get(), ModelGene.OverrideInfo.OverridenSoundType.HURT, this.registryAccess());
    }

    @Override
    protected SoundEvent getDeathSound() {
        return this.getOverridenSoundEvent(FASoundEvents.MAMMOTH_DEATH.get(), ModelGene.OverrideInfo.OverridenSoundType.DEATH, this.registryAccess());
    }

    public void setColor(DyeColor dyeColor) {
        this.entityData.set(WOOL_COLOR, dyeColor.getId());
    }

    public DyeColor getColor() {
        return DyeColor.byId(this.entityData.get(WOOL_COLOR));
    }

    public void setSheared(boolean sheared) {
        this.entityData.set(IS_SHEARED, sheared);
    }

    public boolean isSheared() {
        return this.entityData.get(IS_SHEARED);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("Sheared", this.isSheared());
        compoundTag.putInt("Color", this.getColor().getId());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.setSheared(compoundTag.getBoolean("Sheared"));
        this.setColor(DyeColor.byId(compoundTag.getInt("Color")));
    }

    private float getAttackDamage() {
        return (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    @Override
    public boolean doHurtTarget(ServerLevel serverLevel, Entity entity) {
        this.level().broadcastEntityEvent(this, (byte) 4);
        float attackDamage = this.getAttackDamage();
        float variableDamage = (int) attackDamage > 0 ? attackDamage / 2.0F + (float) this.random.nextInt((int) attackDamage) : attackDamage;
        DamageSource damageSource = this.damageSources().mobAttack(this);
        boolean canHurt = entity.hurtServer(serverLevel, this.damageSources().mobAttack(this), variableDamage);
        if (canHurt) {
            double knockbackResistance;
            if (entity instanceof LivingEntity livingEntity) {
                knockbackResistance = livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
            } else {
                knockbackResistance = 0.0D;
            }

            double variableKnockbackResistance = Math.max(0.0D, 1.0D - knockbackResistance);
            entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, (double) 0.4F * variableKnockbackResistance, 0.0D));
            EnchantmentHelper.doPostAttackEffects(serverLevel, entity, damageSource);
        }

        this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        return canHurt;
    }

    @Override
    public void ate() {
        super.ate();
        this.setSheared(false);
        this.setHunger(this.getMaxHunger());
    }

    @Override
    public boolean readyForShearing() {
        return this.isAlive() && !this.isSheared() && !this.isBaby();
    }

    @Override
    public void shear(ServerLevel serverLevel, SoundSource soundSource, ItemStack itemStack) {
        serverLevel.playSound(null, this, SoundEvents.SHEEP_SHEAR, soundSource, 1.0F, 1.0F);
        this.dropFromShearingLootTable(serverLevel, FALootTables.SHEAR_MAMMOTH, itemStack, (serverLevelIn, itemStackIn) -> {
            for (int i = 0; i < itemStackIn.getCount(); ++i) {
                ItemEntity itemEntity = this.spawnAtLocation(serverLevelIn, itemStackIn.copyWithCount(1), 1.0F);
                if (itemEntity != null) {
                    itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().add((double) ((this.random.nextFloat() - this.random.nextFloat()) * 0.1F), (double) (this.random.nextFloat() * 0.05F), (double) ((this.random.nextFloat() - this.random.nextFloat()) * 0.1F)));
                }
            }
        });
        this.setSheared(true);
    }

    @Override
    public Optional<ResourceKey<DinopediaType>> getDinopediaType() {
        return Optional.of(FADinopediaTypes.MAMMOTH);
    }

    public static DyeColor getRandomMammothColor(RandomSource random) {
        return random.nextInt(500) == 0 ? DyeColor.PINK : random.nextInt(10) == 0 ? DyeColor.BLACK : DyeColor.BROWN;
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, EntitySpawnReason entitySpawnReason, SpawnGroupData spawnGroupData) {
        this.setColor(Mammoth.getRandomMammothColor(serverLevelAccessor.getRandom()));
        return super.finalizeSpawn(serverLevelAccessor, difficultyInstance, entitySpawnReason, spawnGroupData);
    }
}
