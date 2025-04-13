package willatendo.fossilslegacy.server.entity.goals;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;

public class DinoLookAtPlayerGoal extends LookAtPlayerGoal {
    private final Dinosaur dinosaur;

    public DinoLookAtPlayerGoal(Dinosaur dinosaur, Class<? extends LivingEntity> lookAtType, float lookDistance) {
        super(dinosaur, lookAtType, lookDistance);
        this.dinosaur = dinosaur;
    }

    @Override
    public boolean canUse() {
        return this.dinosaur != null ? !this.dinosaur.isTranquilized() && super.canUse() : super.canUse();
    }
}
