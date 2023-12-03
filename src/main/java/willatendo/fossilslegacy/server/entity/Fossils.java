package willatendo.fossilslegacy.server.entity;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public enum Fossils {
	BRACHIOSAURUS(FossilsLegacyUtils.resource("textures/entities/legacy/skeleton/brachiosaurus.png"), 1.0F),
	PLESIOSAURUS(FossilsLegacyUtils.resource("textures/entities/legacy/skeleton/plesiosaurus.png"), 1.0F),
	PTERANODON(FossilsLegacyUtils.resource("textures/entities/legacy/skeleton/pteranodon.png"), 1.0F),
	TRICERATOPS(FossilsLegacyUtils.resource("textures/entities/legacy/skeleton/triceratops.png"), 1.0F);

	private final ResourceLocation fossilTexture;
	private final float scale;

	private Fossils(ResourceLocation fossilTexture, float scale) {
		this.fossilTexture = fossilTexture;
		this.scale = scale;
	}

	public ResourceLocation getFossilTexture() {
		return this.fossilTexture;
	}

	public float getScale() {
		return this.scale;
	}
}
