package willatendo.fossilslegacy.data.loot;

import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithEnchantedBonusCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.criteria.critereon.DinosaurPredicate;
import willatendo.fossilslegacy.server.criteria.critereon.MammothPredicate;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.item.FALootTables;
import willatendo.fossilslegacy.server.loot.LootRandomItem;
import willatendo.fossilslegacy.server.loot.LootRandomItem.RandomItemEntry;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.data.loot.SimpleEntityLootSubProvider;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

public class FAEntityLootSubProvider extends SimpleEntityLootSubProvider {
    public FAEntityLootSubProvider(HolderLookup.Provider registries) {
        super(registries, FAUtils.ID);
    }

    @Override
    public void generate() {
        this.add(FAEntityTypes.ANKYLOSAURUS.get(), this.createDinosaurTable(8, 1.0F, 3.0F, FAItems.RAW_ANKYLOSAURUS.get()));
        this.add(FAEntityTypes.BARYONYX.get(), this.createDinosaurTable(8, 1.0F, 3.0F, FAItems.RAW_BARYONYX.get()));
        this.add(FAEntityTypes.BRACHIOSAURUS.get(), this.createDinosaurTable(36, 1.0F, 3.0F, FAItems.RAW_BRACHIOSAURUS.get()));
        this.add(FAEntityTypes.CARNOTAURUS.get(), this.createDinosaurTable(8, 1.0F, 3.0F, FAItems.RAW_CARNOTAURUS.get()));
        this.add(FAEntityTypes.COMPSOGNATHUS.get(), this.createDinosaurTable(8, 1.0F, 3.0F, FAItems.RAW_COMPSOGNATHUS.get()));
        this.add(FAEntityTypes.CRYOLOPHOSAURUS.get(), this.createDinosaurTable(8, 1.0F, 3.0F, FAItems.RAW_CRYOLOPHOSAURUS.get()));
        this.add(FAEntityTypes.DILOPHOSAURUS.get(), this.createDinosaurTable(8, 1.0F, 3.0F, FAItems.RAW_DILOPHOSAURUS.get()));
        this.add(FAEntityTypes.DIMETRODON.get(), this.createDinosaurTable(12, 1.0F, 3.0F, FAItems.RAW_DIMETRODON.get()));
        this.add(FAEntityTypes.DISTORTUS_REX.get(), this.createDinosaurTable(8, 1.0F, 3.0F, FAItems.RAW_TYRANNOSAURUS.get()).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(FAItems.TYRANNOSAURUS_TOOTH.get()))));
        this.add(FAEntityTypes.DODO.get(), this.createDinosaurTable(8, 1.0F, 2.0F, FAItems.RAW_DODO.get()));
        this.add(FAEntityTypes.DRYOSAURUS.get(), this.createDinosaurTable(8, 1.0F, 3.0F, FAItems.RAW_DRYOSAURUS.get()));
        this.add(FAEntityTypes.MOA.get(), this.createDinosaurTable(8, 1.0F, 2.0F, FAItems.RAW_MOA.get()));
        this.add(FAEntityTypes.ELASMOTHERIUM.get(), this.createDinosaurTable(8, 1.0F, 3.0F, FAItems.RAW_ELASMOTHERIUM.get()));
        this.add(FAEntityTypes.FUTABASAURUS.get(), this.createDinosaurTable(12, 1.0F, 3.0F, FAItems.RAW_FUTABASAURUS.get()));
        this.add(FAEntityTypes.GALLIMIMUS.get(), this.createDinosaurTable(8, 1.0F, 3.0F, FAItems.RAW_GALLIMIMUS.get()));
        this.add(FAEntityTypes.ICHTHYOSAURUS.get(), this.createDinosaurTable(8, 1.0F, 3.0F, FAItems.RAW_ICHTHYOSAURUS.get()));
        this.add(FAEntityTypes.ISOTELUS.get(), LootTable.lootTable());
        this.add(FAEntityTypes.ISOTELUS_LARVA.get(), LootTable.lootTable());
        this.add(FAEntityTypes.MAMMOTH.get(), this.createDinosaurTable(8, 0.0F, 3.0F, Items.LEATHER, 1.0F, 3.0F, FAItems.RAW_MAMMOTH.get()));
        this.add(FAEntityTypes.MOSASAURUS.get(), this.createDinosaurTable(8, 1.0F, 3.0F, FAItems.RAW_MOSASAURUS.get()));
        this.add(FAEntityTypes.NAUTILUS.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootRandomItem.randomItem(5, new RandomItemEntry(FAItems.NAUTILUS_SHELL.get(), 0, 3), new RandomItemEntry(FAItems.MAGIC_CONCH.get(), 3, 5)))));
        this.add(FAEntityTypes.PACHYCEPHALOSAURUS.get(), this.createDinosaurTable(8, 1.0F, 3.0F, FAItems.RAW_PACHYCEPHALOSAURUS.get()));
        this.add(FAEntityTypes.PTERANODON.get(), this.createDinosaurTable(8, 1.0F, 3.0F, FAItems.RAW_PTERANODON.get()));
        this.add(FAEntityTypes.SMILODON.get(), this.createDinosaurTable(8, 1.0F, 3.0F, FAItems.RAW_SMILODON.get()));
        this.add(FAEntityTypes.SPINOSAURUS.get(), this.createDinosaurTable(8, 1.0F, 3.0F, FAItems.RAW_SPINOSAURUS.get()));
        this.add(FAEntityTypes.STEGOSAURUS.get(), this.createDinosaurTable(12, 1.0F, 3.0F, FAItems.RAW_STEGOSAURUS.get()));
        this.add(FAEntityTypes.THERIZINOSAURUS.get(), this.createDinosaurTable(10, 1.0F, 3.0F, FAItems.RAW_THERIZINOSAURUS.get()).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.FEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))).add(LootItem.lootTableItem(FAItems.THERIZINOSAURUS_CLAWS.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))));
        this.add(FAEntityTypes.TRICERATOPS.get(), this.createDinosaurTable(12, 1.0F, 3.0F, FAItems.RAW_TRICERATOPS.get()));
        this.add(FAEntityTypes.TYRANNOSAURUS.get(), this.createDinosaurTable(8, 1.0F, 3.0F, FAItems.RAW_TYRANNOSAURUS.get()).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(FAItems.TYRANNOSAURUS_TOOTH.get()))));
        this.add(FAEntityTypes.VELOCIRAPTOR.get(), this.createDinosaurTable(8, 1.0F, 3.0F, FAItems.RAW_VELOCIRAPTOR.get()));

        this.add(FAEntityTypes.ANKYLOSAURUS_EGG.get(), this.createEggTable(FAItems.ANKYLOSAURUS_EGG.get()));
        this.add(FAEntityTypes.BARYONYX_EGG.get(), this.createEggTable(FAItems.BARYONYX_EGG.get()));
        this.add(FAEntityTypes.BRACHIOSAURUS_EGG.get(), this.createEggTable(FAItems.BRACHIOSAURUS_EGG.get()));
        this.add(FAEntityTypes.CARNOTAURUS_EGG.get(), this.createEggTable(FAItems.CARNOTAURUS_EGG.get()));
        this.add(FAEntityTypes.COMPSOGNATHUS_EGG.get(), this.createEggTable(FAItems.COMPSOGNATHUS_EGG.get()));
        this.add(FAEntityTypes.CRYOLOPHOSAURUS_EGG.get(), this.createEggTable(FAItems.CRYOLOPHOSAURUS_EGG.get()));
        this.add(FAEntityTypes.DILOPHOSAURUS_EGG.get(), this.createEggTable(FAItems.DILOPHOSAURUS_EGG.get()));
        this.add(FAEntityTypes.DIMETRODON_EGG.get(), this.createEggTable(FAItems.DIMETRODON_EGG.get()));
        this.add(FAEntityTypes.DRYOSAURUS_EGG.get(), this.createEggTable(FAItems.DRYOSAURUS_EGG.get()));
        this.add(FAEntityTypes.FUTABASAURUS_EGG.get(), this.createEggTable(FAItems.FUTABASAURUS_EGG.get()));
        this.add(FAEntityTypes.GALLIMIMUS_EGG.get(), this.createEggTable(FAItems.GALLIMIMUS_EGG.get()));
        this.add(FAEntityTypes.ICHTHYOSAURUS_EGG.get(), this.createEggTable(FAItems.ICHTHYOSAURUS_EGG.get()));
        this.add(FAEntityTypes.MOSASAURUS_EGG.get(), this.createEggTable(FAItems.MOSASAURUS_EGG.get()));
        this.add(FAEntityTypes.PACHYCEPHALOSAURUS_EGG.get(), this.createEggTable(FAItems.PACHYCEPHALOSAURUS_EGG.get()));
        this.add(FAEntityTypes.PTERANODON_EGG.get(), this.createEggTable(FAItems.PTERANODON_EGG.get()));
        this.add(FAEntityTypes.SPINOSAURUS_EGG.get(), this.createEggTable(FAItems.SPINOSAURUS_EGG.get()));
        this.add(FAEntityTypes.STEGOSAURUS_EGG.get(), this.createEggTable(FAItems.STEGOSAURUS_EGG.get()));
        this.add(FAEntityTypes.THERIZINOSAURUS_EGG.get(), this.createEggTable(FAItems.THERIZINOSAURUS_EGG.get()));
        this.add(FAEntityTypes.TRICERATOPS_EGG.get(), this.createEggTable(FAItems.TRICERATOPS_EGG.get()));
        this.add(FAEntityTypes.TYRANNOSAURUS_EGG.get(), this.createEggTable(FAItems.TYRANNOSAURUS_EGG.get()));
        this.add(FAEntityTypes.VELOCIRAPTOR_EGG.get(), this.createEggTable(FAItems.VELOCIRAPTOR_EGG.get()));

        this.add(FAEntityTypes.PREGNANT_ARMADILLO.get(), LootTable.lootTable());
        this.add(FAEntityTypes.PREGNANT_CAT.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.STRING).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))))));
        this.add(FAEntityTypes.PREGNANT_COW.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.BEEF).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FAEntityTypes.PREGNANT_DOLPHIN.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.COD).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())))));
        this.add(FAEntityTypes.PREGNANT_DONKEY.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FAEntityTypes.PREGNANT_ELASMOTHERIUM.get(), this.createDinosaurTable(8, 1.0F, 3.0F, FAItems.RAW_ELASMOTHERIUM.get()));
        this.add(FAEntityTypes.PREGNANT_FOX.get(), LootTable.lootTable());
        this.add(FAEntityTypes.PREGNANT_GOAT.get(), LootTable.lootTable());
        this.add(FAEntityTypes.PREGNANT_HORSE.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FAEntityTypes.PREGNANT_LLAMA.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FAEntityTypes.PREGNANT_MAMMOTH.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F)).setBonusRolls(UniformGenerator.between(0.0F, 2.0F)).add(LootItem.lootTableItem(Items.LEATHER))).withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F)).setBonusRolls(UniformGenerator.between(1.0F, 2.0F)).add(LootItem.lootTableItem(FAItems.RAW_MAMMOTH.get()).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())))));
        this.add(FAEntityTypes.PREGNANT_MULE.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FAEntityTypes.PREGNANT_OCELOT.get(), LootTable.lootTable());
        this.add(FAEntityTypes.PREGNANT_PANDA.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Blocks.BAMBOO).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))));
        this.add(FAEntityTypes.PREGNANT_PIG.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.PORKCHOP).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FAEntityTypes.PREGNANT_POLAR_BEAR.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.COD).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F)))).add(LootItem.lootTableItem(Items.SALMON).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FAEntityTypes.PREGNANT_RABBIT.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.RABBIT_HIDE).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.RABBIT).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.RABBIT_FOOT)).when(LootItemKilledByPlayerCondition.killedByPlayer()).when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.1F, 0.03F))));
        this.add(FAEntityTypes.PREGNANT_SHEEP.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.MUTTON).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))).withPool(FAEntityLootSubProvider.createSheepDispatchPool(FALootTables.SHEAR_PREGNANT_SHEEP_BY_DYE)));
        this.add(FAEntityTypes.PREGNANT_SMILODON.get(), this.createDinosaurTable(8, 1.0F, 3.0F, FAItems.RAW_SMILODON.get()));
        this.add(FAEntityTypes.PREGNANT_WOLF.get(), LootTable.lootTable());

        this.add(FAEntityTypes.ANU.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F)).add(LootItem.lootTableItem(Items.COOKED_PORKCHOP))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(FABlocks.TIME_MACHINE.get()))));
        this.add(FAEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0f, 1.0f))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f)).add(LootItem.lootTableItem(Items.GOLD_NUGGET).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F)))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.GOLD_INGOT)).when(LootItemKilledByPlayerCondition.killedByPlayer()).when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.025F, 0.01F))));
        this.add(FAEntityTypes.FAILURESAURUS.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 2.0F)).add(LootItem.lootTableItem(FAItems.MESOZOIC_FOSSIL.get()))));
    }

    protected LootTable.Builder createDinosaurTable(int growthStages, float minAdditional, float maxAdditional, ItemLike additionalDrop, float min, float max, ItemLike rawMeat) {
        return this.createDinosaurTable(growthStages, Optional.of(minAdditional), Optional.of(maxAdditional), Optional.of(additionalDrop), min, max, rawMeat);
    }

    protected LootTable.Builder createDinosaurTable(int growthStages, float min, float max, ItemLike rawMeat) {
        return this.createDinosaurTable(growthStages, Optional.empty(), Optional.empty(), Optional.empty(), min, max, rawMeat);
    }

    protected LootTable.Builder createDinosaurTable(int growthStages, Optional<Float> minAdditional, Optional<Float> maxAdditional, Optional<ItemLike> additionalDrop, float min, float max, ItemLike rawMeat) {
        LootTable.Builder builder = LootTable.lootTable();
        if (additionalDrop.isPresent() && minAdditional.isPresent() && maxAdditional.isPresent()) {
            builder.withPool(LootPool.lootPool().setRolls(UniformGenerator.between(minAdditional.get(), maxAdditional.get())).setBonusRolls(UniformGenerator.between(0.0F, 2.0F)).add(LootItem.lootTableItem(additionalDrop.get())));
        }
        for (int i = 0; i < growthStages + 1; i++) {
            builder.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(rawMeat).apply(SetItemCountFunction.setCount(UniformGenerator.between(min + i, max + i))).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F)))).when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().subPredicate(DinosaurPredicate.growthStage(MinMaxBounds.Ints.exactly(i))))));
        }
        return builder;
    }

    public static LootPool.Builder createMammothDispatchPool(Map<DyeColor, ResourceKey<LootTable>> lootTables) {
        AlternativesEntry.Builder builder = AlternativesEntry.alternatives();

        Map.Entry<DyeColor, ResourceKey<LootTable>> entry;
        for (Iterator<Map.Entry<DyeColor, ResourceKey<LootTable>>> entries = lootTables.entrySet().iterator(); entries.hasNext(); builder = builder.otherwise(NestedLootTable.lootTableReference(entry.getValue()).when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().subPredicate(MammothPredicate.hasWool(entry.getKey())))))) {
            entry = entries.next();
        }

        return LootPool.lootPool().add(builder);
    }

    protected LootTable.Builder createEggTable(Item eggItem) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(eggItem)));
    }
}
