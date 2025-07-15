package willatendo.fossilslegacy.server.pattern;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.entity.genetics.GeneticType;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FAPatterns {
    // Skins
    public static final ResourceKey<Pattern> AMAZON_RAINFOREST = FAPatterns.create("skins/amazon_rainforest");
    public static final ResourceKey<Pattern> CHAMPLAIN_VALLEY = FAPatterns.create("skins/champlain_valley");
    public static final ResourceKey<Pattern> DEATH_VALLEY = FAPatterns.create("skins/death_valley");
    public static final ResourceKey<Pattern> GAMBIA_RIVER_BASIN = FAPatterns.create("skins/gambia_river_basin");
    public static final ResourceKey<Pattern> GREAT_SANDY_DESERT = FAPatterns.create("skins/great_sandy_desert");
    public static final ResourceKey<Pattern> LIMPOPO_RIVER = FAPatterns.create("skins/limpopo_river");
    public static final ResourceKey<Pattern> MANGROVE_FOREST = FAPatterns.create("skins/mangrove_forest");
    public static final ResourceKey<Pattern> QILIAN_MOUNTAINS = FAPatterns.create("skins/qilian_mountains");
    public static final ResourceKey<Pattern> SALAR_DEL_HUASCO = FAPatterns.create("skins/salar_del_huasco");
    public static final ResourceKey<Pattern> SONORAN_DESERT = FAPatterns.create("skins/sonoran_desert");
    public static final ResourceKey<Pattern> SVALBARD = FAPatterns.create("skins/svalbard");
    public static final ResourceKey<Pattern> YUKON_RIVER = FAPatterns.create("skins/yukon_river");

    // Patterns
    public static final ResourceKey<Pattern> BLANK = FAPatterns.create("patterns/blank");
    public static final ResourceKey<Pattern> CHALCORANA = FAPatterns.create("patterns/chalcorana");
    public static final ResourceKey<Pattern> LITHOBATES = FAPatterns.create("patterns/lithobates");
    public static final ResourceKey<Pattern> PAPURANA = FAPatterns.create("patterns/papurana");
    public static final ResourceKey<Pattern> PELOPHYLAX = FAPatterns.create("patterns/pelophylax");
    public static final ResourceKey<Pattern> PULCHRANA = FAPatterns.create("patterns/pulchrana");
    public static final ResourceKey<Pattern> RANA = FAPatterns.create("patterns/rana");

    // Package Skins
    public static final ResourceKey<Pattern> ANKYLOSAURUS_2024 = FAPatterns.create("ankylosaurus_2024");
    public static final ResourceKey<Pattern> BARYONYX_2025 = FAPatterns.create("baryonyx_2025");
    public static final ResourceKey<Pattern> BRACHIOSAURUS_2024 = FAPatterns.create("brachiosaurus_2024");
    public static final ResourceKey<Pattern> GREEN_CARNOTAURUS_2024 = FAPatterns.create("green_carnotaurus_2024");
    public static final ResourceKey<Pattern> RED_CARNOTAURUS_2024 = FAPatterns.create("red_carnotaurus_2024");
    public static final ResourceKey<Pattern> COMPSOGNATHUS_2024 = FAPatterns.create("compsognathus_2024");
    public static final ResourceKey<Pattern> CRYOLOPHOSAURUS_2024 = FAPatterns.create("cryolophosaurus_2024");
    public static final ResourceKey<Pattern> DILOPHOSAURUS_2024 = FAPatterns.create("dilophosaurus_2024");
    public static final ResourceKey<Pattern> DIMETRODON_2024 = FAPatterns.create("dimetrodon_2024");
    public static final ResourceKey<Pattern> DISTORTUS_REX_2025 = FAPatterns.create("distortus_rex_2025");
    public static final ResourceKey<Pattern> DODO_2024 = FAPatterns.create("dodo_2024");
    public static final ResourceKey<Pattern> DRYOSAURUS_2025 = FAPatterns.create("dryosaurus_2025");
    public static final ResourceKey<Pattern> ELASMOTHERIUM_2025 = FAPatterns.create("elasmotherium_2025");
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
        FAPatterns.register(bootstrapContext, AMAZON_RAINFOREST, Pattern.builder(FAUtils.translation("skin", "amazon_rainforest"), 0x479678, GeneticType.DOMINANT).buildComposite("amazon_rainforest", 0));
        FAPatterns.register(bootstrapContext, CHAMPLAIN_VALLEY, Pattern.builder(FAUtils.translation("skin", "champlain_valley"), 0x654920, GeneticType.DOMINANT).buildComposite("champlain_valley", 0));
        FAPatterns.register(bootstrapContext, DEATH_VALLEY, Pattern.builder(FAUtils.translation("skin", "death_valley"), 0xAD8811, GeneticType.DOMINANT).buildComposite("death_valley", 0));
        FAPatterns.register(bootstrapContext, GAMBIA_RIVER_BASIN, Pattern.builder(FAUtils.translation("skin", "gambia_river_basin"), 0x6C6665, GeneticType.DOMINANT).buildComposite("gambia_river_basin", 0));
        FAPatterns.register(bootstrapContext, GREAT_SANDY_DESERT, Pattern.builder(FAUtils.translation("skin", "great_sandy_desert"), 0x5E6747, GeneticType.DOMINANT).buildComposite("great_sandy_desert", 0));
        FAPatterns.register(bootstrapContext, LIMPOPO_RIVER, Pattern.builder(FAUtils.translation("skin", "limpopo_river"), 0x4A331A, GeneticType.DOMINANT).buildComposite("limpopo_river", 0));
        FAPatterns.register(bootstrapContext, MANGROVE_FOREST, Pattern.builder(FAUtils.translation("skin", "mangrove_forest"), 0x5B753D, GeneticType.DOMINANT).buildComposite("mangrove_forest", 0));
        FAPatterns.register(bootstrapContext, QILIAN_MOUNTAINS, Pattern.builder(FAUtils.translation("skin", "qilian_mountains"), 0xA9A191, GeneticType.DOMINANT).buildComposite("qilian_mountains", 0));
        FAPatterns.register(bootstrapContext, SALAR_DEL_HUASCO, Pattern.builder(FAUtils.translation("skin", "salar_del_huasco"), 0x4A4018, GeneticType.DOMINANT).buildComposite("salar_del_huasco", 0));
        FAPatterns.register(bootstrapContext, SONORAN_DESERT, Pattern.builder(FAUtils.translation("skin", "sonoran_desert"), 0xB4813E, GeneticType.DOMINANT).buildComposite("sonoran_desert", 0));
        FAPatterns.register(bootstrapContext, SVALBARD, Pattern.builder(FAUtils.translation("skin", "svalbard"), 0x837B53, GeneticType.DOMINANT).buildComposite("svalbard", 0));
        FAPatterns.register(bootstrapContext, YUKON_RIVER, Pattern.builder(FAUtils.translation("skin", "yukon_river"), 0x88724D, GeneticType.DOMINANT).buildComposite("yukon_river", 0));

        FAPatterns.register(bootstrapContext, BLANK, new Pattern());
        FAPatterns.register(bootstrapContext, CHALCORANA, Pattern.builder(FAUtils.translation("pattern", "chalcorana"), 0x72A03C, GeneticType.DOMINANT).buildComposite("chalcorana", 1));
        FAPatterns.register(bootstrapContext, LITHOBATES, Pattern.builder(FAUtils.translation("pattern", "lithobates"), 0x38220B, GeneticType.DOMINANT).buildComposite("lithobates", 1));
        FAPatterns.register(bootstrapContext, PAPURANA, Pattern.builder(FAUtils.translation("pattern", "papurana"), 0xBD5F1C, GeneticType.DOMINANT).buildComposite("papurana", 1));
        FAPatterns.register(bootstrapContext, PELOPHYLAX, Pattern.builder(FAUtils.translation("pattern", "pelophylax"), 0x45B58F, GeneticType.DOMINANT).buildComposite("pelophylax", 1));
        FAPatterns.register(bootstrapContext, PULCHRANA, Pattern.builder(FAUtils.translation("pattern", "pulchrana"), 0x241D16, GeneticType.DOMINANT).buildComposite("pulchrana", 1));
        FAPatterns.register(bootstrapContext, RANA, Pattern.builder(FAUtils.translation("pattern", "rana"), 0x48290A, GeneticType.DOMINANT).buildComposite("rana", 1));

        FAPatterns.register(bootstrapContext, ANKYLOSAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/ankylosaurus/ankylosaurus.png"), Component.translatable("skin.fossilslegacy.eastern_brown_snake"), 0xFFFFFF, GeneticType.DOMINANT).buildPackage());
        FAPatterns.register(bootstrapContext, BARYONYX_2025, Pattern.builder(FAUtils.resource("textures/entity/baryonyx/baryonyx.png"), Component.translatable("skin.fossilslegacy.blue_iguana"), 0x3F4D71, GeneticType.DOMINANT).buildPackage());
        FAPatterns.register(bootstrapContext, BRACHIOSAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/brachiosaurus/brachiosaurus.png"), Component.translatable("skin.fossilslegacy.blue_iguana"), 0xFFFFFF, GeneticType.DOMINANT).buildPackage());
        FAPatterns.register(bootstrapContext, GREEN_CARNOTAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/carnotaurus/green_carnotaurus_adult.png"), Component.translatable("skin.fossilslegacy.green_tree_python"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/carnotaurus/red_carnotaurus_baby.png")).buildPackage());
        FAPatterns.register(bootstrapContext, RED_CARNOTAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/carnotaurus/red_carnotaurus_adult.png"), Component.translatable("skin.fossilslegacy.northern_cardinal"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/carnotaurus/green_carnotaurus_baby.png")).buildPackage());
        FAPatterns.register(bootstrapContext, COMPSOGNATHUS_2024, Pattern.builder(FAUtils.resource("textures/entity/compsognathus/compsognathus.png"), Component.translatable("skin.fossilslegacy.green_tree_python"), 0xFFFFFF, GeneticType.DOMINANT).buildPackage());
        FAPatterns.register(bootstrapContext, CRYOLOPHOSAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/cryolophosaurus/cryolophosaurus.png"), Component.translatable("skin.fossilslegacy.blue_iguana"), 0xFFFFFF, GeneticType.DOMINANT).buildPackage());
        FAPatterns.register(bootstrapContext, DILOPHOSAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/dilophosaurus/dilophosaurus.png"), Component.translatable("skin.fossilslegacy.inland_taipan"), 0xFFFFFF, GeneticType.DOMINANT).withAggressiveTexture(FAUtils.resource("textures/entity/dilophosaurus/aggressive_dilophosaurus.png")).buildPackage());
        FAPatterns.register(bootstrapContext, DIMETRODON_2024, Pattern.builder(FAUtils.resource("textures/entity/dimetrodon/dimetrodon_adult.png"), Component.translatable("skin.fossilslegacy.eastern_indigo_snake"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/dimetrodon/dimetrodon_baby.png")).withAggressiveTexture(FAUtils.resource("textures/entity/dimetrodon/dimetrodon_agressive.png")).buildPackage());
        FAPatterns.register(bootstrapContext, DISTORTUS_REX_2025, Pattern.builder(FAUtils.resource("textures/entity/distortus_rex/distortus_rex.png"), Component.translatable("skin.fossilslegacy.eastern_brown_snake"), 0xFFFFFF, GeneticType.DOMINANT).buildPackage());
        FAPatterns.register(bootstrapContext, DODO_2024, Pattern.builder(FAUtils.resource("textures/entity/dodo/dodo.png"), Component.translatable("skin.fossilslegacy.domestic_pigeon"), 0xFFFFFF, GeneticType.DOMINANT).buildPackage());
        FAPatterns.register(bootstrapContext, DRYOSAURUS_2025, Pattern.builder(FAUtils.resource("textures/entity/dryosaurus/dryosaurus.png"), Component.translatable("skin.fossilslegacy.green_tree_python"), 0xB3C15C, GeneticType.DOMINANT).buildPackage());
        FAPatterns.register(bootstrapContext, ELASMOTHERIUM_2025, Pattern.builder(FAUtils.resource("textures/entity/elasmotherium/elasmotherium.png"), Component.translatable("skin.fossilslegacy.american_bison"), 0xFFFFFF, GeneticType.DOMINANT).buildPackage());
        FAPatterns.register(bootstrapContext, FUTABASAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/futabasaurus/futabasaurus.png"), Component.translatable("skin.fossilslegacy.broadhead_skink"), 0xFFFFFF, GeneticType.DOMINANT).buildPackage());
        FAPatterns.register(bootstrapContext, GALLIMIMUS_2024, Pattern.builder(FAUtils.resource("textures/entity/gallimimus/gallimimus_adult.png"), Component.translatable("skin.fossilslegacy.broadhead_skink"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/gallimimus/gallimimus_baby.png")).buildPackage());
        FAPatterns.register(bootstrapContext, ICHTHYOSAURUS_2025, Pattern.builder(FAUtils.resource("textures/entity/ichthyosaurus/ichthyosaurus.png"), Component.translatable("skin.fossilslegacy.blue_iguana"), 0xFFFFFF, GeneticType.DOMINANT).buildPackage());
        FAPatterns.register(bootstrapContext, MAMMOTH_2024, Pattern.builder(FAUtils.resource("textures/entity/mammoth/mammoth_adult.png"), Component.translatable("skin.fossilslegacy.american_bison"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/mammoth/mammoth_baby.png")).withFurTexture(FAUtils.resource("textures/entity/mammoth/mammoth_adult_fur.png")).withBabyFurTexture(FAUtils.resource("textures/entity/mammoth/mammoth_baby_fur.png")).withShearedTexture(FAUtils.resource("textures/entity/mammoth/mammoth_adult_sheared.png")).buildPackage());
        FAPatterns.register(bootstrapContext, MOSASAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/mosasaurus/mosasaurus.png"), Component.translatable("skin.fossilslegacy.marine_iguana"), 0xFFFFFF, GeneticType.DOMINANT).withEyeLayerTexture(FAUtils.resource("textures/entity/mosasaurus/mosasaurus_eyes.png")).buildPackage());
        FAPatterns.register(bootstrapContext, MOA_2024, Pattern.builder(FAUtils.resource("textures/entity/moa/moa.png"), Component.translatable("skin.fossilslegacy.american_bison"), 0xFFFFFF, GeneticType.DOMINANT).buildPackage());
        FAPatterns.register(bootstrapContext, PACHYCEPHALOSAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/pachycephalosaurus/pachycephalosaurus_adult.png"), Component.translatable("skin.fossilslegacy.broadhead_skink"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/pachycephalosaurus/pachycephalosaurus_baby.png")).buildPackage());
        FAPatterns.register(bootstrapContext, PTERANODON_2024, Pattern.builder(FAUtils.resource("textures/entity/pteranodon/pteranodon_adult.png"), Component.translatable("skin.fossilslegacy.eastern_indigo_snake"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/pteranodon/pteranodon_baby.png")).buildPackage());
        FAPatterns.register(bootstrapContext, SMILODON_2024, Pattern.builder(FAUtils.resource("textures/entity/smilodon/smilodon_adult.png"), Component.translatable("skin.fossilslegacy.tiger"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/smilodon/smilodon_baby.png")).buildPackage());
        FAPatterns.register(bootstrapContext, SPINOSAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/spinosaurus/spinosaurus_adult.png"), Component.translatable("skin.fossilslegacy.marine_iguana"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/spinosaurus/spinosaurus_baby.png")).buildPackage());
        FAPatterns.register(bootstrapContext, STEGOSAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/stegosaurus/stegosaurus_adult.png"), Component.translatable("skin.fossilslegacy.green_tree_python"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/stegosaurus/stegosaurus_baby.png")).buildPackage());
        FAPatterns.register(bootstrapContext, THERIZINOSAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/therizinosaurus/therizinosaurus_adult.png"), Component.translatable("skin.fossilslegacy.green_parakeet"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/therizinosaurus/therizinosaurus_baby.png")).buildPackage());
        FAPatterns.register(bootstrapContext, GREEN_TRICERATOPS_2024, Pattern.builder(FAUtils.resource("textures/entity/triceratops/green_triceratops_adult.png"), Component.translatable("skin.fossilslegacy.green_tree_python"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/triceratops/green_triceratops_baby.png")).buildPackage());
        FAPatterns.register(bootstrapContext, BROWN_TRICERATOPS_2024, Pattern.builder(FAUtils.resource("textures/entity/triceratops/brown_triceratops_adult.png"), Component.translatable("skin.fossilslegacy.eastern_brown_snake"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/triceratops/brown_triceratops_baby.png")).buildPackage());
        FAPatterns.register(bootstrapContext, TYRANNOSAURUS_2024, Pattern.builder(FAUtils.resource("textures/entity/tyrannosaurus/tyrannosaurus_adult.png"), Component.translatable("skin.fossilslegacy.eastern_brown_snake"), 0xFFFFFF, GeneticType.DOMINANT).withAggressiveTexture(FAUtils.resource("textures/entity/tyrannosaurus/tyrannosaurus_aggressive.png")).withKnockedOutTexture(FAUtils.resource("textures/entity/tyrannosaurus/tyrannosaurus_weak.png")).withBabyTexture(FAUtils.resource("textures/entity/tyrannosaurus/tyrannosaurus_baby.png")).buildPackage());
        FAPatterns.register(bootstrapContext, GREEN_VELOCIRAPTOR_2024, Pattern.builder(FAUtils.resource("textures/entity/velociraptor/green_velociraptor_adult.png"), Component.translatable("skin.fossilslegacy.green_tree_python"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/velociraptor/green_velociraptor_baby.png")).buildPackage());
        FAPatterns.register(bootstrapContext, SANDY_VELOCIRAPTOR_2024, Pattern.builder(FAUtils.resource("textures/entity/velociraptor/sandy_velociraptor_adult.png"), Component.translatable("skin.fossilslegacy.eastern_brown_snake"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/velociraptor/sandy_velociraptor_baby.png")).buildPackage());
        FAPatterns.register(bootstrapContext, WHITE_VELOCIRAPTOR_2024, Pattern.builder(FAUtils.resource("textures/entity/velociraptor/white_velociraptor_adult.png"), Component.translatable("skin.fossilslegacy.gray_ratsnake"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/velociraptor/white_velociraptor_baby.png")).buildPackage());

        FAPatterns.register(bootstrapContext, BRACHIOSAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/brachiosaurus/legacy/brachiosaurus.png"), Component.translatable("skin.fossilslegacy.blue_iguana"), 0xFFFFFF, GeneticType.DOMINANT).buildPackage());
        FAPatterns.register(bootstrapContext, GREEN_CARNOTAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/carnotaurus/legacy/green_carnotaurus.png"), Component.translatable("skin.fossilslegacy.green_tree_python"), 0xFFFFFF, GeneticType.DOMINANT).buildPackage());
        FAPatterns.register(bootstrapContext, RED_CARNOTAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/carnotaurus/legacy/red_carnotaurus.png"), Component.translatable("skin.fossilslegacy.northern_cardinal"), 0xFFFFFF, GeneticType.DOMINANT).buildPackage());
        FAPatterns.register(bootstrapContext, CRYOLOPHOSAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/cryolophosaurus/legacy/cryolophosaurus.png"), Component.translatable("skin.fossilslegacy.blue_iguana"), 0xFFFFFF, GeneticType.DOMINANT).buildPackage());
        FAPatterns.register(bootstrapContext, DILOPHOSAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/dilophosaurus/legacy/dilophosaurus.png"), Component.translatable("skin.fossilslegacy.inland_taipan"), 0xFFFFFF, GeneticType.DOMINANT).withAggressiveTexture(FAUtils.resource("textures/entity/dilophosaurus/legacy/dilophosaurus_aggressive.png")).buildPackage());
        FAPatterns.register(bootstrapContext, FUTABASAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/futabasaurus/legacy/futabasaurus.png"), Component.translatable("skin.fossilslegacy.broadhead_skink"), 0xFFFFFF, GeneticType.DOMINANT).buildPackage());
        FAPatterns.register(bootstrapContext, MAMMOTH_2011, Pattern.builder(FAUtils.resource("textures/entity/mammoth/legacy/mammoth_adult.png"), Component.translatable("skin.fossilslegacy.american_bison"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/mammoth/legacy/mammoth_baby.png")).withFurTexture(FAUtils.resource("textures/entity/mammoth/legacy/mammoth_adult_fur.png")).withBabyFurTexture(FAUtils.resource("textures/entity/mammoth/legacy/mammoth_baby_fur.png")).withShearedTexture(FAUtils.resource("textures/entity/mammoth/legacy/mammoth_adult_sheared.png")).buildPackage());
        FAPatterns.register(bootstrapContext, MOSASAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/mosasaurus/legacy/mosasaurus.png"), Component.translatable("skin.fossilslegacy.marine_iguana"), 0xFFFFFF, GeneticType.DOMINANT).withEyeLayerTexture(FAUtils.resource("textures/entity/mosasaurus/legacy/mosasaurus_eyes.png")).buildPackage());
        FAPatterns.register(bootstrapContext, PTERANODON_2011, Pattern.builder(FAUtils.resource("textures/entity/pteranodon/legacy/pteranodon.png"), Component.translatable("skin.fossilslegacy.eastern_indigo_snake"), 0xFFFFFF, GeneticType.DOMINANT).buildPackage());
        FAPatterns.register(bootstrapContext, SMILODON_2011, Pattern.builder(FAUtils.resource("textures/entity/smilodon/legacy/smilodon_adult.png"), Component.translatable("skin.fossilslegacy.tiger"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/smilodon/legacy/smilodon_baby.png")).buildPackage());
        FAPatterns.register(bootstrapContext, STEGOSAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/stegosaurus/legacy/stegosaurus_adult.png"), Component.translatable("skin.fossilslegacy.green_tree_python"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/stegosaurus/legacy/stegosaurus_baby.png")).buildPackage());
        FAPatterns.register(bootstrapContext, FEATHERED_THERIZINOSAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/therizinosaurus/legacy/therizinosaurus_feathered.png"), Component.translatable("skin.fossilslegacy.green_parakeet"), 0xFFFFFF, GeneticType.DOMINANT).buildPackage());
        FAPatterns.register(bootstrapContext, FEATHERLESS_THERIZINOSAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/therizinosaurus/legacy/therizinosaurus_featherless.png"), Component.translatable("skin.fossilslegacy.green_tree_python"), 0xFFFFFF, GeneticType.DOMINANT).buildPackage());
        FAPatterns.register(bootstrapContext, GREEN_TRICERATOPS_2011, Pattern.builder(FAUtils.resource("textures/entity/triceratops/legacy/green_triceratops_adult.png"), Component.translatable("skin.fossilslegacy.green_tree_python"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/triceratops/legacy/green_triceratops_baby.png")).buildPackage());
        FAPatterns.register(bootstrapContext, BROWN_TRICERATOPS_2011, Pattern.builder(FAUtils.resource("textures/entity/triceratops/legacy/brown_triceratops_adult.png"), Component.translatable("skin.fossilslegacy.eastern_brown_snake"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/triceratops/legacy/brown_triceratops_baby.png")).buildPackage());
        FAPatterns.register(bootstrapContext, TYRANNOSAURUS_2011, Pattern.builder(FAUtils.resource("textures/entity/tyrannosaurus/legacy/tyrannosaurus.png"), Component.translatable("skin.fossilslegacy.eastern_brown_snake"), 0xFFFFFF, GeneticType.DOMINANT).withAggressiveTexture(FAUtils.resource("textures/entity/tyrannosaurus/legacy/tyrannosaurus_aggressive.png")).withKnockedOutTexture(FAUtils.resource("textures/entity/tyrannosaurus/legacy/tyrannosaurus_weak.png")).buildPackage());
        FAPatterns.register(bootstrapContext, GREEN_VELOCIRAPTOR_2011, Pattern.builder(FAUtils.resource("textures/entity/velociraptor/legacy/green_velociraptor_adult.png"), Component.translatable("skin.fossilslegacy.green_tree_python"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/velociraptor/legacy/green_velociraptor_baby.png")).buildPackage());
        FAPatterns.register(bootstrapContext, SANDY_VELOCIRAPTOR_2011, Pattern.builder(FAUtils.resource("textures/entity/velociraptor/legacy/sandy_velociraptor_adult.png"), Component.translatable("skin.fossilslegacy.eastern_brown_snake"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/velociraptor/legacy/sandy_velociraptor_baby.png")).buildPackage());
        FAPatterns.register(bootstrapContext, WHITE_VELOCIRAPTOR_2011, Pattern.builder(FAUtils.resource("textures/entity/velociraptor/legacy/white_velociraptor_adult.png"), Component.translatable("skin.fossilslegacy.gray_ratsnake"), 0xFFFFFF, GeneticType.DOMINANT).withBabyTexture(FAUtils.resource("textures/entity/velociraptor/legacy/white_velociraptor_baby.png")).buildPackage());
    }
}
