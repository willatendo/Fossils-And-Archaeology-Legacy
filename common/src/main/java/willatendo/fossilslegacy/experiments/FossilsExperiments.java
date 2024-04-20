package willatendo.fossilslegacy.experiments;

import willatendo.fossilslegacy.experiments.server.block.FossilsExperimentsBlocks;
import willatendo.fossilslegacy.experiments.server.block.entity.FossilsExperimentsBlockEntities;
import willatendo.fossilslegacy.experiments.server.item.FossilsExperimentsItems;
import willatendo.fossilslegacy.experiments.server.menu.FossilsExperimentsMenus;

public class FossilsExperiments {
	public static void init() {
		FossilsExperimentsItems.init();
		FossilsExperimentsBlocks.init();
		FossilsExperimentsBlockEntities.init();
		FossilsExperimentsMenus.init();
	}
}
