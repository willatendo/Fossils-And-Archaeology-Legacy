package willatendo.fossilslegacy.server.entity;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public enum Fossils {
	BRACHIOSAURUS(FossilsLegacyUtils.resource("textures/entities/legacy/skeleton/brachiosaurus.png")),
	PLESIOSAURUS(FossilsLegacyUtils.resource("textures/entities/legacy/skeleton/plesiosaurus.png")),
	PTERANODON(FossilsLegacyUtils.resource("textures/entities/legacy/skeleton/pteranodon.png")),
	TRICERATOPS(FossilsLegacyUtils.resource("textures/entities/legacy/skeleton/triceratops.png"));

	private final ResourceLocation fossilTexture;

	private Fossils(ResourceLocation fossilTexture) {
		this.fossilTexture = fossilTexture;
	}

	public ResourceLocation getFossilTexture() {
		return this.fossilTexture;
	}
}
