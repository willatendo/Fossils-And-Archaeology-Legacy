package willatendo.fossilslegacy.client;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.stats.RecipeBookSettings;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.RecipeBookType;
import willatendo.fossilslegacy.client.animation.json.JsonAnimationLoader;
import willatendo.fossilslegacy.client.model.json.JsonLayerDefinitionResourceManager;
import willatendo.fossilslegacy.client.model.json.JsonModelLoader;
import willatendo.fossilslegacy.client.resources.StoneTabletTextureManager;
import willatendo.fossilslegacy.network.ServerboundSinkPacket;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.entity.dinosaur.cretaceous.Futabasaurus;
import willatendo.fossilslegacy.server.inventory.FossilsLegacyRecipeBookTypes;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.recipe.AnalyzationRecipe;
import willatendo.fossilslegacy.server.recipe.ArchaeologyRecipe;
import willatendo.fossilslegacy.server.recipe.CultivationRecipe;
import willatendo.fossilslegacy.server.recipe.FossilsLegacyRecipeTypes;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.client.event.registry.*;
import willatendo.simplelibrary.server.util.RecipeBookRegistry;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class FossilsLegacyFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ResourceManagerHelper resourceManagerHelper = ResourceManagerHelper.get(PackType.CLIENT_RESOURCES);
        resourceManagerHelper.registerReloadListener(new IdentifiableResourceReloadListener() {
            @Override
            public ResourceLocation getFabricId() {
                return FossilsLegacyUtils.resource("stone_table_texture_manager");
            }

            @Override
            public CompletableFuture<Void> reload(PreparationBarrier preparationBarrier, ResourceManager resourceManager, ProfilerFiller preparationsProfiler, ProfilerFiller reloadProfiler, Executor backgroundExecutor, Executor gameExecutor) {
                return StoneTabletTextureManager.INSTANCE.reload(preparationBarrier, resourceManager, preparationsProfiler, reloadProfiler, backgroundExecutor, gameExecutor);
            }
        });
        resourceManagerHelper.registerReloadListener(new IdentifiableResourceReloadListener() {
            @Override
            public ResourceLocation getFabricId() {
                return FossilsLegacyUtils.resource("json_models_loader");
            }

            @Override
            public CompletableFuture<Void> reload(PreparationBarrier preparationBarrier, ResourceManager resourceManager, ProfilerFiller preparationsProfiler, ProfilerFiller reloadProfiler, Executor backgroundExecutor, Executor gameExecutor) {
                return JsonModelLoader.INSTANCE.reload(preparationBarrier, resourceManager, preparationsProfiler, reloadProfiler, backgroundExecutor, gameExecutor);
            }
        });
        resourceManagerHelper.registerReloadListener(new IdentifiableResourceReloadListener() {
            @Override
            public ResourceLocation getFabricId() {
                return FossilsLegacyUtils.resource("json_animations_loader");
            }

            @Override
            public CompletableFuture<Void> reload(PreparationBarrier preparationBarrier, ResourceManager resourceManager, ProfilerFiller preparationsProfiler, ProfilerFiller reloadProfiler, Executor backgroundExecutor, Executor gameExecutor) {
                return JsonAnimationLoader.INSTANCE.reload(preparationBarrier, resourceManager, preparationsProfiler, reloadProfiler, backgroundExecutor, gameExecutor);
            }
        });
        resourceManagerHelper.registerReloadListener(new IdentifiableResourceReloadListener() {
            @Override
            public ResourceLocation getFabricId() {
                return FossilsLegacyUtils.resource("json_layers_loader");
            }

            @Override
            public CompletableFuture<Void> reload(PreparationBarrier preparationBarrier, ResourceManager resourceManager, ProfilerFiller preparationsProfiler, ProfilerFiller reloadProfiler, Executor backgroundExecutor, Executor gameExecutor) {
                return JsonLayerDefinitionResourceManager.INSTANCE.reload(preparationBarrier, resourceManager, preparationsProfiler, reloadProfiler, backgroundExecutor, gameExecutor);
            }
        });

        BuiltinItemRendererRegistry.INSTANCE.register(FossilsLegacyItems.ARTICULATED_FOSSIL.get(), FossilsLegacyBlockEntityWithoutLevelRenderer.INSTANCE::renderByItem);

        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.JURASSIC_FERN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.AXOLOTLSPAWN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.LEPIDODENDRON_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.LEPIDODENDRON_LEAVES.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.LEPIDODENDRON_DOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.LEPIDODENDRON_TRAPDOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.POTTED_LEPIDODENDRON_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.SIGILLARIA_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.SIGILLARIA_LEAVES.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.POTTED_SIGILLARIA_SAPLING.get(), RenderType.cutout());

        FossilsLegacyClient.itemColorRegistry(new FabricItemColorRegister());
        FossilsLegacyClient.blockColorRegistry(new FabricBlockColorRegister());

        FossilsLegacyClient.signSheets();

        FossilsLegacyClient.keyMappingEvent(new FabricKeyMappingRegister());

        FossilsLegacyClient.modelLayerEvent(new FabricModelLayerRegister());

        FossilsLegacyClient.modelEvent(new FabricModelRegister());

        FossilsLegacyClient.menuScreenEvent(new FabricMenuScreenRegister());

        ClientTickEvents.END_CLIENT_TICK.register(minecraft -> {
            Player player = minecraft.player;
            if (player != null) {
                if (player.isPassenger()) {
                    if (player.getVehicle() instanceof Futabasaurus) {
                        if (FossilsLegacyKeys.SINK.isDown()) {
                            ClientPlayNetworking.send(new ServerboundSinkPacket(true));
                        }
                        if (!FossilsLegacyKeys.SINK.consumeClick()) {
                            ClientPlayNetworking.send(new ServerboundSinkPacket(false));
                        }
                    }
                }
            }
        });

        RecipeBookRegistry.registerBookCategories(FossilsLegacyRecipeBookTypes.ANALYZER, List.of(FossilsLegacyRecipeBookCategories.ANALYZATION_SEARCH, FossilsLegacyRecipeBookCategories.ANALYZATION_MISC));
        RecipeBookRegistry.registerBookCategories(FossilsLegacyRecipeBookTypes.ARCHAEOLOGY_WORKBENCH, List.of(FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_SEARCH, FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_REPAIR, FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_RESTORE, FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_MISC));
        RecipeBookRegistry.registerBookCategories(FossilsLegacyRecipeBookTypes.CULTIVATOR, List.of(FossilsLegacyRecipeBookCategories.CULTIVATION_SEARCH, FossilsLegacyRecipeBookCategories.CULTIVATION_EGGS, FossilsLegacyRecipeBookCategories.CULTIVATION_PLANTS, FossilsLegacyRecipeBookCategories.CULTIVATION_MISC));

        RecipeBookRegistry.registerAggregateCategory(FossilsLegacyRecipeBookCategories.ANALYZATION_SEARCH, List.of(FossilsLegacyRecipeBookCategories.ANALYZATION_MISC));
        RecipeBookRegistry.registerAggregateCategory(FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_SEARCH, List.of(FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_RESTORE, FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_REPAIR, FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_MISC));
        RecipeBookRegistry.registerAggregateCategory(FossilsLegacyRecipeBookCategories.CULTIVATION_SEARCH, List.of(FossilsLegacyRecipeBookCategories.CULTIVATION_EGGS, FossilsLegacyRecipeBookCategories.CULTIVATION_PLANTS, FossilsLegacyRecipeBookCategories.CULTIVATION_MISC));

        RecipeBookRegistry.registerRecipeCategoryFinder(FossilsLegacyRecipeTypes.ANALYZATION.get(), recipeHolder -> {
            AnalyzationRecipe analyzationRecipe = (AnalyzationRecipe) recipeHolder.value();
            switch (analyzationRecipe.analyzationBookCategory) {
                default:
                case MISC:
                    return FossilsLegacyRecipeBookCategories.ANALYZATION_MISC;
            }
        });
        RecipeBookRegistry.registerRecipeCategoryFinder(FossilsLegacyRecipeTypes.ARCHAEOLOGY.get(), recipeHolder -> {
            ArchaeologyRecipe archaeologyRecipe = (ArchaeologyRecipe) recipeHolder.value();
            switch (archaeologyRecipe.archaeologyBookCategory) {
                case RESTORE:
                    return FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_RESTORE;
                case REPAIR:
                    return FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_REPAIR;
                default:
                case MISC:
                    return FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_MISC;
            }
        });
        RecipeBookRegistry.registerRecipeCategoryFinder(FossilsLegacyRecipeTypes.CULTIVATION.get(), recipeHolder -> {
            CultivationRecipe cultivationRecipe = (CultivationRecipe) recipeHolder.value();
            switch (cultivationRecipe.cultivationBookCategory) {
                case EGG:
                    return FossilsLegacyRecipeBookCategories.CULTIVATION_EGGS;
                case PLANT:
                    return FossilsLegacyRecipeBookCategories.CULTIVATION_PLANTS;
                default:
                case MISC:
                    return FossilsLegacyRecipeBookCategories.CULTIVATION_MISC;
            }
        });
    }
}
