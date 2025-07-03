package willatendo.fossilslegacy.network.clientbound;

import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.client.screen.FossilScreen;
import willatendo.fossilslegacy.server.entity.util.FossilPositions;
import willatendo.fossilslegacy.server.entity.util.FossilRotations;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class ClientboundPackets {
    public static void clientboundFossilMenuPacket(ClientboundFossilScreenPacket clientboundFossilScreenPacket, Player player) {
        Level level = player.level();
        int id = clientboundFossilScreenPacket.id();
        FossilRotations fossilRotations = clientboundFossilScreenPacket.fossilRotations();
        FossilPositions fossilPositions = clientboundFossilScreenPacket.fossilPositions();
        String fossilVariantId = clientboundFossilScreenPacket.fossilVariant();
        Registry<FossilVariant> fossilVariantRegistry = level.registryAccess().lookupOrThrow(FARegistries.FOSSIL_VARIANTS);
        Holder<FossilVariant> fossilVariant = fossilVariantRegistry.get(ResourceLocation.parse(fossilVariantId)).get();
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.setScreen(new FossilScreen(id, fossilRotations, fossilPositions, fossilVariant, FAUtils.translation("entity", "fossil.screen")));
    }
}
