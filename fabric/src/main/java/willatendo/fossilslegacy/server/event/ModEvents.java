package willatendo.fossilslegacy.server.event;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.feature.FossilsLegacyPlacedFeatures;
import willatendo.simplelibrary.server.event.modification.*;
import willatendo.simplelibrary.server.event.registry.FabricAttributeRegister;
import willatendo.simplelibrary.server.event.registry.FabricDynamicRegistryRegister;
import willatendo.simplelibrary.server.event.registry.FabricResourcePackRegister;
import willatendo.simplelibrary.server.event.registry.FabricSpawnPlacementRegister;

public class ModEvents {
    public static void commonSetup() {
        BasicEvents.commonSetup();

        FabricCreativeModeTabModification fabricCreativeModeTabModification = new FabricCreativeModeTabModification();
        BasicEvents.buildCreativeModeTabEvent(fabricCreativeModeTabModification);
        fabricCreativeModeTabModification.build();
        BasicEvents.villagerTradesEvent(new FabricVillagerTradeModification());
        BasicEvents.resourcePackEvent(new FabricResourcePackRegister());
        BasicEvents.attributeEvent(new FabricAttributeRegister());
        BasicEvents.spawnPlacementEvent(new FabricSpawnPlacementRegister());
        BasicEvents.newDynamicRegistryEvent(new FabricDynamicRegistryRegister());
        BasicEvents.strippablesSetup(new FabricStrippablesModification());
        BasicEvents.compostablesSetup(new FabricCompostablesModification());
        BasicEvents.heroOfTheVillageGiftSetup(new FabricHeroOfTheVillageGiftModification());
        BasicEvents.oxidationSetup(new FabricOxidationModification());
        BasicEvents.waxableSetup(new FabricWaxableModification());

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Decoration.UNDERGROUND_ORES, FossilsLegacyPlacedFeatures.ORE_FOSSIL);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Decoration.UNDERGROUND_ORES, FossilsLegacyPlacedFeatures.ORE_PERMAFROST);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.HAS_OCEAN_RUIN_WARM), MobCategory.WATER_AMBIENT, FossilsLegacyEntityTypes.NAUTILUS.get(), 1, 1, 1);

        ServerLifecycleEvents.SERVER_STARTING.register(server -> BasicEvents.structurePoolModification(new FabricStructurePoolModification(server)));
    }
}
