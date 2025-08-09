package willatendo.fossilslegacy;

import willatendo.fossilslegacy.client.FARecipeBookCategories;
import willatendo.fossilslegacy.server.biome.FABiomeSources;
import willatendo.fossilslegacy.server.block.FABlockTypes;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.entity.FABlockEntityTypes;
import willatendo.fossilslegacy.server.command_type.FACommandTypes;
import willatendo.fossilslegacy.server.criteria.FACriteriaTriggers;
import willatendo.fossilslegacy.server.criteria.critereon.FAEntitySubPredicates;
import willatendo.fossilslegacy.server.dinopedia_entry.FADinopediaLineTypes;
import willatendo.fossilslegacy.server.entity.FAEntityDataSerializers;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.FAPoiTypes;
import willatendo.fossilslegacy.server.entity.FAVillagerProfessions;
import willatendo.fossilslegacy.server.feature.FAFeatures;
import willatendo.fossilslegacy.server.feature.FAFoliagePlacerTypes;
import willatendo.fossilslegacy.server.feature.FATrunkPlacerTypes;
import willatendo.fossilslegacy.server.fluid.FAFluids;
import willatendo.fossilslegacy.server.gene.FAGenes;
import willatendo.fossilslegacy.server.item.FACreativeModeTabs;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.item.FAMapDecorationTypes;
import willatendo.fossilslegacy.server.level.FAGameRules;
import willatendo.fossilslegacy.server.loot.FALootPoolEntryTypes;
import willatendo.fossilslegacy.server.menu.FAMenuTypes;
import willatendo.fossilslegacy.server.particles.FAParticleTypes;
import willatendo.fossilslegacy.server.pattern.FAPatternInformationTypes;
import willatendo.fossilslegacy.server.pattern.texture.FATextureTypes;
import willatendo.fossilslegacy.server.pregnancy_types.FAPregnancyTypes;
import willatendo.fossilslegacy.server.recipe.FARecipeDisplays;
import willatendo.fossilslegacy.server.recipe.FARecipeSerialisers;
import willatendo.fossilslegacy.server.recipe.FARecipeTypes;
import willatendo.fossilslegacy.server.recipe.FASlotDisplays;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;
import willatendo.fossilslegacy.server.sound.FASoundEvents;
import willatendo.fossilslegacy.server.stats.FAStats;
import willatendo.fossilslegacy.server.structure.FARuleTestTypes;
import willatendo.fossilslegacy.server.structure.FAStructurePeices;
import willatendo.fossilslegacy.server.structure.FAStructureProcessorType;
import willatendo.fossilslegacy.server.structure.FAStructureTypes;
import willatendo.simplelibrary.platform.ModloaderHelper;
import willatendo.simplelibrary.server.event.registry.SimpleRegistryRegister;
import willatendo.simplelibrary.server.util.Platform;

public final class FossilsLegacyMod {
    public static void onInitialize(SimpleRegistryRegister simpleRegistryRegister) {
        FABuiltInRegistries.init();

        simpleRegistryRegister.register(FAParticleTypes.PARTICLE_TYPES);
        simpleRegistryRegister.register(FAEntitySubPredicates.ENTITY_SUB_PREDICATES);
        simpleRegistryRegister.register(FARecipeBookCategories.RECIPE_BOOK_CATEGORIES);
        simpleRegistryRegister.register(FACommandTypes.COMMAND_TYPES);
        simpleRegistryRegister.register(FARecipeTypes.RECIPE_TYPES);
        simpleRegistryRegister.register(FARecipeSerialisers.RECIPE_SERIALIZERS);
        simpleRegistryRegister.register(FASlotDisplays.SLOT_DISPLAY_TYPES);
        simpleRegistryRegister.register(FARecipeDisplays.RECIPE_DISPLAY_TYPES);
        simpleRegistryRegister.register(FASoundEvents.SOUND_EVENTS);
        simpleRegistryRegister.register(FATrunkPlacerTypes.TRUNK_PLACER_TYPES);
        simpleRegistryRegister.register(FAFoliagePlacerTypes.FOLIAGE_PLACER_TYPES);
        simpleRegistryRegister.register(FAFluids.FLUIDS);
        simpleRegistryRegister.register(FABlocks.BLOCKS);
        simpleRegistryRegister.register(FABlockTypes.BLOCK_TYPES);
        simpleRegistryRegister.register(FAFeatures.FEATURES);
        simpleRegistryRegister.register(FABlockEntityTypes.BLOCK_ENTITY_TYPES);
        simpleRegistryRegister.register(FAMenuTypes.MENU_TYPES);
        simpleRegistryRegister.register(FAPregnancyTypes.PREGNANCY_TYPES);
        FAEntityDataSerializers.init();
        if (ModloaderHelper.INSTANCE.getPlatform() != Platform.FABRIC) {
            simpleRegistryRegister.register(FAPoiTypes.POI_TYPES);
        }
        simpleRegistryRegister.register(FAVillagerProfessions.VILLAGER_PROFESSIONS);
        simpleRegistryRegister.register(FAEntityTypes.ENTITY_TYPES);
        simpleRegistryRegister.register(FADataComponents.DATA_COMPONENT_TYPES);
        simpleRegistryRegister.register(FADinopediaLineTypes.DINOPEDIA_LINE_TYPES);
        simpleRegistryRegister.register(FAPatternInformationTypes.PATTERN_INFORMATION_TYPES);
        simpleRegistryRegister.register(FATextureTypes.TEXTURE_TYPES);
        simpleRegistryRegister.register(FAMapDecorationTypes.MAP_DECORATION_TYPE);
        simpleRegistryRegister.register(FAGenes.GENES);
        simpleRegistryRegister.register(FAItems.ITEMS);
        simpleRegistryRegister.register(FACreativeModeTabs.CREATIVE_MODE_TABS);
        simpleRegistryRegister.register(FALootPoolEntryTypes.LOOT_POOL_ENTRY_TYPES);
        simpleRegistryRegister.register(FARuleTestTypes.RULE_TEST_TYPES);
        simpleRegistryRegister.register(FAStructureProcessorType.STRUCTURE_PROCESSOR_TYPES);
        simpleRegistryRegister.register(FAStructurePeices.STRUCTURE_PIECE_TYPE);
        simpleRegistryRegister.register(FAStructureTypes.STRUCTURE_TYPE);
        simpleRegistryRegister.register(FACriteriaTriggers.TRIGGER_TYPES);
        simpleRegistryRegister.register(FAStats.STATS);
        FABiomeSources.init();
        FAGameRules.init();
    }
}
