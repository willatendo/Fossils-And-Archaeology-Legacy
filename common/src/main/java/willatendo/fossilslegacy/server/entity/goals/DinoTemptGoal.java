package willatendo.fossilslegacy.server.entity.goals;

import net.minecraft.world.entity.ai.goal.TemptGoal;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;

public class DinoTemptGoal extends TemptGoal {
    private Dinosaur dinosaur;

    public DinoTemptGoal(Dinosaur dinosaur, double speedModifier, boolean canScare) {
        super(dinosaur, speedModifier, itemStack -> itemStack.is(dinosaur.getDiet().getTemptFoods()), canScare);
        this.dinosaur = dinosaur;
    }

    @Override
    public boolean canUse() {
        return this.dinosaur != null ? !this.dinosaur.isTranquilized() && super.canUse() : super.canUse();
    }
}
