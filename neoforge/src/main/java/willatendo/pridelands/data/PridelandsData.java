package willatendo.pridelands.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import willatendo.pridelands.data.loot.PridelandsBlockLootSubProvider;
import willatendo.pridelands.data.model.PridelandsBlockModelGenerator;
import willatendo.pridelands.data.model.PridelandsItemModelGenerator;
import willatendo.pridelands.data.tag.PridelandsBlockTagProvider;
import willatendo.pridelands.data.tag.PridelandsItemTagProvider;
import willatendo.pridelands.server.utils.PridelandsUtils;
import willatendo.simplelibrary.data.SimpleLootTableProvider;
import willatendo.simplelibrary.data.SimpleModelProvider;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = PridelandsUtils.ID)
public class PridelandsData {
    @SubscribeEvent
    public static void gatherDataEvent(GatherDataEvent.Client event) {
        DataGenerator dataGenerator = event.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> registries = event.getLookupProvider();

        event.addProvider(new SimpleModelProvider(PridelandsItemModelGenerator::new, PridelandsBlockModelGenerator::new, packOutput, PridelandsUtils.ID));
        event.addProvider(new PridelandsSoundDefinitionsProvider(packOutput, PridelandsUtils.ID));
        event.addProvider(new PridelandsLanguageProvider(packOutput, PridelandsUtils.ID, "en_us"));

        event.addProvider(new PridelandsRecipeProvider.Runner(packOutput, registries));
        event.addProvider(new SimpleLootTableProvider(packOutput, registries, new LootTableProvider.SubProviderEntry(PridelandsBlockLootSubProvider::new, LootContextParamSets.BLOCK)));
        PridelandsBlockTagProvider pridelandsBlockTagProvider = new PridelandsBlockTagProvider(packOutput, registries, PridelandsUtils.ID);
        event.addProvider(pridelandsBlockTagProvider);
        event.addProvider(new PridelandsItemTagProvider(packOutput, registries, pridelandsBlockTagProvider.contentsGetter(), PridelandsUtils.ID));
    }
}
