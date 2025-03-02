package willatendo.fossilslegacy.server.pattern;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.pattern_type.FAPatternTypes;
import willatendo.fossilslegacy.server.pattern_type.PatternType;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FAPatterns {
    public static final ResourceKey<Pattern> ANKYLOSAURUS_2024 = FAPatterns.create("ankylosaurus_2024");
    public static final ResourceKey<Pattern> BRACHIOSAURUS_2024 = FAPatterns.create("brachiosaurus_2024");
    public static final ResourceKey<Pattern> GREEN_CARNOTAURUS_2024 = FAPatterns.create("green_carnotaurus_2024");
    public static final ResourceKey<Pattern> RED_CARNOTAURUS_2024 = FAPatterns.create("red_carnotaurus_2024");
    public static final ResourceKey<Pattern> COMPSOGNATHUS_2024 = FAPatterns.create("compsognathus_2024");
    public static final ResourceKey<Pattern> CRYOLOPHOSAURUS_2024 = FAPatterns.create("cryolophosaurus_2024");
    public static final ResourceKey<Pattern> DILOPHOSAURUS_2024 = FAPatterns.create("dilophosaurus_2024");
    public static final ResourceKey<Pattern> DIMETRODON_2024 = FAPatterns.create("dimetrodon_2024");
    public static final ResourceKey<Pattern> DODO_2024 = FAPatterns.create("dodo_2024");
    public static final ResourceKey<Pattern> FUTABASAURUS_2024 = FAPatterns.create("futabasaurus_2024");
    public static final ResourceKey<Pattern> GALLIMIMUS_2024 = FAPatterns.create("gallimimus_2024");
    public static final ResourceKey<Pattern> ICHTHYOSAURUS_2025 = FAPatterns.create("ichthyosaurus_2025");
    public static final ResourceKey<Pattern> MAMMOTH_2024 = FAPatterns.create("mammoth_2024");
    public static final ResourceKey<Pattern> MOA_2024 = FAPatterns.create("moa_2024");
    public static final ResourceKey<Pattern> MOSASAURUS_2024 = FAPatterns.create("mosasaurus_2024");
    public static final ResourceKey<Pattern> PACHYCEPHALOSAURUS_2024 = FAPatterns.create("pachycephalosaurus_2024");
    public static final ResourceKey<Pattern> PTERANODON_2024 = FAPatterns.create("pteranodon_2024");
    public static final ResourceKey<Pattern> SMILODON_2024 = FAPatterns.create("smilodon_2024");
    public static final ResourceKey<Pattern> SPINOSAURUS_2024 = FAPatterns.create("spinosaurus_2024");
    public static final ResourceKey<Pattern> STEGOSAURUS_2024 = FAPatterns.create("stegosaurus_2024");
    public static final ResourceKey<Pattern> THERIZINOSAURUS_2024 = FAPatterns.create("therizinosaurus_2024");
    public static final ResourceKey<Pattern> GREEN_TRICERATOPS_2024 = FAPatterns.create("green_triceratops_2024");
    public static final ResourceKey<Pattern> BROWN_TRICERATOPS_2024 = FAPatterns.create("brown_triceratops_2024");
    public static final ResourceKey<Pattern> TYRANNOSAURUS_2024 = FAPatterns.create("tyrannosaurus_2024");
    public static final ResourceKey<Pattern> GREEN_VELOCIRAPTOR_2024 = FAPatterns.create("green_velociraptor_2024");
    public static final ResourceKey<Pattern> SANDY_VELOCIRAPTOR_2024 = FAPatterns.create("sandy_velociraptor_2024");
    public static final ResourceKey<Pattern> WHITE_VELOCIRAPTOR_2024 = FAPatterns.create("white_velociraptor_2024");

    public static final ResourceKey<Pattern> BRACHIOSAURUS_2011 = FAPatterns.create("brachiosaurus_2011");
    public static final ResourceKey<Pattern> GREEN_CARNOTAURUS_2011 = FAPatterns.create("green_carnotaurus_2011");
    public static final ResourceKey<Pattern> RED_CARNOTAURUS_2011 = FAPatterns.create("red_carnotaurus_2011");
    public static final ResourceKey<Pattern> CRYOLOPHOSAURUS_2011 = FAPatterns.create("cryolophosaurus_2011");
    public static final ResourceKey<Pattern> DILOPHOSAURUS_2011 = FAPatterns.create("dilophosaurus_2011");
    public static final ResourceKey<Pattern> FUTABASAURUS_2011 = FAPatterns.create("futabasaurus_2011");
    public static final ResourceKey<Pattern> MAMMOTH_2011 = FAPatterns.create("mammoth_2011");
    public static final ResourceKey<Pattern> MOSASAURUS_2011 = FAPatterns.create("mosasaurus_2011");
    public static final ResourceKey<Pattern> PTERANODON_2011 = FAPatterns.create("pteranodon_2011");
    public static final ResourceKey<Pattern> SMILODON_2011 = FAPatterns.create("smilodon_2011");
    public static final ResourceKey<Pattern> STEGOSAURUS_2011 = FAPatterns.create("stegosaurus_2011");
    public static final ResourceKey<Pattern> FEATHERED_THERIZINOSAURUS_2011 = FAPatterns.create("feathered_therizinosaurus_2011");
    public static final ResourceKey<Pattern> FEATHERLESS_THERIZINOSAURUS_2011 = FAPatterns.create("featherless_therizinosaurus_2011");
    public static final ResourceKey<Pattern> GREEN_TRICERATOPS_2011 = FAPatterns.create("green_triceratops_2011");
    public static final ResourceKey<Pattern> BROWN_TRICERATOPS_2011 = FAPatterns.create("brown_triceratops_2011");
    public static final ResourceKey<Pattern> TYRANNOSAURUS_2011 = FAPatterns.create("tyrannosaurus_2011");
    public static final ResourceKey<Pattern> GREEN_VELOCIRAPTOR_2011 = FAPatterns.create("green_velociraptor_2011");
    public static final ResourceKey<Pattern> SANDY_VELOCIRAPTOR_2011 = FAPatterns.create("sandy_velociraptor_2011");
    public static final ResourceKey<Pattern> WHITE_VELOCIRAPTOR_2011 = FAPatterns.create("white_velociraptor_2011");

    private static ResourceKey<Pattern> create(String name) {
        return ResourceKey.create(FARegistries.PATTERN, FAUtils.resource(name));
    }

    private static void register(BootstrapContext<Pattern> bootstrapContext, ResourceKey<Pattern> resourceKey, Pattern pattern) {
        bootstrapContext.register(resourceKey, pattern);
    }

    public static void bootstrap(BootstrapContext<Pattern> bootstrapContext) {
        Holder<PatternType> basic = bootstrapContext.lookup(FARegistries.PATTERN_TYPES).getOrThrow(FAPatternTypes.BASIC);
        FAPatterns.register(bootstrapContext, ANKYLOSAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/ankylosaurus/ankylosaurus_adult.png"), Component.translatable("pattern.fossilslegacy.eastern_brown_snake"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/ankylosaurus/ankylosaurus_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, BRACHIOSAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/brachiosaurus/brachiosaurus_adult.png"), Component.translatable("pattern.fossilslegacy.blue_iguana"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/brachiosaurus/brachiosaurus_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, GREEN_CARNOTAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/carnotaurus/green_carnotaurus_adult.png"), Component.translatable("pattern.fossilslegacy.green_tree_python"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/carnotaurus/red_carnotaurus_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, RED_CARNOTAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/carnotaurus/red_carnotaurus_adult.png"), Component.translatable("pattern.fossilslegacy.northern_cardinal"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/carnotaurus/green_carnotaurus_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, COMPSOGNATHUS_2024, Pattern.builder(FAUtils.resource("textures/entity/compsognathus/compsognathus.png"), Component.translatable("pattern.fossilslegacy.green_tree_python"), 0xFFFFFF).build(basic));
        FAPatterns.register(bootstrapContext, CRYOLOPHOSAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/cryolophosaurus/cryolophosaurus_adult.png"), Component.translatable("pattern.fossilslegacy.blue_iguana"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/cryolophosaurus/cryolophosaurus_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, DILOPHOSAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/dilophosaurus/dilophosaurus_adult.png"), Component.translatable("pattern.fossilslegacy.inland_taipan"), 0xFFFFFF).withAggressiveTexture(FAUtils.resource("textures/entity/dilophosaurus/aggressive_dilophosaurus_adult.png")).build(basic));
        FAPatterns.register(bootstrapContext, DIMETRODON_2024, Pattern.builder(FAUtils.resource("textures/entity/dimetrodon/dimetrodon_adult.png"), Component.translatable("pattern.fossilslegacy.eastern_indigo_snake"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/dimetrodon/dimetrodon_baby.png")).withAggressiveTexture(FAUtils.resource("textures/entity/dimetrodon/dimetrodon_agressive.png")).build(basic));
        FAPatterns.register(bootstrapContext, DODO_2024, Pattern.builder(FAUtils.resource("textures/entity/dodo/dodo.png"), Component.translatable("pattern.fossilslegacy.domestic_pigeon"), 0xFFFFFF).build(basic));
        FAPatterns.register(bootstrapContext, FUTABASAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/futabasaurus/futabasaurus.png"), Component.translatable("pattern.fossilslegacy.broadhead_skink"), 0xFFFFFF).build(basic));
        FAPatterns.register(bootstrapContext, GALLIMIMUS_2024, Pattern.builder(FAUtils.resource("textures/entity/gallimimus/gallimimus_adult.png"), Component.translatable("pattern.fossilslegacy.broadhead_skink"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/gallimimus/gallimimus_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, ICHTHYOSAURUS_2025, Pattern.builder(FAUtils.resource("textures/entity/ichthyosaurus/ichthyosaurus.png"), Component.translatable("pattern.fossilslegacy.blue_iguana"), 0xFFFFFF).build(basic));
        FAPatterns.register(bootstrapContext, MAMMOTH_2024, Pattern.builder(FAUtils.resource("textures/entity/mammoth/mammoth_adult.png"), Component.translatable("pattern.fossilslegacy.american_bison"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/mammoth/mammoth_baby.png")).withFurTexture(FAUtils.resource("textures/entity/mammoth/mammoth_adult_fur.png")).withBabyFurTexture(FAUtils.resource("textures/entity/mammoth/mammoth_baby_fur.png")).withShearedTexture(FAUtils.resource("textures/entity/mammoth/mammoth_adult_sheared.png")).build(basic));
        FAPatterns.register(bootstrapContext, MOSASAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/mosasaurus/mosasaurus.png"), Component.translatable("pattern.fossilslegacy.marine_iguana"), 0xFFFFFF).withEyeLayerTexture(FAUtils.resource("textures/entity/mosasaurus/mosasaurus_eyes.png")).build(basic));
        FAPatterns.register(bootstrapContext, MOA_2024, Pattern.builder(FAUtils.resource("textures/entity/moa/moa.png"), Component.translatable("pattern.fossilslegacy.american_bison"), 0xFFFFFF).build(basic));
        FAPatterns.register(bootstrapContext, PACHYCEPHALOSAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/pachycephalosaurus/pachycephalosaurus_adult.png"), Component.translatable("pattern.fossilslegacy.broadhead_skink"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/pachycephalosaurus/pachycephalosaurus_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, PTERANODON_2024, Pattern.builder(FAUtils.resource("textures/entity/pteranodon/pteranodon_adult.png"), Component.translatable("pattern.fossilslegacy.eastern_indigo_snake"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/pteranodon/pteranodon_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, SMILODON_2024, Pattern.builder(FAUtils.resource("textures/entity/smilodon/smilodon_adult.png"), Component.translatable("pattern.fossilslegacy.tiger"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/smilodon/smilodon_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, SPINOSAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/spinosaurus/spinosaurus_adult.png"), Component.translatable("pattern.fossilslegacy.marine_iguana"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/spinosaurus/spinosaurus_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, STEGOSAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/stegosaurus/stegosaurus_adult.png"), Component.translatable("pattern.fossilslegacy.green_tree_python"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/stegosaurus/stegosaurus_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, THERIZINOSAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/therizinosaurus/therizinosaurus_adult.png"), Component.translatable("pattern.fossilslegacy.green_parakeet"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/therizinosaurus/therizinosaurus_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, GREEN_TRICERATOPS_2024, Pattern.builder(FAUtils.resource("textures/entity/triceratops/green_triceratops_adult.png"), Component.translatable("pattern.fossilslegacy.green_tree_python"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/triceratops/green_triceratops_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, BROWN_TRICERATOPS_2024, Pattern.builder(FAUtils.resource("textures/entity/triceratops/brown_triceratops_adult.png"), Component.translatable("pattern.fossilslegacy.eastern_brown_snake"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/triceratops/brown_triceratops_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, TYRANNOSAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/tyrannosaurus/tyrannosaurus_adult.png"), Component.translatable("pattern.fossilslegacy.eastern_brown_snake"), 0xFFFFFF).withAggressiveTexture(FAUtils.resource("textures/entity/tyrannosaurus/tyrannosaurus_aggressive.png")).withKnockedOutTexture(FAUtils.resource("textures/entity/tyrannosaurus/tyrannosaurus_weak.png")).withBabyTexture(FAUtils.resource("textures/entity/tyrannosaurus/tyrannosaurus_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, GREEN_VELOCIRAPTOR_2024, Pattern.builder(FAUtils.resource("textures/entity/velociraptor/green_velociraptor_adult.png"), Component.translatable("pattern.fossilslegacy.green_tree_python"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/velociraptor/green_velociraptor_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, SANDY_VELOCIRAPTOR_2024, Pattern.builder(FAUtils.resource("textures/entity/velociraptor/sandy_velociraptor_adult.png"), Component.translatable("pattern.fossilslegacy.eastern_brown_snake"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/velociraptor/sandy_velociraptor_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, WHITE_VELOCIRAPTOR_2024, Pattern.builder(FAUtils.resource("textures/entity/velociraptor/white_velociraptor_adult.png"), Component.translatable("pattern.fossilslegacy.gray_ratsnake"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/velociraptor/white_velociraptor_baby.png")).build(basic));

        FAPatterns.register(bootstrapContext, BRACHIOSAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/brachiosaurus/legacy/brachiosaurus.png"), Component.translatable("pattern.fossilslegacy.blue_iguana"), 0xFFFFFF).build(basic));
        FAPatterns.register(bootstrapContext, GREEN_CARNOTAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/carnotaurus/legacy/green_carnotaurus.png"), Component.translatable("pattern.fossilslegacy.green_tree_python"), 0xFFFFFF).build(basic));
        FAPatterns.register(bootstrapContext, RED_CARNOTAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/carnotaurus/legacy/red_carnotaurus.png"), Component.translatable("pattern.fossilslegacy.northern_cardinal"), 0xFFFFFF).build(basic));
        FAPatterns.register(bootstrapContext, CRYOLOPHOSAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/cryolophosaurus/legacy/cryolophosaurus.png"), Component.translatable("pattern.fossilslegacy.blue_iguana"), 0xFFFFFF).build(basic));
        FAPatterns.register(bootstrapContext, DILOPHOSAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/dilophosaurus/legacy/dilophosaurus.png"), Component.translatable("pattern.fossilslegacy.inland_taipan"), 0xFFFFFF).withAggressiveTexture(FAUtils.resource("textures/entity/dilophosaurus/legacy/dilophosaurus_aggressive.png")).build(basic));
        FAPatterns.register(bootstrapContext, FUTABASAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/futabasaurus/legacy/futabasaurus.png"), Component.translatable("pattern.fossilslegacy.broadhead_skink"), 0xFFFFFF).build(basic));
        FAPatterns.register(bootstrapContext, MAMMOTH_2011, Pattern.builder(FAUtils.resource("textures/entity/mammoth/legacy/mammoth_adult.png"), Component.translatable("pattern.fossilslegacy.american_bison"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/mammoth/legacy/mammoth_baby.png")).withFurTexture(FAUtils.resource("textures/entity/mammoth/legacy/mammoth_adult_fur.png")).withBabyFurTexture(FAUtils.resource("textures/entity/mammoth/legacy/mammoth_baby_fur.png")).withShearedTexture(FAUtils.resource("textures/entity/mammoth/legacy/mammoth_adult_sheared.png")).build(basic));
        FAPatterns.register(bootstrapContext, MOSASAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/mosasaurus/legacy/mosasaurus.png"), Component.translatable("pattern.fossilslegacy.marine_iguana"), 0xFFFFFF).withEyeLayerTexture(FAUtils.resource("textures/entity/mosasaurus/legacy/mosasaurus_eyes.png")).build(basic));
        FAPatterns.register(bootstrapContext, PTERANODON_2011, Pattern.builder(FAUtils.resource("textures/entity/pteranodon/legacy/pteranodon.png"), Component.translatable("pattern.fossilslegacy.eastern_indigo_snake"), 0xFFFFFF).build(basic));
        FAPatterns.register(bootstrapContext, SMILODON_2011, Pattern.builder(FAUtils.resource("textures/entity/smilodon/legacy/smilodon_adult.png"), Component.translatable("pattern.fossilslegacy.tiger"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/smilodon/legacy/smilodon_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, STEGOSAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/stegosaurus/legacy/stegosaurus_adult.png"), Component.translatable("pattern.fossilslegacy.green_tree_python"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/stegosaurus/legacy/stegosaurus_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, FEATHERED_THERIZINOSAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/therizinosaurus/legacy/therizinosaurus_feathered.png"), Component.translatable("pattern.fossilslegacy.green_parakeet"), 0xFFFFFF).build(basic));
        FAPatterns.register(bootstrapContext, FEATHERLESS_THERIZINOSAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/therizinosaurus/legacy/therizinosaurus_featherless.png"), Component.translatable("pattern.fossilslegacy.green_tree_python"), 0xFFFFFF).build(basic));
        FAPatterns.register(bootstrapContext, GREEN_TRICERATOPS_2011, Pattern.builder(FAUtils.resource("textures/entity/triceratops/legacy/green_triceratops_adult.png"), Component.translatable("pattern.fossilslegacy.green_tree_python"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/triceratops/legacy/green_triceratops_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, BROWN_TRICERATOPS_2011, Pattern.builder(FAUtils.resource("textures/entity/triceratops/legacy/brown_triceratops_adult.png"), Component.translatable("pattern.fossilslegacy.eastern_brown_snake"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/triceratops/legacy/brown_triceratops_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, TYRANNOSAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/tyrannosaurus/legacy/tyrannosaurus.png"), Component.translatable("pattern.fossilslegacy.eastern_brown_snake"), 0xFFFFFF).withAggressiveTexture(FAUtils.resource("textures/entity/tyrannosaurus/legacy/tyrannosaurus_aggressive.png")).withKnockedOutTexture(FAUtils.resource("textures/entity/tyrannosaurus/legacy/tyrannosaurus_weak.png")).build(basic));
        FAPatterns.register(bootstrapContext, GREEN_VELOCIRAPTOR_2011, Pattern.builder(FAUtils.resource("textures/entity/velociraptor/legacy/green_velociraptor_adult.png"), Component.translatable("pattern.fossilslegacy.green_tree_python"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/velociraptor/legacy/green_velociraptor_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, SANDY_VELOCIRAPTOR_2011, Pattern.builder(FAUtils.resource("textures/entity/velociraptor/legacy/sandy_velociraptor_adult.png"), Component.translatable("pattern.fossilslegacy.eastern_brown_snake"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/velociraptor/legacy/sandy_velociraptor_baby.png")).build(basic));
        FAPatterns.register(bootstrapContext, WHITE_VELOCIRAPTOR_2011, Pattern.builder(FAUtils.resource("textures/entity/velociraptor/legacy/white_velociraptor_adult.png"), Component.translatable("pattern.fossilslegacy.gray_ratsnake"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/velociraptor/legacy/white_velociraptor_baby.png")).build(basic));
    }
}
