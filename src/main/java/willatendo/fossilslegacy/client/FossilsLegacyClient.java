package willatendo.fossilslegacy.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.CatRenderer;
import net.minecraft.client.renderer.entity.ChestedHorseRenderer;
import net.minecraft.client.renderer.entity.CowRenderer;
import net.minecraft.client.renderer.entity.DolphinRenderer;
import net.minecraft.client.renderer.entity.FoxRenderer;
import net.minecraft.client.renderer.entity.GoatRenderer;
import net.minecraft.client.renderer.entity.HorseRenderer;
import net.minecraft.client.renderer.entity.LightningBoltRenderer;
import net.minecraft.client.renderer.entity.LlamaRenderer;
import net.minecraft.client.renderer.entity.OcelotRenderer;
import net.minecraft.client.renderer.entity.PandaRenderer;
import net.minecraft.client.renderer.entity.PigRenderer;
import net.minecraft.client.renderer.entity.PolarBearRenderer;
import net.minecraft.client.renderer.entity.RabbitRenderer;
import net.minecraft.client.renderer.entity.SheepRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.WolfRenderer;
import willatendo.fossilslegacy.client.model.BrachiosaurusModel;
import willatendo.fossilslegacy.client.model.DilophosaurusModel;
import willatendo.fossilslegacy.client.model.EggModel;
import willatendo.fossilslegacy.client.model.FailuresaurusModel;
import willatendo.fossilslegacy.client.model.MammothModel;
import willatendo.fossilslegacy.client.model.MosasaurusModel;
import willatendo.fossilslegacy.client.model.NautilusModel;
import willatendo.fossilslegacy.client.model.PlesiosaurusModel;
import willatendo.fossilslegacy.client.model.SmilodonModel;
import willatendo.fossilslegacy.client.model.StegosaurusModel;
import willatendo.fossilslegacy.client.model.TriceratopsModel;
import willatendo.fossilslegacy.client.model.VelociraptorModel;
import willatendo.fossilslegacy.client.model.fossils.BrachiosaurusSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.PlesiosaurusSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.PteranodonSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.TriceratopsSkeletonModel;
import willatendo.fossilslegacy.client.model.pteranodon.FlyingPteranodonModel;
import willatendo.fossilslegacy.client.model.pteranodon.GroundPteranodonModel;
import willatendo.fossilslegacy.client.model.tyrannosaurus.KnockedOutTyrannosaurusModel;
import willatendo.fossilslegacy.client.model.tyrannosaurus.TyrannosaurusModel;
import willatendo.fossilslegacy.client.render.BrachiosaurusRenderer;
import willatendo.fossilslegacy.client.render.DilophosaurusRenderer;
import willatendo.fossilslegacy.client.render.DilophosaurusVenomRenderer;
import willatendo.fossilslegacy.client.render.DrownedPirateRenderer;
import willatendo.fossilslegacy.client.render.EggRenderer;
import willatendo.fossilslegacy.client.render.FailuresaurusRenderer;
import willatendo.fossilslegacy.client.render.FossilRenderer;
import willatendo.fossilslegacy.client.render.MammothRenderer;
import willatendo.fossilslegacy.client.render.MosasaurusRenderer;
import willatendo.fossilslegacy.client.render.NautilusRenderer;
import willatendo.fossilslegacy.client.render.PlesiosaurusRenderer;
import willatendo.fossilslegacy.client.render.PteranodonRenderer;
import willatendo.fossilslegacy.client.render.SmilodonRenderer;
import willatendo.fossilslegacy.client.render.StegosaurusRenderer;
import willatendo.fossilslegacy.client.render.StoneHieroglyphRenderer;
import willatendo.fossilslegacy.client.render.ThrownJavelinRenderer;
import willatendo.fossilslegacy.client.render.TriceratopsRenderer;
import willatendo.fossilslegacy.client.render.TyrannosaurusRenderer;
import willatendo.fossilslegacy.client.render.VelociraptorRenderer;
import willatendo.fossilslegacy.client.render.ZombifiedPigmanRenderer;
import willatendo.fossilslegacy.client.screen.AnalyzerScreen;
import willatendo.fossilslegacy.client.screen.ArchaeologyWorkbenchScreen;
import willatendo.fossilslegacy.client.screen.CultivatorScreen;
import willatendo.fossilslegacy.client.screen.FeederScreen;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;
import willatendo.fossilslegacy.server.menu.FossilsLegacyMenus;

public class FossilsLegacyClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		MenuScreens.register(FossilsLegacyMenus.ANALYZER.get(), AnalyzerScreen::new);
		MenuScreens.register(FossilsLegacyMenus.ARCHAEOLOGY_WORKBENCH.get(), ArchaeologyWorkbenchScreen::new);
		MenuScreens.register(FossilsLegacyMenus.CULTIVATOR.get(), CultivatorScreen::new);
		MenuScreens.register(FossilsLegacyMenus.FEEDER.get(), FeederScreen::new);

		BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.JURASSIC_FERN.get(), RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.AXOLOTLSPAWN.get(), RenderType.cutout());

		EntityRendererRegistry.register(FossilsLegacyEntities.ANCIENT_LIGHTNING_BOLT.get(), LightningBoltRenderer::new);

		EntityRendererRegistry.register(FossilsLegacyEntities.FOSSIL.get(), FossilRenderer::new);

		EntityRendererRegistry.register(FossilsLegacyEntities.BRACHIOSAURUS.get(), BrachiosaurusRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.DILOPHOSAURUS.get(), DilophosaurusRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.MAMMOTH.get(), MammothRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.MOSASAURUS.get(), MosasaurusRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.NAUTILUS.get(), NautilusRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.PLESIOSAURUS.get(), PlesiosaurusRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.PTERANODON.get(), PteranodonRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.SMILODON.get(), SmilodonRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.STEGOSAURUS.get(), StegosaurusRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.TRICERATOPS.get(), TriceratopsRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.TYRANNOSAURUS.get(), TyrannosaurusRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.VELOCIRAPTOR.get(), VelociraptorRenderer::new);

		EntityRendererRegistry.register(FossilsLegacyEntities.EGG.get(), EggRenderer::new);

		EntityRendererRegistry.register(FossilsLegacyEntities.ZOMBIFIED_PIGMAN.get(), context -> new ZombifiedPigmanRenderer(context, ModelLayers.ZOMBIFIED_PIGLIN, ModelLayers.ZOMBIFIED_PIGLIN_INNER_ARMOR, ModelLayers.ZOMBIFIED_PIGLIN_OUTER_ARMOR, true));
		EntityRendererRegistry.register(FossilsLegacyEntities.DROWNED_PIRATE.get(), DrownedPirateRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.FAILURESAURUS.get(), FailuresaurusRenderer::new);

		EntityRendererRegistry.register(FossilsLegacyEntities.PREGNANT_CAT.get(), CatRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.PREGNANT_COW.get(), CowRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.PREGNANT_DOLPHIN.get(), DolphinRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.PREGNANT_DONKEY.get(), context -> new ChestedHorseRenderer<>(context, 0.87F, ModelLayers.DONKEY));
		EntityRendererRegistry.register(FossilsLegacyEntities.PREGNANT_FOX.get(), FoxRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.PREGNANT_GOAT.get(), GoatRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.PREGNANT_HORSE.get(), HorseRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.PREGNANT_LLAMA.get(), context -> new LlamaRenderer(context, ModelLayers.LLAMA));
		EntityRendererRegistry.register(FossilsLegacyEntities.PREGNANT_MAMMOTH.get(), MammothRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.PREGNANT_MULE.get(), context -> new ChestedHorseRenderer<>(context, 0.92F, ModelLayers.MULE));
		EntityRendererRegistry.register(FossilsLegacyEntities.PREGNANT_OCELOT.get(), OcelotRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.PREGNANT_PANDA.get(), PandaRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.PREGNANT_PIG.get(), PigRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.PREGNANT_POLAR_BEAR.get(), PolarBearRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.PREGNANT_RABBIT.get(), RabbitRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.PREGNANT_SHEEP.get(), SheepRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.PREGNANT_SMILODON.get(), SmilodonRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.PREGNANT_WOLF.get(), WolfRenderer::new);

		EntityRendererRegistry.register(FossilsLegacyEntities.THROWN_JAVELIN.get(), ThrownJavelinRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.THROWN_INCUBATED_EGG.get(), ThrownItemRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntities.DILOPHOSAURUS_VENOM.get(), DilophosaurusVenomRenderer::new);

		EntityRendererRegistry.register(FossilsLegacyEntities.STONE_TABLET.get(), StoneHieroglyphRenderer::new);

		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.BRACHIOSAURUS, BrachiosaurusModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.DILOPHOSAURUS, DilophosaurusModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.MAMMOTH, MammothModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.MOSASAURUS, MosasaurusModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.NAUTILUS, NautilusModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.PLESIOSAURUS, PlesiosaurusModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.GROUND_PTERANODON, GroundPteranodonModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.FLYING_PTERANODON, FlyingPteranodonModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.SMILODON, SmilodonModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.STEGOSAURUS, StegosaurusModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.TRICERATOPS, TriceratopsModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.TYRANNOSAURUS, TyrannosaurusModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.KNOCKED_OUT_TYRANNOSAURUS, KnockedOutTyrannosaurusModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.VELOCIRAPTOR, VelociraptorModel::createBodyLayer);

		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.TRICERATOPS_SKELETON, TriceratopsSkeletonModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.BRACHIOSAURUS_SKELETON, BrachiosaurusSkeletonModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.PLESIOSAURUS_SKELETON, PlesiosaurusSkeletonModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.PTERANODON_SKELETON, PteranodonSkeletonModel::createBodyLayer);

		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.FAILURESAURUS, FailuresaurusModel::createBodyLayer);

		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.EGG, EggModel::createBodyLayer);
	}
}
