package willatendo.fossilslegacy.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.client.extensions.common.IClientBlockExtensions;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import willatendo.fossilslegacy.client.animation.json.JsonAnimationLoader;
import willatendo.fossilslegacy.client.model.CaptainsHatModel;
import willatendo.fossilslegacy.client.model.json.JsonLayerDefinitionResourceManager;
import willatendo.fossilslegacy.client.model.json.JsonModelLoader;
import willatendo.fossilslegacy.client.resources.DecorationPlaqueTextureManager;
import willatendo.fossilslegacy.client.resources.StoneTabletTextureManager;
import willatendo.fossilslegacy.client.user_manual.UserManualItemDataLoader;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.fluid.FAFluidTypes;
import willatendo.fossilslegacy.server.fluid.FAFluids;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.client.event.registry.*;

@EventBusSubscriber(modid = FAUtils.ID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void fmlClientSetupEvent(FMLClientSetupEvent event) {
        FossilsLegacyClient.loadUserManuelData();
        FossilsLegacyClient.signSheets();

        ItemBlockRenderTypes.setRenderLayer(FAFluids.TAR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FAFluids.FLOWING_TAR.get(), RenderType.translucent());
    }

    @SubscribeEvent
    public static void registerClientReloadListenersEvent(AddClientReloadListenersEvent event) {
        event.addListener(FAUtils.resource("decoration_plaque_texture_manager"), DecorationPlaqueTextureManager.INSTANCE);
        event.addListener(FAUtils.resource("stone_table_texture_manager"), StoneTabletTextureManager.INSTANCE);
        event.addListener(FAUtils.resource("json_models_loader"), JsonModelLoader.INSTANCE);
        event.addListener(FAUtils.resource("json_animations_loader"), JsonAnimationLoader.INSTANCE);
        event.addListener(FAUtils.resource("json_layers_loader"), JsonLayerDefinitionResourceManager.INSTANCE);
        event.addListener(FAUtils.resource("user_manual_item_data_loader"), UserManualItemDataLoader.INSTANCE);
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
        }, FABlocks.CYCAD_HEAD.get(), FABlocks.ZAMITES_HEAD.get(), FABlocks.ZAMITES_BRANCH.get());
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
        event.registerItem(new IClientItemExtensions() {
            @Override
            public Model getHumanoidArmorModel(ItemStack itemStack, EquipmentClientInfo.LayerType layerType, Model original) {
                Minecraft minecraft = Minecraft.getInstance();
                if (layerType == EquipmentClientInfo.LayerType.HUMANOID) {
                    CaptainsHatModel captainsHatModel = new CaptainsHatModel(minecraft.getEntityModels().bakeLayer(FAModelLayers.CAPTAINS_HAT));
                    captainsHatModel.copyPropertiesTo((HumanoidModel<HumanoidRenderState>) original);
                    return captainsHatModel;
                }
                return original;
            }

            @Override
            public ResourceLocation getArmorTexture(ItemStack itemStack, EquipmentClientInfo.LayerType layerType, EquipmentClientInfo.Layer layer, ResourceLocation defaultTexture) {
                return layerType == EquipmentClientInfo.LayerType.HUMANOID ? FossilsLegacyClient.CAPTAINS_HAT : defaultTexture;
            }
        }, FAItems.CAPTAINS_HAT.get());
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