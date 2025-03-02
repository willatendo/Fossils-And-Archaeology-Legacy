package willatendo.fossilslegacy.data;

import net.minecraft.DetectedVersion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import willatendo.fossilslegacy.data.advancement.LegacyAdvancementGenerator;
import willatendo.fossilslegacy.data.legacy.FALegacyModelProvider;
import willatendo.fossilslegacy.data.loot.*;
import willatendo.fossilslegacy.data.model.FABlockModelGenerator;
import willatendo.fossilslegacy.data.model.FAItemModelGenerator;
import willatendo.fossilslegacy.data.tag.*;
import willatendo.fossilslegacy.server.event.ModEvents;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.data.ResourcePackGenerator;
import willatendo.simplelibrary.data.SimpleDataMapProvider;
import willatendo.simplelibrary.data.SimpleLootTableProvider;
import willatendo.simplelibrary.data.SimpleModelProvider;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = FAUtils.ID)
public class FossilsLegacyData {
    @SubscribeEvent
    public static void gatherDataEvent(GatherDataEvent.Client event) {
        ModEvents.setupDataMaps();

        DataGenerator dataGenerator = event.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> registries = event.getLookupProvider();

        event.addProvider(new SimpleModelProvider(FAItemModelGenerator::new, FABlockModelGenerator::new, packOutput, FAUtils.ID));
        event.addProvider(new FASoundDefinitionsProvider(packOutput, FAUtils.ID));
        event.addProvider(new FALanguageProvider(packOutput, FAUtils.ID, "en_us"));
        event.addProvider(new FAEntityModelProvider(packOutput, FAUtils.ID));
        event.addProvider(new FAAnimationProvider(packOutput, FAUtils.ID));
        event.addProvider(new FAEquipmentAssetProvider(packOutput));

        event.addProvider(new FARecipeProvider.Runner(packOutput, registries));
        event.addProvider(new AdvancementProvider(packOutput, registries, List.of(new LegacyAdvancementGenerator())));
        event.addProvider(new SimpleLootTableProvider(packOutput, registries, new LootTableProvider.SubProviderEntry(FABlockLootSubProvider::new, LootContextParamSets.BLOCK), new LootTableProvider.SubProviderEntry(FAEntityLootSubProvider::new, LootContextParamSets.ENTITY), new LootTableProvider.SubProviderEntry(FAChestLootSubProvider::new, LootContextParamSets.CHEST), new LootTableProvider.SubProviderEntry(FAGiftLootSubProvider::new, LootContextParamSets.GIFT), new LootTableProvider.SubProviderEntry(FAArchaeologyLootSubProvider::new, LootContextParamSets.ARCHAEOLOGY), new LootTableProvider.SubProviderEntry(FAShearingLootSubProvider::new, LootContextParamSets.SHEARING)));
        event.addProvider(new FABuiltinProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new SimpleDataMapProvider(packOutput, registries, ModEvents.NEOFORGE_COMPOSTABLES_MODIFICATION, ModEvents.NEOFORGE_HERO_OF_THE_VILLAGE_GIFT_MODIFICATION, ModEvents.NEOFORGE_OXIDATION_MODIFICATION, ModEvents.NEOFORGE_WAXABLE_MODIFICATION));
        FABlockTagProvider FABlockTagProvider = new FABlockTagProvider(packOutput, registries, FAUtils.ID);
        event.addProvider(FABlockTagProvider);
        event.addProvider(new FAItemTagProvider(packOutput, registries, FABlockTagProvider.contentsGetter(), FAUtils.ID));
        event.addProvider(new FABiomeTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FAFluidTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FAEntityTypeTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FADamageTypeTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FAFossilVariantTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FAStoneTabletVariantTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FAModelTypeTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FAPOITypeTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FAStructureTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FAAnalyzerResultTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FAFuelEntryTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new PackMetadataGenerator(packOutput).add(PackMetadataSection.TYPE, new PackMetadataSection(FAUtils.translation("resourcePack", "description"), DetectedVersion.BUILT_IN.getPackVersion(PackType.CLIENT_RESOURCES), Optional.empty())));

        ResourceLocation legacyPack = FAUtils.resource("fa_legacy_textures");
        ResourcePackGenerator legacyPackGenerator = new ResourcePackGenerator(dataGenerator, true, legacyPack.toString(), new PackOutput(dataGenerator.getPackOutput().getOutputFolder().resolve("resourcepacks").resolve(legacyPack.getPath())));
        legacyPackGenerator.addProvider(legacyPackOutput -> new PackMetadataGenerator(legacyPackOutput).add(PackMetadataSection.TYPE, new PackMetadataSection(FAUtils.translation("resourcePack", "fa_legacy_textures.description"), DetectedVersion.BUILT_IN.getPackVersion(PackType.CLIENT_RESOURCES), Optional.empty())));
        legacyPackGenerator.addProvider(legacyPackOutput -> new FALegacyModelProvider(legacyPackOutput, FAUtils.ID));
    }
}
