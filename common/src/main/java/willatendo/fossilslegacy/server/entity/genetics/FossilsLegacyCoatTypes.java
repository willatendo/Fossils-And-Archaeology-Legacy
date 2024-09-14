package willatendo.fossilslegacy.server.entity.genetics;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.Optional;

public class FossilsLegacyCoatTypes {
    public static final ResourceKey<CoatType> BRACHIOSAURUS = FossilsLegacyCoatTypes.create("brachiosaurus");
    public static final ResourceKey<CoatType> GREEN_CARNOTAURUS = FossilsLegacyCoatTypes.create("green_carnotaurus");
    public static final ResourceKey<CoatType> RED_CARNOTAURUS = FossilsLegacyCoatTypes.create("red_carnotaurus");
    public static final ResourceKey<CoatType> COMPSOGNATHUS = FossilsLegacyCoatTypes.create("compsognathus");
    public static final ResourceKey<CoatType> CRYOLOPHOSAURUS = FossilsLegacyCoatTypes.create("cryolophosaurus");
    public static final ResourceKey<CoatType> DILOPHOSAURUS = FossilsLegacyCoatTypes.create("dilophosaurus");
    public static final ResourceKey<CoatType> DODO = FossilsLegacyCoatTypes.create("dodo");
    public static final ResourceKey<CoatType> FUTABASAURUS = FossilsLegacyCoatTypes.create("futabasaurus");
    public static final ResourceKey<CoatType> MAMMOTH = FossilsLegacyCoatTypes.create("mammoth");
    public static final ResourceKey<CoatType> MOSASAURUS = FossilsLegacyCoatTypes.create("mosasaurus");
    public static final ResourceKey<CoatType> PACHYCEPHALOSAURUS = FossilsLegacyCoatTypes.create("pachycephalosaurus");
    public static final ResourceKey<CoatType> PTERANODON = FossilsLegacyCoatTypes.create("pteranodon");
    public static final ResourceKey<CoatType> SMILODON = FossilsLegacyCoatTypes.create("smilodon");
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

    private static void register(BootstrapContext<CoatType> bootstrapContext, ResourceKey<CoatType> resourceKey, Component name, int color, ResourceLocation model, ResourceLocation texture, Optional<ResourceLocation> babyTexture, float boundingBoxWidth, float boundingBoxHeight, float boundingBoxGrowth, float baseScaleWidth, float baseScaleHeight, float ageScale) {
        bootstrapContext.register(resourceKey, new CoatType(name, color, model, texture, babyTexture, boundingBoxWidth, boundingBoxHeight, boundingBoxGrowth, baseScaleWidth, baseScaleHeight, ageScale));
    }

    private static void register(BootstrapContext<CoatType> bootstrapContext, ResourceKey<CoatType> resourceKey, Component name, int color, ResourceLocation model, ResourceLocation texture, ResourceLocation babyTexture, float boundingBoxWidth, float boundingBoxHeight, float boundingBoxGrowth, float baseScaleWidth, float baseScaleHeight, float ageScale) {
        FossilsLegacyCoatTypes.register(bootstrapContext, resourceKey, name, color, model, texture, babyTexture == null ? Optional.empty() : Optional.of(babyTexture), boundingBoxWidth, boundingBoxHeight, boundingBoxGrowth, baseScaleWidth, baseScaleHeight, ageScale);
    }

    private static void register(BootstrapContext<CoatType> bootstrapContext, ResourceKey<CoatType> resourceKey, Component name, int color, ResourceLocation model, ResourceLocation texture, float boundingBoxWidth, float boundingBoxHeight, float boundingBoxGrowth, float baseScaleWidth, float baseScaleHeight, float ageScale) {
        FossilsLegacyCoatTypes.register(bootstrapContext, resourceKey, name, color, model, texture, (ResourceLocation) null, boundingBoxWidth, boundingBoxHeight, boundingBoxGrowth, baseScaleWidth, baseScaleHeight, ageScale);
    }

    public static void bootstrap(BootstrapContext<CoatType> bootstrapContext) {
        register(bootstrapContext, BRACHIOSAURUS, Component.translatable("coatType.fossilslegacy.brachiosaurus"), 0x3C3F56, FossilsLegacyUtils.resource("brachiosaurus"), FossilsLegacyUtils.resource("textures/entity/brachiosaurus/brachiosaurus_adult.png"), FossilsLegacyUtils.resource("textures/entity/brachiosaurus/brachiosaurus_baby.png"), 0.5F, 0.5F, 0.2F, 1.5F, 1.5F, 0.3F);
        register(bootstrapContext, GREEN_CARNOTAURUS, Component.translatable("coatType.fossilslegacy.green_carnotaurus"), 0x485039, FossilsLegacyUtils.resource("carnotaurus"), FossilsLegacyUtils.resource("textures/entity/carnotaurus/green_carnotaurus.png"), 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.3F);
        register(bootstrapContext, RED_CARNOTAURUS, Component.translatable("coatType.fossilslegacy.red_carnotaurus"), 0xBF5242, FossilsLegacyUtils.resource("carnotaurus"), FossilsLegacyUtils.resource("textures/entity/carnotaurus/red_carnotaurus.png"), 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.3F);
        register(bootstrapContext, COMPSOGNATHUS, Component.translatable("coatType.fossilslegacy.compsognathus"), 0x213D20, FossilsLegacyUtils.resource("compsognathus"), FossilsLegacyUtils.resource("textures/entity/compsognathus/compsognathus.png"), 0.5F, 0.5F, 1.0F, 0.25F, 0.25F, 0.125F);
        register(bootstrapContext, CRYOLOPHOSAURUS, Component.translatable("coatType.fossilslegacy.cryolophosaurus"), 0x49658B, FossilsLegacyUtils.resource("cryolophosaurus"), FossilsLegacyUtils.resource("textures/entity/cryolophosaurus/cryolophosaurus.png"), 0.5F, 0.5F, 0.35F, 0.25F, 0.25F, 0.2F);
        register(bootstrapContext, DILOPHOSAURUS, Component.translatable("coatType.fossilslegacy.dilophosaurus"), 0x736F4A, FossilsLegacyUtils.resource("dilophosaurus"), FossilsLegacyUtils.resource("textures/entity/dilophosaurus/dilophosaurus.png"), 0.5F, 0.5F, 0.1F, 0.2F, 0.2F, 0.15F);
        register(bootstrapContext, DODO, Component.translatable("coatType.fossilslegacy.dodo"), 0x5A5A5A, FossilsLegacyUtils.resource("dodo"), FossilsLegacyUtils.resource("textures/entity/dodo/dodo.png"), 0.5F, 0.5F, 1.0F, 0.5F, 0.5F, 0.5F);
        register(bootstrapContext, FUTABASAURUS, Component.translatable("coatType.fossilslegacy.futabasaurus"), 0xB92200, FossilsLegacyUtils.resource("futabasaurus"), FossilsLegacyUtils.resource("textures/entity/futabasaurus/futabasaurus.png"), 0.5F, 0.5F, 0.25F, 1.5F, 1.5F, 0.3F);
        register(bootstrapContext, MAMMOTH, Component.translatable("coatType.fossilslegacy.mammoth"), 0x3D2700, FossilsLegacyUtils.resource("mammoth"), FossilsLegacyUtils.resource("textures/entity/mammoth/mammoth.png"), FossilsLegacyUtils.resource("textures/entity/mammoth/baby_mammoth.png"), 0.5F, 0.5F, 3.5F, 1.0F, 1.0F, 2.0F);
        register(bootstrapContext, MOSASAURUS, Component.translatable("coatType.fossilslegacy.mosasaurus"), 0x0D7346, FossilsLegacyUtils.resource("mosasaurus"), FossilsLegacyUtils.resource("textures/entity/mosasaurus/mosasaurus.png"), 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.5125F);
        register(bootstrapContext, PACHYCEPHALOSAURUS, Component.translatable("coatType.fossilslegacy.pachycephalosaurus"), 0xC06929, FossilsLegacyUtils.resource("pachycephalosaurus"), FossilsLegacyUtils.resource("textures/entity/pachycephalosaurus/pachycephalosaurus.png"), FossilsLegacyUtils.resource("textures/entity/pachycephalosaurus/baby_pachycephalosaurus.png"), 0.5F, 0.5F, 0.35F, 1.0F, 1.0F, 0.1F);
        register(bootstrapContext, PTERANODON, Component.translatable("coatType.fossilslegacy.pteranodon"), 0x7C5D89, FossilsLegacyUtils.resource("pteranodon"), FossilsLegacyUtils.resource("textures/entity/pteranodon/pteranodon.png"), 0.5F, 0.5F, 0.2F, 0.8F, 0.8F, 0.2F);
        register(bootstrapContext, SMILODON, Component.translatable("coatType.fossilslegacy.smilodon"), 0xEFA745, FossilsLegacyUtils.resource("smilodon"), FossilsLegacyUtils.resource("textures/entity/smilodon/smilodon.png"), FossilsLegacyUtils.resource("textures/entity/smilodon/baby_smilodon.png"), 0.5F, 0.5F, 1.0F, 1.0F, 1.0F, 1.0F);
        register(bootstrapContext, STEGOSAURUS, Component.translatable("coatType.fossilslegacy.stegosaurus"), 0x8BE400, FossilsLegacyUtils.resource("stegosaurus"), FossilsLegacyUtils.resource("textures/entity/stegosaurus/stegosaurus.png"), FossilsLegacyUtils.resource("textures/entity/stegosaurus/baby_stegosaurus.png"), 0.5F, 0.5F, 0.35F, 1.5F, 1.5F, 0.3F);
        register(bootstrapContext, FEATHERED_THERIZINOSAURUS, Component.translatable("coatType.fossilslegacy.feathered_therizinosaurus"), 0xCE551D, FossilsLegacyUtils.resource("therizinosaurus"), FossilsLegacyUtils.resource("textures/entity/therizinosaurus/feathered_therizinosaurus.png"), 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.3F);
        register(bootstrapContext, FEATHERLESS_THERIZINOSAURUS, Component.translatable("coatType.fossilslegacy.featherless_therizinosaurus"), 0x606F3F, FossilsLegacyUtils.resource("therizinosaurus"), FossilsLegacyUtils.resource("textures/entity/therizinosaurus/featherless_therizinosaurus.png"), 0.5F, 0.5F, 0.35F, 0.5F, 0.5F, 0.3F);
        register(bootstrapContext, GREEN_TRICERATOPS, Component.translatable("coatType.fossilslegacy.green_triceratops"), 0xA58856, FossilsLegacyUtils.resource("triceratops"), FossilsLegacyUtils.resource("textures/entity/triceratops/green_triceratops.png"), FossilsLegacyUtils.resource("textures/entity/triceratops/green_baby_triceratops.png"), 0.5F, 0.5F, 0.35F, 1.5F, 1.5F, 0.3F);
        register(bootstrapContext, BROWN_TRICERATOPS, Component.translatable("coatType.fossilslegacy.brown_triceratops"), 0xADE642, FossilsLegacyUtils.resource("triceratops"), FossilsLegacyUtils.resource("textures/entity/triceratops/brown_triceratops.png"), FossilsLegacyUtils.resource("textures/entity/triceratops/brown_baby_triceratops.png"), 0.5F, 0.5F, 0.35F, 1.5F, 1.5F, 0.3F);
        register(bootstrapContext, TYRANNOSAURUS, Component.translatable("coatType.fossilslegacy.tyrannosaurus"), 0x918066, FossilsLegacyUtils.resource("tyrannosaurus"), FossilsLegacyUtils.resource("textures/entity/tyrannosaurus/tyrannosaurus.png"), 0.5F, 0.5F, 1.0F, 0.5F, 0.5F, 0.5125F);
        register(bootstrapContext, GREEN_VELOCIRAPTOR, Component.translatable("coatType.fossilslegacy.green_velociraptor"), 0x0C3F4C, FossilsLegacyUtils.resource("velociraptor"), FossilsLegacyUtils.resource("textures/entity/velociraptor/green_velociraptor.png"), FossilsLegacyUtils.resource("textures/entity/velociraptor/green_baby_velociraptor.png"), 0.2F, 0.4F, 0.05F, 0.5F, 0.5F, 0.1F);
        register(bootstrapContext, SANDY_VELOCIRAPTOR, Component.translatable("coatType.fossilslegacy.sandy_velociraptor"), 0x632D09, FossilsLegacyUtils.resource("velociraptor"), FossilsLegacyUtils.resource("textures/entity/velociraptor/sandy_velociraptor.png"), FossilsLegacyUtils.resource("textures/entity/velociraptor/sandy_baby_velociraptor.png"), 0.2F, 0.4F, 0.05F, 0.5F, 0.5F, 0.1F);
        register(bootstrapContext, WHITE_VELOCIRAPTOR, Component.translatable("coatType.fossilslegacy.white_velociraptor"), 0x252525, FossilsLegacyUtils.resource("velociraptor"), FossilsLegacyUtils.resource("textures/entity/velociraptor/white_velociraptor.png"), FossilsLegacyUtils.resource("textures/entity/velociraptor/white_baby_velociraptor.png"), 0.2F, 0.4F, 0.05F, 0.5F, 0.5F, 0.1F);
        register(bootstrapContext, LEGACY_BRACHIOSAURUS, Component.translatable("coatType.fossilslegacy.legacy_brachiosaurus"), 0x363950, FossilsLegacyUtils.resource("legacy_brachiosaurus"), FossilsLegacyUtils.resource("textures/entity/brachiosaurus/legacy/brachiosaurus.png"), 0.5F, 0.5F, 0.2F, 1.5F, 1.5F, 0.3F);
        register(bootstrapContext, LEGACY_FUTABASAURUS, Component.translatable("coatType.fossilslegacy.legacy_futabasaurus"), 0xC75B00, FossilsLegacyUtils.resource("legacy_futabasaurus"), FossilsLegacyUtils.resource("textures/entity/futabasaurus/legacy/futabasaurus.png"), 0.5F, 0.5F, 0.25F, 1.5F, 1.5F, 0.3F);
        register(bootstrapContext, LEGACY_GREEN_TRICERATOPS, Component.translatable("coatType.fossilslegacy.legacy_green_triceratops"), 0xB6EF4B, FossilsLegacyUtils.resource("legacy_triceratops"), FossilsLegacyUtils.resource("textures/entity/triceratops/legacy/green_triceratops.png"), FossilsLegacyUtils.resource("textures/entity/triceratops/legacy/green_baby_triceratops.png"), 0.5F, 0.5F, 0.35F, 1.5F, 1.5F, 0.3F);
        register(bootstrapContext, LEGACY_BROWN_TRICERATOPS, Component.translatable("coatType.fossilslegacy.legacy_brown_triceratops"), 0xE3BB7B, FossilsLegacyUtils.resource("legacy_triceratops"), FossilsLegacyUtils.resource("textures/entity/triceratops/legacy/brown_triceratops.png"), FossilsLegacyUtils.resource("textures/entity/triceratops/legacy/brown_baby_triceratops.png"), 0.5F, 0.5F, 0.35F, 1.5F, 1.5F, 0.3F);
        register(bootstrapContext, LEGACY_GREEN_VELOCIRAPTOR, Component.translatable("coatType.fossilslegacy.legacy_green_velociraptor"), 0x71A367, FossilsLegacyUtils.resource("legacy_velociraptor"), FossilsLegacyUtils.resource("textures/entity/velociraptor/legacy/green_velociraptor.png"), FossilsLegacyUtils.resource("textures/entity/velociraptor/legacy/green_baby_velociraptor.png"), 0.3F, 0.3F, 0.1F, 0.2F, 0.32F, 0.1F);
        register(bootstrapContext, LEGACY_SANDY_VELOCIRAPTOR, Component.translatable("coatType.fossilslegacy.legacy_sandy_velociraptor"), 0xD6C68E, FossilsLegacyUtils.resource("legacy_velociraptor"), FossilsLegacyUtils.resource("textures/entity/velociraptor/legacy/sandy_velociraptor.png"), FossilsLegacyUtils.resource("textures/entity/velociraptor/legacy/sandy_baby_velociraptor.png"), 0.3F, 0.3F, 0.1F, 0.2F, 0.32F, 0.1F);
        register(bootstrapContext, LEGACY_WHITE_VELOCIRAPTOR, Component.translatable("coatType.fossilslegacy.legacy_white_velociraptor"), 0xC0C5D5, FossilsLegacyUtils.resource("legacy_velociraptor"), FossilsLegacyUtils.resource("textures/entity/velociraptor/legacy/white_velociraptor.png"), FossilsLegacyUtils.resource("textures/entity/velociraptor/legacy/white_baby_velociraptor.png"), 0.3F, 0.3F, 0.1F, 0.2F, 0.32F, 0.1F);
    }
}
