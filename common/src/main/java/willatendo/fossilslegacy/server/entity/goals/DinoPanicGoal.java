package willatendo.fossilslegacy.server.entity.goals;

import net.minecraft.world.entity.ai.goal.PanicGoal;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;

public class DinoPanicGoal extends PanicGoal {
    private Dinosaur dinosaur;

    public DinoPanicGoal(Dinosaur dinosaur, double speedModifier) {
        super(dinosaur, speedModifier);
        this.dinosaur = dinosaur;
    }

    @Override
    public boolean canUse() {
        return this.dinosaur != null ? !this.dinosaur.isTranquilized() && super.canUse() : super.canUse();
    }
}
