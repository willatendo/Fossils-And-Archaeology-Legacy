package willatendo.fossilslegacy.server.item.dinopedia;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.item.dinopedia.line.BuiltInDinopediaLines;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyDinopediaEntries {
    public static final ResourceKey<DinopediaEntry> ANKYLOSAURUS_DATA = FossilsLegacyDinopediaEntries.create("ankylosaurus_data");
    public static final ResourceKey<DinopediaEntry> BRACHIOSAURUS_DATA = FossilsLegacyDinopediaEntries.create("brachiosaurus_data");
    public static final ResourceKey<DinopediaEntry> CARNOTAURUS_DATA = FossilsLegacyDinopediaEntries.create("carnotaurus_data");
    public static final ResourceKey<DinopediaEntry> COMPSOGNATHUS_DATA = FossilsLegacyDinopediaEntries.create("compsognathus_data");
    public static final ResourceKey<DinopediaEntry> CRYOLOPHOSAURUS_DATA = FossilsLegacyDinopediaEntries.create("cryolophosaurus_data");
    public static final ResourceKey<DinopediaEntry> DILOPHOSAURUS_DATA = FossilsLegacyDinopediaEntries.create("dilophosaurus_data");
    public static final ResourceKey<DinopediaEntry> DIMETRODON_DATA = FossilsLegacyDinopediaEntries.create("dimetrodon_data");
    public static final ResourceKey<DinopediaEntry> DODO_DATA = FossilsLegacyDinopediaEntries.create("dodo_data");
    public static final ResourceKey<DinopediaEntry> FUTABASAURUS_DATA = FossilsLegacyDinopediaEntries.create("futabasaurus_data");
    public static final ResourceKey<DinopediaEntry> GALLIMIMUS_DATA = FossilsLegacyDinopediaEntries.create("gallimimus_data");
    public static final ResourceKey<DinopediaEntry> MAMMOTH_DATA = FossilsLegacyDinopediaEntries.create("mammoth_data");
    public static final ResourceKey<DinopediaEntry> MOA_DATA = FossilsLegacyDinopediaEntries.create("moa_data");
    public static final ResourceKey<DinopediaEntry> MOSASAURUS_DATA = FossilsLegacyDinopediaEntries.create("mosasaurus_data");
    public static final ResourceKey<DinopediaEntry> PACHYCEPHALOSAURUS_DATA = FossilsLegacyDinopediaEntries.create("pachycephalosaurus_data");
    public static final ResourceKey<DinopediaEntry> PTERANODON_DATA = FossilsLegacyDinopediaEntries.create("pteranodon_data");
    public static final ResourceKey<DinopediaEntry> SMILODON_DATA = FossilsLegacyDinopediaEntries.create("smilodon_data");
    public static final ResourceKey<DinopediaEntry> SPINOSAURUS_DATA = FossilsLegacyDinopediaEntries.create("spinosaurus_data");
    public static final ResourceKey<DinopediaEntry> STEGOSAURUS_DATA = FossilsLegacyDinopediaEntries.create("stegosaurus_data");
    public static final ResourceKey<DinopediaEntry> THERIZINOSAURUS_DATA = FossilsLegacyDinopediaEntries.create("therizinosaurus_data");
    public static final ResourceKey<DinopediaEntry> TRICERATOPS_DATA = FossilsLegacyDinopediaEntries.create("triceratops_data");
    public static final ResourceKey<DinopediaEntry> TYRANNOSAURUS_DATA = FossilsLegacyDinopediaEntries.create("tyrannosaurus_data");
    public static final ResourceKey<DinopediaEntry> VELOCIRAPTOR_DATA = FossilsLegacyDinopediaEntries.create("velociraptor_data");

    private static ResourceKey<DinopediaEntry> create(String name) {
        return ResourceKey.create(FossilsLegacyRegistries.DINOPEDIA_ENTRY, FossilsLegacyUtils.resource(name));
    }

    private static void register(BootstrapContext<DinopediaEntry> bootstrapContext, ResourceKey<DinopediaEntry> resourceKey, DinopediaEntry.Builder dinopediaEntry) {
        bootstrapContext.register(resourceKey, dinopediaEntry.build());
    }

    public static void bootstrap(BootstrapContext<DinopediaEntry> bootstrapContext) {
        FossilsLegacyDinopediaEntries.register(bootstrapContext, ANKYLOSAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.RIDEABLE, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FossilsLegacyDinopediaEntries.register(bootstrapContext, BRACHIOSAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.RIDEABLE, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FossilsLegacyDinopediaEntries.register(bootstrapContext, CARNOTAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FossilsLegacyDinopediaEntries.register(bootstrapContext, COMPSOGNATHUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FossilsLegacyDinopediaEntries.register(bootstrapContext, CRYOLOPHOSAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FossilsLegacyDinopediaEntries.register(bootstrapContext, DILOPHOSAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FossilsLegacyDinopediaEntries.register(bootstrapContext, DIMETRODON_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FossilsLegacyDinopediaEntries.register(bootstrapContext, DODO_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FossilsLegacyDinopediaEntries.register(bootstrapContext, FUTABASAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.RIDEABLE, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FossilsLegacyDinopediaEntries.register(bootstrapContext, GALLIMIMUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.RIDEABLE, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FossilsLegacyDinopediaEntries.register(bootstrapContext, MAMMOTH_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.RIDEABLE, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FossilsLegacyDinopediaEntries.register(bootstrapContext, MOA_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FossilsLegacyDinopediaEntries.register(bootstrapContext, MOSASAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FossilsLegacyDinopediaEntries.register(bootstrapContext, PACHYCEPHALOSAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FossilsLegacyDinopediaEntries.register(bootstrapContext, PTERANODON_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.RIDEABLE, BuiltInDinopediaLines.ABLE_TO_FLY, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FossilsLegacyDinopediaEntries.register(bootstrapContext, SMILODON_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FossilsLegacyDinopediaEntries.register(bootstrapContext, SPINOSAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.DANGEROUS, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FossilsLegacyDinopediaEntries.register(bootstrapContext, STEGOSAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FossilsLegacyDinopediaEntries.register(bootstrapContext, THERIZINOSAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FossilsLegacyDinopediaEntries.register(bootstrapContext, TRICERATOPS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.RIDEABLE, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FossilsLegacyDinopediaEntries.register(bootstrapContext, TYRANNOSAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.RIDEABLE, BuiltInDinopediaLines.DANGEROUS, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FossilsLegacyDinopediaEntries.register(bootstrapContext, VELOCIRAPTOR_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
    }
}
