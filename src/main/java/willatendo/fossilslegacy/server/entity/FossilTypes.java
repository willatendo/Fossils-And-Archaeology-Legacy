package willatendo.fossilslegacy.server.entity;

import java.util.function.Function;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public enum FossilTypes {
	BRACHIOSAURUS(36, FossilsLegacyUtils.resource("textures/entities/skeleton/brachiosaurus.png"), 1.0F, 0.2F, fossil -> new FossilScaleFactor(1.5F + (0.3F * (float) fossil.getSize()), 1.5F + (0.3F * (float) fossil.getSize()), 1.5F + (0.3F * (float) fossil.getSize()))),
	PLESIOSAURUS(12, FossilsLegacyUtils.resource("textures/entities/skeleton/plesiosaurus.png"), 1.0F, 0.25F, fossil -> new FossilScaleFactor(1.5F + (0.3F * (float) fossil.getSize()), 1.5F + (0.3F * (float) fossil.getSize()), 1.5F + (0.3F * (float) fossil.getSize()))),
	PTERANODON(8, FossilsLegacyUtils.resource("textures/entities/skeleton/pteranodon.png"), 0.25F, 0.15F, fossil -> new FossilScaleFactor(0.8F * (0.2F * (float) fossil.getSize()), 0.8F * (0.2F * (float) fossil.getSize()), 0.8F * (0.2F * (float) fossil.getSize()))),
	TRICERATOPS(12, FossilsLegacyUtils.resource("textures/entities/skeleton/triceratops.png"), 1.0F, 0.35F, fossil -> new FossilScaleFactor(1.5F + (0.3F * (float) fossil.getSize()), 1.5F + (0.3F * (float) fossil.getSize()), 1.5F + (0.3F * (float) fossil.getSize())));

	private final int maxSize;
	private final ResourceLocation fossilTexture;
	private final float baseSize;
	private final float boundingBoxGrowth;
	private final Function<Fossil, FossilScaleFactor> fossilScaleFactor;

	private FossilTypes(int maxSize, ResourceLocation fossilTexture, float baseSize, float boundingBoxGrowth, Function<Fossil, FossilScaleFactor> scaleFactor) {
		this.maxSize = maxSize;
		this.fossilTexture = fossilTexture;
		this.baseSize = baseSize;
		this.boundingBoxGrowth = boundingBoxGrowth;
		this.fossilScaleFactor = scaleFactor;
	}

	public int getMaxSize() {
		return this.maxSize;
	}

	public ResourceLocation getFossilTexture() {
		return this.fossilTexture;
	}

	public float getBaseSize() {
		return this.baseSize;
	}

	public float getBoundingBoxGrowth() {
		return this.boundingBoxGrowth;
	}

	public FossilScaleFactor getScaleFactor(Fossil fossil) {
		return this.fossilScaleFactor.apply(fossil);
	}

	public static FossilTypes get(int fossil) {
		return FossilTypes.values()[fossil];
	}

	public static record FossilScaleFactor(float x, float y, float z) {
	}
}
