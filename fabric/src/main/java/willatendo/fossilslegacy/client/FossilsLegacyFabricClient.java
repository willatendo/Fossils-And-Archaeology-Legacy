package willatendo.fossilslegacy.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.client.animation.json.JsonAnimationLoader;
import willatendo.fossilslegacy.client.model.json.JsonLayerDefinitionResourceManager;
import willatendo.fossilslegacy.client.model.json.JsonModelLoader;
import willatendo.fossilslegacy.client.resources.StoneTabletTextureManager;
import willatendo.fossilslegacy.network.ServerboundSinkPacket;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Futabasaurus;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.client.event.registry.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class FossilsLegacyFabricClient implements ClientModInitializer {
    public static final ModelResourceLocation THERIZINOSAURUS_2D = new ModelResourceLocation(FAUtils.resource("item/therizinosaurus_claws_gui"), "fabric_resource");
    public static final ModelResourceLocation THERIZINOSAURUS_3D = new ModelResourceLocation(FAUtils.resource("item/therizinosaurus_claws_in_hand"), "fabric_resource");

    @Override
    public void onInitializeClient() {
        ResourceManagerHelper resourceManagerHelper = ResourceManagerHelper.get(PackType.CLIENT_RESOURCES);
        resourceManagerHelper.registerReloadListener(new IdentifiableResourceReloadListener() {
            @Override
            public ResourceLocation getFabricId() {
                return FAUtils.resource("stone_table_texture_manager");
            }

            @Override
            public CompletableFuture<Void> reload(PreparationBarrier preparationBarrier, ResourceManager resourceManager, Executor backgroundExecutor, Executor gameExecutor) {
                return StoneTabletTextureManager.INSTANCE.reload(preparationBarrier, resourceManager, backgroundExecutor, gameExecutor);
            }
        });
        resourceManagerHelper.registerReloadListener(new IdentifiableResourceReloadListener() {
            @Override
            public ResourceLocation getFabricId() {
                return FAUtils.resource("json_models_loader");
            }

            @Override
            public CompletableFuture<Void> reload(PreparationBarrier preparationBarrier, ResourceManager resourceManager, Executor backgroundExecutor, Executor gameExecutor) {
                return JsonModelLoader.INSTANCE.reload(preparationBarrier, resourceManager, backgroundExecutor, gameExecutor);
            }
        });
        resourceManagerHelper.registerReloadListener(new IdentifiableResourceReloadListener() {
            @Override
            public ResourceLocation getFabricId() {
                return FAUtils.resource("json_animations_loader");
            }

            @Override
            public CompletableFuture<Void> reload(PreparationBarrier preparationBarrier, ResourceManager resourceManager, Executor backgroundExecutor, Executor gameExecutor) {
                return JsonAnimationLoader.INSTANCE.reload(preparationBarrier, resourceManager, backgroundExecutor, gameExecutor);
            }
        });
        resourceManagerHelper.registerReloadListener(new IdentifiableResourceReloadListener() {
            @Override
            public ResourceLocation getFabricId() {
                return FAUtils.resource("json_layers_loader");
            }

            @Override
            public CompletableFuture<Void> reload(PreparationBarrier preparationBarrier, ResourceManager resourceManager, Executor backgroundExecutor, Executor gameExecutor) {
                return JsonLayerDefinitionResourceManager.INSTANCE.reload(preparationBarrier, resourceManager, backgroundExecutor, gameExecutor);
            }
        });


        ModelLoadingPlugin.register(context -> context.addModels(FossilsLegacyFabricClient.THERIZINOSAURUS_2D.id(), FossilsLegacyFabricClient.THERIZINOSAURUS_3D.id()));

        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.JURASSIC_FERN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.AXOLOTLSPAWN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.CALAMITES_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.CALAMITES_LEAVES.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.CALAMITES_DOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.CALAMITES_TRAPDOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.POTTED_CALAMITES_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.LEPIDODENDRON_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.LEPIDODENDRON_LEAVES.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.LEPIDODENDRON_DOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.LEPIDODENDRON_TRAPDOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.POTTED_LEPIDODENDRON_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.SIGILLARIA_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.SIGILLARIA_LEAVES.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.SIGILLARIA_DOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.SIGILLARIA_TRAPDOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.POTTED_SIGILLARIA_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.WHITE_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.ORANGE_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.MAGENTA_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.LIGHT_BLUE_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.YELLOW_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.LIME_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.PINK_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.GRAY_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.LIGHT_GRAY_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.CYAN_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.PURPLE_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.BLUE_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.BROWN_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.GREEN_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.RED_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.BLACK_CULTIVATOR.get(), RenderType.translucent());

        FossilsLegacyClient.blockColorRegistry(new FabricBlockColorRegister());

        FossilsLegacyClient.signSheets();

        FossilsLegacyClient.keyMappingEvent(new FabricKeyMappingRegister());

        FossilsLegacyClient.modelLayerEvent(new FabricModelLayerRegister());

        FossilsLegacyClient.modelEvent(new FabricModelRegister());

        FossilsLegacyClient.specialModelsEvent(new FabricSpecialRendererRegistry());

        FossilsLegacyClient.menuScreenEvent(new FabricMenuScreenRegister());

        ClientTickEvents.END_CLIENT_TICK.register(minecraft -> {
            Player player = minecraft.player;
            if (player != null) {
                if (player.isPassenger()) {
                    if (player.getVehicle() instanceof Futabasaurus) {
                        if (FAKeys.SINK.isDown()) {
                            ClientPlayNetworking.send(new ServerboundSinkPacket(true));
                        }
                        if (!FAKeys.SINK.consumeClick()) {
                            ClientPlayNetworking.send(new ServerboundSinkPacket(false));
                        }
                    }
                }
            }
        });
    }
}
