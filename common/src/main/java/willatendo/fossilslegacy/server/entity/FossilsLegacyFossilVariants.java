package willatendo.fossilslegacy.server.entity;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.tags.FossilsLegacyItemTags;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

public class FossilsLegacyFossilVariants {
    public static final ResourceKey<FossilVariant> ANKYLOSAURUS = FossilsLegacyFossilVariants.create("ankylosaurus");
    public static final ResourceKey<FossilVariant> BRACHIOSAURUS = FossilsLegacyFossilVariants.create("brachiosaurus");
    public static final ResourceKey<FossilVariant> LEGACY_BRACHIOSAURUS = FossilsLegacyFossilVariants.create("legacy_brachiosaurus");
    public static final ResourceKey<FossilVariant> CARNOTAURUS = FossilsLegacyFossilVariants.create("carnotaurus");
    public static final ResourceKey<FossilVariant> COMPSOGNATHUS = FossilsLegacyFossilVariants.create("compsognathus");
    public static final ResourceKey<FossilVariant> CRYOLOPHOSAURUS = FossilsLegacyFossilVariants.create("cryolophosaurus");
    public static final ResourceKey<FossilVariant> FUTABASAURUS = FossilsLegacyFossilVariants.create("futabasaurus");
    public static final ResourceKey<FossilVariant> LEGACY_FUTABASAURUS = FossilsLegacyFossilVariants.create("legacy_futabasaurus");
    public static final ResourceKey<FossilVariant> GALLIMIMUS = FossilsLegacyFossilVariants.create("gallimimus");
    public static final ResourceKey<FossilVariant> PACHYCEPHALOSAURUS = FossilsLegacyFossilVariants.create("pachycephalosaurus");
    public static final ResourceKey<FossilVariant> PTERANODON = FossilsLegacyFossilVariants.create("pteranodon");
    public static final ResourceKey<FossilVariant> LEGACY_PTERANODON = FossilsLegacyFossilVariants.create("legacy_pteranodon");
    public static final ResourceKey<FossilVariant> SPINOSAURUS = FossilsLegacyFossilVariants.create("spinosaurus");
    public static final ResourceKey<FossilVariant> STEGOSAURUS = FossilsLegacyFossilVariants.create("stegosaurus");
    public static final ResourceKey<FossilVariant> THERIZINOSAURUS = FossilsLegacyFossilVariants.create("therizinosaurus");
    public static final ResourceKey<FossilVariant> TRICERATOPS = FossilsLegacyFossilVariants.create("triceratops");
    public static final ResourceKey<FossilVariant> TYRANNOSAURUS = FossilsLegacyFossilVariants.create("tyrannosaurus");
    public static final ResourceKey<FossilVariant> LEGACY_TRICERATOPS = FossilsLegacyFossilVariants.create("legacy_triceratops");
    public static final ResourceKey<FossilVariant> VELOCIRAPTOR = FossilsLegacyFossilVariants.create("velociraptor");

    private static ResourceKey<FossilVariant> create(String name) {
        return ResourceKey.create(FossilsLegacyRegistries.FOSSIL_VARIANTS, FossilsLegacyUtils.resource(name));
    }

    private static void register(BootstrapContext<FossilVariant> bootstrapContext, ResourceKey<FossilVariant> resourceKey, FossilVariant fossilVariant) {
        bootstrapContext.register(resourceKey, fossilVariant);
    }

    private static void registerMesozoic(BootstrapContext<FossilVariant> bootstrapContext, ResourceKey<FossilVariant> resourceKey, int maxSize, String texture, ResourceLocation model, int fossilCount, float boundingBoxWidth, float boundingBoxHeight, float boundingBoxGrowth, float baseScaleWidth, float baseScaleHeight, float ageScale, float shadowSize, float shadowGrowth) {
        FossilsLegacyFossilVariants.register(bootstrapContext, resourceKey, new FossilVariant(maxSize, FossilsLegacyUtils.resource("textures/entity/" + texture + "/" + texture + "_skeleton.png"), model, fossilCount, FossilsLegacyItemTags.MESOZOIC_FOSSIL, boundingBoxWidth, boundingBoxHeight, boundingBoxGrowth, baseScaleWidth, baseScaleHeight, ageScale, shadowSize, shadowGrowth));
    }

    private static void registerLegacyMesozoic(BootstrapContext<FossilVariant> bootstrapContext, ResourceKey<FossilVariant> resourceKey, int maxSize, String texture, ResourceLocation model, int fossilCount, float boundingBoxWidth, float boundingBoxHeight, float boundingBoxGrowth, float baseScaleWidth, float baseScaleHeight, float ageScale, float shadowSize, float shadowGrowth) {
        FossilsLegacyFossilVariants.register(bootstrapContext, resourceKey, new FossilVariant(maxSize, FossilsLegacyUtils.resource("textures/entity/" + texture + "/legacy/" + texture + "_skeleton.png"), model, fossilCount, FossilsLegacyItemTags.MESOZOIC_FOSSIL, boundingBoxWidth, boundingBoxHeight, boundingBoxGrowth, baseScaleWidth, baseScaleHeight, ageScale, shadowSize, shadowGrowth));
    }

    public static void bootstrap(BootstrapContext<FossilVariant> bootstrapContext) {
        FossilsLegacyFossilVariants.registerMesozoic(bootstrapContext, ANKYLOSAURUS, 8, "ankylosaurus", FossilsLegacyUtils.resource("ankylosaurus"), 5, 1.75F, 1.5F, 0.2F, 1.5F, 1.5F, 0.3F, 1.0F, 0.25F);
        FossilsLegacyFossilVariants.registerMesozoic(bootstrapContext, BRACHIOSAURUS, 36, "brachiosaurus", FossilsLegacyUtils.resource("brachiosaurus"), 9, 1.75F, 2.5F, 0.3F, 1.5F, 1.5F, 0.3F, 1.0F, 0.15F);
        FossilsLegacyFossilVariants.registerLegacyMesozoic(bootstrapContext, LEGACY_BRACHIOSAURUS, 36, "brachiosaurus", FossilsLegacyUtils.resource("legacy_brachiosaurus"), 9, 1.75F, 2.5F, 0.3F, 1.5F, 1.5F, 0.3F, 0.15F, 0.1F);
        FossilsLegacyFossilVariants.registerMesozoic(bootstrapContext, CARNOTAURUS, 8, "carnotaurus", FossilsLegacyUtils.resource("carnotaurus"), 7, 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.4F, 0.75F, 0.1F);
        FossilsLegacyFossilVariants.registerMesozoic(bootstrapContext, COMPSOGNATHUS, 8, "compsognathus", FossilsLegacyUtils.resource("compsognathus"), 3, 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.4F, 0.75F, 0.1F);
        FossilsLegacyFossilVariants.registerMesozoic(bootstrapContext, CRYOLOPHOSAURUS, 8, "cryolophosaurus", FossilsLegacyUtils.resource("cryolophosaurus"), 5, 0.35F, 0.35F, 0.2F, 0.25F, 0.25F, 0.2F, 0.15F, 0.1F);
        FossilsLegacyFossilVariants.registerMesozoic(bootstrapContext, FUTABASAURUS, 12, "futabasaurus", FossilsLegacyUtils.resource("futabasaurus"), 5, 2.0F, 0.75F, 0.25F, 1.5F, 1.5F, 0.3F, 1.0F, 0.15F);
        FossilsLegacyFossilVariants.registerLegacyMesozoic(bootstrapContext, LEGACY_FUTABASAURUS, 12, "futabasaurus", FossilsLegacyUtils.resource("legacy_futabasaurus"), 5, 2.0F, 0.75F, 0.25F, 1.5F, 1.5F, 0.3F, 1.0F, 0.15F);
        FossilsLegacyFossilVariants.registerMesozoic(bootstrapContext, GALLIMIMUS, 8, "gallimimus", FossilsLegacyUtils.resource("gallimimus"), 5, 0.7F, 0.7F, 0.25F, 0.75F, 0.75F, 0.2F, 1.0F, 0.1F);
        FossilsLegacyFossilVariants.registerMesozoic(bootstrapContext, PACHYCEPHALOSAURUS, 8, "pachycephalosaurus", FossilsLegacyUtils.resource("pachycephalosaurus"), 5, 0.7F, 0.7F, 0.1F, 1.0F, 1.0F, 0.1F, 0.5F, 0.075F);
        FossilsLegacyFossilVariants.registerMesozoic(bootstrapContext, PTERANODON, 8, "pteranodon", FossilsLegacyUtils.resource("pteranodon"), 5, 0.5F, 0.5F, 0.2F, 0.8F, 0.8F, 0.2F, 0.5F, 0.075F);
        FossilsLegacyFossilVariants.registerLegacyMesozoic(bootstrapContext, LEGACY_PTERANODON, 8, "pteranodon", FossilsLegacyUtils.resource("legacy_pteranodon"), 5, 0.5F, 0.5F, 0.2F, 0.8F, 0.8F, 0.2F, 0.5F, 0.075F);
        FossilsLegacyFossilVariants.registerMesozoic(bootstrapContext, SPINOSAURUS, 8, "spinosaurus", FossilsLegacyUtils.resource("spinosaurus"), 7, 0.5F, 0.5F, 0.4F, 0.5F, 0.5F, 0.5125F, 0.5F, 0.15F);
        FossilsLegacyFossilVariants.registerMesozoic(bootstrapContext, STEGOSAURUS, 12, "stegosaurus", FossilsLegacyUtils.resource("stegosaurus"), 6, 0.5F, 0.5F, 0.4F, 0.5F, 0.5F, 0.5125F, 0.5F, 0.15F);
        FossilsLegacyFossilVariants.registerMesozoic(bootstrapContext, THERIZINOSAURUS, 10, "therizinosaurus", FossilsLegacyUtils.resource("therizinosaurus"), 6, 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.25F, 0.75F, 0.1F);
        FossilsLegacyFossilVariants.registerMesozoic(bootstrapContext, TRICERATOPS, 12, "triceratops", FossilsLegacyUtils.resource("triceratops"), 6, 0.75F, 0.75F, 0.2F, 1.5F, 1.5F, 0.3F, 1.0F, 0.1F);
        FossilsLegacyFossilVariants.registerLegacyMesozoic(bootstrapContext, LEGACY_TRICERATOPS, 12, "triceratops", FossilsLegacyUtils.resource("legacy_triceratops"), 6, 0.75F, 0.75F, 0.15F, 1.5F, 1.5F, 0.3F, 1.0F, 0.1F);
        FossilsLegacyFossilVariants.registerMesozoic(bootstrapContext, TYRANNOSAURUS, 8, "tyrannosaurus", FossilsLegacyUtils.resource("tyrannosaurus"), 7, 0.5F, 0.5F, 0.6F, 0.5F, 0.5F, 0.5125F, 0.75F, 0.15F);
        FossilsLegacyFossilVariants.registerMesozoic(bootstrapContext, VELOCIRAPTOR, 8, "velociraptor", FossilsLegacyUtils.resource("velociraptor"), 3, 0.2F, 0.4F, 0.05F, 0.5F, 0.5F, 0.1F, 0.5F, 0.025F);
    }
}
