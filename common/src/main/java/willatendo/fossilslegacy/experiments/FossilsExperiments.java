package willatendo.fossilslegacy.experiments;

import willatendo.fossilslegacy.experiments.server.block.FossilsExperimentsBlocks;
import willatendo.fossilslegacy.experiments.server.block.entity.FossilsExperimentsBlockEntities;
import willatendo.fossilslegacy.experiments.server.entity.FossilsExperimentsEggVariants;
import willatendo.fossilslegacy.experiments.server.entity.FossilsExperimentsEntityTypes;
import willatendo.fossilslegacy.experiments.server.item.FossilsExperimentsItems;
import willatendo.fossilslegacy.experiments.server.menu.FossilsExperimentsMenus;
import willatendo.fossilslegacy.experiments.server.sound.FossilsExperimentsSoundEvents;

public class FossilsExperiments {
    public static void init() {
        FossilsExperimentsSoundEvents.init();
        FossilsExperimentsItems.init();
        FossilsExperimentsBlocks.init();
        FossilsExperimentsBlockEntities.init();
        FossilsExperimentsMenus.init();
        FossilsExperimentsEggVariants.init();
        FossilsExperimentsEntityTypes.init();
    }
}
