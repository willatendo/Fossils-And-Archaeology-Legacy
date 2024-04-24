package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import willatendo.fossilslegacy.data.loot.FossilsLegacyBlockLootSubProvider;
import willatendo.fossilslegacy.data.loot.FossilsLegacyChestLootSubProvider;
import willatendo.fossilslegacy.data.loot.FossilsLegacyEntityLootSubProvider;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = FossilsLegacyUtils.ID)
public class FossilsLegacyData {
    @SubscribeEvent
    public static void gatherDataEvent(GatherDataEvent gatherDataEvent) {
        DataGenerator dataGenerator = gatherDataEvent.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        ExistingFileHelper existingFileHelper = gatherDataEvent.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> registries = gatherDataEvent.getLookupProvider();

        dataGenerator.addProvider(gatherDataEvent.includeClient(), new FossilsLegacyItemModelProvider(packOutput, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeClient(), new FossilsLegacyBlockStateProvider(packOutput, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeClient(), new FossilsLegacySoundDefinitionsProvider(packOutput, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeClient(), new FossilsLegacyLanguageProvider(packOutput, FossilsLegacyUtils.ID, "en_us"));

        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyRecipeProvider(packOutput));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new AdvancementProvider(packOutput, registries, existingFileHelper, List.of(new FossilsLegacyAdvancementGenerator())));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new LootTableProvider(packOutput, BuiltInLootTables.all(), List.of(new LootTableProvider.SubProviderEntry(FossilsLegacyBlockLootSubProvider::new, LootContextParamSets.BLOCK), new LootTableProvider.SubProviderEntry(FossilsLegacyEntityLootSubProvider::new, LootContextParamSets.ENTITY), new LootTableProvider.SubProviderEntry(FossilsLegacyChestLootSubProvider::new, LootContextParamSets.CHEST))) {
            @Override
            protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationcontext) {
            }
        });
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyBuiltinProvider(packOutput, registries, FossilsLegacyUtils.ID));
        FossilsLegacyBlockTagProvider fossilsLegacyBlockTagProvider = new FossilsLegacyBlockTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper);
        dataGenerator.addProvider(gatherDataEvent.includeServer(), fossilsLegacyBlockTagProvider);
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyItemTagProvider(packOutput, registries, fossilsLegacyBlockTagProvider.contentsGetter(), FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyBiomeTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyFluidTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyEntityTypeTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyDamageTypeTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyFossilVariantTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyStoneTabletVariantTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), PackMetadataGenerator.forFeaturePack(packOutput, FossilsLegacyUtils.translation("dataPack", "description")));

        PackOutput legacyPack = new PackOutput(packOutput.getOutputFolder().resolve("resourcepacks").resolve("fa_legacy_textures"));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), PackMetadataGenerator.forFeaturePack(legacyPack, FossilsLegacyUtils.translation("dataPack", "fa_legacy_textures.description")));
    }
}
