package willatendo.fossilslegacy.network;

import net.minecraftforge.network.*;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyPackets {
    public static final SimpleChannel INSTANCE = ChannelBuilder.named(FossilsLegacyUtils.resource("main")).serverAcceptedVersions(((status, version) -> true)).clientAcceptedVersions(((status, version) -> true)).networkProtocolVersion(1).simpleChannel();

    private static int packetId = 0;

    private static int getId() {
        return packetId++;
    }

    public static void registerPackets() {
        INSTANCE.messageBuilder(ServerboundTimeMachineUpdatePacket.class, getId(), NetworkDirection.PLAY_TO_SERVER).decoder(ServerboundTimeMachineUpdatePacket::new).encoder(ServerboundTimeMachineUpdatePacket::toBytes).consumerMainThread(ServerboundTimeMachineUpdatePacket::handle).add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.send(message, PacketDistributor.SERVER.noArg());
    }
}
