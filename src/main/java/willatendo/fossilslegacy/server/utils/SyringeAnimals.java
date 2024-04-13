package willatendo.fossilslegacy.server.utils;

import java.util.function.Supplier;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;

public enum SyringeAnimals {
	CAT(() -> EntityType.CAT),
	COW(() -> EntityType.COW),
	DOLPHIN(() -> EntityType.DOLPHIN),
	DONKEY(() -> EntityType.DONKEY),
	FOX(() -> EntityType.FOX),
	GOAT(() -> EntityType.GOAT),
	HORSE(() -> EntityType.HORSE),
	LLAMA(() -> EntityType.LLAMA),
	MULE(() -> EntityType.MULE),
	OCELOT(() -> EntityType.OCELOT),
	PANDA(() -> EntityType.PANDA),
	PIG(() -> EntityType.PIG),
	POLAR_BEAR(() -> EntityType.POLAR_BEAR),
	RABBIT(() -> EntityType.RABBIT),
	SHEEP(() -> EntityType.SHEEP),
	WOLF(() -> EntityType.WOLF),
	MAMMOTH(() -> FossilsLegacyEntityTypes.MAMMOTH.get()),
	SMILODON(() -> FossilsLegacyEntityTypes.SMILODON.get());

	private final Supplier<EntityType<? extends Entity>> entityType;

	private SyringeAnimals(Supplier<EntityType<? extends Entity>> entityType) {
		this.entityType = entityType;
	}

	public Supplier<EntityType<? extends Entity>> getEntityType() {
		return this.entityType;
	}
}
