package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import willatendo.fossilslegacy.data.loot.FossilsLegacyBlockLootTableProvider;
import willatendo.fossilslegacy.data.loot.FossilsLegacyChestLootTableProvider;
import willatendo.fossilslegacy.data.loot.FossilsLegacyEntityLootTableProvider;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = FossilsLegacyUtils.ID)
public class FossilsLegacyData {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent gatherDataEvent) {
        DataGenerator dataGenerator = gatherDataEvent.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        ExistingFileHelper existingFileHelper = gatherDataEvent.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> provider = gatherDataEvent.getLookupProvider();

        dataGenerator.addProvider(gatherDataEvent.includeClient(), new FossilsLegacyItemModelProvider(packOutput, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeClient(), new FossilsLegacyBlockStateProvider(packOutput, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeClient(), new FossilsLegacySoundDefinitionsProvider(packOutput, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeClient(), new FossilsLegacyLanguageProvider(packOutput, FossilsLegacyUtils.ID, "en_us"));

        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyRecipeProvider(packOutput));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new AdvancementProvider(packOutput, provider, existingFileHelper, List.of(new FossilsLegacyAdvancementProvider())));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new LootTableProvider(packOutput, BuiltInLootTables.all(), List.of(new LootTableProvider.SubProviderEntry(FossilsLegacyBlockLootTableProvider::new, LootContextParamSets.BLOCK), new LootTableProvider.SubProviderEntry(FossilsLegacyChestLootTableProvider::new, LootContextParamSets.CHEST), new LootTableProvider.SubProviderEntry(FossilsLegacyEntityLootTableProvider::new, LootContextParamSets.ENTITY))));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyBuiltinProvider(packOutput, provider, FossilsLegacyUtils.ID));
        FossilsLegacyBlockTagProvider fossilsLegacyBlockTagProvider = new FossilsLegacyBlockTagProvider(packOutput, provider, FossilsLegacyUtils.ID, existingFileHelper);
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyItemTagProvider(packOutput, provider, fossilsLegacyBlockTagProvider.contentsGetter(), FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), fossilsLegacyBlockTagProvider);
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyBiomeTagProvider(packOutput, provider, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyFluidTagProvider(packOutput, provider, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyEntityTypeTagProvider(packOutput, provider, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyDamageTypeTagProvider(packOutput, provider, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyFossilVariantTagProvider(packOutput, provider, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyStoneTabletVariantTagProvider(packOutput, provider, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), PackMetadataGenerator.forFeaturePack(packOutput, FossilsLegacyUtils.translation("dataPack", "description")));

        //SimplePack legacyPackGenerator = dataGenerator.getBuiltinDatapack(gatherDataEvent.includeServer(), FossilsLegacyUtils.resource("fa_legacy_textures"));
        //legacyPackGenerator.addProvider(packOutput -> PackMetadataGenerator.forFeaturePack(packOutput, FossilsLegacyUtils.translation("dataPack", "fa_legacy_textures.description")));
    }
}
