package willatendo.fossilslegacy.server.model_type;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAPatternTags;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FAModelTypes {
    public static final ResourceKey<ModelType> ANKYLOSAURUS = FAModelTypes.create("ankylosaurus");
    public static final ResourceKey<ModelType> BARYONYX = FAModelTypes.create("baryonyx");
    public static final ResourceKey<ModelType> BRACHIOSAURUS = FAModelTypes.create("brachiosaurus");
    public static final ResourceKey<ModelType> CARNOTAURUS = FAModelTypes.create("carnotaurus");
    public static final ResourceKey<ModelType> COMPSOGNATHUS = FAModelTypes.create("compsognathus");
    public static final ResourceKey<ModelType> CRYOLOPHOSAURUS = FAModelTypes.create("cryolophosaurus");
    public static final ResourceKey<ModelType> DILOPHOSAURUS = FAModelTypes.create("dilophosaurus");
    public static final ResourceKey<ModelType> DIMETRODON = FAModelTypes.create("dimetrodon");
    public static final ResourceKey<ModelType> DISTORTUS_REX = FAModelTypes.create("distortus_rex");
    public static final ResourceKey<ModelType> DODO = FAModelTypes.create("dodo");
    public static final ResourceKey<ModelType> DRYOSAURUS = FAModelTypes.create("dryosaurus");
    public static final ResourceKey<ModelType> ELASMOTHERIUM = FAModelTypes.create("elasmotherium");
    public static final ResourceKey<ModelType> FUTABASAURUS = FAModelTypes.create("futabasaurus");
    public static final ResourceKey<ModelType> GALLIMIMUS = FAModelTypes.create("gallimimus");
    public static final ResourceKey<ModelType> ICHTHYOSAURUS = FAModelTypes.create("ichthyosaurus");
    public static final ResourceKey<ModelType> MAMMOTH = FAModelTypes.create("mammoth");
    public static final ResourceKey<ModelType> MOA = FAModelTypes.create("moa");
    public static final ResourceKey<ModelType> MOSASAURUS = FAModelTypes.create("mosasaurus");
    public static final ResourceKey<ModelType> PACHYCEPHALOSAURUS = FAModelTypes.create("pachycephalosaurus");
    public static final ResourceKey<ModelType> PTERANODON = FAModelTypes.create("pteranodon");
    public static final ResourceKey<ModelType> SMILODON = FAModelTypes.create("smilodon");
    public static final ResourceKey<ModelType> SPINOSAURUS = FAModelTypes.create("spinosaurus");
    public static final ResourceKey<ModelType> STEGOSAURUS = FAModelTypes.create("stegosaurus");
    public static final ResourceKey<ModelType> THERIZINOSAURUS = FAModelTypes.create("therizinosaurus");
    public static final ResourceKey<ModelType> TRICERATOPS = FAModelTypes.create("triceratops");
    public static final ResourceKey<ModelType> TYRANNOSAURUS = FAModelTypes.create("tyrannosaurus");
    public static final ResourceKey<ModelType> VELOCIRAPTOR = FAModelTypes.create("velociraptor");

    public static final ResourceKey<ModelType> LEGACY_BRACHIOSAURUS = FAModelTypes.create("legacy_brachiosaurus");
    public static final ResourceKey<ModelType> LEGACY_CARNOTAURUS = FAModelTypes.create("legacy_carnotaurus");
    public static final ResourceKey<ModelType> LEGACY_CRYOLOPHOSAURUS = FAModelTypes.create("legacy_cryolophosaurus");
    public static final ResourceKey<ModelType> LEGACY_DILOPHOSAURUS = FAModelTypes.create("legacy_dilophosaurus");
    public static final ResourceKey<ModelType> LEGACY_FUTABASAURUS = FAModelTypes.create("legacy_futabasaurus");
    public static final ResourceKey<ModelType> LEGACY_MAMMOTH = FAModelTypes.create("legacy_mammoth");
    public static final ResourceKey<ModelType> LEGACY_MOSASAURUS = FAModelTypes.create("legacy_mosasaurus");
    public static final ResourceKey<ModelType> LEGACY_PTERANODON = FAModelTypes.create("legacy_pteranodon");
    public static final ResourceKey<ModelType> LEGACY_SMILODON = FAModelTypes.create("legacy_smilodon");
    public static final ResourceKey<ModelType> LEGACY_STEGOSAURUS = FAModelTypes.create("legacy_stegosaurus");
    public static final ResourceKey<ModelType> LEGACY_THERIZINOSAURUS = FAModelTypes.create("legacy_therizinosaurus");
    public static final ResourceKey<ModelType> LEGACY_TRICERATOPS = FAModelTypes.create("legacy_triceratops");
    public static final ResourceKey<ModelType> LEGACY_TYRANNOSAURUS = FAModelTypes.create("legacy_tyrannosaurus");
    public static final ResourceKey<ModelType> LEGACY_VELOCIRAPTOR = FAModelTypes.create("legacy_velociraptor");

    private static ResourceKey<ModelType> create(String name) {
        return ResourceKey.create(FARegistries.MODEL_TYPES, FAUtils.resource(name));
    }

    private static void register(BootstrapContext<ModelType> bootstrapContext, ResourceKey<ModelType> resourceKey, ModelType modelType) {
        bootstrapContext.register(resourceKey, modelType);
    }

    public static void bootstrap(BootstrapContext<ModelType> bootstrapContext) {
        FAModelTypes.register(bootstrapContext, ANKYLOSAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.ankylosaurus"), 0x533A1B, 1.0F, 0.0F, FAUtils.resource("ankylosaurus"), FAPatternTags.ANKYLOSAURUS_2024_SKINS, FAPatternTags.ANKYLOSAURUS_2024_PATTERNS, 1.75F, 1.5F, 0.2F, 1.5F, 1.5F, 0.3F, 0.75F, 0.25F).build());
        FAModelTypes.register(bootstrapContext, BARYONYX, ModelType.build(Component.translatable("model_type.fossilslegacy.baryonyx"), 0x3C3F56, 1.0F, 0.0F, FAUtils.resource("baryonyx"), FAPatternTags.BARYONYX_2025_SKINS, FAPatternTags.BARYONYX_2025_PATTERNS, 0.5F, 0.5F, 0.4F, 0.5F, 0.5F, 0.35F, 0.25F, 0.15F).build());
        FAModelTypes.register(bootstrapContext, BRACHIOSAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.brachiosaurus"), 0x3C3F56, 0.2F, 15.0F, FAUtils.resource("brachiosaurus"), FAPatternTags.BRACHIOSAURUS_2024_SKINS, FAPatternTags.BRACHIOSAURUS_2024_PATTERNS, 1.75F, 2.5F, 0.3F, 1.5F, 1.5F, 0.4F, 0.75F, 0.15F).build());
        FAModelTypes.register(bootstrapContext, CARNOTAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.carnotaurus"), 0x485039, 1.0F, 0.0F, FAUtils.resource("carnotaurus"), FAPatternTags.CARNOTAURUS_2024_SKINS, FAPatternTags.CARNOTAURUS_2024_PATTERNS, 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.4F, 0.25F, 0.1F).build());
        FAModelTypes.register(bootstrapContext, COMPSOGNATHUS, ModelType.build(Component.translatable("model_type.fossilslegacy.compsognathus"), 0x213D20, 5.0F, -1.0F, FAUtils.resource("compsognathus"), FAPatternTags.COMPSOGNATHUS_2024_SKINS, FAPatternTags.COMPSOGNATHUS_2024_PATTERNS, 0.25F, 0.25F, 0.1F, 0.25F, 0.25F, 0.125F, 0.05F, 0.025F).build());
        FAModelTypes.register(bootstrapContext, CRYOLOPHOSAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.cryolophosaurus"), 0x49658B, 2.0F, -0.2F, FAUtils.resource("cryolophosaurus"), FAPatternTags.CRYOLOPHOSAURUS_2024_SKINS, FAPatternTags.CRYOLOPHOSAURUS_2024_PATTERNS, 0.35F, 0.35F, 0.2F, 0.25F, 0.25F, 0.2F, 0.15F, 0.1F).build());
        FAModelTypes.register(bootstrapContext, DILOPHOSAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.dilophosaurus"), 0x736F4A, 3.0F, -0.5F, FAUtils.resource("dilophosaurus"), FAPatternTags.DILOPHOSAURUS_2024_SKINS, FAPatternTags.DILOPHOSAURUS_2024_PATTERNS, 0.5F, 0.5F, 0.2F, 0.2F, 0.2F, 0.15F, 0.15F, 0.1F).build());
        FAModelTypes.register(bootstrapContext, DIMETRODON, ModelType.build(Component.translatable("model_type.fossilslegacy.dimetrodon"), 0x251A22, 3.0F, -1.25F, FAUtils.resource("dimetrodon"), FAPatternTags.DIMETRODON_2024_SKINS, FAPatternTags.DIMETRODON_2024_PATTERNS, 0.5F, 0.5F, 0.05F, 0.5F, 0.5F, 0.075F, 0.15F, 0.05F).build());
        FAModelTypes.register(bootstrapContext, DISTORTUS_REX, ModelType.build(Component.translatable("model_type.fossilslegacy.distortus_rex"), 0x80643A, 3.0F, -1.25F, FAUtils.resource("distortus_rex"), FAPatternTags.DISTORTUS_REX_2025_SKINS, FAPatternTags.DISTORTUS_REX_2025_PATTERNS, 1.0F, 1.15F, 0.75F, 0.5F, 0.5F, 0.35F, 0.5F, 0.5F).build());
        FAModelTypes.register(bootstrapContext, DODO, ModelType.build(Component.translatable("model_type.fossilslegacy.dodo"), 0x5A5A5A, 5.0F, -1.0F, FAUtils.resource("dodo"), FAPatternTags.DODO_2024_SKINS, FAPatternTags.DODO_2024_PATTERNS, 0.5F, 0.5F, 0.05F, 0.5F, 0.5F, 0.07142857142F, 0.15F, 0.05F).build());
        FAModelTypes.register(bootstrapContext, DRYOSAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.dryosaurus"), 0x5A5A5A, 3.0F, -0.75F, FAUtils.resource("dryosaurus"), FAPatternTags.DRYOSAURUS_2025_SKINS, FAPatternTags.DRYOSAURUS_2025_PATTERNS, 0.4F, 0.4F, 0.1F, 0.5F, 0.5F, 0.15F, 0.15F, 0.05F).build());
        FAModelTypes.register(bootstrapContext, ELASMOTHERIUM, ModelType.build(Component.translatable("model_type.fossilslegacy.elasmotherium"), 0xB92200, 2.0F, -0.5F, FAUtils.resource("elasmotherium"), FAPatternTags.ELASMOTHERIUM_2025_SKINS, FAPatternTags.ELASMOTHERIUM_2025_PATTERNS, 1.0F, 1.0F, 0.15F, 0.8F, 0.8F, 0.15F, 0.5F, 0.15F).build());
        FAModelTypes.register(bootstrapContext, FUTABASAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.futabasaurus"), 0xB92200, 0.5F, 0.25F, FAUtils.resource("futabasaurus"), FAPatternTags.FUTABASAURUS_2024_SKINS, FAPatternTags.FUTABASAURUS_2024_PATTERNS, 2.0F, 0.75F, 0.25F, 1.5F, 1.5F, 0.3F, 0.15F, 0.15F).build());
        FAModelTypes.register(bootstrapContext, GALLIMIMUS, ModelType.build(Component.translatable("model_type.fossilslegacy.gallimimus"), 0x774913, 1.75F, 1.0F, FAUtils.resource("gallimimus"), FAPatternTags.GALLIMIMUS_2024_SKINS, FAPatternTags.GALLIMIMUS_2024_PATTERNS, 0.7F, 0.7F, 0.25F, 0.75F, 0.75F, 0.2F, 0.25F, 0.1F).build());
        FAModelTypes.register(bootstrapContext, ICHTHYOSAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.ichthyosaurus"), 0x383C4F, 3.0F, -1.0F, FAUtils.resource("ichthyosaurus"), FAPatternTags.ICHTHYOSAURUS_2025_SKINS, FAPatternTags.ICHTHYOSAURUS_2025_PATTERNS, 0.7F, 0.5F, 0.25F, 0.75F, 0.75F, 0.1F, 0.35F, 0.1F).build());
        FAModelTypes.register(bootstrapContext, MAMMOTH, ModelType.build(Component.translatable("model_type.fossilslegacy.mammoth"), 0x3D2700, 1.0F, 1.0F, FAUtils.resource("mammoth"), FAPatternTags.MAMMOTH_2024_SKINS, FAPatternTags.MAMMOTH_2024_PATTERNS, 0.7F, 0.7F, 0.5F, 1.0F, 1.0F, 0.4F, 0.75F, 0.15F).build());
        FAModelTypes.register(bootstrapContext, MOSASAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.mosasaurus"), 0x0D7346, 0.9F, 0.25F, FAUtils.resource("mosasaurus"), FAPatternTags.MOSASAURUS_2024_SKINS, FAPatternTags.MOSASAURUS_2024_PATTERNS, 0.5F, 0.5F, 0.1F, 0.5F, 0.5F, 0.5125F, 0.35F, 0.3F).build());
        FAModelTypes.register(bootstrapContext, MOA, ModelType.build(Component.translatable("model_type.fossilslegacy.moa"), 0x352A17, 2.0F, 1.0F, FAUtils.resource("moa"), FAPatternTags.MOA_2024_SKINS, FAPatternTags.MOA_2024_PATTERNS, 0.5F, 1.5F, 0.1F, 0.5F, 0.5F, 0.25F, 0.15F, 0.1F).build());
        FAModelTypes.register(bootstrapContext, PACHYCEPHALOSAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.pachycephalosaurus"), 0xC06929, 2.25F, -0.5F, FAUtils.resource("pachycephalosaurus"), FAPatternTags.PACHYCEPHALOSAURUS_2024_SKINS, FAPatternTags.PACHYCEPHALOSAURUS_2024_PATTERNS, 0.7F, 0.7F, 0.1F, 1.0F, 1.0F, 0.1F, 0.35F, 0.075F).build());
        FAModelTypes.register(bootstrapContext, PTERANODON, ModelType.build(Component.translatable("model_type.fossilslegacy.pteranodon"), 0x7C5D89, 1.5F, 0.0F, FAUtils.resource("pteranodon"), FAPatternTags.PTERANODON_2024_SKINS, FAPatternTags.PTERANODON_2024_PATTERNS, 0.5F, 0.5F, 0.2F, 0.8F, 0.8F, 0.2F, 0.35F, 0.075F).build());
        FAModelTypes.register(bootstrapContext, SMILODON, ModelType.build(Component.translatable("model_type.fossilslegacy.smilodon"), 0xEFA745, 3.0F, -0.25F, FAUtils.resource("smilodon"), FAPatternTags.SMILODON_2024_SKINS, FAPatternTags.SMILODON_2024_PATTERNS, 0.75F, 0.75F, 0.1F, 0.7F, 0.7F, 0.1F, 0.5F, 0.05F).build());
        FAModelTypes.register(bootstrapContext, SPINOSAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.spinosaurus"), 0x26261D, 0.75F, 2.0F, FAUtils.resource("spinosaurus"), FAPatternTags.SPINOSAURUS_2024_SKINS, FAPatternTags.SPINOSAURUS_2024_PATTERNS, 0.5F, 0.5F, 0.4F, 0.5F, 0.5F, 0.5125F, 0.25F, 0.15F).build());
        FAModelTypes.register(bootstrapContext, STEGOSAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.stegosaurus"), 0x8BE400, 1.0F, 0.5F, FAUtils.resource("stegosaurus"), FAPatternTags.STEGOSAURUS_2024_SKINS, FAPatternTags.STEGOSAURUS_2024_PATTERNS, 0.75F, 0.75F, 0.2F, 0.8F, 0.8F, 0.2F, 0.5F, 0.1F).build());
        FAModelTypes.register(bootstrapContext, THERIZINOSAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.therizinosaurus"), 0xCE551D, 1.25F, 1.0F, FAUtils.resource("therizinosaurus"), FAPatternTags.THERIZINOSAURUS_2024_SKINS, FAPatternTags.THERIZINOSAURUS_2024_PATTERNS, 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.25F, 0.25F, 0.1F).build());
        FAModelTypes.register(bootstrapContext, TRICERATOPS, ModelType.build(Component.translatable("model_type.fossilslegacy.triceratops"), 0xADE642, 1.0F, 0.0F, FAUtils.resource("triceratops"), FAPatternTags.TRICERATOPS_2024_SKINS, FAPatternTags.TRICERATOPS_2024_PATTERNS, 1.0F, 1.0F, 0.2F, 1.0F, 1.0F, 0.15F, 0.5F, 0.1F).build());
        FAModelTypes.register(bootstrapContext, TYRANNOSAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.tyrannosaurus"), 0x918066, 0.75F, 0.0F, FAUtils.resource("tyrannosaurus"), FAPatternTags.TYRANNOSAURUS_2024_SKINS, FAPatternTags.TYRANNOSAURUS_2024_PATTERNS, 0.5F, 0.5F, 0.6F, 0.5F, 0.5F, 0.5125F, 0.25F, 0.15F).withKnockoutModel(FAUtils.resource("knocked_out_tyrannosaurus")).build());
        FAModelTypes.register(bootstrapContext, VELOCIRAPTOR, ModelType.build(Component.translatable("model_type.fossilslegacy.velociraptor"), 0x0C3F4C, 4.0F, -0.75F, FAUtils.resource("velociraptor"), FAPatternTags.VELOCIRAPTOR_2024_SKINS, FAPatternTags.VELOCIRAPTOR_2024_PATTERNS, 0.2F, 0.4F, 0.05F, 0.5F, 0.5F, 0.1F, 0.15F, 0.025F).build());

        FAModelTypes.register(bootstrapContext, LEGACY_BRACHIOSAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.legacy_brachiosaurus"), 0x363950, 0.35F, 8.0F, FAUtils.resource("legacy_brachiosaurus"), FAPatternTags.BRACHIOSAURUS_2011_SKINS, FAPatternTags.BRACHIOSAURUS_2011_PATTERNS, 1.75F, 2.5F, 0.3F, 1.5F, 1.5F, 0.3F, 0.75F, 0.1F).build());
        FAModelTypes.register(bootstrapContext, LEGACY_CARNOTAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.legacy_carnotaurus"), 0x485039, 1.0F, 0.0F, FAUtils.resource("legacy_carnotaurus"), FAPatternTags.CARNOTAURUS_2011_SKINS, FAPatternTags.CARNOTAURUS_2011_PATTERNS, 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.3F, 0.75F, 0.1F).build());
        FAModelTypes.register(bootstrapContext, LEGACY_CRYOLOPHOSAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.legacy_cryolophosaurus"), 0x49658B, 2.0F, -0.2F, FAUtils.resource("legacy_cryolophosaurus"), FAPatternTags.CRYOLOPHOSAURUS_2011_SKINS, FAPatternTags.CRYOLOPHOSAURUS_2011_PATTERNS, 0.35F, 0.35F, 0.2F, 0.25F, 0.25F, 0.2F, 0.15F, 0.1F).build());
        FAModelTypes.register(bootstrapContext, LEGACY_DILOPHOSAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.legacy_dilophosaurus"), 0x736F4A, 3.0F, -0.5F, FAUtils.resource("legacy_dilophosaurus"), FAPatternTags.DILOPHOSAURUS_2011_SKINS, FAPatternTags.DILOPHOSAURUS_2011_PATTERNS, 0.5F, 0.5F, 0.2F, 0.2F, 0.2F, 0.15F, 0.15F, 0.1F).build());
        FAModelTypes.register(bootstrapContext, LEGACY_FUTABASAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.legacy_futabasaurus"), 0xC75B00, 1.0F, 0.25F, FAUtils.resource("legacy_futabasaurus"), FAPatternTags.FUTABASAURUS_2011_SKINS, FAPatternTags.FUTABASAURUS_2011_PATTERNS, 0.75F, 0.75F, 0.2F, 1.5F, 1.5F, 0.3F, 0.75F, 0.15F).build());
        FAModelTypes.register(bootstrapContext, LEGACY_MAMMOTH, ModelType.build(Component.translatable("model_type.fossilslegacy.legacy_mammoth"), 0x3D2700, 1.25F, 0.25F, FAUtils.resource("legacy_mammoth"), FAPatternTags.MAMMOTH_2011_SKINS, FAPatternTags.MAMMOTH_2011_PATTERNS, 0.7F, 0.7F, 0.5F, 1.0F, 1.0F, 0.625F, 0.75F, 0.15F).build());
        FAModelTypes.register(bootstrapContext, LEGACY_MOSASAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.legacy_mosasaurus"), 0x0D7346, 1.0F, 0.25F, FAUtils.resource("legacy_mosasaurus"), FAPatternTags.MOSASAURUS_2011_SKINS, FAPatternTags.MOSASAURUS_2011_PATTERNS, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.5125F, 0.5F, 0.1F).build());
        FAModelTypes.register(bootstrapContext, LEGACY_PTERANODON, ModelType.build(Component.translatable("model_type.fossilslegacy.legacy_pteranodon"), 0x7C5D89, 1.5F, 0.0F, FAUtils.resource("legacy_pteranodon"), FAPatternTags.PTERANODON_2011_SKINS, FAPatternTags.PTERANODON_2011_PATTERNS, 0.5F, 0.5F, 0.2F, 0.8F, 0.8F, 0.2F, 0.35F, 0.075F).withFlyingModels(FAUtils.resource("legacy_flying_pteranodon"), FAUtils.resource("legacy_landing_pteranodon")).build());
        FAModelTypes.register(bootstrapContext, LEGACY_SMILODON, ModelType.build(Component.translatable("model_type.fossilslegacy.legacy_smilodon"), 0xEFA745, 3.0F, -0.25F, FAUtils.resource("legacy_smilodon"), FAPatternTags.SMILODON_2011_SKINS, FAPatternTags.SMILODON_2011_PATTERNS, 0.75F, 0.75F, 0.1F, 1.0F, 1.0F, 0.14285714285F, 0.5F, 0.05F).build());
        FAModelTypes.register(bootstrapContext, LEGACY_STEGOSAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.legacy_stegosaurus"), 0x8BE400, 1.0F, 0.0F, FAUtils.resource("legacy_stegosaurus"), FAPatternTags.STEGOSAURUS_2011_SKINS, FAPatternTags.STEGOSAURUS_2011_PATTERNS, 0.75F, 0.75F, 0.2F, 1.5F, 1.5F, 0.3F, 1.0F, 0.1F).build());
        FAModelTypes.register(bootstrapContext, LEGACY_THERIZINOSAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.legacy_therizinosaurus"), 0xCE551D, 0.9F, 1.0F, FAUtils.resource("legacy_therizinosaurus"), FAPatternTags.THERIZINOSAURUS_2011_SKINS, FAPatternTags.THERIZINOSAURUS_2011_PATTERNS, 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.35F, 0.75F, 0.1F).build());
        FAModelTypes.register(bootstrapContext, LEGACY_TRICERATOPS, ModelType.build(Component.translatable("model_type.fossilslegacy.legacy_triceratops"), 0xB6EF4B, 1.0F, 0.0F, FAUtils.resource("legacy_triceratops"), FAPatternTags.TRICERATOPS_2011_SKINS, FAPatternTags.TRICERATOPS_2011_PATTERNS, 0.75F, 0.75F, 0.15F, 1.5F, 1.5F, 0.3F, 1.0F, 0.1F).build());
        FAModelTypes.register(bootstrapContext, LEGACY_TYRANNOSAURUS, ModelType.build(Component.translatable("model_type.fossilslegacy.legacy_tyrannosaurus"), 0x918066, 0.75F, 0.0F, FAUtils.resource("legacy_tyrannosaurus"), FAPatternTags.TYRANNOSAURUS_2011_SKINS, FAPatternTags.TYRANNOSAURUS_2011_PATTERNS, 0.5F, 0.5F, 0.6F, 0.5F, 0.5F, 0.5125F, 0.75F, 0.15F).withKnockoutModel(FAUtils.resource("legacy_knocked_out_tyrannosaurus")).build());
        FAModelTypes.register(bootstrapContext, LEGACY_VELOCIRAPTOR, ModelType.build(Component.translatable("model_type.fossilslegacy.legacy_velociraptor"), 0x71A367, 4.0F, -0.75F, FAUtils.resource("legacy_velociraptor"), FAPatternTags.VELOCIRAPTOR_2011_SKINS, FAPatternTags.VELOCIRAPTOR_2011_PATTERNS, 0.3F, 0.3F, 0.1F, 0.2F, 0.32F, 0.1F, 0.35F, 0.05F).build());
    }
}
