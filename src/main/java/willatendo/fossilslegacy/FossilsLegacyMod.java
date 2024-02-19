package willatendo.fossilslegacy;

import net.fabricmc.api.ModInitializer;
import willatendo.fossilslegacy.server.FossilsLegacyBuiltInRegistries;
import willatendo.fossilslegacy.server.ConfigHelper;
import willatendo.fossilslegacy.server.FossilsLegacyCreativeModeTabs;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.block.entity.FossilsLegacyBlockEntities;
import willatendo.fossilslegacy.server.criteria.FossilsLegacyCriteriaTriggers;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEggVariants;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityDataSerializers;
import willatendo.fossilslegacy.server.entity.FossilsLegacyFossilVariants;
import willatendo.fossilslegacy.server.entity.FossilsLegacyStoneTabletVariants;
import willatendo.fossilslegacy.server.event.ModCallbacks;
import willatendo.fossilslegacy.server.event.ModEvents;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.loot.FossilsLegacyLootPoolEntryTypes;
import willatendo.fossilslegacy.server.menu.FossilsLegacyMenus;
import willatendo.fossilslegacy.server.recipe.FossilsLegacyRecipeTypes;
import willatendo.fossilslegacy.server.recipe.serialiser.FossilsLegacyRecipeSerialisers;
import willatendo.fossilslegacy.server.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.structure.FossilsLegacyStructurePeices;
import willatendo.fossilslegacy.server.structure.FossilsLegacyStructureTypes;

public class FossilsLegacyMod implements ModInitializer {
	@Override
	public void onInitialize() {
		FossilsLegacyBuiltInRegistries.init();

		FossilsLegacyRecipeTypes.init();
		FossilsLegacyRecipeSerialisers.init();
		FossilsLegacySoundEvents.init();
		FossilsLegacyBlocks.init();
		FossilsLegacyBlockEntities.init();
		FossilsLegacyMenus.init();
		FossilsLegacyEggVariants.init();
		FossilsLegacyFossilVariants.init();
		FossilsLegacyStoneTabletVariants.init();
		FossilsLegacyEntityDataSerializers.init();
		FossilsLegacyEntities.init();
		FossilsLegacyItems.init();
		FossilsLegacyCreativeModeTabs.init();
		FossilsLegacyLootPoolEntryTypes.init();
		FossilsLegacyStructurePeices.init();
		FossilsLegacyStructureTypes.init();
		FossilsLegacyCriteriaTriggers.init();

		ModCallbacks.callbacks();
		ModEvents.events();

		ConfigHelper.loadConfig();
	}
}
