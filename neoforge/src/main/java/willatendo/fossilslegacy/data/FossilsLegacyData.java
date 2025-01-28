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

        dataGenerator.addProvider(gatherDataEvent.includeClient(), new FAItemModelProvider(packOutput, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeClient(), new FABlockStateProvider(packOutput, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeClient(), new FASoundDefinitionsProvider(packOutput, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeClient(), new FALanguageProvider(packOutput, FossilsLegacyUtils.ID, "en_us"));
        dataGenerator.addProvider(gatherDataEvent.includeClient(), new FAEntityModelProvider(packOutput, FossilsLegacyUtils.ID));
        dataGenerator.addProvider(gatherDataEvent.includeClient(), new FAAnimationProvider(packOutput, FossilsLegacyUtils.ID));

        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FARecipeProvider(packOutput, registries, FossilsLegacyUtils.ID));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new AdvancementProvider(packOutput, registries, existingFileHelper, List.of(new LegacyAdvancementGenerator())));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new SimpleLootTableProvider(packOutput, registries, new LootTableProvider.SubProviderEntry(FABlockLootSubProvider::new, LootContextParamSets.BLOCK), new LootTableProvider.SubProviderEntry(FAEntityLootSubProvider::new, LootContextParamSets.ENTITY), new LootTableProvider.SubProviderEntry(FAChestLootSubProvider::new, LootContextParamSets.CHEST), new LootTableProvider.SubProviderEntry(FAGiftLootSubProvider::new, LootContextParamSets.GIFT), new LootTableProvider.SubProviderEntry(FAArchaeologyLootSubProvider::new, LootContextParamSets.ARCHAEOLOGY)));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FABuiltinProvider(packOutput, registries, FossilsLegacyUtils.ID));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new SimpleDataMapProvider(packOutput, registries, ModEvents.NEOFORGE_COMPOSTABLES_MODIFICATION, ModEvents.NEOFORGE_HERO_OF_THE_VILLAGE_GIFT_MODIFICATION, ModEvents.NEOFORGE_OXIDATION_MODIFICATION, ModEvents.NEOFORGE_WAXABLE_MODIFICATION));
        FABlockTagProvider FABlockTagProvider = new FABlockTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper);
        dataGenerator.addProvider(gatherDataEvent.includeServer(), FABlockTagProvider);
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FAItemTagProvider(packOutput, registries, FABlockTagProvider.contentsGetter(), FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FABiomeTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FAFluidTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FAEntityTypeTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FADamageTypeTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FAFossilVariantTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FAStoneTabletVariantTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FACoatTypeTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FAPOITypeTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FAStructureTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FAAnalyzerResultTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FAFuelEntryTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new PackMetadataGenerator(packOutput).add(PackMetadataSection.TYPE, new PackMetadataSection(FossilsLegacyUtils.translation("resourcePack", "description"), DetectedVersion.BUILT_IN.getPackVersion(PackType.CLIENT_RESOURCES), Optional.empty())));

        ResourceLocation legacyPack = FossilsLegacyUtils.resource("fa_legacy_textures");
        ResourcePackGenerator legacyPackGenerator = new ResourcePackGenerator(dataGenerator, true, legacyPack.toString(), new PackOutput(dataGenerator.getPackOutput().getOutputFolder().resolve("resourcepacks").resolve(legacyPack.getPath())));
        legacyPackGenerator.addProvider(legacyPackOutput -> new PackMetadataGenerator(legacyPackOutput).add(PackMetadataSection.TYPE, new PackMetadataSection(FossilsLegacyUtils.translation("resourcePack", "fa_legacy_textures.description"), DetectedVersion.BUILT_IN.getPackVersion(PackType.CLIENT_RESOURCES), Optional.empty())));
        legacyPackGenerator.addProvider(legacyPackOutput -> new FALegacyTexturesBlockStateProvider(legacyPackOutput, FossilsLegacyUtils.ID, existingFileHelper));
    }
}
