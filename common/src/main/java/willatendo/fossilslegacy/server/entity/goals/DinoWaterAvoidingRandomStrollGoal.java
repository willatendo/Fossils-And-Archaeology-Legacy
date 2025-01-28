package willatendo.fossilslegacy.server.entity.goals;

import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import willatendo.fossilslegacy.server.command_type.FACommandTypes;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;

public class DinoWaterAvoidingRandomStrollGoal extends WaterAvoidingRandomStrollGoal {
    private final Dinosaur dinosaur;

    public DinoWaterAvoidingRandomStrollGoal(Dinosaur dinosaur, double speedModifier) {
        super(dinosaur, speedModifier);
        this.dinosaur = dinosaur;
    }

    @Override
    public boolean canUse() {
        if (this.dinosaur.getCommand().is(FACommandTypes.STAY)) {
            return false;
        } else {
            return super.canUse();
        }
    }

    @Override
    public boolean canContinueToUse() {
        if (this.dinosaur.getCommand().is(FACommandTypes.STAY)) {
            return false;
        } else {
            return super.canContinueToUse();
        }
    }
}
