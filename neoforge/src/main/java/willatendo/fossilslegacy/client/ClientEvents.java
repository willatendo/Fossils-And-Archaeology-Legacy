package willatendo.fossilslegacy.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.client.event.NeoforgeKeyMappingRegister;
import willatendo.simplelibrary.client.event.NeoforgeMenuScreenRegister;
import willatendo.simplelibrary.client.event.NeoforgeModelLayerRegister;
import willatendo.simplelibrary.client.event.NeoforgeModelRegister;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = FossilsLegacyUtils.ID, value = Dist.CLIENT)
public class ClientEvents {
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
}
