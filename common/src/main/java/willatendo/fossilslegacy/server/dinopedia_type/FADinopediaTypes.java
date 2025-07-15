package willatendo.fossilslegacy.server.dinopedia_type;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.dinopedia_entry.DinopediaEntry;
import willatendo.fossilslegacy.server.dinopedia_entry.FADinopediaEntries;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Arrays;

public final class FADinopediaTypes {
    public static final ResourceKey<DinopediaType> ANKYLOSAURUS = FADinopediaTypes.create("ankylosaurus");
    public static final ResourceKey<DinopediaType> BARYONYX = FADinopediaTypes.create("baryonyx");
    public static final ResourceKey<DinopediaType> BRACHIOSAURUS = FADinopediaTypes.create("brachiosaurus");
    public static final ResourceKey<DinopediaType> CARNOTAURUS = FADinopediaTypes.create("carnotaurus");
    public static final ResourceKey<DinopediaType> COMPSOGNATHUS = FADinopediaTypes.create("compsognathus");
    public static final ResourceKey<DinopediaType> CRYOLOPHOSAURUS = FADinopediaTypes.create("cryolophosaurus");
    public static final ResourceKey<DinopediaType> DILOPHOSAURUS = FADinopediaTypes.create("dilophosaurus");
    public static final ResourceKey<DinopediaType> DIMETRODON = FADinopediaTypes.create("dimetrodon");
    public static final ResourceKey<DinopediaType> DISTORTUS_REX = FADinopediaTypes.create("distortus_rex");
    public static final ResourceKey<DinopediaType> DODO = FADinopediaTypes.create("dodo");
    public static final ResourceKey<DinopediaType> DRYOSAURUS = FADinopediaTypes.create("dryosaurus");
    public static final ResourceKey<DinopediaType> EGG = FADinopediaTypes.create("egg");
    public static final ResourceKey<DinopediaType> ELASMOTHERIUM = FADinopediaTypes.create("elasmotherium");
    public static final ResourceKey<DinopediaType> FUTABASAURUS = FADinopediaTypes.create("futabasaurus");
    public static final ResourceKey<DinopediaType> GALLIMIMUS = FADinopediaTypes.create("gallimimus");
    public static final ResourceKey<DinopediaType> ICHTHYOSAURUS = FADinopediaTypes.create("ichthyosaurus");
    public static final ResourceKey<DinopediaType> MAMMOTH = FADinopediaTypes.create("mammoth");
    public static final ResourceKey<DinopediaType> MOA = FADinopediaTypes.create("moa");
    public static final ResourceKey<DinopediaType> MOSASAURUS = FADinopediaTypes.create("mosasaurus");
    public static final ResourceKey<DinopediaType> PACHYCEPHALOSAURUS = FADinopediaTypes.create("pachycephalosaurus");
    public static final ResourceKey<DinopediaType> PREGNANT_ANIMAL = FADinopediaTypes.create("pregnant_animal");
    public static final ResourceKey<DinopediaType> PTERANODON = FADinopediaTypes.create("pteranodon");
    public static final ResourceKey<DinopediaType> SMILODON = FADinopediaTypes.create("smilodon");
    public static final ResourceKey<DinopediaType> SPINOSAURUS = FADinopediaTypes.create("spinosaurus");
    public static final ResourceKey<DinopediaType> STEGOSAURUS = FADinopediaTypes.create("stegosaurus");
    public static final ResourceKey<DinopediaType> THERIZINOSAURUS = FADinopediaTypes.create("therizinosaurus");
    public static final ResourceKey<DinopediaType> TRICERATOPS = FADinopediaTypes.create("triceratops");
    public static final ResourceKey<DinopediaType> TYRANNOSAURUS = FADinopediaTypes.create("tyrannosaurus");
    public static final ResourceKey<DinopediaType> VELOCIRAPTOR = FADinopediaTypes.create("velociraptor");

    private static ResourceKey<DinopediaType> create(String name) {
        return ResourceKey.create(FARegistries.DINOPEDIA_TYPE, FAUtils.resource(name));
    }

    private static void register(BootstrapContext<DinopediaType> bootstrapContext, ResourceKey<DinopediaType> resourceKey, ResourceKey<DinopediaEntry>... dinopediaEntries) {
        bootstrapContext.register(resourceKey, new DinopediaType(Arrays.asList(dinopediaEntries)));
    }

    public static void bootstrap(BootstrapContext<DinopediaType> bootstrapContext) {
        FADinopediaTypes.register(bootstrapContext, ANKYLOSAURUS, FADinopediaEntries.ANKYLOSAURUS_DATA);
        FADinopediaTypes.register(bootstrapContext, BARYONYX, FADinopediaEntries.BARYONYX_DATA);
        FADinopediaTypes.register(bootstrapContext, BRACHIOSAURUS, FADinopediaEntries.BRACHIOSAURUS_DATA);
        FADinopediaTypes.register(bootstrapContext, CARNOTAURUS, FADinopediaEntries.CARNOTAURUS_DATA);
        FADinopediaTypes.register(bootstrapContext, COMPSOGNATHUS, FADinopediaEntries.COMPSOGNATHUS_DATA);
        FADinopediaTypes.register(bootstrapContext, CRYOLOPHOSAURUS, FADinopediaEntries.CRYOLOPHOSAURUS_DATA);
        FADinopediaTypes.register(bootstrapContext, DILOPHOSAURUS, FADinopediaEntries.DILOPHOSAURUS_DATA);
        FADinopediaTypes.register(bootstrapContext, DIMETRODON, FADinopediaEntries.DIMETRODON_DATA);
        FADinopediaTypes.register(bootstrapContext, DISTORTUS_REX, FADinopediaEntries.DISTORTUS_REX_DATA);
        FADinopediaTypes.register(bootstrapContext, DODO, FADinopediaEntries.DODO_DATA);
        FADinopediaTypes.register(bootstrapContext, DRYOSAURUS, FADinopediaEntries.DRYOSAURUS_DATA);
        FADinopediaTypes.register(bootstrapContext, EGG, FADinopediaEntries.EGG_DATA);
        FADinopediaTypes.register(bootstrapContext, ELASMOTHERIUM, FADinopediaEntries.ELASMOTHERIUM_DATA);
        FADinopediaTypes.register(bootstrapContext, FUTABASAURUS, FADinopediaEntries.FUTABASAURUS_DATA);
        FADinopediaTypes.register(bootstrapContext, GALLIMIMUS, FADinopediaEntries.GALLIMIMUS_DATA);
        FADinopediaTypes.register(bootstrapContext, ICHTHYOSAURUS, FADinopediaEntries.ICHTHYOSAURUS_DATA);
        FADinopediaTypes.register(bootstrapContext, MAMMOTH, FADinopediaEntries.MAMMOTH_DATA);
        FADinopediaTypes.register(bootstrapContext, MOA, FADinopediaEntries.MOA_DATA);
        FADinopediaTypes.register(bootstrapContext, MOSASAURUS, FADinopediaEntries.MOSASAURUS_DATA);
        FADinopediaTypes.register(bootstrapContext, PACHYCEPHALOSAURUS, FADinopediaEntries.PACHYCEPHALOSAURUS_DATA);
        FADinopediaTypes.register(bootstrapContext, PREGNANT_ANIMAL, FADinopediaEntries.PREGNANCY_DATA);
        FADinopediaTypes.register(bootstrapContext, PTERANODON, FADinopediaEntries.PTERANODON_DATA);
        FADinopediaTypes.register(bootstrapContext, SMILODON, FADinopediaEntries.SMILODON_DATA);
        FADinopediaTypes.register(bootstrapContext, SPINOSAURUS, FADinopediaEntries.SPINOSAURUS_DATA);
        FADinopediaTypes.register(bootstrapContext, STEGOSAURUS, FADinopediaEntries.STEGOSAURUS_DATA);
        FADinopediaTypes.register(bootstrapContext, THERIZINOSAURUS, FADinopediaEntries.THERIZINOSAURUS_DATA);
        FADinopediaTypes.register(bootstrapContext, TRICERATOPS, FADinopediaEntries.TRICERATOPS_DATA);
        FADinopediaTypes.register(bootstrapContext, TYRANNOSAURUS, FADinopediaEntries.TYRANNOSAURUS_DATA);
        FADinopediaTypes.register(bootstrapContext, VELOCIRAPTOR, FADinopediaEntries.VELOCIRAPTOR_DATA);
    }
}
