package willatendo.fossilslegacy.client;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import willatendo.fossilslegacy.network.ForgePacketHelper;
import willatendo.fossilslegacy.network.ServerboundSinkPacket;
import willatendo.fossilslegacy.server.utils.FAUtils;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = FAUtils.ID, value = Dist.CLIENT)
public class ClientForgeEvents {
    @SubscribeEvent
    public static void inputEvent_key(InputEvent.Key event) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player != null) {
            if (FAKeys.SINK.isDown()) {
                ForgePacketHelper.sendToServer(new ServerboundSinkPacket(true));
            }
            if (!FAKeys.SINK.consumeClick()) {
                ForgePacketHelper.sendToServer(new ServerboundSinkPacket(false));
            }
        }
    }
}
