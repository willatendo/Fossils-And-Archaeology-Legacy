package willatendo.fossilslegacy.server.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public final class FALootTables {
    public static final ResourceKey<LootTable> ACADEMY_LOOT = FALootTables.create("chests/academy_loot");
    public static final ResourceKey<LootTable> ACADEMY_DISC = FALootTables.create("chests/academy_disc");
    public static final ResourceKey<LootTable> LAB_DNA_LOOT = FALootTables.create("chests/lab_loot/dna");
    public static final ResourceKey<LootTable> LAB_FOSSIL_LOOT = FALootTables.create("chests/lab_loot/fossil");
    public static final ResourceKey<LootTable> LAB_FAILED_EXPERIMENT_LOOT = FALootTables.create("chests/lab_loot/failed_experiment");
    public static final ResourceKey<LootTable> MAYAN_LOOT = FALootTables.create("chests/mayan_loot");
    public static final ResourceKey<LootTable> MAYAN_TREASURE = FALootTables.create("chests/mayan_treasure");
    public static final ResourceKey<LootTable> WEAPON_SHOP_DECOY = FALootTables.create("chests/weapon_shop_decoy");
    public static final ResourceKey<LootTable> WEAPON_SHOP_LOOT = FALootTables.create("chests/weapon_shop_loot");

    public static final ResourceKey<LootTable> VILLAGE_ARCHAEOLOGIST_HUT = FALootTables.create("chests/village/village_archaeologist_hut");

    public static final ResourceKey<LootTable> INCA_LOOT = FALootTables.create("archaeology/inca_loot");

    public static final ResourceKey<LootTable> ANKYLOSAURUS_EGG = FALootTables.create("entities/egg/ankylosaurus");
    public static final ResourceKey<LootTable> BRACHIOSAURUS_EGG = FALootTables.create("entities/egg/brachiosaurus");
    public static final ResourceKey<LootTable> DILOPHOSAURUS_EGG = FALootTables.create("entities/egg/dilophosaurus");
    public static final ResourceKey<LootTable> DIMETRODON_EGG = FALootTables.create("entities/egg/dimetrodon");
    public static final ResourceKey<LootTable> MOSASAURUS_EGG = FALootTables.create("entities/egg/mosasaurus");
    public static final ResourceKey<LootTable> FUTABASAURUS_EGG = FALootTables.create("entities/egg/futabasaurus");
    public static final ResourceKey<LootTable> GALLIMIMUS_EGG = FALootTables.create("entities/egg/gallimimus");
    public static final ResourceKey<LootTable> PTERANODON_EGG = FALootTables.create("entities/egg/pteranodon");
    public static final ResourceKey<LootTable> STEGOSAURUS_EGG = FALootTables.create("entities/egg/stegosaurus");
    public static final ResourceKey<LootTable> SPINOSAURUS_EGG = FALootTables.create("entities/egg/spinosaurus");
    public static final ResourceKey<LootTable> TRICERATOPS_EGG = FALootTables.create("entities/egg/triceratops");
    public static final ResourceKey<LootTable> TYRANNOSAURUS_EGG = FALootTables.create("entities/egg/tyrannosaurus");
    public static final ResourceKey<LootTable> VELOCIRAPTOR_EGG = FALootTables.create("entities/egg/velociraptor");
    public static final ResourceKey<LootTable> CARNOTAURUS_EGG = FALootTables.create("entities/egg/carnotaurus");
    public static final ResourceKey<LootTable> CRYOLOPHOSAURUS_EGG = FALootTables.create("entities/egg/cryolophosaurus");
    public static final ResourceKey<LootTable> THERIZINOSAURUS_EGG = FALootTables.create("entities/egg/therizinosaurus");
    public static final ResourceKey<LootTable> PACHYCEPHALOSAURUS_EGG = FALootTables.create("entities/egg/pachycephalosaurus");
    public static final ResourceKey<LootTable> COMPSOGNATHUS_EGG = FALootTables.create("entities/egg/compsognathus");

    public static final ResourceKey<LootTable> PREGNANT_SHEEP_WHITE = FALootTables.create("entities/pregnant_sheep/white");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_ORANGE = FALootTables.create("entities/pregnant_sheep/orange");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_MAGENTA = FALootTables.create("entities/pregnant_sheep/magenta");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_LIGHT_BLUE = FALootTables.create("entities/pregnant_sheep/light_blue");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_YELLOW = FALootTables.create("entities/pregnant_sheep/yellow");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_LIME = FALootTables.create("entities/pregnant_sheep/lime");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_PINK = FALootTables.create("entities/pregnant_sheep/pink");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_GRAY = FALootTables.create("entities/pregnant_sheep/gray");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_LIGHT_GRAY = FALootTables.create("entities/pregnant_sheep/light_gray");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_CYAN = FALootTables.create("entities/pregnant_sheep/cyan");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_PURPLE = FALootTables.create("entities/pregnant_sheep/purple");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_BLUE = FALootTables.create("entities/pregnant_sheep/blue");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_BROWN = FALootTables.create("entities/pregnant_sheep/brown");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_GREEN = FALootTables.create("entities/pregnant_sheep/green");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_RED = FALootTables.create("entities/pregnant_sheep/red");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_BLACK = FALootTables.create("entities/pregnant_sheep/black");

    public static final ResourceKey<LootTable> ARCHAEOLOGIST_GIFT = FALootTables.create("gameplay/hero_of_the_village/archaeologist_gift");
    public static final ResourceKey<LootTable> PALAEONTOLOGIST_GIFT = FALootTables.create("gameplay/hero_of_the_village/palaeontologist_gift");

    public static ResourceKey<LootTable> create(String name) {
        return ResourceKey.create(Registries.LOOT_TABLE, FossilsLegacyUtils.resource(name));
    }
}
