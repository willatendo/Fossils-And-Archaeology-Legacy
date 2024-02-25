package willatendo.fossilslegacy.server.entity;

import java.util.function.Function;

import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.FossilVariant.FossilScaleFactor;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.FabricRegister;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyFossilVariants {
	public static final SimpleRegistry<FossilVariant> FOSSIL_VARIANTS = SimpleRegistry.create(FossilsLegacyRegistries.FOSSIL_VARIANTS, FossilsLegacyUtils.ID);

	public static final SimpleHolder<FossilVariant> BRACHIOSAURUS = register("brachiosaurus", 36, 1.0F, 0.2F, 0.15F, fossil -> FossilScaleFactor.create(1.5F + (0.3F * (float) fossil.getSize())));
	public static final SimpleHolder<FossilVariant> FUTABASAURUS = register("futabasaurus", 12, 1.0F, 0.25F, 0.15F, fossil -> FossilScaleFactor.create(1.5F + (0.3F * (float) fossil.getSize())));
	public static final SimpleHolder<FossilVariant> PTERANODON = register("pteranodon", 8, 0.5F, 0.15F, 0.125F, fossil -> FossilScaleFactor.create(0.8F + (0.2F * (float) fossil.getSize())));
	public static final SimpleHolder<FossilVariant> TRICERATOPS = register("triceratops", 12, 1.0F, 0.35F, 0.15F, fossil -> FossilScaleFactor.create(1.5F + (0.3F * (float) fossil.getSize())));

	public static SimpleHolder<FossilVariant> register(String id, int maxSize, float baseScale, float boundingBoxGrowth, float shadowSize, Function<Fossil, FossilScaleFactor> fossilScaleFactor) {
		return FOSSIL_VARIANTS.register(id, () -> new FossilVariant(maxSize, FossilsLegacyUtils.resource("textures/entities/skeleton/" + id + ".png"), baseScale, boundingBoxGrowth, shadowSize, fossilScaleFactor));
	}

	public static void init() {
		FabricRegister.register(FOSSIL_VARIANTS);
	}
}
