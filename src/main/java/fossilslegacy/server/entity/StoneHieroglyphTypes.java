package fossilslegacy.server.entity;

import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;

public enum StoneHieroglyphTypes {
	LIGHTING("lighting", 32, 16),
	SOCIAL("social", 16, 16),
	GREAT_WAR("great_war", 32, 32),
	ANU_DEATH("anu_death", 32, 16),
	PORTAL("portal", 32, 32),
	HEROBRINE("herobrine", 32, 32),
	SKELETON_AND_CREEPER("skeleton_and_creeper", 16, 16),
	ZOMBIE_AND_SPIDER("zombie_and_spider", 16, 16),
	TYRANNOSAURUS_IN_ICEBERG("tyrannosaurus_in_iceberg", 32, 32),
	TYRANNOSAURUS_TRANSPORT("tyrannosaurus_transport", 32, 16),
	TYRANNOSAURUS_MELT("tyrannosaurus_melt", 32, 16),
	TYRANNOSAURUS_ATTACK("tyrannosaurus_attack", 32, 32),
	TYRANNOSAURUS_DEATH("tyrannosaurus_death", 32, 32),
	TYRANNOSAURUS_CORPSE("tyrannosaurus_corpse", 64, 32),
	PRINCESS("princess", 32, 32),
	MOSASAURUS("mosasaurus", 32, 16),
	HOLY_MOSASAURUS("holy_mosasaurus", 64, 32),
	PAST("past", 32, 32),
	TIME_MACHINE("time_machine", 16, 32),
	FUTURE("future", 32, 32);

	private final String name;
	private final int width;
	private final int height;

	private StoneHieroglyphTypes(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
	}

	public ResourceLocation getTexture() {
		return FossilsLegacyUtils.resource("textures/entities/stone_hieroglyph/" + this.name + ".png");
	}

	public MutableComponent getName() {
		return FossilsLegacyUtils.translation("stone_hieroglyph", this.name + ".title");
	}

	public MutableComponent getAuthor() {
		return FossilsLegacyUtils.translation("stone_hieroglyph", this.name + ".author");
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
}
