package willatendo.fossilslegacy;

import willatendo.fossilslegacy.experiments.FossilsExperiments;
import willatendo.fossilslegacy.server.FossilsLegacyBuiltInRegistries;
import willatendo.fossilslegacy.server.FossilsLegacyCreativeModeTabs;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.block.entity.FossilsLegacyBlockEntities;
import willatendo.fossilslegacy.server.criteria.FossilsLegacyCriteriaTriggers;
import willatendo.fossilslegacy.server.entity.*;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.loot.FossilsLegacyLootPoolEntryTypes;
import willatendo.fossilslegacy.server.menu.FossilsLegacyMenus;
import willatendo.fossilslegacy.server.recipe.FossilsLegacyRecipeTypes;
import willatendo.fossilslegacy.server.recipe.serialiser.FossilsLegacyRecipeSerialisers;
import willatendo.fossilslegacy.server.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.structure.FossilsLegacyStructurePeices;
import willatendo.fossilslegacy.server.structure.FossilsLegacyStructureTypes;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.List;

public class FossilsLegacyMod {
    public static void onInitialize(List<SimpleRegistry<?>> simpleRegistries) {
        FossilsExperiments.init();

        FossilsLegacyBuiltInRegistries.init();

        FossilsLegacyRecipeTypes.init(simpleRegistries);
        FossilsLegacyRecipeSerialisers.init(simpleRegistries);
        FossilsLegacySoundEvents.init(simpleRegistries);
        FossilsLegacyBlocks.init(simpleRegistries);
        FossilsLegacyBlockEntities.init(simpleRegistries);
        FossilsLegacyMenus.init(simpleRegistries);
        FossilsLegacyEggVariants.init(simpleRegistries);
        FossilsLegacyPregnancyTypes.init(simpleRegistries);
        FossilsLegacyFossilVariants.init(simpleRegistries);
        FossilsLegacyStoneTabletVariants.init(simpleRegistries);
        FossilsLegacyEntityDataSerializers.init();
        FossilsLegacyEntityTypes.init(simpleRegistries);
        FossilsLegacyItems.init(simpleRegistries);
        FossilsLegacyCreativeModeTabs.init(simpleRegistries);
        FossilsLegacyLootPoolEntryTypes.init(simpleRegistries);
        FossilsLegacyStructurePeices.init(simpleRegistries);
        FossilsLegacyStructureTypes.init(simpleRegistries);
        FossilsLegacyCriteriaTriggers.init(simpleRegistries);
    }
}
