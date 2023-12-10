package willatendo.fossilslegacy.server.entity.goal;

import java.util.EnumSet;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import willatendo.fossilslegacy.server.entity.PlayerCommandable;
import willatendo.fossilslegacy.server.entity.TameAccessor;

public class DinoOwnerHurtByTargetGoal extends TargetGoal {
	private final PlayerCommandable playerCommandable;
	private final TameAccessor tameAccessor;
	private LivingEntity ownerLastHurtBy;
	private int timestamp;

	public DinoOwnerHurtByTargetGoal(Animal animal, PlayerCommandable playerCommandable, TameAccessor tameAccessor) {
		super(animal, false);
		this.playerCommandable = playerCommandable;
		this.tameAccessor = tameAccessor;
		this.setFlags(EnumSet.of(Goal.Flag.TARGET));
	}

	@Override
	public boolean canUse() {
		if (this.tameAccessor.isTame() && !this.playerCommandable.isOrderedToSit()) {
			LivingEntity owner = this.tameAccessor.getOwner();
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
		LivingEntity owner = this.tameAccessor.getOwner();
		if (owner != null) {
			this.timestamp = owner.getLastHurtByMobTimestamp();
		}

		super.start();
	}
}
