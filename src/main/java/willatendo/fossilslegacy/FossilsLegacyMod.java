package willatendo.fossilslegacy;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import willatendo.fossilslegacy.client.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.FossilsLegacyCreativeModeTabs;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.block.entity.FossilsLegacyBlockEntities;
import willatendo.fossilslegacy.server.criteria.FossilsLegacyCriteriaTriggers;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.menu.FossilsLegacyMenus;
import willatendo.fossilslegacy.server.recipe.FossilsLegacyRecipeTypes;
import willatendo.fossilslegacy.server.recipe.serialiser.FossilsLegacyRecipeSerialisers;
import willatendo.fossilslegacy.server.structure.FossilLegacyStructureTypes;
import willatendo.fossilslegacy.server.structure.FossilLegacysStructurePeices;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.util.SimpleUtils;

@Mod(FossilsLegacyUtils.ID)
public class FossilsLegacyMod {
	public FossilsLegacyMod() {
		IEventBus iEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		SimpleUtils.registerAll(iEventBus, FossilsLegacySoundEvents.SOUND_EVENTS, FossilsLegacyCreativeModeTabs.CREATIVE_MODE_TABS, FossilsLegacyItems.ITEMS, FossilsLegacyRecipeSerialisers.RECIPE_SERIALIZERS, FossilsLegacyRecipeTypes.RECIPE_TYPES, FossilsLegacyBlockEntities.BLOCK_ENTITY_TYPES, FossilsLegacyMenus.MENU_TYPES, FossilsLegacyBlocks.BLOCKS, FossilsLegacyEntities.ENTITY_TYPES, FossilLegacyStructureTypes.STRUCTURE_TYPE, FossilLegacysStructurePeices.STRUCTURE_PIECE_TYPE);

		FossilsLegacyCriteriaTriggers.init();

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, FossilsLegacyConfig.COMMON_SPEC);
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, FossilsLegacyConfig.CLIENT_SPEC);
	}
}
