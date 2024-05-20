package willatendo.fossilslegacy.server;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.entity.FossilsLegacyStoneTabletVariantTags;
import willatendo.fossilslegacy.server.entity.StoneTablet;
import willatendo.fossilslegacy.server.entity.StoneTabletVariant;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.item.MagicConchItem;
import willatendo.fossilslegacy.server.utils.DinosaurCommand;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class FossilsLegacyCreativeModeTabs {
    public static final SimpleRegistry<CreativeModeTab> CREATIVE_MODE_TABS = SimpleRegistry.create(Registries.CREATIVE_MODE_TAB, FossilsLegacyUtils.ID);
    private static final Comparator<Holder<StoneTabletVariant>> STONE_TABLET_COMPARATOR = Comparator.comparing(Holder::value, Comparator.<StoneTabletVariant>comparingInt(paintingVariant -> paintingVariant.height() * paintingVariant.width()).thenComparing(StoneTabletVariant::width));

    public static final SimpleHolder<CreativeModeTab> FOSSILS_LEGACY = CREATIVE_MODE_TABS.register("fossils_legacy", () -> SimpleUtils.create(FossilsLegacyUtils.ID, FossilsLegacyUtils.ID, () -> FossilsLegacyItems.FOSSIL.get(), (itemDisplayParameters, output) -> {
        output.accept(FossilsLegacyItems.FOSSIL.get());
        output.accept(FossilsLegacyItems.TRICERATOPS_DNA.get());
        output.accept(FossilsLegacyItems.VELOCIRAPTOR_DNA.get());
        output.accept(FossilsLegacyItems.TYRANNOSAURUS_DNA.get());
        output.accept(FossilsLegacyItems.PTERANODON_DNA.get());
        output.accept(FossilsLegacyItems.NAUTILUS_DNA.get());
        output.accept(FossilsLegacyItems.FUTABASAURUS_DNA.get());
        output.accept(FossilsLegacyItems.MOSASAURUS_DNA.get());
        output.accept(FossilsLegacyItems.STEGOSAURUS_DNA.get());
        output.accept(FossilsLegacyItems.DILOPHOSAURUS_DNA.get());
        output.accept(FossilsLegacyItems.BRACHIOSAURUS_DNA.get());
        output.accept(FossilsLegacyItems.CARNOTAURUS_DNA.get());
        output.accept(FossilsLegacyItems.CRYOLOPHOSAURUS_DNA.get());
        output.accept(FossilsLegacyItems.THERIZINOSAURUS_DNA.get());
        output.accept(FossilsLegacyItems.TRICERATOPS_EGG.get());
        output.accept(FossilsLegacyItems.VELOCIRAPTOR_EGG.get());
        output.accept(FossilsLegacyItems.TYRANNOSAURUS_EGG.get());
        output.accept(FossilsLegacyItems.PTERANODON_EGG.get());
        output.accept(FossilsLegacyItems.NAUTILUS_EGGS.get());
        output.accept(FossilsLegacyItems.FUTABASAURUS_EGG.get());
        output.accept(FossilsLegacyItems.MOSASAURUS_EGG.get());
        output.accept(FossilsLegacyItems.STEGOSAURUS_EGG.get());
        output.accept(FossilsLegacyItems.DILOPHOSAURUS_EGG.get());
        output.accept(FossilsLegacyItems.BRACHIOSAURUS_EGG.get());
        output.accept(FossilsLegacyItems.CARNOTAURUS_EGG.get());
        output.accept(FossilsLegacyItems.CRYOLOPHOSAURUS_EGG.get());
        output.accept(FossilsLegacyItems.THERIZINOSAURUS_EGG.get());
        output.accept(FossilsLegacyItems.RAW_TRICERATOPS_MEAT.get());
        output.accept(FossilsLegacyItems.RAW_VELOCIRAPTOR_MEAT.get());
        output.accept(FossilsLegacyItems.RAW_TYRANNOSAURUS_MEAT.get());
        output.accept(FossilsLegacyItems.RAW_PTERANODON_MEAT.get());
        output.accept(FossilsLegacyItems.NAUTILUS.get());
        output.accept(FossilsLegacyItems.RAW_FUTABASAURUS_MEAT.get());
        output.accept(FossilsLegacyItems.RAW_MOSASAURUS_MEAT.get());
        output.accept(FossilsLegacyItems.RAW_STEGOSAURUS_MEAT.get());
        output.accept(FossilsLegacyItems.RAW_DILOPHOSAURUS_MEAT.get());
        output.accept(FossilsLegacyItems.RAW_BRACHIOSAURUS_MEAT.get());
        output.accept(FossilsLegacyItems.RAW_SMILODON_MEAT.get());
        output.accept(FossilsLegacyItems.RAW_MAMMOTH_MEAT.get());
        output.accept(FossilsLegacyItems.RAW_CARNOTAURUS_MEAT.get());
        output.accept(FossilsLegacyItems.RAW_CRYOLOPHOSAURUS_MEAT.get());
        output.accept(FossilsLegacyItems.RAW_THERIZINOSAURUS_MEAT.get());
        output.accept(FossilsLegacyItems.COOKED_TRICERATOPS_MEAT.get());
        output.accept(FossilsLegacyItems.COOKED_VELOCIRAPTOR_MEAT.get());
        output.accept(FossilsLegacyItems.COOKED_TYRANNOSAURUS_MEAT.get());
        output.accept(FossilsLegacyItems.COOKED_PTERANODON_MEAT.get());
        output.accept(FossilsLegacyItems.SIO_CHIU_LE.get());
        output.accept(FossilsLegacyItems.COOKED_FUTABASAURUS_MEAT.get());
        output.accept(FossilsLegacyItems.COOKED_MOSASAURUS_MEAT.get());
        output.accept(FossilsLegacyItems.COOKED_STEGOSAURUS_MEAT.get());
        output.accept(FossilsLegacyItems.COOKED_DILOPHOSAURUS_MEAT.get());
        output.accept(FossilsLegacyItems.COOKED_BRACHIOSAURUS_MEAT.get());
        output.accept(FossilsLegacyItems.COOKED_SMILODON_MEAT.get());
        output.accept(FossilsLegacyItems.COOKED_MAMMOTH_MEAT.get());
        output.accept(FossilsLegacyItems.COOKED_CARNOTAURUS_MEAT.get());
        output.accept(FossilsLegacyItems.COOKED_CRYOLOPHOSAURUS_MEAT.get());
        output.accept(FossilsLegacyItems.COOKED_THERIZINOSAURUS_MEAT.get());
        output.accept(FossilsLegacyItems.TYRANNOSAURUS_TOOTH.get());
        output.accept(FossilsLegacyItems.TOOTH_DAGGER.get());
        output.accept(FossilsLegacyItems.THERIZINOSAURUS_CLAWS.get());
        output.accept(FossilsLegacyItems.SKULL_STICK.get());
        output.accept(FossilsLegacyItems.DINOPEDIA.get());
        output.accept(FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get());
        output.accept(FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get());
        output.accept(FossilsLegacyItems.CHICKEN_ESSENCE_BOTTLE.get());
        output.accept(FossilsLegacyItems.ROMANTIC_CONCOCTION_BOTTLE.get());
        output.accept(FossilsLegacyItems.NAUTILUS_SHELL.get());
        FossilsLegacyCreativeModeTabs.generateMagicConches(itemDisplayParameters, output);
        output.accept(FossilsLegacyItems.FROZEN_MEAT.get());
        output.accept(FossilsLegacyItems.AXOLOTL_DNA.get());
        output.accept(FossilsLegacyItems.CAT_DNA.get());
        output.accept(FossilsLegacyItems.CHICKEN_DNA.get());
        output.accept(FossilsLegacyItems.COW_DNA.get());
        output.accept(FossilsLegacyItems.DOLPHIN_DNA.get());
        output.accept(FossilsLegacyItems.DONKEY_DNA.get());
        output.accept(FossilsLegacyItems.FOX_DNA.get());
        output.accept(FossilsLegacyItems.FROG_DNA.get());
        output.accept(FossilsLegacyItems.GOAT_DNA.get());
        output.accept(FossilsLegacyItems.HORSE_DNA.get());
        output.accept(FossilsLegacyItems.LLAMA_DNA.get());
        output.accept(FossilsLegacyItems.MULE_DNA.get());
        output.accept(FossilsLegacyItems.OCELOT_DNA.get());
        output.accept(FossilsLegacyItems.PANDA_DNA.get());
        output.accept(FossilsLegacyItems.PARROT_DNA.get());
        output.accept(FossilsLegacyItems.PIG_DNA.get());
        output.accept(FossilsLegacyItems.POLAR_BEAR_DNA.get());
        output.accept(FossilsLegacyItems.RABBIT_DNA.get());
        output.accept(FossilsLegacyItems.SHEEP_DNA.get());
        output.accept(FossilsLegacyItems.WOLF_DNA.get());
        output.accept(FossilsLegacyItems.SMILODON_DNA.get());
        output.accept(FossilsLegacyItems.MAMMOTH_DNA.get());
        output.accept(FossilsLegacyItems.CAT_EMBRYO_SYRINGE.get());
        output.accept(FossilsLegacyItems.INCUBATED_CHICKEN_EGG.get());
        output.accept(FossilsLegacyItems.COW_EMBRYO_SYRINGE.get());
        output.accept(FossilsLegacyItems.DOLPHIN_EMBRYO_SYRINGE.get());
        output.accept(FossilsLegacyItems.DONKEY_EMBRYO_SYRINGE.get());
        output.accept(FossilsLegacyItems.FOX_EMBRYO_SYRINGE.get());
        output.accept(FossilsLegacyItems.GOAT_EMBRYO_SYRINGE.get());
        output.accept(FossilsLegacyItems.HORSE_EMBRYO_SYRINGE.get());
        output.accept(FossilsLegacyItems.LLAMA_EMBRYO_SYRINGE.get());
        output.accept(FossilsLegacyItems.MULE_EMBRYO_SYRINGE.get());
        output.accept(FossilsLegacyItems.OCELOT_EMBRYO_SYRINGE.get());
        output.accept(FossilsLegacyItems.PANDA_EMBRYO_SYRINGE.get());
        output.accept(FossilsLegacyItems.INCUBATED_PARROT_EGG.get());
        output.accept(FossilsLegacyItems.PIG_EMBRYO_SYRINGE.get());
        output.accept(FossilsLegacyItems.POLAR_BEAR_EMBRYO_SYRINGE.get());
        output.accept(FossilsLegacyItems.RABBIT_EMBRYO_SYRINGE.get());
        output.accept(FossilsLegacyItems.SHEEP_EMBRYO_SYRINGE.get());
        output.accept(FossilsLegacyItems.WOLF_EMBRYO_SYRINGE.get());
        output.accept(FossilsLegacyItems.SMILODON_EMBRYO_SYRINGE.get());
        output.accept(FossilsLegacyItems.MAMMOTH_EMBRYO_SYRINGE.get());
        output.accept(FossilsLegacyItems.JURASSIC_FERN_SPORES.get());
        output.accept(FossilsLegacyItems.RELIC_SCRAP.get());
        output.accept(FossilsLegacyItems.STONE_TABLET.get());
        FossilsLegacyCreativeModeTabs.generateStoneTabletVariants(itemDisplayParameters, output);
        output.accept(FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get());
        output.accept(FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get());
        output.accept(FossilsLegacyItems.ANCIENT_CHESTPLATE_ARTIFACT.get());
        output.accept(FossilsLegacyItems.ANCIENT_LEGGINGS_ARTIFACT.get());
        output.accept(FossilsLegacyItems.ANCIENT_BOOTS_ARTIFACT.get());
        output.accept(FossilsLegacyItems.SCARAB_GEM.get());
        output.accept(FossilsLegacyItems.ANCIENT_SWORD.get());
        output.accept(FossilsLegacyItems.ANCIENT_HELMET.get());
        output.accept(FossilsLegacyItems.ANCIENT_CHESTPLATE.get());
        output.accept(FossilsLegacyItems.ANCIENT_LEGGINGS.get());
        output.accept(FossilsLegacyItems.ANCIENT_BOOTS.get());
        output.accept(FossilsLegacyItems.SCARAB_GEM_SWORD.get());
        output.accept(FossilsLegacyItems.SCARAB_GEM_SHOVEL.get());
        output.accept(FossilsLegacyItems.SCARAB_GEM_PICKAXE.get());
        output.accept(FossilsLegacyItems.SCARAB_GEM_AXE.get());
        output.accept(FossilsLegacyItems.SCARAB_GEM_HOE.get());
        output.accept(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get());
        output.accept(FossilsLegacyItems.WOODEN_JAVELIN.get());
        output.accept(FossilsLegacyItems.STONE_JAVELIN.get());
        output.accept(FossilsLegacyItems.IRON_JAVELIN.get());
        output.accept(FossilsLegacyItems.GOLDEN_JAVELIN.get());
        output.accept(FossilsLegacyItems.DIAMOND_JAVELIN.get());
        output.accept(FossilsLegacyItems.NETHERITE_JAVELIN.get());
        output.accept(FossilsLegacyItems.SCARAB_GEM_JAVELIN.get());
        output.accept(FossilsLegacyItems.OVERWORLD_COIN.get());
        output.accept(FossilsLegacyItems.NETHER_COIN.get());
        output.accept(FossilsLegacyItems.PREHISTORIC_COIN.get());
        output.accept(FossilsLegacyItems.ANU_SPAWN_EGG.get());
        output.accept(FossilsLegacyItems.FAILURESAURUS_SPAWN_EGG.get());
        output.accept(FossilsLegacyItems.BRACHIOSAURUS_SPAWN_EGG.get());
        output.accept(FossilsLegacyItems.DILOPHOSAURUS_SPAWN_EGG.get());
        output.accept(FossilsLegacyItems.FUTABASAURUS_SPAWN_EGG.get());
        output.accept(FossilsLegacyItems.MAMMOTH_SPAWN_EGG.get());
        output.accept(FossilsLegacyItems.MOSASAURUS_SPAWN_EGG.get());
        output.accept(FossilsLegacyItems.NAUTILUS_SPAWN_EGG.get());
        output.accept(FossilsLegacyItems.PTERANODON_SPAWN_EGG.get());
        output.accept(FossilsLegacyItems.SMILODON_SPAWN_EGG.get());
        output.accept(FossilsLegacyItems.STEGOSAURUS_SPAWN_EGG.get());
        output.accept(FossilsLegacyItems.TRICERATOPS_SPAWN_EGG.get());
        output.accept(FossilsLegacyItems.TYRANNOSAURUS_SPAWN_EGG.get());
        output.accept(FossilsLegacyItems.VELOCIRAPTOR_SPAWN_EGG.get());
        output.accept(FossilsLegacyItems.CARNOTAURUS_SPAWN_EGG.get());
        output.accept(FossilsLegacyItems.CRYOLOPHOSAURUS_SPAWN_EGG.get());
        output.accept(FossilsLegacyItems.THERIZINOSAURUS_SPAWN_EGG.get());
        output.accept(FossilsLegacyBlocks.FOSSIL_ORE.get());
        output.accept(FossilsLegacyBlocks.DEEPSLATE_FOSSIL_ORE.get());
        output.accept(FossilsLegacyBlocks.SKULL_BLOCK.get());
        output.accept(FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get());
        output.accept(FossilsLegacyBlocks.ANALYZER.get());
        output.accept(FossilsLegacyBlocks.CULTIVATOR.get());
        output.accept(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get());
        output.accept(FossilsLegacyBlocks.JURASSIC_FERN.get());
        output.accept(FossilsLegacyBlocks.DRUM.get());
        output.accept(FossilsLegacyBlocks.FEEDER.get());
        output.accept(FossilsLegacyBlocks.PERMAFROST.get());
        output.accept(FossilsLegacyBlocks.ICED_STONE.get());
        output.accept(FossilsLegacyBlocks.AXOLOTLSPAWN.get());
        output.accept(FossilsLegacyBlocks.TIME_MACHINE.get());
    }).build());

    private static void generateMagicConches(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {
        for (DinosaurCommand dinosaurCommand : DinosaurCommand.values()) {
            ItemStack itemStack = new ItemStack(FossilsLegacyItems.MAGIC_CONCH.get());
            MagicConchItem.setOrder(itemStack, dinosaurCommand);
            output.accept(itemStack);
        }
    }

    private static void generateStoneTabletVariants(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {
        itemDisplayParameters.holders().lookup(FossilsLegacyRegistries.STONE_TABLET_VARIANTS).ifPresent(registryLookup -> FossilsLegacyCreativeModeTabs.generatePresetStoneTablets(output, registryLookup, holder -> holder.is(FossilsLegacyStoneTabletVariantTags.PLACEABLE), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
    }

    private static void generatePresetStoneTablets(CreativeModeTab.Output output, HolderLookup.RegistryLookup<StoneTabletVariant> registryLookup, Predicate<Holder<StoneTabletVariant>> predicate, CreativeModeTab.TabVisibility tabVisibility) {
        registryLookup.listElements().filter(predicate).sorted(STONE_TABLET_COMPARATOR).forEach(reference -> {
            ItemStack itemStack = new ItemStack(FossilsLegacyItems.STONE_TABLET.get());
            CompoundTag compoundTag = itemStack.getOrCreateTagElement("EntityTag");
            StoneTablet.storeVariant(compoundTag, reference);
            output.accept(itemStack, tabVisibility);
        });
    }

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(CREATIVE_MODE_TABS);
    }
}
