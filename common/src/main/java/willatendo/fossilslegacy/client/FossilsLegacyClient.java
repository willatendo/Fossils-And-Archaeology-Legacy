package willatendo.fossilslegacy.client;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.*;
import willatendo.fossilslegacy.client.model.AnuModel;
import willatendo.fossilslegacy.client.model.EggModel;
import willatendo.fossilslegacy.client.model.FailuresaurusModel;
import willatendo.fossilslegacy.client.model.TimeMachineClockModel;
import willatendo.fossilslegacy.client.model.dinosaur.CompsognathusModel;
import willatendo.fossilslegacy.client.model.dinosaur.FutabasaurusModel;
import willatendo.fossilslegacy.client.model.dinosaur.PachycephalosaurusModel;
import willatendo.fossilslegacy.client.model.dinosaur.VelociraptorModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.*;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.pteranodon.FlyingPteranodonModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.pteranodon.GroundPteranodonModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.pteranodon.LandingPteranodonModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.tyrannosaurus.KnockedOutTyrannosaurusModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.tyrannosaurus.TyrannosaurusModel;
import willatendo.fossilslegacy.client.model.fossils.CompsognathusSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.FutabasaurusSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.PachycephalosaurusSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.VelociraptorSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.legacy.BrachiosaurusSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.legacy.LegacyFutabasaurusSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.legacy.PteranodonSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.legacy.TriceratopsSkeletonModel;
import willatendo.fossilslegacy.client.render.*;
import willatendo.fossilslegacy.client.screen.*;
import willatendo.fossilslegacy.server.block.entity.FossilsLegacyBlockEntities;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.menu.FossilsLegacyMenus;
import willatendo.simplelibrary.client.event.KeyMappingRegister;
import willatendo.simplelibrary.client.event.MenuScreenRegister;
import willatendo.simplelibrary.client.event.ModelLayerRegister;
import willatendo.simplelibrary.client.event.ModelRegister;

public class FossilsLegacyClient {
    public static void keyMappingEvent(KeyMappingRegister keyMappingRegister) {
        keyMappingRegister.register(FossilsLegacyKeys.SINK);
    }

    public static void modelEvent(ModelRegister modelRegister) {
        modelRegister.register(FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), BrachiosaurusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), DilophosaurusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.MAMMOTH.get(), MammothRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.MOSASAURUS.get(), MosasaurusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.NAUTILUS.get(), NautilusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.FUTABASAURUS.get(), FutabasaurusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.PTERANODON.get(), PteranodonRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.SMILODON.get(), SmilodonRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.STEGOSAURUS.get(), StegosaurusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.TRICERATOPS.get(), TriceratopsRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.TYRANNOSAURUS.get(), TyrannosaurusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.VELOCIRAPTOR.get(), VelociraptorRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.CARNOTAURUS.get(), CarnotaurusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.CRYOLOPHOSAURUS.get(), CryolophosaurusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.THERIZINOSAURUS.get(), TherizinosaurusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.PACHYCEPHALOSAURUS.get(), PachycephalosaurusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.COMPSOGNATHUS.get(), CompsognathusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.EGG.get(), EggRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.ANU.get(), AnuRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.FAILURESAURUS.get(), FailuresaurusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get(), context -> new TamedZombifiedPiglinRenderer(context, ModelLayers.ZOMBIFIED_PIGLIN, ModelLayers.ZOMBIFIED_PIGLIN_INNER_ARMOR, ModelLayers.ZOMBIFIED_PIGLIN_OUTER_ARMOR, true));
        modelRegister.register(FossilsLegacyEntityTypes.PREGNANT_CAT.get(), CatRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.PREGNANT_COW.get(), CowRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.PREGNANT_DOLPHIN.get(), DolphinRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.PREGNANT_DONKEY.get(), context -> new ChestedHorseRenderer<>(context, 0.87F, ModelLayers.DONKEY));
        modelRegister.register(FossilsLegacyEntityTypes.PREGNANT_FOX.get(), FoxRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.PREGNANT_GOAT.get(), GoatRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.PREGNANT_HORSE.get(), HorseRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.PREGNANT_LLAMA.get(), context -> new LlamaRenderer(context, ModelLayers.LLAMA));
        modelRegister.register(FossilsLegacyEntityTypes.PREGNANT_MAMMOTH.get(), MammothRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.PREGNANT_MULE.get(), context -> new ChestedHorseRenderer<>(context, 0.92F, ModelLayers.MULE));
        modelRegister.register(FossilsLegacyEntityTypes.PREGNANT_OCELOT.get(), OcelotRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.PREGNANT_PANDA.get(), PandaRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.PREGNANT_PIG.get(), PigRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.PREGNANT_POLAR_BEAR.get(), PolarBearRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.PREGNANT_RABBIT.get(), RabbitRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), SheepRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.PREGNANT_SMILODON.get(), SmilodonRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.PREGNANT_WOLF.get(), WolfRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.THROWN_JAVELIN.get(), ThrownJavelinRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.THROWN_INCUBATED_EGG.get(), ThrownItemRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.DILOPHOSAURUS_VENOM.get(), DilophosaurusVenomRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.ANCIENT_LIGHTNING_BOLT.get(), LightningBoltRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.FOSSIL.get(), FossilRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.STONE_TABLET.get(), StoneTabletRenderer::new);
        modelRegister.register(FossilsLegacyBlockEntities.TIME_MACHINE.get(), TimeMachineClockRenderer::new);
    }

    public static void modelLayerEvent(ModelLayerRegister modelLayerRegister) {
        modelLayerRegister.register(FossilsLegacyModels.BRACHIOSAURUS, BrachiosaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.DILOPHOSAURUS, DilophosaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.MAMMOTH, MammothModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.MOSASAURUS, MosasaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.NAUTILUS, NautilusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.FUTABASAURUS, FutabasaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.LEGACY_FUTABASAURUS, LegacyFutabasaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.GROUND_PTERANODON, GroundPteranodonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.FLYING_PTERANODON, FlyingPteranodonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.LANDING_PTERANODON, LandingPteranodonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.SMILODON, SmilodonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.STEGOSAURUS, StegosaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.TRICERATOPS, TriceratopsModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.TYRANNOSAURUS, TyrannosaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.KNOCKED_OUT_TYRANNOSAURUS, KnockedOutTyrannosaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.VELOCIRAPTOR, VelociraptorModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.LEGACY_VELOCIRAPTOR, LegacyVelociraptorModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.CARNOTAURUS, CarnotaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.CRYOLOPHOSAURUS, CryolophosaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.THERIZINOSAURUS, TherizinosaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.PACHYCEPHALOSAURUS, PachycephalosaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.COMPSOGNATHUS, CompsognathusModel::createBodyLayer);

        modelLayerRegister.register(FossilsLegacyModels.TRICERATOPS_SKELETON, TriceratopsSkeletonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.BRACHIOSAURUS_SKELETON, BrachiosaurusSkeletonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.FUTABASAURUS_SKELETON, FutabasaurusSkeletonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.LEGACY_FUTABASAURUS_SKELETON, LegacyFutabasaurusSkeletonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.PTERANODON_SKELETON, PteranodonSkeletonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.PACHYCEPHALOSAURUS_SKELETON, PachycephalosaurusSkeletonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.COMPSOGNATHUS_SKELETON, CompsognathusSkeletonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.VELOCIRAPTOR_SKELETON, VelociraptorSkeletonModel::createBodyLayer);

        modelLayerRegister.register(FossilsLegacyModels.ANU, AnuModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModels.FAILURESAURUS, FailuresaurusModel::createBodyLayer);

        modelLayerRegister.register(FossilsLegacyModels.EGG, EggModel::createBodyLayer);

        modelLayerRegister.register(FossilsLegacyModels.TIME_MACHINE_CLOCK, TimeMachineClockModel::createBodyLayer);
    }

    public static void menuScreenEvent(MenuScreenRegister menuScreenRegister) {
        menuScreenRegister.addMenuScreen(FossilsLegacyMenus.ANALYZER.get(), AnalyzerScreen::new);
        menuScreenRegister.addMenuScreen(FossilsLegacyMenus.ARCHAEOLOGY_WORKBENCH.get(), ArchaeologyWorkbenchScreen::new);
        menuScreenRegister.addMenuScreen(FossilsLegacyMenus.CULTIVATOR.get(), CultivatorScreen::new);
        menuScreenRegister.addMenuScreen(FossilsLegacyMenus.FEEDER.get(), FeederScreen::new);
        menuScreenRegister.addMenuScreen(FossilsLegacyMenus.TIME_MACHINE.get(), TimeMachineScreen::new);
    }
}
