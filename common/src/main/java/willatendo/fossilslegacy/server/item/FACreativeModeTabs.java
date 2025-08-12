package willatendo.fossilslegacy.server.item;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.RegistryOps;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.platform.FAModloaderHelper;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.command_type.CommandType;
import willatendo.fossilslegacy.server.decoration_plaque_type.DecorationPlaqueType;
import willatendo.fossilslegacy.server.entity.entities.DecorationPlaque;
import willatendo.fossilslegacy.server.entity.entities.StoneTablet;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;
import willatendo.fossilslegacy.server.item.items.DNAItem;
import willatendo.fossilslegacy.server.item.items.MagicConchItem;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.stone_tablet_variant.StoneTabletVariant;
import willatendo.fossilslegacy.server.tags.FAFossilVariantTags;
import willatendo.fossilslegacy.server.tags.FAStoneTabletVariantTags;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class FACreativeModeTabs {
    public static final SimpleRegistry<CreativeModeTab> CREATIVE_MODE_TABS = SimpleRegistry.create(Registries.CREATIVE_MODE_TAB, FAUtils.ID);
    private static final Comparator<Holder<FossilVariant>> FOSSIL_VARIANT_COMPARATOR = Comparator.comparing(Holder::getRegisteredName, String::compareTo);
    private static final Comparator<Holder<DecorationPlaqueType>> DECORATION_PLAQUE_COMPARATOR = Comparator.comparing(Holder::value, Comparator.<DecorationPlaqueType>comparingInt(decorationPlaqueType -> decorationPlaqueType.height() * decorationPlaqueType.width()).thenComparing(DecorationPlaqueType::width));
    private static final Comparator<Holder<StoneTabletVariant>> STONE_TABLET_COMPARATOR = Comparator.comparing(Holder::value, Comparator.<StoneTabletVariant>comparingInt(stoneTabletVariant -> stoneTabletVariant.height() * stoneTabletVariant.width()).thenComparing(StoneTabletVariant::width));

    public static final SimpleHolder<CreativeModeTab> FA_ARCHAEOLOGY = FACreativeModeTabs.register("fa_archaeology", () -> new ItemStack(FAItems.SCARAB_GEM.get()), (itemDisplayParameters, output) -> {
        FACreativeModeTabs.addArchaeology(output, itemDisplayParameters);
    }, List.of("fa_palaeontology", "fa_palaeobotany", "fa_building_blocks", "fa_utilities", "fa_all"), List.of());
    public static final SimpleHolder<CreativeModeTab> FA_PALAEONTOLOGY = FACreativeModeTabs.register("fa_palaeontology", () -> new ItemStack(FAItems.TRICERATOPS_DNA.get()), (itemDisplayParameters, output) -> {
        FACreativeModeTabs.addCreationBlocks(output);
        output.accept(FABlocks.PALAEONTOLOGY_TABLE.get());
        FACreativeModeTabs.addAnimalFossils(output, itemDisplayParameters);
        FACreativeModeTabs.addHammers(output);
        FACreativeModeTabs.addAnimalDNA(output);
        FACreativeModeTabs.addEggsAndEmbryos(output);
        FACreativeModeTabs.addMeat(output);
        FACreativeModeTabs.addAnimalDrops(output);
        FACreativeModeTabs.addAnimalBlocks(output);
        FACreativeModeTabs.addCreatureSpawnEggs(output);
    }, List.of("fa_all", "fa_palaeobotany", "fa_building_blocks", "fa_utilities"), List.of("fa_archaeology"));
    public static final SimpleHolder<CreativeModeTab> FA_PALAEOBOTANY = FACreativeModeTabs.register("fa_palaeobotany", () -> new ItemStack(FAItems.LEPIDODENDRON_CONE.get()), (itemDisplayParameters, output) -> {
        FACreativeModeTabs.addCreationBlocks(output);
        FACreativeModeTabs.addPlantFossils(output);
        FACreativeModeTabs.addPlantDNA(output);
        FACreativeModeTabs.addSeedsAndSpores(output);
        FACreativeModeTabs.addPlants(output);
        FACreativeModeTabs.addWood(output);
    }, List.of("fa_all", "fa_building_blocks", "fa_utilities"), List.of("fa_archaeology", "fa_palaeontology"));
    public static final SimpleHolder<CreativeModeTab> FA_BUILDING_BLOCKS = FACreativeModeTabs.register("fa_building_blocks", () -> new ItemStack(FABlocks.SMALL_CAGE.get()), (itemDisplayParameters, output) -> {
        FACreativeModeTabs.addRails(output);
        FACreativeModeTabs.addDecorationPosts(output);
        FACreativeModeTabs.addWood(output);
    }, List.of("fa_all", "fa_utilities"), List.of("fa_archaeology", "fa_palaeontology", "fa_palaeobotany"));
    public static final SimpleHolder<CreativeModeTab> FA_UTILITIES = FACreativeModeTabs.register("fa_utilities", () -> new ItemStack(FABlocks.SMALL_CAGE.get()), (itemDisplayParameters, output) -> {
        output.accept(FAItems.USER_MANUAL.get());
        output.accept(FAItems.DINOPEDIA.get());
        FACreativeModeTabs.addRifle(output);
        FACreativeModeTabs.addCages(output);
        FACreativeModeTabs.addFlare(output);
        FACreativeModeTabs.addEssences(output);
        FACreativeModeTabs.addCommandingItems(output, itemDisplayParameters, false);
        output.accept(FAItems.LEGACY_GENETIC_CODE.get());
        output.accept(FAItems.TAR_BUCKET.get());
        FACreativeModeTabs.addMusicDiscs(output);
    }, List.of("fa_all"), List.of("fa_archaeology", "fa_palaeontology", "fa_palaeobotany", "fa_building_blocks"));
    public static final SimpleHolder<CreativeModeTab> FA_ALL = FACreativeModeTabs.register("fa_all", () -> new ItemStack(FAItems.MESOZOIC_FOSSIL.get()), (itemDisplayParameters, output) -> {
        FACreativeModeTabs.addCreationBlocks(output);
        output.accept(FABlocks.PALAEONTOLOGY_TABLE.get());
        FACreativeModeTabs.addAnimalFossils(output, itemDisplayParameters);
        FACreativeModeTabs.addHammers(output);
        FACreativeModeTabs.addAnimalDNA(output);
        FACreativeModeTabs.addEggsAndEmbryos(output);
        FACreativeModeTabs.addMeat(output);
        FACreativeModeTabs.addAnimalDrops(output);
        FACreativeModeTabs.addAnimalBlocks(output);
        FACreativeModeTabs.addPlantFossils(output);
        FACreativeModeTabs.addPlantDNA(output);
        FACreativeModeTabs.addSeedsAndSpores(output);
        FACreativeModeTabs.addPlants(output);
        FACreativeModeTabs.addWood(output);
        FACreativeModeTabs.addRails(output);
        FACreativeModeTabs.addDecorationPosts(output);
        FACreativeModeTabs.addArchaeology(output, itemDisplayParameters);
        output.accept(FAItems.USER_MANUAL.get());
        output.accept(FAItems.DINOPEDIA.get());
        FACreativeModeTabs.addRifle(output);
        FACreativeModeTabs.addCages(output);
        FACreativeModeTabs.addFlare(output);
        FACreativeModeTabs.addEssences(output);
        FACreativeModeTabs.addCommandingItems(output, itemDisplayParameters, true);
        output.accept(FAItems.LEGACY_GENETIC_CODE.get());
        output.accept(FAItems.TAR_BUCKET.get());
        FACreativeModeTabs.addCreatureSpawnEggs(output);
        output.accept(FAItems.ANU_SPAWN_EGG.get());
        output.accept(FAItems.FAILURESAURUS_SPAWN_EGG.get());
        FACreativeModeTabs.addMusicDiscs(output);
    }, List.of(), List.of("fa_archaeology", "fa_palaeontology", "fa_palaeobotany", "fa_building_blocks"));

    private static SimpleHolder<CreativeModeTab> register(String id, Supplier<ItemStack> icon, CreativeModeTab.DisplayItemsGenerator displayItemsGenerator, List<String> after, List<String> before) {
        return CREATIVE_MODE_TABS.register(id, () -> FAModloaderHelper.INSTANCE.createCreativeModeTab(id, after, before).icon(icon).displayItems(displayItemsGenerator).build());
    }

    private static void addArchaeology(CreativeModeTab.Output output, CreativeModeTab.ItemDisplayParameters itemDisplayParameters) {
        output.accept(FABlocks.RELIC_IN_STONE.get());
        output.accept(FABlocks.RELIC_IN_DEEPSLATE.get());
        output.accept(FABlocks.ARCHAEOLOGY_WORKBENCH.get());
        output.accept(FAItems.RELIC_SCRAP.get());
        output.accept(FAItems.SCARAB_GEM.get());
        output.accept(FAItems.JADE.get());
        output.accept(FAItems.JADE_OCELOT.get());
        output.accept(FAItems.JADE_VILLAGER.get());
        output.accept(FAItems.CODEX.get());
        output.accept(FAItems.QUIPU.get());
        output.accept(FAItems.ANCIENT_SWORD_ARTIFACT.get());
        output.accept(FAItems.ANCIENT_SHOVEL_ARTIFACT.get());
        output.accept(FAItems.ANCIENT_PICKAXE_ARTIFACT.get());
        output.accept(FAItems.ANCIENT_AXE_ARTIFACT.get());
        output.accept(FAItems.ANCIENT_HOE_ARTIFACT.get());
        output.accept(FAItems.ANCIENT_HELMET_ARTIFACT.get());
        output.accept(FAItems.ANCIENT_CHESTPLATE_ARTIFACT.get());
        output.accept(FAItems.ANCIENT_LEGGINGS_ARTIFACT.get());
        output.accept(FAItems.ANCIENT_BOOTS_ARTIFACT.get());
        output.accept(FAItems.OVERWORLD_COIN.get());
        output.accept(FAItems.ICE_AGE_COIN.get());
        output.accept(FAItems.PREHISTORIC_COIN.get());
        output.accept(FAItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get());
        output.accept(FAItems.STONE_TABLET.get());
        itemDisplayParameters.holders().lookup(FARegistries.STONE_TABLET_VARIANT).ifPresent(registryLookup -> FACreativeModeTabs.generateStoneTablets(output, itemDisplayParameters.holders(), registryLookup, stoneTabletVariantHolder -> stoneTabletVariantHolder.is(FAStoneTabletVariantTags.PLACEABLE), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
        output.accept(FAItems.ANCIENT_SWORD.get());
        output.accept(FAItems.ANCIENT_SHOVEL.get());
        output.accept(FAItems.ANCIENT_PICKAXE.get());
        output.accept(FAItems.ANCIENT_AXE.get());
        output.accept(FAItems.ANCIENT_HOE.get());
        output.accept(FAItems.ANCIENT_HELMET.get());
        output.accept(FAItems.ANCIENT_CHESTPLATE.get());
        output.accept(FAItems.ANCIENT_LEGGINGS.get());
        output.accept(FAItems.ANCIENT_BOOTS.get());
        output.accept(FAItems.SCARAB_GEM_SWORD.get());
        output.accept(FAItems.SCARAB_GEM_SHOVEL.get());
        output.accept(FAItems.SCARAB_GEM_PICKAXE.get());
        output.accept(FAItems.SCARAB_GEM_AXE.get());
        output.accept(FAItems.SCARAB_GEM_HOE.get());
        output.accept(FAItems.SCARAB_GEM_HELMET.get());
        output.accept(FAItems.SCARAB_GEM_CHESTPLATE.get());
        output.accept(FAItems.SCARAB_GEM_LEGGINGS.get());
        output.accept(FAItems.SCARAB_GEM_BOOTS.get());
        output.accept(FAItems.WOODEN_JAVELIN.get());
        output.accept(FAItems.STONE_JAVELIN.get());
        output.accept(FAItems.IRON_JAVELIN.get());
        output.accept(FAItems.GOLDEN_JAVELIN.get());
        output.accept(FAItems.DIAMOND_JAVELIN.get());
        output.accept(FAItems.NETHERITE_JAVELIN.get());
        output.accept(FAItems.SCARAB_GEM_JAVELIN.get());
    }

    private static void addCreationBlocks(CreativeModeTab.Output output) {
        output.accept(FABlocks.DNA_ANALYZER.get());
        output.accept(FABlocks.DNA_CODER.get());
        output.accept(FAItems.STORAGE_DISC.get());
        output.accept(FAItems.BLANK_DNA.get());
        output.accept(FABlocks.DNA_HYBRIDIZER.get());
        output.accept(FABlocks.DNA_RECOMBINATOR.get());
        output.accept(FABlocks.WHITE_CULTIVATOR.get());
        output.accept(FABlocks.LIGHT_GRAY_CULTIVATOR.get());
        output.accept(FABlocks.GRAY_CULTIVATOR.get());
        output.accept(FABlocks.BLACK_CULTIVATOR.get());
        output.accept(FABlocks.BROWN_CULTIVATOR.get());
        output.accept(FABlocks.RED_CULTIVATOR.get());
        output.accept(FABlocks.ORANGE_CULTIVATOR.get());
        output.accept(FABlocks.YELLOW_CULTIVATOR.get());
        output.accept(FABlocks.LIME_CULTIVATOR.get());
        output.accept(FABlocks.GREEN_CULTIVATOR.get());
        output.accept(FABlocks.CYAN_CULTIVATOR.get());
        output.accept(FABlocks.LIGHT_BLUE_CULTIVATOR.get());
        output.accept(FABlocks.BLUE_CULTIVATOR.get());
        output.accept(FABlocks.PURPLE_CULTIVATOR.get());
        output.accept(FABlocks.MAGENTA_CULTIVATOR.get());
        output.accept(FABlocks.PINK_CULTIVATOR.get());
        output.accept(FABlocks.WHITE_SHATTERED_CULTIVATOR.get());
        output.accept(FABlocks.LIGHT_GRAY_SHATTERED_CULTIVATOR.get());
        output.accept(FABlocks.GRAY_SHATTERED_CULTIVATOR.get());
        output.accept(FABlocks.BLACK_SHATTERED_CULTIVATOR.get());
        output.accept(FABlocks.BROWN_SHATTERED_CULTIVATOR.get());
        output.accept(FABlocks.RED_SHATTERED_CULTIVATOR.get());
        output.accept(FABlocks.ORANGE_SHATTERED_CULTIVATOR.get());
        output.accept(FABlocks.YELLOW_SHATTERED_CULTIVATOR.get());
        output.accept(FABlocks.LIME_SHATTERED_CULTIVATOR.get());
        output.accept(FABlocks.GREEN_SHATTERED_CULTIVATOR.get());
        output.accept(FABlocks.CYAN_SHATTERED_CULTIVATOR.get());
        output.accept(FABlocks.LIGHT_BLUE_SHATTERED_CULTIVATOR.get());
        output.accept(FABlocks.BLUE_SHATTERED_CULTIVATOR.get());
        output.accept(FABlocks.PURPLE_SHATTERED_CULTIVATOR.get());
        output.accept(FABlocks.MAGENTA_SHATTERED_CULTIVATOR.get());
        output.accept(FABlocks.PINK_SHATTERED_CULTIVATOR.get());
    }

    private static void addAnimalFossils(CreativeModeTab.Output output, CreativeModeTab.ItemDisplayParameters itemDisplayParameters) {
        output.accept(FABlocks.CENOZOIC_FOSSIL_ORE.get());
        output.accept(FABlocks.DEEPSLATE_CENOZOIC_FOSSIL_ORE.get());
        output.accept(FABlocks.MESOZOIC_FOSSIL_ORE.get());
        output.accept(FABlocks.DEEPSLATE_MESOZOIC_FOSSIL_ORE.get());
        output.accept(FABlocks.PALAEOZOIC_FOSSIL_ORE.get());
        output.accept(FABlocks.DEEPSLATE_PALAEOZOIC_FOSSIL_ORE.get());
        output.accept(FAItems.CENOZOIC_FOSSIL.get());
        itemDisplayParameters.holders().lookup(FARegistries.FOSSIL_VARIANTS).ifPresent(registryLookup -> FACreativeModeTabs.generateArticulatedFossils(output, registryLookup, fossilVariantHolder -> fossilVariantHolder.is(FAFossilVariantTags.CENOZOIC), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
        output.accept(FAItems.MESOZOIC_FOSSIL.get());
        itemDisplayParameters.holders().lookup(FARegistries.FOSSIL_VARIANTS).ifPresent(registryLookup -> FACreativeModeTabs.generateArticulatedFossils(output, registryLookup, fossilVariantHolder -> fossilVariantHolder.is(FAFossilVariantTags.MESOZOIC), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
        output.accept(FAItems.PALAEOZOIC_FOSSIL.get());
        itemDisplayParameters.holders().lookup(FARegistries.FOSSIL_VARIANTS).ifPresent(registryLookup -> FACreativeModeTabs.generateArticulatedFossils(output, registryLookup, fossilVariantHolder -> fossilVariantHolder.is(FAFossilVariantTags.PALAEOZOIC), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
        output.accept(FABlocks.AMBER_ORE.get());
        output.accept(FABlocks.DEEPSLATE_AMBER_ORE.get());
        output.accept(FAItems.AMBER.get());
        output.accept(FAItems.MOSQUITO_IN_AMBER.get());
        output.accept(FABlocks.LEECH_IN_ICE.get());
        output.accept(FAItems.FROZEN_LEECH.get());
        output.accept(FABlocks.PERMAFROST.get());
        output.accept(FAItems.FROZEN_MEAT.get());
    }

    private static void addHammers(CreativeModeTab.Output output) {
        output.accept(FAItems.WOODEN_HAMMER.get());
        output.accept(FAItems.STONE_HAMMER.get());
        output.accept(FAItems.IRON_HAMMER.get());
        output.accept(FAItems.GOLDEN_HAMMER.get());
        output.accept(FAItems.DIAMOND_HAMMER.get());
        output.accept(FAItems.NETHERITE_HAMMER.get());
    }

    private static void addAnimalBlocks(CreativeModeTab.Output output) {
        output.accept(FABlocks.DRUM.get());
        output.accept(FABlocks.FEEDER.get());
    }

    private static void addPlantFossils(CreativeModeTab.Output output) {
        output.accept(FABlocks.PLANT_FOSSIL_ORE.get());
        output.accept(FABlocks.DEEPSLATE_PLANT_FOSSIL_ORE.get());
        output.accept(FAItems.PLANT_FOSSIL.get());
    }

    private static void addAnimalDNA(CreativeModeTab.Output output) {
        DNAItem.addDNAItem(output, FAItems.ARMADILLO_DNA.get());
        DNAItem.addDNAItem(output, FAItems.AXOLOTL_DNA.get());
        DNAItem.addDNAItem(output, FAItems.CAT_DNA.get());
        DNAItem.addDNAItem(output, FAItems.CHICKEN_DNA.get());
        DNAItem.addDNAItem(output, FAItems.COW_DNA.get());
        DNAItem.addDNAItem(output, FAItems.DOLPHIN_DNA.get());
        DNAItem.addDNAItem(output, FAItems.DONKEY_DNA.get());
        DNAItem.addDNAItem(output, FAItems.FOX_DNA.get());
        DNAItem.addDNAItem(output, FAItems.FROG_DNA.get());
        DNAItem.addDNAItem(output, FAItems.GOAT_DNA.get());
        DNAItem.addDNAItem(output, FAItems.HORSE_DNA.get());
        DNAItem.addDNAItem(output, FAItems.LLAMA_DNA.get());
        DNAItem.addDNAItem(output, FAItems.MULE_DNA.get());
        DNAItem.addDNAItem(output, FAItems.NAUTILUS_DNA.get());
        DNAItem.addDNAItem(output, FAItems.OCELOT_DNA.get());
        DNAItem.addDNAItem(output, FAItems.PANDA_DNA.get());
        DNAItem.addDNAItem(output, FAItems.PARROT_DNA.get());
        DNAItem.addDNAItem(output, FAItems.PIG_DNA.get());
        DNAItem.addDNAItem(output, FAItems.POLAR_BEAR_DNA.get());
        DNAItem.addDNAItem(output, FAItems.RABBIT_DNA.get());
        DNAItem.addDNAItem(output, FAItems.SHEEP_DNA.get());
        DNAItem.addDNAItem(output, FAItems.WOLF_DNA.get());
        DNAItem.addDNAItem(output, FAItems.DODO_DNA.get());
        DNAItem.addDNAItem(output, FAItems.ELASMOTHERIUM_DNA.get());
        DNAItem.addDNAItem(output, FAItems.MAMMOTH_DNA.get());
        DNAItem.addDNAItem(output, FAItems.MOA_DNA.get());
        DNAItem.addDNAItem(output, FAItems.SMILODON_DNA.get());
        DNAItem.addDNAItem(output, FAItems.ANKYLOSAURUS_DNA.get());
        DNAItem.addDNAItem(output, FAItems.BARYONYX_DNA.get());
        DNAItem.addDNAItem(output, FAItems.BRACHIOSAURUS_DNA.get());
        DNAItem.addDNAItem(output, FAItems.CARNOTAURUS_DNA.get());
        DNAItem.addDNAItem(output, FAItems.COMPSOGNATHUS_DNA.get());
        DNAItem.addDNAItem(output, FAItems.CRYOLOPHOSAURUS_DNA.get());
        DNAItem.addDNAItem(output, FAItems.DILOPHOSAURUS_DNA.get());
        DNAItem.addDNAItem(output, FAItems.DRYOSAURUS_DNA.get());
        DNAItem.addDNAItem(output, FAItems.FUTABASAURUS_DNA.get());
        DNAItem.addDNAItem(output, FAItems.GALLIMIMUS_DNA.get());
        DNAItem.addDNAItem(output, FAItems.ICHTHYOSAURUS_DNA.get());
        DNAItem.addDNAItem(output, FAItems.MOSASAURUS_DNA.get());
        DNAItem.addDNAItem(output, FAItems.PACHYCEPHALOSAURUS_DNA.get());
        DNAItem.addDNAItem(output, FAItems.PTERANODON_DNA.get());
        DNAItem.addDNAItem(output, FAItems.SPINOSAURUS_DNA.get());
        DNAItem.addDNAItem(output, FAItems.STEGOSAURUS_DNA.get());
        DNAItem.addDNAItem(output, FAItems.THERIZINOSAURUS_DNA.get());
        DNAItem.addDNAItem(output, FAItems.TRICERATOPS_DNA.get());
        DNAItem.addDNAItem(output, FAItems.TYRANNOSAURUS_DNA.get());
        DNAItem.addDNAItem(output, FAItems.VELOCIRAPTOR_DNA.get());
        DNAItem.addDNAItem(output, FAItems.DIMETRODON_DNA.get());
        DNAItem.addDNAItem(output, FAItems.ISOTELUS_DNA.get());
    }

    private static void addEggsAndEmbryos(CreativeModeTab.Output output) {
        output.accept(FAItems.ARMADILLO_EMBRYO_SYRINGE.get());
        output.accept(FABlocks.AXOLOTLSPAWN.get());
        output.accept(FAItems.CAT_EMBRYO_SYRINGE.get());
        output.accept(FAItems.INCUBATED_CHICKEN_EGG.get());
        output.accept(Items.EGG);
        output.accept(FAItems.COW_EMBRYO_SYRINGE.get());
        output.accept(FAItems.DOLPHIN_EMBRYO_SYRINGE.get());
        output.accept(FAItems.DONKEY_EMBRYO_SYRINGE.get());
        output.accept(FAItems.FOX_EMBRYO_SYRINGE.get());
        output.accept(Blocks.FROGSPAWN);
        output.accept(FAItems.GOAT_EMBRYO_SYRINGE.get());
        output.accept(FAItems.HORSE_EMBRYO_SYRINGE.get());
        output.accept(FAItems.LLAMA_EMBRYO_SYRINGE.get());
        output.accept(FAItems.MULE_EMBRYO_SYRINGE.get());
        output.accept(FAItems.NAUTILUS_EGGS.get());
        output.accept(FAItems.OCELOT_EMBRYO_SYRINGE.get());
        output.accept(FAItems.PANDA_EMBRYO_SYRINGE.get());
        output.accept(FAItems.INCUBATED_PARROT_EGG.get());
        output.accept(FAItems.PIG_EMBRYO_SYRINGE.get());
        output.accept(FAItems.POLAR_BEAR_EMBRYO_SYRINGE.get());
        output.accept(FAItems.RABBIT_EMBRYO_SYRINGE.get());
        output.accept(FAItems.SHEEP_EMBRYO_SYRINGE.get());
        output.accept(FAItems.WOLF_EMBRYO_SYRINGE.get());
        output.accept(FAItems.INCUBATED_DODO_EGG.get());
        output.accept(FAItems.DODO_EGG.get());
        output.accept(FAItems.ELASMOTHERIUM_EMBRYO_SYRINGE.get());
        output.accept(FAItems.MAMMOTH_EMBRYO_SYRINGE.get());
        output.accept(FAItems.INCUBATED_MOA_EGG.get());
        output.accept(FAItems.MOA_EGG.get());
        output.accept(FAItems.SMILODON_EMBRYO_SYRINGE.get());
        output.accept(FAItems.ANKYLOSAURUS_EGG.get());
        output.accept(FAItems.BARYONYX_EGG.get());
        output.accept(FAItems.BRACHIOSAURUS_EGG.get());
        output.accept(FAItems.CARNOTAURUS_EGG.get());
        output.accept(FAItems.COMPSOGNATHUS_EGG.get());
        output.accept(FAItems.CRYOLOPHOSAURUS_EGG.get());
        output.accept(FAItems.DILOPHOSAURUS_EGG.get());
        output.accept(FAItems.DRYOSAURUS_EGG.get());
        output.accept(FAItems.FUTABASAURUS_EGG.get());
        output.accept(FAItems.GALLIMIMUS_EGG.get());
        output.accept(FAItems.ICHTHYOSAURUS_EGG.get());
        output.accept(FAItems.MOSASAURUS_EGG.get());
        output.accept(FAItems.PACHYCEPHALOSAURUS_EGG.get());
        output.accept(FAItems.PTERANODON_EGG.get());
        output.accept(FAItems.SPINOSAURUS_EGG.get());
        output.accept(FAItems.STEGOSAURUS_EGG.get());
        output.accept(FAItems.THERIZINOSAURUS_EGG.get());
        output.accept(FAItems.TRICERATOPS_EGG.get());
        output.accept(FAItems.TYRANNOSAURUS_EGG.get());
        output.accept(FAItems.VELOCIRAPTOR_EGG.get());
        output.accept(FAItems.DIMETRODON_EGG.get());
        output.accept(FAItems.ISOTELUS_EGGS.get());
    }

    private static void addMeat(CreativeModeTab.Output output) {
        output.accept(FAItems.RAW_ANKYLOSAURUS.get());
        output.accept(FAItems.COOKED_ANKYLOSAURUS.get());
        output.accept(FAItems.RAW_BARYONYX.get());
        output.accept(FAItems.COOKED_BARYONYX.get());
        output.accept(FAItems.RAW_BRACHIOSAURUS.get());
        output.accept(FAItems.COOKED_BRACHIOSAURUS.get());
        output.accept(FAItems.RAW_CARNOTAURUS.get());
        output.accept(FAItems.COOKED_CARNOTAURUS.get());
        output.accept(FAItems.RAW_COMPSOGNATHUS.get());
        output.accept(FAItems.COOKED_COMPSOGNATHUS.get());
        output.accept(FAItems.RAW_CRYOLOPHOSAURUS.get());
        output.accept(FAItems.COOKED_CRYOLOPHOSAURUS.get());
        output.accept(FAItems.RAW_DILOPHOSAURUS.get());
        output.accept(FAItems.COOKED_DILOPHOSAURUS.get());
        output.accept(FAItems.RAW_DIMETRODON.get());
        output.accept(FAItems.COOKED_DIMETRODON.get());
        output.accept(FAItems.RAW_DODO.get());
        output.accept(FAItems.COOKED_DODO.get());
        output.accept(FAItems.RAW_DRYOSAURUS.get());
        output.accept(FAItems.COOKED_DRYOSAURUS.get());
        output.accept(FAItems.RAW_ELASMOTHERIUM.get());
        output.accept(FAItems.COOKED_ELASMOTHERIUM.get());
        output.accept(FAItems.RAW_FUTABASAURUS.get());
        output.accept(FAItems.COOKED_FUTABASAURUS.get());
        output.accept(FAItems.RAW_GALLIMIMUS.get());
        output.accept(FAItems.COOKED_GALLIMIMUS.get());
        output.accept(FAItems.RAW_ICHTHYOSAURUS.get());
        output.accept(FAItems.COOKED_ICHTHYOSAURUS.get());
        output.accept(FAItems.RAW_MAMMOTH.get());
        output.accept(FAItems.COOKED_MAMMOTH.get());
        output.accept(FAItems.RAW_MOA.get());
        output.accept(FAItems.COOKED_MOA.get());
        output.accept(FAItems.RAW_MOSASAURUS.get());
        output.accept(FAItems.COOKED_MOSASAURUS.get());
        output.accept(FAItems.NAUTILUS.get());
        output.accept(FAItems.SIO_CHIU_LE.get());
        output.accept(FAItems.RAW_PACHYCEPHALOSAURUS.get());
        output.accept(FAItems.COOKED_PACHYCEPHALOSAURUS.get());
        output.accept(FAItems.RAW_PTERANODON.get());
        output.accept(FAItems.COOKED_PTERANODON.get());
        output.accept(FAItems.RAW_SMILODON.get());
        output.accept(FAItems.COOKED_SMILODON.get());
        output.accept(FAItems.RAW_SPINOSAURUS.get());
        output.accept(FAItems.COOKED_SPINOSAURUS.get());
        output.accept(FAItems.RAW_STEGOSAURUS.get());
        output.accept(FAItems.COOKED_STEGOSAURUS.get());
        output.accept(FAItems.RAW_THERIZINOSAURUS.get());
        output.accept(FAItems.COOKED_THERIZINOSAURUS.get());
        output.accept(FAItems.RAW_TRICERATOPS.get());
        output.accept(FAItems.COOKED_TRICERATOPS.get());
        output.accept(FAItems.RAW_TYRANNOSAURUS.get());
        output.accept(FAItems.COOKED_TYRANNOSAURUS.get());
        output.accept(FAItems.RAW_VELOCIRAPTOR.get());
        output.accept(FAItems.COOKED_VELOCIRAPTOR.get());
    }

    private static void addAnimalDrops(CreativeModeTab.Output output) {
        output.accept(FAItems.THERIZINOSAURUS_CLAWS.get());
        output.accept(FAItems.TYRANNOSAURUS_TOOTH.get());
        output.accept(FAItems.TOOTH_DAGGER.get());
    }

    private static void addCreatureSpawnEggs(CreativeModeTab.Output output) {
        output.accept(FAItems.ANKYLOSAURUS_SPAWN_EGG.get());
        output.accept(FAItems.BARYONYX_SPAWN_EGG.get());
        output.accept(FAItems.BRACHIOSAURUS_SPAWN_EGG.get());
        output.accept(FAItems.CARNOTAURUS_SPAWN_EGG.get());
        output.accept(FAItems.COMPSOGNATHUS_SPAWN_EGG.get());
        output.accept(FAItems.CRYOLOPHOSAURUS_SPAWN_EGG.get());
        output.accept(FAItems.DILOPHOSAURUS_SPAWN_EGG.get());
        output.accept(FAItems.DIMETRODON_SPAWN_EGG.get());
        output.accept(FAItems.DISTORTUS_REX_SPAWN_EGG.get());
        output.accept(FAItems.DODO_SPAWN_EGG.get());
        output.accept(FAItems.DRYOSAURUS_SPAWN_EGG.get());
        output.accept(FAItems.ELASMOTHERIUM_SPAWN_EGG.get());
        output.accept(FAItems.FUTABASAURUS_SPAWN_EGG.get());
        output.accept(FAItems.GALLIMIMUS_SPAWN_EGG.get());
        output.accept(FAItems.ICHTHYOSAURUS_SPAWN_EGG.get());
        output.accept(FAItems.ISOTELUS_SPAWN_EGG.get());
        output.accept(FAItems.ISOTELUS_LARVA_SPAWN_EGG.get());
        output.accept(FAItems.MAMMOTH_SPAWN_EGG.get());
        output.accept(FAItems.MOA_SPAWN_EGG.get());
        output.accept(FAItems.MOSASAURUS_SPAWN_EGG.get());
        output.accept(FAItems.NAUTILUS_SPAWN_EGG.get());
        output.accept(FAItems.PACHYCEPHALOSAURUS_SPAWN_EGG.get());
        output.accept(FAItems.PTERANODON_SPAWN_EGG.get());
        output.accept(FAItems.SMILODON_SPAWN_EGG.get());
        output.accept(FAItems.SPINOSAURUS_SPAWN_EGG.get());
        output.accept(FAItems.STEGOSAURUS_SPAWN_EGG.get());
        output.accept(FAItems.THERIZINOSAURUS_SPAWN_EGG.get());
        output.accept(FAItems.TRICERATOPS_SPAWN_EGG.get());
        output.accept(FAItems.TYRANNOSAURUS_SPAWN_EGG.get());
        output.accept(FAItems.VELOCIRAPTOR_SPAWN_EGG.get());
    }

    private static void addPlantDNA(CreativeModeTab.Output output) {
        DNAItem.addDNAItem(output, FAItems.CYCAD_DNA.get());
        DNAItem.addDNAItem(output, FAItems.GINKGO_DNA.get());
        DNAItem.addDNAItem(output, FAItems.HORSETAIL_DNA.get());
        DNAItem.addDNAItem(output, FAItems.WOLLEMIA_DNA.get());
        DNAItem.addDNAItem(output, FAItems.ARAUCARIA_DNA.get());
        DNAItem.addDNAItem(output, FAItems.CLAYTOSMUNDA_DNA.get());
        DNAItem.addDNAItem(output, FAItems.CYCADEOIDEA_DNA.get());
        DNAItem.addDNAItem(output, FAItems.JURASSIC_FERN_DNA.get());
        DNAItem.addDNAItem(output, FAItems.ARAUCARIOXYLON_DNA.get());
        DNAItem.addDNAItem(output, FAItems.ARCHAEOPTERIS_DNA.get());
        DNAItem.addDNAItem(output, FAItems.CALAMITES_DNA.get());
        DNAItem.addDNAItem(output, FAItems.CORDAITES_DNA.get());
        DNAItem.addDNAItem(output, FAItems.COOKSONIA_DNA.get());
        DNAItem.addDNAItem(output, FAItems.LEPIDODENDRON_DNA.get());
        DNAItem.addDNAItem(output, FAItems.SIGILLARIA_DNA.get());
    }

    private static void addSeedsAndSpores(CreativeModeTab.Output output) {
        output.accept(FAItems.CYCAD_CONE.get());
        output.accept(FAItems.GINKGO_SEED.get());
        output.accept(FAItems.HORSETAIL_SPORE.get());
        output.accept(FAItems.ARAUCARIA_CONE.get());
        output.accept(FAItems.CLAYTOSMUNDA_SPORES.get());
        output.accept(FAItems.CYCADEOIDEA_SEED.get());
        output.accept(FAItems.JURASSIC_FERN_SPORES.get());
        output.accept(FAItems.ARCHAEOPTERIS_SPORE.get());
        output.accept(FAItems.CALAMITES_SPORE.get());
        output.accept(FAItems.COOKSONIA_SPORES.get());
        output.accept(FAItems.LEPIDODENDRON_CONE.get());
        output.accept(FAItems.SIGILLARIA_SPORE.get());
    }

    private static void addPlants(CreativeModeTab.Output output) {
        output.accept(FABlocks.CYCAD_HEAD.get());
        output.accept(FABlocks.CYCAD_LOG.get());
        output.accept(FABlocks.SHORT_HORSETAIL.get());
        output.accept(FABlocks.TALL_HORSETAIL.get());
        output.accept(FABlocks.CLAYTOSMUNDA.get());
        output.accept(FABlocks.CYCADEOIDEA.get());
        output.accept(FABlocks.JURASSIC_FERN.get());
        output.accept(FABlocks.COOKSONIA.get());
        output.accept(FABlocks.MACROTAENIOPTERIS.get());
        output.accept(FABlocks.DIPTERIS.get());
        output.accept(FABlocks.ZAMITES_HEAD.get());
    }

    private static void addRails(CreativeModeTab.Output output) {
        output.accept(FABlocks.STRAIGHT_TRACK.get());
        output.accept(FABlocks.CORNER_TRACK.get());
        output.accept(FABlocks.RAMP_TRACK.get());
    }

    private static void addDecorationPosts(CreativeModeTab.Output output) {
        output.accept(FAItems.WHITE_DECORATION_PLAQUE.get());
        output.accept(FAItems.LIGHT_GRAY_DECORATION_PLAQUE.get());
        output.accept(FAItems.GRAY_DECORATION_PLAQUE.get());
        output.accept(FAItems.BLACK_DECORATION_PLAQUE.get());
        output.accept(FAItems.BROWN_DECORATION_PLAQUE.get());
        output.accept(FAItems.RED_DECORATION_PLAQUE.get());
        output.accept(FAItems.ORANGE_DECORATION_PLAQUE.get());
        output.accept(FAItems.YELLOW_DECORATION_PLAQUE.get());
        output.accept(FAItems.LIME_DECORATION_PLAQUE.get());
        output.accept(FAItems.GREEN_DECORATION_PLAQUE.get());
        output.accept(FAItems.CYAN_DECORATION_PLAQUE.get());
        output.accept(FAItems.LIGHT_BLUE_DECORATION_PLAQUE.get());
        output.accept(FAItems.BLUE_DECORATION_PLAQUE.get());
        output.accept(FAItems.PURPLE_DECORATION_PLAQUE.get());
        output.accept(FAItems.MAGENTA_DECORATION_PLAQUE.get());
        output.accept(FAItems.PINK_DECORATION_PLAQUE.get());
    }

    private static void addRifle(CreativeModeTab.Output output) {
        output.accept(FAItems.RIFLE.get());
        output.accept(FAItems.GREEN_TRANQUILIZER_DART.get());
        output.accept(FAItems.RED_TRANQUILIZER_DART.get());
        output.accept(FAItems.BLUE_TRANQUILIZER_DART.get());
    }

    private static void addCages(CreativeModeTab.Output output) {
        output.accept(FABlocks.SMALL_CAGE.get());
        output.accept(FABlocks.MEDIUM_CAGE.get());
        output.accept(FAItems.IRON_KEY.get());
        output.accept(FAItems.GOLDEN_KEY.get());
        output.accept(FAItems.BOLT_CUTTER.get());
    }

    private static void addFlare(CreativeModeTab.Output output) {
        output.accept(FAItems.FLARE.get());
        output.accept(FAItems.FLARE_BODY.get());
    }

    private static void addEssences(CreativeModeTab.Output output) {
        output.accept(FAItems.RAW_CHICKEN_SOUP_BUCKET.get());
        output.accept(FAItems.COOKED_CHICKEN_SOUP_BUCKET.get());
        output.accept(FAItems.CHICKEN_ESSENCE_BOTTLE.get());
        output.accept(FAItems.RAW_BERRY_MEDLEY_BUCKET.get());
        output.accept(FAItems.COOKED_BERRY_MEDLEY_BUCKET.get());
        output.accept(FAItems.ROMANTIC_CONCOCTION_BOTTLE.get());
    }

    private static void addCommandingItems(CreativeModeTab.Output output, CreativeModeTab.ItemDisplayParameters itemDisplayParameters, boolean search) {
        if (!search) {
            output.accept(Items.STICK);
            output.accept(Items.BONE);
        }
        output.accept(FAItems.SKULL_STICK.get());
        if (!search) {
            output.accept(Items.ARROW);
            output.accept(Items.SPECTRAL_ARROW);
        }
        itemDisplayParameters.holders().lookup(FARegistries.COMMAND_TYPES).ifPresent(registryLookup -> FACreativeModeTabs.generateMagicConches(output, registryLookup));
    }

    private static void addWood(CreativeModeTab.Output output) {
        output.accept(FABlocks.ARAUCARIA_LOG.get());
        output.accept(FABlocks.ARAUCARIA_WOOD.get());
        output.accept(FABlocks.STRIPPED_ARAUCARIA_LOG.get());
        output.accept(FABlocks.STRIPPED_ARAUCARIA_WOOD.get());
        output.accept(FABlocks.ARAUCARIA_PLANKS.get());
        output.accept(FABlocks.ARAUCARIA_STAIRS.get());
        output.accept(FABlocks.ARAUCARIA_SLAB.get());
        output.accept(FABlocks.ARAUCARIA_FENCE.get());
        output.accept(FABlocks.ARAUCARIA_FENCE_GATE.get());
        output.accept(FABlocks.ARAUCARIA_DOOR.get());
        output.accept(FABlocks.ARAUCARIA_TRAPDOOR.get());
        output.accept(FABlocks.ARAUCARIA_PRESSURE_PLATE.get());
        output.accept(FABlocks.ARAUCARIA_BUTTON.get());
        output.accept(FABlocks.ARAUCARIA_LEAVES.get());
        output.accept(FABlocks.ARAUCARIA_SAPLING.get());
        output.accept(FABlocks.ARAUCARIA_SIGN.get());
        output.accept(FABlocks.ARAUCARIA_HANGING_SIGN.get());
        output.accept(FAItems.ARAUCARIA_BOAT.get());
        output.accept(FAItems.ARAUCARIA_CHEST_BOAT.get());
        output.accept(FABlocks.ARAUCARIOXYLON_LOG.get());
        output.accept(FABlocks.ARAUCARIOXYLON_WOOD.get());
        output.accept(FABlocks.STRIPPED_ARAUCARIOXYLON_LOG.get());
        output.accept(FABlocks.STRIPPED_ARAUCARIOXYLON_WOOD.get());
        output.accept(FABlocks.ARAUCARIOXYLON_PLANKS.get());
        output.accept(FABlocks.ARAUCARIOXYLON_STAIRS.get());
        output.accept(FABlocks.ARAUCARIOXYLON_SLAB.get());
        output.accept(FABlocks.ARAUCARIOXYLON_FENCE.get());
        output.accept(FABlocks.ARAUCARIOXYLON_FENCE_GATE.get());
        output.accept(FABlocks.ARAUCARIOXYLON_DOOR.get());
        output.accept(FABlocks.ARAUCARIOXYLON_TRAPDOOR.get());
        output.accept(FABlocks.ARAUCARIOXYLON_PRESSURE_PLATE.get());
        output.accept(FABlocks.ARAUCARIOXYLON_BUTTON.get());
        output.accept(FABlocks.ARAUCARIOXYLON_LEAVES.get());
        output.accept(FABlocks.ARAUCARIOXYLON_SAPLING.get());
        output.accept(FABlocks.ARAUCARIOXYLON_SIGN.get());
        output.accept(FABlocks.ARAUCARIOXYLON_HANGING_SIGN.get());
        output.accept(FAItems.ARAUCARIOXYLON_BOAT.get());
        output.accept(FAItems.ARAUCARIOXYLON_CHEST_BOAT.get());
        output.accept(FABlocks.ARCHAEOPTERIS_LOG.get());
        output.accept(FABlocks.ARCHAEOPTERIS_WOOD.get());
        output.accept(FABlocks.STRIPPED_ARCHAEOPTERIS_LOG.get());
        output.accept(FABlocks.STRIPPED_ARCHAEOPTERIS_WOOD.get());
        output.accept(FABlocks.ARCHAEOPTERIS_PLANKS.get());
        output.accept(FABlocks.ARCHAEOPTERIS_STAIRS.get());
        output.accept(FABlocks.ARCHAEOPTERIS_SLAB.get());
        output.accept(FABlocks.ARCHAEOPTERIS_FENCE.get());
        output.accept(FABlocks.ARCHAEOPTERIS_FENCE_GATE.get());
        output.accept(FABlocks.ARCHAEOPTERIS_DOOR.get());
        output.accept(FABlocks.ARCHAEOPTERIS_TRAPDOOR.get());
        output.accept(FABlocks.ARCHAEOPTERIS_PRESSURE_PLATE.get());
        output.accept(FABlocks.ARCHAEOPTERIS_BUTTON.get());
        output.accept(FABlocks.ARCHAEOPTERIS_LEAVES.get());
        output.accept(FABlocks.ARCHAEOPTERIS_SAPLING.get());
        output.accept(FABlocks.ARCHAEOPTERIS_SIGN.get());
        output.accept(FABlocks.ARCHAEOPTERIS_HANGING_SIGN.get());
        output.accept(FAItems.ARCHAEOPTERIS_BOAT.get());
        output.accept(FAItems.ARCHAEOPTERIS_CHEST_BOAT.get());
        output.accept(FABlocks.CALAMITES_LOG.get());
        output.accept(FABlocks.CALAMITES_WOOD.get());
        output.accept(FABlocks.STRIPPED_CALAMITES_LOG.get());
        output.accept(FABlocks.STRIPPED_CALAMITES_WOOD.get());
        output.accept(FABlocks.CALAMITES_PLANKS.get());
        output.accept(FABlocks.CALAMITES_STAIRS.get());
        output.accept(FABlocks.CALAMITES_SLAB.get());
        output.accept(FABlocks.CALAMITES_FENCE.get());
        output.accept(FABlocks.CALAMITES_FENCE_GATE.get());
        output.accept(FABlocks.CALAMITES_DOOR.get());
        output.accept(FABlocks.CALAMITES_TRAPDOOR.get());
        output.accept(FABlocks.CALAMITES_PRESSURE_PLATE.get());
        output.accept(FABlocks.CALAMITES_BUTTON.get());
        output.accept(FABlocks.CALAMITES_LEAVES.get());
        output.accept(FABlocks.CALAMITES_SAPLING.get());
        output.accept(FABlocks.CALAMITES_SIGN.get());
        output.accept(FABlocks.CALAMITES_HANGING_SIGN.get());
        output.accept(FAItems.CALAMITES_BOAT.get());
        output.accept(FAItems.CALAMITES_CHEST_BOAT.get());
        output.accept(FABlocks.CORDAITES_LOG.get());
        output.accept(FABlocks.CORDAITES_WOOD.get());
        output.accept(FABlocks.STRIPPED_CORDAITES_LOG.get());
        output.accept(FABlocks.STRIPPED_CORDAITES_WOOD.get());
        output.accept(FABlocks.CORDAITES_PLANKS.get());
        output.accept(FABlocks.CORDAITES_STAIRS.get());
        output.accept(FABlocks.CORDAITES_SLAB.get());
        output.accept(FABlocks.CORDAITES_FENCE.get());
        output.accept(FABlocks.CORDAITES_FENCE_GATE.get());
        output.accept(FABlocks.CORDAITES_DOOR.get());
        output.accept(FABlocks.CORDAITES_TRAPDOOR.get());
        output.accept(FABlocks.CORDAITES_PRESSURE_PLATE.get());
        output.accept(FABlocks.CORDAITES_BUTTON.get());
        output.accept(FABlocks.CORDAITES_LEAVES.get());
        output.accept(FABlocks.CORDAITES_SAPLING.get());
        output.accept(FABlocks.CORDAITES_SIGN.get());
        output.accept(FABlocks.CORDAITES_HANGING_SIGN.get());
        output.accept(FAItems.CORDAITES_BOAT.get());
        output.accept(FAItems.CORDAITES_CHEST_BOAT.get());
        output.accept(FABlocks.GINKGO_LOG.get());
        output.accept(FABlocks.GINKGO_WOOD.get());
        output.accept(FABlocks.STRIPPED_GINKGO_LOG.get());
        output.accept(FABlocks.STRIPPED_GINKGO_WOOD.get());
        output.accept(FABlocks.GINKGO_PLANKS.get());
        output.accept(FABlocks.GINKGO_STAIRS.get());
        output.accept(FABlocks.GINKGO_SLAB.get());
        output.accept(FABlocks.GINKGO_FENCE.get());
        output.accept(FABlocks.GINKGO_FENCE_GATE.get());
        output.accept(FABlocks.GINKGO_DOOR.get());
        output.accept(FABlocks.GINKGO_TRAPDOOR.get());
        output.accept(FABlocks.GINKGO_PRESSURE_PLATE.get());
        output.accept(FABlocks.GINKGO_BUTTON.get());
        output.accept(FABlocks.GINKGO_LEAVES.get());
        output.accept(FABlocks.GINKGO_SAPLING.get());
        output.accept(FABlocks.GINKGO_SIGN.get());
        output.accept(FABlocks.GINKGO_HANGING_SIGN.get());
        output.accept(FAItems.GINKGO_BOAT.get());
        output.accept(FAItems.GINKGO_CHEST_BOAT.get());
        output.accept(FABlocks.LEPIDODENDRON_LOG.get());
        output.accept(FABlocks.LEPIDODENDRON_WOOD.get());
        output.accept(FABlocks.STRIPPED_LEPIDODENDRON_LOG.get());
        output.accept(FABlocks.STRIPPED_LEPIDODENDRON_WOOD.get());
        output.accept(FABlocks.LEPIDODENDRON_PLANKS.get());
        output.accept(FABlocks.LEPIDODENDRON_STAIRS.get());
        output.accept(FABlocks.LEPIDODENDRON_SLAB.get());
        output.accept(FABlocks.LEPIDODENDRON_FENCE.get());
        output.accept(FABlocks.LEPIDODENDRON_FENCE_GATE.get());
        output.accept(FABlocks.LEPIDODENDRON_DOOR.get());
        output.accept(FABlocks.LEPIDODENDRON_TRAPDOOR.get());
        output.accept(FABlocks.LEPIDODENDRON_PRESSURE_PLATE.get());
        output.accept(FABlocks.LEPIDODENDRON_BUTTON.get());
        output.accept(FABlocks.LEPIDODENDRON_LEAVES.get());
        output.accept(FABlocks.LEPIDODENDRON_SAPLING.get());
        output.accept(FABlocks.LEPIDODENDRON_SIGN.get());
        output.accept(FABlocks.LEPIDODENDRON_HANGING_SIGN.get());
        output.accept(FAItems.LEPIDODENDRON_BOAT.get());
        output.accept(FAItems.LEPIDODENDRON_CHEST_BOAT.get());
        output.accept(FABlocks.SIGILLARIA_LOG.get());
        output.accept(FABlocks.SIGILLARIA_WOOD.get());
        output.accept(FABlocks.STRIPPED_SIGILLARIA_LOG.get());
        output.accept(FABlocks.STRIPPED_SIGILLARIA_WOOD.get());
        output.accept(FABlocks.SIGILLARIA_PLANKS.get());
        output.accept(FABlocks.SIGILLARIA_STAIRS.get());
        output.accept(FABlocks.SIGILLARIA_SLAB.get());
        output.accept(FABlocks.SIGILLARIA_FENCE.get());
        output.accept(FABlocks.SIGILLARIA_FENCE_GATE.get());
        output.accept(FABlocks.SIGILLARIA_DOOR.get());
        output.accept(FABlocks.SIGILLARIA_TRAPDOOR.get());
        output.accept(FABlocks.SIGILLARIA_PRESSURE_PLATE.get());
        output.accept(FABlocks.SIGILLARIA_BUTTON.get());
        output.accept(FABlocks.SIGILLARIA_LEAVES.get());
        output.accept(FABlocks.SIGILLARIA_SAPLING.get());
        output.accept(FABlocks.SIGILLARIA_SIGN.get());
        output.accept(FABlocks.SIGILLARIA_HANGING_SIGN.get());
        output.accept(FAItems.SIGILLARIA_BOAT.get());
        output.accept(FAItems.SIGILLARIA_CHEST_BOAT.get());
        output.accept(FABlocks.WOLLEMIA_LOG.get());
        output.accept(FABlocks.WOLLEMIA_WOOD.get());
        output.accept(FABlocks.STRIPPED_WOLLEMIA_LOG.get());
        output.accept(FABlocks.STRIPPED_WOLLEMIA_WOOD.get());
        output.accept(FABlocks.WOLLEMIA_PLANKS.get());
        output.accept(FABlocks.WOLLEMIA_STAIRS.get());
        output.accept(FABlocks.WOLLEMIA_SLAB.get());
        output.accept(FABlocks.WOLLEMIA_FENCE.get());
        output.accept(FABlocks.WOLLEMIA_FENCE_GATE.get());
        output.accept(FABlocks.WOLLEMIA_DOOR.get());
        output.accept(FABlocks.WOLLEMIA_TRAPDOOR.get());
        output.accept(FABlocks.WOLLEMIA_PRESSURE_PLATE.get());
        output.accept(FABlocks.WOLLEMIA_BUTTON.get());
        output.accept(FABlocks.WOLLEMIA_LEAVES.get());
        output.accept(FABlocks.WOLLEMIA_SAPLING.get());
        output.accept(FABlocks.WOLLEMIA_SIGN.get());
        output.accept(FABlocks.WOLLEMIA_HANGING_SIGN.get());
        output.accept(FAItems.WOLLEMIA_BOAT.get());
        output.accept(FAItems.WOLLEMIA_CHEST_BOAT.get());
    }

    private static void addMusicDiscs(CreativeModeTab.Output output) {
        output.accept(FAItems.MUSIC_DISC_TRIASSIC.get());
        output.accept(FAItems.MUSIC_DISC_JURASSIC.get());
        output.accept(FAItems.MUSIC_DISC_CRETACEOUS.get());
    }

    private static void generateMagicConches(CreativeModeTab.Output output, HolderLookup.RegistryLookup<CommandType> registryLookup) {
        for (Holder.Reference<CommandType> commandType : registryLookup.listElements().toList()) {
            ItemStack itemStack = new ItemStack(FAItems.MAGIC_CONCH.get());
            MagicConchItem.setOrder(itemStack, commandType);
            output.accept(itemStack);
        }
    }

    private static void generateArticulatedFossils(CreativeModeTab.Output output, HolderLookup.RegistryLookup<FossilVariant> registryLookup, Predicate<Holder<FossilVariant>> predicate, CreativeModeTab.TabVisibility tabVisibility) {
        registryLookup.listElements().filter(predicate).sorted(FOSSIL_VARIANT_COMPARATOR).forEach(reference -> {
            ItemStack itemStack = new ItemStack(FAItems.ARTICULATED_FOSSIL.get());
            itemStack.set(FADataComponents.FOSSIL_VARIANT.get(), reference);
            output.accept(itemStack, tabVisibility);
        });
    }

    private static void generateDecorationPlaques(CreativeModeTab.Output output, HolderLookup.Provider provider, HolderLookup.RegistryLookup<DecorationPlaqueType> registryLookup, Predicate<Holder<DecorationPlaqueType>> predicate, CreativeModeTab.TabVisibility tabVisibility) {
        RegistryOps<Tag> registryOps = provider.createSerializationContext(NbtOps.INSTANCE);
        registryLookup.listElements().filter(predicate).sorted(DECORATION_PLAQUE_COMPARATOR).forEach(reference -> {
            CustomData customData = CustomData.EMPTY.update(registryOps, DecorationPlaque.VARIANT_MAP_CODEC, reference).getOrThrow().update(compoundTag -> compoundTag.putString("id", "fossilslegacy:stone_tablet"));
            ItemStack itemStack = new ItemStack(FAItems.WHITE_DECORATION_PLAQUE.get());
            itemStack.set(DataComponents.ENTITY_DATA, customData);
            output.accept(itemStack, tabVisibility);
        });
    }

    private static void generateStoneTablets(CreativeModeTab.Output output, HolderLookup.Provider provider, HolderLookup.RegistryLookup<StoneTabletVariant> registryLookup, Predicate<Holder<StoneTabletVariant>> predicate, CreativeModeTab.TabVisibility tabVisibility) {
        RegistryOps<Tag> registryOps = provider.createSerializationContext(NbtOps.INSTANCE);
        registryLookup.listElements().filter(predicate).sorted(STONE_TABLET_COMPARATOR).forEach(reference -> {
            CustomData customData = CustomData.EMPTY.update(registryOps, StoneTablet.VARIANT_MAP_CODEC, reference).getOrThrow().update(compoundTag -> compoundTag.putString("id", "fossilslegacy:stone_tablet"));
            ItemStack itemStack = new ItemStack(FAItems.STONE_TABLET.get());
            itemStack.set(DataComponents.ENTITY_DATA, customData);
            output.accept(itemStack, tabVisibility);
        });
    }
}
