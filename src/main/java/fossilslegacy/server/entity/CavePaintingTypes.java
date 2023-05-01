package fossilslegacy.server.entity;

import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.resources.ResourceLocation;

public enum CavePaintingTypes {
	LIGHTING("lighting", 32, 16, 0, 0),
	SOCIAL("social", 16, 16, 32, 0),
	GREAT_WAR("great_war", 32, 32, 0, 16),
	ANU_DEATH("anu_death", 32, 16, 0, 48),
	PORTAL("portal", 32, 32, 0, 64),
	HEROBRINE("herobrine", 32, 32, 32, 32),
	SKELETON_AND_CREEPER("skeleton_and_creeper", 16, 16, 48, 0),
	ZOMBIE_AND_SPIDER("zombie_and_spider", 16, 16, 48, 16),
	TYRANNOSAURUS_IN_ICEBERG("tyrannosaurus_in_iceberg", 32, 32, 64, 0),
	TYRANNOSAURUS_TRANSPORT("tyrannosaurus_transport", 32, 16, 64, 32),
	TYRANNOSAURUS_MELT("tyrannosaurus_melt", 32, 16, 64, 48),
	TYRANNOSAURUS_ATTACK("tyrannosaurus_attack", 32, 32, 64, 64),
	TYRANNOSAURUS_DEATH("tyrannosaurus_death", 32, 32, 32, 64),
	GUNTYRANNOSAURUS_CORPSE("guntyrannosaurus_corpse", 64, 32, 32, 96),
	PRINCESS("princess", 32, 32, 0, 96),
	MOSASAURUS("mosasaurus", 32, 16, 64, 128),
	HOLY_MOSASAURUS("holy_mosasaurus", 64, 32, 0, 128),
	PAST("past", 32, 32, 96, 0),
	TIME_MACHINE("time_machine", 16, 32, 128, 0),
	FUTURE("future", 32, 32, 144, 0);

	private final String name;
	private final int width;
	private final int height;

	private CavePaintingTypes(String name, int width, int height, int xPos, int yPos) {
		this.name = name;
		this.width = width;
		this.height = height;
	}

	public ResourceLocation getTexture() {
		return FossilsLegacyUtils.resource("textures/entity/cave_painting/" + this.name + ".png");
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
}
