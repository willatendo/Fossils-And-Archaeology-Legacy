package willatendo.fossilslegacy.server.entity.goals;

import net.minecraft.world.entity.ai.goal.BreedGoal;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;

public class DinoBreedGoal extends BreedGoal {
    private Dinosaur dinosaur;

    public DinoBreedGoal(Dinosaur dinosaur, double speedModifier) {
        super(dinosaur, speedModifier);
        this.dinosaur = dinosaur;
    }

    @Override
    public boolean canUse() {
        return this.dinosaur != null ? !this.dinosaur.isTranquilized() && super.canUse() : super.canUse();
    }
}
