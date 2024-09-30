package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlockTags;
import willatendo.fossilslegacy.server.item.FossilsLegacyItemTags;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.simplelibrary.server.util.TagRegister;

import java.util.concurrent.CompletableFuture;

public class FossilsLegacyItemTagProvider extends ItemTagsProvider {
    private static final TagRegister<Item> COMMON_TAGS = TagRegister.create(Registries.ITEM, "c");
    private static final TagKey<Item> ENCHANTABLES = COMMON_TAGS.register("enchantables");
    private static final TagKey<Item> FOODS = COMMON_TAGS.register("foods");
    private static final TagKey<Item> RANGED_WEAPONS = COMMON_TAGS.register("tools/ranged_weapon");
    private static final TagKey<Item> RAW_MEAT = COMMON_TAGS.register("foods/raw_meat");
    private static final TagKey<Item> FOOD_POISONING_FOODS = COMMON_TAGS.register("foods/food_poisoning");
    private static final TagKey<Item> MINING_TOOLS = COMMON_TAGS.register("tools/mining_tool");
    private static final TagKey<Item> MELEE_WEAPONS = COMMON_TAGS.register("tools/melee_weapon");
    private static final TagKey<Item> EGGS = COMMON_TAGS.register("eggs");
    private static final TagKey<Item> BUCKETS = COMMON_TAGS.register("buckets");
    private static final TagKey<Item> GEMS = COMMON_TAGS.register("gems");
    private static final TagKey<Item> TOOLS = COMMON_TAGS.register("tools");
    private static final TagKey<Item> BONES = COMMON_TAGS.register("bones");
    private static final TagKey<Item> SEEDS = COMMON_TAGS.register("seeds");
    private static final TagKey<Item> SHEARS = COMMON_TAGS.register("shears");
    private static final TagKey<Item> FENCE_GATES_WOODEN = COMMON_TAGS.register("fence_gates/wooden");

    public FossilsLegacyItemTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, CompletableFuture<TagLookup<Block>> blockTags, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, provider, blockTags, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(ItemTags.PLANKS).add(FossilsLegacyItems.LEPIDODENDRON_PLANKS, FossilsLegacyItems.SIGILLARIA_PLANKS, FossilsLegacyItems.CALAMITES_PLANKS);
        this.tag(ItemTags.WOODEN_BUTTONS).add(FossilsLegacyItems.LEPIDODENDRON_BUTTON, FossilsLegacyItems.SIGILLARIA_BUTTON, FossilsLegacyItems.CALAMITES_BUTTON);
        this.tag(ItemTags.WOODEN_DOORS).add(FossilsLegacyItems.LEPIDODENDRON_DOOR.get(), FossilsLegacyItems.SIGILLARIA_DOOR.get(), FossilsLegacyItems.CALAMITES_DOOR.get());
        this.tag(ItemTags.WOODEN_STAIRS).add(FossilsLegacyItems.LEPIDODENDRON_STAIRS, FossilsLegacyItems.SIGILLARIA_STAIRS, FossilsLegacyItems.CALAMITES_STAIRS);
        this.tag(ItemTags.WOODEN_SLABS).add(FossilsLegacyItems.LEPIDODENDRON_SLAB, FossilsLegacyItems.SIGILLARIA_SLAB, FossilsLegacyItems.CALAMITES_SLAB);
        this.tag(ItemTags.WOODEN_FENCES).add(FossilsLegacyItems.LEPIDODENDRON_FENCE, FossilsLegacyItems.SIGILLARIA_FENCE, FossilsLegacyItems.CALAMITES_FENCE);
        this.tag(FossilsLegacyItemTagProvider.FENCE_GATES_WOODEN).add(FossilsLegacyItems.LEPIDODENDRON_FENCE_GATE, FossilsLegacyItems.SIGILLARIA_FENCE_GATE, FossilsLegacyItems.CALAMITES_FENCE_GATE);
        this.tag(ItemTags.SAPLINGS).add(FossilsLegacyItems.LEPIDODENDRON_SAPLING, FossilsLegacyItems.SIGILLARIA_SAPLING, FossilsLegacyItems.CALAMITES_SAPLING);
        this.tag(ItemTags.LOGS_THAT_BURN).addTags(FossilsLegacyItemTags.LEPIDODENDRON_LOGS, FossilsLegacyItemTags.SIGILLARIA_LOGS, FossilsLegacyItemTags.CALAMITES_LOGS);
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(FossilsLegacyItems.LEPIDODENDRON_PRESSURE_PLATE, FossilsLegacyItems.SIGILLARIA_PRESSURE_PLATE, FossilsLegacyItems.CALAMITES_PRESSURE_PLATE);
        this.tag(ItemTags.LEAVES).add(FossilsLegacyItems.LEPIDODENDRON_LEAVES, FossilsLegacyItems.SIGILLARIA_LEAVES, FossilsLegacyItems.CALAMITES_LEAVES);
        this.tag(ItemTags.WOODEN_TRAPDOORS).add(FossilsLegacyItems.LEPIDODENDRON_TRAPDOOR, FossilsLegacyItems.SIGILLARIA_TRAPDOOR, FossilsLegacyItems.CALAMITES_TRAPDOOR);
        this.tag(ItemTags.SIGNS).add(FossilsLegacyItems.LEPIDODENDRON_SIGN.get(), FossilsLegacyItems.SIGILLARIA_SIGN.get(), FossilsLegacyItems.CALAMITES_SIGN.get());
        this.tag(ItemTags.HANGING_SIGNS).add(FossilsLegacyItems.LEPIDODENDRON_HANGING_SIGN.get(), FossilsLegacyItems.SIGILLARIA_HANGING_SIGN.get(), FossilsLegacyItems.CALAMITES_HANGING_SIGN.get());
        this.tag(ItemTags.FENCE_GATES).add(FossilsLegacyItems.LEPIDODENDRON_FENCE_GATE, FossilsLegacyItems.SIGILLARIA_FENCE_GATE, FossilsLegacyItems.CALAMITES_FENCE_GATE);
        this.tag(ItemTags.BOATS).add(FossilsLegacyItems.LEPIDODENDRON_BOAT.get(), FossilsLegacyItems.LEPIDODENDRON_CHEST_BOAT.get(), FossilsLegacyItems.SIGILLARIA_BOAT.get(), FossilsLegacyItems.SIGILLARIA_CHEST_BOAT.get(), FossilsLegacyItems.CALAMITES_BOAT.get(), FossilsLegacyItems.CALAMITES_CHEST_BOAT.get());

        this.tagEquipment(FossilsLegacyItems.SCARAB_GEM_SWORD.get(), FossilsLegacyItems.SCARAB_GEM_PICKAXE.get(), FossilsLegacyItems.SCARAB_GEM_AXE.get(), FossilsLegacyItems.SCARAB_GEM_SHOVEL.get(), FossilsLegacyItems.SCARAB_GEM_HOE.get(), FossilsLegacyItems.SCARAB_GEM_HELMET.get(), FossilsLegacyItems.SCARAB_GEM_CHESTPLATE.get(), FossilsLegacyItems.SCARAB_GEM_LEGGINGS.get(), FossilsLegacyItems.SCARAB_GEM_BOOTS.get());
        this.tagEquipment(FossilsLegacyItems.ANCIENT_SWORD.get(), FossilsLegacyItems.ANCIENT_PICKAXE.get(), FossilsLegacyItems.ANCIENT_AXE.get(), FossilsLegacyItems.ANCIENT_SHOVEL.get(), FossilsLegacyItems.ANCIENT_HOE.get(), FossilsLegacyItems.ANCIENT_HELMET.get(), FossilsLegacyItems.ANCIENT_CHESTPLATE.get(), FossilsLegacyItems.ANCIENT_LEGGINGS.get(), FossilsLegacyItems.ANCIENT_BOOTS.get());
        this.tag(FossilsLegacyItemTagProvider.BUCKETS).add(FossilsLegacyItems.RAW_BERRY_MEDLEY_BUCKET.get(), FossilsLegacyItems.COOKED_BERRY_MEDLEY_BUCKET.get(), FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get(), FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get());
        this.tag(FossilsLegacyItemTagProvider.SEEDS).add(FossilsLegacyItems.JURASSIC_FERN_SPORES.get());
        this.tag(FossilsLegacyItemTagProvider.SHEARS).add(FossilsLegacyItems.THERIZINOSAURUS_CLAWS.get());
        this.tag(FossilsLegacyItemTagProvider.EGGS).addTags(FossilsLegacyItemTags.CAKE_EGGS);
        this.tag(FossilsLegacyItemTagProvider.GEMS).add(FossilsLegacyItems.SCARAB_GEM.get());
        this.tag(FossilsLegacyItemTagProvider.BONES).add(FossilsLegacyItems.FOSSIL.get());
        this.tag(FossilsLegacyItemTagProvider.RANGED_WEAPONS).add(FossilsLegacyItems.WOODEN_JAVELIN.get(), FossilsLegacyItems.BROKEN_WOODEN_JAVELIN.get(), FossilsLegacyItems.STONE_JAVELIN.get(), FossilsLegacyItems.BROKEN_STONE_JAVELIN.get(), FossilsLegacyItems.GOLDEN_JAVELIN.get(), FossilsLegacyItems.BROKEN_GOLDEN_JAVELIN.get(), FossilsLegacyItems.IRON_JAVELIN.get(), FossilsLegacyItems.BROKEN_IRON_JAVELIN.get(), FossilsLegacyItems.DIAMOND_JAVELIN.get(), FossilsLegacyItems.BROKEN_DIAMOND_JAVELIN.get(), FossilsLegacyItems.NETHERITE_JAVELIN.get(), FossilsLegacyItems.BROKEN_NETHERITE_JAVELIN.get(), FossilsLegacyItems.SCARAB_GEM_JAVELIN.get(), FossilsLegacyItems.BROKEN_SCARAB_GEM_JAVELIN.get());
        this.tag(ItemTags.DURABILITY_ENCHANTABLE).add(FossilsLegacyItems.WOODEN_JAVELIN.get(), FossilsLegacyItems.BROKEN_WOODEN_JAVELIN.get(), FossilsLegacyItems.STONE_JAVELIN.get(), FossilsLegacyItems.BROKEN_STONE_JAVELIN.get(), FossilsLegacyItems.GOLDEN_JAVELIN.get(), FossilsLegacyItems.BROKEN_GOLDEN_JAVELIN.get(), FossilsLegacyItems.IRON_JAVELIN.get(), FossilsLegacyItems.BROKEN_IRON_JAVELIN.get(), FossilsLegacyItems.DIAMOND_JAVELIN.get(), FossilsLegacyItems.BROKEN_DIAMOND_JAVELIN.get(), FossilsLegacyItems.NETHERITE_JAVELIN.get(), FossilsLegacyItems.BROKEN_NETHERITE_JAVELIN.get(), FossilsLegacyItems.SCARAB_GEM_JAVELIN.get(), FossilsLegacyItems.BROKEN_SCARAB_GEM_JAVELIN.get());
        this.tag(ItemTags.VANISHING_ENCHANTABLE).add(FossilsLegacyItems.WOODEN_JAVELIN.get(), FossilsLegacyItems.BROKEN_WOODEN_JAVELIN.get(), FossilsLegacyItems.STONE_JAVELIN.get(), FossilsLegacyItems.BROKEN_STONE_JAVELIN.get(), FossilsLegacyItems.GOLDEN_JAVELIN.get(), FossilsLegacyItems.BROKEN_GOLDEN_JAVELIN.get(), FossilsLegacyItems.IRON_JAVELIN.get(), FossilsLegacyItems.BROKEN_IRON_JAVELIN.get(), FossilsLegacyItems.DIAMOND_JAVELIN.get(), FossilsLegacyItems.BROKEN_DIAMOND_JAVELIN.get(), FossilsLegacyItems.NETHERITE_JAVELIN.get(), FossilsLegacyItems.BROKEN_NETHERITE_JAVELIN.get(), FossilsLegacyItems.SCARAB_GEM_JAVELIN.get(), FossilsLegacyItems.BROKEN_SCARAB_GEM_JAVELIN.get());
        this.tag(FossilsLegacyItemTagProvider.FOODS).add(FossilsLegacyItems.RAW_TRICERATOPS.get(), FossilsLegacyItems.RAW_VELOCIRAPTOR.get(), FossilsLegacyItems.RAW_TYRANNOSAURUS.get(), FossilsLegacyItems.RAW_PTERANODON.get(), FossilsLegacyItems.NAUTILUS.get(), FossilsLegacyItems.RAW_FUTABASAURUS.get(), FossilsLegacyItems.RAW_MOSASAURUS.get(), FossilsLegacyItems.RAW_STEGOSAURUS.get(), FossilsLegacyItems.RAW_DILOPHOSAURUS.get(), FossilsLegacyItems.RAW_BRACHIOSAURUS.get(), FossilsLegacyItems.RAW_SMILODON.get(), FossilsLegacyItems.RAW_MAMMOTH.get(), FossilsLegacyItems.RAW_CARNOTAURUS.get(), FossilsLegacyItems.RAW_CRYOLOPHOSAURUS.get(), FossilsLegacyItems.RAW_THERIZINOSAURUS.get(), FossilsLegacyItems.COOKED_TRICERATOPS.get(), FossilsLegacyItems.COOKED_VELOCIRAPTOR.get(), FossilsLegacyItems.COOKED_TYRANNOSAURUS.get(), FossilsLegacyItems.COOKED_PTERANODON.get(), FossilsLegacyItems.SIO_CHIU_LE.get(), FossilsLegacyItems.COOKED_FUTABASAURUS.get(), FossilsLegacyItems.COOKED_MOSASAURUS.get(), FossilsLegacyItems.COOKED_STEGOSAURUS.get(), FossilsLegacyItems.COOKED_DILOPHOSAURUS.get(), FossilsLegacyItems.COOKED_BRACHIOSAURUS.get(), FossilsLegacyItems.COOKED_SMILODON.get(), FossilsLegacyItems.COOKED_MAMMOTH.get(), FossilsLegacyItems.COOKED_CARNOTAURUS.get(), FossilsLegacyItems.COOKED_CRYOLOPHOSAURUS.get(), FossilsLegacyItems.COOKED_THERIZINOSAURUS.get(), FossilsLegacyItems.CHICKEN_ESSENCE_BOTTLE.get(), FossilsLegacyItems.ROMANTIC_CONCOCTION_BOTTLE.get(), FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get(), FossilsLegacyItems.RAW_BERRY_MEDLEY_BUCKET.get(), FossilsLegacyItems.SIO_CHIU_LE.get());
        this.tag(ItemTags.WOLF_FOOD).add(FossilsLegacyItems.RAW_TRICERATOPS.get(), FossilsLegacyItems.RAW_VELOCIRAPTOR.get(), FossilsLegacyItems.RAW_TYRANNOSAURUS.get(), FossilsLegacyItems.RAW_PTERANODON.get(), FossilsLegacyItems.NAUTILUS.get(), FossilsLegacyItems.RAW_FUTABASAURUS.get(), FossilsLegacyItems.RAW_MOSASAURUS.get(), FossilsLegacyItems.RAW_STEGOSAURUS.get(), FossilsLegacyItems.RAW_DILOPHOSAURUS.get(), FossilsLegacyItems.RAW_BRACHIOSAURUS.get(), FossilsLegacyItems.RAW_SMILODON.get(), FossilsLegacyItems.RAW_MAMMOTH.get(), FossilsLegacyItems.RAW_CARNOTAURUS.get(), FossilsLegacyItems.RAW_CRYOLOPHOSAURUS.get(), FossilsLegacyItems.RAW_THERIZINOSAURUS.get(), FossilsLegacyItems.COOKED_TRICERATOPS.get(), FossilsLegacyItems.COOKED_VELOCIRAPTOR.get(), FossilsLegacyItems.COOKED_TYRANNOSAURUS.get(), FossilsLegacyItems.COOKED_PTERANODON.get(), FossilsLegacyItems.SIO_CHIU_LE.get(), FossilsLegacyItems.COOKED_FUTABASAURUS.get(), FossilsLegacyItems.COOKED_MOSASAURUS.get(), FossilsLegacyItems.COOKED_STEGOSAURUS.get(), FossilsLegacyItems.COOKED_DILOPHOSAURUS.get(), FossilsLegacyItems.COOKED_BRACHIOSAURUS.get(), FossilsLegacyItems.COOKED_SMILODON.get(), FossilsLegacyItems.COOKED_MAMMOTH.get(), FossilsLegacyItems.COOKED_CARNOTAURUS.get(), FossilsLegacyItems.COOKED_CRYOLOPHOSAURUS.get(), FossilsLegacyItems.COOKED_THERIZINOSAURUS.get());
        this.tag(ItemTags.MEAT).add(FossilsLegacyItems.RAW_TRICERATOPS.get(), FossilsLegacyItems.RAW_VELOCIRAPTOR.get(), FossilsLegacyItems.RAW_TYRANNOSAURUS.get(), FossilsLegacyItems.RAW_PTERANODON.get(), FossilsLegacyItems.NAUTILUS.get(), FossilsLegacyItems.RAW_FUTABASAURUS.get(), FossilsLegacyItems.RAW_MOSASAURUS.get(), FossilsLegacyItems.RAW_STEGOSAURUS.get(), FossilsLegacyItems.RAW_DILOPHOSAURUS.get(), FossilsLegacyItems.RAW_BRACHIOSAURUS.get(), FossilsLegacyItems.RAW_SMILODON.get(), FossilsLegacyItems.RAW_MAMMOTH.get(), FossilsLegacyItems.RAW_CARNOTAURUS.get(), FossilsLegacyItems.RAW_CRYOLOPHOSAURUS.get(), FossilsLegacyItems.RAW_THERIZINOSAURUS.get(), FossilsLegacyItems.COOKED_TRICERATOPS.get(), FossilsLegacyItems.COOKED_VELOCIRAPTOR.get(), FossilsLegacyItems.COOKED_TYRANNOSAURUS.get(), FossilsLegacyItems.COOKED_PTERANODON.get(), FossilsLegacyItems.SIO_CHIU_LE.get(), FossilsLegacyItems.COOKED_FUTABASAURUS.get(), FossilsLegacyItems.COOKED_MOSASAURUS.get(), FossilsLegacyItems.COOKED_STEGOSAURUS.get(), FossilsLegacyItems.COOKED_DILOPHOSAURUS.get(), FossilsLegacyItems.COOKED_BRACHIOSAURUS.get(), FossilsLegacyItems.COOKED_SMILODON.get(), FossilsLegacyItems.COOKED_MAMMOTH.get(), FossilsLegacyItems.COOKED_CARNOTAURUS.get(), FossilsLegacyItems.COOKED_CRYOLOPHOSAURUS.get(), FossilsLegacyItems.COOKED_THERIZINOSAURUS.get());
        this.tag(FossilsLegacyItemTagProvider.RAW_MEAT).add(FossilsLegacyItems.RAW_TRICERATOPS.get(), FossilsLegacyItems.RAW_VELOCIRAPTOR.get(), FossilsLegacyItems.RAW_TYRANNOSAURUS.get(), FossilsLegacyItems.RAW_PTERANODON.get(), FossilsLegacyItems.NAUTILUS.get(), FossilsLegacyItems.RAW_FUTABASAURUS.get(), FossilsLegacyItems.RAW_MOSASAURUS.get(), FossilsLegacyItems.RAW_STEGOSAURUS.get(), FossilsLegacyItems.RAW_DILOPHOSAURUS.get(), FossilsLegacyItems.RAW_BRACHIOSAURUS.get(), FossilsLegacyItems.RAW_SMILODON.get(), FossilsLegacyItems.RAW_MAMMOTH.get(), FossilsLegacyItems.RAW_CARNOTAURUS.get(), FossilsLegacyItems.RAW_CRYOLOPHOSAURUS.get(), FossilsLegacyItems.RAW_THERIZINOSAURUS.get());
        this.tag(FossilsLegacyItemTagProvider.FOOD_POISONING_FOODS).add(FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get());

        this.copy(FossilsLegacyBlockTags.LEPIDODENDRON_LOGS, FossilsLegacyItemTags.LEPIDODENDRON_LOGS);
        this.copy(FossilsLegacyBlockTags.SIGILLARIA_LOGS, FossilsLegacyItemTags.SIGILLARIA_LOGS);
        this.copy(FossilsLegacyBlockTags.CALAMITES_LOGS, FossilsLegacyItemTags.CALAMITES_LOGS);
        this.tag(FossilsLegacyItemTags.BRACHIOSAURUS_COMMANDABLES).add(Items.STICK);
        this.tag(FossilsLegacyItemTags.CAKE_EGGS).add(FossilsLegacyItems.TRICERATOPS_EGG.get(), FossilsLegacyItems.VELOCIRAPTOR_EGG.get(), FossilsLegacyItems.TYRANNOSAURUS_EGG.get(), FossilsLegacyItems.PTERANODON_EGG.get(), FossilsLegacyItems.FUTABASAURUS_EGG.get(), FossilsLegacyItems.MOSASAURUS_EGG.get(), FossilsLegacyItems.STEGOSAURUS_EGG.get(), FossilsLegacyItems.DILOPHOSAURUS_EGG.get(), FossilsLegacyItems.BRACHIOSAURUS_EGG.get());
        this.tag(FossilsLegacyItemTags.CARNOTAURUS_COMMANDABLES).add(Items.BONE);
        this.tag(FossilsLegacyItemTags.COMPSOGNATHUS_COMMANDABLES).add(Items.BONE);
        this.tag(FossilsLegacyItemTags.CRYOLOPHOSAURUS_COMMANDABLES).add(Items.BONE);
        this.tag(FossilsLegacyItemTags.DILOPHOSAURUS_COMMANDABLES).add(Items.BONE);
        this.tag(FossilsLegacyItemTags.DNA).add(FossilsLegacyItems.AXOLOTL_DNA.get(), FossilsLegacyItems.BRACHIOSAURUS_DNA.get(), FossilsLegacyItems.CAT_DNA.get(), FossilsLegacyItems.CHICKEN_DNA.get(), FossilsLegacyItems.COW_DNA.get(), FossilsLegacyItems.DILOPHOSAURUS_DNA.get(), FossilsLegacyItems.DOLPHIN_DNA.get(), FossilsLegacyItems.DONKEY_DNA.get(), FossilsLegacyItems.FOX_DNA.get(), FossilsLegacyItems.FROG_DNA.get(), FossilsLegacyItems.GOAT_DNA.get(), FossilsLegacyItems.HORSE_DNA.get(), FossilsLegacyItems.LLAMA_DNA.get(), FossilsLegacyItems.MAMMOTH_DNA.get(), FossilsLegacyItems.MOSASAURUS_DNA.get(), FossilsLegacyItems.MULE_DNA.get(), FossilsLegacyItems.NAUTILUS_DNA.get(), FossilsLegacyItems.OCELOT_DNA.get(), FossilsLegacyItems.PANDA_DNA.get(), FossilsLegacyItems.PARROT_DNA.get(), FossilsLegacyItems.PIG_DNA.get(), FossilsLegacyItems.FUTABASAURUS_DNA.get(), FossilsLegacyItems.POLAR_BEAR_DNA.get(), FossilsLegacyItems.PTERANODON_DNA.get(), FossilsLegacyItems.RABBIT_DNA.get(), FossilsLegacyItems.SHEEP_DNA.get(), FossilsLegacyItems.SMILODON_DNA.get(), FossilsLegacyItems.STEGOSAURUS_DNA.get(), FossilsLegacyItems.TRICERATOPS_DNA.get(), FossilsLegacyItems.TYRANNOSAURUS_DNA.get(), FossilsLegacyItems.VELOCIRAPTOR_DNA.get(), FossilsLegacyItems.WOLF_DNA.get(), FossilsLegacyItems.CARNOTAURUS_DNA.get(), FossilsLegacyItems.CRYOLOPHOSAURUS_DNA.get(), FossilsLegacyItems.THERIZINOSAURUS_DNA.get());
        this.tag(FossilsLegacyItemTags.DRUM_INSTRUMENT).add(Items.STICK, Items.BONE, FossilsLegacyItems.SKULL_STICK.get(), Items.ARROW, Items.SPECTRAL_ARROW, Items.TIPPED_ARROW);
        this.tag(FossilsLegacyItemTags.FROGLIGHTS).add(Items.OCHRE_FROGLIGHT, Items.PEARLESCENT_FROGLIGHT, Items.VERDANT_FROGLIGHT);
        this.tag(FossilsLegacyItemTags.MAMMOTH_COMMANDABLES).add(Items.STICK);
        this.tag(FossilsLegacyItemTags.PACHYCEPHALOSAURUS_COMMANDABLES).add(Items.STICK);
        this.tag(FossilsLegacyItemTags.PIGLIN_TAMING_ARMOR).add(FossilsLegacyItems.ANCIENT_HELMET.get(), FossilsLegacyItems.ANCIENT_CHESTPLATE.get(), FossilsLegacyItems.ANCIENT_LEGGINGS.get(), FossilsLegacyItems.ANCIENT_BOOTS.get());
        this.tag(FossilsLegacyItemTags.PTERANODON_COMMANDABLES).add(Items.ARROW, Items.SPECTRAL_ARROW, Items.TIPPED_ARROW);
        this.tag(FossilsLegacyItemTags.STEGOSAURUS_COMMANDABLES).add(Items.STICK);
        this.tag(FossilsLegacyItemTags.TRICERATOPS_COMMANDABLES).add(Items.STICK);
        this.tag(FossilsLegacyItemTags.THERIZINOSAURUS_COMMANDABLES).add(Items.STICK);
        this.tag(FossilsLegacyItemTags.TYRANNOSAURUS_COMMANDABLES).add(FossilsLegacyItems.SKULL_STICK.get());

        this.tag(FossilsLegacyItemTags.REPAIR_WHEN_BROKEN_IN_ARCHAEOLOGY_TABLE).add(FossilsLegacyItems.SCARAB_GEM_AXE.get(), FossilsLegacyItems.SCARAB_GEM_HOE.get(), FossilsLegacyItems.SCARAB_GEM_PICKAXE.get(), FossilsLegacyItems.SCARAB_GEM_SHOVEL.get(), FossilsLegacyItems.SCARAB_GEM_SWORD.get(), FossilsLegacyItems.BROKEN_WOODEN_JAVELIN.get(), FossilsLegacyItems.BROKEN_STONE_JAVELIN.get(), FossilsLegacyItems.BROKEN_IRON_JAVELIN.get(), FossilsLegacyItems.BROKEN_GOLDEN_JAVELIN.get(), FossilsLegacyItems.BROKEN_DIAMOND_JAVELIN.get(), FossilsLegacyItems.BROKEN_NETHERITE_JAVELIN.get(), FossilsLegacyItems.BROKEN_SCARAB_GEM_JAVELIN.get());
    }

    private void tagEquipment(Item sword, Item pickaxe, Item axe, Item shovel, Item hoe, Item helmet, Item chestplate, Item leggings, Item boots) {
        this.tag(FossilsLegacyItemTagProvider.TOOLS).add(sword, pickaxe, axe, shovel, hoe);
        this.tag(FossilsLegacyItemTagProvider.ENCHANTABLES).add(sword, pickaxe, axe, shovel, hoe, helmet, chestplate, leggings, boots);
        this.tag(ItemTags.ARMOR_ENCHANTABLE).add(helmet, chestplate, leggings, boots);
        this.tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(helmet, chestplate, leggings, boots);
        this.tag(ItemTags.TRIMMABLE_ARMOR).add(helmet, chestplate, leggings, boots);
        this.tag(ItemTags.MINING_ENCHANTABLE).add(sword, pickaxe, axe, shovel, hoe);
        this.tag(ItemTags.MINING_LOOT_ENCHANTABLE).add(sword, pickaxe, axe, shovel, hoe, helmet, chestplate, leggings, boots);
        this.tag(ItemTags.VANISHING_ENCHANTABLE).add(sword, pickaxe, axe, shovel, hoe, helmet, chestplate, leggings, boots);
        this.tag(ItemTags.DURABILITY_ENCHANTABLE).add(sword, pickaxe, axe, shovel, hoe, helmet, chestplate, leggings, boots);
        this.tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(sword, axe);
        this.tag(ItemTags.BREAKS_DECORATED_POTS).add(sword, axe);
        this.tag(FossilsLegacyItemTagProvider.MELEE_WEAPONS).add(sword, axe);
        this.tag(ItemTags.WEAPON_ENCHANTABLE).add(sword, axe);
        this.tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(sword);
        this.tag(ItemTags.SWORDS).add(sword);
        this.tag(ItemTags.SWORD_ENCHANTABLE).add(helmet);
        this.tag(ItemTags.PICKAXES).add(pickaxe);
        this.tag(FossilsLegacyItemTagProvider.MINING_TOOLS).add(pickaxe);
        this.tag(ItemTags.CLUSTER_MAX_HARVESTABLES).add(pickaxe);
        this.tag(ItemTags.SHOVELS).add(shovel);
        this.tag(ItemTags.AXES).add(hoe);
        this.tag(ItemTags.HOES).add(hoe);
        this.tag(ItemTags.HEAD_ARMOR).add(helmet);
        this.tag(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(helmet);
        this.tag(ItemTags.CHEST_ARMOR).add(chestplate);
        this.tag(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(helmet);
        this.tag(ItemTags.LEG_ARMOR).add(chestplate);
        this.tag(ItemTags.LEG_ARMOR_ENCHANTABLE).add(leggings);
        this.tag(ItemTags.FOOT_ARMOR).add(boots);
        this.tag(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(leggings);
    }
}
