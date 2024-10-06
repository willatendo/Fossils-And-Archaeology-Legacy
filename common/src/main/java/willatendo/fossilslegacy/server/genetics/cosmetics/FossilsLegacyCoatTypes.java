package willatendo.fossilslegacy.server.genetics.cosmetics;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyCoatTypes {
    public static final ResourceKey<CoatType> ANKYLOSAURUS = FossilsLegacyCoatTypes.create("ankylosaurus");
    public static final ResourceKey<CoatType> BRACHIOSAURUS = FossilsLegacyCoatTypes.create("brachiosaurus");
    public static final ResourceKey<CoatType> GREEN_CARNOTAURUS = FossilsLegacyCoatTypes.create("green_carnotaurus");
    public static final ResourceKey<CoatType> RED_CARNOTAURUS = FossilsLegacyCoatTypes.create("red_carnotaurus");
    public static final ResourceKey<CoatType> COMPSOGNATHUS = FossilsLegacyCoatTypes.create("compsognathus");
    public static final ResourceKey<CoatType> CRYOLOPHOSAURUS = FossilsLegacyCoatTypes.create("cryolophosaurus");
    public static final ResourceKey<CoatType> DILOPHOSAURUS = FossilsLegacyCoatTypes.create("dilophosaurus");
    public static final ResourceKey<CoatType> DODO = FossilsLegacyCoatTypes.create("dodo");
    public static final ResourceKey<CoatType> FUTABASAURUS = FossilsLegacyCoatTypes.create("futabasaurus");
    public static final ResourceKey<CoatType> GALLIMIMUS = FossilsLegacyCoatTypes.create("gallimimus");
    public static final ResourceKey<CoatType> MAMMOTH = FossilsLegacyCoatTypes.create("mammoth");
    public static final ResourceKey<CoatType> MOA = FossilsLegacyCoatTypes.create("moa");
    public static final ResourceKey<CoatType> MOSASAURUS = FossilsLegacyCoatTypes.create("mosasaurus");
    public static final ResourceKey<CoatType> PACHYCEPHALOSAURUS = FossilsLegacyCoatTypes.create("pachycephalosaurus");
    public static final ResourceKey<CoatType> PTERANODON = FossilsLegacyCoatTypes.create("pteranodon");
    public static final ResourceKey<CoatType> SMILODON = FossilsLegacyCoatTypes.create("smilodon");
    public static final ResourceKey<CoatType> SPINOSAURUS = FossilsLegacyCoatTypes.create("spinosaurus");
    public static final ResourceKey<CoatType> STEGOSAURUS = FossilsLegacyCoatTypes.create("stegosaurus");
    public static final ResourceKey<CoatType> FEATHERED_THERIZINOSAURUS = FossilsLegacyCoatTypes.create("feathered_therizinosaurus");
    public static final ResourceKey<CoatType> FEATHERLESS_THERIZINOSAURUS = FossilsLegacyCoatTypes.create("featherless_therizinosaurus");
    public static final ResourceKey<CoatType> GREEN_TRICERATOPS = FossilsLegacyCoatTypes.create("green_triceratops");
    public static final ResourceKey<CoatType> BROWN_TRICERATOPS = FossilsLegacyCoatTypes.create("brown_triceratops");
    public static final ResourceKey<CoatType> TYRANNOSAURUS = FossilsLegacyCoatTypes.create("tyrannosaurus");
    public static final ResourceKey<CoatType> GREEN_VELOCIRAPTOR = FossilsLegacyCoatTypes.create("green_velociraptor");
    public static final ResourceKey<CoatType> SANDY_VELOCIRAPTOR = FossilsLegacyCoatTypes.create("sandy_velociraptor");
    public static final ResourceKey<CoatType> WHITE_VELOCIRAPTOR = FossilsLegacyCoatTypes.create("white_velociraptor");
    public static final ResourceKey<CoatType> LEGACY_BRACHIOSAURUS = FossilsLegacyCoatTypes.create("legacy_brachiosaurus");
    public static final ResourceKey<CoatType> LEGACY_FUTABASAURUS = FossilsLegacyCoatTypes.create("legacy_mammoth");
    public static final ResourceKey<CoatType> LEGACY_GREEN_TRICERATOPS = FossilsLegacyCoatTypes.create("legacy_green_triceratops");
    public static final ResourceKey<CoatType> LEGACY_BROWN_TRICERATOPS = FossilsLegacyCoatTypes.create("legacy_brown_triceratops");
    public static final ResourceKey<CoatType> LEGACY_GREEN_VELOCIRAPTOR = FossilsLegacyCoatTypes.create("legacy_green_velociraptor");
    public static final ResourceKey<CoatType> LEGACY_SANDY_VELOCIRAPTOR = FossilsLegacyCoatTypes.create("legacy_sandy_velociraptor");
    public static final ResourceKey<CoatType> LEGACY_WHITE_VELOCIRAPTOR = FossilsLegacyCoatTypes.create("legacy_white_velociraptor");

    private static ResourceKey<CoatType> create(String name) {
        return ResourceKey.create(FossilsLegacyRegistries.COAT_TYPES, FossilsLegacyUtils.resource(name));
    }

    private static void register(BootstrapContext<CoatType> bootstrapContext, ResourceKey<CoatType> resourceKey, CoatType coatType) {
        bootstrapContext.register(resourceKey, coatType);
    }

    public static void bootstrap(BootstrapContext<CoatType> bootstrapContext) {
        FossilsLegacyCoatTypes.register(bootstrapContext, ANKYLOSAURUS, CoatType.build(Component.translatable("coatType.fossilslegacy.ankylosaurus"), Component.translatable("pattern.fossilslegacy.eastern_brown_snake"), 0x533A1B, 0.3F, 0.0F, FossilsLegacyUtils.resource("ankylosaurus"), FossilsLegacyUtils.resource("textures/entity/ankylosaurus/ankylosaurus_adult.png"), 1.75F, 1.5F, 0.2F, 1.5F, 1.5F, 0.3F, 1.0F, 0.25F).withBabyTexture(FossilsLegacyUtils.resource("textures/entity/ankylosaurus/ankylosaurus_baby.png")).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, BRACHIOSAURUS, CoatType.build(Component.translatable("coatType.fossilslegacy.brachiosaurus"), Component.translatable("pattern.fossilslegacy.blue_iguana"), 0x3C3F56, 0.07F, 8.0F, FossilsLegacyUtils.resource("brachiosaurus"), FossilsLegacyUtils.resource("textures/entity/brachiosaurus/brachiosaurus_adult.png"), 1.75F, 2.5F, 0.3F, 1.5F, 1.5F, 0.3F, 1.0F, 0.15F).withBabyTexture(FossilsLegacyUtils.resource("textures/entity/brachiosaurus/brachiosaurus_baby.png")).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, GREEN_CARNOTAURUS, CoatType.build(Component.translatable("coatType.fossilslegacy.green_carnotaurus"), Component.translatable("pattern.fossilslegacy.green_tree_python"), 0x485039, 0.35F, 1.0F, FossilsLegacyUtils.resource("carnotaurus"), FossilsLegacyUtils.resource("textures/entity/carnotaurus/green_carnotaurus.png"), 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.3F, 0.75F, 0.1F).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, RED_CARNOTAURUS, CoatType.build(Component.translatable("coatType.fossilslegacy.red_carnotaurus"), Component.translatable("pattern.fossilslegacy.northern_cardinal"), 0xBF5242, 0.35F, 1.0F, FossilsLegacyUtils.resource("carnotaurus"), FossilsLegacyUtils.resource("textures/entity/carnotaurus/red_carnotaurus.png"), 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.3F, 0.75F, 0.1F).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, COMPSOGNATHUS, CoatType.build(Component.translatable("coatType.fossilslegacy.compsognathus"), Component.translatable("pattern.fossilslegacy.green_tree_python"), 0x213D20, 2.0F, -1.0F, FossilsLegacyUtils.resource("compsognathus"), FossilsLegacyUtils.resource("textures/entity/compsognathus/compsognathus.png"), 0.25F, 0.25F, 0.1F, 0.25F, 0.25F, 0.125F, 0.25F, 0.025F).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, CRYOLOPHOSAURUS, CoatType.build(Component.translatable("coatType.fossilslegacy.cryolophosaurus"), Component.translatable("pattern.fossilslegacy.blue_iguana"), 0x49658B, 0.75F, -0.2F, FossilsLegacyUtils.resource("cryolophosaurus"), FossilsLegacyUtils.resource("textures/entity/cryolophosaurus/cryolophosaurus.png"), 0.35F, 0.35F, 0.2F, 0.25F, 0.25F, 0.2F, 0.15F, 0.1F).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, DILOPHOSAURUS, CoatType.build(Component.translatable("coatType.fossilslegacy.dilophosaurus"), Component.translatable("pattern.fossilslegacy.inland_taipan"), 0x736F4A, 1.0F, 0.25F, FossilsLegacyUtils.resource("dilophosaurus"), FossilsLegacyUtils.resource("textures/entity/dilophosaurus/dilophosaurus.png"), 0.5F, 0.5F, 0.2F, 0.2F, 0.2F, 0.15F, 0.15F, 0.1F).withAggressiveTexture(FossilsLegacyUtils.resource("textures/entity/dilophosaurus/aggressive_dilophosaurus.png")).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, DODO, CoatType.build(Component.translatable("coatType.fossilslegacy.dodo"), Component.translatable("pattern.fossilslegacy.domestic_pigeon"), 0x5A5A5A, 2.0F, -1.0F, FossilsLegacyUtils.resource("dodo"), FossilsLegacyUtils.resource("textures/entity/dodo/dodo.png"), 0.5F, 0.5F, 0.05F, 0.5F, 0.5F, 0.07142857142F, 0.15F, 0.05F).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, FUTABASAURUS, CoatType.build(Component.translatable("coatType.fossilslegacy.futabasaurus"), Component.translatable("pattern.fossilslegacy.broadhead_skink"), 0xB92200, 0.35F, 0.25F, FossilsLegacyUtils.resource("futabasaurus"), FossilsLegacyUtils.resource("textures/entity/futabasaurus/futabasaurus.png"), 2.0F, 0.75F, 0.25F, 1.5F, 1.5F, 0.3F, 1.0F, 0.15F).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, GALLIMIMUS, CoatType.build(Component.translatable("coatType.fossilslegacy.gallimimus"), Component.translatable("pattern.fossilslegacy.broadhead_skink"), 0x774913, 0.4F, 1.5F, FossilsLegacyUtils.resource("gallimimus"), FossilsLegacyUtils.resource("textures/entity/gallimimus/gallimimus_adult.png"), 0.7F, 0.7F, 0.25F, 0.75F, 0.75F, 0.2F, 1.0F, 0.1F).withBabyTexture(FossilsLegacyUtils.resource("textures/entity/gallimimus/gallimimus_baby.png")).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, MAMMOTH, CoatType.build(Component.translatable("coatType.fossilslegacy.mammoth"), Component.translatable("pattern.fossilslegacy.american_bison"), 0x3D2700, 0.4F, 0.0F, FossilsLegacyUtils.resource("mammoth"), FossilsLegacyUtils.resource("textures/entity/mammoth/mammoth.png"), 0.7F, 0.7F, 0.5F, 1.0F, 1.0F, 0.625F, 0.75F, 0.15F).withBabyTexture(FossilsLegacyUtils.resource("textures/entity/mammoth/baby_mammoth.png")).withShearedTexture(FossilsLegacyUtils.resource("textures/entity/mammoth/sheared_mammoth.png")).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, MOA, CoatType.build(Component.translatable("coatType.fossilslegacy.moa"), Component.translatable("pattern.fossilslegacy.american_bison"), 0x352A17, 0.45F, 1.0F, FossilsLegacyUtils.resource("moa"), FossilsLegacyUtils.resource("textures/entity/moa/moa.png"), 0.5F, 1.5F, 0.1F, 0.5F, 0.5F, 0.25F, 0.15F, 0.1F).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, MOSASAURUS, CoatType.build(Component.translatable("coatType.fossilslegacy.mosasaurus"), Component.translatable("pattern.fossilslegacy.marine_iguana"), 0x0D7346, 0.4F, 0.25F, FossilsLegacyUtils.resource("mosasaurus"), FossilsLegacyUtils.resource("textures/entity/mosasaurus/mosasaurus.png"), 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.5125F, 0.5F, 0.1F).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, PACHYCEPHALOSAURUS, CoatType.build(Component.translatable("coatType.fossilslegacy.pachycephalosaurus"), Component.translatable("pattern.fossilslegacy.broadhead_skink"), 0xC06929, 0.7F, 0.0F, FossilsLegacyUtils.resource("pachycephalosaurus"), FossilsLegacyUtils.resource("textures/entity/pachycephalosaurus/pachycephalosaurus.png"), 0.7F, 0.7F, 0.1F, 1.0F, 1.0F, 0.1F, 0.5F, 0.075F).withBabyTexture(FossilsLegacyUtils.resource("textures/entity/pachycephalosaurus/baby_pachycephalosaurus.png")).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, PTERANODON, CoatType.build(Component.translatable("coatType.fossilslegacy.pteranodon"), Component.translatable("pattern.fossilslegacy.eastern_indigo_snake"), 0x7C5D89, 0.75F, 0.0F, FossilsLegacyUtils.resource("pteranodon"), FossilsLegacyUtils.resource("textures/entity/pteranodon/pteranodon.png"), 0.5F, 0.5F, 0.2F, 0.8F, 0.8F, 0.2F, 0.5F, 0.075F).withFlyingModels(FossilsLegacyUtils.resource("flying_pteranodon"), FossilsLegacyUtils.resource("landing_pteranodon")).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, SMILODON, CoatType.build(Component.translatable("coatType.fossilslegacy.smilodon"), Component.translatable("pattern.fossilslegacy.tiger"), 0xEFA745, 1.0F, -0.5F, FossilsLegacyUtils.resource("smilodon"), FossilsLegacyUtils.resource("textures/entity/smilodon/smilodon.png"), 0.75F, 0.75F, 0.05F, 1.0F, 1.0F, 0.14285714285F, 0.5F, 0.05F).withBabyTexture(FossilsLegacyUtils.resource("textures/entity/smilodon/baby_smilodon.png")).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, SPINOSAURUS, CoatType.build(Component.translatable("coatType.fossilslegacy.spinosaurus"), Component.translatable("pattern.fossilslegacy.marine_iguana"), 0x26261D, 0.25F, 3.0F, FossilsLegacyUtils.resource("spinosaurus"), FossilsLegacyUtils.resource("textures/entity/spinosaurus/spinosaurus_adult.png"), 0.5F, 0.5F, 0.4F, 0.5F, 0.5F, 0.5125F, 0.5F, 0.15F).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, STEGOSAURUS, CoatType.build(Component.translatable("coatType.fossilslegacy.stegosaurus"), Component.translatable("pattern.fossilslegacy.green_tree_python"), 0x8BE400, 0.3F, 0.0F, FossilsLegacyUtils.resource("stegosaurus"), FossilsLegacyUtils.resource("textures/entity/stegosaurus/stegosaurus.png"), 0.75F, 0.75F, 0.2F, 1.5F, 1.5F, 0.3F, 1.0F, 0.1F).withBabyTexture(FossilsLegacyUtils.resource("textures/entity/stegosaurus/baby_stegosaurus.png")).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, FEATHERED_THERIZINOSAURUS, CoatType.build(Component.translatable("coatType.fossilslegacy.feathered_therizinosaurus"), Component.translatable("pattern.fossilslegacy.green_parakeet"), 0xCE551D, 0.25F, 0.25F, FossilsLegacyUtils.resource("therizinosaurus"), FossilsLegacyUtils.resource("textures/entity/therizinosaurus/feathered_therizinosaurus.png"), 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.35F, 0.75F, 0.1F).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, FEATHERLESS_THERIZINOSAURUS, CoatType.build(Component.translatable("coatType.fossilslegacy.featherless_therizinosaurus"), Component.translatable("pattern.fossilslegacy.green_tree_python"), 0x606F3F, 0.25F, 0.25F, FossilsLegacyUtils.resource("therizinosaurus"), FossilsLegacyUtils.resource("textures/entity/therizinosaurus/featherless_therizinosaurus.png"), 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.35F, 0.75F, 0.1F).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, GREEN_TRICERATOPS, CoatType.build(Component.translatable("coatType.fossilslegacy.green_triceratops"), Component.translatable("pattern.fossilslegacy.green_tree_python"), 0xADE642, 0.4F, 0.0F, FossilsLegacyUtils.resource("triceratops"), FossilsLegacyUtils.resource("textures/entity/triceratops/green_triceratops.png"), 1.0F, 1.0F, 0.2F, 1.0F, 1.0F, 0.15F, 1.0F, 0.1F).withBabyTexture(FossilsLegacyUtils.resource("textures/entity/triceratops/green_baby_triceratops.png")).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, BROWN_TRICERATOPS, CoatType.build(Component.translatable("coatType.fossilslegacy.brown_triceratops"), Component.translatable("pattern.fossilslegacy.eastern_brown_snake"), 0xA58856, 0.4F, 0.0F, FossilsLegacyUtils.resource("triceratops"), FossilsLegacyUtils.resource("textures/entity/triceratops/brown_triceratops.png"), 1.0F, 1.0F, 0.2F, 1.0F, 1.0F, 0.15F, 1.0F, 0.1F).withBabyTexture(FossilsLegacyUtils.resource("textures/entity/triceratops/brown_baby_triceratops.png")).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, TYRANNOSAURUS, CoatType.build(Component.translatable("coatType.fossilslegacy.tyrannosaurus"), Component.translatable("pattern.fossilslegacy.eastern_brown_snake"), 0x918066, 0.25F, 0.25F, FossilsLegacyUtils.resource("tyrannosaurus"), FossilsLegacyUtils.resource("textures/entity/tyrannosaurus/tyrannosaurus.png"), 0.5F, 0.5F, 0.4F, 0.5F, 0.5F, 0.5125F, 0.75F, 0.15F).withKnockoutModel(FossilsLegacyUtils.resource("knocked_out_tyrannosaurus")).withAggressiveTexture(FossilsLegacyUtils.resource("textures/entity/tyrannosaurus/aggressive_tyrannosaurus.png")).withKnockedOutTexture(FossilsLegacyUtils.resource("textures/entity/tyrannosaurus/weak_tyrannosaurus.png")).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, GREEN_VELOCIRAPTOR, CoatType.build(Component.translatable("coatType.fossilslegacy.green_velociraptor"), Component.translatable("pattern.fossilslegacy.green_tree_python"), 0x0C3F4C, 1.5F, -0.75F, FossilsLegacyUtils.resource("velociraptor"), FossilsLegacyUtils.resource("textures/entity/velociraptor/green_velociraptor.png"), 0.2F, 0.4F, 0.05F, 0.5F, 0.5F, 0.1F, 0.5F, 0.025F).withBabyTexture(FossilsLegacyUtils.resource("textures/entity/velociraptor/green_baby_velociraptor.png")).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, SANDY_VELOCIRAPTOR, CoatType.build(Component.translatable("coatType.fossilslegacy.sandy_velociraptor"), Component.translatable("pattern.fossilslegacy.eastern_brown_snake"), 0x632D09, 1.5F, -0.75F, FossilsLegacyUtils.resource("velociraptor"), FossilsLegacyUtils.resource("textures/entity/velociraptor/sandy_velociraptor.png"), 0.2F, 0.4F, 0.05F, 0.5F, 0.5F, 0.1F, 0.5F, 0.025F).withBabyTexture(FossilsLegacyUtils.resource("textures/entity/velociraptor/sandy_baby_velociraptor.png")).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, WHITE_VELOCIRAPTOR, CoatType.build(Component.translatable("coatType.fossilslegacy.white_velociraptor"), Component.translatable("pattern.fossilslegacy.gray_ratsnake"), 0x252525, 1.5F, -0.75F, FossilsLegacyUtils.resource("velociraptor"), FossilsLegacyUtils.resource("textures/entity/velociraptor/white_velociraptor.png"), 0.2F, 0.4F, 0.05F, 0.5F, 0.5F, 0.1F, 0.5F, 0.025F).withBabyTexture(FossilsLegacyUtils.resource("textures/entity/velociraptor/white_baby_velociraptor.png")).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, LEGACY_BRACHIOSAURUS, CoatType.build(Component.translatable("coatType.fossilslegacy.legacy_brachiosaurus"), Component.translatable("pattern.fossilslegacy.blue_iguana"), 0x363950, 0.07F, 8.0F, FossilsLegacyUtils.resource("legacy_brachiosaurus"), FossilsLegacyUtils.resource("textures/entity/brachiosaurus/legacy/brachiosaurus.png"), 1.75F, 2.5F, 0.3F, 1.5F, 1.5F, 0.3F, 0.15F, 0.1F).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, LEGACY_FUTABASAURUS, CoatType.build(Component.translatable("coatType.fossilslegacy.legacy_futabasaurus"), Component.translatable("pattern.fossilslegacy.broadhead_skink"), 0xC75B00, 0.3F, 0.25F, FossilsLegacyUtils.resource("legacy_futabasaurus"), FossilsLegacyUtils.resource("textures/entity/futabasaurus/legacy/futabasaurus.png"), 0.75F, 0.75F, 0.2F, 1.5F, 1.5F, 0.3F, 0.15F, 0.1F).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, LEGACY_GREEN_TRICERATOPS, CoatType.build(Component.translatable("coatType.fossilslegacy.legacy_green_triceratops"), Component.translatable("pattern.fossilslegacy.green_tree_python"), 0xB6EF4B, 0.4F, 0.0F, FossilsLegacyUtils.resource("legacy_triceratops"), FossilsLegacyUtils.resource("textures/entity/triceratops/legacy/green_triceratops.png"), 0.75F, 0.75F, 0.15F, 1.5F, 1.5F, 0.3F, 1.0F, 0.1F).withBabyTexture(FossilsLegacyUtils.resource("textures/entity/triceratops/legacy/green_baby_triceratops.png")).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, LEGACY_BROWN_TRICERATOPS, CoatType.build(Component.translatable("coatType.fossilslegacy.legacy_brown_triceratops"), Component.translatable("pattern.fossilslegacy.eastern_brown_snake"), 0xE3BB7B, 0.4F, 0.0F, FossilsLegacyUtils.resource("legacy_triceratops"), FossilsLegacyUtils.resource("textures/entity/triceratops/legacy/brown_triceratops.png"), 0.75F, 0.75F, 0.15F, 1.5F, 1.5F, 0.3F, 1.0F, 0.1F).withBabyTexture(FossilsLegacyUtils.resource("textures/entity/triceratops/legacy/brown_baby_triceratops.png")).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, LEGACY_GREEN_VELOCIRAPTOR, CoatType.build(Component.translatable("coatType.fossilslegacy.legacy_green_velociraptor"), Component.translatable("pattern.fossilslegacy.green_tree_python"), 0x71A367, 1.0F, -0.75F, FossilsLegacyUtils.resource("legacy_velociraptor"), FossilsLegacyUtils.resource("textures/entity/velociraptor/legacy/green_velociraptor.png"), 0.3F, 0.3F, 0.1F, 0.2F, 0.32F, 0.1F, 0.35F, 0.05F).withBabyTexture(FossilsLegacyUtils.resource("textures/entity/velociraptor/legacy/green_baby_velociraptor.png")).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, LEGACY_SANDY_VELOCIRAPTOR, CoatType.build(Component.translatable("coatType.fossilslegacy.legacy_sandy_velociraptor"), Component.translatable("pattern.fossilslegacy.eastern_brown_snake"), 0xD6C68E, 1.0F, -0.75F, FossilsLegacyUtils.resource("legacy_velociraptor"), FossilsLegacyUtils.resource("textures/entity/velociraptor/legacy/sandy_velociraptor.png"), 0.3F, 0.3F, 0.1F, 0.2F, 0.32F, 0.1F, 0.35F, 0.05F).withBabyTexture(FossilsLegacyUtils.resource("textures/entity/velociraptor/legacy/sandy_baby_velociraptor.png")).build());
        FossilsLegacyCoatTypes.register(bootstrapContext, LEGACY_WHITE_VELOCIRAPTOR, CoatType.build(Component.translatable("coatType.fossilslegacy.legacy_white_velociraptor"), Component.translatable("pattern.fossilslegacy.gray_ratsnake"), 0xC0C5D5, 1.0F, -0.75F, FossilsLegacyUtils.resource("legacy_velociraptor"), FossilsLegacyUtils.resource("textures/entity/velociraptor/legacy/white_velociraptor.png"), 0.3F, 0.3F, 0.1F, 0.2F, 0.32F, 0.1F, 0.35F, 0.05F).withBabyTexture(FossilsLegacyUtils.resource("textures/entity/velociraptor/legacy/white_baby_velociraptor.png")).build());
    }
}
