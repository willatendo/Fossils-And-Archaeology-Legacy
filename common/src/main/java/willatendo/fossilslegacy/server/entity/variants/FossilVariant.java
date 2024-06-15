package willatendo.fossilslegacy.server.entity.variants;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.entity.Fossil;

import java.util.function.Function;

public record FossilVariant(int maxSize, ResourceLocation fossilTexture, float baseSize, float boundingBoxGrowth, float shadowSize, Function<Fossil, FossilScaleFactor> fossilScaleFactor) {

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
