package willatendo.fossilslegacy;

import willatendo.simplelibrary.enum_extender.EnumExtenderInitializer;

import java.util.List;

public class FossilsLegacyEnumExtenders implements EnumExtenderInitializer {
    @Override
    public List<String> getRecipeBookTypes() {
        return List.of("analyzer", "archaeology_workbench", "cultivator");
    }
}
