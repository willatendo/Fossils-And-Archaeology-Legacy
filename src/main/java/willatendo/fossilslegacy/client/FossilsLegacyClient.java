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
import willatendo.fossilslegacy.client.model.AnuModel;
import willatendo.fossilslegacy.client.model.BrachiosaurusModel;
import willatendo.fossilslegacy.client.model.DilophosaurusModel;
import willatendo.fossilslegacy.client.model.EggModel;
import willatendo.fossilslegacy.client.model.FailuresaurusModel;
import willatendo.fossilslegacy.client.model.FutabasaurusModel;
import willatendo.fossilslegacy.client.model.MammothModel;
import willatendo.fossilslegacy.client.model.MosasaurusModel;
import willatendo.fossilslegacy.client.model.NautilusModel;
import willatendo.fossilslegacy.client.model.SmilodonModel;
import willatendo.fossilslegacy.client.model.StegosaurusModel;
import willatendo.fossilslegacy.client.model.TriceratopsModel;
import willatendo.fossilslegacy.client.model.VelociraptorModel;
import willatendo.fossilslegacy.client.model.fossils.BrachiosaurusSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.FutabasaurusSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.PteranodonSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.TriceratopsSkeletonModel;
import willatendo.fossilslegacy.client.model.pteranodon.FlyingPteranodonModel;
import willatendo.fossilslegacy.client.model.pteranodon.GroundPteranodonModel;
import willatendo.fossilslegacy.client.model.pteranodon.LandingPteranodonModel;
import willatendo.fossilslegacy.client.model.tyrannosaurus.KnockedOutTyrannosaurusModel;
import willatendo.fossilslegacy.client.model.tyrannosaurus.TyrannosaurusModel;
import willatendo.fossilslegacy.client.render.AnuRenderer;
import willatendo.fossilslegacy.client.render.BrachiosaurusRenderer;
import willatendo.fossilslegacy.client.render.DilophosaurusRenderer;
import willatendo.fossilslegacy.client.render.DilophosaurusVenomRenderer;
import willatendo.fossilslegacy.client.render.EggRenderer;
import willatendo.fossilslegacy.client.render.FailuresaurusRenderer;
import willatendo.fossilslegacy.client.render.FossilRenderer;
import willatendo.fossilslegacy.client.render.FutabasaurusRenderer;
import willatendo.fossilslegacy.client.render.MammothRenderer;
import willatendo.fossilslegacy.client.render.MosasaurusRenderer;
import willatendo.fossilslegacy.client.render.NautilusRenderer;
import willatendo.fossilslegacy.client.render.PteranodonRenderer;
import willatendo.fossilslegacy.client.render.SmilodonRenderer;
import willatendo.fossilslegacy.client.render.StegosaurusRenderer;
import willatendo.fossilslegacy.client.render.StoneHieroglyphRenderer;
import willatendo.fossilslegacy.client.render.TamedZombifiedPiglinRenderer;
import willatendo.fossilslegacy.client.render.ThrownJavelinRenderer;
import willatendo.fossilslegacy.client.render.TriceratopsRenderer;
import willatendo.fossilslegacy.client.render.TyrannosaurusRenderer;
import willatendo.fossilslegacy.client.render.VelociraptorRenderer;
import willatendo.fossilslegacy.client.screen.AnalyzerScreen;
import willatendo.fossilslegacy.client.screen.ArchaeologyWorkbenchScreen;
import willatendo.fossilslegacy.client.screen.CultivatorScreen;
import willatendo.fossilslegacy.client.screen.FeederScreen;
import willatendo.fossilslegacy.experiments.client.FossilsExperimentsClient;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.menu.FossilsLegacyMenus;

public class FossilsLegacyClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		FossilsExperimentsClient.init();

		FossilsLegacyKeys.init();

		MenuScreens.register(FossilsLegacyMenus.ANALYZER.get(), AnalyzerScreen::new);
		MenuScreens.register(FossilsLegacyMenus.ARCHAEOLOGY_WORKBENCH.get(), ArchaeologyWorkbenchScreen::new);
		MenuScreens.register(FossilsLegacyMenus.CULTIVATOR.get(), CultivatorScreen::new);
		MenuScreens.register(FossilsLegacyMenus.FEEDER.get(), FeederScreen::new);

		BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.JURASSIC_FERN.get(), RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.AXOLOTLSPAWN.get(), RenderType.cutout());

		EntityRendererRegistry.register(FossilsLegacyEntityTypes.ANCIENT_LIGHTNING_BOLT.get(), LightningBoltRenderer::new);

		EntityRendererRegistry.register(FossilsLegacyEntityTypes.FOSSIL.get(), FossilRenderer::new);

		EntityRendererRegistry.register(FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), BrachiosaurusRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), DilophosaurusRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.MAMMOTH.get(), MammothRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.MOSASAURUS.get(), MosasaurusRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.NAUTILUS.get(), NautilusRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.FUTABASAURUS.get(), FutabasaurusRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.PTERANODON.get(), PteranodonRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.SMILODON.get(), SmilodonRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.STEGOSAURUS.get(), StegosaurusRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.TRICERATOPS.get(), TriceratopsRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.TYRANNOSAURUS.get(), TyrannosaurusRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.VELOCIRAPTOR.get(), VelociraptorRenderer::new);

		EntityRendererRegistry.register(FossilsLegacyEntityTypes.EGG.get(), EggRenderer::new);

		EntityRendererRegistry.register(FossilsLegacyEntityTypes.ANU.get(), AnuRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.FAILURESAURUS.get(), FailuresaurusRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get(), context -> new TamedZombifiedPiglinRenderer(context, ModelLayers.ZOMBIFIED_PIGLIN, ModelLayers.ZOMBIFIED_PIGLIN_INNER_ARMOR, ModelLayers.ZOMBIFIED_PIGLIN_OUTER_ARMOR, true));

		EntityRendererRegistry.register(FossilsLegacyEntityTypes.PREGNANT_CAT.get(), CatRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.PREGNANT_COW.get(), CowRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.PREGNANT_DOLPHIN.get(), DolphinRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.PREGNANT_DONKEY.get(), context -> new ChestedHorseRenderer<>(context, 0.87F, ModelLayers.DONKEY));
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.PREGNANT_FOX.get(), FoxRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.PREGNANT_GOAT.get(), GoatRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.PREGNANT_HORSE.get(), HorseRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.PREGNANT_LLAMA.get(), context -> new LlamaRenderer(context, ModelLayers.LLAMA));
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.PREGNANT_MAMMOTH.get(), MammothRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.PREGNANT_MULE.get(), context -> new ChestedHorseRenderer<>(context, 0.92F, ModelLayers.MULE));
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.PREGNANT_OCELOT.get(), OcelotRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.PREGNANT_PANDA.get(), PandaRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.PREGNANT_PIG.get(), PigRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.PREGNANT_POLAR_BEAR.get(), PolarBearRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.PREGNANT_RABBIT.get(), RabbitRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), SheepRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.PREGNANT_SMILODON.get(), SmilodonRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.PREGNANT_WOLF.get(), WolfRenderer::new);

		EntityRendererRegistry.register(FossilsLegacyEntityTypes.THROWN_JAVELIN.get(), ThrownJavelinRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.THROWN_INCUBATED_EGG.get(), ThrownItemRenderer::new);
		EntityRendererRegistry.register(FossilsLegacyEntityTypes.DILOPHOSAURUS_VENOM.get(), DilophosaurusVenomRenderer::new);

		EntityRendererRegistry.register(FossilsLegacyEntityTypes.STONE_TABLET.get(), StoneHieroglyphRenderer::new);

		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.BRACHIOSAURUS, BrachiosaurusModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.DILOPHOSAURUS, DilophosaurusModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.MAMMOTH, MammothModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.MOSASAURUS, MosasaurusModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.NAUTILUS, NautilusModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.FUTABASAURUS, FutabasaurusModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.GROUND_PTERANODON, GroundPteranodonModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.FLYING_PTERANODON, FlyingPteranodonModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.LANDING_PTERANODON, LandingPteranodonModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.SMILODON, SmilodonModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.STEGOSAURUS, StegosaurusModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.TRICERATOPS, TriceratopsModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.TYRANNOSAURUS, TyrannosaurusModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.KNOCKED_OUT_TYRANNOSAURUS, KnockedOutTyrannosaurusModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.VELOCIRAPTOR, VelociraptorModel::createBodyLayer);

		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.TRICERATOPS_SKELETON, TriceratopsSkeletonModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.BRACHIOSAURUS_SKELETON, BrachiosaurusSkeletonModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.PLESIOSAURUS_SKELETON, FutabasaurusSkeletonModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.PTERANODON_SKELETON, PteranodonSkeletonModel::createBodyLayer);

		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.ANU, AnuModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.FAILURESAURUS, FailuresaurusModel::createBodyLayer);

		EntityModelLayerRegistry.registerModelLayer(FossilsLegacyModels.EGG, EggModel::createBodyLayer);
	}
}
