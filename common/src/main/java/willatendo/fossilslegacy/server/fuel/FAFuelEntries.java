package willatendo.fossilslegacy.server.fuel;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class FAFuelEntries {
    public static final ResourceKey<FuelEntry> FOSSIL = FAFuelEntries.create("fossil");
    public static final ResourceKey<FuelEntry> RAW_CHICKEN_SOUP_BUCKET = FAFuelEntries.create("raw_chicken_soup_bucket");
    public static final ResourceKey<FuelEntry> RAW_BERRY_MEDLEY_BUCKET = FAFuelEntries.create("raw_berry_medley_bucket");
    public static final ResourceKey<FuelEntry> AXOLOTLSPAWN = FAFuelEntries.create("axolotlspawn");
    public static final ResourceKey<FuelEntry> ANKYLOSAURUS_EGG = FAFuelEntries.create("ankylosaurus_egg");
    public static final ResourceKey<FuelEntry> BRACHIOSAURUS_EGG = FAFuelEntries.create("brachiosaurus_egg");
    public static final ResourceKey<FuelEntry> CARNOTAURUS_EGG = FAFuelEntries.create("carnotaurus_egg");
    public static final ResourceKey<FuelEntry> COMPSOGNATHUS_EGG = FAFuelEntries.create("compsognathus_egg");
    public static final ResourceKey<FuelEntry> CRYOLOPHOSAURUS_EGG = FAFuelEntries.create("cryolophosaurus_egg");
    public static final ResourceKey<FuelEntry> DILOPHOSAURUS_EGG = FAFuelEntries.create("dilophosaurus_egg");
    public static final ResourceKey<FuelEntry> DIMETRODON_EGG = FAFuelEntries.create("dimetrodon_egg");
    public static final ResourceKey<FuelEntry> FROGSPAWN = FAFuelEntries.create("frogspawn");
    public static final ResourceKey<FuelEntry> GALLIMIMUS_EGG = FAFuelEntries.create("gallimimus_egg");
    public static final ResourceKey<FuelEntry> INCUBATED_CHICKEN_EGG = FAFuelEntries.create("incubated_chicken_egg");
    public static final ResourceKey<FuelEntry> INCUBATED_DODO_EGG = FAFuelEntries.create("incubated_dodo_egg");
    public static final ResourceKey<FuelEntry> INCUBATED_MOA_EGG = FAFuelEntries.create("incubated_moa_egg");
    public static final ResourceKey<FuelEntry> INCUBATED_PARROT_EGG = FAFuelEntries.create("incubated_parrot_egg");
    public static final ResourceKey<FuelEntry> MOSASAURUS_EGG = FAFuelEntries.create("mosasaurus_egg");
    public static final ResourceKey<FuelEntry> NAUTILUS_EGGS = FAFuelEntries.create("nautilus_eggs");
    public static final ResourceKey<FuelEntry> FUTABASAURUS_EGG = FAFuelEntries.create("futabasaurus_egg");
    public static final ResourceKey<FuelEntry> PACHYCEPHALOSAURUS_EGG = FAFuelEntries.create("pachycephalosaurus_egg");
    public static final ResourceKey<FuelEntry> PTERANODON_EGG = FAFuelEntries.create("pteranodon_egg");
    public static final ResourceKey<FuelEntry> SPINOSAURUS_EGG = FAFuelEntries.create("spinosaurus_egg");
    public static final ResourceKey<FuelEntry> STEGOSAURUS_EGG = FAFuelEntries.create("stegosaurus_egg");
    public static final ResourceKey<FuelEntry> THERIZINOSAURUS_EGG = FAFuelEntries.create("therizinosaurus_egg");
    public static final ResourceKey<FuelEntry> TRICERATOPS_EGG = FAFuelEntries.create("triceratops_egg");
    public static final ResourceKey<FuelEntry> TYRANNOSAURUS_EGG = FAFuelEntries.create("tyrannosaurus_egg");
    public static final ResourceKey<FuelEntry> VELOCIRAPTOR_EGG = FAFuelEntries.create("velociraptor_egg");
    public static final ResourceKey<FuelEntry> RAW_ANKYLOSAURUS = FAFuelEntries.create("raw_ankylosaurus");
    public static final ResourceKey<FuelEntry> RAW_BRACHIOSAURUS = FAFuelEntries.create("raw_brachiosaurus");
    public static final ResourceKey<FuelEntry> RAW_CARNOTAURUS = FAFuelEntries.create("raw_carnotaurus");
    public static final ResourceKey<FuelEntry> RAW_COMPSOGNATHUS = FAFuelEntries.create("raw_compsognathus");
    public static final ResourceKey<FuelEntry> RAW_CRYOLOPHOSAURUS = FAFuelEntries.create("raw_cryolophosaurus");
    public static final ResourceKey<FuelEntry> RAW_DILOPHOSAURUS = FAFuelEntries.create("raw_dilophosaurus");
    public static final ResourceKey<FuelEntry> RAW_DIMETRODON = FAFuelEntries.create("raw_dimetrodon");
    public static final ResourceKey<FuelEntry> RAW_DODO = FAFuelEntries.create("raw_dodo");
    public static final ResourceKey<FuelEntry> RAW_GALLIMIMUS = FAFuelEntries.create("raw_gallimimus");
    public static final ResourceKey<FuelEntry> RAW_MAMMOTH = FAFuelEntries.create("raw_mammoth");
    public static final ResourceKey<FuelEntry> RAW_MOA = FAFuelEntries.create("raw_moa");
    public static final ResourceKey<FuelEntry> RAW_MOSASAURUS = FAFuelEntries.create("raw_mosasaurus");
    public static final ResourceKey<FuelEntry> RAW_FUTABASAURUS = FAFuelEntries.create("raw_futabasaurus");
    public static final ResourceKey<FuelEntry> RAW_PACHYCEPHALOSAURUS = FAFuelEntries.create("raw_pachycephalosaurus");
    public static final ResourceKey<FuelEntry> RAW_PTERANODON = FAFuelEntries.create("raw_pteranodon");
    public static final ResourceKey<FuelEntry> RAW_SMILODON = FAFuelEntries.create("raw_smilodon");
    public static final ResourceKey<FuelEntry> RAW_SPINOSAURUS = FAFuelEntries.create("raw_spinosaurus");
    public static final ResourceKey<FuelEntry> RAW_STEGOSAURUS = FAFuelEntries.create("raw_stegosaurus");
    public static final ResourceKey<FuelEntry> RAW_THERIZINOSAURUS = FAFuelEntries.create("raw_therizinosaurus");
    public static final ResourceKey<FuelEntry> RAW_TRICERATOPS = FAFuelEntries.create("raw_triceratops");
    public static final ResourceKey<FuelEntry> RAW_TYRANNOSAURUS = FAFuelEntries.create("raw_tyrannosaurus");
    public static final ResourceKey<FuelEntry> RAW_VELOCIRAPTOR = FAFuelEntries.create("raw_velociraptor");
    public static final ResourceKey<FuelEntry> PORKCHOP = FAFuelEntries.create("porkchop");
    public static final ResourceKey<FuelEntry> COD = FAFuelEntries.create("cod");
    public static final ResourceKey<FuelEntry> SALMON = FAFuelEntries.create("salmon");
    public static final ResourceKey<FuelEntry> TROPICAL_FISH = FAFuelEntries.create("tropical_fish");
    public static final ResourceKey<FuelEntry> BEEF = FAFuelEntries.create("beef");
    public static final ResourceKey<FuelEntry> MUTTON = FAFuelEntries.create("mutton");
    public static final ResourceKey<FuelEntry> RABBIT = FAFuelEntries.create("rabbit");
    public static final ResourceKey<FuelEntry> CHICKEN = FAFuelEntries.create("chicken");
    public static final ResourceKey<FuelEntry> EGG = FAFuelEntries.create("egg");
    public static final ResourceKey<FuelEntry> DODO_EGG = FAFuelEntries.create("dodo_egg");
    public static final ResourceKey<FuelEntry> MOA_EGG = FAFuelEntries.create("moa_egg");
    public static final ResourceKey<FuelEntry> SLIME_BALL = FAFuelEntries.create("slime_ball");
    public static final ResourceKey<FuelEntry> MILK_BUCKET = FAFuelEntries.create("milk_bucket");

    public static final ResourceKey<FuelEntry> RELIC_SCRAP = FAFuelEntries.create("relic_scrap");

    private static ResourceKey<FuelEntry> create(String name) {
        return ResourceKey.create(FARegistries.FUEL_ENTRY, FAUtils.resource(name));
    }

    private static void register(BootstrapContext<FuelEntry> bootstrapContext, ResourceKey<FuelEntry> resourceKey, Item fuel, int time) {
        bootstrapContext.register(resourceKey, new FuelEntry(BuiltInRegistries.ITEM.getKey(fuel), time));
    }

    public static void bootstrap(BootstrapContext<FuelEntry> bootstrapContext) {
        FAFuelEntries.register(bootstrapContext, FOSSIL, FAItems.FOSSIL.get(), 300);
        FAFuelEntries.register(bootstrapContext, RAW_CHICKEN_SOUP_BUCKET, FAItems.RAW_CHICKEN_SOUP_BUCKET.get(), 1000);
        FAFuelEntries.register(bootstrapContext, RAW_BERRY_MEDLEY_BUCKET, FAItems.RAW_BERRY_MEDLEY_BUCKET.get(), 1000);
        FAFuelEntries.register(bootstrapContext, AXOLOTLSPAWN, FABlocks.AXOLOTLSPAWN.get().asItem(), 12000);
        FAFuelEntries.register(bootstrapContext, ANKYLOSAURUS_EGG, FAItems.ANKYLOSAURUS_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, BRACHIOSAURUS_EGG, FAItems.BRACHIOSAURUS_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, CARNOTAURUS_EGG, FAItems.CARNOTAURUS_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, COMPSOGNATHUS_EGG, FAItems.COMPSOGNATHUS_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, CRYOLOPHOSAURUS_EGG, FAItems.CRYOLOPHOSAURUS_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, DILOPHOSAURUS_EGG, FAItems.DILOPHOSAURUS_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, DIMETRODON_EGG, FAItems.DIMETRODON_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, FROGSPAWN, Items.FROGSPAWN, 12000);
        FAFuelEntries.register(bootstrapContext, INCUBATED_CHICKEN_EGG, FAItems.INCUBATED_CHICKEN_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, INCUBATED_DODO_EGG, FAItems.INCUBATED_DODO_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, INCUBATED_MOA_EGG, FAItems.INCUBATED_MOA_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, INCUBATED_PARROT_EGG, FAItems.INCUBATED_PARROT_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, MOSASAURUS_EGG, FAItems.MOSASAURUS_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, NAUTILUS_EGGS, FAItems.NAUTILUS_EGGS.get(), 12000);
        FAFuelEntries.register(bootstrapContext, FUTABASAURUS_EGG, FAItems.FUTABASAURUS_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, GALLIMIMUS_EGG, FAItems.GALLIMIMUS_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, PACHYCEPHALOSAURUS_EGG, FAItems.PACHYCEPHALOSAURUS_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, PTERANODON_EGG, FAItems.PTERANODON_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, SPINOSAURUS_EGG, FAItems.SPINOSAURUS_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, STEGOSAURUS_EGG, FAItems.STEGOSAURUS_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, THERIZINOSAURUS_EGG, FAItems.THERIZINOSAURUS_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, TRICERATOPS_EGG, FAItems.TRICERATOPS_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, TYRANNOSAURUS_EGG, FAItems.TYRANNOSAURUS_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, VELOCIRAPTOR_EGG, FAItems.VELOCIRAPTOR_EGG.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_ANKYLOSAURUS, FAItems.RAW_ANKYLOSAURUS.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_BRACHIOSAURUS, FAItems.RAW_BRACHIOSAURUS.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_CARNOTAURUS, FAItems.RAW_CARNOTAURUS.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_COMPSOGNATHUS, FAItems.RAW_COMPSOGNATHUS.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_CRYOLOPHOSAURUS, FAItems.RAW_CRYOLOPHOSAURUS.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_DILOPHOSAURUS, FAItems.RAW_DILOPHOSAURUS.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_DIMETRODON, FAItems.RAW_DIMETRODON.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_DODO, FAItems.RAW_DODO.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_GALLIMIMUS, FAItems.RAW_GALLIMIMUS.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_MAMMOTH, FAItems.RAW_MAMMOTH.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_MOA, FAItems.RAW_MOA.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_MOSASAURUS, FAItems.RAW_MOSASAURUS.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_FUTABASAURUS, FAItems.RAW_FUTABASAURUS.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_PACHYCEPHALOSAURUS, FAItems.RAW_PACHYCEPHALOSAURUS.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_PTERANODON, FAItems.RAW_PTERANODON.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_SMILODON, FAItems.RAW_SMILODON.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_SPINOSAURUS, FAItems.RAW_SPINOSAURUS.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_STEGOSAURUS, FAItems.RAW_STEGOSAURUS.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_THERIZINOSAURUS, FAItems.RAW_THERIZINOSAURUS.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_TRICERATOPS, FAItems.RAW_TRICERATOPS.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_TYRANNOSAURUS, FAItems.RAW_TYRANNOSAURUS.get(), 12000);
        FAFuelEntries.register(bootstrapContext, RAW_VELOCIRAPTOR, FAItems.RAW_VELOCIRAPTOR.get(), 12000);
        FAFuelEntries.register(bootstrapContext, PORKCHOP, Items.PORKCHOP, 3000);
        FAFuelEntries.register(bootstrapContext, COD, Items.COD, 3000);
        FAFuelEntries.register(bootstrapContext, SALMON, Items.SALMON, 3000);
        FAFuelEntries.register(bootstrapContext, TROPICAL_FISH, Items.TROPICAL_FISH, 3000);
        FAFuelEntries.register(bootstrapContext, BEEF, Items.BEEF, 4000);
        FAFuelEntries.register(bootstrapContext, MUTTON, Items.MUTTON, 3000);
        FAFuelEntries.register(bootstrapContext, RABBIT, Items.RABBIT, 3000);
        FAFuelEntries.register(bootstrapContext, CHICKEN, Items.CHICKEN, 1500);
        FAFuelEntries.register(bootstrapContext, EGG, Items.EGG, 1000);
        FAFuelEntries.register(bootstrapContext, DODO_EGG, FAItems.DODO_EGG.get(), 1000);
        FAFuelEntries.register(bootstrapContext, MOA_EGG, FAItems.MOA_EGG.get(), 1000);
        FAFuelEntries.register(bootstrapContext, SLIME_BALL, Items.SLIME_BALL, 800);
        FAFuelEntries.register(bootstrapContext, MILK_BUCKET, Items.MILK_BUCKET, 6000);

        FAFuelEntries.register(bootstrapContext, RELIC_SCRAP, FAItems.RELIC_SCRAP.get(), 100);
    }
}
