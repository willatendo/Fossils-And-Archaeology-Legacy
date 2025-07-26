package willatendo.fossilslegacy.server.event;

import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.client.gui.screens.recipebook.RecipeCollection;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.crafting.ExtendedRecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import willatendo.fossilslegacy.client.FASearchRecipeBookCategory;
import willatendo.fossilslegacy.network.NetworkUtils;
import willatendo.fossilslegacy.network.ServerboundPacketRegistry;
import willatendo.fossilslegacy.network.clientbound.ClientboundRecipeContentPacket;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.feature.FAPlacedFeatures;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.event.modification.*;
import willatendo.simplelibrary.server.event.registry.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ModEvents {
    public static final Map<ExtendedRecipeBookCategory, List<RecipeCollection>> SEARCH_TABS = new HashMap<>();

    public static void commonSetup() {
        BasicEvents.commonSetup();

        ServerboundPacketRegistry.serverboundPacketSetup(new FabricServerboundPacketRegister());
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
        BasicEvents.idModification(new FabricIdModification(FAUtils.ID));
        for (FASearchRecipeBookCategory category : FASearchRecipeBookCategory.values()) {
            SEARCH_TABS.put(category, category.includedCategories().stream().flatMap(recipeBookCategory -> SEARCH_TABS.getOrDefault(category, List.of()).stream()).collect(ImmutableList.toImmutableList()));
        }

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Decoration.UNDERGROUND_ORES, FAPlacedFeatures.ORE_CENOZOIC_FOSSIL);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Decoration.UNDERGROUND_ORES, FAPlacedFeatures.ORE_MESOZOIC_FOSSIL);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Decoration.UNDERGROUND_ORES, FAPlacedFeatures.ORE_PALAEOZOIC_FOSSIL);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Decoration.UNDERGROUND_ORES, FAPlacedFeatures.ORE_PERMAFROST);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.HAS_OCEAN_RUIN_WARM), MobCategory.WATER_AMBIENT, FAEntityTypes.NAUTILUS.get(), 1, 1, 1);

        ServerLifecycleEvents.SERVER_STARTING.register(server -> BasicEvents.structurePoolModification(new FabricStructurePoolModification(server)));
        ServerLifecycleEvents.SYNC_DATA_PACK_CONTENTS.register((serverPlayer, b) -> NetworkUtils.sendToClient(serverPlayer, ClientboundRecipeContentPacket.create(Set.of(RecipeType.CRAFTING, RecipeType.SMELTING, RecipeType.SMOKING, RecipeType.BLASTING, RecipeType.SMITHING), serverPlayer.server.getRecipeManager().recipes)));
    }
}
