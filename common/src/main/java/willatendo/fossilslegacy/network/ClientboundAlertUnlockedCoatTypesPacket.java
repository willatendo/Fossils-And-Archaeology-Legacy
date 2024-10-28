package willatendo.fossilslegacy.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.network.util.ForgeHandlePacket;

import java.util.List;

public record ClientboundAlertUnlockedCoatTypesPacket(List<String> coatTypes) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ClientboundAlertUnlockedCoatTypesPacket> TYPE = new CustomPacketPayload.Type<>(BasicPackets.ALERT_UNLOCKED_COAT_TYPES);
    public static final StreamCodec<ByteBuf, ClientboundAlertUnlockedCoatTypesPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8.apply(ByteBufCodecs.collection(NonNullList::createWithCapacity)), ClientboundAlertUnlockedCoatTypesPacket::coatTypes, ClientboundAlertUnlockedCoatTypesPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    // Forge Start

    public void encode(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.coatTypes().size());
        this.coatTypes().forEach(friendlyByteBuf::writeUtf);
    }

    public static ClientboundAlertUnlockedCoatTypesPacket decode(FriendlyByteBuf friendlyByteBuf) {
        List<String> coatTypes = Lists.newArrayList();
        for (int i = 0; i < friendlyByteBuf.readInt(); i++) {
            coatTypes.add(friendlyByteBuf.readUtf());
        }
        return new ClientboundAlertUnlockedCoatTypesPacket(coatTypes);
    }

    public static void handle(ForgeHandlePacket forgeHandlePacket, ClientboundAlertUnlockedCoatTypesPacket clientboundAlertUnlockedCoatTypesPacket) {
        BasicPackets.clientboundAlertUnlockedCoatTypes(clientboundAlertUnlockedCoatTypesPacket.coatTypes(), forgeHandlePacket.getServerPlayer(), forgeHandlePacket.getServerPlayer().level());
    }
}
