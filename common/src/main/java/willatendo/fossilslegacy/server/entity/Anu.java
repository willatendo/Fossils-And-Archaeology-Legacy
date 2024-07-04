package willatendo.fossilslegacy.server.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.criteria.FossilsLegacyCriteriaTriggers;
import willatendo.fossilslegacy.server.entity.util.SpeakerType;
import willatendo.fossilslegacy.server.entity.util.SpeakingEntity;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;
import java.util.function.Function;

public class Anu extends Zombie implements SpeakingEntity {
    private static final EntityDataAccessor<Boolean> IS_CHARGING = SynchedEntityData.defineId(Anu.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> ATTACK_MODE = SynchedEntityData.defineId(Anu.class, EntityDataSerializers.INT);
    private final ServerBossEvent anuBossEvent = (ServerBossEvent) new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS).setDarkenScreen(true);

    public Anu(EntityType<? extends Anu> entityType, Level level) {
        super(entityType, level);
        this.xpReward = 50;
    }

    public static AttributeSupplier anuAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 100.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 0.0D).build();
    }

    @Override
    protected boolean convertsInWater() {
        return false;
    }

    @Override
    protected ItemStack getSkull() {
        return null;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(7, new AnuShootFireballGoal(this));
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(IS_CHARGING, false);
        builder.define(ATTACK_MODE, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("AttackMode", this.getAttackMode());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.setAttackMode(compoundTag.getInt("AttackMode"));
        if (this.hasCustomName()) {
            this.anuBossEvent.setName(this.getDisplayName());
        }
    }

    @Override
    public void setCustomName(Component component) {
        super.setCustomName(component);
        this.anuBossEvent.setName(this.getDisplayName());
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        this.anuBossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }

    @Override
    public void startSeenByPlayer(ServerPlayer serverPlayer) {
        super.startSeenByPlayer(serverPlayer);
        this.anuBossEvent.addPlayer(serverPlayer);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer serverPlayer) {
        super.stopSeenByPlayer(serverPlayer);
        this.anuBossEvent.removePlayer(serverPlayer);
    }

    @Override
    public void heal(float hearts) {
        float health = this.getHealth();
        if (health > 0.0f) {
            this.setHealth(health + hearts);
        }
    }

    @Override
    public void aiStep() {
        this.spreadNether();
        super.aiStep();
        if (this.isBaby()) {
            this.setBaby(false);
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().dimension() == Level.OVERWORLD) {
            for (Player player : this.level().players()) {
                if (player instanceof ServerPlayer serverPlayer) {
                    FossilsLegacyCriteriaTriggers.ANU_ON_EARTH.get().trigger(serverPlayer, this);
                }
            }
        }

        if (this.getAttackMode() != 1) {
            if (this.random.nextInt(5000) <= 5 && this.level().getNearestPlayer(this, 16.0D) != null) {
                this.qiShock();
            }
        }

        if (this.getTarget() != null && this.getRandom().nextInt(100) <= 25) {
            List<ZombifiedPiglin> zombifiedPiglins = this.level().getEntitiesOfClass(ZombifiedPiglin.class, new AABB(this.getX(), this.getY(), this.getZ(), this.getX() + 1.0D, this.getY() + 1.0D, this.getZ() + 1.0D).inflate(16D, 4D, 16D));
            if (!zombifiedPiglins.isEmpty() && zombifiedPiglins.size() >= 5) {
                this.turnZombifiedPiglinsOnPlayer(zombifiedPiglins, this.getTarget());
            }
        }
        if (this.getTarget() == null && this.getRandom().nextInt(100) <= 20 && !(this.level().dimension() == Level.NETHER)) {
            List<Pig> pigsInArea = this.level().getEntitiesOfClass(Pig.class, new AABB(this.getX(), this.getY(), this.getZ(), this.getX() + 1.0D, this.getY() + 1.0D, this.getZ() + 1.0D).inflate(16D, 4D, 16D));
            if (pigsInArea.size() >= 3) {
                this.turnPigsIntoZombifiedPiglins(pigsInArea);
            }
        }
    }

    public boolean isCharging() {
        return this.entityData.get(IS_CHARGING);
    }

    public void setCharging(boolean charging) {
        this.entityData.set(IS_CHARGING, charging);
    }

    public int getAttackMode() {
        return this.entityData.get(ATTACK_MODE);
    }

    public void setAttackMode(int attackMode) {
        this.entityData.set(ATTACK_MODE, attackMode);
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource randomSource, DifficultyInstance difficultyInstance) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
    }

    private void spreadNether() {
        if (!(this.level().dimension() == Level.NETHER)) {
            for (int x = (int) (Math.round(this.getBlockX()) - 1); x <= (int) (Math.round(this.getBlockX()) + 1); x++) {
                for (int z = (int) (Math.round(this.getBlockZ()) - 1); z <= (int) (Math.round(this.getBlockZ()) + 1); z++) {
                    int y = (int) (Math.round(this.getBlockY()) - 1);
                    BlockState blockState = this.level().getBlockState(new BlockPos(x, y, z));
                    BlockPos blockPos = new BlockPos(x, y, z);
                    if (blockState.is(BlockTags.BASE_STONE_OVERWORLD)) {
                        this.level().setBlock(blockPos, Blocks.NETHERRACK.defaultBlockState(), 3);
                    }
                    if (blockState.is(BlockTags.DIRT) || blockState.is(BlockTags.SAND) || blockState.is(Blocks.GRAVEL)) {
                        this.level().setBlock(blockPos, Blocks.SOUL_SAND.defaultBlockState(), 3);
                    }
                    if (blockState.is(BlockTags.ICE)) {
                        this.level().setBlock(blockPos, Blocks.OBSIDIAN.defaultBlockState(), 3);
                    }
                    if (blockState.is(Blocks.CLAY)) {
                        this.level().setBlock(blockPos, Blocks.GLOWSTONE.defaultBlockState(), 3);
                    }
                    if (x != Math.round(this.getBlockX()) && z != (Math.round(this.getBlockZ()))) {
                        if (this.getRandom().nextInt(2000) <= 1 && this.level().getBlockState(blockPos.above()).isAir()) {
                            if (this.level().getBlockState(blockPos).is(BlockTags.SOUL_FIRE_BASE_BLOCKS)) {
                                this.level().setBlock(blockPos.above(), Blocks.SOUL_FIRE.defaultBlockState(), 3);
                            } else {
                                this.level().setBlock(blockPos.above(), Blocks.FIRE.defaultBlockState(), 3);
                            }
                        }
                    }
                }
            }
            if (this.level() instanceof ServerLevel serverLevel) {
                serverLevel.setDayTime(18000L);
            }
        }
    }

    private void turnZombifiedPiglinsOnPlayer(List<ZombifiedPiglin> zombifiedPiglins, Entity target) {
        if (this.getTarget() == null) {
            return;
        }
        if (this.getTarget() instanceof Player player) {
            this.sendMessageToPlayer(Anu.AnuSpeaker.SUMMON_ZOMBIFIED_PIGLINS, player);
        }
        for (int j = 0; j < zombifiedPiglins.size(); j++) {
            Entity entity = zombifiedPiglins.get(j);
            if (entity instanceof TamedZombifiedPiglin tamedZombifiedPiglin) {
                if ((tamedZombifiedPiglin).getTarget() == null) {
                    tamedZombifiedPiglin.setTarget(this.getTarget());
                    if (this.getTarget() instanceof Player player) {
                        tamedZombifiedPiglin.sendMessageToPlayer(TamedZombifiedPiglin.TamedZombifiedPiglinSpeaker.ANU_SUMMON, player);
                    }
                }
            }
        }
    }

    private void turnPigsIntoZombifiedPiglins(List<Pig> pigs) {
        if (this.getTarget() instanceof Player player) {
            this.sendMessageToPlayer(Anu.AnuSpeaker.SUMMON_PIGS, player);
        }
        for (int j = 0; j < pigs.size(); j++) {
            Pig pig = pigs.get(j);
            if (this.level() instanceof ServerLevel serverLevel) {
                pig.thunderHit(serverLevel, new LightningBolt(EntityType.LIGHTNING_BOLT, serverLevel));
            }
        }
    }

    public void qiShock() {
        List<LivingEntity> livingEntities = this.level().getEntitiesOfClass(LivingEntity.class, new AABB(this.getX(), this.getY(), this.getZ(), this.getX() + 1.0D, this.getY() + 1.0D, this.getZ() + 1.0D).inflate(32D, 4D, 32D));
        if (!livingEntities.isEmpty()) {
            if (this.getTarget() instanceof Player player) {
                this.sendMessageToPlayer(Anu.AnuSpeaker.QI_SHOCK, player);
            }
            this.level().playLocalSound(this, SoundEvents.GENERIC_EXPLODE.value(), SoundSource.HOSTILE, 6.0F, (1.0F + (this.getRandom().nextFloat() - this.getRandom().nextFloat()) * 0.2F) * 0.7F);
            this.level().addParticle(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            for (int i = 0; i < livingEntities.size(); i++) {
                LivingEntity livingEntity = livingEntities.get(i);
                double x = this.getX() - livingEntity.getX();
                double z;
                for (z = this.getZ() - livingEntity.getZ(); x * x + z * z < 0.0001D; z = (Math.random() - Math.random()) * 0.01D) {
                    x = (Math.random() - Math.random()) * 0.01D;
                }
                if (livingEntity != this) {
                    livingEntity.knockback(0.0D, x * 5.0D, z * 5.0D);
                }
                if (livingEntity instanceof Player player) {
                    if (this.getRandom().nextInt(1000) >= 950) {
                        player.getInventory().dropAll();
                    }
                }
            }
        }
    }

    @Override
    public boolean hurt(DamageSource damageSource, float damage) {
        Entity attacker = damageSource.getEntity();
        if (attacker instanceof Player player) {
            if (damage > 0.0F) {
                ItemStack itemInMainHand = player.getMainHandItem();
                if (itemInMainHand.isEmpty()) {
                    if (this.getAttackMode() != 0) {
                        this.sendMessageToPlayer(AnuSpeaker.HAND_ATTACKED, player);
                        this.setAttackMode(0);
                        return super.hurt(damageSource, damage);
                    }
                } else {
                    if (itemInMainHand.getItem() instanceof SwordItem && this.getAttackMode() != 0) {
                        this.sendMessageToPlayer(AnuSpeaker.THREATEN, player);
                        this.setAttackMode(0);
                        return super.hurt(damageSource, damage);
                    }
                    if (damageSource.is(DamageTypes.ARROW) && this.getAttackMode() != 1) {
                        this.sendMessageToPlayer(AnuSpeaker.BOW_ATTACKED, player);
                        this.setAttackMode(1);
                        return super.hurt(damageSource, damage);
                    }
                    if (!(itemInMainHand.getItem() instanceof BowItem) && !(itemInMainHand.getItem() instanceof SwordItem)) {
                        double playerDistance = Math.sqrt(this.distanceToSqr(this.level().getNearestPlayer(this, 24.0D)));
                        if (playerDistance > 6 && this.getAttackMode() != 1) {
                            if (this.level().dimension() == Level.NETHER) {
                                this.sendMessageToPlayer(AnuSpeaker.LEARNED_HERE, player);
                            } else {
                                this.sendMessageToPlayer(AnuSpeaker.LEARNED_THERE, player);
                            }
                            this.setAttackMode(1);
                            return super.hurt(damageSource, damage);
                        }

                        if (playerDistance < 6 && this.getAttackMode() != 0) {
                            this.sendMessageToPlayer(AnuSpeaker.GENERIC_RANGED_ATTACKED, player);
                            this.setAttackMode(0);
                            return super.hurt(damageSource, damage);
                        }
                    }
                }
            } else {
                if (this.getAttackMode() != 1) {
                    this.sendMessageToPlayer(AnuSpeaker.GENERIC_MELEE_ATTACKED, player);
                    this.setAttackMode(1);
                    return super.hurt(damageSource, damage);
                }
            }

        }
        return super.hurt(damageSource, damage);
    }

    @Override
    public boolean removeWhenFarAway(double distance) {
        return !(this.level().dimension() == Level.NETHER);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ZOMBIFIED_PIGLIN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.ZOMBIFIED_PIGLIN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ZOMBIFIED_PIGLIN_DEATH;
    }

    @Override
    protected float getBlockSpeedFactor() {
        return 1.0F;
    }

    public static class AnuShootFireballGoal extends Goal {
        private final Anu anu;
        public int chargeTime;

        public AnuShootFireballGoal(Anu ghast) {
            this.anu = ghast;
        }

        @Override
        public boolean canUse() {
            return this.anu.getTarget() != null && this.anu.getAttackMode() == 0;
        }

        @Override
        public void start() {
            this.chargeTime = 0;
        }

        @Override
        public void stop() {
            this.anu.setCharging(false);
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            LivingEntity target = this.anu.getTarget();
            if (target == null) {
                return;
            }
            if (target.distanceToSqr(this.anu) < 4096.0 && this.anu.hasLineOfSight(target)) {
                Level level = this.anu.level();
                ++this.chargeTime;
                if (this.chargeTime == 20) {
                    Vec3 vec3 = this.anu.getViewVector(1.0f);
                    double x = target.getX() - (this.anu.getX() + vec3.x * 4.0);
                    double y = target.getY(0.5) - (0.5 + this.anu.getY(0.5));
                    double z = target.getZ() - (this.anu.getZ() + vec3.z * 4.0);
                    LargeFireball largeFireball = new LargeFireball(level, (LivingEntity) this.anu, new Vec3(x, y, z), 1);
                    largeFireball.setPos(this.anu.getX() + vec3.x * 4.0, this.anu.getY(0.5) + 0.5, largeFireball.getZ() + vec3.z * 4.0);
                    level.addFreshEntity(largeFireball);
                    this.chargeTime = -40;

                    if (target instanceof Player player) {
                        this.anu.sendMessageToPlayer(AnuSpeaker.RAIN_FIRE, player);
                    }
                }
            } else if (this.chargeTime > 0) {
                --this.chargeTime;
            }
            this.anu.setCharging(this.chargeTime > 10);
        }
    }

    public static enum AnuSpeaker implements SpeakerType<Anu> {
        GREETINGS("greetings"),
        HAND_ATTACKED("weak_attacked"),
        THREATEN("threating"),
        BOW_ATTACKED("bow_attacked"),
        LEARNED_HERE("learned_here"),
        LEARNED_THERE("learned_there"),
        GENERIC_RANGED_ATTACKED("generic_ranged_attacked"),
        GENERIC_MELEE_ATTACKED("generic_melee_attacked"),
        SUMMON_ZOMBIFIED_PIGLINS("summon_zombified_piglins"),
        SUMMON_PIGS("summon_pigs"),
        QI_SHOCK("qi_shock"),
        RAIN_FIRE("rain_fire");

        private Function<Player, Component> message;
        private final String translationKey;

        private AnuSpeaker(Function<Player, Component> message, String translationKey) {
            this.message = message;
            this.translationKey = translationKey;
        }

        private AnuSpeaker(String id) {
            this(player -> Anu.AnuSpeaker.basicSpeach(id), "entity.fossilslegacy.anu.speech." + id);
        }

        @Override
        public String getTranslationKey() {
            return this.translationKey;
        }

        protected static Component basicSpeach(String id) {
            return FossilsLegacyUtils.translation("entity", "anu.speach." + id);
        }

        protected static Component basicSpeach(String id, Object... args) {
            return FossilsLegacyUtils.translation("entity", "anu.speach." + id, args);
        }

        @Override
        public Component getMessage(Player player, Anu anu) {
            return this.message.apply(player);
        }
    }
}
