package willatendo.fossilslegacy.data;

import java.util.List;
import java.util.Map;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableProvider.SubProviderEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import willatendo.fossilslegacy.data.loot.FossilsLegacyBlockLoot;
import willatendo.fossilslegacy.data.loot.FossilsLegacyChestLoot;
import willatendo.fossilslegacy.data.loot.FossilsLegacyEntityLoot;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.data.DataHelper;

@EventBusSubscriber(bus = Bus.MOD, modid = FossilsLegacyUtils.ID)
public class DataGen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataHelper.collectAllData(FossilsLegacyUtils.ID, event, FossilsLegacyLanguageProvider::new).addSoundDefinitionProvider(FossilsLegacySoundDefinitionsProvider::new).addBlockStateProvider(FossilsLegacyBlockStateProvider::new).addItemModelProvider(FossilsLegacyItemModelProvider::new).addBasicTagProviders(FossilsLegacyItemTagProvider::new, FossilsLegacyBlockTagProvider::new).addFluidTagProvider(FossilsLegacyFluidTagProvider::new).addBiomeTagProvider(FossilsLegacyBiomeTagProvider::new).addRecipeProvider(FossilsLegacyRecipeProvider::new).addLootProvider(DataGen::lootTableProvider).addAdvancementProvider(List.of(new FossilsLegacyAdvancementProvider())).addGeneric(FossilsLegacyCustomProviders::new).addGeneric(FossilsLegacyPlacedFeatureProvider::new).addGeneric(FossilsLegacyConfiguredFeatureProvider::new).addTagGeneric((packOutput, provider, id) -> new FossilsLegacyEntityTypeTagProvider(packOutput, provider, id, event.getExistingFileHelper())).addGeneric(FossilsLegacyBiomeModiferProvider::new);
	}

	public static LootTableProvider lootTableProvider(PackOutput packedOutpit) {
		return new LootTableProvider(packedOutpit, BuiltInLootTables.all(), List.of(new SubProviderEntry(FossilsLegacyBlockLoot::new, LootContextParamSets.BLOCK), new SubProviderEntry(FossilsLegacyEntityLoot::new, LootContextParamSets.ENTITY), new SubProviderEntry(FossilsLegacyChestLoot::new, LootContextParamSets.CHEST))) {
			@Override
			protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationcontext) {
			}
		};
	}
}
