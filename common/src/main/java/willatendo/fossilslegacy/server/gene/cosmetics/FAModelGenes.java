package willatendo.fossilslegacy.server.gene.cosmetics;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAPatternGeneTags;
import willatendo.fossilslegacy.server.tags.FASkinGeneTags;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FAModelGenes {
    public static final ResourceKey<ModelGene> ANKYLOSAURUS = FAModelGenes.create("ankylosaurus");
    public static final ResourceKey<ModelGene> BARYONYX = FAModelGenes.create("baryonyx");
    public static final ResourceKey<ModelGene> BRACHIOSAURUS = FAModelGenes.create("brachiosaurus");
    public static final ResourceKey<ModelGene> CARNOTAURUS = FAModelGenes.create("carnotaurus");
    public static final ResourceKey<ModelGene> COMPSOGNATHUS = FAModelGenes.create("compsognathus");
    public static final ResourceKey<ModelGene> CRYOLOPHOSAURUS = FAModelGenes.create("cryolophosaurus");
    public static final ResourceKey<ModelGene> DILOPHOSAURUS = FAModelGenes.create("dilophosaurus");
    public static final ResourceKey<ModelGene> DIMETRODON = FAModelGenes.create("dimetrodon");
    public static final ResourceKey<ModelGene> DISTORTUS_REX = FAModelGenes.create("distortus_rex");
    public static final ResourceKey<ModelGene> DODO = FAModelGenes.create("dodo");
    public static final ResourceKey<ModelGene> DRYOSAURUS = FAModelGenes.create("dryosaurus");
    public static final ResourceKey<ModelGene> ELASMOTHERIUM = FAModelGenes.create("elasmotherium");
    public static final ResourceKey<ModelGene> FUTABASAURUS = FAModelGenes.create("futabasaurus");
    public static final ResourceKey<ModelGene> GALLIMIMUS = FAModelGenes.create("gallimimus");
    public static final ResourceKey<ModelGene> ICHTHYOSAURUS = FAModelGenes.create("ichthyosaurus");
    public static final ResourceKey<ModelGene> ISOTELUS = FAModelGenes.create("isotelus");
    public static final ResourceKey<ModelGene> ISOTELUS_LARVA = FAModelGenes.create("isotelus_larva");
    public static final ResourceKey<ModelGene> MAMMOTH = FAModelGenes.create("mammoth");
    public static final ResourceKey<ModelGene> MOA = FAModelGenes.create("moa");
    public static final ResourceKey<ModelGene> MOSASAURUS = FAModelGenes.create("mosasaurus");
    public static final ResourceKey<ModelGene> PACHYCEPHALOSAURUS = FAModelGenes.create("pachycephalosaurus");
    public static final ResourceKey<ModelGene> PTERANODON = FAModelGenes.create("pteranodon");
    public static final ResourceKey<ModelGene> SMILODON = FAModelGenes.create("smilodon");
    public static final ResourceKey<ModelGene> SPINOSAURUS = FAModelGenes.create("spinosaurus");
    public static final ResourceKey<ModelGene> STEGOSAURUS = FAModelGenes.create("stegosaurus");
    public static final ResourceKey<ModelGene> THERIZINOSAURUS = FAModelGenes.create("therizinosaurus");
    public static final ResourceKey<ModelGene> TRICERATOPS = FAModelGenes.create("triceratops");
    public static final ResourceKey<ModelGene> TYRANNOSAURUS = FAModelGenes.create("tyrannosaurus");
    public static final ResourceKey<ModelGene> VELOCIRAPTOR = FAModelGenes.create("velociraptor");

    public static final ResourceKey<ModelGene> LEGACY_BRACHIOSAURUS = FAModelGenes.create("legacy_brachiosaurus");
    public static final ResourceKey<ModelGene> LEGACY_CARNOTAURUS = FAModelGenes.create("legacy_carnotaurus");
    public static final ResourceKey<ModelGene> LEGACY_CRYOLOPHOSAURUS = FAModelGenes.create("legacy_cryolophosaurus");
    public static final ResourceKey<ModelGene> LEGACY_DILOPHOSAURUS = FAModelGenes.create("legacy_dilophosaurus");
    public static final ResourceKey<ModelGene> LEGACY_FUTABASAURUS = FAModelGenes.create("legacy_futabasaurus");
    public static final ResourceKey<ModelGene> LEGACY_MAMMOTH = FAModelGenes.create("legacy_mammoth");
    public static final ResourceKey<ModelGene> LEGACY_MOSASAURUS = FAModelGenes.create("legacy_mosasaurus");
    public static final ResourceKey<ModelGene> LEGACY_PTERANODON = FAModelGenes.create("legacy_pteranodon");
    public static final ResourceKey<ModelGene> LEGACY_SMILODON = FAModelGenes.create("legacy_smilodon");
    public static final ResourceKey<ModelGene> LEGACY_STEGOSAURUS = FAModelGenes.create("legacy_stegosaurus");
    public static final ResourceKey<ModelGene> LEGACY_THERIZINOSAURUS = FAModelGenes.create("legacy_therizinosaurus");
    public static final ResourceKey<ModelGene> LEGACY_TRICERATOPS = FAModelGenes.create("legacy_triceratops");
    public static final ResourceKey<ModelGene> LEGACY_TYRANNOSAURUS = FAModelGenes.create("legacy_tyrannosaurus");
    public static final ResourceKey<ModelGene> LEGACY_VELOCIRAPTOR = FAModelGenes.create("legacy_velociraptor");

    private static ResourceKey<ModelGene> create(String name) {
        return ResourceKey.create(FARegistries.MODEL_GENE, FAUtils.resource(name));
    }

    private static void register(BootstrapContext<ModelGene> bootstrapContext, ResourceKey<ModelGene> resourceKey, ModelGene modelGene) {
        bootstrapContext.register(resourceKey, modelGene);
    }

    public static void bootstrap(BootstrapContext<ModelGene> bootstrapContext) {
        FAModelGenes.register(bootstrapContext, ANKYLOSAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.ankylosaurus"), 0x533A1B, 1.0F, 0.0F, FAUtils.resource("ankylosaurus"), FASkinGeneTags.ANKYLOSAURUS_2024_SKINS, FAPatternGeneTags.ANKYLOSAURUS_2024_PATTERNS, 1.75F, 1.5F, 0.4F, 1.5F, 1.5F, 0.3F, 0.75F, 0.25F).build());
        FAModelGenes.register(bootstrapContext, BARYONYX, ModelGene.build(Component.translatable("model_type.fossilslegacy.baryonyx"), 0x3C3F56, 1.0F, 0.0F, FAUtils.resource("baryonyx"), FASkinGeneTags.BARYONYX_2025_SKINS, FAPatternGeneTags.BARYONYX_2025_PATTERNS, 0.5F, 0.5F, 0.4F, 0.5F, 0.5F, 0.35F, 0.25F, 0.15F).build());
        FAModelGenes.register(bootstrapContext, BRACHIOSAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.brachiosaurus"), 0x3C3F56, 0.2F, 15.0F, FAUtils.resource("brachiosaurus"), FASkinGeneTags.BRACHIOSAURUS_2024_SKINS, FAPatternGeneTags.BRACHIOSAURUS_2024_PATTERNS, 1.75F, 2.5F, 0.3F, 1.5F, 1.5F, 0.4F, 0.75F, 0.15F).build());
        FAModelGenes.register(bootstrapContext, CARNOTAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.carnotaurus"), 0x485039, 1.0F, 0.0F, FAUtils.resource("carnotaurus"), FASkinGeneTags.CARNOTAURUS_2024_SKINS, FAPatternGeneTags.CARNOTAURUS_2024_PATTERNS, 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.4F, 0.25F, 0.1F).build());
        FAModelGenes.register(bootstrapContext, COMPSOGNATHUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.compsognathus"), 0x213D20, 5.0F, -1.0F, FAUtils.resource("compsognathus"), FASkinGeneTags.COMPSOGNATHUS_2024_SKINS, FAPatternGeneTags.COMPSOGNATHUS_2024_PATTERNS, 0.25F, 0.25F, 0.1F, 0.25F, 0.25F, 0.125F, 0.05F, 0.025F).build());
        FAModelGenes.register(bootstrapContext, CRYOLOPHOSAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.cryolophosaurus"), 0x49658B, 2.0F, -0.2F, FAUtils.resource("cryolophosaurus"), FASkinGeneTags.CRYOLOPHOSAURUS_2024_SKINS, FAPatternGeneTags.CRYOLOPHOSAURUS_2024_PATTERNS, 0.35F, 0.35F, 0.2F, 0.25F, 0.25F, 0.2F, 0.15F, 0.1F).build());
        FAModelGenes.register(bootstrapContext, DILOPHOSAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.dilophosaurus"), 0x736F4A, 3.0F, -0.5F, FAUtils.resource("dilophosaurus"), FASkinGeneTags.DILOPHOSAURUS_2024_SKINS, FAPatternGeneTags.DILOPHOSAURUS_2024_PATTERNS, 0.5F, 0.5F, 0.2F, 0.2F, 0.2F, 0.15F, 0.15F, 0.1F).build());
        FAModelGenes.register(bootstrapContext, DIMETRODON, ModelGene.build(Component.translatable("model_type.fossilslegacy.dimetrodon"), 0x251A22, 3.0F, -1.25F, FAUtils.resource("dimetrodon"), FASkinGeneTags.DIMETRODON_2024_SKINS, FAPatternGeneTags.DIMETRODON_2024_PATTERNS, 0.5F, 0.5F, 0.05F, 0.5F, 0.5F, 0.075F, 0.15F, 0.05F).build());
        FAModelGenes.register(bootstrapContext, DISTORTUS_REX, ModelGene.build(Component.translatable("model_type.fossilslegacy.distortus_rex"), 0x80643A, 3.0F, -1.25F, FAUtils.resource("distortus_rex"), FASkinGeneTags.DISTORTUS_REX_2025_SKINS, FAPatternGeneTags.DISTORTUS_REX_2025_PATTERNS, 1.0F, 1.15F, 0.75F, 0.5F, 0.5F, 0.35F, 0.5F, 0.5F).build());
        FAModelGenes.register(bootstrapContext, DODO, ModelGene.build(Component.translatable("model_type.fossilslegacy.dodo"), 0x5A5A5A, 5.0F, -1.0F, FAUtils.resource("dodo"), FASkinGeneTags.DODO_2024_SKINS, FAPatternGeneTags.DODO_2024_PATTERNS, 0.5F, 0.5F, 0.05F, 0.5F, 0.5F, 0.07142857142F, 0.15F, 0.05F).build());
        FAModelGenes.register(bootstrapContext, DRYOSAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.dryosaurus"), 0x5A5A5A, 3.0F, -0.75F, FAUtils.resource("dryosaurus"), FASkinGeneTags.DRYOSAURUS_2025_SKINS, FAPatternGeneTags.DRYOSAURUS_2025_PATTERNS, 0.4F, 0.4F, 0.1F, 0.5F, 0.5F, 0.15F, 0.15F, 0.05F).build());
        FAModelGenes.register(bootstrapContext, ELASMOTHERIUM, ModelGene.build(Component.translatable("model_type.fossilslegacy.elasmotherium"), 0xB92200, 2.0F, -0.5F, FAUtils.resource("elasmotherium"), FASkinGeneTags.ELASMOTHERIUM_2025_SKINS, FAPatternGeneTags.ELASMOTHERIUM_2025_PATTERNS, 1.0F, 1.0F, 0.15F, 0.8F, 0.8F, 0.15F, 0.5F, 0.05F).build());
        FAModelGenes.register(bootstrapContext, FUTABASAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.futabasaurus"), 0xB92200, 0.5F, 0.25F, FAUtils.resource("futabasaurus"), FASkinGeneTags.FUTABASAURUS_2024_SKINS, FAPatternGeneTags.FUTABASAURUS_2024_PATTERNS, 2.0F, 0.75F, 0.25F, 1.5F, 1.5F, 0.3F, 0.15F, 0.15F).build());
        FAModelGenes.register(bootstrapContext, GALLIMIMUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.gallimimus"), 0x774913, 1.75F, 1.0F, FAUtils.resource("gallimimus"), FASkinGeneTags.GALLIMIMUS_2024_SKINS, FAPatternGeneTags.GALLIMIMUS_2024_PATTERNS, 0.7F, 0.7F, 0.25F, 0.75F, 0.75F, 0.2F, 0.25F, 0.1F).build());
        FAModelGenes.register(bootstrapContext, ICHTHYOSAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.ichthyosaurus"), 0x383C4F, 3.0F, -1.0F, FAUtils.resource("ichthyosaurus"), FASkinGeneTags.ICHTHYOSAURUS_2025_SKINS, FAPatternGeneTags.ICHTHYOSAURUS_2025_PATTERNS, 0.7F, 0.5F, 0.25F, 0.75F, 0.75F, 0.1F, 0.35F, 0.1F).build());
        FAModelGenes.register(bootstrapContext, ISOTELUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.isotelus"), 0x43403B, 3.0F, -1.0F, FAUtils.resource("isotelus"), FASkinGeneTags.ISOTELUS_2025_SKINS, FAPatternGeneTags.ISOTELUS_2025_PATTERNS, 0.5F, 0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.25F, 0.0F).build());
        FAModelGenes.register(bootstrapContext, ISOTELUS_LARVA, ModelGene.build(Component.translatable("model_type.fossilslegacy.isotelus_larva"), 0xCBA840, 3.0F, -1.0F, FAUtils.resource("isotelus_larva"), FASkinGeneTags.ISOTELUS_LARVA_2025_SKINS, FAPatternGeneTags.ISOTELUS_LARVA_2025_PATTERNS, 0.15F, 0.15F, 0.0F, 1.0F, 1.0F, 0.0F, 0.1F, 0.0F).build());
        FAModelGenes.register(bootstrapContext, MAMMOTH, ModelGene.build(Component.translatable("model_type.fossilslegacy.mammoth"), 0x3D2700, 1.0F, 1.0F, FAUtils.resource("mammoth"), FASkinGeneTags.MAMMOTH_2024_SKINS, FAPatternGeneTags.MAMMOTH_2024_PATTERNS, 0.7F, 0.7F, 0.5F, 1.0F, 1.0F, 0.4F, 0.75F, 0.15F).build());
        FAModelGenes.register(bootstrapContext, MOSASAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.mosasaurus"), 0x0D7346, 0.9F, 0.25F, FAUtils.resource("mosasaurus"), FASkinGeneTags.MOSASAURUS_2024_SKINS, FAPatternGeneTags.MOSASAURUS_2024_PATTERNS, 0.5F, 0.5F, 0.1F, 0.5F, 0.5F, 0.5125F, 0.35F, 0.3F).build());
        FAModelGenes.register(bootstrapContext, MOA, ModelGene.build(Component.translatable("model_type.fossilslegacy.moa"), 0x352A17, 2.0F, 1.0F, FAUtils.resource("moa"), FASkinGeneTags.MOA_2024_SKINS, FAPatternGeneTags.MOA_2024_PATTERNS, 0.5F, 1.5F, 0.1F, 0.5F, 0.5F, 0.25F, 0.15F, 0.1F).build());
        FAModelGenes.register(bootstrapContext, PACHYCEPHALOSAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.pachycephalosaurus"), 0xC06929, 2.25F, -0.5F, FAUtils.resource("pachycephalosaurus"), FASkinGeneTags.PACHYCEPHALOSAURUS_2024_SKINS, FAPatternGeneTags.PACHYCEPHALOSAURUS_2024_PATTERNS, 0.7F, 0.7F, 0.1F, 1.0F, 1.0F, 0.1F, 0.35F, 0.075F).build());
        FAModelGenes.register(bootstrapContext, PTERANODON, ModelGene.build(Component.translatable("model_type.fossilslegacy.pteranodon"), 0x7C5D89, 1.5F, 0.0F, FAUtils.resource("pteranodon"), FASkinGeneTags.PTERANODON_2024_SKINS, FAPatternGeneTags.PTERANODON_2024_PATTERNS, 0.5F, 0.5F, 0.2F, 0.8F, 0.8F, 0.2F, 0.35F, 0.075F).build());
        FAModelGenes.register(bootstrapContext, SMILODON, ModelGene.build(Component.translatable("model_type.fossilslegacy.smilodon"), 0xEFA745, 3.0F, -0.25F, FAUtils.resource("smilodon"), FASkinGeneTags.SMILODON_2024_SKINS, FAPatternGeneTags.SMILODON_2024_PATTERNS, 0.75F, 0.75F, 0.1F, 0.7F, 0.7F, 0.1F, 0.5F, 0.05F).build());
        FAModelGenes.register(bootstrapContext, SPINOSAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.spinosaurus"), 0x26261D, 0.75F, 2.0F, FAUtils.resource("spinosaurus"), FASkinGeneTags.SPINOSAURUS_2024_SKINS, FAPatternGeneTags.SPINOSAURUS_2024_PATTERNS, 0.5F, 0.5F, 0.4F, 0.5F, 0.5F, 0.5125F, 0.25F, 0.15F).build());
        FAModelGenes.register(bootstrapContext, STEGOSAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.stegosaurus"), 0x8BE400, 1.0F, 0.5F, FAUtils.resource("stegosaurus"), FASkinGeneTags.STEGOSAURUS_2024_SKINS, FAPatternGeneTags.STEGOSAURUS_2024_PATTERNS, 0.75F, 0.75F, 0.2F, 0.8F, 0.8F, 0.2F, 0.5F, 0.1F).build());
        FAModelGenes.register(bootstrapContext, THERIZINOSAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.therizinosaurus"), 0xCE551D, 1.25F, 1.0F, FAUtils.resource("therizinosaurus"), FASkinGeneTags.THERIZINOSAURUS_2024_SKINS, FAPatternGeneTags.THERIZINOSAURUS_2024_PATTERNS, 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.25F, 0.25F, 0.1F).build());
        FAModelGenes.register(bootstrapContext, TRICERATOPS, ModelGene.build(Component.translatable("model_type.fossilslegacy.triceratops"), 0xADE642, 1.0F, 0.0F, FAUtils.resource("triceratops"), FASkinGeneTags.TRICERATOPS_2024_SKINS, FAPatternGeneTags.TRICERATOPS_2024_PATTERNS, 1.0F, 1.0F, 0.2F, 1.0F, 1.0F, 0.15F, 0.5F, 0.1F).build());
        FAModelGenes.register(bootstrapContext, TYRANNOSAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.tyrannosaurus"), 0x918066, 0.75F, 0.0F, FAUtils.resource("tyrannosaurus"), FASkinGeneTags.TYRANNOSAURUS_2024_SKINS, FAPatternGeneTags.TYRANNOSAURUS_2024_PATTERNS, 0.5F, 0.5F, 0.6F, 0.5F, 0.5F, 0.5125F, 0.25F, 0.15F).withKnockoutModel(FAUtils.resource("knocked_out_tyrannosaurus")).build());
        FAModelGenes.register(bootstrapContext, VELOCIRAPTOR, ModelGene.build(Component.translatable("model_type.fossilslegacy.velociraptor"), 0x0C3F4C, 4.0F, -0.75F, FAUtils.resource("velociraptor"), FASkinGeneTags.VELOCIRAPTOR_2024_SKINS, FAPatternGeneTags.VELOCIRAPTOR_2024_PATTERNS, 0.2F, 0.4F, 0.05F, 0.5F, 0.5F, 0.1F, 0.15F, 0.025F).build());

        FAModelGenes.register(bootstrapContext, LEGACY_BRACHIOSAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.legacy_brachiosaurus"), 0x363950, 0.35F, 8.0F, FAUtils.resource("legacy_brachiosaurus"), FASkinGeneTags.BRACHIOSAURUS_2011_SKINS, FAPatternGeneTags.BRACHIOSAURUS_2011_PATTERNS, 1.75F, 2.5F, 0.3F, 1.5F, 1.5F, 0.3F, 0.75F, 0.1F).build());
        FAModelGenes.register(bootstrapContext, LEGACY_CARNOTAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.legacy_carnotaurus"), 0x485039, 1.0F, 0.0F, FAUtils.resource("legacy_carnotaurus"), FASkinGeneTags.CARNOTAURUS_2011_SKINS, FAPatternGeneTags.CARNOTAURUS_2011_PATTERNS, 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.3F, 0.75F, 0.1F).build());
        FAModelGenes.register(bootstrapContext, LEGACY_CRYOLOPHOSAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.legacy_cryolophosaurus"), 0x49658B, 2.0F, -0.2F, FAUtils.resource("legacy_cryolophosaurus"), FASkinGeneTags.CRYOLOPHOSAURUS_2011_SKINS, FAPatternGeneTags.CRYOLOPHOSAURUS_2011_PATTERNS, 0.35F, 0.35F, 0.2F, 0.25F, 0.25F, 0.2F, 0.15F, 0.1F).build());
        FAModelGenes.register(bootstrapContext, LEGACY_DILOPHOSAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.legacy_dilophosaurus"), 0x736F4A, 3.0F, -0.5F, FAUtils.resource("legacy_dilophosaurus"), FASkinGeneTags.DILOPHOSAURUS_2011_SKINS, FAPatternGeneTags.DILOPHOSAURUS_2011_PATTERNS, 0.5F, 0.5F, 0.2F, 0.2F, 0.2F, 0.15F, 0.15F, 0.1F).build());
        FAModelGenes.register(bootstrapContext, LEGACY_FUTABASAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.legacy_futabasaurus"), 0xC75B00, 1.0F, 0.25F, FAUtils.resource("legacy_futabasaurus"), FASkinGeneTags.FUTABASAURUS_2011_SKINS, FAPatternGeneTags.FUTABASAURUS_2011_PATTERNS, 0.75F, 0.75F, 0.2F, 1.5F, 1.5F, 0.3F, 0.75F, 0.15F).build());
        FAModelGenes.register(bootstrapContext, LEGACY_MAMMOTH, ModelGene.build(Component.translatable("model_type.fossilslegacy.legacy_mammoth"), 0x3D2700, 1.25F, 0.25F, FAUtils.resource("legacy_mammoth"), FASkinGeneTags.MAMMOTH_2011_SKINS, FAPatternGeneTags.MAMMOTH_2011_PATTERNS, 0.7F, 0.7F, 0.5F, 1.0F, 1.0F, 0.625F, 0.75F, 0.15F).build());
        FAModelGenes.register(bootstrapContext, LEGACY_MOSASAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.legacy_mosasaurus"), 0x0D7346, 1.0F, 0.25F, FAUtils.resource("legacy_mosasaurus"), FASkinGeneTags.MOSASAURUS_2011_SKINS, FAPatternGeneTags.MOSASAURUS_2011_PATTERNS, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.5125F, 0.5F, 0.1F).build());
        FAModelGenes.register(bootstrapContext, LEGACY_PTERANODON, ModelGene.build(Component.translatable("model_type.fossilslegacy.legacy_pteranodon"), 0x7C5D89, 1.5F, 0.0F, FAUtils.resource("legacy_pteranodon"), FASkinGeneTags.PTERANODON_2011_SKINS, FAPatternGeneTags.PTERANODON_2011_PATTERNS, 0.5F, 0.5F, 0.2F, 0.8F, 0.8F, 0.2F, 0.35F, 0.075F).withFlyingModels(FAUtils.resource("legacy_flying_pteranodon"), FAUtils.resource("legacy_landing_pteranodon")).build());
        FAModelGenes.register(bootstrapContext, LEGACY_SMILODON, ModelGene.build(Component.translatable("model_type.fossilslegacy.legacy_smilodon"), 0xEFA745, 3.0F, -0.25F, FAUtils.resource("legacy_smilodon"), FASkinGeneTags.SMILODON_2011_SKINS, FAPatternGeneTags.SMILODON_2011_PATTERNS, 0.75F, 0.75F, 0.1F, 1.0F, 1.0F, 0.14285714285F, 0.5F, 0.05F).build());
        FAModelGenes.register(bootstrapContext, LEGACY_STEGOSAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.legacy_stegosaurus"), 0x8BE400, 1.0F, 0.0F, FAUtils.resource("legacy_stegosaurus"), FASkinGeneTags.STEGOSAURUS_2011_SKINS, FAPatternGeneTags.STEGOSAURUS_2011_PATTERNS, 0.75F, 0.75F, 0.2F, 1.5F, 1.5F, 0.3F, 1.0F, 0.1F).build());
        FAModelGenes.register(bootstrapContext, LEGACY_THERIZINOSAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.legacy_therizinosaurus"), 0xCE551D, 0.9F, 1.0F, FAUtils.resource("legacy_therizinosaurus"), FASkinGeneTags.THERIZINOSAURUS_2011_SKINS, FAPatternGeneTags.THERIZINOSAURUS_2011_PATTERNS, 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.35F, 0.75F, 0.1F).build());
        FAModelGenes.register(bootstrapContext, LEGACY_TRICERATOPS, ModelGene.build(Component.translatable("model_type.fossilslegacy.legacy_triceratops"), 0xB6EF4B, 1.0F, 0.0F, FAUtils.resource("legacy_triceratops"), FASkinGeneTags.TRICERATOPS_2011_SKINS, FAPatternGeneTags.TRICERATOPS_2011_PATTERNS, 0.75F, 0.75F, 0.15F, 1.5F, 1.5F, 0.3F, 1.0F, 0.1F).build());
        FAModelGenes.register(bootstrapContext, LEGACY_TYRANNOSAURUS, ModelGene.build(Component.translatable("model_type.fossilslegacy.legacy_tyrannosaurus"), 0x918066, 0.75F, 0.0F, FAUtils.resource("legacy_tyrannosaurus"), FASkinGeneTags.TYRANNOSAURUS_2011_SKINS, FAPatternGeneTags.TYRANNOSAURUS_2011_PATTERNS, 0.5F, 0.5F, 0.6F, 0.5F, 0.5F, 0.5125F, 0.75F, 0.15F).withKnockoutModel(FAUtils.resource("legacy_knocked_out_tyrannosaurus")).build());
        FAModelGenes.register(bootstrapContext, LEGACY_VELOCIRAPTOR, ModelGene.build(Component.translatable("model_type.fossilslegacy.legacy_velociraptor"), 0x71A367, 4.0F, -0.75F, FAUtils.resource("legacy_velociraptor"), FASkinGeneTags.VELOCIRAPTOR_2011_SKINS, FAPatternGeneTags.VELOCIRAPTOR_2011_PATTERNS, 0.3F, 0.3F, 0.1F, 0.2F, 0.32F, 0.1F, 0.35F, 0.05F).build());
    }
}
