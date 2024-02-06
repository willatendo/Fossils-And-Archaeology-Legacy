package willatendo.fossilslegacy.server.entity;

import java.util.List;
import java.util.function.Function;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.FossilsLegacyConfig;
import willatendo.fossilslegacy.server.criteria.FossilsLegacyCriteriaTriggers;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class Anu extends Monster implements SpeakingEntity {
	private final ServerBossEvent anuBossEvent = (ServerBossEvent) new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS).setDarkenScreen(true);

	public Anu(EntityType<? extends Anu> entityType, Level level) {
		super(entityType, level);
	}

	public static boolean checkAnuSpawnRules(EntityType<Anu> entityType, ServerLevelAccessor serverLevelAccessor, MobSpawnType mobSpawnType, BlockPos blockPos, RandomSource randomSource) {
		return FossilsLegacyConfig.COMMON_CONFIG.shouldAnuSpawn() && serverLevelAccessor.getDifficulty() != Difficulty.PEACEFUL;
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compoundTag) {
		super.readAdditionalSaveData(compoundTag);
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
	}

	@Override
	public void tick() {
		super.tick();

		if (this.level().dimension() != Level.NETHER) {
			for (Player player : this.level().players()) {
				if (player instanceof ServerPlayer serverPlayer) {
					FossilsLegacyCriteriaTriggers.ANU_ON_EARTH.get().trigger(serverPlayer, this);
				}
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
						this.level().setBlock(blockPos, Blocks.SOUL_SOIL.defaultBlockState(), 3);
					}
					if (blockState.is(BlockTags.ICE)) {
						this.level().setBlock(blockPos, Blocks.OBSIDIAN.defaultBlockState(), 3);
					}
					if (blockState.is(Blocks.CLAY)) {
						this.level().setBlock(blockPos, Blocks.GLOWSTONE.defaultBlockState(), 3);
					}
					if (x != Math.round(this.getBlockX()) && z != (Math.round(this.getBlockZ()))) {
						if (this.getRandom().nextInt(2000) <= 1 && this.level().getBlockState(blockPos.above()).isAir()) {
							this.level().setBlock(blockPos.above(), Blocks.FIRE.defaultBlockState(), 3);
						}
					}
				}
			}
			if (this.level() instanceof ServerLevel serverLevel) {
				serverLevel.setDayTime(24000L);
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
						tamedZombifiedPiglin.sendMessageToPlayer(TamedZombifiedPiglin.TameZombifiedPiglinSpeaker.ANU_SUMMON, player);
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
			this.level().playLocalSound(this, SoundEvents.GENERIC_EXPLODE, SoundSource.HOSTILE, 6.0F, (1.0F + (this.getRandom().nextFloat() - this.getRandom().nextFloat()) * 0.2F) * 0.7F);
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

	public void fireFireball(Entity target) {
		if (this.getTarget() instanceof Player player) {
			this.sendMessageToPlayer(Anu.AnuSpeaker.RAIN_FIRE, player);
		}
		double x = target.getX() - this.getX();
		double y = target.getY(0.5) - (0.5 + this.getY(0.5));
		double z = target.getZ() - this.getZ();
		for (int i = 1; i <= 16; i++) {
			Vec3 vec3 = this.getViewVector(1.0f);
			LargeFireball largeFireball = new LargeFireball(this.level(), this, x, y, z, 1);
			largeFireball.setPos(this.getX() + vec3.x * 4.0, this.getY(0.5) + 0.5, largeFireball.getZ() + vec3.z * 4.0);
			this.level().addFreshEntity(largeFireball);
		}
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

	public static enum AnuSpeaker implements Speaker {
		GREETINGS("greetings"),
		HAND_ATTACKED("weak_attacked"),
		THREATEN("threating"),
		BOW_ATTACKED("bow_attacked"),
		LEARNED_HERE("learned_here"),
		LEANRED_THERE("learned_there"),
		GENERIC_RANGED_ATTACKED("generic_ranged_attacked"),
		GENERIC_MELEE_ATTACKED("generic_melee_attacked"),
		SUMMON_ZOMBIFIED_PIGLINS("summon_zombified_piglins"),
		SUMMON_PIGS("summon_pigs"),
		QI_SHOCK("qi_shock"),
		RAIN_FIRE("rain_fire");

		private Function<Player, Component> message;

		private AnuSpeaker(Function<Player, Component> message) {
			this.message = message;
		}

		private AnuSpeaker(String id) {
			this(player -> Anu.AnuSpeaker.basicSpeach(id));
		}

		protected static Component basicSpeach(String id) {
			return FossilsLegacyUtils.translation("entity", "anu.speach." + id);
		}

		protected static Component basicSpeach(String id, Object... args) {
			return FossilsLegacyUtils.translation("entity", "anu.speach." + id, args);
		}

		@Override
		public Component getMessage(Player player) {
			return this.message.apply(player);
		}
	}
}
