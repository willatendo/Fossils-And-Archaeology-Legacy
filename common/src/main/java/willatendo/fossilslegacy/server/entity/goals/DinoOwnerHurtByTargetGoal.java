package willatendo.fossilslegacy.server.entity.goals;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;

import java.util.EnumSet;

public class DinoOwnerHurtByTargetGoal extends TargetGoal {
	private final Dinosaur dinosaur;
	private LivingEntity ownerLastHurtBy;
	private int timestamp;
	
	public DinoOwnerHurtByTargetGoal(Dinosaur dinosaur) {
		super(dinosaur, false);
		this.dinosaur = dinosaur;
		this.setFlags(EnumSet.of(Goal.Flag.TARGET));
	}

	@Override
	public boolean canUse() {
		if (this.dinosaur.isTame() && !this.dinosaur.isOrderedToSit()) {
			LivingEntity owner = this.dinosaur.getOwner();
			if (owner == null) {
				return false;
			} else {
				this.ownerLastHurtBy = owner.getLastHurtByMob();
				int time = owner.getLastHurtByMobTimestamp();
				return time != this.timestamp && this.canAttack(this.ownerLastHurtBy, TargetingConditions.DEFAULT);
			}
		} else {
			return false;
		}
	}

	@Override
	public void start() {
		this.mob.setTarget(this.ownerLastHurtBy);
		LivingEntity owner = this.dinosaur.getOwner();
		if (owner != null) {
			this.timestamp = owner.getLastHurtByMobTimestamp();
		}

		super.start();
	}
}
