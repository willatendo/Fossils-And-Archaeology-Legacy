package willatendo.fossilslegacy.server.entity;

import java.util.function.Function;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public enum Fossils {
	BRACHIOSAURUS(FossilsLegacyUtils.resource("textures/entities/skeleton/brachiosaurus.png"), fossil -> new ScaleFactor(1.5F + (0.3F * (float) fossil.getSize()), 1.5F + (0.3F * (float) fossil.getSize()), 1.5F + (0.3F * (float) fossil.getSize()))),
	PLESIOSAURUS(FossilsLegacyUtils.resource("textures/entities/skeleton/plesiosaurus.png"), fossil -> new ScaleFactor(1.5F + (0.3F * (float) fossil.getSize()), 1.5F + (0.3F * (float) fossil.getSize()), 1.5F + (0.3F * (float) fossil.getSize()))),
	PTERANODON(FossilsLegacyUtils.resource("textures/entities/skeleton/pteranodon.png"), fossil -> new ScaleFactor(1.5F + (0.3F * (float) fossil.getSize()), 1.5F + (0.3F * (float) fossil.getSize()), 1.5F + (0.3F * (float) fossil.getSize()))),
	TRICERATOPS(FossilsLegacyUtils.resource("textures/entities/skeleton/triceratops.png"), fossil -> new ScaleFactor(1.5F + (0.3F * (float) fossil.getSize()), 1.5F + (0.3F * (float) fossil.getSize()), 1.5F + (0.3F * (float) fossil.getSize())));

	private final ResourceLocation fossilTexture;
	private final Function<Fossil, ScaleFactor> scaleFactor;

	private Fossils(ResourceLocation fossilTexture, Function<Fossil, ScaleFactor> scaleFactor) {
		this.fossilTexture = fossilTexture;
		this.scaleFactor = scaleFactor;
	}

	public ResourceLocation getFossilTexture() {
		return this.fossilTexture;
	}

	public Function<Fossil, ScaleFactor> getScaleFactor() {
		return this.scaleFactor;
	}

	public static record ScaleFactor(float x, float y, float z) {
	}
}
