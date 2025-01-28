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
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.menu.FARecipeBookTypes;
import willatendo.fossilslegacy.server.recipe.FARecipeTypes;
import willatendo.fossilslegacy.server.recipe.recipes.AnalyzationRecipe;
import willatendo.fossilslegacy.server.recipe.recipes.ArchaeologyRecipe;
import willatendo.fossilslegacy.server.recipe.recipes.CultivationRecipe;
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
    public static void registerClientExtensionsEvent(RegisterClientExtensionsEvent event) {
        event.registerItem(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return FABlockEntityWithoutLevelRenderer.INSTANCE;
            }
        }, FAItems.ARTICULATED_FOSSIL.get());
    }

    @SubscribeEvent
    public static void registerRecipeBookCategoriesEvent(RegisterRecipeBookCategoriesEvent event) {
        event.registerBookCategories(FARecipeBookTypes.ANALYZER, List.of(FARecipeBookCategories.ANALYZATION_SEARCH, FARecipeBookCategories.ANALYZATION_MISC));
        event.registerBookCategories(FARecipeBookTypes.ARCHAEOLOGY_WORKBENCH, List.of(FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_SEARCH, FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_REPAIR, FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_RESTORE, FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_MISC));
        event.registerBookCategories(FARecipeBookTypes.CULTIVATOR, List.of(FARecipeBookCategories.CULTIVATION_SEARCH, FARecipeBookCategories.CULTIVATION_EGGS, FARecipeBookCategories.CULTIVATION_PLANTS, FARecipeBookCategories.CULTIVATION_MISC));

        event.registerAggregateCategory(FARecipeBookCategories.ANALYZATION_SEARCH, List.of(FARecipeBookCategories.ANALYZATION_MISC));
        event.registerAggregateCategory(FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_SEARCH, List.of(FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_RESTORE, FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_REPAIR, FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_MISC));
        event.registerAggregateCategory(FARecipeBookCategories.CULTIVATION_SEARCH, List.of(FARecipeBookCategories.CULTIVATION_EGGS, FARecipeBookCategories.CULTIVATION_PLANTS, FARecipeBookCategories.CULTIVATION_MISC));

        event.registerRecipeCategoryFinder(FARecipeTypes.ANALYZATION.get(), recipeHolder -> {
            AnalyzationRecipe analyzationRecipe = (AnalyzationRecipe) recipeHolder.value();
            return switch (analyzationRecipe.analyzationBookCategory) {
                default -> FARecipeBookCategories.ANALYZATION_MISC;
            };
        });
        event.registerRecipeCategoryFinder(FARecipeTypes.ARCHAEOLOGY.get(), recipeHolder -> {
            ArchaeologyRecipe archaeologyRecipe = (ArchaeologyRecipe) recipeHolder.value();
            return switch (archaeologyRecipe.archaeologyBookCategory) {
                case RESTORE -> FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_RESTORE;
                case REPAIR -> FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_REPAIR;
                default -> FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_MISC;
            };
        });
        event.registerRecipeCategoryFinder(FARecipeTypes.CULTIVATION.get(), recipeHolder -> {
            CultivationRecipe cultivationRecipe = (CultivationRecipe) recipeHolder.value();
            return switch (cultivationRecipe.cultivationBookCategory) {
                case EGG -> FARecipeBookCategories.CULTIVATION_EGGS;
                case PLANT -> FARecipeBookCategories.CULTIVATION_PLANTS;
                default -> FARecipeBookCategories.CULTIVATION_MISC;
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