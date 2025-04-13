package willatendo.fossilslegacy.server.entity.goals;

import net.minecraft.world.entity.ai.goal.FloatGoal;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;

public class DinoFloatGoal extends FloatGoal {
    private Dinosaur dinosaur;

    public DinoFloatGoal(Dinosaur dinosaur) {
        super(dinosaur);
        this.dinosaur = dinosaur;
    }

    @Override
    public boolean canUse() {
        return this.dinosaur != null ? !this.dinosaur.isTranquilized() && super.canUse() : super.canUse();
    }
}
