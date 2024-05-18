package willatendo.fossilslegacy.server.event;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.animal.horse.Mule;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.Heightmap;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.block.SkullBlock;
import willatendo.fossilslegacy.server.dispenser.DispenseEntityItemBehavior;
import willatendo.fossilslegacy.server.entity.*;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.simplelibrary.server.event.EventsHolder;

public class BasicEvents {
    public static final EventsHolder EVENTS_HOLDER = new EventsHolder();

    public static void addToMaps() {
        ComposterBlock.COMPOSTABLES.put(FossilsLegacyBlocks.JURASSIC_FERN.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(FossilsLegacyItems.JURASSIC_FERN_SPORES.get(), 0.65F);

        FossilsLegacyItems.EGGS.forEach(eggItem -> DispenserBlock.registerBehavior(eggItem, new DispenseEntityItemBehavior(entity -> ((Egg) entity).setEggVariant(eggItem.getEggVariant()))));
        DispenserBlock.registerBehavior(FossilsLegacyItems.NAUTILUS_EGGS.get(), new DispenseEntityItemBehavior());
        DispenserBlock.registerBehavior(FossilsLegacyItems.NAUTILUS.get(), new DispenseEntityItemBehavior());
        DispenserBlock.registerBehavior(FossilsLegacyItems.FOSSIL.get(), new DispenseEntityItemBehavior());
        DispenserBlock.registerBehavior(FossilsLegacyItems.INCUBATED_CHICKEN_EGG.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level level, Position position, ItemStack itemStack) {
                return Util.make(new ThrownIncubatedEgg(level, position.x(), position.y(), position.z()), thrownIncubatedEgg -> {
                    thrownIncubatedEgg.setItem(itemStack);
                    thrownIncubatedEgg.setEggType(0);
                });
            }
        });
        DispenserBlock.registerBehavior(FossilsLegacyItems.INCUBATED_PARROT_EGG.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level level, Position position, ItemStack itemStack) {
                return Util.make(new ThrownIncubatedEgg(level, position.x(), position.y(), position.z()), thrownIncubatedEgg -> {
                    thrownIncubatedEgg.setItem(itemStack);
                    thrownIncubatedEgg.setEggType(1);
                });
            }
        });
        DispenserBlock.registerBehavior(FossilsLegacyBlocks.SKULL_BLOCK.get(), new OptionalDispenseItemBehavior() {
            @Override
            protected ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
                Level level = blockSource.level();
                BlockPos blockPos = blockSource.pos().relative(blockSource.state().getValue(DispenserBlock.FACING));
                SkullBlock skullBlock = (SkullBlock) FossilsLegacyBlocks.SKULL_BLOCK.get();
                if (level.isEmptyBlock(blockPos) && skullBlock.canSpawnAnu(level, blockPos)) {
                    if (!level.isClientSide()) {
                        level.setBlock(blockPos, skullBlock.defaultBlockState(), 3);
                        level.gameEvent((Entity) null, GameEvent.BLOCK_PLACE, blockPos);
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
                        level.gameEvent((Entity) null, GameEvent.BLOCK_PLACE, blockPos);
                    }

                    itemStack.shrink(1);
                    this.setSuccess(true);
                }

                return itemStack;
            }
        });
    }

    private static void addAttribute(EntityType<? extends LivingEntity> entityType, AttributeSupplier attributeSupplier) {
        EVENTS_HOLDER.addAttribute(entityType, attributeSupplier);
    }

    public static void attributeInit() {
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.ANU.get(), Anu.anuAttributes());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), Brachiosaurus.brachiosaurusAttributes());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), Dilophosaurus.dilophosaurusAttributes());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.EGG.get(), Egg.eggAttributes());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.FAILURESAURUS.get(), Failuresaurus.createAttributes().build());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.FOSSIL.get(), Fossil.fossilAttributes());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.MAMMOTH.get(), Mammoth.mammothAttributes());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.MOSASAURUS.get(), Mosasaurus.mosasaurusAttributes());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.NAUTILUS.get(), Nautilus.nautilusAttributes());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.FUTABASAURUS.get(), Futabasaurus.plesiosaurusAttributes());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.PREGNANT_CAT.get(), Cat.createAttributes().build());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.PREGNANT_COW.get(), Cow.createAttributes().build());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.PREGNANT_DOLPHIN.get(), Dolphin.createAttributes().build());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.PREGNANT_DONKEY.get(), Donkey.createBaseChestedHorseAttributes().build());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.PREGNANT_FOX.get(), Fox.createAttributes().build());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.PREGNANT_GOAT.get(), Goat.createAttributes().build());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.PREGNANT_HORSE.get(), Horse.createBaseHorseAttributes().build());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.PREGNANT_LLAMA.get(), Llama.createAttributes().build());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.PREGNANT_MAMMOTH.get(), Mammoth.mammothAttributes());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.PREGNANT_SMILODON.get(), Smilodon.smilodonAttributes());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.PREGNANT_MULE.get(), Mule.createBaseChestedHorseAttributes().build());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.PREGNANT_OCELOT.get(), Ocelot.createAttributes().build());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.PREGNANT_PANDA.get(), Panda.createAttributes().build());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.PREGNANT_PIG.get(), Pig.createAttributes().build());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.PREGNANT_POLAR_BEAR.get(), PolarBear.createAttributes().build());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.PREGNANT_RABBIT.get(), Rabbit.createAttributes().build());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), Sheep.createAttributes().build());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.PREGNANT_WOLF.get(), Wolf.createAttributes().build());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.PTERANODON.get(), Pteranodon.pteranodonAttributes());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.SMILODON.get(), Smilodon.smilodonAttributes());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.STEGOSAURUS.get(), Stegosaurus.stegosaurusAttributes());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get(), ZombifiedPiglin.createAttributes().build());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.TRICERATOPS.get(), Triceratops.triceratopsAttributes());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.TYRANNOSAURUS.get(), Tyrannosaurus.tyrannosaurusAttributes());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.VELOCIRAPTOR.get(), Velociraptor.velociraptorAttributes());

        BasicEvents.addAttribute(FossilsLegacyEntityTypes.CARNOTAURUS.get(), Carnotaurus.carnotaurusAttributes());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.CRYOLOPHOSAURUS.get(), Cryolophosaurus.cryolophosaurusAttributes());
        BasicEvents.addAttribute(FossilsLegacyEntityTypes.THERIZINOSAURUS.get(), Therizinosaurus.therizinosaurusAttributes());
    }

    private static <T extends Entity> void addSpawnPlacement(EntityType<T> entityType, SpawnPlacements.Type type, Heightmap.Types types, SpawnPlacements.SpawnPredicate<T> spawnPredicate) {
        EVENTS_HOLDER.addSpawnPlacement(entityType, type, types, spawnPredicate);
    }

    public static void spawnPlacementsInit() {
        BasicEvents.addSpawnPlacement(FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Brachiosaurus::checkAnimalSpawnRules);
        BasicEvents.addSpawnPlacement(FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Dilophosaurus::checkAnimalSpawnRules);
        BasicEvents.addSpawnPlacement(FossilsLegacyEntityTypes.MOSASAURUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mosasaurus::checkMosasaurusSpawnRules);
        BasicEvents.addSpawnPlacement(FossilsLegacyEntityTypes.NAUTILUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Nautilus::checkNautilusSpawnRules);
        BasicEvents.addSpawnPlacement(FossilsLegacyEntityTypes.FUTABASAURUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Futabasaurus::checkFutabasaurusSpawnRules);
        BasicEvents.addSpawnPlacement(FossilsLegacyEntityTypes.PTERANODON.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Pteranodon::checkAnimalSpawnRules);
        BasicEvents.addSpawnPlacement(FossilsLegacyEntityTypes.STEGOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Stegosaurus::checkAnimalSpawnRules);
        BasicEvents.addSpawnPlacement(FossilsLegacyEntityTypes.TRICERATOPS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Triceratops::checkAnimalSpawnRules);
        BasicEvents.addSpawnPlacement(FossilsLegacyEntityTypes.TYRANNOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Tyrannosaurus::checkAnimalSpawnRules);
        BasicEvents.addSpawnPlacement(FossilsLegacyEntityTypes.VELOCIRAPTOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Velociraptor::checkAnimalSpawnRules);
        BasicEvents.addSpawnPlacement(FossilsLegacyEntityTypes.CARNOTAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Carnotaurus::checkAnimalSpawnRules);
        BasicEvents.addSpawnPlacement(FossilsLegacyEntityTypes.CRYOLOPHOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Cryolophosaurus::checkAnimalSpawnRules);
        BasicEvents.addSpawnPlacement(FossilsLegacyEntityTypes.THERIZINOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Therizinosaurus::checkAnimalSpawnRules);
    }
}
