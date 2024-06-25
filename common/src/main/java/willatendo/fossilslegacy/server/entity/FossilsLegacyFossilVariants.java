package willatendo.fossilslegacy.server.entity;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant.FossilScaleFactor;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.List;
import java.util.function.Function;

public class FossilsLegacyFossilVariants {
    public static final SimpleRegistry<FossilVariant> FOSSIL_VARIANTS = SimpleRegistry.create(FossilsLegacyRegistries.FOSSIL_VARIANTS, FossilsLegacyUtils.ID);

    public static final SimpleHolder<FossilVariant> BRACHIOSAURUS = register("brachiosaurus", 36, 0.15F, 1.0F, 1.5F, fossil -> FossilScaleFactor.create(1.5F + (0.3F * (float) fossil.getSize())));
    public static final SimpleHolder<FossilVariant> COMPSOGNATHUS = nonLegacy("compsognathus", 8, 0.125F, 0.75F, 0.75F, fossil -> FossilScaleFactor.create(0.25F + (0.125F * (float) fossil.getSize())));
    public static final SimpleHolder<FossilVariant> FUTABASAURUS = register("futabasaurus", 12, 0.15F, 1.0F, 0.65F, fossil -> FossilScaleFactor.create(1.5F + (0.3F * (float) fossil.getSize())));
    public static final SimpleHolder<FossilVariant> PACHYCEPHALOSAURUS = nonLegacy("pachycephalosaurus", 8, 0.15F, 1.0F, 1.0F, fossil -> FossilScaleFactor.create(1.0F + (0.1F * (float) fossil.getSize())));
    public static final SimpleHolder<FossilVariant> PTERANODON = register("pteranodon", 8, 0.125F, 0.5F, 0.5F, fossil -> FossilScaleFactor.create(0.8F + (0.2F * (float) fossil.getSize())));
    public static final SimpleHolder<FossilVariant> TRICERATOPS = register("triceratops", 12, 0.15F, 0.5F, 0.5F, fossil -> FossilScaleFactor.create(1.5F + (0.3F * (float) fossil.getSize())));
    public static final SimpleHolder<FossilVariant> VELOCIRAPTOR = nonLegacy("velociraptor", 8, 0.15F, 0.25F, 0.5F, fossil -> FossilScaleFactor.create(0.5F + (0.1F * (float) fossil.getSize())));

    public static SimpleHolder<FossilVariant> register(String id, int maxSize, float shadowSize, float boundingBoxWidth, float boundingBoxHeight, Function<Fossil, FossilScaleFactor> fossilScaleFactor) {
        return FossilsLegacyFossilVariants.register(id, maxSize, FossilsLegacyUtils.resource("textures/entities/skeleton/" + id + ".png"), shadowSize, boundingBoxWidth, boundingBoxHeight, fossilScaleFactor);
    }

    public static SimpleHolder<FossilVariant> nonLegacy(String id, int maxSize, float shadowSize, float boundingBoxWidth, float boundingBoxHeight, Function<Fossil, FossilScaleFactor> fossilScaleFactor) {
        return FossilsLegacyFossilVariants.register(id, maxSize, FossilsLegacyUtils.resource("textures/entities/animals/" + id + "/" + id + "_skeleton.png"), shadowSize, boundingBoxWidth, boundingBoxHeight, fossilScaleFactor);
    }

    public static SimpleHolder<FossilVariant> register(String id, int maxSize, ResourceLocation textureLocation, float shadowSize, float boundingBoxWidth, float boundingBoxHeight, Function<Fossil, FossilScaleFactor> fossilScaleFactor) {
        return FOSSIL_VARIANTS.register(id, () -> new FossilVariant(maxSize, textureLocation, shadowSize, boundingBoxWidth, boundingBoxHeight, fossilScaleFactor));
    }

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(FOSSIL_VARIANTS);
    }
}
