package willatendo.fossilslegacy.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.network.ServerboundSinkPacket;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.entity.Futabasaurus;

public class FossilsLegacyFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.JURASSIC_FERN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.AXOLOTLSPAWN.get(), RenderType.cutout());

        KeyBindingHelper.registerKeyBinding(FossilsLegacyKeys.SINK);

        FossilsLegacyClient.init();

        FossilsLegacyClient.CLIENT_EVENTS_HOLDER.registerAllMenuScreens(menuScreenEntry -> {
            MenuScreens.register(menuScreenEntry.menuType(), menuScreenEntry.screenConstructor());
        });

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
