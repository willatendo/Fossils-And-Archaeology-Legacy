package willatendo.fossilslegacy.client;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import willatendo.fossilslegacy.network.ForgePacketHelper;
import willatendo.fossilslegacy.network.ServerboundSinkPacket;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = FossilsLegacyUtils.ID, value = Dist.CLIENT)
public class ClientForgeEvents {
    @SubscribeEvent
    public static void inputEvent_key(InputEvent.Key event) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player != null) {
            if (FossilsLegacyKeys.SINK.isDown()) {
                ForgePacketHelper.sendToServer(new ServerboundSinkPacket(true));
            }
            if (!FossilsLegacyKeys.SINK.consumeClick()) {
                ForgePacketHelper.sendToServer(new ServerboundSinkPacket(false));
            }
        }
    }
}
