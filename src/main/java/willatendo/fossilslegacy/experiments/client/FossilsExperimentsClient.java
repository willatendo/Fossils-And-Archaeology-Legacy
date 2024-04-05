package willatendo.fossilslegacy.experiments.client;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import willatendo.fossilslegacy.experiments.client.model.TimeMachineClockModel;
import willatendo.fossilslegacy.experiments.client.render.TimeMachineClockRenderer;
import willatendo.fossilslegacy.experiments.client.screen.TimeMachineScreen;
import willatendo.fossilslegacy.experiments.server.block.entity.FossilsExperimentsBlockEntities;
import willatendo.fossilslegacy.experiments.server.menu.FossilsExperimentsMenus;

public class FossilsExperimentsClient {
	public static void init() {
		MenuScreens.register(FossilsExperimentsMenus.TIME_MACHINE.get(), TimeMachineScreen::new);

		EntityModelLayerRegistry.registerModelLayer(FossilsExperimentsModels.TIME_MACHINE_CLOCK, TimeMachineClockModel::createBodyLayer);

		BlockEntityRenderers.register(FossilsExperimentsBlockEntities.TIME_MACHINE.get(), TimeMachineClockRenderer::new);
	}
}
