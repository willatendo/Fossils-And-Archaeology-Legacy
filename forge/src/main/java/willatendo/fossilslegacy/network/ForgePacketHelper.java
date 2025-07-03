package willatendo.fossilslegacy.network;

import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.ChannelBuilder;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.SimpleChannel;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class ForgePacketHelper {
    private static final SimpleChannel INSTANCE = ChannelBuilder.named(FAUtils.resource("main")).serverAcceptedVersions((status, version) -> true).clientAcceptedVersions((status, version) -> true).networkProtocolVersion(1).simpleChannel();

    public static void sendToServer(Object msg) {
        INSTANCE.send(msg, PacketDistributor.SERVER.noArg());
    }

    public static void sendToClient(Object msg) {
        INSTANCE.send(msg, PacketDistributor.ALL.noArg());
    }

    public static void sendToClient(ServerPlayer serverPlayer, Object msg) {
        INSTANCE.send(msg, PacketDistributor.PLAYER.with(serverPlayer));
    }
}
