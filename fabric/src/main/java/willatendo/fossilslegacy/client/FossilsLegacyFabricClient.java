package willatendo.fossilslegacy.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.client.animation.json.JsonAnimationLoader;
import willatendo.fossilslegacy.client.model.json.JsonLayerDefinitionResourceManager;
import willatendo.fossilslegacy.client.model.json.JsonModelLoader;
import willatendo.fossilslegacy.client.render.TridentLikeItemRenderer;
import willatendo.fossilslegacy.client.resources.StoneTabletTextureManager;
import willatendo.fossilslegacy.network.ServerboundSinkPacket;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Futabasaurus;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.menu.FARecipeBookTypes;
import willatendo.fossilslegacy.server.recipe.FARecipeTypes;
import willatendo.fossilslegacy.server.recipe.recipes.AnalyzationRecipe;
import willatendo.fossilslegacy.server.recipe.recipes.ArchaeologyRecipe;
import willatendo.fossilslegacy.server.recipe.recipes.CultivationRecipe;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.client.event.registry.*;
import willatendo.simplelibrary.server.util.RecipeBookRegistry;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class FossilsLegacyFabricClient implements ClientModInitializer {
    public static final ModelResourceLocation THERIZINOSAURUS_2D = new ModelResourceLocation(FossilsLegacyUtils.resource("item/therizinosaurus_claws_gui"), "fabric_resource");
    public static final ModelResourceLocation THERIZINOSAURUS_3D = new ModelResourceLocation(FossilsLegacyUtils.resource("item/therizinosaurus_claws_in_hand"), "fabric_resource");

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


        ModelLoadingPlugin.register(context -> context.addModels(FossilsLegacyFabricClient.THERIZINOSAURUS_2D.id(), FossilsLegacyFabricClient.THERIZINOSAURUS_3D.id()));

        BuiltinItemRendererRegistry.INSTANCE.register(FAItems.ARTICULATED_FOSSIL.get(), FABlockEntityWithoutLevelRenderer.INSTANCE::renderByItem);
        BuiltinItemRendererRegistry.INSTANCE.register(FAItems.THERIZINOSAURUS_CLAWS.get(), new TridentLikeItemRenderer(FossilsLegacyFabricClient.THERIZINOSAURUS_2D, FossilsLegacyFabricClient.THERIZINOSAURUS_3D));

        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.JURASSIC_FERN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.AXOLOTLSPAWN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.CALAMITES_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.CALAMITES_LEAVES.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.CALAMITES_DOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.CALAMITES_TRAPDOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.POTTED_CALAMITES_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.LEPIDODENDRON_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.LEPIDODENDRON_LEAVES.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.LEPIDODENDRON_DOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.LEPIDODENDRON_TRAPDOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.POTTED_LEPIDODENDRON_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.SIGILLARIA_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.SIGILLARIA_LEAVES.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.SIGILLARIA_DOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.SIGILLARIA_TRAPDOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.POTTED_SIGILLARIA_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.WHITE_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.ORANGE_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.MAGENTA_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.LIGHT_BLUE_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.YELLOW_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.LIME_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.PINK_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.GRAY_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.LIGHT_GRAY_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.CYAN_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.PURPLE_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.BLUE_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.BROWN_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.GREEN_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.RED_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.BLACK_CULTIVATOR.get(), RenderType.translucent());

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
                        if (FAKeys.SINK.isDown()) {
                            ClientPlayNetworking.send(new ServerboundSinkPacket(true));
                        }
                        if (!FAKeys.SINK.consumeClick()) {
                            ClientPlayNetworking.send(new ServerboundSinkPacket(false));
                        }
                    }
                }
            }
        });

        RecipeBookRegistry.registerBookCategories(FARecipeBookTypes.ANALYZER, List.of(FARecipeBookCategories.ANALYZATION_SEARCH, FARecipeBookCategories.ANALYZATION_MISC));
        RecipeBookRegistry.registerBookCategories(FARecipeBookTypes.ARCHAEOLOGY_WORKBENCH, List.of(FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_SEARCH, FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_REPAIR, FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_RESTORE, FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_MISC));
        RecipeBookRegistry.registerBookCategories(FARecipeBookTypes.CULTIVATOR, List.of(FARecipeBookCategories.CULTIVATION_SEARCH, FARecipeBookCategories.CULTIVATION_EGGS, FARecipeBookCategories.CULTIVATION_PLANTS, FARecipeBookCategories.CULTIVATION_MISC));

        RecipeBookRegistry.registerAggregateCategory(FARecipeBookCategories.ANALYZATION_SEARCH, List.of(FARecipeBookCategories.ANALYZATION_MISC));
        RecipeBookRegistry.registerAggregateCategory(FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_SEARCH, List.of(FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_RESTORE, FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_REPAIR, FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_MISC));
        RecipeBookRegistry.registerAggregateCategory(FARecipeBookCategories.CULTIVATION_SEARCH, List.of(FARecipeBookCategories.CULTIVATION_EGGS, FARecipeBookCategories.CULTIVATION_PLANTS, FARecipeBookCategories.CULTIVATION_MISC));

        RecipeBookRegistry.registerRecipeCategoryFinder(FARecipeTypes.ANALYZATION.get(), recipeHolder -> {
            AnalyzationRecipe analyzationRecipe = (AnalyzationRecipe) recipeHolder.value();
            switch (analyzationRecipe.analyzationBookCategory) {
                default:
                case MISC:
                    return FARecipeBookCategories.ANALYZATION_MISC;
            }
        });
        RecipeBookRegistry.registerRecipeCategoryFinder(FARecipeTypes.ARCHAEOLOGY.get(), recipeHolder -> {
            ArchaeologyRecipe archaeologyRecipe = (ArchaeologyRecipe) recipeHolder.value();
            switch (archaeologyRecipe.archaeologyBookCategory) {
                case RESTORE:
                    return FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_RESTORE;
                case REPAIR:
                    return FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_REPAIR;
                default:
                case MISC:
                    return FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_MISC;
            }
        });
        RecipeBookRegistry.registerRecipeCategoryFinder(FARecipeTypes.CULTIVATION.get(), recipeHolder -> {
            CultivationRecipe cultivationRecipe = (CultivationRecipe) recipeHolder.value();
            switch (cultivationRecipe.cultivationBookCategory) {
                case EGG:
                    return FARecipeBookCategories.CULTIVATION_EGGS;
                case PLANT:
                    return FARecipeBookCategories.CULTIVATION_PLANTS;
                default:
                case MISC:
                    return FARecipeBookCategories.CULTIVATION_MISC;
            }
        });
    }
}
