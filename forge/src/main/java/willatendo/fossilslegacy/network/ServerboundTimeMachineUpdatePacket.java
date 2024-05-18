package willatendo.fossilslegacy.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.event.network.CustomPayloadEvent;

public class ServerboundTimeMachineUpdatePacket {
    private final BlockPos blockPos;

    public ServerboundTimeMachineUpdatePacket(BlockPos blockPos) {
        this.blockPos = blockPos;
    }

    public ServerboundTimeMachineUpdatePacket(FriendlyByteBuf friendlyByteBuf) {
        this.blockPos = friendlyByteBuf.readBlockPos();
    }

    public void toBytes(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBlockPos(this.blockPos);
    }

    public boolean handle(CustomPayloadEvent.Context context) {
        context.enqueueWork(() -> {
            BasicPackets.serverboundTimeMachineUpdatePacket(this.blockPos, context.getSender().level());
        });
        return true;
    }
}
