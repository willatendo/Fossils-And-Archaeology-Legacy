package willatendo.fossilslegacy.client;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.stats.RecipeBookSettings;
import net.minecraft.world.inventory.RecipeBookType;
import willatendo.fossilslegacy.client.model.AnuModel;
import willatendo.fossilslegacy.client.model.EggModel;
import willatendo.fossilslegacy.client.model.FailuresaurusModel;
import willatendo.fossilslegacy.client.model.TimeMachineClockModel;
import willatendo.fossilslegacy.client.model.dinosaur.*;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.*;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.pteranodon.FlyingPteranodonModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.pteranodon.GroundPteranodonModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.pteranodon.LandingPteranodonModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.tyrannosaurus.KnockedOutTyrannosaurusModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.tyrannosaurus.TyrannosaurusModel;
import willatendo.fossilslegacy.client.model.fossils.*;
import willatendo.fossilslegacy.client.model.fossils.legacy.LegacyBrachiosaurusSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.legacy.LegacyFutabasaurusSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.legacy.PteranodonSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.legacy.TriceratopsSkeletonModel;
import willatendo.fossilslegacy.client.render.*;
import willatendo.fossilslegacy.client.screen.*;
import willatendo.fossilslegacy.server.block.FossilsLegacyWoodTypes;
import willatendo.fossilslegacy.server.block.entity.FossilsLegacyBlockEntityTypes;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.inventory.FossilsLegacyRecipeBookTypes;
import willatendo.fossilslegacy.server.menu.FossilsLegacyMenuTypes;
import willatendo.simplelibrary.client.event.KeyMappingRegister;
import willatendo.simplelibrary.client.event.MenuScreenRegister;
import willatendo.simplelibrary.client.event.ModelLayerRegister;
import willatendo.simplelibrary.client.event.ModelRegister;

public class FossilsLegacyClient {
    public static void signSheets() {
        FossilsLegacyWoodTypes.register(FossilsLegacyWoodTypes.LEPIDODENDRON);
    }

    public static void keyMappingEvent(KeyMappingRegister keyMappingRegister) {
        keyMappingRegister.register(FossilsLegacyKeys.SINK);
    }

    public static void modelEvent(ModelRegister modelRegister) {
        modelRegister.register(FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), BrachiosaurusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), DilophosaurusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.DODO.get(), DodoRenderer::new);
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
        modelRegister.register(FossilsLegacyEntityTypes.PREGNANT_ARMADILLO.get(), ArmadilloRenderer::new);
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

        modelRegister.register(FossilsLegacyBlockEntityTypes.TIME_MACHINE.get(), TimeMachineClockRenderer::new);
        modelRegister.register(FossilsLegacyBlockEntityTypes.LEPIDODENDRON_SIGN.get(), SignRenderer::new);
        modelRegister.register(FossilsLegacyBlockEntityTypes.LEPIDODENDRON_HANGING_SIGN.get(), HangingSignRenderer::new);
    }

    public static void modelLayerEvent(ModelLayerRegister modelLayerRegister) {
        modelLayerRegister.register(FossilsLegacyModelLayers.ANU, AnuModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.BRACHIOSAURUS.getFirst(), BrachiosaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.BRACHIOSAURUS.getSecond(), LegacyBrachiosaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.BRACHIOSAURUS_SKELETON.getFirst(), BrachiosaurusSkeletonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.BRACHIOSAURUS_SKELETON.getSecond(), LegacyBrachiosaurusSkeletonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.CARNOTAURUS, CarnotaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.COMPSOGNATHUS, CompsognathusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.COMPSOGNATHUS_SKELETON, CompsognathusSkeletonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.CRYOLOPHOSAURUS, CryolophosaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.DILOPHOSAURUS, DilophosaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.DODO, DodoModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.EGG, EggModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.FAILURESAURUS, FailuresaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.FUTABASAURUS.getFirst(), FutabasaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.FUTABASAURUS.getSecond(), LegacyFutabasaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.FUTABASAURUS_SKELETON.getFirst(), FutabasaurusSkeletonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.FUTABASAURUS_SKELETON.getSecond(), LegacyFutabasaurusSkeletonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.MAMMOTH, MammothModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.MOSASAURUS, MosasaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.NAUTILUS, NautilusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.PACHYCEPHALOSAURUS, PachycephalosaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.PACHYCEPHALOSAURUS_SKELETON, PachycephalosaurusSkeletonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.PTERANODON_GROUND, GroundPteranodonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.PTERANODON_FLYING, FlyingPteranodonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.PTERANODON_LANDING, LandingPteranodonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.PTERANODON_SKELETON, PteranodonSkeletonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.SMILODON, SmilodonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.STEGOSAURUS, StegosaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.THERIZINOSAURUS, TherizinosaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.TIME_MACHINE_CLOCK, TimeMachineClockModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.TRICERATOPS.getFirst(), TriceratopsModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.TRICERATOPS.getSecond(), LegacyTriceratopsModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.TRICERATOPS_SKELETON, TriceratopsSkeletonModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.TYRANNOSAURUS, TyrannosaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.TYRANNOSAURUS_KNOCKED_OUT, KnockedOutTyrannosaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.VELOCIRAPTOR.getFirst(), VelociraptorModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.VELOCIRAPTOR.getSecond(), LegacyVelociraptorModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.VELOCIRAPTOR_SKELETON, VelociraptorSkeletonModel::createBodyLayer);
    }

    public static void menuScreenEvent(MenuScreenRegister menuScreenRegister) {
        menuScreenRegister.addMenuScreen(FossilsLegacyMenuTypes.ANALYZER.get(), AnalyzerScreen::new);
        menuScreenRegister.addMenuScreen(FossilsLegacyMenuTypes.ARCHAEOLOGY_WORKBENCH.get(), ArchaeologyWorkbenchScreen::new);
        menuScreenRegister.addMenuScreen(FossilsLegacyMenuTypes.CULTIVATOR.get(), CultivatorScreen::new);
        menuScreenRegister.addMenuScreen(FossilsLegacyMenuTypes.FEEDER.get(), FeederScreen::new);
        menuScreenRegister.addMenuScreen(FossilsLegacyMenuTypes.TIME_MACHINE.get(), TimeMachineScreen::new);
    }
}
