package willatendo.fossilslegacy.server.event;

import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.BoatDispenseItemBehavior;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.armadillo.Armadillo;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.animal.horse.Mule;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.Heightmap;
import willatendo.fossilslegacy.server.analyzer_result.AnalyzerResult;
import willatendo.fossilslegacy.server.ancient_axe_bonus.AncientAxeBonus;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.blocks.SkullBlock;
import willatendo.fossilslegacy.server.block.cauldron.FACauldronInteraction;
import willatendo.fossilslegacy.server.block.dispenser.DispenseEntityItemBehavior;
import willatendo.fossilslegacy.server.block.entity.FABlockEntityTypes;
import willatendo.fossilslegacy.server.decoration_plaque_type.DecorationPlaqueType;
import willatendo.fossilslegacy.server.dinopedia_entry.DinopediaEntry;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.FAVillagerProfessions;
import willatendo.fossilslegacy.server.entity.entities.Anu;
import willatendo.fossilslegacy.server.entity.entities.Egg;
import willatendo.fossilslegacy.server.entity.entities.Failuresaurus;
import willatendo.fossilslegacy.server.entity.entities.Fossil;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.*;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.guadalupian.Dimetrodon;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.*;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.*;
import willatendo.fossilslegacy.server.feeder_food.FeederFood;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;
import willatendo.fossilslegacy.server.fuel.FuelEntry;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.item.FALootTables;
import willatendo.fossilslegacy.server.item.FAMapDecorationTypes;
import willatendo.fossilslegacy.server.item.items.EggItem;
import willatendo.fossilslegacy.server.jewel_recovery.JewelRecovery;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;
import willatendo.fossilslegacy.server.pattern.texture.Texture;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.stats.FAStats;
import willatendo.fossilslegacy.server.stone_tablet_variant.StoneTabletVariant;
import willatendo.fossilslegacy.server.tags.FABlockTags;
import willatendo.fossilslegacy.server.tags.FAStructureTags;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.event.modification.*;
import willatendo.simplelibrary.server.event.registry.*;

import java.util.List;

public final class BasicEvents {
    public static void commonSetup() {
        FACauldronInteraction.init();

        EggItem.EGGS.forEach(eggItem -> DispenserBlock.registerBehavior(eggItem, new DispenseEntityItemBehavior()));
        DispenserBlock.registerBehavior(FAItems.NAUTILUS_EGGS.get(), new DispenseEntityItemBehavior());
        DispenserBlock.registerBehavior(FAItems.NAUTILUS.get(), new DispenseEntityItemBehavior());
        DispenserBlock.registerBehavior(FAItems.ARTICULATED_FOSSIL.get(), new DispenseEntityItemBehavior());
        DispenserBlock.registerProjectileBehavior(FAItems.INCUBATED_CHICKEN_EGG.get());
        DispenserBlock.registerProjectileBehavior(FAItems.INCUBATED_PARROT_EGG.get());
        DispenserBlock.registerBehavior(FABlocks.SKULL_BLOCK.get(), new OptionalDispenseItemBehavior() {
            @Override
            protected ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
                Level level = blockSource.level();
                BlockPos blockPos = blockSource.pos().relative(blockSource.state().getValue(DispenserBlock.FACING));
                SkullBlock skullBlock = FABlocks.SKULL_BLOCK.get();
                if (level.isEmptyBlock(blockPos) && skullBlock.canSpawnAnu(level, blockPos)) {
                    if (!level.isClientSide()) {
                        level.setBlock(blockPos, skullBlock.defaultBlockState(), 3);
                        level.gameEvent(null, GameEvent.BLOCK_PLACE, blockPos);
                    }

                    itemStack.shrink(1);
                    this.setSuccess(true);
                }

                return itemStack;
            }
        });
        DispenserBlock.registerBehavior(FABlocks.SKULL_LANTERN_BLOCK.get(), new OptionalDispenseItemBehavior() {
            @Override
            protected ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
                Level level = blockSource.level();
                BlockPos blockPos = blockSource.pos().relative(blockSource.state().getValue(DispenserBlock.FACING));
                SkullBlock skullBlock = (SkullBlock) FABlocks.SKULL_LANTERN_BLOCK.get();
                if (level.isEmptyBlock(blockPos) && skullBlock.canSpawnAnu(level, blockPos)) {
                    if (!level.isClientSide()) {
                        level.setBlock(blockPos, skullBlock.defaultBlockState(), 3);
                        level.gameEvent(null, GameEvent.BLOCK_PLACE, blockPos);
                    }

                    itemStack.shrink(1);
                    this.setSuccess(true);
                }

                return itemStack;
            }
        });
        DispenserBlock.registerBehavior(FAItems.ARCHAEOPTERIS_BOAT.get(), new BoatDispenseItemBehavior(FAEntityTypes.ARCHAEOPTERIS_BOAT.get()));
        DispenserBlock.registerBehavior(FAItems.CALAMITES_BOAT.get(), new BoatDispenseItemBehavior(FAEntityTypes.CALAMITES_BOAT.get()));
        DispenserBlock.registerBehavior(FAItems.GINKGO_BOAT.get(), new BoatDispenseItemBehavior(FAEntityTypes.GINKGO_BOAT.get()));
        DispenserBlock.registerBehavior(FAItems.LEPIDODENDRON_BOAT.get(), new BoatDispenseItemBehavior(FAEntityTypes.LEPIDODENDRON_BOAT.get()));
        DispenserBlock.registerBehavior(FAItems.SIGILLARIA_BOAT.get(), new BoatDispenseItemBehavior(FAEntityTypes.SIGILLARIA_BOAT.get()));
        DispenserBlock.registerBehavior(FAItems.ARCHAEOPTERIS_CHEST_BOAT.get(), new BoatDispenseItemBehavior(FAEntityTypes.ARCHAEOPTERIS_CHEST_BOAT.get()));
        DispenserBlock.registerBehavior(FAItems.CALAMITES_CHEST_BOAT.get(), new BoatDispenseItemBehavior(FAEntityTypes.CALAMITES_CHEST_BOAT.get()));
        DispenserBlock.registerBehavior(FAItems.GINKGO_CHEST_BOAT.get(), new BoatDispenseItemBehavior(FAEntityTypes.GINKGO_CHEST_BOAT.get()));
        DispenserBlock.registerBehavior(FAItems.LEPIDODENDRON_CHEST_BOAT.get(), new BoatDispenseItemBehavior(FAEntityTypes.LEPIDODENDRON_CHEST_BOAT.get()));
        DispenserBlock.registerBehavior(FAItems.SIGILLARIA_CHEST_BOAT.get(), new BoatDispenseItemBehavior(FAEntityTypes.SIGILLARIA_CHEST_BOAT.get()));

        FlammablesModification.register(FABlocks.ARCHAEOPTERIS_PLANKS.get(), 5, 20);
        FlammablesModification.register(FABlocks.ARCHAEOPTERIS_SLAB.get(), 5, 20);
        FlammablesModification.register(FABlocks.ARCHAEOPTERIS_FENCE_GATE.get(), 5, 20);
        FlammablesModification.register(FABlocks.ARCHAEOPTERIS_FENCE.get(), 5, 20);
        FlammablesModification.register(FABlocks.ARCHAEOPTERIS_STAIRS.get(), 5, 20);
        FlammablesModification.register(FABlocks.ARCHAEOPTERIS_LOG.get(), 5, 5);
        FlammablesModification.register(FABlocks.STRIPPED_ARCHAEOPTERIS_LOG.get(), 5, 5);
        FlammablesModification.register(FABlocks.STRIPPED_ARCHAEOPTERIS_WOOD.get(), 5, 5);
        FlammablesModification.register(FABlocks.ARCHAEOPTERIS_WOOD.get(), 5, 5);
        FlammablesModification.register(FABlocks.ARCHAEOPTERIS_LEAVES.get(), 30, 60);
        FlammablesModification.register(FABlocks.CALAMITES_PLANKS.get(), 5, 20);
        FlammablesModification.register(FABlocks.CALAMITES_SLAB.get(), 5, 20);
        FlammablesModification.register(FABlocks.CALAMITES_FENCE_GATE.get(), 5, 20);
        FlammablesModification.register(FABlocks.CALAMITES_FENCE.get(), 5, 20);
        FlammablesModification.register(FABlocks.CALAMITES_STAIRS.get(), 5, 20);
        FlammablesModification.register(FABlocks.CALAMITES_LOG.get(), 5, 5);
        FlammablesModification.register(FABlocks.STRIPPED_CALAMITES_LOG.get(), 5, 5);
        FlammablesModification.register(FABlocks.STRIPPED_CALAMITES_WOOD.get(), 5, 5);
        FlammablesModification.register(FABlocks.CALAMITES_WOOD.get(), 5, 5);
        FlammablesModification.register(FABlocks.CALAMITES_LEAVES.get(), 30, 60);
        FlammablesModification.register(FABlocks.GINKGO_PLANKS.get(), 5, 20);
        FlammablesModification.register(FABlocks.GINKGO_SLAB.get(), 5, 20);
        FlammablesModification.register(FABlocks.GINKGO_FENCE_GATE.get(), 5, 20);
        FlammablesModification.register(FABlocks.GINKGO_FENCE.get(), 5, 20);
        FlammablesModification.register(FABlocks.GINKGO_STAIRS.get(), 5, 20);
        FlammablesModification.register(FABlocks.GINKGO_LOG.get(), 5, 5);
        FlammablesModification.register(FABlocks.STRIPPED_GINKGO_LOG.get(), 5, 5);
        FlammablesModification.register(FABlocks.STRIPPED_GINKGO_WOOD.get(), 5, 5);
        FlammablesModification.register(FABlocks.GINKGO_WOOD.get(), 5, 5);
        FlammablesModification.register(FABlocks.GINKGO_LEAVES.get(), 30, 60);
        FlammablesModification.register(FABlocks.LEPIDODENDRON_PLANKS.get(), 5, 20);
        FlammablesModification.register(FABlocks.LEPIDODENDRON_SLAB.get(), 5, 20);
        FlammablesModification.register(FABlocks.LEPIDODENDRON_FENCE_GATE.get(), 5, 20);
        FlammablesModification.register(FABlocks.LEPIDODENDRON_FENCE.get(), 5, 20);
        FlammablesModification.register(FABlocks.LEPIDODENDRON_STAIRS.get(), 5, 20);
        FlammablesModification.register(FABlocks.LEPIDODENDRON_LOG.get(), 5, 5);
        FlammablesModification.register(FABlocks.STRIPPED_LEPIDODENDRON_LOG.get(), 5, 5);
        FlammablesModification.register(FABlocks.STRIPPED_LEPIDODENDRON_WOOD.get(), 5, 5);
        FlammablesModification.register(FABlocks.LEPIDODENDRON_WOOD.get(), 5, 5);
        FlammablesModification.register(FABlocks.LEPIDODENDRON_LEAVES.get(), 30, 60);
        FlammablesModification.register(FABlocks.SIGILLARIA_PLANKS.get(), 5, 20);
        FlammablesModification.register(FABlocks.SIGILLARIA_SLAB.get(), 5, 20);
        FlammablesModification.register(FABlocks.SIGILLARIA_FENCE_GATE.get(), 5, 20);
        FlammablesModification.register(FABlocks.SIGILLARIA_FENCE.get(), 5, 20);
        FlammablesModification.register(FABlocks.SIGILLARIA_STAIRS.get(), 5, 20);
        FlammablesModification.register(FABlocks.SIGILLARIA_LOG.get(), 5, 5);
        FlammablesModification.register(FABlocks.STRIPPED_SIGILLARIA_LOG.get(), 5, 5);
        FlammablesModification.register(FABlocks.STRIPPED_SIGILLARIA_WOOD.get(), 5, 5);
        FlammablesModification.register(FABlocks.SIGILLARIA_WOOD.get(), 5, 5);
        FlammablesModification.register(FABlocks.SIGILLARIA_LEAVES.get(), 30, 60);

        FAStats.STAT_FORMATTERS.forEach(Stats.CUSTOM::get);
    }

    public static void compostablesSetup(CompostablesModification compostablesModification) {
        compostablesModification.add(FABlocks.JURASSIC_FERN.get(), 0.65F);
        compostablesModification.add(FAItems.JURASSIC_FERN_SPORES.get(), 0.35F);
        compostablesModification.add(FABlocks.SHORT_HORSETAIL.get(), 0.5F);
        compostablesModification.add(FABlocks.TALL_HORSETAIL.get(), 0.5F);
        compostablesModification.add(FAItems.HORSETAIL_SPORE.get(), 0.35F);
        compostablesModification.add(FAItems.CYCAD_CONE.get(), 0.35F);
        compostablesModification.add(FABlocks.LEPIDODENDRON_LEAVES.get(), 0.3F);
        compostablesModification.add(FABlocks.LEPIDODENDRON_SAPLING.get(), 0.3F);
        compostablesModification.add(FAItems.LEPIDODENDRON_CONE.get(), 0.35F);
        compostablesModification.add(FABlocks.SIGILLARIA_LEAVES.get(), 0.3F);
        compostablesModification.add(FABlocks.SIGILLARIA_SAPLING.get(), 0.3F);
        compostablesModification.add(FAItems.CALAMITES_SPORE.get(), 0.35F);
        compostablesModification.add(FABlocks.CALAMITES_LEAVES.get(), 0.3F);
        compostablesModification.add(FABlocks.CALAMITES_SAPLING.get(), 0.3F);
        compostablesModification.add(FAItems.CYCAD_CONE.get(), 0.35F);
        compostablesModification.add(FABlocks.ARCHAEOPTERIS_LEAVES.get(), 0.3F);
        compostablesModification.add(FABlocks.ARCHAEOPTERIS_SAPLING.get(), 0.3F);
        compostablesModification.add(FAItems.ARCHAEOPTERIS_SPORE.get(), 0.35F);
        compostablesModification.add(FABlocks.GINKGO_LEAVES.get(), 0.3F);
        compostablesModification.add(FABlocks.GINKGO_SAPLING.get(), 0.3F);
        compostablesModification.add(FAItems.GINKGO_SPORE.get(), 0.35F);
    }

    public static void strippablesSetup(StrippablesModification strippablesModification) {
        AxeItem.STRIPPABLES = Maps.newHashMap(AxeItem.STRIPPABLES);
        strippablesModification.register(FABlocks.ARCHAEOPTERIS_LOG.get(), FABlocks.STRIPPED_ARCHAEOPTERIS_LOG.get());
        strippablesModification.register(FABlocks.ARCHAEOPTERIS_WOOD.get(), FABlocks.STRIPPED_ARCHAEOPTERIS_WOOD.get());
        strippablesModification.register(FABlocks.CALAMITES_LOG.get(), FABlocks.STRIPPED_CALAMITES_LOG.get());
        strippablesModification.register(FABlocks.CALAMITES_WOOD.get(), FABlocks.STRIPPED_CALAMITES_WOOD.get());
        strippablesModification.register(FABlocks.GINKGO_LOG.get(), FABlocks.STRIPPED_GINKGO_LOG.get());
        strippablesModification.register(FABlocks.GINKGO_WOOD.get(), FABlocks.STRIPPED_GINKGO_WOOD.get());
        strippablesModification.register(FABlocks.LEPIDODENDRON_LOG.get(), FABlocks.STRIPPED_LEPIDODENDRON_LOG.get());
        strippablesModification.register(FABlocks.LEPIDODENDRON_WOOD.get(), FABlocks.STRIPPED_LEPIDODENDRON_WOOD.get());
        strippablesModification.register(FABlocks.SIGILLARIA_LOG.get(), FABlocks.STRIPPED_SIGILLARIA_LOG.get());
        strippablesModification.register(FABlocks.SIGILLARIA_WOOD.get(), FABlocks.STRIPPED_SIGILLARIA_WOOD.get());
    }

    public static void buildCreativeModeTabEvent(CreativeModeTabModification creativeModeTabModification) {
        creativeModeTabModification.add(CreativeModeTabs.OP_BLOCKS, FAItems.DEBUG_MAX_HUNGER.get());
        creativeModeTabModification.add(CreativeModeTabs.OP_BLOCKS, FAItems.DEBUG_MAX_HEALTH.get());
        creativeModeTabModification.add(CreativeModeTabs.OP_BLOCKS, FAItems.DEBUG_FULL_GROWN.get());
        creativeModeTabModification.add(CreativeModeTabs.OP_BLOCKS, FAItems.DEBUG_BABY.get());
        creativeModeTabModification.add(CreativeModeTabs.OP_BLOCKS, FAItems.DEBUG_TAME.get());
        creativeModeTabModification.add(CreativeModeTabs.OP_BLOCKS, FAItems.DEBUG_CHANGE_GENETICS.get());
    }

    public static void villagerTradesEvent(VillagerTradeModification villagerTradeModification) {
        villagerTradeModification.add(FAVillagerProfessions.ARCHAEOLOGIST.get(), List.of(new VillagerTrades.EmeraldForItems(FAItems.RELIC_SCRAP.get(), 5, 16, 2), new VillagerTrades.EmeraldForItems(FAItems.JADE.get(), 6, 8, 2, 10)), List.of(new VillagerTrades.ItemsAndEmeraldsToItems(FAItems.ANCIENT_SWORD_ARTIFACT.get(), 1, 30, FAItems.ANCIENT_SWORD.get(), 1, 8, 6, 15), new VillagerTrades.ItemsAndEmeraldsToItems(FAItems.ANCIENT_AXE_ARTIFACT.get(), 1, 30, FAItems.ANCIENT_AXE.get(), 1, 8, 6, 15), new VillagerTrades.ItemsAndEmeraldsToItems(FAItems.ANCIENT_PICKAXE_ARTIFACT.get(), 1, 30, FAItems.ANCIENT_PICKAXE.get(), 1, 8, 6, 15), new VillagerTrades.ItemsAndEmeraldsToItems(FAItems.ANCIENT_HOE_ARTIFACT.get(), 1, 30, FAItems.ANCIENT_HOE.get(), 1, 8, 6, 15), new VillagerTrades.ItemsAndEmeraldsToItems(FAItems.ANCIENT_SHOVEL_ARTIFACT.get(), 1, 30, FAItems.ANCIENT_SHOVEL.get(), 1, 8, 6, 15), new VillagerTrades.ItemsForEmeralds(FAItems.STONE_TABLET.get(), 10, 2, 6), new VillagerTrades.ItemsForEmeralds(FAItems.WOODEN_JAVELIN.get(), 5, 1, 6), new VillagerTrades.ItemsForEmeralds(FAItems.STONE_JAVELIN.get(), 10, 1, 6), new VillagerTrades.ItemsForEmeralds(FAItems.IRON_JAVELIN.get(), 15, 1, 6)), List.of(new VillagerTrades.ItemsAndEmeraldsToItems(FAItems.ANCIENT_HELMET_ARTIFACT.get(), 1, 30, FAItems.ANCIENT_HELMET.get(), 1, 8, 6, 15), new VillagerTrades.ItemsAndEmeraldsToItems(FAItems.ANCIENT_CHESTPLATE_ARTIFACT.get(), 1, 30, FAItems.ANCIENT_CHESTPLATE.get(), 1, 8, 6, 15), new VillagerTrades.ItemsAndEmeraldsToItems(FAItems.ANCIENT_LEGGINGS_ARTIFACT.get(), 1, 30, FAItems.ANCIENT_LEGGINGS.get(), 1, 8, 6, 15), new VillagerTrades.ItemsAndEmeraldsToItems(FAItems.ANCIENT_BOOTS_ARTIFACT.get(), 1, 30, FAItems.ANCIENT_BOOTS.get(), 1, 8, 6, 15), new VillagerTrades.EmeraldForItems(FAItems.JADE_VILLAGER.get(), 1, 4, 6, 25), new VillagerTrades.EmeraldForItems(FAItems.JADE_OCELOT.get(), 1, 4, 6, 25)), List.of(new VillagerTrades.EmeraldForItems(FAItems.SCARAB_GEM_JAVELIN.get(), 1, 2, 12, 30), new VillagerTrades.ItemsForEmeralds(FAItems.GOLDEN_JAVELIN.get(), 20, 1, 12), new VillagerTrades.ItemsForEmeralds(FAItems.DIAMOND_JAVELIN.get(), 30, 1, 12)), List.of(new VillagerTrades.ItemsForEmeralds(FAItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), 30, 1, 12), new VillagerTrades.EmeraldForItems(FAItems.CODEX.get(), 1, 2, 6, 30), new VillagerTrades.EmeraldForItems(FAItems.QUIPU.get(), 1, 2, 6, 30), new VillagerTrades.TreasureMapForEmeralds(20, FAStructureTags.ACADEMY, "filled_map.academy", FAMapDecorationTypes.ACADEMY, 12, 10), new VillagerTrades.TreasureMapForEmeralds(20, FAStructureTags.MACHU_PICCHU, "filled_map.machu_picchu", FAMapDecorationTypes.MACHU_PICCHU, 12, 10), new VillagerTrades.TreasureMapForEmeralds(20, FAStructureTags.MAYAN_TEMPLE, "filled_map.mayan_temple", FAMapDecorationTypes.MAYAN_TEMPLE, 12, 10), new VillagerTrades.TreasureMapForEmeralds(20, FAStructureTags.WEAPON_SHOP, "filled_map.weapon_shop", FAMapDecorationTypes.WEAPON_SHOP, 12, 10)));
        villagerTradeModification.add(FAVillagerProfessions.PALAEONTOLOGIST.get(), List.of(new VillagerTrades.EmeraldForItems(FAItems.MESOZOIC_FOSSIL.get(), 5, 16, 2), new VillagerTrades.EmeraldForItems(FAItems.FROZEN_MEAT.get(), 5, 16, 2)), List.of(new VillagerTrades.ItemsForEmeralds(FAItems.DINOPEDIA.get(), 10, 1, 4, 4), new VillagerTrades.ItemsForEmeralds(FAItems.THERIZINOSAURUS_CLAWS.get(), 25, 1, 16, 2), new VillagerTrades.ItemsForEmeralds(FAItems.TYRANNOSAURUS_TOOTH.get(), 30, 1, 16, 2), new VillagerTrades.ItemsForEmeralds(FAItems.NAUTILUS_SHELL.get(), 10, 1, 16, 2)), List.of(new VillagerTrades.ItemsAndEmeraldsToItems(new ItemStack(FABlocks.FOSSIL_ORE.get()).getItem(), 1, 10, new ItemStack(FABlocks.DEEPSLATE_FOSSIL_ORE.get()).getItem(), 1, 8, 3, 15), new VillagerTrades.EmeraldForItems(new ItemStack(FABlocks.SKULL_BLOCK.get()).getItem(), 10, 16, 3), new VillagerTrades.ItemsForEmeralds(FAItems.LEPIDODENDRON_DNA.get(), 20, 1, 1, 2)), List.of(new VillagerTrades.EmeraldForItems(FAItems.JURASSIC_FERN_SPORES.get(), 3, 8, 6), new VillagerTrades.EmeraldForItems(FAItems.HORSETAIL_SPORE.get(), 3, 8, 6), new VillagerTrades.ItemsForEmeralds(FAItems.CALAMITES_SPORE.get(), 20, 1, 4, 12), new VillagerTrades.ItemsForEmeralds(FAItems.ARCHAEOPTERIS_SPORE.get(), 20, 1, 4, 12), new VillagerTrades.ItemsForEmeralds(FAItems.GINKGO_SPORE.get(), 20, 1, 4, 12), new VillagerTrades.ItemsForEmeralds(FAItems.LEPIDODENDRON_CONE.get(), 20, 1, 4, 12), new VillagerTrades.ItemsForEmeralds(FAItems.CYCAD_CONE.get(), 20, 1, 4, 12), new VillagerTrades.ItemsForEmeralds(FAItems.SIGILLARIA_SPORE.get(), 20, 1, 4, 12)), List.of(new VillagerTrades.ItemsForEmeralds(FAItems.LEGACY_GENETIC_CODE.get(), 30, 1, 12)));
    }

    public static void heroOfTheVillageGiftSetup(HeroOfTheVillageGiftModification heroOfTheVillageGiftModification) {
        heroOfTheVillageGiftModification.add(FAVillagerProfessions.ARCHAEOLOGIST, FALootTables.ARCHAEOLOGIST_GIFT);
        heroOfTheVillageGiftModification.add(FAVillagerProfessions.PALAEONTOLOGIST, FALootTables.PALAEONTOLOGIST_GIFT);
    }

    public static void oxidationSetup(OxidationModification oxidationModification) {
        oxidationModification.add(FABlocks.COPPER_LLAMA_STATUE.get(), FABlocks.EXPOSED_COPPER_LLAMA_STATUE.get());
        oxidationModification.add(FABlocks.EXPOSED_COPPER_LLAMA_STATUE.get(), FABlocks.WEATHERED_COPPER_LLAMA_STATUE.get());
        oxidationModification.add(FABlocks.WEATHERED_COPPER_LLAMA_STATUE.get(), FABlocks.OXIDIZED_COPPER_LLAMA_STATUE.get());
    }

    public static void waxableSetup(WaxableModification waxableModification) {
        waxableModification.add(FABlocks.COPPER_LLAMA_STATUE.get(), FABlocks.WAXED_COPPER_LLAMA_STATUE.get());
        waxableModification.add(FABlocks.EXPOSED_COPPER_LLAMA_STATUE.get(), FABlocks.WAXED_EXPOSED_COPPER_LLAMA_STATUE.get());
        waxableModification.add(FABlocks.WEATHERED_COPPER_LLAMA_STATUE.get(), FABlocks.WAXED_WEATHERED_COPPER_LLAMA_STATUE.get());
        waxableModification.add(FABlocks.OXIDIZED_COPPER_LLAMA_STATUE.get(), FABlocks.WAXED_OXIDIZED_COPPER_LLAMA_STATUE.get());
    }

    public static void resourcePackEvent(ResourcePackRegister resourcePackRegister) {
        resourcePackRegister.register(FAUtils.ID, "fa_legacy_textures");
    }

    public static void newRegistryEvent(NewRegistryRegister newRegistryRegister) {
        newRegistryRegister.register(FABuiltInRegistries.COMMAND_TYPES, FARegistries.COMMAND_TYPES);
        newRegistryRegister.register(FABuiltInRegistries.DINOPEDIA_LINE_TYPES, FARegistries.DINOPEDIA_LINE_TYPE);
        newRegistryRegister.register(FABuiltInRegistries.PREGNANCY_TYPES, FARegistries.PREGNANCY_TYPE);
        newRegistryRegister.register(FABuiltInRegistries.PATTERN_INFORMATION_TYPES, FARegistries.PATTERN_INFORMATION_TYPE);
        newRegistryRegister.register(FABuiltInRegistries.TEXTURE_TYPES, FARegistries.TEXTURE_TYPE);
    }

    public static void newDynamicRegistryEvent(DynamicRegistryRegister dynamicRegistryRegister) {
        dynamicRegistryRegister.register(FARegistries.ANALYZER_RESULT, AnalyzerResult.CODEC);
        dynamicRegistryRegister.register(FARegistries.ANCIENT_AXE_BONUS, AncientAxeBonus.CODEC);
        dynamicRegistryRegister.register(FARegistries.DECORATION_PLAQUE_TYPE, DecorationPlaqueType.DIRECT_CODEC);
        dynamicRegistryRegister.register(FARegistries.DINOPEDIA_ENTRY, DinopediaEntry.CODEC);
        dynamicRegistryRegister.register(FARegistries.DINOPEDIA_TYPE, DinopediaType.CODEC);
        dynamicRegistryRegister.register(FARegistries.FEEDER_FOOD, FeederFood.CODEC);
        dynamicRegistryRegister.register(FARegistries.FOSSIL_VARIANTS, FossilVariant.DIRECT_CODEC);
        dynamicRegistryRegister.register(FARegistries.FUEL_ENTRY, FuelEntry.CODEC);
        dynamicRegistryRegister.register(FARegistries.MODEL_TYPES, ModelType.DIRECT_CODEC);
        dynamicRegistryRegister.register(FARegistries.PATTERN, Pattern.DIRECT_CODEC);
        dynamicRegistryRegister.register(FARegistries.JEWEL_RECOVERY, JewelRecovery.CODEC);
        dynamicRegistryRegister.register(FARegistries.STONE_TABLET_VARIANT, StoneTabletVariant.DIRECT_CODEC);
        dynamicRegistryRegister.register(FARegistries.TEXTURE, Texture.CODEC);
    }

    public static void attributeEvent(AttributeRegister attributeRegister) {
        attributeRegister.register(FAEntityTypes.ANU.get(), Anu.anuAttributes());
        attributeRegister.register(FAEntityTypes.ANKYLOSAURUS.get(), Ankylosaurus.ankylosaurusAttributes());
        attributeRegister.register(FAEntityTypes.BRACHIOSAURUS.get(), Brachiosaurus.brachiosaurusAttributes());
        attributeRegister.register(FAEntityTypes.CARNOTAURUS.get(), Carnotaurus.carnotaurusAttributes());
        attributeRegister.register(FAEntityTypes.COMPSOGNATHUS.get(), Compsognathus.compsognathusAttributes());
        attributeRegister.register(FAEntityTypes.CRYOLOPHOSAURUS.get(), Cryolophosaurus.cryolophosaurusAttributes());
        attributeRegister.register(FAEntityTypes.DILOPHOSAURUS.get(), Dilophosaurus.dilophosaurusAttributes());
        attributeRegister.register(FAEntityTypes.DIMETRODON.get(), Dimetrodon.dimetrodonAttributes());
        attributeRegister.register(FAEntityTypes.DODO.get(), Dodo.dodoAttributes());
        attributeRegister.register(FAEntityTypes.MOA.get(), Moa.moaAttributes());
        attributeRegister.register(FAEntityTypes.GALLIMIMUS.get(), Gallimimus.gallimimusAttributes());
        attributeRegister.register(FAEntityTypes.ICHTHYOSAURUS.get(), Ichthyosaurus.ichthyosaurusAttributes());
        attributeRegister.register(FAEntityTypes.DRYOSAURUS.get(), Dryosaurus.dryosaurusAttributes());
        attributeRegister.register(FAEntityTypes.BARYONYX.get(), Baryonyx.baryonyxAttributes());
        attributeRegister.register(FAEntityTypes.ELASMOTHERIUM.get(), Elasmotherium.elasmotheriumAttributes());
        attributeRegister.register(FAEntityTypes.ANKYLOSAURUS_EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FAEntityTypes.BARYONYX_EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FAEntityTypes.BRACHIOSAURUS_EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FAEntityTypes.CARNOTAURUS_EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FAEntityTypes.COMPSOGNATHUS_EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FAEntityTypes.CRYOLOPHOSAURUS_EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FAEntityTypes.DILOPHOSAURUS_EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FAEntityTypes.DIMETRODON_EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FAEntityTypes.DRYOSAURUS_EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FAEntityTypes.FUTABASAURUS_EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FAEntityTypes.GALLIMIMUS_EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FAEntityTypes.ICHTHYOSAURUS_EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FAEntityTypes.MOSASAURUS_EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FAEntityTypes.PACHYCEPHALOSAURUS_EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FAEntityTypes.PTERANODON_EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FAEntityTypes.SPINOSAURUS_EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FAEntityTypes.STEGOSAURUS_EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FAEntityTypes.THERIZINOSAURUS_EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FAEntityTypes.TRICERATOPS_EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FAEntityTypes.TYRANNOSAURUS_EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FAEntityTypes.VELOCIRAPTOR_EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FAEntityTypes.FAILURESAURUS.get(), Failuresaurus.createAttributes().build());
        attributeRegister.register(FAEntityTypes.FOSSIL.get(), Fossil.fossilAttributes());
        attributeRegister.register(FAEntityTypes.MAMMOTH.get(), Mammoth.mammothAttributes());
        attributeRegister.register(FAEntityTypes.MOSASAURUS.get(), Mosasaurus.mosasaurusAttributes());
        attributeRegister.register(FAEntityTypes.NAUTILUS.get(), Nautilus.nautilusAttributes());
        attributeRegister.register(FAEntityTypes.FUTABASAURUS.get(), Futabasaurus.futabasaurusAttributes());
        attributeRegister.register(FAEntityTypes.PACHYCEPHALOSAURUS.get(), Pachycephalosaurus.pachycephalosaurusAttributes());
        attributeRegister.register(FAEntityTypes.PREGNANT_ARMADILLO.get(), Armadillo.createAttributes().build());
        attributeRegister.register(FAEntityTypes.PREGNANT_CAT.get(), Cat.createAttributes().build());
        attributeRegister.register(FAEntityTypes.PREGNANT_COW.get(), Cow.createAttributes().build());
        attributeRegister.register(FAEntityTypes.PREGNANT_DOLPHIN.get(), Dolphin.createAttributes().build());
        attributeRegister.register(FAEntityTypes.PREGNANT_DONKEY.get(), Donkey.createBaseChestedHorseAttributes().build());
        attributeRegister.register(FAEntityTypes.PREGNANT_ELASMOTHERIUM.get(), Elasmotherium.elasmotheriumAttributes());
        attributeRegister.register(FAEntityTypes.PREGNANT_FOX.get(), Fox.createAttributes().build());
        attributeRegister.register(FAEntityTypes.PREGNANT_GOAT.get(), Goat.createAttributes().build());
        attributeRegister.register(FAEntityTypes.PREGNANT_HORSE.get(), Horse.createBaseHorseAttributes().build());
        attributeRegister.register(FAEntityTypes.PREGNANT_LLAMA.get(), Llama.createAttributes().build());
        attributeRegister.register(FAEntityTypes.PREGNANT_MAMMOTH.get(), Mammoth.mammothAttributes());
        attributeRegister.register(FAEntityTypes.PREGNANT_SMILODON.get(), Smilodon.smilodonAttributes());
        attributeRegister.register(FAEntityTypes.PREGNANT_MULE.get(), Mule.createBaseChestedHorseAttributes().build());
        attributeRegister.register(FAEntityTypes.PREGNANT_OCELOT.get(), Ocelot.createAttributes().build());
        attributeRegister.register(FAEntityTypes.PREGNANT_PANDA.get(), Panda.createAttributes().build());
        attributeRegister.register(FAEntityTypes.PREGNANT_PIG.get(), Pig.createAttributes().build());
        attributeRegister.register(FAEntityTypes.PREGNANT_POLAR_BEAR.get(), PolarBear.createAttributes().build());
        attributeRegister.register(FAEntityTypes.PREGNANT_RABBIT.get(), Rabbit.createAttributes().build());
        attributeRegister.register(FAEntityTypes.PREGNANT_SHEEP.get(), Sheep.createAttributes().build());
        attributeRegister.register(FAEntityTypes.PREGNANT_WOLF.get(), Wolf.createAttributes().build());
        attributeRegister.register(FAEntityTypes.PTERANODON.get(), Pteranodon.pteranodonAttributes());
        attributeRegister.register(FAEntityTypes.SMILODON.get(), Smilodon.smilodonAttributes());
        attributeRegister.register(FAEntityTypes.SPINOSAURUS.get(), Spinosaurus.spinosaurusAttributes());
        attributeRegister.register(FAEntityTypes.STEGOSAURUS.get(), Stegosaurus.stegosaurusAttributes());
        attributeRegister.register(FAEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get(), ZombifiedPiglin.createAttributes().build());
        attributeRegister.register(FAEntityTypes.THERIZINOSAURUS.get(), Therizinosaurus.therizinosaurusAttributes());
        attributeRegister.register(FAEntityTypes.TRICERATOPS.get(), Triceratops.triceratopsAttributes());
        attributeRegister.register(FAEntityTypes.TYRANNOSAURUS.get(), Tyrannosaurus.tyrannosaurusAttributes());
        attributeRegister.register(FAEntityTypes.VELOCIRAPTOR.get(), Velociraptor.velociraptorAttributes());
    }

    public static void spawnPlacementEvent(SpawnPlacementRegister spawnPlacementRegister) {
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.ANKYLOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Ankylosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.ANKYLOSAURUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.BARYONYX.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Ankylosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.BARYONYX_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.BRACHIOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Brachiosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.BRACHIOSAURUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.CARNOTAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Carnotaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.CARNOTAURUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.COMPSOGNATHUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Compsognathus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.COMPSOGNATHUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.CRYOLOPHOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Cryolophosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.CRYOLOPHOSAURUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.DILOPHOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Dilophosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.DILOPHOSAURUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.DIMETRODON.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Dilophosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.DIMETRODON_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.DRYOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Dryosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.DRYOSAURUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.DODO.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Dodo.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.DODO_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.ELASMOTHERIUM.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Elasmotherium.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.ELASMOTHERIUM_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.FUTABASAURUS.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Futabasaurus::checkFutabasaurusSpawnRules);
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.GALLIMIMUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Gallimimus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.GALLIMIMUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.ICHTHYOSAURUS.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Ichthyosaurus::checkIchthyosaurusSpawnRules);
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.MAMMOTH.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Mammoth.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.MAMMOTH_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.MOA.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Moa.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.MOA_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.MOSASAURUS.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mosasaurus::checkMosasaurusSpawnRules);
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.NAUTILUS.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Nautilus::checkNautilusSpawnRules);
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.PACHYCEPHALOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Pachycephalosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.PACHYCEPHALOSAURUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.PTERANODON.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Pteranodon.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.PTERANODON_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.SMILODON.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Smilodon.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.SMILODON_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.SPINOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Spinosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.SPINOSAURUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.STEGOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Stegosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.STEGOSAURUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.THERIZINOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Therizinosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.THERIZINOSAURUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.TRICERATOPS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Triceratops.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.TRICERATOPS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.TYRANNOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Tyrannosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.TYRANNOSAURUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FAEntityTypes.VELOCIRAPTOR.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Velociraptor.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FABlockTags.VELOCIRAPTOR_SPAWNABLE));
    }

    public static void structurePoolModification(StructurePoolModification structurePoolModification) {
        structurePoolModification.add(structurePoolModification.getTemplatePoolRegistry(), structurePoolModification.getProcessorListRegistry(), structurePoolModification.getPlainsPoolLocation(), "fossilslegacy:village/plains/houses/plains_dig_site", 10);
        structurePoolModification.add(structurePoolModification.getTemplatePoolRegistry(), structurePoolModification.getProcessorListRegistry(), structurePoolModification.getPlainsPoolLocation(), "fossilslegacy:village/plains/houses/plains_archaeology_hut", 10);
        structurePoolModification.add(structurePoolModification.getTemplatePoolRegistry(), structurePoolModification.getProcessorListRegistry(), structurePoolModification.getDesertPoolLocation(), "fossilslegacy:village/desert/houses/desert_dig_site", 10);
        structurePoolModification.add(structurePoolModification.getTemplatePoolRegistry(), structurePoolModification.getProcessorListRegistry(), structurePoolModification.getDesertPoolLocation(), "fossilslegacy:village/plains/houses/desert_archaeology_hut", 10);
        structurePoolModification.add(structurePoolModification.getTemplatePoolRegistry(), structurePoolModification.getProcessorListRegistry(), structurePoolModification.getSavannaPoolLocation(), "fossilslegacy:village/savanna/houses/savanna_dig_site", 10);
        structurePoolModification.add(structurePoolModification.getTemplatePoolRegistry(), structurePoolModification.getProcessorListRegistry(), structurePoolModification.getSavannaPoolLocation(), "fossilslegacy:village/plains/houses/savanna_archaeology_hut", 10);
        structurePoolModification.add(structurePoolModification.getTemplatePoolRegistry(), structurePoolModification.getProcessorListRegistry(), structurePoolModification.getSnowyPoolLocation(), "fossilslegacy:village/snowy/houses/snowy_dig_site", 10);
        structurePoolModification.add(structurePoolModification.getTemplatePoolRegistry(), structurePoolModification.getProcessorListRegistry(), structurePoolModification.getSnowyPoolLocation(), "fossilslegacy:village/plains/houses/snowy_archaeology_hut", 10);
        structurePoolModification.add(structurePoolModification.getTemplatePoolRegistry(), structurePoolModification.getProcessorListRegistry(), structurePoolModification.getTaigaPoolLocation(), "fossilslegacy:village/taiga/houses/taiga_dig_site", 10);
        structurePoolModification.add(structurePoolModification.getTemplatePoolRegistry(), structurePoolModification.getProcessorListRegistry(), structurePoolModification.getTaigaPoolLocation(), "fossilslegacy:village/plains/houses/taiga_archaeology_hut", 10);
    }

    public static void idModification(IdModification idModification) {
        idModification.updateId(BuiltInRegistries.ITEM, FAUtils.resource("gene_modification_table"), FAItems.DNA_RECOMBINATOR::get);
        idModification.updateId(BuiltInRegistries.ITEM, FAUtils.resource("fossil"), FAItems.MESOZOIC_FOSSIL::get);
        idModification.updateId(BuiltInRegistries.BLOCK, FAUtils.resource("gene_modification_table"), FABlocks.DNA_RECOMBINATOR::get);
        idModification.updateId(BuiltInRegistries.BLOCK_ENTITY_TYPE, FAUtils.resource("gene_modification_table"), FABlockEntityTypes.DNA_RECOMBINATOR::get);
    }
}
