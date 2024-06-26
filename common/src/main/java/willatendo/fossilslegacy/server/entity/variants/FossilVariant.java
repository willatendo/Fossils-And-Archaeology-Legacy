package willatendo.fossilslegacy.server.entity.variants;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.entity.Fossil;

import java.util.function.Function;

public record FossilVariant(int maxSize, ResourceLocation fossilTexture, ResourceLocation legacyTexture, float shadowSize, float boundingBoxWidth, float boundingBoxHeight, Function<Fossil, FossilScaleFactor> fossilScaleFactor) {
	public FossilVariant(int maxSize, ResourceLocation fossilTexture, float shadowSize, float boundingBoxWidth, float boundingBoxHeight, Function<Fossil, FossilScaleFactor> fossilScaleFactor) {
		this(maxSize, fossilTexture, null, shadowSize, boundingBoxWidth, boundingBoxHeight, fossilScaleFactor);
	}

	public FossilScaleFactor getScaleFactor(Fossil fossil) {
		return this.fossilScaleFactor.apply(fossil);
	}

	public static record FossilScaleFactor(float x, float y, float z) {
		public static FossilScaleFactor create(float x, float y, float z) {
			return new FossilScaleFactor(x, y, z);
		}

		public static FossilScaleFactor create(float xyz) {
			return new FossilScaleFactor(xyz, xyz, xyz);
		}
	}
}
