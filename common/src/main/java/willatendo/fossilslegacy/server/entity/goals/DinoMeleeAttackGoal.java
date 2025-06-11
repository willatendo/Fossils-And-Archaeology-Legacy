package willatendo.fossilslegacy.server.entity.goals;

import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;

public class DinoMeleeAttackGoal extends MeleeAttackGoal {
    private final Dinosaur dinosaur;

    public DinoMeleeAttackGoal(Dinosaur dinosaur, double speedModifier, boolean followingTargetEvenIfNotSeen) {
        super(dinosaur, speedModifier, followingTargetEvenIfNotSeen);
        this.dinosaur = dinosaur;
    }

    @Override
    public boolean canUse() {
        return this.dinosaur != null ? !this.dinosaur.isTranquilized() && super.canUse() : super.canUse();
    }
}
