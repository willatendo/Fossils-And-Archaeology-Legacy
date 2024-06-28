package willatendo.fossilslegacy.server.event;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.feature.FossilsLegacyPlacedFeatures;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.simplelibrary.server.event.FabricAttributeRegister;
import willatendo.simplelibrary.server.event.FabricResourcePackRegister;
import willatendo.simplelibrary.server.event.FabricSpawnPlacementRegister;
import willatendo.simplelibrary.server.registry.SimpleHolder;

public class ModEvents {
    public static void commonSetup() {
        BasicEvents.commonSetup();
        ModEvents.addToCreativeModeTabs();

        BasicEvents.resourcePackEvent(new FabricResourcePackRegister());
        BasicEvents.attributeEvent(new FabricAttributeRegister());
        BasicEvents.spawnPlacementEvent(new FabricSpawnPlacementRegister());

        ComposterBlock.COMPOSTABLES.put(FossilsLegacyBlocks.JURASSIC_FERN.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(FossilsLegacyItems.JURASSIC_FERN_SPORES.get(), 0.65F);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Decoration.UNDERGROUND_ORES, FossilsLegacyPlacedFeatures.ORE_FOSSIL);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Decoration.UNDERGROUND_ORES, FossilsLegacyPlacedFeatures.ORE_PERMAFROST);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.HAS_OCEAN_RUIN_WARM), MobCategory.WATER_AMBIENT, FossilsLegacyEntityTypes.NAUTILUS.get(), 1, 1, 1);
    }

    public static void addToCreativeModeTabs() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.OP_BLOCKS).register(fabricItemGroupEntries -> {
            for (SimpleHolder<? extends Item> items : FossilsLegacyItems.DEBUG_ITEMS.getEntriesView()) {
                if ((fabricItemGroupEntries.shouldShowOpRestrictedItems())) {
                    fabricItemGroupEntries.accept(items.get());
                }
            }
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.addAfter(Items.ALLAY_SPAWN_EGG, FossilsLegacyItems.ANU_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.BLAZE_SPAWN_EGG, FossilsLegacyItems.BRACHIOSAURUS_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.CAT_SPAWN_EGG, FossilsLegacyItems.CARNOTAURUS_SPAWN_EGG.get(), FossilsLegacyItems.CRYOLOPHOSAURUS_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.CREEPER_SPAWN_EGG, FossilsLegacyItems.DILOPHOSAURUS_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.EVOKER_SPAWN_EGG, FossilsLegacyItems.FAILURESAURUS_SPAWN_EGG.get(), FossilsLegacyItems.FUTABASAURUS_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.MAGMA_CUBE_SPAWN_EGG, FossilsLegacyItems.MAMMOTH_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.MOOSHROOM_SPAWN_EGG, FossilsLegacyItems.MOSASAURUS_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.MULE_SPAWN_EGG, FossilsLegacyItems.NAUTILUS_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.POLAR_BEAR_SPAWN_EGG, FossilsLegacyItems.PTERANODON_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.SLIME_SPAWN_EGG, FossilsLegacyItems.SMILODON_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.SQUID_SPAWN_EGG, FossilsLegacyItems.STEGOSAURUS_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.TADPOLE_SPAWN_EGG, FossilsLegacyItems.THERIZINOSAURUS_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.TRADER_LLAMA_SPAWN_EGG, FossilsLegacyItems.TRICERATOPS_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.TURTLE_SPAWN_EGG, FossilsLegacyItems.TYRANNOSAURUS_SPAWN_EGG.get(), FossilsLegacyItems.VELOCIRAPTOR_SPAWN_EGG.get());
        });
    }
}
