package willatendo.fossilslegacy;

import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.biome.FossilsLegacyBiomeSources;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.block.entity.FossilsLegacyBlockEntityTypes;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyBuiltInRegistries;
import willatendo.fossilslegacy.server.criteria.FossilsLegacyCriteriaTriggers;
import willatendo.fossilslegacy.server.entity.*;
import willatendo.fossilslegacy.server.entity.commands.FossilsLegacyCommandTypes;
import willatendo.fossilslegacy.server.entity.poi.FossilsLegacyPoiTypes;
import willatendo.fossilslegacy.server.feature.foliageplacer.FossilsLegacyFoliagePlacerTypes;
import willatendo.fossilslegacy.server.feature.trunkplacer.FossilsLegacyTrunkPlacerTypes;
import willatendo.fossilslegacy.server.item.*;
import willatendo.fossilslegacy.server.item.dinopedia.line.FossilsLegacyDinopediaLineTypes;
import willatendo.fossilslegacy.server.level.FossilsLegacyGameRules;
import willatendo.fossilslegacy.server.loot.FossilsLegacyLootPoolEntryTypes;
import willatendo.fossilslegacy.server.menu.FossilsLegacyMenuTypes;
import willatendo.fossilslegacy.server.recipe.FossilsLegacyRecipeTypes;
import willatendo.fossilslegacy.server.recipe.serialiser.FossilsLegacyRecipeSerialisers;
import willatendo.fossilslegacy.server.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.structure.FossilsLegacyStructureTypes;
import willatendo.fossilslegacy.server.structure.piece.FossilsLegacyStructurePeices;
import willatendo.fossilslegacy.server.structure.processor.FossilsLegacyStructureProcessorType;
import willatendo.fossilslegacy.server.structure.processor.rule.FossilsLegacyRuleTestTypes;
import willatendo.fossilslegacy.server.utils.Platform;
import willatendo.simplelibrary.server.SimpleBuiltInRegistries;
import willatendo.simplelibrary.server.event.registry.SimpleRegistryRegister;

public final class FossilsLegacyMod {
    public static void onInitialize(SimpleRegistryRegister simpleRegistryRegister) {
        FossilsLegacyBuiltInRegistries.init();

        simpleRegistryRegister.register(FossilsLegacyCommandTypes.COMMAND_TYPES);
        simpleRegistryRegister.register(FossilsLegacyRecipeTypes.RECIPE_TYPES);
        simpleRegistryRegister.register(FossilsLegacyRecipeSerialisers.RECIPE_SERIALIZERS);
        simpleRegistryRegister.register(FossilsLegacySoundEvents.SOUND_EVENTS);
        simpleRegistryRegister.register(FossilsLegacyTrunkPlacerTypes.TRUNK_PLACER_TYPES);
        simpleRegistryRegister.register(FossilsLegacyFoliagePlacerTypes.FOLIAGE_PLACER_TYPES);
        simpleRegistryRegister.register(FossilsLegacyBlocks.BLOCKS);
        simpleRegistryRegister.register(FossilsLegacyBlockEntityTypes.BLOCK_ENTITY_TYPES);
        simpleRegistryRegister.register(FossilsLegacyMenuTypes.MENU_TYPES);
        simpleRegistryRegister.register(FossilsLegacyEggVariants.EGG_VARIANTS);
        simpleRegistryRegister.register(FossilsLegacyPregnancyTypes.PREGNANCY_TYPES);
        FossilsLegacyEntityDataSerializers.init();
        if (FossilsModloaderHelper.INSTANCE.getPlatform() != Platform.FABRIC) {
            simpleRegistryRegister.register(FossilsLegacyPoiTypes.POI_TYPES);
        }
        simpleRegistryRegister.register(FossilsLegacyVillagerProfessions.VILLAGER_PROFESSIONS);
        simpleRegistryRegister.register(FossilsLegacyEntityTypes.ENTITY_TYPES);
        simpleRegistryRegister.register(FossilsLegacyDataComponents.DATA_COMPONENT_TYPES);
        simpleRegistryRegister.register(FossilsLegacyArmorMaterials.ARMOR_MATERIALS);
        simpleRegistryRegister.register(FossilsLegacyDinopediaLineTypes.DINOPEDIA_LINE_TYPES);
        FossilsLegacyMapDecorationTypes.init();
        simpleRegistryRegister.register(FossilsLegacyItems.ITEMS);
        simpleRegistryRegister.register(FossilsLegacyCreativeModeTabs.CREATIVE_MODE_TABS);
        simpleRegistryRegister.register(FossilsLegacyLootPoolEntryTypes.LOOT_POOL_ENTRY_TYPES);
        simpleRegistryRegister.register(FossilsLegacyRuleTestTypes.RULE_TEST_TYPES);
        simpleRegistryRegister.register(FossilsLegacyStructureProcessorType.STRUCTURE_PROCESSOR_TYPES);
        simpleRegistryRegister.register(FossilsLegacyStructurePeices.STRUCTURE_PIECE_TYPE);
        simpleRegistryRegister.register(FossilsLegacyStructureTypes.STRUCTURE_TYPE);
        simpleRegistryRegister.register(FossilsLegacyCriteriaTriggers.TRIGGER_TYPES);
        FossilsLegacyBiomeSources.init();
        SimpleBuiltInRegistries.init();
        simpleRegistryRegister.register(FossilsLegacyBoatTypes.BOAT_TYPES);
        FossilsLegacyGameRules.init();
    }
}
