package willatendo.fossilslegacy.client;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
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
import willatendo.fossilslegacy.client.screen.AnalyzerScreen;
import willatendo.fossilslegacy.client.screen.ArchaeologyWorkbenchScreen;
import willatendo.fossilslegacy.client.screen.CultivatorScreen;
import willatendo.fossilslegacy.client.screen.FeederScreen;
import willatendo.fossilslegacy.experiments.client.FossilsExperimentsClient;
import willatendo.fossilslegacy.experiments.client.FossilsExperimentsModels;
import willatendo.fossilslegacy.experiments.client.model.CarnotaurusModel;
import willatendo.fossilslegacy.experiments.client.model.CryolophosaurusModel;
import willatendo.fossilslegacy.experiments.client.model.TimeMachineClockModel;
import willatendo.fossilslegacy.experiments.client.render.CarnotaurusRenderer;
import willatendo.fossilslegacy.experiments.client.render.CryolophosaurusRenderer;
import willatendo.fossilslegacy.experiments.server.entity.FossilsExperimentsEntityTypes;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.menu.FossilsLegacyMenus;

import java.util.ArrayList;
import java.util.List;

public class FossilsLegacyClient {
    public static final List<Model> MODELS = new ArrayList<>();
    public static final List<ModelLayer> MODEL_LAYERS = new ArrayList<>();

    public static <T extends Entity> void addModel(EntityType<? extends T> entityType, EntityRendererProvider<? extends T> entityRendererProvider) {
        MODELS.add(new Model(entityType, entityRendererProvider));
    }

    public static void addModelLayer(ModelLayerLocation modelLayerLocation, TexturedModelDataProvider texturedModelDataProvider) {
        MODEL_LAYERS.add(new ModelLayer(modelLayerLocation, texturedModelDataProvider));
    }

    public static void onInitializeClient() {
        FossilsExperimentsClient.init();

        MenuScreens.register(FossilsLegacyMenus.ANALYZER.get(), AnalyzerScreen::new);
        MenuScreens.register(FossilsLegacyMenus.ARCHAEOLOGY_WORKBENCH.get(), ArchaeologyWorkbenchScreen::new);
        MenuScreens.register(FossilsLegacyMenus.CULTIVATOR.get(), CultivatorScreen::new);
        MenuScreens.register(FossilsLegacyMenus.FEEDER.get(), FeederScreen::new);

        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.ANCIENT_LIGHTNING_BOLT.get(), LightningBoltRenderer::new);

        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.FOSSIL.get(), FossilRenderer::new);

        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), BrachiosaurusRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), DilophosaurusRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.MAMMOTH.get(), MammothRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.MOSASAURUS.get(), MosasaurusRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.NAUTILUS.get(), NautilusRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.FUTABASAURUS.get(), FutabasaurusRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.PTERANODON.get(), PteranodonRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.SMILODON.get(), SmilodonRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.STEGOSAURUS.get(), StegosaurusRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.TRICERATOPS.get(), TriceratopsRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.TYRANNOSAURUS.get(), TyrannosaurusRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.VELOCIRAPTOR.get(), VelociraptorRenderer::new);

        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.EGG.get(), EggRenderer::new);

        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.ANU.get(), AnuRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.FAILURESAURUS.get(), FailuresaurusRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get(), context -> new TamedZombifiedPiglinRenderer(context, ModelLayers.ZOMBIFIED_PIGLIN, ModelLayers.ZOMBIFIED_PIGLIN_INNER_ARMOR, ModelLayers.ZOMBIFIED_PIGLIN_OUTER_ARMOR, true));

        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.PREGNANT_CAT.get(), CatRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.PREGNANT_COW.get(), CowRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.PREGNANT_DOLPHIN.get(), DolphinRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.PREGNANT_DONKEY.get(), context -> new ChestedHorseRenderer<>(context, 0.87F, ModelLayers.DONKEY));
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.PREGNANT_FOX.get(), FoxRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.PREGNANT_GOAT.get(), GoatRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.PREGNANT_HORSE.get(), HorseRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.PREGNANT_LLAMA.get(), context -> new LlamaRenderer(context, ModelLayers.LLAMA));
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.PREGNANT_MAMMOTH.get(), MammothRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.PREGNANT_MULE.get(), context -> new ChestedHorseRenderer<>(context, 0.92F, ModelLayers.MULE));
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.PREGNANT_OCELOT.get(), OcelotRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.PREGNANT_PANDA.get(), PandaRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.PREGNANT_PIG.get(), PigRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.PREGNANT_POLAR_BEAR.get(), PolarBearRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.PREGNANT_RABBIT.get(), RabbitRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), SheepRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.PREGNANT_SMILODON.get(), SmilodonRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.PREGNANT_WOLF.get(), WolfRenderer::new);

        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.THROWN_JAVELIN.get(), ThrownJavelinRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.THROWN_INCUBATED_EGG.get(), ThrownItemRenderer::new);
        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.DILOPHOSAURUS_VENOM.get(), DilophosaurusVenomRenderer::new);

        FossilsLegacyClient.addModel(FossilsLegacyEntityTypes.STONE_TABLET.get(), StoneTabletRenderer::new);

        FossilsLegacyClient.addModel(FossilsExperimentsEntityTypes.CARNOTAURUS.get(), CarnotaurusRenderer::new);
        FossilsLegacyClient.addModel(FossilsExperimentsEntityTypes.CRYOLOPHOSAURUS.get(), CryolophosaurusRenderer::new);

        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.BRACHIOSAURUS, BrachiosaurusModel::createBodyLayer);
        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.DILOPHOSAURUS, DilophosaurusModel::createBodyLayer);
        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.MAMMOTH, MammothModel::createBodyLayer);
        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.MOSASAURUS, MosasaurusModel::createBodyLayer);
        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.NAUTILUS, NautilusModel::createBodyLayer);
        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.FUTABASAURUS, FutabasaurusModel::createBodyLayer);
        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.GROUND_PTERANODON, GroundPteranodonModel::createBodyLayer);
        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.FLYING_PTERANODON, FlyingPteranodonModel::createBodyLayer);
        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.LANDING_PTERANODON, LandingPteranodonModel::createBodyLayer);
        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.SMILODON, SmilodonModel::createBodyLayer);
        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.STEGOSAURUS, StegosaurusModel::createBodyLayer);
        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.TRICERATOPS, TriceratopsModel::createBodyLayer);
        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.TYRANNOSAURUS, TyrannosaurusModel::createBodyLayer);
        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.KNOCKED_OUT_TYRANNOSAURUS, KnockedOutTyrannosaurusModel::createBodyLayer);
        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.VELOCIRAPTOR, VelociraptorModel::createBodyLayer);

        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.TRICERATOPS_SKELETON, TriceratopsSkeletonModel::createBodyLayer);
        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.BRACHIOSAURUS_SKELETON, BrachiosaurusSkeletonModel::createBodyLayer);
        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.PLESIOSAURUS_SKELETON, FutabasaurusSkeletonModel::createBodyLayer);
        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.PTERANODON_SKELETON, PteranodonSkeletonModel::createBodyLayer);

        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.ANU, AnuModel::createBodyLayer);
        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.FAILURESAURUS, FailuresaurusModel::createBodyLayer);

        FossilsLegacyClient.addModelLayer(FossilsLegacyModels.EGG, EggModel::createBodyLayer);

        FossilsLegacyClient.addModelLayer(FossilsExperimentsModels.CARNOTAURUS, CarnotaurusModel::createBodyLayer);
        FossilsLegacyClient.addModelLayer(FossilsExperimentsModels.CRYOLOPHOSAURUS, CryolophosaurusModel::createBodyLayer);

        FossilsLegacyClient.addModelLayer(FossilsExperimentsModels.TIME_MACHINE_CLOCK, TimeMachineClockModel::createBodyLayer);
    }

    public static final record Model<T extends Entity>(EntityType<T> entityType,
                                                       EntityRendererProvider<T> entityRendererProvider) {
    }

    public static final record ModelLayer(ModelLayerLocation modelLayerLocation,
                                          TexturedModelDataProvider texturedModelDataProvider) {
    }
}