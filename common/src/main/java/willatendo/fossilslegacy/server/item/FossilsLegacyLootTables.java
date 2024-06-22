package willatendo.fossilslegacy.server.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyLootTables {
    public static final ResourceKey<LootTable> ACADEMY_LOOT = create("chests/academy_loot");
    public static final ResourceKey<LootTable> ACADEMY_DISC = create("chests/academy_disc");
    public static final ResourceKey<LootTable> WEAPON_SHOP_DECOY = create("chests/weapon_shop_decoy");
    public static final ResourceKey<LootTable> WEAPON_SHOP_LOOT = create("chests/weapon_shop_loot");

    public static final ResourceKey<LootTable> BRACHIOSAURUS_EGG = create("entities/egg/brachiosaurus");
    public static final ResourceKey<LootTable> DILOPHOSAURUS_EGG = create("entities/egg/dilophosaurus");
    public static final ResourceKey<LootTable> MOSASAURUS_EGG = create("entities/egg/mosasaurus");
    public static final ResourceKey<LootTable> FUTABASAURUS_EGG = create("entities/egg/futabasaurus");
    public static final ResourceKey<LootTable> PTERANODON_EGG = create("entities/egg/pteranodon");
    public static final ResourceKey<LootTable> STEGOSAURUS_EGG = create("entities/egg/stegosaurus");
    public static final ResourceKey<LootTable> TRICERATOPS_EGG = create("entities/egg/triceratops");
    public static final ResourceKey<LootTable> TYRANNOSAURUS_EGG = create("entities/egg/tyrannosaurus");
    public static final ResourceKey<LootTable> VELOCIRAPTOR_EGG = create("entities/egg/velociraptor");
    public static final ResourceKey<LootTable> CARNOTAURUS_EGG = create("entities/egg/carnotaurus");
    public static final ResourceKey<LootTable> CRYOLOPHOSAURUS_EGG = create("entities/egg/cryolophosaurus");
    public static final ResourceKey<LootTable> THERIZINOSAURUS_EGG = create("entities/egg/therizinosaurus");
    public static final ResourceKey<LootTable> PACHYCEPHALOSAURUS_EGG = create("entities/egg/pachycephalosaurus");
    public static final ResourceKey<LootTable> COMPSOGNATHUS_EGG = create("entities/egg/compsognathus");

    public static final ResourceKey<LootTable> PREGNANT_SHEEP_WHITE = create("entities/pregnant_sheep/white");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_ORANGE = create("entities/pregnant_sheep/orange");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_MAGENTA = create("entities/pregnant_sheep/magenta");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_LIGHT_BLUE = create("entities/pregnant_sheep/light_blue");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_YELLOW = create("entities/pregnant_sheep/yellow");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_LIME = create("entities/pregnant_sheep/lime");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_PINK = create("entities/pregnant_sheep/pink");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_GRAY = create("entities/pregnant_sheep/gray");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_LIGHT_GRAY = create("entities/pregnant_sheep/light_gray");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_CYAN = create("entities/pregnant_sheep/cyan");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_PURPLE = create("entities/pregnant_sheep/purple");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_BLUE = create("entities/pregnant_sheep/blue");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_BROWN = create("entities/pregnant_sheep/brown");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_GREEN = create("entities/pregnant_sheep/green");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_RED = create("entities/pregnant_sheep/red");
    public static final ResourceKey<LootTable> PREGNANT_SHEEP_BLACK = create("entities/pregnant_sheep/black");

    public static ResourceKey<LootTable> create(String name) {
        return ResourceKey.create(Registries.LOOT_TABLE, FossilsLegacyUtils.resource(name));
    }
}
