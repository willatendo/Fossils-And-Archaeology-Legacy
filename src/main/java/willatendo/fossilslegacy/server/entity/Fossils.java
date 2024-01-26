package willatendo.fossilslegacy.server.entity;

import java.util.function.Function;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public enum Fossils {
	BRACHIOSAURUS(36, FossilsLegacyUtils.resource("textures/entities/skeleton/brachiosaurus.png"), fossil -> new FossilScaleFactor(1.5F + (0.3F * (float) fossil.getSize()), 1.5F + (0.3F * (float) fossil.getSize()), 1.5F + (0.3F * (float) fossil.getSize()))),
	PLESIOSAURUS(12, FossilsLegacyUtils.resource("textures/entities/skeleton/plesiosaurus.png"), fossil -> new FossilScaleFactor(1.5F + (0.3F * (float) fossil.getSize()), 1.5F + (0.3F * (float) fossil.getSize()), 1.5F + (0.3F * (float) fossil.getSize()))),
	PTERANODON(8, FossilsLegacyUtils.resource("textures/entities/skeleton/pteranodon.png"), fossil -> new FossilScaleFactor(0.8F * (0.2F * (float) fossil.getSize()), 0.8F * (0.2F * (float) fossil.getSize()), 0.8F * (0.2F * (float) fossil.getSize()))),
	TRICERATOPS(12, FossilsLegacyUtils.resource("textures/entities/skeleton/triceratops.png"), fossil -> new FossilScaleFactor(1.5F + (0.3F * (float) fossil.getSize()), 1.5F + (0.3F * (float) fossil.getSize()), 1.5F + (0.3F * (float) fossil.getSize())));

	private final int maxSize;
	private final ResourceLocation fossilTexture;
	private final Function<Fossil, FossilScaleFactor> fossilScaleFactor;

	private Fossils(int maxSize, ResourceLocation fossilTexture, Function<Fossil, FossilScaleFactor> scaleFactor) {
		this.maxSize = maxSize;
		this.fossilTexture = fossilTexture;
		this.fossilScaleFactor = scaleFactor;
	}

	public int getMaxSize() {
		return this.maxSize;
	}

	public ResourceLocation getFossilTexture() {
		return this.fossilTexture;
	}

	public Function<Fossil, FossilScaleFactor> getScaleFactor() {
		return this.fossilScaleFactor;
	}

	public static record FossilScaleFactor(float x, float y, float z) {
	}
}
