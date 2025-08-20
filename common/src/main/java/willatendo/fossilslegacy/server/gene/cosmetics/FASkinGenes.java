package willatendo.fossilslegacy.server.gene.cosmetics;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.entity.FAEntityTypeReferences;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.CompositeTextureRules;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.TextureInformation;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.PackageTextureRules;
import willatendo.fossilslegacy.server.gene.inheritance.InheritanceRules;
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
        Component americanBison = Component.translatable("skin.fossilslegacy.american_bison");
        Component blueIguana = Component.translatable("skin.fossilslegacy.blue_iguana");
        Component broadheadSkink = Component.translatable("skin.fossilslegacy.broadhead_skink");
        Component domesticPigeon = Component.translatable("skin.fossilslegacy.domestic_pigeon");
        Component easternBrownSnake = Component.translatable("skin.fossilslegacy.eastern_brown_snake");
        Component easternIndigoSnake = Component.translatable("skin.fossilslegacy.eastern_indigo_snake");
        Component greenParkeet = Component.translatable("skin.fossilslegacy.green_parakeet");
        Component greenTreePython = Component.translatable("skin.fossilslegacy.green_tree_python");
        Component grayRatsnake = Component.translatable("skin.fossilslegacy.gray_ratsnake");
        Component inlandTaipan = Component.translatable("skin.fossilslegacy.inland_taipan");
        Component marineIguana = Component.translatable("skin.fossilslegacy.marine_iguana");
        Component northCardinal = Component.translatable("skin.fossilslegacy.northern_cardinal");
        Component tiger = Component.translatable("skin.fossilslegacy.tiger");
        FASkinGenes.register(
                bootstrapContext,
                AMAZON_RAINFOREST,
                SkinGene.createComposite(
                        FAUtils.translation("skin", "amazon_rainforest"),
                        0x479678,
                        InheritanceRules.always(),
                        CompositeTextureRules.sequence(
                                CompositeTextureRules.layer0("amazon_rainforest")
                        )
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                CHAMPLAIN_VALLEY,
                SkinGene.createComposite(
                        FAUtils.translation("skin", "champlain_valley"),
                        0x654920,
                        InheritanceRules.always(),
                        CompositeTextureRules.sequence(
                                CompositeTextureRules.layer0("champlain_valley")
                        )
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                DEATH_VALLEY,
                SkinGene.createComposite(
                        FAUtils.translation("skin", "death_valley"),
                        0xAD8811,
                        InheritanceRules.always(),
                        CompositeTextureRules.sequence(
                                CompositeTextureRules.layer0("death_valley")
                        )
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                GAMBIA_RIVER_BASIN,
                SkinGene.createComposite(
                        FAUtils.translation("skin", "gambia_river_basin"),
                        0x6C6665,
                        InheritanceRules.always(),
                        CompositeTextureRules.sequence(
                                CompositeTextureRules.layer0("gambia_river_basin")
                        )
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                GREAT_SANDY_DESERT,
                SkinGene.createComposite(
                        FAUtils.translation("skin", "great_sandy_desert"),
                        0x5E6747,
                        InheritanceRules.always(),
                        CompositeTextureRules.sequence(
                                CompositeTextureRules.layer0("great_sandy_desert")
                        )
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                LIMPOPO_RIVER,
                SkinGene.createComposite(
                        FAUtils.translation("skin", "limpopo_river"),
                        0x4A331A,
                        InheritanceRules.always(),
                        CompositeTextureRules.sequence(
                                CompositeTextureRules.layer0("limpopo_river")
                        )
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                MANGROVE_FOREST,
                SkinGene.createComposite(
                        FAUtils.translation("skin", "mangrove_forest"),
                        0x5B753D,
                        InheritanceRules.always(),
                        CompositeTextureRules.sequence(
                                CompositeTextureRules.layer0("mangrove_forest")
                        )
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                QILIAN_MOUNTAINS,
                SkinGene.createComposite(
                        FAUtils.translation("skin", "qilian_mountains"),
                        0xA9A191,
                        InheritanceRules.always(),
                        CompositeTextureRules.sequence(
                                CompositeTextureRules.layer0("qilian_mountains")
                        )
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                SALAR_DEL_HUASCO,
                SkinGene.createComposite(
                        FAUtils.translation("skin", "salar_del_huasco"),
                        0x4A4018,
                        InheritanceRules.always(),
                        CompositeTextureRules.sequence(
                                CompositeTextureRules.layer0("salar_del_huasco")
                        )
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                SONORAN_DESERT,
                SkinGene.createComposite(
                        FAUtils.translation("skin", "sonoran_desert"),
                        0xB4813E,
                        InheritanceRules.always(),
                        CompositeTextureRules.sequence(
                                CompositeTextureRules.layer0("sonoran_desert")
                        )
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                SVALBARD,
                SkinGene.createComposite(
                        FAUtils.translation("skin", "svalbard"),
                        0x837B53,
                        InheritanceRules.always(),
                        CompositeTextureRules.sequence(
                                CompositeTextureRules.layer0("svalbard")
                        )
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                YUKON_RIVER,
                SkinGene.createComposite(
                        FAUtils.translation("skin", "yukon_river"),
                        0x88724D,
                        InheritanceRules.always(),
                        CompositeTextureRules.sequence(
                                CompositeTextureRules.layer0("yukon_river")
                        )
                )
        );

        FASkinGenes.register(
                bootstrapContext,
                ANKYLOSAURUS_2024,
                SkinGene.createPackage(
                        easternBrownSnake,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence(
                                PackageTextureRules.ifTrue(
                                        PackageTextureRules.isBaby(),
                                        PackageTextureRules.texture(
                                                TextureInformation.simple(
                                                        FAUtils.resource("textures/entity/ankylosaurus/ankylosaurus.png"),
                                                        FAUtils.resource("textures/entity/ankylosaurus/eyes/baby.png"),
                                                        FAUtils.resource("textures/entity/ankylosaurus/eyes/closed.png")
                                                )
                                        )
                                ),
                                PackageTextureRules.texture(
                                        TextureInformation.simple(
                                                FAUtils.resource("textures/entity/ankylosaurus/ankylosaurus.png"),
                                                FAUtils.resource("textures/entity/ankylosaurus/eyes/adult.png"),
                                                FAUtils.resource("textures/entity/ankylosaurus/eyes/closed.png")
                                        )
                                )
                        )
                )
        );
        FASkinGenes.register(
                bootstrapContext, 
                BARYONYX_2025, 
                SkinGene.createPackage(
                        blueIguana, 
                        0x3F4D71,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                BRACHIOSAURUS_2024,
                SkinGene.createPackage(
                        blueIguana,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                GREEN_CARNOTAURUS_2024,
                SkinGene.createPackage(
                        greenTreePython,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                RED_CARNOTAURUS_2024,
                SkinGene.createPackage(
                        northCardinal,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                COMPSOGNATHUS_2024,
                SkinGene.createPackage(
                        greenTreePython,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                CRYOLOPHOSAURUS_2024,
                SkinGene.createPackage(
                        blueIguana, 0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                DILOPHOSAURUS_2024,
                SkinGene.createPackage(
                        inlandTaipan,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                DIMETRODON_2024,
                SkinGene.createPackage(
                        easternIndigoSnake,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                DISTORTUS_REX_2025,
                SkinGene.createPackage(
                        easternBrownSnake,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                DODO_2024,
                SkinGene.createPackage(
                        domesticPigeon,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                DRYOSAURUS_2025,
                SkinGene.createPackage(
                        greenTreePython,
                        0xB3C15C,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                ELASMOTHERIUM_2025,
                SkinGene.createPackage(
                        americanBison,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                FUTABASAURUS_2024,
                SkinGene.createPackage(
                        broadheadSkink,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                GALLIMIMUS_2024,
                SkinGene.createPackage(
                        broadheadSkink,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                ICHTHYOSAURUS_2025,
                SkinGene.createPackage(
                        blueIguana,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                ISOTELUS_2025,
                SkinGene.createPackage(
                        grayRatsnake,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                ISOTELUS_LARVA_2025,
                SkinGene.createPackage(
                        grayRatsnake,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                MAMMOTH_2024,
                SkinGene.createPackage(
                        americanBison,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                MOSASAURUS_2024,
                SkinGene.createPackage(
                        marineIguana,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                MOA_2024,
                SkinGene.createPackage(
                        americanBison,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                PACHYCEPHALOSAURUS_2024,
                SkinGene.createPackage(
                        broadheadSkink,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                PTERANODON_2024,
                SkinGene.createPackage(
                        easternIndigoSnake,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                SMILODON_2024,
                SkinGene.createPackage(
                        tiger,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                SPINOSAURUS_2024,
                SkinGene.createPackage(
                        marineIguana,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                STEGOSAURUS_2024,
                SkinGene.createPackage(
                        greenTreePython,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                THERIZINOSAURUS_2024,
                SkinGene.createPackage(
                        greenParkeet,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                GREEN_TRICERATOPS_2024,
                SkinGene.createPackage(
                        greenTreePython,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                BROWN_TRICERATOPS_2024,
                SkinGene.createPackage(
                        easternBrownSnake,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                TYRANNOSAURUS_2024,
                SkinGene.createPackage(
                        easternBrownSnake,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                GREEN_VELOCIRAPTOR_2024,
                SkinGene.createPackage(
                        greenTreePython,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                SANDY_VELOCIRAPTOR_2024,
                SkinGene.createPackage(
                        easternBrownSnake,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                WHITE_VELOCIRAPTOR_2024,
                SkinGene.createPackage(
                        grayRatsnake,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );

        FASkinGenes.register(
                bootstrapContext,
                BRACHIOSAURUS_2011,
                SkinGene.createPackage(
                        blueIguana,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                GREEN_CARNOTAURUS_2011,
                SkinGene.createPackage(
                        greenTreePython,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                RED_CARNOTAURUS_2011,
                SkinGene.createPackage(
                        northCardinal,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                CRYOLOPHOSAURUS_2011,
                SkinGene.createPackage(
                        blueIguana,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                DILOPHOSAURUS_2011,
                SkinGene.createPackage(
                        inlandTaipan,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                FUTABASAURUS_2011,
                SkinGene.createPackage(
                        broadheadSkink,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                MAMMOTH_2011,
                SkinGene.createPackage(
                        americanBison,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                MOSASAURUS_2011,
                SkinGene.createPackage(
                        marineIguana,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                PTERANODON_2011,
                SkinGene.createPackage(
                        easternIndigoSnake,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                SMILODON_2011,
                SkinGene.createPackage(
                        tiger,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                STEGOSAURUS_2011,
                SkinGene.createPackage(
                        greenTreePython,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                FEATHERED_THERIZINOSAURUS_2011,
                SkinGene.createPackage(
                        greenParkeet,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                FEATHERLESS_THERIZINOSAURUS_2011,
                SkinGene.createPackage(
                        greenTreePython,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                GREEN_TRICERATOPS_2011,
                SkinGene.createPackage(
                        greenTreePython,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                BROWN_TRICERATOPS_2011,
                SkinGene.createPackage(
                        easternBrownSnake,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                TYRANNOSAURUS_2011,
                SkinGene.createPackage(
                        easternBrownSnake,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                GREEN_VELOCIRAPTOR_2011,
                SkinGene.createPackage(
                        greenTreePython,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                SANDY_VELOCIRAPTOR_2011,
                SkinGene.createPackage(
                        easternBrownSnake,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
        FASkinGenes.register(
                bootstrapContext,
                WHITE_VELOCIRAPTOR_2011,
                SkinGene.createPackage(
                        grayRatsnake,
                        0xFFFFFF,
                        InheritanceRules.always(),
                        PackageTextureRules.sequence()
                )
        );
    }
}
