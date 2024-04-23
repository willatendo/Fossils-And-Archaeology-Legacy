package willatendo.fossilslegacy.server.event;

import net.minecraft.Util;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
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
import willatendo.fossilslegacy.experiments.server.entity.Carnotaurus;
import willatendo.fossilslegacy.experiments.server.entity.Cryolophosaurus;
import willatendo.fossilslegacy.experiments.server.entity.FossilsExperimentsEntityTypes;
import willatendo.fossilslegacy.experiments.server.entity.Therizinosaurus;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.dispenser.DispenseEntityItemBehavior;
import willatendo.fossilslegacy.server.entity.*;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

import java.util.ArrayList;
import java.util.List;

public class BasicEvents {
    public static final List<Attributes> ATTRIBUTES = new ArrayList<>();


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
    }

    public static void addAttribute(EntityType<? extends LivingEntity> entityType, AttributeSupplier attributeSupplier) {
        ATTRIBUTES.add(new Attributes(entityType, attributeSupplier));
    }

    public static void init() {
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

        BasicEvents.addAttribute(FossilsExperimentsEntityTypes.CARNOTAURUS.get(), Carnotaurus.carnotaurusAttributes());
        BasicEvents.addAttribute(FossilsExperimentsEntityTypes.CRYOLOPHOSAURUS.get(), Cryolophosaurus.cryolophosaurusAttributes());
        BasicEvents.addAttribute(FossilsExperimentsEntityTypes.THERIZINOSAURUS.get(), Therizinosaurus.therizinosaurusAttributes());
    }

    public static final record Attributes(EntityType<? extends LivingEntity> entityType,
                                          AttributeSupplier attributeSupplier) {
    }
}
