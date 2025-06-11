package willatendo.pridelands.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import willatendo.pridelands.server.utils.PridelandsUtils;
import willatendo.simplelibrary.client.event.registry.NeoforgeParticleRegistry;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = PridelandsUtils.ID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void registerParticleProvidersEvent(RegisterParticleProvidersEvent event) {
        ToThePridelandsClient.particleRegisterEvent(new NeoforgeParticleRegistry(event));
    }
}
