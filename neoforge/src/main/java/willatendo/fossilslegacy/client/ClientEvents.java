package willatendo.fossilslegacy.client;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.client.extensions.common.IClientBlockExtensions;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import willatendo.fossilslegacy.dual.FossilsLegacyDualEvents;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.fluid.FAFluidTypes;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.client.event.registry.*;
import willatendo.simplelibrary.server.event.registry.NeoforgeClientReloadListenerRegister;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = FAUtils.ID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void fmlClientSetupEvent(FMLClientSetupEvent event) {
        FossilsLegacyClient.loadUserManuelData();
        FossilsLegacyClient.signSheets();
    }

    @SubscribeEvent
    public static void registerClientReloadListenersEvent(AddClientReloadListenersEvent event) {
        FossilsLegacyDualEvents.clientReloadListenersEvent(new NeoforgeClientReloadListenerRegister(event));
    }

    @SubscribeEvent
    public static void specialModelsEvent(RegisterSpecialModelRendererEvent event) {
        FossilsLegacyClient.specialModelsEvent(new NeoforgeSpecialRendererRegistry(event));
    }

    @SubscribeEvent
    public static void registerKeyMappingsEvent(RegisterKeyMappingsEvent event) {
        FossilsLegacyClient.keyMappingEvent(new NeoforgeKeyMappingRegister(event));
    }

    @SubscribeEvent
    public static void entityRenderersEvent_RegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        FossilsLegacyClient.modelEvent(new NeoforgeModelRegister(event));
    }

    @SubscribeEvent
    public static void entityRenderersEvent_RegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        FossilsLegacyClient.modelLayerEvent(new NeoforgeModelLayerRegister(event));
    }

    @SubscribeEvent
    public static void registerMenuScreensEvent(RegisterMenuScreensEvent event) {
        FossilsLegacyClient.menuScreenEvent(new NeoforgeMenuScreenRegister(event));
    }

    @SubscribeEvent
    public static void registerColorHandlersEvent_Block(RegisterColorHandlersEvent.Block event) {
        FossilsLegacyClient.blockColorRegistry(new NeoforgeBlockColorRegister(event));
    }

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerBlock(new IClientBlockExtensions() {
            @Override
            public boolean areBreakingParticlesTinted(BlockState blockState, ClientLevel clientLevel, BlockPos blockPos) {
                return false;
            }
        }, FABlocks.CYCAD_HEAD.get());
        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return FossilsLegacyClient.TAR_STILL;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return FossilsLegacyClient.TAR_FLOW;
            }
        }, FAFluidTypes.TAR_TYPE.get());
    }

    @SubscribeEvent
    public static void registerParticleProvidersEvent(RegisterParticleProvidersEvent event) {
        FossilsLegacyClient.particleRegisterEvent(new NeoforgeParticleRegistry(event));
    }

    @SubscribeEvent
    public static void registerRecipesEvent(RecipesReceivedEvent event) {
        FossilsLegacyClient.addRecipes(event.getRecipeMap());
    }
}