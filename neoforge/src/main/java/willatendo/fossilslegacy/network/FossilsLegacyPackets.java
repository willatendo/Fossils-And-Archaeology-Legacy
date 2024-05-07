package willatendo.fossilslegacy.network;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.PacketDistributor;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyPackets {
    public static final ResourceLocation TIME_MACHINE_UPDATE = FossilsLegacyUtils.resource("time_machine_update");
    public static final ResourceLocation SINK = FossilsLegacyUtils.resource("sink");

    public static <MSG extends CustomPacketPayload> void sendToServer(MSG message) {
        PacketDistributor.SERVER.noArg().send(message);
    }
}
