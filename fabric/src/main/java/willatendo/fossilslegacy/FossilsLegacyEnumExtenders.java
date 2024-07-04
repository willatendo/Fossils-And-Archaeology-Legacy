package willatendo.fossilslegacy;

import willatendo.simplelibrary.enumextender.EnumExtenderInitializer;
import willatendo.simplelibrary.enumextender.ExtendedRecipeBookCategory;

import java.util.List;

public class FossilsLegacyEnumExtenders implements EnumExtenderInitializer {
    @Override
    public List<String> getRecipeBookTypes() {
        return List.of("analyzer", "archaeology_workbench", "cultivator");
    }

    @Override
    public List<ExtendedRecipeBookCategory> getRecipeBookCategories() {
        return List.of(new ExtendedRecipeBookCategory("analyzation_search", "minecraft:compass"), new ExtendedRecipeBookCategory("analyzation_misc", "fossilslegacy:velociraptor_dna"), new ExtendedRecipeBookCategory("archaeology_search", "minecraft:compass"), new ExtendedRecipeBookCategory("archaeology_restore", "fossilslegacy:ancient_shovel_artifact"), new ExtendedRecipeBookCategory("archaeology_repair", "fossilslegacy:golden_javelin"), new ExtendedRecipeBookCategory("archaeology_misc", "fossilslegacy:relic_scrap"), new ExtendedRecipeBookCategory("cultivation_search", "minecraft:compass"), new ExtendedRecipeBookCategory("cultivation_eggs", "fossilslegacy:tyrannosaurus_egg"), new ExtendedRecipeBookCategory("cultivation_plants", "fossilslegacy:lepidodendron_sapling"), new ExtendedRecipeBookCategory("cultivation_misc", "fossilslegacy:triceratops_dna"));
    }
}
