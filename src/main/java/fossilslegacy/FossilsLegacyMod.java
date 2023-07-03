package fossilslegacy;

import fossilslegacy.client.sound.FossilsLegacySoundEvents;
import fossilslegacy.server.FossilsLegacyCreativeModeTabs;
import fossilslegacy.server.block.FossilsLegacyBlocks;
import fossilslegacy.server.block.entity.FossilsLegacyBlockEntities;
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

@Mod(FossilsLegacyUtils.ID)
public class FossilsLegacyMod {
	public FossilsLegacyMod() {
		IEventBus iEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		FossilsLegacySoundEvents.SOUND_EVENTS.register(iEventBus);
		FossilsLegacyCreativeModeTabs.CREATIVE_MODE_TABS.register(iEventBus);
		FossilsLegacyItems.ITEMS.register(iEventBus);
		FossilsLegacyRecipeSerialisers.RECIPE_SERIALIZERS.register(iEventBus);
		FossilsLegacyRecipeTypes.RECIPE_TYPES.register(iEventBus);
		FossilsLegacyBlockEntities.BLOCK_ENTITY_TYPES.register(iEventBus);
		FossilsLegacyMenus.MENU_TYPES.register(iEventBus);
		FossilsLegacyBlocks.BLOCKS.register(iEventBus);
		FossilsLegacyEntities.ENTITY_TYPES.register(iEventBus);
		FossilLegacyStructureTypes.STRUCTURE_TYPE.register(iEventBus);
		FossilLegacysStructurePeices.STRUCTURE_PIECE_TYPE.register(iEventBus);
	}
}
