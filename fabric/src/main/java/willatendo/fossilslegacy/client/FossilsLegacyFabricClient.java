package willatendo.fossilslegacy.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleRenderEvents;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.client.animation.json.JsonAnimationLoader;
import willatendo.fossilslegacy.client.model.json.JsonLayerDefinitionResourceManager;
import willatendo.fossilslegacy.client.model.json.JsonModelLoader;
import willatendo.fossilslegacy.client.resources.DecorationPlaqueTextureManager;
import willatendo.fossilslegacy.client.resources.StoneTabletTextureManager;
import willatendo.fossilslegacy.client.user_manual.UserManualItemDataLoader;
import willatendo.fossilslegacy.network.ClientboundPacketRegistry;
import willatendo.fossilslegacy.network.clientbound.ClientboundRecipeContentPacket;
import willatendo.fossilslegacy.network.clientbound.FabricClientboundPackets;
import willatendo.fossilslegacy.network.serverbound.ServerboundVehicleSinkPacket;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Futabasaurus;
import willatendo.fossilslegacy.server.fluid.FAFluids;
import willatendo.fossilslegacy.server.registry.FABlockRegistry;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.client.event.registry.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class FossilsLegacyFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ResourceManagerHelper resourceManagerHelper = ResourceManagerHelper.get(PackType.CLIENT_RESOURCES);
        resourceManagerHelper.registerReloadListener(new IdentifiableResourceReloadListener() {
            @Override
            public ResourceLocation getFabricId() {
                return FAUtils.resource("decoration_plaque_texture_manager");
            }

            @Override
            public CompletableFuture<Void> reload(PreparationBarrier preparationBarrier, ResourceManager resourceManager, Executor backgroundExecutor, Executor gameExecutor) {
                return DecorationPlaqueTextureManager.INSTANCE.reload(preparationBarrier, resourceManager, backgroundExecutor, gameExecutor);
            }
        });
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
        resourceManagerHelper.registerReloadListener(new IdentifiableResourceReloadListener() {
            @Override
            public ResourceLocation getFabricId() {
                return FAUtils.resource("user_manual_item_data_loader");
            }

            @Override
            public CompletableFuture<Void> reload(PreparationBarrier preparationBarrier, ResourceManager resourceManager, Executor backgroundExecutor, Executor gameExecutor) {
                return UserManualItemDataLoader.INSTANCE.reload(preparationBarrier, resourceManager, backgroundExecutor, gameExecutor);
            }
        });

        for (int i = 0; i < FABlockRegistry.woodSize(); i++) {
            BlockRenderLayerMap.INSTANCE.putBlock(FABlockRegistry.getSapling(i).get(), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(FABlockRegistry.getLeaves(i).get(), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(FABlockRegistry.getDoor(i).get(), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(FABlockRegistry.getTrapdoor(i).get(), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(FABlockRegistry.getPottedSapling(i).get(), RenderType.cutout());
        }
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.JURASSIC_FERN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.SHORT_HORSETAIL.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.TALL_HORSETAIL.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.AXOLOTLSPAWN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.CYCAD_HEAD.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.ZAMITES_HEAD.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.SALVINIA.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.LOTUS.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.COOKSONIA.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.CLAYTOSMUNDA.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.CYCADEOIDEA.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.MACROTAENIOPTERIS.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.DIPTERIS.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.SARCANDRA.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.DNA_HYBRIDIZER.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.WHITE_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.WHITE_SHATTERED_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.ORANGE_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.ORANGE_SHATTERED_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.MAGENTA_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.MAGENTA_SHATTERED_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.LIGHT_BLUE_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.LIGHT_BLUE_SHATTERED_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.YELLOW_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.YELLOW_SHATTERED_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.LIME_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.LIME_SHATTERED_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.PINK_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.PINK_SHATTERED_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.GRAY_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.GRAY_SHATTERED_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.LIGHT_GRAY_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.LIGHT_GRAY_SHATTERED_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.CYAN_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.CYAN_SHATTERED_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.PURPLE_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.PURPLE_SHATTERED_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.BLUE_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.BLUE_SHATTERED_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.BROWN_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.BROWN_SHATTERED_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.GREEN_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.GREEN_SHATTERED_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.RED_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.RED_SHATTERED_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.BLACK_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.BLACK_SHATTERED_CULTIVATOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.STRAIGHT_TRACK.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.CORNER_TRACK.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FABlocks.RAMP_TRACK.get(), RenderType.cutout());

        ParticleRenderEvents.ALLOW_BLOCK_DUST_TINT.register((blockState, clientLevel, blockPos) -> !blockState.is(FABlocks.CYCAD_HEAD.get()) && !blockState.is(FABlocks.ZAMITES_HEAD.get()) && !blockState.is(FABlocks.ZAMITES_BRANCH.get()));

        FabricClientboundPacketRegister fabricClientboundPacketRegister = new FabricClientboundPacketRegister();
        fabricClientboundPacketRegister.registerClientbound(ClientboundRecipeContentPacket.TYPE, ClientboundRecipeContentPacket.STREAM_CODEC, FabricClientboundPackets::clientboundOpenDinopediaScreenPacket);
        ClientboundPacketRegistry.clientboundPacketSetup(fabricClientboundPacketRegister);

        FossilsLegacyClient.blockColorRegistry(new FabricBlockColorRegister());

        FossilsLegacyClient.loadUserManuelData();

        FossilsLegacyClient.signSheets();

        FossilsLegacyClient.keyMappingEvent(new FabricKeyMappingRegister());

        FossilsLegacyClient.modelLayerEvent(new FabricModelLayerRegister());

        FossilsLegacyClient.modelEvent(new FabricModelRegister());

        FossilsLegacyClient.specialModelsEvent(new FabricSpecialRendererRegistry());

        FossilsLegacyClient.menuScreenEvent(new FabricMenuScreenRegister());

        FossilsLegacyClient.particleRegisterEvent(new FabricParticleRegistry());

        FluidRenderHandlerRegistry.INSTANCE.register(FAFluids.TAR.get(), FAFluids.FLOWING_TAR.get(), new SimpleFluidRenderHandler(FossilsLegacyClient.TAR_STILL, FossilsLegacyClient.TAR_FLOW));

        ClientTickEvents.END_CLIENT_TICK.register(minecraft -> {
            Player player = minecraft.player;
            if (player != null) {
                if (player.isPassenger()) {
                    if (player.getVehicle() instanceof Futabasaurus) {
                        if (FAKeys.SINK.isDown()) {
                            ClientPlayNetworking.send(new ServerboundVehicleSinkPacket(true));
                        }
                        if (!FAKeys.SINK.consumeClick()) {
                            ClientPlayNetworking.send(new ServerboundVehicleSinkPacket(false));
                        }
                    }
                }
            }
        });
    }
}
