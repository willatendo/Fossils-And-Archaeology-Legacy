package willatendo.fossilslegacy.server.item;

import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.storage.loot.LootTable;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.EnumMap;
import java.util.Map;

public final class FALootTables {
    public static final ResourceKey<LootTable> ACADEMY_LOOT = FALootTables.create("chests/academy_loot");
    public static final ResourceKey<LootTable> ACADEMY_DISC = FALootTables.create("chests/academy_disc");
    public static final ResourceKey<LootTable> LAB_DNA_LOOT = FALootTables.create("chests/lab_loot/dna");
    public static final ResourceKey<LootTable> LAB_FOSSIL_LOOT = FALootTables.create("chests/lab_loot/fossil");
    public static final ResourceKey<LootTable> LAB_FAILED_EXPERIMENT_LOOT = FALootTables.create("chests/lab_loot/failed_experiment");
    public static final ResourceKey<LootTable> MAYAN_LOOT = FALootTables.create("chests/mayan_loot");
    public static final ResourceKey<LootTable> MAYAN_TREASURE = FALootTables.create("chests/mayan_treasure");
    public static final ResourceKey<LootTable> PIRATE_SHIP_CANNON = FALootTables.create("chests/cannon");
    public static final ResourceKey<LootTable> PIRATE_SHIP_LOOT = FALootTables.create("chests/pirate_loot");
    public static final ResourceKey<LootTable> WEAPON_SHOP_DECOY = FALootTables.create("chests/weapon_shop_decoy");
    public static final ResourceKey<LootTable> WEAPON_SHOP_LOOT = FALootTables.create("chests/weapon_shop_loot");

    public static final ResourceKey<LootTable> VILLAGE_ARCHAEOLOGIST_HUT = FALootTables.create("chests/village/village_archaeologist_hut");

    public static final ResourceKey<LootTable> INCA_LOOT = FALootTables.create("archaeology/inca_loot");

    public static final ResourceKey<LootTable> SHEAR_MAMMOTH = FALootTables.create("shearing/mammoth");
    public static final ResourceKey<LootTable> SHEAR_PREGNANT_SHEEP = FALootTables.create("shearing/pregnant_sheep");
    public static final Map<DyeColor, ResourceKey<LootTable>> SHEAR_MAMMOTH_BY_DYE = Util.make(new EnumMap<>(DyeColor.class), enumMap -> FALootTables.makeDyeKeyMap(enumMap, "shearing/mammoth"));
    public static final Map<DyeColor, ResourceKey<LootTable>> SHEAR_PREGNANT_SHEEP_BY_DYE = Util.make(new EnumMap<>(DyeColor.class), enumMap -> FALootTables.makeDyeKeyMap(enumMap, "shearing/sheep"));

    public static final ResourceKey<LootTable> ARCHAEOLOGIST_GIFT = FALootTables.create("gameplay/hero_of_the_village/archaeologist_gift");
    public static final ResourceKey<LootTable> PALAEONTOLOGIST_GIFT = FALootTables.create("gameplay/hero_of_the_village/palaeontologist_gift");

    public static ResourceKey<LootTable> create(String name) {
        return ResourceKey.create(Registries.LOOT_TABLE, FAUtils.resource(name));
    }

    private static void makeDyeKeyMap(EnumMap<DyeColor, ResourceKey<LootTable>> output, String name) {
        for (DyeColor dyeColor : DyeColor.values()) {
            output.put(dyeColor, FALootTables.create(name + "/" + dyeColor.getName()));
        }
    }
}
