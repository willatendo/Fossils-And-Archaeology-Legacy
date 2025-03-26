package willatendo.fossilslegacy.client;

import net.minecraft.client.renderer.special.SpecialModelRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import willatendo.fossilslegacy.dual.FossilsLegacyDualEvents;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.client.event.registry.*;
import willatendo.simplelibrary.server.event.registry.ForgeClientReloadListenerRegister;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = FAUtils.ID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void fmlClientSetupEvent(FMLClientSetupEvent event) {
        FossilsLegacyClient.signSheets();
        FossilsLegacyClient.specialModelsEvent(SpecialModelRenderers.ID_MAPPER::put);
    }

    @SubscribeEvent
    public static void registerClientReloadListenersEvent(RegisterClientReloadListenersEvent event) {
        FossilsLegacyDualEvents.clientReloadListenersEvent(new ForgeClientReloadListenerRegister(event));
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
    public static void registerColorHandlersEvent_Block(RegisterColorHandlersEvent.Block event) {
        FossilsLegacyClient.blockColorRegistry(new ForgeBlockColorRegister(event));
    }
}