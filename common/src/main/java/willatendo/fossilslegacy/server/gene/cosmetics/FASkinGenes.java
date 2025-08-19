package willatendo.fossilslegacy.server.gene.cosmetics;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FASkinGenes {
    public static final ResourceKey<SkinGene> AMAZON_RAINFOREST = FASkinGenes.create("amazon_rainforest");
    public static final ResourceKey<SkinGene> CHAMPLAIN_VALLEY = FASkinGenes.create("champlain_valley");
    public static final ResourceKey<SkinGene> DEATH_VALLEY = FASkinGenes.create("death_valley");
    public static final ResourceKey<SkinGene> GAMBIA_RIVER_BASIN = FASkinGenes.create("gambia_river_basin");
    public static final ResourceKey<SkinGene> GREAT_SANDY_DESERT = FASkinGenes.create("great_sandy_desert");
    public static final ResourceKey<SkinGene> LIMPOPO_RIVER = FASkinGenes.create("limpopo_river");
    public static final ResourceKey<SkinGene> MANGROVE_FOREST = FASkinGenes.create("mangrove_forest");
    public static final ResourceKey<SkinGene> QILIAN_MOUNTAINS = FASkinGenes.create("qilian_mountains");
    public static final ResourceKey<SkinGene> SALAR_DEL_HUASCO = FASkinGenes.create("salar_del_huasco");
    public static final ResourceKey<SkinGene> SONORAN_DESERT = FASkinGenes.create("sonoran_desert");
    public static final ResourceKey<SkinGene> SVALBARD = FASkinGenes.create("svalbard");
    public static final ResourceKey<SkinGene> YUKON_RIVER = FASkinGenes.create("yukon_river");

    public static final ResourceKey<SkinGene> ANKYLOSAURUS_2024 = FASkinGenes.create("ankylosaurus_2024");
    public static final ResourceKey<SkinGene> BARYONYX_2025 = FASkinGenes.create("baryonyx_2025");
    public static final ResourceKey<SkinGene> BRACHIOSAURUS_2024 = FASkinGenes.create("brachiosaurus_2024");
    public static final ResourceKey<SkinGene> GREEN_CARNOTAURUS_2024 = FASkinGenes.create("green_carnotaurus_2024");
    public static final ResourceKey<SkinGene> RED_CARNOTAURUS_2024 = FASkinGenes.create("red_carnotaurus_2024");
    public static final ResourceKey<SkinGene> COMPSOGNATHUS_2024 = FASkinGenes.create("compsognathus_2024");
    public static final ResourceKey<SkinGene> CRYOLOPHOSAURUS_2024 = FASkinGenes.create("cryolophosaurus_2024");
    public static final ResourceKey<SkinGene> DILOPHOSAURUS_2024 = FASkinGenes.create("dilophosaurus_2024");
    public static final ResourceKey<SkinGene> DIMETRODON_2024 = FASkinGenes.create("dimetrodon_2024");
    public static final ResourceKey<SkinGene> DISTORTUS_REX_2025 = FASkinGenes.create("distortus_rex_2025");
    public static final ResourceKey<SkinGene> DODO_2024 = FASkinGenes.create("dodo_2024");
    public static final ResourceKey<SkinGene> DRYOSAURUS_2025 = FASkinGenes.create("dryosaurus_2025");
    public static final ResourceKey<SkinGene> ELASMOTHERIUM_2025 = FASkinGenes.create("elasmotherium_2025");
    public static final ResourceKey<SkinGene> FUTABASAURUS_2024 = FASkinGenes.create("futabasaurus_2024");
    public static final ResourceKey<SkinGene> GALLIMIMUS_2024 = FASkinGenes.create("gallimimus_2024");
    public static final ResourceKey<SkinGene> ICHTHYOSAURUS_2025 = FASkinGenes.create("ichthyosaurus_2025");
    public static final ResourceKey<SkinGene> ISOTELUS_2025 = FASkinGenes.create("isotelus_2025");
    public static final ResourceKey<SkinGene> ISOTELUS_LARVA_2025 = FASkinGenes.create("isotelus_larva_2025");
    public static final ResourceKey<SkinGene> MAMMOTH_2024 = FASkinGenes.create("mammoth_2024");
    public static final ResourceKey<SkinGene> MOA_2024 = FASkinGenes.create("moa_2024");
    public static final ResourceKey<SkinGene> MOSASAURUS_2024 = FASkinGenes.create("mosasaurus_2024");
    public static final ResourceKey<SkinGene> PACHYCEPHALOSAURUS_2024 = FASkinGenes.create("pachycephalosaurus_2024");
    public static final ResourceKey<SkinGene> PTERANODON_2024 = FASkinGenes.create("pteranodon_2024");
    public static final ResourceKey<SkinGene> SMILODON_2024 = FASkinGenes.create("smilodon_2024");
    public static final ResourceKey<SkinGene> SPINOSAURUS_2024 = FASkinGenes.create("spinosaurus_2024");
    public static final ResourceKey<SkinGene> STEGOSAURUS_2024 = FASkinGenes.create("stegosaurus_2024");
    public static final ResourceKey<SkinGene> THERIZINOSAURUS_2024 = FASkinGenes.create("therizinosaurus_2024");
    public static final ResourceKey<SkinGene> GREEN_TRICERATOPS_2024 = FASkinGenes.create("green_triceratops_2024");
    public static final ResourceKey<SkinGene> BROWN_TRICERATOPS_2024 = FASkinGenes.create("brown_triceratops_2024");
    public static final ResourceKey<SkinGene> TYRANNOSAURUS_2024 = FASkinGenes.create("tyrannosaurus_2024");
    public static final ResourceKey<SkinGene> GREEN_VELOCIRAPTOR_2024 = FASkinGenes.create("green_velociraptor_2024");
    public static final ResourceKey<SkinGene> SANDY_VELOCIRAPTOR_2024 = FASkinGenes.create("sandy_velociraptor_2024");
    public static final ResourceKey<SkinGene> WHITE_VELOCIRAPTOR_2024 = FASkinGenes.create("white_velociraptor_2024");

    public static final ResourceKey<SkinGene> BRACHIOSAURUS_2011 = FASkinGenes.create("brachiosaurus_2011");
    public static final ResourceKey<SkinGene> GREEN_CARNOTAURUS_2011 = FASkinGenes.create("green_carnotaurus_2011");
    public static final ResourceKey<SkinGene> RED_CARNOTAURUS_2011 = FASkinGenes.create("red_carnotaurus_2011");
    public static final ResourceKey<SkinGene> CRYOLOPHOSAURUS_2011 = FASkinGenes.create("cryolophosaurus_2011");
    public static final ResourceKey<SkinGene> DILOPHOSAURUS_2011 = FASkinGenes.create("dilophosaurus_2011");
    public static final ResourceKey<SkinGene> FUTABASAURUS_2011 = FASkinGenes.create("futabasaurus_2011");
    public static final ResourceKey<SkinGene> MAMMOTH_2011 = FASkinGenes.create("mammoth_2011");
    public static final ResourceKey<SkinGene> MOSASAURUS_2011 = FASkinGenes.create("mosasaurus_2011");
    public static final ResourceKey<SkinGene> PTERANODON_2011 = FASkinGenes.create("pteranodon_2011");
    public static final ResourceKey<SkinGene> SMILODON_2011 = FASkinGenes.create("smilodon_2011");
    public static final ResourceKey<SkinGene> STEGOSAURUS_2011 = FASkinGenes.create("stegosaurus_2011");
    public static final ResourceKey<SkinGene> FEATHERED_THERIZINOSAURUS_2011 = FASkinGenes.create("feathered_therizinosaurus_2011");
    public static final ResourceKey<SkinGene> FEATHERLESS_THERIZINOSAURUS_2011 = FASkinGenes.create("featherless_therizinosaurus_2011");
    public static final ResourceKey<SkinGene> GREEN_TRICERATOPS_2011 = FASkinGenes.create("green_triceratops_2011");
    public static final ResourceKey<SkinGene> BROWN_TRICERATOPS_2011 = FASkinGenes.create("brown_triceratops_2011");
    public static final ResourceKey<SkinGene> TYRANNOSAURUS_2011 = FASkinGenes.create("tyrannosaurus_2011");
    public static final ResourceKey<SkinGene> GREEN_VELOCIRAPTOR_2011 = FASkinGenes.create("green_velociraptor_2011");
    public static final ResourceKey<SkinGene> SANDY_VELOCIRAPTOR_2011 = FASkinGenes.create("sandy_velociraptor_2011");
    public static final ResourceKey<SkinGene> WHITE_VELOCIRAPTOR_2011 = FASkinGenes.create("white_velociraptor_2011");

    private static ResourceKey<SkinGene> create(String name) {
        return ResourceKey.create(FARegistries.SKIN_GENE, FAUtils.resource(name));
    }

    private static void register(BootstrapContext<SkinGene> bootstrapContext, ResourceKey<SkinGene> resourceKey, SkinGene skinGene) {
        bootstrapContext.register(resourceKey, skinGene);
    }

    public static void bootstrap(BootstrapContext<SkinGene> bootstrapContext) {
        FASkinGenes.register(bootstrapContext, AMAZON_RAINFOREST, SkinGene.builder(FAUtils.translation("skinGenes", "amazon_rainforest"), 0x479678).buildComposite("amazon_rainforest"));
        FASkinGenes.register(bootstrapContext, CHAMPLAIN_VALLEY, SkinGene.builder(FAUtils.translation("skinGenes", "champlain_valley"), 0x654920).buildComposite("champlain_valley"));
        FASkinGenes.register(bootstrapContext, DEATH_VALLEY, SkinGene.builder(FAUtils.translation("skinGenes", "death_valley"), 0xAD8811).buildComposite("death_valley"));
        FASkinGenes.register(bootstrapContext, GAMBIA_RIVER_BASIN, SkinGene.builder(FAUtils.translation("skinGenes", "gambia_river_basin"), 0x6C6665).buildComposite("gambia_river_basin"));
        FASkinGenes.register(bootstrapContext, GREAT_SANDY_DESERT, SkinGene.builder(FAUtils.translation("skinGenes", "great_sandy_desert"), 0x5E6747).buildComposite("great_sandy_desert"));
        FASkinGenes.register(bootstrapContext, LIMPOPO_RIVER, SkinGene.builder(FAUtils.translation("skinGenes", "limpopo_river"), 0x4A331A).buildComposite("limpopo_river"));
        FASkinGenes.register(bootstrapContext, MANGROVE_FOREST, SkinGene.builder(FAUtils.translation("skinGenes", "mangrove_forest"), 0x5B753D).buildComposite("mangrove_forest"));
        FASkinGenes.register(bootstrapContext, QILIAN_MOUNTAINS, SkinGene.builder(FAUtils.translation("skinGenes", "qilian_mountains"), 0xA9A191).buildComposite("qilian_mountains"));
        FASkinGenes.register(bootstrapContext, SALAR_DEL_HUASCO, SkinGene.builder(FAUtils.translation("skinGenes", "salar_del_huasco"), 0x4A4018).buildComposite("salar_del_huasco"));
        FASkinGenes.register(bootstrapContext, SONORAN_DESERT, SkinGene.builder(FAUtils.translation("skinGenes", "sonoran_desert"), 0xB4813E).buildComposite("sonoran_desert"));
        FASkinGenes.register(bootstrapContext, SVALBARD, SkinGene.builder(FAUtils.translation("skinGenes", "svalbard"), 0x837B53).buildComposite("svalbard"));
        FASkinGenes.register(bootstrapContext, YUKON_RIVER, SkinGene.builder(FAUtils.translation("skinGenes", "yukon_river"), 0x88724D).buildComposite("yukon_river"));

        FASkinGenes.register(bootstrapContext, ANKYLOSAURUS_2024, SkinGene.builder(FAUtils.resource("textures/entity/ankylosaurus/ankylosaurus.png"), Component.translatable("skinGenes.fossilslegacy.eastern_brown_snake"), 0xFFFFFF).withEyeLayerTexture(FAUtils.resource("textures/entity/ankylosaurus/eyes/adult.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, BARYONYX_2025, SkinGene.builder(FAUtils.resource("textures/entity/baryonyx/baryonyx.png"), Component.translatable("skinGenes.fossilslegacy.blue_iguana"), 0x3F4D71).buildPackage());
        FASkinGenes.register(bootstrapContext, BRACHIOSAURUS_2024, SkinGene.builder(FAUtils.resource("textures/entity/brachiosaurus/brachiosaurus.png"), Component.translatable("skinGenes.fossilslegacy.blue_iguana"), 0xFFFFFF).buildPackage());
        FASkinGenes.register(bootstrapContext, GREEN_CARNOTAURUS_2024, SkinGene.builder(FAUtils.resource("textures/entity/carnotaurus/green_carnotaurus_adult.png"), Component.translatable("skinGenes.fossilslegacy.green_tree_python"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/carnotaurus/red_carnotaurus_baby.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, RED_CARNOTAURUS_2024, SkinGene.builder(FAUtils.resource("textures/entity/carnotaurus/red_carnotaurus_adult.png"), Component.translatable("skinGenes.fossilslegacy.northern_cardinal"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/carnotaurus/green_carnotaurus_baby.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, COMPSOGNATHUS_2024, SkinGene.builder(FAUtils.resource("textures/entity/compsognathus/compsognathus.png"), Component.translatable("skinGenes.fossilslegacy.green_tree_python"), 0xFFFFFF).buildPackage());
        FASkinGenes.register(bootstrapContext, CRYOLOPHOSAURUS_2024, SkinGene.builder(FAUtils.resource("textures/entity/cryolophosaurus/cryolophosaurus.png"), Component.translatable("skinGenes.fossilslegacy.blue_iguana"), 0xFFFFFF).buildPackage());
        FASkinGenes.register(bootstrapContext, DILOPHOSAURUS_2024, SkinGene.builder(FAUtils.resource("textures/entity/dilophosaurus/dilophosaurus.png"), Component.translatable("skinGenes.fossilslegacy.inland_taipan"), 0xFFFFFF).withAggressiveTexture(FAUtils.resource("textures/entity/dilophosaurus/aggressive_dilophosaurus.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, DIMETRODON_2024, SkinGene.builder(FAUtils.resource("textures/entity/dimetrodon/dimetrodon_adult.png"), Component.translatable("skinGenes.fossilslegacy.eastern_indigo_snake"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/dimetrodon/dimetrodon_baby.png")).withAggressiveTexture(FAUtils.resource("textures/entity/dimetrodon/dimetrodon_agressive.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, DISTORTUS_REX_2025, SkinGene.builder(FAUtils.resource("textures/entity/distortus_rex/distortus_rex.png"), Component.translatable("skinGenes.fossilslegacy.eastern_brown_snake"), 0xFFFFFF).buildPackage());
        FASkinGenes.register(bootstrapContext, DODO_2024, SkinGene.builder(FAUtils.resource("textures/entity/dodo/dodo.png"), Component.translatable("skinGenes.fossilslegacy.domestic_pigeon"), 0xFFFFFF).buildPackage());
        FASkinGenes.register(bootstrapContext, DRYOSAURUS_2025, SkinGene.builder(FAUtils.resource("textures/entity/dryosaurus/dryosaurus.png"), Component.translatable("skinGenes.fossilslegacy.green_tree_python"), 0xB3C15C).buildPackage());
        FASkinGenes.register(bootstrapContext, ELASMOTHERIUM_2025, SkinGene.builder(FAUtils.resource("textures/entity/elasmotherium/elasmotherium.png"), Component.translatable("skinGenes.fossilslegacy.american_bison"), 0xFFFFFF).buildPackage());
        FASkinGenes.register(bootstrapContext, FUTABASAURUS_2024, SkinGene.builder(FAUtils.resource("textures/entity/futabasaurus/futabasaurus.png"), Component.translatable("skinGenes.fossilslegacy.broadhead_skink"), 0xFFFFFF).buildPackage());
        FASkinGenes.register(bootstrapContext, GALLIMIMUS_2024, SkinGene.builder(FAUtils.resource("textures/entity/gallimimus/gallimimus_adult.png"), Component.translatable("skinGenes.fossilslegacy.broadhead_skink"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/gallimimus/gallimimus_baby.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, ICHTHYOSAURUS_2025, SkinGene.builder(FAUtils.resource("textures/entity/ichthyosaurus/ichthyosaurus.png"), Component.translatable("skinGenes.fossilslegacy.blue_iguana"), 0xFFFFFF).buildPackage());
        FASkinGenes.register(bootstrapContext, ISOTELUS_2025, SkinGene.builder(FAUtils.resource("textures/entity/isotelus/isotelus.png"), Component.translatable("skinGenes.fossilslegacy.gray_ratsnake"), 0xFFFFFF).buildPackage());
        FASkinGenes.register(bootstrapContext, ISOTELUS_LARVA_2025, SkinGene.builder(FAUtils.resource("textures/entity/isotelus/isotelus_larva.png"), Component.translatable("skinGenes.fossilslegacy.gray_ratsnake"), 0xFFFFFF).buildPackage());
        FASkinGenes.register(bootstrapContext, MAMMOTH_2024, SkinGene.builder(FAUtils.resource("textures/entity/mammoth/mammoth_adult.png"), Component.translatable("skinGenes.fossilslegacy.american_bison"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/mammoth/mammoth_baby.png")).withFurTexture(FAUtils.resource("textures/entity/mammoth/mammoth_adult_fur.png")).withBabyFurTexture(FAUtils.resource("textures/entity/mammoth/mammoth_baby_fur.png")).withShearedTexture(FAUtils.resource("textures/entity/mammoth/mammoth_adult_sheared.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, MOSASAURUS_2024, SkinGene.builder(FAUtils.resource("textures/entity/mosasaurus/mosasaurus.png"), Component.translatable("skinGenes.fossilslegacy.marine_iguana"), 0xFFFFFF).withEyeLayerTexture(FAUtils.resource("textures/entity/mosasaurus/mosasaurus_eyes.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, MOA_2024, SkinGene.builder(FAUtils.resource("textures/entity/moa/moa.png"), Component.translatable("skinGenes.fossilslegacy.american_bison"), 0xFFFFFF).buildPackage());
        FASkinGenes.register(bootstrapContext, PACHYCEPHALOSAURUS_2024, SkinGene.builder(FAUtils.resource("textures/entity/pachycephalosaurus/pachycephalosaurus_adult.png"), Component.translatable("skinGenes.fossilslegacy.broadhead_skink"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/pachycephalosaurus/pachycephalosaurus_baby.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, PTERANODON_2024, SkinGene.builder(FAUtils.resource("textures/entity/pteranodon/pteranodon_adult.png"), Component.translatable("skinGenes.fossilslegacy.eastern_indigo_snake"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/pteranodon/pteranodon_baby.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, SMILODON_2024, SkinGene.builder(FAUtils.resource("textures/entity/smilodon/smilodon_adult.png"), Component.translatable("skinGenes.fossilslegacy.tiger"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/smilodon/smilodon_baby.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, SPINOSAURUS_2024, SkinGene.builder(FAUtils.resource("textures/entity/spinosaurus/spinosaurus_adult.png"), Component.translatable("skinGenes.fossilslegacy.marine_iguana"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/spinosaurus/spinosaurus_baby.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, STEGOSAURUS_2024, SkinGene.builder(FAUtils.resource("textures/entity/stegosaurus/stegosaurus_adult.png"), Component.translatable("skinGenes.fossilslegacy.green_tree_python"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/stegosaurus/stegosaurus_baby.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, THERIZINOSAURUS_2024, SkinGene.builder(FAUtils.resource("textures/entity/therizinosaurus/therizinosaurus_adult.png"), Component.translatable("skinGenes.fossilslegacy.green_parakeet"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/therizinosaurus/therizinosaurus_baby.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, GREEN_TRICERATOPS_2024, SkinGene.builder(FAUtils.resource("textures/entity/triceratops/green_triceratops_adult.png"), Component.translatable("skinGenes.fossilslegacy.green_tree_python"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/triceratops/green_triceratops_baby.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, BROWN_TRICERATOPS_2024, SkinGene.builder(FAUtils.resource("textures/entity/triceratops/brown_triceratops_adult.png"), Component.translatable("skinGenes.fossilslegacy.eastern_brown_snake"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/triceratops/brown_triceratops_baby.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, TYRANNOSAURUS_2024, SkinGene.builder(FAUtils.resource("textures/entity/tyrannosaurus/tyrannosaurus_adult.png"), Component.translatable("skinGenes.fossilslegacy.eastern_brown_snake"), 0xFFFFFF).withAggressiveTexture(FAUtils.resource("textures/entity/tyrannosaurus/tyrannosaurus_aggressive.png")).withKnockedOutTexture(FAUtils.resource("textures/entity/tyrannosaurus/tyrannosaurus_weak.png")).withBabyTexture(FAUtils.resource("textures/entity/tyrannosaurus/tyrannosaurus_baby.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, GREEN_VELOCIRAPTOR_2024, SkinGene.builder(FAUtils.resource("textures/entity/velociraptor/green_velociraptor_adult.png"), Component.translatable("skinGenes.fossilslegacy.green_tree_python"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/velociraptor/green_velociraptor_baby.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, SANDY_VELOCIRAPTOR_2024, SkinGene.builder(FAUtils.resource("textures/entity/velociraptor/sandy_velociraptor_adult.png"), Component.translatable("skinGenes.fossilslegacy.eastern_brown_snake"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/velociraptor/sandy_velociraptor_baby.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, WHITE_VELOCIRAPTOR_2024, SkinGene.builder(FAUtils.resource("textures/entity/velociraptor/white_velociraptor_adult.png"), Component.translatable("skinGenes.fossilslegacy.gray_ratsnake"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/velociraptor/white_velociraptor_baby.png")).buildPackage());

        FASkinGenes.register(bootstrapContext, BRACHIOSAURUS_2011, SkinGene.builder(FAUtils.resource("textures/entity/brachiosaurus/legacy/brachiosaurus.png"), Component.translatable("skinGenes.fossilslegacy.blue_iguana"), 0xFFFFFF).buildPackage());
        FASkinGenes.register(bootstrapContext, GREEN_CARNOTAURUS_2011, SkinGene.builder(FAUtils.resource("textures/entity/carnotaurus/legacy/green_carnotaurus.png"), Component.translatable("skinGenes.fossilslegacy.green_tree_python"), 0xFFFFFF).buildPackage());
        FASkinGenes.register(bootstrapContext, RED_CARNOTAURUS_2011, SkinGene.builder(FAUtils.resource("textures/entity/carnotaurus/legacy/red_carnotaurus.png"), Component.translatable("skinGenes.fossilslegacy.northern_cardinal"), 0xFFFFFF).buildPackage());
        FASkinGenes.register(bootstrapContext, CRYOLOPHOSAURUS_2011, SkinGene.builder(FAUtils.resource("textures/entity/cryolophosaurus/legacy/cryolophosaurus.png"), Component.translatable("skinGenes.fossilslegacy.blue_iguana"), 0xFFFFFF).buildPackage());
        FASkinGenes.register(bootstrapContext, DILOPHOSAURUS_2011, SkinGene.builder(FAUtils.resource("textures/entity/dilophosaurus/legacy/dilophosaurus.png"), Component.translatable("skinGenes.fossilslegacy.inland_taipan"), 0xFFFFFF).withAggressiveTexture(FAUtils.resource("textures/entity/dilophosaurus/legacy/dilophosaurus_aggressive.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, FUTABASAURUS_2011, SkinGene.builder(FAUtils.resource("textures/entity/futabasaurus/legacy/futabasaurus.png"), Component.translatable("skinGenes.fossilslegacy.broadhead_skink"), 0xFFFFFF).buildPackage());
        FASkinGenes.register(bootstrapContext, MAMMOTH_2011, SkinGene.builder(FAUtils.resource("textures/entity/mammoth/legacy/mammoth_adult.png"), Component.translatable("skinGenes.fossilslegacy.american_bison"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/mammoth/legacy/mammoth_baby.png")).withFurTexture(FAUtils.resource("textures/entity/mammoth/legacy/mammoth_adult_fur.png")).withBabyFurTexture(FAUtils.resource("textures/entity/mammoth/legacy/mammoth_baby_fur.png")).withShearedTexture(FAUtils.resource("textures/entity/mammoth/legacy/mammoth_adult_sheared.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, MOSASAURUS_2011, SkinGene.builder(FAUtils.resource("textures/entity/mosasaurus/legacy/mosasaurus.png"), Component.translatable("skinGenes.fossilslegacy.marine_iguana"), 0xFFFFFF).withEyeLayerTexture(FAUtils.resource("textures/entity/mosasaurus/legacy/mosasaurus_eyes.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, PTERANODON_2011, SkinGene.builder(FAUtils.resource("textures/entity/pteranodon/legacy/pteranodon.png"), Component.translatable("skinGenes.fossilslegacy.eastern_indigo_snake"), 0xFFFFFF).buildPackage());
        FASkinGenes.register(bootstrapContext, SMILODON_2011, SkinGene.builder(FAUtils.resource("textures/entity/smilodon/legacy/smilodon_adult.png"), Component.translatable("skinGenes.fossilslegacy.tiger"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/smilodon/legacy/smilodon_baby.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, STEGOSAURUS_2011, SkinGene.builder(FAUtils.resource("textures/entity/stegosaurus/legacy/stegosaurus_adult.png"), Component.translatable("skinGenes.fossilslegacy.green_tree_python"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/stegosaurus/legacy/stegosaurus_baby.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, FEATHERED_THERIZINOSAURUS_2011, SkinGene.builder(FAUtils.resource("textures/entity/therizinosaurus/legacy/therizinosaurus_feathered.png"), Component.translatable("skinGenes.fossilslegacy.green_parakeet"), 0xFFFFFF).buildPackage());
        FASkinGenes.register(bootstrapContext, FEATHERLESS_THERIZINOSAURUS_2011, SkinGene.builder(FAUtils.resource("textures/entity/therizinosaurus/legacy/therizinosaurus_featherless.png"), Component.translatable("skinGenes.fossilslegacy.green_tree_python"), 0xFFFFFF).buildPackage());
        FASkinGenes.register(bootstrapContext, GREEN_TRICERATOPS_2011, SkinGene.builder(FAUtils.resource("textures/entity/triceratops/legacy/green_triceratops_adult.png"), Component.translatable("skinGenes.fossilslegacy.green_tree_python"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/triceratops/legacy/green_triceratops_baby.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, BROWN_TRICERATOPS_2011, SkinGene.builder(FAUtils.resource("textures/entity/triceratops/legacy/brown_triceratops_adult.png"), Component.translatable("skinGenes.fossilslegacy.eastern_brown_snake"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/triceratops/legacy/brown_triceratops_baby.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, TYRANNOSAURUS_2011, SkinGene.builder(FAUtils.resource("textures/entity/tyrannosaurus/legacy/tyrannosaurus.png"), Component.translatable("skinGenes.fossilslegacy.eastern_brown_snake"), 0xFFFFFF).withAggressiveTexture(FAUtils.resource("textures/entity/tyrannosaurus/legacy/tyrannosaurus_aggressive.png")).withKnockedOutTexture(FAUtils.resource("textures/entity/tyrannosaurus/legacy/tyrannosaurus_weak.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, GREEN_VELOCIRAPTOR_2011, SkinGene.builder(FAUtils.resource("textures/entity/velociraptor/legacy/green_velociraptor_adult.png"), Component.translatable("skinGenes.fossilslegacy.green_tree_python"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/velociraptor/legacy/green_velociraptor_baby.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, SANDY_VELOCIRAPTOR_2011, SkinGene.builder(FAUtils.resource("textures/entity/velociraptor/legacy/sandy_velociraptor_adult.png"), Component.translatable("skinGenes.fossilslegacy.eastern_brown_snake"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/velociraptor/legacy/sandy_velociraptor_baby.png")).buildPackage());
        FASkinGenes.register(bootstrapContext, WHITE_VELOCIRAPTOR_2011, SkinGene.builder(FAUtils.resource("textures/entity/velociraptor/legacy/white_velociraptor_adult.png"), Component.translatable("skinGenes.fossilslegacy.gray_ratsnake"), 0xFFFFFF).withBabyTexture(FAUtils.resource("textures/entity/velociraptor/legacy/white_velociraptor_baby.png")).buildPackage());
    }
}
