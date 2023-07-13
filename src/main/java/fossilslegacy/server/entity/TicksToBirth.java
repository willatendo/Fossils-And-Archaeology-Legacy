package fossilslegacy.server.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public interface TicksToBirth<T extends Entity> {
	T getOffspring(Level level);

	int getRemainingTime();

	void setRemainingTime(int remainingPregnancyTime);

	default void onEntityTicksComplete(Mob mob, Level level) {
	}

	default int maxTime() {
		return 3000;
	}

	default void birthTick(Mob mob, Level level) {
		if (this.getRemainingTime() >= this.maxTime()) {
			Entity offspring = this.getOffspring(level);
			offspring.moveTo(mob.getX(), mob.getY(), mob.getZ(), 0.0F, 0.0F);
			if (offspring instanceof GrowingEntity growingEntity) {
				growingEntity.setGrowthStage(0);
				growingEntity.setRealAge(0);
			}
			if (offspring instanceof TamesOnBirth tamesOnBirth) {
				Player player = level.getNearestPlayer(offspring, 25.0D);
				if (player != null) {
					tamesOnBirth.setOwnerUUID(player.getUUID());
				}
			}
			level.addFreshEntity(offspring);
			this.onEntityTicksComplete(mob, level);
			mob.remove(RemovalReason.DISCARDED);
		} else {
			this.setRemainingTime(this.getRemainingTime() + 1);
		}
	}
}
