package willatendo.fossilslegacy.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import willatendo.fossilslegacy.network.FossilsLegacyPackets;
import willatendo.fossilslegacy.network.ServerboundSinkPacket;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = FossilsLegacyUtils.ID, value = Dist.CLIENT)
public class ClientForgeEvents {
    @SubscribeEvent
    public static void keyEvents(InputEvent.Key event) {
        if (FossilsLegacyKeys.SINK.isDown()) {
            FossilsLegacyPackets.sendToServer(new ServerboundSinkPacket(true));
        }
        if (FossilsLegacyKeys.SINK.consumeClick() == false) {
            FossilsLegacyPackets.sendToServer(new ServerboundSinkPacket(false));
        }
    }
}
