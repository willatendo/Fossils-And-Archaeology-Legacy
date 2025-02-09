package willatendo.fossilslegacy.server.entity.goals;

import net.minecraft.world.entity.ai.goal.TemptGoal;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;

public class DinoTemptGoal extends TemptGoal {
    public DinoTemptGoal(Dinosaur dinosaur, double speedModifier, boolean canScare) {
        super(dinosaur, speedModifier, itemStack -> itemStack.is(dinosaur.getDiet().getTemptFoods()), canScare);
    }
}
