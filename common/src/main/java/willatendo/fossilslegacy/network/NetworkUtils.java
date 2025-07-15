package willatendo.fossilslegacy.network;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import willatendo.fossilslegacy.platform.FAModloaderHelper;

public class NetworkUtils {
    public static void sendToClient(ServerPlayer serverPlayer, CustomPacketPayload customPacketPayload) {
        FAModloaderHelper.INSTANCE.sendToClient(serverPlayer, customPacketPayload);
    }

    public static void sendToServer(CustomPacketPayload customPacketPayload) {
        FAModloaderHelper.INSTANCE.sendToServer(customPacketPayload);
    }
}
