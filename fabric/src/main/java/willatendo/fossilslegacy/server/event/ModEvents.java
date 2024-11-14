package willatendo.fossilslegacy.server.event;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.behavior.GiveGiftToHero;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.entity.FossilsLegacyVillagerProfessions;
import willatendo.fossilslegacy.server.feature.FossilsLegacyPlacedFeatures;
import willatendo.fossilslegacy.server.item.FossilsLegacyLootTables;
import willatendo.simplelibrary.server.event.modification.FabricCreativeModeTabModification;
import willatendo.simplelibrary.server.event.modification.FabricVillagerTradeModification;
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
        BasicEvents.compostablesSetup();

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Decoration.UNDERGROUND_ORES, FossilsLegacyPlacedFeatures.ORE_FOSSIL);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Decoration.UNDERGROUND_ORES, FossilsLegacyPlacedFeatures.ORE_PERMAFROST);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.HAS_OCEAN_RUIN_WARM), MobCategory.WATER_AMBIENT, FossilsLegacyEntityTypes.NAUTILUS.get(), 1, 1, 1);

        GiveGiftToHero.GIFTS.put(FossilsLegacyVillagerProfessions.ARCHAEOLOGIST.get(), FossilsLegacyLootTables.ARCHAEOLOGIST_GIFT);
        GiveGiftToHero.GIFTS.put(FossilsLegacyVillagerProfessions.PALAEONTOLOGIST.get(), FossilsLegacyLootTables.PALAEONTOLOGIST_GIFT);
    }
}
