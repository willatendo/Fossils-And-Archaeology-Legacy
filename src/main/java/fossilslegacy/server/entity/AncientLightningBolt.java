package fossilslegacy.server.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.Level;

public class AncientLightningBolt extends LightningBolt {
	public AncientLightningBolt(EntityType<? extends AncientLightningBolt> entityType, Level level) {
		super(entityType, level);
	}
}
