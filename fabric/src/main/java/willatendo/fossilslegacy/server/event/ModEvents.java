package willatendo.fossilslegacy.server.event;

import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.client.gui.screens.recipebook.RecipeCollection;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.crafting.ExtendedRecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import willatendo.fossilslegacy.client.FASearchRecipeBookCategory;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.feature.FAPlacedFeatures;
import willatendo.simplelibrary.server.event.modification.*;
import willatendo.simplelibrary.server.event.registry.FabricAttributeRegister;
import willatendo.simplelibrary.server.event.registry.FabricDynamicRegistryRegister;
import willatendo.simplelibrary.server.event.registry.FabricResourcePackRegister;
import willatendo.simplelibrary.server.event.registry.FabricSpawnPlacementRegister;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ModEvents {
    public static final Map<ExtendedRecipeBookCategory, List<RecipeCollection>> SEARCH_TABS = new HashMap<>();

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
        for (FASearchRecipeBookCategory category : FASearchRecipeBookCategory.values()) {
            SEARCH_TABS.put(category, category.includedCategories().stream().flatMap(recipeBookCategory -> SEARCH_TABS.getOrDefault(category, List.of()).stream()).collect(ImmutableList.toImmutableList()));
        }

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Decoration.UNDERGROUND_ORES, FAPlacedFeatures.ORE_FOSSIL);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Decoration.UNDERGROUND_ORES, FAPlacedFeatures.ORE_PERMAFROST);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.HAS_OCEAN_RUIN_WARM), MobCategory.WATER_AMBIENT, FAEntityTypes.NAUTILUS.get(), 1, 1, 1);

        ServerLifecycleEvents.SERVER_STARTING.register(server -> BasicEvents.structurePoolModification(new FabricStructurePoolModification(server)));
    }
}
