package willatendo.fossilslegacy.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import willatendo.fossilslegacy.dual.FossilsLegacyDualEvents;
import willatendo.fossilslegacy.server.menu.FARecipeBookTypes;
import willatendo.fossilslegacy.server.recipe.FARecipeTypes;
import willatendo.fossilslegacy.server.recipe.recipes.AnalyzationRecipe;
import willatendo.fossilslegacy.server.recipe.recipes.ArchaeologyRecipe;
import willatendo.fossilslegacy.server.recipe.recipes.CultivationRecipe;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.client.event.registry.*;
import willatendo.simplelibrary.server.event.registry.ForgeClientReloadListenerRegister;

import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = FossilsLegacyUtils.ID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void fmlClientSetupEvent(FMLClientSetupEvent event) {
        FossilsLegacyClient.signSheets();
    }

    @SubscribeEvent
    public static void registerClientReloadListenersEvent(RegisterClientReloadListenersEvent event) {
        FossilsLegacyDualEvents.clientReloadListenersEvent(new ForgeClientReloadListenerRegister(event));
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
            AnalyzationRecipe analyzationRecipe = (AnalyzationRecipe) recipeHolder;
            switch (analyzationRecipe.analyzationBookCategory) {
                default:
                case MISC:
                    return FARecipeBookCategories.ANALYZATION_MISC;
            }
        });
        event.registerRecipeCategoryFinder(FARecipeTypes.ARCHAEOLOGY.get(), recipeHolder -> {
            ArchaeologyRecipe archaeologyRecipe = (ArchaeologyRecipe) recipeHolder;
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
        event.registerRecipeCategoryFinder(FARecipeTypes.CULTIVATION.get(), recipeHolder -> {
            CultivationRecipe cultivationRecipe = (CultivationRecipe) recipeHolder;
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

    @SubscribeEvent
    public static void registerKeyMappingsEvent(RegisterKeyMappingsEvent event) {
        FossilsLegacyClient.keyMappingEvent(new ForgeKeyMappingRegister(event));
    }

    @SubscribeEvent
    public static void entityRenderersEvent_RegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        FossilsLegacyClient.modelEvent(new ForgeModelRegister(event));
    }

    @SubscribeEvent
    public static void entityRenderersEvent_RegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        FossilsLegacyClient.modelLayerEvent(new ForgeModelLayerRegister(event));
    }

    @SubscribeEvent
    public static void registerMenuScreensEvent(FMLClientSetupEvent event) {
        FossilsLegacyClient.menuScreenEvent(new ForgeMenuScreenRegister(event));
    }

    @SubscribeEvent
    public static void registerColorHandlersEvent_Item(RegisterColorHandlersEvent.Item event) {
        FossilsLegacyClient.itemColorRegistry(new ForgeItemColorRegister(event));
    }

    @SubscribeEvent
    public static void registerColorHandlersEvent_Block(RegisterColorHandlersEvent.Block event) {
        FossilsLegacyClient.blockColorRegistry(new ForgeBlockColorRegister(event));
    }
}