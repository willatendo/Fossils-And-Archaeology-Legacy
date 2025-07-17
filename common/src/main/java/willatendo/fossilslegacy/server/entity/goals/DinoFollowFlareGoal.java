package willatendo.fossilslegacy.server.entity.goals;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.FAItems;

import java.util.EnumSet;

public class DinoFollowFlareGoal extends Goal {
    private static final TargetingConditions TEMPT_TARGETING = TargetingConditions.forNonCombat().ignoreLineOfSight();
    private final Dinosaur dinosaur;
    private final TargetingConditions targetingConditions;
    protected Player player;

    public DinoFollowFlareGoal(Dinosaur dinosaur) {
        this.dinosaur = dinosaur;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        this.targetingConditions = DinoFollowFlareGoal.TEMPT_TARGETING.copy().selector((livingEntity, serverLevel) -> {
            ItemStack mainHandItemStack = livingEntity.getMainHandItem();
            ItemStack offHandItemStack = livingEntity.getOffhandItem();
            return this.hasInHand(mainHandItemStack) || this.hasInHand(offHandItemStack);
        });
    }

    private boolean hasInHand(ItemStack itemStack) {
        return itemStack.is(FAItems.FLARE.get()) && itemStack.has(FADataComponents.BURNING.get());
    }

    @Override
    public boolean canUse() {
        this.player = getServerLevel(this.dinosaur).getNearestPlayer(this.targetingConditions.range(this.dinosaur.getAttributeValue(Attributes.TEMPT_RANGE) * 3), this.dinosaur);
        return this.player != null;
    }


    @Override
    public void stop() {
        this.player = null;
        this.dinosaur.getNavigation().stop();
    }

    @Override
    public void tick() {
        this.dinosaur.getLookControl().setLookAt(this.player, (float) (this.dinosaur.getMaxHeadYRot() + 20), (float) this.dinosaur.getMaxHeadXRot());
        if (this.dinosaur.distanceToSqr(this.player) < 6.25) {
            this.dinosaur.getNavigation().stop();
        } else {
            this.dinosaur.getNavigation().moveTo(this.player, 1.0F);
        }
    }
}
