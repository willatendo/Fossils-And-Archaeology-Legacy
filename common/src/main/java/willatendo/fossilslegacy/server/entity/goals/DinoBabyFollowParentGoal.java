package willatendo.fossilslegacy.server.entity.goals;

import net.minecraft.world.entity.ai.goal.Goal;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;

import java.util.List;

public class DinoBabyFollowParentGoal extends Goal {
	private final Dinosaur dinosaur;
	private Dinosaur parent;
	private final double speedModifier;
	private int timeToRecalcPath;

	public DinoBabyFollowParentGoal(Dinosaur dinosaur, double speedModifier) {
		this.dinosaur = dinosaur;
		this.speedModifier = speedModifier;
	}

	@Override
	public boolean canUse() {
		if (!this.dinosaur.isBaby()) {
			return false;
		} else {
			List<? extends Dinosaur> dinosaurs = this.dinosaur.level().getEntitiesOfClass(this.dinosaur.getClass(), this.dinosaur.getBoundingBox().inflate(8.0D, 4.0D, 8.0D));
			Dinosaur dinosaur = null;
			double maxDistance = Double.MAX_VALUE;

			for (Dinosaur dinosaursNearby : dinosaurs) {
				if (dinosaursNearby.getAge() >= 0) {
					double d1 = this.dinosaur.distanceToSqr(dinosaursNearby);
					if (!(d1 > maxDistance)) {
						maxDistance = d1;
						dinosaur = dinosaursNearby;
					}
				}
			}

			if (dinosaur == null) {
				return false;
			} else if (maxDistance < 9.0D) {
				return false;
			} else {
				this.parent = dinosaur;
				return true;
			}
		}
	}

	@Override
	public boolean canContinueToUse() {
		if (this.dinosaur.getAge() >= 0) {
			return false;
		} else if (!this.parent.isAlive()) {
			return false;
		} else {
			double distance = this.dinosaur.distanceToSqr(this.parent);
			return !(distance < 9.0D) && !(distance > 256.0D);
		}
	}

	@Override
	public void start() {
		this.timeToRecalcPath = 0;
	}

	@Override
	public void stop() {
		this.parent = null;
	}

	@Override
	public void tick() {
		if (--this.timeToRecalcPath <= 0) {
			this.timeToRecalcPath = this.adjustedTickDelay(10);
			this.dinosaur.getNavigation().moveTo(this.parent, this.speedModifier);
		}
	}
}
