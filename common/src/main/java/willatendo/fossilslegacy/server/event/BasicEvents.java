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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.Heightmap;
import willatendo.fossilslegacy.server.FossilsLegacyBuiltInRegistries;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.block.FossilsLegacyCauldronInteraction;
import willatendo.fossilslegacy.server.block.SkullBlock;
import willatendo.fossilslegacy.server.dispenser.DispenseEntityItemBehavior;
import willatendo.fossilslegacy.server.entity.*;
import willatendo.fossilslegacy.server.entity.genetics.CoatType;
import willatendo.fossilslegacy.server.entity.variants.StoneTabletVariant;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.event.*;

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
        AxeItem.STRIPPABLES.put(FossilsLegacyBlocks.LEPIDODENDRON_LOG.get(), FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_LOG.get());
        AxeItem.STRIPPABLES.put(FossilsLegacyBlocks.LEPIDODENDRON_WOOD.get(), FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_WOOD.get());

        FireBlock fireblock = (FireBlock) Blocks.FIRE;
        fireblock.setFlammable(FossilsLegacyBlocks.LEPIDODENDRON_PLANKS.get(), 5, 20);
        fireblock.setFlammable(FossilsLegacyBlocks.LEPIDODENDRON_SLAB.get(), 5, 20);
        fireblock.setFlammable(FossilsLegacyBlocks.LEPIDODENDRON_FENCE_GATE.get(), 5, 20);
        fireblock.setFlammable(FossilsLegacyBlocks.LEPIDODENDRON_FENCE.get(), 5, 20);
        fireblock.setFlammable(FossilsLegacyBlocks.LEPIDODENDRON_STAIRS.get(), 5, 20);
        fireblock.setFlammable(FossilsLegacyBlocks.LEPIDODENDRON_LOG.get(), 5, 5);
        fireblock.setFlammable(FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_LOG.get(), 5, 5);
        fireblock.setFlammable(FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_WOOD.get(), 5, 5);
        fireblock.setFlammable(FossilsLegacyBlocks.LEPIDODENDRON_WOOD.get(), 5, 5);
        fireblock.setFlammable(FossilsLegacyBlocks.LEPIDODENDRON_LEAVES.get(), 30, 60);
    }

    public static void resourcePackEvent(ResourcePackRegister resourcePackRegister) {
        resourcePackRegister.register(FossilsLegacyUtils.ID, "fa_legacy_textures");
    }

    public static void newRegistryEvent(NewRegistryRegister newRegistryRegister) {
        newRegistryRegister.register(FossilsLegacyBuiltInRegistries.EGG_VARIANTS);
        newRegistryRegister.register(FossilsLegacyBuiltInRegistries.PREGNANCY_TYPES);
        newRegistryRegister.register(FossilsLegacyBuiltInRegistries.FOSSIL_VARIANTS);
    }

    public static void newDynamicRegistryEvent(DynamicRegistryRegister dynamicRegistryRegister) {
        dynamicRegistryRegister.register(FossilsLegacyRegistries.STONE_TABLET_VARIANTS, StoneTabletVariant.DIRECT_CODEC);
        dynamicRegistryRegister.register(FossilsLegacyRegistries.COAT_TYPES, CoatType.DIRECT_CODEC);
    }

    public static void attributeEvent(AttributeRegister attributeRegister) {
        attributeRegister.register(FossilsLegacyEntityTypes.ANU.get(), Anu.anuAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), Brachiosaurus.brachiosaurusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.CARNOTAURUS.get(), Carnotaurus.carnotaurusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.COMPSOGNATHUS.get(), Compsognathus.compsognathusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.CRYOLOPHOSAURUS.get(), Cryolophosaurus.cryolophosaurusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), Dilophosaurus.dilophosaurusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.DODO.get(), Dodo.dodoAttributes());
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
        attributeRegister.register(FossilsLegacyEntityTypes.STEGOSAURUS.get(), Stegosaurus.stegosaurusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get(), ZombifiedPiglin.createAttributes().build());
        attributeRegister.register(FossilsLegacyEntityTypes.THERIZINOSAURUS.get(), Therizinosaurus.therizinosaurusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.TRICERATOPS.get(), Triceratops.triceratopsAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.TYRANNOSAURUS.get(), Tyrannosaurus.tyrannosaurusAttributes());
        attributeRegister.register(FossilsLegacyEntityTypes.VELOCIRAPTOR.get(), Velociraptor.velociraptorAttributes());
    }

    public static void spawnPlacementEvent(SpawnPlacementRegister spawnPlacementRegister) {
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Brachiosaurus::checkAnimalSpawnRules);
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Dilophosaurus::checkAnimalSpawnRules);
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.MOSASAURUS.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mosasaurus::checkMosasaurusSpawnRules);
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.NAUTILUS.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Nautilus::checkNautilusSpawnRules);
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.FUTABASAURUS.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Futabasaurus::checkFutabasaurusSpawnRules);
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.PTERANODON.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Pteranodon::checkAnimalSpawnRules);
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.STEGOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Stegosaurus::checkAnimalSpawnRules);
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.TRICERATOPS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Triceratops::checkAnimalSpawnRules);
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.TYRANNOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Tyrannosaurus::checkAnimalSpawnRules);
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.VELOCIRAPTOR.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Velociraptor::checkAnimalSpawnRules);
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.CARNOTAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Carnotaurus::checkAnimalSpawnRules);
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.CRYOLOPHOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Cryolophosaurus::checkAnimalSpawnRules);
        spawnPlacementRegister.addSpawnPlacement(FossilsLegacyEntityTypes.THERIZINOSAURUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Therizinosaurus::checkAnimalSpawnRules);
    }
}
