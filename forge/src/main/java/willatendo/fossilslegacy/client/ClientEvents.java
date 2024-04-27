package willatendo.fossilslegacy.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = FossilsLegacyUtils.ID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        FossilsLegacyClient.bindScreens();
    }

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(FossilsLegacyKeys.SINK);
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        FossilsLegacyClient.loadModels();
        FossilsLegacyClient.ENTITY_MODEL_ENTRIES.forEach(entityModel -> {
            event.registerEntityRenderer(entityModel.entityType(), entityModel.entityRendererProvider());
        });
        FossilsLegacyClient.BLOCK_MODEL_ENTRIES.forEach(blockModel -> {
            event.registerBlockEntityRenderer(blockModel.blockEntityType(), blockModel.blockEntityRendererProvider());
        });
    }

    @SubscribeEvent
    public static void registerModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        FossilsLegacyClient.loadModelLayers();
        FossilsLegacyClient.MODEL_LAYER_ENTRIES.forEach(modelLayer -> {
            event.registerLayerDefinition(modelLayer.modelLayerLocation(), modelLayer.texturedModelDataProvider()::createModelData);
        });
    }
}
