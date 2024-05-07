package willatendo.fossilslegacy.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.event.network.CustomPayloadEvent;

public class ServerboundTimeMachineUpdatePacket {
    private final BlockPos blockPos;
    private final boolean timeTravelling;

    public ServerboundTimeMachineUpdatePacket(BlockPos blockPos, boolean timeTravelling) {
        this.blockPos = blockPos;
        this.timeTravelling = timeTravelling;
    }

    public ServerboundTimeMachineUpdatePacket(FriendlyByteBuf friendlyByteBuf) {
        this.blockPos = friendlyByteBuf.readBlockPos();
        this.timeTravelling = friendlyByteBuf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBlockPos(this.blockPos);
        friendlyByteBuf.writeBoolean(this.timeTravelling);
    }

    public boolean handle(CustomPayloadEvent.Context context) {
        context.enqueueWork(() -> {
            BasicPackets.serverboundTimeMachineUpdatePacket(this.blockPos, this.timeTravelling, context.getSender().level());
        });
        return true;
    }
}
