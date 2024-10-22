package willatendo.fossilslegacy.client;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import willatendo.fossilslegacy.client.screen.SkullOverlayScreen;
import willatendo.fossilslegacy.dual.FossilsLegacyDualEvents;
import willatendo.fossilslegacy.server.inventory.FossilsLegacyRecipeBookTypes;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.recipe.AnalyzationRecipe;
import willatendo.fossilslegacy.server.recipe.ArchaeologyRecipe;
import willatendo.fossilslegacy.server.recipe.CultivationRecipe;
import willatendo.fossilslegacy.server.recipe.FossilsLegacyRecipeTypes;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.client.event.registry.*;
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
            return switch (analyzationRecipe.analyzationBookCategory) {
                default -> FossilsLegacyRecipeBookCategories.ANALYZATION_MISC;
            };
        });
        event.registerRecipeCategoryFinder(FossilsLegacyRecipeTypes.ARCHAEOLOGY.get(), recipeHolder -> {
            ArchaeologyRecipe archaeologyRecipe = (ArchaeologyRecipe) recipeHolder.value();
            return switch (archaeologyRecipe.archaeologyBookCategory) {
                case RESTORE -> FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_RESTORE;
                case REPAIR -> FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_REPAIR;
                default -> FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_MISC;
            };
        });
        event.registerRecipeCategoryFinder(FossilsLegacyRecipeTypes.CULTIVATION.get(), recipeHolder -> {
            CultivationRecipe cultivationRecipe = (CultivationRecipe) recipeHolder.value();
            return switch (cultivationRecipe.cultivationBookCategory) {
                case EGG -> FossilsLegacyRecipeBookCategories.CULTIVATION_EGGS;
                case PLANT -> FossilsLegacyRecipeBookCategories.CULTIVATION_PLANTS;
                default -> FossilsLegacyRecipeBookCategories.CULTIVATION_MISC;
            };
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
        FossilsLegacyClient.itemColorRegistry(new NeoforgeItemColorRegister(event));
    }

    @SubscribeEvent
    public static void registerColorHandlersEvent_Block(RegisterColorHandlersEvent.Block event) {
        FossilsLegacyClient.blockColorRegistry(new NeoforgeBlockColorRegister(event));
    }
}