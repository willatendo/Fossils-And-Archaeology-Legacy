package willatendo.fossilslegacy.server.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class Failuresaurus extends Zombie {
    public Failuresaurus(EntityType<? extends Failuresaurus> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void jumpFromGround() {
    }
}
