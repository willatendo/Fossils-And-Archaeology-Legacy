package willatendo.fossilslegacy;

import net.fabricmc.api.ModInitializer;
import willatendo.fossilslegacy.client.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.FossilsLegacyCreativeModeTabs;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.block.entity.FossilsLegacyBlockEntities;
import willatendo.fossilslegacy.server.criteria.FossilsLegacyCriteriaTriggers;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;
import willatendo.fossilslegacy.server.event.ModEvents;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.menu.FossilsLegacyMenus;
import willatendo.fossilslegacy.server.recipe.FossilsLegacyRecipeTypes;
import willatendo.fossilslegacy.server.recipe.serialiser.FossilsLegacyRecipeSerialisers;
import willatendo.fossilslegacy.server.structure.FossilsLegacyStructurePeices;
import willatendo.fossilslegacy.server.structure.FossilsLegacyStructureTypes;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.config.ModConfig.Type;
import willatendo.simplelibrary.config.api.ForgeConfigRegistry;

public class FossilsLegacyMod implements ModInitializer {
	@Override
	public void onInitialize() {
		FossilsLegacyRecipeTypes.init();
		FossilsLegacyRecipeSerialisers.init();
		FossilsLegacySoundEvents.init();
		FossilsLegacyBlocks.init();
		FossilsLegacyBlockEntities.init();
		FossilsLegacyMenus.init();
		FossilsLegacyEntities.init();
		FossilsLegacyItems.init();
		FossilsLegacyCreativeModeTabs.init();
		FossilsLegacyStructurePeices.init();
		FossilsLegacyStructureTypes.init();

		FossilsLegacyCriteriaTriggers.init();

		ModEvents.lightning();
		ModEvents.addLegacyPack();
		ModEvents.entityAttributes();
		ModEvents.entitySpawns();
		ModEvents.creativeModTabModification();
		ModEvents.addToBiomes();

		ForgeConfigRegistry.INSTANCE.register(FossilsLegacyUtils.ID, Type.COMMON, FossilsLegacyConfig.COMMON_SPEC);
	}
}
