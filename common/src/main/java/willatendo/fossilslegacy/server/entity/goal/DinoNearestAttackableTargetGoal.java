package willatendo.fossilslegacy.server.entity.goal;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.server.entity.Dinosaur;

public class DinoNearestAttackableTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
    private final Dinosaur dinosaur;

    public DinoNearestAttackableTargetGoal(Dinosaur dinosaur, Class<T> classTarget, boolean mustSee) {
        super(dinosaur, classTarget, mustSee);
        this.dinosaur = dinosaur;
    }

    @Override
    protected void findTarget() {
        if (this.targetType != Player.class && this.targetType != ServerPlayer.class) {
            this.target = this.mob.level().getNearestEntity(this.mob.level().getEntitiesOfClass(this.targetType, this.getTargetSearchArea(this.getFollowDistance()), (entity) -> {
                if (entity.getType() != this.dinosaur.getType()) {
                    return true;
                } else {
                    return false;
                }
            }), this.targetConditions, this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ());
        } else {
            this.target = this.mob.level().getNearestPlayer(this.targetConditions, this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ());
        }
    }

    @Override
    public boolean canUse() {
        if (!this.dinosaur.isBaby()) {
            if (this.dinosaur.isTame()) {
                return !this.dinosaur.isOwnedBy(this.target) && this.dinosaur.getType() != this.target.getType();
            } else {
                return this.target != null ? this.dinosaur.getType() != this.target.getType() : super.canUse();
            }
        } else {
            return false;
        }
    }
}
