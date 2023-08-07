package willatendo.fossilslegacy.data;

import java.util.Map;
import java.util.Set;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import willatendo.fossilslegacy.data.loot.FossilsLegacyLootTableProvider;

public class FossilsLegacyLootProvider extends LootTableProvider {
	public FossilsLegacyLootProvider(PackOutput packOutput) {
		super(packOutput, Set.of(), FossilsLegacyLootTableProvider.create(packOutput).getTables());
	}

	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationContext) {
	}
}
