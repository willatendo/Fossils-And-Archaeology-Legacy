package willatendo.fossilslegacy.server.item.dinopedia;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.Arrays;

public class FossilsLegacyDinopediaTypes {
    public static final ResourceKey<DinopediaType> ANKYLOSAURUS = FossilsLegacyDinopediaTypes.create("ankylosaurus");
    public static final ResourceKey<DinopediaType> BRACHIOSAURUS = FossilsLegacyDinopediaTypes.create("brachiosaurus");
    public static final ResourceKey<DinopediaType> CARNOTAURUS = FossilsLegacyDinopediaTypes.create("carnotaurus");
    public static final ResourceKey<DinopediaType> COMPSOGNATHUS = FossilsLegacyDinopediaTypes.create("compsognathus");
    public static final ResourceKey<DinopediaType> CRYOLOPHOSAURUS = FossilsLegacyDinopediaTypes.create("cryolophosaurus");
    public static final ResourceKey<DinopediaType> DILOPHOSAURUS = FossilsLegacyDinopediaTypes.create("dilophosaurus");
    public static final ResourceKey<DinopediaType> DIMETRODON = FossilsLegacyDinopediaTypes.create("dimetrodon");
    public static final ResourceKey<DinopediaType> DODO = FossilsLegacyDinopediaTypes.create("dodo");
    public static final ResourceKey<DinopediaType> EGG = FossilsLegacyDinopediaTypes.create("egg");
    public static final ResourceKey<DinopediaType> FUTABASAURUS = FossilsLegacyDinopediaTypes.create("futabasaurus");
    public static final ResourceKey<DinopediaType> GALLIMIMUS = FossilsLegacyDinopediaTypes.create("gallimimus");
    public static final ResourceKey<DinopediaType> MAMMOTH = FossilsLegacyDinopediaTypes.create("mammoth");
    public static final ResourceKey<DinopediaType> MOA = FossilsLegacyDinopediaTypes.create("moa");
    public static final ResourceKey<DinopediaType> MOSASAURUS = FossilsLegacyDinopediaTypes.create("mosasaurus");
    public static final ResourceKey<DinopediaType> PACHYCEPHALOSAURUS = FossilsLegacyDinopediaTypes.create("pachycephalosaurus");
    public static final ResourceKey<DinopediaType> PTERANODON = FossilsLegacyDinopediaTypes.create("pteranodon");
    public static final ResourceKey<DinopediaType> SMILODON = FossilsLegacyDinopediaTypes.create("smilodon");
    public static final ResourceKey<DinopediaType> SPINOSAURUS = FossilsLegacyDinopediaTypes.create("spinosaurus");
    public static final ResourceKey<DinopediaType> STEGOSAURUS = FossilsLegacyDinopediaTypes.create("stegosaurus");
    public static final ResourceKey<DinopediaType> THERIZINOSAURUS = FossilsLegacyDinopediaTypes.create("therizinosaurus");
    public static final ResourceKey<DinopediaType> TRICERATOPS = FossilsLegacyDinopediaTypes.create("triceratops");
    public static final ResourceKey<DinopediaType> TYRANNOSAURUS = FossilsLegacyDinopediaTypes.create("tyrannosaurus");
    public static final ResourceKey<DinopediaType> VELOCIRAPTOR = FossilsLegacyDinopediaTypes.create("velociraptor");

    private static ResourceKey<DinopediaType> create(String name) {
        return ResourceKey.create(FossilsLegacyRegistries.DINOPEDIA_TYPE, FossilsLegacyUtils.resource(name));
    }

    private static void register(BootstrapContext<DinopediaType> bootstrapContext, ResourceKey<DinopediaType> resourceKey, ResourceKey<DinopediaEntry>... dinopediaEntries) {
        bootstrapContext.register(resourceKey, new DinopediaType(Arrays.asList(dinopediaEntries)));
    }

    public static void bootstrap(BootstrapContext<DinopediaType> bootstrapContext) {
        FossilsLegacyDinopediaTypes.register(bootstrapContext, ANKYLOSAURUS, FossilsLegacyDinopediaEntries.ANKYLOSAURUS_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, BRACHIOSAURUS, FossilsLegacyDinopediaEntries.BRACHIOSAURUS_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, CARNOTAURUS, FossilsLegacyDinopediaEntries.CARNOTAURUS_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, COMPSOGNATHUS, FossilsLegacyDinopediaEntries.COMPSOGNATHUS_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, CRYOLOPHOSAURUS, FossilsLegacyDinopediaEntries.CRYOLOPHOSAURUS_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, DILOPHOSAURUS, FossilsLegacyDinopediaEntries.DILOPHOSAURUS_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, DIMETRODON, FossilsLegacyDinopediaEntries.DIMETRODON_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, DODO, FossilsLegacyDinopediaEntries.DODO_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, EGG, FossilsLegacyDinopediaEntries.EGG_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, FUTABASAURUS, FossilsLegacyDinopediaEntries.FUTABASAURUS_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, GALLIMIMUS, FossilsLegacyDinopediaEntries.GALLIMIMUS_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, MAMMOTH, FossilsLegacyDinopediaEntries.MAMMOTH_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, MOA, FossilsLegacyDinopediaEntries.MOA_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, MOSASAURUS, FossilsLegacyDinopediaEntries.MOSASAURUS_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, PACHYCEPHALOSAURUS, FossilsLegacyDinopediaEntries.PACHYCEPHALOSAURUS_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, PTERANODON, FossilsLegacyDinopediaEntries.PTERANODON_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, SMILODON, FossilsLegacyDinopediaEntries.SMILODON_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, SPINOSAURUS, FossilsLegacyDinopediaEntries.SPINOSAURUS_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, STEGOSAURUS, FossilsLegacyDinopediaEntries.STEGOSAURUS_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, THERIZINOSAURUS, FossilsLegacyDinopediaEntries.THERIZINOSAURUS_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, TRICERATOPS, FossilsLegacyDinopediaEntries.TRICERATOPS_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, TYRANNOSAURUS, FossilsLegacyDinopediaEntries.TYRANNOSAURUS_DATA);
        FossilsLegacyDinopediaTypes.register(bootstrapContext, VELOCIRAPTOR, FossilsLegacyDinopediaEntries.VELOCIRAPTOR_DATA);
    }
}
