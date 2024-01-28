package willatendo.fossilslegacy.data.loot;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

public class FossilsLegacyBlockLootTableProvider extends FabricBlockLootTableProvider {
	public FossilsLegacyBlockLootTableProvider(FabricDataOutput fabricDataOutput) {
		super(fabricDataOutput);
	}

	@Override
	public void generate() {
		this.add(FossilsLegacyBlocks.FOSSIL_ORE.get(), block -> this.createSilkTouchDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(FossilsLegacyItems.FOSSIL.get()).when(LootItemRandomChanceCondition.randomChance(0.2245F))).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(FossilsLegacyItems.RELIC_SCRAP.get()).when(LootItemRandomChanceCondition.randomChance(0.265F)))).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(Items.BONE).when(LootItemRandomChanceCondition.randomChance(0.4F)))).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(FossilsLegacyBlocks.SKULL_BLOCK.get()).when(LootItemRandomChanceCondition.randomChance(0.1F)))).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get()).when(LootItemRandomChanceCondition.randomChance(0.005F)))).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get()).when(LootItemRandomChanceCondition.randomChance(0.005F)))).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(FossilsLegacyItems.SCARAB_GEM.get()).when(LootItemRandomChanceCondition.randomChance(0.0005F))))));
		this.add(FossilsLegacyBlocks.DEEPSLATE_FOSSIL_ORE.get(), block -> this.createSilkTouchDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(FossilsLegacyItems.FOSSIL.get()).when(LootItemRandomChanceCondition.randomChance(0.2245F))).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(FossilsLegacyItems.RELIC_SCRAP.get()).when(LootItemRandomChanceCondition.randomChance(0.265F)))).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(Items.BONE).when(LootItemRandomChanceCondition.randomChance(0.4F)))).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(FossilsLegacyBlocks.SKULL_BLOCK.get()).when(LootItemRandomChanceCondition.randomChance(0.1F)))).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get()).when(LootItemRandomChanceCondition.randomChance(0.005F)))).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get()).when(LootItemRandomChanceCondition.randomChance(0.005F)))).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(FossilsLegacyItems.SCARAB_GEM.get()).when(LootItemRandomChanceCondition.randomChance(0.0005F))))));
		this.dropSelf(FossilsLegacyBlocks.SKULL_BLOCK.get());
		this.dropSelf(FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get());
		this.dropSelf(FossilsLegacyBlocks.ANALYZER.get());
		this.dropSelf(FossilsLegacyBlocks.CULTIVATOR.get());
		this.dropSelf(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get());
		this.add(FossilsLegacyBlocks.JURASSIC_FERN.get(), block -> this.createDoublePlantWithSeedDrops(block, FossilsLegacyBlocks.JURASSIC_FERN.get()));
		this.dropSelf(FossilsLegacyBlocks.DRUM.get());
		this.dropSelf(FossilsLegacyBlocks.FEEDER.get());
		this.add(FossilsLegacyBlocks.PERMAFROST.get(), block -> this.createSilkTouchDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(FossilsLegacyItems.JURASSIC_FERN_SPORES.get()).when(LootItemRandomChanceCondition.randomChance(0.2F))).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(FossilsLegacyBlocks.SKULL_BLOCK.get()).when(LootItemRandomChanceCondition.randomChance(0.2F)))).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(FossilsLegacyItems.FROZEN_MEAT.get()).when(LootItemRandomChanceCondition.randomChance(0.2F)))).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(Items.BEEF).when(LootItemRandomChanceCondition.randomChance(0.2F)))).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(Items.PORKCHOP).when(LootItemRandomChanceCondition.randomChance(0.2F))))));
		this.add(FossilsLegacyBlocks.ICED_STONE.get(), block -> this.createSingleItemTableWithSilkTouch(block, Blocks.COBBLESTONE));
		this.add(FossilsLegacyBlocks.AXOLOTLSPAWN.get(), noDrop());
	}
}
