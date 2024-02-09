package willatendo.fossilslegacy.server.entity.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import willatendo.fossilslegacy.server.entity.DinoSituation;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.HighlyIntelligent;

public class LearnChestsGoal extends Goal {
	private final Dinosaur dinosaur;
	private final HighlyIntelligent highlyIntelligent;
	private ChestBlockEntity nearbyChestBlcokEntity = null;
	private int learningTick = 300;

	public LearnChestsGoal(Dinosaur dinosaur) {
		this.dinosaur = dinosaur;
		if (dinosaur instanceof HighlyIntelligent highlyIntelligent) {
			this.highlyIntelligent = highlyIntelligent;
		} else {
			this.highlyIntelligent = null;
		}
	}

	@Override
	public boolean canUse() {
		if (this.dinosaur == null || this.highlyIntelligent == null) {
			return false;
		}
		if (this.highlyIntelligent.hasLearnedChests()) {
			return false;
		}
		this.nearbyChestBlcokEntity = this.getNearbyChest(15, 3, 15);
		if (this.nearbyChestBlcokEntity == null) {
			return false;
		}
		return true;
	}

	@Override
	public void tick() {
		this.learningTick--;
		if (this.learningTick <= 0) {
			if (this.dinosaur.isTame() && this.dinosaur.getOwner() instanceof Player player) {
				this.dinosaur.sendMessageToPlayer(DinoSituation.LEARNED_CHESTS, player);
			} else {
				for (Player player : this.dinosaur.level().players()) {
					this.dinosaur.sendMessageToPlayer(DinoSituation.LEARNED_CHESTS, player);
				}
			}

			this.highlyIntelligent.setLearnedChests(true);
		}
	}

	private ChestBlockEntity getNearbyChest(int rangeX, int rangeY, int rangeZ) {
		Level level = this.dinosaur.level();
		BlockEntity tmp = null;
		if (level == null) {
			return null;
		}
		for (int Xoffset = -rangeX; Xoffset <= rangeX; Xoffset++) {
			for (int Yoffset = -rangeY; Yoffset <= rangeY; Xoffset++) {
				if (this.dinosaur.getY() + Yoffset <= -64) {
					continue;
				}
				for (int Zoffset = -rangeZ; Zoffset < rangeZ; Zoffset++) {
					tmp = level.getBlockEntity(new BlockPos((int) (this.dinosaur.getX() + Xoffset), (int) (this.dinosaur.getY() + Yoffset), (int) (this.dinosaur.getZ() + Zoffset)));
					if (tmp instanceof ChestBlockEntity) {
						return (ChestBlockEntity) tmp;
					}
				}
			}
		}
		return null;
	}

}
