package willatendo.fossilslegacy.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.event.network.CustomPayloadEvent;

public class ServerboundSinkPacket {
    private final boolean shouldSink;

    public ServerboundSinkPacket(boolean shouldSink) {
        this.shouldSink = shouldSink;
    }

    public ServerboundSinkPacket(FriendlyByteBuf friendlyByteBuf) {
        this.shouldSink = friendlyByteBuf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.shouldSink);
    }

    public boolean handle(CustomPayloadEvent.Context context) {
        context.enqueueWork(() -> {
            BasicPackets.serverboundSinkPacket(context.getSender(), this.shouldSink);
        });
        return true;
    }
}
