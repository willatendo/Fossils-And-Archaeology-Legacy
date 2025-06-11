package willatendo.fossilslegacy.server.entity.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.level.Level;

public abstract class Vehicle extends VehicleEntity {
    public Vehicle(EntityType<? extends Vehicle> entityType, Level level) {
        super(entityType, level);
    }
}
