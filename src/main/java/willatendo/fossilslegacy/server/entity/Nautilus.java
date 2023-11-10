package willatendo.fossilslegacy.server.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.level.Level;

public class Nautilus extends Squid {
	public Nautilus(EntityType<? extends Squid> entityType, Level level) {
		super(entityType, level);
	}

	public static AttributeSupplier nautilusAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0F).build();
	}
}
