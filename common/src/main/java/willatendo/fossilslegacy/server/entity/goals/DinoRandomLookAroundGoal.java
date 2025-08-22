package willatendo.fossilslegacy.server.entity.goals;

import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;

public class DinoRandomLookAroundGoal extends RandomLookAroundGoal {
    private final Dinosaur dinosaur;

    public DinoRandomLookAroundGoal(Dinosaur dinosaur) {
        super(dinosaur);
        this.dinosaur = dinosaur;
    }

    @Override
    public boolean canUse() {
        return !this.dinosaur.isTranquilized() && super.canUse();
    }
}
