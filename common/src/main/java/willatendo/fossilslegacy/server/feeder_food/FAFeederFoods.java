package willatendo.fossilslegacy.server.feeder_food;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FAFeederFoods {
    public static final ResourceKey<FeederFood> BEEF = FAFeederFoods.create("beef");
    public static final ResourceKey<FeederFood> COOKED_BEEF = FAFeederFoods.create("cooked_beef");
    public static final ResourceKey<FeederFood> CHICKEN = FAFeederFoods.create("chicken");
    public static final ResourceKey<FeederFood> COOKED_CHICKEN = FAFeederFoods.create("cooked_chicken");
    public static final ResourceKey<FeederFood> MUTTON = FAFeederFoods.create("mutton");
    public static final ResourceKey<FeederFood> COOKED_MUTTON = FAFeederFoods.create("cooked_mutton");
    public static final ResourceKey<FeederFood> RABBIT = FAFeederFoods.create("rabbit");
    public static final ResourceKey<FeederFood> COOKED_RABBIT = FAFeederFoods.create("cooked_rabbit");
    public static final ResourceKey<FeederFood> PORKCHOP = FAFeederFoods.create("porkchop");
    public static final ResourceKey<FeederFood> COOKED_PORKCHOP = FAFeederFoods.create("cooked_porkchop");
    public static final ResourceKey<FeederFood> COD = FAFeederFoods.create("cod");
    public static final ResourceKey<FeederFood> COOKED_COD = FAFeederFoods.create("cooked_cod");
    public static final ResourceKey<FeederFood> SALMON = FAFeederFoods.create("salmon");
    public static final ResourceKey<FeederFood> COOKED_SALMON = FAFeederFoods.create("cooked_salmon");
    public static final ResourceKey<FeederFood> TROPICAL_FISH = FAFeederFoods.create("tropical_fish");
    public static final ResourceKey<FeederFood> RAW_TRICERATOPS = FAFeederFoods.create("raw_triceratops");
    public static final ResourceKey<FeederFood> RAW_VELOCIRAPTOR = FAFeederFoods.create("raw_velociraptor");
    public static final ResourceKey<FeederFood> RAW_TYRANNOSAURUS = FAFeederFoods.create("raw_tyrannosaurus");
    public static final ResourceKey<FeederFood> RAW_PTERANODON = FAFeederFoods.create("raw_pteranodon");
    public static final ResourceKey<FeederFood> RAW_FUTABASAURUS = FAFeederFoods.create("raw_futabasaurus");
    public static final ResourceKey<FeederFood> RAW_MOSASAURUS = FAFeederFoods.create("raw_mosasaurus");
    public static final ResourceKey<FeederFood> RAW_STEGOSAURUS = FAFeederFoods.create("raw_stegosaurus");
    public static final ResourceKey<FeederFood> RAW_DILOPHOSAURUS = FAFeederFoods.create("raw_dilophosaurus");
    public static final ResourceKey<FeederFood> RAW_BRACHIOSAURUS = FAFeederFoods.create("raw_brachiosaurus");
    public static final ResourceKey<FeederFood> RAW_SMILODON = FAFeederFoods.create("raw_smilodon");
    public static final ResourceKey<FeederFood> RAW_MAMMOTH = FAFeederFoods.create("raw_mammoth");
    public static final ResourceKey<FeederFood> RAW_CARNOTAURUS = FAFeederFoods.create("raw_carnotaurus");
    public static final ResourceKey<FeederFood> RAW_CRYOLOPHOSAURUS = FAFeederFoods.create("raw_cryolophosaurus");
    public static final ResourceKey<FeederFood> RAW_THERIZINOSAURUS = FAFeederFoods.create("raw_therizinosaurus");
    public static final ResourceKey<FeederFood> RAW_PACHYCEPHALOSAURUS = FAFeederFoods.create("raw_pachycephalosaurus");
    public static final ResourceKey<FeederFood> RAW_COMPSOGNATHUS = FAFeederFoods.create("raw_compsognathus");
    public static final ResourceKey<FeederFood> RAW_DODO = FAFeederFoods.create("raw_dodo");
    public static final ResourceKey<FeederFood> RAW_MOA = FAFeederFoods.create("raw_moa");
    public static final ResourceKey<FeederFood> RAW_GALLIMIMUS = FAFeederFoods.create("raw_gallimimus");
    public static final ResourceKey<FeederFood> RAW_SPINOSAURUS = FAFeederFoods.create("raw_spinosaurus");
    public static final ResourceKey<FeederFood> RAW_ANKYLOSAURUS = FAFeederFoods.create("raw_ankylosaurus");
    public static final ResourceKey<FeederFood> RAW_DIMETRODON = FAFeederFoods.create("raw_dimetrodon");
    public static final ResourceKey<FeederFood> RAW_ICHTHYOSAURUS = FAFeederFoods.create("raw_ichthyosaurus");
    public static final ResourceKey<FeederFood> RAW_ELASMOTHERIUM = FAFeederFoods.create("raw_elasmotherium");
    public static final ResourceKey<FeederFood> COOKED_TRICERATOPS = FAFeederFoods.create("cooked_triceratops");
    public static final ResourceKey<FeederFood> COOKED_VELOCIRAPTOR = FAFeederFoods.create("cooked_velociraptor");
    public static final ResourceKey<FeederFood> COOKED_TYRANNOSAURUS = FAFeederFoods.create("cooked_tyrannosaurus");
    public static final ResourceKey<FeederFood> COOKED_PTERANODON = FAFeederFoods.create("cooked_pteranodon");
    public static final ResourceKey<FeederFood> SIO_CHIU_LE = FAFeederFoods.create("sio_chiu_le");
    public static final ResourceKey<FeederFood> COOKED_FUTABASAURUS = FAFeederFoods.create("cooked_futabasaurus");
    public static final ResourceKey<FeederFood> COOKED_MOSASAURUS = FAFeederFoods.create("cooked_mosasaurus");
    public static final ResourceKey<FeederFood> COOKED_STEGOSAURUS = FAFeederFoods.create("cooked_stegosaurus");
    public static final ResourceKey<FeederFood> COOKED_DILOPHOSAURUS = FAFeederFoods.create("cooked_dilophosaurus");
    public static final ResourceKey<FeederFood> COOKED_BRACHIOSAURUS = FAFeederFoods.create("cooked_brachiosaurus");
    public static final ResourceKey<FeederFood> COOKED_SMILODON = FAFeederFoods.create("cooked_smilodon");
    public static final ResourceKey<FeederFood> COOKED_MAMMOTH = FAFeederFoods.create("cooked_mammoth");
    public static final ResourceKey<FeederFood> COOKED_CARNOTAURUS = FAFeederFoods.create("cooked_carnotaurus");
    public static final ResourceKey<FeederFood> COOKED_CRYOLOPHOSAURUS = FAFeederFoods.create("cooked_cryolophosaurus");
    public static final ResourceKey<FeederFood> COOKED_THERIZINOSAURUS = FAFeederFoods.create("cooked_therizinosaurus");
    public static final ResourceKey<FeederFood> COOKED_PACHYCEPHALOSAURUS = FAFeederFoods.create("cooked_pachycephalosaurus");
    public static final ResourceKey<FeederFood> COOKED_COMPSOGNATHUS = FAFeederFoods.create("cooked_compsognathus");
    public static final ResourceKey<FeederFood> COOKED_DODO = FAFeederFoods.create("cooked_dodo");
    public static final ResourceKey<FeederFood> COOKED_MOA = FAFeederFoods.create("cooked_moa");
    public static final ResourceKey<FeederFood> COOKED_GALLIMIMUS = FAFeederFoods.create("cooked_gallimimus");
    public static final ResourceKey<FeederFood> COOKED_SPINOSAURUS = FAFeederFoods.create("cooked_spinosaurus");
    public static final ResourceKey<FeederFood> COOKED_ANKYLOSAURUS = FAFeederFoods.create("cooked_ankylosaurus");
    public static final ResourceKey<FeederFood> COOKED_DIMETRODON = FAFeederFoods.create("cooked_dimetrodon");
    public static final ResourceKey<FeederFood> COOKED_ICHTHYOSAURUS = FAFeederFoods.create("cooked_ichthyosaurus");
    public static final ResourceKey<FeederFood> COOKED_ELASMOTHERIUM = FAFeederFoods.create("cooked_elasmotherium");
    public static final ResourceKey<FeederFood> APPLE = FAFeederFoods.create("apple");
    public static final ResourceKey<FeederFood> WHEAT = FAFeederFoods.create("wheat");
    public static final ResourceKey<FeederFood> BREAD = FAFeederFoods.create("bread");
    public static final ResourceKey<FeederFood> SUGAR_CANE = FAFeederFoods.create("sugar_cane");
    public static final ResourceKey<FeederFood> WHEAT_SEEDS = FAFeederFoods.create("wheat_seeds");
    public static final ResourceKey<FeederFood> BEETROOT_SEEDS = FAFeederFoods.create("beetroot_seeds");
    public static final ResourceKey<FeederFood> MELON_SEEDS = FAFeederFoods.create("melon_seeds");
    public static final ResourceKey<FeederFood> PUMPKIN_SEEDS = FAFeederFoods.create("pumpkin_seeds");
    public static final ResourceKey<FeederFood> MELON_SLICE = FAFeederFoods.create("melon_slice");
    public static final ResourceKey<FeederFood> SWEET_BERRIES = FAFeederFoods.create("sweet_berries");
    public static final ResourceKey<FeederFood> GLOW_BERRIES = FAFeederFoods.create("glow_berries");
    public static final ResourceKey<FeederFood> CARROT = FAFeederFoods.create("carrot");
    public static final ResourceKey<FeederFood> POTATO = FAFeederFoods.create("potato");
    public static final ResourceKey<FeederFood> BAKED_POTATO = FAFeederFoods.create("baked_potato");
    public static final ResourceKey<FeederFood> BEETROOT = FAFeederFoods.create("beetroot");
    public static final ResourceKey<FeederFood> KELP = FAFeederFoods.create("kelp");
    public static final ResourceKey<FeederFood> JURASSIC_FERN_SPORES = FAFeederFoods.create("jurassic_fern_spores");

    public static ResourceKey<FeederFood> create(String name) {
        return ResourceKey.create(FARegistries.FEEDER_FOOD, FAUtils.resource(name));
    }

    private static void register(BootstrapContext<FeederFood> bootstrapContext, ResourceKey<FeederFood> resourceKey, Item item, int fillAmount, FeederFood.FillType fillType) {
        bootstrapContext.register(resourceKey, new FeederFood(BuiltInRegistries.ITEM.getKey(item), new FeederFood.FeederInfo(fillAmount, fillType)));
    }

    public static void bootstrap(BootstrapContext<FeederFood> bootstrapContext) {
        register(bootstrapContext, BEEF, Items.BEEF, 40, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_BEEF, Items.COOKED_BEEF, 20, FeederFood.FillType.MEAT);
        register(bootstrapContext, CHICKEN, Items.CHICKEN, 30, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_CHICKEN, Items.COOKED_CHICKEN, 10, FeederFood.FillType.MEAT);
        register(bootstrapContext, MUTTON, Items.MUTTON, 30, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_MUTTON, Items.COOKED_MUTTON, 10, FeederFood.FillType.MEAT);
        register(bootstrapContext, RABBIT, Items.RABBIT, 30, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_RABBIT, Items.COOKED_RABBIT, 10, FeederFood.FillType.MEAT);
        register(bootstrapContext, PORKCHOP, Items.PORKCHOP, 20, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_PORKCHOP, Items.COOKED_PORKCHOP, 30, FeederFood.FillType.MEAT);
        register(bootstrapContext, COD, Items.COD, 40, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_COD, Items.COOKED_COD, 60, FeederFood.FillType.MEAT);
        register(bootstrapContext, SALMON, Items.SALMON, 40, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_SALMON, Items.COOKED_SALMON, 60, FeederFood.FillType.MEAT);
        register(bootstrapContext, TROPICAL_FISH, Items.TROPICAL_FISH, 40, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_TRICERATOPS, FAItems.RAW_TRICERATOPS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_VELOCIRAPTOR, FAItems.RAW_VELOCIRAPTOR.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_TYRANNOSAURUS, FAItems.RAW_TYRANNOSAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_PTERANODON, FAItems.RAW_PTERANODON.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_FUTABASAURUS, FAItems.RAW_FUTABASAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_MOSASAURUS, FAItems.RAW_MOSASAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_STEGOSAURUS, FAItems.RAW_STEGOSAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_DILOPHOSAURUS, FAItems.RAW_DILOPHOSAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_BRACHIOSAURUS, FAItems.RAW_BRACHIOSAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_SMILODON, FAItems.RAW_SMILODON.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_MAMMOTH, FAItems.RAW_MAMMOTH.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_CARNOTAURUS, FAItems.RAW_CARNOTAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_CRYOLOPHOSAURUS, FAItems.RAW_CRYOLOPHOSAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_THERIZINOSAURUS, FAItems.RAW_THERIZINOSAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_PACHYCEPHALOSAURUS, FAItems.RAW_PACHYCEPHALOSAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_COMPSOGNATHUS, FAItems.RAW_COMPSOGNATHUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_DODO, FAItems.RAW_DODO.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_MOA, FAItems.RAW_MOA.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_GALLIMIMUS, FAItems.RAW_GALLIMIMUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_SPINOSAURUS, FAItems.RAW_SPINOSAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_ANKYLOSAURUS, FAItems.RAW_ANKYLOSAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_DIMETRODON, FAItems.RAW_DIMETRODON.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_ICHTHYOSAURUS, FAItems.RAW_ICHTHYOSAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, RAW_ELASMOTHERIUM, FAItems.RAW_ELASMOTHERIUM.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_TRICERATOPS, FAItems.COOKED_TRICERATOPS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_VELOCIRAPTOR, FAItems.COOKED_VELOCIRAPTOR.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_TYRANNOSAURUS, FAItems.COOKED_TYRANNOSAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_PTERANODON, FAItems.COOKED_PTERANODON.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, SIO_CHIU_LE, FAItems.SIO_CHIU_LE.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_FUTABASAURUS, FAItems.COOKED_FUTABASAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_MOSASAURUS, FAItems.COOKED_MOSASAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_STEGOSAURUS, FAItems.COOKED_STEGOSAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_DILOPHOSAURUS, FAItems.COOKED_DILOPHOSAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_BRACHIOSAURUS, FAItems.COOKED_BRACHIOSAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_SMILODON, FAItems.COOKED_SMILODON.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_MAMMOTH, FAItems.COOKED_MAMMOTH.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_CARNOTAURUS, FAItems.COOKED_CARNOTAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_CRYOLOPHOSAURUS, FAItems.COOKED_CRYOLOPHOSAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_THERIZINOSAURUS, FAItems.COOKED_THERIZINOSAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_PACHYCEPHALOSAURUS, FAItems.COOKED_PACHYCEPHALOSAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_COMPSOGNATHUS, FAItems.COOKED_COMPSOGNATHUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_DODO, FAItems.COOKED_DODO.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_MOA, FAItems.COOKED_MOA.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_GALLIMIMUS, FAItems.COOKED_GALLIMIMUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_SPINOSAURUS, FAItems.COOKED_SPINOSAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_ANKYLOSAURUS, FAItems.COOKED_ANKYLOSAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_DIMETRODON, FAItems.COOKED_DIMETRODON.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_ICHTHYOSAURUS, FAItems.COOKED_ICHTHYOSAURUS.get(), 100, FeederFood.FillType.MEAT);
        register(bootstrapContext, COOKED_ELASMOTHERIUM, FAItems.COOKED_ELASMOTHERIUM.get(), 100, FeederFood.FillType.MEAT);

        register(bootstrapContext, APPLE, Items.APPLE, 100, FeederFood.FillType.PLANT);
        register(bootstrapContext, WHEAT, Items.WHEAT, 40, FeederFood.FillType.PLANT);
        register(bootstrapContext, BREAD, Items.BREAD, 120, FeederFood.FillType.PLANT);
        register(bootstrapContext, SUGAR_CANE, Items.SUGAR_CANE, 20, FeederFood.FillType.PLANT);
        register(bootstrapContext, WHEAT_SEEDS, Items.WHEAT_SEEDS, 20, FeederFood.FillType.PLANT);
        register(bootstrapContext, BEETROOT_SEEDS, Items.BEETROOT_SEEDS, 20, FeederFood.FillType.PLANT);
        register(bootstrapContext, MELON_SEEDS, Items.MELON_SEEDS, 20, FeederFood.FillType.PLANT);
        register(bootstrapContext, PUMPKIN_SEEDS, Items.PUMPKIN_SEEDS, 20, FeederFood.FillType.PLANT);
        register(bootstrapContext, MELON_SLICE, Items.MELON_SLICE, 25, FeederFood.FillType.PLANT);
        register(bootstrapContext, SWEET_BERRIES, Items.SWEET_BERRIES, 15, FeederFood.FillType.PLANT);
        register(bootstrapContext, GLOW_BERRIES, Items.GLOW_BERRIES, 15, FeederFood.FillType.PLANT);
        register(bootstrapContext, CARROT, Items.CARROT, 100, FeederFood.FillType.PLANT);
        register(bootstrapContext, POTATO, Items.POTATO, 100, FeederFood.FillType.PLANT);
        register(bootstrapContext, BAKED_POTATO, Items.BAKED_POTATO, 75, FeederFood.FillType.PLANT);
        register(bootstrapContext, BEETROOT, Items.BEETROOT, 25, FeederFood.FillType.PLANT);
        register(bootstrapContext, KELP, Items.KELP, 15, FeederFood.FillType.PLANT);
        register(bootstrapContext, JURASSIC_FERN_SPORES, FAItems.JURASSIC_FERN_SPORES.get(), 50, FeederFood.FillType.PLANT);
    }
}
