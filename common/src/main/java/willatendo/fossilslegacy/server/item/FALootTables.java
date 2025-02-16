package willatendo.fossilslegacy.server.item;

import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.storage.loot.LootTable;
import willatendo.fossilslegacy.server.egg_variant.EggVariant;
import willatendo.fossilslegacy.server.egg_variant.FAEggVariants;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

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
    public static final ResourceKey<LootTable> CARNOTAURUS_EGG = FALootTables.create("entities/egg/carnotaurus");
    public static final ResourceKey<LootTable> COMPSOGNATHUS_EGG = FALootTables.create("entities/egg/compsognathus");
    public static final ResourceKey<LootTable> CRYOLOPHOSAURUS_EGG = FALootTables.create("entities/egg/cryolophosaurus");
    public static final ResourceKey<LootTable> DILOPHOSAURUS_EGG = FALootTables.create("entities/egg/dilophosaurus");
    public static final ResourceKey<LootTable> DIMETRODON_EGG = FALootTables.create("entities/egg/dimetrodon");
    public static final ResourceKey<LootTable> FUTABASAURUS_EGG = FALootTables.create("entities/egg/futabasaurus");
    public static final ResourceKey<LootTable> GALLIMIMUS_EGG = FALootTables.create("entities/egg/gallimimus");
    public static final ResourceKey<LootTable> MOSASAURUS_EGG = FALootTables.create("entities/egg/mosasaurus");
    public static final ResourceKey<LootTable> PACHYCEPHALOSAURUS_EGG = FALootTables.create("entities/egg/pachycephalosaurus");
    public static final ResourceKey<LootTable> PTERANODON_EGG = FALootTables.create("entities/egg/pteranodon");
    public static final ResourceKey<LootTable> SPINOSAURUS_EGG = FALootTables.create("entities/egg/spinosaurus");
    public static final ResourceKey<LootTable> STEGOSAURUS_EGG = FALootTables.create("entities/egg/stegosaurus");
    public static final ResourceKey<LootTable> THERIZINOSAURUS_EGG = FALootTables.create("entities/egg/therizinosaurus");
    public static final ResourceKey<LootTable> TRICERATOPS_EGG = FALootTables.create("entities/egg/triceratops");
    public static final ResourceKey<LootTable> TYRANNOSAURUS_EGG = FALootTables.create("entities/egg/tyrannosaurus");
    public static final ResourceKey<LootTable> VELOCIRAPTOR_EGG = FALootTables.create("entities/egg/velociraptor");
    public static final Map<ResourceKey<EggVariant>, ResourceKey<LootTable>> LOOT_BY_EGG = new HashMap<>();

    public static final ResourceKey<LootTable> SHEAR_MAMMOTH = FALootTables.create("shearing/mammoth");
    public static final ResourceKey<LootTable> SHEAR_PREGNANT_SHEEP = FALootTables.create("shearing/pregnant_sheep");
    public static final Map<DyeColor, ResourceKey<LootTable>> SHEAR_MAMMOTH_BY_DYE = Util.make(new EnumMap<>(DyeColor.class), enumMap -> FALootTables.makeDyeKeyMap(enumMap, "shearing/mammoth"));
    public static final Map<DyeColor, ResourceKey<LootTable>> SHEAR_PREGNANT_SHEEP_BY_DYE = Util.make(new EnumMap<>(DyeColor.class), enumMap -> FALootTables.makeDyeKeyMap(enumMap, "shearing/sheep"));

    public static final ResourceKey<LootTable> ARCHAEOLOGIST_GIFT = FALootTables.create("gameplay/hero_of_the_village/archaeologist_gift");
    public static final ResourceKey<LootTable> PALAEONTOLOGIST_GIFT = FALootTables.create("gameplay/hero_of_the_village/palaeontologist_gift");

    static {
        LOOT_BY_EGG.put(FAEggVariants.ANKYLOSAURUS.getKey(), FALootTables.ANKYLOSAURUS_EGG);
        LOOT_BY_EGG.put(FAEggVariants.BRACHIOSAURUS.getKey(), FALootTables.BRACHIOSAURUS_EGG);
        LOOT_BY_EGG.put(FAEggVariants.CARNOTAURUS.getKey(), FALootTables.CARNOTAURUS_EGG);
        LOOT_BY_EGG.put(FAEggVariants.COMPSOGNATHUS.getKey(), FALootTables.COMPSOGNATHUS_EGG);
        LOOT_BY_EGG.put(FAEggVariants.CRYOLOPHOSAURUS.getKey(), FALootTables.CRYOLOPHOSAURUS_EGG);
        LOOT_BY_EGG.put(FAEggVariants.DILOPHOSAURUS.getKey(), FALootTables.DILOPHOSAURUS_EGG);
        LOOT_BY_EGG.put(FAEggVariants.DIMETRODON.getKey(), FALootTables.DIMETRODON_EGG);
        LOOT_BY_EGG.put(FAEggVariants.MOSASAURUS.getKey(), FALootTables.MOSASAURUS_EGG);
        LOOT_BY_EGG.put(FAEggVariants.FUTABASAURUS.getKey(), FALootTables.FUTABASAURUS_EGG);
        LOOT_BY_EGG.put(FAEggVariants.GALLIMIMUS.getKey(), FALootTables.GALLIMIMUS_EGG);
        LOOT_BY_EGG.put(FAEggVariants.PACHYCEPHALOSAURUS.getKey(), FALootTables.PACHYCEPHALOSAURUS_EGG);
        LOOT_BY_EGG.put(FAEggVariants.PTERANODON.getKey(), FALootTables.PTERANODON_EGG);
        LOOT_BY_EGG.put(FAEggVariants.SPINOSAURUS.getKey(), FALootTables.SPINOSAURUS_EGG);
        LOOT_BY_EGG.put(FAEggVariants.STEGOSAURUS.getKey(), FALootTables.STEGOSAURUS_EGG);
        LOOT_BY_EGG.put(FAEggVariants.THERIZINOSAURUS.getKey(), FALootTables.THERIZINOSAURUS_EGG);
        LOOT_BY_EGG.put(FAEggVariants.TRICERATOPS.getKey(), FALootTables.TRICERATOPS_EGG);
        LOOT_BY_EGG.put(FAEggVariants.TYRANNOSAURUS.getKey(), FALootTables.TYRANNOSAURUS_EGG);
        LOOT_BY_EGG.put(FAEggVariants.VELOCIRAPTOR.getKey(), FALootTables.VELOCIRAPTOR_EGG);
    }

    public static ResourceKey<LootTable> create(String name) {
        return ResourceKey.create(Registries.LOOT_TABLE, FAUtils.resource(name));
    }

    private static void makeDyeKeyMap(EnumMap<DyeColor, ResourceKey<LootTable>> output, String name) {
        for (DyeColor dyeColor : DyeColor.values()) {
            output.put(dyeColor, FALootTables.create(name + "/" + dyeColor.getName()));
        }
    }
}
