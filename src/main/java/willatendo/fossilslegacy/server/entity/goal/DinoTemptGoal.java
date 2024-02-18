package willatendo.fossilslegacy.server.entity.goal;

import net.minecraft.world.entity.ai.goal.TemptGoal;
import willatendo.fossilslegacy.server.entity.Dinosaur;

public class DinoTemptGoal extends TemptGoal {
	public DinoTemptGoal(Dinosaur dinosaur, double speedModifier, boolean canScare) {
		super(dinosaur, speedModifier, dinosaur.getDiet().getTemptFoods(), canScare);
	}
}
