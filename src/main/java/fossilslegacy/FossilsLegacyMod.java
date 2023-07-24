package fossilslegacy;

import fossilslegacy.client.sound.FossilsLegacySoundEvents;
import fossilslegacy.server.FossilsLegacyCreativeModeTabs;
import fossilslegacy.server.block.FossilsLegacyBlocks;
import fossilslegacy.server.block.entity.FossilsLegacyBlockEntities;
import fossilslegacy.server.criteria.FossilsLegacyCriteriaTriggers;
import fossilslegacy.server.entity.FossilsLegacyEntities;
import fossilslegacy.server.item.FossilsLegacyItems;
import fossilslegacy.server.menu.FossilsLegacyMenus;
import fossilslegacy.server.recipe.FossilsLegacyRecipeTypes;
import fossilslegacy.server.recipe.serialiser.FossilsLegacyRecipeSerialisers;
import fossilslegacy.server.structure.FossilLegacyStructureTypes;
import fossilslegacy.server.structure.FossilLegacysStructurePeices;
import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import willatendo.simplelibrary.server.util.SimpleUtils;

@Mod(FossilsLegacyUtils.ID)
public class FossilsLegacyMod {
	public FossilsLegacyMod() {
		IEventBus iEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		SimpleUtils.registerAll(iEventBus, FossilsLegacySoundEvents.SOUND_EVENTS, FossilsLegacyCreativeModeTabs.CREATIVE_MODE_TABS, FossilsLegacyItems.ITEMS, FossilsLegacyRecipeSerialisers.RECIPE_SERIALIZERS, FossilsLegacyRecipeTypes.RECIPE_TYPES, FossilsLegacyBlockEntities.BLOCK_ENTITY_TYPES, FossilsLegacyMenus.MENU_TYPES, FossilsLegacyBlocks.BLOCKS, FossilsLegacyEntities.ENTITY_TYPES, FossilLegacyStructureTypes.STRUCTURE_TYPE, FossilLegacysStructurePeices.STRUCTURE_PIECE_TYPE);

		FossilsLegacyCriteriaTriggers.init();
	}
}
