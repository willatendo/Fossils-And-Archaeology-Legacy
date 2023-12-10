package willatendo.fossilslegacy.server.entity.goal;

import java.util.EnumSet;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import willatendo.fossilslegacy.server.entity.PlayerCommandable;
import willatendo.fossilslegacy.server.entity.TameAccessor;

public class DinoOwnerHurtTargetGoal extends TargetGoal {
	private final PlayerCommandable playerCommandable;
	private final TameAccessor tameAccessor;
	private LivingEntity ownerLastHurt;
	private int timestamp;

	public DinoOwnerHurtTargetGoal(Animal animal, PlayerCommandable playerCommandable, TameAccessor tameAccessor) {
		super(animal, false);
		this.playerCommandable = playerCommandable;
		this.tameAccessor = tameAccessor;
		this.setFlags(EnumSet.of(Goal.Flag.TARGET));
	}

	@Override
	public boolean canUse() {
		if (this.tameAccessor.isTame() && !this.playerCommandable.isOrderedToSit()) {
			LivingEntity livingentity = this.tameAccessor.getOwner();
			if (livingentity == null) {
				return false;
			} else {
				this.ownerLastHurt = livingentity.getLastHurtMob();
				int i = livingentity.getLastHurtMobTimestamp();
				return i != this.timestamp && this.canAttack(this.ownerLastHurt, TargetingConditions.DEFAULT);
			}
		} else {
			return false;
		}
	}

	@Override
	public void start() {
		this.mob.setTarget(this.ownerLastHurt);
		LivingEntity livingentity = this.tameAccessor.getOwner();
		if (livingentity != null) {
			this.timestamp = livingentity.getLastHurtMobTimestamp();
		}

		super.start();
	}
}
