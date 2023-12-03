package willatendo.fossilslegacy.client.event;

import java.util.function.Supplier;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.CatRenderer;
import net.minecraft.client.renderer.entity.ChestedHorseRenderer;
import net.minecraft.client.renderer.entity.CowRenderer;
import net.minecraft.client.renderer.entity.DolphinRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.EggModel;
import willatendo.fossilslegacy.client.model.FailuresaurusModel;
import willatendo.fossilslegacy.client.model.MammothModel;
import willatendo.fossilslegacy.client.model.SmilodonModel;
import willatendo.fossilslegacy.client.model.fossils.BrachiosaurusLegacySkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.PlesiosaurusLegacySkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.PteranodonLegacySkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.TriceratopsLegacySkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.TriceratopsSkeletonModel;
import willatendo.fossilslegacy.client.model.legacy.MammothLegacyModel;
import willatendo.fossilslegacy.client.model.legacy.SmilodonLegacyModel;
import willatendo.fossilslegacy.client.model.legacy.TriceratopsLegacyModel;
import willatendo.fossilslegacy.client.model.pterosaurus.BabyPteranodonModel;
import willatendo.fossilslegacy.client.model.triceratops.BabyTriceratopsModel;
import willatendo.fossilslegacy.client.model.triceratops.TriceratopsModel;
import willatendo.fossilslegacy.client.render.DrownedPirateRenderer;
import willatendo.fossilslegacy.client.render.EggRenderer;
import willatendo.fossilslegacy.client.render.FailuresaurusRenderer;
import willatendo.fossilslegacy.client.render.FossilRenderer;
import willatendo.fossilslegacy.client.render.MammothRenderer;
import willatendo.fossilslegacy.client.render.SmilodonRenderer;
import willatendo.fossilslegacy.client.render.StoneHieroglyphRenderer;
import willatendo.fossilslegacy.client.render.ThrownJavelinRenderer;
import willatendo.fossilslegacy.client.render.TriceratopsRenderer;
import willatendo.fossilslegacy.client.render.ZombifiedPigmanRenderer;
import willatendo.fossilslegacy.client.screen.AnalyzerScreen;
import willatendo.fossilslegacy.client.screen.ArchaeologyWorkbenchScreen;
import willatendo.fossilslegacy.client.screen.CultivatorScreen;
import willatendo.fossilslegacy.client.screen.FeederScreen;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;
import willatendo.fossilslegacy.server.menu.FossilsLegacyMenus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

@EventBusSubscriber(bus = Bus.MOD, modid = FossilsLegacyUtils.ID, value = Dist.CLIENT)
public class ModClientEvents {
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		MenuScreens.register(FossilsLegacyMenus.ANALYZER.get(), AnalyzerScreen::new);
		MenuScreens.register(FossilsLegacyMenus.ARCHAEOLOGY_WORKBENCH.get(), ArchaeologyWorkbenchScreen::new);
		MenuScreens.register(FossilsLegacyMenus.CULTIVATOR.get(), CultivatorScreen::new);
		MenuScreens.register(FossilsLegacyMenus.FEEDER.get(), FeederScreen::new);

		EntityRenderers.register(FossilsLegacyEntities.ANCIENT_LIGHTNING_BOLT.get(), LightningBoltRenderer::new);

		EntityRenderers.register(FossilsLegacyEntities.FOSSIL.get(), FossilRenderer::new);

		EntityRenderers.register(FossilsLegacyEntities.MAMMOTH.get(), MammothRenderer::new);
		EntityRenderers.register(FossilsLegacyEntities.SMILODON.get(), SmilodonRenderer::new);
		EntityRenderers.register(FossilsLegacyEntities.TRICERATOPS.get(), TriceratopsRenderer::new);

		EntityRenderers.register(FossilsLegacyEntities.EGG.get(), EggRenderer::new);

		EntityRenderers.register(FossilsLegacyEntities.ZOMBIFIED_PIGMAN.get(), ZombifiedPigmanRenderer::new);
		EntityRenderers.register(FossilsLegacyEntities.DROWNED_PIRATE.get(), DrownedPirateRenderer::new);
		EntityRenderers.register(FossilsLegacyEntities.FAILURESAURUS.get(), FailuresaurusRenderer::new);

		EntityRenderers.register(FossilsLegacyEntities.PREGNANT_CAT.get(), CatRenderer::new);
		EntityRenderers.register(FossilsLegacyEntities.PREGNANT_COW.get(), CowRenderer::new);
		EntityRenderers.register(FossilsLegacyEntities.PREGNANT_DOLPHIN.get(), DolphinRenderer::new);
		EntityRenderers.register(FossilsLegacyEntities.PREGNANT_DONKEY.get(), context -> new ChestedHorseRenderer<>(context, 0.87F, ModelLayers.DONKEY));
		EntityRenderers.register(FossilsLegacyEntities.PREGNANT_FOX.get(), FoxRenderer::new);
		EntityRenderers.register(FossilsLegacyEntities.PREGNANT_GOAT.get(), GoatRenderer::new);
		EntityRenderers.register(FossilsLegacyEntities.PREGNANT_HORSE.get(), HorseRenderer::new);
		EntityRenderers.register(FossilsLegacyEntities.PREGNANT_LLAMA.get(), context -> new LlamaRenderer(context, ModelLayers.LLAMA));
		EntityRenderers.register(FossilsLegacyEntities.PREGNANT_MAMMOTH.get(), MammothRenderer::new);
		EntityRenderers.register(FossilsLegacyEntities.PREGNANT_MULE.get(), context -> new ChestedHorseRenderer<>(context, 0.92F, ModelLayers.MULE));
		EntityRenderers.register(FossilsLegacyEntities.PREGNANT_OCELOT.get(), OcelotRenderer::new);
		EntityRenderers.register(FossilsLegacyEntities.PREGNANT_PANDA.get(), PandaRenderer::new);
		EntityRenderers.register(FossilsLegacyEntities.PREGNANT_PIG.get(), PigRenderer::new);
		EntityRenderers.register(FossilsLegacyEntities.PREGNANT_POLAR_BEAR.get(), PolarBearRenderer::new);
		EntityRenderers.register(FossilsLegacyEntities.PREGNANT_RABBIT.get(), RabbitRenderer::new);
		EntityRenderers.register(FossilsLegacyEntities.PREGNANT_SHEEP.get(), SheepRenderer::new);
		EntityRenderers.register(FossilsLegacyEntities.PREGNANT_SMILODON.get(), SmilodonRenderer::new);
		EntityRenderers.register(FossilsLegacyEntities.PREGNANT_WOLF.get(), WolfRenderer::new);

		EntityRenderers.register(FossilsLegacyEntities.THROWN_JAVELIN.get(), ThrownJavelinRenderer::new);
		EntityRenderers.register(FossilsLegacyEntities.THROWN_INCUBATED_EGG.get(), ThrownItemRenderer::new);
		EntityRenderers.register(FossilsLegacyEntities.STONE_HIEROGLYPH.get(), StoneHieroglyphRenderer::new);
	}

	@SubscribeEvent
	public static void entityRenderers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		registerModel(event, FossilsLegacyModels.MAMMOTH, FossilsLegacyModels.LEGACY_MAMMOTH, MammothModel::createBodyLayer, MammothLegacyModel::createBodyLayer);

		registerModel(event, FossilsLegacyModels.SMILODON, FossilsLegacyModels.LEGACY_SMILODON, SmilodonModel::createBodyLayer, SmilodonLegacyModel::createBodyLayer);

		registerModel(event, new EntityRenderer(FossilsLegacyModels.TRICERATOPS_ADULT, TriceratopsModel::createBodyLayer), new EntityRenderer(FossilsLegacyModels.TRICERATOPS_BABY, BabyTriceratopsModel::createBodyLayer), new EntityRenderer(FossilsLegacyModels.LEGACY_TRICERATOPS, TriceratopsLegacyModel::createBodyLayer), new EntityRenderer(FossilsLegacyModels.TRICERATOPS_SKELETON, TriceratopsSkeletonModel::createBodyLayer), new EntityRenderer(FossilsLegacyModels.LEGACY_TRICERATOPS_SKELETON, TriceratopsLegacySkeletonModel::createBodyLayer));

		event.registerLayerDefinition(FossilsLegacyModels.LEGACY_BRACHIOSAURS_SKELETON, BrachiosaurusLegacySkeletonModel::createBodyLayer);
		event.registerLayerDefinition(FossilsLegacyModels.LEGACY_PLESIOSAURUS_SKELETON, PlesiosaurusLegacySkeletonModel::createBodyLayer);
		event.registerLayerDefinition(FossilsLegacyModels.LEGACY_PTERANODON_SKELETON, PteranodonLegacySkeletonModel::createBodyLayer);

		event.registerLayerDefinition(FossilsLegacyModels.PTERANODON_BABY, BabyPteranodonModel::createBodyLayer);

		event.registerLayerDefinition(FossilsLegacyModels.FAILURESAURUS, FailuresaurusModel::createBodyLayer);

		event.registerLayerDefinition(FossilsLegacyModels.EGG, EggModel::createBodyLayer);
	}

	private static void registerModel(EntityRenderersEvent.RegisterLayerDefinitions event, ModelLayerLocation mainModel, ModelLayerLocation legacyModel, Supplier<LayerDefinition> mainLayer, Supplier<LayerDefinition> legacyLayer) {
		registerModel(event, new EntityRenderer(mainModel, mainLayer), new EntityRenderer(legacyModel, legacyLayer));
	}

	private static void registerModel(EntityRenderersEvent.RegisterLayerDefinitions event, EntityRenderer... entityRenderers) {
		for (EntityRenderer entityRenderer : entityRenderers) {
			event.registerLayerDefinition(entityRenderer.modelLayerLocation(), entityRenderer.layer());
		}
	}

	@SubscribeEvent
	public static void onRegisterReloadListenerEvent(RegisterClientReloadListenersEvent event) {
//		Minecraft minecraft = Minecraft.getInstance();
//		TextureManager textureManager = minecraft.getTextureManager();
//		event.registerReloadListener(new FossilsLegacySpriteUploader(textureManager));
	}

	private static record EntityRenderer(ModelLayerLocation modelLayerLocation, Supplier<LayerDefinition> layer) {
	}
}
