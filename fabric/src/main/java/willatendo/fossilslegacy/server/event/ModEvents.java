package willatendo.fossilslegacy.server.event;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import willatendo.fossilslegacy.dual.FossilsLegacyDualEvents;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.feature.FossilsLegacyPlacedFeatures;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.simplelibrary.server.event.modification.FabricCreativeModeTabModification;
import willatendo.simplelibrary.server.event.registry.*;

public class ModEvents {
    public static void commonSetup() {
        BasicEvents.commonSetup();

        FossilsLegacyDualEvents.clientReloadListenersEvent(new FabricClientReloadListenerRegister());

        FabricCreativeModeTabModification fabricCreativeModeTabModification = new FabricCreativeModeTabModification();
        BasicEvents.buildCreativeModeTabEvent(fabricCreativeModeTabModification);
        fabricCreativeModeTabModification.build();
        BasicEvents.resourcePackEvent(new FabricResourcePackRegister());
        BasicEvents.attributeEvent(new FabricAttributeRegister());
        BasicEvents.spawnPlacementEvent(new FabricSpawnPlacementRegister());
        BasicEvents.newDynamicRegistryEvent(new FabricDynamicRegistryRegister());

        ComposterBlock.COMPOSTABLES.put(FossilsLegacyBlocks.JURASSIC_FERN.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(FossilsLegacyItems.JURASSIC_FERN_SPORES.get(), 0.65F);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Decoration.UNDERGROUND_ORES, FossilsLegacyPlacedFeatures.ORE_FOSSIL);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Decoration.UNDERGROUND_ORES, FossilsLegacyPlacedFeatures.ORE_PERMAFROST);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.HAS_OCEAN_RUIN_WARM), MobCategory.WATER_AMBIENT, FossilsLegacyEntityTypes.NAUTILUS.get(), 1, 1, 1);
    }

    public static void addToCreativeModeTabs() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.OP_BLOCKS).register(fabricItemGroupEntries -> {
            if (fabricItemGroupEntries.shouldShowOpRestrictedItems()) {
                fabricItemGroupEntries.accept(FossilsLegacyItems.DEBUG_MAX_HUNGER.get());
                fabricItemGroupEntries.accept(FossilsLegacyItems.DEBUG_MAX_HEALTH.get());
                fabricItemGroupEntries.accept(FossilsLegacyItems.DEBUG_FULL_GROWN.get());
                fabricItemGroupEntries.accept(FossilsLegacyItems.DEBUG_BABY.get());
                fabricItemGroupEntries.accept(FossilsLegacyItems.DEBUG_TAME.get());
                fabricItemGroupEntries.accept(FossilsLegacyItems.DEBUG_CHANGE_GENETICS.get());
            }
        });
    }
}
