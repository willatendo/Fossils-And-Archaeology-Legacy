package willatendo.fossilslegacy.client;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
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
import willatendo.fossilslegacy.client.screen.*;
import willatendo.fossilslegacy.server.block.entity.FossilsLegacyBlockEntities;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.menu.FossilsLegacyMenus;
import willatendo.simplelibrary.client.event.ClientEventsHolder;
import willatendo.simplelibrary.client.event.ModelLayerEntry;
import willatendo.simplelibrary.client.event.TexturedModelDataProvider;

import java.util.ArrayList;
import java.util.List;

public class FossilsLegacyClient {
    public static final ClientEventsHolder CLIENT_EVENTS_HOLDER = new ClientEventsHolder();

    public static void init() {
        FossilsLegacyClient.loadModelLayers();
        FossilsLegacyClient.loadModels();
        FossilsLegacyClient.bindScreens();
    }

    public static void loadModels() {
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), BrachiosaurusRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), DilophosaurusRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.MAMMOTH.get(), MammothRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.MOSASAURUS.get(), MosasaurusRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.NAUTILUS.get(), NautilusRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.FUTABASAURUS.get(), FutabasaurusRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.PTERANODON.get(), PteranodonRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.SMILODON.get(), SmilodonRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.STEGOSAURUS.get(), StegosaurusRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.TRICERATOPS.get(), TriceratopsRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.TYRANNOSAURUS.get(), TyrannosaurusRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.VELOCIRAPTOR.get(), VelociraptorRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.CARNOTAURUS.get(), CarnotaurusRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.CRYOLOPHOSAURUS.get(), CryolophosaurusRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.THERIZINOSAURUS.get(), TherizinosaurusRenderer::new);

        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.EGG.get(), EggRenderer::new);

        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.ANU.get(), AnuRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.FAILURESAURUS.get(), FailuresaurusRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get(), context -> new TamedZombifiedPiglinRenderer(context, ModelLayers.ZOMBIFIED_PIGLIN, ModelLayers.ZOMBIFIED_PIGLIN_INNER_ARMOR, ModelLayers.ZOMBIFIED_PIGLIN_OUTER_ARMOR, true));

        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.PREGNANT_CAT.get(), CatRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.PREGNANT_COW.get(), CowRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.PREGNANT_DOLPHIN.get(), DolphinRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.PREGNANT_DONKEY.get(), context -> new ChestedHorseRenderer<>(context, 0.87F, ModelLayers.DONKEY));
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.PREGNANT_FOX.get(), FoxRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.PREGNANT_GOAT.get(), GoatRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.PREGNANT_HORSE.get(), HorseRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.PREGNANT_LLAMA.get(), context -> new LlamaRenderer(context, ModelLayers.LLAMA));
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.PREGNANT_MAMMOTH.get(), MammothRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.PREGNANT_MULE.get(), context -> new ChestedHorseRenderer<>(context, 0.92F, ModelLayers.MULE));
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.PREGNANT_OCELOT.get(), OcelotRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.PREGNANT_PANDA.get(), PandaRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.PREGNANT_PIG.get(), PigRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.PREGNANT_POLAR_BEAR.get(), PolarBearRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.PREGNANT_RABBIT.get(), RabbitRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), SheepRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.PREGNANT_SMILODON.get(), SmilodonRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.PREGNANT_WOLF.get(), WolfRenderer::new);

        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.THROWN_JAVELIN.get(), ThrownJavelinRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.THROWN_INCUBATED_EGG.get(), ThrownItemRenderer::new);
        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.DILOPHOSAURUS_VENOM.get(), DilophosaurusVenomRenderer::new);

        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.ANCIENT_LIGHTNING_BOLT.get(), LightningBoltRenderer::new);

        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.FOSSIL.get(), FossilRenderer::new);

        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyEntityTypes.STONE_TABLET.get(), StoneTabletRenderer::new);

        CLIENT_EVENTS_HOLDER.addModel(FossilsLegacyBlockEntities.TIME_MACHINE.get(), TimeMachineClockRenderer::new);
    }

    public static void loadModelLayers() {
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.BRACHIOSAURUS, BrachiosaurusModel::createBodyLayer);
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.DILOPHOSAURUS, DilophosaurusModel::createBodyLayer);
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.MAMMOTH, MammothModel::createBodyLayer);
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.MOSASAURUS, MosasaurusModel::createBodyLayer);
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.NAUTILUS, NautilusModel::createBodyLayer);
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.FUTABASAURUS, FutabasaurusModel::createBodyLayer);
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.GROUND_PTERANODON, GroundPteranodonModel::createBodyLayer);
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.FLYING_PTERANODON, FlyingPteranodonModel::createBodyLayer);
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.LANDING_PTERANODON, LandingPteranodonModel::createBodyLayer);
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.SMILODON, SmilodonModel::createBodyLayer);
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.STEGOSAURUS, StegosaurusModel::createBodyLayer);
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.TRICERATOPS, TriceratopsModel::createBodyLayer);
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.TYRANNOSAURUS, TyrannosaurusModel::createBodyLayer);
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.KNOCKED_OUT_TYRANNOSAURUS, KnockedOutTyrannosaurusModel::createBodyLayer);
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.VELOCIRAPTOR, VelociraptorModel::createBodyLayer);
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.CARNOTAURUS, CarnotaurusModel::createBodyLayer);
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.CRYOLOPHOSAURUS, CryolophosaurusModel::createBodyLayer);
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.THERIZINOSAURUS, TherizinosaurusModel::createBodyLayer);

        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.TRICERATOPS_SKELETON, TriceratopsSkeletonModel::createBodyLayer);
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.BRACHIOSAURUS_SKELETON, BrachiosaurusSkeletonModel::createBodyLayer);
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.PLESIOSAURUS_SKELETON, FutabasaurusSkeletonModel::createBodyLayer);
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.PTERANODON_SKELETON, PteranodonSkeletonModel::createBodyLayer);

        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.ANU, AnuModel::createBodyLayer);
        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.FAILURESAURUS, FailuresaurusModel::createBodyLayer);

        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.EGG, EggModel::createBodyLayer);

        CLIENT_EVENTS_HOLDER.addModelLayer(FossilsLegacyModels.TIME_MACHINE_CLOCK, TimeMachineClockModel::createBodyLayer);
    }

    public static void bindScreens() {
        CLIENT_EVENTS_HOLDER.addMenuScreen(FossilsLegacyMenus.ANALYZER.get(), AnalyzerScreen::new);
        CLIENT_EVENTS_HOLDER.addMenuScreen(FossilsLegacyMenus.ARCHAEOLOGY_WORKBENCH.get(), ArchaeologyWorkbenchScreen::new);
        CLIENT_EVENTS_HOLDER.addMenuScreen(FossilsLegacyMenus.CULTIVATOR.get(), CultivatorScreen::new);
        CLIENT_EVENTS_HOLDER.addMenuScreen(FossilsLegacyMenus.FEEDER.get(), FeederScreen::new);
        CLIENT_EVENTS_HOLDER.addMenuScreen(FossilsLegacyMenus.TIME_MACHINE.get(), TimeMachineScreen::new);
    }

    public static final record EntityModelEntry<T extends Entity>(EntityType<T> entityType,
                                                                  EntityRendererProvider<T> entityRendererProvider) {
    }

    public static final record BlockModelEntry<T extends BlockEntity>(BlockEntityType<T> blockEntityType,
                                                                      BlockEntityRendererProvider<T> blockEntityRendererProvider) {
    }

    public static final record ModelLayerEntry(ModelLayerLocation modelLayerLocation,
                                               TexturedModelDataProvider texturedModelDataProvider) {
    }
}
