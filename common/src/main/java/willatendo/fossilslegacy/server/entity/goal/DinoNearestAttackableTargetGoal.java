package willatendo.fossilslegacy.server.entity.goal;

import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import willatendo.fossilslegacy.server.entity.Dinosaur;

public class DinoNearestAttackableTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
    private final Dinosaur dinosaur;

    public DinoNearestAttackableTargetGoal(Dinosaur dinosaur, TagKey<EntityType<?>> targets, boolean mustSee) {
        super(dinosaur, (Class<T>) LivingEntity.class, 10, mustSee, false, livingEntity -> {
            boolean sameOwnerFlag = false;
            if (livingEntity instanceof OwnableEntity ownableEntity) {
                if (ownableEntity.getOwnerUUID() != null && dinosaur.getOwnerUUID() != null) {
                    if (ownableEntity.getOwnerUUID() == dinosaur.getOwnerUUID()) {
                        sameOwnerFlag = true;
                    }
                }
            }
            return !sameOwnerFlag && livingEntity.getType().is(targets);
        });
        this.dinosaur = dinosaur;
    }
}
