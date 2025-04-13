package willatendo.fossilslegacy.server.entity.goals;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;

import java.util.EnumSet;

public class DinoOwnerHurtTargetGoal extends TargetGoal {
    private final Dinosaur dinosaur;
    private LivingEntity ownerLastHurt;
    private int timestamp;

    public DinoOwnerHurtTargetGoal(Dinosaur dinosaur) {
        super(dinosaur, false);
        this.dinosaur = dinosaur;
        this.setFlags(EnumSet.of(Goal.Flag.TARGET));
    }

    @Override
    public boolean canUse() {
        if (this.dinosaur.isTranquilized()) {
            return false;
        }
        if (this.dinosaur.isTame() && !this.dinosaur.isOrderedToSit()) {
            LivingEntity livingentity = this.dinosaur.getOwner();
            if (livingentity == null) {
                return false;
            } else {
                this.ownerLastHurt = livingentity.getLastHurtMob();
                int i = livingentity.getLastHurtMobTimestamp();
                return i != this.timestamp && this.canAttack(this.ownerLastHurt, TargetingConditions.DEFAULT);
            }
        } else {
            return false;
        }
    }

    @Override
    public void start() {
        this.dinosaur.setTarget(this.ownerLastHurt);
        LivingEntity livingentity = this.dinosaur.getOwner();
        if (livingentity != null) {
            this.timestamp = livingentity.getLastHurtMobTimestamp();
        }

        super.start();
    }
}
