package willatendo.fossilslegacy.server.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyLootTables {
    public static final ResourceKey<LootTable> ACADEMY_LOOT = FossilsLegacyLootTables.create("chests/academy_loot");
    public static final ResourceKey<LootTable> ACADEMY_DISC = FossilsLegacyLootTables.create("chests/academy_disc");
    public static final ResourceKey<LootTable> MAYAN_LOOT = FossilsLegacyLootTables.create("chests/mayan_loot");
    public static final ResourceKey<LootTable> MAYAN_TREASURE = FossilsLegacyLootTables.create("chests/mayan_treasure");
    public static final ResourceKey<LootTable> WEAPON_SHOP_DECOY = FossilsLegacyLootTables.create("chests/weapon_shop_decoy");
    public static final ResourceKey<LootTable> WEAPON_SHOP_LOOT = FossilsLegacyLootTables.create("chests/weapon_shop_loot");

    public static final ResourceKey<LootTable> BRACHIOSAURUS_EGG = FossilsLegacyLootTables.create("entities/egg/brachiosaurus");
    public static final ResourceKey<LootTable> DILOPHOSAURUS_EGG = FossilsLegacyLootTables.create("entities/egg/dilophosaurus");
    public static final ResourceKey<LootTable> MOSASAURUS_EGG = FossilsLegacyLootTables.create("entities/egg/mosasaurus");
    public static final ResourceKey<LootTable> FUTABASAURUS_EGG = FossilsLegacyLootTables.create("entities/egg/futabasaurus");
    public static final ResourceKey<LootTable> PTERANODON_EGG = FossilsLegacyLootTables.create("entities/egg/pteranodon");
    public static final ResourceKey<LootTable> STEGOSAURUS_EGG = FossilsLegacyLootTables.create("entities/egg/stegosaurus");
    public static final ResourceKey<LootTable> TRICERATOPS_EGG = FossilsLegacyLootTables.create("entities/egg/triceratops");
    public static final ResourceKey<LootTable> TYRANNOSAURUS_EGG = FossilsLegacyLootTables.create("entities/egg/tyrannosaurus");
    public static final ResourceKey<LootTable> VELOCIRAPTOR_EGG = FossilsLegacyLootTables.create("entities/egg/velociraptor");
    public static final ResourceKey<LootTable> CARNOTAURUS_EGG = FossilsLegacyLootTables.create("entities/egg/carnotaurus");
    public static final ResourceKey<LootTable> CRYOLOPHOSAURUS_EGG = FossilsLegacyLootTables.create("entities/egg/cryolophosaurus");
    public static final ResourceKey<LootTable> THERIZINOSAURUS_EGG = FossilsLegacyLootTables.create("entities/egg/therizinosaurus");
    public static final ResourceKey<LootTable> PACHYCEPHALOSAURUS_EGG = FossilsLegacyLootTables.create("entities/egg/pachycephalosaurus");
    public static final ResourceKey<LootTable> COMPSOGNATHUS_EGG = FossilsLegacyLootTables.create("entities/egg/compsognathus");

    public static final ResourceKey<LootTable> PREGNANT_SHEEP_WHITE = FossilsLegacyLootTables.create("entities/pregnant_sheep/white");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_ORANGE = FossilsLegacyLootTables.create("entities/pregnant_sheep/orange");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_MAGENTA = FossilsLegacyLootTables.create("entities/pregnant_sheep/magenta");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_LIGHT_BLUE = FossilsLegacyLootTables.create("entities/pregnant_sheep/light_blue");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_YELLOW = FossilsLegacyLootTables.create("entities/pregnant_sheep/yellow");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_LIME = FossilsLegacyLootTables.create("entities/pregnant_sheep/lime");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_PINK = FossilsLegacyLootTables.create("entities/pregnant_sheep/pink");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_GRAY = FossilsLegacyLootTables.create("entities/pregnant_sheep/gray");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_LIGHT_GRAY = FossilsLegacyLootTables.create("entities/pregnant_sheep/light_gray");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_CYAN = FossilsLegacyLootTables.create("entities/pregnant_sheep/cyan");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_PURPLE = FossilsLegacyLootTables.create("entities/pregnant_sheep/purple");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_BLUE = FossilsLegacyLootTables.create("entities/pregnant_sheep/blue");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_BROWN = FossilsLegacyLootTables.create("entities/pregnant_sheep/brown");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_GREEN = FossilsLegacyLootTables.create("entities/pregnant_sheep/green");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_RED = FossilsLegacyLootTables.create("entities/pregnant_sheep/red");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_BLACK = FossilsLegacyLootTables.create("entities/pregnant_sheep/black");

    public static ResourceKey<LootTable> create(String name) {
        return ResourceKey.create(Registries.LOOT_TABLE, FossilsLegacyUtils.resource(name));
    }
}
