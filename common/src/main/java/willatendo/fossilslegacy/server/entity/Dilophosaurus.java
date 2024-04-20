package willatendo.fossilslegacy.server.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.utils.Lists;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.entity.goal.DinoBabyFollowParentGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoEatFromFeederGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoFollowOwnerGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoNearestAttackableTargetGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoOwnerHurtByTargetGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoOwnerHurtTargetGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoTemptGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoWaterAvoidingRandomStrollGoal;
import willatendo.fossilslegacy.server.item.FossilsLegacyItemTags;
import willatendo.fossilslegacy.server.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class Dilophosaurus extends Dinosaur implements DinopediaInformation, RangedAttackMob {
	public Dilophosaurus(EntityType<? extends Dilophosaurus> entityType, Level level) {
		super(entityType, level);
	}

	public static AttributeSupplier dilophosaurusAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0F).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 4.0D).build();
	}

	@Override
	public float maxUpStep() {
		return 1.0F;
	}

	@Override
	public int getMaxHunger() {
		return 100;
	}

	@Override
	public EggVariant getEggVariant() {
		return FossilsLegacyEggVariants.DILOPHOSAURUS.get();
	}

	@Override
	public int getMaxGrowthStage() {
		return 8;
	}

	@Override
	public float getBoundingBoxGrowth() {
		return 0.15F;
	}

	@Override
	public double getMinHealth() {
		return 7.0D;
	}

	@Override
	public Diet getDiet() {
		return Diet.carnivore();
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new DinoTemptGoal(this, 1.1D, false));
		this.goalSelector.addGoal(3, new DinoBabyFollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(3, new RangedAttackGoal(this, 1.25D, 20, 10.0F));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(5, new DinoWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinoFollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinoEatFromFeederGoal(this, 1.0D, 24, true));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new DinoOwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new DinoOwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(4, new DinoNearestAttackableTargetGoal<>(this, LivingEntity.class, true));
	}

	@Override
	public void performRangedAttack(LivingEntity livingEntity, float damage) {
		DilophosaurusVenom dilophosaurusVenom = new DilophosaurusVenom(this.level(), this);
		double headHeight = livingEntity.getEyeY() - (double) 1.1F;
		double x = livingEntity.getX() - this.getX();
		double y = headHeight - dilophosaurusVenom.getY();
		double z = livingEntity.getZ() - this.getZ();
		double p = Math.sqrt(x * x + z * z) * (double) 0.2F;
		dilophosaurusVenom.shoot(x, y + p, z, 1.6F, 12.0F);
		this.level().addFreshEntity(dilophosaurusVenom);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return this.random.nextInt(3) == 0 ? FossilsLegacySoundEvents.DILOPHOSAURUS_CALL.get() : FossilsLegacySoundEvents.DILOPHOSAURUS_AMBIENT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return FossilsLegacySoundEvents.DILOPHOSAURUS_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return FossilsLegacySoundEvents.DILOPHOSAURUS_DEATH.get();
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
		return CommandType.tag(FossilsLegacyItemTags.DILOPHOSAURUS_COMMANDABLES);
	}
}
