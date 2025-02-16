package willatendo.fossilslegacy.server.dinopedia_entry;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.dinopedia_entry.line.BuiltInDinopediaLines;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FADinopediaEntries {
    public static final ResourceKey<DinopediaEntry> ANKYLOSAURUS_DATA = FADinopediaEntries.create("ankylosaurus_data");
    public static final ResourceKey<DinopediaEntry> BRACHIOSAURUS_DATA = FADinopediaEntries.create("brachiosaurus_data");
    public static final ResourceKey<DinopediaEntry> CARNOTAURUS_DATA = FADinopediaEntries.create("carnotaurus_data");
    public static final ResourceKey<DinopediaEntry> COMPSOGNATHUS_DATA = FADinopediaEntries.create("compsognathus_data");
    public static final ResourceKey<DinopediaEntry> CRYOLOPHOSAURUS_DATA = FADinopediaEntries.create("cryolophosaurus_data");
    public static final ResourceKey<DinopediaEntry> DILOPHOSAURUS_DATA = FADinopediaEntries.create("dilophosaurus_data");
    public static final ResourceKey<DinopediaEntry> DIMETRODON_DATA = FADinopediaEntries.create("dimetrodon_data");
    public static final ResourceKey<DinopediaEntry> DODO_DATA = FADinopediaEntries.create("dodo_data");
    public static final ResourceKey<DinopediaEntry> EGG_DATA = FADinopediaEntries.create("egg_data");
    public static final ResourceKey<DinopediaEntry> FUTABASAURUS_DATA = FADinopediaEntries.create("futabasaurus_data");
    public static final ResourceKey<DinopediaEntry> GALLIMIMUS_DATA = FADinopediaEntries.create("gallimimus_data");
    public static final ResourceKey<DinopediaEntry> MAMMOTH_DATA = FADinopediaEntries.create("mammoth_data");
    public static final ResourceKey<DinopediaEntry> MOA_DATA = FADinopediaEntries.create("moa_data");
    public static final ResourceKey<DinopediaEntry> MOSASAURUS_DATA = FADinopediaEntries.create("mosasaurus_data");
    public static final ResourceKey<DinopediaEntry> PACHYCEPHALOSAURUS_DATA = FADinopediaEntries.create("pachycephalosaurus_data");
    public static final ResourceKey<DinopediaEntry> PREGNANCY_DATA = FADinopediaEntries.create("pregnancy_data");
    public static final ResourceKey<DinopediaEntry> PTERANODON_DATA = FADinopediaEntries.create("pteranodon_data");
    public static final ResourceKey<DinopediaEntry> SMILODON_DATA = FADinopediaEntries.create("smilodon_data");
    public static final ResourceKey<DinopediaEntry> SPINOSAURUS_DATA = FADinopediaEntries.create("spinosaurus_data");
    public static final ResourceKey<DinopediaEntry> STEGOSAURUS_DATA = FADinopediaEntries.create("stegosaurus_data");
    public static final ResourceKey<DinopediaEntry> THERIZINOSAURUS_DATA = FADinopediaEntries.create("therizinosaurus_data");
    public static final ResourceKey<DinopediaEntry> TRICERATOPS_DATA = FADinopediaEntries.create("triceratops_data");
    public static final ResourceKey<DinopediaEntry> TYRANNOSAURUS_DATA = FADinopediaEntries.create("tyrannosaurus_data");
    public static final ResourceKey<DinopediaEntry> VELOCIRAPTOR_DATA = FADinopediaEntries.create("velociraptor_data");

    private static ResourceKey<DinopediaEntry> create(String name) {
        return ResourceKey.create(FARegistries.DINOPEDIA_ENTRY, FAUtils.resource(name));
    }

    private static void register(BootstrapContext<DinopediaEntry> bootstrapContext, ResourceKey<DinopediaEntry> resourceKey, DinopediaEntry.Builder dinopediaEntry) {
        bootstrapContext.register(resourceKey, dinopediaEntry.build());
    }

    public static void bootstrap(BootstrapContext<DinopediaEntry> bootstrapContext) {
        FADinopediaEntries.register(bootstrapContext, ANKYLOSAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.RIDEABLE, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, BRACHIOSAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.RIDEABLE, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, CARNOTAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, COMPSOGNATHUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, CRYOLOPHOSAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, DILOPHOSAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, DIMETRODON_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, DODO_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, EGG_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.EGG_DISPLAY_NAME, BuiltInDinopediaLines.REMAINING_TIME, BuiltInDinopediaLines.STATUS).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, FUTABASAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.RIDEABLE, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, GALLIMIMUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.RIDEABLE, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, MAMMOTH_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.RIDEABLE, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, MOA_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, MOSASAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, PACHYCEPHALOSAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, PREGNANCY_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.PREGNANT_DISPLAY_NAME, BuiltInDinopediaLines.PREGNANT_HEALTH, BuiltInDinopediaLines.PREGNANCY_TIME, BuiltInDinopediaLines.PREGNANCY_TYPE).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, PTERANODON_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.RIDEABLE, BuiltInDinopediaLines.ABLE_TO_FLY, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, SMILODON_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, SPINOSAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.DANGEROUS, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, STEGOSAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, THERIZINOSAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, TRICERATOPS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.RIDEABLE, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, TYRANNOSAURUS_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.RIDEABLE, BuiltInDinopediaLines.DANGEROUS, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
        FADinopediaEntries.register(bootstrapContext, VELOCIRAPTOR_DATA, DinopediaEntry.of().addText(BuiltInDinopediaLines.DISPLAY_NAME, BuiltInDinopediaLines.OWNER, BuiltInDinopediaLines.AGE, BuiltInDinopediaLines.HEALTH, BuiltInDinopediaLines.HUNGER, BuiltInDinopediaLines.NOT_OWNER, BuiltInDinopediaLines.WILD).drawEntity().centerText());
    }
}
