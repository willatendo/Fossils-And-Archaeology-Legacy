package willatendo.fossilslegacy.client;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.*;
import willatendo.fossilslegacy.client.model.AnuModel;
import willatendo.fossilslegacy.client.model.EggModel;
import willatendo.fossilslegacy.client.model.FailuresaurusModel;
import willatendo.fossilslegacy.client.model.TimeMachineClockModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.NautilusModel;
import willatendo.fossilslegacy.client.render.*;
import willatendo.fossilslegacy.client.screen.*;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.block.entity.FossilsLegacyBlockEntityTypes;
import willatendo.fossilslegacy.server.block.properties.FossilsLegacyWoodTypes;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.menu.FossilsLegacyMenuTypes;
import willatendo.simplelibrary.client.event.registry.*;

public final class FossilsLegacyClient {
    public static void signSheets() {
        FossilsLegacyWoodTypes.register(FossilsLegacyWoodTypes.CALAMITES);
        FossilsLegacyWoodTypes.register(FossilsLegacyWoodTypes.LEPIDODENDRON);
        FossilsLegacyWoodTypes.register(FossilsLegacyWoodTypes.SIGILLARIA);
    }

    public static void itemColorRegistry(ItemColorRegistry itemColorRegistry) {
        itemColorRegistry.registerLeavesColor(FossilsLegacyBlocks.CALAMITES_LEAVES.get(), FossilsLegacyBlocks.LEPIDODENDRON_LEAVES.get(), FossilsLegacyBlocks.SIGILLARIA_LEAVES.get());
    }

    public static void blockColorRegistry(BlockColorRegistry blockColorRegistry) {
        blockColorRegistry.registerLeavesColor(FossilsLegacyBlocks.CALAMITES_LEAVES.get(), FossilsLegacyBlocks.LEPIDODENDRON_LEAVES.get(), FossilsLegacyBlocks.SIGILLARIA_LEAVES.get(), FossilsLegacyBlocks.JURASSIC_FERN.get());
    }

    public static void keyMappingEvent(KeyMappingRegistry keyMappingRegister) {
        keyMappingRegister.register(FossilsLegacyKeys.SINK);
        keyMappingRegister.register(FossilsLegacyKeys.NAVIGATE_LEFT);
        keyMappingRegister.register(FossilsLegacyKeys.NAVIGATE_RIGHT);
        keyMappingRegister.register(FossilsLegacyKeys.APPLY_GENE);
    }

    public static void modelEvent(ModelRegistry modelRegister) {
        modelRegister.register(FossilsLegacyEntityTypes.ANKYLOSAURUS.get(), AnkylosaurusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), BrachiosaurusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), DilophosaurusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.DODO.get(), DodoRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.MOA.get(), MoaRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.MAMMOTH.get(), MammothRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.MOSASAURUS.get(), MosasaurusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.NAUTILUS.get(), NautilusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.FUTABASAURUS.get(), FutabasaurusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.GALLIMIMUS.get(), GallimimusRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.PTERANODON.get(), PteranodonRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.SMILODON.get(), SmilodonRenderer::new);
        modelRegister.register(FossilsLegacyEntityTypes.SPINOSAURUS.get(), SpinosaurusRenderer::new);
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

        modelRegister.register(FossilsLegacyBlockEntityTypes.PALEONTOLOGY_TABLE.get(), PalaeontologyTableRenderer::new);
        modelRegister.register(FossilsLegacyBlockEntityTypes.TIME_MACHINE.get(), TimeMachineClockRenderer::new);
        modelRegister.register(FossilsLegacyBlockEntityTypes.LEPIDODENDRON_SIGN.get(), SignRenderer::new);
        modelRegister.register(FossilsLegacyBlockEntityTypes.LEPIDODENDRON_HANGING_SIGN.get(), HangingSignRenderer::new);
    }

    public static void modelLayerEvent(ModelLayerRegistry modelLayerRegister) {
        modelLayerRegister.register(FossilsLegacyModelLayers.ANU, AnuModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.EGG, EggModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.FAILURESAURUS, FailuresaurusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.NAUTILUS, NautilusModel::createBodyLayer);
        modelLayerRegister.register(FossilsLegacyModelLayers.TIME_MACHINE_CLOCK, TimeMachineClockModel::createBodyLayer);
    }

    public static void menuScreenEvent(MenuScreenRegistry menuScreenRegister) {
        menuScreenRegister.addMenuScreen(FossilsLegacyMenuTypes.ANALYZER.get(), AnalyzerScreen::new);
        menuScreenRegister.addMenuScreen(FossilsLegacyMenuTypes.ARCHAEOLOGY_WORKBENCH.get(), ArchaeologyWorkbenchScreen::new);
        menuScreenRegister.addMenuScreen(FossilsLegacyMenuTypes.CULTIVATOR.get(), CultivatorScreen::new);
        menuScreenRegister.addMenuScreen(FossilsLegacyMenuTypes.FEEDER.get(), FeederScreen::new);
        menuScreenRegister.addMenuScreen(FossilsLegacyMenuTypes.GENE_MODIFICATION.get(), GeneModificationTableScreen::new);
        menuScreenRegister.addMenuScreen(FossilsLegacyMenuTypes.PALAEONTOLOGY_TABLE.get(), PalaeontologyTableScreen::new);
        menuScreenRegister.addMenuScreen(FossilsLegacyMenuTypes.TIME_MACHINE.get(), TimeMachineScreen::new);
    }
}
