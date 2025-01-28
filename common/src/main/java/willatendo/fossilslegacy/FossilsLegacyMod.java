package willatendo.fossilslegacy;

import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.biome.FABiomeSources;
import willatendo.fossilslegacy.server.block.FABlockTypes;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.entity.FABlockEntityTypes;
import willatendo.fossilslegacy.server.egg_variant.FAEggVariants;
import willatendo.fossilslegacy.server.menu.FAMenuTypes;
import willatendo.fossilslegacy.server.pregnancy_types.FAPregnancyTypes;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;
import willatendo.fossilslegacy.server.criteria.FLCriteriaTriggers;
import willatendo.fossilslegacy.server.entity.*;
import willatendo.fossilslegacy.server.command_type.FACommandTypes;
import willatendo.fossilslegacy.server.entity.FAPoiTypes;
import willatendo.fossilslegacy.server.feature.FAFoliagePlacerTypes;
import willatendo.fossilslegacy.server.feature.FATrunkPlacerTypes;
import willatendo.fossilslegacy.server.item.*;
import willatendo.fossilslegacy.server.dinopedia_entry.FADinopediaLineTypes;
import willatendo.fossilslegacy.server.level.FAGameRules;
import willatendo.fossilslegacy.server.loot.FALootPoolEntryTypes;
import willatendo.fossilslegacy.server.recipe.FARecipeTypes;
import willatendo.fossilslegacy.server.recipe.FARecipeSerialisers;
import willatendo.fossilslegacy.server.sound.FASoundEvents;
import willatendo.fossilslegacy.server.stats.FAStats;
import willatendo.fossilslegacy.server.structure.FAStructureTypes;
import willatendo.fossilslegacy.server.structure.FAStructurePeices;
import willatendo.fossilslegacy.server.structure.FAStructureProcessorType;
import willatendo.fossilslegacy.server.structure.FARuleTestTypes;
import willatendo.fossilslegacy.server.utils.Platform;
import willatendo.simplelibrary.server.SimpleBuiltInRegistries;
import willatendo.simplelibrary.server.event.registry.SimpleRegistryRegister;

public final class FossilsLegacyMod {
    public static void onInitialize(SimpleRegistryRegister simpleRegistryRegister) {
        FABuiltInRegistries.init();

        simpleRegistryRegister.register(FACommandTypes.COMMAND_TYPES);
        simpleRegistryRegister.register(FARecipeTypes.RECIPE_TYPES);
        simpleRegistryRegister.register(FARecipeSerialisers.RECIPE_SERIALIZERS);
        simpleRegistryRegister.register(FASoundEvents.SOUND_EVENTS);
        simpleRegistryRegister.register(FATrunkPlacerTypes.TRUNK_PLACER_TYPES);
        simpleRegistryRegister.register(FAFoliagePlacerTypes.FOLIAGE_PLACER_TYPES);
        simpleRegistryRegister.register(FABlocks.BLOCKS);
        simpleRegistryRegister.register(FABlockTypes.BLOCK_TYPES);
        simpleRegistryRegister.register(FABlockEntityTypes.BLOCK_ENTITY_TYPES);
        simpleRegistryRegister.register(FAMenuTypes.MENU_TYPES);
        simpleRegistryRegister.register(FAEggVariants.EGG_VARIANTS);
        simpleRegistryRegister.register(FAPregnancyTypes.PREGNANCY_TYPES);
        FAEntityDataSerializers.init();
        if (FossilsModloaderHelper.INSTANCE.getPlatform() != Platform.FABRIC) {
            simpleRegistryRegister.register(FAPoiTypes.POI_TYPES);
        }
        simpleRegistryRegister.register(FAVillagerProfessions.VILLAGER_PROFESSIONS);
        simpleRegistryRegister.register(FAEntityTypes.ENTITY_TYPES);
        simpleRegistryRegister.register(FADataComponents.DATA_COMPONENT_TYPES);
        simpleRegistryRegister.register(FAArmorMaterials.ARMOR_MATERIALS);
        simpleRegistryRegister.register(FADinopediaLineTypes.DINOPEDIA_LINE_TYPES);
        FAMapDecorationTypes.init();
        simpleRegistryRegister.register(FAItems.ITEMS);
        simpleRegistryRegister.register(FACreativeModeTabs.CREATIVE_MODE_TABS);
        simpleRegistryRegister.register(FALootPoolEntryTypes.LOOT_POOL_ENTRY_TYPES);
        simpleRegistryRegister.register(FARuleTestTypes.RULE_TEST_TYPES);
        simpleRegistryRegister.register(FAStructureProcessorType.STRUCTURE_PROCESSOR_TYPES);
        simpleRegistryRegister.register(FAStructurePeices.STRUCTURE_PIECE_TYPE);
        simpleRegistryRegister.register(FAStructureTypes.STRUCTURE_TYPE);
        simpleRegistryRegister.register(FLCriteriaTriggers.TRIGGER_TYPES);
        simpleRegistryRegister.register(FAStats.STATS);
        FABiomeSources.init();
        SimpleBuiltInRegistries.init();
        simpleRegistryRegister.register(FABoatTypes.BOAT_TYPES);
        FAGameRules.init();
    }
}
