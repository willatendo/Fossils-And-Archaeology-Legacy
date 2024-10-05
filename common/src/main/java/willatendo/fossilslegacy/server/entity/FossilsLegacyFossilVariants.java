package willatendo.fossilslegacy.server.entity;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyFossilVariants {
    public static final ResourceKey<FossilVariant> BRACHIOSAURUS = FossilsLegacyFossilVariants.create("brachiosaurus");
    public static final ResourceKey<FossilVariant> COMPSOGNATHUS = FossilsLegacyFossilVariants.create("compsognathus");
    public static final ResourceKey<FossilVariant> FUTABASAURUS = FossilsLegacyFossilVariants.create("futabasaurus");
    public static final ResourceKey<FossilVariant> PACHYCEPHALOSAURUS = FossilsLegacyFossilVariants.create("pachycephalosaurus");
    public static final ResourceKey<FossilVariant> PTERANODON = FossilsLegacyFossilVariants.create("pteranodon");
    public static final ResourceKey<FossilVariant> TRICERATOPS = FossilsLegacyFossilVariants.create("triceratops");
    public static final ResourceKey<FossilVariant> VELOCIRAPTOR = FossilsLegacyFossilVariants.create("velociraptor");

    private static ResourceKey<FossilVariant> create(String name) {
        return ResourceKey.create(FossilsLegacyRegistries.FOSSIL_VARIANTS, FossilsLegacyUtils.resource(name));
    }

    private static void register(BootstrapContext<FossilVariant> bootstrapContext, ResourceKey<FossilVariant> resourceKey, FossilVariant fossilVariant) {
        bootstrapContext.register(resourceKey, fossilVariant);
    }

    private static void register(BootstrapContext<FossilVariant> bootstrapContext, ResourceKey<FossilVariant> resourceKey, int maxSize, String texture, ResourceLocation model, float shadowSize, float boundingBoxWidth, float boundingBoxHeight, float baseScale, float sizeScale) {
        FossilsLegacyFossilVariants.register(bootstrapContext, resourceKey, new FossilVariant(maxSize, FossilsLegacyUtils.resource("textures/entity/" + texture + "/" + texture + "_skeleton.png"), model, shadowSize, boundingBoxWidth, boundingBoxHeight, baseScale, sizeScale));
    }

    public static void bootstrap(BootstrapContext<FossilVariant> bootstrapContext) {
        FossilsLegacyFossilVariants.register(bootstrapContext, BRACHIOSAURUS, 36, "brachiosaurus", FossilsLegacyUtils.resource("brachiosaurus"), 0.15F, 1.0F, 1.5F, 1.5F, 0.3F);
        FossilsLegacyFossilVariants.register(bootstrapContext, COMPSOGNATHUS, 8, "compsognathus", FossilsLegacyUtils.resource("compsognathus"), 0.125F, 0.75F, 0.75F, 0.25F, 0.125F);
        FossilsLegacyFossilVariants.register(bootstrapContext, FUTABASAURUS, 12, "futabasaurus", FossilsLegacyUtils.resource("futabasaurus"), 0.15F, 1.0F, 0.65F, 1.5F, 0.3F);
        FossilsLegacyFossilVariants.register(bootstrapContext, PACHYCEPHALOSAURUS, 8, "pachycephalosaurus", FossilsLegacyUtils.resource("pachycephalosaurus"), 0.15F, 1.0F, 1.0F, 1.0F, 0.1F);
        FossilsLegacyFossilVariants.register(bootstrapContext, PTERANODON, 8, "pteranodon", FossilsLegacyUtils.resource("pteranodon"), 0.125F, 0.5F, 0.5F, 0.8F, 0.2F);
        FossilsLegacyFossilVariants.register(bootstrapContext, TRICERATOPS, 12, "triceratops", FossilsLegacyUtils.resource("legacy_triceratops"), 0.15F, 0.5F, 0.5F, 1.5F, 0.3F);
        FossilsLegacyFossilVariants.register(bootstrapContext, VELOCIRAPTOR, 8, "velociraptor", FossilsLegacyUtils.resource("velociraptor"), 0.15F, 0.25F, 0.5F, 0.5F, 0.1F);
    }
}
