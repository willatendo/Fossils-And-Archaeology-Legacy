package willatendo.fossilslegacy.server.entity.goal;

import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.commands.FossilsLegacyCommandTypes;

public class DinoWaterAvoidingRandomStrollGoal extends WaterAvoidingRandomStrollGoal {
    private final Dinosaur dinosaur;

    public DinoWaterAvoidingRandomStrollGoal(Dinosaur dinosaur, double speedModifier) {
        super(dinosaur, speedModifier);
        this.dinosaur = dinosaur;
    }

    @Override
    public boolean canUse() {
        if (this.dinosaur.getCommand().is(FossilsLegacyCommandTypes.STAY)) {
            return false;
        } else {
            return super.canUse();
        }
    }

    @Override
    public boolean canContinueToUse() {
        if (this.dinosaur.getCommand().is(FossilsLegacyCommandTypes.STAY)) {
            return false;
        } else {
            return super.canContinueToUse();
        }
    }
}
