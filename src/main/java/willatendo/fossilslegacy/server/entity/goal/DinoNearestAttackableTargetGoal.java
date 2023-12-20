package willatendo.fossilslegacy.server.entity.goal;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import willatendo.fossilslegacy.server.entity.Dinosaur;

public class DinoNearestAttackableTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
	private final Dinosaur dinosaur;

	public DinoNearestAttackableTargetGoal(Dinosaur dinosaur, Class<T> classTarget, boolean mustSee) {
		super(dinosaur, classTarget, mustSee);
		this.dinosaur = dinosaur;
	}

	@Override
	public boolean canUse() {
		return (!this.dinosaur.isBaby() && !this.dinosaur.isOwnedBy(this.target)) ? super.canUse() : false;
	}
}
