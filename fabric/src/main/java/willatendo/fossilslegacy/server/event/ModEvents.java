package willatendo.fossilslegacy.server.event;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import willatendo.fossilslegacy.client.resources.StoneTabletTextureManager;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.feature.FossilsLegacyPlacedFeatures;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.event.registry.FabricAttributeRegister;
import willatendo.simplelibrary.server.event.registry.FabricDynamicRegistryRegister;
import willatendo.simplelibrary.server.event.registry.FabricResourcePackRegister;
import willatendo.simplelibrary.server.event.registry.FabricSpawnPlacementRegister;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class ModEvents {
    public static void commonSetup() {
        BasicEvents.commonSetup();

        ResourceManagerHelper.get(PackType.CLIENT_RESOURCES).registerReloadListener(new IdentifiableResourceReloadListener() {
            @Override
            public ResourceLocation getFabricId() {
                return FossilsLegacyUtils.resource("stone_table_texture_manager");
            }

            @Override
            public CompletableFuture<Void> reload(PreparationBarrier preparationBarrier, ResourceManager resourceManager, ProfilerFiller profilerFiller, ProfilerFiller profilerFiller2, Executor executor, Executor executor2) {
                return StoneTabletTextureManager.INSTANCE.reload(preparationBarrier, resourceManager, profilerFiller, profilerFiller2, executor, executor2);
            }
        });

        ModEvents.addToCreativeModeTabs();

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
