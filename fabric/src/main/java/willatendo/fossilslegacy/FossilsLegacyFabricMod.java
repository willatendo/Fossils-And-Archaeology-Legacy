package willatendo.fossilslegacy;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.api.ModInitializer;
import net.minecraft.stats.RecipeBookSettings;
import net.minecraft.world.inventory.RecipeBookType;
import willatendo.fossilslegacy.server.event.ModCallbacks;
import willatendo.fossilslegacy.server.event.ModEvents;
import willatendo.fossilslegacy.server.menu.FARecipeBookTypes;
import willatendo.simplelibrary.server.event.registry.FabricSimpleRegistryRegister;

public class FossilsLegacyFabricMod implements ModInitializer {
    @Override
    public void onInitialize() {
        FossilsLegacyMod.onInitialize(new FabricSimpleRegistryRegister());

        ModCallbacks.callbacks();
        ModEvents.commonSetup();

        ImmutableMap.Builder<RecipeBookType, Pair<String, String>> tagFields = ImmutableMap.<RecipeBookType, Pair<String, String>>builder().putAll(RecipeBookSettings.TAG_FIELDS);
        tagFields.put(FARecipeBookTypes.ARCHAEOLOGY_WORKBENCH, Pair.of("isArchaeologyWorkbenchGuiOpen", "isArchaeologyWorkbenchFilteringCraftable"));
        tagFields.put(FARecipeBookTypes.CULTIVATOR, Pair.of("isCultivatorGuiOpen", "isCultivatorFilteringCraftable"));
        tagFields.put(FARecipeBookTypes.ANALYZER, Pair.of("isAnalyzerGuiOpen", "isAnalyzerFilteringCraftable"));
        RecipeBookSettings.TAG_FIELDS = tagFields.build();
    }
}
