package willatendo.fossilslegacy.client;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import willatendo.fossilslegacy.network.serverbound.ServerboundVehicleSinkPacket;
import willatendo.fossilslegacy.server.utils.FAUtils;


@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, modid = FAUtils.ID, value = Dist.CLIENT)
public class ClientForgeEvents {
    @SubscribeEvent
    public static void inputEvent_key(InputEvent.Key event) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player != null) {
            if (FAKeys.SINK.isDown()) {
                PacketDistributor.sendToServer(new ServerboundVehicleSinkPacket(true));
            }
            if (!FAKeys.SINK.consumeClick()) {
                PacketDistributor.sendToServer(new ServerboundVehicleSinkPacket(false));
            }
        }
    }
}
