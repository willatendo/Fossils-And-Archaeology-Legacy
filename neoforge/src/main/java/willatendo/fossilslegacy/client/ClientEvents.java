package willatendo.fossilslegacy.client;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = FossilsLegacyUtils.ID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void skullOverlay(RegisterGuiLayersEvent event) {
        event.registerBelow(FossilsLegacyUtils.mc("hotbar"), FossilsLegacyUtils.resource("skull_overlay"), new SkullOverlayScreen());
    }

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(FossilsLegacyKeys.SINK);
    }

    @SubscribeEvent
    public static void screens(RegisterMenuScreensEvent event) {
        FossilsLegacyClient.bindScreens();
        FossilsLegacyClient.CLIENT_EVENTS_HOLDER.registerAllMenuScreens(menuScreen -> {
            event.register(menuScreen.menuType(), menuScreen.screenConstructor());
        });
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        FossilsLegacyClient.loadModels();
        FossilsLegacyClient.CLIENT_EVENTS_HOLDER.registerAllEntityModels(entityModel -> {
            event.registerEntityRenderer(entityModel.entityType(), entityModel.entityRendererProvider());
        });
        FossilsLegacyClient.CLIENT_EVENTS_HOLDER.registerAllBlockModels(blockModel -> {
            event.registerBlockEntityRenderer(blockModel.blockEntityType(), blockModel.blockEntityRendererProvider());
        });
    }

    @SubscribeEvent
    public static void registerModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        FossilsLegacyClient.loadModelLayers();
        FossilsLegacyClient.CLIENT_EVENTS_HOLDER.registerAllModelLayers(modelLayer -> {
            event.registerLayerDefinition(modelLayer.modelLayerLocation(), modelLayer.texturedModelDataProvider()::createModelData);
        });
    }
}
