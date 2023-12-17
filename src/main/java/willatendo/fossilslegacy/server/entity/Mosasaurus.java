package willatendo.fossilslegacy.server.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.utils.Lists;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.navigation.AmphibiousPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.block.entity.FeederBlockEntity;
import willatendo.fossilslegacy.server.entity.Egg.EggType;
import willatendo.fossilslegacy.server.entity.goal.DinoOwnerHurtByTargetGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoOwnerHurtTargetGoal;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class Mosasaurus extends Dinosaur implements DinopediaInformation {
	public final float idleSinkSpeed = -0.00375F;
	public final float activeSinkSpeed = this.idleSinkSpeed * 5.0F;
	public final float floatSpeed = this.activeSinkSpeed * -5.0f;

	public Mosasaurus(EntityType<? extends Mosasaurus> entityType, Level level) {
		super(entityType, level);
		this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
	}

	public static AttributeSupplier mosasaurusAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 7.0F).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 1.0D).build();
	}

	@Override
	public int getMaxHunger() {
		return 500;
	}

	@Override
	public EggType eggType() {
		return EggType.MOSASAURUS;
	}

	@Override
	public int maxGrowthStage() {
		return 8;
	}

	@Override
	public float boundingBoxGrowth() {
		return 0.35F;
	}

	@Override
	public double getMinHealth() {
		return 7.0F;
	}

	@Override
	public int foodLevelForItemStack(ItemStack itemStack) {
		return FeederBlockEntity.getMeatFoodLevel(itemStack);
	}

	@Override
	protected PathNavigation createNavigation(Level level) {
		return new MosasaurusPathNavigation(this, level);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public boolean isPushedByFluid() {
		return false;
	}

	@Override
	protected void playStepSound(BlockPos blockPos, BlockState blockState) {
	}

	@Override
	protected void registerGoals() {
//		this.goalSelector.addGoal(0, new FloatGoal(this));
//		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
//		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, DinoConstants.CARNIVORE_FOOD, false));
//		this.goalSelector.addGoal(4, new DinoBabyFollowParentGoal(this, 1.1D));
//		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(6, new RandomSwimmingGoal(this, 1.0D, 10));
//		this.goalSelector.addGoal(6, new DinoFollowOwnerGoal(this, this, this, 1.0D, 10.0F, 2.0F));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new DinoOwnerHurtByTargetGoal(this, this, this));
		this.targetSelector.addGoal(2, new DinoOwnerHurtTargetGoal(this, this, this));
	}

	@Override
	public void travel(Vec3 vec3) {
		if (this.isControlledByLocalInstance() && this.isInWater()) {
			this.moveRelative(0.1F, vec3);
			this.move(MoverType.SELF, this.getDeltaMovement());
			this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
			if (this.getTarget() == null) {
				this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
			}
		} else {
			super.travel(vec3);
		}

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
		return null;
	}

	public static class MosasaurusPathNavigation extends AmphibiousPathNavigation {
		public MosasaurusPathNavigation(Mob mob, Level level) {
			super(mob, level);
		}

		@Override
		public boolean isStableDestination(BlockPos blockPos) {
			return this.level.getBlockState(blockPos).is(Blocks.WATER);
		}
	}
}
