package willatendo.pridelands.server.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import willatendo.pridelands.server.utils.PridelandsUtils;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = PridelandsUtils.ID)
public class ModEvents {
    @SubscribeEvent
    public static void fmlCommonSetupEvent(FMLCommonSetupEvent event) {
        BasicEvents.commonSetup();
    }
}
