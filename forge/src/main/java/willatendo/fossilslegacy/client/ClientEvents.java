package willatendo.fossilslegacy.client;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import willatendo.fossilslegacy.client.model.*;
import willatendo.fossilslegacy.client.model.fossils.BrachiosaurusSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.FutabasaurusSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.PteranodonSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.TriceratopsSkeletonModel;
import willatendo.fossilslegacy.client.model.pteranodon.FlyingPteranodonModel;
import willatendo.fossilslegacy.client.model.pteranodon.GroundPteranodonModel;
import willatendo.fossilslegacy.client.model.pteranodon.LandingPteranodonModel;
import willatendo.fossilslegacy.client.model.tyrannosaurus.KnockedOutTyrannosaurusModel;
import willatendo.fossilslegacy.client.model.tyrannosaurus.TyrannosaurusModel;
import willatendo.fossilslegacy.client.render.*;
import willatendo.fossilslegacy.experiments.client.FossilsExperimentsModels;
import willatendo.fossilslegacy.experiments.client.model.TimeMachineClockModel;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = FossilsLegacyUtils.ID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        FossilsLegacyClient.onInitializeClient();
    }

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(FossilsLegacyKeys.SINK);
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(FossilsLegacyEntityTypes.ANCIENT_LIGHTNING_BOLT.get(), LightningBoltRenderer::new);

        event.registerEntityRenderer(FossilsLegacyEntityTypes.FOSSIL.get(), FossilRenderer::new);

        event.registerEntityRenderer(FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), BrachiosaurusRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), DilophosaurusRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.MAMMOTH.get(), MammothRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.MOSASAURUS.get(), MosasaurusRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.NAUTILUS.get(), NautilusRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.FUTABASAURUS.get(), FutabasaurusRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.PTERANODON.get(), PteranodonRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.SMILODON.get(), SmilodonRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.STEGOSAURUS.get(), StegosaurusRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.TRICERATOPS.get(), TriceratopsRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.TYRANNOSAURUS.get(), TyrannosaurusRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.VELOCIRAPTOR.get(), VelociraptorRenderer::new);

        event.registerEntityRenderer(FossilsLegacyEntityTypes.EGG.get(), EggRenderer::new);

        event.registerEntityRenderer(FossilsLegacyEntityTypes.ANU.get(), AnuRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.FAILURESAURUS.get(), FailuresaurusRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get(), context -> new TamedZombifiedPiglinRenderer(context, ModelLayers.ZOMBIFIED_PIGLIN, ModelLayers.ZOMBIFIED_PIGLIN_INNER_ARMOR, ModelLayers.ZOMBIFIED_PIGLIN_OUTER_ARMOR, true));

        event.registerEntityRenderer(FossilsLegacyEntityTypes.PREGNANT_CAT.get(), CatRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.PREGNANT_COW.get(), CowRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.PREGNANT_DOLPHIN.get(), DolphinRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.PREGNANT_DONKEY.get(), context -> new ChestedHorseRenderer<>(context, 0.87F, ModelLayers.DONKEY));
        event.registerEntityRenderer(FossilsLegacyEntityTypes.PREGNANT_FOX.get(), FoxRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.PREGNANT_GOAT.get(), GoatRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.PREGNANT_HORSE.get(), HorseRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.PREGNANT_LLAMA.get(), context -> new LlamaRenderer(context, ModelLayers.LLAMA));
        event.registerEntityRenderer(FossilsLegacyEntityTypes.PREGNANT_MAMMOTH.get(), MammothRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.PREGNANT_MULE.get(), context -> new ChestedHorseRenderer<>(context, 0.92F, ModelLayers.MULE));
        event.registerEntityRenderer(FossilsLegacyEntityTypes.PREGNANT_OCELOT.get(), OcelotRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.PREGNANT_PANDA.get(), PandaRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.PREGNANT_PIG.get(), PigRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.PREGNANT_POLAR_BEAR.get(), PolarBearRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.PREGNANT_RABBIT.get(), RabbitRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), SheepRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.PREGNANT_SMILODON.get(), SmilodonRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.PREGNANT_WOLF.get(), WolfRenderer::new);

        event.registerEntityRenderer(FossilsLegacyEntityTypes.THROWN_JAVELIN.get(), ThrownJavelinRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.THROWN_INCUBATED_EGG.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(FossilsLegacyEntityTypes.DILOPHOSAURUS_VENOM.get(), DilophosaurusVenomRenderer::new);

        event.registerEntityRenderer(FossilsLegacyEntityTypes.STONE_TABLET.get(), StoneHieroglyphRenderer::new);
    }

    @SubscribeEvent
    public static void register(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(FossilsLegacyModels.BRACHIOSAURUS, BrachiosaurusModel::createBodyLayer);
        event.registerLayerDefinition(FossilsLegacyModels.DILOPHOSAURUS, DilophosaurusModel::createBodyLayer);
        event.registerLayerDefinition(FossilsLegacyModels.MAMMOTH, MammothModel::createBodyLayer);
        event.registerLayerDefinition(FossilsLegacyModels.MOSASAURUS, MosasaurusModel::createBodyLayer);
        event.registerLayerDefinition(FossilsLegacyModels.NAUTILUS, NautilusModel::createBodyLayer);
        event.registerLayerDefinition(FossilsLegacyModels.FUTABASAURUS, FutabasaurusModel::createBodyLayer);
        event.registerLayerDefinition(FossilsLegacyModels.GROUND_PTERANODON, GroundPteranodonModel::createBodyLayer);
        event.registerLayerDefinition(FossilsLegacyModels.FLYING_PTERANODON, FlyingPteranodonModel::createBodyLayer);
        event.registerLayerDefinition(FossilsLegacyModels.LANDING_PTERANODON, LandingPteranodonModel::createBodyLayer);
        event.registerLayerDefinition(FossilsLegacyModels.SMILODON, SmilodonModel::createBodyLayer);
        event.registerLayerDefinition(FossilsLegacyModels.STEGOSAURUS, StegosaurusModel::createBodyLayer);
        event.registerLayerDefinition(FossilsLegacyModels.TRICERATOPS, TriceratopsModel::createBodyLayer);
        event.registerLayerDefinition(FossilsLegacyModels.TYRANNOSAURUS, TyrannosaurusModel::createBodyLayer);
        event.registerLayerDefinition(FossilsLegacyModels.KNOCKED_OUT_TYRANNOSAURUS, KnockedOutTyrannosaurusModel::createBodyLayer);
        event.registerLayerDefinition(FossilsLegacyModels.VELOCIRAPTOR, VelociraptorModel::createBodyLayer);

        event.registerLayerDefinition(FossilsLegacyModels.TRICERATOPS_SKELETON, TriceratopsSkeletonModel::createBodyLayer);
        event.registerLayerDefinition(FossilsLegacyModels.BRACHIOSAURUS_SKELETON, BrachiosaurusSkeletonModel::createBodyLayer);
        event.registerLayerDefinition(FossilsLegacyModels.PLESIOSAURUS_SKELETON, FutabasaurusSkeletonModel::createBodyLayer);
        event.registerLayerDefinition(FossilsLegacyModels.PTERANODON_SKELETON, PteranodonSkeletonModel::createBodyLayer);

        event.registerLayerDefinition(FossilsLegacyModels.ANU, AnuModel::createBodyLayer);
        event.registerLayerDefinition(FossilsLegacyModels.FAILURESAURUS, FailuresaurusModel::createBodyLayer);

        event.registerLayerDefinition(FossilsLegacyModels.EGG, EggModel::createBodyLayer);

        event.registerLayerDefinition(FossilsExperimentsModels.TIME_MACHINE_CLOCK, TimeMachineClockModel::createBodyLayer);
    }
}
