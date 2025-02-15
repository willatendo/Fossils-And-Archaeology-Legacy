package willatendo.fossilslegacy.client;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.horse.Mule;
import willatendo.fossilslegacy.client.model.*;
import willatendo.fossilslegacy.client.model.dinosaur.NautilusModel;
import willatendo.fossilslegacy.client.render.*;
import willatendo.fossilslegacy.client.screen.*;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.FAWoodTypes;
import willatendo.fossilslegacy.server.block.entity.FABlockEntityTypes;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.menu.FAMenuTypes;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.client.event.registry.*;

public final class FossilsLegacyClient {
    public static void signSheets() {
        FAWoodTypes.register(FAWoodTypes.CALAMITES);
        FAWoodTypes.register(FAWoodTypes.LEPIDODENDRON);
        FAWoodTypes.register(FAWoodTypes.SIGILLARIA);
    }

    public static void blockColorRegistry(BlockColorRegistry blockColorRegistry) {
        blockColorRegistry.registerLeavesColor(FABlocks.CALAMITES_LEAVES.get(), FABlocks.LEPIDODENDRON_LEAVES.get(), FABlocks.SIGILLARIA_LEAVES.get(), FABlocks.JURASSIC_FERN.get());
    }

    public static void keyMappingEvent(KeyMappingRegistry keyMappingRegister) {
        keyMappingRegister.register(FAKeys.APPLY_GENE);
        keyMappingRegister.register(FAKeys.NAVIGATE_LEFT);
        keyMappingRegister.register(FAKeys.NAVIGATE_RIGHT);
        keyMappingRegister.register(FAKeys.SINK);
    }

    public static void modelEvent(ModelRegistry modelRegister) {
        modelRegister.register(FAEntityTypes.ANKYLOSAURUS.get(), AnkylosaurusRenderer::new);
        modelRegister.register(FAEntityTypes.BRACHIOSAURUS.get(), BrachiosaurusRenderer::new);
        modelRegister.register(FAEntityTypes.DILOPHOSAURUS.get(), DilophosaurusRenderer::new);
        modelRegister.register(FAEntityTypes.DIMETRODON.get(), DimetrodonRenderer::new);
        modelRegister.register(FAEntityTypes.DODO.get(), DodoRenderer::new);
        modelRegister.register(FAEntityTypes.MOA.get(), MoaRenderer::new);
        modelRegister.register(FAEntityTypes.MAMMOTH.get(), MammothRenderer::new);
        modelRegister.register(FAEntityTypes.MOSASAURUS.get(), MosasaurusRenderer::new);
        modelRegister.register(FAEntityTypes.NAUTILUS.get(), NautilusRenderer::new);
        modelRegister.register(FAEntityTypes.FUTABASAURUS.get(), FutabasaurusRenderer::new);
        modelRegister.register(FAEntityTypes.GALLIMIMUS.get(), GallimimusRenderer::new);
        modelRegister.register(FAEntityTypes.PTERANODON.get(), PteranodonRenderer::new);
        modelRegister.register(FAEntityTypes.SMILODON.get(), SmilodonRenderer::new);
        modelRegister.register(FAEntityTypes.SPINOSAURUS.get(), SpinosaurusRenderer::new);
        modelRegister.register(FAEntityTypes.STEGOSAURUS.get(), StegosaurusRenderer::new);
        modelRegister.register(FAEntityTypes.TRICERATOPS.get(), TriceratopsRenderer::new);
        modelRegister.register(FAEntityTypes.TYRANNOSAURUS.get(), TyrannosaurusRenderer::new);
        modelRegister.register(FAEntityTypes.VELOCIRAPTOR.get(), VelociraptorRenderer::new);
        modelRegister.register(FAEntityTypes.CARNOTAURUS.get(), CarnotaurusRenderer::new);
        modelRegister.register(FAEntityTypes.CRYOLOPHOSAURUS.get(), CryolophosaurusRenderer::new);
        modelRegister.register(FAEntityTypes.THERIZINOSAURUS.get(), TherizinosaurusRenderer::new);
        modelRegister.register(FAEntityTypes.PACHYCEPHALOSAURUS.get(), PachycephalosaurusRenderer::new);
        modelRegister.register(FAEntityTypes.COMPSOGNATHUS.get(), CompsognathusRenderer::new);
        modelRegister.register(FAEntityTypes.EGG.get(), EggRenderer::new);
        modelRegister.register(FAEntityTypes.ANU.get(), AnuRenderer::new);
        modelRegister.register(FAEntityTypes.FAILURESAURUS.get(), FailuresaurusRenderer::new);
        modelRegister.register(FAEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get(), context -> new TamedZombifiedPiglinRenderer(context, ModelLayers.ZOMBIFIED_PIGLIN, ModelLayers.ZOMBIFIED_PIGLIN_BABY, ModelLayers.ZOMBIFIED_PIGLIN_INNER_ARMOR, ModelLayers.ZOMBIFIED_PIGLIN_OUTER_ARMOR, ModelLayers.ZOMBIFIED_PIGLIN_BABY_INNER_ARMOR, ModelLayers.ZOMBIFIED_PIGLIN_BABY_OUTER_ARMOR));
        modelRegister.register(FAEntityTypes.PREGNANT_ARMADILLO.get(), ArmadilloRenderer::new);
        modelRegister.register(FAEntityTypes.PREGNANT_CAT.get(), CatRenderer::new);
        modelRegister.register(FAEntityTypes.PREGNANT_COW.get(), CowRenderer::new);
        modelRegister.register(FAEntityTypes.PREGNANT_DOLPHIN.get(), DolphinRenderer::new);
        modelRegister.register(FAEntityTypes.PREGNANT_DONKEY.get(), context -> new DonkeyRenderer<Donkey>(context, ModelLayers.DONKEY, ModelLayers.DONKEY_BABY, false));
        modelRegister.register(FAEntityTypes.PREGNANT_FOX.get(), FoxRenderer::new);
        modelRegister.register(FAEntityTypes.PREGNANT_GOAT.get(), GoatRenderer::new);
        modelRegister.register(FAEntityTypes.PREGNANT_HORSE.get(), HorseRenderer::new);
        modelRegister.register(FAEntityTypes.PREGNANT_LLAMA.get(), context -> new LlamaRenderer(context, ModelLayers.LLAMA, ModelLayers.LLAMA_BABY));
        modelRegister.register(FAEntityTypes.PREGNANT_MAMMOTH.get(), MammothRenderer::new);
        modelRegister.register(FAEntityTypes.PREGNANT_MULE.get(), context -> new DonkeyRenderer<Mule>(context, ModelLayers.MULE, ModelLayers.MULE_BABY, true));
        modelRegister.register(FAEntityTypes.PREGNANT_OCELOT.get(), OcelotRenderer::new);
        modelRegister.register(FAEntityTypes.PREGNANT_PANDA.get(), PandaRenderer::new);
        modelRegister.register(FAEntityTypes.PREGNANT_PIG.get(), PigRenderer::new);
        modelRegister.register(FAEntityTypes.PREGNANT_POLAR_BEAR.get(), PolarBearRenderer::new);
        modelRegister.register(FAEntityTypes.PREGNANT_RABBIT.get(), RabbitRenderer::new);
        modelRegister.register(FAEntityTypes.PREGNANT_SHEEP.get(), SheepRenderer::new);
        modelRegister.register(FAEntityTypes.PREGNANT_SMILODON.get(), SmilodonRenderer::new);
        modelRegister.register(FAEntityTypes.PREGNANT_WOLF.get(), WolfRenderer::new);
        modelRegister.register(FAEntityTypes.THROWN_JAVELIN.get(), ThrownJavelinRenderer::new);
        modelRegister.register(FAEntityTypes.THROWN_INCUBATED_EGG.get(), ThrownItemRenderer::new);
        modelRegister.register(FAEntityTypes.DILOPHOSAURUS_VENOM.get(), DilophosaurusVenomRenderer::new);
        modelRegister.register(FAEntityTypes.ANCIENT_LIGHTNING_BOLT.get(), LightningBoltRenderer::new);
        modelRegister.register(FAEntityTypes.FOSSIL.get(), FossilRenderer::new);
        modelRegister.register(FAEntityTypes.STONE_TABLET.get(), StoneTabletRenderer::new);

        modelRegister.register(FAEntityTypes.CALAMITES_BOAT.get(), context -> new BoatRenderer(context, FAModelLayers.CALAMITES_BOAT));
        modelRegister.register(FAEntityTypes.LEPIDODENDRON_BOAT.get(), context -> new BoatRenderer(context, FAModelLayers.LEPIDODENDRON_BOAT));
        modelRegister.register(FAEntityTypes.SIGILLARIA_BOAT.get(), context -> new BoatRenderer(context, FAModelLayers.SIGILLARIA_BOAT));
        modelRegister.register(FAEntityTypes.CALAMITES_CHEST_BOAT.get(), context -> new BoatRenderer(context, FAModelLayers.CALAMITES_CHEST_BOAT));
        modelRegister.register(FAEntityTypes.LEPIDODENDRON_CHEST_BOAT.get(), context -> new BoatRenderer(context, FAModelLayers.LEPIDODENDRON_CHEST_BOAT));
        modelRegister.register(FAEntityTypes.SIGILLARIA_CHEST_BOAT.get(), context -> new BoatRenderer(context, FAModelLayers.SIGILLARIA_CHEST_BOAT));

        modelRegister.register(FABlockEntityTypes.CULTIVATOR.get(), CultivatorBlockEntityRenderer::new);
        modelRegister.register(FABlockEntityTypes.FOSSILS_SIGN.get(), SignRenderer::new);
        modelRegister.register(FABlockEntityTypes.FOSSILS_HANGING_SIGN.get(), HangingSignRenderer::new);
        modelRegister.register(FABlockEntityTypes.TIME_MACHINE.get(), TimeMachineClockRenderer::new);
        modelRegister.register(FABlockEntityTypes.VASE.get(), VaseRenderer::new);
    }

    public static void specialModelsEvent(SpecialRendererRegistry specialRendererRegistry) {
        specialRendererRegistry.register(FAUtils.resource("articulated_fossil"), ArticulatedFossilSpecialRenderer.Unbaked.MAP_CODEC);
    }

    public static void modelLayerEvent(ModelLayerRegistry modelLayerRegister) {
        modelLayerRegister.register(FAModelLayers.ANIMAL_FETUS, AnimalFetusModel::createBodyLayer);
        modelLayerRegister.register(FAModelLayers.ANU, () -> LayerDefinition.create(PlayerModel.createMesh(CubeDeformation.NONE, false), 64, 32));
        modelLayerRegister.register(FAModelLayers.REGULAR_EGG, EggModel::createRegularBodyLayer);
        modelLayerRegister.register(FAModelLayers.SMALL_EGG, EggModel::createSmallBodyLayer);
        modelLayerRegister.register(FAModelLayers.FAILURESAURUS, FailuresaurusModel::createBodyLayer);
        modelLayerRegister.register(FAModelLayers.NAUTILUS, NautilusModel::createBodyLayer);
        modelLayerRegister.register(FAModelLayers.PLANT_EMBRYO, PlantEmbryoModel::createBodyLayer);
        modelLayerRegister.register(FAModelLayers.TIME_MACHINE_CLOCK, TimeMachineClockModel::createBodyLayer);
        LayerDefinition boatModel = BoatModel.createBoatModel();
        LayerDefinition chestBoatModel = BoatModel.createChestBoatModel();
        modelLayerRegister.register(FAModelLayers.CALAMITES_BOAT, () -> boatModel);
        modelLayerRegister.register(FAModelLayers.LEPIDODENDRON_BOAT, () -> boatModel);
        modelLayerRegister.register(FAModelLayers.SIGILLARIA_BOAT, () -> boatModel);
        modelLayerRegister.register(FAModelLayers.CALAMITES_CHEST_BOAT, () -> chestBoatModel);
        modelLayerRegister.register(FAModelLayers.LEPIDODENDRON_CHEST_BOAT, () -> chestBoatModel);
        modelLayerRegister.register(FAModelLayers.SIGILLARIA_CHEST_BOAT, () -> chestBoatModel);
    }

    public static void menuScreenEvent(MenuScreenRegistry menuScreenRegister) {
        menuScreenRegister.addMenuScreen(FAMenuTypes.ANALYZER.get(), AnalyzerScreen::new);
        menuScreenRegister.addMenuScreen(FAMenuTypes.ARCHAEOLOGY_WORKBENCH.get(), ArchaeologyWorkbenchScreen::new);
        menuScreenRegister.addMenuScreen(FAMenuTypes.CULTIVATOR.get(), CultivatorScreen::new);
        menuScreenRegister.addMenuScreen(FAMenuTypes.FEEDER.get(), FeederScreen::new);
        menuScreenRegister.addMenuScreen(FAMenuTypes.GENE_MODIFICATION.get(), GeneModificationTableScreen::new);
        menuScreenRegister.addMenuScreen(FAMenuTypes.PALAEONTOLOGY_TABLE.get(), PalaeontologyTableScreen::new);
        menuScreenRegister.addMenuScreen(FAMenuTypes.TIME_MACHINE.get(), TimeMachineScreen::new);
    }
}
