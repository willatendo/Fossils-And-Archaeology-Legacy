package willatendo.pridelands.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import willatendo.pridelands.server.block.PridelandsBlocks;
import willatendo.simplelibrary.client.event.registry.FabricParticleRegistry;

public class ToThePridelandsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ToThePridelandsClient.particleRegisterEvent(new FabricParticleRegistry());

        BlockRenderLayerMap.INSTANCE.putBlock(PridelandsBlocks.HYENA_BONE_TORCH.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PridelandsBlocks.HYENA_BONE_WALL_TORCH.get(), RenderType.cutout());
    }
}
