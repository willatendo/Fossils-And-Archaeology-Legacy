package willatendo.fossilslegacy.server.entity.util.interfaces;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.Optional;
import java.util.UUID;

public interface TicksToBirth {
    Entity getOffspring(Level level);

    int getRemainingTime();

    void setRemainingTime(int remainingPregnancyTime);

    default void onEntityTicksComplete(Mob mob, Entity offspring, Level level) {
        if (level instanceof ServerLevel serverLevel && offspring instanceof Mob mobOffspring) {
            mobOffspring.finalizeSpawn(serverLevel, level.getCurrentDifficultyAt(mob.blockPosition()), MobSpawnType.BREEDING, null);
        }
    }

    default int maxTime() {
        return 3000;
    }

    default void birthTick(Mob mob, Level level) {
        this.birthTick(mob, level, Optional.empty());
    }

    default void birthTick(Mob mob, Level level, Optional<UUID> owner) {
        if (this.getRemainingTime() >= this.maxTime()) {
            Entity offspring = this.getOffspring(level);
            offspring.moveTo(mob.getX(), mob.getY(), mob.getZ(), 0.0F, 0.0F);
            if (offspring instanceof GrowingEntity growingEntity) {
                growingEntity.setGrowthStage(0);
            }
            if (offspring instanceof Animal animal) {
                animal.setBaby(true);
            }
            if (owner.isEmpty()) {
                if (offspring instanceof TamesOnBirth tamesOnBirth) {
                    if (tamesOnBirth.tamesOnBirth()) {
                        Player player = level.getNearestPlayer(offspring, 25.0D);
                        if (player != null) {
                            tamesOnBirth.setOwnerUUID(player.getUUID());
                        }
                    }
                }
            } else {
                if (offspring instanceof TameAccessor tameAccessor) {
                    tameAccessor.setOwnerUUID(owner.get());
                }
            }
            this.onEntityTicksComplete(mob, offspring, level);
            level.addFreshEntity(offspring);
            mob.remove(RemovalReason.DISCARDED);
        } else {
            this.setRemainingTime(this.getRemainingTime() + 1);
        }
    }
}
