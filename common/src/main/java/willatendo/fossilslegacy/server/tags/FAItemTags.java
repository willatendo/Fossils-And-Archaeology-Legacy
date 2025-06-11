package willatendo.fossilslegacy.server.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FAItemTags {
    private static final TagRegister<Item> ITEM_TAGS = TagRegister.create(Registries.ITEM, FAUtils.ID);

    public static final TagKey<Item> ANCIENT_TOOL_MATERIALS = ITEM_TAGS.register("ancient_tool_materials");
    public static final TagKey<Item> ANKYLOSAURUS_COMMANDABLES = ITEM_TAGS.register("commandable/ankylosaurus");
    public static final TagKey<Item> ARCHAEOPTERIS_LOGS = ITEM_TAGS.register("archaeopteris_logs");
    public static final TagKey<Item> BARYONYX_COMMANDABLES = ITEM_TAGS.register("commandable/baryonyx");
    public static final TagKey<Item> BRACHIOSAURUS_COMMANDABLES = ITEM_TAGS.register("commandable/brachiosaurus");
    public static final TagKey<Item> CAKE_EGGS = ITEM_TAGS.register("cake_eggs");
    public static final TagKey<Item> CALAMITES_LOGS = ITEM_TAGS.register("calamites_logs");
    public static final TagKey<Item> CARNIVORE_FOODS = ITEM_TAGS.register("carnivore_foods");
    public static final TagKey<Item> CARNOTAURUS_COMMANDABLES = ITEM_TAGS.register("commandable/carnotaurus");
    public static final TagKey<Item> COMPSOGNATHUS_COMMANDABLES = ITEM_TAGS.register("commandable/compsognathus");
    public static final TagKey<Item> CRYOLOPHOSAURUS_COMMANDABLES = ITEM_TAGS.register("commandable/cryolophosaurus");
    public static final TagKey<Item> DAGGER_TOOL_MATERIALS = ITEM_TAGS.register("dagger_tool_materials");
    public static final TagKey<Item> DARTS = ITEM_TAGS.register("darts");
    public static final TagKey<Item> DILOPHOSAURUS_COMMANDABLES = ITEM_TAGS.register("commandable/dilophosaurus");
    public static final TagKey<Item> DIMETRODON_COMMANDABLES = ITEM_TAGS.register("commandable/dimetrodon");
    public static final TagKey<Item> DNA = ITEM_TAGS.register("dna");
    public static final TagKey<Item> DRUM_INSTRUMENT = ITEM_TAGS.register("drum_instrument");
    public static final TagKey<Item> FROGLIGHTS = ITEM_TAGS.register("froglights");
    public static final TagKey<Item> GALLIMIMUS_COMMANDABLES = ITEM_TAGS.register("commandable/gallimimus");
    public static final TagKey<Item> DRYOSAURUS_COMMANDABLES = ITEM_TAGS.register("commandable/dryosaurus");
    public static final TagKey<Item> HERBIVORE_FOODS = ITEM_TAGS.register("herbivore_foods");
    public static final TagKey<Item> ICED_MEAT_TOOL_MATERIALS = ITEM_TAGS.register("iced_meat_tool_materials");
    public static final TagKey<Item> LEPIDODENDRON_LOGS = ITEM_TAGS.register("lepidodendron_logs");
    public static final TagKey<Item> MAMMOTH_COMMANDABLES = ITEM_TAGS.register("commandable/mammoth");
    public static final TagKey<Item> MESOZOIC_FOSSIL = ITEM_TAGS.register("mesozoic_fossil");
    public static final TagKey<Item> OMNIVORE_FOODS = ITEM_TAGS.register("omnivore_foods");
    public static final TagKey<Item> PACHYCEPHALOSAURUS_COMMANDABLES = ITEM_TAGS.register("commandable/pachycephalosaurus");
    public static final TagKey<Item> PIGLIN_TAMING_ARMOR = ITEM_TAGS.register("piglin_taming_armor");
    public static final TagKey<Item> PISCIVORE_FOODS = ITEM_TAGS.register("piscivore_foods");
    public static final TagKey<Item> PTERANODON_COMMANDABLES = ITEM_TAGS.register("commandable/pteranodon");
    public static final TagKey<Item> REPAIR_WHEN_BROKEN_IN_ARCHAEOLOGY_TABLE = ITEM_TAGS.register("repair_when_broken_in_archaeology_table");
    public static final TagKey<Item> SCARAB_GEM_TOOL_MATERIALS = ITEM_TAGS.register("scarab_gem_tool_materials");
    public static final TagKey<Item> SIGILLARIA_LOGS = ITEM_TAGS.register("sigillaria_logs");
    public static final TagKey<Item> SPINOSAURUS_COMMANDABLES = ITEM_TAGS.register("commandable/spinosaurus");
    public static final TagKey<Item> STEGOSAURUS_COMMANDABLES = ITEM_TAGS.register("commandable/stegosaurus");
    public static final TagKey<Item> TRICERATOPS_COMMANDABLES = ITEM_TAGS.register("commandable/triceratops");
    public static final TagKey<Item> THERIZINOSAURUS_COMMANDABLES = ITEM_TAGS.register("commandable/therizinosaurus");
    public static final TagKey<Item> TYRANNOSAURUS_COMMANDABLES = ITEM_TAGS.register("commandable/tyrannosaurus");
}
