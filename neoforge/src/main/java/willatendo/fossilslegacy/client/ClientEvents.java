package willatendo.fossilslegacy.client;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.*;
import willatendo.fossilslegacy.client.screen.SkullOverlayScreen;
import willatendo.fossilslegacy.dual.FossilsLegacyDualEvents;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.inventory.FossilsLegacyRecipeBookTypes;
import willatendo.fossilslegacy.server.recipe.AnalyzationRecipe;
import willatendo.fossilslegacy.server.recipe.ArchaeologyRecipe;
import willatendo.fossilslegacy.server.recipe.CultivationRecipe;
import willatendo.fossilslegacy.server.recipe.FossilsLegacyRecipeTypes;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.client.event.registry.NeoforgeKeyMappingRegister;
import willatendo.simplelibrary.client.event.registry.NeoforgeMenuScreenRegister;
import willatendo.simplelibrary.client.event.registry.NeoforgeModelLayerRegister;
import willatendo.simplelibrary.client.event.registry.NeoforgeModelRegister;
import willatendo.simplelibrary.server.event.registry.NeoforgeClientReloadListenerRegister;

import java.util.List;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = FossilsLegacyUtils.ID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void fmlClientSetupEvent(FMLClientSetupEvent event) {
        FossilsLegacyClient.signSheets();
    }

    @SubscribeEvent
    public static void registerClientReloadListenersEvent(RegisterClientReloadListenersEvent event) {
        FossilsLegacyDualEvents.clientReloadListenersEvent(new NeoforgeClientReloadListenerRegister(event));
    }

    @SubscribeEvent
    public static void registerRecipeBookCategoriesEvent(RegisterRecipeBookCategoriesEvent event) {
        event.registerBookCategories(FossilsLegacyRecipeBookTypes.ANALYZER, List.of(FossilsLegacyRecipeBookCategories.ANALYZATION_SEARCH, FossilsLegacyRecipeBookCategories.ANALYZATION_MISC));
        event.registerBookCategories(FossilsLegacyRecipeBookTypes.ARCHAEOLOGY_WORKBENCH, List.of(FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_SEARCH, FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_REPAIR, FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_RESTORE, FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_MISC));
        event.registerBookCategories(FossilsLegacyRecipeBookTypes.CULTIVATOR, List.of(FossilsLegacyRecipeBookCategories.CULTIVATION_SEARCH, FossilsLegacyRecipeBookCategories.CULTIVATION_EGGS, FossilsLegacyRecipeBookCategories.CULTIVATION_PLANTS, FossilsLegacyRecipeBookCategories.CULTIVATION_MISC));

        event.registerAggregateCategory(FossilsLegacyRecipeBookCategories.ANALYZATION_SEARCH, List.of(FossilsLegacyRecipeBookCategories.ANALYZATION_MISC));
        event.registerAggregateCategory(FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_SEARCH, List.of(FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_RESTORE, FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_REPAIR, FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_MISC));
        event.registerAggregateCategory(FossilsLegacyRecipeBookCategories.CULTIVATION_SEARCH, List.of(FossilsLegacyRecipeBookCategories.CULTIVATION_EGGS, FossilsLegacyRecipeBookCategories.CULTIVATION_PLANTS, FossilsLegacyRecipeBookCategories.CULTIVATION_MISC));

        event.registerRecipeCategoryFinder(FossilsLegacyRecipeTypes.ANALYZATION.get(), recipeHolder -> {
            AnalyzationRecipe analyzationRecipe = (AnalyzationRecipe) recipeHolder.value();
            switch (analyzationRecipe.analyzationBookCategory) {
                default:
                case MISC:
                    return FossilsLegacyRecipeBookCategories.ANALYZATION_MISC;
            }
        });
        event.registerRecipeCategoryFinder(FossilsLegacyRecipeTypes.ARCHAEOLOGY.get(), recipeHolder -> {
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
        event.registerRecipeCategoryFinder(FossilsLegacyRecipeTypes.CULTIVATION.get(), recipeHolder -> {
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

    @SubscribeEvent
    public static void registerGuiLayersEvent(RegisterGuiLayersEvent event) {
        event.registerBelow(FossilsLegacyUtils.mc("hotbar"), FossilsLegacyUtils.resource("skull_overlay"), new SkullOverlayScreen());
    }

    @SubscribeEvent
    public static void registerKeyMappingsEvent(RegisterKeyMappingsEvent event) {
        FossilsLegacyClient.keyMappingEvent(new NeoforgeKeyMappingRegister(event));
    }

    @SubscribeEvent
    public static void entityRenderersEvent_RegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        FossilsLegacyClient.modelEvent(new NeoforgeModelRegister(event));
    }

    @SubscribeEvent
    public static void entityRenderersEvent_RegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        FossilsLegacyClient.modelLayerEvent(new NeoforgeModelLayerRegister(event));
    }

    @SubscribeEvent
    public static void registerMenuScreensEvent(RegisterMenuScreensEvent event) {
        FossilsLegacyClient.menuScreenEvent(new NeoforgeMenuScreenRegister(event));
    }

    @SubscribeEvent
    public static void registerColorHandlersEvent_Item(RegisterColorHandlersEvent.Item event) {
        event.register((itemStack, tintIndex) -> {
            BlockState blockState = ((BlockItem) itemStack.getItem()).getBlock().defaultBlockState();
            return event.getBlockColors().getColor(blockState, null, null, tintIndex);
        }, FossilsLegacyBlocks.LEPIDODENDRON_LEAVES.get());
    }

    @SubscribeEvent
    public static void registerColorHandlersEvent_Block(RegisterColorHandlersEvent.Block event) {
        event.register((blockState, blockAndTintGetter, blockPos, tintIndex) -> blockAndTintGetter != null && blockPos != null ? BiomeColors.getAverageFoliageColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor(), FossilsLegacyBlocks.LEPIDODENDRON_LEAVES.get());
    }
}