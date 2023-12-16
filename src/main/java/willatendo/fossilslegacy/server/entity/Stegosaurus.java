package willatendo.fossilslegacy.server.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.utils.Lists;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.client.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.block.entity.FeederBlockEntity;
import willatendo.fossilslegacy.server.entity.Egg.EggType;
import willatendo.fossilslegacy.server.entity.goal.DinoBabyFollowParentGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoFollowOwnerGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoOwnerHurtByTargetGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoOwnerHurtTargetGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoWaterAvoidingRandomStrollGoal;
import willatendo.fossilslegacy.server.item.FossilsLegacyItemTags;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class Stegosaurus extends Dinosaur implements DinopediaInformation {
	public Stegosaurus(EntityType<? extends Stegosaurus> entityType, Level level) {
		super(entityType, level);
	}

	public static AttributeSupplier stegosaurusAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0F).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 1.0D).build();
	}

	@Override
	public int getMaxHunger() {
		return 500;
	}

	@Override
	public EggType eggType() {
		return EggType.STEGOSAURUS;
	}

	@Override
	public int maxGrowthStage() {
		return 12;
	}

	@Override
	public float boundingBoxGrowth() {
		return 0.35F;
	}

	@Override
	public double getMinHealth() {
		return 10.0F;
	}

	@Override
	public int foodLevelForItemStack(ItemStack itemStack) {
		return FeederBlockEntity.getPlantsFoodLevel(itemStack);
	}

	@Override
	public boolean isBaby() {
		return this.getGrowthStage() < 4;
	}

	@Override
	public float getStepHeight() {
		return this.getGrowthStage() < 4 ? 0.5F : this.getGrowthStage() < 8 ? 1.0F : 1.5F;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, DinoConstants.HERBIVORE_FOOD, false));
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
	protected SoundEvent getAmbientSound() {
		return FossilsLegacySoundEvents.STEGOSAURUS_AMBIENT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return FossilsLegacySoundEvents.STEGOSAURUS_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return FossilsLegacySoundEvents.STEGOSAURUS_DEATH.get();
	}

	@Override
	public double getPassengersRidingOffset() {
		return 0.15D * this.getGrowthStage();
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
	public TagKey<Item> commandItems() {
		return FossilsLegacyItemTags.TRICERATOPS_COMMANDABLES;
	}
}
