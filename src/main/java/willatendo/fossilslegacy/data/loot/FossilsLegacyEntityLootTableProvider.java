package willatendo.fossilslegacy.data.loot;

import java.util.Optional;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.item.FossilsLegacyLootTables;
import willatendo.fossilslegacy.server.loot.LootOneItemOfManyRandom;
import willatendo.fossilslegacy.server.loot.LootOneItemOfManyRandom.ItemAndChance;
import willatendo.simplelibrary.data.loot.SimpleEntityLootSubProvider;

public class FossilsLegacyEntityLootTableProvider extends SimpleEntityLootSubProvider {
	public FossilsLegacyEntityLootTableProvider(FabricDataOutput fabricDataOutput) {
		super(fabricDataOutput);
	}

	@Override
	public void generate() {
		this.add(FossilsLegacyEntities.BRACHIOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_BRACHIOSAURUS_MEAT.get()));
		this.add(FossilsLegacyEntities.DILOPHOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_DILOPHOSAURUS_MEAT.get()));
		this.add(FossilsLegacyEntities.MAMMOTH.get(), this.createDinosaurTable(0.0F, 3.0F, Items.LEATHER, 1.0F, 3.0F, FossilsLegacyItems.RAW_MAMMOTH_MEAT.get()));
		this.add(FossilsLegacyEntities.MOSASAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_MOSASAURUS_MEAT.get()));
		this.add(FossilsLegacyEntities.NAUTILUS.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootOneItemOfManyRandom.lootTableItem(5, new ItemAndChance(FossilsLegacyItems.NAUTILUS_SHELL.get(), 0, 3), new ItemAndChance(FossilsLegacyItems.MAGIC_CONCH.get(), 3, 5)))));
		this.add(FossilsLegacyEntities.PTERANODON.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_PTERANODON_MEAT.get()));
		this.add(FossilsLegacyEntities.FUTABASAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_FUTABASAURUS_MEAT.get()));
		this.add(FossilsLegacyEntities.SMILODON.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_SMILODON_MEAT.get()));
		this.add(FossilsLegacyEntities.STEGOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_STEGOSAURUS_MEAT.get()));
		this.add(FossilsLegacyEntities.TRICERATOPS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_TRICERATOPS_MEAT.get()));
		this.add(FossilsLegacyEntities.TYRANNOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_TYRANNOSAURUS_MEAT.get()).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(FossilsLegacyItems.TYRANNOSAURUS_TOOTH.get()))));
		this.add(FossilsLegacyEntities.VELOCIRAPTOR.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_VELOCIRAPTOR_MEAT.get()));

		this.add(FossilsLegacyEntities.TAMED_ZOMBIFIED_PIGLIN.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0f, 1.0f))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f)).add(LootItem.lootTableItem(Items.GOLD_NUGGET).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.GOLD_INGOT)).when(LootItemKilledByPlayerCondition.killedByPlayer()).when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))));
		this.add(FossilsLegacyEntities.FAILURESAURUS.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 2.0F)).add(LootItem.lootTableItem(FossilsLegacyItems.FOSSIL.get()))));

		this.add(FossilsLegacyEntities.EGG.get(), LootTable.lootTable());
		this.add(FossilsLegacyEntities.EGG.get(), FossilsLegacyLootTables.BRACHIOSAURUS_EGG, this.createEggTable(FossilsLegacyItems.BRACHIOSAURUS_EGG.get()));
		this.add(FossilsLegacyEntities.EGG.get(), FossilsLegacyLootTables.DILOPHOSAURUS_EGG, this.createEggTable(FossilsLegacyItems.DILOPHOSAURUS_EGG.get()));
		this.add(FossilsLegacyEntities.EGG.get(), FossilsLegacyLootTables.MOSASAURUS_EGG, this.createEggTable(FossilsLegacyItems.MOSASAURUS_EGG.get()));
		this.add(FossilsLegacyEntities.EGG.get(), FossilsLegacyLootTables.FUTABASAURUS_EGG, this.createEggTable(FossilsLegacyItems.FUTABASAURUS_EGG.get()));
		this.add(FossilsLegacyEntities.EGG.get(), FossilsLegacyLootTables.PTERANODON_EGG, this.createEggTable(FossilsLegacyItems.PTERANODON_EGG.get()));
		this.add(FossilsLegacyEntities.EGG.get(), FossilsLegacyLootTables.STEGOSAURUS_EGG, this.createEggTable(FossilsLegacyItems.STEGOSAURUS_EGG.get()));
		this.add(FossilsLegacyEntities.EGG.get(), FossilsLegacyLootTables.TRICERATOPS_EGG, this.createEggTable(FossilsLegacyItems.TRICERATOPS_EGG.get()));
		this.add(FossilsLegacyEntities.EGG.get(), FossilsLegacyLootTables.TYRANNOSAURUS_EGG, this.createEggTable(FossilsLegacyItems.TYRANNOSAURUS_EGG.get()));
		this.add(FossilsLegacyEntities.EGG.get(), FossilsLegacyLootTables.VELOCIRAPTOR_EGG, this.createEggTable(FossilsLegacyItems.VELOCIRAPTOR_EGG.get()));

		this.add(FossilsLegacyEntities.PREGNANT_CAT.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.STRING).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))))));
		this.add(FossilsLegacyEntities.PREGNANT_COW.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.BEEF).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))).apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));
		this.add(FossilsLegacyEntities.PREGNANT_DOLPHIN.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.COD).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))).apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))));
		this.add(FossilsLegacyEntities.PREGNANT_DONKEY.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));
		this.add(FossilsLegacyEntities.PREGNANT_FOX.get(), LootTable.lootTable());
		this.add(FossilsLegacyEntities.PREGNANT_GOAT.get(), LootTable.lootTable());
		this.add(FossilsLegacyEntities.PREGNANT_HORSE.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));
		this.add(FossilsLegacyEntities.PREGNANT_LLAMA.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));
		this.add(FossilsLegacyEntities.PREGNANT_MAMMOTH.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F)).setBonusRolls(UniformGenerator.between(0.0F, 2.0F)).add(LootItem.lootTableItem(Items.LEATHER))).withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F)).setBonusRolls(UniformGenerator.between(1.0F, 2.0F)).add(LootItem.lootTableItem(FossilsLegacyItems.RAW_MAMMOTH_MEAT.get()).apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))));
		this.add(FossilsLegacyEntities.PREGNANT_MULE.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));
		this.add(FossilsLegacyEntities.PREGNANT_OCELOT.get(), LootTable.lootTable());
		this.add(FossilsLegacyEntities.PREGNANT_PANDA.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Blocks.BAMBOO).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))));
		this.add(FossilsLegacyEntities.PREGNANT_PIG.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.PORKCHOP).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))).apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));
		this.add(FossilsLegacyEntities.PREGNANT_POLAR_BEAR.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.COD).apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))).add(LootItem.lootTableItem(Items.SALMON).apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));
		this.add(FossilsLegacyEntities.PREGNANT_RABBIT.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.RABBIT_HIDE).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.RABBIT).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.RABBIT_FOOT)).when(LootItemKilledByPlayerCondition.killedByPlayer()).when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.1F, 0.03F))));
		this.add(FossilsLegacyEntities.PREGNANT_SHEEP.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.MUTTON).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));
		this.add(FossilsLegacyEntities.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_BLACK, this.createPregnantSheepTable(Blocks.BLACK_WOOL));
		this.add(FossilsLegacyEntities.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_BLUE, this.createPregnantSheepTable(Blocks.BLUE_WOOL));
		this.add(FossilsLegacyEntities.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_BROWN, this.createPregnantSheepTable(Blocks.BROWN_WOOL));
		this.add(FossilsLegacyEntities.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_CYAN, this.createPregnantSheepTable(Blocks.CYAN_WOOL));
		this.add(FossilsLegacyEntities.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_GRAY, this.createPregnantSheepTable(Blocks.GRAY_WOOL));
		this.add(FossilsLegacyEntities.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_GREEN, this.createPregnantSheepTable(Blocks.GREEN_WOOL));
		this.add(FossilsLegacyEntities.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_LIGHT_BLUE, this.createPregnantSheepTable(Blocks.LIGHT_BLUE_WOOL));
		this.add(FossilsLegacyEntities.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_LIGHT_GRAY, this.createPregnantSheepTable(Blocks.LIGHT_GRAY_WOOL));
		this.add(FossilsLegacyEntities.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_LIME, this.createPregnantSheepTable(Blocks.LIME_WOOL));
		this.add(FossilsLegacyEntities.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_MAGENTA, this.createPregnantSheepTable(Blocks.MAGENTA_WOOL));
		this.add(FossilsLegacyEntities.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_ORANGE, this.createPregnantSheepTable(Blocks.ORANGE_WOOL));
		this.add(FossilsLegacyEntities.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_PINK, this.createPregnantSheepTable(Blocks.PINK_WOOL));
		this.add(FossilsLegacyEntities.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_PURPLE, this.createPregnantSheepTable(Blocks.PURPLE_WOOL));
		this.add(FossilsLegacyEntities.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_RED, this.createPregnantSheepTable(Blocks.RED_WOOL));
		this.add(FossilsLegacyEntities.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_WHITE, this.createPregnantSheepTable(Blocks.WHITE_WOOL));
		this.add(FossilsLegacyEntities.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_YELLOW, this.createPregnantSheepTable(Blocks.YELLOW_WOOL));
		this.add(FossilsLegacyEntities.PREGNANT_SMILODON.get(), LootTable.lootTable());
		this.add(FossilsLegacyEntities.PREGNANT_WOLF.get(), LootTable.lootTable());
	}

	protected LootTable.Builder createDinosaurTable(float minAdditional, float maxAdditional, ItemLike additionalDrop, float min, float max, ItemLike rawMeat) {
		return this.createDinosaurTable(Optional.of(minAdditional), Optional.of(maxAdditional), Optional.of(additionalDrop), min, max, rawMeat);
	}

	protected LootTable.Builder createDinosaurTable(float min, float max, ItemLike rawMeat) {
		return this.createDinosaurTable(Optional.empty(), Optional.empty(), Optional.empty(), min, max, rawMeat);
	}

	protected LootTable.Builder createDinosaurTable(Optional<Float> minAdditional, Optional<Float> maxAdditional, Optional<ItemLike> additionalDrop, float min, float max, ItemLike rawMeat) {
		LootTable.Builder builder = LootTable.lootTable();
		if (additionalDrop.isPresent() && minAdditional.isPresent() && maxAdditional.isPresent()) {
			builder.withPool(LootPool.lootPool().setRolls(UniformGenerator.between(minAdditional.get(), maxAdditional.get())).setBonusRolls(UniformGenerator.between(0.0F, 2.0F)).add(LootItem.lootTableItem(additionalDrop.get())));
		}
		builder.withPool(LootPool.lootPool().setRolls(UniformGenerator.between(min, max)).setBonusRolls(UniformGenerator.between(1.0F, 2.0F)).add(LootItem.lootTableItem(rawMeat).apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))));
		return builder;
	}

	protected LootTable.Builder createPregnantSheepTable(ItemLike itemLike) {
		return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(itemLike))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootTableReference.lootTableReference(FossilsLegacyEntities.PREGNANT_SHEEP.get().getDefaultLootTable())));
	}

	protected LootTable.Builder createEggTable(ItemLike itemLike) {
		return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(itemLike)));
	}
}
