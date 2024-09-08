package willatendo.fossilslegacy.network;

import net.minecraftforge.network.ChannelBuilder;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.SimpleChannel;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class ForgePacketHelper {
    private static final SimpleChannel INSTANCE = ChannelBuilder.named(FossilsLegacyUtils.resource("main")).serverAcceptedVersions((status, version) -> true).clientAcceptedVersions((status, version) -> true).networkProtocolVersion(1).simpleChannel();

    public static void register() {
        INSTANCE.messageBuilder(ServerboundSinkPacket.class, NetworkDirection.PLAY_TO_SERVER).encoder(ServerboundSinkPacket::encode).decoder(ServerboundSinkPacket::decode).consumerMainThread((msg, context) -> ServerboundSinkPacket.handle(() -> context.getSender(), msg)).add();
        INSTANCE.messageBuilder(ServerboundTimeMachineUpdatePacket.class, NetworkDirection.PLAY_TO_CLIENT).encoder(ServerboundTimeMachineUpdatePacket::encode).decoder(ServerboundTimeMachineUpdatePacket::decode).consumerMainThread((msg, context) -> ServerboundTimeMachineUpdatePacket.handle(() -> context.getSender(), msg)).add();
    }

    public static void sendToServer(Object msg) {
        INSTANCE.send(msg, PacketDistributor.SERVER.noArg());
    }

    public static void sendToClient(Object msg) {
        INSTANCE.send(msg, PacketDistributor.ALL.noArg());
    }
}
