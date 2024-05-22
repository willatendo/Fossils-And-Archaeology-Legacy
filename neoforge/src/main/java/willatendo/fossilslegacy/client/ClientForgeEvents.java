package willatendo.fossilslegacy.client;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.InputEvent;
import willatendo.fossilslegacy.network.FossilsLegacyPackets;
import willatendo.fossilslegacy.network.ServerboundSinkPacket;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = FossilsLegacyUtils.ID, value = Dist.CLIENT)
public class ClientForgeEvents {
    @SubscribeEvent
    public static void keyEvents(InputEvent.Key event) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player != null) {
            if (FossilsLegacyKeys.SINK.isDown()) {
                FossilsLegacyPackets.sendToServer(new ServerboundSinkPacket(true));
            }
            if (FossilsLegacyKeys.SINK.consumeClick() == false) {
                FossilsLegacyPackets.sendToServer(new ServerboundSinkPacket(false));
            }
        }
    }
}
