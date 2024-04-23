package willatendo.fossilslegacy.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;

public class FossilsLegacyFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.JURASSIC_FERN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.AXOLOTLSPAWN.get(), RenderType.cutout());

        KeyBindingHelper.registerKeyBinding(FossilsLegacyKeys.SINK);

        FossilsLegacyClient.onInitializeClient();

        FossilsLegacyClient.MODELS.forEach(model -> {
            EntityRendererRegistry.register(model.entityType(), model.entityRendererProvider());
        });

        FossilsLegacyClient.MODEL_LAYERS.forEach(modelLayer -> {
            EntityModelLayerRegistry.registerModelLayer(modelLayer.modelLayerLocation(), modelLayer.texturedModelDataProvider()::createModelData);
        });
    }
}
