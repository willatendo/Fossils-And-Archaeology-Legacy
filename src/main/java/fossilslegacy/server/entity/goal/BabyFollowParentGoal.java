package fossilslegacy.server.entity.goal;

import java.util.List;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Animal;

public class BabyFollowParentGoal extends Goal {
	private final Animal animal;
	private Animal parent;
	private final double speedModifier;
	private int timeToRecalcPath;

	public BabyFollowParentGoal(Animal animal, double speedModifier) {
		this.animal = animal;
		this.speedModifier = speedModifier;
	}

	@Override
	public boolean canUse() {
		if (!this.animal.isBaby()) {
			return false;
		} else {
			List<? extends Animal> animals = this.animal.level().getEntitiesOfClass(this.animal.getClass(), this.animal.getBoundingBox().inflate(8.0D, 4.0D, 8.0D));
			Animal animal = null;
			double maxDistance = Double.MAX_VALUE;

			for (Animal animalsNearby : animals) {
				if (animalsNearby.getAge() >= 0) {
					double d1 = this.animal.distanceToSqr(animalsNearby);
					if (!(d1 > maxDistance)) {
						maxDistance = d1;
						animal = animalsNearby;
					}
				}
			}

			if (animal == null) {
				return false;
			} else if (maxDistance < 9.0D) {
				return false;
			} else {
				this.parent = animal;
				return true;
			}
		}
	}

	@Override
	public boolean canContinueToUse() {
		if (this.animal.getAge() >= 0) {
			return false;
		} else if (!this.parent.isAlive()) {
			return false;
		} else {
			double distance = this.animal.distanceToSqr(this.parent);
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
			this.animal.getNavigation().moveTo(this.parent, this.speedModifier);
		}
	}
}
