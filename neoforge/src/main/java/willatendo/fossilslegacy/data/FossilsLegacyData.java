package willatendo.fossilslegacy.data;

import net.minecraft.DetectedVersion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import willatendo.fossilslegacy.data.advancement.LegacyAdvancementGenerator;
import willatendo.fossilslegacy.data.loot.*;
import willatendo.fossilslegacy.data.tag.*;
import willatendo.fossilslegacy.server.event.ModEvents;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.data.ResourcePackGenerator;
import willatendo.simplelibrary.data.SimpleDataMapProvider;
import willatendo.simplelibrary.data.SimpleLootTableProvider;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = FossilsLegacyUtils.ID)
public class FossilsLegacyData {
    @SubscribeEvent
    public static void gatherDataEvent(GatherDataEvent gatherDataEvent) {
        ModEvents.setupDataMaps();

        DataGenerator dataGenerator = gatherDataEvent.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        ExistingFileHelper existingFileHelper = gatherDataEvent.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> registries = gatherDataEvent.getLookupProvider();

        dataGenerator.addProvider(gatherDataEvent.includeClient(), new FossilsLegacyItemModelProvider(packOutput, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeClient(), new FossilsLegacyBlockStateProvider(packOutput, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeClient(), new FossilsLegacySoundDefinitionsProvider(packOutput, FossilsLegacyUtils.ID, existingFileHelper));
        FossilsLegacyLanguageProvider fossilsLegacyLanguageProvider = new FossilsLegacyLanguageProvider(packOutput, FossilsLegacyUtils.ID, "en_us");
        dataGenerator.addProvider(gatherDataEvent.includeClient(), fossilsLegacyLanguageProvider);
        dataGenerator.addProvider(gatherDataEvent.includeClient(), new FossilsLegacyEntityModelProvider(packOutput, FossilsLegacyUtils.ID));
        dataGenerator.addProvider(gatherDataEvent.includeClient(), new FossilsLegacyAnimationProvider(packOutput, FossilsLegacyUtils.ID));

        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyRecipeProvider(packOutput, registries, FossilsLegacyUtils.ID));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new AdvancementProvider(packOutput, registries, existingFileHelper, List.of(new LegacyAdvancementGenerator())));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new SimpleLootTableProvider(packOutput, registries, new LootTableProvider.SubProviderEntry(FossilsLegacyBlockLootSubProvider::new, LootContextParamSets.BLOCK), new LootTableProvider.SubProviderEntry(FossilsLegacyEntityLootSubProvider::new, LootContextParamSets.ENTITY), new LootTableProvider.SubProviderEntry(FossilsLegacyChestLootSubProvider::new, LootContextParamSets.CHEST), new LootTableProvider.SubProviderEntry(FossilsLegacyGiftLootSubProvider::new, LootContextParamSets.GIFT), new LootTableProvider.SubProviderEntry(FossilsLegacyArchaeologyLootSubProvider::new, LootContextParamSets.ARCHAEOLOGY)));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyBuiltinProvider(packOutput, registries, FossilsLegacyUtils.ID));
        //dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyDataMapProvider(packOutput, registries));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new SimpleDataMapProvider(packOutput, registries, ModEvents.NEOFORGE_COMPOSTABLES_MODIFICATION, ModEvents.NEOFORGE_HERO_OF_THE_VILLAGE_GIFT_MODIFICATION, ModEvents.NEOFORGE_OXIDATION_MODIFICATION, ModEvents.NEOFORGE_WAXABLE_MODIFICATION));
        FossilsLegacyBlockTagProvider fossilsLegacyBlockTagProvider = new FossilsLegacyBlockTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper);
        dataGenerator.addProvider(gatherDataEvent.includeServer(), fossilsLegacyBlockTagProvider);
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyItemTagProvider(packOutput, registries, fossilsLegacyBlockTagProvider.contentsGetter(), FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyBiomeTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyFluidTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyEntityTypeTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyDamageTypeTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyFossilVariantTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyStoneTabletVariantTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyCoatTypeTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyPOITypeTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyStructureTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new PackMetadataGenerator(packOutput).add(PackMetadataSection.TYPE, new PackMetadataSection(FossilsLegacyUtils.translation("resourcePack", "description"), DetectedVersion.BUILT_IN.getPackVersion(PackType.CLIENT_RESOURCES), Optional.empty())));

        ResourceLocation legacyPack = FossilsLegacyUtils.resource("fa_legacy_textures");
        ResourcePackGenerator legacyPackGenerator = new ResourcePackGenerator(dataGenerator, true, legacyPack.toString(), new PackOutput(dataGenerator.getPackOutput().getOutputFolder().resolve("resourcepacks").resolve(legacyPack.getPath())));
        legacyPackGenerator.addProvider(legacyPackOutput -> new PackMetadataGenerator(legacyPackOutput).add(PackMetadataSection.TYPE, new PackMetadataSection(FossilsLegacyUtils.translation("resourcePack", "fa_legacy_textures.description"), DetectedVersion.BUILT_IN.getPackVersion(PackType.CLIENT_RESOURCES), Optional.empty())));
    }
}
