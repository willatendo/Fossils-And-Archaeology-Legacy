package willatendo.fossilslegacy.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.network.ServerboundSinkPacket;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.entity.Futabasaurus;
import willatendo.simplelibrary.client.event.FabricKeyMappingRegister;
import willatendo.simplelibrary.client.event.FabricMenuScreenRegister;
import willatendo.simplelibrary.client.event.FabricModelLayerRegister;

public class FossilsLegacyFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.JURASSIC_FERN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.AXOLOTLSPAWN.get(), RenderType.cutout());

        FossilsLegacyClient.keyMappingEvent(new FabricKeyMappingRegister());

        FossilsLegacyClient.modelLayerEvent(new FabricModelLayerRegister());

        FossilsLegacyClient.modelLayerEvent(new FabricModelLayerRegister());

        FossilsLegacyClient.menuScreenEvent(new FabricMenuScreenRegister());

        ClientTickEvents.END_CLIENT_TICK.register(minecraft -> {
            Player player = minecraft.player;
            if (player != null) {
                if (player.isPassenger()) {
                    if (player.getVehicle() instanceof Futabasaurus) {
                        if (FossilsLegacyKeys.SINK.isDown()) {
                            ClientPlayNetworking.send(new ServerboundSinkPacket(true));
                        }
                        if (FossilsLegacyKeys.SINK.consumeClick() == false) {
                            ClientPlayNetworking.send(new ServerboundSinkPacket(false));
                        }
                    }
                }
            }
        });
    }
}
