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
    public boolean canUse() {
        boolean canUse = super.canUse();
        if (canUse && this.target.getType() == this.dinosaur.getType()) {
            return false;
        }
        return canUse;
    }
}
