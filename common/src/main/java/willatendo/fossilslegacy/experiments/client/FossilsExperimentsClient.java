package willatendo.fossilslegacy.experiments.client;

import net.minecraft.client.gui.screens.MenuScreens;
import willatendo.fossilslegacy.client.FossilsLegacyClient;
import willatendo.fossilslegacy.experiments.client.model.CarnotaurusModel;
import willatendo.fossilslegacy.experiments.client.model.CryolophosaurusModel;
import willatendo.fossilslegacy.experiments.client.model.TherizinosaurusModel;
import willatendo.fossilslegacy.experiments.client.model.TimeMachineClockModel;
import willatendo.fossilslegacy.experiments.client.render.CarnotaurusRenderer;
import willatendo.fossilslegacy.experiments.client.render.CryolophosaurusRenderer;
import willatendo.fossilslegacy.experiments.client.render.TherizinosaurusRenderer;
import willatendo.fossilslegacy.experiments.client.render.TimeMachineClockRenderer;
import willatendo.fossilslegacy.experiments.client.screen.TimeMachineScreen;
import willatendo.fossilslegacy.experiments.server.block.entity.FossilsExperimentsBlockEntities;
import willatendo.fossilslegacy.experiments.server.entity.FossilsExperimentsEntityTypes;
import willatendo.fossilslegacy.experiments.server.menu.FossilsExperimentsMenus;

public class FossilsExperimentsClient {
    public static void loadModelLayers() {
        FossilsLegacyClient.addModelLayer(FossilsExperimentsModels.CARNOTAURUS, CarnotaurusModel::createBodyLayer);
        FossilsLegacyClient.addModelLayer(FossilsExperimentsModels.CRYOLOPHOSAURUS, CryolophosaurusModel::createBodyLayer);
        FossilsLegacyClient.addModelLayer(FossilsExperimentsModels.THERIZINOSAURUS, TherizinosaurusModel::createBodyLayer);

        FossilsLegacyClient.addModelLayer(FossilsExperimentsModels.TIME_MACHINE_CLOCK, TimeMachineClockModel::createBodyLayer);
    }

    public static void loadModels() {
        FossilsLegacyClient.addModel(FossilsExperimentsEntityTypes.CARNOTAURUS.get(), CarnotaurusRenderer::new);
        FossilsLegacyClient.addModel(FossilsExperimentsEntityTypes.CRYOLOPHOSAURUS.get(), CryolophosaurusRenderer::new);
        FossilsLegacyClient.addModel(FossilsExperimentsEntityTypes.THERIZINOSAURUS.get(), TherizinosaurusRenderer::new);

        FossilsLegacyClient.addModel(FossilsExperimentsBlockEntities.TIME_MACHINE.get(), TimeMachineClockRenderer::new);
    }

    public static void bindScreens() {
        MenuScreens.register(FossilsExperimentsMenus.TIME_MACHINE.get(), TimeMachineScreen::new);
    }
}
