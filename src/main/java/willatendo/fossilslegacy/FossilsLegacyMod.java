package willatendo.fossilslegacy;

import net.fabricmc.api.ModInitializer;
import willatendo.fossilslegacy.client.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.FossilsLegacyCreativeModeTabs;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.block.entity.FossilsLegacyBlockEntities;
import willatendo.fossilslegacy.server.criteria.FossilsLegacyCriteriaTriggers;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;
import willatendo.fossilslegacy.server.event.ModServerEvents;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.menu.FossilsLegacyMenus;
import willatendo.fossilslegacy.server.recipe.FossilsLegacyRecipeTypes;
import willatendo.fossilslegacy.server.recipe.serialiser.FossilsLegacyRecipeSerialisers;
import willatendo.fossilslegacy.server.structure.FossilLegacyStructureTypes;
import willatendo.fossilslegacy.server.structure.FossilLegacysStructurePeices;

public class FossilsLegacyMod implements ModInitializer {
	@Override
	public void onInitialize() {
//		FossilsLegacyConfig.init();

		FossilsLegacyRecipeTypes.init();
		FossilsLegacyRecipeSerialisers.init();
		FossilsLegacySoundEvents.init();
		FossilsLegacyBlocks.init();
		FossilsLegacyBlockEntities.init();
		FossilsLegacyMenus.init();
		FossilsLegacyItems.init();
		FossilsLegacyEntities.init();
		FossilsLegacyCreativeModeTabs.init();
		FossilLegacysStructurePeices.init();
		FossilLegacyStructureTypes.init();

		FossilsLegacyCriteriaTriggers.init();

		ModServerEvents.entityAttributes();
		ModServerEvents.creativeModTabModification();
		ModServerEvents.addToBiomes();
	}
}
