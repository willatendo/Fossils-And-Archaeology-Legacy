package willatendo.fossilslegacy.server.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.utils.Lists;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.client.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.block.entity.FeederBlockEntity;
import willatendo.fossilslegacy.server.entity.goal.DinoBabyFollowParentGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoFollowOwnerGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoOwnerHurtByTargetGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoOwnerHurtTargetGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoWaterAvoidingRandomStrollGoal;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class Smilodon extends Dinosaur implements DinopediaInformation {
	private boolean isWet;
	private boolean isShaking;
	private float shakeAnim;
	private float shakeAnimO;

	public Smilodon(EntityType<? extends Smilodon> entityType, Level level) {
		super(entityType, level);
	}

	public static AttributeSupplier smilodonAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 8.0F).add(Attributes.MOVEMENT_SPEED, 0.23D).build();
	}

	@Override
	public int getMaxHunger() {
		return 100;
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
		return FossilsLegacyEntities.SMILODON.get().create(serverLevel);
	}

	@Override
	public int maxGrowthStage() {
		return 1;
	}

	@Override
	public double getMinHealth() {
		return 8.0D;
	}

	@Override
	public float boundingBoxGrowth() {
		return 0.0F;
	}

	@Override
	public int foodLevelForItemStack(ItemStack itemStack) {
		return FeederBlockEntity.getMeatFoodLevel(itemStack);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, DinoConstants.CARNIVORE_FOOD, false));
		this.goalSelector.addGoal(4, new DinoBabyFollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(6, new DinoWaterAvoidingRandomStrollGoal(this, this, 1.0D));
		this.goalSelector.addGoal(6, new DinoFollowOwnerGoal(this, this, this, 1.0D, 10.0F, 2.0F));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new DinoOwnerHurtByTargetGoal(this, this, this));
		this.targetSelector.addGoal(2, new DinoOwnerHurtTargetGoal(this, this, this));
	}

	@Override
	public void aiStep() {
		super.aiStep();

		if (!this.level().isClientSide && this.isWet && !this.isShaking && !this.isPathFinding() && this.onGround()) {
			this.isShaking = true;
			this.shakeAnim = 0.0F;
			this.shakeAnimO = 0.0F;
			this.level().broadcastEntityEvent(this, (byte) 8);
		}
	}

	@Override
	public void handleEntityEvent(byte event) {
		if (event == 8) {
			this.isShaking = true;
			this.shakeAnim = 0.0F;
			this.shakeAnimO = 0.0F;
		} else if (event == 56) {
			this.cancelShake();
		} else {
			super.handleEntityEvent(event);
		}
	}

	public float getTailAngle() {
		return this.isTame() ? (0.55F - (this.getMaxHealth() - this.getHealth()) * 0.02F) * (float) Math.PI : ((float) Math.PI / 5F);
	}

	private void cancelShake() {
		this.isShaking = false;
		this.shakeAnim = 0.0F;
		this.shakeAnimO = 0.0F;
	}

	public boolean isWet() {
		return this.isWet;
	}

	public boolean isShaking() {
		return this.isShaking;
	}

	public float getWetShade(float time) {
		return Math.min(0.5F + Mth.lerp(time, this.shakeAnimO, this.shakeAnim) / 2.0F * 0.5F, 1.0F);
	}

	public float getBodyRollAngle(float ageInTicks, float max) {
		float f = (Mth.lerp(ageInTicks, this.shakeAnimO, this.shakeAnim) + max) / 1.8F;
		if (f < 0.0F) {
			f = 0.0F;
		} else if (f > 1.0F) {
			f = 1.0F;
		}

		return Mth.sin(f * (float) Math.PI) * Mth.sin(f * (float) Math.PI * 11.0F) * 0.15F * (float) Math.PI;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return FossilsLegacySoundEvents.SMILODON_AMBIENT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return FossilsLegacySoundEvents.SMILODON_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return FossilsLegacySoundEvents.SMILODON_DEATH.get();
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
		return CommandType.hand();
	}
}
