package willatendo.fossilslegacy.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import willatendo.fossilslegacy.network.FossilsLegacyPackets;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;

public class FossilsLegacyFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.JURASSIC_FERN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.AXOLOTLSPAWN.get(), RenderType.cutout());

        KeyBindingHelper.registerKeyBinding(FossilsLegacyKeys.SINK);

        FossilsLegacyPackets.registerClientToServerPackets();

        FossilsLegacyClient.init();

        FossilsLegacyClient.CLIENT_EVENTS_HOLDER.registerAllEntityModels(entityModel -> {
            EntityRendererRegistry.register(entityModel.entityType(), entityModel.entityRendererProvider());
        });
        FossilsLegacyClient.CLIENT_EVENTS_HOLDER.registerAllBlockModels(blockModel -> {
            BlockEntityRenderers.register(blockModel.blockEntityType(), blockModel.blockEntityRendererProvider());
        });

        FossilsLegacyClient.CLIENT_EVENTS_HOLDER.registerAllModelLayers(modelLayer -> {
            EntityModelLayerRegistry.registerModelLayer(modelLayer.modelLayerLocation(), modelLayer.texturedModelDataProvider()::createModelData);
        });

        ClientTickEvents.END_CLIENT_TICK.register(minecraft -> {
            if (FossilsLegacyKeys.SINK.isDown()) {
                ClientPlayNetworking.send(FossilsLegacyPackets.SINK, PacketByteBufs.create().writeBoolean(true));
            } else {
                ClientPlayNetworking.send(FossilsLegacyPackets.SINK, PacketByteBufs.create().writeBoolean(false));
            }
        });
    }
}
