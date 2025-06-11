package willatendo.missinglinks.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import willatendo.missinglinks.data.loot.MissingBlockLootSubProvider;
import willatendo.missinglinks.data.model.MissingBlockModelGenerator;
import willatendo.missinglinks.data.model.MissingItemModelGenerator;
import willatendo.missinglinks.data.tag.MissingBlockTagProvider;
import willatendo.missinglinks.data.tag.MissingItemTagProvider;
import willatendo.missinglinks.server.util.MissingLinks2Utils;
import willatendo.simplelibrary.data.SimpleLootTableProvider;
import willatendo.simplelibrary.data.SimpleModelProvider;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = MissingLinks2Utils.ID)
public class MissingData {
    @SubscribeEvent
    public static void gatherDataEvent(GatherDataEvent.Client event) {
        DataGenerator dataGenerator = event.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> registries = event.getLookupProvider();

        event.addProvider(new SimpleModelProvider(MissingItemModelGenerator::new, MissingBlockModelGenerator::new, packOutput, MissingLinks2Utils.ID));
        event.addProvider(new MissingLanguageProvider(packOutput, MissingLinks2Utils.ID, "en_us"));

        event.addProvider(new MissingRecipeProvider.Runner(packOutput, registries));
        event.addProvider(new SimpleLootTableProvider(packOutput, registries, new LootTableProvider.SubProviderEntry(MissingBlockLootSubProvider::new, LootContextParamSets.BLOCK)));
        MissingBlockTagProvider missingBlockTagProvider = new MissingBlockTagProvider(packOutput, registries, MissingLinks2Utils.ID);
        event.addProvider(missingBlockTagProvider);
        event.addProvider(new MissingItemTagProvider(packOutput, registries, missingBlockTagProvider.contentsGetter(), MissingLinks2Utils.ID));
    }
}
