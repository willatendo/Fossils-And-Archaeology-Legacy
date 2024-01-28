package willatendo.fossilslegacy.server.entity.goal;

import java.util.EnumSet;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.entity.Smilodon;

public class SmilodonBegGoal extends Goal {
	private final Smilodon smilodon;
	private Player player;
	private final Level level;
	private final float lookDistance;
	private int lookTime;
	private final TargetingConditions begTargeting;

	public SmilodonBegGoal(Smilodon wolf, float lookDistance) {
		this.smilodon = wolf;
		this.level = wolf.level();
		this.lookDistance = lookDistance;
		this.begTargeting = TargetingConditions.forNonCombat().range(lookDistance);
		this.setFlags(EnumSet.of(Goal.Flag.LOOK));
	}

	@Override
	public boolean canUse() {
		this.player = this.level.getNearestPlayer(this.begTargeting, this.smilodon);
		if (this.player == null) {
			return false;
		}
		return this.playerHoldingInteresting(this.player);
	}

	@Override
	public boolean canContinueToUse() {
		if (!this.player.isAlive()) {
			return false;
		}
		if (this.smilodon.distanceToSqr(this.player) > (double) (this.lookDistance * this.lookDistance)) {
			return false;
		}
		return this.lookTime > 0 && this.playerHoldingInteresting(this.player);
	}

	@Override
	public void start() {
		this.smilodon.setIsInterested(true);
		this.lookTime = this.adjustedTickDelay(40 + this.smilodon.getRandom().nextInt(40));
	}

	@Override
	public void stop() {
		this.smilodon.setIsInterested(false);
		this.player = null;
	}

	@Override
	public void tick() {
		this.smilodon.getLookControl().setLookAt(this.player.getX(), this.player.getEyeY(), this.player.getZ(), 10.0f, this.smilodon.getMaxHeadXRot());
		--this.lookTime;
	}

	private boolean playerHoldingInteresting(Player player) {
		for (InteractionHand interactionHand : InteractionHand.values()) {
			ItemStack itemStack = player.getItemInHand(interactionHand);
			if (this.smilodon.isTame() && itemStack.is(Items.BONE)) {
				return true;
			}
			if (!this.smilodon.isFood(itemStack))
				continue;
			return true;
		}
		return false;
	}
}
