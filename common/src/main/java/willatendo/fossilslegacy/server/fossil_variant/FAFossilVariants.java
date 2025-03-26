package willatendo.fossilslegacy.server.fossil_variant;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAItemTags;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FAFossilVariants {
    public static final ResourceKey<FossilVariant> ANKYLOSAURUS = FAFossilVariants.create("ankylosaurus");
    public static final ResourceKey<FossilVariant> BRACHIOSAURUS = FAFossilVariants.create("brachiosaurus");
    public static final ResourceKey<FossilVariant> LEGACY_BRACHIOSAURUS = FAFossilVariants.create("legacy_brachiosaurus");
    public static final ResourceKey<FossilVariant> CARNOTAURUS = FAFossilVariants.create("carnotaurus");
    public static final ResourceKey<FossilVariant> COMPSOGNATHUS = FAFossilVariants.create("compsognathus");
    public static final ResourceKey<FossilVariant> CRYOLOPHOSAURUS = FAFossilVariants.create("cryolophosaurus");
    public static final ResourceKey<FossilVariant> DILOPHOSAURUS = FAFossilVariants.create("dilophosaurus");
    public static final ResourceKey<FossilVariant> DIMETRODON = FAFossilVariants.create("dimetrodon");
    public static final ResourceKey<FossilVariant> FUTABASAURUS = FAFossilVariants.create("futabasaurus");
    public static final ResourceKey<FossilVariant> LEGACY_FUTABASAURUS = FAFossilVariants.create("legacy_futabasaurus");
    public static final ResourceKey<FossilVariant> GALLIMIMUS = FAFossilVariants.create("gallimimus");
    public static final ResourceKey<FossilVariant> MOSASAURUS = FAFossilVariants.create("mosasaurus");
    public static final ResourceKey<FossilVariant> PACHYCEPHALOSAURUS = FAFossilVariants.create("pachycephalosaurus");
    public static final ResourceKey<FossilVariant> PTERANODON = FAFossilVariants.create("pteranodon");
    public static final ResourceKey<FossilVariant> LEGACY_PTERANODON = FAFossilVariants.create("legacy_pteranodon");
    public static final ResourceKey<FossilVariant> SPINOSAURUS = FAFossilVariants.create("spinosaurus");
    public static final ResourceKey<FossilVariant> STEGOSAURUS = FAFossilVariants.create("stegosaurus");
    public static final ResourceKey<FossilVariant> THERIZINOSAURUS = FAFossilVariants.create("therizinosaurus");
    public static final ResourceKey<FossilVariant> TRICERATOPS = FAFossilVariants.create("triceratops");
    public static final ResourceKey<FossilVariant> TYRANNOSAURUS = FAFossilVariants.create("tyrannosaurus");
    public static final ResourceKey<FossilVariant> LEGACY_TRICERATOPS = FAFossilVariants.create("legacy_triceratops");
    public static final ResourceKey<FossilVariant> VELOCIRAPTOR = FAFossilVariants.create("velociraptor");

    private static ResourceKey<FossilVariant> create(String name) {
        return ResourceKey.create(FARegistries.FOSSIL_VARIANTS, FAUtils.resource(name));
    }

    private static void register(BootstrapContext<FossilVariant> bootstrapContext, ResourceKey<FossilVariant> resourceKey, FossilVariant fossilVariant) {
        bootstrapContext.register(resourceKey, fossilVariant);
    }

    private static void registerMesozoic(BootstrapContext<FossilVariant> bootstrapContext, ResourceKey<FossilVariant> resourceKey, int maxSize, String texture, ResourceLocation model, int fossilCount, float boundingBoxWidth, float boundingBoxHeight, float boundingBoxGrowth, float baseScaleWidth, float baseScaleHeight, float ageScale, float shadowSize, float shadowGrowth) {
        FAFossilVariants.register(bootstrapContext, resourceKey, new FossilVariant(maxSize, FAUtils.resource("textures/entity/" + texture + "/" + texture + "_skeleton.png"), model, fossilCount, FAItemTags.MESOZOIC_FOSSIL, boundingBoxWidth, boundingBoxHeight, boundingBoxGrowth, baseScaleWidth, baseScaleHeight, ageScale, shadowSize, shadowGrowth));
    }

    private static void registerLegacyMesozoic(BootstrapContext<FossilVariant> bootstrapContext, ResourceKey<FossilVariant> resourceKey, int maxSize, String texture, ResourceLocation model, int fossilCount, float boundingBoxWidth, float boundingBoxHeight, float boundingBoxGrowth, float baseScaleWidth, float baseScaleHeight, float ageScale, float shadowSize, float shadowGrowth) {
        FAFossilVariants.register(bootstrapContext, resourceKey, new FossilVariant(maxSize, FAUtils.resource("textures/entity/" + texture + "/legacy/" + texture + "_skeleton.png"), model, fossilCount, FAItemTags.MESOZOIC_FOSSIL, boundingBoxWidth, boundingBoxHeight, boundingBoxGrowth, baseScaleWidth, baseScaleHeight, ageScale, shadowSize, shadowGrowth));
    }

    public static void bootstrap(BootstrapContext<FossilVariant> bootstrapContext) {
        FAFossilVariants.registerMesozoic(bootstrapContext, ANKYLOSAURUS, 8, "ankylosaurus", FAUtils.resource("ankylosaurus"), 5, 1.75F, 1.5F, 0.2F, 1.5F, 1.5F, 0.3F, 1.0F, 0.25F);
        FAFossilVariants.registerMesozoic(bootstrapContext, BRACHIOSAURUS, 36, "brachiosaurus", FAUtils.resource("brachiosaurus"), 9, 1.75F, 2.5F, 0.3F, 1.5F, 1.5F, 0.3F, 1.0F, 0.15F);
        FAFossilVariants.registerLegacyMesozoic(bootstrapContext, LEGACY_BRACHIOSAURUS, 36, "brachiosaurus", FAUtils.resource("legacy_brachiosaurus"), 9, 1.75F, 2.5F, 0.3F, 1.5F, 1.5F, 0.3F, 0.15F, 0.1F);
        FAFossilVariants.registerMesozoic(bootstrapContext, CARNOTAURUS, 8, "carnotaurus", FAUtils.resource("carnotaurus"), 7, 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.4F, 0.75F, 0.1F);
        FAFossilVariants.registerMesozoic(bootstrapContext, COMPSOGNATHUS, 8, "compsognathus", FAUtils.resource("compsognathus"), 3, 0.25F, 0.25F, 0.1F, 0.25F, 0.25F, 0.125F, 0.25F, 0.025F);
        FAFossilVariants.registerMesozoic(bootstrapContext, CRYOLOPHOSAURUS, 8, "cryolophosaurus", FAUtils.resource("cryolophosaurus"), 5, 0.35F, 0.35F, 0.2F, 0.25F, 0.25F, 0.2F, 0.15F, 0.1F);
        FAFossilVariants.registerMesozoic(bootstrapContext, DILOPHOSAURUS, 8, "dilophosaurus", FAUtils.resource("dilophosaurus"), 6, 0.5F, 0.5F, 0.2F, 0.2F, 0.2F, 0.15F, 0.15F, 0.1F);
        FAFossilVariants.registerMesozoic(bootstrapContext, DIMETRODON, 12, "dimetrodon", FAUtils.resource("dimetrodon"), 5, 0.5F, 0.5F, 0.05F, 0.5F, 0.5F, 0.075F, 0.15F, 0.05F);
        FAFossilVariants.registerMesozoic(bootstrapContext, FUTABASAURUS, 12, "futabasaurus", FAUtils.resource("futabasaurus"), 5, 2.0F, 0.75F, 0.25F, 1.5F, 1.5F, 0.3F, 1.0F, 0.15F);
        FAFossilVariants.registerLegacyMesozoic(bootstrapContext, LEGACY_FUTABASAURUS, 12, "futabasaurus", FAUtils.resource("legacy_futabasaurus"), 5, 2.0F, 0.75F, 0.25F, 1.5F, 1.5F, 0.3F, 1.0F, 0.15F);
        FAFossilVariants.registerMesozoic(bootstrapContext, GALLIMIMUS, 8, "gallimimus", FAUtils.resource("gallimimus"), 5, 0.7F, 0.7F, 0.25F, 0.75F, 0.75F, 0.2F, 1.0F, 0.1F);
        FAFossilVariants.registerMesozoic(bootstrapContext, MOSASAURUS, 8, "mosasaurus", FAUtils.resource("mosasaurus"), 6, 0.5F, 0.5F, 0.1F, 0.5F, 0.5F, 0.5125F, 0.5F, 0.1F);
        FAFossilVariants.registerMesozoic(bootstrapContext, PACHYCEPHALOSAURUS, 8, "pachycephalosaurus", FAUtils.resource("pachycephalosaurus"), 5, 0.7F, 0.7F, 0.1F, 1.0F, 1.0F, 0.1F, 0.5F, 0.075F);
        FAFossilVariants.registerMesozoic(bootstrapContext, PTERANODON, 8, "pteranodon", FAUtils.resource("pteranodon"), 5, 0.5F, 0.5F, 0.2F, 0.8F, 0.8F, 0.2F, 0.5F, 0.075F);
        FAFossilVariants.registerLegacyMesozoic(bootstrapContext, LEGACY_PTERANODON, 8, "pteranodon", FAUtils.resource("legacy_pteranodon"), 5, 0.5F, 0.5F, 0.2F, 0.8F, 0.8F, 0.2F, 0.5F, 0.075F);
        FAFossilVariants.registerMesozoic(bootstrapContext, SPINOSAURUS, 8, "spinosaurus", FAUtils.resource("spinosaurus"), 7, 0.5F, 0.5F, 0.4F, 0.5F, 0.5F, 0.5125F, 0.5F, 0.15F);
        FAFossilVariants.registerMesozoic(bootstrapContext, STEGOSAURUS, 12, "stegosaurus", FAUtils.resource("stegosaurus"), 6, 0.5F, 0.5F, 0.4F, 0.5F, 0.5F, 0.5125F, 0.5F, 0.15F);
        FAFossilVariants.registerMesozoic(bootstrapContext, THERIZINOSAURUS, 10, "therizinosaurus", FAUtils.resource("therizinosaurus"), 6, 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.25F, 0.75F, 0.1F);
        FAFossilVariants.registerMesozoic(bootstrapContext, TRICERATOPS, 12, "triceratops", FAUtils.resource("triceratops"), 6, 1.0F, 1.0F, 0.2F, 1.0F, 1.0F, 0.15F, 1.0F, 0.1F);
        FAFossilVariants.registerLegacyMesozoic(bootstrapContext, LEGACY_TRICERATOPS, 12, "triceratops", FAUtils.resource("legacy_triceratops"), 6, 0.75F, 0.75F, 0.15F, 1.5F, 1.5F, 0.3F, 1.0F, 0.1F);
        FAFossilVariants.registerMesozoic(bootstrapContext, TYRANNOSAURUS, 8, "tyrannosaurus", FAUtils.resource("tyrannosaurus"), 7, 0.5F, 0.5F, 0.6F, 0.5F, 0.5F, 0.5125F, 0.75F, 0.15F);
        FAFossilVariants.registerMesozoic(bootstrapContext, VELOCIRAPTOR, 8, "velociraptor", FAUtils.resource("velociraptor"), 3, 0.2F, 0.4F, 0.05F, 0.5F, 0.5F, 0.1F, 0.5F, 0.025F);
    }
}
