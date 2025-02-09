package willatendo.fossilslegacy.server.item;

import net.minecraft.Util;
import net.minecraft.core.Holder;
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
    public static final Map<Holder<EggVariant>, ResourceKey<LootTable>> EGG_BY_DYE = new HashMap<>();

    public static final ResourceKey<LootTable> SHEAR_MAMMOTH = FALootTables.create("shearing/mammoth");
    public static final Map<DyeColor, ResourceKey<LootTable>> SHEAR_MAMMOTH_BY_DYE = Util.make(new EnumMap<>(DyeColor.class), enumMap -> makeDyeKeyMap(enumMap, "shearing/mammoth"));

    public static final ResourceKey<LootTable> ARCHAEOLOGIST_GIFT = FALootTables.create("gameplay/hero_of_the_village/archaeologist_gift");
    public static final ResourceKey<LootTable> PALAEONTOLOGIST_GIFT = FALootTables.create("gameplay/hero_of_the_village/palaeontologist_gift");

    static {
        EGG_BY_DYE.put(FAEggVariants.ANKYLOSAURUS, FALootTables.ANKYLOSAURUS_EGG);
        EGG_BY_DYE.put(FAEggVariants.BRACHIOSAURUS, FALootTables.BRACHIOSAURUS_EGG);
        EGG_BY_DYE.put(FAEggVariants.CARNOTAURUS, FALootTables.CARNOTAURUS_EGG);
        EGG_BY_DYE.put(FAEggVariants.COMPSOGNATHUS, FALootTables.COMPSOGNATHUS_EGG);
        EGG_BY_DYE.put(FAEggVariants.CRYOLOPHOSAURUS, FALootTables.CRYOLOPHOSAURUS_EGG);
        EGG_BY_DYE.put(FAEggVariants.DILOPHOSAURUS, FALootTables.DILOPHOSAURUS_EGG);
        EGG_BY_DYE.put(FAEggVariants.DIMETRODON, FALootTables.DIMETRODON_EGG);
        EGG_BY_DYE.put(FAEggVariants.MOSASAURUS, FALootTables.MOSASAURUS_EGG);
        EGG_BY_DYE.put(FAEggVariants.FUTABASAURUS, FALootTables.FUTABASAURUS_EGG);
        EGG_BY_DYE.put(FAEggVariants.GALLIMIMUS, FALootTables.GALLIMIMUS_EGG);
        EGG_BY_DYE.put(FAEggVariants.PACHYCEPHALOSAURUS, FALootTables.PACHYCEPHALOSAURUS_EGG);
        EGG_BY_DYE.put(FAEggVariants.PTERANODON, FALootTables.PTERANODON_EGG);
        EGG_BY_DYE.put(FAEggVariants.SPINOSAURUS, FALootTables.SPINOSAURUS_EGG);
        EGG_BY_DYE.put(FAEggVariants.STEGOSAURUS, FALootTables.STEGOSAURUS_EGG);
        EGG_BY_DYE.put(FAEggVariants.THERIZINOSAURUS, FALootTables.THERIZINOSAURUS_EGG);
        EGG_BY_DYE.put(FAEggVariants.TRICERATOPS, FALootTables.TRICERATOPS_EGG);
        EGG_BY_DYE.put(FAEggVariants.TYRANNOSAURUS, FALootTables.TYRANNOSAURUS_EGG);
        EGG_BY_DYE.put(FAEggVariants.VELOCIRAPTOR, FALootTables.VELOCIRAPTOR_EGG);
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
