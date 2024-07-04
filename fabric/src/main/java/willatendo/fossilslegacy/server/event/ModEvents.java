package willatendo.fossilslegacy.server.event;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.stats.RecipeBookSettings;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.feature.FossilsLegacyPlacedFeatures;
import willatendo.fossilslegacy.server.inventory.FossilsLegacyRecipeBookTypes;
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

        ImmutableMap.Builder<RecipeBookType, Pair<String, String>> tagFields = ImmutableMap.<RecipeBookType, Pair<String, String>>builder().putAll(RecipeBookSettings.TAG_FIELDS);
        tagFields.put(FossilsLegacyRecipeBookTypes.ARCHAEOLOGY_WORKBENCH, Pair.of("isArchaeologyWorkbenchGuiOpen", "isArchaeologyWorkbenchFilteringCraftable"));
        tagFields.put(FossilsLegacyRecipeBookTypes.CULTIVATOR, Pair.of("isCultivatorGuiOpen", "isCultivatorFilteringCraftable"));
        tagFields.put(FossilsLegacyRecipeBookTypes.ANALYZER, Pair.of("isAnalyzerGuiOpen", "isAnalyzerFilteringCraftable"));
        RecipeBookSettings.TAG_FIELDS = tagFields.build();
    }

    public static void addToCreativeModeTabs() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.OP_BLOCKS).register(fabricItemGroupEntries -> {
            for (SimpleHolder<? extends Item> items : FossilsLegacyItems.DEBUG_ITEMS.getEntriesView()) {
                if ((fabricItemGroupEntries.shouldShowOpRestrictedItems())) {
                    fabricItemGroupEntries.accept(items.get());
                }
            }
        });
    }
}
