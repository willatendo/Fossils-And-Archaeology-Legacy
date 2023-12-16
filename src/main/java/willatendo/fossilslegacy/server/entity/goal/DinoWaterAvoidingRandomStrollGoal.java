package willatendo.fossilslegacy.server.entity.goal;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import willatendo.fossilslegacy.server.entity.PlayerCommandableAccess;
import willatendo.fossilslegacy.server.utils.DinosaurCommand;

public class DinoWaterAvoidingRandomStrollGoal extends WaterAvoidingRandomStrollGoal {
	private final PlayerCommandableAccess playerCommandable;

	public DinoWaterAvoidingRandomStrollGoal(PathfinderMob pathfinderMob, PlayerCommandableAccess playerCommandable, double speedModifier) {
		super(pathfinderMob, speedModifier);
		this.playerCommandable = playerCommandable;
	}

	@Override
	public boolean canUse() {
		if (this.playerCommandable.getCommand() == DinosaurCommand.STAY) {
			return false;
		} else {
			return super.canUse();
		}
	}

	@Override
	public boolean canContinueToUse() {
		if (this.playerCommandable.getCommand() == DinosaurCommand.STAY) {
			return false;
		} else {
			return super.canContinueToUse();
		}
	}
}
