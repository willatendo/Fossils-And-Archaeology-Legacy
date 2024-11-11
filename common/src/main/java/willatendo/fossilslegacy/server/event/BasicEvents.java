package willatendo.fossilslegacy.server.event;

import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.armadillo.Armadillo;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.animal.horse.Mule;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.Heightmap;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.block.SkullBlock;
import willatendo.fossilslegacy.server.core.cauldron.FossilsLegacyCauldronInteraction;
import willatendo.fossilslegacy.server.core.dispenser.DispenseEntityItemBehavior;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyBuiltInRegistries;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.*;
import willatendo.fossilslegacy.server.entity.dinosaur.cretaceous.*;
import willatendo.fossilslegacy.server.entity.dinosaur.guadalupian.Dimetrodon;
import willatendo.fossilslegacy.server.entity.dinosaur.jurassic.*;
import willatendo.fossilslegacy.server.entity.dinosaur.quaternary.*;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.entity.variants.StoneTabletVariant;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.item.feederfood.FeederFood;
import willatendo.fossilslegacy.server.tags.FossilsLegacyBlockTags;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.event.modification.CreativeModeTabModification;
import willatendo.simplelibrary.server.event.modification.FlammablesModification;
import willatendo.simplelibrary.server.event.modification.StrippablesModification;
import willatendo.simplelibrary.server.event.registry.*;

public class BasicEvents {
    public static void commonSetup() {
        FossilsLegacyCauldronInteraction.init();

        FossilsLegacyItems.EGGS.forEach(eggItem -> DispenserBlock.registerBehavior(eggItem, new DispenseEntityItemBehavior(entity -> ((Egg) entity).setEggVariant(eggItem.getEggVariant()))));
        DispenserBlock.registerBehavior(FossilsLegacyItems.NAUTILUS_EGGS.get(), new DispenseEntityItemBehavior());
        DispenserBlock.registerBehavior(FossilsLegacyItems.NAUTILUS.get(), new DispenseEntityItemBehavior());
        DispenserBlock.registerBehavior(FossilsLegacyItems.FOSSIL.get(), new DispenseEntityItemBehavior());
        DispenserBlock.registerProjectileBehavior(FossilsLegacyItems.INCUBATED_CHICKEN_EGG.get());
        DispenserBlock.registerProjectileBehavior(FossilsLegacyItems.INCUBATED_PARROT_EGG.get());
        DispenserBlock.registerBehavior(FossilsLegacyBlocks.SKULL_BLOCK.get(), new OptionalDispenseItemBehavior() {
            @Override
            protected ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
                Level level = blockSource.level();
                BlockPos blockPos = blockSource.pos().relative(blockSource.state().getValue(DispenserBlock.FACING));
                SkullBlock skullBlock = FossilsLegacyBlocks.SKULL_BLOCK.get();
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
        DispenserBlock.registerBehavior(FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get(), new OptionalDispenseItemBehavior() {
            @Override
            protected ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
                Level level = blockSource.level();
                BlockPos blockPos = blockSource.pos().relative(blockSource.state().getValue(DispenserBlock.FACING));
                SkullBlock skullBlock = (SkullBlock) FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get();
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

        AxeItem.STRIPPABLES = Maps.newHashMap(AxeItem.STRIPPABLES);
        StrippablesModification.register(FossilsLegacyBlocks.CALAMITES_LOG.get(), FossilsLegacyBlocks.STRIPPED_CALAMITES_LOG.get());
        StrippablesModification.register(FossilsLegacyBlocks.CALAMITES_WOOD.get(), FossilsLegacyBlocks.STRIPPED_CALAMITES_WOOD.get());
        StrippablesModification.register(FossilsLegacyBlocks.LEPIDODENDRON_LOG.get(), FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_LOG.get());
        StrippablesModification.register(FossilsLegacyBlocks.LEPIDODENDRON_WOOD.get(), FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_WOOD.get());
        StrippablesModification.register(FossilsLegacyBlocks.SIGILLARIA_LOG.get(), FossilsLegacyBlocks.STRIPPED_SIGILLARIA_LOG.get());
        StrippablesModification.register(FossilsLegacyBlocks.SIGILLARIA_WOOD.get(), FossilsLegacyBlocks.STRIPPED_SIGILLARIA_WOOD.get());

        FlammablesModification.register(FossilsLegacyBlocks.CALAMITES_PLANKS.get(), 5, 20);
        FlammablesModification.register(FossilsLegacyBlocks.CALAMITES_SLAB.get(), 5, 20);
        FlammablesModification.register(FossilsLegacyBlocks.CALAMITES_FENCE_GATE.get(), 5, 20);
        FlammablesModification.register(FossilsLegacyBlocks.CALAMITES_FENCE.get(), 5, 20);
        FlammablesModification.register(FossilsLegacyBlocks.CALAMITES_STAIRS.get(), 5, 20);
        FlammablesModification.register(FossilsLegacyBlocks.CALAMITES_LOG.get(), 5, 5);
        FlammablesModification.register(FossilsLegacyBlocks.STRIPPED_CALAMITES_LOG.get(), 5, 5);
        FlammablesModification.register(FossilsLegacyBlocks.STRIPPED_CALAMITES_WOOD.get(), 5, 5);
        FlammablesModification.register(FossilsLegacyBlocks.CALAMITES_WOOD.get(), 5, 5);
        FlammablesModification.register(FossilsLegacyBlocks.CALAMITES_LEAVES.get(), 30, 60);
        FlammablesModification.register(FossilsLegacyBlocks.LEPIDODENDRON_PLANKS.get(), 5, 20);
        FlammablesModification.register(FossilsLegacyBlocks.LEPIDODENDRON_SLAB.get(), 5, 20);
        FlammablesModification.register(FossilsLegacyBlocks.LEPIDODENDRON_FENCE_GATE.get(), 5, 20);
        FlammablesModification.register(FossilsLegacyBlocks.LEPIDODENDRON_FENCE.get(), 5, 20);
        FlammablesModification.register(FossilsLegacyBlocks.LEPIDODENDRON_STAIRS.get(), 5, 20);
        FlammablesModification.register(FossilsLegacyBlocks.LEPIDODENDRON_LOG.get(), 5, 5);
        FlammablesModification.register(FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_LOG.get(), 5, 5);
        FlammablesModification.register(FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_WOOD.get(), 5, 5);
        FlammablesModification.register(FossilsLegacyBlocks.LEPIDODENDRON_WOOD.get(), 5, 5);
        FlammablesModification.register(FossilsLegacyBlocks.LEPIDODENDRON_LEAVES.get(), 30, 60);
        FlammablesModification.register(FossilsLegacyBlocks.SIGILLARIA_PLANKS.get(), 5, 20);
        FlammablesModification.register(FossilsLegacyBlocks.SIGILLARIA_SLAB.get(), 5, 20);
        FlammablesModification.register(FossilsLegacyBlocks.SIGILLARIA_FENCE_GATE.get(), 5, 20);
        FlammablesModification.register(FossilsLegacyBlocks.SIGILLARIA_FENCE.get(), 5, 20);
        FlammablesModification.register(FossilsLegacyBlocks.SIGILLARIA_STAIRS.get(), 5, 20);
        FlammablesModification.register(FossilsLegacyBlocks.SIGILLARIA_LOG.get(), 5, 5);
        FlammablesModification.register(FossilsLegacyBlocks.STRIPPED_SIGILLARIA_LOG.get(), 5, 5);
        FlammablesModification.register(FossilsLegacyBlocks.STRIPPED_SIGILLARIA_WOOD.get(), 5, 5);
        FlammablesModification.register(FossilsLegacyBlocks.SIGILLARIA_WOOD.get(), 5, 5);
        FlammablesModification.register(FossilsLegacyBlocks.SIGILLARIA_LEAVES.get(), 30, 60);
    }

    public static void compostablesSetup() {
        ComposterBlock.COMPOSTABLES.put(FossilsLegacyBlocks.JURASSIC_FERN.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(FossilsLegacyItems.JURASSIC_FERN_SPORES.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(FossilsLegacyBlocks.LEPIDODENDRON_LEAVES.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(FossilsLegacyBlocks.LEPIDODENDRON_SAPLING.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(FossilsLegacyBlocks.SIGILLARIA_LEAVES.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(FossilsLegacyBlocks.SIGILLARIA_SAPLING.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(FossilsLegacyBlocks.CALAMITES_LEAVES.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(FossilsLegacyBlocks.CALAMITES_SAPLING.get(), 0.3F);
    }

    public static void buildCreativeModeTabEvent(CreativeModeTabModification creativeModeTabModification) {
        creativeModeTabModification.add(CreativeModeTabs.OP_BLOCKS, FossilsLegacyItems.DEBUG_MAX_HUNGER.get());
        creativeModeTabModification.add(CreativeModeTabs.OP_BLOCKS, FossilsLegacyItems.DEBUG_MAX_HEALTH.get());
        creativeModeTabModification.add(CreativeModeTabs.OP_BLOCKS, FossilsLegacyItems.DEBUG_FULL_GROWN.get());
        creativeModeTabModification.add(CreativeModeTabs.OP_BLOCKS, FossilsLegacyItems.DEBUG_BABY.get());
        creativeModeTabModification.add(CreativeModeTabs.OP_BLOCKS, FossilsLegacyItems.DEBUG_TAME.get());
        creativeModeTabModification.add(CreativeModeTabs.OP_BLOCKS, FossilsLegacyItems.DEBUG_CHANGE_GENETICS.get());
    }

    public static void resourcePackEvent(ResourcePackRegister resourcePackRegister) {
        resourcePackRegister.register(FossilsLegacyUtils.ID, "fa_legacy_textures");
    }

    public static void newRegistryEvent(NewRegistryRegister newRegistryRegister) {
        newRegistryRegister.register(FossilsLegacyBuiltInRegistries.COMMAND_TYPES, FossilsLegacyRegistries.COMMAND_TYPES);
        newRegistryRegister.register(FossilsLegacyBuiltInRegistries.EGG_VARIANTS, FossilsLegacyRegistries.EGG_VARIANTS);
        newRegistryRegister.register(FossilsLegacyBuiltInRegistries.PREGNANCY_TYPES, FossilsLegacyRegistries.PREGNANCY_TYPES);
    }

    public static void newDynamicRegistryEvent(DynamicRegistryRegister dynamicRegistryRegister) {
        dynamicRegistryRegister.register(FossilsLegacyRegistries.COAT_TYPES, CoatType.DIRECT_CODEC);
        dynamicRegistryRegister.register(FossilsLegacyRegistries.FEEDER_FOOD, FeederFood.DIRECT_CODEC);
        dynamicRegistryRegister.register(FossilsLegacyRegistries.FOSSIL_VARIANTS, FossilVariant.DIRECT_CODEC);
        dynamicRegistryRegister.register(FossilsLegacyRegistries.STONE_TABLET_VARIANTS, StoneTabletVariant.DIRECT_CODEC);
    }

    public static void attributeEvent(AttributeRegister attributeRegister) {
        attributeRegister.register(FossilsLegacyEntityTypes.ANU.get(), Anu.anuAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.ANKYLOSAURUS.get(), Ankylosaurus.ankylosaurusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), Brachiosaurus.brachiosaurusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.CARNOTAURUS.get(), Carnotaurus.carnotaurusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.COMPSOGNATHUS.get(), Compsognathus.compsognathusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.CRYOLOPHOSAURUS.get(), Cryolophosaurus.cryolophosaurusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), Dilophosaurus.dilophosaurusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.DIMETRODON.get(), Dimetrodon.dimetrodonAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.DODO.get(), Dodo.dodoAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.MOA.get(), Moa.moaAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.GALLIMIMUS.get(), Gallimimus.gallimimusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.EGG.get(), Egg.eggAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.FAILURESAURUS.get(), Failuresaurus.createAttributes().build());
        attributeRegister.register(FossilsLegacyEntityTypes.FOSSIL.get(), Fossil.fossilAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.MAMMOTH.get(), Mammoth.mammothAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.MOSASAURUS.get(), Mosasaurus.mosasaurusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.NAUTILUS.get(), Nautilus.nautilusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.FUTABASAURUS.get(), Futabasaurus.plesiosaurusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.PACHYCEPHALOSAURUS.get(), Pachycephalosaurus.pachycephalosaurusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.PREGNANT_ARMADILLO.get(), Armadillo.createAttributes().build());
        attributeRegister.register(FossilsLegacyEntityTypes.PREGNANT_CAT.get(), Cat.createAttributes().build());
        attributeRegister.register(FossilsLegacyEntityTypes.PREGNANT_COW.get(), Cow.createAttributes().build());
        attributeRegister.register(FossilsLegacyEntityTypes.PREGNANT_DOLPHIN.get(), Dolphin.createAttributes().build());
        attributeRegister.register(FossilsLegacyEntityTypes.PREGNANT_DONKEY.get(), Donkey.createBaseChestedHorseAttributes().build());
        attributeRegister.register(FossilsLegacyEntityTypes.PREGNANT_FOX.get(), Fox.createAttributes().build());
        attributeRegister.register(FossilsLegacyEntityTypes.PREGNANT_GOAT.get(), Goat.createAttributes().build());
        attributeRegister.register(FossilsLegacyEntityTypes.PREGNANT_HORSE.get(), Horse.createBaseHorseAttributes().build());
        attributeRegister.register(FossilsLegacyEntityTypes.PREGNANT_LLAMA.get(), Llama.createAttributes().build());
        attributeRegister.register(FossilsLegacyEntityTypes.PREGNANT_MAMMOTH.get(), Mammoth.mammothAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.PREGNANT_SMILODON.get(), Smilodon.smilodonAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.PREGNANT_MULE.get(), Mule.createBaseChestedHorseAttributes().build());
        attributeRegister.register(FossilsLegacyEntityTypes.PREGNANT_OCELOT.get(), Ocelot.createAttributes().build());
        attributeRegister.register(FossilsLegacyEntityTypes.PREGNANT_PANDA.get(), Panda.createAttributes().build());
        attributeRegister.register(FossilsLegacyEntityTypes.PREGNANT_PIG.get(), Pig.createAttributes().build());
        attributeRegister.register(FossilsLegacyEntityTypes.PREGNANT_POLAR_BEAR.get(), PolarBear.createAttributes().build());
        attributeRegister.register(FossilsLegacyEntityTypes.PREGNANT_RABBIT.get(), Rabbit.createAttributes().build());
        attributeRegister.register(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), Sheep.createAttributes().build());
        attributeRegister.register(FossilsLegacyEntityTypes.PREGNANT_WOLF.get(), Wolf.createAttributes().build());
        attributeRegister.register(FossilsLegacyEntityTypes.PTERANODON.get(), Pteranodon.pteranodonAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.SMILODON.get(), Smilodon.smilodonAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.SPINOSAURUS.get(), Spinosaurus.spinosaurusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.STEGOSAURUS.get(), Stegosaurus.stegosaurusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get(), ZombifiedPiglin.createAttributes().build());
        attributeRegister.register(FossilsLegacyEntityTypes.THERIZINOSAURUS.get(), Therizinosaurus.therizinosaurusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.TRICERATOPS.get(), Triceratops.triceratopsAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.TYRANNOSAURUS.get(), Tyrannosaurus.tyrannosaurusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.VELOCIRAPTOR.get(), Velociraptor.velociraptorAttributes());
    }

    public static void spawnPlacementEvent(SpawnPlacementRegister spawnPlacementRegister) {
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.ANKYLOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Ankylosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FossilsLegacyBlockTags.ANKYLOSAURUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Brachiosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FossilsLegacyBlockTags.BRACHIOSAURUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.CARNOTAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Carnotaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FossilsLegacyBlockTags.CARNOTAURUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.COMPSOGNATHUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Compsognathus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FossilsLegacyBlockTags.COMPSOGNATHUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.CRYOLOPHOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Cryolophosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FossilsLegacyBlockTags.CRYOLOPHOSAURUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Dilophosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FossilsLegacyBlockTags.DILOPHOSAURUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.DIMETRODON.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Dilophosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FossilsLegacyBlockTags.DIMETRODON_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.DODO.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Dodo.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FossilsLegacyBlockTags.DODO_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.FUTABASAURUS.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Futabasaurus::checkFutabasaurusSpawnRules);
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.GALLIMIMUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Gallimimus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FossilsLegacyBlockTags.GALLIMIMUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.MAMMOTH.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Mammoth.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FossilsLegacyBlockTags.MAMMOTH_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.MOA.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Moa.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FossilsLegacyBlockTags.MOA_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.MOSASAURUS.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mosasaurus::checkMosasaurusSpawnRules);
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.NAUTILUS.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Nautilus::checkNautilusSpawnRules);
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.PACHYCEPHALOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Pachycephalosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FossilsLegacyBlockTags.PACHYCEPHALOSAURUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.PTERANODON.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Pteranodon.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FossilsLegacyBlockTags.PTERANODON_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.SMILODON.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Smilodon.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FossilsLegacyBlockTags.SMILODON_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.SPINOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Spinosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FossilsLegacyBlockTags.SPINOSAURUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.STEGOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Stegosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FossilsLegacyBlockTags.STEGOSAURUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.THERIZINOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Therizinosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FossilsLegacyBlockTags.THERIZINOSAURUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.TRICERATOPS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Triceratops.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FossilsLegacyBlockTags.TRICERATOPS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.TYRANNOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Tyrannosaurus.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FossilsLegacyBlockTags.TYRANNOSAURUS_SPAWNABLE));
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.VELOCIRAPTOR.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> Velociraptor.checkDinosaurSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource, FossilsLegacyBlockTags.VELOCIRAPTOR_SPAWNABLE));
    }
}
